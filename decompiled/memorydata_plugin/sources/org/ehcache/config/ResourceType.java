package org.ehcache.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.ehcache.config.h;

/* JADX INFO: loaded from: classes7.dex */
public interface ResourceType<T extends h> {

    public static final enum Core extends Enum<Core> implements ResourceType<k> {
        private static final /* synthetic */ Core[] $VALUES = null;
        public static final Core DISK = null;
        public static final Core HEAP = null;
        public static final Core OFFHEAP = null;
        private final boolean persistable;
        private final boolean requiresSerialization;
        private final int tierHeight;

        static {
            Core r6 = new Core("HEAP", 0, false, false, 10000);
            HEAP = r6;
            Core r0 = new Core("OFFHEAP", 1, false, true, 1000);
            OFFHEAP = r0;
            Core r1 = new Core("DISK", 2, true, true, 100);
            DISK = r1;
            $VALUES = new Core[]{r6, r0, r1};
        }

        private Core(String r1, int r2, boolean r3, boolean r4, int r5) {
            super(r1, r2);
            this.persistable = r3;
            this.requiresSerialization = r4;
            this.tierHeight = r5;
        }

        public static Core valueOf(String r2) {
            return (Core) ZeusTransformUtils.preCheckCast(Enum.valueOf(Core.class, r2), Core.class, "com.obric.memorydata.plugin");
        }

        public static Core[] values() {
            return (Core[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Core[].class, "com.obric.memorydata.plugin");
        }

        @Override // org.ehcache.config.ResourceType
        public Class<k> getResourcePoolClass() {
            return k.class;
        }

        @Override // org.ehcache.config.ResourceType
        public int getTierHeight() {
            return this.tierHeight;
        }

        @Override // org.ehcache.config.ResourceType
        public boolean isPersistable() {
            return this.persistable;
        }

        @Override // org.ehcache.config.ResourceType
        public boolean requiresSerialization() {
            return this.requiresSerialization;
        }

        @Override // java.lang.Enum
        public String toString() {
            return name().toLowerCase();
        }
    }

    Class<T> getResourcePoolClass();

    int getTierHeight();

    boolean isPersistable();

    boolean requiresSerialization();
}
