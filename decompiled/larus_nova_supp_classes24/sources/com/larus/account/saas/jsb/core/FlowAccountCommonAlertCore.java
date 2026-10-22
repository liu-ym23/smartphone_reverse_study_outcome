package com.larus.account.saas.jsb.core;

import android.app.Activity;
import com.larus.account.saas.ui.AccountCommonAlertAction;
import com.larus.account.saas.ui.AccountCommonAlertData;
import com.larus.account.saas.ui.IAccountCommonAlertUiService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowAccountCommonAlertCore {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountCommonAlertCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "ACTIVITY_NULL", "NOT_HANDLED", "CANCELLED", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error ACTIVITY_NULL = null;
        public static final Error CANCELLED = null;
        public static final Error NOT_HANDLED = null;
        public static final /* synthetic */ Error[] a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r1) {
            return (Error) r27.a.a(Error.class, r1);
        }

        public static Error[] values() {
            return (Error[]) a.clone();
        }

        static {
            Error r0 = new Error("ACTIVITY_NULL", 0, 1, "activity is null");
            ACTIVITY_NULL = r0;
            Error r1 = new Error("NOT_HANDLED", 1, 2, "activity cannot show common alert");
            NOT_HANDLED = r1;
            Error r2 = new Error("CANCELLED", 2, 3, "cancelled");
            CANCELLED = r2;
            a = new Error[]{r0, r1, r2};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.message = r4;
        }
    }

    public static final class a {
        public final String a;
        public final String b;
        public final Integer c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Action(id=" + this.a + ", title=" + this.b + ", style=" + this.c + ')';
        }

        public a(String r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Integer c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(id=" + this.a + ", title=" + this.b + ", style=" + this.c + ')';
        }

        public b(String r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public static void a(Activity r7, String r8, String r9, List r10, final y38.b r11) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r7 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountCommonAlertCore", "owner activity is null, abort common alert.");
        Error r12 = Error.ACTIVITY_NULL;
        r11.a(new x38.a(r12.getCode(), r12.getMessage(), null));
        return;
    L6:
        ArrayList r2 = new ArrayList();
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L16;
        a r3 = (a) r13.next();
        if (r3 != null) goto L12;
        AccountCommonAlertAction r4 = null;
    L13:
        if (r4 == null) goto L8;
        r2.add(r4);
        goto L8
    L12:
        r4 = new AccountCommonAlertAction(r3.a, r3.b, r3.c);
        goto L13
    L16:
        if (IAccountCommonAlertUiService.b.b(r7, new AccountCommonAlertData(r8, r9, r2), new FlowAccountCommonAlertCore$handle$handled$1(r11), new FlowAccountCommonAlertCore$handle$handled$2(r11)) == true) goto L24;
        com.larus.account.saas.runtime.internal.delegate.a.a.a("FlowAccountCommonAlertCore", "owner activity " + r7 + " cannot show common alert.");
        Error r14 = Error.NOT_HANDLED;
        r11.a(new x38.a(r14.getCode(), r14.getMessage(), null));
        return;
    }
}
