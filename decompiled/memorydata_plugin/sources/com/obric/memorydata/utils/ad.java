package com.obric.memorydata.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/obric/memorydata/utils/LinkStyle;", "", "data", "", "action", "Lcom/obric/memorydata/utils/ClickAction;", TypedValues.Custom.S_COLOR, "", "underline", "", "callback", "Lcom/obric/memorydata/utils/OnClickCallback;", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/utils/ClickAction;IZLcom/obric/memorydata/utils/OnClickCallback;)V", "getData", "()Ljava/lang/String;", "getAction", "()Lcom/obric/memorydata/utils/ClickAction;", "getColor", "()I", "getUnderline", "()Z", "getCallback", "()Lcom/obric/memorydata/utils/OnClickCallback;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f13159b;
    private final int c;
    private final boolean d;
    private final ag e;

    public ad(String r3, e r4, int r5, boolean r6, ag r7) {
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        ag r9 = (ag) ZeusTransformUtils.wrapperContextForParams(r7, ag.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r8, "action");
        this.f13158a = r3;
        this.f13159b = r8;
        this.c = r5;
        this.d = r6;
        this.e = r9;
    }

    public final String a() {
        return this.f13158a;
    }

    public final e b() {
        return this.f13159b;
    }

    public final int c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final ag e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ad.class) == true) goto L8;
        return false;
    L8:
        ad r6 = (ad) ZeusTransformUtils.preCheckCast(r5, ad.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f13158a, r6.f13158a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13159b, r6.f13159b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.f13158a.hashCode() * 31) + this.f13159b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        ag r2 = this.e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "LinkStyle(data=" + this.f13158a + ", action=" + this.f13159b + ", color=" + this.c + ", underline=" + this.d + ", callback=" + this.e + ')';
    }
}
