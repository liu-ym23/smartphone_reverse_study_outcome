package com.bytedance.android.livesdk.interactivity.api.entity;

import android.content.Context;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.r;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public s a;
    public final t b;
    public Context c;
    public final r d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L12;
        l r4 = (l) r3;
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        t r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Context r4 = this.c;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        r r7 = this.d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPSOperatePanelEvent(clickMessage=" + this.b + ", context=" + this.c + ", callback=" + this.d + ")";
    }

    public final Context getContext() {
        return this.c;
    }

    public l(t r2, Context r3, r r4) {
        Intrinsics.checkNotNullParameter(r2, "clickMessage");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        ALogger.d("PSOperatePanel", "create an OpenPSOperatePanelEvent");
    }
}
