package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/ObricActionBarItemsConfig;", NameKeys.UnloadStrategy_No_Strategy, "isActionBarFilterEnable", NameKeys.UnloadStrategy_No_Strategy, "obricActionBarWhiteList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/assistant/ObricActionBarItem;", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObricActionBarWhiteList", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/assistant/ObricActionBarItemsConfig;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricActionBarItemsConfig {

    @SerializedName("is_action_bar_filter_enable")
    private final Boolean isActionBarFilterEnable;

    @SerializedName("obric_action_bar_white_list")
    private final List<q0> obricActionBarWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricActionBarItemsConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricActionBarItemsConfig copy$default(ObricActionBarItemsConfig r0, Boolean r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isActionBarFilterEnable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.obricActionBarWhiteList;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.isActionBarFilterEnable;
    }

    public final List<q0> component2() {
        return this.obricActionBarWhiteList;
    }

    public final ObricActionBarItemsConfig copy(Boolean r2, List<q0> r3) {
        return new ObricActionBarItemsConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricActionBarItemsConfig) == true) goto L8;
        return false;
    L8:
        ObricActionBarItemsConfig r6 = (ObricActionBarItemsConfig) r5;
        if (Intrinsics.areEqual(this.isActionBarFilterEnable, r6.isActionBarFilterEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricActionBarWhiteList, r6.obricActionBarWhiteList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isActionBarFilterEnable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<q0> r4 = this.obricActionBarWhiteList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricActionBarItemsConfig(isActionBarFilterEnable=" + this.isActionBarFilterEnable + ", obricActionBarWhiteList=" + this.obricActionBarWhiteList + ')';
    }

    public final List<q0> getObricActionBarWhiteList() {
        return this.obricActionBarWhiteList;
    }

    public final Boolean isActionBarFilterEnable() {
        return this.isActionBarFilterEnable;
    }

    public ObricActionBarItemsConfig(Boolean r1, List<q0> r2) {
        this.isActionBarFilterEnable = r1;
        this.obricActionBarWhiteList = r2;
    }

    public /* synthetic */ ObricActionBarItemsConfig(Boolean r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
