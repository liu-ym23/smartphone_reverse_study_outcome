package bp1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.e5;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.action.l;
import com.bytedance.android.livesdk.dislike.m;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ DataCenter b;

    public g(d r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        String r13 = this.a.getType();
        int r0 = a.h;
        Room r1 = null;
        if (Intrinsics.areEqual(r13, "to_user") == false) goto L36;
        d r14 = this.a;
        Object r2 = r14.d;
        if ((r2 instanceof com.bytedance.android.live.base.model.user.f) == true) goto L7;
        r2 = null;
    L7:
        com.bytedance.android.live.base.model.user.f r3 = (com.bytedance.android.live.base.model.user.f) r2;
        i r15 = r14.h;
        if (r15 == null) goto L28;
        String r16 = r15.b;
        if (r16 == null) goto L28;
        if (r16.length() <= 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 != true) goto L28;
        if (r3 == null) goto L22;
        i r18 = this.a.h;
        if (r18 == null) goto L20;
        String r19 = r18.b;
    L21:
        r3.b = r19;
        goto L22
    L20:
        r19 = null;
    L22:
        if (r3 == null) goto L28;
        i r110 = this.a.h;
        if (r110 == null) goto L26;
        String r111 = r110.a;
    L27:
        r3.a = r111;
        goto L28
    L26:
        r111 = null;
        goto L27
    L14:
        r17 = false;
    L28:
        if (r3 == null) goto L50;
        m r4 = null;
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L34;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();
        if (r6 == null) goto L34;
        r1 = (Room) r6.getValue();
    L34:
        new l(new ActionsManager(r4, r1, "", null, null, 56), r3).g(true, "chat_merge");
    L50:
        DataCenter r112 = this.b;
        if (r112 == null) goto L54;
        r112.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
        return;
    L54:
        return;
    L36:
        if (Intrinsics.areEqual(this.a.getType(), "host_share_dialog") == false) goto L43;
        c0.b r113 = y3.f(this.b).t(ToolbarButton.SHARE);
        if ((r113 instanceof e5) == true) goto L40;
        r113 = null;
    L40:
        e5 r114 = (e5) r113;
        if (r114 == null) goto L50;
        r114.o = "ext_more";
        r114.onClick(null);
        r114.o = "";
        goto L50
    L43:
        Room r115 = y3.f(this.b).t(ToolbarButton.SHARE);
        if ((r115 instanceof e5) == false) goto L47;
        r1 = r115;
    L47:
        e5 r7 = (e5) r1;
        if (r7 == null) goto L50;
        r7.f(this.a, false, null, false, false);
        goto L50
    }
}
