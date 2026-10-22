package da;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f8521a = null;

    static {
        f8521a = new e();
    }

    private e() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void a(VectorDrawable r10, String r11, int r12) {
        Field r13 = VectorDrawable.class.getDeclaredField("mVectorState");
        Intrinsics.checkNotNullExpressionValue(r13, "stateField");
        r13.setAccessible(true);
        Object r14 = r13.get(r10);
        Field r15 = r14.getClass().getDeclaredField("mVGTargetsMap");
        Intrinsics.checkNotNullExpressionValue(r15, "targetsMapField");
        r15.setAccessible(true);
        Object r16 = r15.get(r14);
        Objects.requireNonNull(r16, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
        Object r17 = ((ArrayMap) r16).get(r11);
        if (r17 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r17.getClass().getSimpleName(), "VFullPath") == false) goto L9;
        Field r18 = Class.forName("android.graphics.drawable.VectorDrawable$VFullPath").getDeclaredField("mNativePtr");
        Intrinsics.checkNotNullExpressionValue(r18, "nativePtrField");
        r18.setAccessible(true);
        Object r19 = r18.get(r17);
        Objects.requireNonNull(r19, "null cannot be cast to non-null type kotlin.Long");
        long r20 = ((Long) r19).longValue();
        Method r21 = Class.forName("android.graphics.drawable.VectorDrawable").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        Intrinsics.checkNotNullExpressionValue(r21, "nSetFillColor");
        r21.setAccessible(true);
        r21.invoke(null, new Object[]{Long.valueOf(r20), Integer.valueOf(r12)});
        return;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private final void b(AnimatedVectorDrawable r10, String r11, int r12) {
        Field r13 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        Intrinsics.checkNotNullExpressionValue(r13, "stateField");
        r13.setAccessible(true);
        Object r14 = r13.get(r10);
        Field r15 = r14.getClass().getDeclaredField("mVectorDrawable");
        if (r15 == null) goto L16;
        r15.setAccessible(true);
        c r16 = c.f8520a;
        Object r17 = r15.get(r14);
        if (r17 != null) goto L8;
    L6:
        r17 = null;
    L9:
        VectorDrawable r18 = (VectorDrawable) r17;
        if (r18 == null) goto L14;
        a(r18, r11, r12);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if ((r17 instanceof VectorDrawable) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }

    private final void d(VectorDrawable r10, String r11, int r12) {
        a(r10, r11, r12);     // Catch: Exception -> L4
        r10.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", e);
    }

    private final void e(AnimatedVectorDrawable r10, String r11, int r12) {
        b(r10, r11, r12);     // Catch: Exception -> L4
        r10.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", e);
    }

    @RequiresApi(29)
    public final void c(StateListDrawable r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        Intrinsics.checkNotNullParameter(r11, "pathName");
        int r13 = r10.getStateCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L11;
        Drawable r15 = r10.getStateDrawable(r14);
        if ((r15 instanceof VectorDrawable) == false) goto L8;
        d((VectorDrawable) r15, r11, r12);
    L10:
        r14 = r14 + 1;
        goto L3
    L8:
        if ((r15 instanceof AnimatedVectorDrawable) == false) goto L10;
        e((AnimatedVectorDrawable) r15, r11, r12);
        goto L10
    }
}
