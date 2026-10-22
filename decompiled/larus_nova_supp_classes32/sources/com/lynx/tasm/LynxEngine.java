package com.lynx.tasm;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.LynxUIRenderer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxEngine {
    public WeakReference<LynxTemplateRender> a;
    public long b;
    public final TemplateBundle c;
    public LynxEngineState d;
    public ThreadStrategyForRendering e;
    public ILynxUIRenderer f;
    public TasmPlatformInvoker g;
    public t1 h;

    public static final enum LynxEngineState extends Enum<LynxEngineState> {
        public static final LynxEngineState DESTROYED = null;
        public static final LynxEngineState FREEZED = null;
        public static final LynxEngineState ON_REUSING = null;
        public static final LynxEngineState READY_BE_REUSED = null;
        public static final LynxEngineState UN_LOADED = null;
        public static final /* synthetic */ LynxEngineState[] a = null;

        static {
            LynxEngineState r0 = new LynxEngineState("UN_LOADED", 0);
            UN_LOADED = r0;
            LynxEngineState r1 = new LynxEngineState("READY_BE_REUSED", 1);
            READY_BE_REUSED = r1;
            LynxEngineState r3 = new LynxEngineState("ON_REUSING", 2);
            ON_REUSING = r3;
            LynxEngineState r5 = new LynxEngineState("FREEZED", 3);
            FREEZED = r5;
            LynxEngineState r7 = new LynxEngineState("DESTROYED", 4);
            DESTROYED = r7;
            a = new LynxEngineState[]{r0, r1, r3, r5, r7};
        }

        public static LynxEngineState[] values() {
            return (LynxEngineState[]) a.clone();
        }

        public static LynxEngineState valueOf(String r1) {
            return (LynxEngineState) r27.a.a(LynxEngineState.class, r1);
        }

        public LynxEngineState(String r1, int r2) {
            super(r1, r2);
        }
    }

    private native long nativeCreate();

    private native void nativeDestroyEngine(long r1);

    private native long nativeDetachEngine(long r1);

    public final synchronized boolean a() {
        monitor-enter(this);
        if (this.d != LynxEngineState.READY_BE_REUSED) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c() {
        monitor-enter(this);
        if (this.d == LynxEngineState.UN_LOADED) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.d != LynxEngineState.READY_BE_REUSED) goto L9;
        e(LynxEngineState.ON_REUSING);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L9:
        monitor-exit(this);
        return false;
    }

    public final void b() {
        if (this.d == LynxEngineState.READY_BE_REUSED) goto L8;
        WeakReference<LynxTemplateRender> r0 = this.a;
        if (r0 == null) goto L8;
        if (r0.get() == null) goto L8;
    L15:
        e(LynxEngineState.DESTROYED);
        u.b.a.delete(this);
        long r1 = this.b;
        if (r1 == 0) goto L19;
        this.b = 0;
        nativeDestroyEngine(r1);
        return;
    L19:
        return;
    L8:
        ILynxUIRenderer r2 = this.f;
        if (r2 == null) goto L14;
        LynxUIRenderer r3 = (LynxUIRenderer) r2;
        r3.l();
        LynxUIOwner r4 = r3.b;
        if (r4 == null) goto L14;
        r4.destroy();
    L14:
        this.f = null;
        goto L15
    }

    public final String toString() {
        return "LynxEngineWrapper{mNativePtr=" + this.b + ", mLynxEngineState=" + this.d + '}';
    }

    public final synchronized void e(LynxEngineState r5) {
        monitor-enter(this);
        LLog.i("LynxEngineWrapper", this + "updateLynxEngineState:" + r5.name());     // Catch: Throwable -> L13
        LynxEngineState r1 = this.d;     // Catch: Throwable -> L13
        LynxEngineState r2 = LynxEngineState.DESTROYED;     // Catch: Throwable -> L13
        if (r1 != r2) goto L10;
        if (r5 == r2) goto L8;
        LLog.e("LynxEngineWrapper", "lynxEngineState has been destroyed." + this);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);
        return;
    L10:
        this.d = r5;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public LynxEngine(TemplateBundle r3, LynxTemplateRender r4) {
        this.d = LynxEngineState.UN_LOADED;
        this.b = nativeCreate();
        this.a = new WeakReference(r4);
        this.c = r3;
        this.e = r4.getThreadStrategyForRendering();
    }
}
