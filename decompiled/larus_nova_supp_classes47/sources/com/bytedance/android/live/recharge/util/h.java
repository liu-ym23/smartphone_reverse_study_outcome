package com.bytedance.android.live.recharge.util;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.recharge.utils.m;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.utils.e4;
import com.bytedance.android.livesdk.utils.r3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static long a;

    public static final class a extends ClickableSpan {
        public final /* synthetic */ Context a;

        public a(Context r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            Intrinsics.checkNotNullParameter(r5, "widget");
            m.l("livesdk_recharge_safe_agreement_popup_agreement_click", false, 0);
            ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(this.a, (String) com.bytedance.android.live.recharge.utils.j.h.getValue(null, com.bytedance.android.live.recharge.utils.j.a[6]));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setUnderlineText(false);
        }
    }

    public static final class b extends ClickableSpan {
        public final /* synthetic */ Context a;

        public b(Context r1) {
            this.a = r1;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r5) {
            Intrinsics.checkNotNullParameter(r5, "widget");
            m.l("livesdk_recharge_safe_agreement_popup_safe_click", false, 0);
            ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(this.a, (String) com.bytedance.android.live.recharge.utils.j.i.getValue(null, com.bytedance.android.live.recharge.utils.j.a[7]));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setUnderlineText(false);
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            this.a.invoke();
            int r7 = m.a;
            m.l("livesdk_recharge_safe_agreement_popup_recharge_click", false, 0);
            long r0 = System.currentTimeMillis() - h.a;
            h.a = r0;
            m.l("livesdk_recharge_safe_agreement_popup_duration", true, r0 / ((long) WebcastRedirectException.UNKNOWN));
            r5.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r5, int r6) {
            this.a.invoke();
            int r7 = m.a;
            m.l("livesdk_recharge_safe_agreement_popup_disagree_click", false, 0);
            long r0 = System.currentTimeMillis() - h.a;
            h.a = r0;
            m.l("livesdk_recharge_safe_agreement_popup_duration", true, r0 / ((long) WebcastRedirectException.UNKNOWN));
            r5.dismiss();
        }
    }

    public static final zy0.d b(Context r7, Uri r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "originalUri");
        final x0 r0 = new x0(r8);
        x0 r9 = r0.d("url");
        boolean r2 = false;
        if (r9.toString().length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        return null;
    L9:
        String r5 = r0.a("status_bar_height");
        if (r5 != null) goto L12;
    L13:
        r2 = true;
    L14:
        if (r2 == true) goto L16;
        r9.b("status_bar_height", r5);
    L16:
        String r10 = r0.a("type");
        if (r10 == null) goto L35;
        int r3 = r10.hashCode();
        if (r3 == 106852524) goto L26;
        if (r3 != 110066619) goto L36;
        r10.equals("fullscreen");
        return null;
    L36:
        return null;
    L26:
        if (r10.equals("popup") == true) goto L28;
        return null;
    L28:
        if (Intrinsics.areEqual(r0.a("gravity"), "bottom") == false) goto L31;
        return ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(r7, r0.c(), new RechargePanelUtilsKt$createRechargeBottomPanel$1(r0));
    L31:
        return ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(r7, r0.c(), new RechargePanelUtilsKt$createRechargePopupPanel$1(r0));
    L35:
        return null;
    L12:
        if (r5.length() != 0) goto L14;
    L5:
        r1 = false;
        goto L7
    }

    public static final int a(x0 r0, String r1, int r2) {
        String r3 = r0.a(r1);
        if (r3 == null) goto L8;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 != null) goto L7;
        return r2;
    L7:
        return r4.intValue();
    L8:
        return r2;
    }

    public static final c9 d(Context r10, Function0<Unit> r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r12, "confirmFun");
        Intrinsics.checkNotNullParameter(r13, "cancelFun");
        String r0 = s1.B(2131915668);
        String r1 = s1.B(2131915671);
        String r3 = s1.C(2131915672, new Object[]{r3.c(), e4.a()});
        String r4 = s1.B(2131915673);
        a = System.currentTimeMillis();
        m.l("livesdk_recharge_safe_agreement_popup_show", false, 0);
        c9.b r7 = new c9.b();
        r7.a = r10;
        r7.b = 2;
        r7.c = 2131565715;
        r7.e = s1.C(2131915669, new Object[]{e4.a()});
        r7.f = c(r10, r0, r1, r3, r4);
        r7.g = 17;
        r7.q = false;
        String r14 = s1.C(2131915666, new Object[]{e4.a()});
        c r2 = new c(r12);
        r7.l = r14;
        r7.m = r2;
        String r15 = s1.B(2131915667);
        d r16 = new d(r13);
        r7.j = r15;
        r7.k = r16;
        c9 r17 = new c9(r7.a, r7);
        ((TextView) r17.e.findViewById(2131384757)).setMovementMethod(LinkMovementMethod.getInstance());
        return r17;
    }

    public static final SpannableStringBuilder c(Context r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "leftText");
        Intrinsics.checkNotNullParameter(r6, "rightText");
        Intrinsics.checkNotNullParameter(r7, "protocol");
        Intrinsics.checkNotNullParameter(r8, "protocolTip");
        SpannableStringBuilder r0 = SpannableStringBuilder.valueOf(r5 + r7 + r6 + r8);
        int r9 = r5.length();
        int r10 = r7.length() + r9;
        int r12 = r6.length() + r10;
        int r13 = r8.length() + r12;
        r0.setSpan(new ForegroundColorSpan(s1.h(2131107805)), r9, r10, 18);
        r0.setSpan(new a(r4), r9, r10, 18);
        r0.setSpan(new ForegroundColorSpan(s1.h(2131107805)), r12, r13, 18);
        r0.setSpan(new b(r4), r12, r13, 18);
        return r0;
    }
}
