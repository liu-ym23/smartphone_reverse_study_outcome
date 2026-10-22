package com.bytedance.android.live.componentsmarket.impl.components.close;

import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.ey0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.ViewConfig;
import com.bytedance.live.datacontext.n;
import j70.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i extends j<d90.a> {
    @Override // j70.k
    public final Tetris<? extends h70.b> b() {
        return new RoomCloseWidget();
    }

    public i() {
    }

    @Override // j70.d
    public final boolean B(h70.b r5) {
        d90.a r6 = (d90.a) r5;
        Intrinsics.checkNotNullParameter(r6, "layerContext");
        RoomContext r0 = r6.b();
        boolean r1 = true;
        if (r0 == null) goto L12;
        n r2 = r0.getExternalConfigJudger();
        if (r2 == null) goto L12;
        IExternalConfigJudger r3 = (IExternalConfigJudger) r2.getValue();
        if (r3 == null) goto L12;
        if (r3.disableUserLeave() != true) goto L12;
        return false;
    L12:
        if (d90.c.i(r6) == true) goto L14;
    L24:
        r1 = false;
    L26:
        return r1;
    L14:
        if (jr1.b.a(r6) == true) goto L24;
        z70.b r4 = r6.a;
        if (r4 == null) goto L24;
        r6.f.getClass();
        if (r4.d(d90.d.a.A2) != true) goto L24;
        z70.b r7 = r6.a;
        if (r7 == null) goto L24;
        r6.f.getClass();
        if (r7.d(d90.d.a.z2) != true) goto L24;
        goto L24
    }

    @Override // j70.d
    public final j70.f C(h70.b r2) {
        d90.a r3 = (d90.a) r2;
        Intrinsics.checkNotNullParameter(r3, "layerContext");
        r3.f.getClass();
        return d90.d.a.y2;
    }

    @Override // j70.d
    public final LayerIndex E(h70.b r2) {
        Intrinsics.checkNotNullParameter((d90.a) r2, "layerContext");
        return LayerIndex.INDEX_2;
    }

    @Override // j70.h
    public final double H(h70.b r3) {
        Intrinsics.checkNotNullParameter((d90.a) r3, "layerContext");
        return 0.1d;
    }

    @Override // j70.h
    public final ElementConstraint J(h70.b r7) {
        final d90.a r8 = (d90.a) r7;
        Intrinsics.checkNotNullParameter(r8, "layerContext");
        final Ref.FloatRef r0 = new Ref.FloatRef();
        r0.element = 8.0f;
        if (LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue().getEnable() == false) goto L7;
        if (FoldScreenUtils.e() == false) goto L7;
    L9:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L16;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L16;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L16;
        r0.element = UtilityKotlinExtentionsKt.j(StatusBarUtil.getStatusBarHeight(r8.getContext())) + 8.0f;
    L16:
        if (e5.l() == true) goto L18;
    L22:
        RoomContext r2 = r8.b();
        if (r2 == null) goto L53;
        n r3 = r2.getExternalConfigJudger();
        if (r3 == null) goto L53;
        IExternalConfigJudger r4 = (IExternalConfigJudger) r3.getValue();
        if (r4 == null) goto L53;
        if (r4.isInExternalMode() != true) goto L53;
        RoomContext r5 = r8.b();
        if (r5 == null) goto L39;
        n r6 = r5.getExternalConfigJudger();
        if (r6 == null) goto L39;
        IExternalConfigJudger r9 = (IExternalConfigJudger) r6.getValue();
        if (r9 == null) goto L39;
        ViewConfig r11 = IExternalConfigJudger.DefaultImpls.getInteractionViewConfig$default(r9, true, null, 2, null);
        if (r11 == null) goto L39;
        int r12 = r11.getMarginTop();
    L40:
        if (r12 <= 0) goto L53;
        RoomContext r13 = r8.b();
        if (r13 == null) goto L50;
        n r14 = r13.getExternalConfigJudger();
        if (r14 == null) goto L50;
        IExternalConfigJudger r15 = (IExternalConfigJudger) r14.getValue();
        if (r15 == null) goto L50;
        ViewConfig r16 = IExternalConfigJudger.DefaultImpls.getInteractionViewConfig$default(r15, true, null, 2, null);
        if (r16 == null) goto L50;
        float r17 = UtilityKotlinExtentionsKt.j(r16.getMarginTop());
    L51:
        r0.element = r17 + 8.0f;
    L50:
        r17 = 0.0f;
    L39:
        r12 = 0;
    L53:
        return I(new RoomCloseWidgetDescriptor$generateConstraint$1(r0, r8));
    L18:
        if (PadConfigUtils.d() == true) goto L20;
    L21:
        r0.element = 8.0f;
        goto L22
    L20:
        if (((Boolean) ey0.a.getValue()).booleanValue() == false) goto L22;
    L7:
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == false) goto L22;
        goto L22
    }
}
