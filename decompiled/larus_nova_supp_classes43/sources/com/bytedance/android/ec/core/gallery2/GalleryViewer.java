package com.bytedance.android.ec.core.gallery2;

import android.content.Context;
import com.bytedance.android.ec.model.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/ec/core/gallery2/GalleryViewer;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoViewerDialog;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GalleryViewer extends PhotoViewerDialog implements TransitionListener {
    public final IndexIndicator a;
    public final TitleIndicator b;
    public final GalleryAdapter c;

    public final void onPageSelected(int r1) {
    }

    public final void onTransitionBegin(int r1) {
    }

    public final void onTransitionChanged(int r1, float r10) {
    }

    public final void onTransitionEnd(int r1) {
    }

    public GalleryViewer(Context r10) {
        GalleryAdapter r0 = new GalleryAdapter();
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r0, "galleyAdapter");
        super(r10, r0);
        this.c = r0;
        r0.addTransitionListener(this);
        IndexIndicator r1 = new IndexIndicator(r10, null, 6, 0);
        this.a = r1;
        TitleIndicator r11 = new TitleIndicator(r10, null, 6, 0);
        this.b = r11;
        addIndicatorView(r1);
        addIndicatorView(r11);
    }

    public final void a(List<? extends l> r10) {
        Intrinsics.checkNotNullParameter(r10, "medias");
        this.c.a = r10;
        this.a.setCount(((ArrayList) r10).size());
    }
}
