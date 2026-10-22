package com.bytedance.android.live.openplatform.impl.minigamecommon.context;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface OnMiniGameLifecycleChangeListener {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigamecommon/context/OnMiniGameLifecycleChangeListener$MiniGameLifecycle;", "", "OnCreate", "OnResume", "OnStop", "OnExit", "OnDestroy", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MiniGameLifecycle extends Enum<MiniGameLifecycle> {
        public static final MiniGameLifecycle OnCreate = null;
        public static final MiniGameLifecycle OnDestroy = null;
        public static final MiniGameLifecycle OnExit = null;
        public static final MiniGameLifecycle OnResume = null;
        public static final MiniGameLifecycle OnStop = null;
        public static final /* synthetic */ MiniGameLifecycle[] a = null;

        static {
            MiniGameLifecycle r1 = new MiniGameLifecycle("OnCreate", 0);
            OnCreate = r1;
            MiniGameLifecycle r2 = new MiniGameLifecycle("OnResume", 1);
            OnResume = r2;
            MiniGameLifecycle r3 = new MiniGameLifecycle("OnStop", 2);
            OnStop = r3;
            MiniGameLifecycle r4 = new MiniGameLifecycle("OnExit", 3);
            OnExit = r4;
            MiniGameLifecycle r5 = new MiniGameLifecycle("OnDestroy", 4);
            OnDestroy = r5;
            a = new MiniGameLifecycle[]{r1, r2, r3, r4, r5};
        }

        public static MiniGameLifecycle valueOf(String r1) {
            return (MiniGameLifecycle) r27.a.a(MiniGameLifecycle.class, r1);
        }

        public static MiniGameLifecycle[] values() {
            return (MiniGameLifecycle[]) a.clone();
        }

        public MiniGameLifecycle(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a();

    void b();

    void c();

    void d();

    void e();
}
