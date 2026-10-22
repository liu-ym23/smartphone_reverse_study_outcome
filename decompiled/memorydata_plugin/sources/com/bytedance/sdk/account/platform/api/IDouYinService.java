package com.bytedance.sdk.account.platform.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface IDouYinService extends b {

    public static final enum TargetAPP extends Enum<TargetAPP> {
        private static final /* synthetic */ TargetAPP[] $VALUES = null;
        public static final TargetAPP AWEME = null;
        public static final TargetAPP TIKTOK = null;

        static {
            TargetAPP r0 = new TargetAPP("AWEME", 0);
            AWEME = r0;
            TargetAPP r1 = new TargetAPP("TIKTOK", 1);
            TIKTOK = r1;
            $VALUES = new TargetAPP[]{r0, r1};
        }

        private TargetAPP(String r1, int r2) {
            super(r1, r2);
        }

        public static TargetAPP valueOf(String r2) {
            return (TargetAPP) ZeusTransformUtils.preCheckCast(Enum.valueOf(TargetAPP.class, r2), TargetAPP.class, "com.obric.memorydata.plugin");
        }

        public static TargetAPP[] values() {
            return (TargetAPP[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TargetAPP[].class, "com.obric.memorydata.plugin");
        }
    }
}
