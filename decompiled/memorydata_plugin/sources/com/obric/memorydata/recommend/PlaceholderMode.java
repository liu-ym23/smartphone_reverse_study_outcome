package com.obric.memorydata.recommend;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/PlaceholderMode;", "", "<init>", "(Ljava/lang/String;I)V", "BRACES", "BRACKETS", "ANGLE_BRACKETS", "DOUBLE_BRACES", "DOLLAR_BRACES", "NONE", "CUSTOM", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum PlaceholderMode extends Enum<PlaceholderMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PlaceholderMode[] $VALUES = null;
    public static final PlaceholderMode ANGLE_BRACKETS = null;
    public static final PlaceholderMode BRACES = null;
    public static final PlaceholderMode BRACKETS = null;
    public static final PlaceholderMode CUSTOM = null;
    public static final PlaceholderMode DOLLAR_BRACES = null;
    public static final PlaceholderMode DOUBLE_BRACES = null;
    public static final PlaceholderMode NONE = null;

    private static final /* synthetic */ PlaceholderMode[] $values() {
        return new PlaceholderMode[]{BRACES, BRACKETS, ANGLE_BRACKETS, DOUBLE_BRACES, DOLLAR_BRACES, NONE, CUSTOM};
    }

    static {
        BRACES = new PlaceholderMode("BRACES", 0);
        BRACKETS = new PlaceholderMode("BRACKETS", 1);
        ANGLE_BRACKETS = new PlaceholderMode("ANGLE_BRACKETS", 2);
        DOUBLE_BRACES = new PlaceholderMode("DOUBLE_BRACES", 3);
        DOLLAR_BRACES = new PlaceholderMode("DOLLAR_BRACES", 4);
        NONE = new PlaceholderMode("NONE", 5);
        CUSTOM = new PlaceholderMode("CUSTOM", 6);
        PlaceholderMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private PlaceholderMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<PlaceholderMode> getEntries() {
        return $ENTRIES;
    }

    public static PlaceholderMode valueOf(String r2) {
        return (PlaceholderMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(PlaceholderMode.class, r2), PlaceholderMode.class, "com.obric.memorydata.plugin");
    }

    public static PlaceholderMode[] values() {
        return (PlaceholderMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PlaceholderMode[].class, "com.obric.memorydata.plugin");
    }
}
