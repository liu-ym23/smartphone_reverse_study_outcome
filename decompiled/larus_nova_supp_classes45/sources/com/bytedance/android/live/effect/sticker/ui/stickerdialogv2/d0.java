package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.StickerPanelIntroductionPage;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements View.OnClickListener {
    public final /* synthetic */ LiveStickerDialogV2 a;
    public final /* synthetic */ Sticker b;
    public final /* synthetic */ Ref.ObjectRef c;

    public d0(LiveStickerDialogV2 r1, Sticker r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Type inference failed for: r6v20, types: [android.view.ViewGroup, com.bytedance.android.live.effect.sticker.ui.StickerPanelIntroductionPage] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        boolean r0 = false;
        if (r2.a(((Sticker.EffectTipsInfo) this.c.element).getJumpUrl()) == false) goto L22;
        View r7 = this.a.getView();
        if (r7 == null) goto L22;
        Context r8 = r7.getContext();
        if (r8 == null) goto L22;
        StickerDialogUIViewModel r2 = this.a.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L11:
        r2.onClickHint(r8, ((Sticker.EffectTipsInfo) this.c.element).getJumpUrl(), this.b);
        List<String> r9 = com.bytedance.android.live.effect.utils.q.a;
        Sticker r11 = this.b;
        LiveEffectScene r3 = this.a.q;
        Intrinsics.checkNotNullParameter(r3, "$this$isLiving");
        if (r3 != LiveEffectScene.Live) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        String r1 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L19:
        com.bytedance.android.live.effect.utils.q.d(r11, "click", r1);
        LiveStickerDialogV2.T90(this.a);
        return;
    L18:
        r1 = "0";
        goto L19
    L14:
        if (r3 != LiveEffectScene.GiftMenuLive) goto L16;
    L22:
        if ((!((Sticker.EffectTipsInfo) this.c.element).getSubTipList().isEmpty()) == false) goto L32;
        View r12 = this.a.getView();
        if (r12 == null) goto L28;
        ?? r13 = (StickerPanelIntroductionPage) r12.findViewById(2131375573);
        if (r13 == 0) goto L28;
        r13.setTitle(((Sticker.EffectTipsInfo) this.c.element).getTipTitle());
        r13.setIntroductionInfoList(((Sticker.EffectTipsInfo) this.c.element).getSubTipList());
        r13.setVisibility(0);
    L28:
        Sticker r14 = this.b;
        if (r14 == null) goto L33;
        List<String> r4 = com.bytedance.android.live.effect.utils.q.a;
        String r5 = this.a.q.getPage();
        Intrinsics.checkNotNullParameter(r14, "sticker");
        Intrinsics.checkNotNullParameter(r5, "eventPage");
        HashMap r15 = new HashMap();
        r15.put("sticker_id", String.valueOf(r14.getId()));
        r15.put("sticker_type", r14.getStickerType().getTypeName());
        com.bytedance.android.live.effect.utils.q.e("livesdk_interact_effect_instruction_show", r15, r5);
        return;
    L33:
        return;
    }
}
