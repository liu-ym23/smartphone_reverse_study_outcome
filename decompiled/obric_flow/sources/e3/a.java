package e3;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d3.b f16751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16753c;
    public final ByteArrayInputStream d;

    public a(d3.b r5, String r10, String r11, ByteArrayInputStream r12) {
        Intrinsics.checkNotNullParameter(r5, "byteArray");
        Intrinsics.checkNotNullParameter(r10, "cacheKey");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        Intrinsics.checkNotNullParameter(r12, "fileStream");
        this.f16751a = r5;
        this.f16752b = r10;
        this.f16753c = r11;
        this.d = r12;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        d3.b r11 = r10.f16751a;
        if (Intrinsics.areEqual(this.f16751a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16752b, r10.f16752b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16753c, r10.f16753c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Arrays.hashCode(this.f16751a.f16588a) * 31;
        int r10 = kk.a.b(this.f16752b, r5, 31);
        int r11 = kk.a.b(this.f16753c, r10, 31);
        return this.d.hashCode() + r11;
    }

    public final String toString() {
        return "AppletCacheResponse(byteArray=" + this.f16751a + ", cacheKey=" + this.f16752b + ", filePath=" + this.f16753c + ", fileStream=" + this.d + ')';
    }
}
