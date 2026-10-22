package com.bytedance.android.livesdk.feed;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface ApiCallBack {

    public static final enum ApiType extends Enum<ApiType> {
        public static final ApiType LOAD_MORE = null;
        public static final ApiType REFRESH = null;
        public static final /* synthetic */ ApiType[] a = null;

        static {
            ApiType r0 = new ApiType("REFRESH", 0);
            REFRESH = r0;
            ApiType r1 = new ApiType("LOAD_MORE", 1);
            LOAD_MORE = r1;
            a = new ApiType[]{r0, r1};
        }

        public static ApiType[] values() {
            return (ApiType[]) a.clone();
        }

        public static ApiType valueOf(String r1) {
            return (ApiType) r27.a.a(ApiType.class, r1);
        }

        public ApiType(String r1, int r2) {
            super(r1, r2);
        }
    }
}
