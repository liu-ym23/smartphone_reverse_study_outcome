package ms.bd.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class w2 extends BroadcastReceiver {
    public static final String a = null;
    public static final String b = null;
    public static w2 c;
    public static boolean d;

    static {
        String r0 = (String) p2.a(16777217, 0, 0, "bb3b3c", new byte[]{125, 111, 84, 31, 10, 125, 98, 66, 118, 59, 124, 110});
        a = (String) p2.a(16777217, 0, 0, "35c40d", new byte[]{33, 56, 29, 14, 13, 106, 36, 17, 54, 101, 44, 52, 21, 14, 2, 118, 36, 21, 33, 97, 33, 121, 30, 79, 27, 122, 54, 29, 49, 101, 54, 62, 31, 78, 65, ByteCompanionObject.MAX_VALUE, 57, 2, 55, 42, 45, 57});
        b = (String) p2.a(16777217, 0, 0, "c0d883", new byte[]{113, 61, 26, 2, 5, 61, 116, 20, 49, 105, 124, 49, 18, 2, 10, 33, 116, 16, 38, 109, 113, 124, 25, 67, 19, 45, 102, 24, 54, 105, 102, 59, 24, 66, 73, 40, 105, 7, 48, 38, 125, 52, 17});
        d = false;
    }

    public w2() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r12, Intent r13) {
        String r0 = r13.getAction();
        String r1 = (String) p2.a(16777217, 0, 0, "e8b305", new byte[]{90, 53, 5, 78, 9, 43, 101, 24, 39, 106, 123, 52, 81, 85, 10, 33, 99, 16, 37, 102, 112, 96, 81, 70, 12, 54, 111, 22, 61, 35, 41, 122, 84, 84, 65});
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = r0.hashCode();
        if (r2 == (-1125048048)) goto L14;
        if (r2 == (-516751266)) goto L11;
    L16:
        byte r3 = -1;
    L18:
        if (r3 == 0) goto L31;
        if (r3 == 1) goto L22;
        String r14 = (String) p2.a(16777217, 0, 0, "a1ca11", new byte[]{69, 61, 27, 27, 1, 49, 108, 80, 60, 62, 100, 58, 22, 28, 13, 39, 118, 25, 61, 63, 48, 33, 21, 22, 11, 47, 116, 21, 54, ByteCompanionObject.MAX_VALUE});
        return;
    L22:
        if (s1.a != null) goto L24;
        return;
    L24:
        if (s1.b == false) goto L50;
        p1 r15 = s1.a;
        if (r15.d == true) goto L28;
    L30:
        s1.b = false;
        return;
    L28:
        if (r15.a.a == false) goto L30;
        Message r16 = new Message();
        r16.what = 4;
        r15.e.sendMessage(r16);
        ThreadMethodProxy.start(new PthreadThreadV2(new o1(r15), "ms/bd/c/w2"));
        goto L30
    L50:
        return;
    L31:
        Context r17 = r12.getApplicationContext();
        monitor-enter(s1.class);
        s1.a(r17, r13);     // Catch: Throwable -> L43
        if (s1.b == true) goto L41;
        p1 r18 = s1.a;     // Catch: Throwable -> L43
        if (r18.d == true) goto L38;
    L40:
        s1.b = true;     // Catch: Throwable -> L43
        goto L41
    L38:
        if (r18.a.a == false) goto L40;
        r18.f = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L43
        PthreadHandlerThreadV2 r19 = new PthreadHandlerThreadV2((String) p2.a(16777217, 0, 0, "4ff7b4", new byte[]{41, 109, 3, 70, 98, 55, 50, 84}));     // Catch: Throwable -> L43
        r18.g = r19;     // Catch: Throwable -> L43
        ThreadMethodProxy.start(r19);     // Catch: Throwable -> L43
        r18.e = new n1(r18, r18.g.getLooper());     // Catch: Throwable -> L43
        Message r110 = new Message();     // Catch: Throwable -> L43
        r110.what = 1;     // Catch: Throwable -> L43
        r18.e.sendMessage(r110);     // Catch: Throwable -> L43
        Message r111 = new Message();     // Catch: Throwable -> L43
        r111.what = 3;     // Catch: Throwable -> L43
        r18.e.sendMessageDelayed(r111, r18.b.c);     // Catch: Throwable -> L43
    L41:
        monitor-exit(s1.class);
        return;
    L43:
        th = move-exception;
        throw th;
    L11:
        if (r0.equals(b) == false) goto L16;
        r3 = 1;
        goto L18
    L14:
        if (r0.equals(a) == false) goto L16;
        r3 = 0;
        goto L18
    }
}
