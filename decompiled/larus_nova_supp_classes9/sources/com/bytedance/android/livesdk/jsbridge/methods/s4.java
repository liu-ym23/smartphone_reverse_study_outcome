package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Single;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "live.updateCacheData", owner = "chenweizhuo@bytedance.com")
public final class s4 extends u<t4, UpdateCacheDataResultModel> {
    public s4() {
    }

    public final void invoke(Object r13, CallContext r14) {
        t4 r15 = (t4) r13;
        Intrinsics.checkNotNullParameter(r15, "params");
        Intrinsics.checkNotNullParameter(r14, "context");
        String r16 = r15.b();
        String r0 = r15.a();
        if (r16 == null) goto L15;
        if (r0 == null) goto L15;
        Integer r17 = r15.c();
        int r1 = com.bytedance.android.live.schema.helper.f.a;
        if (r17 == null) goto L9;
        long r3 = r17.intValue();
    L10:
        Intrinsics.checkNotNullParameter(r16, "key");
        Intrinsics.checkNotNullParameter(r0, "data");
        Keva r18 = Keva.getRepo("lynx_common_cache");
        Keva r6 = Keva.getRepo("lynx_cache_valid_time");
        r18.storeString(r16, r0);
        if (r3 != 0) goto L13;
        r3 = 86400;
        long r7 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L14:
        r6.storeLong(r16, r3 + r7);
        Keva r19 = Keva.getRepo("lynx_cache_valid_time");
        Ref.ObjectRef r110 = new Ref.ObjectRef();
        r110.element = Disposables.disposed();
        r110.element = Single.just(Long.valueOf(r19.getLong("last_clean_timestamp", 0))).flatMapCompletable(new com.bytedance.android.live.schema.helper.b(r19)).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnComplete(new com.bytedance.android.live.schema.helper.c(r110)).subscribe(com.bytedance.android.live.schema.helper.d.a, com.bytedance.android.live.schema.helper.e.a);
        finishWithSuccess();
        return;
    L13:
        r7 = System.currentTimeMillis() / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        goto L14
    L9:
        r3 = 0;
    L15:
        finishWithFailure();
    }
}
