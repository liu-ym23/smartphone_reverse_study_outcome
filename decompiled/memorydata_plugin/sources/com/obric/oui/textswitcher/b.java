package com.obric.oui.textswitcher;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/textswitcher/TextSpec;", "", "textColor", "", "textSizeDp", "", "paddingDp", "", "(Ljava/lang/Integer;Ljava/lang/Float;[I)V", "getPaddingDp", "()[I", "getTextColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTextSizeDp", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Float;[I)Lcom/obric/oui/textswitcher/TextSpec;", "equals", "", "other", "hashCode", "toString", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f14720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f14721b;
    private final int[] c;

    public b() {
        this(null, null, null, 7, null);
    }

    public b(Integer r2, Float r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r4, "paddingDp");
        this.f14720a = r2;
        this.f14721b = r3;
        this.c = r4;
    }

    public /* synthetic */ b(Integer r2, Float r3, int[] r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new int[]{0, 0, 0, 0};
    L11:
        this(r2, r3, r4);
    }

    public final Integer a() {
        return this.f14720a;
    }

    public final Float b() {
        return this.f14721b;
    }

    public final int[] c() {
        return this.c;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r7 != null) goto L8;
        Class<?> r3 = null;
    L10:
        if (Intrinsics.areEqual(r2, r3) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.oui.textswitcher.TextSpec");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f14720a, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14720a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f14721b, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).f14721b) == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.c, ((b) ZeusTransformUtils.preCheckCast(r7, b.class, "com.obric.memorydata.plugin")).c) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r3 = r7.getClass();
        goto L10
    }

    public int hashCode() {
        Integer r0 = this.f14720a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Float r4 = this.f14721b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Arrays.hashCode(this.c);
    L5:
        r2 = r0.intValue();
        goto L6
    }

    public String toString() {
        return "TextSpec(textColor=" + this.f14720a + ", textSizeDp=" + this.f14721b + ", paddingDp=" + Arrays.toString(this.c) + ')';
    }
}
