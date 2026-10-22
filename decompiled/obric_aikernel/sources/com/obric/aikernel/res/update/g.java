package com.obric.aikernel.res.update;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f5179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f5183h;

    public g(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r10, "ownerType");
        Intrinsics.checkNotNullParameter(r11, "ownerName");
        Intrinsics.checkNotNullParameter(r12, "ownerVersion");
        Intrinsics.checkNotNullParameter(r13, "ownerDepVersion");
        Intrinsics.checkNotNullParameter(r14, "bizName");
        Intrinsics.checkNotNullParameter(r15, "loraType");
        Intrinsics.checkNotNullParameter(r16, "modelName");
        Intrinsics.checkNotNullParameter(r17, "modelVersion");
        this.f5176a = r10;
        this.f5177b = r11;
        this.f5178c = r12;
        this.f5179d = r13;
        this.f5180e = r14;
        this.f5181f = r15;
        this.f5182g = r16;
        this.f5183h = r17;
    }

    public final String a() {
        return this.f5180e;
    }

    public final String b() {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{this.f5176a, this.f5177b, this.f5178c, this.f5179d, this.f5182g, this.f5183h}), "\u001f", null, null, 0, null, null, 62, null);
    }

    public final String c() {
        return this.f5181f;
    }

    public final String d() {
        return this.f5182g;
    }

    public final String e() {
        return this.f5183h;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.f5176a, r11.f5176a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f5177b, r11.f5177b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f5178c, r11.f5178c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f5179d, r11.f5179d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f5180e, r11.f5180e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f5181f, r11.f5181f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f5182g, r11.f5182g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f5183h, r11.f5183h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String f() {
        return this.f5179d;
    }

    public final String g() {
        return this.f5177b;
    }

    public final String h() {
        return this.f5176a;
    }

    public int hashCode() {
        return (((((((((((((this.f5176a.hashCode() * 31) + this.f5177b.hashCode()) * 31) + this.f5178c.hashCode()) * 31) + this.f5179d.hashCode()) * 31) + this.f5180e.hashCode()) * 31) + this.f5181f.hashCode()) * 31) + this.f5182g.hashCode()) * 31) + this.f5183h.hashCode();
    }

    public final String i() {
        return this.f5178c;
    }

    public String toString() {
        return "ModelDownloadIdentity(ownerType=" + this.f5176a + ", ownerName=" + this.f5177b + ", ownerVersion=" + this.f5178c + ", ownerDepVersion=" + this.f5179d + ", bizName=" + this.f5180e + ", loraType=" + this.f5181f + ", modelName=" + this.f5182g + ", modelVersion=" + this.f5183h + ')';
    }
}
