package com.obric.memorydata.memory.ui;

import android.content.Context;
import android.os.Vibrator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0007J\u0018\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/memory/ui/VibratorSmt;", "", "<init>", "()V", "TAG", "", "IMPL_CLASS_NAME", "METHOD_NAME_1", "EFFECT_PRESS", "", "EFFECT_TAP", "EFFECT_LONG_PRESS", "EFFECT_TICK", "EFFECT_RIGID", "EFFECT_SOFT", "EFFECT_CONFIRM", "EFFECT_REJECT", "EFFECT_CLEAR", "EFFECT_WAKE_UP", "AOSP_EFFECT_ID_SEGMENT_TICK", "implClassInstance", "Ljava/lang/Class;", "method1Instance", "Ljava/lang/reflect/Method;", "vibrateEffectWithHapticPlayer", "", "context", "Landroid/content/Context;", "effectId", "performHapticFeedbackAOSP", "view", "Landroid/view/View;", TypedValues.AttributesType.S_TARGET, "Landroid/os/Vibrator;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f10971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f10972b;
    private static Method c;

    static {
        f10971a = new l();
    }

    private l() {
    }

    @JvmStatic
    public static final void a(Context r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        c r0 = c.f10771a;
        Object r1 = null;
        if (r8 == null) goto L5;
        Object r2 = r8.getSystemService("vibrator");
    L6:
        if (r2 != null) goto L9;
    L11:
        Vibrator r3 = (Vibrator) ZeusTransformUtils.preCheckCast(r1, Vibrator.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        a(r3, r7);
        return;
    L14:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ");
        if (r8 != null) goto L17;
        boolean r10 = true;
    L18:
        IRunLog.a.b(r4, "VibratorSmt", r9.append(r10).toString(), null, 4, null);
        return;
    L17:
        r10 = false;
        goto L18
    L9:
        if (ZeusTransformUtils.instanceOf(r2, Vibrator.class) == false) goto L11;
        r1 = r2;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void a(Vibrator r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, TypedValues.AttributesType.S_TARGET);
    L15:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "VibratorSmt", "vibrateEffectWithHapticPlayer error: " + e, null, 4, null);
        return;
    L4:
        if (f10972b != null) goto L7;
        f10972b = ZeusTransformUtils.forName("bytedanceos.api.VibratorSmt", "com.obric.memorydata.plugin");     // Catch: Exception -> L15
    L7:
        if (c != null) goto L11;
        Class<?> r1 = f10972b;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L15
        Method r2 = r1.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L15
        c = r2;     // Catch: Exception -> L15
        if (r2 == null) goto L11;
        r2.setAccessible(true);     // Catch: Exception -> L15
    L11:
        Method r3 = c;     // Catch: Exception -> L15
        if (r3 == null) goto L20;
        r3.invoke(f10972b, new Object[]{r8, Integer.valueOf(r9)});     // Catch: Exception -> L15
        return;
    }
}
