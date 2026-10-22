package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;
    public final View.OnClickListener b;

    public c(a r3) {
        Intrinsics.checkNotNullParameter("扫描", "title");
        Intrinsics.checkNotNullParameter(r3, "onItemClickListener");
        this.a = "";
        this.a = "扫描";
        this.b = r3;
    }
}
