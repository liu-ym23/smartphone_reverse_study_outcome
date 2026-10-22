package com.bytedance.android.live.profit.taskcenter.panel.model;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profit.taskcenter.b;
import fv0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class PanelInfo {
    public final PropertyOwner<State> a;
    public final PropertyOwner b;
    public final Context c;
    public final Uri d;
    public final Bundle e;
    public final int f;
    public final a g;
    public final boolean h;
    public final b i;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/taskcenter/panel/model/PanelInfo$State;", "", "target", "", "isAtLeast", "", "value", "I", "getValue", "()I", "WAITING", "READY", "SHOWING", "DISMISSED", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum State extends Enum<State> {
        public static final State DISMISSED = null;
        public static final State READY = null;
        public static final State SHOWING = null;
        public static final State WAITING = null;
        public static final /* synthetic */ State[] a = null;
        private final int value;

        static {
            State r1 = new State("WAITING", 0, 0);
            WAITING = r1;
            State r2 = new State("READY", 1, 1);
            READY = r2;
            State r3 = new State("SHOWING", 2, 2);
            SHOWING = r3;
            State r4 = new State("DISMISSED", 3, 3);
            DISMISSED = r4;
            a = new State[]{r1, r2, r3, r4};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public final boolean isAtLeast(State r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            if (this.value < r2.value) goto L5;
            return true;
        L5:
            return false;
        }

        public State(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PanelInfo) == false) goto L20;
        PanelInfo r4 = (PanelInfo) r3;
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L12;
        return false;
    L12:
        if (this.f == r4.f) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L16;
        return false;
    L16:
        if (this.h == r4.h) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17 */
    public final int hashCode() {
        Context r0 = this.c;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Uri r4 = this.d;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Bundle r7 = this.e;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (((r6 + r8) * 31) + this.f) * 31;
        a r10 = this.g;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        boolean r14 = this.h;
        ?? r15 = r14;
        if (r14 == false) goto L21;
        r15 = 1;
    L21:
        int r16 = (r13 + r15) * 31;
        b r17 = this.i;
        if (r17 == null) goto L25;
        r1 = r17.hashCode();
    L25:
        return r16 + r1;
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PanelInfo(context=" + this.c + ", uri=" + this.d + ", bundle=" + this.e + ", priorityLevel=" + this.f + ", frequencyParams=" + this.g + ", needCheckDialogAndTip=" + this.h + ", callback=" + this.i + ")";
    }

    public final Context getContext() {
        return this.c;
    }

    public final void a(State r3, DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r3, "target");
        ALogger.i("TaskPanelManager", "PanelInfo  moveToState  target=" + r3 + "  dialog=" + r4);
        if (((State) this.a.a).isAtLeast(r3) == false) goto L5;
        return;
    L5:
        this.a.a(r3);
        int r5 = fv0.b.a[r3.ordinal()];
        if (r5 != 1) goto L8;
        this.i.waiting();
        return;
    L8:
        if (r5 != 2) goto L10;
        this.i.readyToShow();
        return;
    L10:
        if (r5 != 3) goto L12;
        this.i.showing(r4);
        return;
    L12:
        if (r5 != 4) goto L22;
        this.i.onDismiss(r4);
        return;
    }

    public PanelInfo(Context r2, Uri r3, Bundle r4, int r5, a r6, b r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "bundle");
        Intrinsics.checkNotNullParameter(r6, "frequencyParams");
        Intrinsics.checkNotNullParameter(r7, "callback");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = false;
        this.i = r7;
        PropertyOwner<State> r8 = new PropertyOwner(State.WAITING);
        this.a = r8;
        this.b = r8;
    }
}
