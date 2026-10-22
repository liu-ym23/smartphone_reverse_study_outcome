package com.bytedance.android.live.effect.beauty.presets;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/PresetEffect;", "", "effectId", "", "name", "panel", "parameters", "", "Lcom/bytedance/android/live/effect/beauty/presets/EffectParameter;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEffectId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getPanel", "getParameters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PresetEffect {
    private final String effectId;
    private String name;
    private final String panel;
    private final List<EffectParameter> parameters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresetEffect copy$default(PresetEffect r0, String r1, String r2, String r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.effectId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.panel;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.parameters;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.effectId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.panel;
    }

    public final List<EffectParameter> component4() {
        return this.parameters;
    }

    public final PresetEffect copy(String r2, String r3, String r4, List<EffectParameter> r5) {
        Intrinsics.checkNotNullParameter(r2, "effectId");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "parameters");
        return new PresetEffect(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PresetEffect) == false) goto L14;
        PresetEffect r4 = (PresetEffect) r3;
        if (Intrinsics.areEqual(this.effectId, r4.effectId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.panel, r4.panel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parameters, r4.parameters) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.effectId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.name;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.panel;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<EffectParameter> r11 = this.parameters;
        if (r11 == null) goto L18;
        r1 = r11.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PresetEffect(effectId=" + this.effectId + ", name=" + this.name + ", panel=" + this.panel + ", parameters=" + this.parameters + ")";
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPanel() {
        return this.panel;
    }

    public final List<EffectParameter> getParameters() {
        return this.parameters;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public PresetEffect(String r2, String r3, String r4, List<EffectParameter> r5) {
        Intrinsics.checkNotNullParameter(r2, "effectId");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "parameters");
        this.effectId = r2;
        this.name = r3;
        this.panel = r4;
        this.parameters = r5;
    }
}
