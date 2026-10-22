package com.lynx.animax.util;

import androidx.annotation.Keep;
import com.lynx.animax.UIAnimaX;
import com.lynx.animax.service.AnimaXFrescoImageService;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.h;
import gm.a;
import gm.b;
import ym.d;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxAnimaX {
    private static final String TAG = "LynxAnimaX";
    private static volatile LynxAnimaX sInstance;
    private volatile boolean mHasLibInit;
    private b mScope;

    private LynxAnimaX() {
        this.mScope = new b(TAG);
        this.mHasLibInit = false;
    }

    private void createGlobalServices() {
        a.b().c(this.mScope, com.lynx.animax.setting.b.class, new com.lynx.animax.setting.b());
        a.b().c(this.mScope, IAnimaXImageService.class, new AnimaXFrescoImageService());
    }

    private synchronized void initWithLock(h r5) {
        monitor-enter(this);
        AnimaX r10 = AnimaX.a();     // Catch: Throwable -> L8
        if (r10.f9710a == true) goto L6;
    L10:
        AnimaX r11 = AnimaX.a();     // Catch: Throwable -> L8
        if (r5 != null) goto L13;
        d r12 = null;
    L14:
        r11.b(r12);     // Catch: Throwable -> L8
    L16:
        if (this.mHasLibInit == false) goto L18;
    L23:
        monitor-exit(this);
        return;
    L18:
        if (AnimaX.a().c("animax_napi") == false) goto L23;
        createGlobalServices();     // Catch: Throwable -> L8
        this.mHasLibInit = true;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L13:
        r12 = new d(r5);     // Catch: Throwable -> L8
        goto L14
    L6:
        if (r10.d == false) goto L10;
    L8:
        th = move-exception;
        throw th;
    }

    public static LynxAnimaX inst() {
        if (sInstance != null) goto L16;
        monitor-enter(LynxAnimaX.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new LynxAnimaX();     // Catch: Throwable -> L9
    L11:
        monitor-exit(LynxAnimaX.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public LynxUI createUI(LynxContext r5) {
        init();     // Catch: Throwable -> L4
        return new UIAnimaX(r5);
    L4:
        th = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, TAG, "animax ui init error" + th.toString());
        return null;
    }

    public b getScope() {
        return this.mScope;
    }

    public boolean hasInitialized() {
        AnimaX r5 = AnimaX.a();
        if (r5.f9710a == true) goto L5;
        return false;
    L5:
        if (r5.d == true) goto L7;
        return false;
    L7:
        if (this.mHasLibInit == false) goto L13;
        return true;
    L13:
        return false;
    }

    public void init() {
        init(null);
    }

    public void init(h r5) {
        if (hasInitialized() == true) goto L6;
        initWithLock(r5);
        return;
    }
}
