package dia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.CoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.z8;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.util.f2;
import eia.n;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b extends n {

    public static final class a {
    }

    static {
    }

    @Override // eia.n, eia.v
    public final void a() {
        FLogger.a.i("LandscapeInputStrategy", "applyOrientationChange " + hashCode());
        o r0 = (o) this.h.getValue();
        View r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.a r2 = r0.Uv();
    L6:
        if (r2 == null) goto L8;
        ConstraintLayout r3 = r2.h();
    L9:
        ConstraintLayout r4 = f2.a(r3);
        if (r4 == null) goto L16;
        r4.setPadding(r4.getPaddingLeft(), r4.getPaddingTop(), r4.getPaddingRight(), 0);
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L15;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r6.bottomMargin = 0;
        r4.setLayoutParams(r6);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L16:
        f1 r7 = (f1) this.e.getValue();
        if (r7 == null) goto L21;
        boolean r8 = true;
        if (r7.sL() != true) goto L21;
    L22:
        if (r8 == false) goto L26;
        ICoreInputAbility r9 = (ICoreInputAbility) this.d.getValue();
        if (r9 == null) goto L26;
        r9.C1(false, false, "obric_applyOrientationChange");
    L26:
        o r10 = (o) this.h.getValue();
        if (r10 == null) goto L29;
        com.larus.bmhome.chat.component.bottom.core.a r11 = r10.Uv();
    L30:
        if (r11 == null) goto L32;
        r1 = r11.f();
    L32:
        if (r1 == null) goto L34;
        e1.o(r1);
    L34:
        o r12 = (o) this.h.getValue();
        if (r12 == null) goto L37;
        r12.JP(Boolean.FALSE);
    L37:
        ICoreInputAbility r13 = (ICoreInputAbility) this.d.getValue();
        if (r13 == null) goto L50;
        CoreInputAbility r14 = r13.JO();
        if (r14 == null) goto L50;
        ICoreInputAbility r15 = (ICoreInputAbility) this.d.getValue();
        if (r15 == null) goto L48;
        z8.a r16 = r15.Jd();
        if (r16 == null) goto L48;
        z8.b r17 = r16.l;
        if (r17 == null) goto L48;
        z8.b r18 = new z8.b(false, r17.b);
    L49:
        r14.l9(r18);
    L48:
        r18 = new z8.b(false, 2);
    L50:
        super.a();
        return;
    L29:
        r11 = null;
    L21:
        r8 = false;
        goto L22
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public b(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
