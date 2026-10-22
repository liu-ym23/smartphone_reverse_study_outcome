package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.component.MultiComponentManager;
import com.bytedance.android.live.liveinteract.component.data.ComponentGlobalDataContext;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerClientUIInfoChangeContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import hh1.w0;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nz.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/voicelink/MultiLinkVoiceAnchorContainerWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lkn0/a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkVoiceAnchorContainerWidget extends PlatformMultiLinkWidget implements kn0.a {
    public final CompositeDisposable a;
    public IRoom b;
    public int c;
    public int d;
    public int e;
    public Widget f;
    public Widget g;
    public Widget h;
    public com.bytedance.android.livesdk.message.linker.h i;
    public boolean j;
    public final FragmentManager k;
    public final com.bytedance.android.live.pushstream.d l;
    public final w0 m;

    public final int getLayoutId() {
        return 2131567950;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return 0;
    }

    @Override // kn0.a
    public final void i2(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        Lazy r0 = MultiComponentManager.e;
        MultiComponentManager.a.a().a(this, ((Widget) this).context, ((Widget) this).dataCenter);
        getScopeServiceInMultiLinkRoom(cg6.a.class).init(((Widget) this).context);
        enableSubWidgetManager();
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r1 == null) goto L7;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L7;
        this.a.add(r2.a().subscribe(new e(this)));
    L7:
        RxUtilKt.c(xs2.b.a().b(pe0.a.class).subscribe(new d(this)), this.a);
        this.b = (IRoom) ((Widget) this).dataCenter.get("data_room");
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        ComponentGlobalDataContext.Companion.getClass();
        ComponentGlobalDataContext r0 = ComponentGlobalDataContext.a.a();
        if (r0 == null) goto L7;
        DataCenter r1 = r0.getDataCenter();
        if (r1 == null) goto L7;
        r1.put("cmd_link_switch_video_resolution_for_short_video", new com.bytedance.android.live.liveinteract.model.e());
    L7:
        cg6.a r2 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r2 == null) goto L20;
        hg6.g r3 = r2.getRtcManager();
        if (r3 == null) goto L14;
        fg6.b r4 = r3.F();
        if (r4 == null) goto L14;
        r4.a();
    L14:
        hg6.g r5 = r2.getRtcManager();
        if (r5 == null) goto L17;
        r5.onDestroy();
    L17:
        vb6.g r6 = r2.O5();
        if (r6 == null) goto L20;
        r6.h(null);
    L20:
        hd0.c.f().k(0);
        com.bytedance.live.datacontext.j r7 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).s();
        if (r7 == null) goto L25;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r8 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r7.getValue();
        if (r8 == null) goto L25;
        r8.reset();
    L25:
        this.a.dispose();
        if (this.l.t0() == true) goto L28;
    L39:
        com.bytedance.android.live.liveinteract.plantform.utils.i.b();
        Lazy r9 = MultiComponentManager.e;
        MultiComponentManager.a.a().b(((Widget) this).context);
        cg6.a r10 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r10 == null) goto L43;
        r10.release();
        return;
    L43:
        return;
    L28:
        if (this.l == null) goto L36;
        cg6.a r11 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r11 == null) goto L36;
        jg6.a r12 = r11.e5();
        if (r12 == null) goto L36;
        kg6.e r13 = r12.b();
        if (r13 == null) goto L36;
        r13.z(new kg6.d(true, true, "onDestroy", 8));
    L36:
        String r14 = je0.d.b0();
        w0 r15 = this.m;
        if (r15 == null) goto L39;
        r15.f9(r14, false);
        goto L39
    }

    @Override // kn0.a
    public final void E1(ILinkerClientUIInfoChangeContent r2) {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L6;
        r0.onClientUIInfoChangeMessage(r2);
        return;
    }

    @Override // kn0.a
    public final void d1(z0 r4) {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        com.bytedance.android.live.liveinteract.multianchor.model.b r1 = null;
        if (r0 == null) goto L8;
        if (r4 == null) goto L6;
        com.bytedance.android.live.liveinteract.multianchor.model.b r2 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
    L7:
        r0.onSwitchSceneMessage(r2);
        goto L8
    L6:
        r2 = null;
    L8:
        IKtvService r3 = jc1.k.n(IKtvService.class);
        if (r4 == null) goto L11;
        r1 = (com.bytedance.android.live.liveinteract.multianchor.model.b) r4.castTo(com.bytedance.android.live.liveinteract.multianchor.model.b.class);
    L11:
        r3.onSwitchSceneMessage(r1);
    }

    public static long wq(int r1, int r2) {
        if (r1 != 0) goto L4;
        f0.c r3 = f0.c.b;
        return 7;
    L4:
        if (r1 != 5) goto L6;
    L14:
        int r4 = f0.f.b;
        return 4;
    L6:
        if (r1 == 9) goto L11;
        if (r1 == 16) goto L14;
        return 0;
    L11:
        if (r2 != 61) goto L13;
        int r5 = f0.g.b;
        return 2;
    L13:
        int r6 = f0.b.b;
        return 1;
    }

    @Override // kn0.a
    public final void continueAnchorLinkMic(int r2, com.bytedance.android.livesdk.message.linker.h r3) {
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        if (com.bytedance.android.live.liveinteract.voicechat.d.a.a() == null) goto L5;
    L7:
        com.bytedance.android.live.liveinteract.voicechat.d r0 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r0 == null) goto L10;
        r0.continueAnchorLinkMic(r2, r3);
    L10:
        this.i = null;
        return;
    L5:
        if (jc1.k.n(IKtvService.class).continueAnchorLinkMic(r2, r3) == true) goto L7;
        this.i = r3;
    }

    public MultiLinkVoiceAnchorContainerWidget(FragmentManager r2, com.bytedance.android.live.pushstream.d r3, w0 r4) {
        Intrinsics.checkNotNullParameter(r3, "liveStream");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.a = new CompositeDisposable();
    }

    @Override // kn0.a
    public final void vh(int r23, int r24, int r25, String r26) {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.e(this);
        if (r0 != null) goto L8;
        return;
    L8:
        if (this.b == null) goto L27;
        long r11 = System.currentTimeMillis();
        com.bytedance.live.datacontext.j r1 = r0.s();
        if (r1 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L17;
        int r9 = r3.b;
    L18:
        tf0.m r4 = b0.b();
        if ((r4 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) == true) goto L21;
        r4 = null;
    L21:
        com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u r5 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u) r4;
        if (r5 == null) goto L24;
        r5.a = false;
        r5.b = r11;
    L24:
        LinkApi r13 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r6 = this.b;
        Intrinsics.checkNotNull(r6);
        long r14 = r6.getId();
        IRoom r7 = this.b;
        Intrinsics.checkNotNull(r7);
        Disposable r8 = r13.switchScene(r14, r7.getId(), r23, r24, r25, r26).subscribeOn(Schedulers.io()).flatMap(f.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r5, r25, r23, r24, r26, r11, r9), new h(this, r23, r24, r26, r11));
        this.a.add(r8);
        return;
    L17:
        r9 = 0;
        goto L18
    }
}
