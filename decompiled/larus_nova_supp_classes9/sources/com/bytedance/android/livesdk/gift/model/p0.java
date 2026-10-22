package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/p0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "gifts", "Ljava/util/List;", "getGifts", "()Ljava/util/List;", "setGifts", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "topGiftIds", "getTopGiftIds", "setTopGiftIds", "dislikeGiftIds", "getDislikeGiftIds", "setDislikeGiftIds", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p0 implements vh7.h {

    @SerializedName("dislike_gift_ids")
    protected List<Long> dislikeGiftIds;

    @SerializedName("gifts")
    protected List<? extends h1> gifts;

    @SerializedName("top_gift_ids")
    protected List<Long> topGiftIds;

    public p0() {
    }

    public p0(am3.g r6) {
        this.gifts = new ArrayList();
        this.topGiftIds = new ArrayList();
        this.dislikeGiftIds = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L17;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 != 3) goto L11;
        List<? extends h1> r3 = this.dislikeGiftIds;
    L14:
        Object r4 = Long.valueOf(r6.j());
    L16:
        r3.add(r4);
        goto L3
    L11:
        am3.h.e(r6);
        goto L3
    L13:
        r3 = this.topGiftIds;
        goto L14
    L15:
        r3 = this.gifts;
        r4 = vh7.f.a(r6, h1.class);
        goto L16
    L17:
        r6.d(r0);
    }
}
