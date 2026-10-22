package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.impl.LinkMultiControlWidget;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ LinkUserFollowGuideDialog a;

    public t(LinkUserFollowGuideDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        IFollowPair r5 = (IFollowPair) r4;
        LinkUserFollowGuideDialog r6 = this.a;
        gd0.u r0 = r6.f;
        Object[] r1 = new Object[1];
        String r7 = r6.a;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("identityText");
    L5:
        r1[0] = r7;
        String r8 = s1.C(2131917621, r1);
        ((LinkMultiControlWidget.a) r0).getClass();
        f2.c(r8, 0);
    }
}
