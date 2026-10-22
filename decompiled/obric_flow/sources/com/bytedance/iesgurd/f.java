package com.bytedance.iesgurd;

import ai.j0;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6626c;
    public final boolean d;
    public final String e;

    public f(String r5, String r10, String r11, boolean r12, String r13) {
        this.f6624a = r5;
        this.f6625b = r10;
        this.f6626c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof f) == false) goto L18;
        f r10 = (f) r5;
        r10.getClass();
        if (Intrinsics.areEqual(GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG, GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f6624a, r10.f6624a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f6625b, r10.f6625b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6626c, r10.f6626c) == true) goto L14;
        return false;
    L14:
        if (this.d == r10.d) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    public final int hashCode() {
        int r5 = 2110048317 * 31;
        int r10 = 0;
        String r11 = this.f6624a;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.f6625b;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f6626c;
        if (r17 == null) goto L13;
        int r18 = r17.hashCode();
    L14:
        int r19 = (r16 + r18) * 31;
        boolean r20 = this.d;
        ?? r21 = r20;
        if (r20 == false) goto L17;
        r21 = 1;
    L17:
        int r22 = (r19 + r21) * 961;
        String r23 = this.e;
        if (r23 == null) goto L21;
        r10 = r23.hashCode();
    L21:
        return r22 + r10;
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("IESGurdResParams(tag=Forest, accessKey=");
        r5.append(this.f6624a);
        r5.append(", channel=");
        r5.append(this.f6625b);
        r5.append(", bundle=");
        r5.append(this.f6626c);
        r5.append(", onlyOffline=");
        r5.append(this.d);
        r5.append(", getCdnSync=false, rootDir=");
        return j0.q(r5, this.e, ")");
    }
}
