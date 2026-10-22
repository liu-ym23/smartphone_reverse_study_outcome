package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater;

import am2.x;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.g3;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements c0.b {
    public Integer a;
    public TextView b;
    public View c;
    public final String d;
    public final CompositeDisposable e;
    public final int f;
    public final int g;
    public final com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d h;
    public final DataCenter i;
    public final Context j;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void Y6() {
        this.i.put("more_pane_watch_later_show_log_send", Boolean.FALSE);
    }

    public final Map<String, String> b() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("from_panel", "more_function_panel");
        Integer r1 = this.a;
        int r2 = this.f;
        if (r1 != null) goto L6;
    L8:
        int r3 = this.g;
        if (r1 != null) goto L12;
    L14:
        String r4 = "";
    L15:
        r0.put("icon_status", r4);
        r0.put("event_page", "live_detail");
        return r0;
    L12:
        if (r1.intValue() != r3) goto L14;
        r4 = "cancel_watch_later";
        goto L15
    L6:
        if (r1.intValue() != r2) goto L8;
        r4 = "watch_later";
        goto L15
    }

    public final Context getContext() {
        return this.j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        u.l().sendLog("livesdk_watch_later_icon_click", b(), new Object[]{Room.class, x.class});
        Integer r11 = this.a;
        int r0 = this.f;
        if (r11 != null) goto L6;
    L8:
        int r1 = this.g;
        if (r11 != null) goto L12;
        return;
    L12:
        if (r11.intValue() != r1) goto L16;
        this.a = Integer.valueOf(this.f);
        long r2 = z.o(this.i).getRoomId();
        String r6 = this.d;
        g.b(new n(r2, "room", new WatchLaterBehavior$requestCancelWatchLater$1(this), this.e, r6));
        return;
    L16:
        return;
    L6:
        if (r11.intValue() != r0) goto L8;
        long r3 = z.o(this.i).getRoomId();
        String r8 = this.d;
        g.a(new n(r3, "room", new WatchLaterBehavior$requestAddWatchLater$1(this), this.e, r8));
    }

    public static final void a(k r2, IWatchLaterData r3) {
        TextView r0 = r2.b;
        if (r0 == null) goto L5;
        r0.setText(r3.getDisplayText());
    L5:
        ImageModel r1 = r3.getIcon();
        if (r1 == null) goto L11;
        List r4 = r1.getUrls();
        if (r4 == null) goto L11;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L11;
    L12:
        RxUtilKt.c(g3.a(r5).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new i(r2)).onErrorComplete().subscribe(new j(r2)), r2.e);
        String r6 = r3.getDrawerButtonText();
        r2.i.put("action_click_panel_watch_later", r6);
        return;
    L11:
        r5 = "";
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e.dispose();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.c = r5.findViewById(2131374718);
        this.b = (TextView) r5.findViewById(2131380593);
        Boolean r7 = (Boolean) this.i.get("more_pane_watch_later_show_log_send", Boolean.FALSE);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.d r8 = this.h;
        if (r8 == null) goto L5;
        boolean r9 = r8.isRequesting();
    L7:
        if (r7.booleanValue() == true) goto L11;
        if (r9 == true) goto L12;
        this.i.put("more_pane_watch_later_show_log_send", Boolean.TRUE);
        u.l().sendLog("livesdk_watch_later_icon_show", b(), new Object[]{Room.class, x.class});
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r9 = true;
        goto L7
    }

    public k(s r2, DataCenter r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.i = r3;
        this.j = r4;
        String r5 = r2.o;
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(s2.a(r5).optInt("status"));
    L6:
        this.a = r6;
        this.d = "WatchLaterBehavior";
        this.e = new CompositeDisposable();
        this.f = 1;
        this.g = 2;
        MorePanelDynamicControllerViewModel.Companion.getClass();
        this.h = MorePanelDynamicControllerViewModel.Companion.a(r3);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
