package com.obric.dejavu.library;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0002\u0010\u0010JF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006\""}, d2 = {"Lcom/obric/dejavu/library/DbSearchOption;", "", "normalize", "", "searchProbe", "", "searchProbeFilter", "", "distFilter", "filters", "", "", "(ZIFF[Ljava/lang/String;)V", "getDistFilter", "()F", "getFilters", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getNormalize", "()Z", "getSearchProbe", "()I", "getSearchProbeFilter", "component1", "component2", "component3", "component4", "component5", "copy", "(ZIFF[Ljava/lang/String;)Lcom/obric/dejavu/library/DbSearchOption;", "equals", "other", "hashCode", "toString", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7890b;
    private final float c;
    private final float d;
    private final String[] e;

    public e() {
        this(false, 0, 0.0f, 0.0f, null, 31, null);
    }

    public e(boolean r2, int r3, float r4, float r5, String[] r6) {
        Intrinsics.checkNotNullParameter(r6, "filters");
        this.f7889a = r2;
        this.f7890b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ e(boolean r3, int r4, float r5, float r6, String[] r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = Float.NaN;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = Float.NaN;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = new String[0];
    L17:
        this(r3, r4, r5, r6, r7);
    }

    public final boolean a() {
        return this.f7889a;
    }

    public final int b() {
        return this.f7890b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final String[] e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (this.f7889a == r6.f7889a) goto L12;
        return false;
    L12:
        if (this.f7890b == r6.f7890b) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean r0 = this.f7889a;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((((((r1 * 31) + Integer.hashCode(this.f7890b)) * 31) + Float.hashCode(this.c)) * 31) + Float.hashCode(this.d)) * 31) + Arrays.hashCode(this.e);
    }

    public String toString() {
        return "DbSearchOption(normalize=" + this.f7889a + ", searchProbe=" + this.f7890b + ", searchProbeFilter=" + this.c + ", distFilter=" + this.d + ", filters=" + Arrays.toString(this.e) + ')';
    }
}
