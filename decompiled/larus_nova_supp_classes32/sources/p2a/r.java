package p2a;

import com.larus.voice_setting.INativeVoiceSettingService;
import com.larus.voice_setting.VoiceSettingRuntimeKind;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.d0;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements h {
    public static final r b = null;
    public static final z c = null;

    public r() {
    }

    static {
        b = new r();
        c = new z();
    }

    public static h u() {
        int r0 = w.a;
        boolean r1 = y.a();
        b r2 = c.a;
        h r3 = c.a(Reflection.getOrCreateKotlinClass(INativeVoiceSettingService.class));
        h r4 = (c) c.a(Reflection.getOrCreateKotlinClass(c.class));
        if (r4 != null) goto L6;
        r4 = (h) c.a(Reflection.getOrCreateKotlinClass(h.class));
    L6:
        z r5 = c;
        Intrinsics.checkNotNullParameter(r5, "fallback");
        if (r1 == false) goto L11;
        if (r4 == null) goto L11;
        x r6 = new x(r4, VoiceSettingRuntimeKind.KMP);
    L15:
        return r6.a;
    L11:
        if (r3 != null) goto L13;
        r3 = r5;
    L13:
        r6 = new x(r3, VoiceSettingRuntimeKind.NATIVE);
        goto L15
    }

    public final d a3() {
        return u().a3();
    }

    public final v2a.b f7() {
        return u().f7();
    }

    public final a l2() {
        return u().l2();
    }

    public final void G(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        u().G(r2);
    }

    public final void T0(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        u().T0(r2);
    }

    public final void X2(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        u().X2(r2);
    }
}
