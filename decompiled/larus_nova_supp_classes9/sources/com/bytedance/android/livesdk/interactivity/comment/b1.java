package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1 implements Consumer<za2.a> {
    public final /* synthetic */ CommentWidget a;

    public b1(CommentWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r13) throws Exception {
        za2.a r14 = (za2.a) r13;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L5;
    L7:
        CommentWidget r0 = this.a;
        DataCenter r2 = ((Widget) r0).dataCenter;
        Room r1 = r0.r;
        if (r1 != null) goto L10;
    L16:
        String r4 = r14.mRequestSource;
        if (r14.mTargetType != 0) goto L19;
        boolean r5 = true;
    L20:
        u22.m.a r3 = new u22.m.a(r4, r5, r14.mUserId, 3, r14.mUserName, 0, null);
        u22.m r6 = new u22.m(r14.mUserName);
        r6.l = OpenInputSource.AtUserEvent;
        r6.e = r3;
        xs2.b.a().post(r6);
        r2.put("cmd_wanna_send_message", r6);
        return;
    L19:
        r5 = false;
        goto L20
    L10:
        if (r1.getOrientation() != 2) goto L16;
        if (r2.get("data_is_portrait") == null) goto L16;
        if (((Boolean) r2.get("data_is_portrait")).booleanValue() == true) goto L16;
        return;
    L5:
        if (this.a.isScreenPortrait() == true) goto L7;
        f2.b(2131915052, 0);
    }
}
