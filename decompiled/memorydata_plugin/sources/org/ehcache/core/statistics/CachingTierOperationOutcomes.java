package org.ehcache.core.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface CachingTierOperationOutcomes {

    public static final enum GetOrComputeIfAbsentOutcome extends Enum<GetOrComputeIfAbsentOutcome> implements CachingTierOperationOutcomes {
        private static final /* synthetic */ GetOrComputeIfAbsentOutcome[] $VALUES = null;
        public static final GetOrComputeIfAbsentOutcome FAULTED = null;
        public static final GetOrComputeIfAbsentOutcome FAULT_FAILED = null;
        public static final GetOrComputeIfAbsentOutcome FAULT_FAILED_MISS = null;
        public static final GetOrComputeIfAbsentOutcome HIT = null;
        public static final GetOrComputeIfAbsentOutcome MISS = null;

        static {
            GetOrComputeIfAbsentOutcome r0 = new GetOrComputeIfAbsentOutcome("HIT", 0);
            HIT = r0;
            GetOrComputeIfAbsentOutcome r1 = new GetOrComputeIfAbsentOutcome("FAULTED", 1);
            FAULTED = r1;
            GetOrComputeIfAbsentOutcome r3 = new GetOrComputeIfAbsentOutcome("FAULT_FAILED", 2);
            FAULT_FAILED = r3;
            GetOrComputeIfAbsentOutcome r5 = new GetOrComputeIfAbsentOutcome("FAULT_FAILED_MISS", 3);
            FAULT_FAILED_MISS = r5;
            GetOrComputeIfAbsentOutcome r7 = new GetOrComputeIfAbsentOutcome("MISS", 4);
            MISS = r7;
            $VALUES = new GetOrComputeIfAbsentOutcome[]{r0, r1, r3, r5, r7};
        }

        private GetOrComputeIfAbsentOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static GetOrComputeIfAbsentOutcome valueOf(String r2) {
            return (GetOrComputeIfAbsentOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(GetOrComputeIfAbsentOutcome.class, r2), GetOrComputeIfAbsentOutcome.class, "com.obric.memorydata.plugin");
        }

        public static GetOrComputeIfAbsentOutcome[] values() {
            return (GetOrComputeIfAbsentOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GetOrComputeIfAbsentOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum InvalidateAllOutcome extends Enum<InvalidateAllOutcome> implements CachingTierOperationOutcomes {
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

    public static final enum InvalidateAllWithHashOutcome extends Enum<InvalidateAllWithHashOutcome> implements CachingTierOperationOutcomes {
        private static final /* synthetic */ InvalidateAllWithHashOutcome[] $VALUES = null;
        public static final InvalidateAllWithHashOutcome FAILURE = null;
        public static final InvalidateAllWithHashOutcome SUCCESS = null;

        static {
            InvalidateAllWithHashOutcome r0 = new InvalidateAllWithHashOutcome("SUCCESS", 0);
            SUCCESS = r0;
            InvalidateAllWithHashOutcome r1 = new InvalidateAllWithHashOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new InvalidateAllWithHashOutcome[]{r0, r1};
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

    public static final enum InvalidateOutcome extends Enum<InvalidateOutcome> implements CachingTierOperationOutcomes {
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
