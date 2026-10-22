package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/larus/canvas/service/bean/TabExtra;", "", "isSupportRefImage", "", "effectMode", "", "abilityType", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEffectMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAbilityType", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/canvas/service/bean/TabExtra;", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TabExtra {

    @SerializedName("ability_type")
    private final Integer abilityType;

    @SerializedName("effect_mode")
    private final Integer effectMode;

    @SerializedName("is_support_ref_image")
    private final Boolean isSupportRefImage;

    public TabExtra() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TabExtra copy$default(TabExtra r0, Boolean r1, Integer r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isSupportRefImage;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.effectMode;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.abilityType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Boolean component1() {
        return this.isSupportRefImage;
    }

    public final Integer component2() {
        return this.effectMode;
    }

    public final Integer component3() {
        return this.abilityType;
    }

    public final TabExtra copy(Boolean r2, Integer r3, Integer r4) {
        return new TabExtra(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TabExtra) == true) goto L8;
        return false;
    L8:
        TabExtra r6 = (TabExtra) r5;
        if (Intrinsics.areEqual(this.isSupportRefImage, r6.isSupportRefImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.effectMode, r6.effectMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.abilityType, r6.abilityType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isSupportRefImage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.effectMode;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.abilityType;
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
        return "TabExtra(isSupportRefImage=" + this.isSupportRefImage + ", effectMode=" + this.effectMode + ", abilityType=" + this.abilityType + ')';
    }

    public final Integer getAbilityType() {
        return this.abilityType;
    }

    public final Integer getEffectMode() {
        return this.effectMode;
    }

    public final Boolean isSupportRefImage() {
        return this.isSupportRefImage;
    }

    public TabExtra(Boolean r1, Integer r2, Integer r3) {
        this.isSupportRefImage = r1;
        this.effectMode = r2;
        this.abilityType = r3;
    }

    public /* synthetic */ TabExtra(Boolean r2, Integer r3, Integer r4, int r5, DefaultConstructorMarker r6) {
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
