package com.bytedance.android.livesdk.gift.format;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.o;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements SingleOnSubscribe {
    public final /* synthetic */ GiftPlayerView a;
    public final /* synthetic */ long b;

    public static final class a extends o {
        public final /* synthetic */ b a;
        public final /* synthetic */ SingleEmitter b;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "t");
            int r2 = GiftPlayerView.k;
            this.a.a.e("download assets failed, " + r4);
            this.b.onError(r4);
        }

        public a(b r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.o, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "path");
            super.c(r2, r4);
            GiftPlayerView r3 = this.a.a;
            int r5 = GiftPlayerView.k;
            r3.e("download assets success");
            this.b.onSuccess(r4);
        }
    }

    public b(GiftPlayerView r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        com.bytedance.android.live.core.resources.e r0 = GiftPlayerView.b(this.a).G1(this.b);
        GiftPlayerView.b(this.a).Ne(r0, new a(this, r4), IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    }
}
