package com.larus.uaigc.creation;

import android.view.View;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final h a;
    public final CoroutineScope b;
    public final l0 c;
    public final g d;
    public final c4 e;
    public final View f;
    public final Message g;
    public final com.larus.bmhome.share.panel.d h;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        h r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        l0 r4 = this.c;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        g r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        c4 r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        View r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Message r16 = this.g;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        com.larus.bmhome.share.panel.d r19 = this.h;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "VideoSharePanelParams(sharePanelEventParam=" + this.a + ", scope=" + this.b + ", loadingDialog=" + this.c + ", videoPlayData=" + this.d + ", videoEventParams=" + this.e + ", rootView=" + this.f + ", message=" + this.g + ", clickInterceptor=" + this.h + ')';
    }

    public /* synthetic */ f(h r9, CoroutineScope r10, g r11, c4 r12, View r13, Message r14) {
        this(r9, r10, r11, r12, r13, r14, null);
    }

    public f(h r2, CoroutineScope r3, g r4, c4 r5, View r6, Message r7, com.larus.bmhome.share.panel.d r8) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        this.a = r2;
        this.b = r3;
        this.c = null;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
