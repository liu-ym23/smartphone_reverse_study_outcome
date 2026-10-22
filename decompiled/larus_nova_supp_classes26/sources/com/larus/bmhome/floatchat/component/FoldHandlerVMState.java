package com.larus.bmhome.floatchat.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/floatchat/component/FoldHandlerVMState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "status", "", "needAnim", "", "<init>", "(IZ)V", "getStatus", "()I", "getNeedAnim", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FoldHandlerVMState implements w1a.b {
    private final boolean needAnim;
    private final int status;

    /* JADX WARN: Multi-variable type inference failed */
    public FoldHandlerVMState() {
        int r2 = 0;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public static /* synthetic */ FoldHandlerVMState copy$default(FoldHandlerVMState r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.needAnim;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.needAnim;
    }

    public final FoldHandlerVMState copy(int r2, boolean r3) {
        return new FoldHandlerVMState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FoldHandlerVMState) == true) goto L8;
        return false;
    L8:
        FoldHandlerVMState r6 = (FoldHandlerVMState) r5;
        if (this.status == r6.status) goto L12;
        return false;
    L12:
        if (this.needAnim == r6.needAnim) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.status * 31;
        if (this.needAnim == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "FoldHandlerVMState(status=" + this.status + ", needAnim=" + this.needAnim + ')';
    }

    public final boolean getNeedAnim() {
        return this.needAnim;
    }

    public final int getStatus() {
        return this.status;
    }

    public FoldHandlerVMState(int r1, boolean r2) {
        this.status = r1;
        this.needAnim = r2;
    }

    public /* synthetic */ FoldHandlerVMState(int r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
