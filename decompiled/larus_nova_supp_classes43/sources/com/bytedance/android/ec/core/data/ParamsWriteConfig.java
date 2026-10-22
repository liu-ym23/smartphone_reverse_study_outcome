package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "Ljava/io/Serializable;", "action", "", "optional", "", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAction", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOptional", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "equals", "other", "", "hashCode", "toString", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamsWriteConfig implements Serializable {

    @SerializedName("action")
    private final Integer action;

    @SerializedName("optional")
    private final Boolean optional;

    /* JADX WARN: Multi-variable type inference failed */
    public ParamsWriteConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ParamsWriteConfig copy$default(ParamsWriteConfig r0, Integer r1, Boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.optional;
    L9:
        return r0.copy(r1, r10);
    }

    public final Integer component1() {
        return this.action;
    }

    public final Boolean component2() {
        return this.optional;
    }

    public final ParamsWriteConfig copy(Integer r10, Boolean r11) {
        return new ParamsWriteConfig(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ParamsWriteConfig) == false) goto L10;
        ParamsWriteConfig r11 = (ParamsWriteConfig) r10;
        if (Intrinsics.areEqual(this.action, r11.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optional, r11.optional) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Integer r0 = this.action;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Boolean r12 = this.optional;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "ParamsWriteConfig(action=" + this.action + ", optional=" + this.optional + ")";
    }

    public final Integer getAction() {
        return this.action;
    }

    public final Boolean getOptional() {
        return this.optional;
    }

    public ParamsWriteConfig(Integer r1, Boolean r10) {
        this.action = r1;
        this.optional = r10;
    }

    public /* synthetic */ ParamsWriteConfig(Integer r1, Boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r10 = Boolean.FALSE;
    L8:
        this(r1, r10);
    }
}
