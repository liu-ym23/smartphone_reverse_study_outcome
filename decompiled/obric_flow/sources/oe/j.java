package oe;

import com.bytedance.ies.xelement.BounceLayout;
import com.bytedance.ies.xelement.LynxScrollView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxScrollView f20554a;

    public j(LynxScrollView r5) {
        this.f20554a = r5;
    }

    public final void a(int r12, int r13, int r14, int r15) {
        LynxScrollView r11 = this.f20554a;
        if (((BounceLayout) LynxScrollView.j(r11)).getMEnableBounce() == true) goto L6;
        return;
    L6:
        if (((BounceLayout) LynxScrollView.j(r11)).getMScrollDirection() != BounceLayout.ScrollDirection.f6358c) goto L8;
    L16:
        r11.getClass();
        r11.getClass();
        Intrinsics.checkNotNullParameter("scroll", "type");
        on.f r16 = new on.f(r11.getSign(), "scroll");
        r16.d(r12, 0, r11.g, r11.f, r12 - r14, 0);
        LynxContext r17 = r11.getLynxContext();
        if (r17 == null) goto L24;
        r r18 = r17.g;
        if (r18 == null) goto L25;
        r18.b(r16);
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (((BounceLayout) LynxScrollView.j(r11)).getMScrollDirection() == BounceLayout.ScrollDirection.d) goto L16;
        r11.getClass();
        r11.getClass();
        Intrinsics.checkNotNullParameter("scroll", "type");
        on.f r19 = new on.f(r11.getSign(), "scroll");
        r19.d(0, r13, r11.g, r11.f, 0, r13 - r15);
        LynxContext r110 = r11.getLynxContext();
        if (r110 == null) goto L22;
        r r111 = r110.g;
        if (r111 == null) goto L23;
        r111.b(r19);
        return;
    L23:
        return;
    }
}
