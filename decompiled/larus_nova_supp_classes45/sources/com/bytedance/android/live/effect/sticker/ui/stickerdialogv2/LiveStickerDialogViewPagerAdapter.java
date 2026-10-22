package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.live.effect.sticker.ui.SpecialTabType;
import com.bytedance.android.live.uikit.viewpager.AbsPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/stickerdialogv2/LiveStickerDialogViewPagerAdapter;", "Lcom/bytedance/android/live/uikit/viewpager/AbsPagerAdapter;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerDialogViewPagerAdapter extends AbsPagerAdapter {
    public final List<EffectCategoryModel> a;
    public WeakReference<View> b;
    public final Map<String, WeakReference<StickerNormalTabView>> c;
    public final Map<String, WeakReference<StickerMultiCategoryTabView>> d;
    public final WeakReference<LifecycleOwner> e;
    public final LiveEffectContextFactoryDelegate$Type f;
    public final LiveEffectScene g;
    public final boolean h;
    public final boolean i;
    public final String j;

    public final int getItemPosition(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        return -2;
    }

    public final int getCount() {
        return ((ArrayList) this.a).size();
    }

    public final CharSequence getPageTitle(int r2) {
        if (r2 < ((ArrayList) this.a).size()) goto L7;
        return null;
    L7:
        return ((EffectCategoryModel) ListProtector.get(this.a, r2)).getName();
    }

    public final View getView(int r12, View r13, ViewGroup r14) {
        if (Intrinsics.areEqual(getPageTitle(r12), s1.B(2131916354)) == false) goto L12;
        WeakReference<View> r15 = this.b;
        if (r15 == null) goto L7;
        View r16 = r15.get();
    L8:
        if (r16 != null) goto L37;
        ConstraintLayout r17 = new StickerSearchTabView(((AbsPagerAdapter) this).mContext, this.f, this.g, this.e);
        this.b = new WeakReference(r17);
        return r17;
    L37:
        return r16;
    L7:
        r16 = null;
        goto L8
    L12:
        if (this.h == false) goto L16;
        boolean r18 = true;
        if ((!((EffectCategoryModel) ListProtector.get(this.a, r12)).getChildren_categories().isEmpty()) == false) goto L16;
    L17:
        String r0 = "";
        if (r18 == false) goto L24;
        String r19 = ((EffectCategoryModel) ListProtector.get(this.a, r12)).getKey();
        List r7 = ((EffectCategoryModel) ListProtector.get(this.a, r12)).getChildren_categories();
        Context r2 = ((AbsPagerAdapter) this).mContext;
        LiveEffectContextFactoryDelegate$Type r3 = this.f;
        LiveEffectScene r4 = this.g;
        WeakReference<LifecycleOwner> r5 = this.e;
        if (Intrinsics.areEqual(r19, SpecialTabType.FAVORITE.getTabKey()) == false) goto L22;
        r0 = s1.B(2131916344);
    L22:
        ConstraintLayout r110 = new StickerMultiCategoryTabView(r2, r3, r4, r5, r19, r7, r0);
        this.d.put(r19, new WeakReference(r110));
        return r110;
    L24:
        String r111 = ((EffectCategoryModel) ListProtector.get(this.a, r12)).getKey();
        Context r6 = ((AbsPagerAdapter) this).mContext;
        LiveEffectContextFactoryDelegate$Type r8 = this.f;
        LiveEffectScene r9 = this.g;
        WeakReference<LifecycleOwner> r11 = this.e;
        SpecialTabType r1 = SpecialTabType.FAVORITE;
        if (Intrinsics.areEqual(r111, r1.getTabKey()) == false) goto L29;
        StickerNormalTabDataSourceType r21 = StickerNormalTabDataSourceType.Favorite;
    L27:
        StickerNormalTabDataSourceType r22 = r21;
        if (Intrinsics.areEqual(r111, r1.getTabKey()) == false) goto L35;
        r0 = s1.B(2131916344);
    L35:
        ConstraintLayout r112 = new StickerNormalTabView(r6, r8, r9, r11, r111, r22, r0, this.i, this.j);
        this.c.put(r111, new WeakReference(r112));
        return r112;
    L29:
        if (Intrinsics.areEqual(r111, SpecialTabType.CAMPAIGN.getTabKey()) == false) goto L31;
        r21 = StickerNormalTabDataSourceType.Campaign;
        goto L27
    L31:
        r21 = StickerNormalTabDataSourceType.Normal;
    L16:
        r18 = false;
        goto L17
    }

    public LiveStickerDialogViewPagerAdapter(Context r2, WeakReference<LifecycleOwner> r3, LiveEffectContextFactoryDelegate$Type r4, LiveEffectScene r5, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "type");
        Intrinsics.checkNotNullParameter(r5, "scene");
        Intrinsics.checkNotNullParameter(r8, "parentTabKey");
        super(r2, LayoutInflater.from(r2));
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
        this.a = new ArrayList();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }
}
