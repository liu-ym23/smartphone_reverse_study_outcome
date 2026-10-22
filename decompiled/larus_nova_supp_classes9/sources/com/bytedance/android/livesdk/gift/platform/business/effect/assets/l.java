package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l<T> implements ObservableOnSubscribe {
    public final /* synthetic */ j a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ AssetDownloadPriority d;

    public static final class a implements f {
        public boolean a;
        public final /* synthetic */ l b;
        public final /* synthetic */ ObservableEmitter c;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r11) {
            ObservableEmitter r0 = this.c;
            com.bytedance.android.live.core.resources.e r1 = this.b.a.G1(r11);
            if (r1 == null) goto L5;
            int r6 = r1.getResourceType();
        L6:
            r0.onNext(new k.a(r11, null, -1, r6, false, 18));
            this.c.onComplete();
            return;
        L5:
            r6 = 0;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
            this.c.onError(r2);
        }

        public a(l r1, ObservableEmitter r2) {
            this.b = r1;
            this.c = r2;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r11, String r13) {
            Intrinsics.checkNotNullParameter(r13, "path");
            ObservableEmitter r0 = this.c;
            com.bytedance.android.live.core.resources.e r1 = this.b.a.G1(r11);
            if (r1 == null) goto L5;
            int r6 = r1.getResourceType();
        L6:
            r0.onNext(new k.a(r11, r13, 0, r6, this.a, 4));
            this.c.onComplete();
            return;
        L5:
            r6 = 0;
            goto L6
        }
    }

    public l(IAssetsManager r1, long r2, int r4, AssetDownloadPriority r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void subscribe(ObservableEmitter<k.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        this.a.r0(this.b, new a(this, r8), this.c, this.d);
    }
}
