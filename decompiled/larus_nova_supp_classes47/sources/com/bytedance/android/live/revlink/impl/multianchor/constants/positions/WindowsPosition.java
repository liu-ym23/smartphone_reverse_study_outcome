package com.bytedance.android.live.revlink.impl.multianchor.constants.positions;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/constants/positions/WindowsPosition;", "", "SINGLE", "TWO_LEFT", "TWO_RIGHT", "THREE_LEFT", "THREE_RIGHT_TOP", "THREE_RIGHT_BOTTOM", "FOUR_LEFT_TOP", "FOUR_LEFT_BOTTOM", "FOUR_RIGHT_TOP", "FOUR_RIGHT_BOTTOM", "ENLARGE_LEFT", "ENLARGE_RIGHT_TOP", "ENLARGE_RIGHT_MIDDLE", "ENLARGE_RIGHT_BOTTOM", "FULL_BIG", "FULL_SMALL_ONE", "FULL_SMALL_TWO", "FULL_SMALL_THR", "FULL_RECORD_BIG", "IGNORE", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum WindowsPosition extends Enum<WindowsPosition> {
    public static final WindowsPosition ENLARGE_LEFT = null;
    public static final WindowsPosition ENLARGE_RIGHT_BOTTOM = null;
    public static final WindowsPosition ENLARGE_RIGHT_MIDDLE = null;
    public static final WindowsPosition ENLARGE_RIGHT_TOP = null;
    public static final WindowsPosition FOUR_LEFT_BOTTOM = null;
    public static final WindowsPosition FOUR_LEFT_TOP = null;
    public static final WindowsPosition FOUR_RIGHT_BOTTOM = null;
    public static final WindowsPosition FOUR_RIGHT_TOP = null;
    public static final WindowsPosition FULL_BIG = null;
    public static final WindowsPosition FULL_RECORD_BIG = null;
    public static final WindowsPosition FULL_SMALL_ONE = null;
    public static final WindowsPosition FULL_SMALL_THR = null;
    public static final WindowsPosition FULL_SMALL_TWO = null;
    public static final WindowsPosition IGNORE = null;
    public static final WindowsPosition SINGLE = null;
    public static final WindowsPosition THREE_LEFT = null;
    public static final WindowsPosition THREE_RIGHT_BOTTOM = null;
    public static final WindowsPosition THREE_RIGHT_TOP = null;
    public static final WindowsPosition TWO_LEFT = null;
    public static final WindowsPosition TWO_RIGHT = null;
    public static final /* synthetic */ WindowsPosition[] a = null;

    static {
        WindowsPosition r1 = new WindowsPosition("SINGLE", 0);
        SINGLE = r1;
        WindowsPosition r2 = new WindowsPosition("TWO_LEFT", 1);
        TWO_LEFT = r2;
        WindowsPosition r3 = new WindowsPosition("TWO_RIGHT", 2);
        TWO_RIGHT = r3;
        WindowsPosition r4 = new WindowsPosition("THREE_LEFT", 3);
        THREE_LEFT = r4;
        WindowsPosition r5 = new WindowsPosition("THREE_RIGHT_TOP", 4);
        THREE_RIGHT_TOP = r5;
        WindowsPosition r6 = new WindowsPosition("THREE_RIGHT_BOTTOM", 5);
        THREE_RIGHT_BOTTOM = r6;
        WindowsPosition r7 = new WindowsPosition("FOUR_LEFT_TOP", 6);
        FOUR_LEFT_TOP = r7;
        WindowsPosition r8 = new WindowsPosition("FOUR_LEFT_BOTTOM", 7);
        FOUR_LEFT_BOTTOM = r8;
        WindowsPosition r9 = new WindowsPosition("FOUR_RIGHT_TOP", 8);
        FOUR_RIGHT_TOP = r9;
        WindowsPosition r10 = new WindowsPosition("FOUR_RIGHT_BOTTOM", 9);
        FOUR_RIGHT_BOTTOM = r10;
        WindowsPosition r12 = new WindowsPosition("ENLARGE_LEFT", 10);
        ENLARGE_LEFT = r12;
        WindowsPosition r13 = new WindowsPosition("ENLARGE_RIGHT_TOP", 11);
        ENLARGE_RIGHT_TOP = r13;
        WindowsPosition r14 = new WindowsPosition("ENLARGE_RIGHT_MIDDLE", 12);
        ENLARGE_RIGHT_MIDDLE = r14;
        WindowsPosition r15 = new WindowsPosition("ENLARGE_RIGHT_BOTTOM", 13);
        ENLARGE_RIGHT_BOTTOM = r15;
        WindowsPosition r16 = new WindowsPosition("FULL_BIG", 14);
        FULL_BIG = r16;
        WindowsPosition r17 = new WindowsPosition("FULL_SMALL_ONE", 15);
        FULL_SMALL_ONE = r17;
        WindowsPosition r18 = new WindowsPosition("FULL_SMALL_TWO", 16);
        FULL_SMALL_TWO = r18;
        WindowsPosition r19 = new WindowsPosition("FULL_SMALL_THR", 17);
        FULL_SMALL_THR = r19;
        WindowsPosition r20 = new WindowsPosition("FULL_RECORD_BIG", 18);
        FULL_RECORD_BIG = r20;
        WindowsPosition r22 = new WindowsPosition("IGNORE", 19);
        IGNORE = r22;
        a = new WindowsPosition[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22};
    }

    public static WindowsPosition valueOf(String r1) {
        return (WindowsPosition) a.a(WindowsPosition.class, r1);
    }

    public static WindowsPosition[] values() {
        return (WindowsPosition[]) a.clone();
    }

    public WindowsPosition(String r1, int r2) {
        super(r1, r2);
    }
}
