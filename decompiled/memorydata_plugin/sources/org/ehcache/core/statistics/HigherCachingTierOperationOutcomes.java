package org.ehcache.core.statistics;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface HigherCachingTierOperationOutcomes {

    public static final enum SilentInvalidateAllOutcome extends Enum<SilentInvalidateAllOutcome> implements HigherCachingTierOperationOutcomes {
        private static final /* synthetic */ SilentInvalidateAllOutcome[] $VALUES = null;
        public static final SilentInvalidateAllOutcome FAILURE = null;
        public static final SilentInvalidateAllOutcome SUCCESS = null;

        static {
            SilentInvalidateAllOutcome r0 = new SilentInvalidateAllOutcome("SUCCESS", 0);
            SUCCESS = r0;
            SilentInvalidateAllOutcome r1 = new SilentInvalidateAllOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new SilentInvalidateAllOutcome[]{r0, r1};
        }

        private SilentInvalidateAllOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static SilentInvalidateAllOutcome valueOf(String r2) {
            return (SilentInvalidateAllOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(SilentInvalidateAllOutcome.class, r2), SilentInvalidateAllOutcome.class, "com.obric.memorydata.plugin");
        }

        public static SilentInvalidateAllOutcome[] values() {
            return (SilentInvalidateAllOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SilentInvalidateAllOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum SilentInvalidateAllWithHashOutcome extends Enum<SilentInvalidateAllWithHashOutcome> implements HigherCachingTierOperationOutcomes {
        private static final /* synthetic */ SilentInvalidateAllWithHashOutcome[] $VALUES = null;
        public static final SilentInvalidateAllWithHashOutcome FAILURE = null;
        public static final SilentInvalidateAllWithHashOutcome SUCCESS = null;

        static {
            SilentInvalidateAllWithHashOutcome r0 = new SilentInvalidateAllWithHashOutcome("SUCCESS", 0);
            SUCCESS = r0;
            SilentInvalidateAllWithHashOutcome r1 = new SilentInvalidateAllWithHashOutcome("FAILURE", 1);
            FAILURE = r1;
            $VALUES = new SilentInvalidateAllWithHashOutcome[]{r0, r1};
        }

        private SilentInvalidateAllWithHashOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static SilentInvalidateAllWithHashOutcome valueOf(String r2) {
            return (SilentInvalidateAllWithHashOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(SilentInvalidateAllWithHashOutcome.class, r2), SilentInvalidateAllWithHashOutcome.class, "com.obric.memorydata.plugin");
        }

        public static SilentInvalidateAllWithHashOutcome[] values() {
            return (SilentInvalidateAllWithHashOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SilentInvalidateAllWithHashOutcome[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum SilentInvalidateOutcome extends Enum<SilentInvalidateOutcome> implements HigherCachingTierOperationOutcomes {
        private static final /* synthetic */ SilentInvalidateOutcome[] $VALUES = null;
        public static final SilentInvalidateOutcome MISS = null;
        public static final SilentInvalidateOutcome REMOVED = null;

        static {
            SilentInvalidateOutcome r0 = new SilentInvalidateOutcome("REMOVED", 0);
            REMOVED = r0;
            SilentInvalidateOutcome r1 = new SilentInvalidateOutcome("MISS", 1);
            MISS = r1;
            $VALUES = new SilentInvalidateOutcome[]{r0, r1};
        }

        private SilentInvalidateOutcome(String r1, int r2) {
            super(r1, r2);
        }

        public static SilentInvalidateOutcome valueOf(String r2) {
            return (SilentInvalidateOutcome) ZeusTransformUtils.preCheckCast(Enum.valueOf(SilentInvalidateOutcome.class, r2), SilentInvalidateOutcome.class, "com.obric.memorydata.plugin");
        }

        public static SilentInvalidateOutcome[] values() {
            return (SilentInvalidateOutcome[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SilentInvalidateOutcome[].class, "com.obric.memorydata.plugin");
        }
    }
}
