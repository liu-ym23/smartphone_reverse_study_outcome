package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.camera.impl.databinding.LarusItemPreviewGifBinding;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/GifPreviewFragment;", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/BasePreviewFragment;", "<init>", "()V", "binding", "Lcom/larus/camera/impl/databinding/LarusItemPreviewGifBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GifPreviewFragment extends BasePreviewFragment {
    public static final /* synthetic */ int i = 0;
    public LarusItemPreviewGifBinding h;

    public static final class a {
    }

    static {
    }

    public final void onDestroyView() {
        LarusItemPreviewGifBinding r0 = this.h;
        if (r0 == null) goto L7;
        SimpleDraweeView r1 = r0.b;
        if (r1 == null) goto L7;
        ImageLoaderKt.b(r1);
    L7:
        this.h = null;
        super.onDestroyView();
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onResume() {
        super.onResume();
        T90().setIsPhotoEditable(false);
        T90().setRedoEnabled(false);
        T90().setUndoEnabled(false);
        T90().setInDrawingMode(false);
        T90().setInCropMode(false);
        T90().setMarkedImageGetter(null);
    }

    public GifPreviewFragment() {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Object r9 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        ResultDisplayParam r11 = this.e;     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        String r12 = r11.getPath();     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        if (r12.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L14;
        r12 = null;
    L14:
        if (r12 == null) goto L16;
        Uri r13 = Uri.fromFile(new PolarisFileWrapper(r12));     // Catch: Throwable -> L19
    L17:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r14) == true) goto L25;
        r9 = r14;
    L25:
        final Uri r1 = (Uri) r9;
        if (r1 != null) goto L28;
        return;
    L28:
        LarusItemPreviewGifBinding r15 = this.h;
        if (r15 == null) goto L36;
        final SimpleDraweeView r16 = r15.b;
        if (r16 == null) goto L37;
        ImageLoaderKt.x(r16, r1, null, null, new b(r16, r1), 6);
        r16.post(new c(this, r16));
        return;
    L37:
        return;
    L36:
        return;
    L10:
        r0 = false;
    L16:
        r13 = null;
    L19:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562611, r3, false);
        SimpleDraweeView r6 = ViewBindings.findChildViewById(r5, 2131382919);
        if (r6 == null) goto L7;
        ConstraintLayout r7 = r5;
        this.h = new LarusItemPreviewGifBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131382919)));
    }
}
