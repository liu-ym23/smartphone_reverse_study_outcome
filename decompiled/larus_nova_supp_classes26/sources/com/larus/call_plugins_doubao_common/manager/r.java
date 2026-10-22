package com.larus.call_plugins_doubao_common.manager;

import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r extends n0 {
    public final com.larus.media.model.a u;

    public static final class a implements com.larus.media.v {
        public final /* synthetic */ r a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function0<Unit> c;

        public final boolean b(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r0 = com.larus.media.o0.a;
            return com.larus.media.o0.a("dora", r2.getScene());
        }

        public final void e(lk9.g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.d(r2);
            this.a.a.invoke();
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(lk9.g r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            com.larus.media.v.a.f(r2, r3);
            r r4 = this.a;
            if (r4.l == false) goto L6;
            r4.l = false;
            this.c.invoke();
            return;
        }

        public final void d(lk9.g r1, lk9.g r2) {
            com.larus.media.v.a.c(r1, r2);
        }

        public final void g(lk9.g r1, float r2) {
            com.larus.media.v.a.g(r1, r2);
        }

        public final void i(lk9.g r2, lk9.g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            com.larus.media.v.a.e(r2, r3);
            if (Intrinsics.areEqual(r3.getScene(), "NAVIGATION") == false) goto L6;
            this.a.l = true;
            this.b.invoke();
            return;
        }

        public a(r r1, Function0<Unit> r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
            return com.larus.media.v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(lk9.g r1, lk9.g r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, "current");
            Intrinsics.checkNotNullParameter(r2, "applicant");
            Map r4 = com.larus.media.o0.a;
            return com.larus.media.o0.b(r1.getScene(), r2.getScene());
        }
    }

    @Override // com.larus.call_plugins_doubao_common.manager.n0
    public final void k() {
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.a(this.u);
    }

    @Override // com.larus.call_plugins_doubao_common.manager.n0
    public final void m() {
        Lazy r0 = MediaResourceManager.a;
        MediaResourceManager.m(this.u, new n(), new o(), 0, 8);
    }

    @Override // com.larus.call_plugins_doubao_common.manager.n0
    public final void a(int r4, String r5) {
        if (r4 == (-1)) goto L19;
        boolean r0 = false;
        if (r4 != 2) goto L7;
    L18:
        Lazy r6 = MediaResourceManager.a;
        MediaResourceManager.m(this.u, new p(), new q(), 0, 8);
        return;
    L7:
        if (r4 == 5) goto L18;
        if (r4 != 7) goto L24;
        IObricDoraService r7 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r7 != null) goto L14;
    L16:
        if (r0 == false) goto L21;
        Lazy r8 = MediaResourceManager.a;
        MediaResourceManager.a(this.u);
        return;
    L21:
        return;
    L14:
        if (r7.t() != true) goto L16;
        r0 = true;
        goto L16
    L24:
        return;
    L19:
        Lazy r9 = MediaResourceManager.a;
        MediaResourceManager.a(this.u);
    }

    public r(Function0<Unit> r28, Function0<Unit> r29, Function0<Unit> r30, Function1<? super Float, Unit> r31) {
        Intrinsics.checkNotNullParameter(r28, "onFinish");
        Intrinsics.checkNotNullParameter(r29, "onPause");
        Intrinsics.checkNotNullParameter(r30, "onResume");
        Intrinsics.checkNotNullParameter(r31, "onMediaVolumeChange");
        super(r28, r29, r30, r31, null, null, null, null, false, false, 2032);
        this.u = new com.larus.media.model.a(null, "dora", false, 1, 3, false, 0, false, false, 0, false, new a(this, r29, r30), 2021);
    }
}
