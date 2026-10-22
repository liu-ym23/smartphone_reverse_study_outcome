package com.bytedance.android.live.room.discovery.drawer.template;

import android.os.SystemClock;
import android.view.View;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.room.discovery.drawer.h;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveDrawerEntranceCommonWidget a;

    public d(LiveDrawerEntranceCommonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        BaseResponse r10 = (BaseResponse) r9;
        Extra r0 = r10.extra;
        if (r0 != null) goto L5;
    L39:
        LiveDrawerEntranceCommonWidget r12 = this.a;
        List<String> r1 = LiveDrawerEntranceCommonWidget.G;
        r12.Gq();
        return;
    L5:
        if (((h) r0).getTotal() <= 0) goto L39;
        if (r10.data == null) goto L39;
        LiveDrawerEntranceCommonWidget r2 = this.a;
        int r3 = ((h) r10.extra).getTotal();
        Room r13 = (Room) r10.data;
        long r4 = this.a.p;
        r2.n = true;
        if (r2.Cq() == false) goto L19;
        View r5 = r2.h;
        if (r5 == null) goto L13;
        r5.setVisibility(8);
    L13:
        SimpleDraweeView r6 = r2.c;
        if (r6 == null) goto L16;
        r6.setVisibility(8);
    L16:
        View r7 = r2.g;
        if (r7 == null) goto L28;
        r7.setPadding(s1.f(11.0f), 0, 0, 0);
    L28:
        r2.Lq(52.0f);
        UIUtils.setText(r2.f, s1.C(2131911635, new Object[]{Integer.valueOf(r3)}));
        SimpleDraweeView r8 = r2.i;
        User r14 = r13.getOwner();
        if (r14 == null) goto L31;
        ImageModel r15 = r14.getAvatarThumb();
    L32:
        ImageLoader.bindImage(r8, r15);
        com.bytedance.android.live.core.view.a r16 = r2.l;
        if (r16 == null) goto L35;
        r16.d();
    L35:
        DataCenter r17 = ((Widget) r2).dataCenter;
        if (r17 == null) goto L38;
        r17.put("data_more_entrance_follow", Boolean.valueOf(r2.n));
    L38:
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.b.C2;
        Long r19 = Long.valueOf(SystemClock.elapsedRealtime());
        r18.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
        r2.q.removeMessages(1);
        r2.q.sendEmptyMessageDelayed(1, r4);
        goto L39
    L31:
        r15 = null;
        goto L32
    L19:
        View r20 = r2.h;
        if (r20 == null) goto L22;
        r20.setVisibility(0);
    L22:
        SimpleDraweeView r22 = r2.c;
        if (r22 == null) goto L25;
        r22.setVisibility(0);
    L25:
        View r23 = r2.g;
        if (r23 == null) goto L28;
        r23.setPadding(0, 0, 0, 0);
        goto L28
    }
}
