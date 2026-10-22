package com.ss.android.lark.passport.flow.mfa;

import android.app.Activity;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m {
    public final Activity a;
    public final FlowMfaFlowSession b;
    public final FlowStep c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "FlowMfaRouterContext(activity=" + this.a + ", session=" + this.b + ", step=" + this.c + ')';
    }

    public final Activity getActivity() {
        return this.a;
    }

    public m(Activity r2, FlowMfaFlowSession r3, FlowStep r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r4, "step");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
