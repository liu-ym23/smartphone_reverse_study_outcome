package com.bytedance.android.livesdk.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/LivePlayerStackPrint;", "", "enable_player_print_stack", "", "player_stack_depth", "", "(ZI)V", "getEnable_player_print_stack", "()Z", "getPlayer_stack_depth", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerStackPrint {
    private final boolean enable_player_print_stack;
    private final int player_stack_depth;

    /* JADX WARN: Multi-variable type inference failed */
    public LivePlayerStackPrint() {
        boolean r2 = false;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public static /* synthetic */ LivePlayerStackPrint copy$default(LivePlayerStackPrint r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.enable_player_print_stack;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.player_stack_depth;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.enable_player_print_stack;
    }

    public final int component2() {
        return this.player_stack_depth;
    }

    public final LivePlayerStackPrint copy(boolean r2, int r3) {
        return new LivePlayerStackPrint(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LivePlayerStackPrint) == false) goto L10;
        LivePlayerStackPrint r4 = (LivePlayerStackPrint) r3;
        if (this.enable_player_print_stack == r4.enable_player_print_stack) goto L8;
        return false;
    L8:
        if (this.player_stack_depth == r4.player_stack_depth) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r0 = this.enable_player_print_stack;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (r1 * 31) + this.player_stack_depth;
    }

    public String toString() {
        return "LivePlayerStackPrint(enable_player_print_stack=" + this.enable_player_print_stack + ", player_stack_depth=" + this.player_stack_depth + ")";
    }

    public final boolean getEnable_player_print_stack() {
        return this.enable_player_print_stack;
    }

    public final int getPlayer_stack_depth() {
        return this.player_stack_depth;
    }

    public LivePlayerStackPrint(boolean r1, int r2) {
        this.enable_player_print_stack = r1;
        this.player_stack_depth = r2;
    }

    public /* synthetic */ LivePlayerStackPrint(boolean r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 10;
    L8:
        this(r1, r2);
    }
}
