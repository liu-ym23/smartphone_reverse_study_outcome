package com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ MultiAnchorLinkUserInviteDialog a;

    public j(MultiAnchorLinkUserInviteDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        l8 r6 = (l8) r5;
        if (this.a.isViewValid() == false) goto L24;
        if (r6 == null) goto L25;
        String r0 = r6.getContent();
        py.k r7 = r6.getBackgroundImage();
        if (r0 != null) goto L10;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        ((TextView) this.a.S90(2131391355)).setText(r0);
    L17:
        if (r7 != null) goto L19;
        return;
    L19:
        if (r7.isValid() != true) goto L23;
        MultiAnchorLinkUserInviteDialog r1 = this.a;
        r1.j = true;
        View r3 = r1.S90(2131385286);
        ((ObservableSubscribeProxy) a1.k(r7).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r1))).subscribe(new v(r3), w.a);
        ((TextView) this.a.S90(2131391355)).setTextColor(ColorProtector.parseColor("#809C4800"));
        ((ImageView) this.a.S90(2131376580)).setImageDrawable(s1.m(2131251336));
        return;
    L23:
        return;
    L10:
        if (r0.length() == 0) goto L13;
        r2 = false;
        goto L15
    L25:
        return;
    }
}
