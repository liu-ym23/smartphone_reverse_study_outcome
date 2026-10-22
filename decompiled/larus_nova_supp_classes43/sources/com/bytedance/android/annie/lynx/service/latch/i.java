package com.bytedance.android.annie.lynx.service.latch;

import com.bytedance.ies.web.jsbridge2.d0;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements a.InterfaceC0070a, Disposable {
    public final /* synthetic */ ex.a.b a;
    public final /* synthetic */ ex.a.b b;

    public final void dispose() {
        this.a.dispose();
    }

    public final boolean isDisposed() {
        return this.a.isDisposed();
    }

    @Override // com.bytedance.android.annie.lynx.service.latch.a.InterfaceC0070a
    public final List<com.bytedance.android.latch.a.c> a() {
        return this.b.a();
    }

    public i(ex.a.b r1) {
        this.b = r1;
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService.e
    public final void f(d0 r10) {
        Intrinsics.checkNotNullParameter(r10, "jsBridge2");
        this.b.f(r10);
    }
}
