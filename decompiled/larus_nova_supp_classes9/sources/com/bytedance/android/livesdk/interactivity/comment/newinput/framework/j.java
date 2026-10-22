package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class j {
    public final View a;
    public final g b;

    public j(View r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "bridges");
        this.a = r2;
        this.b = r3;
    }
}
