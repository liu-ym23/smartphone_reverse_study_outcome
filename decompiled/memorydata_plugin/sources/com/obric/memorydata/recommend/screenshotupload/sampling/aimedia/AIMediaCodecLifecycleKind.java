package com.obric.memorydata.recommend.screenshotupload.sampling.aimedia;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/aimedia/AIMediaCodecLifecycleKind;", "", "<init>", "(Ljava/lang/String;I)V", "START", "RESUME", "PAUSE", "STOP", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AIMediaCodecLifecycleKind extends Enum<AIMediaCodecLifecycleKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AIMediaCodecLifecycleKind[] $VALUES = null;
    public static final AIMediaCodecLifecycleKind PAUSE = null;
    public static final AIMediaCodecLifecycleKind RESUME = null;
    public static final AIMediaCodecLifecycleKind START = null;
    public static final AIMediaCodecLifecycleKind STOP = null;

    private static final /* synthetic */ AIMediaCodecLifecycleKind[] $values() {
        return new AIMediaCodecLifecycleKind[]{START, RESUME, PAUSE, STOP};
    }

    static {
        START = new AIMediaCodecLifecycleKind("START", 0);
        RESUME = new AIMediaCodecLifecycleKind("RESUME", 1);
        PAUSE = new AIMediaCodecLifecycleKind("PAUSE", 2);
        STOP = new AIMediaCodecLifecycleKind("STOP", 3);
        AIMediaCodecLifecycleKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private AIMediaCodecLifecycleKind(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<AIMediaCodecLifecycleKind> getEntries() {
        return $ENTRIES;
    }

    public static AIMediaCodecLifecycleKind valueOf(String r2) {
        return (AIMediaCodecLifecycleKind) ZeusTransformUtils.preCheckCast(Enum.valueOf(AIMediaCodecLifecycleKind.class, r2), AIMediaCodecLifecycleKind.class, "com.obric.memorydata.plugin");
    }

    public static AIMediaCodecLifecycleKind[] values() {
        return (AIMediaCodecLifecycleKind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AIMediaCodecLifecycleKind[].class, "com.obric.memorydata.plugin");
    }
}
