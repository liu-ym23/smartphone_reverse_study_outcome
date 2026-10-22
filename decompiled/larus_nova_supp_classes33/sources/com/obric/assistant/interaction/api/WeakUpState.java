package com.obric.assistant.interaction.api;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/api/WeakUpState;", "", "isAudioWeakUp", "", "isUiRenderedByChildProcess", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeakUpState {
    private final boolean isAudioWeakUp;
    private final boolean isUiRenderedByChildProcess;

    public WeakUpState() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ WeakUpState copy$default(WeakUpState r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isAudioWeakUp;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isUiRenderedByChildProcess;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isAudioWeakUp;
    }

    public final boolean component2() {
        return this.isUiRenderedByChildProcess;
    }

    public final WeakUpState copy(boolean r2, boolean r3) {
        return new WeakUpState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WeakUpState) == true) goto L8;
        return false;
    L8:
        WeakUpState r6 = (WeakUpState) r5;
        if (this.isAudioWeakUp == r6.isAudioWeakUp) goto L12;
        return false;
    L12:
        if (this.isUiRenderedByChildProcess == r6.isUiRenderedByChildProcess) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isAudioWeakUp == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isUiRenderedByChildProcess == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "WeakUpState(isAudioWeakUp=" + this.isAudioWeakUp + ", isUiRenderedByChildProcess=" + this.isUiRenderedByChildProcess + ')';
    }

    public final boolean isAudioWeakUp() {
        return this.isAudioWeakUp;
    }

    public final boolean isUiRenderedByChildProcess() {
        return this.isUiRenderedByChildProcess;
    }

    public WeakUpState(boolean r1, boolean r2) {
        this.isAudioWeakUp = r1;
        this.isUiRenderedByChildProcess = r2;
    }

    public /* synthetic */ WeakUpState(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
