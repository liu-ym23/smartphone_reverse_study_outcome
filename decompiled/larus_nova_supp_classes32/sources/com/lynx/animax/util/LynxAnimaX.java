package com.lynx.animax.util;

import com.lynx.animax.UIAnimaX;
import com.lynx.animax.service.AnimaXFrescoImageService;
import com.lynx.animax.service.IAnimaXImageService;
import com.lynx.tasm.INativeLibraryLoader;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import q4a.c;
import w4a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxAnimaX {
    private static final String TAG = "LynxAnimaX";
    private static volatile LynxAnimaX sInstance;
    private volatile boolean mHasLibInit;
    private e mScope;

    public class a implements c {
        public final /* synthetic */ INativeLibraryLoader a;

        public a(INativeLibraryLoader r1) {
            this.a = r1;
        }
    }

    public void init() {
        init(null);
    }

    public static LynxAnimaX inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LynxAnimaX.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LynxAnimaX();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LynxAnimaX.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private LynxAnimaX() {
        this.mScope = new e(TAG);
        this.mHasLibInit = false;
    }

    private void createGlobalServices() {
        w4a.a.b().c(this.mScope, w4a.c.class, new com.lynx.animax.setting.a());
        w4a.a.b().c(this.mScope, IAnimaXImageService.class, new AnimaXFrescoImageService());
    }

    public boolean hasInitialized() {
        if (AnimaX.e().a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mHasLibInit == false) goto L7;
        return true;
    }

    public e getScope() {
        return this.mScope;
    }

    private synchronized void initWithLock(INativeLibraryLoader r3) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (AnimaX.e().a == true) goto L11;
        AnimaX r0 = AnimaX.e();     // Catch: Throwable -> L19
        if (r3 != null) goto L8;
        a r4 = null;
    L9:
        r0.d(r4);     // Catch: Throwable -> L19
        goto L11
    L8:
        r4 = new a(r3);     // Catch: Throwable -> L19
    L11:
        if (this.mHasLibInit == false) goto L13;
    L17:
        monitor-exit(this);
        return;
    L13:
        if (AnimaX.e().f("animax_napi") == true) goto L16;
        monitor-exit(this);
        return;
    L16:
        createGlobalServices();     // Catch: Throwable -> L19
        this.mHasLibInit = true;     // Catch: Throwable -> L19
        goto L17
    }

    public LynxUI createUI(LynxContext r3) {
        init();     // Catch: Throwable -> L4
        return new UIAnimaX(r3);
    L4:
        th = move-exception;
        AnimaXLog.a(TAG, "animax ui init error" + th.toString());
        return null;
    }

    public void init(INativeLibraryLoader r2) {
        if (hasInitialized() == true) goto L6;
        initWithLock(r2);
        return;
    }
}
