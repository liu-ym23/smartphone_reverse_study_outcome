package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserRequest;
import io.reactivex.subjects.BehaviorSubject;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final f a;
    public final LinkedList<b> b;

    public static final class a {
    }

    public static final class b {
        public final UpdateUserRequest a;
        public final BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> b;
        public final com.ss.android.lark.passportc.api.d c;
        public final lzb.a d;
        public final List<BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c>> e;

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
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "UpdateUserRequestPayload(updateRequest=" + this.a + ", updateSubject=" + this.b + ", executeMode=" + this.c + ", actionContext=" + this.d + ", mergedSubjects=" + this.e + ')';
        }

        public b(UpdateUserRequest r2, BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c> r3, com.ss.android.lark.passportc.api.d r4, lzb.a r5, List<BehaviorSubject<com.ss.android.lark.passportc.impl.v2.entity.c>> r6) {
            Intrinsics.checkNotNullParameter(r2, "updateRequest");
            Intrinsics.checkNotNullParameter(r3, "updateSubject");
            Intrinsics.checkNotNullParameter(r4, "executeMode");
            Intrinsics.checkNotNullParameter(r5, "actionContext");
            Intrinsics.checkNotNullParameter(r6, "mergedSubjects");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    static {
    }

    public c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "backgroundUserService");
        this.a = r2;
        this.b = new LinkedList();
    }
}
