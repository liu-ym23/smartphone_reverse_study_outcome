package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements vr1.e {
    public final /* synthetic */ i40.a a;

    public a(i40.a r1) {
        this.a = r1;
    }

    @Override // vr1.e
    public final e0 a(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "root");
        i40.d r4 = this.a.a(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new e0(r4.a, r4.b);
    }

    @Override // vr1.e
    public final e0 b(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        i40.d r4 = this.a.b(r2, r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return new e0(r4.a, r4.b);
    }

    @Override // vr1.e
    public final e0 c(Context r9, ViewGroup r10, int r11, int r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "root");
        this.a.c(r9, r10, r11, r12, r13, r14);
        return null;
    }
}
