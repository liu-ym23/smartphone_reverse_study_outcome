package com.obric.cae.userAware.SubwayFusionAware;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final enum SubwayState extends Enum<SubwayState> {
    private static final /* synthetic */ SubwayState[] $VALUES = null;
    public static final SubwayState STATE_ENTER_CONFIDENCE_SCORING = null;
    public static final SubwayState STATE_ENTER_PRE_FILTER = null;
    public static final SubwayState STATE_EXIT_CONFIDENCE_SCORING = null;
    public static final SubwayState STATE_IDLE = null;
    public static final SubwayState STATE_ON_SUBWAY = null;

    private static /* synthetic */ SubwayState[] $values() {
        return new SubwayState[]{STATE_IDLE, STATE_ENTER_PRE_FILTER, STATE_ENTER_CONFIDENCE_SCORING, STATE_ON_SUBWAY, STATE_EXIT_CONFIDENCE_SCORING};
    }

    static {
        STATE_IDLE = new SubwayState("STATE_IDLE", 0);
        STATE_ENTER_PRE_FILTER = new SubwayState("STATE_ENTER_PRE_FILTER", 1);
        STATE_ENTER_CONFIDENCE_SCORING = new SubwayState("STATE_ENTER_CONFIDENCE_SCORING", 2);
        STATE_ON_SUBWAY = new SubwayState("STATE_ON_SUBWAY", 3);
        STATE_EXIT_CONFIDENCE_SCORING = new SubwayState("STATE_EXIT_CONFIDENCE_SCORING", 4);
        $VALUES = $values();
    }

    private SubwayState(String r1, int r2) {
        super(r1, r2);
    }

    public static SubwayState valueOf(String r2) {
        return (SubwayState) ZeusTransformUtils.preCheckCast(Enum.valueOf(SubwayState.class, r2), SubwayState.class, "com.obric.memorydata.plugin");
    }

    public static SubwayState[] values() {
        return (SubwayState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SubwayState[].class, "com.obric.memorydata.plugin");
    }
}
