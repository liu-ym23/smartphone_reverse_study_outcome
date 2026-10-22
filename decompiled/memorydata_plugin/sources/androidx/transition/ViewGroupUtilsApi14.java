package androidx.transition;

import android.animation.LayoutTransition;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.Log;
import android.view.ViewGroup;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static void cancelLayoutTransition(LayoutTransition r7) {
        if (sCancelMethodFetched == false) goto L16;
    L9:
        Method r0 = sCancelMethod;
        if (r0 == null) goto L20;
        r0.invoke(r7, new Object[0]);     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L14
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
        Method r4 = LayoutTransition.class.getDeclaredMethod(ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, new Class[0]);     // Catch: NoSuchMethodException -> L7
        sCancelMethod = r4;     // Catch: NoSuchMethodException -> L7
        r4.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L8:
        sCancelMethodFetched = true;
    L7:
        Log.i(TAG, "Failed to access cancel method by reflection");
        goto L8
    }

    static void suppressLayout(ViewGroup r7, boolean r8) {
        boolean r2 = false;
        if (sEmptyLayoutTransition != null) goto L6;
        LayoutTransition r0 = new AnonymousClass1();
        sEmptyLayoutTransition = r0;
        r0.setAnimator(2, null);
        sEmptyLayoutTransition.setAnimator(0, null);
        sEmptyLayoutTransition.setAnimator(1, null);
        sEmptyLayoutTransition.setAnimator(3, null);
        sEmptyLayoutTransition.setAnimator(4, null);
    L6:
        if (r8 == false) goto L17;
        LayoutTransition r9 = r7.getLayoutTransition();
        if (r9 != null) goto L10;
    L15:
        LayoutTransition r10 = sEmptyLayoutTransition;
    L16:
        r7.setLayoutTransition(r10);
        return;
    L10:
        if (r9.isRunning() == false) goto L13;
        cancelLayoutTransition(r9);
    L13:
        if (r9 == sEmptyLayoutTransition) goto L15;
        r7.setTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, OaidModel.KEY_ID, "transition_layout_save"), r9);
        goto L15
    L17:
        r7.setLayoutTransition(null);
        if (sLayoutSuppressedFieldFetched == false) goto L41;
    L23:
        Field r11 = sLayoutSuppressedField;
        if (r11 != null) goto L39;
    L32:
        if (r2 == false) goto L34;
        r7.requestLayout();
    L34:
        r10 = (LayoutTransition) ZeusTransformUtils.preCheckCast(r7.getTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, OaidModel.KEY_ID, "transition_layout_save")), LayoutTransition.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L45;
        r7.setTag(ZeusTransformUtils.mapRes(R.id.transition_layout_save, OaidModel.KEY_ID, "transition_layout_save"), null);
        goto L16
    L45:
        return;
    L39:
        boolean r12 = r11.getBoolean(r7);     // Catch: IllegalAccessException -> L38
        if (r12 == true) goto L43;
    L30:
        r2 = r12;
        goto L32
    L43:
        sLayoutSuppressedField.setBoolean(r7, false);     // Catch: IllegalAccessException -> L29
    L29:
        r2 = r12;
    L31:
        Log.i(TAG, "Failed to get mLayoutSuppressed field by reflection");
        goto L32
    L41:
        Field r13 = ViewGroup.class.getDeclaredField("mLayoutSuppressed");     // Catch: NoSuchFieldException -> L21
        sLayoutSuppressedField = r13;     // Catch: NoSuchFieldException -> L21
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L21
    L22:
        sLayoutSuppressedFieldFetched = true;
    L21:
        Log.i(TAG, "Failed to access mLayoutSuppressed field by reflection");
        goto L22
    }
}
