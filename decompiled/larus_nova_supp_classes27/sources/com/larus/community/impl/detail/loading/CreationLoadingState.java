package com.larus.community.impl.detail.loading;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/community/impl/detail/loading/CreationLoadingState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationId", "", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "state", "", "<init>", "(Ljava/lang/String;Lcom/larus/platform/api/creation/UserCreation;I)V", "getCreationId", "()Ljava/lang/String;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "getState", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingState implements w1a.b {

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("state")
    private final int state;

    @SerializedName("creation")
    private final UserCreation userCreation;

    public CreationLoadingState() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ CreationLoadingState copy$default(CreationLoadingState r0, String r1, UserCreation r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.creationId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.userCreation;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.state;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.creationId;
    }

    public final UserCreation component2() {
        return this.userCreation;
    }

    public final int component3() {
        return this.state;
    }

    public final CreationLoadingState copy(String r2, UserCreation r3, @CreationOperateType int r4) {
        return new CreationLoadingState(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationLoadingState) == true) goto L8;
        return false;
    L8:
        CreationLoadingState r6 = (CreationLoadingState) r5;
        if (Intrinsics.areEqual(this.creationId, r6.creationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userCreation, r6.userCreation) == true) goto L15;
        return false;
    L15:
        if (this.state == r6.state) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.creationId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        UserCreation r4 = this.userCreation;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.state;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationLoadingState(creationId=" + this.creationId + ", userCreation=" + this.userCreation + ", state=" + this.state + ')';
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final int getState() {
        return this.state;
    }

    public final UserCreation getUserCreation() {
        return this.userCreation;
    }

    public CreationLoadingState(String r1, UserCreation r2, @CreationOperateType int r3) {
        this.creationId = r1;
        this.userCreation = r2;
        this.state = r3;
    }

    public /* synthetic */ CreationLoadingState(String r2, UserCreation r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
