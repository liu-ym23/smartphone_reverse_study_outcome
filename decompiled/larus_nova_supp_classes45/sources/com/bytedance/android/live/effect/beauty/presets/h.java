package com.bytedance.android.live.effect.beauty.presets;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public h(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        LiveBeautyPresetsFragment r14 = this.a;
        int r0 = LiveBeautyPresetsFragment.C;
        r14.U90().B2(false);
        LiveBeautyPresetsFragment r15 = this.a;
        if (r15.v == true) goto L10;
        if ((!Intrinsics.areEqual(r15.T90().j(), "")) == false) goto L7;
        f2.c("先添加美化效果，才能保存为预设", 0);
        return;
    L7:
        f2.c("无法新增，已经达到数量上限", 0);
        return;
    L10:
        if (((ArrayList) r15.T90().a).size() < this.a.A.intValue()) goto L13;
        f2.c("无法新增，已经达到数量上限", 0);
        return;
    L13:
        LiveBeautyPresetsHelper r16 = this.a.T90();
        r16.getClass();
        String r7 = LiveBeautyPresetsHelper.m() + '_' + System.currentTimeMillis();
        Map<String, List<PresetEffect>> r11 = r16.f();
        int r1 = ((ArrayList) r16.a).size();
    L14:
        r1 = r1 + 1;
        Iterator r2 = ((ArrayList) r16.a).iterator();
    L16:
        if (r2.hasNext() == false) goto L20;
        Object r4 = r2.next();
        if (Intrinsics.areEqual(((BeautifyPreset) r4).getPresetName(), "预设" + r1) == false) goto L16;
    L21:
        if (r4 != null) goto L14;
        BeautifyPreset r3 = new BeautifyPreset(r7, "预设" + r1, m90.b.a.c(r16.i).booleanValue(), m90.b.j.c(r16.i).booleanValue(), r11);
        ListProtector.add(r16.a, 0, r3);
        r16.c = r3.getEffectsByPanel();
        r16.o();
        r16.p(r3.getPresetId());
        this.a.U90().A2(this.a.T90().a, PresetOperationType.ADD_PRESET, 0);
        this.a.X90(false);
        LiveBeautyPresetsFragment r17 = this.a;
        r17.W90(!Intrinsics.areEqual(r17.T90().j(), ""));
        TextView r18 = this.a.w;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("remindView");
    L26:
        r18.setVisibility(8);
        RecyclerView r19 = this.a.l;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L29:
        RecyclerView.LayoutManager r110 = r19.getLayoutManager();
        if (r110 == null) goto L32;
        r110.scrollToPosition(0);
    L32:
        BeautifyPreset r111 = (BeautifyPreset) ListProtector.get(this.a.T90().a, 0);
        Long r5 = LivePresetsLogger.a;
        LivePresetsLogger.a(r111.getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), r111.getEffectsByPanel()), LivePresetsLogger.BtnType.SAVE, null, 8);
        f2.c("已添加预设，长按可删除", 0);
        return;
    L20:
        r4 = null;
        goto L21
    }
}
