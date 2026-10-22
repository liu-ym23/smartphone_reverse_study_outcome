package com.larus.uaigc.service;

import com.larus.bmhome.resource.access.ResourceCancelReason;
import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ICreationResourceAccessServiceKt {
    public static final boolean d(com.larus.bmhome.resource.access.a0 r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.a) == true) goto L5;
    L7:
        return false;
    L5:
        if (((com.larus.bmhome.resource.access.a0.a) r1).a != ResourceCancelReason.PAGE_DESTROY) goto L7;
        return true;
    }

    public static final boolean e(com.larus.bmhome.resource.access.a0 r2) {
        int r0 = e.a;
        String r1 = null;
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L5;
        com.larus.bmhome.resource.access.a0.c r3 = (com.larus.bmhome.resource.access.a0.c) r2;
    L6:
        if (r3 == null) goto L11;
        com.larus.bmhome.resource.access.r r4 = r3.a;
        if (r4 == null) goto L11;
        r1 = r4.b;
    L11:
        return Intrinsics.areEqual(r1, "review_un_pass");
    L5:
        r3 = null;
        goto L6
    }

    public static final boolean f(ResourceUploadError r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = e.a;
        return Intrinsics.areEqual(r1.getCode(), "review_un_pass");
    }

    public static final ResourceUploadError g(com.larus.bmhome.resource.access.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L6;
        com.larus.bmhome.resource.access.r r3 = ((com.larus.bmhome.resource.access.a0.c) r2).a;
        return new ResourceUploadError(r3.b, r3.c);
    L6:
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L9;
        return new ResourceUploadError("upload_cancelled", ((com.larus.bmhome.resource.access.a0.a) r2).a.name());
    L9:
        if (Intrinsics.areEqual(r2, com.larus.bmhome.resource.access.a0.b.a) == true) goto L20;
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.e) == true) goto L20;
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.f) == true) goto L20;
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.d) == true) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        return new ResourceUploadError("invalid_terminal_state", r2.toString());
    }

    public static final mr9.l h(com.larus.bmhome.resource.access.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L5;
        com.larus.bmhome.resource.access.a0.d r3 = (com.larus.bmhome.resource.access.a0.d) r2;
    L6:
        if (r3 == null) goto L11;
        com.larus.bmhome.resource.access.f0 r4 = r3.a;
        if (r4 != null) goto L10;
        return null;
    L10:
        return com.larus.bmhome.resource.access.s.c(r4);
    L11:
        return null;
    L5:
        r3 = null;
        goto L6
    }

    public static final void c(com.larus.bmhome.resource.access.a0 r1, Function1<? super mr9.l, Unit> r2, Function1<? super ResourceUploadError, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "successCallback");
        Intrinsics.checkNotNullParameter(r3, "failedCallback");
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.d) == false) goto L9;
        mr9.l r4 = h(r1);
        if (r4 == null) goto L7;
        r2.invoke(r4);
        return;
    L7:
        r3.invoke(new ResourceUploadError("empty_upload_result", "upload result is null"));
        return;
    L9:
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.c) == false) goto L12;
        r3.invoke(g(r1));
        return;
    L12:
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.a) == false) goto L17;
        if (d(r1) == true) goto L28;
        r3.invoke(g(r1));
        return;
    L28:
        return;
    L17:
        if (Intrinsics.areEqual(r1, com.larus.bmhome.resource.access.a0.b.a) == false) goto L19;
        return;
    L19:
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.e) == false) goto L21;
        return;
    L21:
        if ((r1 instanceof com.larus.bmhome.resource.access.a0.f) == false) goto L24;
        return;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public static final Object a(com.larus.bmhome.resource.access.b0 r2, Function1<? super com.larus.bmhome.resource.access.a0.e, Unit> r3, Function1<? super com.larus.bmhome.resource.access.a0.f, Unit> r4, Continuation<? super com.larus.bmhome.resource.access.a0> r5) {
        return kotlinx.coroutines.flow.e.t(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(r2.a(), new ICreationResourceAccessServiceKt$awaitTerminalState$4(r3, r4, null)), new ICreationResourceAccessServiceKt$awaitTerminalState$5(null), r5);
    }

    public static /* synthetic */ Object b(com.larus.bmhome.resource.access.b0 r1, Function1 r2, Continuation r3, int r4) {
        if ((r4 & 1) == 0) goto L5;
        Function1 r0 = new l();
    L7:
        if ((r4 & 2) == 0) goto L10;
        r2 = new m();
    L10:
        return a(r1, r0, r2, r3);
    L5:
        r0 = null;
        goto L7
    }
}
