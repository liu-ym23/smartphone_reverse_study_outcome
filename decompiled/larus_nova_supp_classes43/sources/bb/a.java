package bb;

import com.bytedance.android.anniex.solutions.card.AirActionConstant$AirSolutionLifecycle;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import com.lynx.tasm.TemplateData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final AnnieXLynxView a;
    public final b b;
    public final eb.a c;
    public gb.c d;
    public volatile boolean e;

    /* JADX INFO: renamed from: bb.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0006a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AirActionConstant$AirSolutionLifecycle.values().length];
            r0[AirActionConstant$AirSolutionLifecycle.OnShow.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AirActionConstant$AirSolutionLifecycle.OnHide.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AirActionConstant$AirSolutionLifecycle.OnViewLoad.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void a(AirActionConstant$AirSolutionLifecycle r10) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        c r0 = c.a;
        AnnieXLynxView r1 = this.a;
        r0.getClass();
        c.b(r1, this);
        int r11 = C0006a.a[r10.ordinal()];
        if (r11 != 1) goto L5;
        gb.c r12 = this.d;
        if (r12 == null) goto L19;
        gb.a.c r13 = r12.e();
    L20:
        if (r13 == null) goto L23;
        this.c.a(null, r13, this.b);
        return;
    L23:
        return;
    L19:
        r13 = null;
        goto L20
    L5:
        if (r11 != 2) goto L7;
        gb.c r14 = this.d;
        if (r14 == null) goto L19;
        r13 = r14.d();
        goto L20
    L7:
        if (r11 != 3) goto L12;
        gb.c r15 = this.d;
        if (r15 == null) goto L19;
        r13 = r15.f();
        goto L20
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public a(AnnieXLynxView r10, LynxBDXBridge r11) {
        Intrinsics.checkNotNullParameter(r10, "lynxView");
        Intrinsics.checkNotNullParameter(r11, "lynxBDXBridge");
        this.a = r10;
        this.b = new b();
        this.c = new eb.a(r10, r11);
    }

    public final void b(TemplateData r10, boolean r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        return;
    L9:
        Map<? extends String, ? extends Object> r1 = null;
        if (r10 == null) goto L12;
        Map<? extends String, ? extends Object> r12 = r10.toMap();
    L14:
        if ((r12 instanceof Map) == false) goto L16;
        r1 = r12;
    L16:
        if (r1 == null) goto L21;
        if (r11 == false) goto L19;
        ((LinkedHashMap) this.b.c.a).clear();
    L19:
        this.b.c.a.putAll(r1);
        return;
    L21:
        return;
    L12:
        r12 = null;
        goto L14
    L5:
        if (r10.isEmpty() != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void c(Map<String, ? extends Object> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "templateData");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
        ((LinkedHashMap) this.b.c.a).clear();
    L7:
        this.b.c.a.putAll(r10);
    }
}
