package com.obric.memorydata.personalcontext.search.bridge;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0010\u001a\u00020\u0005J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/search/bridge/EntitySearchOption;", "", "searchTaskId", "", "needReturnParamsByResult", "", "isStorageEntityParams", "isNeedWideRecallResult", "foregroundCallerPkg", "<init>", "(Ljava/lang/String;ZZZLjava/lang/String;)V", "getSearchTaskId", "()Ljava/lang/String;", "getNeedReturnParamsByResult", "()Z", "getForegroundCallerPkg", "isNeedGenerateParams", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12297b;
    private final boolean c;
    private final boolean d;
    private final String e;

    public e(String r2, boolean r3, boolean r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "searchTaskId");
        this.f12296a = r2;
        this.f12297b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    public /* synthetic */ e(String r8, boolean r9, boolean r10, boolean r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r13 & 4) == 0) goto L9;
        r10 = true;
    L9:
        boolean r4 = r10;
        if ((r13 & 8) == 0) goto L12;
        boolean r5 = false;
    L14:
        if ((r13 & 16) == 0) goto L16;
        r12 = null;
    L16:
        this(r8, r3, r4, r5, r12);
        return;
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = r9;
        goto L7
    }

    public final String a() {
        return this.f12296a;
    }

    public final boolean b() {
        return this.f12297b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12296a, r6.f12296a) == true) goto L12;
        return false;
    L12:
        if (this.f12297b == r6.f12297b) goto L15;
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

    public final boolean f() {
        if (this.f12297b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.c == true) goto L8;
        return false;
    }

    public int hashCode() {
        int r0 = ((((((this.f12296a.hashCode() * 31) + Boolean.hashCode(this.f12297b)) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        String r2 = this.e;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "EntitySearchOption(searchTaskId=" + this.f12296a + ", needReturnParamsByResult=" + this.f12297b + ", isStorageEntityParams=" + this.c + ", isNeedWideRecallResult=" + this.d + ", foregroundCallerPkg=" + this.e + ')';
    }
}
