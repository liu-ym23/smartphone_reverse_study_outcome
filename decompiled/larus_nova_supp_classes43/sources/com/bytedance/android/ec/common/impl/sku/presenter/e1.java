package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.gallery2.GalleryViewer;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e1 implements View.OnClickListener {
    public final /* synthetic */ f1 a;

    public static final class a implements OnPageSelectedListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ e1 b;
        public final /* synthetic */ View c;

        public final void onPageSelected(int r10) {
            SkuViewModel.doSkuEventAction$default(f1.e0(this.b.a), "slide_product_big_picture", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ITEM_ORDER, String.valueOf(r10 + 1))}, null, null, null, 28, null);
        }

        public a(List r1, e1 r10, View r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public e1(f1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        int r0 = qf.a.a;
        ArrayList r1 = null;
        if (qf.a.e.a(f1.e0(this.a).getSkuParams()) == true) goto L5;
        List<String> r10 = f1.e0(this.a).getImageList();
    L12:
        if (r10 == null) goto L39;
        List<String> r11 = r10;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r14 = r11.iterator();
    L15:
        if (r14.hasNext() == false) goto L26;
        String r15 = (String) r14.next();
        if (r15 != null) goto L24;
        SkuInfoVO r16 = (SkuInfoVO) f1.e0(this.a).getSkuInfo().a();
        if (r16 == null) goto L21;
        r15 = r16.getBigCover();
    L22:
        if (r15 != null) goto L24;
        r15 = "";
        goto L24
    L21:
        r15 = null;
    L24:
        r13.add(r15);
        goto L15
    L26:
        if ((!r13.isEmpty()) == false) goto L28;
        r1 = r13;
    L28:
        if (r1 == null) goto L39;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r18 = r1.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        String r19 = (String) r18.next();
        com.bytedance.android.ec.model.k r20 = new com.bytedance.android.ec.model.k();
        r20.b = r19;
        r17.add(r20);
        goto L31
    L33:
        GalleryViewer r21 = new GalleryViewer(this.a.Y().c());
        r21.a(r17);
        TitleIndicator r22 = r21.b;
        int r23 = qf.a.a;
        if (qf.a.e.a(f1.e0(this.a).getSkuParams()) == true) goto L36;
        LinkedList r24 = new LinkedList(f1.e0(this.a).getNameList());
    L37:
        r22.setData(r24);
        r21.setOnPageSelectedListener(new a(r17, this, r12));
        r21.showAnimated(f1.e0(this.a).getCurrentPos(), r12);
        SkuViewModel.doSkuEventAction$default(f1.e0(this.a), "click_product_infolayer_picture", new Pair[0], null, null, null, 28, null);
        goto L39
    L36:
        r24 = new LinkedList(f1.e0(this.a).getNameListSpec());
    L39:
        if (f1.e0(this.a).getSkuParams().isFromSuperMarket() == false) goto L47;
        f1.e0(this.a).doEventAction("market_click_product_params_picture", new Pair[0]);
        return;
    L47:
        return;
    L5:
        r10 = f1.e0(this.a).getBigImageUrlList();
        if ((!r10.isEmpty()) == true) goto L9;
        r10 = null;
    L9:
        if (r10 != null) goto L12;
        r10 = f1.e0(this.a).getImageUrlList();
        goto L12
    }
}
