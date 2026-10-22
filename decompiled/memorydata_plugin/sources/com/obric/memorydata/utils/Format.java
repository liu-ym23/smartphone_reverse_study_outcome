package com.obric.memorydata.utils;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/utils/Format;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FULL", "DATE", "DATE_NO_YEAR", "SECOND", "HOUR_COUNT", "MINUTE", "FULL_WITH_MILLI", "FULL_WITHOUT_SECOND", "FULL_WITH_CHINESE", "CHINESE_MONTH_DAY", "MONTH_DAY_SPLIT_BY_SLASH", "DATE_SPLIT_BY_SLASH", "MINUTE_SPLIT_BY_SLASH", "FULL_SPLIT_BY_SLASH", "MONTH_DAY_HOUR_MINUTE", "DATE_NOT_FORMATTED", "MONTH_NOT_FORMATTED", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Format extends Enum<Format> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Format[] $VALUES = null;
    public static final Format CHINESE_MONTH_DAY = null;
    public static final Format DATE = null;
    public static final Format DATE_NOT_FORMATTED = null;
    public static final Format DATE_NO_YEAR = null;
    public static final Format DATE_SPLIT_BY_SLASH = null;
    public static final Format FULL = null;
    public static final Format FULL_SPLIT_BY_SLASH = null;
    public static final Format FULL_WITHOUT_SECOND = null;
    public static final Format FULL_WITH_CHINESE = null;
    public static final Format FULL_WITH_MILLI = null;
    public static final Format HOUR_COUNT = null;
    public static final Format MINUTE = null;
    public static final Format MINUTE_SPLIT_BY_SLASH = null;
    public static final Format MONTH_DAY_HOUR_MINUTE = null;
    public static final Format MONTH_DAY_SPLIT_BY_SLASH = null;
    public static final Format MONTH_NOT_FORMATTED = null;
    public static final Format SECOND = null;
    private final String value;

    private static final /* synthetic */ Format[] $values() {
        return new Format[]{FULL, DATE, DATE_NO_YEAR, SECOND, HOUR_COUNT, MINUTE, FULL_WITH_MILLI, FULL_WITHOUT_SECOND, FULL_WITH_CHINESE, CHINESE_MONTH_DAY, MONTH_DAY_SPLIT_BY_SLASH, DATE_SPLIT_BY_SLASH, MINUTE_SPLIT_BY_SLASH, FULL_SPLIT_BY_SLASH, MONTH_DAY_HOUR_MINUTE, DATE_NOT_FORMATTED, MONTH_NOT_FORMATTED};
    }

    static {
        FULL = new Format("FULL", 0, "yyyy-MM-dd HH:mm:ss");
        DATE = new Format("DATE", 1, "yyyy-MM-dd");
        DATE_NO_YEAR = new Format("DATE_NO_YEAR", 2, "MM-dd");
        SECOND = new Format("SECOND", 3, "HH:mm:ss");
        HOUR_COUNT = new Format("HOUR_COUNT", 4, "HH");
        MINUTE = new Format("MINUTE", 5, "HH:mm");
        FULL_WITH_MILLI = new Format("FULL_WITH_MILLI", 6, "yyyyMMddHHmmssSSS");
        FULL_WITHOUT_SECOND = new Format("FULL_WITHOUT_SECOND", 7, "yyyy-MM-dd HH:mm");
        FULL_WITH_CHINESE = new Format("FULL_WITH_CHINESE", 8, "yyyy年MM月dd日HH:mm");
        CHINESE_MONTH_DAY = new Format("CHINESE_MONTH_DAY", 9, "MM月dd日");
        MONTH_DAY_SPLIT_BY_SLASH = new Format("MONTH_DAY_SPLIT_BY_SLASH", 10, "MM/dd");
        DATE_SPLIT_BY_SLASH = new Format("DATE_SPLIT_BY_SLASH", 11, "yyyy/MM/dd");
        MINUTE_SPLIT_BY_SLASH = new Format("MINUTE_SPLIT_BY_SLASH", 12, "yyyy/MM/dd HH:mm");
        FULL_SPLIT_BY_SLASH = new Format("FULL_SPLIT_BY_SLASH", 13, "yyyy/MM/dd HH:mm:ss");
        MONTH_DAY_HOUR_MINUTE = new Format("MONTH_DAY_HOUR_MINUTE", 14, "MM/dd HH:mm");
        DATE_NOT_FORMATTED = new Format("DATE_NOT_FORMATTED", 15, "yyyy/M/d");
        MONTH_NOT_FORMATTED = new Format("MONTH_NOT_FORMATTED", 16, "M/d");
        Format[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private Format(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<Format> getEntries() {
        return $ENTRIES;
    }

    public static Format valueOf(String r2) {
        return (Format) ZeusTransformUtils.preCheckCast(Enum.valueOf(Format.class, r2), Format.class, "com.obric.memorydata.plugin");
    }

    public static Format[] values() {
        return (Format[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Format[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
