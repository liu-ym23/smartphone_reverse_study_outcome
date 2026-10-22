package com.obric.aikernel.res.downloader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/res/downloader/DownloadLocalState;", "", "saveDirExists", "", "saveFileExists", "saveFileBytes", "", "tmpDirExists", "(ZZJZ)V", "getSaveDirExists", "()Z", "getSaveFileBytes", "()J", "getSaveFileExists", "getTmpDirExists", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f6017b;
    private final long c;
    private final boolean d;

    public f(boolean r1, boolean r2, long r3, boolean r5) {
        this.f6016a = r1;
        this.f6017b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final boolean a() {
        return this.f6016a;
    }

    public final boolean b() {
        return this.f6017b;
    }

    public final long c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, f.class) == true) goto L8;
        return false;
    L8:
        f r10 = (f) ZeusTransformUtils.preCheckCast(r9, f.class, "com.obric.memorydata.plugin");
        if (this.f6016a == r10.f6016a) goto L12;
        return false;
    L12:
        if (this.f6017b == r10.f6017b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        boolean r0 = this.f6016a;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.f6017b;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + Long.hashCode(this.c)) * 31;
        boolean r7 = this.d;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return r6 + r1;
    }

    public String toString() {
        return "DownloadLocalState(saveDirExists=" + this.f6016a + ", saveFileExists=" + this.f6017b + ", saveFileBytes=" + this.c + ", tmpDirExists=" + this.d + ')';
    }
}
