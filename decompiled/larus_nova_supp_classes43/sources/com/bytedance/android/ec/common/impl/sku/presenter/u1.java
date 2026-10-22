package com.bytedance.android.ec.common.impl.sku.presenter;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SpecInfo;
import com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class u1<T> implements Observer {
    public final /* synthetic */ b2 a;

    public u1(b2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r10) {
        SkuInfoVO r1 = (SkuInfoVO) r10;
        if (r1 != null) goto L5;
        return;
    L5:
        if (b2.e0(this.a).getSkuPanelState() != null) goto L7;
        b2.e0(this.a).setSkuPanelState(new SkuRestoreState(r1.getSpecInfoList().size()));
    L7:
        SkuRestoreState r11 = b2.e0(this.a).getSkuPanelState();
        String[] r0 = null;
        if (r11 != null) goto L10;
    L34:
        Iterator<T> r12 = r1.getSpecInfoList().iterator();
        int r13 = 0;
    L36:
        if (r12.hasNext() == false) goto L55;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        if (Intrinsics.areEqual(((SpecInfo) r14).getHideSpec(), Boolean.TRUE) == false) goto L54;
        SkuRestoreState r16 = b2.e0(this.a).getSkuPanelState();
        if (r16 == null) goto L47;
        String[] r17 = r16.getSelectSkuKeys();
        if (r17 == null) goto L47;
        int r18 = r17.length;
    L48:
        if (r13 >= r18) goto L54;
        SkuRestoreState r19 = b2.e0(this.a).getSkuPanelState();
        if (r19 == null) goto L54;
        String[] r20 = r19.getSelectSkuKeys();
        if (r20 == null) goto L54;
        r20[r13] = null;
    L47:
        r18 = 0;
    L54:
        r13 = r15;
        goto L36
    L55:
        this.a.j0();
        SpecItemOptimizeGroupLayout r21 = b2.d0(this.a);
        SkuRestoreState r22 = b2.e0(this.a).getSkuPanelState();
        if (r22 == null) goto L58;
        r0 = r22.getSelectSkuKeys();
    L58:
        r21.d(r1, r0, b2.e0(this.a).getSkuParams().getSceneType(), b2.e0(this.a).getBaseParamsJson(), b2.e0(this.a), b2.e0(this.a).getSkuParams().getHeightPercent());
        b2.e0(this.a).setImageList(b2.d0(this.a).getImageUrlList());
        b2.e0(this.a).setNameList(b2.d0(this.a).getNameList());
        b2.e0(this.a).setFirstIdList(b2.d0(this.a).getFirstIdList());
        b2.h0(this.a, false);
        return;
    L10:
        if (ArraysKt.filterNotNull(r11.getSelectSkuKeys()).isEmpty() == true) goto L13;
        r11 = null;
    L13:
        if (r11 == null) goto L34;
        Iterator<T> r23 = r1.getSkuList().keySet().iterator();
    L16:
        if (r23.hasNext() == false) goto L34;
        String r24 = (String) r23.next();
        SkuItemInfoVO r25 = r1.getSkuList().get(r24);
        if (r25 == null) goto L20;
        String r26 = r25.getId();
    L21:
        SkuRestoreState r27 = b2.e0(this.a).getSkuPanelState();
        if (r27 == null) goto L24;
        String r28 = r27.getSelectedSkuId();
    L26:
        if (Intrinsics.areEqual(r26, r28) == false) goto L16;
        SkuRestoreState r29 = b2.e0(this.a).getSkuPanelState();
        if (r29 == null) goto L16;
        Object[] r30 = new Regex("_").split(r24, 0).toArray(new String[0]);
        if (r30 == null) goto L33;
        r29.setSelectSkuKeys((String[]) r30);
        goto L16
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L24:
        r28 = null;
        goto L26
    L20:
        r26 = null;
        goto L21
    }
}
