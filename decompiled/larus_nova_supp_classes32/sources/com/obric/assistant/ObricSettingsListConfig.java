package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/ObricSettingsListConfig;", NameKeys.UnloadStrategy_No_Strategy, "ObricSettingsWhiteList", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "ObricSettingsBlackList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getObricSettingsWhiteList", "()Ljava/util/List;", "getObricSettingsBlackList", "component1", "component2", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSettingsListConfig {

    @SerializedName("obric_settings_black_list")
    private final List<String> ObricSettingsBlackList;

    @SerializedName("obric_settings_white_list")
    private final List<String> ObricSettingsWhiteList;

    public ObricSettingsListConfig() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricSettingsListConfig copy$default(ObricSettingsListConfig r0, List r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.ObricSettingsWhiteList;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.ObricSettingsBlackList;
    L9:
        return r0.copy(r1, r2);
    }

    public final List<String> component1() {
        return this.ObricSettingsWhiteList;
    }

    public final List<String> component2() {
        return this.ObricSettingsBlackList;
    }

    public final ObricSettingsListConfig copy(List<String> r2, List<String> r3) {
        return new ObricSettingsListConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricSettingsListConfig) == true) goto L8;
        return false;
    L8:
        ObricSettingsListConfig r6 = (ObricSettingsListConfig) r5;
        if (Intrinsics.areEqual(this.ObricSettingsWhiteList, r6.ObricSettingsWhiteList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ObricSettingsBlackList, r6.ObricSettingsBlackList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.ObricSettingsWhiteList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.ObricSettingsBlackList;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricSettingsListConfig(ObricSettingsWhiteList=" + this.ObricSettingsWhiteList + ", ObricSettingsBlackList=" + this.ObricSettingsBlackList + ')';
    }

    public final List<String> getObricSettingsBlackList() {
        return this.ObricSettingsBlackList;
    }

    public final List<String> getObricSettingsWhiteList() {
        return this.ObricSettingsWhiteList;
    }

    public ObricSettingsListConfig(List<String> r1, List<String> r2) {
        this.ObricSettingsWhiteList = r1;
        this.ObricSettingsBlackList = r2;
    }

    public /* synthetic */ ObricSettingsListConfig(List r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
