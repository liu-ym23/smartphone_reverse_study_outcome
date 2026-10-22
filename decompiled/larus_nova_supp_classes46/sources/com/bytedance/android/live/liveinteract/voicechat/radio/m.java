package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.livesdk.chatroom.model.interact.IAudioSubtitleContent;
import com.bytedance.android.livesdk.chatroom.model.interact.UpdateSubtitleType;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import hh1.v0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m implements jk0.d {
    public static final /* synthetic */ int j = 0;
    public jk0.b a;
    public com.bytedance.android.live.liveinteract.voicechat.radio.a b;
    public RadioSubtitleBusinessWidget c;
    public int d;
    public boolean e;
    public k2 f;
    public final Context g;
    public final WidgetManager h;
    public final j1 i;

    public static final class a {
    }

    static {
    }

    @Override // jk0.d
    public final void a() {
        int r0 = e.a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onSubtitleStateChangeStop ab-off return");
        return;
    L6:
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onSubtitleStateStop");
        jk0.b r1 = this.a;
        if (r1 == null) goto L10;
        r1.onStop();
        return;
    }

    @Override // jk0.d
    public final void b() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onSubtitleStateStart");
        int r1 = e.a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onSubtitleStateChangeStart ab-off return");
        return;
    L6:
        jk0.b r0 = this.a;
        if (r0 == null) goto L10;
        r0.onStart();
        return;
    }

    @Override // jk0.d
    public final void c() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onAnchorSetSubtitleStartBefore");
        j(this);
    }

    @Override // jk0.d
    public final void e() {
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] onAnchorSetSubtitleSttopAfter");
        int r1 = e.a;
        if (e.c(gh0.a.d()) == false) goto L6;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] onAnchorSetSubtitleStopAfter 实验命中off 不操作rtc");
        return;
    L6:
        l();
        jk0.b r0 = this.a;
        if (r0 == null) goto L10;
        r0.onStop();
        return;
    }

    public final void k() {
        RadioSubtitleBusinessWidget r0 = this.c;
        if (r0 == null) goto L8;
        WidgetManager r1 = this.h;
        if (r1 == null) goto L7;
        r1.unload(r0);
    L7:
        this.c = null;
    L8:
        l();
    }

    @Override // jk0.d
    public final void d() {
        if (gh0.a.d() == true) goto L12;
        int r0 = e.a;
        if (e.c(gh0.a.d()) == false) goto L8;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onMessageSubtitleStart ab-off return");
        return;
    L8:
        jk0.b r1 = this.a;
        if (r1 == null) goto L13;
        r1.onStart();
        return;
    L13:
        return;
    }

    @Override // jk0.d
    public final void f() {
        if (gh0.a.d() == true) goto L12;
        int r0 = e.a;
        if (e.c(gh0.a.d()) == false) goto L8;
        ALogger.e("RadioStageContainerWidget", "[RadioSubtitleComponent] onMessageSubtitleStop ab-off return");
        return;
    L8:
        jk0.b r1 = this.a;
        if (r1 == null) goto L13;
        r1.onStop();
        return;
    L13:
        return;
    }

    public final void l() {
        if (gh0.a.d() == false) goto L26;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r0 = this.b;
        if (r0 == null) goto L24;
        vb6.g r2 = r0.b;
        if (r2 == null) goto L15;
        yb6.e r3 = r2.j();
        if (r3 == null) goto L15;
        ei6.a r4 = r3.Z0();
        if (r4 == null) goto L15;
        zi6.d r5 = r4.c();
        if (r5 == null) goto L15;
        r5.b();
    L15:
        vb6.g r6 = r0.b;
        if (r6 == null) goto L20;
        yb6.e r7 = r6.j();
        if (r7 == null) goto L20;
        r7.n();
    L20:
        vb6.g r8 = r0.b;
        if (r8 == null) goto L23;
        r8.h(null);
    L23:
        r0.b = null;
    L24:
        this.b = null;
        return;
    }

    @Override // jk0.d
    public final com.bytedance.android.live.liveinteract.voicechat.radio.a g() {
        return this.b;
    }

    public static final void h(m r3) {
        if (r3.f == null) goto L5;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] requestInitRtcInfo pre has: " + r3.f);
        k2 r0 = r3.f;
        Intrinsics.checkNotNull(r0);
        r3.i(r0);
        return;
    L5:
        LinkApis r1 = (LinkApis) com.bytedance.android.live.network.c.b().e(LinkApis.class);
        IRoom r2 = je0.d.e(null);
        if (r2 == null) goto L8;
        long r4 = r2.getId();
    L9:
        r1.preInitRtc(r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(r3), new p(r3));
        return;
    L8:
        r4 = 0;
        goto L9
    }

    public static void j(m r4) {
        r4.getClass();
        RadioSubtitleComponent$startSubTitleWithDependence$1 r0 = new RadioSubtitleComponent$startSubTitleWithDependence$1(r4, null);
        r4.d = 0;
        int r1 = e.a;
        if (e.c(gh0.a.d()) == false) goto L5;
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent] 实验命中off 不打开字幕");
        return;
    L5:
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] loadSubtitleBusinessWidget:" + r4.c);
        if (r4.c != null) goto L9;
        RadioSubtitleBusinessWidget r2 = new RadioSubtitleBusinessWidget();
        r4.c = r2;
        Intrinsics.checkNotNullParameter(r4, "callback");
        r2.z = r4;
        r4.h.load(r4.c);
    L9:
        if (gh0.a.d() == false) goto L20;
        int r5 = ((IAudioSubtitleContent) b6.p0.getValue()).getStatus();
        ALogger.i("RadioStageContainerWidget", "[RadioSubtitleComponent][AudioSubtitle] startSubTitleWithDependence subtitleSettingStatus:" + r5);
        if (r5 != IAudioSubtitleContent.SwitchStatus.SWITCH_UNKNOWN.getValue()) goto L16;
        IAudioSubtitleContent r6 = vh7.f.c(IAudioSubtitleContent.class);
        r6.setStatus(IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue());
        nj0.b r3 = LinkmicSubtitleBusinessContext.Companion.b();
        if (r3 == null) goto L21;
        r3.N5(r6, UpdateSubtitleType.UNKNOWN, new q(r6, r0));
        return;
    L21:
        return;
    L16:
        if (r5 != IAudioSubtitleContent.SwitchStatus.SWITCH_ON.getValue()) goto L23;
        r0.m387invoke();
        return;
    L23:
        return;
    }

    public final void i(k2 r10) {
        boolean r1 = true;
        if (this.b != null) goto L32;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r0 = new com.bytedance.android.live.liveinteract.voicechat.radio.a(this.g, r10, this.i);
        this.b = r0;
        ALogger.i("RadioStageContainerWidget", "[RadioLinkRTCManager]initRTC: " + r0.h);
        vb6.g r11 = r0.b;
        if (r11 == null) goto L7;
        r11.attach();
    L7:
        com.bytedance.live.datacontext.m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L15;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L15;
        vb6.g r4 = r0.b;
        if (r4 == null) goto L14;
        r4.b(r13.getId(), r13.getOwnerUserIdString(), new b(r0));
    L14:
        tc0.c.h().e = r13.getOwnerUserIdString();
    L15:
        tc0.c r14 = tc0.c.h();
        String r5 = r0.h.b();
        if (r5 != null) goto L18;
        r5 = "";
    L18:
        r14.f = r5;
        tc0.c.h().k = r0.h.a();
        m00.e r15 = jc1.k.n(IMiddlewareBroadcastService.class).createLinkInRoomView(r0.a, r0.g, 0);
        Intrinsics.checkNotNull(r15);
        r0.c = r15;
        vb6.g r16 = r0.b;
        if (r16 == null) goto L29;
        yb6.e r17 = r16.j();
        if (r17 == null) goto L29;
        v0 r6 = r0.c;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
    L25:
        if (r6 == null) goto L28;
        r17.s0(gc6.b.c(r6, null), m.class.getSimpleName().concat(" create set"));
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.interact.LiveVideoClientFactory");
    L29:
        vb6.g r18 = r0.b;
        if (r18 == null) goto L32;
        r18.b1(r0.f, true);
    L32:
        RadioSubtitleBusinessWidget r19 = this.c;
        if (r19 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r2 = this.b;
        Intrinsics.checkNotNull(r2);
        com.bytedance.android.live.pushstream.d r3 = r2.a;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        r19.d = r3;
    L35:
        RadioSubtitleBusinessWidget r110 = this.c;
        if (r110 == null) goto L38;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r7 = this.b;
        Intrinsics.checkNotNull(r7);
        vb6.g r8 = r7.b;
        Intrinsics.checkNotNull(r8);
        yb6.e r9 = r8.j();
        Intrinsics.checkNotNullParameter(r9, "mediaManager");
        r110.c = r9;
    L38:
        RadioSubtitleBusinessWidget r111 = this.c;
        if (r111 == null) goto L41;
        r111.xq();
    L41:
        com.bytedance.android.live.liveinteract.voicechat.radio.a r112 = this.b;
        if (r112 == null) goto L55;
        vb6.g r113 = r112.b;
        if (r113 == null) goto L52;
        yb6.e r114 = r113.j();
        if (r114 == null) goto L52;
        yb6.n r115 = r114.K();
        if (r115 == null) goto L52;
        if (r115.e != true) goto L52;
        boolean r116 = true;
    L53:
        if (r116 != true) goto L55;
    L56:
        if (r1 == true) goto L63;
        com.bytedance.android.live.liveinteract.voicechat.radio.a r117 = this.b;
        if (r117 == null) goto L64;
        int r20 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        ALogger.i("RadioStageContainerWidget", "startRTC--currentScene:" + r20);
        vb6.g r118 = r117.b;
        if (r118 == null) goto L65;
        r118.c1(r20);
        return;
    L65:
        return;
    L64:
        return;
    L63:
        return;
    L52:
        r116 = false;
    L55:
        r1 = false;
        goto L56
    }

    public m(Context r2, WidgetManager r3, j1 r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "subWidgetManager");
        Intrinsics.checkNotNullParameter(r4, "scopeProvider");
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
