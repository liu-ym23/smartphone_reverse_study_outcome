package com.larksuite.component.blockit.hashtag.list;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends OnSingleClickListener {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.b.a();
    }
}
