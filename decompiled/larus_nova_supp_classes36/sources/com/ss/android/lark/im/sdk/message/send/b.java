package com.ss.android.lark.im.sdk.message.send;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements jkb.d<k> {
    public final InterfaceC0084b a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.message.send.b$b, reason: collision with other inner class name */
    public interface InterfaceC0084b {
        long a();
    }

    static {
    }

    @Override // jkb.d
    public final String getName() {
        return "CheckFileSizeStep";
    }

    public b() {
        com.ss.android.lark.im.sdk.message.send.a r0 = com.ss.android.lark.im.sdk.message.send.a.a;
        Intrinsics.checkNotNullParameter(r0, "maxSizeProvider");
        this.a = r0;
    }

    @Override // jkb.d
    public final void a(jkb.b r10, jkb.c r11) {
        k r12 = (k) r10;
        Intrinsics.checkNotNullParameter(r12, "pipelineContext");
        Intrinsics.checkNotNullParameter(r11, "pipelineControl");
        com.ss.android.lark.biz.im.api.l r0 = r12.a;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.biz.im.api.FileMessageParams");
        com.ss.android.lark.biz.im.api.l r1 = r0;
        n6b.a r13 = r12.b;
        long r2 = this.a.a();
        boolean r3 = r13 instanceof n6b.a;
        if (r3 == false) goto L5;
        r13.b(r1.E);
    L5:
        long r4 = r1.E;
        if (r4 > r2) goto L8;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L14;
        if (r3 == false) goto L13;
        r13.n(r4, r2);
    L13:
        com.ss.android.lark.im.sdk.a.a("CheckFileSizeStep", "!fileSizeCheckPass");
        r11.b(new jkb.e("File size check failed, limit is " + r2 + ", but actual size is " + r1.E, 500600, true));
        return;
    L14:
        com.ss.android.lark.im.sdk.a.b("CheckFileSizeStep", "File size check pass");
        r13.i();
        r11.a();
        return;
    L8:
        r7 = false;
        goto L10
    }
}
