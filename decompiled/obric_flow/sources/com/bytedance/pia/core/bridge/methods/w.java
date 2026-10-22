package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.api.bridge.PiaMethod$Error;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.setting.Settings;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements ah.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah.b f7028a = null;

    static {
        f7028a = new ah.b("pia.internal.setting.get", PiaMethod$Scope.f6954c, new a(2));
    }

    @Override // ah.a
    public final void a(gh.c r5, Object r10, gh.b r11, n0 r12) {
        Void r13 = (Void) r10;
        nh.d r14 = r5.f17099b;     // Catch: Throwable -> L5
        Lazy r15 = Settings.B;     // Catch: Throwable -> L5
        Map<String, Boolean> r16 = (Map) com.lynx.tasm.p.a().f7070w.getValue();     // Catch: Throwable -> L5
        Map<String, Boolean> r17 = (Map) com.lynx.tasm.p.a().f7071x.getValue();     // Catch: Throwable -> L5
        com.bytedance.pia.core.setting.a r18 = r14.d;     // Catch: Throwable -> L5
        v r19 = new v();     // Catch: Throwable -> L5
        r19.f7025a = r16;     // Catch: Throwable -> L5
        r19.f7026b = r17;     // Catch: Throwable -> L5
        r19.f7027c = r18;     // Catch: Throwable -> L5
        r11.accept(r19);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r12.accept(new PiaMethod$Error(th.toString()));
    }
}
