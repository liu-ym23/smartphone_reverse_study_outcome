package androidx.core.accessibilityservice;

import ai.j0;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
    }

    @NonNull
    public static String capabilityToString(int r5) {
        if (r5 != 1) goto L5;
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    L5:
        if (r5 != 2) goto L7;
        return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
    L7:
        if (r5 != 4) goto L9;
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L9:
        if (r5 == 8) goto L12;
        return "UNKNOWN";
    L12:
        return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }

    @NonNull
    public static String feedbackTypeToString(int r5) {
        StringBuilder r10 = j0.u("[");
    L3:
        if (r5 <= 0) goto L22;
        int r11 = 1 << Integer.numberOfTrailingZeros(r5);
        r5 = r5 & (~r11);
        if (r10.length() <= 1) goto L7;
        r10.append(", ");
    L7:
        if (r11 != 1) goto L9;
        r10.append("FEEDBACK_SPOKEN");
        goto L3
    L9:
        if (r11 != 2) goto L11;
        r10.append("FEEDBACK_HAPTIC");
        goto L3
    L11:
        if (r11 != 4) goto L13;
        r10.append("FEEDBACK_AUDIBLE");
        goto L3
    L13:
        if (r11 != 8) goto L15;
        r10.append("FEEDBACK_VISUAL");
        goto L3
    L15:
        if (r11 != 16) goto L3;
        r10.append("FEEDBACK_GENERIC");
        goto L3
    L22:
        r10.append("]");
        return r10.toString();
    }

    @Nullable
    public static String flagToString(int r5) {
        if (r5 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r5 != 2) goto L7;
        return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
    L7:
        if (r5 != 4) goto L9;
        return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
    L9:
        if (r5 != 8) goto L11;
        return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L11:
        if (r5 != 16) goto L13;
        return "FLAG_REPORT_VIEW_IDS";
    L13:
        if (r5 == 32) goto L16;
        return null;
    L16:
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int getCapabilities(@NonNull AccessibilityServiceInfo r5) {
        return r5.getCapabilities();
    }

    @Nullable
    public static String loadDescription(@NonNull AccessibilityServiceInfo r5, @NonNull PackageManager r10) {
        return r5.loadDescription(r10);
    }
}
