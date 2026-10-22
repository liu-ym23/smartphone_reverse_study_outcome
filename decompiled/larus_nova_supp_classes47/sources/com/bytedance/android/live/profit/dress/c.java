package com.bytedance.android.live.profit.dress;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.profit.dress.config.TextAlignType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.android.live.profit.dress.d] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    public static final d a(o r30) {
        Intrinsics.checkNotNullParameter(r30, "$this$toDressData");
        int r0 = r30.getDressType();
        Object r3 = null;
        if (r0 != 1) goto L5;
        com.bytedance.android.live.profit.dress.config.b r1 = r30.getAvatarBorderConfig();
        if (r1 == null) goto L71;
        r3 = new a(r1.getAvatarBorder(), r1.getThumbAvatarBorder());
    L71:
        return r3;
    L5:
        if (r0 != 2) goto L7;
        com.bytedance.android.live.profit.dress.config.i r2 = r30.getEnterEffectConfig();
        if (r2 == null) goto L71;
        long r7 = r2.getType();
        py.k r9 = r2.getIcon();
        long r10 = r2.getAvatarPos();
        a5 r12 = r2.getText();
        py.k r13 = r2.getTextIcon();
        long r14 = r2.getAnimAssetId();
        py.k r16 = r2.getTextIconOverlay();
        long r17 = r2.getCenterAnimAssetId();
        py.k r19 = r2.getDynamicImage();
        long r20 = r2.getMp4AnimAssetId();
        long r22 = r2.getAlignment();
        long r24 = r2.getAlignmentOffset();
        a5 r26 = r2.getTemplate();
        com.bytedance.android.live.profit.dress.config.h r27 = r2.getProfilePreviewConfig();
        String r28 = r2.getAvatarBorderDressId();
        Intrinsics.checkNotNullParameter(r2, "$this$getAlignType");
        long r4 = r2.getAlignment();
        if (r4 != 0) goto L60;
        TextAlignType r5 = TextAlignType.Left;
    L66:
        r3 = new l(r7, r9, r10, r12, r13, r14, r16, r17, r19, r20, r22, r24, r26, r27, r28, r5);
        goto L71
    L60:
        if (r4 != 1) goto L63;
        r5 = TextAlignType.Right;
        goto L66
    L63:
        if (r4 != 2) goto L65;
        r5 = TextAlignType.Middle;
        goto L66
    L65:
        r5 = TextAlignType.Middle;
        goto L66
    L7:
        if (r0 != 10) goto L9;
        com.bytedance.android.live.profit.dress.config.r r6 = r30.getProfileSkinConfig();
        if (r6 == null) goto L71;
        r3 = new v(r6.getParallaxAssetId(), r6.getProfileDisplayAssetId(), r6.getFlashCardId(), r6.getOverallBgImg(), r6.getPanelOpenEffect(), r6.getPanelLoopEffect(), r6.getRightPng(), r6.getBorderPoint9(), r6.getBorderPng(), r6.getMainButtonPng(), r6.getMainButtonWebp());
        goto L71
    L9:
        if (r0 != 20) goto L11;
        com.bytedance.android.live.profit.dress.config.j r8 = r30.getGuestBattleThemeElement();
        if (r8 == null) goto L71;
        r3 = new m(r8.getFirstConfig(), r8.getStragglerConfig(), r8.getRoomBackground(), r8.getPlayRuleImage());
        goto L71
    L11:
        if (r0 != 23) goto L13;
        com.bytedance.android.live.profit.dress.config.p r15 = r30.getOpenAssetConfig();
        if (r15 == null) goto L71;
        long r18 = r15.getAssetId();
        long r23 = r15.getTextWidth();
        long r110 = r15.getTextHeight();
        a5 r111 = r15.getTemplateText();
        String r112 = r15.getAvatarBorderDressId();
        Intrinsics.checkNotNullParameter(r15, "$this$getAlignType");
        int r25 = r15.getAlignType();
        if (r25 == 0) goto L45;
        if (r25 == 1) goto L44;
        if (r25 == 2) goto L43;
        TextAlignType r29 = TextAlignType.Middle;
    L46:
        r3 = new u(r18, r23, r110, r111, r112, r29, r15.getSchema());
        goto L71
    L43:
        r29 = TextAlignType.Right;
        goto L46
    L44:
        r29 = TextAlignType.Left;
        goto L46
    L45:
        r29 = TextAlignType.Middle;
        goto L46
    L13:
        if (r0 != 28) goto L15;
        com.bytedance.android.live.profit.dress.config.t r32 = r30.getRedEnvelopeSkin();
        if (r32 == null) goto L71;
        r3 = new w(r32.getName(), r32.getShortTouchWaiting(), r32.getShortTouchOutNoMore(), r32.getShortTouchOutWithMore(), r32.getEnterSkin(), r32.getUpperCover(), r32.getLowerCover(), r32.getBackgroud(), r32.getBorder(), r32.getCardImg(), r32.getCounterImg(), r32.getBlessIcon(), r32.getBlessWord(), r32.getSurpriseGifts());
        goto L71
    L15:
        if (r0 != 31) goto L17;
        com.bytedance.android.live.profit.dress.config.u r33 = r30.getRolePropConfig();
        if (r33 == null) goto L71;
        r3 = new x(r33.getPlayerProp(), r33.getTeamPlayerProp(), r33.getMvpEmojiDecorationId(), r33.getBloodBarStyleWebp(), r33.getMvpEmojiDecorationImg());
        goto L71
    L17:
        if (r0 != 33) goto L19;
        com.bytedance.android.live.profit.dress.config.k r34 = r30.getLinkmicDecorationConfig();
        if (r34 == null) goto L71;
        String r35 = r34.getName();
        String r36 = r34.getPlayValueIcon();
        String r37 = r34.getLinkmicDynamicEffect();
        String r38 = r34.getBeautyEffectId();
        String r39 = r34.getLinkmicStaticEffect();
        boolean r113 = r34.getShowFlymicEffect();
        String r114 = r34.getValueBgColor();
        String r115 = r34.getValueNumberColor();
        Intrinsics.checkNotNullParameter(r34, "$this$sponsorBgColor");
        com.bytedance.android.live.profit.dress.config.o r40 = (com.bytedance.android.live.profit.dress.config.o) r34.castToOrNull(com.bytedance.android.live.profit.dress.config.o.class);
        if (r40 == null) goto L29;
        r3 = r40.getSponsorBgColor();
    L29:
        r3 = new s(r35, r36, r37, r38, r39, r113, r114, r115, r3, r34.getHonorIcon(), r34.getPlayType(), r34.getStarWishConfig());
        goto L71
    L19:
        if (r0 != 35) goto L72;
        com.bytedance.android.live.profit.dress.config.m r42 = r30.getLinkmicRealTimeChorusConfig();
        if (r42 == null) goto L71;
        r3 = new t(r42.getGlobalValid(), r42.getAllowListId(), r42.getStageList());
        goto L71
    L72:
        return q.a;
    }
}
