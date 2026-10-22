package b1a;

import com.larus.im.FlowRuntime;
import com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionSlideParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuElementShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobUseTemplateMenuShowParamsKmp;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements o0a.a {
    public static final v a = null;

    public static final class a {
    }

    public c() {
    }

    static {
        a = w.a(new b());
    }

    @Override // o0a.a
    public final void a(MobUseTemplateMenuShowParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobUseTemplateMenuShowParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("use_template_menu_show", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void b(MobTemplateClickParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobTemplateClickParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("use_template", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void c(MobFeedStaytimeParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobFeedStaytimeParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("feed_staytime", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void d(MobSessionClickParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobSessionClickParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("session_click", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void e(MobTemplateMenuClickParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobTemplateMenuClickParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("use_template_menu_click", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void f(MobSessionSlideParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobSessionSlideParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("session_slide", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void g(MobTemplateShowParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobTemplateShowParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("template_show", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // o0a.a
    public final void h(MobTemplateMenuElementShowParamsKmp r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        v r2 = a;     // Catch: Throwable -> L9
        r2.getClass();     // Catch: Throwable -> L9
        d0 r5 = r2.d(MobTemplateMenuElementShowParamsKmp.Companion.serializer(), r4);     // Catch: Throwable -> L9
        if ((r5 instanceof d0) == false) goto L6;
        d0 r6 = r5;     // Catch: Throwable -> L9
    L7:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r7) == true) goto L15;
        r0 = r7;
    L15:
        d0 r3 = (d0) r0;
        if (r3 == null) goto L22;
        FlowRuntime.b().d().a("use_template_menu_element_show", r3);
        return;
    L22:
        return;
    L6:
        r6 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
