package d3;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ w a;
    public final /* synthetic */ x b;
    public final /* synthetic */ AtomicBoolean c;

    public /* synthetic */ b(w r1, x r10, AtomicBoolean r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    public final Object invoke(Object r10) {
        final w r0 = this.a;
        final x r1 = this.b;
        final AtomicBoolean r11 = this.c;
        b0 r12 = (b0) r10;
        r0.getClass();
        String r13 = r0.e(r1.a);
        if (r12 == null) goto L5;
        r12.c(r1.a, new c(r0, r1, r11), new d(r0, r1, r11), r13);
    L10:
        return Unit.INSTANCE;
    L5:
        j4.a.a.getClass();
        j4.a r14 = j4.a.C0167a.a();
        if (r14 == null) goto L8;
        r14.markError(r13);
    L8:
        r0.h(r1, new AIBridgeMethod.Error("can not find target runtime", null, 2, null), r11);
        com.bytedance.ai.applet.base.log.b r15 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[AIBridge] can not find target runtime with target: " + r1.a.g(), null);
        goto L10
    }
}
