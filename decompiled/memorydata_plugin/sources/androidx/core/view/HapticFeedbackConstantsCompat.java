package androidx.core.view;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class HapticFeedbackConstantsCompat {
    public static final int CLOCK_TICK = 4;
    public static final int CONFIRM = 16;
    public static final int CONTEXT_CLICK = 6;
    public static final int DRAG_START = 25;
    static final int FIRST_CONSTANT_INT = 0;
    public static final int FLAG_IGNORE_VIEW_SETTING = 1;
    public static final int GESTURE_END = 13;
    public static final int GESTURE_START = 12;
    public static final int GESTURE_THRESHOLD_ACTIVATE = 23;
    public static final int GESTURE_THRESHOLD_DEACTIVATE = 24;
    public static final int KEYBOARD_PRESS = 3;
    public static final int KEYBOARD_RELEASE = 7;
    public static final int KEYBOARD_TAP = 3;
    static final int LAST_CONSTANT_INT = 27;
    public static final int LONG_PRESS = 0;
    public static final int NO_HAPTICS = -1;
    public static final int REJECT = 17;
    public static final int SEGMENT_FREQUENT_TICK = 27;
    public static final int SEGMENT_TICK = 26;
    public static final int TEXT_HANDLE_MOVE = 9;
    public static final int TOGGLE_OFF = 22;
    public static final int TOGGLE_ON = 21;
    public static final int VIRTUAL_KEY = 1;
    public static final int VIRTUAL_KEY_RELEASE = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HapticFeedbackType {
    }

    private HapticFeedbackConstantsCompat() {
    }

    static int getFeedbackConstantOrFallback(int r6) {
        if (r6 != (-1)) goto L5;
        return -1;
    L5:
        int r3 = 0;
        if (Build.VERSION.SDK_INT >= 34) goto L13;
        switch(r6) {
            case 21: goto L11;
            case 22: goto L10;
            case 23: goto L11;
            case 24: goto L10;
            case 25: goto L9;
            case 26: goto L11;
            case 27: goto L10;
            default: goto L13;
        };
    L9:
        r6 = 0;
        goto L13
    L10:
        r6 = 4;
        goto L13
    L11:
        r6 = 6;
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L15;
    L25:
        r3 = r6;
    L27:
        if (Build.VERSION.SDK_INT >= 27) goto L37;
        if (r3 != 7) goto L31;
    L35:
        r3 = -1;
        goto L37
    L31:
        if (r3 == 8) goto L35;
        if (r3 == 9) goto L35;
    L37:
        if (Build.VERSION.SDK_INT >= 23) goto L42;
        if (r3 != 6) goto L42;
        r3 = 4;
    L42:
        if (Build.VERSION.SDK_INT >= 21) goto L45;
        if (r3 != 4) goto L45;
        return -1;
    L45:
        return r3;
    L15:
        if (r6 != 12) goto L17;
    L24:
        r3 = 1;
        goto L27
    L17:
        if (r6 != 13) goto L19;
        r3 = 6;
        goto L27
    L19:
        if (r6 == 16) goto L24;
        if (r6 == 17) goto L27;
        goto L25
    }
}
