package com.bytedance.android.ec.common.impl.sku.presenter;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.gallery2.GalleryViewer;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ec.core.gallery2.opt.GalleryViewerV2;
import com.bytedance.android.ec.core.gallery2.opt.ScrollTitleIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r0 implements View.OnClickListener {
    public final /* synthetic */ s0 a;

    public static final class a implements OnPageSelectedListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ r0 b;

        public final void onPageSelected(int r10) {
            SkuViewModel.doSkuEventAction$default(s0.e0(this.b.a), "slide_product_big_picture", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ITEM_ORDER, String.valueOf(r10 + 1))}, null, null, null, 28, null);
        }

        public a(List r1, r0 r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class b implements OnDismissListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ r0 b;

        public final void onDismiss(int r10) {
            if (this.a.size() <= 1) goto L6;
            s0.e0(this.b.a).getImageSpecSelectIndex().g(Integer.valueOf(r10));
            return;
        }

        public b(List r1, r0 r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public static final class c implements OnPageSelectedListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ r0 b;

        public final void onPageSelected(int r10) {
            SkuViewModel.doSkuEventAction$default(s0.e0(this.b.a), "slide_product_big_picture", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTER_METHOD_PIC, "product_infolayer"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ITEM_ORDER, String.valueOf(r10 + 1))}, null, null, null, 28, null);
        }

        public c(List r1, r0 r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public r0(s0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        int r12 = qf.a.a;
        ArrayList r0 = null;
        if (qf.a.e.a(s0.e0(this.a).getSkuParams()) == true) goto L5;
        List<String> r13 = s0.e0(this.a).getImageList();
    L12:
        if (r13 == null) goto L47;
        List<String> r14 = r13;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L26;
        String r16 = (String) r15.next();
        if (r16 != null) goto L24;
        SkuInfoVO r17 = (SkuInfoVO) s0.e0(this.a).getSkuInfo().a();
        if (r17 == null) goto L21;
        r16 = r17.getBigCover();
    L22:
        if (r16 != null) goto L24;
        r16 = "";
        goto L24
    L21:
        r16 = null;
    L24:
        r10.add(r16);
        goto L15
    L26:
        if ((!r10.isEmpty()) == false) goto L28;
        r0 = r10;
    L28:
        if (r0 == null) goto L47;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L31:
        if (r1.hasNext() == false) goto L34;
        String r19 = (String) r1.next();
        com.bytedance.android.ec.model.k r20 = new com.bytedance.android.ec.model.k();
        r20.b = r19;
        r18.add(r20);
        goto L31
    L34:
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L40;
        GalleryViewerV2 r21 = new GalleryViewerV2(this.a.Y().c(), null, false, null, 30);
        r21.a(r18);
        ScrollTitleIndicator r22 = r21.b;
        int r23 = qf.a.a;
        if (qf.a.e.a(s0.e0(this.a).getSkuParams()) == true) goto L38;
        LinkedList r24 = new LinkedList(s0.e0(this.a).getNameList());
    L39:
        r22.setData(r24);
        r21.setOnPageSelectedListener(new a(r18, this));
        r21.setOnDismissListener(new b(r18, this));
        r21.show(s0.e0(this.a).getCurrentPos());
    L45:
        SkuViewModel.doSkuEventAction$default(s0.e0(this.a), "click_product_infolayer_picture", new Pair[0], null, null, null, 28, null);
        goto L47
    L38:
        r24 = new LinkedList(s0.e0(this.a).getNameListSpec());
        goto L39
    L40:
        GalleryViewer r25 = new GalleryViewer(this.a.Y().c());
        r25.a(r18);
        TitleIndicator r26 = r25.b;
        int r27 = qf.a.a;
        if (qf.a.e.a(s0.e0(this.a).getSkuParams()) == true) goto L43;
        LinkedList r28 = new LinkedList(s0.e0(this.a).getNameList());
    L44:
        r26.setData(r28);
        r25.setOnPageSelectedListener(new c(r18, this));
        r25.show(s0.e0(this.a).getCurrentPos());
        goto L45
    L43:
        r28 = new LinkedList(s0.e0(this.a).getNameListSpec());
    L47:
        if (s0.e0(this.a).getSkuParams().isFromSuperMarket() == false) goto L55;
        s0.e0(this.a).doEventAction("market_click_product_params_picture", new Pair[0]);
        return;
    L55:
        return;
    L5:
        r13 = s0.e0(this.a).getBigImageUrlList();
        if ((!r13.isEmpty()) == true) goto L9;
        r13 = null;
    L9:
        if (r13 != null) goto L12;
        r13 = s0.e0(this.a).getImageUrlList();
        goto L12
    }
}
