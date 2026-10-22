package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.LiveStickerSelectDialogFactory;
import com.bytedance.android.live.effect.sticker.ui.aigc.AigcTaskPanel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerAigcViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public u(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r8) {
        Sticker r9 = (Sticker) r8;
        LiveStickerDialogV2 r0 = this.a;
        int r1 = LiveStickerDialogV2.y;
        r0.Z90();
        StickerAigcViewModel r2 = r0.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L5:
        r2.hideAigcHint();
        StickerAigcViewModel r3 = r0.j;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L8:
        r3.clearAigcStickerRenderCache();
        if (r9 != null) goto L11;
    L34:
        View r4 = r0.getView();
        if (r4 == null) goto L39;
        AigcTaskPanel r5 = (AigcTaskPanel) r4.findViewById(2131362448);
        if (r5 == null) goto L39;
        r5.setCurrentEffectID(0);
        r5.t = null;
    L39:
        StickerAigcViewModel r6 = r0.j;
        if (r6 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L42:
        r6.updateAigcTaskPanelStatus(r9);
        return;
    L11:
        if (r9.isAigcSticker() != true) goto L34;
        View r7 = r0.getView();
        if (r7 == null) goto L17;
        AigcTaskPanel r11 = (AigcTaskPanel) r7.findViewById(2131362448);
        if (r11 == null) goto L17;
        r11.reset();
        r11.setCurrentEffectID(r9.getId());
        r11.setKeywordList(CollectionsKt.toList(r9.getAigcEffectInfo().getKeywordInfoMap().keySet()));
    L17:
        StickerAigcViewModel r12 = r0.j;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("stickerAigcViewModel");
    L20:
        r12.updateAigcTaskPanelStatus(r9);
        LiveEffectScene r13 = r0.q;
        if (r13 != LiveEffectScene.Preview) goto L44;
        int r14 = LiveStickerSelectDialogFactory.a;
        Intrinsics.checkNotNullParameter(r13, "liveEffectScene");
        m90.c<Boolean> r15 = m90.b.E;
        if (r15.c(r0.p).booleanValue() == true) goto L45;
        Intrinsics.checkNotNullParameter(r0.q, "liveEffectScene");
        r15.e(r0.p, Boolean.TRUE);
        long r16 = System.currentTimeMillis();
        View r17 = r0.getView();
        if (r17 == null) goto L46;
        View r18 = r17.findViewById(2131362447);
        if (r18 == null) goto L47;
        r18.setVisibility(0);
        AbstractDraweeController r19 = Fresco.newDraweeControllerBuilder().setUri("https://lf9-webcastcdn-tos.douyinstatic.com/obj/live-android/live_aigc_teachingvideo.webp").setAutoPlayAnimations(true).build();
        SimpleDraweeView r21 = r18.findViewById(2131385276);
        if (r21 == null) goto L31;
        r21.setController(r19);
    L31:
        TextView r22 = (TextView) r18.findViewById(2131364839);
        if (r22 == null) goto L48;
        r22.setOnClickListener(new a0(r0, r9, r16));
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    }
}
