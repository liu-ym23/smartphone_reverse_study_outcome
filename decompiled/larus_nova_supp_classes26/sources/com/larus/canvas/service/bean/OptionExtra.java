package com.larus.canvas.service.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0002\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006$"}, d2 = {"Lcom/larus/canvas/service/bean/OptionExtra;", "", "isPresetRefImage", "", "presetRefImage", "Lcom/larus/canvas/service/bean/PresetRefImage;", "isTrending", "detectMode", "", "subDisplay", "", "optionMsg", "<init>", "(Ljava/lang/Boolean;Lcom/larus/canvas/service/bean/PresetRefImage;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPresetRefImage", "()Lcom/larus/canvas/service/bean/PresetRefImage;", "getDetectMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSubDisplay", "()Ljava/lang/String;", "getOptionMsg", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Lcom/larus/canvas/service/bean/PresetRefImage;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/canvas/service/bean/OptionExtra;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OptionExtra {

    @SerializedName("detect_mode")
    private final Integer detectMode;

    @SerializedName("is_preset_ref_image")
    private final Boolean isPresetRefImage;

    @SerializedName("is_trending")
    private final Boolean isTrending;

    @SerializedName("option_msg")
    private final String optionMsg;

    @SerializedName("preset_ref_image")
    private final PresetRefImage presetRefImage;

    @SerializedName("sub_display")
    private final String subDisplay;

    public OptionExtra() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ OptionExtra copy$default(OptionExtra r4, Boolean r5, PresetRefImage r6, Boolean r7, Integer r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.isPresetRefImage;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.presetRefImage;
    L8:
        PresetRefImage r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.isTrending;
    L11:
        Boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.detectMode;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.subDisplay;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.optionMsg;
    L20:
        Boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final Boolean component1() {
        return this.isPresetRefImage;
    }

    public final PresetRefImage component2() {
        return this.presetRefImage;
    }

    public final Boolean component3() {
        return this.isTrending;
    }

    public final Integer component4() {
        return this.detectMode;
    }

    public final String component5() {
        return this.subDisplay;
    }

    public final String component6() {
        return this.optionMsg;
    }

    public final OptionExtra copy(Boolean r9, PresetRefImage r10, Boolean r11, Integer r12, String r13, String r14) {
        return new OptionExtra(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OptionExtra) == true) goto L8;
        return false;
    L8:
        OptionExtra r6 = (OptionExtra) r5;
        if (Intrinsics.areEqual(this.isPresetRefImage, r6.isPresetRefImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.presetRefImage, r6.presetRefImage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isTrending, r6.isTrending) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detectMode, r6.detectMode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subDisplay, r6.subDisplay) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.optionMsg, r6.optionMsg) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.isPresetRefImage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PresetRefImage r4 = this.presetRefImage;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.isTrending;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.detectMode;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.subDisplay;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.optionMsg;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OptionExtra(isPresetRefImage=" + this.isPresetRefImage + ", presetRefImage=" + this.presetRefImage + ", isTrending=" + this.isTrending + ", detectMode=" + this.detectMode + ", subDisplay=" + this.subDisplay + ", optionMsg=" + this.optionMsg + ')';
    }

    public final Integer getDetectMode() {
        return this.detectMode;
    }

    public final String getOptionMsg() {
        return this.optionMsg;
    }

    public final PresetRefImage getPresetRefImage() {
        return this.presetRefImage;
    }

    public final String getSubDisplay() {
        return this.subDisplay;
    }

    public final Boolean isPresetRefImage() {
        return this.isPresetRefImage;
    }

    public final Boolean isTrending() {
        return this.isTrending;
    }

    public OptionExtra(Boolean r1, PresetRefImage r2, Boolean r3, Integer r4, String r5, String r6) {
        this.isPresetRefImage = r1;
        this.presetRefImage = r2;
        this.isTrending = r3;
        this.detectMode = r4;
        this.subDisplay = r5;
        this.optionMsg = r6;
    }

    public /* synthetic */ OptionExtra(Boolean r6, PresetRefImage r7, Boolean r8, Integer r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        Boolean r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        PresetRefImage r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Boolean r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Integer r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
