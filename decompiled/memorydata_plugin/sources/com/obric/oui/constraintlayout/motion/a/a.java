package com.obric.oui.constraintlayout.motion.a;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.motion.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13660a = null;

        static {
            int[] r0 = new int[ConstraintAttribute.AttributeType.values().length];
            f13660a = r0;
            r0[ConstraintAttribute.AttributeType.INT_TYPE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f13660a[ConstraintAttribute.AttributeType.FLOAT_TYPE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f13660a[ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f13660a[ConstraintAttribute.AttributeType.COLOR_TYPE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f13660a[ConstraintAttribute.AttributeType.STRING_TYPE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f13660a[ConstraintAttribute.AttributeType.BOOLEAN_TYPE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f13660a[ConstraintAttribute.AttributeType.DIMENSION_TYPE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    private static int a(int r1) {
        int r2 = (r1 & (~(r1 >> 31))) - 255;
        return (r2 & (r2 >> 31)) + 255;
    }

    public static void a(ConstraintAttribute r16, View r17, float[] r18) {
        Class<?> r0 = r17.getClass();
        String r5 = "set" + r16.a();
        boolean r12 = true;
        switch(AnonymousClass1.f13660a[r16.getType().ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L28;
        };     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L6:
        r0.getMethod(r5, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L7:
        Method r1 = r0.getMethod(r5, new Class[]{Boolean.TYPE});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        Object[] r6 = new Object[1];     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        if (r18[0] > 0.5f) goto L11;
        r12 = false;
    L11:
        r6[0] = Boolean.valueOf(r12);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r1.invoke(r17, r6);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L14:
        r0.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((((a((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (r18[3] * 255.0f)) << 24)) | (a((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | a((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f)))});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L15:
        Method r2 = r0.getMethod(r5, new Class[]{Drawable.class});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        int r7 = (((a((int) (((float) Math.pow(r18[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (r18[3] * 255.0f)) << 24)) | (a((int) (((float) Math.pow(r18[1], 0.45454545454545453d)) * 255.0f)) << 8)) | a((int) (((float) Math.pow(r18[2], 0.45454545454545453d)) * 255.0f));     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        ColorDrawable r8 = new ColorDrawable();     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r8.setColor(r7);     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        r2.invoke(r17, new Object[]{r8});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L16:
        r0.getMethod(r5, new Class[]{Float.TYPE}).invoke(r17, new Object[]{Float.valueOf(r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L17:
        r0.getMethod(r5, new Class[]{Integer.TYPE}).invoke(r17, new Object[]{Integer.valueOf((int) r18[0])});     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
        return;
    L28:
        return;
    L13:
        throw new RuntimeException("unable to interpolate strings " + r16.a());     // Catch: InvocationTargetException -> L19 IllegalAccessException -> L21 NoSuchMethodException -> L23
    L21:
        e = e;
        StringBuilder r9 = new StringBuilder();
        String r10 = "Cannot access method ";
    L25:
        Log.e("CustomSupport", r9.append(r10).append(r5).append(" on View \"").append(com.obric.oui.constraintlayout.motion.widget.a.a(r17)).append("\"").toString(), e);
        return;
    L23:
        e = e;
        r9 = new StringBuilder();
        r10 = "No method ";
    L19:
        e = e;
        r9 = new StringBuilder();
        r10 = "Cannot invoke method ";
        goto L25
    }
}
