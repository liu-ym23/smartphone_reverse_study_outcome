package ab;

import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.ies.bullet.service.sdk.param.NavBtnType;
import com.bytedance.ies.bullet.service.sdk.param.StatusFontMode;
import kotlin.jvm.internal.Intrinsics;
import t36.f;
import y36.d;
import y36.g;
import y36.i;
import y36.n;
import y36.p;
import y36.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements f {
    public y36.a a;
    public p b;
    public y36.a c;
    public y36.a d;
    public r e;
    public y36.a f;
    public y36.a g;
    public n h;
    public r i;
    public r j;
    public com.bytedance.ies.bullet.service.sdk.param.a k;
    public p l;
    public r m;
    public y36.a n;
    public y36.a o;
    public y36.a p;
    public y36.a q;
    public d r;
    public y36.a s;
    public y36.a t;

    public b() {
    }

    public final y36.a b() {
        y36.a r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("showCloseall");
        return null;
    }

    public final y36.a c() {
        y36.a r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("transStatusBar");
        return null;
    }

    public final p getType() {
        p r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    public final void a(t36.d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        Boolean r1 = Boolean.FALSE;
        y36.a r0 = new y36.a(r10, "is_host_status_bar_light", r1);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.t = r0;
        y36.a r11 = new y36.a(r10, "disable_input_scroll", r1);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        this.a = r11;
        p r12 = new p(r10, "type", "");
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        this.b = r12;
        Intrinsics.checkNotNullParameter(new y36.a(r10, "hide_back", r1), "<set-?>");
        Intrinsics.checkNotNullParameter(new y36.a(r10, "show_more_button", r1), "<set-?>");
        Intrinsics.checkNotNullParameter(new d(r10, "title_bar_style", 0), "<set-?>");
        y36.a r13 = new y36.a(r10, "hide_status_bar", r1);
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        this.d = r13;
        r r14 = new r(r10, "nav_bar_color");
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        this.e = r14;
        Intrinsics.checkNotNullParameter(new g(r10, NavBtnType.NONE), "<set-?>");
        y36.a r15 = new y36.a(r10, "show_closeall", r1);
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        this.f = r15;
        y36.a r16 = new y36.a(r10, "show_close_always", r1);
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        this.g = r16;
        n r17 = new n(r10);
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        this.h = r17;
        r r18 = new r(r10, "status_bar_bg_color");
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        this.i = r18;
        r r19 = new r(r10, "status_bar_color");
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        this.j = r19;
        com.bytedance.ies.bullet.service.sdk.param.a r20 = new com.bytedance.ies.bullet.service.sdk.param.a(r10, "status_font_mode", StatusFontMode.DEFAULT);
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        this.k = r20;
        p r21 = new p(r10, "title", null);
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        this.l = r21;
        r r22 = new r(r10, "title_color");
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        this.m = r22;
        Intrinsics.checkNotNullParameter(new y36.a(r10, "support_exchange_theme", r1), "<set-?>");
        Boolean r23 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(new y36.a(r10, "is_adjust_pan", r23), "<set-?>");
        if (h.u() == false) goto L6;
        y36.a r24 = new y36.a(r10, "hide_nav_bar", r1);
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        this.c = r24;
        y36.a r25 = new y36.a(r10, "trans_status_bar", r1);
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        this.n = r25;
    L9:
        y36.a r26 = new y36.a(r10, "should_full_screen", r1);
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        this.o = r26;
        y36.a r27 = new y36.a(r10, "show_back", r1);
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        this.p = r27;
        y36.a r28 = new y36.a(r10, "enable_share", r1);
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        this.q = r28;
        d r29 = new d(r10, "icon_theme", 0);
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        this.r = r29;
        y36.a r30 = new y36.a(r10, "close_position_right", r23);
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        this.s = r30;
        return;
    L6:
        if (Intrinsics.areEqual(((i) getType()).b, "fullscreen") == false) goto L8;
        y36.a r31 = new y36.a(r10, "hide_nav_bar", r1);
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        this.c = r31;
        y36.a r32 = new y36.a(r10, "trans_status_bar", r1);
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        this.n = r32;
        goto L9
    L8:
        y36.a r33 = new y36.a(r10, "hide_nav_bar", r23);
        Intrinsics.checkNotNullParameter(r33, "<set-?>");
        this.c = r33;
        y36.a r34 = new y36.a(r10, "trans_status_bar", r1);
        Intrinsics.checkNotNullParameter(r34, "<set-?>");
        this.n = r34;
        goto L9
    }
}
