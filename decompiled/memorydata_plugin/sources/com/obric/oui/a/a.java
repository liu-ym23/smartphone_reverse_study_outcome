package com.obric.oui.a;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.c.a.b;
import com.obric.oui.c.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/haptic/VibratorSmt;", "", "()V", "AOSP_EFFECT_ID_SEGMENT_TICK", "", "EFFECT_CLEAR", "EFFECT_CONFIRM", "EFFECT_LONG_PRESS", "EFFECT_PRESS", "EFFECT_REJECT", "EFFECT_RIGID", "EFFECT_SOFT", "EFFECT_TAP", "EFFECT_TICK", "EFFECT_WAKE_UP", "IMPL_CLASS_NAME", "", "METHOD_NAME_1", "TAG", "implClassInstance", "Ljava/lang/Class;", "method1Instance", "Ljava/lang/reflect/Method;", "performHapticFeedbackAOSP", "", "view", "Landroid/view/View;", "effectId", "vibrateEffectWithHapticPlayer", "context", "Landroid/content/Context;", TypedValues.AttributesType.S_TARGET, "Landroid/os/Vibrator;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13272a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f13273b;
    private static Method c;

    static {
        f13272a = new a();
    }

    private a() {
    }

    @JvmStatic
    public static final void a(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        c r0 = c.f13403a;
        Object r1 = null;
        if (r6 != null) goto L5;
        Object r2 = null;
    L6:
        if (r2 != null) goto L9;
    L11:
        Vibrator r3 = (Vibrator) ZeusTransformUtils.preCheckCast(r1, Vibrator.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        a(r3, r5);
        return;
    L14:
        if (r6 != null) goto L16;
        boolean r7 = true;
    L17:
        b.e("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r7)));
        return;
    L16:
        r7 = false;
        goto L17
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Vibrator.class) == false) goto L11;
        r1 = r2;
        goto L11
    L5:
        r2 = r6.getSystemService("vibrator");
        goto L6
    }

    @JvmStatic
    public static final void a(Vibrator r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
    L17:
        e = move-exception;
        b.e("VibratorSmt", Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L4:
        if (f13273b != null) goto L7;
        f13273b = ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.memorydata.plugin");     // Catch: Exception -> L17
    L7:
        if (c != null) goto L12;
        Class<?> r0 = f13273b;     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L17
        Method r1 = r0.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L17
        c = r1;     // Catch: Exception -> L17
        if (r1 == null) goto L12;
        r1.setAccessible(true);     // Catch: Exception -> L17
    L12:
        Method r2 = c;     // Catch: Exception -> L17
        if (r2 == null) goto L22;
        r2.invoke(f13273b, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L17
        return;
    }

    public final void a(View r1, int r2) {
        if (r1 == null) goto L11;
        r1.performHapticFeedback(r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        b.e("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
        return;
    }
}
