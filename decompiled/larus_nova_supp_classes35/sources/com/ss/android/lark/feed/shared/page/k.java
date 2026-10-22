package com.ss.android.lark.feed.shared.page;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.SwipeDismissItemAnimator;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.ss.android.lark.feed.shared.data.utils.FeedValueHelper;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public final Context a;
    public RecyclerView b;
    public final LarkFeedInBoxListAdapter c;
    public final RecyclerView.Adapter<?> d;
    public final b e;
    public final FeedItemsViewInit$forbiddenScrollItemListener$1 f;
    public r g;
    public final StableLinearLayoutManager h;
    public final p i;
    public final teb.d j;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public final void a(r r2) {
        Intrinsics.checkNotNullParameter(r2, "inboxContainerListener");
        this.g = r2;
        LarkFeedInBoxListAdapter r3 = this.c;
        if (r3 == null) goto L5;
        r3.d = new l();
    L5:
        if (r3 == null) goto L7;
        r3.f = new m(this);
    L7:
        if (r3 == null) goto L9;
        r3.e = new n(this);
    L9:
        if (r3 == null) goto L11;
        r3.g = new o();
    L11:
        com.ss.android.lark.integrator.im.feed_shared.dependency.f r4 = heb.a.a.getFeedDependency();
        p r0 = this.i;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "shortcutStatusListener");
    }

    public final void b(RecyclerView.RecycledViewPool r4) {
        if (r4 != null) goto L4;
        r4 = new RecyclerView.RecycledViewPool();
        r4.setMaxRecycledViews(1, 10);
    L4:
        RecyclerView r0 = this.b;
        if (r0 == null) goto L7;
        r0.setRecycledViewPool(r4);
    L7:
        RecyclerView r5 = this.b;
        if (r5 == null) goto L10;
        r5.setLayoutManager(this.h);
    L10:
        RecyclerView r6 = this.b;
        if (r6 == null) goto L16;
        LarkFeedInBoxListAdapter r1 = this.d;
        if (r1 != null) goto L15;
        r1 = this.c;
    L15:
        r6.setAdapter(r1);
    L16:
        RecyclerView r7 = this.b;
        if (r7 == null) goto L20;
        r7.setItemViewCacheSize(4);
    L20:
        if (((Boolean) FeedValueHelper.h.getValue()).booleanValue() == false) goto L29;
        teb.d r8 = this.j;
        RecyclerView r2 = this.b;
        LarkFeedInBoxListAdapter r3 = this.c;
        r8.b = r2;
        r8.a = r3;     // Catch: Exception -> L24
        RecyclerView.Recycler r9 = (RecyclerView.Recycler) d27.b.b(r2, "mRecycler");     // Catch: Exception -> L24
        r8.c = r9;     // Catch: Exception -> L24
        r8.d = (ArrayList) d27.b.b(r9, "mCachedViews");     // Catch: Exception -> L24
        r2.addOnScrollListener(new teb.b(r8));
        r2.setViewCacheExtension(new teb.c(r8, r2));
    L26:
        LarkFeedInBoxListAdapter r10 = this.c;
        if (r10 == null) goto L29;
        r10.v = this.j;
    L24:
        e = move-exception;
        Log.e("FeedPreBinder", "FeedPreBinder init error.", e);
    L29:
        RecyclerView r11 = this.b;
        if (heb.a.a.getFeatureGatingDependency().isEnable("lark.feed.anim.default") == false) goto L33;
        SwipeDismissItemAnimator r12 = new SwipeDismissItemAnimator();
    L36:
        if (r12 == null) goto L45;
        r12.setSupportsChangeAnimations(false);
        r12.setRemoveDuration(300);
        r11.setItemAnimator(r12);
        if (com.ss.android.lark.feed.shared.page.utils.b.b() == false) goto L44;
        zdc.h.b(r11);
        return;
    L44:
        return;
    L45:
        return;
    L33:
        if ((r11.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L35;
        r12 = (SimpleItemAnimator) r11.getItemAnimator();
        goto L36
    L35:
        r12 = null;
        goto L36
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.lark.feed.shared.page.FeedItemsViewInit$forbiddenScrollItemListener$1] */
    public k(Context r2, FeedRecyclerView r3, LarkFeedInBoxListAdapter r4, RecyclerView.Adapter r5, b r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new FeedItemsViewInit$forbiddenScrollItemListener$1();
        this.h = new StableLinearLayoutManager(r2, 0);
        this.i = new p();
        this.j = new teb.d();
    }
}
