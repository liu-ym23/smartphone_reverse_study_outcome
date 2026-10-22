package com.bytedance.forest.model;

import ai.j0;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/model/ForestEnvData;", "", "type", "Lcom/bytedance/forest/model/ForestEnvType;", "name", "", "(Lcom/bytedance/forest/model/ForestEnvType;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/forest/model/ForestEnvType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
public final class ForestEnvData {

    @Keep
    private final String name;

    @Keep
    private final ForestEnvType type;

    public ForestEnvData(ForestEnvType r5, String r10) {
        this.type = r5;
        this.name = r10;
    }

    public static /* synthetic */ ForestEnvData copy$default(ForestEnvData r5, ForestEnvType r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.type;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.name;
    L9:
        return r5.copy(r10, r11);
    }

    public final ForestEnvType component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final ForestEnvData copy(ForestEnvType r5, String r10) {
        return new ForestEnvData(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof ForestEnvData) == false) goto L10;
        ForestEnvData r10 = (ForestEnvData) r5;
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final ForestEnvType getType() {
        return this.type;
    }

    public int hashCode() {
        ForestEnvType r5 = this.type;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = r11 * 31;
        String r13 = this.name;
        if (r13 == null) goto L10;
        r10 = r13.hashCode();
    L10:
        return r12 + r10;
    L5:
        r11 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ForestEnvData(type=");
        r5.append(this.type);
        r5.append(", name=");
        return j0.q(r5, this.name, ")");
    }
}
