package com.lynx.canvas;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.krypton.ICanvasManager;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonHelper;
import com.lynx.tasm.behavior.ui.krypton.LynxKryptonModule;
import com.lynx.tasm.event.LynxEventDetail;
import com.miui.easygo.constant.EasyGoDbTable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UISurfaceCanvas extends LynxUI<FrameLayout> {
    private static final String TAG = "UISurfaceCanvas";
    private int mAndroidSurfaceZOrderMode;
    private String mAndroidSurfaceZOrderValue;
    private String mName;
    private UICanvasSurfaceView mSurfaceView;
    private boolean mSurfaceViewSetup;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchEvent(LynxEventDetail r1) {
        return false;
    }

    private CanvasManager getOrTryCreateCanvasManager() {
        getLynxContext();
        LynxKryptonModule r0 = (LynxKryptonModule) getLynxContext().getExtensionModuleByKey(LynxKryptonModule.TAG);
        if (r0 != null) goto L5;
        return null;
    L5:
        LynxKryptonHelper r1 = r0.getLynxKryptonHelper();
        if (r1 != null) goto L8;
        return null;
    L8:
        ICanvasManager r2 = r1.getCanvasManager();
        if (r2 == null) goto L12;
        LLog.i(TAG, "Canvas manager is already created.");
        return (CanvasManager) r2;
    L12:
        LLog.i(TAG, "Setup canvas environment from UISurfaceCanvas in lazy mode.");
        r1.setupCanvasIfCanvasViewCreated();
        return (CanvasManager) r1.getCanvasManager();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        UICanvasSurfaceView r0 = this.mSurfaceView;
        if (r0 == null) goto L5;
        r0.destroy();
        this.mSurfaceView = null;
    L5:
        this.mSurfaceViewSetup = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        super.layout();
        Rect r0 = getBoundingClientRect();
        UICanvasSurfaceView r1 = this.mSurfaceView;
        if (r1 == null) goto L6;
        r1.notifyLayout(r0);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        CanvasManager r0 = getOrTryCreateCanvasManager();
        if (r0 == null) goto L17;
        if (this.mSurfaceView != null) goto L11;
        if (this.mAndroidSurfaceZOrderValue != null) goto L9;
        this.mAndroidSurfaceZOrderValue = "on-top";
        this.mAndroidSurfaceZOrderMode = 1;
    L9:
        this.mSurfaceView = new UICanvasSurfaceView(getLynxContext(), this.mAndroidSurfaceZOrderMode);
        ((FrameLayout) this.mView).addView(this.mSurfaceView, new FrameLayout.LayoutParams(-1, -1));
    L11:
        if (this.mSurfaceViewSetup == false) goto L13;
        return;
    L13:
        if (this.mName == null) goto L19;
        this.mSurfaceView.setup(this.mName, r0.getKryptonApp());
        this.mSurfaceView.setTag("url:" + getLynxContext().getTemplateUrl() + ", tag_name:" + this.mName);
        this.mSurfaceViewSetup = true;
        return;
    L19:
        return;
    L17:
        throw new RuntimeException("Canvas environment has not setup!!");
    }

    public UISurfaceCanvas(LynxContext r2) {
        this(r2, null);
    }

    private static String canonicalizeZOrder(String r2) {
        if (r2 != null) goto L5;
        return "on-top";
    L5:
        String r3 = r2.trim().toLowerCase();
        if ("on-top".equals(r3) == false) goto L8;
    L13:
        return r3;
    L8:
        if ("media-overlay".equals(r3) == true) goto L13;
        if ("normal".equals(r3) == true) goto L13;
        return "on-top";
    }

    private static int parseZOrderMode(String r1) {
        if ("normal".equals(r1) == false) goto L7;
        return 0;
    L7:
        if ("media-overlay".equals(r1) == false) goto L10;
        return 2;
    L10:
        return 1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public FrameLayout createView(Context r2) {
        FrameLayout r0 = new FrameLayout(r2);
        this.mView = r0;
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchTouch(MotionEvent r4) {
        if (isUserInteractionEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mSurfaceView != null) goto L7;
        return false;
    L7:
        Rect r0 = getLynxContext().getUIBody().getBoundingClientRect();
        Rect r1 = getBoundingClientRect();
        return this.mSurfaceView.dispatchTouch(r4, r0, r1);
    }

    @LynxProp(name = "android-surface-z-order")
    public void setAndroidSurfaceZOrder(String r2) {
        String r3 = canonicalizeZOrder(r2);
        String r0 = this.mAndroidSurfaceZOrderValue;
        if (r0 != null) goto L5;
        this.mAndroidSurfaceZOrderMode = parseZOrderMode(r3);
        this.mAndroidSurfaceZOrderValue = r3;
        return;
    L5:
        if (TextUtils.equals(r0, r3) == true) goto L10;
        reportAndroidSurfaceZOrderMutation(this.mAndroidSurfaceZOrderValue, r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = EasyGoDbTable.Server.NAME)
    public void setName(String r2) {
        if (TextUtils.isEmpty(this.mName) == false) goto L5;
    L7:
        this.mName = r2;
        super.setName(r2);
        return;
    L5:
        if (TextUtils.equals(this.mName, r2) == true) goto L7;
        reportNameMutation(this.mName, r2);
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public UISurfaceCanvas(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mAndroidSurfaceZOrderMode = 1;
    }

    private void reportAndroidSurfaceZOrderMutation(String r3, String r4) {
        String r5 = "android-surface-z-order cannot be changed after first set. old=" + r3 + ", new=" + r4 + ", url=" + getLynxContext().getTemplateUrl() + ", name=" + this.mName;
        LLog.e(TAG, r5);
        throw new IllegalArgumentException(r5);
    }

    private void reportNameMutation(String r3, String r4) {
        String r5 = "name cannot be changed after first set. old=" + r3 + ", new=" + r4 + ", url=" + getLynxContext().getTemplateUrl();
        LLog.e(TAG, r5);
        throw new IllegalArgumentException(r5);
    }
}
