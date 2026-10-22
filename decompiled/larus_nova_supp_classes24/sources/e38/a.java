package e38;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.bytedance.lark.sdk.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.g;
import com.ss.android.lark.sdk.i;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements se6.c {
    public static final Map<Command, g.b> a = null;
    public static final Map<com.ss.android.lark.pb.improto.Command, g.b> b = null;

    public a() {
    }

    static {
        a r0 = new a();
        ((CopyOnWriteArrayList) d.f).add(r0);
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public final void a(Packet r11, long r12, long r14) {
        if (r11 != null) goto L5;
        return;
    L5:
        Command r1 = r11.cmd;
        Log.i("PushDispatcher", "thread = " + ThreadMethodProxy.currentThread().getName() + " command = " + r1 + " uid=" + r11.user_id);
        ByteString r2 = r11.payload;
        if (r2 != null) goto L8;
        r2 = ByteString.EMPTY;
    L8:
        com.ss.android.lark.sdk.d r4 = i.b;
        if (r4 == null) goto L11;
        boolean r5 = r4.e();
    L12:
        if (r5 == true) goto L14;
    L16:
        g.b r6 = null;
        if (Intrinsics.areEqual(r1, Command.PASS_THROUGH_PUSH) == true) goto L45;
        if (r1 == null) goto L34;
        r6 = (g.b) ((ConcurrentHashMap) a).get(r1);
    L34:
        if (r6 != null) goto L36;
        Log.w("PushDispatcher", "unprocessed push：" + r1);
    L40:
        long r7 = System.currentTimeMillis();
        if ((r7 - r12) <= 10000) goto L47;
        String r13 = "push time out command = " + r1 + ", decode time = " + (r14 - r12) + ", handle push time = " + (r7 - r14);
        Log.e("PushDispatcher", r13, new RuntimeException(r13), true);
        return;
    L47:
        return;
    L36:
        if ((r6 instanceof g.a) == false) goto L38;
        ((g.a) r6).f(r2.toByteArray(), r11);
        goto L40
    L38:
        r6.a(r2.toByteArray());
        goto L40
    L45:
        com.ss.android.lark.pb.improto.Packet r8 = (com.ss.android.lark.pb.improto.Packet) com.ss.android.lark.pb.improto.Packet.ADAPTER.decode(r2);     // Catch: IllegalStateException -> L25 IOException -> L32
        r2 = r8.mpayload;     // Catch: IllegalStateException -> L25 IOException -> L32
        com.ss.android.lark.pb.improto.Command r9 = com.ss.android.lark.pb.improto.Command.fromValue(r8.mcommand.intValue());     // Catch: IllegalStateException -> L25 IOException -> L32
        if (r9 == null) goto L23;
        r6 = (g.b) ((ConcurrentHashMap) b).get(r9);     // Catch: IllegalStateException -> L25 IOException -> L32
    L44:
    L23:
        Log.e("PushDispatcher", "onPush  passThroughCommand is null, " + r1);     // Catch: IllegalStateException -> L25 IOException -> L32
    L32:
        e = move-exception;
        Log.e("PushDispatcher", e.getMessage());
    L25:
        e = move-exception;
        String r10 = e.getMessage();
        Log.e("PushDispatcher", e.getMessage());
        if (r10 != null) goto L29;
    L31:
        throw e;
    L29:
        if (StringsKt.contains$default(r10, "mcmd", false, 2, r6) == false) goto L31;
        Log.w("PushDispatcher", "catch exception for unsupported command");
        goto L34
    L14:
        if (d.t(r11) == true) goto L16;
        return;
    L11:
        r5 = false;
        goto L12
    }
}
