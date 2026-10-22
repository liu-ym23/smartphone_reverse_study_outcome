package org.apache.commons.math3.geometry.partitioning;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Region<S extends Space> {

    public static final enum Location extends Enum<Location> {
        private static final /* synthetic */ Location[] $VALUES = null;
        public static final Location BOUNDARY = null;
        public static final Location INSIDE = null;
        public static final Location OUTSIDE = null;

        static {
            Location r0 = new Location("INSIDE", 0);
            INSIDE = r0;
            Location r1 = new Location("OUTSIDE", 1);
            OUTSIDE = r1;
            Location r3 = new Location("BOUNDARY", 2);
            BOUNDARY = r3;
            $VALUES = new Location[]{r0, r1, r3};
        }

        private Location(String r1, int r2) {
            super(r1, r2);
        }

        public static Location valueOf(String r2) {
            return (Location) ZeusTransformUtils.preCheckCast(Enum.valueOf(Location.class, r2), Location.class, "com.obric.memorydata.plugin");
        }

        public static Location[] values() {
            return (Location[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Location[].class, "com.obric.memorydata.plugin");
        }
    }

    Region<S> buildNew(BSPTree<S> r1);

    BSPTree<S> getTree(boolean r1);

    boolean isEmpty();

    boolean isEmpty(BSPTree<S> r1);
}
