package androidx.compose.runtime.reflect;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", "(ZIII)V", "getChangedParams", "()I", "getDefaultParams", "()Z", "getRealParamsCount", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposableInfo {
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;

    public ComposableInfo(boolean r5, int r10, int r11, int r12) {
        this.isComposable = r5;
        this.realParamsCount = r10;
        this.changedParams = r11;
        this.defaultParams = r12;
    }

    public static /* synthetic */ ComposableInfo copy$default(ComposableInfo r5, boolean r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = r5.isComposable;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = r5.realParamsCount;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = r5.changedParams;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r13 = r5.defaultParams;
    L15:
        return r5.copy(r10, r11, r12, r13);
    }

    public final boolean component1() {
        return this.isComposable;
    }

    public final int component2() {
        return this.realParamsCount;
    }

    public final int component3() {
        return this.changedParams;
    }

    public final int component4() {
        return this.defaultParams;
    }

    public final ComposableInfo copy(boolean r5, int r10, int r11, int r12) {
        return new ComposableInfo(r5, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ComposableInfo) == true) goto L8;
        return false;
    L8:
        ComposableInfo r10 = (ComposableInfo) r5;
        if (this.isComposable == r10.isComposable) goto L12;
        return false;
    L12:
        if (this.realParamsCount == r10.realParamsCount) goto L15;
        return false;
    L15:
        if (this.changedParams == r10.changedParams) goto L18;
        return false;
    L18:
        if (this.defaultParams == r10.defaultParams) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public int hashCode() {
        boolean r5 = this.isComposable;
        ?? r10 = r5;
        if (r5 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = this.realParamsCount;
        int r12 = a.c(r11, r10 * 31, 31);
        int r13 = a.c(this.changedParams, r12, 31);
        return Integer.hashCode(this.defaultParams) + r13;
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ComposableInfo(isComposable=");
        r5.append(this.isComposable);
        r5.append(", realParamsCount=");
        r5.append(this.realParamsCount);
        r5.append(", changedParams=");
        r5.append(this.changedParams);
        r5.append(", defaultParams=");
        return j0.n(r5, this.defaultParams, ')');
    }
}
