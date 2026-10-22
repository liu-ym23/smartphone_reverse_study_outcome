package org.ehcache.core.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public class TierOperationOutcomes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<GetOutcome, Set<StoreOperationOutcomes.GetOutcome>> f18062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<GetOutcome, Set<AuthoritativeTierOperationOutcomes.GetAndFaultOutcome>> f18063b = null;
    public static final Map<GetOutcome, Set<LowerCachingTierOperationsOutcome.GetAndRemoveOutcome>> c = null;
    public static final Map<GetOutcome, Set<CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome>> d = null;
    public static final Map<EvictionOutcome, Set<StoreOperationOutcomes.EvictionOutcome>> e = null;

    public static final enum EvictionOutcome extends Enum<EvictionOutcome> {
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

    public static final enum GetOutcome extends Enum<GetOutcome> {
        private static final /* synthetic */ GetOutcome[] $VALUES = null;
        public static final GetOutcome HIT = null;
        public static final GetOutcome MISS = null;

        static {
            GetOutcome r0 = new GetOutcome("HIT", 0);
            HIT = r0;
            GetOutcome r1 = new GetOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new GetOutcome[]{r0, r1};
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

    static {
        EnumMap r0 = new EnumMap(GetOutcome.class);
        r0.put(GetOutcome.HIT, EnumSet.of(StoreOperationOutcomes.GetOutcome.HIT));
        r0.put(GetOutcome.MISS, EnumSet.of(StoreOperationOutcomes.GetOutcome.MISS, StoreOperationOutcomes.GetOutcome.TIMEOUT));
        f18062a = Collections.unmodifiableMap(r0);
        EnumMap r1 = new EnumMap(GetOutcome.class);
        r1.put(GetOutcome.HIT, EnumSet.of(AuthoritativeTierOperationOutcomes.GetAndFaultOutcome.HIT));
        r1.put(GetOutcome.MISS, EnumSet.of(AuthoritativeTierOperationOutcomes.GetAndFaultOutcome.MISS, AuthoritativeTierOperationOutcomes.GetAndFaultOutcome.TIMEOUT));
        f18063b = Collections.unmodifiableMap(r1);
        EnumMap r2 = new EnumMap(GetOutcome.class);
        r2.put(GetOutcome.HIT, EnumSet.of(LowerCachingTierOperationsOutcome.GetAndRemoveOutcome.HIT_REMOVED));
        r2.put(GetOutcome.MISS, EnumSet.of(LowerCachingTierOperationsOutcome.GetAndRemoveOutcome.MISS));
        c = Collections.unmodifiableMap(r2);
        EnumMap r3 = new EnumMap(GetOutcome.class);
        r3.put(GetOutcome.HIT, EnumSet.of(CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome.HIT));
        r3.put(GetOutcome.MISS, EnumSet.of(CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome.FAULTED, CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome.FAULT_FAILED, CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome.FAULT_FAILED_MISS, CachingTierOperationOutcomes.GetOrComputeIfAbsentOutcome.MISS));
        d = Collections.unmodifiableMap(r3);
        EnumMap r4 = new EnumMap(EvictionOutcome.class);
        r4.put(EvictionOutcome.SUCCESS, EnumSet.of(StoreOperationOutcomes.EvictionOutcome.SUCCESS));
        r4.put(EvictionOutcome.FAILURE, EnumSet.of(StoreOperationOutcomes.EvictionOutcome.FAILURE));
        e = Collections.unmodifiableMap(r4);
    }
}
