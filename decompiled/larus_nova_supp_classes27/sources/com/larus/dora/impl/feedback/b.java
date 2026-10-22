package com.larus.dora.impl.feedback;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.api.b4;
import com.larus.platform.model.upload.ResourceUploadError;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b implements b4.a {
    public int a;
    public final /* synthetic */ g b;
    public final /* synthetic */ kotlinx.coroutines.i<Unit> c;

    public final void a(ResourceUploadError r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        IOException r0 = new IOException("Image upload failed: " + r4);
        pk4.j.c("DoraGFeedbackViewModel", "Image upload failed: " + r4, r0);
        String r5 = this.b.i;
        if (r5 == null) goto L6;
        new PolarisFileWrapper(r5).delete();
    L6:
        if (this.c.isActive() == false) goto L9;
        kotlinx.coroutines.i<Unit> r6 = this.c;
        Result.Companion r1 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(ResultKt.createFailure(r0)));
        return;
    }

    public final void b(mr9.k r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        Long r4 = r3.a;
        if (r4 == null) goto L5;
        int r5 = (int) r4.longValue();
    L7:
        if ((r5 - this.a) <= 5) goto L12;
        this.a = r5;
        i r0 = this.b.c.a.getImageSubmitCallback();
        if (r0 == null) goto L13;
        r0.b(this.b.b, r5);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r5 = 0;
        goto L7
    }

    public final void c(mr9.l r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        pk4.j.d("DoraGFeedbackViewModel", r3.a);
        g r0 = this.b;
        String r4 = r3.a;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.g = r4;
        String r5 = r0.i;
        if (r5 == null) goto L9;
        new PolarisFileWrapper(r5).delete();
    L9:
        if (this.c.isActive() == false) goto L12;
        kotlinx.coroutines.i<Unit> r6 = this.c;
        Result.Companion r1 = Result.Companion;
        r6.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return;
    }

    public b(g r1, kotlinx.coroutines.j r2) {
        this.b = r1;
        this.c = r2;
    }
}
