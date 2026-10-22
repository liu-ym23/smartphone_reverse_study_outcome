package com.bytedance.pia.core.bridge.methods;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/p;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "extraVary", "content", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url")
    private final String f7011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("extraVary")
    private final List<String> f7012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("content")
    private final String f7013c;

    public final String a() {
        return this.f7013c;
    }

    public final List b() {
        return this.f7012b;
    }

    public final String c() {
        return this.f7011a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r5;
        if (Intrinsics.areEqual(this.f7011a, r10.f7011a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f7012b, r10.f7012b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f7013c, r10.f7013c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r5 = this.f7011a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        List<String> r13 = this.f7012b;
        if (r13 != null) goto L9;
        int r14 = 0;
    L10:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f7013c;
        if (r16 == null) goto L15;
        r10 = r16.hashCode();
    L15:
        return r15 + r10;
    L9:
        r14 = r13.hashCode();
        goto L10
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Params(url=");
        r5.append(this.f7011a);
        r5.append(", extraVary=");
        r5.append(this.f7012b);
        r5.append(", content=");
        return ai.j0.p(r5, this.f7013c, ')');
    }
}
