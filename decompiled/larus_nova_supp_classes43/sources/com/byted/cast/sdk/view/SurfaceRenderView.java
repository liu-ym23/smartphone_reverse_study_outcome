package com.byted.cast.sdk.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class SurfaceRenderView extends SurfaceView implements IRenderView {
    private static final String TAG = "SurfaceRenderView";
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private MeasureHelper mMeasureHelper;
    private SurfaceCallback mSurfaceCallback;

    public static final class InternalSurfaceHolder implements IRenderView.ISurfaceHolder {
        private SurfaceHolder mSurfaceHolder;
        private SurfaceRenderView mSurfaceView;

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public SurfaceTexture getSurfaceTexture() {
            return null;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public Surface openSurface() {
            SurfaceHolder r0 = this.mSurfaceHolder;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getSurface();
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public IRenderView getRenderView() {
            return this.mSurfaceView;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.ISurfaceHolder
        public SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        public InternalSurfaceHolder(SurfaceRenderView r1, SurfaceHolder r10) {
            this.mSurfaceView = r1;
            this.mSurfaceHolder = r10;
        }
    }

    public static final class SurfaceCallback implements SurfaceHolder.Callback {
        private ContextManager.CastContext mCastContext;
        private int mFormat;
        private int mHeight;
        private boolean mIsFormatChanged;
        private CastLogger mLogger;
        private Map<IRenderView.IRenderCallback, Object> mRenderCallbackMap;
        private SurfaceHolder mSurfaceHolder;
        private WeakReference<SurfaceRenderView> mWeakSurfaceView;
        private int mWidth;

        public void addRenderCallback(IRenderView.IRenderCallback r10) {
            this.mLogger.i(SurfaceRenderView.TAG, "addRenderCallback:" + this.mSurfaceHolder);
            this.mRenderCallbackMap.put(r10, r10);
            if (this.mSurfaceHolder == null) goto L5;
            InternalSurfaceHolder r0 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            r10.onSurfaceCreated(r0, this.mWidth, this.mHeight);
            this.mLogger.i(SurfaceRenderView.TAG, "onSurfaceCreated:" + this.mSurfaceHolder);
        L7:
            if (this.mIsFormatChanged == false) goto L12;
            if (r0 != null) goto L10;
            r0 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
        L10:
            r10.onSurfaceChanged(r0, this.mFormat, this.mWidth, this.mHeight);
            return;
        L12:
            return;
        L5:
            r0 = null;
            goto L7
        }

        public void removeRenderCallback(IRenderView.IRenderCallback r10) {
            this.mLogger.i(SurfaceRenderView.TAG, "removeRenderCallback:" + r10);
            this.mRenderCallbackMap.remove(r10);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder r10) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceCreated:" + r10);
            this.mSurfaceHolder = r10;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder r0 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r1 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().onSurfaceCreated(r0, 0, 0);
            goto L4
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder r10) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceDestroyed:" + r10);
            this.mSurfaceHolder = null;
            this.mIsFormatChanged = false;
            this.mFormat = 0;
            this.mWidth = 0;
            this.mHeight = 0;
            InternalSurfaceHolder r11 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r0 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onSurfaceDestroyed(r11);
            goto L4
        }

        public SurfaceCallback(SurfaceRenderView r10, ContextManager.CastContext r11) {
            this.mRenderCallbackMap = new ConcurrentHashMap();
            this.mCastContext = r11;
            this.mLogger = ContextManager.getLogger(r11);
            this.mWeakSurfaceView = new WeakReference(r10);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder r10, int r11, int r12, int r13) {
            this.mLogger.i(SurfaceRenderView.TAG, "surfaceChanged:" + r10);
            this.mSurfaceHolder = r10;
            this.mIsFormatChanged = true;
            this.mFormat = r11;
            this.mWidth = r12;
            this.mHeight = r13;
            InternalSurfaceHolder r14 = new InternalSurfaceHolder(this.mWeakSurfaceView.get(), this.mSurfaceHolder);
            Iterator<IRenderView.IRenderCallback> r0 = this.mRenderCallbackMap.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onSurfaceChanged(r14, r11, r12, r13);
            goto L4
        }
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public View getView() {
        return this;
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setVideoRotation(int r1) {
    }

    private void initView(Context r10) {
        this.mMeasureHelper = new MeasureHelper(this);
        this.mSurfaceCallback = new SurfaceCallback(this, this.mCastContext);
        getHolder().addCallback(this.mSurfaceCallback);
        getHolder().setType(0);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void addRenderCallback(IRenderView.IRenderCallback r10) {
        this.mSurfaceCallback.addRenderCallback(r10);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent r10) {
        super.onInitializeAccessibilityEvent(r10);
        r10.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r10) {
        super.onInitializeAccessibilityNodeInfo(r10);
        r10.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void removeRenderCallback(IRenderView.IRenderCallback r10) {
        this.mSurfaceCallback.removeRenderCallback(r10);
    }

    @Override // com.byted.cast.sdk.view.IRenderView
    public void setAspectRatio(int r10) {
        this.mMeasureHelper.setAspectRatio(r10);
        requestLayout();
    }

    public SurfaceRenderView(Context r1, ContextManager.CastContext r10) {
        super(r1);
        this.mCastContext = r10;
        this.mLogger = ContextManager.getLogger(r10);
        initView(r1);
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

    public SurfaceRenderView(Context r1, AttributeSet r10) {
        super(r1, r10);
        initView(r1);
    }

    public SurfaceRenderView(Context r1, AttributeSet r10, int r11) {
        super(r1, r10, r11);
        initView(r1);
    }

    public SurfaceRenderView(Context r1, AttributeSet r10, int r11, int r12) {
        super(r1, r10, r11, r12);
        initView(r1);
    }
}
