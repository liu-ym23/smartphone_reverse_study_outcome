package com.bytedance.android.livesdk.chatroom.ui.setting;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveRoomCommentSettingItem extends mx.l {
    public static final /* synthetic */ int q = 0;
    public final DataCenter p;

    public LiveRoomCommentSettingItem(DataCenter r10) {
        super(s1.B(2131919669), null, ((Boolean) com.bytedance.android.livesdk.sharedpref.b.G1.getValue()).booleanValue(), false, false, null, 122);
        this.p = r10;
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, r10, 0, 2);
        if (r11 == null) goto L10;
        com.bytedance.live.datacontext.m r12 = r11.getRoom();
        if (r12 == null) goto L11;
        Room r13 = (Room) r12.getValue();
        if (r13 == null) goto L12;
        g(r13, ((mx.a) this).g);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void c(SwitchSettingViewHolder r13, final boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r13, "holder");
        ((mx.l) this).l = r14;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.p, 0, 2);
        FragmentActivity r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L7;
        final Room r3 = (Room) r2.getValue();
    L8:
        if (r3 != null) goto L11;
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.G1;
        Boolean r16 = Boolean.valueOf(r14);
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
        return;
    L11:
        FragmentActivity r17 = s2.a(((RecyclerView.ViewHolder) r13).itemView.getContext());
        if ((r17 instanceof FragmentActivity) == false) goto L15;
        r1 = r17;
    L15:
        FragmentActivity r5 = r1;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r14 == false) goto L20;
        int r6 = 1;
    L21:
        int r18 = a0.a;
        a0.b(r5, r6, 0, r3.id, new LiveRoomCommentSettingItem$onCheckStateChanged$1(this, r14, r3), LiveRoomCommentSettingItem$onCheckStateChanged$2.INSTANCE);
        return;
    L20:
        r6 = 2;
    L7:
        r3 = null;
        goto L8
    }

    public final void g(Room r6, boolean r7) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.p, 0, 2);
        boolean r1 = false;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r0.getMediaReviewStatus();
        if (r2 == null) goto L9;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L10:
        if (r7 == true) goto L19;
        RoomContext r8 = RoomContext.a.a(this.p, r6.id);
        if (r8 == null) goto L14;
        r1 = r8.isBroadcastMedia();
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        if (r4 < 5) goto L21;
        y3.f(this.p).a(ToolbarButton.COMMENT, "");
        return;
    L21:
        return;
    L19:
        return;
    L9:
        r4 = 0;
        goto L10
    }
}
