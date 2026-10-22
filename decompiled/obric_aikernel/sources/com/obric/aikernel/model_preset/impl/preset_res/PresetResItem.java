package com.obric.aikernel.model_preset.impl.preset_res;

import com.obric.aikernel.model_preset.api.PresetType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PresetResItem {
    private final Map<String, String> fileNameKeyInfoMap;
    private final String modelName;
    private final PresetType presetType;

    public PresetResItem(String r10, Map<String, String> r11, PresetType r12) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileNameKeyInfoMap");
        Intrinsics.checkNotNullParameter(r12, "presetType");
        this.modelName = r10;
        this.fileNameKeyInfoMap = r11;
        this.presetType = r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresetResItem copy$default(PresetResItem r10, String r11, Map r12, PresetType r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.modelName;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.fileNameKeyInfoMap;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.presetType;
    L12:
        return r10.copy(r11, r12, r13);
    }

    public final String component1() {
        return this.modelName;
    }

    public final Map<String, String> component2() {
        return this.fileNameKeyInfoMap;
    }

    public final PresetType component3() {
        return this.presetType;
    }

    public final PresetResItem copy(String r10, Map<String, String> r11, PresetType r12) {
        Intrinsics.checkNotNullParameter(r10, "modelName");
        Intrinsics.checkNotNullParameter(r11, "fileNameKeyInfoMap");
        Intrinsics.checkNotNullParameter(r12, "presetType");
        return new PresetResItem(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PresetResItem) == true) goto L8;
        return false;
    L8:
        PresetResItem r11 = (PresetResItem) r10;
        if (Intrinsics.areEqual(this.modelName, r11.modelName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileNameKeyInfoMap, r11.fileNameKeyInfoMap) == true) goto L15;
        return false;
    L15:
        if (this.presetType == r11.presetType) goto L17;
        return false;
    L17:
        return true;
    }

    public final Map<String, String> getFileNameKeyInfoMap() {
        return this.fileNameKeyInfoMap;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final PresetType getPresetType() {
        return this.presetType;
    }

    public int hashCode() {
        return (((this.modelName.hashCode() * 31) + this.fileNameKeyInfoMap.hashCode()) * 31) + this.presetType.hashCode();
    }

    public String toString() {
        return "PresetResItem(modelName=" + this.modelName + ", fileNameKeyInfoMap=" + this.fileNameKeyInfoMap + ", presetType=" + this.presetType + ')';
    }
}
