package com.larus.bmhome.taskskill.interaction;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import bs8.g;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.TaskModeService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcDeviceSelectionHandler {
    public c a;
    public a b;

    public interface a {
        void a(PcDevice r1);

        void b(String r1);

        void c(PcDevice r1);
    }

    public static final class b {
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
        }

        public final String toString() {
            return "ToastResources(offline=" + this.a + ", needUpgrade=" + this.b + ", controlDisabled=" + this.c + ", verifyFailed=" + this.d + ')';
        }

        public c(int r1) {
            this.a = r1;
            this.b = 2131901739;
            this.c = 2131901734;
            this.d = 2131901751;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PcDeviceUiState.values().length];
            r0[PcDeviceUiState.OFFLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PcDeviceUiState.NEED_UPGRADE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PcDeviceUiState.CONTROL_DISABLED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PcDeviceUiState.UNAUTHORIZED_AVAILABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public PcDeviceSelectionHandler(c r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "toastRes");
        this.a = r2;
        this.b = r3;
    }

    public final void b(Context r10, LifecycleCoroutineScope r11, PcDevice r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "device");
        int r0 = d.a[g.b(r12).ordinal()];
        if (r0 == 1) goto L29;
        if (r0 != 2) goto L7;
        s r13 = s.a;
        int r14 = this.a.b;
        r13.getClass();
        s.s(r10, r14);
        return;
    L7:
        if (r0 != 3) goto L9;
        s r15 = s.a;
        int r1 = this.a.c;
        r15.getClass();
        s.s(r10, r1);
        String r16 = r12.getDeviceId();
        if (r16 != null) goto L24;
        r16 = "";
    L24:
        if (StringsKt.isBlank(r16) == false) goto L26;
        FLogger.a.w("PcDeviceSelectionHandler", "[requestEnableControlPermission] empty deviceId");
        return;
    L26:
        TaskModeService.a.e(r16);
        return;
    L9:
        if (r0 == 4) goto L13;
        a r17 = this.b;
        if (r17 == null) goto L35;
        r17.a(r12);
        return;
    L35:
        return;
    L13:
        a r2 = this.b;
        if (r2 == null) goto L17;
        r2.b(r12.getDeviceId());
    L17:
        if (TaskModeService.a.b() == true) goto L19;
        FLogger.a.i("PcDeviceSelectionHandler", "[handleUnauthorizedDeviceClick] skip mfa, deviceId=" + r12.getDeviceId());
        a(r10, r11, r12, "", true);
        return;
    L19:
        FLogger.a.i("PcDeviceSelectionHandler", "[startMfaVerify] deviceId=" + r12.getDeviceId());
        AccountService.a.u(new com.larus.bmhome.taskskill.interaction.a(r12, this, r10, r11));
        return;
    L29:
        if (Intrinsics.areEqual(qa9.a.a().a(), "1") == false) goto L33;
        a r18 = this.b;
        if (r18 == null) goto L42;
        r18.a(r12);
        return;
    L42:
        return;
    L33:
        s r19 = s.a;
        int r110 = this.a.a;
        r19.getClass();
        s.s(r10, r110);
    }

    public final void a(Context r15, CoroutineScope r16, PcDevice r17, String r18, boolean r19) {
        String r0 = r17.getDeviceId();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        if (r18 != null) goto L8;
        String r5 = "";
    L10:
        if (StringsKt.isBlank(r3) == true) goto L17;
        if (r19 == false) goto L13;
    L15:
        BuildersKt.launch$default(r16, null, null, new PcDeviceSelectionHandler$authorizeDevice$1(this, r17, r3, r15, r5, null), 3, null);
        return;
    L13:
        if (StringsKt.isBlank(r5) == false) goto L15;
    L17:
        FLogger.a.w("PcDeviceSelectionHandler", "[authorizeDevice] invalid params, targetDeviceId=" + r3 + ", ticketBlank=" + StringsKt.isBlank(r5));
        a r1 = this.b;
        if (r1 == null) goto L20;
        r1.b(null);
    L20:
        s r2 = s.a;
        int r4 = this.a.d;
        r2.getClass();
        s.s(r15, r4);
        return;
    L8:
        r5 = r18;
        goto L10
    L5:
        r3 = r0;
        goto L6
    }
}
