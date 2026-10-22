package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdkapi.depend.model.live.ILLPanelWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IWatchLaterData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d0 extends OptionAction {
    public int e;
    public TextView f;
    public ImageView g;
    public final String h;
    public final int i;
    public final int j;
    public final ActionsManager k;

    public final Map<String, String> h() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("from_panel", "long_press_panel");
        int r1 = this.e;
        if (r1 != this.i) goto L6;
        String r2 = "watch_later";
    L9:
        r0.put("icon_status", r2);
        r0.put("event_page", "live_detail");
        return r0;
    L6:
        if (r1 != this.j) goto L8;
        r2 = "cancel_watch_later";
        goto L9
    L8:
        r2 = "";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r12) {
        Intrinsics.checkNotNullParameter(r12, "v");
        if (this.f != null) goto L6;
        this.f = (TextView) r12.findViewById(2131368819);
    L6:
        if (this.g != null) goto L8;
        this.g = (ImageView) r12.findViewById(2131374718);
    L8:
        int r13 = this.e;
        int r0 = this.i;
        long r1 = 0;
        if (r13 != r0) goto L15;
        Room r2 = this.b;
        if (r2 == null) goto L13;
        r1 = r2.getRoomId();
    L13:
        String r9 = this.h;
        CompositeDisposable r8 = (CompositeDisposable) this.c.getValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.g.a(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.n(r1, "room_press", new WatchLaterAction$requestAddWatchLater$1(this), r8, r9));
        return;
    L15:
        if (r13 != this.j) goto L22;
        this.e = r0;
        Room r3 = this.b;
        if (r3 == null) goto L19;
        r1 = r3.getRoomId();
    L19:
        String r10 = this.h;
        CompositeDisposable r11 = (CompositeDisposable) this.c.getValue();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.g.b(new com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.watchlater.n(r1, "room_press", new WatchLaterAction$requestCancelWatchLater$1(this), r11, r10));
        return;
    }

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void b(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r0 = ILoginGuideService.a.a();
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watch_later_icon_click", h(), new Object[]{Room.class, am2.x.class});
        a(r7);
        return;
    L5:
        if (r0.intercept(new q61.c(new q61.b.a(cz.c.r.c))) != true) goto L7;
    }

    public d0(ActionsManager r5, ILLPanelWidget r6) {
        Intrinsics.checkNotNullParameter(r5, "actionsManager");
        Intrinsics.checkNotNullParameter(r6, "widget");
        super(r5);
        this.k = r5;
        this.e = r6.getId();
        this.h = "WatchLaterAction";
        this.i = 1;
        this.j = 2;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watch_later_icon_show", h(), new Object[]{Room.class, am2.x.class});
    }

    public static final void g(d0 r3, IWatchLaterData r4) {
        TextView r0 = r3.f;
        if (r0 == null) goto L5;
        r0.setText(r4.getDisplayText());
    L5:
        ImageModel r1 = r4.getIcon();
        if (r1 == null) goto L8;
        ImageUtil.loadImage(r3.g, r1, 0);
    L8:
        String r5 = r4.getDrawerButtonText();
        DataCenter r6 = r3.k.f;
        if (r6 == null) goto L12;
        r6.put("action_click_panel_watch_later", r5);
        return;
    }
}
