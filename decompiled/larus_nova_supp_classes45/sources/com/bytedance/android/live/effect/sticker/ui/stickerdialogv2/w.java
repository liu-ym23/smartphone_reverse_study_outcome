package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.StickerFavoriteView;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewStatus;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerPreviewViewModel;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public w(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r18) {
        Sticker r0 = (Sticker) r18;
        LiveStickerDialogV2 r2 = this.a;
        int r3 = LiveStickerDialogV2.y;
        View r4 = r2.getView();
        if (r4 == null) goto L10;
        StickerFavoriteView r5 = (StickerFavoriteView) r4.findViewById(2131372178);
        if (r5 == null) goto L10;
        StickerDataViewModel r6 = r2.f;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L9:
        r5.e(r0, r6.isFavoriteSticker(r0));
    L10:
        StickerPreviewViewModel r7 = r2.h;
        if (r7 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L13:
        com.bytedance.android.live.effect.sticker.viewmodel.f r8 = (com.bytedance.android.live.effect.sticker.viewmodel.f) r7.getPreviewStatusData().getValue();
        if (r8 == null) goto L16;
        StickerPreviewStatus r9 = r8.a;
    L17:
        boolean r11 = true;
        if (r9 != StickerPreviewStatus.Downgrade) goto L36;
        StickerPreviewViewModel r12 = r2.h;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("stickerPreviewViewModel");
    L22:
        com.bytedance.android.live.effect.sticker.viewmodel.f r13 = (com.bytedance.android.live.effect.sticker.viewmodel.f) r12.getPreviewStatusData().getValue();
        if (r13 == null) goto L27;
        Sticker r14 = r13.b;
        if (r14 == null) goto L27;
        Long r15 = Long.valueOf(r14.getId());
    L28:
        if (r0 == null) goto L30;
        Long r16 = Long.valueOf(r0.getId());
    L32:
        if (Intrinsics.areEqual(r15, r16) == false) goto L36;
        if (r2.q == LiveEffectScene.GiftMenuPreview) goto L36;
        boolean r17 = true;
    L37:
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = null;
        if (r17 == false) goto L40;
        r19.element = new Sticker.EffectTipsInfo(s1.B(2131916423), null, null, null, null, 30, null);
    L40:
        if (r0 == null) goto L43;
        Sticker.EffectTipsInfo r21 = r0.getEffectTipsInfo();
        if (r21 == null) goto L43;
    L44:
        r19.element = r21;
        if (r21 != null) goto L47;
    L88:
        View r1 = r2.getView();
        if (r1 == null) goto L93;
        View r22 = r1.findViewById(2131366909);
        if (r22 == null) goto L93;
        r22.setVisibility(8);
    L93:
        View r23 = r2.getView();
        if (r23 == null) goto L102;
        View r24 = r23.findViewById(2131387348);
        if (r24 == null) goto L103;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        r25.height = s1.f(273.0f);
        Unit r26 = Unit.INSTANCE;
        r24.setLayoutParams(r25);
        return;
    L103:
        return;
    L102:
        return;
    L47:
        if (r21.getTipText().length() != 0) goto L49;
        boolean r27 = true;
    L50:
        if (r27 == true) goto L88;
        View r28 = r2.getView();
        if (r28 == null) goto L57;
        TextView r29 = (TextView) r28.findViewById(2131388723);
        if (r29 == null) goto L57;
        r29.setText(((Sticker.EffectTipsInfo) r19.element).getTipText());
    L57:
        View r31 = r2.getView();
        if (r31 == null) goto L69;
        View r32 = r31.findViewById(2131388721);
        if (r32 == null) goto L69;
        if ((!((Sticker.EffectTipsInfo) r19.element).getSubTipList().isEmpty()) == false) goto L64;
    L67:
        int r33 = 0;
    L68:
        r32.setVisibility(r33);
        goto L69
    L64:
        if (r2.a(((Sticker.EffectTipsInfo) r19.element).getJumpUrl()) == true) goto L67;
        r33 = 4;
    L69:
        View r34 = r2.getView();
        if (r34 == null) goto L83;
        View r35 = r34.findViewById(2131366909);
        if (r35 == null) goto L83;
        List<String> r36 = com.bytedance.android.live.effect.utils.q.a;
        LiveEffectScene r37 = r2.q;
        Intrinsics.checkNotNullParameter(r37, "$this$isLiving");
        if (r37 != LiveEffectScene.Live) goto L76;
    L79:
        if (r11 == false) goto L81;
        String r38 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L82:
        com.bytedance.android.live.effect.utils.q.d(r0, "show", r38);
        r35.setVisibility(0);
        r35.setOnClickListener(new d0(r2, r0, r19));
        goto L83
    L81:
        r38 = "0";
        goto L82
    L76:
        if (r37 == LiveEffectScene.GiftMenuLive) goto L79;
        r11 = false;
    L83:
        View r39 = r2.getView();
        if (r39 == null) goto L99;
        View r41 = r39.findViewById(2131387348);
        if (r41 == null) goto L100;
        ViewGroup.LayoutParams r42 = r41.getLayoutParams();
        r42.height = s1.f(238.0f);
        Unit r43 = Unit.INSTANCE;
        r41.setLayoutParams(r42);
        return;
    L100:
        return;
    L99:
        return;
    L49:
        r27 = false;
    L43:
        r21 = (Sticker.EffectTipsInfo) r19.element;
        goto L44
    L30:
        r16 = null;
    L27:
        r15 = null;
    L36:
        r17 = false;
        goto L37
    L16:
        r9 = null;
        goto L17
    }
}
