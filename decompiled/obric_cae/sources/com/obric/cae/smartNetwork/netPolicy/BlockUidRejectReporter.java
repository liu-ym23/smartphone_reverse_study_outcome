package com.obric.cae.smartNetwork.netPolicy;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.cae.caed.events.BlockUidRejectParcel;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.log.CaeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BlockUidRejectReporter {
    private static final int EVENT_BATCH_THRESHOLD = 50;
    private static final String EVENT_NAME = "BlockUidRejectEvent";
    private static final long MAX_CACHE_DURATION_MS = 60000;
    private static final int MSG_FLUSH = 1;
    private static final String TAG = "BlockUidRejectReporter";
    private static volatile BlockUidRejectReporter sInstance;
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final List<BlockUidRejectRecord> mPendingEvents;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.netPolicy.BlockUidRejectReporter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BlockUidRejectRecord {
        String outIface;
        String packageName;
        long timestamp;
        int uid;

        private BlockUidRejectRecord() {
        }

        public /* synthetic */ BlockUidRejectRecord(AnonymousClass1 r8) {
            this();
        }
    }

    private BlockUidRejectReporter(Context r8) {
        this.mPendingEvents = new ArrayList();
        this.mContext = r8.getApplicationContext();
        HandlerThread r10 = new HandlerThread("BlockUidRejectReporter");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(r10.getLooper(), new a(this));
    }

    public static /* synthetic */ boolean a(BlockUidRejectReporter r8, Message r10) {
        return r8.lambda$new$0(r10);
    }

    private void flush() {
        List<BlockUidRejectRecord> r8 = this.mPendingEvents;
        monitor-enter(r8);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingEvents.isEmpty() == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L16
        return;
    L8:
        ArrayList r10 = new ArrayList(this.mPendingEvents);     // Catch: Throwable -> L16
        this.mPendingEvents.clear();     // Catch: Throwable -> L16
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L16
        monitor-exit(r8);     // Catch: Throwable -> L16
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        reportOneEvent((BlockUidRejectRecord) r11.next());
        goto L12
    L14:
        CaeLog.i(TAG, "Reported " + r10.size() + " BlockUidRejectEvent events");
    }

    public static BlockUidRejectReporter getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(BlockUidRejectReporter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BlockUidRejectReporter(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(BlockUidRejectReporter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private String getPackageName(int r8, String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L15;
        return r10;
    L15:
        String[] r11 = this.mContext.getPackageManager().getPackagesForUid(r8);     // Catch: Exception -> L11
        if (r11 != null) goto L8;
        return "";
    L8:
        if (r11.length <= 0) goto L18;
        return TextUtils.join(",", r11);
    L18:
        return "";
    L11:
        e = move-exception;
        CaeLog.e(TAG, "getPackagesForUid failed: " + e.getMessage(), e);
        return "";
    }

    private /* synthetic */ boolean lambda$new$0(Message r8) {
        if (r8.what != 1) goto L6;
        flush();
        return true;
    L6:
        return false;
    }

    private void reportOneEvent(BlockUidRejectRecord r8) {
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L4
        r10.put("uid", r8.uid);     // Catch: JSONException -> L4
        r10.put("packageName", r8.packageName);     // Catch: JSONException -> L4
        r10.put("outIface", r8.outIface);     // Catch: JSONException -> L4
        r10.put("timestamp", r8.timestamp);     // Catch: JSONException -> L4
        ByteIOUtils.trackEvent(EVENT_NAME, r10);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        CaeLog.e(TAG, "Failed to report BlockUidRejectEvent: " + e.getMessage(), e);
    }

    public void onBlockUidRejectEvent(BlockUidRejectParcel r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        BlockUidRejectRecord r10 = new BlockUidRejectRecord(null);
        int r11 = r8.f4224a;
        r10.uid = r11;
        r10.packageName = getPackageName(r11, r8.f4225b);
        String r12 = r8.f4226m;
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        r10.outIface = r12;
        long r13 = r8.f4227n;
        if (r13 > 0) goto L13;
        r13 = System.currentTimeMillis();
    L13:
        r10.timestamp = r13;
        List<BlockUidRejectRecord> r14 = this.mPendingEvents;
        monitor-enter(r14);
        boolean r15 = this.mPendingEvents.isEmpty();     // Catch: Throwable -> L23
        this.mPendingEvents.add(r10);     // Catch: Throwable -> L23
        CaeLog.d(TAG, "Cached BlockUidRejectEvent, size=" + this.mPendingEvents.size() + ", uid=" + r10.uid + ", packageName=" + r10.packageName + ", outIface=" + r10.outIface);     // Catch: Throwable -> L23
        if (r15 == false) goto L19;
        this.mHandler.sendEmptyMessageDelayed(1, 60000);     // Catch: Throwable -> L23
    L19:
        if (this.mPendingEvents.size() < 50) goto L21;
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L23
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L23
    L21:
        monitor-exit(r14);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }
}
