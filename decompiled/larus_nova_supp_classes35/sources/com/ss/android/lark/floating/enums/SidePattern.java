package com.ss.android.lark.floating.enums;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/floating/enums/SidePattern;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LEFT", "RIGHT", "TOP", "BOTTOM", "AUTO_HORIZONTAL", "AUTO_VERTICAL", "AUTO_SIDE", "RESULT_LEFT", "RESULT_RIGHT", "RESULT_TOP", "RESULT_BOTTOM", "RESULT_HORIZONTAL", "RESULT_VERTICAL", "RESULT_SIDE", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SidePattern extends Enum<SidePattern> {
    public static final SidePattern AUTO_HORIZONTAL = null;
    public static final SidePattern AUTO_SIDE = null;
    public static final SidePattern AUTO_VERTICAL = null;
    public static final SidePattern BOTTOM = null;
    public static final SidePattern DEFAULT = null;
    public static final SidePattern LEFT = null;
    public static final SidePattern RESULT_BOTTOM = null;
    public static final SidePattern RESULT_HORIZONTAL = null;
    public static final SidePattern RESULT_LEFT = null;
    public static final SidePattern RESULT_RIGHT = null;
    public static final SidePattern RESULT_SIDE = null;
    public static final SidePattern RESULT_TOP = null;
    public static final SidePattern RESULT_VERTICAL = null;
    public static final SidePattern RIGHT = null;
    public static final SidePattern TOP = null;
    public static final /* synthetic */ SidePattern[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<SidePattern> getEntries() {
        return b;
    }

    static {
        SidePattern r0 = new SidePattern("DEFAULT", 0);
        DEFAULT = r0;
        SidePattern r1 = new SidePattern("LEFT", 1);
        LEFT = r1;
        SidePattern r3 = new SidePattern("RIGHT", 2);
        RIGHT = r3;
        SidePattern r5 = new SidePattern("TOP", 3);
        TOP = r5;
        SidePattern r7 = new SidePattern("BOTTOM", 4);
        BOTTOM = r7;
        SidePattern r9 = new SidePattern("AUTO_HORIZONTAL", 5);
        AUTO_HORIZONTAL = r9;
        SidePattern r11 = new SidePattern("AUTO_VERTICAL", 6);
        AUTO_VERTICAL = r11;
        SidePattern r13 = new SidePattern("AUTO_SIDE", 7);
        AUTO_SIDE = r13;
        SidePattern r15 = new SidePattern("RESULT_LEFT", 8);
        RESULT_LEFT = r15;
        SidePattern r14 = new SidePattern("RESULT_RIGHT", 9);
        RESULT_RIGHT = r14;
        SidePattern r12 = new SidePattern("RESULT_TOP", 10);
        RESULT_TOP = r12;
        SidePattern r10 = new SidePattern("RESULT_BOTTOM", 11);
        RESULT_BOTTOM = r10;
        SidePattern r8 = new SidePattern("RESULT_HORIZONTAL", 12);
        RESULT_HORIZONTAL = r8;
        SidePattern r6 = new SidePattern("RESULT_VERTICAL", 13);
        RESULT_VERTICAL = r6;
        SidePattern r4 = new SidePattern("RESULT_SIDE", 14);
        RESULT_SIDE = r4;
        SidePattern[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        a = r2;
        b = EnumEntriesKt.enumEntries(r2);
    }

    public static SidePattern[] values() {
        return (SidePattern[]) a.clone();
    }

    public static SidePattern valueOf(String r1) {
        return (SidePattern) a.a(SidePattern.class, r1);
    }

    public SidePattern(String r1, int r2) {
        super(r1, r2);
    }
}
