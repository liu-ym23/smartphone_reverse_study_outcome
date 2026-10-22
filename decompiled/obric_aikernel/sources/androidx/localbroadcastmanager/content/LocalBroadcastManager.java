package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = null;
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts;
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers;

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent r10, ArrayList<ReceiverRecord> r11) {
            this.intent = r10;
            this.receivers = r11;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter r10, BroadcastReceiver r11) {
            this.filter = r10;
            this.receiver = r11;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder(128);
            r10.append("Receiver{");
            r10.append(this.receiver);
            r10.append(" filter=");
            r10.append(this.filter);
            if (this.dead == false) goto L5;
            r10.append(" DEAD");
        L5:
            r10.append("}");
            return r10.toString();
        }
    }

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context r10) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r10;
        final Looper r11 = r10.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r11);
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context r10) {
        Object r11 = mLock;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBroadcastManager(r10.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBroadcastManager r12 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return r12;
    }

    void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r10 = this.mReceivers;
        monitor-enter(r10);
        int r11 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L19
        if (r11 <= 0) goto L6;
        BroadcastRecord[] r12 = new BroadcastRecord[r11];     // Catch: Throwable -> L19
        this.mPendingBroadcasts.toArray(r12);     // Catch: Throwable -> L19
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        int r13 = 0;
    L11:
        if (r13 >= r11) goto L2;
        BroadcastRecord r14 = r12[r13];
        int r15 = r14.receivers.size();
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L18;
        ReceiverRecord r17 = r14.receivers.get(r16);
        if (r17.dead == true) goto L17;
        r17.receiver.onReceive(this.mAppContext, r14.intent);
    L17:
        r16 = r16 + 1;
        goto L13
    L18:
        r13 = r13 + 1;
        goto L11
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(@NonNull BroadcastReceiver r10, @NonNull IntentFilter r11) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r12 = this.mReceivers;
        monitor-enter(r12);
        ReceiverRecord r13 = new ReceiverRecord(r11, r10);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r14 = this.mReceivers.get(r10);     // Catch: Throwable -> L16
        if (r14 != null) goto L7;
        r14 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r10, r14);     // Catch: Throwable -> L16
    L7:
        r14.add(r13);     // Catch: Throwable -> L16
        int r15 = 0;
    L9:
        if (r15 >= r11.countActions()) goto L14;
        String r16 = r11.getAction(r15);     // Catch: Throwable -> L16
        ArrayList<ReceiverRecord> r17 = this.mActions.get(r16);     // Catch: Throwable -> L16
        if (r17 != null) goto L13;
        r17 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r16, r17);     // Catch: Throwable -> L16
    L13:
        r17.add(r13);     // Catch: Throwable -> L16
        r15 = r15 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r12);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public boolean sendBroadcast(@NonNull Intent r22) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r10 = this.mReceivers;
        monitor-enter(r10);
        String r11 = r22.getAction();     // Catch: Throwable -> L64
        String r12 = r22.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L64
        Uri r13 = r22.getData();     // Catch: Throwable -> L64
        String r14 = r22.getScheme();     // Catch: Throwable -> L64
        Set<String> r15 = r22.getCategories();     // Catch: Throwable -> L64
        if ((r22.getFlags() & 8) == 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == false) goto L10;
        Log.v(TAG, "Resolving type " + r12 + " scheme " + r14 + " of intent " + r22);     // Catch: Throwable -> L64
    L10:
        ArrayList<ReceiverRecord> r17 = this.mActions.get(r22.getAction());     // Catch: Throwable -> L64
        if (r17 == null) goto L61;
        if (r16 == false) goto L14;
        Log.v(TAG, "Action list: " + r17);     // Catch: Throwable -> L64
    L14:
        ArrayList r18 = null;
        int r19 = 0;
    L16:
        if (r19 >= r17.size()) goto L50;
        ReceiverRecord r20 = r17.get(r19);     // Catch: Throwable -> L64
        if (r16 == false) goto L21;
        Log.v(TAG, "Matching against filter " + r20.filter);     // Catch: Throwable -> L64
    L21:
        if (r20.broadcasting == false) goto L25;
        if (r16 == false) goto L24;
        Log.v(TAG, "  Filter's target already added");     // Catch: Throwable -> L64
    L24:
        int r110 = r19;
        ArrayList<ReceiverRecord> r111 = r17;
        String r112 = r11;
        String r21 = r12;
        ArrayList r113 = r18;
    L48:
        r18 = r113;
    L49:
        r19 = r110 + 1;     // Catch: Throwable -> L64
        r11 = r112;
        r17 = r111;
        r12 = r21;
        goto L16
    L25:
        r110 = r19;
        r112 = r11;
        r113 = r18;
        r111 = r17;
        r21 = r12;
        int r23 = r20.filter.match(r11, r12, r14, r13, r15, TAG);     // Catch: Throwable -> L64
        if (r23 < 0) goto L33;
        if (r16 == false) goto L29;
        Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(r23));     // Catch: Throwable -> L64
    L29:
        if (r113 != null) goto L31;
        r18 = new ArrayList();     // Catch: Throwable -> L64
    L32:
        r18.add(r20);     // Catch: Throwable -> L64
        r20.broadcasting = true;     // Catch: Throwable -> L64
        goto L49
    L31:
        r18 = r113;
        goto L32
    L33:
        if (r16 == false) goto L48;
        if (r23 != (-4)) goto L37;
        String r24 = EventBody.KEY_CATEGORY;
    L47:
        Log.v(TAG, "  Filter did not match: " + r24);     // Catch: Throwable -> L64
        goto L48
    L37:
        if (r23 != (-3)) goto L39;
        r24 = "action";
        goto L47
    L39:
        if (r23 != (-2)) goto L41;
        r24 = "data";
        goto L47
    L41:
        if (r23 == (-1)) goto L43;
        r24 = "unknown reason";
        goto L47
    L43:
        r24 = WsConstants.KEY_CONNECTION_TYPE;
        goto L47
    L50:
        ArrayList r114 = r18;
        if (r114 == null) goto L61;
        int r25 = 0;
    L54:
        if (r25 >= r114.size()) goto L56;
        ((ReceiverRecord) r114.get(r25)).broadcasting = false;     // Catch: Throwable -> L64
        r25 = r25 + 1;     // Catch: Throwable -> L64
        goto L54
    L56:
        this.mPendingBroadcasts.add(new BroadcastRecord(r22, r114));     // Catch: Throwable -> L64
        if (this.mHandler.hasMessages(1) == true) goto L59;
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L64
    L59:
        monitor-exit(r10);     // Catch: Throwable -> L64
        return true;
    L61:
        monitor-exit(r10);     // Catch: Throwable -> L64
        return false;
    L7:
        r16 = false;
    L64:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(@NonNull Intent r10) {
        if (sendBroadcast(r10) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver r12) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r10 = this.mReceivers;
        monitor-enter(r10);
        ArrayList<ReceiverRecord> r11 = this.mReceivers.remove(r12);     // Catch: Throwable -> L28
        if (r11 != null) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L28
        return;
    L8:
        int r13 = r11.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r13 < 0) goto L26;
        ReceiverRecord r14 = r11.get(r13);     // Catch: Throwable -> L28
        r14.dead = true;     // Catch: Throwable -> L28
        int r15 = 0;
    L12:
        if (r15 >= r14.filter.countActions()) goto L25;
        String r16 = r14.filter.getAction(r15);     // Catch: Throwable -> L28
        ArrayList<ReceiverRecord> r17 = this.mActions.get(r16);     // Catch: Throwable -> L28
        if (r17 == null) goto L24;
        int r18 = r17.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r18 < 0) goto L22;
        ReceiverRecord r19 = r17.get(r18);     // Catch: Throwable -> L28
        if (r19.receiver != r12) goto L20;
        r19.dead = true;     // Catch: Throwable -> L28
        r17.remove(r18);     // Catch: Throwable -> L28
    L20:
        r18 = r18 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r17.size() > 0) goto L24;
        this.mActions.remove(r16);     // Catch: Throwable -> L28
    L24:
        r15 = r15 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r13 = r13 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r10);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }
}
