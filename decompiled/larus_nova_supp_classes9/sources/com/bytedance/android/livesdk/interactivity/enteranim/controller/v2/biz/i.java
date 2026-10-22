package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i<T> implements SingleOnSubscribe {
    public final /* synthetic */ j a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ boolean c;

    public static final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
        public final /* synthetic */ i a;
        public final /* synthetic */ SingleEmitter b;
        public final /* synthetic */ long c;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r4) {
            this.b.onError(new Throwable("download cancelled: id=" + this.a.a.b));
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
            this.b.onError(r2);
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r10, String r13) {
            Intrinsics.checkNotNullParameter(r13, "path");
            this.b.onSuccess(new RevenueUtils.a(r13, this.a.b, this.c, System.currentTimeMillis() - this.c, this.a.c, true));
        }

        public a(i r1, SingleEmitter r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public i(j r1, com.bytedance.android.live.core.resources.e r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(SingleEmitter<RevenueUtils.a> r11) {
        Intrinsics.checkNotNullParameter(r11, "emitter");
        ALogger.i("RevenueUtils", "downloading asset id=" + this.a.b + "...");
        long r0 = System.currentTimeMillis();
        RevenueUtils r2 = this.a.a;
        RevenueUtils.b r3 = RevenueUtils.i;
        IAssetsManager r4 = r2.c();
        j r5 = this.a;
        long r6 = r5.b;
        a r7 = new a(this, r11, r0);
        if (r5.c == false) goto L5;
        AssetDownloadPriority r13 = AssetDownloadPriority.LOCAL;
    L6:
        r4.r0(r6, r7, 4, r13);
        return;
    L5:
        r13 = AssetDownloadPriority.OTHER_SEND;
        goto L6
    }
}
