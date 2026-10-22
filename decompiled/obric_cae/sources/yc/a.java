package yc;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import he.i;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(VectorDrawable r8, int r10) {
        Field r11 = VectorDrawable.class.getDeclaredField("mVectorState");
        i.e(r11, "stateField");
        r11.setAccessible(true);
        Object r12 = r11.get(r8);
        Field r13 = r12.getClass().getDeclaredField("mVGTargetsMap");
        i.e(r13, "targetsMapField");
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        if (r14 == null) goto L15;
        Object r15 = ((ArrayMap) r14).get("primary_shape");
        if (r15 != null) goto L7;
        return;
    L7:
        if (i.a(r15.getClass().getSimpleName(), "VFullPath") == false) goto L16;
        Field r16 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        i.e(r16, "nativePtrField");
        r16.setAccessible(true);
        Object r17 = r16.get(r15);
        if (r17 == null) goto L12;
        long r18 = ((Long) r17).longValue();
        Method r19 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        i.e(r19, "nSetFillColor");
        r19.setAccessible(true);
        r19.invoke(null, new Object[]{Long.valueOf(r18), Integer.valueOf(r10)});
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void b(AnimatedVectorDrawable r8, int r10) {
        Field r11 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        i.e(r11, "stateField");
        r11.setAccessible(true);
        Object r12 = r11.get(r8);
        Field r13 = r12.getClass().getDeclaredField("mVectorDrawable");
        if (r13 == null) goto L18;
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        if (r14 != null) goto L8;
    L10:
        r14 = null;
    L11:
        VectorDrawable r15 = (VectorDrawable) r14;
        if (r15 == null) goto L16;
        a(r15, r10);
        return;
    L16:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r14 instanceof VectorDrawable) == false) goto L10;
    L18:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }
}
