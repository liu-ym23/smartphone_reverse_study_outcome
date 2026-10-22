package androidx.room.jarjarred.kotlinx.metadata;

import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/room/jarjarred/kotlinx/metadata/KmVersion;", "", "major", "", "minor", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KmVersion {
    private final int major;
    private final int minor;
    private final int patch;

    public KmVersion(int r5, int r10, int r11) {
        this.major = r5;
        this.minor = r10;
        this.patch = r11;
    }

    public static /* synthetic */ KmVersion copy$default(KmVersion r5, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.major;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.minor;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.patch;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final int component1() {
        return this.major;
    }

    public final int component2() {
        return this.minor;
    }

    public final int component3() {
        return this.patch;
    }

    public final KmVersion copy(int r5, int r10, int r11) {
        return new KmVersion(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof KmVersion) == true) goto L8;
        return false;
    L8:
        KmVersion r10 = (KmVersion) r5;
        if (this.major == r10.major) goto L12;
        return false;
    L12:
        if (this.minor == r10.minor) goto L15;
        return false;
    L15:
        if (this.patch == r10.patch) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        int r5 = Integer.hashCode(this.major) * 31;
        int r10 = a.c(this.minor, r5, 31);
        return Integer.hashCode(this.patch) + r10;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(this.major);
        r5.append('.');
        r5.append(this.minor);
        r5.append('.');
        r5.append(this.patch);
        return r5.toString();
    }
}
