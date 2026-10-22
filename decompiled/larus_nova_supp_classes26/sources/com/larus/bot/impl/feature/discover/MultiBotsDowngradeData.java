package com.larus.bot.impl.feature.discover;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/feature/discover/MultiBotsDowngradeData;", "", "botSearchDowngrade", "", "botCreateDowngrade", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBotSearchDowngrade", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBotCreateDowngrade", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/bot/impl/feature/discover/MultiBotsDowngradeData;", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiBotsDowngradeData {

    @SerializedName("bot_create_dg")
    private final Integer botCreateDowngrade;

    @SerializedName("bot_search_dg")
    private final Integer botSearchDowngrade;

    public MultiBotsDowngradeData() {
        Integer r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MultiBotsDowngradeData copy$default(MultiBotsDowngradeData r0, Integer r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.botSearchDowngrade;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.botCreateDowngrade;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.botSearchDowngrade;
    }

    public final Integer component2() {
        return this.botCreateDowngrade;
    }

    public final MultiBotsDowngradeData copy(Integer r2, Integer r3) {
        return new MultiBotsDowngradeData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MultiBotsDowngradeData) == true) goto L8;
        return false;
    L8:
        MultiBotsDowngradeData r6 = (MultiBotsDowngradeData) r5;
        if (Intrinsics.areEqual(this.botSearchDowngrade, r6.botSearchDowngrade) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botCreateDowngrade, r6.botCreateDowngrade) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.botSearchDowngrade;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.botCreateDowngrade;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MultiBotsDowngradeData(botSearchDowngrade=" + this.botSearchDowngrade + ", botCreateDowngrade=" + this.botCreateDowngrade + ')';
    }

    public final Integer getBotCreateDowngrade() {
        return this.botCreateDowngrade;
    }

    public final Integer getBotSearchDowngrade() {
        return this.botSearchDowngrade;
    }

    public MultiBotsDowngradeData(Integer r1, Integer r2) {
        this.botSearchDowngrade = r1;
        this.botCreateDowngrade = r2;
    }

    public /* synthetic */ MultiBotsDowngradeData(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
