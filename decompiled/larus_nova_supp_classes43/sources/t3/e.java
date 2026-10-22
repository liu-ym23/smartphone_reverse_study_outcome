package t3;

import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final a b = null;
    public final boolean a;

    public static final class a {
        public a() {
        }

        public static e a(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Object r0 = r10.getSystemService("power");
            if ((r0 instanceof PowerManager) == false) goto L5;
            PowerManager r1 = (PowerManager) r0;
        L6:
            boolean r11 = true;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L13
            if (Settings.System.getInt(r10.getContentResolver(), "POWER_SAVE_MODE_OPEN", 0) != 1) goto L10;
            boolean r13 = true;
        L11:
            Object r14 = Result.constructor-impl(Boolean.valueOf(r13));     // Catch: Throwable -> L13
        L15:
            Boolean r15 = Boolean.FALSE;
            if (Result.isFailure-impl(r14) == false) goto L18;
            r14 = r15;
        L18:
            boolean r16 = ((Boolean) r14).booleanValue();
            if (r1 != null) goto L21;
        L23:
            boolean r17 = false;
        L24:
            if (r17 == true) goto L29;
            if (r16 == true) goto L29;
            r11 = false;
        L29:
            return new e(r11);
        L21:
            if (r1.isPowerSaveMode() != true) goto L23;
            r17 = true;
            goto L24
        L10:
            r13 = false;
        L13:
            th = move-exception;
            Result.Companion r18 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L5:
            r1 = null;
            goto L6
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.a == ((e) r10).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "BatteryInfoChangeSnapshot(isLowPowerModeEnabled=" + this.a + ')';
    }

    static {
        b = new a();
    }

    public e(boolean r1) {
        this.a = r1;
    }
}
