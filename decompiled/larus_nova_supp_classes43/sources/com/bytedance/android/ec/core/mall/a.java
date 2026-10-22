package com.bytedance.android.ec.core.mall;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/core/mall/a;", "", "", "nativeFeedBundle", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "nativeFeedPageCard", "b", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("native_feed_bundle_config_url")
    private final String nativeFeedBundle;

    @SerializedName("native_feed_page_card_schema")
    private final String nativeFeedPageCard;

    public a() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.nativeFeedBundle, r11.nativeFeedBundle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.nativeFeedPageCard, r11.nativeFeedPageCard) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.nativeFeedBundle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.nativeFeedPageCard;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "MallGylConfig(nativeFeedBundle=" + this.nativeFeedBundle + ", nativeFeedPageCard=" + this.nativeFeedPageCard + ")";
    }

    public final String a() {
        return this.nativeFeedBundle;
    }

    public final String b() {
        return this.nativeFeedPageCard;
    }

    public a(int r1) {
        this.nativeFeedBundle = null;
        this.nativeFeedPageCard = null;
    }
}
