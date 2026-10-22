package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.scope.o;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements dy0.c, o {
    public final AssetsService a;
    public final com.bytedance.android.livesdk.revenue.service.effect.c b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
        public final /* synthetic */ d a;
        public final /* synthetic */ Function0 b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r1) {
            this.b.invoke();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
            this.b.invoke();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r7, String r9) {
            Intrinsics.checkNotNullParameter(r9, "path");
            this.b.invoke();
            d r8 = this.a;
            long r4 = this.c;
            long r2 = this.d;
            yp2.c r10 = r8.b.Hk(new e(r8, r2, r4));
            r8.b.nm(r10, "_Interact_preview", null);
        }

        public b(d r1, Function0 r2, long r3, long r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r5;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final void a() {
        this.b.D8();
    }

    public d(AssetsService r2, com.bytedance.android.livesdk.revenue.service.effect.c r3) {
        Intrinsics.checkNotNullParameter(r2, "assertService");
        Intrinsics.checkNotNullParameter(r3, "effectService");
        this.a = r2;
        this.b = r3;
    }

    public final void f(long r9, long r11, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r13, "endCallback");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        k.n(IGiftService.class).initGiftResourceManager(s1.getContext());     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        b r1 = new b(this, r13, r9, r11);
        if (this.a.G1(r9) != null) goto L10;
        r13.invoke();
        ALogger.e("InteractGiftPreviewService", "assertModel is null");
        return;
    L10:
        this.a.j4(r9, r1, IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_INTERACT_GIFT);
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
