package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.e1;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements Observer<FollowPair> {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;
    public final /* synthetic */ User b;

    public final void onComplete() {
    }

    public final void onError(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if (this.a.isViewValid() == true) goto L5;
        return;
    L5:
        CommonMergeAnchorInfoWidget r0 = this.a;
        int r1 = CommonMergeAnchorInfoWidget.x;
        UIUtils.setViewVisibility(r0.h, 0);
        ProgressBar r2 = this.a.i;
        if (r2 == null) goto L8;
        r2.setVisibility(8);
    L8:
        ExceptionUtils.handleException(((Widget) this.a).context, r3);
    }

    public final void onNext(Object r2) {
        FollowPair r3 = (FollowPair) r2;
        Intrinsics.checkNotNullParameter(r3, "pair");
        CommonMergeAnchorInfoWidget.Cq(this.a, r3);
        FragmentActivity r4 = this.a.q;
        User r0 = this.b;
        if (r0 == null) goto L5;
        String r1 = r0.getIdStr();
    L6:
        e1.a(r4, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
        this.a.l.add(r2);
    }

    public n(CommonMergeAnchorInfoWidget r1, User r2) {
        this.a = r1;
        this.b = r2;
    }
}
