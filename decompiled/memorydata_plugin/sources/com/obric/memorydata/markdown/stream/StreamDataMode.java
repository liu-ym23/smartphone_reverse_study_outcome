package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/markdown/stream/StreamDataMode;", "", "<init>", "(Ljava/lang/String;I)V", "Incremental", "Cumulative", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum StreamDataMode extends Enum<StreamDataMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StreamDataMode[] $VALUES = null;
    public static final StreamDataMode Cumulative = null;
    public static final StreamDataMode Incremental = null;

    private static final /* synthetic */ StreamDataMode[] $values() {
        return new StreamDataMode[]{Incremental, Cumulative};
    }

    static {
        Incremental = new StreamDataMode("Incremental", 0);
        Cumulative = new StreamDataMode("Cumulative", 1);
        StreamDataMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private StreamDataMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<StreamDataMode> getEntries() {
        return $ENTRIES;
    }

    public static StreamDataMode valueOf(String r2) {
        return (StreamDataMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(StreamDataMode.class, r2), StreamDataMode.class, "com.obric.memorydata.plugin");
    }

    public static StreamDataMode[] values() {
        return (StreamDataMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StreamDataMode[].class, "com.obric.memorydata.plugin");
    }
}
