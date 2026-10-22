package fb;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final bb.b a;

    public b(bb.b r10) {
        Intrinsics.checkNotNullParameter(r10, "airSolutionContext");
        this.a = r10;
    }

    public final void a(eb.a r10, gb.b r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r10, "actionDispatcher");
        Intrinsics.checkNotNullParameter(r11, "expression");
        if (Intrinsics.areEqual(r11.a(), "c") == false) goto L17;
        String r0 = r11.b();
        if (r0 == null) goto L18;
        JavaOnlyMap r1 = new JavaOnlyMap();
        Object r13 = r11.c();
        if ((r13 instanceof Map) == false) goto L9;
        Map<String, ? extends Object> r14 = (Map) r13;
    L10:
        if (r14 == null) goto L13;
        r1 = this.a.d.c(r14, r12);
    L13:
        if (Intrinsics.areEqual("setData", r0) == false) goto L15;
        bb.b r15 = this.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r15, "airSolutionContext");
        Intrinsics.checkNotNullParameter(r1, "realArguments");
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.f("AirSolution_ActionDispatcher", "updateData: annieXLynxView: data: " + r1, null, 12);
        r15.c.a.putAll(r1);
        r10.a.updateData(r1);
        return;
    L15:
        r10.b(r0, r1, this.a);
        return;
    L9:
        r14 = null;
        goto L10
    L18:
        return;
    }
}
