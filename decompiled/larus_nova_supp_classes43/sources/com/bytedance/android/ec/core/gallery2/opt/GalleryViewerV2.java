package com.bytedance.android.ec.core.gallery2.opt;

import android.content.Context;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/opt/GalleryViewerV2;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryViewerV2 extends PhotoViewerDialog implements TransitionListener {
    public final d a;
    public final ScrollTitleIndicator b;
    public final GalleryAdapterV2 c;

    public final void onPageSelected(int r1) {
    }

    public final void onTransitionBegin(int r1) {
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    public final void onTransitionEnd(int r1) {
    }

    public final void a(List<? extends l> r10) {
        Intrinsics.checkNotNullParameter(r10, "medias");
        this.c.a = r10;
        this.a.setCount(((ArrayList) r10).size());
    }

    public GalleryViewerV2(Context r10, b r11, boolean r12, String r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L11;
        GalleryAdapterV2 r0 = new GalleryAdapterV2();
    L13:
        if ((r14 & 16) == 0) goto L15;
        r13 = null;
    L15:
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r0, "galleyAdapter");
        super(r10, r0);
        this.c = r0;
        r0.addTransitionListener(this);
        d r15 = new d(r10, r12, r13, r11);
        r15.setOnBackPressListener(new GalleryViewerV2$$special$$inlined$apply$lambda$1(this));
        Unit r16 = Unit.INSTANCE;
        this.a = r15;
        ScrollTitleIndicator r17 = new ScrollTitleIndicator(r10, null, 6, 0);
        this.b = r17;
        r0.setOnScrollListener(new AnonymousClass2(this));
        addIndicatorView(r15);
        addIndicatorView(r17);
        return;
    L11:
        r0 = null;
        goto L13
    }
}
