package com.bytedance.ttnet.mpa;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class TTNetMpaService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f3291a = true;

    public static final enum HookMode extends Enum<HookMode> {
        private static final /* synthetic */ HookMode[] $VALUES = null;
        public static final HookMode BYTE = null;
        public static final HookMode SHADOW = null;
        public static final HookMode SYMBOL = null;

        static {
            HookMode r0 = new HookMode("SYMBOL", 0);
            SYMBOL = r0;
            HookMode r1 = new HookMode("BYTE", 1);
            BYTE = r1;
            HookMode r3 = new HookMode("SHADOW", 2);
            SHADOW = r3;
            $VALUES = new HookMode[]{r0, r1, r3};
        }

        private HookMode(String r1, int r2) {
            super(r1, r2);
        }

        public static HookMode valueOf(String r2) {
            return (HookMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(HookMode.class, r2), HookMode.class, "com.obric.memorydata.plugin");
        }

        public static HookMode[] values() {
            return (HookMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HookMode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    private TTNetMpaService() {
    }
}
