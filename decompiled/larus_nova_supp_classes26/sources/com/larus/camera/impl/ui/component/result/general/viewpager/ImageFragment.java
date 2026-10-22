package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.databinding.LarusItemPreviewImageBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/ImageFragment;", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/BasePreviewFragment;", "<init>", "()V", "binding", "Lcom/larus/camera/impl/databinding/LarusItemPreviewImageBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageFragment extends BasePreviewFragment {
    public static final /* synthetic */ int i = 0;
    public LarusItemPreviewImageBinding h;

    public static final class a {
    }

    static {
    }

    public ImageFragment() {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        LarusItemPreviewImageBinding r5 = this.h;
        if (r5 == null) goto L8;
        final ImageView r6 = r5.b;
        if (r6 == null) goto L9;
        r6.setImageBitmap(S90());
        r6.post(new f(this, r6));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new ImageFragment$onViewCreated$1$2(this, r6, null));
        return;
    L9:
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562612, r3, false);
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r5, 2131382921);
        if (r6 == null) goto L7;
        ConstraintLayout r7 = r5;
        this.h = new LarusItemPreviewImageBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131382921)));
    }
}
