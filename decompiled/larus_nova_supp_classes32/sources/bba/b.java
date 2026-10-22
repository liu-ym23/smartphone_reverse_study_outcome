package bba;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.bytedance.keva.Keva;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public final ContentResolver a;

    public static final class a {
    }

    static {
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2.getApplicationContext().getContentResolver();
    }

    public final bba.a a(Long r17) {
        boolean r1 = true;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(Keva.getRepo("obric_ai_key_gesture", 1));     // Catch: Throwable -> L5
    L7:
        Long r3 = null;
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        Keva r4 = (Keva) r2;
        Object r5 = Result.constructor-impl(Integer.valueOf(Settings.Global.getInt(this.a, "ai_key_sensitivity", 0)));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r5) == false) goto L18;
        r5 = 0;
    L18:
        int r6 = ((Number) r5).intValue();
        long r8 = 180000;
        if (r4 != null) goto L78;
        Long r7 = null;
    L24:
        Object r9 = Result.constructor-impl(r7);     // Catch: Throwable -> L21
    L28:
        if (Result.isFailure-impl(r9) == false) goto L30;
        r9 = null;
    L30:
        Long r10 = (Long) r9;
        if (r10 == null) goto L33;
        long r11 = r10.longValue();
    L35:
        if (r17 != null) goto L37;
    L45:
        long r14 = r11;
    L46:
        if (r17 != null) goto L48;
    L57:
        long[] r12 = bba.a.e;
        if (r6 >= 0) goto L60;
    L62:
        boolean r13 = false;
    L63:
        if (r13 == false) goto L65;
        long r15 = r12[r6];
    L66:
        Long r16 = Long.valueOf(r14);
        if (r16.longValue() > 0) goto L70;
        r1 = false;
    L70:
        if (r1 == false) goto L72;
        r3 = r16;
    L72:
        if (r3 == null) goto L75;
        r8 = r3.longValue();
    L75:
        return new bba.a(r15, r8);
    L65:
        r15 = r12[0];
        goto L66
    L60:
        if (r6 >= 3) goto L62;
        r13 = true;
        goto L63
    L48:
        if (r14 == r11) goto L57;
        if (r4 != null) goto L76;
        Unit r18 = null;
    L54:
        Result.constructor-impl(r18);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L57
    L76:
        r4.storeLong("gesture_timeout_millis", r14);     // Catch: Throwable -> L51
        r18 = Unit.INSTANCE;     // Catch: Throwable -> L51
        goto L54
    L37:
        if (r17.longValue() <= 0) goto L39;
        boolean r20 = true;
    L40:
        if (r20 == false) goto L42;
        Long r21 = r17;
    L43:
        if (r21 == null) goto L45;
        r14 = r21.longValue();
        goto L46
    L42:
        r21 = null;
        goto L43
    L39:
        r20 = false;
        goto L40
    L33:
        r11 = 180000;
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L78:
        r7 = Long.valueOf(r4.getLong("gesture_timeout_millis", 180000));     // Catch: Throwable -> L21
    L13:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
