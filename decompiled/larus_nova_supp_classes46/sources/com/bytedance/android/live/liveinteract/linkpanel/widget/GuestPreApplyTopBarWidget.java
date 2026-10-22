package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.vm.VideoRoomAudiencePreApplyViewModel;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/GuestPreApplyTopBarWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GuestPreApplyTopBarWidget extends LiveWidget {
    public TextView a;
    public TextView b;
    public final a c;
    public final VideoRoomAudiencePreApplyViewModel d;
    public final IRoom e;
    public final String f;
    public final xf0.a g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ GuestPreApplyTopBarWidget a;

        public a(GuestPreApplyTopBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5 != null) goto L5;
            return;
        L5:
            if (r5.intValue() != 0) goto L11;
            TextView r6 = this.a.b;
            if (r6 == null) goto L9;
            r6.setText(s1.B(2131917501));
        L9:
            this.a.xq(null);
            return;
        L11:
            if (r5.intValue() != 1) goto L19;
            DataCenter r7 = ((Widget) this.a).dataCenter;
            if (r7 == null) goto L15;
            r7.put("data_audience_pre_linkmic_waiting", Boolean.TRUE);
        L15:
            TextView r8 = this.a.b;
            if (r8 == null) goto L27;
            r8.setText(s1.B(2131917502));
            return;
        L27:
            return;
        L19:
            if (r5.intValue() != 2) goto L29;
            DataCenter r9 = ((Widget) this.a).dataCenter;
            if (r9 == null) goto L23;
            r9.put("data_audience_pre_linkmic_waiting", Boolean.FALSE);
        L23:
            this.a.g.dismiss();
            return;
        }
    }

    public static final class b<T> implements com.ss.android.ugc.aweme.compat.nullable.Observer {
        public final /* synthetic */ GuestPreApplyTopBarWidget a;

        public b(GuestPreApplyTopBarWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            GuestPreApplyTopBarWidget r0 = this.a;
            r0.xq((a5) r2);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ GuestPreApplyTopBarWidget a;

        public c(GuestPreApplyTopBarWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r0 != null) goto L6;
        L11:
            GuestPreApplyTopBarWidget r4 = this.a;
            VideoRoomAudiencePreApplyViewModel r1 = r4.d;
            if (r1 == null) goto L16;
            r1.cancelPreApply(r4.e);
            return;
        L16:
            return;
        L6:
            if (r0.intValue() != 0) goto L11;
            VideoRoomAudiencePreApplyViewModel r2 = this.a.d;
            if (r2 == null) goto L10;
            r2.checkAndPreApply(r3.getContext(), this.a.e);
        L10:
            this.a.wq();
        }
    }

    public final int getLayoutId() {
        return 2131565483;
    }

    public final void wq() {
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        r0.put("is_approve_needed", "1");
        r0.put("source", "pre_apply");
        r0.put("function_type", "new_audience");
        r0.put("function_type2", "new_audience");
        String r1 = this.f;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        r0.put("request_page", this.f);
    L11:
        Intrinsics.checkNotNullParameter(r0, "logMap");
        j0.l().sendLog("livesdk_guest_connection_apply", r0, new Object[]{IRoom.class, am2.x.class});
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final void onCreate() {
        super.onCreate();
        this.a = (TextView) ((Widget) this).contentView.findViewById(2131391606);
        this.b = (TextView) ((Widget) this).contentView.findViewById(2131390275);
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L6;
    L7:
        hd0.c.f().c(this.c);
    L8:
        VideoRoomAudiencePreApplyViewModel r1 = this.d;
        if (r1 == null) goto L14;
        LiveData<a5> r2 = r1.getWaitingTitleData();
        if (r2 == null) goto L14;
        r2.observe(this, new b(this));
    L14:
        if (hd0.c.f().g() == false) goto L21;
        Context r3 = ((Widget) this).context;
        if (r3 == null) goto L24;
        VideoRoomAudiencePreApplyViewModel r4 = this.d;
        if (r4 == null) goto L20;
        r4.checkAndPreApply(r3, this.e);
    L20:
        wq();
    L24:
        TextView r5 = this.b;
        if (r5 == null) goto L28;
        r5.setOnClickListener(new c(this));
        return;
    L28:
        return;
    L21:
        VideoRoomAudiencePreApplyViewModel r6 = this.d;
        if (r6 == null) goto L24;
        r6.fetchList(this.e, true);
        goto L24
    L6:
        if (r0.intValue() == 2) goto L8;
        goto L7
    }

    public final void onDestroy() {
        super.onDestroy();
        hd0.c.f().e(this.c);
    }

    public final void xq(a5 r4) {
        if (r4 == null) goto L4;
        TextView r0 = this.a;
        if (r0 == null) goto L15;
        r0.setText(sb2.a.h(r4, "", false));
        return;
    L15:
        return;
    L4:
        if (hd0.c.f().g() == false) goto L12;
        TextView r5 = this.a;
        if (r5 == null) goto L13;
        r5.setText(s1.B(2131917503));
        return;
    L13:
        return;
    }

    public GuestPreApplyTopBarWidget(VideoRoomAudiencePreApplyViewModel r2, IRoom r3, String r4, xf0.a r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "guestApply");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.c = new a(this);
    }
}
