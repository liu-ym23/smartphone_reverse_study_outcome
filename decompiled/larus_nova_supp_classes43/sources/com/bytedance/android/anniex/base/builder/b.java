package com.bytedance.android.anniex.base.builder;

import android.app.Activity;
import com.bytedance.ies.bullet.base.core.common.Components;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends UIComponentBuilder {
    public Activity j;
    public ka.b k;
    public Components l;

    public b() {
        this.l = Components.Fragment;
    }

    public final void d(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.j = r10;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.a = r10;
    }
}
