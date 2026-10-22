package com.ss.android.lark.feed.shared.page;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.shared.hitpoint.FeedHitPointNew;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ FeedItemsFragment a;
    public final /* synthetic */ FeedFolder b;

    public h(FeedItemsFragment r1, FeedFolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        peb.b r4 = heb.a.a;
        com.ss.android.lark.integrator.im.feed_shared.dependency.f r5 = heb.a.a.getFeedDependency();
        FragmentActivity r6 = this.a.requireActivity();
        FeedFolder r0 = this.b;
        if (r0 == null) goto L5;
        r0.getId();
    L5:
        UserSession r1 = PassportcConvention.b(this.a);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r1, "userSession");
        com.ss.android.lark.feed.shared.hitpoint.a.b(true);
        FeedHitPointNew.a(FeedHitPointNew.FeedDelayedPopupClickParam.OPEN);
    }
}
