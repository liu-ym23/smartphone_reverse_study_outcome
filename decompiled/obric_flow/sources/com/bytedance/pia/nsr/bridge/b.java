package com.bytedance.pia.nsr.bridge;

import ai.j0;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pia/nsr/bridge/b;", "", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "", "b", "Ljava/lang/Long;", "()Ljava/lang/Long;", "expires", "", "c", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "reuse", "nameSpace", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url")
    private final String f7176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("expires")
    private final Long f7177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("reuse")
    private final Boolean f7178c;

    @SerializedName("namespace")
    private final String d;

    public final Long a() {
        return this.f7177b;
    }

    public final String b() {
        return this.d;
    }

    public final Boolean c() {
        return this.f7178c;
    }

    public final String d() {
        return this.f7176a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        if (Intrinsics.areEqual(this.f7176a, r10.f7176a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7177b, r10.f7177b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7178c, r10.f7178c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f7176a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        Long r13 = this.f7177b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.f7178c;
        if (r16 != null) goto L13;
        int r17 = 0;
    L14:
        int r18 = (r15 + r17) * 31;
        String r19 = this.d;
        if (r19 == null) goto L19;
        r10 = r19.hashCode();
    L19:
        return r18 + r10;
    L13:
        r17 = r16.hashCode();
        goto L14
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Params(url=");
        r5.append(this.f7176a);
        r5.append(", expires=");
        r5.append(this.f7177b);
        r5.append(", reuse=");
        r5.append(this.f7178c);
        r5.append(", nameSpace=");
        return j0.p(r5, this.d, ')');
    }
}
