package com.suite.lark.platform.component.cta.newstyle;

import android.content.Context;
import android.view.View;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.component.universe_design.button.UDButton;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.cta.newstyle.entity.CTAParams;
import kotlin.jvm.internal.Intrinsics;
import z5c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends OnSingleClickListener {
    public final /* synthetic */ UDButton a;
    public final /* synthetic */ CTADialogFragment b;
    public final /* synthetic */ goc.b.d c;

    public final void onSingleClick(View r18) {
        Context r0 = this.a.getContext();
        CTADialogFragment r2 = this.b;
        goc.b r3 = r2.f;
        goc.b.d r4 = this.c;
        goc.a r5 = r2.e;
        goc.b.e r6 = r2.k;
        CTAParams r7 = r2.g;
        String r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ctaParams");
        r7 = null;
    L5:
        joc.c r9 = loc.e.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r4, "button");
        goc.b.a r1 = r4.a();
        if (r1 == null) goto L8;
        String r10 = r1.a();
    L9:
        String r11 = "";
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        if (r10.length() <= 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L18;
        ((eoc.a) ClaymoreServiceLoader.loadFirst(eoc.a.class)).a();
    L18:
        if (r5 == null) goto L23;
        String r13 = r4.e();
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        r5.a(r13);
    L23:
        if (r3 == null) goto L62;
        goc.b.g r14 = r3.b();
        if (r14 == null) goto L62;
        goc.b.h r15 = r14.b();
        if (r15 == null) goto L62;
        int r16 = g.a;
        if (r7 == null) goto L35;
        String r17 = r7.getFeatureKey();
        if (r17 == null) goto L35;
        String r19 = r17;
    L36:
        if (r7 == null) goto L41;
        String r20 = r7.getScene();
        if (r20 == null) goto L41;
        String r110 = r20;
    L42:
        String r21 = r15.b();
        if (r21 != null) goto L45;
        String r111 = "";
    L46:
        boolean r112 = r15.a();
        boolean r113 = r15.d();
        if (r6 == null) goto L49;
        r8 = r6.d();
    L49:
        if (r8 != null) goto L51;
        String r114 = "";
    L52:
        String r22 = r15.c();
        if (r22 != null) goto L55;
        String r115 = "";
    L56:
        r r23 = r.c3;
        String r24 = r4.e();
        if (r24 == null) goto L60;
        r11 = r24;
    L60:
        g.a(r19, r110, r111, r112, r113, r114, r115, r23.a(r11));
        goto L62
    L55:
        r115 = r22;
        goto L56
    L51:
        r114 = r8;
        goto L52
    L45:
        r111 = r21;
    L41:
        r110 = "";
    L35:
        r19 = "";
    L62:
        if (Intrinsics.areEqual(this.c.d(), "primary") == false) goto L71;
        return;
    L71:
        this.b.dismiss();     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r25 = DialogFragmentLancet.sLastShowStack;
        if (r25 == null) goto L74;
        com.bytedance.crash.d.d(r25, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L74:
        return;
    L15:
        r12 = false;
        goto L16
    L8:
        r10 = null;
        goto L9
    }

    public b(UDButton r1, CTADialogFragment r2, goc.b.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(500);
    }
}
