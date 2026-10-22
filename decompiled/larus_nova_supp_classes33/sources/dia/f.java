package dia;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.util.f2;
import eia.n;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.b1;
import laa.j;
import v19.c7;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f extends n {

    public static final class a {
    }

    static {
    }

    @Override // eia.n, eia.v
    public final void a() {
        FLogger r0 = FLogger.a;
        r0.i("PortraitInputStrategy", "applyOrientationChange " + hashCode());
        o r1 = (o) this.h.getValue();
        View r3 = null;
        if (r1 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.a r2 = r1.Uv();
    L6:
        if (r2 == null) goto L8;
        ConstraintLayout r4 = r2.h();
    L9:
        ConstraintLayout r5 = f2.a(r4);
        boolean r6 = false;
        if (r5 == null) goto L27;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
        if (r7 == null) goto L26;
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        o r9 = (o) this.h.getValue();
        if (r9 == null) goto L16;
        com.larus.bmhome.chat.component.bottom.core.a r10 = r9.Uv();
    L17:
        if (r10 == null) goto L19;
        ConstraintLayout r11 = r10.h();
    L21:
        if ((r11 instanceof ShadowLayout) == false) goto L23;
        int r12 = aia.e.a;
        int r13 = c7.b(12);
    L24:
        r8.bottomMargin = r13;
        r5.setLayoutParams(r8);
        goto L27
    L23:
        r13 = 0;
        goto L24
    L19:
        r11 = null;
        goto L21
    L16:
        r10 = null;
        goto L17
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L27:
        j r14 = (j) this.j.getValue();
        if (r14 == null) goto L34;
        b1 r15 = r14.O4();
        if (r15 == null) goto L34;
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L34;
        boolean r16 = true;
    L35:
        com.larus.bmhome.instruction.g r17 = (com.larus.bmhome.instruction.g) this.i.getValue();
        if (r17 != null) goto L38;
    L40:
        boolean r18 = false;
    L41:
        g1 r19 = (g1) this.k.getValue();
        if (r19 != null) goto L44;
    L46:
        boolean r20 = false;
    L47:
        r0.i("PortraitInputStrategy", "applyOrientationChange isSpecialInputOpen " + r16 + ", isInstructionInputOpen " + r18 + ", isAttachmentPanelOpen " + r20);
        if (r16 == true) goto L53;
        if (r18 == true) goto L53;
        if (r20 == true) goto L53;
        boolean r21 = false;
    L54:
        if (r21 == false) goto L56;
    L79:
        o r22 = (o) this.h.getValue();
        if (r22 == null) goto L82;
        r22.JP(null);
    L82:
        o r23 = (o) this.h.getValue();
        if (r23 == null) goto L85;
        com.larus.bmhome.chat.component.bottom.core.a r24 = r23.Uv();
    L86:
        if (r24 == null) goto L88;
        r3 = r24.f();
    L88:
        if (r3 == null) goto L90;
        e1.o(r3);
    L90:
        super.a();
        return;
    L85:
        r24 = null;
        goto L86
    L56:
        if (com.obric.assistant.task.skill.f.d() == true) goto L79;
        if (b() == false) goto L90;
        o r25 = (o) this.h.getValue();
        if (r25 == null) goto L67;
        String r26 = r25.u7();
        if (r26 == null) goto L67;
        if ((!StringsKt.isBlank(r26)) != true) goto L67;
        r6 = true;
    L67:
        if (r6 == true) goto L90;
        o r27 = (o) this.h.getValue();
        if (r27 == null) goto L71;
        r27.JP(Boolean.TRUE);
    L71:
        o r28 = (o) this.h.getValue();
        if (r28 == null) goto L74;
        com.larus.bmhome.chat.component.bottom.core.a r29 = r28.Uv();
    L75:
        if (r29 == null) goto L77;
        r3 = r29.f();
    L77:
        if (r3 == null) goto L90;
        e1.x(r3);
        goto L90
    L74:
        r29 = null;
    L53:
        r21 = true;
        goto L54
    L44:
        if (r19.isVisible() != true) goto L46;
        r20 = true;
        goto L47
    L38:
        if (r17.z0() != true) goto L40;
        r18 = true;
    L34:
        r16 = false;
        goto L35
    L8:
        r4 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public f(Context r2, t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
    }
}
