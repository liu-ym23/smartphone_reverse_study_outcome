package com.bytedance.android.livesdk.interactivity;

import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/GiftImageGetter;", "Lcom/bytedance/android/livesdk/interactivity/service/textrender/inject/IGiftImageGetter;", BuildConfig.FLAVOR, "giftId", "Lpy/k;", "getGiftImage", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class GiftImageGetter implements IGiftImageGetter {
    public GiftImageGetter() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.inject.IGiftImageGetter
    public py.k getGiftImage(long r2) {
        h2 r3 = jc1.k.n(IGiftServiceExternal.class).findLiteGiftById(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.getImage();
    }
}
