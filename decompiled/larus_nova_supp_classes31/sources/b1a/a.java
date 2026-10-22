package b1a;

import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionSlideParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuElementShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobUseTemplateMenuShowParamsKmp;
import kotlin.jvm.internal.Intrinsics;
import tx9.u3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements o0a.a {
    public a() {
    }

    @Override // o0a.a
    public final void a(MobUseTemplateMenuShowParamsKmp r11) {
        Intrinsics.checkNotNullParameter(r11, "params");
        u3.o(r11.a, r11.b, r11.c, r11.d, r11.e, r11.f, r11.g, r11.h, r11.i);
    }

    @Override // o0a.a
    public final void b(MobTemplateClickParamsKmp r41) {
        Intrinsics.checkNotNullParameter(r41, "params");
        Boolean r1 = r41.D;
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        u3.l(r41.a, r41.b, r41.c, r41.d, r41.e, r41.f, r41.g, r41.h, r41.i, r41.j, r41.k, r41.l, r41.m, r41.n, r41.o, r41.p, r41.q, r41.r, r41.s, r41.t, r41.u, r41.v, r41.w, r41.x, r41.y, r41.z, r41.A, r41.B, r41.C, Boolean.valueOf(r2), null, null, null, null, null, 384, 31);
        return;
    L5:
        r2 = IUgcAIGCService.a.v();
        goto L6
    }

    @Override // o0a.a
    public final void c(MobFeedStaytimeParamsKmp r17) {
        Intrinsics.checkNotNullParameter(r17, "params");
        String r2 = r17.a;
        String r3 = r17.b;
        String r4 = r17.c;
        Integer r5 = r17.d;
        String r6 = r17.e;
        String r7 = r17.f;
        String r15 = r17.g;
        u3.h(r2, r3, r4, r5, r6, r7, r17.h, r17.i, r17.j, r17.k, r17.l, r17.m, r17.n, r15);
    }

    @Override // o0a.a
    public final void d(MobSessionClickParamsKmp r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        String r1 = r15.a;
        String r2 = r15.b;
        String r3 = r15.c;
        Integer r4 = r15.d;
        String r5 = r15.e;
        String r6 = r15.f;
        String r13 = r15.g;
        u3.i(r1, r2, r3, r4, r5, r6, r15.h, r15.i, r15.j, r15.k, r15.l, r15.m, r13);
    }

    @Override // o0a.a
    public final void e(MobTemplateMenuClickParamsKmp r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        u3.m(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.g, r14.h, r14.i, r14.j, null, 3072);
    }

    @Override // o0a.a
    public final void f(MobSessionSlideParamsKmp r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        String r1 = r15.a;
        String r2 = r15.b;
        String r3 = r15.c;
        Integer r4 = r15.d;
        String r5 = r15.e;
        String r6 = r15.f;
        String r13 = r15.g;
        u3.j(r1, r2, r3, r4, r5, r6, r15.h, r15.i, r15.j, r15.k, r15.l, r15.m, r13);
    }

    @Override // o0a.a
    public final void g(MobTemplateShowParamsKmp r34) {
        Intrinsics.checkNotNullParameter(r34, "params");
        u3.k(r34.a, r34.b, r34.c, r34.d, r34.e, r34.f, r34.g, r34.h, r34.i, r34.j, r34.k, r34.l, r34.m, r34.n, r34.o, r34.p, r34.q, r34.r, r34.s, r34.t, r34.u, r34.v, r34.w, r34.x, r34.y, r34.z, r34.A, null, null, null, -134217728);
    }

    @Override // o0a.a
    public final void h(MobTemplateMenuElementShowParamsKmp r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        u3.n(r14.a, r14.b, r14.c, r14.d, r14.e, r14.f, r14.g, r14.h, r14.i, r14.j, null, 3072);
    }
}
