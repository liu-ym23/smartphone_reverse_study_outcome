package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble;

import am2.x;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubbleManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.MorePanelButtonLogNameHelper;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BubbleController a;
    public final /* synthetic */ i b;

    public b(BubbleController r1, i r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        ToolbarBubbleManager.BubbleInfo.State r8 = (ToolbarBubbleManager.BubbleInfo.State) r7;
        Intrinsics.checkNotNullParameter(r8, "state");
        if (r8 != ToolbarBubbleManager.BubbleInfo.State.SHOWING) goto L30;
        BubbleController r9 = this.a;
        i r0 = this.b;
        g.b r1 = r9.e.a().query(r0.getId());
        if (r1 != null) goto L7;
        r1 = new g.b(r0.getId(), r0.a().getId());
    L7:
        r1.j();
        r9.e.a().e(r1);
        r9.e.a().f(r1);
        i.a r2 = r0.getCallback();
        if (r2 == null) goto L10;
        r2.c(r0);
    L10:
        MorePanelButtonLogNameHelper r3 = MorePanelButtonLogNameHelper.b;
        DataCenter r4 = r9.e.c;
        ExtendedToolbarButton.a r5 = ExtendedToolbarButton.h;
        ToolbarButton r6 = r0.a();
        r5.getClass();
        ExtendedToolbarButton.b r10 = ExtendedToolbarButton.a.a(r6);
        r3.getClass();
        String r11 = MorePanelButtonLogNameHelper.a(r4, r10);
        String r12 = "";
        if (r11 != null) goto L13;
        r11 = "";
    L13:
        com.bytedance.android.livesdk.log.g r13 = u.l();
        Pair[] r14 = new Pair[3];
        DataCenter r15 = r9.e.c;
        if (r15 == null) goto L19;
        Room r16 = z.o(r15);
        if (r16 == null) goto L19;
        String r17 = r16.getOwnerUserIdString();
        if (r17 == null) goto L19;
    L20:
        r14[0] = TuplesKt.to("anchor_id", r17);
        DataCenter r18 = r9.e.c;
        if (r18 == null) goto L28;
        Room r19 = z.o(r18);
        if (r19 == null) goto L28;
        String r20 = r19.getIdStr();
        if (r20 == null) goto L28;
        r12 = r20;
    L28:
        r14[1] = TuplesKt.to("room_id", r12);
        r14[2] = TuplesKt.to("bubble_type", r11);
        r13.sendLog("livesdk_guide_bubble_show", MapsKt.mapOf(r14), new Object[]{Room.class, x.class});
        return;
    L19:
        r17 = "";
        goto L20
    }
}
