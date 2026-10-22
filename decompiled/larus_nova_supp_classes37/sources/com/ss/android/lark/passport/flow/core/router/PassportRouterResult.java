package com.ss.android.lark.passport.flow.core.router;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportRouterResult {
    public final Status a;
    public final String b;
    public final String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/flow/core/router/PassportRouterResult$Status;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_NEXT_STEP", "TERMINAL", "DISPATCHED", "UNSUPPORTED", "flow-passport-core_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final enum Status extends Enum<Status> {
        public static final Status DISPATCHED = null;
        public static final Status INVALID_NEXT_STEP = null;
        public static final Status TERMINAL = null;
        public static final Status UNSUPPORTED = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("INVALID_NEXT_STEP", 0);
            INVALID_NEXT_STEP = r0;
            Status r1 = new Status("TERMINAL", 1);
            TERMINAL = r1;
            Status r3 = new Status("DISPATCHED", 2);
            DISPATCHED = r3;
            Status r5 = new Status("UNSUPPORTED", 3);
            UNSUPPORTED = r5;
            Status[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PassportRouterResult) == true) goto L8;
        return false;
    L8:
        PassportRouterResult r6 = (PassportRouterResult) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PassportRouterResult(status=" + this.a + ", nextStep=" + this.b + ", actionName=" + this.c + ')';
    }

    public final boolean a() {
        Status r0 = this.a;
        if (r0 != Status.TERMINAL) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Status.DISPATCHED) goto L8;
        return false;
    }

    public PassportRouterResult(Status r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
