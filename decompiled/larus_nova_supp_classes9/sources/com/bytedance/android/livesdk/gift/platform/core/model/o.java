package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/model/o;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftId", "J", "b", "()J", BuildConfig.FLAVOR, "price", "I", "d", "()I", "index", "c", "forceInsert", "a", "setForceInsert", "(I)V", BuildConfig.FLAVOR, "sortExtra", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "pageType", "getPageType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {
    public final int a;
    public final long b;

    @SerializedName("force_insert")
    private int forceInsert;

    @SerializedName("id")
    private final long giftId;

    @SerializedName("index")
    private final int index;

    @SerializedName("page_type")
    private final int pageType;

    @SerializedName("price")
    private final int price;

    @SerializedName("sort_extra")
    private String sortExtra;

    public final int a() {
        return this.forceInsert;
    }

    public final long b() {
        return this.giftId;
    }

    public final int c() {
        return this.index;
    }

    public final int d() {
        return this.price;
    }

    public final String e() {
        return this.sortExtra;
    }

    public final void f(String r1) {
        this.sortExtra = r1;
    }

    public final void g(int r1) {
        this.forceInsert = r1;
    }

    public o(h1 r4, int r5, long r6, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r4, "gift");
        long r0 = r4.getId();
        int r2 = r4.getDiamondCount();
        String r7 = r4.getSortExtra();
        this.giftId = r0;
        this.price = r2;
        this.index = r5;
        this.forceInsert = 0;
        this.sortExtra = r7;
        this.pageType = r8;
        this.a = r9;
        this.b = r6;
    }
}
