package com.larus.camera.impl.ui.component.result.general.viewpager;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.markableview.MarkableImageView;
import com.larus.camera.impl.databinding.LarusItemPreviewMarkableImageBinding;
import com.larus.camera.impl.ui.viewmodel.CameraResultViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/camera/impl/ui/component/result/general/viewpager/MarkableImageFragment;", "Lcom/larus/camera/impl/ui/component/result/general/viewpager/BasePreviewFragment;", "<init>", "()V", "binding", "Lcom/larus/camera/impl/databinding/LarusItemPreviewMarkableImageBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "subscribeInputStatus", "onLeavePageFromThumbList", "onResume", "resetMark", "setPreviewBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setupMarkingFeatures", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkableImageFragment extends BasePreviewFragment {
    public static final /* synthetic */ int i = 0;
    public LarusItemPreviewMarkableImageBinding h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment, com.larus.camera.impl.ui.component.result.general.viewpager.d
    public final void oK() {
        if (((Boolean) T90().getEnableUndo().getValue()).booleanValue() == true) goto L5;
    L14:
        LarusItemPreviewMarkableImageBinding r0 = this.h;
        if (r0 == null) goto L19;
        MarkableImageView r1 = r0.b;
        if (r1 == null) goto L19;
        r1.clear();
    L19:
        T90().setRedoEnabled(false);
        T90().setUndoEnabled(false);
        T90().setInDrawingMode(false);
        T90().setInCropMode(false);
        return;
    L5:
        if (T90().shouldDeferCurrentMarkBitmapUpdate() == false) goto L7;
        T90().setImageHasBeenMarked(true);
        goto L14
    L7:
        LarusItemPreviewMarkableImageBinding r2 = this.h;
        if (r2 == null) goto L14;
        MarkableImageView r3 = r2.b;
        if (r3 == null) goto L14;
        Bitmap r4 = r3.getMarkedBitmap();
        if (r4 == null) goto L14;
        T90().updateCurrentBitmap(r4, "onPreviewThumbItemClick");
        T90().setImageHasBeenMarked(true);
        goto L14
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onResume() {
        super.onResume();
        if (isAdded() == true) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L21;
        T90().setIsPhotoEditable(true);
        Bitmap r0 = S90();
        if (r0 == null) goto L9;
        U90(r0);
    L9:
        T90().setMarkedImageGetter(new i(this));
        T90().setRawMarkedImageGetter(new j(this));
        LarusItemPreviewMarkableImageBinding r1 = this.h;
        if (r1 == null) goto L14;
        MarkableImageView r2 = r1.b;
        if (r2 == null) goto L14;
        r2.setRawBitmap((Bitmap) T90().getRawBaseBitmap().getValue());
    L14:
        LarusItemPreviewMarkableImageBinding r3 = this.h;
        if (r3 == null) goto L22;
        MarkableImageView r4 = r3.b;
        if (r4 == null) goto L23;
        r4.setMarkEnabled(T90().shouldEnableMark());
        return;
    L23:
        return;
    L22:
        return;
    }

    public MarkableImageFragment() {
    }

    public final void U90(Bitmap r5) {
        LarusItemPreviewMarkableImageBinding r0 = this.h;
        if (r0 == null) goto L18;
        MarkableImageView r1 = r0.b;
        if (r1 == null) goto L19;
        String r2 = null;
        if (CameraResultViewModel.shouldUseUnifiedPreviewFramework$default(T90(), null, 1, null) == true) goto L9;
    L10:
        r1.setImageBitmap(r5);
    L12:
        if (T90().shouldUseMarkSelectMode() == false) goto L20;
        CameraResultViewModel r6 = T90();
        ResultDisplayParam r3 = this.e;
        if (r3 == null) goto L16;
        r2 = r3.getOutputKey();
    L16:
        r1.setPathBitmap(r6.getMarkedMaskBitmap(r2));
        return;
    L20:
        return;
    L9:
        if (r1.getViewBitmap() == r5) goto L12;
    L19:
        return;
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [android.widget.ImageView, com.larus.bmhome.view.markableview.MarkableImageView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusItemPreviewMarkableImageBinding r9 = this.h;
        if (r9 == null) goto L7;
        final ?? r10 = r9.b;
        if (r10 == 0) goto L7;
        r10.post(new h(this, r10));
        r10.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r10.setPenColor(ContextCompat.getColor(r10.getContext(), 2131102526));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MarkableImageFragment$setupMarkingFeatures$1$2(this, r10, null));
        r10.setOnUserMarkedListener(new k(this, r10));
    L7:
        MutableSharedFlow<com.larus.camera.impl.utils.eventbus.g> r11 = com.larus.camera.impl.utils.eventbus.c.a;
        LifecycleCoroutineScope r12 = LifecycleOwnerKt.getLifecycleScope(this);
        final a1 r0 = com.larus.camera.impl.utils.eventbus.c.b;
        Flow<Object> r1 = new MarkableImageFragment$subscribeInputStatus$$inlined$subscribe$1(r0);
        g1.a.getClass();
        h1 r2 = g1.a.b;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(r1, r12, r2, 0), new MarkableImageFragment$subscribeInputStatus$$inlined$subscribe$2(null, this)), r12);
        LifecycleCoroutineScope r13 = LifecycleOwnerKt.getLifecycleScope(this);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(kotlinx.coroutines.flow.e.D(new MarkableImageFragment$subscribeInputStatus$$inlined$subscribe$3(r0), r13, r2, 0), new MarkableImageFragment$subscribeInputStatus$$inlined$subscribe$4(null, this)), r13);
        Bitmap r14 = S90();
        if (r14 == null) goto L11;
        U90(r14);
        return;
    }

    @Override // com.larus.camera.impl.ui.component.result.general.viewpager.BasePreviewFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562614, r3, false);
        MarkableImageView r6 = (MarkableImageView) ViewBindings.findChildViewById(r5, 2131379545);
        if (r6 == null) goto L7;
        ConstraintLayout r7 = r5;
        this.h = new LarusItemPreviewMarkableImageBinding(r7, r6);
        return r7;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(2131379545)));
    }
}
