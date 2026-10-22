package com.bytedance.android.live.effect.beauty.presets;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u001b\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0003JM\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR,\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/BeautifyPreset;", "", "presetId", "", "presetName", "beautyEnabled", "", "bodyEnabled", "effectsByPanel", "", "", "Lcom/bytedance/android/live/effect/beauty/presets/PresetEffect;", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "getBeautyEnabled", "()Z", "getBodyEnabled", "getEffectsByPanel", "()Ljava/util/Map;", "setEffectsByPanel", "(Ljava/util/Map;)V", "getPresetId", "()Ljava/lang/String;", "getPresetName", "setPresetName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeautifyPreset {
    private final boolean beautyEnabled;
    private final boolean bodyEnabled;
    private Map<String, ? extends List<PresetEffect>> effectsByPanel;
    private final String presetId;
    private String presetName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BeautifyPreset copy$default(BeautifyPreset r3, String r4, String r5, boolean r6, boolean r7, Map r8, int r9, Object r11) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.presetId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.presetName;
    L8:
        String r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.beautyEnabled;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.bodyEnabled;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.effectsByPanel;
    L17:
        String r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final String component1() {
        return this.presetId;
    }

    public final String component2() {
        return this.presetName;
    }

    public final boolean component3() {
        return this.beautyEnabled;
    }

    public final boolean component4() {
        return this.bodyEnabled;
    }

    public final Map<String, List<PresetEffect>> component5() {
        return this.effectsByPanel;
    }

    public final BeautifyPreset copy(String r8, String r9, boolean r11, boolean r12, Map<String, ? extends List<PresetEffect>> r13) {
        Intrinsics.checkNotNullParameter(r8, "presetId");
        Intrinsics.checkNotNullParameter(r9, "presetName");
        Intrinsics.checkNotNullParameter(r13, "effectsByPanel");
        return new BeautifyPreset(r8, r9, r11, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof BeautifyPreset) == false) goto L16;
        BeautifyPreset r4 = (BeautifyPreset) r3;
        if (Intrinsics.areEqual(this.presetId, r4.presetId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.presetName, r4.presetName) == true) goto L10;
        return false;
    L10:
        if (this.beautyEnabled == r4.beautyEnabled) goto L12;
        return false;
    L12:
        if (this.bodyEnabled == r4.bodyEnabled) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.effectsByPanel, r4.effectsByPanel) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.presetId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.presetName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.beautyEnabled;
        ?? r8 = 1;
        ?? r9 = r7;
        if (r7 == false) goto L13;
        r9 = 1;
    L13:
        int r11 = (r6 + r9) * 31;
        boolean r12 = this.bodyEnabled;
        if (r12 == true) goto L17;
        r8 = r12;
    L17:
        int r13 = (r11 + r8) * 31;
        Map<String, ? extends List<PresetEffect>> r14 = this.effectsByPanel;
        if (r14 == null) goto L21;
        r1 = r14.hashCode();
    L21:
        return r13 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BeautifyPreset(presetId=" + this.presetId + ", presetName=" + this.presetName + ", beautyEnabled=" + this.beautyEnabled + ", bodyEnabled=" + this.bodyEnabled + ", effectsByPanel=" + this.effectsByPanel + ")";
    }

    public final boolean getBeautyEnabled() {
        return this.beautyEnabled;
    }

    public final boolean getBodyEnabled() {
        return this.bodyEnabled;
    }

    public final Map<String, List<PresetEffect>> getEffectsByPanel() {
        return this.effectsByPanel;
    }

    public final String getPresetId() {
        return this.presetId;
    }

    public final String getPresetName() {
        return this.presetName;
    }

    public final void setEffectsByPanel(Map<String, ? extends List<PresetEffect>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.effectsByPanel = r2;
    }

    public final void setPresetName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.presetName = r2;
    }

    public BeautifyPreset(String r2, String r3, boolean r4, boolean r5, Map<String, ? extends List<PresetEffect>> r6) {
        Intrinsics.checkNotNullParameter(r2, "presetId");
        Intrinsics.checkNotNullParameter(r3, "presetName");
        Intrinsics.checkNotNullParameter(r6, "effectsByPanel");
        this.presetId = r2;
        this.presetName = r3;
        this.beautyEnabled = r4;
        this.bodyEnabled = r5;
        this.effectsByPanel = r6;
    }
}
