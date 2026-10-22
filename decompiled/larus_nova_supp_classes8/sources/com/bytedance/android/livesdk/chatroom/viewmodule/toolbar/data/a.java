package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import android.content.Context;
import com.bytedance.android.live.core.setting.x3;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorAIHelperLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorChannelLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorConfigCompatFixLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorFlowFeedbackLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorFoldButtonManagerLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorLinkmicAnnounceLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorMiniAppMoreLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorStableModeLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AnchorUnionLiveLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.CommonSlotMoreLoader;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.LiveMatrixLoader;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends AudienceMoreDialogDataManagerImpl {
    public final Context i;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogDataManagerImpl
    public final void e() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        this.e.a(new AnchorConfigCompatFixLoader(r0));
        this.e.a(new LiveMatrixLoader(r0));
        this.e.a(new CommonSlotMoreLoader(r0));
        this.e.a(new AnchorFoldButtonManagerLoader(r0));
        this.e.a(new AnchorFlowFeedbackLoader(r0, this.i));
        this.e.a(new AnchorUnionLiveLoader(r0));
        this.e.a(new AnchorStableModeLoader(r0));
        this.e.a(new AnchorChannelLoader(r0));
        this.e.a(new AnchorLinkmicAnnounceLoader(r0));
        if (ud0.a.getValue().booleanValue() == true) goto L8;
        this.e.a(new AnchorMiniAppMoreLoader(r0, getContext(), this.g));
    L8:
        this.e.a(new AnchorAIHelperLoader(r0));
        IEnterGuideService r1 = k.f(IEnterGuideService.class);
        if (r1 == null) goto L14;
        l32.c r2 = r1.getKeyRoomInfoBizController();
        if (r2 == null) goto L15;
        this.e.a(r2.c(r0, this.i));
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogDataManagerImpl
    public final void g() {
        if (z.h(this.g) == false) goto L5;
    L6:
        super.g();
        return;
    L5:
        if (tb1.c.a == false) goto L6;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.AudienceMoreDialogDataManagerImpl
    public final void f() {
        super.f();
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r1 = RoomContext.a.c(r0, this.g, 0, 2);
        if (r1 == null) goto L11;
        m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L11;
        RoomExtra r4 = r3.getExtra();
        if (r4 == null) goto L11;
        Boolean r5 = Boolean.valueOf(r4.isGroupLiveScene());
    L13:
        if (((Boolean) x3.a.getValue()).booleanValue() == true) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L23;
        RoomContext r6 = RoomContext.a.c(r0, this.g, 0, 2);
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.isPrivateRoom() != true) goto L25;
        g<a2, e> r7 = this.e;
        g.b r8 = new i();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "filter");
        g.e<T> r9 = new g.e();
        r7.b = r9;
        r9.a.add((Handler) r8);
        return;
    L25:
        return;
    L23:
        return;
    L11:
        r5 = null;
        goto L13
    }

    public a(DataCenter r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "dc");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        super(r2, r3);
        this.i = r3;
    }
}
