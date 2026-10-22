package com.ss.android.lark.http.netstate;

import android.content.Context;
import com.ss.android.lark.inv.export.router.InvRouter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class NetworkUtils {

    public static final enum CompressType extends Enum<CompressType> {
        public static final CompressType DEFLATER = null;
        public static final CompressType GZIP = null;
        public static final CompressType NONE = null;
        public static final /* synthetic */ CompressType[] a = null;
        final int nativeInt;

        static {
            CompressType r0 = new CompressType("NONE", 0, 0);
            NONE = r0;
            CompressType r1 = new CompressType("GZIP", 1, 1);
            GZIP = r1;
            CompressType r3 = new CompressType("DEFLATER", 2, 2);
            DEFLATER = r3;
            a = new CompressType[]{r0, r1, r3};
        }

        public static CompressType[] values() {
            return (CompressType[]) a.clone();
        }

        public static CompressType valueOf(String r1) {
            return (CompressType) r27.a.a(CompressType.class, r1);
        }

        public CompressType(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeInt = r3;
        }
    }

    public static final enum NetworkType extends Enum<NetworkType> {
        public static final NetworkType MOBILE = null;
        public static final NetworkType MOBILE_2G = null;
        public static final NetworkType MOBILE_3G = null;
        public static final NetworkType MOBILE_4G = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final /* synthetic */ NetworkType[] a = null;
        final int nativeInt;
        private final String nativeName;

        static {
            NetworkType r0 = new NetworkType("NONE", 0, 0, "unvailable");
            NONE = r0;
            NetworkType r1 = new NetworkType("MOBILE", 1, 1, "mobile");
            MOBILE = r1;
            NetworkType r2 = new NetworkType("MOBILE_2G", 2, 2, "mobile_2g");
            MOBILE_2G = r2;
            NetworkType r4 = new NetworkType("MOBILE_3G", 3, 3, "mobile_3g");
            MOBILE_3G = r4;
            NetworkType r6 = new NetworkType("WIFI", 4, 4, "wifi");
            WIFI = r6;
            NetworkType r8 = new NetworkType("MOBILE_4G", 5, 5, "mobile_4g");
            MOBILE_4G = r8;
            NetworkType r10 = new NetworkType("UNKNOWN", 6, 6, InvRouter.UNKNOWN);
            UNKNOWN = r10;
            a = new NetworkType[]{r0, r1, r2, r4, r6, r8, r10};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) a.clone();
        }

        public com.larksuite.framework.utils.NetworkUtils.NetworkType toType() {
            if (this != NONE) goto L7;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.NONE;
        L7:
            if (this != UNKNOWN) goto L11;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.UNKNOWN;
        L11:
            if (this != WIFI) goto L15;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.WIFI;
        L15:
            if (this != MOBILE_2G) goto L19;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_2G;
        L19:
            if (this != MOBILE_3G) goto L23;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_3G;
        L23:
            if (this != MOBILE_4G) goto L27;
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_4G;
        L27:
            return com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE;
        }

        public String getNativeName() {
            return this.nativeName;
        }

        public int getValue() {
            return this.nativeInt;
        }

        public static NetworkType from(com.larksuite.framework.utils.NetworkUtils.NetworkType r1) {
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.NONE) goto L7;
            return NONE;
        L7:
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.UNKNOWN) goto L11;
            return UNKNOWN;
        L11:
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.WIFI) goto L15;
            return WIFI;
        L15:
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_2G) goto L19;
            return MOBILE_2G;
        L19:
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_3G) goto L23;
            return MOBILE_3G;
        L23:
            if (r1 != com.larksuite.framework.utils.NetworkUtils.NetworkType.MOBILE_4G) goto L27;
            return MOBILE_4G;
        L27:
            return MOBILE;
        }

        public static NetworkType valueOf(String r1) {
            return (NetworkType) r27.a.a(NetworkType.class, r1);
        }

        public NetworkType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.nativeInt = r3;
            this.nativeName = r4;
        }
    }

    public static NetworkType a(Context r0) {
        return NetworkType.from(com.larksuite.framework.utils.NetworkUtils.b(r0));
    }
}
