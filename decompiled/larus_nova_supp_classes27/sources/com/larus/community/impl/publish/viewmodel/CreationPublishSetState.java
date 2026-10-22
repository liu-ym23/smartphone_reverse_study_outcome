package com.larus.community.impl.publish.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishSetState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "isChecked", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishSetState implements w1a.b {
    private final boolean isChecked;

    public CreationPublishSetState() {
        boolean r2 = false;
        this(r2, 1, null);
    }

    public static /* synthetic */ CreationPublishSetState copy$default(CreationPublishSetState r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.isChecked;
    L6:
        return r0.copy(r1);
    }

    public final boolean component1() {
        return this.isChecked;
    }

    public final CreationPublishSetState copy(boolean r2) {
        return new CreationPublishSetState(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CreationPublishSetState) == true) goto L9;
        return false;
    L9:
        if (this.isChecked == ((CreationPublishSetState) r4).isChecked) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.isChecked == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "CreationPublishSetState(isChecked=" + this.isChecked + ')';
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public CreationPublishSetState(boolean r1) {
        this.isChecked = r1;
    }

    public /* synthetic */ CreationPublishSetState(boolean r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        this(r1);
    }
}
