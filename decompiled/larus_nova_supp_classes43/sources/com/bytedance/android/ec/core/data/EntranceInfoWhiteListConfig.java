package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ8\u0010\u0012\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR2\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoWhiteListConfig;", "Ljava/io/Serializable;", "whiteList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "enable", "", "(Ljava/util/HashSet;Ljava/lang/Integer;)V", "getEnable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWhiteList", "()Ljava/util/HashSet;", "setWhiteList", "(Ljava/util/HashSet;)V", "component1", "component2", "copy", "(Ljava/util/HashSet;Ljava/lang/Integer;)Lcom/bytedance/android/ec/core/data/EntranceInfoWhiteListConfig;", "equals", "", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoWhiteListConfig implements Serializable {

    @SerializedName("enable")
    private final Integer enable;

    @SerializedName("white_list")
    private HashSet<String> whiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public EntranceInfoWhiteListConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntranceInfoWhiteListConfig copy$default(EntranceInfoWhiteListConfig r0, HashSet r1, Integer r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.whiteList;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.enable;
    L9:
        return r0.copy(r1, r10);
    }

    public final HashSet<String> component1() {
        return this.whiteList;
    }

    public final Integer component2() {
        return this.enable;
    }

    public final EntranceInfoWhiteListConfig copy(HashSet<String> r10, Integer r11) {
        return new EntranceInfoWhiteListConfig(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof EntranceInfoWhiteListConfig) == false) goto L10;
        EntranceInfoWhiteListConfig r11 = (EntranceInfoWhiteListConfig) r10;
        if (Intrinsics.areEqual(this.whiteList, r11.whiteList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enable, r11.enable) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        HashSet<String> r0 = this.whiteList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Integer r12 = this.enable;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "EntranceInfoWhiteListConfig(whiteList=" + this.whiteList + ", enable=" + this.enable + ")";
    }

    public final Integer getEnable() {
        return this.enable;
    }

    public final HashSet<String> getWhiteList() {
        return this.whiteList;
    }

    public final void setWhiteList(HashSet<String> r1) {
        this.whiteList = r1;
    }

    public EntranceInfoWhiteListConfig(HashSet<String> r1, Integer r10) {
        this.whiteList = r1;
        this.enable = r10;
    }

    public /* synthetic */ EntranceInfoWhiteListConfig(HashSet r1, Integer r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = 0;
    L8:
        this(r1, r10);
    }
}
