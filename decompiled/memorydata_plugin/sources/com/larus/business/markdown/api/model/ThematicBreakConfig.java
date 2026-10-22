package com.larus.business.markdown.api.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "", "height", "", "bgColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBgColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/business/markdown/api/model/ThematicBreakConfig;", "equals", "", "other", "hashCode", "toString", "", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThematicBreakConfig {
    private final Integer bgColor;
    private final Integer height;

    /* JADX WARN: Multi-variable type inference failed */
    public ThematicBreakConfig() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public ThematicBreakConfig(Integer r1, Integer r2) {
        this.height = r1;
        this.bgColor = r2;
    }

    public /* synthetic */ ThematicBreakConfig(Integer r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ ThematicBreakConfig copy$default(ThematicBreakConfig r0, Integer r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.height;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.bgColor;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.height;
    }

    public final Integer component2() {
        return this.bgColor;
    }

    public final ThematicBreakConfig copy(Integer r1, Integer r2) {
        return new ThematicBreakConfig(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ThematicBreakConfig.class) == true) goto L8;
        return false;
    L8:
        ThematicBreakConfig r6 = (ThematicBreakConfig) ZeusTransformUtils.preCheckCast(r5, ThematicBreakConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.height, r6.height) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgColor, r6.bgColor) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public int hashCode() {
        Integer r0 = this.height;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.bgColor;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ThematicBreakConfig(height=" + this.height + ", bgColor=" + this.bgColor + ')';
    }
}
