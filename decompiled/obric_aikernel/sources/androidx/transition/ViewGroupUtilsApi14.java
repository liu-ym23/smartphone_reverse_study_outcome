package androidx.transition;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
class ViewGroupUtilsApi14 {
    private static final int LAYOUT_TRANSITION_CHANGING = 4;
    private static final String TAG = "ViewGroupUtilsApi14";
    private static Method sCancelMethod;
    private static boolean sCancelMethodFetched;
    private static LayoutTransition sEmptyLayoutTransition;
    private static Field sLayoutSuppressedField;
    private static boolean sLayoutSuppressedFieldFetched;

    private ViewGroupUtilsApi14() {
    }

    private static void cancelLayoutTransition(LayoutTransition r10) {
        if (sCancelMethodFetched == false) goto L16;
    L9:
        Method r11 = sCancelMethod;
        if (r11 == null) goto L20;
        r11.invoke(r10, new Object[0]);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14
    L22:
        return;
    L14:
        Log.i(TAG, "Failed to access cancel method by reflection");
        return;
    L13:
        Log.i(TAG, "Failed to invoke cancel method by reflection");
        return;
    L20:
        return;
    L16:
        Method r12 = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);     // Catch: NoSuchMethodException -> L7
        sCancelMethod = r12;     // Catch: NoSuchMethodException -> L7
        r12.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L8:
        sCancelMethodFetched = true;
    L7:
        Log.i(TAG, "Failed to access cancel method by reflection");
        goto L8
    }

    static void suppressLayout(@NonNull ViewGroup r10, boolean r11) {
        boolean r12 = false;
        if (sEmptyLayoutTransition != null) goto L5;
        LayoutTransition r13 = new AnonymousClass1();
        sEmptyLayoutTransition = r13;
        r13.setAnimator(2, null);
        sEmptyLayoutTransition.setAnimator(0, null);
        sEmptyLayoutTransition.setAnimator(1, null);
        sEmptyLayoutTransition.setAnimator(3, null);
        sEmptyLayoutTransition.setAnimator(4, null);
    L5:
        if (r11 == false) goto L15;
        LayoutTransition r14 = r10.getLayoutTransition();
        if (r14 != null) goto L9;
    L14:
        r10.setLayoutTransition(sEmptyLayoutTransition);
        return;
    L9:
        if (r14.isRunning() == false) goto L12;
        cancelLayoutTransition(r14);
    L12:
        if (r14 == sEmptyLayoutTransition) goto L14;
        r10.setTag(R.id.transition_layout_save, r14);
        goto L14
    L15:
        r10.setLayoutTransition(null);
        if (sLayoutSuppressedFieldFetched == false) goto L39;
    L21:
        Field r15 = sLayoutSuppressedField;
        if (r15 != null) goto L41;
    L30:
        if (r12 == false) goto L32;
        r10.requestLayout();
    L32:
        int r16 = R.id.transition_layout_save;
        LayoutTransition r17 = (LayoutTransition) r10.getTag(r16);
        if (r17 == null) goto L44;
        r10.setTag(r16, null);
        r10.setLayoutTransition(r17);
        return;
    L44:
        return;
    L41:
        boolean r18 = r15.getBoolean(r10);     // Catch: IllegalAccessException -> L36
        if (r18 == true) goto L37;
    L28:
        r12 = r18;
        goto L30
    L37:
        sLayoutSuppressedField.setBoolean(r10, false);     // Catch: IllegalAccessException -> L27
    L27:
        r12 = r18;
    L29:
        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
        goto L30
    L39:
        Field r19 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");     // Catch: NoSuchFieldException -> L19
        sLayoutSuppressedField = r19;     // Catch: NoSuchFieldException -> L19
        r19.setAccessible(true);     // Catch: NoSuchFieldException -> L19
    L20:
        sLayoutSuppressedFieldFetched = true;
    L19:
        Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
        goto L20
    }
}
