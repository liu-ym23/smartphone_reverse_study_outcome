package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.syncdata.RoomChannelSettingsSyncData;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityTraceMonitor;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r13) {
        RoomChannelSettingsSyncData r14 = (RoomChannelSettingsSyncData) r13;
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.a;
        c r1 = this.a;
        boolean r2 = r14.getLinkMicSwitch();
        boolean r3 = r14.getMemberInviteSwitch();
        Intrinsics.checkNotNullParameter(r1, "channel");
        LinkedHashMap r9 = new LinkedHashMap();
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.g.j(r9, r1);
        r9.put("link_mic_switch", String.valueOf(r2));
        r9.put("member_invite_switch", String.valueOf(r3));
        Unit r4 = Unit.INSTANCE;
        com.bytedance.android.livesdk.interactivity.api.monitor.c r5 = new com.bytedance.android.livesdk.interactivity.api.monitor.c(0, null, 0, r9, 7);
        r5.a(InteractivityMonitor.Event.ChatChannelSettingUpdate);
        r5.b(InteractivityTraceMonitor.Event.ChatChannelSettingUpdate);
        if (r14.getMemberInviteSwitch() == ((Boolean) this.a.m.a).booleanValue()) goto L5;
        this.a.m.a(Boolean.valueOf(r14.getMemberInviteSwitch()));
    L5:
        c r15 = this.a;
        int r6 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r15, "chatChannel");
        StringBuilder r7 = new StringBuilder("update setting, channelId is ");
        r7.append(r15.p);
        r7.append(", linkState is ");
        PropertyOwner<Boolean> r8 = r15.l;
        r8.getClass();
        r7.append(((Boolean) r8.a).booleanValue());
        r7.append(", inviteState is ");
        PropertyOwner<Boolean> r16 = r15.m;
        r16.getClass();
        r7.append(((Boolean) r16.a).booleanValue());
        com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.b(r7.toString());
    }
}
