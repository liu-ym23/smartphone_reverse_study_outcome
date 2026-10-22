package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h<T> implements SingleOnSubscribe {
    public final /* synthetic */ AssetsService a;
    public final /* synthetic */ List b;

    public static final class a implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b {
        public final /* synthetic */ h a;
        public final /* synthetic */ SingleEmitter b;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
        public final void a(List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a> r3) {
            Intrinsics.checkNotNullParameter(r3, "assetsResult");
            jy0.b.a("AssetsService", "cancel download asset");
            this.b.onError(new Throwable("download asset canceled"));
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
        public final void onFailed(Throwable r3) {
            StringBuilder r0 = new StringBuilder("download asset failed: ");
            if (r3 == null) goto L5;
            String r1 = r3.getMessage();
        L6:
            r0.append(r1);
            jy0.b.a("AssetsService", r0.toString());
            if (r3 == null) goto L10;
            this.b.onError(r3);
            return;
        L10:
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.b
        public final void onResult(List<com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a> r7) {
            Intrinsics.checkNotNullParameter(r7, "assetsResult");
            SingleEmitter r0 = this.b;
            this.a.a.getClass();
            Intrinsics.checkNotNullParameter(r7, "$this$toDownloadAssetsResponse");
            ArrayList r1 = new ArrayList();
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a r2 = (com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a) r8.next();
            lc6.q r3 = new lc6.q();
            r3.d(r2.a);
            r3.c(r2.b);
            r3.b(r2.c);
            r3.a(r2.d);
            r1.add(r3);
            goto L4
        L6:
            lc6.p r9 = new lc6.p();
            r9.setResult(r1);
            r0.onSuccess(r9);
        }

        public a(h r1, SingleEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public h(AssetsService r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(SingleEmitter<lc6.p> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        com.bytedance.android.livesdk.gift.platform.business.effect.assets.k.a(this.a, this.b, new a(this, r5), 3, AssetDownloadPriority.NORMAL);
    }
}
