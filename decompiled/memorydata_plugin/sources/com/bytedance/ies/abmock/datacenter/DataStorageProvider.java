package com.bytedance.ies.abmock.datacenter;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface DataStorageProvider {

    public static final enum StorageType extends Enum<StorageType> {
        private static final /* synthetic */ StorageType[] $VALUES = null;
        public static final StorageType CONFIG = null;
        public static final StorageType CONFIG_META = null;
        public static final StorageType LAUNCH_CONFIG = null;
        public static final StorageType LIBRA_CONFIG = null;
        public static final StorageType PRECISE_EXPOSURE = null;
        public static final StorageType UNREGISTER_CONFIG = null;

        static {
            StorageType r0 = new StorageType("CONFIG", 0);
            CONFIG = r0;
            StorageType r1 = new StorageType("LIBRA_CONFIG", 1);
            LIBRA_CONFIG = r1;
            StorageType r3 = new StorageType("UNREGISTER_CONFIG", 2);
            UNREGISTER_CONFIG = r3;
            StorageType r5 = new StorageType("PRECISE_EXPOSURE", 3);
            PRECISE_EXPOSURE = r5;
            StorageType r7 = new StorageType("CONFIG_META", 4);
            CONFIG_META = r7;
            StorageType r9 = new StorageType("LAUNCH_CONFIG", 5);
            LAUNCH_CONFIG = r9;
            $VALUES = new StorageType[]{r0, r1, r3, r5, r7, r9};
        }

        private StorageType(String r1, int r2) {
            super(r1, r2);
        }

        public static StorageType valueOf(String r2) {
            return (StorageType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StorageType.class, r2), StorageType.class, "com.obric.memorydata.plugin");
        }

        public static StorageType[] values() {
            return (StorageType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StorageType[].class, "com.obric.memorydata.plugin");
        }
    }

    public interface a {
    }

    com.bytedance.ies.abmock.datacenter.storage.e a();

    void a(a r1);

    com.bytedance.ies.abmock.datacenter.storage.e b();

    com.bytedance.ies.abmock.datacenter.storage.e c();

    com.bytedance.ies.abmock.datacenter.storage.e d();

    com.bytedance.ies.abmock.datacenter.storage.e e();

    com.bytedance.ies.abmock.datacenter.storage.e f();

    com.bytedance.ies.abmock.datacenter.storage.e g();

    com.bytedance.ies.abmock.datacenter.storage.e h();

    com.bytedance.ies.abmock.datacenter.storage.e i();

    com.bytedance.ies.abmock.datacenter.storage.e j();
}
