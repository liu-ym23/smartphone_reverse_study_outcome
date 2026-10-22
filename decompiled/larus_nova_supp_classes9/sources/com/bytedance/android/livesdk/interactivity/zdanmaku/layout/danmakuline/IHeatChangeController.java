package com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface IHeatChangeController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/layout/danmakuline/IHeatChangeController$DanmakuHeat;", BuildConfig.FLAVOR, "LOW", "MEDIUM", "HIGH", "NORMAL", "HIGH_MAX", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DanmakuHeat extends Enum<DanmakuHeat> {
        public static final DanmakuHeat HIGH = null;
        public static final DanmakuHeat HIGH_MAX = null;
        public static final DanmakuHeat LOW = null;
        public static final DanmakuHeat MEDIUM = null;
        public static final DanmakuHeat NORMAL = null;
        public static final /* synthetic */ DanmakuHeat[] a = null;

        static {
            DanmakuHeat r1 = new DanmakuHeat("LOW", 0);
            LOW = r1;
            DanmakuHeat r2 = new DanmakuHeat("MEDIUM", 1);
            MEDIUM = r2;
            DanmakuHeat r3 = new DanmakuHeat("HIGH", 2);
            HIGH = r3;
            DanmakuHeat r4 = new DanmakuHeat("NORMAL", 3);
            NORMAL = r4;
            DanmakuHeat r5 = new DanmakuHeat("HIGH_MAX", 4);
            HIGH_MAX = r5;
            a = new DanmakuHeat[]{r1, r2, r3, r4, r5};
        }

        public static DanmakuHeat valueOf(String r1) {
            return (DanmakuHeat) a.a(DanmakuHeat.class, r1);
        }

        public static DanmakuHeat[] values() {
            return (DanmakuHeat[]) a.clone();
        }

        public DanmakuHeat(String r1, int r2) {
            super(r1, r2);
        }
    }

    DanmakuHeat a();
}
