package com.bytedance.framwork.core.monitor;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MonitorNetUtil {

    public static final enum CompressType extends Enum<CompressType> {
        private static final /* synthetic */ CompressType[] $VALUES = null;
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            $VALUES = new CompressType[]{r0, r1, r3};
        }

        private CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static CompressType valueOf(String r2) {
            return (CompressType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CompressType.class, r2), CompressType.class, "com.obric.memorydata.plugin");
        }

        public static CompressType[] values() {
            return (CompressType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CompressType[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType WIFI = null;
        final int nativeInt;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0);
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1);
            MOBILE = r1;
            NetworkType r3 = new NetworkType("MOBILE_2G", 2, 2);
            MOBILE_2G = r3;
            NetworkType r5 = new NetworkType("MOBILE_3G", 3, 3);
            MOBILE_3G = r5;
            NetworkType r7 = new NetworkType("WIFI", 4, 4);
            WIFI = r7;
            NetworkType r9 = new NetworkType("MOBILE_4G", 5, 5);
            MOBILE_4G = r9;
            $VALUES = new NetworkType[]{r0, r1, r3, r5, r7, r9};
        }

        private NetworkType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }

        public static NetworkType valueOf(String r2) {
            return (NetworkType) ZeusTransformUtils.preCheckCast(Enum.valueOf(NetworkType.class, r2), NetworkType.class, "com.obric.memorydata.plugin");
        }

        public static NetworkType[] values() {
            return (NetworkType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NetworkType[].class, "com.obric.memorydata.plugin");
        }

        public int getValue() {
            return this.nativeInt;
        }
    }
}
