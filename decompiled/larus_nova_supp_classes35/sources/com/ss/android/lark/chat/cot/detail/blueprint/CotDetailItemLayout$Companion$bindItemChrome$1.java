package com.ss.android.lark.chat.cot.detail.blueprint;

import android.widget.ImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.chat.cot.CotBlockStatus;
import com.ss.android.lark.chat.cot.detail.CotDetailBlockType;
import com.ss.android.lark.chat.cot.detail.k;
import com.ss.android.lark.chat.cot.detail.t;
import com.ss.android.lark.chat.cot.detail.u;
import com.ss.android.lark.chat.entity.message.CotStatus;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class CotDetailItemLayout$Companion$bindItemChrome$1 extends FunctionReferenceImpl implements Function3<ImageView, k, Boolean, Unit> {
    public CotDetailItemLayout$Companion$bindItemChrome$1(Object r8) {
        super(3, r8, com.ss.android.lark.chat.cot.detail.widget.a.class, "bind", "bind(Landroid/widget/ImageView;Lcom/ss/android/lark/chat/cot/detail/CotDetailItem;Z)V", 0);
    }

    public final void invoke(ImageView r8, k r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "p0");
        Intrinsics.checkNotNullParameter(r9, "p1");
        ((com.ss.android.lark.chat.cot.detail.widget.a) ((CallableReference) this).receiver).getClass();
        Intrinsics.checkNotNullParameter(r8, "markerView");
        Intrinsics.checkNotNullParameter(r9, "item");
        boolean r0 = true;
        com.ss.android.lark.chat.cot.c r1 = null;
        CotStatus r2 = null;
        com.ss.android.lark.chat.cot.c r3 = null;
        com.ss.android.lark.chat.cot.c r4 = null;
        if (r10 == true) goto L81;
        CotDetailBlockType r11 = r9.b;
        if (r11 == CotDetailBlockType.STATUS) goto L7;
    L9:
        int r12 = com.ss.android.lark.chat.cot.detail.widget.a.b.a[r11.ordinal()];
        if (r12 == 1) goto L80;
        if (r12 != 2) goto L13;
        u r13 = r9.c();
        if (r13 == null) goto L79;
        r4 = r13.a;
    L79:
        com.ss.android.lark.chat.cot.detail.widget.a.f(r8, r4);
        return;
    L13:
        if (r12 != 3) goto L15;
        com.ss.android.lark.chat.cot.detail.widget.a.a(r8);
        return;
    L15:
        if (r12 != 4) goto L17;
        com.ss.android.lark.chat.cot.detail.b r14 = r9.g;
        if ((r14 instanceof com.ss.android.lark.chat.cot.detail.a) == false) goto L62;
        com.ss.android.lark.chat.cot.detail.a r15 = (com.ss.android.lark.chat.cot.detail.a) r14;
    L64:
        if (r9.b == CotDetailBlockType.ACTION) goto L67;
        r0 = false;
    L67:
        if (r0 == true) goto L70;
        r15 = null;
    L70:
        if (r15 == null) goto L72;
        r3 = r15.a;
    L72:
        if (r3 != null) goto L74;
        com.ss.android.lark.chat.cot.detail.widget.a.a(r8);
        return;
    L74:
        com.ss.android.lark.chat.cot.detail.widget.a.f(r8, r3);
        return;
    L62:
        r15 = null;
        goto L64
    L17:
        if (r12 != 5) goto L58;
        if (r9.e != CotBlockStatus.VIOLATED) goto L21;
        com.ss.android.lark.chat.cot.detail.widget.a.C0091a r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131254921);
    L56:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r8, r16.a, false);
        r8.setColorFilter(UDColorUtils.getColor(r8.getContext(), r16.b));
        return;
    L21:
        t r17 = r9.b();
        if (r17 == null) goto L24;
        CotStatus r18 = r17.a;
    L26:
        if (r18 != CotStatus.DONE) goto L28;
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131256306);
        goto L56
    L28:
        t r19 = r9.b();
        if (r19 == null) goto L31;
        CotStatus r110 = r19.a;
    L33:
        if (r110 != CotStatus.ERROR) goto L35;
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131254921);
        goto L56
    L35:
        t r111 = r9.b();
        if (r111 == null) goto L38;
        CotStatus r112 = r111.a;
    L40:
        if (r112 != CotStatus.TIMEOUT) goto L42;
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131254921);
        goto L56
    L42:
        t r113 = r9.b();
        if (r113 == null) goto L45;
        CotStatus r114 = r113.a;
    L47:
        if (r114 != CotStatus.INTERRUPTED) goto L49;
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131254921);
        goto L56
    L49:
        t r20 = r9.b();
        if (r20 == null) goto L53;
        r2 = r20.a;
    L53:
        if (r2 != CotStatus.PAUSED) goto L55;
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131254921);
        goto L56
    L55:
        r16 = new com.ss.android.lark.chat.cot.detail.widget.a.C0091a(2131256306);
        goto L56
    L45:
        r114 = null;
        goto L47
    L38:
        r112 = null;
        goto L40
    L31:
        r110 = null;
        goto L33
    L24:
        r18 = null;
        goto L26
    L58:
        throw new NoWhenBranchMatchedException();
    L80:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r8, 2131237761, true);
        return;
    L7:
        if (r9.e != CotBlockStatus.RUNNING) goto L9;
        com.ss.android.lark.chat.cot.detail.widget.a.g(r8);
        return;
    L81:
        int r115 = com.ss.android.lark.chat.cot.detail.widget.a.b.a[r9.b.ordinal()];
        if (r115 == 1) goto L92;
        if (r115 == 2) goto L85;
        com.ss.android.lark.chat.cot.detail.widget.a.g(r8);
        return;
    L85:
        u r21 = r9.c();
        if (r21 == null) goto L88;
        r1 = r21.a;
    L88:
        Intrinsics.checkNotNullParameter(r8, "iconView");
        if (com.ss.android.lark.chat.cot.detail.widget.a.e(r8, r1) == false) goto L91;
        r8.setVisibility(0);
        return;
    L91:
        com.ss.android.lark.chat.cot.detail.widget.a.g(r8);
        r8.setVisibility(8);
        return;
    L92:
        com.ss.android.lark.chat.cot.detail.widget.a.b(r8, 2131237761, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((ImageView) r1, (k) r2, ((Boolean) r3).booleanValue());
        return Unit.INSTANCE;
    }
}
