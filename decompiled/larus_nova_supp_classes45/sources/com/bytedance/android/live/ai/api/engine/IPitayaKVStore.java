package com.bytedance.android.live.ai.api.engine;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface IPitayaKVStore {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ai/api/engine/IPitayaKVStore$ServiceType;", "", "IN_MEMORY_CACHE", "KV_STORE", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ServiceType extends Enum<ServiceType> {
        public static final ServiceType IN_MEMORY_CACHE = null;
        public static final ServiceType KV_STORE = null;
        public static final /* synthetic */ ServiceType[] a = null;

        static {
            ServiceType r1 = new ServiceType("IN_MEMORY_CACHE", 0);
            IN_MEMORY_CACHE = r1;
            ServiceType r2 = new ServiceType("KV_STORE", 1);
            KV_STORE = r2;
            a = new ServiceType[]{r1, r2};
        }

        public static ServiceType valueOf(String r1) {
            return (ServiceType) a.a(ServiceType.class, r1);
        }

        public static ServiceType[] values() {
            return (ServiceType[]) a.clone();
        }

        public ServiceType(String r1, int r2) {
            super(r1, r2);
        }
    }
}
