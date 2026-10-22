package com.obric.cae.smartNfc.cloud;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNfc.CaeNfcEventManagerService;
import com.obric.cae.utils.CaeUtil;
import defpackage.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NfcCloudSyncer {
    private static final int MSG_DOWNLOAD_CONFIG = 1;
    private static final String TAG = "NfcCloudSyncer";
    private Context mContext;
    private final CaeNfcEventManagerService mEventManagerService;
    private HandlerThread mSolutionThread;
    private SolutionUpdateHandler mUpdateHandler;

    public class SolutionUpdateHandler extends Handler {
        final /* synthetic */ NfcCloudSyncer this$0;

        public SolutionUpdateHandler(NfcCloudSyncer r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            String r10 = NfcCloudSyncer.access$000();
            defpackage.a.j(new StringBuilder("handleMessage: "), r8.what, r10);
            if (r8.what != 1) goto L7;
            NfcCloudSyncer.access$100(this.this$0, (String) r8.obj);
            return;
        }
    }

    public NfcCloudSyncer(Context r8, CaeNfcEventManagerService r10) {
        this.mContext = r8;
        this.mEventManagerService = r10;
        HandlerThread r11 = new HandlerThread("solution update thread");
        this.mSolutionThread = r11;
        r11.start();
        this.mUpdateHandler = new SolutionUpdateHandler(this, this.mSolutionThread.getLooper());
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void access$100(NfcCloudSyncer r8, String r10) {
        r8.parseCloudData(r10);
    }

    private Bundle buildCloudConfigBundle(JSONObject r8) {
        Bundle r10 = new Bundle();
        Iterator<String> r11 = r8.keys();
    L4:
        if (r11.hasNext() == false) goto L29;
        String r12 = r11.next();
        if (CloudServiceConstants.OSettings.TAG_CLOUD_CONFIG.equals(r12) == true) goto L4;
        Object r13 = r8.opt(r12);
        if (r13 == null) goto L4;
        if (r13 == JSONObject.NULL) goto L4;
        if ((r13 instanceof Integer) == true) goto L15;
        if ((r13 instanceof Long) == true) goto L18;
        if ((r13 instanceof Double) == true) goto L21;
        if ((r13 instanceof Boolean) == true) goto L24;
        if ((r13 instanceof String) == true) goto L27;
        b.o("skip unsupported cloud config type for key: ", r12, TAG);
        goto L4
    L27:
        r10.putString(r12, (String) r13);
        goto L4
    L24:
        r10.putBoolean(r12, ((Boolean) r13).booleanValue());
        goto L4
    L21:
        r10.putDouble(r12, ((Double) r13).doubleValue());
        goto L4
    L18:
        r10.putLong(r12, ((Long) r13).longValue());
        goto L4
    L15:
        r10.putInt(r12, ((Integer) r13).intValue());
        goto L4
    L29:
        return r10;
    }

    private void notifyCloudConfigUpdate(Bundle r8) {
        CaeNfcEventManagerService r10 = this.mEventManagerService;
        if (r10 == null) goto L6;
        r10.notifyCloudConfigUpdate(r8);
        return;
    }

    private void parseCloudData(String r8) {
        String r10 = TAG;
        b.o("parseCloudData: ", r8, r10);
        JSONObject r11 = new JSONObject(r8);     // Catch: JSONException -> L15
        if (r11.has(CloudServiceConstants.OSettings.TAG_CLOUD_CONFIG) == true) goto L7;
        return;
    L7:
        if (r11.getInt(CloudServiceConstants.OSettings.TAG_CLOUD_CONFIG) == 1) goto L9;
        return;
    L9:
        Bundle r12 = buildCloudConfigBundle(r11);     // Catch: JSONException -> L15
        if (r12.isEmpty() == false) goto L13;
        CaeLog.d(r10, "cloud config is empty after parsing");     // Catch: JSONException -> L15
        return;
    L13:
        notifyCloudConfigUpdate(r12);     // Catch: JSONException -> L15
        return;
    L15:
        e = move-exception;
        CaeLog.e(TAG, "" + e);
    }

    public void cleanup() {
        CaeLog.d(TAG, "cleanup");
        HandlerThread r8 = this.mSolutionThread;
        if (r8 == null) goto L6;
        r8.quitSafely();
        return;
    }

    public void onCloudDataChange(String r8) {
        CaeUtil.sendMessageWithParam(this.mUpdateHandler, 1, r8);
    }

    public void onPostStateChange(int r8, String r10, String r11) {
    }
}
