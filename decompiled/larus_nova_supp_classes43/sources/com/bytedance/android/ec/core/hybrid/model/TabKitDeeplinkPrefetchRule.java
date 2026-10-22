package com.bytedance.android.ec.core.hybrid.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/model/TabKitDeeplinkPrefetchRule;", "Ljava/io/Serializable;", "strategy", "", "bizTag", "", "prefetchChannelTag", "(ILjava/lang/String;Ljava/lang/String;)V", "getBizTag", "()Ljava/lang/String;", "getPrefetchChannelTag", "getStrategy", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitDeeplinkPrefetchRule implements Serializable {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("prefetch_channel_tag")
    private final String prefetchChannelTag;

    @SerializedName("strategy")
    private final int strategy;

    public TabKitDeeplinkPrefetchRule() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ TabKitDeeplinkPrefetchRule copy$default(TabKitDeeplinkPrefetchRule r0, int r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.strategy;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.bizTag;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.prefetchChannelTag;
    L12:
        return r0.copy(r1, r10, r11);
    }

    public final int component1() {
        return this.strategy;
    }

    public final String component2() {
        return this.bizTag;
    }

    public final String component3() {
        return this.prefetchChannelTag;
    }

    public final TabKitDeeplinkPrefetchRule copy(int r10, String r11, String r12) {
        return new TabKitDeeplinkPrefetchRule(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof TabKitDeeplinkPrefetchRule) == false) goto L12;
        TabKitDeeplinkPrefetchRule r11 = (TabKitDeeplinkPrefetchRule) r10;
        if (this.strategy == r11.strategy) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTag, r11.bizTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.prefetchChannelTag, r11.prefetchChannelTag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.strategy * 31;
        String r1 = this.bizTag;
        int r10 = 0;
        if (r1 == null) goto L5;
        int r11 = r1.hashCode();
    L6:
        int r12 = (r0 + r11) * 31;
        String r13 = this.prefetchChannelTag;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        return "TabKitDeeplinkPrefetchRule(strategy=" + this.strategy + ", bizTag=" + this.bizTag + ", prefetchChannelTag=" + this.prefetchChannelTag + ")";
    }

    public final String getBizTag() {
        return this.bizTag;
    }

    public final String getPrefetchChannelTag() {
        return this.prefetchChannelTag;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public TabKitDeeplinkPrefetchRule(int r1, String r10, String r11) {
        this.strategy = r1;
        this.bizTag = r10;
        this.prefetchChannelTag = r11;
    }

    public /* synthetic */ TabKitDeeplinkPrefetchRule(int r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
