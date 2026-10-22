package com.bytedance.frameworks.baselib.network.http.cronet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TTAppStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2399a = "TTAppStateManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AppStartState f2400b;
    private static volatile AppStartState c;

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState Default = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        public static final AppStartState WeakNet = null;
        final int state;

        static {
            AppStartState r0 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r0;
            AppStartState r1 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r1;
            AppStartState r3 = new AppStartState("HotStart", 2, 1);
            HotStart = r3;
            AppStartState r5 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r5;
            AppStartState r7 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r7;
            AppStartState r9 = new AppStartState("Default", 5, 4);
            Default = r9;
            $VALUES = new AppStartState[]{r0, r1, r3, r5, r7, r9};
        }

        private AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        public static AppStartState valueOf(String r2) {
            return (AppStartState) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppStartState.class, r2), AppStartState.class, "com.obric.memorydata.plugin");
        }

        public static AppStartState[] values() {
            return (AppStartState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppStartState[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.state;
        }
    }

    static {
        f2400b = AppStartState.NormalStart;
        c = AppStartState.Default;
    }

    public TTAppStateManager() {
    }

    public static int a() {
        return f2400b.state;
    }
}
