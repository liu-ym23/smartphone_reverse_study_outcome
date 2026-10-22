package org.ehcache.core.statistics;

import com.bytedance.retrofit2.HttpMethodContrants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface AuthoritativeTierOperationOutcomes {

    public static final enum ComputeIfAbsentAndFaultOutcome extends Enum<ComputeIfAbsentAndFaultOutcome> implements AuthoritativeTierOperationOutcomes {
        private static final /* synthetic */ ComputeIfAbsentAndFaultOutcome[] $VALUES = null;
        public static final ComputeIfAbsentAndFaultOutcome HIT = null;
        public static final ComputeIfAbsentAndFaultOutcome NOOP = null;
        public static final ComputeIfAbsentAndFaultOutcome PUT = null;

        static {
            ComputeIfAbsentAndFaultOutcome r0 = new ComputeIfAbsentAndFaultOutcome("HIT", 0);
            HIT = r0;
            ComputeIfAbsentAndFaultOutcome r1 = new ComputeIfAbsentAndFaultOutcome(HttpMethodContrants.PUT, 1);
            PUT = r1;
            ComputeIfAbsentAndFaultOutcome r3 = new ComputeIfAbsentAndFaultOutcome("NOOP", 2);
            NOOP = r3;
            $VALUES = new ComputeIfAbsentAndFaultOutcome[]{r0, r1, r3};
        }

        private ComputeIfAbsentAndFaultOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static ComputeIfAbsentAndFaultOutcome valueOf(String r2) {
            return (ComputeIfAbsentAndFaultOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(ComputeIfAbsentAndFaultOutcome.class, r2), ComputeIfAbsentAndFaultOutcome.class, "com.obric.memorydata.plugin");
        }

        public static ComputeIfAbsentAndFaultOutcome[] values() {
            return (ComputeIfAbsentAndFaultOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ComputeIfAbsentAndFaultOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum FlushOutcome extends Enum<FlushOutcome> implements AuthoritativeTierOperationOutcomes {
        private static final /* synthetic */ FlushOutcome[] $VALUES = null;
        public static final FlushOutcome HIT = null;
        public static final FlushOutcome MISS = null;

        static {
            FlushOutcome r0 = new FlushOutcome("HIT", 0);
            HIT = r0;
            FlushOutcome r1 = new FlushOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new FlushOutcome[]{r0, r1};
        }

        private FlushOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static FlushOutcome valueOf(String r2) {
            return (FlushOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(FlushOutcome.class, r2), FlushOutcome.class, "com.obric.memorydata.plugin");
        }

        public static FlushOutcome[] values() {
            return (FlushOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FlushOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum GetAndFaultOutcome extends Enum<GetAndFaultOutcome> implements AuthoritativeTierOperationOutcomes {
        private static final /* synthetic */ GetAndFaultOutcome[] $VALUES = null;
        public static final GetAndFaultOutcome HIT = null;
        public static final GetAndFaultOutcome MISS = null;
        public static final GetAndFaultOutcome TIMEOUT = null;

        static {
            GetAndFaultOutcome r0 = new GetAndFaultOutcome("HIT", 0);
            HIT = r0;
            GetAndFaultOutcome r1 = new GetAndFaultOutcome("MISS", 1);
            MISS = r1;
            GetAndFaultOutcome r3 = new GetAndFaultOutcome("TIMEOUT", 2);
            TIMEOUT = r3;
            $VALUES = new GetAndFaultOutcome[]{r0, r1, r3};
        }

        private GetAndFaultOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static GetAndFaultOutcome valueOf(String r2) {
            return (GetAndFaultOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(GetAndFaultOutcome.class, r2), GetAndFaultOutcome.class, "com.obric.memorydata.plugin");
        }

        public static GetAndFaultOutcome[] values() {
            return (GetAndFaultOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GetAndFaultOutcome[].class, "com.obric.memorydata.plugin");
        }
    }
}
