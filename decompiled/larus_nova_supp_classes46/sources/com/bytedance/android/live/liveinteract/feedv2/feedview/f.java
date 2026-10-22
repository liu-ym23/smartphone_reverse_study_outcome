package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.config.yl0;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements com.bytedance.android.live.liveinteract.plantform.commonwindow.g {
    public final /* synthetic */ MultiLinkCommonVideoFeedPreview a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void b(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        this.a.getConfigOuterProvider().printALogger("CommonVideoFeedPreview", this.a.hashCode(), "call getLayoutConfigFailed, targetUILayout = " + this.c + ", trace = " + r5.c.a, true);
        f2.g();
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.commonwindow.g
    public final void a(com.bytedance.android.live.liveinteract.plantform.commonwindow.h r20, com.bytedance.android.live.liveinteract.plantform.commonwindow.i r21) {
        Intrinsics.checkNotNullParameter(r20, "request");
        Intrinsics.checkNotNullParameter(r21, "response");
        IPreviewMultiLinkOuterConfigProvider.DefaultImpls.printALogger$default(this.a.getConfigOuterProvider(), "CommonVideoFeedPreview", this.a.hashCode(), "call getLayoutConfigSuccess, spendTime = " + (System.currentTimeMillis() - this.b) + ", targetUILayout = " + this.c + ", trace = " + r20.c.a, false, 8, null);
        MultiLinkCommonVideoFeedPreview r1 = this.a;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3 = r1.getLayoutConfig();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r4 = r21.a;
        if (r3 != null) goto L5;
    L9:
        r1.G(r3, r4);
    L10:
        this.a.F(r21.a);
        if (((Boolean) vm2.h.w6.getValue(null, vm2.h.a[385(0x181, float:5.4E-43)])).booleanValue() == false) goto L105;
        this.a.A();
        com.bytedance.android.live.liveinteract.plantform.commonwindow.m r2 = this.a.getLayoutConfig();
        if (r2 == null) goto L15;
        this.a.G(null, r2);
    L15:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.a r5 = this.a.getDynamicWidget();
        if (r5 == null) goto L18;
        r5.onViewHolderSelected();
    L18:
        MultiLinkCommonVideoFeedPreview r6 = this.a;
        r6.getClass();
        Lazy r7 = KtvCommonSettingHelper.a;
        boolean r8 = true;
        if (((Boolean) KtvCommonSettingHelper.a.getValue()).booleanValue() == true) goto L21;
    L58:
        MultiLinkCommonVideoFeedPreview r9 = this.a;
        if (r9.E == 62) goto L62;
        r8 = false;
    L62:
        if (r8 == true) goto L64;
        return;
    L64:
        if (r9.w == null) goto L66;
        return;
    L66:
        if (((Boolean) yl0.a.getValue()).booleanValue() == false) goto L108;
        IKtvService r10 = jc1.k.f(IKtvService.class);
        if (r10 == null) goto L76;
        IPreviewMultiLinkOuterConfigProvider r11 = r9.b;
        if (r11 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L72:
        String r12 = r11.getEnterFromMerge();
        if (r12 != null) goto L75;
        r12 = "";
    L75:
        fd2.g r13 = r10.createConcertFeedWidget(r12);
    L77:
        r9.w = r13;
        if (r13 == null) goto L101;
        Context r14 = r9.getContext();
        IRoom r15 = r9.r();
        if (r15 == null) goto L85;
        String r16 = r15.getIdStr();
        if (r16 == null) goto L85;
        String r17 = r16;
    L86:
        IRoom r18 = r9.r();
        if (r18 == null) goto L92;
        String r19 = r18.getOwnerUserIdString();
        if (r19 == null) goto L92;
        String r110 = r19;
    L93:
        IPreviewMultiLinkOuterConfigProvider r22 = r9.b;
        if (r22 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L96:
        String r23 = r22.getEnterFromMerge();
        if (r23 != null) goto L99;
        String r111 = "";
    L100:
        r13.c(new fd2.b(r14, r17, r110, true, false, r111, null, null, (ViewGroup) r9.findViewById(2131376892)));
        goto L101
    L99:
        r111 = r23;
    L92:
        r110 = "";
    L85:
        r17 = "";
    L101:
        fd2.g r24 = r9.w;
        if (r24 == null) goto L109;
        r24.onSelect();
        return;
    L109:
        return;
    L76:
        r13 = null;
        goto L77
    L108:
        return;
    L21:
        if (r6.E != 63) goto L23;
        boolean r25 = true;
    L24:
        if (r25 == false) goto L58;
        if (r6.x != null) goto L58;
        IKtvService r26 = jc1.k.f(IKtvService.class);
        if (r26 == null) goto L30;
        fd2.g r27 = r26.createVideoChorusFeedWidget();
    L31:
        r6.x = r27;
        if (r27 == null) goto L55;
        Context r28 = r6.getContext();
        IRoom r29 = r6.r();
        if (r29 == null) goto L39;
        String r30 = r29.getIdStr();
        if (r30 == null) goto L39;
        String r112 = r30;
    L40:
        IRoom r31 = r6.r();
        if (r31 == null) goto L46;
        String r32 = r31.getOwnerUserIdString();
        if (r32 == null) goto L46;
        String r113 = r32;
    L47:
        IPreviewMultiLinkOuterConfigProvider r33 = r6.b;
        if (r33 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("configOuterProvider");
    L50:
        String r34 = r33.getEnterFromMerge();
        if (r34 != null) goto L53;
        String r114 = "";
    L54:
        r27.c(new fd2.b(r28, r112, r113, true, true, r114, (ViewGroup) r6.findViewById(2131392275), (ViewGroup) r6.findViewById(2131379318), (ViewGroup) r6.findViewById(2131392273)));
        goto L55
    L53:
        r114 = r34;
    L46:
        r113 = "";
    L39:
        r112 = "";
    L55:
        fd2.g r35 = r6.x;
        if (r35 == null) goto L58;
        r35.onSelect();
        goto L58
    L30:
        r27 = null;
        goto L31
    L23:
        r25 = false;
        goto L24
    L105:
        return;
    L5:
        if (r3.j() != r4.j()) goto L9;
        if (r3.getUiLayout() != r4.getUiLayout()) goto L9;
        goto L9
    }

    public f(MultiLinkCommonVideoFeedPreview r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
