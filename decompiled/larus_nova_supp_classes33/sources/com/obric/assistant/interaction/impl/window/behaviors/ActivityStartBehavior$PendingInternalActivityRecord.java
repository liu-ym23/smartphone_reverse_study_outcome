package com.obric.assistant.interaction.impl.window.behaviors;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$PendingInternalActivityRecord;", "", "targetActivityClassName", "", "token", "chainToken", "deferWindowStashUntilResumed", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTargetActivityClassName", "()Ljava/lang/String;", "getToken", "getChainToken", "getDeferWindowStashUntilResumed", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityStartBehavior$PendingInternalActivityRecord {
    private final String chainToken;
    private final boolean deferWindowStashUntilResumed;
    private final String targetActivityClassName;
    private final String token;

    public static /* synthetic */ ActivityStartBehavior$PendingInternalActivityRecord copy$default(ActivityStartBehavior$PendingInternalActivityRecord r0, String r1, String r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.targetActivityClassName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.token;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.chainToken;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.deferWindowStashUntilResumed;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.targetActivityClassName;
    }

    public final String component2() {
        return this.token;
    }

    public final String component3() {
        return this.chainToken;
    }

    public final boolean component4() {
        return this.deferWindowStashUntilResumed;
    }

    public final ActivityStartBehavior$PendingInternalActivityRecord copy(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "targetActivityClassName");
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "chainToken");
        return new ActivityStartBehavior$PendingInternalActivityRecord(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActivityStartBehavior$PendingInternalActivityRecord) == true) goto L8;
        return false;
    L8:
        ActivityStartBehavior$PendingInternalActivityRecord r6 = (ActivityStartBehavior$PendingInternalActivityRecord) r5;
        if (Intrinsics.areEqual(this.targetActivityClassName, r6.targetActivityClassName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chainToken, r6.chainToken) == true) goto L18;
        return false;
    L18:
        if (this.deferWindowStashUntilResumed == r6.deferWindowStashUntilResumed) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.targetActivityClassName.hashCode() * 31) + this.token.hashCode()) * 31) + this.chainToken.hashCode()) * 31;
        if (this.deferWindowStashUntilResumed == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "PendingInternalActivityRecord(targetActivityClassName=" + this.targetActivityClassName + ", token=" + this.token + ", chainToken=" + this.chainToken + ", deferWindowStashUntilResumed=" + this.deferWindowStashUntilResumed + ')';
    }

    public final String getChainToken() {
        return this.chainToken;
    }

    public final boolean getDeferWindowStashUntilResumed() {
        return this.deferWindowStashUntilResumed;
    }

    public final String getTargetActivityClassName() {
        return this.targetActivityClassName;
    }

    public final String getToken() {
        return this.token;
    }

    public ActivityStartBehavior$PendingInternalActivityRecord(String r2, String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "targetActivityClassName");
        Intrinsics.checkNotNullParameter(r3, "token");
        Intrinsics.checkNotNullParameter(r4, "chainToken");
        this.targetActivityClassName = r2;
        this.token = r3;
        this.chainToken = r4;
        this.deferWindowStashUntilResumed = r5;
    }
}
