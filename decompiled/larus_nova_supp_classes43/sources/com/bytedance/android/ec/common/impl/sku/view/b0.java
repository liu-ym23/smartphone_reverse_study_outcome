package com.bytedance.android.ec.common.impl.sku.view;

import android.view.View;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.core.gallery2.GalleryViewer;
import com.bytedance.android.ec.core.gallery2.TitleIndicator;
import com.bytedance.android.ec.core.gallery2.opt.GalleryViewerV2;
import com.bytedance.android.ec.core.gallery2.opt.ScrollTitleIndicator;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b0 implements View.OnClickListener {
    public final /* synthetic */ SpecItemOptimizeView a;

    public static final class a implements OnDismissListener {
        public final /* synthetic */ List a;
        public final /* synthetic */ b0 b;

        public final void onDismiss(int r10) {
            Function1<? super Integer, Unit> r0 = this.b.a.q;
            if (r0 == null) goto L6;
            Unit r11 = (Unit) r0.invoke(Integer.valueOf(r10));
            return;
        }

        public a(List r1, b0 r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    public b0(SpecItemOptimizeView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        SkuViewModel r11 = this.a.o;
        if (r11 == null) goto L51;
        List<String> r12 = r11.getImageList();
        if (r12 == null) goto L51;
        ArrayList r13 = null;
        if ((!r12.isEmpty()) == true) goto L10;
        r12 = null;
    L10:
        if (r12 == null) goto L51;
        List<String> r14 = r12;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L13:
        if (r15.hasNext() == false) goto L28;
        String r16 = (String) r15.next();
        if (r16 != null) goto L26;
        SkuViewModel r17 = this.a.o;
        if (r17 == null) goto L23;
        QLiveData<SkuInfoVO> r18 = r17.getSkuInfo();
        if (r18 == null) goto L23;
        SkuInfoVO r19 = (SkuInfoVO) r18.a();
        if (r19 == null) goto L23;
        r16 = r19.getBigCover();
    L24:
        if (r16 != null) goto L26;
        r16 = "";
    L23:
        r16 = null;
    L26:
        r1.add(r16);
        goto L13
    L28:
        if ((!r1.isEmpty()) == false) goto L30;
        r13 = r1;
    L30:
        if (r13 == null) goto L51;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r20 = r13.iterator();
    L33:
        if (r20.hasNext() == false) goto L36;
        String r21 = (String) r20.next();
        com.bytedance.android.ec.model.k r22 = new com.bytedance.android.ec.model.k();
        r22.b = r21;
        r110.add(r22);
        goto L33
    L36:
        if (com.bytedance.android.ec.core.abtest.d.k() == false) goto L44;
        GalleryViewerV2 r23 = new GalleryViewerV2(this.a.getContext(), null, false, null, 30);
        r23.a(r110);
        ScrollTitleIndicator r24 = r23.b;
        SkuViewModel r25 = this.a.o;
        if (r25 == null) goto L42;
        List<String> r26 = r25.getNameList();
        if (r26 == null) goto L42;
    L43:
        r24.setData(new LinkedList(r26));
        r23.setOnDismissListener(new a(r110, this));
        r23.setOnPageSelectedListener(r23.getOnPageSelectedListener());
        r23.show(SpecItemOptimizeView.R5(this.a));
    L42:
        r26 = CollectionsKt.emptyList();
        goto L43
    L44:
        GalleryViewer r27 = new GalleryViewer(this.a.getContext());
        r27.a(r110);
        TitleIndicator r111 = r27.b;
        SkuViewModel r28 = this.a.o;
        if (r28 == null) goto L49;
        List<String> r29 = r28.getNameList();
        if (r29 == null) goto L49;
    L50:
        r111.setData(new LinkedList(r29));
        r27.setOnPageSelectedListener(r27.getOnPageSelectedListener());
        r27.show(SpecItemOptimizeView.R5(this.a));
    L49:
        r29 = CollectionsKt.emptyList();
    L51:
        SkuViewModel r30 = this.a.o;
        if (r30 == null) goto L60;
        SkuViewModel.doSkuEventAction$default(r30, "sku_panel_module_click", new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_MODULE_NAME, "big_pic_choose")}, null, null, null, 28, null);
        return;
    }
}
