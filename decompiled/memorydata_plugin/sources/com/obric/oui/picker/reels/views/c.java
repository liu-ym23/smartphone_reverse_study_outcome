package com.obric.oui.picker.reels.views;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000f\u001a\u00020\rJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/picker/reels/views/ReelPickerPercentConfig;", "", "widthSpec", "Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;", "heightSpec", "(Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;)V", "getHeightSpec", "()Lcom/obric/oui/picker/reels/views/PercentDimensionSpec;", "getWidthSpec", "component1", "component2", "copy", "equals", "", "other", "hasPercentDimension", "hashCode", "", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f14303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f14304b;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public c(b r1, b r2) {
        this.f14303a = r1;
        this.f14304b = r2;
    }

    public /* synthetic */ c(b r2, b r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final b a() {
        return this.f14303a;
    }

    public final b b() {
        return this.f14304b;
    }

    public final boolean c() {
        if (this.f14303a == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f14304b != null) goto L8;
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14303a, r6.f14303a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f14304b, r6.f14304b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        b r0 = this.f14303a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        b r4 = this.f14304b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ReelPickerPercentConfig(widthSpec=" + this.f14303a + ", heightSpec=" + this.f14304b + ')';
    }
}
