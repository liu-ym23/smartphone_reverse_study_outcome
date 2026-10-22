package com.bytedance.android.annie.service.latch;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.web.jsbridge2.d0;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements ILatchService {

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.latch.a$a, reason: collision with other inner class name */
    public static final class C0082a implements ILatchService.e {
        public C0082a() {
        }

        public final void dispose() {
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.e
        public final void f(d0 r10) {
            Intrinsics.checkNotNullParameter(r10, "jsBridge2");
        }

        public final boolean isDisposed() {
            return true;
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean O0(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void Q0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String R0(View r1) {
        return null;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void S0(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean c(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void d(String r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final int d1(Context r1, String r10, Uri r11, ILatchService.d r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "latchProcessOptions");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String i(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        return null;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void initPrefetch() {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void s(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final Pair<ILatchService.PrefetchStrategy, String> k(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return new Pair(ILatchService.PrefetchStrategy.Nothing, "annie is not ready.");
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.d e(long r1, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "display");
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        return new ILatchService.d();
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.e u0(Context r1, String r10, Uri r11, long r12, ILatchService.d r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r13, "latchProcessOptions");
        return new C0082a();
    }
}
