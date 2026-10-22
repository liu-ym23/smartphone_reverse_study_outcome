package com.volcengine.zeus;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = null;
    private final HashMap<String, ArrayList<c>> mActions;
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<b> mPendingBroadcasts;
    private final HashMap<PluginBroadcastReceiver, ArrayList<c>> mReceivers;

    public class a extends Handler {
        public final /* synthetic */ LocalBroadcastManager a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            if (r3.what == 1) goto L5;
            super.handleMessage(r3);
            return;
        L5:
            this.a.executePendingBroadcasts();
        }

        public a(LocalBroadcastManager r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static final class c {
        public final IntentFilter a;
        public final PluginBroadcastReceiver b;
        public boolean c;
        public boolean d;

        public final String toString() {
            StringBuilder r0 = new StringBuilder(128);
            r0.append("Receiver{");
            r0.append(this.b);
            r0.append(" filter=");
            r0.append(this.a);
            if (this.d == false) goto L5;
            r0.append(" DEAD");
        L5:
            r0.append("}");
            return r0.toString();
        }

        public c(IntentFilter r1, PluginBroadcastReceiver r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        mLock = new Object();
    }

    public void executePendingBroadcasts() {
    L2:
        HashMap<PluginBroadcastReceiver, ArrayList<c>> r0 = this.mReceivers;
        monitor-enter(r0);
        int r1 = this.mPendingBroadcasts.size();     // Catch: Throwable -> L19
        if (r1 <= 0) goto L6;
        b[] r2 = new b[r1];     // Catch: Throwable -> L19
        this.mPendingBroadcasts.toArray(r2);     // Catch: Throwable -> L19
        this.mPendingBroadcasts.clear();     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        int r3 = 0;
    L11:
        if (r3 >= r1) goto L2;
        b r4 = r2[r3];
        int r5 = r4.b.size();
        int r6 = 0;
    L13:
        if (r6 >= r5) goto L18;
        c r7 = (c) ListProtector.get(r4.b, r6);
        if (r7.d == true) goto L17;
        r7.b.onReceive(this.mAppContext, r4.a);
    L17:
        r6 = r6 + 1;
        goto L13
    L18:
        r3 = r3 + 1;
        goto L11
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private LocalBroadcastManager(Context r2) {
        this.mReceivers = new HashMap();
        this.mActions = new HashMap();
        this.mPendingBroadcasts = new ArrayList();
        this.mAppContext = r2;
        this.mHandler = new a(this, r2.getMainLooper());
    }

    public static LocalBroadcastManager getInstance(Context r2) {
        Object r0 = mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new LocalBroadcastManager(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        LocalBroadcastManager r3 = mInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    }

    public boolean sendBroadcast(Intent r23) {
        HashMap<PluginBroadcastReceiver, ArrayList<c>> r2 = this.mReceivers;
        monitor-enter(r2);
        String r10 = r23.getAction();     // Catch: Throwable -> L49
        String r11 = r23.resolveTypeIfNeeded(this.mAppContext.getContentResolver());     // Catch: Throwable -> L49
        Uri r12 = r23.getData();     // Catch: Throwable -> L49
        String r13 = r23.getScheme();     // Catch: Throwable -> L49
        Set<String> r14 = r23.getCategories();     // Catch: Throwable -> L49
        if ((r23.getFlags() & 8) == 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == false) goto L10;
        r23.toString();     // Catch: Throwable -> L49
    L10:
        ArrayList<c> r8 = this.mActions.get(r23.getAction());     // Catch: Throwable -> L49
        if (r8 == null) goto L46;
        if (r16 == false) goto L14;
        r8.toString();     // Catch: Throwable -> L49
    L14:
        ArrayList r7 = null;
        int r6 = 0;
    L16:
        if (r6 >= r8.size()) goto L35;
        c r5 = r8.get(r6);     // Catch: Throwable -> L49
        if (r16 == false) goto L21;
        Objects.toString(r5.a);     // Catch: Throwable -> L49
    L21:
        if (r5.c == false) goto L23;
        int r18 = r6;
        ArrayList<c> r20 = r8;
        String r19 = r10;
        String r21 = r11;
        ArrayList r15 = r7;
    L33:
        r7 = r15;
    L34:
        r6 = r18 + 1;     // Catch: Throwable -> L49
        r10 = r19;
        r8 = r20;
        r11 = r21;
        goto L16
    L23:
        r18 = r6;
        r19 = r10;
        r15 = r7;
        r20 = r8;
        r21 = r11;
        int r3 = r5.a.match(r10, r11, r13, r12, r14, TAG);     // Catch: Throwable -> L49
        if (r3 < 0) goto L31;
        if (r16 == false) goto L27;
        Integer.toHexString(r3);     // Catch: Throwable -> L49
    L27:
        if (r15 != null) goto L29;
        r7 = new ArrayList();     // Catch: Throwable -> L49
    L30:
        r7.add(r5);     // Catch: Throwable -> L49
        r5.c = true;     // Catch: Throwable -> L49
        goto L34
    L29:
        r7 = r15;
        goto L30
    L31:
        if (r16 == false) goto L33;
        goto L33
    L35:
        ArrayList r17 = r7;
        if (r17 == null) goto L46;
        int r4 = 0;
    L39:
        if (r4 >= r17.size()) goto L41;
        ((c) r17.get(r4)).c = false;     // Catch: Throwable -> L49
        r4 = r4 + 1;     // Catch: Throwable -> L49
        goto L39
    L41:
        this.mPendingBroadcasts.add(new b(r23, r17));     // Catch: Throwable -> L49
        if (this.mHandler.hasMessages(1) == true) goto L44;
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L49
    L44:
        monitor-exit(r2);     // Catch: Throwable -> L49
        return true;
    L46:
        monitor-exit(r2);     // Catch: Throwable -> L49
        return false;
    L7:
        r16 = false;
    L49:
        th = move-exception;
        throw th;
    }

    public void sendBroadcastSync(Intent r1) {
        if (sendBroadcast(r1) == false) goto L6;
        executePendingBroadcasts();
        return;
    }

    public void unregisterReceiver(PluginBroadcastReceiver r12) {
        HashMap<PluginBroadcastReceiver, ArrayList<c>> r0 = this.mReceivers;
        monitor-enter(r0);
        ArrayList<c> r1 = this.mReceivers.remove(r12);     // Catch: Throwable -> L28
        if (r1 != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L8:
        int r2 = r1.size() - 1;     // Catch: Throwable -> L28
    L9:
        if (r2 < 0) goto L26;
        c r4 = r1.get(r2);     // Catch: Throwable -> L28
        r4.d = true;     // Catch: Throwable -> L28
        int r5 = 0;
    L12:
        if (r5 >= r4.a.countActions()) goto L25;
        String r6 = r4.a.getAction(r5);     // Catch: Throwable -> L28
        ArrayList<c> r7 = this.mActions.get(r6);     // Catch: Throwable -> L28
        if (r7 == null) goto L24;
        int r8 = r7.size() - 1;     // Catch: Throwable -> L28
    L16:
        if (r8 < 0) goto L22;
        c r9 = r7.get(r8);     // Catch: Throwable -> L28
        if (r9.b != r12) goto L20;
        r9.d = true;     // Catch: Throwable -> L28
        r7.remove(r8);     // Catch: Throwable -> L28
    L20:
        r8 = r8 - 1;     // Catch: Throwable -> L28
        goto L16
    L22:
        if (r7.size() > 0) goto L24;
        this.mActions.remove(r6);     // Catch: Throwable -> L28
    L24:
        r5 = r5 + 1;     // Catch: Throwable -> L28
        goto L12
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L28
        goto L9
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public void registerReceiver(PluginBroadcastReceiver r7, IntentFilter r8) {
        HashMap<PluginBroadcastReceiver, ArrayList<c>> r0 = this.mReceivers;
        monitor-enter(r0);
        c r1 = new c(r8, r7);     // Catch: Throwable -> L16
        ArrayList<c> r2 = this.mReceivers.get(r7);     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r2 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mReceivers.put(r7, r2);     // Catch: Throwable -> L16
    L7:
        r2.add(r1);     // Catch: Throwable -> L16
        int r9 = 0;
    L9:
        if (r9 >= r8.countActions()) goto L14;
        String r3 = r8.getAction(r9);     // Catch: Throwable -> L16
        ArrayList<c> r4 = this.mActions.get(r3);     // Catch: Throwable -> L16
        if (r4 != null) goto L13;
        r4 = new ArrayList(1);     // Catch: Throwable -> L16
        this.mActions.put(r3, r4);     // Catch: Throwable -> L16
    L13:
        r4.add(r1);     // Catch: Throwable -> L16
        r9 = r9 + 1;     // Catch: Throwable -> L16
        goto L9
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
