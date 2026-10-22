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
import androidx.constraintlayout.motion.widget.a;
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

    public static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent r5, ArrayList<ReceiverRecord> r10) {
            this.intent = r5;
            this.receivers = r10;
        }
    }

    public static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter r5, BroadcastReceiver r10) {
            this.filter = r5;
            this.receiver = r10;
        }

        public String toString() {
            StringBuilder r5 = a.x(128, "Receiver{");
            r5.append(this.receiver);
            r5.append(" filter=");
            r5.append(this.filter);
            if (this.dead == false) goto L5;
            r5.append(" DEAD");
        L5:
            r5.append("}");
            return r5.toString();
        }
    }

    static {
        mLock = new Object();
    }

    private LocalBroadcastManager(Context r5) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r5;
        final Looper r10 = r5.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r10);
    }

    @NonNull
    public static LocalBroadcastManager getInstance(@NonNull Context r5) {
        Object r10 = mLock;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L9;
        mInstance = new LocalBroadcastManager(r5.getApplicationContext());     // Catch: Throwable -> L7
    L9:
        LocalBroadcastManager r11 = mInstance;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    }

    public void executePendingBroadcasts() {
    L2:
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r5 = this.mReceivers;
        monitor-enter(r5);
        int r10 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L8
        if (r10 <= 0) goto L6;
        BroadcastRecord[] r11 = new BroadcastRecord[r10];     // Catch: Throwable -> L8
        this.mPendingBroadcasts.toArray(r11);     // Catch: Throwable -> L8
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        int r12 = 0;
    L13:
        if (r12 >= r10) goto L2;
        BroadcastRecord r13 = r11[r12];
        int r14 = r13.receivers.size();
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L20;
        ReceiverRecord r16 = r13.receivers.get(r15);
        if (r16.dead == true) goto L19;
        r16.receiver.onReceive(this.mAppContext, r13.intent);
    L19:
        r15 = r15 + 1;
        goto L15
    L20:
        r12 = r12 + 1;
        goto L13
    L6:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(@NonNull BroadcastReceiver r10, @NonNull IntentFilter r11) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r5 = this.mReceivers;
        monitor-enter(r5);
        ReceiverRecord r12 = new ReceiverRecord(r11, r10);     // Catch: Throwable -> L7
        ArrayList<ReceiverRecord> r13 = this.mReceivers.get(r10);     // Catch: Throwable -> L7
        if (r13 != null) goto L9;
        r13 = new ArrayList(1);     // Catch: Throwable -> L7
        this.mReceivers.put(r10, r13);     // Catch: Throwable -> L7
    L9:
        r13.add(r12);     // Catch: Throwable -> L7
        int r14 = 0;
    L11:
        if (r14 >= r11.countActions()) goto L16;
        String r15 = r11.getAction(r14);     // Catch: Throwable -> L7
        ArrayList<ReceiverRecord> r16 = this.mActions.get(r15);     // Catch: Throwable -> L7
        if (r16 != null) goto L15;
        r16 = new ArrayList(1);     // Catch: Throwable -> L7
        this.mActions.put(r15, r16);     // Catch: Throwable -> L7
    L15:
        r16.add(r12);     // Catch: Throwable -> L7
        r14 = r14 + 1;     // Catch: Throwable -> L7
        goto L11
    L16:
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean sendBroadcast(@NonNull Intent r23) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r5 = this.mReceivers;
        monitor-enter(r5);
        String r12 = r23.getAction();     // Catch: Throwable -> L10
        String r13 = r23.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L10
        Uri r14 = r23.getData();     // Catch: Throwable -> L10
        String r15 = r23.getScheme();     // Catch: Throwable -> L10
        Set<String> r16 = r23.getCategories();     // Catch: Throwable -> L10
        boolean r10 = true;
        if ((r23.getFlags() & 8) == 0) goto L7;
        Object[] r17 = true;
    L8:
        if (r17 == false) goto L12;
        Log.v(TAG, "Resolving type " + r13 + " scheme " + r15 + " of intent " + r23);     // Catch: Throwable -> L10
    L12:
        ArrayList<ReceiverRecord> r11 = this.mActions.get(r23.getAction());     // Catch: Throwable -> L10
        if (r11 == null) goto L62;
        if (r17 == false) goto L16;
        Log.v(TAG, "Action list: " + r11);     // Catch: Throwable -> L10
    L16:
        ArrayList r18 = null;
        int r19 = 0;
    L18:
        if (r19 >= r11.size()) goto L50;
        ReceiverRecord r20 = r11.get(r19);     // Catch: Throwable -> L10
        if (r17 == false) goto L23;
        Log.v(TAG, "Matching against filter " + r20.filter);     // Catch: Throwable -> L10
    L23:
        if (r20.broadcasting == false) goto L27;
        if (r17 == false) goto L26;
        Log.v(TAG, "  Filter's target already added");     // Catch: Throwable -> L10
    L26:
        ArrayList<ReceiverRecord> r110 = r11;
        int r21 = r19;
        String r22 = r12;
        boolean r111 = r10;
    L49:
        r19 = r21 + 1;     // Catch: Throwable -> L10
        r10 = r111;
        r11 = r110;
        r12 = r22;
        goto L18
    L27:
        String r24 = r12;
        r110 = r11;
        r21 = r19;
        r22 = r12;
        r111 = r10;
        int r25 = r20.filter.match(r24, r13, r15, r14, r16, TAG);     // Catch: Throwable -> L10
        if (r25 < 0) goto L34;
        if (r17 == false) goto L31;
        Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(r25));     // Catch: Throwable -> L10
    L31:
        if (r18 != null) goto L33;
        r18 = new ArrayList();     // Catch: Throwable -> L10
    L33:
        r18.add(r20);     // Catch: Throwable -> L10
        r20.broadcasting = r111;     // Catch: Throwable -> L10
        goto L49
    L34:
        if (r17 == false) goto L49;
        if (r25 != (-4)) goto L38;
        String r26 = "category";
    L48:
        Log.v(TAG, "  Filter did not match: " + r26);     // Catch: Throwable -> L10
        goto L49
    L38:
        if (r25 != (-3)) goto L40;
        r26 = "action";
        goto L48
    L40:
        if (r25 != (-2)) goto L42;
        r26 = "data";
        goto L48
    L42:
        if (r25 == (-1)) goto L44;
        r26 = "unknown reason";
        goto L48
    L44:
        r26 = "type";
        goto L48
    L50:
        boolean r112 = r10;
        if (r18 == null) goto L61;
        int r113 = 0;
    L54:
        if (r113 >= r18.size()) goto L56;
        ((ReceiverRecord) r18.get(r113)).broadcasting = false;     // Catch: Throwable -> L10
        r113 = r113 + 1;     // Catch: Throwable -> L10
        goto L54
    L56:
        this.mPendingBroadcasts.add(new BroadcastRecord(r23, r18));     // Catch: Throwable -> L10
        if (this.mHandler.hasMessages(r112 ? 1 : 0) == true) goto L59;
        this.mHandler.sendEmptyMessage(r112 ? 1 : 0);     // Catch: Throwable -> L10
    L59:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r112;
    L61:
        boolean r27 = false;
    L63:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r27;
    L62:
        r27 = false;
        goto L63
    L7:
        r17 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(@NonNull Intent r5) {
        if (sendBroadcast(r5) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(@NonNull BroadcastReceiver r12) {
        HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> r5 = this.mReceivers;
        monitor-enter(r5);
        ArrayList<ReceiverRecord> r10 = this.mReceivers.remove(r12);     // Catch: Throwable -> L8
        if (r10 != null) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        int r11 = r10.size() - 1;     // Catch: Throwable -> L8
    L11:
        if (r11 < 0) goto L28;
        ReceiverRecord r13 = r10.get(r11);     // Catch: Throwable -> L8
        r13.dead = true;     // Catch: Throwable -> L8
        int r14 = 0;
    L14:
        if (r14 >= r13.filter.countActions()) goto L27;
        String r15 = r13.filter.getAction(r14);     // Catch: Throwable -> L8
        ArrayList<ReceiverRecord> r16 = this.mActions.get(r15);     // Catch: Throwable -> L8
        if (r16 == null) goto L26;
        int r17 = r16.size() - 1;     // Catch: Throwable -> L8
    L18:
        if (r17 < 0) goto L24;
        ReceiverRecord r18 = r16.get(r17);     // Catch: Throwable -> L8
        if (r18.receiver != r12) goto L22;
        r18.dead = true;     // Catch: Throwable -> L8
        r16.remove(r17);     // Catch: Throwable -> L8
    L22:
        r17 = r17 - 1;     // Catch: Throwable -> L8
        goto L18
    L24:
        if (r16.size() > 0) goto L26;
        this.mActions.remove(r15);     // Catch: Throwable -> L8
    L26:
        r14 = r14 + 1;     // Catch: Throwable -> L8
        goto L14
    L27:
        r11 = r11 - 1;     // Catch: Throwable -> L8
        goto L11
    L28:
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
