package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "Ljava/io/Serializable;", "removeIfEmpty", "", "", "forceString", "(Ljava/util/List;Ljava/util/List;)V", "getForceString", "()Ljava/util/List;", "getRemoveIfEmpty", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamsForceRule implements Serializable {

    @SerializedName("force_string")
    private final List<String> forceString;

    @SerializedName("remove_if_empty")
    private final List<String> removeIfEmpty;

    public ParamsForceRule() {
        List r0 = null;
        this(r0, r0, 3, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParamsForceRule copy$default(ParamsForceRule r0, List r1, List r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.removeIfEmpty;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.forceString;
    L9:
        return r0.copy(r1, r10);
    }

    public final List<String> component1() {
        return this.removeIfEmpty;
    }

    public final List<String> component2() {
        return this.forceString;
    }

    public final ParamsForceRule copy(List<String> r10, List<String> r11) {
        return new ParamsForceRule(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ParamsForceRule) == false) goto L10;
        ParamsForceRule r11 = (ParamsForceRule) r10;
        if (Intrinsics.areEqual(this.removeIfEmpty, r11.removeIfEmpty) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.forceString, r11.forceString) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.removeIfEmpty;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        List<String> r12 = this.forceString;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "ParamsForceRule(removeIfEmpty=" + this.removeIfEmpty + ", forceString=" + this.forceString + ")";
    }

    public final List<String> getForceString() {
        return this.forceString;
    }

    public final List<String> getRemoveIfEmpty() {
        return this.removeIfEmpty;
    }

    public ParamsForceRule(List<String> r1, List<String> r10) {
        this.removeIfEmpty = r1;
        this.forceString = r10;
    }

    public /* synthetic */ ParamsForceRule(List r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
