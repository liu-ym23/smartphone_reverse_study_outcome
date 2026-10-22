package com.obric.aikernel.res.update;

import com.obric.aikernel.res.downloader.DownloadTask;
import com.obric.aikernel.res.metadata.config.DistConfig;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DistConfig f5161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DownloadTask f5162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pair<Boolean, Integer> f5163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5164d;

    public b(DistConfig r10, DownloadTask r11, Pair<Boolean, Integer> r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "distConfig");
        Intrinsics.checkNotNullParameter(r11, "task");
        Intrinsics.checkNotNullParameter(r12, "downloadResult");
        Intrinsics.checkNotNullParameter(r13, "message");
        this.f5161a = r10;
        this.f5162b = r11;
        this.f5163c = r12;
        this.f5164d = r13;
    }

    public final Pair<Boolean, Integer> a() {
        return this.f5163c;
    }

    public final String b() {
        return this.f5164d;
    }

    public final DownloadTask c() {
        return this.f5162b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.f5161a, r11.f5161a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5162b, r11.f5162b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5163c, r11.f5163c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f5164d, r11.f5164d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f5161a.hashCode() * 31) + this.f5162b.hashCode()) * 31) + this.f5163c.hashCode()) * 31) + this.f5164d.hashCode();
    }

    public String toString() {
        return "DownloadAwaitResult(distConfig=" + this.f5161a + ", task=" + this.f5162b + ", downloadResult=" + this.f5163c + ", message=" + this.f5164d + ')';
    }
}
