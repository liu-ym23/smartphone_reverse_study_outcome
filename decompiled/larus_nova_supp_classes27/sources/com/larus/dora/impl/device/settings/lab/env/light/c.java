package com.larus.dora.impl.device.settings.lab.env.light;

import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.serviceimpl.SessionService;
import g49.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends p49.a {
    public static final a c = null;
    public static volatile c d;
    public final Lazy a;
    public final Lazy b;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements f49.b {
        public final /* synthetic */ c a;

        @Override // f49.b
        public final void b() {
        }

        @Override // f49.b
        public final void d(int r1) {
        }

        @Override // f49.b
        public final void h(int r1) {
        }

        @Override // f49.b
        public final void i() {
        }

        @Override // f49.b
        public final void j(byte[] r1, byte[] r2) {
        }

        @Override // f49.b
        public final void k() {
        }

        @Override // f49.b
        public final void m() {
        }

        @Override // f49.b
        public final void n() {
        }

        @Override // f49.b
        public final void o() {
        }

        @Override // f49.b
        public final void p() {
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // f49.b
        public final void l(int r7, int r8, int r9) {
            if (r8 == 11) goto L5;
            return;
        L5:
            if (r7 != 2) goto L15;
            IDoraPageConfig r10 = (IDoraPageConfig) this.a.b.getValue();
            boolean r11 = false;
            if (r10 != null) goto L9;
        L11:
            if (r11 == false) goto L16;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LightJob$init$1$onVoiceWakeUp$1(this.a, null), 3, null);
            return;
        L16:
            return;
        L9:
            if (r10.d("dora_g_config_key_env_observe_light_enable", false) != true) goto L11;
            r11 = true;
            goto L11
        }
    }

    static {
        c = new a();
    }

    public final void a() {
        d.d("LightJob", "LightJob init");
        IDoraService r0 = (IDoraService) this.a.getValue();
        if (r0 == null) goto L8;
        SessionService r1 = r0.d();
        if (r1 == null) goto L9;
        r1.i(new b(this));
        return;
    L9:
        return;
    }

    public c() {
        this.a = LazyKt.lazy(new com.larus.dora.impl.device.settings.lab.env.light.a());
        this.b = LazyKt.lazy(new com.larus.dora.impl.device.settings.lab.env.light.b());
    }
}
