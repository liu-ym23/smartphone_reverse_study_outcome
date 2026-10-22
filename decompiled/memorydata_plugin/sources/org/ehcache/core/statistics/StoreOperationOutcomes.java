package org.ehcache.core.statistics;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface StoreOperationOutcomes {

    public static final enum ComputeIfAbsentOutcome extends Enum<ComputeIfAbsentOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ComputeIfAbsentOutcome[] $VALUES = null;
        public static final ComputeIfAbsentOutcome HIT = null;
        public static final ComputeIfAbsentOutcome NOOP = null;
        public static final ComputeIfAbsentOutcome PUT = null;

        static {
            ComputeIfAbsentOutcome r0 = new ComputeIfAbsentOutcome("HIT", 0);
            HIT = r0;
            ComputeIfAbsentOutcome r1 = new ComputeIfAbsentOutcome(HttpMethodContrants.PUT, 1);
            PUT = r1;
            ComputeIfAbsentOutcome r3 = new ComputeIfAbsentOutcome("NOOP", 2);
            NOOP = r3;
            $VALUES = new ComputeIfAbsentOutcome[]{r0, r1, r3};
        }

        private ComputeIfAbsentOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ComputeIfAbsentOutcome valueOf(String r2) {
            return (ComputeIfAbsentOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ComputeIfAbsentOutcome.class, r2), ComputeIfAbsentOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ComputeIfAbsentOutcome[] values() {
            return (ComputeIfAbsentOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ComputeIfAbsentOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ComputeOutcome extends Enum<ComputeOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ComputeOutcome[] $VALUES = null;
        public static final ComputeOutcome HIT = null;
        public static final ComputeOutcome MISS = null;
        public static final ComputeOutcome PUT = null;
        public static final ComputeOutcome REMOVED = null;

        static {
            ComputeOutcome r0 = new ComputeOutcome("HIT", 0);
            HIT = r0;
            ComputeOutcome r1 = new ComputeOutcome("MISS", 1);
            MISS = r1;
            ComputeOutcome r3 = new ComputeOutcome(HttpMethodContrants.PUT, 2);
            PUT = r3;
            ComputeOutcome r5 = new ComputeOutcome("REMOVED", 3);
            REMOVED = r5;
            $VALUES = new ComputeOutcome[]{r0, r1, r3, r5};
        }

        private ComputeOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ComputeOutcome valueOf(String r2) {
            return (ComputeOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ComputeOutcome.class, r2), ComputeOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ComputeOutcome[] values() {
            return (ComputeOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ComputeOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ConditionalRemoveOutcome extends Enum<ConditionalRemoveOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ConditionalRemoveOutcome[] $VALUES = null;
        public static final ConditionalRemoveOutcome MISS = null;
        public static final ConditionalRemoveOutcome REMOVED = null;

        static {
            ConditionalRemoveOutcome r0 = new ConditionalRemoveOutcome("REMOVED", 0);
            REMOVED = r0;
            ConditionalRemoveOutcome r1 = new ConditionalRemoveOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new ConditionalRemoveOutcome[]{r0, r1};
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

    public static final enum ConditionalReplaceOutcome extends Enum<ConditionalReplaceOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ConditionalReplaceOutcome[] $VALUES = null;
        public static final ConditionalReplaceOutcome MISS = null;
        public static final ConditionalReplaceOutcome REPLACED = null;

        static {
            ConditionalReplaceOutcome r0 = new ConditionalReplaceOutcome("REPLACED", 0);
            REPLACED = r0;
            ConditionalReplaceOutcome r1 = new ConditionalReplaceOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new ConditionalReplaceOutcome[]{r0, r1};
        }

        private ConditionalReplaceOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ConditionalReplaceOutcome valueOf(String r2) {
            return (ConditionalReplaceOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ConditionalReplaceOutcome.class, r2), ConditionalReplaceOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ConditionalReplaceOutcome[] values() {
            return (ConditionalReplaceOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ConditionalReplaceOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum EvictionOutcome extends Enum<EvictionOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ EvictionOutcome[] $VALUES = null;
        public static final EvictionOutcome FAILURE = null;
        public static final EvictionOutcome SUCCESS = null;

        static {
            EvictionOutcome r0 = new EvictionOutcome("SUCCESS", 0);
            SUCCESS = r0;
            EvictionOutcome r1 = new EvictionOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new EvictionOutcome[]{r0, r1};
        }

        private EvictionOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static EvictionOutcome valueOf(String r2) {
            return (EvictionOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(EvictionOutcome.class, r2), EvictionOutcome.class, "com.obric.memorydata.plugin");
        }

        public static EvictionOutcome[] values() {
            return (EvictionOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EvictionOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum ExpirationOutcome extends Enum<ExpirationOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ExpirationOutcome[] $VALUES = null;
        public static final ExpirationOutcome SUCCESS = null;

        static {
            ExpirationOutcome r0 = new ExpirationOutcome("SUCCESS", 0);
            SUCCESS = r0;
            $VALUES = new ExpirationOutcome[]{r0};
        }

        private ExpirationOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ExpirationOutcome valueOf(String r2) {
            return (ExpirationOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExpirationOutcome.class, r2), ExpirationOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ExpirationOutcome[] values() {
            return (ExpirationOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExpirationOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum GetOutcome extends Enum<GetOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ GetOutcome[] $VALUES = null;
        public static final GetOutcome HIT = null;
        public static final GetOutcome MISS = null;
        public static final GetOutcome TIMEOUT = null;

        static {
            GetOutcome r0 = new GetOutcome("HIT", 0);
            HIT = r0;
            GetOutcome r1 = new GetOutcome("MISS", 1);
            MISS = r1;
            GetOutcome r3 = new GetOutcome("TIMEOUT", 2);
            TIMEOUT = r3;
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

    public static final enum PutIfAbsentOutcome extends Enum<PutIfAbsentOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ PutIfAbsentOutcome[] $VALUES = null;
        public static final PutIfAbsentOutcome HIT = null;
        public static final PutIfAbsentOutcome PUT = null;

        static {
            PutIfAbsentOutcome r0 = new PutIfAbsentOutcome(HttpMethodContrants.PUT, 0);
            PUT = r0;
            PutIfAbsentOutcome r1 = new PutIfAbsentOutcome("HIT", 1);
            HIT = r1;
            $VALUES = new PutIfAbsentOutcome[]{r0, r1};
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

    public static final enum PutOutcome extends Enum<PutOutcome> implements StoreOperationOutcomes {
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

    public static final enum RemoveOutcome extends Enum<RemoveOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ RemoveOutcome[] $VALUES = null;
        public static final RemoveOutcome MISS = null;
        public static final RemoveOutcome REMOVED = null;

        static {
            RemoveOutcome r0 = new RemoveOutcome("REMOVED", 0);
            REMOVED = r0;
            RemoveOutcome r1 = new RemoveOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new RemoveOutcome[]{r0, r1};
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

    public static final enum ReplaceOutcome extends Enum<ReplaceOutcome> implements StoreOperationOutcomes {
        private static final /* synthetic */ ReplaceOutcome[] $VALUES = null;
        public static final ReplaceOutcome MISS = null;
        public static final ReplaceOutcome REPLACED = null;

        static {
            ReplaceOutcome r0 = new ReplaceOutcome("REPLACED", 0);
            REPLACED = r0;
            ReplaceOutcome r1 = new ReplaceOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new ReplaceOutcome[]{r0, r1};
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
