package com.byted.cast.sdk.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.byted.cast.sdk.RTCMediaKind;
import com.byted.cast.sdk.RTCVideoRender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RTCSurfaceView extends GLSurfaceView implements IRenderView {
    private GestureDetector mGestureDetector;
    private MeasureHelper mMeasureHelper;
    private String mMirrorId;
    private RTCVideoRender mVideoRender;

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r1) {
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r1) {
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r1) {
    }

    private void init() {
        this.mVideoRender = new RTCVideoRender(this, this.mMirrorId);
        this.mMeasureHelper = new MeasureHelper(this);
        setRenderer(this.mVideoRender);
        setRenderMode(0);
    }

    public boolean clearSource() {
        return this.mVideoRender.clearSource();
    }

    public RTCMediaKind getMediaKind() {
        return this.mVideoRender.getMediaKind();
    }

    public String getUserId() {
        return this.mVideoRender.getUserId();
    }

    public boolean isSetSource() {
        return this.mVideoRender.isSetSource();
    }

    public boolean isSubscribed() {
        return this.mVideoRender.isSubscribed();
    }

    public boolean subscribe() {
        return this.mVideoRender.subscribe();
    }

    public boolean unsubscribe() {
        return this.mVideoRender.unsubscribe();
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return true;
    }

    public RTCVideoRender getRender() {
        return this.mVideoRender;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        GestureDetector r0 = this.mGestureDetector;
        if (r0 == null) goto L6;
        r0.onTouchEvent(r10);
    L6:
        if (r10.getAction() != 1) goto L9;
        performClick();
    L9:
        return super.onTouchEvent(r10);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r10) {
        this.mMeasureHelper.setAspectRatio(r10);
        requestLayout();
    }

    public void setOnGestureListener(GestureDetector.OnGestureListener r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.mGestureDetector = new GestureDetector(getContext(), r10);
    }

    public RTCSurfaceView(Context r1, String r10) {
        super(r1);
        this.mMirrorId = r10;
        init();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r10, int r11) {
        this.mMeasureHelper.doMeasure(r10, r11);
        setMeasuredDimension(this.mMeasureHelper.getMeasuredWidth(), this.mMeasureHelper.getMeasuredHeight());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSampleAspectRatio(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L7;
        this.mMeasureHelper.setVideoSampleAspectRatio(r10, r11);
        requestLayout();
        return;
    L7:
        return;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoSize(int r10, int r11) {
        if (r10 <= 0) goto L6;
        if (r11 <= 0) goto L7;
        this.mMeasureHelper.setVideoSize(r10, r11);
        getHolder().setFixedSize(r10, r11);
        requestLayout();
        return;
    L7:
        return;
    }

    public RTCSurfaceView(Context r1, AttributeSet r10) {
        super(r1, r10);
        init();
    }

    public boolean setSource(String r10, RTCMediaKind r11, RTCVideoRender.StatusListener r12) {
        return this.mVideoRender.setSource(r10, r11, r12);
    }
}
