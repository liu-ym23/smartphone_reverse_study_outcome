package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import am2.x;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.android.live.core.setting.q4;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.ProfileViewData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import u32.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements n {
    public final /* synthetic */ UserInfoTabPresenter a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ ProfileViewData c;

    public final boolean a() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b() {
        n81.a.b("onAppointmentHide");
        Disposable r0 = this.a.t;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.a.t = null;
    }

    public final long d() {
        ProfileViewData r0 = this.c;
        if (r0 == null) goto L5;
        long r3 = r0.getShowDuration();
    L7:
        if (r3 <= 0) goto L9;
        return r3;
    L9:
        int r1 = n81.a.a;
        return ((Long) q4.a.getValue()).longValue();
    L5:
        r3 = 0;
        goto L7
    }

    public final void g() {
        n81.a.b("onAppointmentShow");
        this.a.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("show_page", "live_open_top_left_anchor");
        r0.put("is_anchor", DataType.FALSE);
        j0.l().sendLog("livesdk_live_announce_card_show", r0, new Object[]{x.class, Room.class});
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.a.a(), 0, 2);
        if (r1 == null) goto L6;
        r1.getRoomTabAppointmentShowed().setValue(Boolean.TRUE);
        return;
    }

    public final TextView e() {
        return this.b;
    }

    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "labelType");
        this.a.e.b().getMiddleVm().isAppointmentShowing().setValue(Boolean.valueOf(Intrinsics.areEqual(r3, "appointment")));
    }

    public final void c(TextView r2, SpannableString r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (r2 != null) goto L5;
        return;
    L5:
        UserInfoTabPresenter.i(this.a, r2, r3);
    }

    public d(UserInfoTabPresenter r1, TextView r2, ProfileViewData r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
