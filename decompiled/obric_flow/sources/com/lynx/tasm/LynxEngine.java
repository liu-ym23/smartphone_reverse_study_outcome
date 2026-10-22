package com.lynx.tasm;

import com.lynx.base.log.LynxLog;

/* JADX INFO: loaded from: classes2.dex */
class LynxEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LynxEngineState f9965a;

    public static final enum LynxEngineState extends Enum<LynxEngineState> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final LynxEngineState f9966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final LynxEngineState f9967b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final LynxEngineState f9968c = null;
        public static final LynxEngineState d = null;
        public static final /* synthetic */ LynxEngineState[] e = null;

        static {
            LynxEngineState r5 = new LynxEngineState("UN_LOADED", 0);
            f9966a = r5;
            LynxEngineState r10 = new LynxEngineState("READY_BE_REUSED", 1);
            f9967b = r10;
            LynxEngineState r11 = new LynxEngineState("ON_REUSING", 2);
            f9968c = r11;
            LynxEngineState r12 = new LynxEngineState("FREEZED", 3);
            LynxEngineState r13 = new LynxEngineState("DESTROYED", 4);
            d = r13;
            e = new LynxEngineState[]{r5, r10, r11, r12, r13};
        }

        public LynxEngineState(String r5, int r10) {
            super(r5, r10);
        }

        public static LynxEngineState valueOf(String r5) {
            return (LynxEngineState) Enum.valueOf(LynxEngineState.class, r5);
        }

        public static LynxEngineState[] values() {
            return (LynxEngineState[]) e.clone();
        }
    }

    private native long nativeCreate();

    private native void nativeDestroyEngine(long r5);

    private native long nativeDetachEngine(long r5);

    public final synchronized void a(LynxEngineState r5) {
        monitor-enter(this);
        LynxLog.b(2, "LynxEngineWrapper", this + "updateLynxEngineState:" + r5.name());     // Catch: Throwable -> L9
        LynxEngineState r10 = this.f9965a;     // Catch: Throwable -> L9
        LynxEngineState r11 = LynxEngineState.d;     // Catch: Throwable -> L9
        if (r10 != r11) goto L13;
        if (r5 == r11) goto L11;
        LynxLog.b(4, "LynxEngineWrapper", "lynxEngineState has been destroyed." + this);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
        return;
    L13:
        this.f9965a = r5;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        return "LynxEngineWrapper{mNativePtr=0, mLynxEngineState=" + this.f9965a + '}';
    }
}
