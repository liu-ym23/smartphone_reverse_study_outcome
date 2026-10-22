package com.lynx.tasm.behavior.ui.krypton;

import com.lynx.jsbridge.d;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxKryptonModule extends d {
    public static final String TAG = "LynxKryptonModule";
    private LynxKryptonHelper mKryptonHelper;
    private long mNativePtr;

    private native long nativeCreate();

    private native void nativeDestroy(long r1);

    private native long nativeGetExtensionDelegatePtr(long r1, long r3);

    @Override // com.lynx.jsbridge.d
    public void destroy() {
        this.mKryptonHelper.deInit();
        nativeDestroy(this.mNativePtr);
        this.mNativePtr = 0;
    }

    @Override // com.lynx.jsbridge.d
    public long getExtensionDelegatePtr() {
        if (this.mNativePtr != 0) goto L6;
        LLog.e(TAG, "native ptr is 0");
        return 0;
    L6:
        CanvasRuntimeMediator r0 = new CanvasRuntimeMediator(this.mContext);
        this.mKryptonHelper.registerCanvasRuntimeMediator(r0);
        long r5 = r0.getNativePtr();
        if (r5 != 0) goto L10;
        LLog.e(TAG, "mediator ptr is 0");
        return 0;
    L10:
        long r1 = nativeGetExtensionDelegatePtr(this.mNativePtr, r5);
        r0.resetNativePtr(r5);
        return r1;
    }

    @Override // com.lynx.jsbridge.d
    public void setUp() {
        LynxGroup r0 = this.mGroup;
        if (r0 == null) goto L10;
        if (r0.enableCanvas() == false) goto L10;
        LLog.i(TAG, "LynxKryptonModule setup success with LynxGroup id: " + this.mGroup.getID() + " current url: " + this.mContext.getTemplateUrl());
        this.mKryptonHelper.setupCanvasIfEnableCanvas();
        return;
    L10:
        if (this.mGroup != null) goto L12;
        LLog.e(TAG, "LynxKryptonModule setup failed because LynxGroup is null, current url: " + this.mContext.getTemplateUrl());
        return;
    L12:
        LLog.e(TAG, "LynxKryptonModule setup failed because LynxGroup id: " + this.mGroup.getID() + " is not enable canvas, current url: " + this.mContext.getTemplateUrl());
    }

    public LynxKryptonHelper getLynxKryptonHelper() {
        return this.mKryptonHelper;
    }

    @Override // com.lynx.jsbridge.d
    public void onTemplateLoad(String r3) {
        LLog.i(TAG, "LynxKryptonModule onTemplateLoad " + r3 + " this: " + this);
        this.mKryptonHelper.onTemplateLoad(r3);
    }

    public LynxKryptonModule(LynxContext r1, LynxGroup r2, c r3) {
        super(r1, r2, r3);
        this.mNativePtr = 0;
        this.mKryptonHelper = new LynxKryptonHelper(r3);
        this.mNativePtr = nativeCreate();
        LLog.i(TAG, "LynxKryptonModule create");
    }
}
