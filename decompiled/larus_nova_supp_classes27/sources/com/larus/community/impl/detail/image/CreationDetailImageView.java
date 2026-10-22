package com.larus.community.impl.detail.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.community.impl.databinding.LarusCommunityCreationDetailImageLayoutBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u0018H\u0002J\n\u0010#\u001a\u0004\u0018\u00010 H\u0002J\u0014\u0010$\u001a\u00020\u00182\n\u0010%\u001a\u00020&\"\u00020\u0018H\u0002J6\u0010'\u001a\u00020\f2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\u0016\u0010(\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationDetailImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationDetailImageLayoutBinding;", "onImageLongPressListener", "Lkotlin/Function0;", "", "getOnImageLongPressListener", "()Lkotlin/jvm/functions/Function0;", "setOnImageLongPressListener", "(Lkotlin/jvm/functions/Function0;)V", "onImageScaleListener", "getOnImageScaleListener", "setOnImageScaleListener", "onImageDoubleTapListener", "getOnImageDoubleTapListener", "setOnImageDoubleTapListener", "screenWidth", "", "screenHeight", "getImageView", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "bindImageData", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "buildCreationResizeOptions", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "buildFullSizeResizeOptions", "resizeSize", "buildContainerResizeOptions", "firstValidSize", "sizes", "", "bindAction", "adjustContainerSize", "hasExtraList", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailImageView extends ConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final LarusCommunityCreationDetailImageLayoutBinding a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public final int e;
    public final int f;

    public final CreationZoomableDraweeView getImageView() {
        return this.a.c;
    }

    public final Function0<Unit> getOnImageDoubleTapListener() {
        return this.d;
    }

    public final Function0<Unit> getOnImageLongPressListener() {
        return this.b;
    }

    public final Function0<Unit> getOnImageScaleListener() {
        return this.c;
    }

    public CreationDetailImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final int R5(int... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        int r3 = r6[r2];
        boolean r4 = true;
        if (r3 > 1) goto L8;
        r4 = false;
    L8:
        if (r4 == true) goto L9;
        r2 = r2 + 1;
        goto L3
    L9:
        Integer r7 = Integer.valueOf(r3);
    L12:
        if (r7 != null) goto L14;
        return 0;
    L14:
        return r7.intValue();
    L11:
        r7 = null;
        goto L12
    }

    public final void setOnImageDoubleTapListener(Function0<Unit> r1) {
        this.d = r1;
    }

    public final void setOnImageLongPressListener(Function0<Unit> r1) {
        this.b = r1;
    }

    public final void setOnImageScaleListener(Function0<Unit> r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationDetailImageView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        LayoutInflater.from(r3).inflate(2131561929, this);
        int r5 = 2131367728;
        ConstraintLayout r0 = ViewBindings.findChildViewById(this, 2131367728);
        if (r0 == null) goto L9;
        r5 = 2131375091;
        CreationZoomableDraweeView r1 = (CreationZoomableDraweeView) ViewBindings.findChildViewById(this, 2131375091);
        if (r1 == null) goto L9;
        this.a = new LarusCommunityCreationDetailImageLayoutBinding(this, r0, r1);
        this.e = com.larus.utils.i.d(r3);
        this.f = com.larus.utils.i.c(r3);
        r1.getHierarchy().setActualImageColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(ContextCompat.getColor(r3, 2131103188), BlendModeCompat.DST_OVER));
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }
}
