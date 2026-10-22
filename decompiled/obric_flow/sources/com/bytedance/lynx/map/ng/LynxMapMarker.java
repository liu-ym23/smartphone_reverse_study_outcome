package com.bytedance.lynx.map.ng;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.bytedance.amap.model.AliMarker;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import java.util.List;
import mf.a;
import mf.b;
import mf.c;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxMapMarker extends UIView implements b {
    private ReadableMap mAnnotation;
    private boolean mAnnotationUpdated;
    public boolean mEnableCustomizedView;
    public boolean mIsUserMarker;
    public a mLynxMapView;
    public IMarker mMarker;
    private int mMarkerLeft;
    private int mMarkerTop;
    public MotionEvent mMotionEventAtLastTouchUp;

    public LynxMapMarker(LynxContext r5) {
        this(r5, null);
    }

    private Bitmap genBitmap() {
        Bitmap r5 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r10 = new Canvas(r5);
        requestLayoutRecursively(this.mView);
        measure();
        layout();
        ((com.lynx.tasm.behavior.ui.view.b) this.mView).draw(r10);
        return r5;
    }

    private void requestLayoutRecursively(View r5) {
        r5.forceLayout();
        if ((r5 instanceof ViewGroup) == false) goto L8;
        ViewGroup r10 = (ViewGroup) r5;
        int r11 = 0;
    L6:
        if (r11 >= r10.getChildCount()) goto L8;
        requestLayoutRecursively(r10.getChildAt(r11));
        r11 = r11 + 1;
    L8:
        layoutChildren();
    }

    private void startMarkerAnimationInternal(IMarker r5, ReadableMap r10) {
        if (r5 == null) goto L9;
        if (r10 == null) goto L10;
        a r11 = this.mLynxMapView;
        if (r11 == null) goto L11;
        List r12 = r11.parseAnimationStyle(r10);
        this.mLynxMapView.startMarkerAnimation(r5, r12);
        return;
    L11:
        return;
    L10:
        return;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.View] */
    private void updateAnnotation(ReadableMap r10) {
        if (this.mLynxMapView != null) goto L6;
        return;
    L6:
        if (this.mEnableCustomizedView == false) goto L8;
        Bitmap r5 = null;
    L9:
        BDMarkerOptions r11 = this.mLynxMapView.genMarkerOptions(r10, getWidth(), getHeight(), this.mEnableCustomizedView);
        if (this.mEnableCustomizedView == false) goto L12;
        r11.d = getView();
    L13:
        IMarker r12 = this.mMarker;
        if (r12 != null) goto L16;
        updateView();
        this.mMarker = this.mLynxMapView.addMarker(r11, this.mIsUserMarker);
    L25:
        startMarkerAnimationInternal(this.mMarker, r10.getMap("animate"));
        return;
    L16:
        ((AliMarker) r12).a(r11.f6921b);
        if (this.mEnableCustomizedView == false) goto L19;
        updateView();
    L22:
        if (this.mIsUserMarker == true) goto L24;
        ((AliMarker) this.mMarker).b(r11.g);
    L24:
        ((AliMarker) this.mMarker).a(r11.f6923h);
        ((AliMarker) this.mMarker).a(r11.f6925j);
        ((AliMarker) this.mMarker).c(r11.f6924i);
        goto L25
    L19:
        if (r5 == null) goto L22;
        ((AliMarker) this.mMarker).a(r5);
        goto L22
    L12:
        r11.f6922c = r5;
        goto L13
    L8:
        r5 = genBitmap();
        goto L9
    }

    private void updateView() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5, Object r10) {
        return createView(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        IMarker r5 = this.mMarker;
        if (r5 == null) goto L5;
        this.mLynxMapView.removeMarker(r5, this.mIsUserMarker);
        this.mMarker = null;
    L5:
        super.destroy();
    }

    @Override // mf.b
    public LynxBaseUI getMapUI() {
        return getParentBaseUI();
    }

    @Override // mf.b
    public int getMarkerHeight() {
        return getHeight();
    }

    @Override // mf.b
    public int getMarkerLeft() {
        return this.mMarkerLeft;
    }

    @Override // mf.b
    public int getMarkerTop() {
        return this.mMarkerTop;
    }

    @Override // mf.b
    public int getMarkerWidth() {
        return getWidth();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Rect getRectWithoutTransform() {
        Rect r5 = super.getRectWithoutTransform();
        if (this.mEnableCustomizedView == false) goto L5;
        r5.left = this.mMarkerLeft;
        r5.top = this.mMarkerTop;
    L5:
        return r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        if (this.mAnnotationUpdated == false) goto L6;
        this.mAnnotationUpdated = false;
        updateAnnotation(this.mAnnotation);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeRemoved() {
        IMarker r5 = this.mMarker;
        if (r5 == null) goto L5;
        this.mLynxMapView.removeMarker(r5, this.mIsUserMarker);
        this.mMarker = null;
    L5:
        super.onNodeRemoved();
    }

    @Override // mf.b
    public void onTouchUp(MotionEvent r5) {
        this.mMotionEventAtLastTouchUp = r5;
    }

    @f0
    public void refreshMarker(Callback r5) {
        IMarker r10 = this.mMarker;
        if (r10 != null) goto L8;
        if (r5 == null) goto L14;
        r5.invoke(new Object[]{8, "marker is not rendered!"});
        return;
    L14:
        return;
    L8:
        if (this.mEnableCustomizedView == false) goto L10;
        updateView();
    L11:
        if (r5 == null) goto L15;
        r5.invoke(new Object[]{0});
        return;
    L15:
        return;
    L10:
        AliMarker r11 = (AliMarker) r10;
        r11.a(genBitmap());
        goto L11
    }

    @c0(name = "annotation")
    public void setAnnotation(ReadableMap r5) {
        if (r5.getArray("points") != null) goto L5;
        return;
    L5:
        if (r5.getArray("points").getArray(0) == null) goto L10;
        this.mAnnotation = r5;
        this.mAnnotationUpdated = true;
        return;
    }

    @Override // mf.b
    public void setMarkerLayoutParams(int r5, int r10, int r11, int r12) {
        this.mMarkerLeft = r5;
        this.mMarkerTop = r10;
    }

    @c0(name = "android-enable-customized-view")
    public void setUseCustomizedView(boolean r5) {
        this.mEnableCustomizedView = r5;
    }

    @c0(name = "user-marker")
    public void setUserMarker(boolean r5) {
        this.mIsUserMarker = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateLayout(int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, int r36, int r37, Rect r38) {
        int r5 = getWidth();
        int r10 = getHeight();
        super.updateLayout(0, 0, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
        if (r5 != getWidth()) goto L7;
        if (r10 != getHeight()) goto L7;
        return;
    L7:
        if (this.mAnnotationUpdated == true) goto L11;
        refreshMarker(null);
        return;
    }

    public LynxMapMarker(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mAnnotationUpdated = false;
        this.mIsUserMarker = false;
        this.mEnableCustomizedView = false;
        this.mMarkerLeft = 0;
        this.mMarkerTop = 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public com.lynx.tasm.behavior.ui.view.b createView(Context r5, Object r10) {
        c r11 = new c(r5);
        r11.f20067a = this;
        return r11;
    }
}
