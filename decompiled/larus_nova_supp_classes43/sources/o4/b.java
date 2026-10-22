package o4;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.settings.d;
import d3.a0;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t5.k;
import t5.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements i3.b {
    public final a a;

    @Override // i3.b
    public final int getPriority() {
        return 50;
    }

    @Override // i3.b
    public final void reset() {
        a r0 = this.a;
        Object r1 = r0.b;
        monitor-enter(r1);
        r0.a = null;     // Catch: Throwable -> L9
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r1);
        r0.c.clear();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public b() {
        this.a = new a();
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "invocation");
        a0 r0 = r10.c.getContainerContext();
        if (r0 == null) goto L5;
        r0.getAppletId();
    L5:
        a r1 = this.a;
        String r11 = r10.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "methodName");
        d.a.getClass();
        o r12 = d.a().aiBridgeConfig().e();
        if (r12 != null) goto L9;
        r12 = new o(null);
    L9:
        if (r12.a() == true) goto L12;
        return null;
    L12:
        if (r12.b().contains(r11) == true) goto L63;
        j3.a r13 = r1.a;
        if (r13 != null) goto L27;
        Object r14 = r1.b;
        monitor-enter(r14);
        j3.a r15 = r1.a;     // Catch: Throwable -> L56
        if (r15 == null) goto L23;
        monitor-exit(r14);
        r13 = r15;
        goto L27
    L23:
        com.bytedance.ai.applet.base.log.b r16 = com.bytedance.ai.applet.base.log.a.a;     // Catch: Throwable -> L56
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[AIBridge][RateLimit] init: " + r12);     // Catch: Throwable -> L56
        j3.a r17 = new j3.a(r12.c(), r12.d());     // Catch: Throwable -> L56
        r1.a = r17;     // Catch: Throwable -> L56
        monitor-exit(r14);
        r13 = r17;
    L56:
        th = move-exception;
        throw th;
    L27:
        if (j3.a.a(r13) == false) goto L30;
        com.bytedance.ai.applet.base.log.b r18 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[AIBridge] method:" + r11 + " rate limited, reason:global", null);
        f3.a r19 = f3.a.s;
        AIBridgeMethod.Error r20 = new AIBridgeMethod.Error(0, r19.b, null, r19);
    L55:
        return r20;
    L30:
        j3.a r21 = r1.c.get(r11);
        if (r21 != null) goto L53;
        k r22 = r12.e().get(r11);
        if (r22 == null) goto L38;
        Integer r23 = r22.a();
        if (r23 == null) goto L38;
        int r24 = r23.intValue();
    L39:
        k r25 = r12.e().get(r11);
        if (r25 == null) goto L44;
        Long r26 = r25.b();
        if (r26 == null) goto L44;
        long r27 = r26.longValue();
    L45:
        ConcurrentHashMap<String, j3.a> r28 = r1.c;
        j3.a r29 = r28.get(r11);
        if (r29 != null) goto L51;
        r29 = new j3.a(r24, r27);
        j3.a r30 = r28.putIfAbsent(r11, r29);
        if (r30 == null) goto L51;
        r29 = r30;
    L51:
        r21 = r29;
    L44:
        r27 = r12.g();
    L38:
        r24 = r12.f();
    L53:
        if (j3.a.a(r21) == false) goto L61;
        com.bytedance.ai.applet.base.log.b r31 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.d("ai_bridge", "[AIBridge] method:" + r11 + " rate limited, reason:method", null);
        f3.a r32 = f3.a.s;
        r20 = new AIBridgeMethod.Error(0, r32.b, null, r32);
        goto L55
    L61:
        return null;
    L63:
        return null;
    }
}
