package com.larus.dora.impl.dynamic;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/dora/impl/dynamic/ImageInfo;", "", "lightUrl", "", "", "darkUrl", "<init>", "([Ljava/lang/String;[Ljava/lang/String;)V", "getLightUrl", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getDarkUrl", "equals", "", "other", "hashCode", "", "component1", "component2", "copy", "([Ljava/lang/String;[Ljava/lang/String;)Lcom/larus/dora/impl/dynamic/ImageInfo;", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class u1 {

    @SerializedName("dark_url")
    private final String[] darkUrl;

    @SerializedName("light_url")
    private final String[] lightUrl;

    public final String toString() {
        return "ImageInfo(lightUrl=" + Arrays.toString(this.lightUrl) + ", darkUrl=" + Arrays.toString(this.darkUrl) + ')';
    }

    public final int hashCode() {
        String[] r0 = this.lightUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = Arrays.hashCode(r0);
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.darkUrl;
        if (r4 == null) goto L10;
        r1 = Arrays.hashCode(r4);
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public u1() {
        this.lightUrl = null;
        this.darkUrl = null;
    }

    public final String[] a() {
        return this.darkUrl;
    }

    public final String[] b() {
        return this.lightUrl;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(u1.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.dora.impl.dynamic.ImageInfo");
        u1 r6 = (u1) r5;
        String[] r1 = this.lightUrl;
        if (r1 == null) goto L21;
        String[] r3 = r6.lightUrl;
        if (r3 != null) goto L18;
        return false;
    L18:
        if (Arrays.equals(r1, r3) == true) goto L23;
        return false;
    L23:
        String[] r4 = this.darkUrl;
        if (r4 == null) goto L32;
        String[] r7 = r6.darkUrl;
        if (r7 != null) goto L29;
        return false;
    L29:
        if (Arrays.equals(r4, r7) == true) goto L34;
        return false;
    L34:
        return true;
    L32:
        if (r6.darkUrl == null) goto L34;
        return false;
    L21:
        if (r6.lightUrl == null) goto L23;
        return false;
    L8:
        r2 = null;
        goto L10
    }
}
