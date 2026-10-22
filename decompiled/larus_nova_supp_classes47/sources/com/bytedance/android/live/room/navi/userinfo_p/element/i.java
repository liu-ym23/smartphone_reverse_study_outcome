package com.bytedance.android.live.room.navi.userinfo_p.element;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.x;
import com.bytedance.android.live.room.navi.userinfo_p.presenter.UserInfoTabPresenter;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ UserInfoMiddleElement a;

    public i(UserInfoMiddleElement r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        IFollowPair r8 = (IFollowPair) r7;
        UserInfoTabPresenter r0 = this.a.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r8 != null) goto L7;
    L8:
        if (r8 != null) goto L10;
    L12:
        if (r8 != null) goto L14;
    L16:
        Context r9 = r0.e.getContext();
        if (r9 == null) goto L19;
        String r10 = r9.getString(2131911612, new Object[]{x.b(r0.o)});
    L20:
        if (r10 == null) goto L28;
        TextView r1 = r0.l;
        if (r1 == null) goto L27;
        r1.setText(r10);
        return;
    L27:
        return;
    L28:
        return;
    L19:
        r10 = null;
        goto L20
    L14:
        if (r8.getFollowStatus() != 0) goto L16;
        r0.o--;
        com.bytedance.android.livesdk.interactivity.api.base.b.a r12 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r2 = q.a;
        r12.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.f();
        goto L16
    L10:
        if (r8.getFollowStatus() != 2) goto L12;
    L11:
        r0.o++;
        com.bytedance.android.livesdk.interactivity.api.base.b.a r13 = com.bytedance.android.livesdk.interactivity.api.base.b.m;
        q r3 = q.a;
        r13.getClass();
        com.bytedance.android.livesdk.interactivity.api.base.b.a.b();
        goto L16
    L7:
        if (r8.getFollowStatus() == 1) goto L11;
        goto L8
    }
}
