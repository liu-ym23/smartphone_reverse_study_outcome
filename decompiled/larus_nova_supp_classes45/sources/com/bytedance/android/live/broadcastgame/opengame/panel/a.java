package com.bytedance.android.live.broadcastgame.opengame.panel;

import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<R> {
    public final int a;
    public final BaseOpenMethod<R> b;
    public final Function1<JSONObject, Unit> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        BaseOpenMethod<R> r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Function1<JSONObject, Unit> r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "DoubleBallLoadingEvent(visibility=" + this.a + ", callMethod=" + this.b + ", returnCallWithResult=" + this.c + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r2, BaseOpenMethod<R> r3, Function1<? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "callMethod");
        Intrinsics.checkNotNullParameter(r4, "returnCallWithResult");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
