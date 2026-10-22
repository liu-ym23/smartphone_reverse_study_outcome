package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowHost$NavigationBarInsetsRuntime;", "", "navigationMode", "", "snapshot", "Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "consumedInsets", "Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "<init>", "(Ljava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;)V", "getNavigationMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSnapshot", "()Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;", "getConsumedInsets", "()Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Lcom/obric/assistant/interaction/impl/window/NavigationBarInsetsSnapshot;Lcom/obric/assistant/interaction/impl/window/ConsumedNavigationBarInsets;)Lcom/obric/assistant/interaction/impl/window/WindowHost$NavigationBarInsetsRuntime;", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowHost$NavigationBarInsetsRuntime {
    private final ConsumedNavigationBarInsets consumedInsets;
    private final Integer navigationMode;
    private final NavigationBarInsetsSnapshot snapshot;

    public static /* synthetic */ WindowHost$NavigationBarInsetsRuntime copy$default(WindowHost$NavigationBarInsetsRuntime r0, Integer r1, NavigationBarInsetsSnapshot r2, ConsumedNavigationBarInsets r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.navigationMode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.snapshot;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.consumedInsets;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.navigationMode;
    }

    public final NavigationBarInsetsSnapshot component2() {
        return this.snapshot;
    }

    public final ConsumedNavigationBarInsets component3() {
        return this.consumedInsets;
    }

    public final WindowHost$NavigationBarInsetsRuntime copy(Integer r2, NavigationBarInsetsSnapshot r3, ConsumedNavigationBarInsets r4) {
        Intrinsics.checkNotNullParameter(r4, "consumedInsets");
        return new WindowHost$NavigationBarInsetsRuntime(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WindowHost$NavigationBarInsetsRuntime) == true) goto L8;
        return false;
    L8:
        WindowHost$NavigationBarInsetsRuntime r6 = (WindowHost$NavigationBarInsetsRuntime) r5;
        if (Intrinsics.areEqual(this.navigationMode, r6.navigationMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.snapshot, r6.snapshot) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.consumedInsets, r6.consumedInsets) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.navigationMode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        NavigationBarInsetsSnapshot r4 = this.snapshot;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + this.consumedInsets.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NavigationBarInsetsRuntime(navigationMode=" + this.navigationMode + ", snapshot=" + this.snapshot + ", consumedInsets=" + this.consumedInsets + ')';
    }

    public final ConsumedNavigationBarInsets getConsumedInsets() {
        return this.consumedInsets;
    }

    public final Integer getNavigationMode() {
        return this.navigationMode;
    }

    public final NavigationBarInsetsSnapshot getSnapshot() {
        return this.snapshot;
    }

    public WindowHost$NavigationBarInsetsRuntime(Integer r2, NavigationBarInsetsSnapshot r3, ConsumedNavigationBarInsets r4) {
        Intrinsics.checkNotNullParameter(r4, "consumedInsets");
        this.navigationMode = r2;
        this.snapshot = r3;
        this.consumedInsets = r4;
    }
}
