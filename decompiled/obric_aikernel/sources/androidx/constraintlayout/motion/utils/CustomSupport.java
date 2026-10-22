package androidx.constraintlayout.motion.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class CustomSupport {
    private static final String TAG = "CustomSupport";

    /* JADX INFO: renamed from: androidx.constraintlayout.motion.utils.CustomSupport$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = null;

        static {
            int[] r10 = new int[ConstraintAttribute.AttributeType.values().length];
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r10;
            r10[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public CustomSupport() {
    }

    private static int clamp(int r10) {
        int r11 = (r10 & (~(r10 >> 31))) - 255;
        return (r11 & (r11 >> 31)) + 255;
    }

    public static void setInterpolatedValue(ConstraintAttribute r16, View r17, float[] r18) {
        Class<?> r10 = r17.getClass();
        String r11 = "set" + r16.getName();
        boolean r12 = true;
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[r16.getType().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L27;
        };     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L6:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L7:
        Method r13 = r10.getMethod(r11, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        Object[] r14 = new Object[1];     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        if (r18[0] > 0.5f) goto L11;
        r12 = false;
    L11:
        r14[0] = Boolean.valueOf(r12);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r13.invoke(r17, r14);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L14:
        r10.getMethod(r11, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((((clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L15:
        Method r15 = r10.getMethod(r11, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        int r19 = (((clamp((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (clamp((int) (r18[3] * 255.0f)) << 24)) | (clamp((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | clamp((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        ColorDrawable r20 = new ColorDrawable();     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r20.setColor(r19);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r15.invoke(r17, new Object[]{r20});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L16:
        r10.getMethod(r11, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L17:
        r10.getMethod(r11, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L27:
        return;
    L13:
        throw new RuntimeException("unable to interpolate strings " + r16.getName());     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L21:
        e = move-exception;
        Log.e(TAG, "cannot access method " + r11 + " on View \"" + Debug.getName(r17) + "\"");
        e.printStackTrace();
        return;
    L23:
        e = move-exception;
        Log.e(TAG, "no method " + r11 + " on View \"" + Debug.getName(r17) + "\"");
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }
}
