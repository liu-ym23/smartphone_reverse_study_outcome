package com.bytedance.android.anniex.container.ui;

import android.content.Context;
import com.bytedance.ies.argus.api.ArgusContainerDelegate;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class AnnieXMorePanel$createReportButton$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ia.c $container;
    final /* synthetic */ Context $context;

    public AnnieXMorePanel$createReportButton$1(ia.c r1, Context r10) {
        this.$container = r1;
        this.$context = r10;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m211invoke() {
        m16.b r0 = this.$container.getContextProviderFactory();
        String r1 = null;
        if (r0 == null) goto L7;
        BulletContext r10 = (BulletContext) r0.c(BulletContext.class);
        if (r10 == null) goto L7;
        ArgusContainerDelegate r11 = r10.D;
    L8:
        if (r11 == null) goto L12;
        com.bytedance.ies.argus.aspect.eventCenter.e r12 = r11.a;
        if (r12 == null) goto L12;
        String r13 = r12.e();
    L13:
        if (r11 == null) goto L17;
        com.bytedance.ies.argus.aspect.eventCenter.e r14 = r11.a;
        if (r14 == null) goto L17;
        String r15 = r14.s;
    L18:
        SSWebView r16 = this.$container.getKitView();
        if ((r16 instanceof SSWebView) == false) goto L21;
        SSWebView r17 = r16;
    L22:
        if (r17 == null) goto L30;
        ArgusWebDelegateAdapter r18 = r17.getArgusAdapter$anniex_release();
        if (r18 == null) goto L30;
        ArgusWebDelegate r19 = r18.a;
        if (r19 == null) goto L30;
        com.bytedance.ies.argus.aspect.eventCenter.i r20 = r19.c;
        if (r20 == null) goto L30;
        r1 = r20.e();
    L30:
        s26.d r21 = s26.d.c;
        if (s26.d.c.d(this.$container.getBid(), com.bytedance.android.anniex.base.service.a.class) == null) goto L34;
        Context r22 = this.$context;
        la.c r23 = new la.c(0);
        r23.b = this.$container.getCurrentUrl();
        r23.d = r13;
        r23.e = r1;
        r23.f = r15;
        r23.a = this.$container.getContainerId();
        com.bytedance.android.anniex.base.service.a.K0(r22, r23);
        return;
    L34:
        return;
    L21:
        r17 = null;
    L17:
        r15 = null;
    L12:
        r13 = null;
    L7:
        r11 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m211invoke();
        return Unit.INSTANCE;
    }
}
