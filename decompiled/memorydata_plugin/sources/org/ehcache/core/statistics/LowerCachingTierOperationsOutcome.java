package org.ehcache.core.statistics;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface LowerCachingTierOperationsOutcome {

    public static final enum GetAndRemoveOutcome extends Enum<GetAndRemoveOutcome> implements LowerCachingTierOperationsOutcome {
        private static final /* synthetic */ GetAndRemoveOutcome[] $VALUES = null;
        public static final GetAndRemoveOutcome HIT_REMOVED = null;
        public static final GetAndRemoveOutcome MISS = null;

        static {
            GetAndRemoveOutcome r0 = new GetAndRemoveOutcome("HIT_REMOVED", 0);
            HIT_REMOVED = r0;
            GetAndRemoveOutcome r1 = new GetAndRemoveOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new GetAndRemoveOutcome[]{r0, r1};
        }

        private GetAndRemoveOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static GetAndRemoveOutcome valueOf(String r2) {
            return (GetAndRemoveOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(GetAndRemoveOutcome.class, r2), GetAndRemoveOutcome.class, "com.obric.memorydata.plugin");
        }

        public static GetAndRemoveOutcome[] values() {
            return (GetAndRemoveOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GetAndRemoveOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum InstallMappingOutcome extends Enum<InstallMappingOutcome> implements LowerCachingTierOperationsOutcome {
        private static final /* synthetic */ InstallMappingOutcome[] $VALUES = null;
        public static final InstallMappingOutcome NOOP = null;
        public static final InstallMappingOutcome PUT = null;

        static {
            InstallMappingOutcome r0 = new InstallMappingOutcome(HttpMethodContrants.PUT, 0);
            PUT = r0;
            InstallMappingOutcome r1 = new InstallMappingOutcome("NOOP", 1);
            NOOP = r1;
            $VALUES = new InstallMappingOutcome[]{r0, r1};
        }

        private InstallMappingOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static InstallMappingOutcome valueOf(String r2) {
            return (InstallMappingOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(InstallMappingOutcome.class, r2), InstallMappingOutcome.class, "com.obric.memorydata.plugin");
        }

        public static InstallMappingOutcome[] values() {
            return (InstallMappingOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InstallMappingOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum InvalidateAllOutcome extends Enum<InvalidateAllOutcome> implements LowerCachingTierOperationsOutcome {
        private static final /* synthetic */ InvalidateAllOutcome[] $VALUES = null;
        public static final InvalidateAllOutcome FAILURE = null;
        public static final InvalidateAllOutcome SUCCESS = null;

        static {
            InvalidateAllOutcome r0 = new InvalidateAllOutcome("SUCCESS", 0);
            SUCCESS = r0;
            InvalidateAllOutcome r1 = new InvalidateAllOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new InvalidateAllOutcome[]{r0, r1};
        }

        private InvalidateAllOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static InvalidateAllOutcome valueOf(String r2) {
            return (InvalidateAllOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(InvalidateAllOutcome.class, r2), InvalidateAllOutcome.class, "com.obric.memorydata.plugin");
        }

        public static InvalidateAllOutcome[] values() {
            return (InvalidateAllOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InvalidateAllOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum InvalidateAllWithHashOutcome extends Enum<InvalidateAllWithHashOutcome> implements LowerCachingTierOperationsOutcome {
        private static final /* synthetic */ InvalidateAllWithHashOutcome[] $VALUES = null;
        public static final InvalidateAllWithHashOutcome SUCCESS = null;

        static {
            InvalidateAllWithHashOutcome r0 = new InvalidateAllWithHashOutcome("SUCCESS", 0);
            SUCCESS = r0;
            $VALUES = new InvalidateAllWithHashOutcome[]{r0};
        }

        private InvalidateAllWithHashOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static InvalidateAllWithHashOutcome valueOf(String r2) {
            return (InvalidateAllWithHashOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(InvalidateAllWithHashOutcome.class, r2), InvalidateAllWithHashOutcome.class, "com.obric.memorydata.plugin");
        }

        public static InvalidateAllWithHashOutcome[] values() {
            return (InvalidateAllWithHashOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InvalidateAllWithHashOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum InvalidateOutcome extends Enum<InvalidateOutcome> implements LowerCachingTierOperationsOutcome {
        private static final /* synthetic */ InvalidateOutcome[] $VALUES = null;
        public static final InvalidateOutcome MISS = null;
        public static final InvalidateOutcome REMOVED = null;

        static {
            InvalidateOutcome r0 = new InvalidateOutcome("REMOVED", 0);
            REMOVED = r0;
            InvalidateOutcome r1 = new InvalidateOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new InvalidateOutcome[]{r0, r1};
        }

        private InvalidateOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static InvalidateOutcome valueOf(String r2) {
            return (InvalidateOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(InvalidateOutcome.class, r2), InvalidateOutcome.class, "com.obric.memorydata.plugin");
        }

        public static InvalidateOutcome[] values() {
            return (InvalidateOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), InvalidateOutcome[].class, "com.obric.memorydata.plugin");
        }
    }
}
