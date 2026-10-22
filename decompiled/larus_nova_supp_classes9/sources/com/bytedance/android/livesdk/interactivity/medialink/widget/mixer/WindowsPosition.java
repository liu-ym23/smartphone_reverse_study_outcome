package com.bytedance.android.livesdk.interactivity.medialink.widget.mixer;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/mixer/WindowsPosition;", BuildConfig.FLAVOR, "SINGLE", "TWO_LEFT", "TWO_RIGHT", "THREE_LEFT", "THREE_RIGHT_TOP", "THREE_RIGHT_BOTTOM", "FOUR_LEFT_TOP", "FOUR_LEFT_BOTTOM", "FOUR_RIGHT_TOP", "FOUR_RIGHT_BOTTOM", "IGNORE", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowsPosition extends Enum<WindowsPosition> {
    public static final WindowsPosition FOUR_LEFT_BOTTOM = null;
    public static final WindowsPosition FOUR_LEFT_TOP = null;
    public static final WindowsPosition FOUR_RIGHT_BOTTOM = null;
    public static final WindowsPosition FOUR_RIGHT_TOP = null;
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
        WindowsPosition r11 = new WindowsPosition("IGNORE", 10);
        IGNORE = r11;
        a = new WindowsPosition[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
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
