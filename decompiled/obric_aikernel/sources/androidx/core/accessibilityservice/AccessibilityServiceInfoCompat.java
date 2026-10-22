package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
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
    public static String capabilityToString(int r10) {
        if (r10 != 1) goto L5;
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    L5:
        if (r10 != 2) goto L7;
        return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
    L7:
        if (r10 != 4) goto L9;
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L9:
        if (r10 == 8) goto L12;
        return "UNKNOWN";
    L12:
        return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }

    @NonNull
    public static String feedbackTypeToString(int r10) {
        StringBuilder r11 = new StringBuilder();
        String r12 = "[";
    L3:
        r11.append(r12);
    L4:
        if (r10 <= 0) goto L23;
        int r13 = 1 << Integer.numberOfTrailingZeros(r10);
        r10 = r10 & (~r13);
        if (r11.length() <= 1) goto L8;
        r11.append(", ");
    L8:
        if (r13 == 1) goto L22;
        if (r13 == 2) goto L21;
        if (r13 == 4) goto L20;
        if (r13 == 8) goto L19;
        if (r13 != 16) goto L4;
        r12 = "FEEDBACK_GENERIC";
        goto L3
    L19:
        r12 = "FEEDBACK_VISUAL";
        goto L3
    L20:
        r12 = "FEEDBACK_AUDIBLE";
        goto L3
    L21:
        r12 = "FEEDBACK_HAPTIC";
        goto L3
    L22:
        r12 = "FEEDBACK_SPOKEN";
        goto L3
    L23:
        r11.append("]");
        return r11.toString();
    }

    @Nullable
    public static String flagToString(int r10) {
        if (r10 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r10 != 2) goto L7;
        return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
    L7:
        if (r10 != 4) goto L9;
        return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
    L9:
        if (r10 != 8) goto L11;
        return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L11:
        if (r10 != 16) goto L13;
        return "FLAG_REPORT_VIEW_IDS";
    L13:
        if (r10 == 32) goto L16;
        return null;
    L16:
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int getCapabilities(@NonNull AccessibilityServiceInfo r10) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return r10.getCapabilities();
    L7:
        if (r10.getCanRetrieveWindowContent() == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    @Nullable
    public static String loadDescription(@NonNull AccessibilityServiceInfo r10, @NonNull PackageManager r11) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return r10.loadDescription(r11);
    L7:
        return r10.getDescription();
    }
}
