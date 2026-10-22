package com.obric.oui.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/time/TimeStyle;", "", "FULL", "FULL_Y", "FULL_YM", "FULL_YMD", "FULL_MD", "FULL_YMDHM", "FULL_YMDEHM", "BRIEF_HM", "BRIEF_MD", "BRIEF_YMDHM", "RELATIVE_DETAILED", "RELATIVE_FUZZY", "RELATIVE_MIXED", "RELATIVE_MIXED_BRIEF", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum TimeStyle extends Enum<TimeStyle> {
    public static final TimeStyle BRIEF_HM = null;
    public static final TimeStyle BRIEF_MD = null;
    public static final TimeStyle BRIEF_YMDHM = null;
    public static final TimeStyle FULL = null;
    public static final TimeStyle FULL_MD = null;
    public static final TimeStyle FULL_Y = null;
    public static final TimeStyle FULL_YM = null;
    public static final TimeStyle FULL_YMD = null;
    public static final TimeStyle FULL_YMDEHM = null;
    public static final TimeStyle FULL_YMDHM = null;
    public static final TimeStyle RELATIVE_DETAILED = null;
    public static final TimeStyle RELATIVE_FUZZY = null;
    public static final TimeStyle RELATIVE_MIXED = null;
    public static final TimeStyle RELATIVE_MIXED_BRIEF = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimeStyle[] f14762a = null;

    static {
        TimeStyle r5 = new TimeStyle("FULL", 0);
        FULL = r5;
        TimeStyle r10 = new TimeStyle("FULL_Y", 1);
        FULL_Y = r10;
        TimeStyle r11 = new TimeStyle("FULL_YM", 2);
        FULL_YM = r11;
        TimeStyle r12 = new TimeStyle("FULL_YMD", 3);
        FULL_YMD = r12;
        TimeStyle r13 = new TimeStyle("FULL_MD", 4);
        FULL_MD = r13;
        TimeStyle r14 = new TimeStyle("FULL_YMDHM", 5);
        FULL_YMDHM = r14;
        TimeStyle r15 = new TimeStyle("FULL_YMDEHM", 6);
        FULL_YMDEHM = r15;
        TimeStyle r16 = new TimeStyle("BRIEF_HM", 7);
        BRIEF_HM = r16;
        TimeStyle r17 = new TimeStyle("BRIEF_MD", 8);
        BRIEF_MD = r17;
        TimeStyle r18 = new TimeStyle("BRIEF_YMDHM", 9);
        BRIEF_YMDHM = r18;
        TimeStyle r19 = new TimeStyle("RELATIVE_DETAILED", 10);
        RELATIVE_DETAILED = r19;
        TimeStyle r110 = new TimeStyle("RELATIVE_FUZZY", 11);
        RELATIVE_FUZZY = r110;
        TimeStyle r111 = new TimeStyle("RELATIVE_MIXED", 12);
        RELATIVE_MIXED = r111;
        TimeStyle r112 = new TimeStyle("RELATIVE_MIXED_BRIEF", 13);
        RELATIVE_MIXED_BRIEF = r112;
        f14762a = new TimeStyle[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112};
    }

    public static TimeStyle valueOf(String r5) {
        return (TimeStyle) Enum.valueOf(TimeStyle.class, r5);
    }

    public static TimeStyle[] values() {
        return (TimeStyle[]) f14762a.clone();
    }
}
