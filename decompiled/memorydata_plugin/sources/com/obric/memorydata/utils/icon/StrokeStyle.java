package com.obric.memorydata.utils.icon;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/utils/icon/StrokeStyle;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID", "DASHED", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum StrokeStyle extends Enum<StrokeStyle> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ StrokeStyle[] $VALUES = null;
    public static final StrokeStyle DASHED = null;
    public static final StrokeStyle SOLID = null;

    private static final /* synthetic */ StrokeStyle[] $values() {
        return new StrokeStyle[]{SOLID, DASHED};
    }

    static {
        SOLID = new StrokeStyle("SOLID", 0);
        DASHED = new StrokeStyle("DASHED", 1);
        StrokeStyle[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private StrokeStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<StrokeStyle> getEntries() {
        return $ENTRIES;
    }

    public static StrokeStyle valueOf(String r2) {
        return (StrokeStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(StrokeStyle.class, r2), StrokeStyle.class, "com.obric.memorydata.plugin");
    }

    public static StrokeStyle[] values() {
        return (StrokeStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StrokeStyle[].class, "com.obric.memorydata.plugin");
    }
}
