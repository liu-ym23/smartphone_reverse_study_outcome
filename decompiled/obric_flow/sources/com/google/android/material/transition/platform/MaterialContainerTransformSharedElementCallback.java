package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {

    @Nullable
    private static WeakReference<View> capturedSharedElement;
    private boolean entering;

    @Nullable
    private Rect returnEndBounds;

    @Nullable
    private ShapeProvider shapeProvider;
    private boolean sharedElementReenterTransitionEnabled;
    private boolean transparentWindowBackgroundEnabled;

    public interface ShapeProvider {
        @Nullable
        ShapeAppearanceModel provideShape(@NonNull View r5);
    }

    public static class ShapeableViewShapeProvider implements ShapeProvider {
        public ShapeableViewShapeProvider() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback.ShapeProvider
        @Nullable
        public ShapeAppearanceModel provideShape(@NonNull View r5) {
            if ((r5 instanceof Shapeable) == true) goto L7;
            return null;
        L7:
            return ((Shapeable) r5).getShapeAppearanceModel();
        }
    }

    public MaterialContainerTransformSharedElementCallback() {
        this.entering = true;
        this.transparentWindowBackgroundEnabled = true;
        this.sharedElementReenterTransitionEnabled = false;
        this.shapeProvider = new ShapeableViewShapeProvider();
    }

    public static /* synthetic */ void access$000(Window r5) {
        removeWindowBackground(r5);
    }

    public static /* synthetic */ void access$100(Window r5) {
        restoreWindowBackground(r5);
    }

    public static /* synthetic */ WeakReference access$200() {
        return capturedSharedElement;
    }

    public static /* synthetic */ WeakReference access$202(WeakReference r5) {
        capturedSharedElement = r5;
        return r5;
    }

    @Nullable
    private static Drawable getWindowBackground(Window r5) {
        return r5.getDecorView().getBackground();
    }

    private static void removeWindowBackground(Window r5) {
        Drawable r10 = getWindowBackground(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
    }

    private static void restoreWindowBackground(Window r5) {
        Drawable r10 = getWindowBackground(r5);
        if (r10 != null) goto L5;
        return;
    L5:
        r10.mutate().clearColorFilter();
    }

    private void setUpEnterTransform(final Window r5) {
        Transition r10 = r5.getSharedElementEnterTransition();
        if ((r10 instanceof MaterialContainerTransform) == false) goto L11;
        MaterialContainerTransform r11 = (MaterialContainerTransform) r10;
        if (this.sharedElementReenterTransitionEnabled == true) goto L8;
        r5.setSharedElementReenterTransition(null);
    L8:
        if (this.transparentWindowBackgroundEnabled == false) goto L12;
        updateBackgroundFadeDuration(r5, r11);
        r11.addListener(new AnonymousClass1(this, r5));
        return;
    L12:
        return;
    }

    private void setUpReturnTransform(final Activity r5, final Window r10) {
        Transition r11 = r10.getSharedElementReturnTransition();
        if ((r11 instanceof MaterialContainerTransform) == false) goto L8;
        MaterialContainerTransform r12 = (MaterialContainerTransform) r11;
        r12.setHoldAtEndEnabled(true);
        r12.addListener(new AnonymousClass2(this, r5));
        if (this.transparentWindowBackgroundEnabled == false) goto L9;
        updateBackgroundFadeDuration(r10, r12);
        r12.addListener(new AnonymousClass3(this, r10));
        return;
    L9:
        return;
    }

    private static void updateBackgroundFadeDuration(Window r5, MaterialContainerTransform r10) {
        if (r10.getDuration() < 0) goto L6;
        r5.setTransitionBackgroundFadeDuration(r10.getDuration());
        return;
    }

    @Nullable
    public ShapeProvider getShapeProvider() {
        return this.shapeProvider;
    }

    public boolean isSharedElementReenterTransitionEnabled() {
        return this.sharedElementReenterTransitionEnabled;
    }

    public boolean isTransparentWindowBackgroundEnabled() {
        return this.transparentWindowBackgroundEnabled;
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public Parcelable onCaptureSharedElementSnapshot(@NonNull View r5, @NonNull Matrix r10, @NonNull RectF r11) {
        capturedSharedElement = new WeakReference(r5);
        return super.onCaptureSharedElementSnapshot(r5, r10, r11);
    }

    @Override // android.app.SharedElementCallback
    @Nullable
    public View onCreateSnapshotView(@NonNull Context r5, @Nullable Parcelable r10) {
        View r11 = super.onCreateSnapshotView(r5, r10);
        if (r11 == null) goto L13;
        WeakReference<View> r12 = capturedSharedElement;
        if (r12 == null) goto L13;
        if (this.shapeProvider == null) goto L13;
        View r13 = r12.get();
        if (r13 == null) goto L13;
        ShapeAppearanceModel r14 = this.shapeProvider.provideShape(r13);
        if (r14 == null) goto L13;
        r11.setTag(R.id.mtrl_motion_snapshot_view, r14);
    L13:
        return r11;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@NonNull List<String> r5, @NonNull Map<String, View> r10) {
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        if (r10.isEmpty() == true) goto L16;
        View r11 = r10.get(r5.get(0));
        if (r11 == null) goto L17;
        Activity r12 = ContextUtils.getActivity(r11.getContext());
        if (r12 == null) goto L18;
        Window r13 = r12.getWindow();
        if (this.entering == false) goto L13;
        setUpEnterTransform(r13);
        return;
    L13:
        setUpReturnTransform(r12, r13);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@NonNull List<String> r5, @NonNull List<View> r10, @NonNull List<View> r11) {
        if (r10.isEmpty() == true) goto L8;
        if ((r10.get(0).getTag(R.id.mtrl_motion_snapshot_view) instanceof View) == false) goto L8;
        r10.get(0).setTag(R.id.mtrl_motion_snapshot_view, null);
    L8:
        if (this.entering == false) goto L10;
    L12:
        this.entering = false;
        return;
    L10:
        if (r10.isEmpty() == true) goto L12;
        this.returnEndBounds = TransitionUtils.getRelativeBoundsRect(r10.get(0));
        goto L12
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@NonNull List<String> r5, @NonNull List<View> r10, @NonNull List<View> r11) {
        if (r10.isEmpty() == true) goto L8;
        if (r11.isEmpty() == true) goto L8;
        r10.get(0).setTag(R.id.mtrl_motion_snapshot_view, r11.get(0));
    L8:
        if (this.entering == false) goto L10;
        return;
    L10:
        if (r10.isEmpty() == false) goto L12;
        return;
    L12:
        if (this.returnEndBounds == null) goto L17;
        View r12 = r10.get(0);
        r12.measure(View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.width(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.returnEndBounds.height(), BasicMeasure.EXACTLY));
        Rect r13 = this.returnEndBounds;
        r12.layout(r13.left, r13.top, r13.right, r13.bottom);
        return;
    }

    public void setShapeProvider(@Nullable ShapeProvider r5) {
        this.shapeProvider = r5;
    }

    public void setSharedElementReenterTransitionEnabled(boolean r5) {
        this.sharedElementReenterTransitionEnabled = r5;
    }

    public void setTransparentWindowBackgroundEnabled(boolean r5) {
        this.transparentWindowBackgroundEnabled = r5;
    }
}
