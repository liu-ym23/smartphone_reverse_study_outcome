package com.larus.uaigc.spring.viewmodel;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/spring/viewmodel/TransparentState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "hasShowMenu", "", "hasShowIme", "<init>", "(ZZ)V", "getHasShowMenu", "()Z", "getHasShowIme", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class TransparentState implements b {
    private final boolean hasShowIme;
    private final boolean hasShowMenu;

    public TransparentState() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ TransparentState copy$default(TransparentState r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.hasShowMenu;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hasShowIme;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.hasShowMenu;
    }

    public final boolean component2() {
        return this.hasShowIme;
    }

    public final TransparentState copy(boolean r2, boolean r3) {
        return new TransparentState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TransparentState) == true) goto L8;
        return false;
    L8:
        TransparentState r6 = (TransparentState) r5;
        if (this.hasShowMenu == r6.hasShowMenu) goto L12;
        return false;
    L12:
        if (this.hasShowIme == r6.hasShowIme) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.hasShowMenu == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.hasShowIme == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "TransparentState(hasShowMenu=" + this.hasShowMenu + ", hasShowIme=" + this.hasShowIme + ')';
    }

    public final boolean getHasShowIme() {
        return this.hasShowIme;
    }

    public final boolean getHasShowMenu() {
        return this.hasShowMenu;
    }

    public TransparentState(boolean r1, boolean r2) {
        this.hasShowMenu = r1;
        this.hasShowIme = r2;
    }

    public /* synthetic */ TransparentState(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
