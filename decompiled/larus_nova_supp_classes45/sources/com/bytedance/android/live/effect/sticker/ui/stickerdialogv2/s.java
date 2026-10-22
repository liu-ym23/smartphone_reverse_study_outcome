package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.effect.base.LiveEffectPagerSlidingTabStrip;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDataViewModel;
import com.bytedance.android.live.effect.sticker.viewmodel.StickerDialogUIViewModel;
import com.bytedance.android.live.uikit.rtl.RtlViewPager;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s<T> implements Observer {
    public final /* synthetic */ LiveStickerDialogV2 a;

    public s(LiveStickerDialogV2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        List r6 = (List) r5;
        LiveStickerDialogV2 r0 = this.a;
        StickerDialogUIViewModel r1 = r0.g;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDialogUIViewModel");
    L5:
        com.bytedance.android.live.effect.base.f r2 = r1.getShowTraceInfo();
        r2.j = System.currentTimeMillis();
        if (r0.l != null) goto L8;
        r0.W90();
    L8:
        LiveStickerDialogViewPagerAdapter r3 = r0.l;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNullParameter(r6, "tabList");
        ((ArrayList) r3.a).clear();
        ArrayList r4 = (ArrayList) r3.a;
        r4.addAll(r6);
        r3.notifyDataSetChanged();
    L11:
        View r7 = r0.getView();
        if (r7 == null) goto L16;
        LiveEffectPagerSlidingTabStrip r8 = (LiveEffectPagerSlidingTabStrip) r7.findViewById(2131388052);
        if (r8 == null) goto L16;
        r8.d();
    L16:
        View r9 = r0.getView();
        if (r9 == null) goto L25;
        RtlViewPager r11 = r9.findViewById(2131387348);
        if (r11 == null) goto L26;
        StickerDataViewModel r12 = r0.f;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("stickerDataViewModel");
    L23:
        r11.setCurrentItem(r12.getTabPositionByTabKey(r0.V90().a));
        return;
    L26:
        return;
    }
}
