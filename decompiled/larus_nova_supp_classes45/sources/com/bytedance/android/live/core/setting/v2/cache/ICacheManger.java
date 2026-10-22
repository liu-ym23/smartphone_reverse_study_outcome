package com.bytedance.android.live.core.setting.v2.cache;

import java.util.Map;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ICacheManger {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$CacheType;", "", "LOCAL_CACHE", "STICKY", "PRELOAD_CACHE", "TRANSIENT", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum CacheType extends Enum<CacheType> {
        public static final CacheType LOCAL_CACHE = null;
        public static final CacheType OBJECT = null;
        public static final CacheType PRELOAD_CACHE = null;
        public static final CacheType STICKY = null;
        public static final CacheType TRANSIENT = null;
        public static final /* synthetic */ CacheType[] a = null;

        static {
            CacheType r1 = new CacheType("LOCAL_CACHE", 0);
            LOCAL_CACHE = r1;
            CacheType r2 = new CacheType("STICKY", 1);
            STICKY = r2;
            CacheType r3 = new CacheType("PRELOAD_CACHE", 2);
            PRELOAD_CACHE = r3;
            CacheType r4 = new CacheType("TRANSIENT", 3);
            TRANSIENT = r4;
            CacheType r5 = new CacheType("OBJECT", 4);
            OBJECT = r5;
            a = new CacheType[]{r1, r2, r3, r4, r5};
        }

        public static CacheType valueOf(String r1) {
            return (CacheType) a.a(CacheType.class, r1);
        }

        public static CacheType[] values() {
            return (CacheType[]) a.clone();
        }

        public CacheType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "", "PLUS", "MINUS", "live-setting_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Operation extends Enum<Operation> {
        public static final Operation MINUS = null;
        public static final Operation PLUS = null;
        public static final /* synthetic */ Operation[] a = null;

        static {
            Operation r1 = new Operation("PLUS", 0);
            PLUS = r1;
            Operation r2 = new Operation("MINUS", 1);
            MINUS = r2;
            a = new Operation[]{r1, r2};
        }

        public static Operation valueOf(String r1) {
            return (Operation) a.a(Operation.class, r1);
        }

        public static Operation[] values() {
            return (Operation[]) a.clone();
        }

        public Operation(String r1, int r2) {
            super(r1, r2);
        }
    }

    boolean update(CacheType r1, Operation r2, Map<String, ? extends Object> r3);
}
