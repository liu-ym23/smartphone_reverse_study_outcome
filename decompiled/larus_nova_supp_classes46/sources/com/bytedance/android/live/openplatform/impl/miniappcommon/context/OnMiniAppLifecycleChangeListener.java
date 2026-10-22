package com.bytedance.android.live.openplatform.impl.miniappcommon.context;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface OnMiniAppLifecycleChangeListener {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/context/OnMiniAppLifecycleChangeListener$MiniAppLifecycle;", "", "OnCreate", "OnResume", "OnStop", "OnDestroy", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum MiniAppLifecycle extends Enum<MiniAppLifecycle> {
        public static final MiniAppLifecycle OnCreate = null;
        public static final MiniAppLifecycle OnDestroy = null;
        public static final MiniAppLifecycle OnResume = null;
        public static final MiniAppLifecycle OnStop = null;
        public static final /* synthetic */ MiniAppLifecycle[] a = null;

        static {
            MiniAppLifecycle r1 = new MiniAppLifecycle("OnCreate", 0);
            OnCreate = r1;
            MiniAppLifecycle r2 = new MiniAppLifecycle("OnResume", 1);
            OnResume = r2;
            MiniAppLifecycle r3 = new MiniAppLifecycle("OnStop", 2);
            OnStop = r3;
            MiniAppLifecycle r4 = new MiniAppLifecycle("OnDestroy", 3);
            OnDestroy = r4;
            a = new MiniAppLifecycle[]{r1, r2, r3, r4};
        }

        public static MiniAppLifecycle valueOf(String r1) {
            return (MiniAppLifecycle) r27.a.a(MiniAppLifecycle.class, r1);
        }

        public static MiniAppLifecycle[] values() {
            return (MiniAppLifecycle[]) a.clone();
        }

        public MiniAppLifecycle(String r1, int r2) {
            super(r1, r2);
        }
    }

    void a();

    void b();

    void c();

    void d();
}
