package db;

import com.bytedance.gkfs.storage.io.GkFSBlockBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GkFSBlockBuffer f16631b;

    public c(GkFSBlockBuffer r5) {
        this.f16631b = r5;
        this.f16630a = r5.f4945a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f16631b, ((c) r5).f16631b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        GkFSBlockBuffer r5 = this.f16631b;
        if (r5 != null) goto L5;
        return 0;
    L5:
        return r5.hashCode();
    }

    public final String toString() {
        return "CacheItem(buffer=" + this.f16631b + ")";
    }
}
