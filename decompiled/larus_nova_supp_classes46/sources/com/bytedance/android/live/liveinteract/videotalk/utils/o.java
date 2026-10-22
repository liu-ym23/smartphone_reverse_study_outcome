package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o {
    public boolean a;
    public boolean b;
    public final a c;
    public final DataCenter d;
    public final Context e;
    public final IRoom f;
    public final int g;
    public final int h;
    public final LifecycleOwner i;

    public static final class a implements Observer<Integer> {
        public final /* synthetic */ o a;

        public a(o r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Integer r4 = (Integer) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.intValue() != 0) goto L9;
            ALogger.e("ttlive_link", "close video interact and open video talk");
            this.a.d.put("data_need_restore_video_interact", Boolean.TRUE);
            hd0.c.f().e(this);
            this.a.c(false);
            return;
        }
    }

    public final void b() {
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() != null) goto L5;
    L7:
        c(false);
        return;
    L5:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(2) == false) goto L7;
        this.d.put("cmd_force_close_linkin_before_videotalk", Boolean.TRUE);
        hd0.c.f().k(2);
        hd0.c.f().c(this.c);
    }

    public final void c(boolean r19) {
        Ref.ObjectRef r5 = new Ref.ObjectRef();
        r5.element = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        long r2 = System.currentTimeMillis();
        if (((IRoom) r5.element) != null) goto L10;
        DataCenter r0 = this.d;
        if (r0 == null) goto L8;
        r5.element = (IRoom) r0.get("data_room", null);
    L8:
        if (((IRoom) r5.element) != null) goto L10;
        return;
    L10:
        IMultiLinkServiceExternal r1 = jc1.k.f(IMultiLinkServiceExternal.class);
        Intrinsics.checkNotNull(r1);
        if (r1.getMultiDataHolderExternal().getChannelId() == 0) goto L15;
        f2.b(2131917544, 0);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.g0("during_pk");
        return;
    L15:
        if (this.b == false) goto L17;
        return;
    L17:
        this.b = true;
        int r3 = com.bytedance.android.live.liveinteract.plantform.utils.f.a;
        com.bytedance.android.live.liveinteract.plantform.utils.f.a((LiveMode) this.d.get("data_live_mode", LiveMode.UNDEFINED));
        int r4 = this.g;
        wf0.b.i(r4);
        Single<com.bytedance.android.live.network.response.e<j0>> r7 = ((LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class)).initV2(((IRoom) r5.element).getId(), 4, 16, false, r4, "8,12", 0, this.h, 2);
        IService r8 = jc1.k.f(IInteractService.class);
        Intrinsics.checkNotNull(r8);
        ((IInteractService) r8).setDynamicFromAudience(false);
        TalkRoomBusinessFullLinkMonitor r6 = TalkRoomBusinessFullLinkMonitor.a;
        int r9 = this.h;
        r6.getClass();
        TalkRoomBusinessFullLinkMonitor.c0("click_bottom_bar_icon", r4, r9);
        InteractLinkFullLinkMonitor.i("8,12", r4, "click_bottom_bar_icon");
        r7.compose(RxUtil.rxSchedulerHelper()).subscribe(new r(this, r2, r4, r5), new s(this, r19, r2));
    }

    public static void a(LinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }

    public o(DataCenter r2, Context r3, IRoom r4, int r5, int r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r2, "mDataCenter");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "mRoom");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.c = new a(this);
    }
}
