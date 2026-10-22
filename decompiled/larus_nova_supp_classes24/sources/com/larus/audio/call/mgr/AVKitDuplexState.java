package com.larus.audio.call.mgr;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitDuplexState;", "", "upState", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "downState", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "<init>", "(Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;)V", "getUpState", "()Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "getDownState", "()Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "toSimpleString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "UpState", "DownState", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AVKitDuplexState {
    public static final int $stable = 0;
    private final DownState downState;
    private final UpState upState;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "toSimpleString", "", "Active", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface DownState {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState$Active;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public interface Active extends DownState {
        }

        public static final class a {
            public static String a(DownState r0) {
                String r1 = Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName();
                if (r1 != null) goto L6;
                return "";
            L6:
                return r1;
            }
        }

        StateTriggerEvent getTriggerBy();

        String toSimpleString();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "", "triggerBy", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "getTriggerBy", "()Lcom/larus/audio/call/mgr/StateTriggerEvent;", "toSimpleString", "", "Active", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface UpState {

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState$Active;", "Lcom/larus/audio/call/mgr/AVKitDuplexState$UpState;", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public interface Active extends UpState {
        }

        StateTriggerEvent getTriggerBy();

        String toSimpleString();
    }

    public static /* synthetic */ AVKitDuplexState copy$default(AVKitDuplexState r0, UpState r1, DownState r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.upState;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.downState;
    L9:
        return r0.copy(r1, r2);
    }

    public final UpState component1() {
        return this.upState;
    }

    public final DownState component2() {
        return this.downState;
    }

    public final AVKitDuplexState copy(UpState r2, DownState r3) {
        Intrinsics.checkNotNullParameter(r2, "upState");
        Intrinsics.checkNotNullParameter(r3, "downState");
        return new AVKitDuplexState(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AVKitDuplexState) == true) goto L8;
        return false;
    L8:
        AVKitDuplexState r6 = (AVKitDuplexState) r5;
        if (Intrinsics.areEqual(this.upState, r6.upState) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downState, r6.downState) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.upState.hashCode() * 31) + this.downState.hashCode();
    }

    public String toString() {
        return "AVKitDuplexState(upState=" + this.upState + ", downState=" + this.downState + ')';
    }

    public final String toSimpleString() {
        return "up:[" + this.upState.toSimpleString() + "]-down:[" + this.downState.toSimpleString() + ']';
    }

    public final DownState getDownState() {
        return this.downState;
    }

    public final UpState getUpState() {
        return this.upState;
    }

    public AVKitDuplexState(UpState r2, DownState r3) {
        Intrinsics.checkNotNullParameter(r2, "upState");
        Intrinsics.checkNotNullParameter(r3, "downState");
        this.upState = r2;
        this.downState = r3;
    }
}
