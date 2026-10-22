package org.ehcache.spi.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
@b
public interface MaintainableService extends c {

    public static final enum MaintenanceScope extends Enum<MaintenanceScope> {
        private static final /* synthetic */ MaintenanceScope[] $VALUES = null;
        public static final MaintenanceScope CACHE = null;
        public static final MaintenanceScope CACHE_MANAGER = null;

        static {
            MaintenanceScope r0 = new MaintenanceScope("CACHE_MANAGER", 0);
            CACHE_MANAGER = r0;
            MaintenanceScope r1 = new MaintenanceScope("CACHE", 1);
            CACHE = r1;
            $VALUES = new MaintenanceScope[]{r0, r1};
        }

        private MaintenanceScope(String r1, int r2) {
            super(r1, r2);
        }

        public static MaintenanceScope valueOf(String r2) {
            return (MaintenanceScope) ZeusTransformUtils.preCheckCast(Enum.valueOf(MaintenanceScope.class, r2), MaintenanceScope.class, "com.obric.memorydata.plugin");
        }

        public static MaintenanceScope[] values() {
            return (MaintenanceScope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MaintenanceScope[].class, "com.obric.memorydata.plugin");
        }
    }
}
