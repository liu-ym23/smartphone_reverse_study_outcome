package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends c {
    public final View a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((d) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        View r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "LandscapeBannerViewHolder(activityIndicator=" + this.a + ")";
    }

    public d(View r1) {
        this.a = r1;
    }
}
