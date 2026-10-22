package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u000bHÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/res/update/DownloadAwaitResult;", "", "distConfig", "Lcom/obric/aikernel/res/metadata/config/DistConfig;", "task", "Lcom/obric/aikernel/res/downloader/DownloadTask;", "downloadResult", "Lkotlin/Pair;", "", "", "message", "", "(Lcom/obric/aikernel/res/metadata/config/DistConfig;Lcom/obric/aikernel/res/downloader/DownloadTask;Lkotlin/Pair;Ljava/lang/String;)V", "getDistConfig", "()Lcom/obric/aikernel/res/metadata/config/DistConfig;", "getDownloadResult", "()Lkotlin/Pair;", "getMessage", "()Ljava/lang/String;", "getTask", "()Lcom/obric/aikernel/res/downloader/DownloadTask;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.aikernel.res.metadata.config.a f6116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.aikernel.res.downloader.j f6117b;
    private final Pair<Boolean, Integer> c;
    private final String d;

    public b(com.obric.aikernel.res.metadata.config.a r2, com.obric.aikernel.res.downloader.j r3, Pair<Boolean, Integer> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "distConfig");
        Intrinsics.checkNotNullParameter(r3, "task");
        Intrinsics.checkNotNullParameter(r4, "downloadResult");
        Intrinsics.checkNotNullParameter(r5, "message");
        this.f6116a = r2;
        this.f6117b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final com.obric.aikernel.res.downloader.j a() {
        return this.f6117b;
    }

    public final Pair<Boolean, Integer> b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6116a, r6.f6116a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6117b, r6.f6117b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f6116a.hashCode() * 31) + this.f6117b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DownloadAwaitResult(distConfig=" + this.f6116a + ", task=" + this.f6117b + ", downloadResult=" + this.c + ", message=" + this.d + ')';
    }
}
