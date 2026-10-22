package com.bytedance.android.annie.service.business.latch;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.lynx.tasm.LynxView;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements IAnnieBusinessLatchService {

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.business.latch.a$a, reason: collision with other inner class name */
    public static final class C0080a implements IAnnieBusinessLatchService.b {
        public C0080a() {
        }

        @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
        public final void X0(IHybridComponent r1) {
        }

        public final void dispose() {
        }

        public final boolean isDisposed() {
            return true;
        }

        @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
        public final void Y0(LynxView r10) {
            Intrinsics.checkNotNullParameter(r10, "lynxView");
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void P0(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void d(String r1, boolean r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final String i(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        return null;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final int w1(Context r1, String r10, Uri r11, IAnnieBusinessLatchService.a r12) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r12, "latchProcessOptions");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final Pair<IAnnieBusinessLatchService.PrefetchStrategy, String> k(Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        return new Pair(IAnnieBusinessLatchService.PrefetchStrategy.Nothing, "annie is not ready.");
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.a e(long r1, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "display");
        Intrinsics.checkNotNullParameter(r11, "errMsg");
        return new IAnnieBusinessLatchService.a();
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.b C0(Context r1, String r10, String r11, Uri r12, long r13, IAnnieBusinessLatchService.a r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r10, "originUrl");
        Intrinsics.checkNotNullParameter(r11, "uuid");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r14, "latchProcessOptions");
        return new C0080a();
    }
}
