package com.bytedance.android.live.livepkaudience.widget;

import am2.x;
import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.liveinteract.animation.InteractAnimationContext;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.r0;
import com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget;
import com.bytedance.android.live.livepkaudience.base.o;
import com.bytedance.android.live.livepkaudience.base.p;
import com.bytedance.android.live.livepkaudience.base.y;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractAnchorContext;
import com.bytedance.android.live.livepkaudience.context.LinkPkInteractGuestDataContext;
import com.bytedance.android.live.livepkaudience.dialog.RevLinkDialog;
import com.bytedance.android.live.livepkaudience.vm.LinkPkSwitchCameraManager;
import com.bytedance.android.live.livepkaudience.window.LinkPkInteractAnchorWindowManagerV2;
import com.bytedance.android.live.multilink.impl.InteractService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.LinkInviteResult;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicRtcInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiLiveCoreInfo;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiRtcInfo;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.bh0;
import com.bytedance.android.livesdk.config.ch0;
import com.bytedance.android.livesdk.config.df1;
import com.bytedance.android.livesdk.config.oh0;
import com.bytedance.android.livesdk.config.u7;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.if;
import com.bytedance.android.livesdk.message.model.ue;
import com.bytedance.android.livesdk.message.model.xe;
import com.bytedance.android.livesdk.message.model.ye;
import com.bytedance.android.livesdk.o7;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.CircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerLinkedListChangeContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkmicMediaParam;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkRoomFightUpdateContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerChangeMediaInfoContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerResumeAudienceContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import dl0.k;
import gd0.v;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kc0.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nc0.r;
import nc0.s;
import org.json.JSONObject;
import uf2.d0;
import uf2.m1;
import uf2.z;
import vlc.l;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/livepkaudience/widget/LinkPkInteractAudienceAnchorWidget;", "Lcom/bytedance/android/live/livepkaudience/base/BasePkInteractAnchorWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/live/livepkaudience/service/b;", "Lvlc/l;", "Lcom/bytedance/android/live/livepkaudience/vm/b;", "Lcom/bytedance/android/live/livepkaudience/presenter/a$a;", "livepkaudience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkPkInteractAudienceAnchorWidget extends BasePkInteractAnchorWidget implements Observer<KVData>, com.bytedance.android.live.livepkaudience.service.b, l, com.bytedance.android.live.livepkaudience.vm.b, com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a {
    public boolean A;
    public final lc0.c B;
    public final c C;
    public final v0 D;
    public final LinkPkInteractGuestDataContext E;
    public final String l;
    public final String m;
    public final Set<Integer> n;
    public com.bytedance.android.live.livepkaudience.base.i o;
    public RevLinkDialog p;
    public LinkPkInteractAnchorWindowManagerV2 q;
    public final CompositeDisposable r;
    public com.bytedance.android.live.livepkaudience.presenter.a s;
    public final gd0.h t;
    public final lc0.d u;
    public int v;
    public final a w;
    public vlc.d x;
    public LinkPkSwitchCameraManager y;
    public boolean z;

    public static final class a extends y {
        public final /* synthetic */ LinkPkInteractAudienceAnchorWidget a;

        public a(LinkPkInteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void onOnlineListChanged(List<? extends LinkPlayerInfo> r4) {
            ArrayList r0 = new ArrayList(r4);
            ((Widget) this.a).dataCenter.put("data_online_changed_list", r0);
            gy.f r1 = this.a.c;
            if (r1 == null) goto L5;
            r1.f();
        L5:
            LinkPkInteractAudienceAnchorWidget r2 = this.a;
            int r3 = r2.f;
            if (r4 == null) goto L8;
            int r5 = ((CopyOnWriteArrayList) r4).size();
        L9:
            r2.f = Math.max(r3, r5);
            this.a.zq();
            this.a.Gq();
            return;
        L8:
            r5 = 0;
            goto L9
        }

        @Override // com.bytedance.android.live.livepkaudience.base.y, com.bytedance.android.live.livepkaudience.base.z
        public final void b(String r1, String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r1, "userId");
            gy.f r4 = this.a.c;
            if (r4 == null) goto L6;
            r4.f();
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkPkInteractAudienceAnchorWidget a;

        public b(LinkPkInteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.bf(false);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LinkPkInteractAudienceAnchorWidget a;

        public c(LinkPkInteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (((RevPkState) r3) != RevPkState.PK) goto L23;
            com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
            com.bytedance.android.live.livepkaudience.service.e r4 = com.bytedance.android.live.livepkaudience.service.e.a.a();
            if (r4 == null) goto L7;
            r4.hideInteractDialog();
        L7:
            RevLinkDialog r5 = this.a.p;
            if (r5 != null) goto L21;
        L15:
            this.a.E.resetLogData();
            Integer r6 = (Integer) ((Widget) this.a).dataCenter.get("data_link_state", 0);
            if (k.a() == true) goto L18;
            return;
        L18:
            if (v.a(r6.intValue(), 32) == false) goto L25;
            this.a.finishInteract("switchToBreakThrough");
            return;
        L25:
            return;
        L21:
            r5.dismiss();     // Catch: Exception -> L11
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L15;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L15
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LinkPkInteractAudienceAnchorWidget a;

        public d(LinkPkInteractAudienceAnchorWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            gy.f r0 = this.a.c;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.f();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void J(String[] r1, boolean[] r2, int[] r3) {
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void L0(String r1, TextureView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.b
    public final void Mo(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, com.bytedance.android.live.livepkaudience.vm.a r6) {
    }

    public final void S2(String r1, Object r2, int r3, int r4) {
    }

    public final int getLayoutId() {
        return 2131567759;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void h1(String r1, SurfaceView r2, int r3, int r4) {
    }

    @Override // com.bytedance.android.live.livepkaudience.vm.b
    public final boolean l5() {
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void q(int r1) {
    }

    public final void Eq() {
        if (this.u.d() != RevPkState.PK) goto L10;
        LinkPkInteractGuestDataContext r0 = this.E;
        if (r0 == null) goto L17;
        m<Boolean> r1 = r0.getHasAudienceJoin4Pk();
        if (r1 == null) goto L18;
        r1.setValue(Boolean.TRUE);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        if (this.u.d() != RevPkState.PENAL) goto L20;
        LinkPkInteractGuestDataContext r2 = this.E;
        if (r2 == null) goto L21;
        m<Boolean> r3 = r2.getHasAudienceJoin4Penalty();
        if (r3 == null) goto L22;
        r3.setValue(Boolean.TRUE);
        return;
    L22:
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final int H() {
        com.bytedance.android.live.livepkaudience.base.i r0 = this.o;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.b();
    }

    public final int Jq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        int r1 = 0;
        if (r0 == null) goto L9;
        WeakReference r2 = (WeakReference) r0.get("data_broadcast_preview_surface_view", null);
        if (r2 == null) goto L9;
        SurfaceView r3 = (SurfaceView) r2.get();
        if (r3 == null) goto L9;
        int r4 = r3.getHeight();
    L10:
        if (r4 > 0) goto L20;
        int r5 = s1.w();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L19;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L19;
        Context r6 = ((Widget) this).context;
        if (r6 == null) goto L19;
        r1 = StatusBarUtil.getStatusBarHeight(r6);
    L19:
        return r5 - r1;
    L20:
        return r4;
    L9:
        r4 = 0;
        goto L10
    }

    public final void Kq() {
        com.bytedance.android.live.livepkaudience.base.i r0 = this.o;
        if (r0 == null) goto L11;
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r2 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r2 == null) goto L9;
        com.bytedance.android.live.livepkaudience.service.g r3 = r2.ml();
        if (r3 == null) goto L9;
        Map<Long, RoomLinkerContent> r4 = r3.a;
    L10:
        r0.K(r4);
    L9:
        r4 = null;
    L11:
        gy.f r1 = this.c;
        if (r1 == null) goto L17;
        s r5 = r1.L();
        if (r5 == null) goto L17;
        Map r6 = r5.c();
        if (r6 == null) goto L17;
    L18:
        String r7 = this.B.u();
        String r8 = this.l;
        StringBuilder r9 = new StringBuilder("updateFirstvideoFrame linkerContentMap = ");
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r10 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r10 == null) goto L23;
        com.bytedance.android.live.livepkaudience.service.g r11 = r10.ml();
        if (r11 == null) goto L23;
        Map<Long, RoomLinkerContent> r12 = r11.a;
    L24:
        r9.append(r12);
        r9.append(", remoteView = ");
        r9.append(r6.size());
        r9.append(", linkmicId = ");
        r9.append(r7);
        ALogger.i(r8, r9.toString());
        ViewGroup r13 = ((Widget) this).containerView;
        if (r13 == null) goto L27;
        r13.postDelayed(new d(this), 2000);
    L27:
        com.bytedance.android.live.livepkaudience.base.i r14 = this.o;
        if (r14 == null) goto L34;
        LinkPlayerInfo r15 = r14.k("0", r7);
        if (r15 == null) goto L34;
        if (r15.silenceStatus != 1) goto L34;
        f2.c(s1.B(2131914855), 0);
    L34:
        Iterator r16 = r6.entrySet().iterator();
        String r17 = "";
    L36:
        if (r16.hasNext() == false) goto L65;
        Map.Entry r18 = (Map.Entry) r16.next();
        String r19 = (String) r18.getKey();
        Object r20 = r18.getValue();
        if (Cq(r19) == true) goto L36;
        if (TextUtils.equals(r19, r7) == true) goto L36;
        r17 = r17 + ' ' + r19 + ", ";
        if ((r20 instanceof SurfaceView) == true) goto L44;
        if ((r20 instanceof TextureView) == true) goto L47;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r21 = ILiveWrappedLivePusher.a.b();
        if (r21 == null) goto L51;
        z.a r22 = r21.buildLayerControlLayer(r20);
    L52:
        V4(r19, r22);
        DataCenter r23 = ((Widget) this).dataCenter;
        if (r23 == null) goto L57;
        Boolean r24 = (Boolean) r23.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r24 == null) goto L57;
        boolean r25 = r24.booleanValue();
    L58:
        Aq(r25, true);
        DataCenter r26 = ((Widget) this).dataCenter;
        if (r26 == null) goto L63;
        Boolean r27 = (Boolean) r26.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r27 == null) goto L63;
        boolean r28 = r27.booleanValue();
    L64:
        Aq(r28, true);
    L63:
        r28 = false;
    L57:
        r25 = false;
        goto L58
    L51:
        r22 = null;
        goto L52
    L47:
        j0(r19, (TextureView) r20, 0, 0);
        goto L36
    L44:
        y0(r19, (SurfaceView) r20, 0, 0);
        goto L36
    L65:
        dl0.m r29 = dl0.m.a;
        int r30 = r6.size();
        r29.getClass();
        dl0.m.D(r7, r30, r17, true);
        return;
    L23:
        r12 = null;
    L17:
        r6 = MapsKt.emptyMap();
        goto L18
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final p X4() {
        p r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.service.b
    public final com.bytedance.android.live.livepkaudience.base.i getLinkUserCenter() {
        if (this.o != null) goto L5;
        this.o = new com.bytedance.android.live.livepkaudience.base.i(((Widget) this).dataCenter);
    L5:
        com.bytedance.android.live.livepkaudience.base.i r0 = this.o;
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void onDestroy() {
        int r0 = al0.b.a;
        DataCenter r1 = ((Widget) this).dataCenter;
        long r2 = this.e;
        int r4 = this.f;
        Room r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        ICircleInfo r5 = r3.getCircleInfo();
        if ((r5 instanceof CircleInfo) == true) goto L8;
        r5 = null;
    L8:
        al0.b.e(r1, r2, r4, (CircleInfo) r5, 32);
        vlc.d r6 = this.x;
        if (r6 == null) goto L11;
        r6.removeMessageListener(this);
    L11:
        super.onDestroy();
        IPkAudienceLinkOutService r7 = (IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class);
        if (r7 == null) goto L14;
        r7.onPKInteractBizEnd();
    L14:
        this.r.dispose();
        LinkPkInteractAnchorWindowManagerV2 r8 = this.q;
        if (r8 == null) goto L67;
        int r9 = LinkPkInteractAnchorWindowManagerV2.G;
        Intrinsics.checkNotNullParameter(MultiLinkOpenSource.DEFAULT, "reason");
        r8.j = false;
        com.bytedance.android.live.livepkaudience.base.i r10 = r8.e;
        if (r10 == null) goto L19;
        r10.J(r8);
    L19:
        el0.f r11 = r8.h;
        if (r11 == null) goto L22;
        r11.a.J(r11);
    L22:
        Iterator r12 = ((ArrayList) r8.d).iterator();
    L24:
        if (r12.hasNext() == false) goto L26;
        r8.b.removeView((el0.a) r12.next());
        goto L24
    L26:
        Iterator r13 = ((ArrayList) r8.c).iterator();
    L28:
        if (r13.hasNext() == false) goto L30;
        r8.b.removeView((el0.a) r13.next());
        goto L28
    L30:
        ((ArrayList) r8.c).clear();
        com.bytedance.android.live.livepkaudience.rtc.d r14 = r8.m;
        if (r14 == null) goto L33;
        r14.c();
    L33:
        r8.m = null;
        if (Intrinsics.areEqual(MultiLinkOpenSource.DEFAULT, MultiLinkOpenSource.DEFAULT) == false) goto L53;
        xs2.b.a().post(new kd0.a(false, 0));
        DataCenter r15 = r8.l;
        if (r15 == null) goto L38;
        r15.put("cmd_interact_player_view_change", new kd0.a(false, 0));
    L38:
        DataCenter r16 = r8.l;
        if (r16 == null) goto L41;
        r16.put("cmd_what_is_single_view_mode", Boolean.FALSE);
    L41:
        DataCenter r17 = r8.l;
        if (r17 == null) goto L44;
        r17.put("cmd_what_audience_join_self_link", Boolean.FALSE);
    L44:
        ILinkServiceExternal r18 = jc1.k.f(ILinkServiceExternal.class);
        if (r18 == null) goto L47;
        r18.onAudienceJoinSelfLink(false);
    L47:
        DataCenter r19 = r8.l;
        if (r19 == null) goto L50;
        r19.put("cmd_what_audience_join_guest_link", Boolean.FALSE);
    L50:
        ILinkServiceExternal r20 = jc1.k.f(ILinkServiceExternal.class);
        if (r20 == null) goto L53;
        r20.onAudienceJoinGuestLink(false);
    L53:
        DataCenter r21 = r8.l;
        if (r21 == null) goto L56;
        r21.removeObserver(r8);
    L56:
        DataCenter r22 = r8.l;
        if (r22 == null) goto L59;
        r22.removeObserver("data_audio_chat_support_send_gift_to_linker", r8.z);
    L59:
        com.bytedance.android.live.livepkaudience.seat.f r23 = r8.w;
        if (r23 == null) goto L62;
        ((LinkedHashMap) r23.a).clear();
    L62:
        r8.y.f(r8.B);
        r8.y.c(r8.A);
        ((ArrayList) r8.d).clear();
        com.bytedance.android.live.livepkaudience.rtc.d r24 = r8.m;
        if (r24 == null) goto L65;
        r24.c();
    L65:
        r8.m = null;
    L67:
        if (this.t == null) goto L71;
        InteractAnimationContext.a r25 = InteractAnimationContext.Companion;
        if (r25.a() == null) goto L71;
        r25.a().l();
    L71:
        LinkPkSwitchCameraManager r26 = this.y;
        if (r26 == null) goto L76;
        r26.a.dispose();
        vlc.d r27 = r26.b;
        if (r27 == null) goto L76;
        r27.removeMessageListener(r26);
    L76:
        gy.f r28 = this.c;
        if (r28 == null) goto L79;
        r28.e(this);
    L79:
        this.z = false;
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L82;
        r29.put("data_pk_anchor_silence_status_change", Boolean.FALSE);
    L82:
        ILinkServiceExternal r30 = jc1.k.f(ILinkServiceExternal.class);
        if (r30 == null) goto L85;
        r30.notifyPkAnchorSilenceStatus(false);
    L85:
        DataCenter r31 = ((Widget) this).dataCenter;
        if (r31 == null) goto L88;
        r31.removeObserver(this);
    L88:
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r32 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r32 == null) goto L91;
        r32.hideInteractDialog();
    L91:
        RevLinkDialog r33 = this.p;
        if (r33 != null) goto L108;
    L99:
        DataCenter r34 = ((Widget) this).dataCenter;
        if (r34 == null) goto L104;
        Boolean r35 = Boolean.FALSE;
        if (((Boolean) r34.get("data_talk_room_admin_allowed_flag", r35)).booleanValue() == false) goto L104;
        r34.put("data_talk_room_admin_allowed_flag", r35);
    L104:
        this.u.c(this.C);
        hd0.c.f().k(0);
        com.bytedance.android.live.livepkaudience.presenter.a r36 = this.s;
        if (r36 == null) goto L112;
        r36.detachView();
        return;
    L112:
        return;
    L108:
        r33.dismiss();     // Catch: Exception -> L95
    L95:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r37 = DialogFragmentLancet.sLastShowStack;
        if (r37 == null) goto L99;
        com.bytedance.crash.d.d(r37, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L99
    }

    public final void onPause() {
        gy.f r0 = this.c;
        if (r0 != null) goto L5;
    L18:
        super.onPause();
        return;
    L5:
        if (r0.isEngineOn() == false) goto L18;
        if (this.z == true) goto L18;
        boolean r2 = false;
        Integer r1 = (Integer) ((Widget) this).dataCenter.get("data_link_state", 0);
        if (jc1.k.n(ILinkServiceExternal.class).getPkService().getPkState() != 1) goto L13;
        r2 = true;
    L13:
        if (v.a(r1.intValue(), 4) == false) goto L17;
        if (r2 == false) goto L20;
        getLinkUserCenter().B();
        goto L18
    L20:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final int xq() {
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == false) goto L6;
        return 16;
    L6:
        return 1;
    }

    public final void zq() {
        if (((Boolean) bh0.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        gy.f r0 = this.c;
        if (r0 == null) goto L65;
        s r1 = r0.L();
        if (r1 == null) goto L91;
        Map r2 = r1.c();
        if (r2 == null) goto L92;
        Iterator r3 = ((HashMap) r2).entrySet().iterator();
    L13:
        if (r3.hasNext() == false) goto L93;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (TextUtils.equals((CharSequence) r4.getKey(), this.B.u()) == true) goto L13;
        if (TextUtils.equals((CharSequence) r4.getKey(), this.B.y()) == true) goto L13;
        if (Cq((String) r4.getKey()) == true) goto L13;
        String r5 = (String) r4.getKey();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r6 = ILiveWrappedLivePusher.a.b();
        m1.b r7 = null;
        if (r6 == null) goto L24;
        z.a r8 = r6.buildLayerControlLayer(r4.getValue());
    L25:
        com.bytedance.android.live.livepkaudience.base.i r9 = this.o;
        if (r9 == null) goto L64;
        boolean r10 = r9.v(r5);
        com.bytedance.android.live.livepkaudience.base.i r11 = this.o;
        if (r11 == null) goto L62;
        String r12 = r11.r(r5);
        com.bytedance.android.live.livepkaudience.base.i r13 = this.o;
        if (r13 == null) goto L60;
        int r14 = r13.O4(r12);
        if (r10 == false) goto L34;
        int r15 = r14 + 1;
    L35:
        Iq(r15, (float) (com.bytedance.android.live.livepkaudience.rtc.d.i / com.bytedance.android.live.livepkaudience.rtc.d.h));
        ILiveWrappedLivePusher r16 = ILiveWrappedLivePusher.a.b();
        if (r16 == null) goto L40;
        m1.b r17 = r16.newVideoMixerDescription(null);
        if (r17 == null) goto L40;
        r17.e();
        r17.b();
        r17.c();
        r17.f();
        r17.h();
        r17.i();
        r17.g();
        r7 = r17;
    L40:
        if (r8 == null) goto L13;
        if (r7 == null) goto L13;
        String r18 = "adjustGuestSingleView tryUpdateLayerDescription, linkId = " + r5 + ", top = " + r7.getTop() + ", botoom = " + r7.getBottom() + ", left = " + r7.getLeft() + ", surfaceHeight: " + Jq() + ',';
        ALogger.e(this.l, r18);
        dl0.m r19 = dl0.m.a;
        String r20 = this.l + "_tryUpdateLayerDescription";
        r19.getClass();
        dl0.m.C(r20, r18);
        m1.b r21 = r8.Y();
        if (r21 == null) goto L58;
        if (r21.getLeft() != r7.getLeft()) goto L58;
        if (r21.getTop() != r7.getTop()) goto L58;
        if (r21.getRight() != r7.getRight()) goto L58;
        if (r21.getBottom() != r7.getBottom()) goto L58;
        if (r21.isVisible() != r7.isVisible()) goto L58;
        if (r21.getMode() != r7.getMode()) goto L58;
        if (r21.d() == r7.d()) goto L13;
    L58:
        r8.b();
        goto L13
    L34:
        r15 = r14 - 1;
        goto L35
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L62:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L64:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L24:
        r8 = null;
        goto L25
    L93:
        return;
    L92:
        return;
    L91:
        return;
    }

    public final void Gq() {
        Pair<List<LinkPlayerInfo>, List<LinkPlayerInfo>> r0 = getLinkUserCenter().i();
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        String r2 = "";
        if (r1 == null) goto L10;
        m r3 = r1.getRoom();
        if (r3 == null) goto L10;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L10;
        String r5 = r4.getOwnerUserIdString();
        if (r5 == null) goto L10;
    L11:
        ILinkServiceExternal r6 = jc1.k.f(ILinkServiceExternal.class);
        if (r6 == null) goto L18;
        lc0.c r7 = r6.getMultiDataHolder();
        if (r7 == null) goto L18;
        String r8 = r7.a();
        if (r8 == null) goto L18;
        r2 = r8;
    L18:
        com.bytedance.android.live.livepkaudience.service.c.w0.getClass();
        LinkPkInteractGuestDataContext r9 = com.bytedance.android.live.livepkaudience.service.c.a.a();
        if (r9 == null) goto L24;
        MutableLiveData<String> r10 = r9.getGuestLynxListData();
        if (r10 == null) goto L25;
        r10.setValue(dl0.f.a((List) r0.getFirst(), (List) r0.getSecond(), r5, r2));
        return;
    L25:
        return;
    L24:
        return;
    L10:
        r5 = "";
        goto L11
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        LinkPkInteractAnchorContext r1 = (LinkPkInteractAnchorContext) r0.component1();
        Disposable r2 = (Disposable) r0.component2();
        com.bytedance.live.datacontext.b.a(r1, "linkpk_interact_anchor_service");
        r1.getService().d(this);
        this.r.add(r2);
        ((Widget) this).dataCenter.observe("cmd_force_close_linkin", this);
        ((Widget) this).dataCenter.observe("cmd_force_close_linkin_before_videotalk", this);
        ((Widget) this).dataCenter.observe("cmd_what_audience_join_self_link", this);
        ((Widget) this).dataCenter.observe("cmd_what_audience_join_guest_link", this);
        ((Widget) this).dataCenter.observe("data_anchor_video_talk_room_init_source", this);
        ((Widget) this).dataCenter.observe("data_observe_pk_id_start", this);
        ((Widget) this).dataCenter.observe("cmd_pk_state_change", this);
        getLinkUserCenter().c(this.w);
        IPkAudienceLinkOutService r3 = (IPkAudienceLinkOutService) jc1.k.f(IPkAudienceLinkOutService.class);
        if (r3 == null) goto L5;
        r3.onPKInteractBizStart();
    L5:
        Gq();
        this.r.add(((InteractService.a) this.t).a(((Widget) this).dataCenter));
        Room r4 = this.a;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L8:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L122;
        FrameLayout r6 = (FrameLayout) r5;
        com.bytedance.android.live.livepkaudience.base.i r7 = this.o;
        FragmentActivity r8 = ((Widget) this).context;
        if (r8 == null) goto L120;
        LinkPkInteractAnchorWindowManagerV2 r9 = new LinkPkInteractAnchorWindowManagerV2(r4, r6, r7, r8, this, r5.findViewById(2131392689), this.E);
        this.q = r9;
        r9.f = new b(this);
        if (this.t == null) goto L17;
        InteractAnimationContext.a r10 = InteractAnimationContext.Companion;
        if (r10.a() == null) goto L17;
        r10.a().g(r9);
    L17:
        LinkPkInteractAnchorWindowManagerV2 r11 = this.q;
        if (r11 == null) goto L31;
        DataCenter r12 = ((Widget) this).dataCenter;
        r11.l = r12;
        if (r12 == null) goto L24;
        Boolean r13 = (Boolean) r12.get("data_is_portrait", Boolean.TRUE);
        if (r13 == null) goto L24;
        boolean r14 = r13.booleanValue();
    L25:
        r11.k = r14;
        DataCenter r15 = r11.l;
        if (r15 == null) goto L28;
        r15.observe("data_intimate_chat_support_send_gift_to_linker", r11.z);
    L28:
        DataCenter r16 = r11.l;
        if (r16 == null) goto L31;
        r16.observe("data_big_party_support_send_gift_to_linker", r11.z);
    L24:
        r14 = true;
    L31:
        LinkPkInteractAnchorWindowManagerV2 r17 = this.q;
        if (r17 == null) goto L34;
        r17.n = this.D.A();
    L34:
        LinkPkInteractAnchorWindowManagerV2 r18 = this.q;
        if (r18 == null) goto L48;
        r18.j = true;
        com.bytedance.android.live.livepkaudience.base.i r19 = r18.e;
        if (r19 == null) goto L39;
        r19.c(r18);
    L39:
        el0.f r20 = r18.h;
        if (r20 == null) goto L42;
        r20.a.c(r20);
    L42:
        DataCenter r21 = r18.l;
        if (r21 == null) goto L45;
        r21.observeForever("data_link_state", r18);
    L45:
        FragmentActivity r22 = r18.a;
        if (r22 == null) goto L48;
        ((ArrayList) r18.d).add(new el0.a(r22, null, r18, r18.l, null));
        ((ArrayList) r18.d).add(new el0.a(r22, null, r18, r18.l, null));
    L48:
        com.bytedance.android.live.livepkaudience.service.e.y0.getClass();
        com.bytedance.android.live.livepkaudience.service.e r23 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r23 == null) goto L51;
        String r24 = r23.Wc();
    L53:
        if (TextUtils.isEmpty(r24) == true) goto L55;
        bf(true);
    L55:
        LinkPkSwitchCameraManager r25 = new LinkPkSwitchCameraManager(((Widget) this).context, ((Widget) this).dataCenter, getLinkUserCenter(), this);
        this.y = r25;
        r25.j();
        vlc.d r26 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.x = r26;
        if (r26 == null) goto L58;
        r26.addMessageListener(MessageType.LINK_OFFICIAL_KICK_OUT.getIntType(), this);
    L58:
        vlc.d r27 = this.x;
        if (r27 == null) goto L61;
        r27.addMessageListener(MessageType.LINKER.getIntType(), this);
    L61:
        vlc.d r28 = this.x;
        if (r28 == null) goto L64;
        r28.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
    L64:
        vlc.d r29 = this.x;
        if (r29 == null) goto L67;
        r29.addMessageListener(MessageType.LINK_MIC_DYNAMIC_EMOJI_MESSAGE.getIntType(), this);
    L67:
        this.s = new com.bytedance.android.live.livepkaudience.presenter.a(true, ((Widget) this).dataCenter);
        this.u.a(this.C);
        com.bytedance.android.live.livepkaudience.presenter.a r30 = this.s;
        if (r30 == null) goto L70;
        r30.c0(this);
    L70:
        gy.f r31 = this.c;
        if (r31 == null) goto L73;
        r31.m(this);
    L73:
        LinkPkInteractAnchorWindowManagerV2 r32 = this.q;
        if (r32 == null) goto L76;
        r32.r = this.c;
    L76:
        RoomContext r33 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r33 == null) goto L81;
        m r34 = r33.getRoom();
        if (r34 == null) goto L81;
        Room r35 = (Room) r34.getValue();
    L82:
        if (r35 == null) goto L86;
        User r36 = r35.getOwner();
        if (r36 == null) goto L86;
        String r37 = r36.getIdStr();
    L87:
        String r38 = this.m + r37;
        com.bytedance.android.livesdk.sharedpref.e r39 = com.bytedance.android.livesdk.sharedpref.b.g;
        Boolean r40 = (Boolean) ((Map) r39.getValue()).get(r38);
        if (r40 == null) goto L90;
        boolean r41 = r40.booleanValue();
    L91:
        if (r41 == true) goto L93;
        ((Widget) this).dataCenter.put("data_link_pk_interact_show_red_dot", Boolean.FALSE);
        ((Map) r39.getValue()).put(r38, Boolean.TRUE);
    L93:
        com.bytedance.android.live.livepkaudience.service.e r42 = com.bytedance.android.live.livepkaudience.service.e.a.a();
        if (r42 == null) goto L98;
        com.bytedance.android.live.livepkaudience.service.g r43 = r42.ml();
        if (r43 == null) goto L98;
        Map<Long, RoomLinkerContent> r44 = r43.a;
    L99:
        if (r44 != null) goto L101;
        ((Widget) this).dataCenter.observe("cmd_what_receive_apply", this);
    L102:
        hd0.c.f().k(2);
        DataCenter r45 = ((Widget) this).dataCenter;
        if (r45 == null) goto L110;
        jd0.c r46 = (jd0.c) r45.get("data_gift_message_board_linkmic_event", new jd0.c(0));
        if (r46 == null) goto L110;
        if (r2.a(r46.a) == false) goto L110;
        xs2.b.a().post(r46);
        ((Widget) this).dataCenter.put("data_gift_message_board_linkmic_event", null);
    L110:
        if (jc1.k.f(IKtvService.class) == null) goto L123;
        m r47 = jc1.k.n(IKtvService.class).getKtvComponentStatusChangedObservable();
        if (r47 == null) goto L124;
        Observable r48 = r47.a();
        if (r48 == null) goto L125;
        Disposable r49 = r48.subscribe(new com.bytedance.android.live.livepkaudience.widget.a(this));
        if (r49 == null) goto L126;
        RxUtilKt.c(r49, this.r);
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L101:
        Kq();
    L98:
        r44 = null;
        goto L99
    L90:
        r41 = false;
    L86:
        r37 = null;
    L81:
        r35 = null;
        goto L82
    L51:
        r24 = null;
        goto L53
    L120:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L122:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void onResume() {
        super.onResume();
        getLinkUserCenter().C();
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void u0() {
        com.bytedance.android.live.livepkaudience.base.i r0 = getLinkUserCenter();
        CopyOnWriteArrayList<LinkPlayerInfo> r1 = r0.c;
        if (r1 == null) goto L16;
        Iterator<LinkPlayerInfo> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L28;
        IBaseUser r3 = r2.next().getUser();
        if (r3 == null) goto L6;
        String r4 = r3.getIdString();
        if (r4 == null) goto L6;
        if (q0.a(r4) == false) goto L6;
        if (r0.A(r4) == false) goto L6;
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).getPkService().sendGuestKickOut(r4, "");
        goto L6
    L28:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void o() {
        super.o();
    }

    public final void Bq(String r4) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L9:
        if (TextUtils.equals(r4, this.B.y()) == false) goto L13;
        if (r2 == false) goto L14;
        Lq(true, "first_update_with_audience");
        return;
    L14:
        return;
    L13:
        return;
    L7:
        r2 = false;
        goto L9
    }

    public final boolean Cq(String r8) {
        if (TextUtils.equals(r8, this.B.u()) == false) goto L5;
    L35:
        return false;
    L5:
        if (TextUtils.equals(r8, this.B.y()) == true) goto L35;
        Integer r0 = (Integer) ch0.a.getValue();
        List r2 = jc1.k.n(ILinkServiceExternal.class).getMultiAnchorService().d();
        if (r0.intValue() <= 0) goto L30;
        List r3 = r2;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L30;
        Iterator r5 = r2.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        Object r6 = r5.next();
        if (Intrinsics.areEqual(((AnchorLinkUser) r6).getLinkmicIdStr(), r8) == false) goto L19;
    L24:
        if (r6 == null) goto L27;
        return true;
    L27:
        if (getLinkUserCenter().t(r8) == null) goto L30;
        return false;
    L23:
        r6 = null;
        goto L24
    L12:
        if (r3.isEmpty() == true) goto L15;
        r4 = false;
    L30:
        if (r0.intValue() != 1) goto L35;
        if (r8 == null) goto L35;
        if (StringsKt.startsWith$default(r8, "1_", false, 2, null) != true) goto L35;
        return true;
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void D(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        if (Intrinsics.areEqual(jc1.k.n(IUserService.class).user().n(), r6) == false) goto L5;
        return;
    L5:
        com.bytedance.android.live.livepkaudience.base.i r0 = this.o;
        if (r0 == null) goto L16;
        User r7 = r0.q(r6);
        if (r7 != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r7.getNickName()) == false) goto L12;
    L14:
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName()}), 0);
        return;
    L12:
        if (r7.getNickName().length() <= 10) goto L14;
        f2.c(s1.C(2131923165, new Object[]{r7.getNickName().subSequence(0, 10).toString() + "..."}), 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void Em(xe r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        super.Em(r2);
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void Fl(User r6) {
        Intrinsics.checkNotNullParameter(r6, "user");
        Intrinsics.checkNotNullParameter(r6, "user");
        if (((Boolean) u7.a.getValue()).booleanValue() == false) goto L8;
        p r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L7:
        r0.e(r6.getIdString(), r6.getCastSecUid());
        return;
    L8:
        this.i.put(r6.getIdStr(), Long.valueOf(System.currentTimeMillis()));
        this.j = "apply";
        p r1 = this.b;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L11:
        r1.e(r6.getIdString(), r6.getCastSecUid());
    }

    public final void Fq(String r6) {
        Boolean r0 = (Boolean) ((Widget) this).dataCenter.get("data_pk_anchor_silence_status_change", Boolean.FALSE);
        if (getLinkUserCenter().v(r6) != true) goto L10;
        gy.f r1 = this.c;
        if (r1 == null) goto L10;
        if (r6 != null) goto L8;
        String r2 = "";
    L9:
        r1.h(r2, r0.booleanValue(), "pkGuestmuteAudio");
        goto L10
    L8:
        r2 = r6;
    L10:
        String r7 = "muteAudio isMute = " + r0 + ", linkId = " + r6 + ", isNotSelfGuest = " + Boolean.valueOf(getLinkUserCenter().v(r6));
        ALogger.i(this.l, r7);
        dl0.m r3 = dl0.m.a;
        String r4 = this.l + "_muteAudio";
        r3.getClass();
        dl0.m.C(r4, r7);
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void G(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        com.bytedance.android.live.livepkaudience.base.i r0 = this.o;
        if (r0 == null) goto L13;
        User r7 = r0.q(r6);
        if (r7 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r7.getNickName()) == false) goto L9;
    L11:
        f2.c(s1.C(2131923172, new Object[]{r7.getNickName()}), 0);
        return;
    L9:
        if (r7.getNickName().length() <= 10) goto L11;
        f2.c(s1.C(2131923172, new Object[]{r7.getNickName().subSequence(0, 10).toString() + "..."}), 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void b5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        com.bytedance.android.live.livepkaudience.presenter.a r0 = this.s;
        if (r0 == null) goto L6;
        r0.e0(r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void bf(boolean r5) {
        DataCenter r0 = ((Widget) this).dataCenter;
        int r1 = RevLinkDialog.u;
        RevLinkDialog.a r2 = new RevLinkDialog.a(r0, this);
        Room r3 = this.a;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        RevLinkDialog r6 = r2.a(PbRequest.SwitchType.PK, -1, r3, r5);
        this.p = r6;
        FragmentActivity r4 = ((Widget) this).context;
        if ((r4 instanceof FragmentActivity) == false) goto L15;
        if (r4 == null) goto L14;
        FragmentManager r7 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "RevLinkDialog", r8);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r7, r6, r8) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L12:
        r6.show(r7, "RevLinkDialog");
        return;
    L20:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void finishInteract(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reqFrom");
        ((Widget) this).dataCenter.put("data_interact_number_dot_show", "");
        wq(this.d, r4);
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L8;
        Boolean r0 = Boolean.FALSE;
        if (((Boolean) r5.get("data_talk_room_admin_allowed_flag", r0)).booleanValue() == false) goto L9;
        r5.put("data_talk_room_admin_allowed_flag", r0);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void markSwitchToMulti(boolean r1) {
        this.z = r1;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void nm(xe r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        User r0 = new User();
        r0.setIdStr(r3.getFromUserIdStr());
        r0.setCastSecUid(r3.getSecFromUserId());
        Fl(r0);
    }

    public final void onChanged(Object r8) {
        KVData r9 = (KVData) r8;
        if (r9 == null) goto L88;
        String r0 = r9.getKey();
        r r3 = null;
        int r4 = 0;
        switch(r0.hashCode()) {
            case -1540323875: goto L76;
            case -1205238432: goto L73;
            case -1018269700: goto L70;
            case -95319361: goto L67;
            case 725404490: goto L32;
            case 1080946897: goto L26;
            case 1715701863: goto L23;
            case 2140954685: goto L8;
            default: goto L108;
        };
    L108:
        return;
    L8:
        if (r0.equals("cmd_what_audience_join_self_link") == false) goto L89;
        gy.f r1 = this.c;
        if (r1 == null) goto L14;
        s r2 = r1.L();
        if (r2 == null) goto L14;
        r3 = r2.e(this.B.y());
    L14:
        if (r3 == null) goto L90;
        Boolean r5 = (Boolean) r9.getData();
        if (r5 != null) goto L18;
        r5 = Boolean.FALSE;
    L18:
        Aq(r5.booleanValue(), false);
        Boolean r10 = (Boolean) r9.getData();
        if (r10 != null) goto L21;
        r10 = Boolean.FALSE;
    L21:
        Lq(r10.booleanValue(), "with_audience_change");
        return;
    L90:
        return;
    L89:
        return;
    L23:
        if (r0.equals("cmd_force_close_linkin_before_videotalk") == false) goto L92;
        wq(this.d, "stop_intimate_before_big_party");
        return;
    L92:
        return;
    L26:
        if (r0.equals("cmd_what_audience_join_guest_link") == false) goto L94;
        Boolean r11 = (Boolean) r9.getData();
        if (r11 != null) goto L30;
        r11 = Boolean.FALSE;
    L30:
        Aq(r11.booleanValue(), false);
        return;
    L94:
        return;
    L32:
        if (r0.equals("data_observe_pk_id_start") == false) goto L96;
        this.B.getPkId();
        int r12 = al0.b.a;
        if (v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 32) == true) goto L36;
        return;
    L36:
        if (this.A == true) goto L98;
        this.e = System.currentTimeMillis();
        this.A = true;
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L41;
        String r7 = (String) r6.get("data_anchor_video_talk_room_init_source", "");
        if (r7 == null) goto L41;
    L42:
        Room r13 = this.a;
        if (r13 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L45:
        if (r13 == null) goto L47;
        r r14 = r13.getCircleInfo();
    L49:
        if ((r14 instanceof CircleInfo) == false) goto L52;
        r3 = r14;
    L52:
        CircleInfo r15 = (CircleInfo) r3;
        Intrinsics.checkNotNullParameter(r7, "requestPage");
        HashMap r16 = new HashMap();
        r16.put("live_type", "video_live");
        r16.put("function_type", al0.b.d());
        r16.put("function_type2", al0.b.d());
        r16.put("shoot_way", "null");
        r16.put("source", "");
        r16.put("request_page", r7);
        if (r15 == null) goto L58;
        String r17 = r15.getCircleName();
        if (r17 == null) goto L58;
        r16.put("circle_name", r17);
    L58:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue() == false) goto L60;
        String r18 = "on";
    L61:
        r16.put("is_camera_allow", r18);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L64;
        String r19 = "1";
    L65:
        r16.put("is_invite_only", r19);
        al0.b.c(r16);
        u.l().sendLog("livesdk_anchor_audience_connection_open_success", r16, new Object[]{x.class, Room.class});
        return;
    L64:
        r19 = "0";
        goto L65
    L60:
        r18 = "off";
        goto L61
    L47:
        r14 = null;
    L41:
        r7 = "";
        goto L42
    L98:
        return;
    L96:
        return;
    L67:
        if (r0.equals("cmd_force_close_linkin") == false) goto L100;
        wq(this.d, "forbidden_notice");
        return;
    L100:
        return;
    L70:
        if (r0.equals("cmd_what_receive_apply") == false) goto L102;
        Kq();
        return;
    L102:
        return;
    L73:
        if (r0.equals("data_anchor_video_talk_room_init_source") == false) goto L104;
        this.e = System.currentTimeMillis();
        return;
    L104:
        return;
    L76:
        if (r0.equals("cmd_pk_state_change") == false) goto L106;
        z0 r20 = (z0) r9.getData();
        int r21 = this.v;
        if (r20 == null) goto L82;
        if (r21 != r20.d) goto L82;
        return;
    L82:
        if (((Boolean) o7.a.getValue()).booleanValue() == false) goto L109;
        if (r20 == null) goto L86;
        r4 = r20.d;
    L86:
        this.v = r4;
        zq();
        return;
    L109:
        return;
    L106:
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onMessage(tlc.d r23) {
        if (r23 != null) goto L5;
        return;
    L5:
        int r3 = 0;
        boolean r4 = false;
        r4 = false;
        boolean r5 = false;
        r5 = false;
        if ((r23 instanceof ye) == false) goto L8;
        ye r1 = (ye) r23;
        f2.c(r1.getMToastMsg(), 0);
        kickOut(r1.getUserId(), "", "msequence_msg");
        return;
    L8:
        String r6 = null;
        long r7 = 0;
        if ((r23 instanceof if) == false) goto L206;
        if r2 = (if) r23;
        if (r2.getMType() != 6) goto L13;
        return;
    L13:
        if (r2.getMType() != 11) goto L74;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L19;
        Integer r9 = (Integer) r8.get("data_link_state", 0);
        if (r9 == null) goto L19;
        int r10 = r9.intValue();
    L20:
        boolean r11 = v.a(r10, 4);
        String r12 = this.l;
        StringBuilder r13 = new StringBuilder("onMessage LINKER_LINKED_CHANGE content = ");
        ILinkerLinkedListChangeContent r14 = r2.getMLinkedListChange();
        if (r14 == null) goto L23;
        r6 = r14.toString();
    L23:
        r13.append(r6);
        r13.append(", isPk = ");
        r13.append(r11);
        r13.append(", scene = ");
        r13.append(r2.mScene);
        ALogger.i(r12, r13.toString());
        if (this.n.contains(Integer.valueOf(r2.mScene)) == true) goto L26;
        return;
    L26:
        lc0.d r15 = jc1.k.n(ILinkServiceExternal.class).getPkService();
        ILinkerLinkedListChangeContent r16 = r2.getMLinkedListChange();
        if (r16 == null) goto L69;
        Map r17 = r16.getLinkerContentMap();
        if (r17 == null) goto L69;
        if (r15 == null) goto L34;
        Room r18 = r15.b();
        if (r18 == null) goto L34;
        long r19 = r18.id;
    L36:
        if (r19 <= 0) goto L41;
        if (r15 == null) goto L45;
        Room r20 = r15.b();
        if (r20 == null) goto L45;
        r7 = r20.id;
    L45:
        g2 r21 = (g2) r17.get(Long.valueOf(r7));
        if (r21 != null) goto L48;
    L50:
        ((Widget) this).dataCenter.put("data_pk_anchor_silence_status_change", Boolean.valueOf(r4));
        ILinkServiceExternal r22 = jc1.k.f(ILinkServiceExternal.class);
        if (r22 == null) goto L53;
        r22.notifyPkAnchorSilenceStatus(r4);
    L53:
        LinkPkInteractAnchorWindowManagerV2 r24 = this.q;
        if (r24 == null) goto L56;
        r24.q(r4);
    L56:
        g2 r25 = (g2) r17.get(Long.valueOf(r7));
        if (r25 == null) goto L69;
        List r26 = r25.getLinkedUsers();
        if (r26 == null) goto L69;
        Iterator r27 = r26.iterator();
    L62:
        if (r27.hasNext() == false) goto L69;
        com.bytedance.android.livesdk.link.model.bridge.k r28 = (com.bytedance.android.livesdk.link.model.bridge.k) r27.next();
        gy.f r29 = this.c;
        if (r29 == null) goto L62;
        String r30 = r28.getInteractId();
        if (r30 != null) goto L68;
        r30 = "";
    L68:
        r29.h(r30, r4, "linker_linked_change");
        goto L62
    L48:
        if (r21.getRoomLinkSilenceStatus() != 1) goto L50;
        r4 = true;
        goto L50
    L41:
        if (r15 == null) goto L45;
        User r31 = r15.C();
        if (r31 == null) goto L45;
        r7 = r31.getLiveRoomId();
    L34:
        r19 = 0;
    L69:
        if (r11 != true) goto L270;
        gy.f r32 = this.c;
        if (r32 == null) goto L271;
        r32.m(this);
        return;
    L271:
        return;
    L270:
        return;
    L19:
        r10 = 0;
        goto L20
    L74:
        if (r2.getMType() != 41) goto L119;
        lc0.d r33 = jc1.k.n(ILinkServiceExternal.class).getPkService();
        LinkRoomFightUpdateContent r34 = r2.linkerCrossRoomUpdateContent;
        if (r34 == null) goto L273;
        Map r35 = r34.getLinkerContentMap();
        if (r35 == null) goto L274;
        if (r33 == null) goto L83;
        Room r36 = r33.b();
        if (r36 == null) goto L83;
        long r110 = r36.id;
    L85:
        if (r110 <= 0) goto L90;
        if (r33 == null) goto L94;
        Room r37 = r33.b();
        if (r37 == null) goto L94;
        r7 = r37.id;
    L94:
        RoomLinkerContent r38 = (RoomLinkerContent) r35.get(Long.valueOf(r7));
        if (r38 != null) goto L97;
    L99:
        ((Widget) this).dataCenter.put("data_pk_anchor_silence_status_change", Boolean.valueOf(r5));
        ILinkServiceExternal r39 = jc1.k.f(ILinkServiceExternal.class);
        if (r39 == null) goto L102;
        r39.notifyPkAnchorSilenceStatus(r5);
    L102:
        LinkPkInteractAnchorWindowManagerV2 r40 = this.q;
        if (r40 == null) goto L105;
        r40.q(r5);
    L105:
        ALogger.i(this.l, "onMessage TYPE_LINKER_CROSS_ROOM_UPDATE key = " + r7 + ", isMute = " + r5);
        RoomLinkerContent r41 = (RoomLinkerContent) r35.get(Long.valueOf(r7));
        if (r41 == null) goto L275;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r42 = r41.linkedUsers;
        if (r42 == null) goto L276;
        Iterator<T> r43 = r42.iterator();
    L111:
        if (r43.hasNext() == false) goto L298;
        com.bytedance.android.livesdk.link.model.bridge.k r44 = (com.bytedance.android.livesdk.link.model.bridge.k) r43.next();
        gy.f r45 = this.c;
        if (r45 == null) goto L111;
        String r46 = r44.getInteractId();
        if (r46 != null) goto L117;
        r46 = "";
    L117:
        r45.h(r46, r5, "linker_cross_room_update");
        goto L111
    L298:
        return;
    L276:
        return;
    L275:
        return;
    L97:
        if (r38.mRoomLinkSilenceStatus != 1) goto L99;
        r5 = true;
        goto L99
    L90:
        if (r33 == null) goto L94;
        User r47 = r33.C();
        if (r47 == null) goto L94;
        r7 = r47.getLiveRoomId();
    L83:
        r110 = 0;
        goto L85
    L274:
        return;
    L273:
        return;
    L119:
        if (r2.getMType() != 46) goto L188;
        String r48 = this.l;
        StringBuilder r49 = new StringBuilder("onMessage TYPE_LINK_RESUME_AUDIENCE content = ");
        LinkerResumeAudienceContent r50 = r2.getLinkerResumeAudienceContent();
        if (r50 == null) goto L123;
        String r51 = r50.toString();
    L124:
        r49.append(r51);
        ALogger.i(r48, r49.toString());
        DataCenter r52 = ((Widget) this).dataCenter;
        if (r52 == null) goto L127;
        String r53 = (String) r52.get("data_room_unique_id", "");
    L128:
        tc0.c.i(r53).O = r2.getLinkerResumeAudienceContent();
        tc0.c r54 = tc0.c.h();
        LinkerResumeAudienceContent r55 = r2.getLinkerResumeAudienceContent();
        if (r55 == null) goto L131;
        String r56 = r55.getRtcExtInfo();
    L132:
        r54.k = r56;
        tc0.c r57 = tc0.c.h();
        LinkerResumeAudienceContent r58 = r2.getLinkerResumeAudienceContent();
        if (r58 == null) goto L135;
        String r59 = r58.getLiveCoreExtInfo();
    L136:
        r57.m = r59;
        LinkerResumeAudienceContent r60 = r2.getLinkerResumeAudienceContent();
        if (r60 == null) goto L167;
        List r61 = r60.getMLinkUsers();
        if (r61 == null) goto L167;
        Iterator r62 = r61.iterator();
    L142:
        if (r62.hasNext() == false) goto L160;
        Object r63 = r62.next();
        com.bytedance.android.livesdk.link.model.bridge.k r65 = (com.bytedance.android.livesdk.link.model.bridge.k) r63;
        if (r65 == null) goto L159;
        User r66 = ((AnchorLinkUser) r65).getMUser();
        if (r66 == null) goto L148;
        String r67 = r66.getIdString();
    L149:
        Room r68 = this.a;
        if (r68 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L152:
        if (r68 == null) goto L154;
        String r69 = r68.getOwnerUserIdString();
    L156:
        if (Intrinsics.areEqual(r67, r69) == false) goto L142;
    L161:
        com.bytedance.android.livesdk.link.model.bridge.k r70 = (com.bytedance.android.livesdk.link.model.bridge.k) r63;
        if (r70 == null) goto L167;
        AnchorLinkUser r71 = (AnchorLinkUser) r70;
        if (TextUtils.isEmpty(r71.getMLinkmicIdStr()) == false) goto L166;
        tc0.c.h().f = String.valueOf(r71.getMLinkmicId());
        tc0.c.h().e = String.valueOf(r71.getMLinkmicId());
        goto L167
    L166:
        tc0.c.h().f = r71.getMLinkmicIdStr();
        tc0.c.h().e = r71.getMLinkmicIdStr();
        goto L167
    L154:
        r69 = null;
        goto L156
    L148:
        r67 = null;
        goto L149
    L159:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser");
    L160:
        r63 = null;
    L167:
        gy.f r72 = this.c;
        if (r72 == null) goto L174;
        LinkerResumeAudienceContent r73 = r2.getLinkerResumeAudienceContent();
        if (r73 == null) goto L172;
        String r74 = r73.getRtcExtInfo();
    L173:
        r72.Q(r74, "TYPE_LINK_RESUME_AUDIENCE");
        goto L174
    L172:
        r74 = null;
    L174:
        gy.f r75 = this.c;
        if (r75 == null) goto L181;
        LinkerResumeAudienceContent r76 = r2.getLinkerResumeAudienceContent();
        if (r76 == null) goto L179;
        r6 = r76.getLiveCoreExtInfo();
    L179:
        r75.T(r6, "TYPE_LINK_RESUME_AUDIENCE");
    L181:
        if (((Boolean) df1.a.getValue()).booleanValue() == false) goto L277;
        gy.f r77 = this.c;
        if (r77 == null) goto L278;
        d0 r78 = r77.getLiveCore();
        if (r78 == null) goto L279;
        r78.I();
        return;
    L279:
        return;
    L278:
        return;
    L277:
        return;
    L135:
        r59 = null;
        goto L136
    L131:
        r56 = null;
        goto L132
    L127:
        r53 = null;
        goto L128
    L123:
        r51 = null;
        goto L124
    L188:
        if (r2.getMType() != 53) goto L281;
        LinkerChangeMediaInfoContent r79 = r2.getLinkerChangeMediaInfoContent();
        if (r79 == null) goto L204;
        IKtvService r80 = jc1.k.f(IKtvService.class);
        if (r80 != null) goto L194;
        return;
    L194:
        if (r80.isInKtvState(1) != true) goto L283;
        ILinkmicMediaParam r81 = r79.getLinkmicMediaParam();
        if (r81 == null) goto L200;
        r0 r82 = r81.getKtvComponentMediaInfo();
        if (r82 == null) goto L200;
        r6 = r82.getLiveCoreExtInfo();
    L200:
        if (r6 == null) goto L284;
        gy.f r83 = this.c;
        if (r83 == null) goto L285;
        gy.f.a.a(r83, r6);
        return;
    L285:
        return;
    L284:
        return;
    L283:
        return;
    L204:
        return;
    L281:
        return;
    L206:
        if ((r23 instanceof LinkMicGuideMessage) == false) goto L237;
        LinkMicGuideMessage r84 = (LinkMicGuideMessage) r23;
        if (r84.guidelineType != 12) goto L287;
        LinkMicGuideMessage.d r85 = r84.pkLinkBubbleContent;
        if (r85 == null) goto L212;
        String r111 = r85.toast;
    L213:
        RoomContext r86 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r86 == null) goto L218;
        m r87 = r86.getRoom();
        if (r87 == null) goto L218;
        Room r88 = (Room) r87.getValue();
    L219:
        if (r88 == null) goto L223;
        User r89 = r88.getOwner();
        if (r89 == null) goto L223;
        r6 = r89.getIdStr();
    L223:
        String r90 = this.m + r6;
        long r91 = System.currentTimeMillis();
        com.bytedance.android.livesdk.sharedpref.e r92 = com.bytedance.android.livesdk.sharedpref.b.f;
        Long r93 = (Long) ((Map) r92.getValue()).get(r90);
        if (r93 == null) goto L226;
        r7 = r93.longValue();
    L226:
        com.bytedance.android.livesdk.sharedpref.e r210 = com.bytedance.android.livesdk.sharedpref.b.d;
        Integer r94 = (Integer) ((Map) r210.getValue()).get(r90);
        if (r94 == null) goto L229;
        r3 = r94.intValue();
    L229:
        long r112 = 86400000;
        if (((r91 / r112) - (r7 / r112)) >= 1) goto L232;
        return;
    L232:
        if (r3 > 2) goto L296;
        if (r111 == null) goto L289;
        pp1.c r95 = new pp1.c(r111, null, null, 0, null, null, 0, 0, null, 0, 8190);
        ((Map) r92.getValue()).put(r90, Long.valueOf(r91));
        ((Map) r210.getValue()).put(r90, Integer.valueOf(r3 + 1));
        y3.m(((Widget) this).dataCenter).b(ToolbarButton.INTERACTION, r95);
        return;
    L289:
        return;
    L296:
        return;
    L218:
        r88 = null;
        goto L219
    L212:
        r111 = null;
        goto L213
    L287:
        return;
    L237:
        if ((r23 instanceof ue) == false) goto L291;
        LinkPkInteractAnchorWindowManagerV2 r96 = this.q;
        if (r96 == null) goto L292;
        ue r97 = (ue) r23;
        Intrinsics.checkNotNullParameter(r97, "emojiMessage");
        if (r97.isThanksInteractEmoji() == false) goto L246;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isQuickInteractEnable() == true) goto L246;
        return;
    L246:
        if (r97.isInteractEmoji() == false) goto L250;
        DataCenter r98 = r96.l;
        if (r98 == null) goto L293;
        r98.put("cmd_show_dynamic_emoji_in_comment", r97);
        return;
    L293:
        return;
    L250:
        com.bytedance.android.live.livepkaudience.seat.f r99 = r96.w;
        if (r99 == null) goto L295;
        int r100 = com.bytedance.android.live.livepkaudience.seat.e.a;
        wj0.b r101 = new wj0.b(r97.getFromUser(), r97.getDynamicEmoji(), r97.getRandomEmojiImage(), r97.getBaseMessage());
        Intrinsics.checkNotNullParameter(r101, "info");
        r99.a(new com.bytedance.android.live.livepkaudience.seat.c(r101));
        return;
    L295:
        return;
    L292:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void onPermitSuccess(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r2, "uid");
        gy.f r3 = this.c;
        if (r3 == null) goto L6;
        r3.m(this);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void u3(String r3) {
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        com.bytedance.android.live.livepkaudience.presenter.a r1 = this.s;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r3, "toUserId");
        r1.d0(r3, 0);
        return;
    }

    public final void Aq(boolean r6, boolean r7) {
        gy.f r0 = this.c;
        if (r0 == null) goto L8;
        s r1 = r0.L();
        if (r1 == null) goto L8;
        Map r2 = r1.c();
        if (r2 == null) goto L8;
    L9:
        Object r3 = r2.get(this.B.y());
        String r8 = "adjustPkSingleView myLayer = " + r3 + ", bottom = " + (1.0f - ((float) (com.bytedance.android.live.livepkaudience.rtc.d.i / com.bytedance.android.live.livepkaudience.rtc.d.h))) + ", skipCheck = " + r7 + ", adjust = " + r6 + ", guestLinkMicId = " + jc1.k.n(ILinkServiceExternal.class).getMultiDataHolderExternal().y();
        ALogger.i(this.l, r8);
        dl0.m r9 = dl0.m.a;
        String r4 = this.l + "_adjustPkSingleView";
        r9.getClass();
        dl0.m.C(r4, r8);
        boolean r10 = r3 instanceof z.a;
        return;
    L8:
        r2 = MapsKt.emptyMap();
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void F(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        ExceptionUtils.handleException(((Widget) this).context, r3, 2131919335);
    }

    public final RectF Iq(int r6, float r7) {
        int r0 = Jq();
        ILinkServiceExternal r1 = jc1.k.f(ILinkServiceExternal.class);
        if (r1 == null) goto L7;
        lc0.d r2 = r1.getPkService();
        if (r2 == null) goto L7;
        oq2.d r3 = r2.G();
    L8:
        int r4 = 0;
        if (r3 == null) goto L11;
        int r5 = r3.a;
    L12:
        if (r3 == null) goto L14;
        int r8 = r3.c;
    L15:
        float r9 = r0;
        float r10 = (r5 + r8) / r9;
        if (r3 == null) goto L19;
        r4 = r3.c;
    L19:
        return new RectF(r6 * 0.25f, r10 - ((r4 * r7) / r9), (r6 + 1) * 0.25f, r10);
    L14:
        r8 = 0;
        goto L15
    L11:
        r5 = 0;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void L2(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r2, "uid");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    public final void Lq(boolean r6, String r7) {
        lc0.d r0 = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal();
        MultiLiveCoreInfo r1 = r0.multiLiveCoreInfo();
        if (r1 == null) goto L14;
        MultiAnchorLinkmicLiveCoreInfo r2 = r1.multiAnchorLiveCoreInfo;
        if (r2 == null) goto L14;
        Map r3 = r2.liveCoreExtInfoMap;
        if (r3 == null) goto L14;
        gy.f r4 = this.c;
        if (r4 == null) goto L14;
        if (r6 == false) goto L12;
        Object r5 = r3.get(3L);
    L13:
        r4.T((String) r5, r7);
        goto L14
    L12:
        r5 = r3.get(2L);
    L14:
        MultiRtcInfo r8 = r0.multiRtcInfo();
        if (r8 == null) goto L27;
        MultiAnchorLinkmicRtcInfo r9 = r8.mMultiAnchorLinkmicRtcInfo;
        if (r9 == null) goto L28;
        Map r10 = r9.rtcInfoMap;
        if (r10 == null) goto L29;
        gy.f r11 = this.c;
        if (r11 == null) goto L30;
        if (r6 == false) goto L24;
        Object r12 = r10.get(3L);
    L25:
        r11.Q((String) r12, r7);
        return;
    L24:
        r12 = r10.get(2L);
        goto L25
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void R(long r1, Exception r3) {
        super.R(r1, r3);
        f2.h(getContext(), 2131919334, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void V4(String r19, z.a r20) {
        if (Cq(r19) == false) goto L6;
        String r1 = "intercept first frame " + r19 + " from other anchor";
        ALogger.i(this.l, r1);
        dl0.m r2 = dl0.m.a;
        String r3 = this.l + "_onFirstRemoteVideoFrameRender";
        r2.getClass();
        dl0.m.C(r3, r1);
        return;
    L6:
        Eq();
        Fq(r19);
        Bq(r19);
        LinkPkInteractAnchorWindowManagerV2 r4 = this.q;
        String r5 = "";
        if (r4 == null) goto L12;
        if (r19 != null) goto L10;
        String r6 = "";
    L11:
        r4.n(r6, null);
        goto L12
    L10:
        r6 = r19;
    L12:
        DataCenter r7 = ((Widget) this).dataCenter;
        boolean r8 = false;
        if (r7 == null) goto L17;
        Boolean r9 = (Boolean) r7.get("cmd_what_audience_join_self_link", Boolean.FALSE);
        if (r9 == null) goto L17;
        boolean r10 = r9.booleanValue();
    L18:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L23;
        Boolean r12 = (Boolean) r11.get("cmd_what_audience_join_guest_link", Boolean.FALSE);
        if (r12 == null) goto L23;
        boolean r13 = r12.booleanValue();
    L24:
        boolean r14 = ((com.bytedance.android.live.liveinteract.service.f) ((IInteractService) jc1.k.n(IInteractService.class)).getInteractAudienceService()).P();
        boolean r15 = true;
        if (TextUtils.equals(r19, this.B.u()) == true) goto L145;
        if (TextUtils.equals(r19, this.B.y()) == true) goto L145;
        com.bytedance.android.live.livepkaudience.base.i r16 = this.o;
        if (r16 == null) goto L143;
        boolean r17 = r16.v(r19);
        com.bytedance.android.live.livepkaudience.base.i r18 = this.o;
        if (r18 == null) goto L141;
        String r21 = r18.r(r19);
        com.bytedance.android.live.livepkaudience.base.i r110 = this.o;
        if (r110 == null) goto L139;
        int r22 = r110.O4(r21);
        if (r17 == false) goto L38;
        int r23 = r22 + 1;
    L39:
        String r24 = "onFirstRemoteVideoFrameRender ILayerControl linkId = " + r19 + ", isLinkWithAudience = " + r14 + ", isNotSelfGuest = " + r17 + ", guestPos = " + r22 + ", realPos = " + r23;
        ALogger.e(this.l, r24);
        dl0.m r25 = dl0.m.a;
        String r26 = this.l + "_onFirstRemoteVideoFrameRender";
        r25.getClass();
        dl0.m.C(r26, r24);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r27 = ILiveWrappedLivePusher.a.b();
        if (r27 == null) goto L42;
        m1.b r28 = r27.newVideoMixerDescription(null);
    L43:
        Iq(r23, (float) (com.bytedance.android.live.livepkaudience.rtc.d.i / com.bytedance.android.live.livepkaudience.rtc.d.h));
        if (r28 == null) goto L46;
        r28.e();
    L46:
        if (r28 == null) goto L48;
        r28.b();
    L48:
        if (r28 == null) goto L50;
        r28.c();
    L50:
        if (r28 == null) goto L52;
        r28.f();
    L52:
        if (r28 == null) goto L54;
        r28.h();
    L54:
        if (r28 == null) goto L56;
        r28.i();
    L56:
        if (r28 == null) goto L58;
        r28.g();
    L58:
        if (r20 == null) goto L60;
        r20.b();
    L60:
        Aq(true, false);
        if (((Boolean) oh0.a.getValue()).booleanValue() == false) goto L170;
        gy.f r29 = this.c;
        if (r29 == null) goto L68;
        s r30 = r29.L();
        if (r30 == null) goto L68;
        Map r31 = r30.c();
        if (r31 == null) goto L68;
    L70:
        if (r31.get(this.B.y()) == null) goto L171;
        List r32 = CollectionsKt.toMutableList(r31.values());
        gy.f r33 = this.c;
        if (r33 == null) goto L80;
        d0 r34 = r33.getLiveCore();
        if (r34 == null) goto L80;
        z r35 = r34.C();
        if (r35 == null) goto L80;
        z.a r36 = r35.K0();
        if (r36 == null) goto L80;
        r32.add(r36);
    L80:
        Intrinsics.checkNotNullParameter(r32, "layers");
        List r37 = r32;
        int r38 = r37.size();
        int r39 = 0;
    L81:
        if (r39 >= r38) goto L120;
        int r40 = r39 + 1;
        int r111 = r32.size();
        int r112 = r40;
    L83:
        if (r112 >= r111) goto L119;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r113 = ILiveWrappedLivePusher.a.b();
        if (r113 == null) goto L118;
        z.a r114 = r113.buildLayerControlLayer(ListProtector.get(r32, r39));
        if (r114 == null) goto L118;
        m1.b r115 = r114.Y();
        if (r115 == null) goto L118;
        ILiveWrappedLivePusher r116 = ILiveWrappedLivePusher.a.b();
        if (r116 == null) goto L118;
        z.a r117 = r116.buildLayerControlLayer(ListProtector.get(r32, r112));
        if (r117 == null) goto L118;
        m1.b r118 = r117.Y();
        if (r118 == null) goto L118;
        if (dl0.m.t(r115) == true) goto L118;
        if (dl0.m.t(r118) == true) goto L118;
        if (r115.getLeft() < r118.getRight()) goto L106;
    L108:
        boolean r119 = false;
    L110:
        if (r115.getTop() < r118.getBottom()) goto L112;
    L114:
        boolean r120 = false;
    L115:
        if (r119 == false) goto L118;
        if (r120 == false) goto L118;
        r8 = true;
        goto L120
    L112:
        if (r115.getBottom() <= r118.getTop()) goto L114;
        r120 = true;
        goto L115
    L106:
        if (r115.getRight() <= r118.getLeft()) goto L108;
        r119 = true;
    L118:
        r112 = r112 + 1;
        goto L83
    L119:
        r39 = r40;
    L120:
        if (r8 == true) goto L122;
        return;
    L122:
        if (r37.isEmpty() == true) goto L173;
        Iterator r41 = r32.iterator();
    L126:
        if (r41.hasNext() == false) goto L136;
        Object r42 = r41.next();
        if (r42 == null) goto L135;
        m1.b r43 = ((z.a) r42).Y();
        if (r43 == null) goto L132;
        String r44 = "【l = " + r43.getLeft() + ", r = " + r43.getRight() + ", t = " + r43.getTop() + ", b = " + r43.getBottom() + 12305;
    L133:
        r5 = r5 + ' ' + r44 + ',';
        goto L126
    L132:
        r44 = null;
        goto L133
    L135:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLayerControl.ILiveWrappedLayer");
    L136:
        JSONObject r45 = new JSONObject();
        BaseMonitor.add(r45, "business_api_name", "single_view_layer_overlap");
        BaseMonitor.add(r45, "layers", r5);
        dl0.m.l(r45);
        HashMap r46 = new HashMap();
        r46.put("business_api_name", "single_view_layer_overlap");
        r46.put("role_type", dl0.m.p());
        dy.b r47 = dy.b.a;
        r46.put("android_event_key", "single_view_layer_overlap");
        dy.b.e("ttlive_pk_business_api_call", LiveTracingMonitor.EventModule.PK, r46, r45);
        return;
    L173:
        return;
    L171:
        return;
    L68:
        r31 = MapsKt.emptyMap();
        goto L70
    L170:
        return;
    L42:
        r28 = null;
        goto L43
    L38:
        r23 = r22 - 1;
        goto L39
    L139:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L141:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L143:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.livepkaudience.base.LinkPkUserInfoCenter");
    L145:
        if (TextUtils.equals(r19, this.B.u()) == false) goto L151;
        if (r10 == true) goto L150;
        if (r14 == true) goto L150;
        r15 = false;
    L150:
        Aq(r15, false);
        return;
    L151:
        Aq(r13, false);
        return;
    L23:
        r13 = false;
    L17:
        r10 = false;
        goto L18
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void V6(String r2, LinkInviteResult r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r3, "result");
        super.V6(r2, r3);
        f2.b(2131918074, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void c7(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L12:
        boolean r1 = com.bytedance.android.live.revenue.core.util.h.a;
        q r4 = com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).getPkService();
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r4.sendGuestKickOut(r2, r3);
        return;
    L11:
        if (q0.a(r2) == true) goto L12;
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void e1(String r2, long r3) {
        if (Cq(r2) == false) goto L5;
        return;
    L5:
        super.e1(r2, r3);
        com.bytedance.android.live.livepkaudience.base.i r4 = this.o;
        if (r4 == null) goto L8;
        r4.E(r2);
    L8:
        LinkPkInteractAnchorWindowManagerV2 r5 = this.q;
        if (r5 == null) goto L12;
        r5.a("0", r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void f0(long r1, Exception r3) {
        super.f0(r1, r3);
        f2.b(2131919447, 0);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget, com.bytedance.android.live.livepkaudience.base.g
    public final void l(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        Intrinsics.checkNotNullParameter(r2, "uid");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.presenter.a.InterfaceC0115a
    public final void r(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "toUserId");
        if ((r3 instanceof ApiServerException) == false) goto L6;
        f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    }

    public LinkPkInteractAudienceAnchorWidget(v0 r2, LinkPkInteractGuestDataContext r3, BasePkInteractAnchorWidget.a r4) {
        Intrinsics.checkNotNullParameter(r2, "videoClientFactory");
        Intrinsics.checkNotNullParameter(r3, "linkPkInteractDataContext");
        this.D = r2;
        this.E = r3;
        this.l = "LinkPkInteractAudienceAnchorWidget";
        this.m = "show_bubble_tag_anchor";
        this.n = SetsKt.setOf(new Integer[]{1, 8});
        this.r = new CompositeDisposable();
        this.t = ((IInteractService) jc1.k.n(IInteractService.class)).getAnimationController();
        this.u = jc1.k.n(ILinkServiceExternal.class).getPkServiceExternal();
        this.w = new a(this);
        this.B = jc1.k.n(ILinkServiceExternal.class).getMultiDataHolder();
        this.C = new c(this);
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void S(String r5, int r6, int r7) {
        LinkPkInteractAnchorWindowManagerV2 r0 = this.q;
        if (r0 == null) goto L14;
        Iterator r1 = ((ArrayList) r0.c).iterator();
    L6:
        if (r1.hasNext() == false) goto L20;
        el0.a r2 = (el0.a) r1.next();
        el0.g r3 = r2.getPresenter();
        if (r3 == null) goto L10;
        String r4 = r3.c();
    L12:
        if (Intrinsics.areEqual(r4, r5) == false) goto L6;
        r2.setDebugText(r6 + " x " + r7);
        goto L6
    L10:
        r4 = null;
        goto L12
    L20:
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void kickOut(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "uid");
        Intrinsics.checkNotNullParameter(r5, "reqFrom");
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r5 = "anchor_stop_normal";
    L8:
        p r1 = this.b;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L11:
        r1.d(r3, r4, r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void j0(String r1, TextureView r2, int r3, int r4) {
        if (Cq(r1) == false) goto L5;
        return;
    L5:
        Eq();
        Fq(r1);
        Bq(r1);
        LinkPkInteractAnchorWindowManagerV2 r5 = this.q;
        if (r5 == null) goto L11;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r5.n(r1, r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void switchAudioByClient(boolean r9, List<AnchorLinkUser> r10, long r11, Map<Long, ? extends RoomLinkerContent> r13) {
        Intrinsics.checkNotNullParameter(r10, "linkedUsers");
        gy.f r0 = this.c;
        if (r0 == null) goto L5;
        r0.u1(!r9);
    L5:
        com.bytedance.android.live.livepkaudience.base.i r2 = getLinkUserCenter();
        if (r9 == false) goto L8;
        String r12 = "silence";
    L9:
        r2.I(r10, r11, r12, r13);
        return;
    L8:
        r12 = "unSilence";
        goto L9
    }

    @Override // com.bytedance.android.live.livepkaudience.base.BasePkInteractAnchorWidget
    public final void y0(String r1, SurfaceView r2, int r3, int r4) {
        if (Cq(r1) == false) goto L5;
        return;
    L5:
        Eq();
        Fq(r1);
        Bq(r1);
        LinkPkInteractAnchorWindowManagerV2 r5 = this.q;
        if (r5 == null) goto L11;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r5.n(r1, r2);
        return;
    }

    @Override // com.bytedance.android.live.livepkaudience.service.b
    public final void invite(long r11, String r13, String r14, int r15, long r16) {
        Intrinsics.checkNotNullParameter(r13, "uid");
        Intrinsics.checkNotNullParameter(r14, "secUid");
        p r1 = this.b;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("linkManager");
    L5:
        o.c(r1, r11, r13, r14, r15, r16, 32);
    }
}
