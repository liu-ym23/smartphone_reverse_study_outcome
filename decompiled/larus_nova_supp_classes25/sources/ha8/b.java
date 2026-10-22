package ha8;

import android.content.Context;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.avlink.n1;
import com.larus.avlink.simulInterpret.page.model.DoraDeviceType;
import com.larus.avlink.u0;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Function0 r3) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L7;
        SessionService r1 = r0.d();
        if (r1 == null) goto L7;
        IDoraService.h.a.a(r1, 3, DoraCallStateCode.DOUBAO_STOP_SI_BY_GUI);
    L7:
        if (r3 == null) goto L10;
        r3.invoke();
        return;
    }

    public static void b(Context r6, String r7, Function0 r8, Function0 r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "sourceTag");
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        Integer r1 = null;
        if (r0 == null) goto L5;
        DeviceService r2 = r0.device();
    L6:
        boolean r3 = true;
        if (r2 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        DoraDeviceType r5 = DoraDeviceType.DEVICE_LITE;
    L23:
        if (c98.c.a() == false) goto L26;
        n1.d(r7, "not start si in GUI due to isDoraCallDegrade");
        c98.c.b(false);
    L64:
        IDoraService r10 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r10 == null) goto L68;
        r10.A0("dora_interpretation_start_click", MapsKt.emptyMap());
        return;
    L68:
        return;
    L26:
        if (r5 != DoraDeviceType.DEVICE_LITE) goto L41;
        IDoraService r11 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r11 == null) goto L34;
        DeviceService r12 = r11.device();
        if (r12 == null) goto L34;
        if (r12.G() != true) goto L34;
    L35:
        if (r3 == false) goto L37;
        c(r6, r7, r5, r8);
        goto L64
    L37:
        d.e(r6, null);
        n1.d(r7, "not start si in GUI due to buds disconnected");
        if (r9 == null) goto L40;
        r9.invoke();
    L40:
        s r13 = s.a;
        int r14 = j0.a;
        s.j(r13, r6, j0.d(2131903324), null, false, 28);
    L34:
        r3 = false;
        goto L35
    L41:
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L48;
        DeviceService r16 = r15.device();
        if (r16 == null) goto L48;
        if (r16.W() != true) goto L48;
    L49:
        if (r3 == true) goto L63;
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r17 == null) goto L53;
        r1 = Integer.valueOf(r17.d0());
    L53:
        n1.d(r7, "wear count is " + r1 + " in start");
        if (r1 != null) goto L57;
    L58:
        c(r6, r7, r5, r8);
        goto L64
    L57:
        if (r1.intValue() != 0) goto L58;
        boolean r18 = d.a;
        int r19 = u0.a;
        u0.a(j0.d(2131902703));
        n1.d(r7, "not start si in GUI due wear count is 0 buds");
        if (r9 == null) goto L62;
        r9.invoke();
    L62:
        s r20 = s.a;
        int r21 = j0.a;
        s.j(r20, r6, j0.d(2131902484), null, false, 28);
        goto L64
    L63:
        n1.d(r7, "not start si in GUI due head phone mode");
        s r22 = s.a;
        int r23 = j0.a;
        s.j(r22, r6, j0.d(2131904009), null, false, 28);
    L48:
        r3 = false;
        goto L49
    L14:
        if (r2 != null) goto L16;
    L18:
        boolean r24 = false;
    L19:
        if (r24 == false) goto L21;
        r5 = DoraDeviceType.DEVICE_G;
        goto L23
    L21:
        r5 = DoraDeviceType.UNKNOWN;
        goto L23
    L16:
        if (r2.M() != true) goto L18;
        r24 = true;
        goto L19
    L9:
        if (r2.a() != true) goto L11;
        r4 = true;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static void c(Context r6, String r7, DoraDeviceType r8, Function0 r9) {
        if (r8 != DoraDeviceType.DEVICE_LITE) goto L5;
        String r10 = "lite";
    L6:
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L13;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.k0() != true) goto L13;
    L14:
        if (r2 == true) goto L16;
        n1.d(r7, "not start si in GUI due to not support in ".concat(r10));
        s r3 = s.a;
        int r11 = j0.a;
        s.j(r3, r6, j0.d(2131903360), null, false, 28);
        return;
    L16:
        if (b98.b.b(3) == false) goto L18;
        n1.d(r7, "not start si in GUI due to video recording in ".concat(r10));
        s r4 = s.a;
        int r12 = j0.a;
        s.j(r4, r6, j0.d(2131902665), null, false, 28);
        return;
    L18:
        if (r9 == null) goto L20;
        r9.invoke();
    L20:
        n1.d(r7, "start si in GUI in ".concat(r10));
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L28;
        SessionService r14 = r13.d();
        if (r14 == null) goto L29;
        r14.o(5, 8);
        return;
    L29:
        return;
    L28:
        return;
    L13:
        r2 = false;
        goto L14
    L5:
        r10 = "g";
        goto L6
    }
}
