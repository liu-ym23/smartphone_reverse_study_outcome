package com.ss.android.lark.feed.shared.page;

import androidx.lifecycle.Observer;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ FeedItemsFragment a;

    public f(FeedItemsFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        FeedFolder r5 = (FeedFolder) r4;
        FeedFolder r0 = this.a.s;
        FeedFolder r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r5, r0) == false) goto L12;
        this.a.W90().foregroundFilterChanged();
        StringBuilder r6 = new StringBuilder();
        r6.append(this.a);
        r6.append(" foregroundFilterChanged, filter=");
        FeedFolder r2 = this.a.s;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("feedFilter");
    L11:
        r6.append(r1);
        Log.i("FeedSharedModule_FeedItemsFragment", r6.toString());
        return;
    L10:
        r1 = r2;
        goto L11
    L12:
        efb.a r7 = this.a.z;
        if (r7 == null) goto L17;
        ((ArrayList) r7.c).clear();
        return;
    }
}
