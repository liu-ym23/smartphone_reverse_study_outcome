package com.bytedance.obric.memory.model;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum SampleSource extends Enum<SampleSource> {
    private static final /* synthetic */ SampleSource[] $VALUES = null;

    @SerializedName("1")
    public static final SampleSource SAMPLE_SOURCE_AUTO = null;

    @SerializedName("2")
    public static final SampleSource SAMPLE_SOURCE_LIKE_DISLIKE = null;

    @SerializedName("3")
    public static final SampleSource SAMPLE_SOURCE_MANUAL = null;

    @SerializedName("4")
    public static final SampleSource SAMPLE_SOURCE_OAUTO_AUTO = null;
    private final int value;

    static {
        SampleSource r0 = new SampleSource("SAMPLE_SOURCE_AUTO", 0, 1);
        SAMPLE_SOURCE_AUTO = r0;
        SampleSource r1 = new SampleSource("SAMPLE_SOURCE_LIKE_DISLIKE", 1, 2);
        SAMPLE_SOURCE_LIKE_DISLIKE = r1;
        SampleSource r4 = new SampleSource("SAMPLE_SOURCE_MANUAL", 2, 3);
        SAMPLE_SOURCE_MANUAL = r4;
        SampleSource r6 = new SampleSource("SAMPLE_SOURCE_OAUTO_AUTO", 3, 4);
        SAMPLE_SOURCE_OAUTO_AUTO = r6;
        $VALUES = new SampleSource[]{r0, r1, r4, r6};
    }

    private SampleSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static SampleSource findByValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return SAMPLE_SOURCE_OAUTO_AUTO;
    L15:
        return SAMPLE_SOURCE_MANUAL;
    L17:
        return SAMPLE_SOURCE_LIKE_DISLIKE;
    L19:
        return SAMPLE_SOURCE_AUTO;
    }

    public static SampleSource valueOf(String r2) {
        return (SampleSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(SampleSource.class, r2), SampleSource.class, "com.obric.memorydata.plugin");
    }

    public static SampleSource[] values() {
        return (SampleSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SampleSource[].class, "com.obric.memorydata.plugin");
    }

    public int getValue() {
        return this.value;
    }
}
