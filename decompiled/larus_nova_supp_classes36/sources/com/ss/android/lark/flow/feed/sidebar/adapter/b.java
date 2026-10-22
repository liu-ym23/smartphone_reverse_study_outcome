package com.ss.android.lark.flow.feed.sidebar.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.shared.page.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final Context a;
    public final FeedSidebarAdapter b;
    public r c;
    public final StableLinearLayoutManager d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public b(Context r1, RecyclerView r2, FeedSidebarAdapter r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.a = r1;
        this.b = r3;
        this.d = new StableLinearLayoutManager(r1, 0);
    }
}
