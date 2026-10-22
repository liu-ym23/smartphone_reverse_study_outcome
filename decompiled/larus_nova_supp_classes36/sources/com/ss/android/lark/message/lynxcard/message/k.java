package com.ss.android.lark.message.lynxcard.message;

import android.os.SystemClock;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.universalcard.datachannel.MessageCardRenderUtils;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements EllipsizeFrameLayout.c {
    public final /* synthetic */ LynxCardViewHolder a;
    public final /* synthetic */ v5b.c<LynxCardContentVO> b;
    public final /* synthetic */ LynxCardMessageCell c;

    public k(LynxCardViewHolder r1, v5b.c<LynxCardContentVO> r2, LynxCardMessageCell r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final boolean a() {
        v5b.c<LynxCardContentVO> r0 = this.a.k;
        String r1 = null;
        if (r0 == null) goto L5;
        LynxCardContentVO r2 = (LynxCardContentVO) r0.b();
    L6:
        v5b.c<LynxCardContentVO> r3 = this.a.k;
        if (r3 == null) goto L10;
        r1 = r3.getId();
    L10:
        if (Intrinsics.areEqual(r1, this.b.getId()) == false) goto L16;
        if (r0 == null) goto L16;
        if (r2 == null) goto L16;
        if (this.c.p(r0, r2, MessageCardRenderUtils.a(r2)) == false) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
        return false;
    L19:
        LynxCardMessageCell r5 = this.c;
        LynxCardViewHolder r6 = this.a;
        v5b.c<LynxCardContentVO> r7 = this.b;
        r5.getClass();
        if (r6.d == false) goto L23;
    L30:
        boolean r8 = false;
    L31:
        if (r8 == false) goto L37;
        LynxCardMessageCell r9 = this.c;
        v5b.c<LynxCardContentVO> r10 = this.b;
        r9.getClass();
        LynxCardContentVO r11 = r0.b();
        LynxCardContentVO r12 = (LynxCardContentVO) r10.b();
        r11.l = false;
        if (r11 == r12) goto L35;
        r12.l = false;
    L35:
        r9.b.b(r10.getId());
        return false;
    L37:
        return true;
    L23:
        if (Intrinsics.areEqual(r6.f, r7.getId()) == false) goto L30;
        long r13 = SystemClock.uptimeMillis() - r6.e;
        if (0 > r13) goto L30;
        if (r13 >= 501) goto L30;
        r8 = true;
    L16:
        r4 = false;
        goto L17
    L5:
        r2 = null;
        goto L6
    }
}
