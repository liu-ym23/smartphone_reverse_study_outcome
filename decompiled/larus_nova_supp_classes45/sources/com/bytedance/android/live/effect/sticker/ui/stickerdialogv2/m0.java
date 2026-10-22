package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.sticker.ui.StickerSearchBox;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerSearchViewModel;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.widget.FlowLayout;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m0 extends com.bytedance.android.live.effect.sticker.ui.k {
    public final /* synthetic */ StickerSearchPageView a;

    public m0(StickerSearchPageView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.j
    public final void c(boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r12, "newContent");
        if (r11 == false) goto L25;
        LoadingStatusView r13 = StickerSearchPageView.R5(this.a);
        if (r13 == null) goto L7;
        r13.reset();
    L7:
        TextView r14 = StickerSearchPageView.U5(this.a);
        if (r14 == null) goto L10;
        r14.setVisibility(8);
    L10:
        RecyclerView r15 = StickerSearchPageView.Y5(this.a);
        if (r15 == null) goto L13;
        r15.setVisibility(4);
    L13:
        LiveStickerDialogListAdapter r16 = this.a.p;
        if (r16 == null) goto L16;
        r16.y2(CollectionsKt.emptyList());
    L16:
        StickerSearchViewModel r17 = this.a.n;
        if (r17 == null) goto L19;
        r17.resetSearchStatus();
    L19:
        TextView r18 = StickerSearchPageView.V5(this.a);
        if (r18 == null) goto L22;
        r18.setVisibility(0);
    L22:
        FlowLayout r19 = StickerSearchPageView.S5(this.a);
        if (r19 == null) goto L49;
        r19.setVisibility(0);
    L49:
        StickerSearchViewModel r110 = this.a.n;
        if (r110 == null) goto L53;
        r110.updateSearchContent(r12);
        return;
    L53:
        return;
    L25:
        StickerSearchPageView r111 = this.a;
        boolean r5 = r111.q;
        if (r5 == false) goto L28;
        r111.q = false;
    L28:
        int r6 = r111.r + 1;
        r111.r = r6;
        TextView r112 = StickerSearchPageView.U5(r111);
        if (r112 == null) goto L31;
        r112.setVisibility(8);
    L31:
        RecyclerView r113 = StickerSearchPageView.Y5(this.a);
        if (r113 == null) goto L34;
        r113.setVisibility(4);
    L34:
        LoadingStatusView r114 = StickerSearchPageView.R5(this.a);
        if (r114 == null) goto L37;
        r114.showLoading();
    L37:
        long r7 = System.currentTimeMillis();
        StickerSearchBox r115 = StickerSearchPageView.T5(this.a);
        if (r115 == null) goto L40;
        r115.U5(true);
    L40:
        StickerSearchViewModel r116 = this.a.n;
        if (r116 == null) goto L43;
        r116.doSearchSticker(r12, new StickerSearchViewModel.b(r12, r5, r6, r7));
    L43:
        TextView r117 = StickerSearchPageView.V5(this.a);
        if (r117 == null) goto L46;
        r117.setVisibility(4);
    L46:
        FlowLayout r118 = StickerSearchPageView.S5(this.a);
        if (r118 == null) goto L49;
        r118.setVisibility(4);
        goto L49
    }
}
