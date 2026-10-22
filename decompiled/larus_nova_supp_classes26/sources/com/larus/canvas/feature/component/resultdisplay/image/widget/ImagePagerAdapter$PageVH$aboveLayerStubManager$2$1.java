package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.canvas.impl.databinding.LarusCanvasPageImageAboveLayerBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1 extends FunctionReferenceImpl implements Function1<View, LarusCanvasPageImageAboveLayerBinding> {
    public static final ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1 INSTANCE = null;

    static {
        INSTANCE = new ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1();
    }

    public ImagePagerAdapter$PageVH$aboveLayerStubManager$2$1() {
        super(1, LarusCanvasPageImageAboveLayerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/canvas/impl/databinding/LarusCanvasPageImageAboveLayerBinding;", 0);
    }

    public final LarusCanvasPageImageAboveLayerBinding invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        int r0 = 2131365416;
        if (((ImageView) ViewBindings.findChildViewById(r4, 2131365416)) == null) goto L13;
        r0 = 2131365419;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, 2131365419);
        if (r1 == null) goto L13;
        r0 = 2131365424;
        if (((TextView) ViewBindings.findChildViewById(r4, 2131365424)) == null) goto L13;
        r0 = 2131378977;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r4, 2131378977);
        if (r2 == null) goto L13;
        return new LarusCanvasPageImageAboveLayerBinding((ConstraintLayout) r4, r1, r2);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((View) r1);
    }
}
