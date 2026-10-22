package org.apache.commons.math3.stat.clustering;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.stat.clustering.Clusterable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class DBSCANClusterer<T extends Clusterable<T>> {

    private static final enum PointStatus extends Enum<PointStatus> {
        private static final /* synthetic */ PointStatus[] $VALUES = null;
        public static final PointStatus NOISE = null;
        public static final PointStatus PART_OF_CLUSTER = null;

        static {
            PointStatus r0 = new PointStatus("NOISE", 0);
            NOISE = r0;
            PointStatus r1 = new PointStatus("PART_OF_CLUSTER", 1);
            PART_OF_CLUSTER = r1;
            $VALUES = new PointStatus[]{r0, r1};
        }

        private PointStatus(String r1, int r2) {
            super(r1, r2);
        }

        public static PointStatus valueOf(String r2) {
            return (PointStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(PointStatus.class, r2), PointStatus.class, "com.obric.memorydata.plugin");
        }

        public static PointStatus[] values() {
            return (PointStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PointStatus[].class, "com.obric.memorydata.plugin");
        }
    }
}
