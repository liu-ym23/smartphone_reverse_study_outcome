package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAddCartGuideInfo;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SkuPanelGroupOptimizePresenter$initViews$2 implements View.OnClickListener {
    public final /* synthetic */ m2 a;

    public SkuPanelGroupOptimizePresenter$initViews$2(m2 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(final View r27) {
        SkuInfoVO r1 = (SkuInfoVO) m2.d0(this.a).getSkuInfo().a();
        Object r10 = null;
        if (r1 == null) goto L5;
        final SkuAddCartGuideInfo r11 = r1.getAddCartGuideInfo();
    L6:
        m2 r12 = this.a;
        com.bytedance.android.ec.common.impl.sku.view.f r13 = r12.g;
        if (r13 != null) goto L9;
    L10:
        List<String> r14 = m2.d0(r12).getCheckedIdArray();
        if (r14 == null) goto L22;
        Iterator<T> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L21;
        Object r16 = r15.next();
        if (((String) r16) != null) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L14;
        r10 = r16;
        goto L21
    L18:
        r17 = false;
    L21:
        r10 = (String) r10;
    L22:
        if (r10 == null) goto L24;
    L60:
        m2.d0(this.a).setLastBehaviorBeforeDismiss("click");
        m2.d0(this.a).closeDialogFragment(1);
        return;
    L24:
        if (Intrinsics.areEqual(m2.d0(this.a).getCanAddCart(), Boolean.TRUE) == false) goto L60;
        if (r11 == null) goto L60;
        if (r11.showInSku((Long) m2.d0(this.a).m1027getCurrentCount().a()) != true) goto L60;
        m2 r18 = this.a;
        if (r18.g != null) goto L31;
        r18.g = new com.bytedance.android.ec.common.impl.sku.view.f(r27);
    L31:
        com.bytedance.android.ec.common.impl.sku.view.f r19 = this.a.g;
        if (r19 == null) goto L34;
        r19.b(r27, r11.getGuideText(), new SkuPanelGroupOptimizePresenter$initViews$2$$special$$inlined$apply$lambda$1(this, r27, r11), new SkuPanelGroupOptimizePresenter$initViews$2$$special$$inlined$apply$lambda$2(this, r27, r11), new SkuPanelGroupOptimizePresenter$initViews$2$$special$$inlined$apply$lambda$3(this, r27, r11));
    L34:
        m2 r20 = this.a;
        Map<String, String> r21 = r11.getTrackMeta();
        if (r21 != null) goto L37;
        r21 = MapsKt.emptyMap();
    L37:
        SkuViewModel r22 = r20.f;
        if (r22 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        SpreadBuilder r23 = new SpreadBuilder(2);
        r23.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "sku"));
        ArrayList r110 = new ArrayList(r21.size());
        Iterator<Map.Entry<String, String>> r111 = r21.entrySet().iterator();
    L42:
        if (r111.hasNext() == false) goto L44;
        Map.Entry<String, String> r112 = r111.next();
        r110.add(new Pair(r112.getKey(), r112.getValue()));
        goto L42
    L44:
        Object[] r113 = r110.toArray(new Pair[0]);
        if (r113 == null) goto L59;
        r23.addSpread(r113);
        SkuViewModel.doSkuEventAction$default(r22, "sku_panel_module_show", (Pair[]) r23.toArray(new Pair[r23.size()]), null, null, null, 28, null);
        SkuViewModel r24 = r20.f;
        if (r24 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        SpreadBuilder r25 = new SpreadBuilder(2);
        r25.add(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, "sku"));
        ArrayList r26 = new ArrayList(r21.size());
        Iterator<Map.Entry<String, String>> r28 = r21.entrySet().iterator();
    L51:
        if (r28.hasNext() == false) goto L53;
        Map.Entry<String, String> r29 = r28.next();
        r26.add(new Pair(r29.getKey(), r29.getValue()));
        goto L51
    L53:
        Object[] r30 = r26.toArray(new Pair[0]);
        if (r30 == null) goto L57;
        r25.addSpread(r30);
        SkuViewModel.doSkuEventAction$default(r24, "show_add_to_cart", (Pair[]) r25.toArray(new Pair[r25.size()]), "a1.b5267.c91096.d045550", PageFinder.via(((QFragmentPresenter) r20).e), null, 16, null);
        return;
    L57:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L59:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L9:
        if (r13.a == true) goto L60;
    L5:
        r11 = null;
        goto L6
    }
}
