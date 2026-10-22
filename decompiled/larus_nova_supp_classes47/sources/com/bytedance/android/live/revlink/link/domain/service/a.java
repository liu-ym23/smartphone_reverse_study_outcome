package com.bytedance.android.live.revlink.link.domain.service;

import com.bytedance.android.live.revlink.impl.multianchor.ui.i;
import com.bytedance.android.live.revlink.impl.multianchor.ui.q;
import com.bytedance.android.live.revlink.impl.multianchor.ui.r;
import com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements i {
    public final i a;

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void a() {
        this.a.a();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void b(String r2) {
        this.a.b(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void c(boolean r2, boolean r3) {
        this.a.c(r2, r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final Disposable d(q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        return this.a.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "linkMicId");
        return this.a.e(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void f(String r8, String r9, boolean r10, r r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "source");
        this.a.f(r8, r9, r10, r12, r13);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void g(q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.g(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean h() {
        return this.a.h();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void i(boolean r2, r.c r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        this.a.i(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean j(String r2, String r3) {
        return this.a.j(r2, r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void k(q r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.k(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void l(String r7, boolean r8, boolean r9, boolean r10, boolean r12) {
        this.a.l(r7, r8, r9, r10, r12);
    }

    public a(MultiMuteManager r2) {
        Intrinsics.checkNotNullParameter(r2, "muteManager");
        this.a = r2;
    }
}
