package com.obric.oui.constraintlayout.core.state;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class State {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f13600a = null;

    public static final enum Chain extends Enum<Chain> {
        private static final /* synthetic */ Chain[] $VALUES = null;
        public static final Chain PACKED = null;
        public static final Chain SPREAD = null;
        public static final Chain SPREAD_INSIDE = null;
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        static {
            Chain r0 = new Chain("SPREAD", 0);
            SPREAD = r0;
            Chain r1 = new Chain("SPREAD_INSIDE", 1);
            SPREAD_INSIDE = r1;
            Chain r3 = new Chain("PACKED", 2);
            PACKED = r3;
            $VALUES = new Chain[]{r0, r1, r3};
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", r3);
            chainMap.put("spread_inside", r1);
            chainMap.put("spread", r0);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        private Chain(String r1, int r2) {
            super(r1, r2);
        }

        public static Chain getChainByString(String r2) {
            if (chainMap.containsKey(r2) == true) goto L5;
            return null;
        L5:
            return (Chain) ZeusTransformUtils.preCheckCast(chainMap.get(r2), Chain.class, "com.obric.memorydata.plugin");
        }

        public static int getValueByString(String r2) {
            if (valueMap.containsKey(r2) == true) goto L5;
            return -1;
        L5:
            return ((Integer) ZeusTransformUtils.preCheckCast(valueMap.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        }

        public static Chain valueOf(String r2) {
            return (Chain) ZeusTransformUtils.preCheckCast(Enum.valueOf(Chain.class, r2), Chain.class, "com.obric.memorydata.plugin");
        }

        public static Chain[] values() {
            return (Chain[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Chain[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Constraint extends Enum<Constraint> {
        private static final /* synthetic */ Constraint[] $VALUES = null;
        public static final Constraint BASELINE_TO_BASELINE = null;
        public static final Constraint BASELINE_TO_BOTTOM = null;
        public static final Constraint BASELINE_TO_TOP = null;
        public static final Constraint BOTTOM_TO_BASELINE = null;
        public static final Constraint BOTTOM_TO_BOTTOM = null;
        public static final Constraint BOTTOM_TO_TOP = null;
        public static final Constraint CENTER_HORIZONTALLY = null;
        public static final Constraint CENTER_VERTICALLY = null;
        public static final Constraint CIRCULAR_CONSTRAINT = null;
        public static final Constraint END_TO_END = null;
        public static final Constraint END_TO_START = null;
        public static final Constraint LEFT_TO_LEFT = null;
        public static final Constraint LEFT_TO_RIGHT = null;
        public static final Constraint RIGHT_TO_LEFT = null;
        public static final Constraint RIGHT_TO_RIGHT = null;
        public static final Constraint START_TO_END = null;
        public static final Constraint START_TO_START = null;
        public static final Constraint TOP_TO_BASELINE = null;
        public static final Constraint TOP_TO_BOTTOM = null;
        public static final Constraint TOP_TO_TOP = null;

        static {
            Constraint r0 = new Constraint("LEFT_TO_LEFT", 0);
            LEFT_TO_LEFT = r0;
            Constraint r1 = new Constraint("LEFT_TO_RIGHT", 1);
            LEFT_TO_RIGHT = r1;
            Constraint r3 = new Constraint("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r3;
            Constraint r5 = new Constraint("RIGHT_TO_RIGHT", 3);
            RIGHT_TO_RIGHT = r5;
            Constraint r7 = new Constraint("START_TO_START", 4);
            START_TO_START = r7;
            Constraint r9 = new Constraint("START_TO_END", 5);
            START_TO_END = r9;
            Constraint r11 = new Constraint("END_TO_START", 6);
            END_TO_START = r11;
            Constraint r13 = new Constraint("END_TO_END", 7);
            END_TO_END = r13;
            Constraint r15 = new Constraint("TOP_TO_TOP", 8);
            TOP_TO_TOP = r15;
            Constraint r14 = new Constraint("TOP_TO_BOTTOM", 9);
            TOP_TO_BOTTOM = r14;
            Constraint r12 = new Constraint("TOP_TO_BASELINE", 10);
            TOP_TO_BASELINE = r12;
            Constraint r10 = new Constraint("BOTTOM_TO_TOP", 11);
            BOTTOM_TO_TOP = r10;
            Constraint r8 = new Constraint("BOTTOM_TO_BOTTOM", 12);
            BOTTOM_TO_BOTTOM = r8;
            Constraint r6 = new Constraint("BOTTOM_TO_BASELINE", 13);
            BOTTOM_TO_BASELINE = r6;
            Constraint r4 = new Constraint("BASELINE_TO_BASELINE", 14);
            BASELINE_TO_BASELINE = r4;
            Constraint r2 = new Constraint("BASELINE_TO_TOP", 15);
            BASELINE_TO_TOP = r2;
            Constraint r16 = new Constraint("BASELINE_TO_BOTTOM", 16);
            BASELINE_TO_BOTTOM = r16;
            Constraint r17 = new Constraint("CENTER_HORIZONTALLY", 17);
            CENTER_HORIZONTALLY = r17;
            Constraint r18 = new Constraint("CENTER_VERTICALLY", 18);
            CENTER_VERTICALLY = r18;
            Constraint r19 = new Constraint("CIRCULAR_CONSTRAINT", 19);
            CIRCULAR_CONSTRAINT = r19;
            $VALUES = new Constraint[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19};
        }

        private Constraint(String r1, int r2) {
            super(r1, r2);
        }

        public static Constraint valueOf(String r2) {
            return (Constraint) ZeusTransformUtils.preCheckCast(Enum.valueOf(Constraint.class, r2), Constraint.class, "com.obric.memorydata.plugin");
        }

        public static Constraint[] values() {
            return (Constraint[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Constraint[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BOTTOM = null;
        public static final Direction END = null;
        public static final Direction LEFT = null;
        public static final Direction RIGHT = null;
        public static final Direction START = null;
        public static final Direction TOP = null;

        static {
            Direction r0 = new Direction("LEFT", 0);
            LEFT = r0;
            Direction r1 = new Direction("RIGHT", 1);
            RIGHT = r1;
            Direction r3 = new Direction("START", 2);
            START = r3;
            Direction r5 = new Direction("END", 3);
            END = r5;
            Direction r7 = new Direction("TOP", 4);
            TOP = r7;
            Direction r9 = new Direction("BOTTOM", 5);
            BOTTOM = r9;
            $VALUES = new Direction[]{r0, r1, r3, r5, r7, r9};
        }

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String r2) {
            return (Direction) ZeusTransformUtils.preCheckCast(Enum.valueOf(Direction.class, r2), Direction.class, "com.obric.memorydata.plugin");
        }

        public static Direction[] values() {
            return (Direction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Direction[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Helper extends Enum<Helper> {
        private static final /* synthetic */ Helper[] $VALUES = null;
        public static final Helper ALIGN_HORIZONTALLY = null;
        public static final Helper ALIGN_VERTICALLY = null;
        public static final Helper BARRIER = null;
        public static final Helper COLUMN = null;
        public static final Helper FLOW = null;
        public static final Helper GRID = null;
        public static final Helper HORIZONTAL_CHAIN = null;
        public static final Helper HORIZONTAL_FLOW = null;
        public static final Helper LAYER = null;
        public static final Helper ROW = null;
        public static final Helper VERTICAL_CHAIN = null;
        public static final Helper VERTICAL_FLOW = null;

        static {
            Helper r0 = new Helper("HORIZONTAL_CHAIN", 0);
            HORIZONTAL_CHAIN = r0;
            Helper r1 = new Helper("VERTICAL_CHAIN", 1);
            VERTICAL_CHAIN = r1;
            Helper r3 = new Helper("ALIGN_HORIZONTALLY", 2);
            ALIGN_HORIZONTALLY = r3;
            Helper r5 = new Helper("ALIGN_VERTICALLY", 3);
            ALIGN_VERTICALLY = r5;
            Helper r7 = new Helper("BARRIER", 4);
            BARRIER = r7;
            Helper r9 = new Helper("LAYER", 5);
            LAYER = r9;
            Helper r11 = new Helper("HORIZONTAL_FLOW", 6);
            HORIZONTAL_FLOW = r11;
            Helper r13 = new Helper("VERTICAL_FLOW", 7);
            VERTICAL_FLOW = r13;
            Helper r15 = new Helper("GRID", 8);
            GRID = r15;
            Helper r14 = new Helper("ROW", 9);
            ROW = r14;
            Helper r12 = new Helper("COLUMN", 10);
            COLUMN = r12;
            Helper r10 = new Helper("FLOW", 11);
            FLOW = r10;
            $VALUES = new Helper[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        }

        private Helper(String r1, int r2) {
            super(r1, r2);
        }

        public static Helper valueOf(String r2) {
            return (Helper) ZeusTransformUtils.preCheckCast(Enum.valueOf(Helper.class, r2), Helper.class, "com.obric.memorydata.plugin");
        }

        public static Helper[] values() {
            return (Helper[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Helper[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum Wrap extends Enum<Wrap> {
        private static final /* synthetic */ Wrap[] $VALUES = null;
        public static final Wrap ALIGNED = null;
        public static final Wrap CHAIN = null;
        public static final Wrap NONE = null;
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        static {
            Wrap r0 = new Wrap("NONE", 0);
            NONE = r0;
            Wrap r1 = new Wrap("CHAIN", 1);
            CHAIN = r1;
            Wrap r3 = new Wrap("ALIGNED", 2);
            ALIGNED = r3;
            $VALUES = new Wrap[]{r0, r1, r3};
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put("none", r0);
            wrapMap.put("chain", r1);
            wrapMap.put("aligned", r3);
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        private Wrap(String r1, int r2) {
            super(r1, r2);
        }

        public static Wrap getChainByString(String r2) {
            if (wrapMap.containsKey(r2) == true) goto L5;
            return null;
        L5:
            return (Wrap) ZeusTransformUtils.preCheckCast(wrapMap.get(r2), Wrap.class, "com.obric.memorydata.plugin");
        }

        public static int getValueByString(String r2) {
            if (valueMap.containsKey(r2) == true) goto L5;
            return -1;
        L5:
            return ((Integer) ZeusTransformUtils.preCheckCast(valueMap.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        }

        public static Wrap valueOf(String r2) {
            return (Wrap) ZeusTransformUtils.preCheckCast(Enum.valueOf(Wrap.class, r2), Wrap.class, "com.obric.memorydata.plugin");
        }

        public static Wrap[] values() {
            return (Wrap[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Wrap[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f13600a = 0;
    }
}
