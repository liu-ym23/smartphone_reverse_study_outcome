package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d3 implements com.larus.platform.api.p3 {
    public static final d3 a = null;
    public static final Lazy b = null;

    public d3() {
    }

    static {
        a = new d3();
        b = LazyKt.lazy(new c3());
    }

    public static com.larus.platform.api.p3 a() {
        return (com.larus.platform.api.p3) b.getValue();
    }

    @Override // com.larus.platform.api.p3
    public final void d() {
        com.larus.platform.api.p3 r0 = a();
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.larus.platform.api.p3
    public final boolean e() {
        com.larus.platform.api.p3 r0 = a();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.p3
    public final void b(tc9.e r2) {
        com.larus.platform.api.p3 r0 = a();
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    @Override // com.larus.platform.api.p3
    public final void f(Fragment r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "resourceId");
        com.larus.platform.api.p3 r0 = a();
        if (r0 == null) goto L6;
        r0.f(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.p3
    public final void h(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "messageId");
        com.larus.platform.api.p3 r0 = a();
        if (r0 == null) goto L6;
        r0.h(r2, r3, r4);
        return;
    }

    @Override // com.larus.platform.api.p3
    public final void g(Context r8, String r9, ArtifactBlock r10, Message r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r10, "artifactBlock");
        Intrinsics.checkNotNullParameter(r11, "message");
        com.larus.platform.api.p3 r1 = a();
        if (r1 == null) goto L6;
        r1.g(r8, r9, r10, r11, r12);
        return;
    }
}
