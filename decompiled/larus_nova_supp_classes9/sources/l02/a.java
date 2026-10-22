package l02;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
    public final /* synthetic */ b a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r1) {
    }

    public a(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        this.a.a.remove(Long.valueOf(r2));
    }
}
