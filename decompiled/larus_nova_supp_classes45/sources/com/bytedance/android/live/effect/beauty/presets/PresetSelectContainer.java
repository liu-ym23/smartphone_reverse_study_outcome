package com.bytedance.android.live.effect.beauty.presets;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/PresetSelectContainer;", "", "selectionsByUid", "", "", "Lcom/bytedance/android/live/effect/beauty/presets/RoomPresetSelectContainer;", "(Ljava/util/Map;)V", "getSelectionsByUid", "()Ljava/util/Map;", "setSelectionsByUid", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PresetSelectContainer {
    private Map<String, RoomPresetSelectContainer> selectionsByUid;

    public PresetSelectContainer() {
        Map r0 = null;
        this(r0, 1, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PresetSelectContainer copy$default(PresetSelectContainer r0, Map r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.selectionsByUid;
    L6:
        return r0.copy(r1);
    }

    public final Map<String, RoomPresetSelectContainer> component1() {
        return this.selectionsByUid;
    }

    public final PresetSelectContainer copy(Map<String, RoomPresetSelectContainer> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectionsByUid");
        return new PresetSelectContainer(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof PresetSelectContainer) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.selectionsByUid, ((PresetSelectContainer) r2).selectionsByUid) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        Map<String, RoomPresetSelectContainer> r0 = this.selectionsByUid;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "PresetSelectContainer(selectionsByUid=" + this.selectionsByUid + ")";
    }

    public final Map<String, RoomPresetSelectContainer> getSelectionsByUid() {
        return this.selectionsByUid;
    }

    public PresetSelectContainer(Map<String, RoomPresetSelectContainer> r2) {
        Intrinsics.checkNotNullParameter(r2, "selectionsByUid");
        this.selectionsByUid = r2;
    }

    public final void setSelectionsByUid(Map<String, RoomPresetSelectContainer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectionsByUid = r2;
    }

    public /* synthetic */ PresetSelectContainer(Map r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = new LinkedHashMap();
    L5:
        this(r1);
    }
}
