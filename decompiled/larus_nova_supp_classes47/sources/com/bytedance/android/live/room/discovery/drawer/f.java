package com.bytedance.android.live.room.discovery.drawer;

import android.os.SystemClock;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ NewLiveDrawerEntranceWidget a;

    public f(NewLiveDrawerEntranceWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        BaseResponse r10 = (BaseResponse) r9;
        Extra r0 = r10.extra;
        if (r0 != null) goto L5;
    L42:
        NewLiveDrawerEntranceWidget r12 = this.a;
        List<String> r1 = NewLiveDrawerEntranceWidget.y;
        r12.Iq();
        return;
    L5:
        if (((h) r0).getTotal() <= 0) goto L42;
        if (r10.data == null) goto L42;
        NewLiveDrawerEntranceWidget r2 = this.a;
        int r3 = ((h) r10.extra).getTotal();
        Room r13 = (Room) r10.data;
        long r4 = this.a.b;
        if (r2.Eq() == false) goto L13;
        View r5 = r2.f;
        if (r5 == null) goto L16;
        r5.setVisibility(8);
    L16:
        TextView r6 = r2.d;
        if (r6 == null) goto L19;
        r6.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L19:
        TextView r7 = r2.d;
        if (r7 == null) goto L22;
        r7.setMarqueeRepeatLimit(-1);
    L22:
        TextView r8 = r2.d;
        if (r8 == null) goto L25;
        r8.setFilters(new InputFilter[0]);
    L25:
        TextView r14 = r2.d;
        if (r14 == null) goto L28;
        r14.setMaxWidth(s1.f(52.0f));
    L28:
        TextView r15 = r2.d;
        if (r15 == null) goto L31;
        r15.requestFocusFromTouch();
    L31:
        UIUtils.setText(r2.d, s1.C(2131911635, new Object[]{Integer.valueOf(r3)}));
        SimpleDraweeView r16 = r2.g;
        User r17 = r13.getOwner();
        if (r17 == null) goto L34;
        ImageModel r18 = r17.getAvatarThumb();
    L35:
        ImageLoader.bindImage(r16, r18);
        com.bytedance.android.live.core.view.a r19 = r2.o;
        if (r19 == null) goto L38;
        r19.d();
    L38:
        r2.n = true;
        DataCenter r20 = ((Widget) r2).dataCenter;
        if (r20 == null) goto L41;
        r20.put("data_more_entrance_follow", Boolean.TRUE);
    L41:
        com.bytedance.android.livesdk.sharedpref.e r22 = com.bytedance.android.livesdk.sharedpref.b.C2;
        Long r23 = Long.valueOf(SystemClock.elapsedRealtime());
        r22.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r22, r23);
        r2.m.removeMessages(1);
        r2.m.sendEmptyMessageDelayed(1, r4);
        goto L42
    L34:
        r18 = null;
        goto L35
    L13:
        View r24 = r2.f;
        if (r24 == null) goto L16;
        r24.setVisibility(0);
        goto L16
    }
}
