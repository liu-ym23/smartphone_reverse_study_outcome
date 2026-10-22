package org.ehcache.core.statistics;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface CacheOperationOutcomes {

    public static final enum ClearOutcome extends Enum<ClearOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ ClearOutcome[] $VALUES = null;
        public static final ClearOutcome FAILURE = null;
        public static final ClearOutcome SUCCESS = null;

        static {
            ClearOutcome r0 = new ClearOutcome("SUCCESS", 0);
            SUCCESS = r0;
            ClearOutcome r1 = new ClearOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new ClearOutcome[]{r0, r1};
        }

        private ClearOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ClearOutcome valueOf(String r2) {
            return (ClearOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClearOutcome.class, r2), ClearOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ClearOutcome[] values() {
            return (ClearOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClearOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ConditionalRemoveOutcome extends Enum<ConditionalRemoveOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ ConditionalRemoveOutcome[] $VALUES = null;
        public static final ConditionalRemoveOutcome FAILURE = null;
        public static final ConditionalRemoveOutcome FAILURE_KEY_MISSING = null;
        public static final ConditionalRemoveOutcome FAILURE_KEY_PRESENT = null;
        public static final ConditionalRemoveOutcome SUCCESS = null;

        static {
            ConditionalRemoveOutcome r0 = new ConditionalRemoveOutcome("SUCCESS", 0);
            SUCCESS = r0;
            ConditionalRemoveOutcome r1 = new ConditionalRemoveOutcome("FAILURE_KEY_PRESENT", 1);
            FAILURE_KEY_PRESENT = r1;
            ConditionalRemoveOutcome r3 = new ConditionalRemoveOutcome("FAILURE_KEY_MISSING", 2);
            FAILURE_KEY_MISSING = r3;
            ConditionalRemoveOutcome r5 = new ConditionalRemoveOutcome("FAILURE", 3);
            FAILURE = r5;
            $VALUES = new ConditionalRemoveOutcome[]{r0, r1, r3, r5};
        }

        private ConditionalRemoveOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ConditionalRemoveOutcome valueOf(String r2) {
            return (ConditionalRemoveOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConditionalRemoveOutcome.class, r2), ConditionalRemoveOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ConditionalRemoveOutcome[] values() {
            return (ConditionalRemoveOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConditionalRemoveOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum GetAllOutcome extends Enum<GetAllOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ GetAllOutcome[] $VALUES = null;
        public static final GetAllOutcome FAILURE = null;
        public static final GetAllOutcome SUCCESS = null;

        static {
            GetAllOutcome r0 = new GetAllOutcome("SUCCESS", 0);
            SUCCESS = r0;
            GetAllOutcome r1 = new GetAllOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new GetAllOutcome[]{r0, r1};
        }

        private GetAllOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static GetAllOutcome valueOf(String r2) {
            return (GetAllOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(GetAllOutcome.class, r2), GetAllOutcome.class, "com.obric.memorydata.plugin");
        }

        public static GetAllOutcome[] values() {
            return (GetAllOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GetAllOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum GetOutcome extends Enum<GetOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ GetOutcome[] $VALUES = null;
        public static final GetOutcome FAILURE = null;
        public static final GetOutcome HIT = null;
        public static final GetOutcome MISS = null;

        static {
            GetOutcome r0 = new GetOutcome("HIT", 0);
            HIT = r0;
            GetOutcome r1 = new GetOutcome("MISS", 1);
            MISS = r1;
            GetOutcome r3 = new GetOutcome("FAILURE", 2);
            FAILURE = r3;
            $VALUES = new GetOutcome[]{r0, r1, r3};
        }

        private GetOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static GetOutcome valueOf(String r2) {
            return (GetOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(GetOutcome.class, r2), GetOutcome.class, "com.obric.memorydata.plugin");
        }

        public static GetOutcome[] values() {
            return (GetOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GetOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PutAllOutcome extends Enum<PutAllOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ PutAllOutcome[] $VALUES = null;
        public static final PutAllOutcome FAILURE = null;
        public static final PutAllOutcome SUCCESS = null;

        static {
            PutAllOutcome r0 = new PutAllOutcome("SUCCESS", 0);
            SUCCESS = r0;
            PutAllOutcome r1 = new PutAllOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new PutAllOutcome[]{r0, r1};
        }

        private PutAllOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static PutAllOutcome valueOf(String r2) {
            return (PutAllOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(PutAllOutcome.class, r2), PutAllOutcome.class, "com.obric.memorydata.plugin");
        }

        public static PutAllOutcome[] values() {
            return (PutAllOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PutAllOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PutIfAbsentOutcome extends Enum<PutIfAbsentOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ PutIfAbsentOutcome[] $VALUES = null;
        public static final PutIfAbsentOutcome FAILURE = null;
        public static final PutIfAbsentOutcome HIT = null;
        public static final PutIfAbsentOutcome PUT = null;

        static {
            PutIfAbsentOutcome r0 = new PutIfAbsentOutcome(HttpMethodContrants.PUT, 0);
            PUT = r0;
            PutIfAbsentOutcome r1 = new PutIfAbsentOutcome("HIT", 1);
            HIT = r1;
            PutIfAbsentOutcome r3 = new PutIfAbsentOutcome("FAILURE", 2);
            FAILURE = r3;
            $VALUES = new PutIfAbsentOutcome[]{r0, r1, r3};
        }

        private PutIfAbsentOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static PutIfAbsentOutcome valueOf(String r2) {
            return (PutIfAbsentOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(PutIfAbsentOutcome.class, r2), PutIfAbsentOutcome.class, "com.obric.memorydata.plugin");
        }

        public static PutIfAbsentOutcome[] values() {
            return (PutIfAbsentOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PutIfAbsentOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PutOutcome extends Enum<PutOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ PutOutcome[] $VALUES = null;
        public static final PutOutcome FAILURE = null;
        public static final PutOutcome NOOP = null;
        public static final PutOutcome PUT = null;

        static {
            PutOutcome r0 = new PutOutcome(HttpMethodContrants.PUT, 0);
            PUT = r0;
            PutOutcome r1 = new PutOutcome("NOOP", 1);
            NOOP = r1;
            PutOutcome r3 = new PutOutcome("FAILURE", 2);
            FAILURE = r3;
            $VALUES = new PutOutcome[]{r0, r1, r3};
        }

        private PutOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static PutOutcome valueOf(String r2) {
            return (PutOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(PutOutcome.class, r2), PutOutcome.class, "com.obric.memorydata.plugin");
        }

        public static PutOutcome[] values() {
            return (PutOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PutOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum RemoveAllOutcome extends Enum<RemoveAllOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ RemoveAllOutcome[] $VALUES = null;
        public static final RemoveAllOutcome FAILURE = null;
        public static final RemoveAllOutcome SUCCESS = null;

        static {
            RemoveAllOutcome r0 = new RemoveAllOutcome("SUCCESS", 0);
            SUCCESS = r0;
            RemoveAllOutcome r1 = new RemoveAllOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new RemoveAllOutcome[]{r0, r1};
        }

        private RemoveAllOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static RemoveAllOutcome valueOf(String r2) {
            return (RemoveAllOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(RemoveAllOutcome.class, r2), RemoveAllOutcome.class, "com.obric.memorydata.plugin");
        }

        public static RemoveAllOutcome[] values() {
            return (RemoveAllOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RemoveAllOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum RemoveOutcome extends Enum<RemoveOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ RemoveOutcome[] $VALUES = null;
        public static final RemoveOutcome FAILURE = null;
        public static final RemoveOutcome NOOP = null;
        public static final RemoveOutcome SUCCESS = null;

        static {
            RemoveOutcome r0 = new RemoveOutcome("SUCCESS", 0);
            SUCCESS = r0;
            RemoveOutcome r1 = new RemoveOutcome("NOOP", 1);
            NOOP = r1;
            RemoveOutcome r3 = new RemoveOutcome("FAILURE", 2);
            FAILURE = r3;
            $VALUES = new RemoveOutcome[]{r0, r1, r3};
        }

        private RemoveOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static RemoveOutcome valueOf(String r2) {
            return (RemoveOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(RemoveOutcome.class, r2), RemoveOutcome.class, "com.obric.memorydata.plugin");
        }

        public static RemoveOutcome[] values() {
            return (RemoveOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RemoveOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ReplaceOutcome extends Enum<ReplaceOutcome> implements CacheOperationOutcomes {
        private static final /* synthetic */ ReplaceOutcome[] $VALUES = null;
        public static final ReplaceOutcome FAILURE = null;
        public static final ReplaceOutcome HIT = null;
        public static final ReplaceOutcome MISS_NOT_PRESENT = null;
        public static final ReplaceOutcome MISS_PRESENT = null;

        static {
            ReplaceOutcome r0 = new ReplaceOutcome("HIT", 0);
            HIT = r0;
            ReplaceOutcome r1 = new ReplaceOutcome("MISS_PRESENT", 1);
            MISS_PRESENT = r1;
            ReplaceOutcome r3 = new ReplaceOutcome("MISS_NOT_PRESENT", 2);
            MISS_NOT_PRESENT = r3;
            ReplaceOutcome r5 = new ReplaceOutcome("FAILURE", 3);
            FAILURE = r5;
            $VALUES = new ReplaceOutcome[]{r0, r1, r3, r5};
        }

        private ReplaceOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ReplaceOutcome valueOf(String r2) {
            return (ReplaceOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ReplaceOutcome.class, r2), ReplaceOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ReplaceOutcome[] values() {
            return (ReplaceOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ReplaceOutcome[].class, "com.obric.memorydata.plugin");
        }
    }
}
