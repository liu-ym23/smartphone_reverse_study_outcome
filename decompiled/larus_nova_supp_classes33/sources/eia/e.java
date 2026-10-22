package eia;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common_ui.view.GradientMaskView;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class e extends v {
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public void f(boolean r1) {
    }

    public void g() {
    }

    public final void c() {
        ICoreInputAbility r0 = (ICoreInputAbility) this.d.getValue();
        if (r0 == null) goto L7;
        CoreInputAbility r1 = r0.JO();
        if (r1 == null) goto L7;
        r1.w9(false);
    L7:
        ICoreInputAbility r2 = (ICoreInputAbility) this.d.getValue();
        if (r2 == null) goto L12;
        CoreInputAbility r3 = r2.JO();
        if (r3 == null) goto L12;
        r3.n9(true);
    L12:
        com.larus.bmhome.chat.component.bottom.core.a r4 = e();
        View r5 = null;
        if (r4 == null) goto L15;
        GradientMaskView r6 = r4.a();
    L16:
        if (r6 == null) goto L18;
        e1.o(r6);
    L18:
        com.larus.bmhome.chat.component.bottom.core.a r7 = e();
        if (r7 == null) goto L21;
        RecyclerView r8 = r7.d();
    L22:
        if (r8 == null) goto L24;
        e1.o(r8);
    L24:
        FrameLayout r9 = (FrameLayout) this.g.getValue();
        if (r9 == null) goto L27;
        r5 = r9.findViewById(2131381280);
    L27:
        if (r5 == null) goto L30;
        e1.o(r5);
        return;
    L30:
        return;
    L21:
        r8 = null;
        goto L22
    L15:
        r6 = null;
        goto L16
    }

    public final void d() {
        ICoreInputAbility r0 = (ICoreInputAbility) this.d.getValue();
        if (r0 == null) goto L7;
        CoreInputAbility r1 = r0.JO();
        if (r1 == null) goto L7;
        r1.w9(true);
    L7:
        ICoreInputAbility r2 = (ICoreInputAbility) this.d.getValue();
        if (r2 == null) goto L12;
        CoreInputAbility r3 = r2.JO();
        if (r3 == null) goto L12;
        r3.n9(false);
    L12:
        com.larus.bmhome.chat.component.bottom.core.a r4 = e();
        View r5 = null;
        if (r4 == null) goto L15;
        GradientMaskView r6 = r4.a();
    L16:
        if (r6 == null) goto L18;
        e1.x(r6);
    L18:
        com.larus.bmhome.chat.component.bottom.core.a r7 = e();
        if (r7 == null) goto L21;
        RecyclerView r8 = r7.d();
    L22:
        if (r8 == null) goto L24;
        e1.x(r8);
    L24:
        FrameLayout r9 = (FrameLayout) this.g.getValue();
        if (r9 == null) goto L27;
        r5 = r9.findViewById(2131381280);
    L27:
        if (r5 == null) goto L30;
        e1.x(r5);
        return;
    L30:
        return;
    L21:
        r8 = null;
        goto L22
    L15:
        r6 = null;
        goto L16
    }

    public final va8.c e() {
        va8.o r0 = (va8.o) this.f.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Uv();
    }

    public e(Context r2, final t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
        this.d = LazyKt.lazy(new eia.a(r3));
        this.e = LazyKt.lazy(new b(r3));
        this.f = LazyKt.lazy(new c(r3));
        this.g = LazyKt.lazy(new d(this));
    }
}
