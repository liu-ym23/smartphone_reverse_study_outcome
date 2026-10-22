package q9;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import da.c;
import ea.b;
import java.lang.reflect.Method;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f12487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f12488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12489c = null;

    static {
        f12489c = new a();
    }

    private a() {
    }

    @JvmStatic
    public static final void b(Context r10, int r11) {
        c r12 = c.f8520a;
        Object r13 = null;
        if (r10 == null) goto L5;
        Object r14 = r10.getSystemService("vibrator");
    L6:
        if (r14 != null) goto L9;
    L11:
        Vibrator r15 = (Vibrator) r13;
        if (r15 == null) goto L14;
        c(r15, r11);
        return;
    L14:
        StringBuilder r16 = new StringBuilder();
        r16.append("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ");
        if (r10 != null) goto L17;
        boolean r17 = true;
    L18:
        r16.append(r17);
        b.b("VibratorSmt", r16.toString());
        return;
    L17:
        r17 = false;
        goto L18
    L9:
        if ((r14 instanceof Vibrator) == false) goto L11;
        r13 = r14;
        goto L11
    L5:
        r14 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(Vibrator r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, TypedValues.AttributesType.S_TARGET);
    L15:
        e = move-exception;
        b.b("VibratorSmt", "vibrateEffectWithHapticPlayer error: " + e);
        return;
    L4:
        if (f12487a != null) goto L7;
        f12487a = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Exception -> L15
    L7:
        if (f12488b != null) goto L11;
        Class<?> r12 = f12487a;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L15
        Method r13 = r12.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L15
        f12488b = r13;     // Catch: Exception -> L15
        if (r13 == null) goto L11;
        r13.setAccessible(true);     // Catch: Exception -> L15
    L11:
        Method r14 = f12488b;     // Catch: Exception -> L15
        if (r14 == null) goto L20;
        r14.invoke(f12487a, new Object[]{r10, Integer.valueOf(r11)});     // Catch: Exception -> L15
        return;
    }

    public final void a(View r10, int r11) {
        if (r10 == null) goto L10;
        r10.performHapticFeedback(r11);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        return;
    }
}
