package com.obric.oui.c;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.VectorDrawable;
import android.util.ArrayMap;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0003J \u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0003J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/utils/VectorBreaker;", "", "()V", "TAG", "", "reflectSetPathColor", "", "vd", "Landroid/graphics/drawable/VectorDrawable;", "pathName", TypedValues.Custom.S_COLOR, "", "reflectSetPathColor2", "Landroid/graphics/drawable/AnimatedVectorDrawable;", "setPathColor", "drawable", "Landroid/graphics/drawable/StateListDrawable;", "setPathColor2", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f13407a = null;

    static {
        f13407a = new g();
    }

    private g() {
    }

    private final void a(AnimatedVectorDrawable r1, String r2, int r3) {
        b(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "setPathColor2, Color injection failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void a(VectorDrawable r1, String r2, int r3) {
        b(r1, r2, r3);     // Catch: Exception -> L4
        r1.invalidateSelf();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("VectorBreaker", "Color injection failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void b(AnimatedVectorDrawable r4, String r5, int r6) {
        Field r0 = AnimatedVectorDrawable.class.getDeclaredField("mAnimatedVectorState");
        r0.setAccessible(true);
        Object r7 = r0.get(r4);
        Field r1 = r7.getClass().getDeclaredField("mVectorDrawable");
        if (r1 == null) goto L16;
        r1.setAccessible(true);
        c r2 = c.f13403a;
        Object r8 = r1.get(r7);
        if (r8 != null) goto L8;
    L6:
        r8 = null;
    L9:
        VectorDrawable r9 = (VectorDrawable) ZeusTransformUtils.preCheckCast(r8, VectorDrawable.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L14;
        b(r9, r5, r6);
        return;
    L14:
        throw new IllegalStateException("mVectorDrawable is null");
    L8:
        if (ZeusTransformUtils.instanceOf(r8, VectorDrawable.class) == false) goto L6;
    L16:
        throw new IllegalStateException("mVectorDrawable Field is null");
    }

    private final void b(VectorDrawable r6, String r7, int r8) {
        Field r5 = VectorDrawable.class.getDeclaredField("mVectorState");
        r5.setAccessible(true);
        Object r9 = r5.get(r6);
        Field r10 = r9.getClass().getDeclaredField("mVGTargetsMap");
        r10.setAccessible(true);
        Object r11 = r10.get(r9);
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.util.ArrayMap<kotlin.String, kotlin.Any>");
        Object r12 = ((ArrayMap) ZeusTransformUtils.preCheckCast(r11, ArrayMap.class, "com.obric.memorydata.plugin")).get(r7);
        if (r12 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r12.getClass().getSimpleName(), "VFullPath") == false) goto L9;
        Field r13 = ZeusTransformUtils.forName("android.graphics.drawable.VectorDrawable$VFullPath", "com.obric.memorydata.plugin").getDeclaredField("mNativePtr");
        r13.setAccessible(true);
        Object r14 = r13.get(r12);
        Objects.requireNonNull(r14, "null cannot be cast to non-null type kotlin.Long");
        long r15 = ((Long) ZeusTransformUtils.preCheckCast(r14, Long.class, "com.obric.memorydata.plugin")).longValue();
        Method r16 = ZeusTransformUtils.forName("android.graphics.drawable.VectorDrawable", "com.obric.memorydata.plugin").getDeclaredMethod("nSetFillColor", new Class[]{Long.TYPE, Integer.TYPE});
        r16.setAccessible(true);
        r16.invoke(null, new Object[]{Long.valueOf(r15), Integer.valueOf(r8)});
        return;
    }

    public final void a(StateListDrawable r6, String r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "drawable");
        Intrinsics.checkNotNullParameter(r7, "pathName");
        int r0 = r6.getStateCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r1 + 1;
        Drawable r3 = r6.getStateDrawable(r1);
        if (ZeusTransformUtils.instanceOf(r3, VectorDrawable.class) == false) goto L8;
        a((VectorDrawable) ZeusTransformUtils.preCheckCast(r3, VectorDrawable.class, "com.obric.memorydata.plugin"), r7, r8);
    L10:
        r1 = r2;
        goto L3
    L8:
        if (ZeusTransformUtils.instanceOf(r3, AnimatedVectorDrawable.class) == false) goto L10;
        a((AnimatedVectorDrawable) ZeusTransformUtils.preCheckCast(r3, AnimatedVectorDrawable.class, "com.obric.memorydata.plugin"), r7, r8);
        goto L10
    }
}
