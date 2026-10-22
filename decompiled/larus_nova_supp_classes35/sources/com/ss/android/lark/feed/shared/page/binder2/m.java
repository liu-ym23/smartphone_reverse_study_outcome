package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ FeedExpiredFoldHintViewHolder a;

    public m(FeedExpiredFoldHintViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.b.setVisibility(8);
        com.ss.android.lark.feed.shared.hitpoint.a.c(true);
        com.ss.android.lark.integrator.im.feed_shared.dependency.f r3 = heb.a.a.getFeedDependency();
        FeedFolder r0 = FeedFolderCompat.INSTANCE.getEXPIRED_FOLD();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "feedFilter");
        LarkFeedInBoxListAdapter.D2(((teb.g) this.a.a).a);
    }
}
