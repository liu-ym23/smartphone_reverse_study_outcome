package com.bytedance.android.live.profit.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AssetUtilsKt {

    public static final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
        public final /* synthetic */ IAssetsManager a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function2 e;

        public final void b(boolean r1) {
        }

        public final void onProgress(int r1) {
        }

        public final void a(long r2) {
            this.c.invoke(new Error("download asset cancelled"));
        }

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "t");
            this.c.invoke(r2);
        }

        public final void c(long r3, String r5) {
            Intrinsics.checkNotNullParameter(r5, "path");
            com.bytedance.android.live.core.resources.e r4 = this.a.G1(this.b);
            if (r4 != null) goto L7;
            this.c.invoke(new UnknownError("asset success callback but still null"));
            return;
        L7:
            if (r4.getResourceType() == this.d) goto L10;
            this.c.invoke(new Error("invalid resource type"));
            return;
        L10:
            this.e.invoke(r5, Boolean.FALSE);
        }

        public a(IAssetsManager r1, long r2, Function1 r4, int r5, Function2 r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final void a(IAssetsManager r9, final long r10, int r12, int r13, final Function2<? super Result<String>, ? super Boolean, Unit> r14) {
        Intrinsics.checkNotNullParameter(r9, "assetManager");
        Intrinsics.checkNotNullParameter(r14, "callback");
        ALogger.i("ProfitAssetUtil", "loading asset: assetId=" + r10);
        Function1<Throwable, Unit> r6 = new AssetUtilsKt$loadEffectAsset$failed$1(r10, r14);
        Function2<String, Boolean, Unit> r8 = new AssetUtilsKt$loadEffectAsset$succeed$1(r10, r14);
        if (r10 > 0) goto L6;
        r6.invoke(new Error("invalid assetId: assetId=" + r10));
        return;
    L6:
        com.bytedance.android.live.core.resources.e r15 = r9.G1(r10);
        if (r15 != null) goto L10;
        r6.invoke(new Error("asset not found: assetId=" + r10));
        return;
    L10:
        String r0 = r9.H0(r10);
        if (r0 == null) goto L14;
        r8.invoke(r0, Boolean.TRUE);
        return;
    L14:
        r9.Ne(r15, new a(r9, r10, r6, r12, r8), r13);
    }
}
