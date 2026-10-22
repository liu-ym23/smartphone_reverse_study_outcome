package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/q0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "gifts", "Ljava/util/List;", "b", "()Ljava/util/List;", "setGifts", "(Ljava/util/List;)V", "pool", "c", "setPool", BuildConfig.FLAVOR, "topGiftIds", "d", "setTopGiftIds", "dislikeGiftIds", "a", "setDislikeGiftIds", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q0 implements vh7.h {

    @SerializedName("dislike_gift_ids")
    protected List<Long> dislikeGiftIds;

    @SerializedName("gifts")
    protected List<? extends h1> gifts;

    @SerializedName("pool")
    protected List<? extends h1> pool;

    @SerializedName("top_gift_ids")
    protected List<Long> topGiftIds;

    public static final class a {
    }

    static {
    }

    public q0() {
    }

    public final List<Long> a() {
        return this.dislikeGiftIds;
    }

    public final List<h1> b() {
        return this.gifts;
    }

    public final List<h1> c() {
        return this.pool;
    }

    public final List<Long> d() {
        return this.topGiftIds;
    }

    public q0(am3.g r6) {
        this.gifts = new ArrayList();
        this.pool = new ArrayList();
        this.topGiftIds = new ArrayList();
        this.dislikeGiftIds = new ArrayList();
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L13;
        List<? extends h1> r3 = this.dislikeGiftIds;
    L16:
        Object r4 = Long.valueOf(r6.j());
    L20:
        r3.add(r4);
        goto L3
    L13:
        am3.h.e(r6);
        goto L3
    L15:
        r3 = this.topGiftIds;
        goto L16
    L17:
        r3 = this.pool;
    L19:
        r4 = vh7.f.a(r6, h1.class);
        goto L20
    L18:
        r3 = this.gifts;
        goto L19
    L21:
        r6.d(r0);
    }
}
