package com.bytedance.android.live.saas.middleware.npth;

import com.bytedance.crash.ICrashCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/npth/NpthParam;", "", "params", "Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;", "javaCrash", "", "nativeCrash", "anr", "crashCallback", "Lcom/bytedance/crash/ICrashCallback;", "(Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;ZZZLcom/bytedance/crash/ICrashCallback;)V", "getAnr", "()Z", "setAnr", "(Z)V", "getCrashCallback", "()Lcom/bytedance/crash/ICrashCallback;", "setCrashCallback", "(Lcom/bytedance/crash/ICrashCallback;)V", "getJavaCrash", "setJavaCrash", "getNativeCrash", "setNativeCrash", "getParams", "()Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;", "setParams", "(Lcom/bytedance/android/live/saas/middleware/npth/DefaultNpthParams;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class NpthParam {
    private boolean anr;
    private ICrashCallback crashCallback;
    private boolean javaCrash;
    private boolean nativeCrash;
    private DefaultNpthParams params;

    public static /* synthetic */ NpthParam copy$default(NpthParam r3, DefaultNpthParams r4, boolean r5, boolean r6, boolean r7, ICrashCallback r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.params;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.javaCrash;
    L8:
        boolean r12 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.nativeCrash;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.anr;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.crashCallback;
    L17:
        DefaultNpthParams r13 = r4;
        return r3.copy(r13, r12, r0, r1, r8);
    }

    public final DefaultNpthParams component1() {
        return this.params;
    }

    public final boolean component2() {
        return this.javaCrash;
    }

    public final boolean component3() {
        return this.nativeCrash;
    }

    public final boolean component4() {
        return this.anr;
    }

    public final ICrashCallback component5() {
        return this.crashCallback;
    }

    public final NpthParam copy(DefaultNpthParams r8, boolean r9, boolean r10, boolean r12, ICrashCallback r13) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r13, "crashCallback");
        return new NpthParam(r8, r9, r10, r12, r13);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NpthParam) == false) goto L16;
        NpthParam r4 = (NpthParam) r3;
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L8;
        return false;
    L8:
        if (this.javaCrash == r4.javaCrash) goto L10;
        return false;
    L10:
        if (this.nativeCrash == r4.nativeCrash) goto L12;
        return false;
    L12:
        if (this.anr == r4.anr) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.crashCallback, r4.crashCallback) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        DefaultNpthParams r0 = this.params;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        boolean r4 = this.javaCrash;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.nativeCrash;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        boolean r12 = this.anr;
        if (r12 == true) goto L16;
        r5 = r12;
    L16:
        int r13 = (r10 + r5) * 31;
        ICrashCallback r14 = this.crashCallback;
        if (r14 == null) goto L20;
        r1 = r14.hashCode();
    L20:
        return r13 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "NpthParam(params=" + this.params + ", javaCrash=" + this.javaCrash + ", nativeCrash=" + this.nativeCrash + ", anr=" + this.anr + ", crashCallback=" + this.crashCallback + ")";
    }

    public final boolean getAnr() {
        return this.anr;
    }

    public final ICrashCallback getCrashCallback() {
        return this.crashCallback;
    }

    public final boolean getJavaCrash() {
        return this.javaCrash;
    }

    public final boolean getNativeCrash() {
        return this.nativeCrash;
    }

    public final DefaultNpthParams getParams() {
        return this.params;
    }

    public final void setAnr(boolean r1) {
        this.anr = r1;
    }

    public final void setCrashCallback(ICrashCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.crashCallback = r2;
    }

    public final void setJavaCrash(boolean r1) {
        this.javaCrash = r1;
    }

    public final void setNativeCrash(boolean r1) {
        this.nativeCrash = r1;
    }

    public final void setParams(DefaultNpthParams r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.params = r2;
    }

    public NpthParam(DefaultNpthParams r2, boolean r3, boolean r4, boolean r5, ICrashCallback r6) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r6, "crashCallback");
        this.params = r2;
        this.javaCrash = r3;
        this.nativeCrash = r4;
        this.anr = r5;
        this.crashCallback = r6;
    }

    public /* synthetic */ NpthParam(DefaultNpthParams r8, boolean r9, boolean r10, boolean r12, ICrashCallback r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        boolean r3 = true;
    L7:
        if ((r14 & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r14 & 8) == 0) goto L13;
        boolean r5 = true;
    L14:
        this(r8, r3, r4, r5, r13);
        return;
    L13:
        r5 = r12;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
