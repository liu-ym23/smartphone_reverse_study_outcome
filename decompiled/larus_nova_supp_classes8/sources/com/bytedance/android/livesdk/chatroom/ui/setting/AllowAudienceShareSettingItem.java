package com.bytedance.android.livesdk.chatroom.ui.setting;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.s2;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AllowAudienceShareSettingItem extends mx.l {
    public AllowAudienceShareSettingItem() {
        super(s1.B(2131919668), null, ((Boolean) com.bytedance.android.livesdk.sharedpref.b.H1.getValue()).booleanValue(), false, false, null, 122);
    }

    public final void c(SwitchSettingViewHolder r13, final boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "holder");
        Intrinsics.checkNotNullParameter(r13, "holder");
        ((mx.l) this).l = r14;
        FragmentActivity r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        Room r2 = (Room) r1.getValue();
    L8:
        if (r2 != null) goto L11;
        com.bytedance.android.livesdk.sharedpref.e r15 = com.bytedance.android.livesdk.sharedpref.b.H1;
        Boolean r16 = Boolean.valueOf(r14);
        r15.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r15, r16);
        return;
    L11:
        FragmentActivity r17 = s2.a(((RecyclerView.ViewHolder) r13).itemView.getContext());
        if ((r17 instanceof FragmentActivity) == false) goto L15;
        r4 = r17;
    L15:
        FragmentActivity r5 = r4;
        if (r5 != null) goto L18;
        return;
    L18:
        if (r14 == false) goto L20;
        int r7 = 1;
    L21:
        int r18 = a0.a;
        a0.b(r5, 0, r7, r2.id, new AllowAudienceShareSettingItem$onCheckStateChanged$1(r14), AllowAudienceShareSettingItem$onCheckStateChanged$2.INSTANCE);
        return;
    L20:
        r7 = 2;
    L7:
        r2 = null;
        goto L8
    }
}
