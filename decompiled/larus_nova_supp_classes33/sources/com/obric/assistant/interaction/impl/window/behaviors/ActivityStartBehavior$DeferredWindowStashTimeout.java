package com.obric.assistant.interaction.impl.window.behaviors;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ActivityStartBehavior$DeferredWindowStashTimeout;", "", "token", "", "chainToken", "runnable", "Ljava/lang/Runnable;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;)V", "getToken", "()Ljava/lang/String;", "getChainToken", "getRunnable", "()Ljava/lang/Runnable;", "component1", "component2", "component3", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityStartBehavior$DeferredWindowStashTimeout {
    private final String chainToken;
    private final Runnable runnable;
    private final String token;

    public static /* synthetic */ ActivityStartBehavior$DeferredWindowStashTimeout copy$default(ActivityStartBehavior$DeferredWindowStashTimeout r0, String r1, String r2, Runnable r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.chainToken;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.runnable;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.chainToken;
    }

    public final Runnable component3() {
        return this.runnable;
    }

    public final ActivityStartBehavior$DeferredWindowStashTimeout copy(String r2, String r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "chainToken");
        Intrinsics.checkNotNullParameter(r4, "runnable");
        return new ActivityStartBehavior$DeferredWindowStashTimeout(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ActivityStartBehavior$DeferredWindowStashTimeout) == true) goto L8;
        return false;
    L8:
        ActivityStartBehavior$DeferredWindowStashTimeout r6 = (ActivityStartBehavior$DeferredWindowStashTimeout) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chainToken, r6.chainToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.runnable, r6.runnable) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.token.hashCode() * 31) + this.chainToken.hashCode()) * 31) + this.runnable.hashCode();
    }

    public String toString() {
        return "DeferredWindowStashTimeout(token=" + this.token + ", chainToken=" + this.chainToken + ", runnable=" + this.runnable + ')';
    }

    public final String getChainToken() {
        return this.chainToken;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final String getToken() {
        return this.token;
    }

    public ActivityStartBehavior$DeferredWindowStashTimeout(String r2, String r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "chainToken");
        Intrinsics.checkNotNullParameter(r4, "runnable");
        this.token = r2;
        this.chainToken = r3;
        this.runnable = r4;
    }
}
