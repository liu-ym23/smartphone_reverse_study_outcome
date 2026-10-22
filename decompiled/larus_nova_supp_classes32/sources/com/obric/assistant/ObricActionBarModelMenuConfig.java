package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricActionBarModelMenuConfig;", NameKeys.UnloadStrategy_No_Strategy, "enable", NameKeys.UnloadStrategy_No_Strategy, "blockedItemIds", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "defaultStatus", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBlockedItemIds", "()Ljava/util/List;", "getDefaultStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;)Lcom/obric/assistant/ObricActionBarModelMenuConfig;", "equals", "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarModelMenuConfig {

    @SerializedName("blocked_item_ids")
    private final List<Integer> blockedItemIds;

    @SerializedName("default_status")
    private final Integer defaultStatus;

    @SerializedName("enable")
    private final Boolean enable;

    public ObricActionBarModelMenuConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricActionBarModelMenuConfig copy$default(ObricActionBarModelMenuConfig r0, Boolean r1, List r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.blockedItemIds;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.defaultStatus;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final List<Integer> component2() {
        return this.blockedItemIds;
    }

    public final Integer component3() {
        return this.defaultStatus;
    }

    public final ObricActionBarModelMenuConfig copy(Boolean r2, List<Integer> r3, Integer r4) {
        return new ObricActionBarModelMenuConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricActionBarModelMenuConfig) == true) goto L8;
        return false;
    L8:
        ObricActionBarModelMenuConfig r6 = (ObricActionBarModelMenuConfig) r5;
        if (Intrinsics.areEqual(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blockedItemIds, r6.blockedItemIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultStatus, r6.defaultStatus) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<Integer> r4 = this.blockedItemIds;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.defaultStatus;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricActionBarModelMenuConfig(enable=" + this.enable + ", blockedItemIds=" + this.blockedItemIds + ", defaultStatus=" + this.defaultStatus + ')';
    }

    public final List<Integer> getBlockedItemIds() {
        return this.blockedItemIds;
    }

    public final Integer getDefaultStatus() {
        return this.defaultStatus;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public ObricActionBarModelMenuConfig(Boolean r1, List<Integer> r2, Integer r3) {
        this.enable = r1;
        this.blockedItemIds = r2;
        this.defaultStatus = r3;
    }

    public /* synthetic */ ObricActionBarModelMenuConfig(Boolean r2, List r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
