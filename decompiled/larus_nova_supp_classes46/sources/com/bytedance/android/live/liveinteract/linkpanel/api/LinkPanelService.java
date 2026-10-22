package com.bytedance.android.live.liveinteract.linkpanel.api;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestApplyDialog;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.LinkPanelManageDialog;
import com.bytedance.android.live.liveinteract.linkpanel.util.p;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.linkpanel.vm.AdminInviteAndApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.vm.GuestApplyViewModel;
import com.bytedance.android.live.liveinteract.linkpanel.widget.GuestApplyTopBarWidget;
import com.bytedance.android.live.liveinteract.plantform.base.LinkInternalServiceContext;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.MultiLinkPanelLifecycle;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.WaitingListType;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.chatroom.y0;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/api/LinkPanelService;", "Lcom/bytedance/android/live/liveinteract/component/api/linkpanel/ILinkPanelService;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPanelService implements ILinkPanelService {
    public LinkPanelManageDialog a;
    public GuestApplyDialog b;
    public final HashSet<Function1<com.bytedance.android.live.liveinteract.api.data.a, Unit>> c;
    public final HashSet<Function1<Integer, Unit>> d;
    public final HashSet<Function1<Integer, Unit>> e;
    public final CompositeDisposable f;
    public int g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.liveinteract.api.data.a r3 = (com.bytedance.android.live.liveinteract.api.data.a) r2;
            Intrinsics.checkNotNullParameter(r3, "config");
            ILinkPanelService r0 = com.bytedance.android.live.liveinteract.component.b.a();
            if (r0 == null) goto L6;
            r0.jk(r3);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinkPanelService a;

        public c(LinkPanelService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ LinkPanelService a;

        public d(LinkPanelService r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a = null;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void removePermitCallback() {
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final boolean isShowing() {
        LinkPanelManageDialog r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() != true) goto L7;
        return true;
    }

    public LinkPanelService() {
        this.c = new HashSet();
        this.d = new HashSet();
        this.e = new HashSet();
        this.f = new CompositeDisposable();
        this.g = MultiLinkPanelLifecycle.HIDE.ordinal();
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void close() {
        t61 r0 = z.a();
        if (r0 != null) goto L5;
    L24:
        LinkPanelManageDialog r1 = this.a;
        if (r1 != null) goto L27;
    L34:
        GuestApplyDialog r2 = this.b;
        if (r2 != null) goto L37;
        return;
    L37:
        if (r2.isShowing() == false) goto L56;
        r2.dismiss();     // Catch: Exception -> L40
        return;
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L57;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L57:
        return;
    L56:
        return;
    L27:
        if (r1.isShowing() == false) goto L34;
        r1.dismiss();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L34;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L34
    L5:
        if (u61.c(r0) != true) goto L24;
        LinkPanelManageDialog r5 = this.a;
        if (r5 != null) goto L49;
    L15:
        GuestApplyDialog r6 = this.b;
        if (r6 == null) goto L53;
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L19
    L23:
        this.b = null;
        return;
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r7 = DialogFragmentLancet.sLastShowStack;
        if (r7 == null) goto L23;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L23
    L53:
        return;
    L49:
        r5.dismissAllowingStateLoss();     // Catch: Exception -> L10
    L14:
        this.a = null;
    L10:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L14;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L14
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    public final void onCreate() {
        ILinkPanelService.a.onCreate(this);
        if (((IInteractService) k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L17;
        LinkInternalServiceContext r0 = LinkInternalServiceContext.Companion.getContext();
        if (r0 == null) goto L9;
        m<com.bytedance.android.live.liveinteract.api.data.a> r1 = r0.getPaidVideoTalkConfig();
        if (r1 == null) goto L9;
        Observable r2 = r1.a();
    L10:
        if (r2 == null) goto L18;
        Observable r3 = r2.observeOn(AndroidSchedulers.mainThread());
        if (r3 == null) goto L19;
        Disposable r4 = r3.subscribe(b.a);
        if (r4 == null) goto L20;
        this.f.add(r4);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    public final void onDestroy() {
        ILinkPanelService.a.onDestroy(this);
        this.a = null;
        this.b = null;
        this.f.clear();
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        ILinkPanelService.a.onPause(this);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        ILinkPanelService.a.onResume(this);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        ILinkPanelService.a.onStart(this);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService, com.bytedance.android.live.liveinteract.component.api.IComponentService
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        ILinkPanelService.a.onStop(this);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void NO(int r4) {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(Integer.valueOf(r4));
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void T60(int r4) {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(Integer.valueOf(r4));
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void Tp(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void Uo(Function1<? super com.bytedance.android.live.liveinteract.api.data.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void VG(Function1<? super com.bytedance.android.live.liveinteract.api.data.a, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void X40(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.add(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void eq(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.d.remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void jk(com.bytedance.android.live.liveinteract.api.data.a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function1) r0.next()).invoke(r3);
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void js(int r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void k50(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.e.remove(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void setOnDismissListener(DialogInterface.OnDismissListener r2) {
        Intrinsics.checkNotNullParameter(r2, "onDismissListener");
        LinkPanelManageDialog r0 = this.a;
        if (r0 == null) goto L6;
        r0.setOnDismissListener(r2);
        return;
    }

    public static void a(LinkPanelManageDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void JR(Context r3, DataCenter r4, IRoom r5, boolean r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        com.bytedance.android.live.liveinteract.linkpanel.api.b r0 = new com.bytedance.android.live.liveinteract.linkpanel.api.b(this);
        int r1 = LinkPanelManageDialog.v;
        LinkPanelManageDialog.a r2 = new LinkPanelManageDialog.a(r4, r7, r0);
        Boolean r8 = (Boolean) r4.get("data_is_portrait", Boolean.TRUE);
        if (r8 == null) goto L5;
        boolean r9 = r8.booleanValue();
    L6:
        r2.h = r5;
        r2.i = true;
        r2.j = r9;
        r2.f = -1;
        r2.k = r6;
        LinkPanelManageDialog r10 = r2.a(24);
        this.a = r10;
        a(r10, ((FragmentActivity) r3).getSupportFragmentManager());
        return;
    L5:
        r9 = true;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void PQ(Context r3, DataCenter r4, IRoom r5, String r6, MultiLinkDynamicWidgetNew r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        com.bytedance.android.live.liveinteract.linkpanel.api.a r0 = new com.bytedance.android.live.liveinteract.linkpanel.api.a(this);
        int r1 = LinkPanelManageDialog.v;
        LinkPanelManageDialog.a r2 = new LinkPanelManageDialog.a(r4, r7, r0);
        Boolean r8 = (Boolean) r4.get("data_is_portrait", Boolean.TRUE);
        if (r8 == null) goto L5;
        boolean r9 = r8.booleanValue();
    L6:
        r2.h = r5;
        r2.i = true;
        r2.j = r9;
        r2.f = -1;
        r2.g = r6;
        LinkPanelManageDialog r10 = r2.a(26);
        this.a = r10;
        a(r10, ((FragmentActivity) r3).getSupportFragmentManager());
        return;
    L5:
        r9 = true;
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void ad(Context r3, DataCenter r4, String r5, int r6, LifecycleOwner r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Map<String, cm2.a> r0 = p.a;
        p.h("apply_panel", 0);
        t61 r1 = z.a();
        if (r1 != null) goto L5;
    L12:
        d r2 = new d(this);
        int r8 = LinkPanelManageDialog.v;
        LinkPanelManageDialog.a r9 = new LinkPanelManageDialog.a(r4, r7, r2);
        r9.g = r5;
        r9.f = r6;
        LinkPanelManageDialog r10 = r9.a(17);
        this.a = r10;
        a(r10, ((FragmentActivity) r3).getSupportFragmentManager());
        return;
    L5:
        if (u61.a(r1) != true) goto L12;
        DataContext r11 = com.bytedance.live.datacontext.d.d(AdminInviteAndApplyViewModel.TAG);
        if ((r11 instanceof AdminInviteAndApplyViewModel) == true) goto L9;
        r11 = null;
    L9:
        AdminInviteAndApplyViewModel r12 = (AdminInviteAndApplyViewModel) r11;
        if (r12 == null) goto L12;
        r12.getInviteList();
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void pj(Context r17, IRoom r18, a5 r19, String r20, int r21) {
        Intrinsics.checkNotNullParameter(r18, PbRequest.SwitchType.ROOM);
        DataContext r3 = null;
        if (h.U().a() == true) goto L5;
        Map<String, cm2.a> r2 = p.a;
        p.h("apply_panel", 0);
        t61 r4 = z.a();
        if (r4 != null) goto L89;
    L107:
        GuestApplyDialog r5 = this.b;
        if (r5 != null) goto L110;
    L111:
        int r6 = GuestApplyDialog.o;
        Function0<Unit> r7 = new LinkPanelService$showGuestApplyDialog$1(this);
        GuestApplyDialog r8 = new GuestApplyDialog();
        r8.d = r18;
        r8.g = r21;
        r8.e = r7;
        this.b = r8;
    L112:
        GuestApplyDialog r9 = this.b;
        if (r9 != null) goto L115;
    L122:
        if (r17 == null) goto L131;
        GuestApplyDialog r10 = this.b;
        if (r10 == null) goto L132;
        r10.show(r17, r20);
        return;
    L132:
        return;
    L131:
        return;
    L115:
        if (r9.isShowing() != true) goto L122;
        GuestApplyDialog r1 = this.b;
        if (r1 == null) goto L128;
        GuestApplyTopBarWidget r11 = r1.l;
        if (r11 != null) goto L121;
        r1.f = r19;
        return;
    L121:
        r11.wq(r19);
        return;
    L128:
        return;
    L110:
        if (r5.isShowing() == true) goto L112;
    L89:
        if (u61.a(r4) != true) goto L107;
        DataContext r12 = com.bytedance.live.datacontext.d.d(GuestApplyViewModel.TAG);
        if ((r12 instanceof GuestApplyViewModel) == true) goto L93;
        r12 = null;
    L93:
        GuestApplyViewModel r13 = (GuestApplyViewModel) r12;
        if (r13 == null) goto L107;
        DataContext r14 = com.bytedance.live.datacontext.d.d(GuestApplyViewModel.TAG);
        if ((r14 instanceof GuestApplyViewModel) == false) goto L99;
        r3 = r14;
    L99:
        GuestApplyViewModel r15 = (GuestApplyViewModel) r3;
        if (r15 == null) goto L105;
        MutableLiveData<Integer> r16 = r15.getWaitingListType();
        if (r16 == null) goto L105;
        Integer r22 = (Integer) r16.getValue();
        if (r22 == null) goto L105;
    L106:
        GuestApplyViewModel.fetchList$default(r13, true, r18, null, r22.intValue(), 0, false, 52, null);
    L105:
        r22 = Integer.valueOf(WaitingListType.UNKNOWN.ordinal());
        goto L106
    L5:
        if (h.U().h() == true) goto L7;
    L15:
        int r23 = com.bytedance.android.live.liveinteract.utils.c.a;
        String r24 = h.U().b();
        LinkedHashMap r25 = new LinkedHashMap();
        r25.put("position", String.valueOf(r21));
        if (r20 == null) goto L18;
        r25.put("request_page", r20);
    L18:
        IMiddlewareUserService r26 = k.f(IMiddlewareUserService.class);
        if (r26 == null) goto L26;
        e r27 = r26.user();
        if (r27 == null) goto L26;
        if (r27.isAdmin() != true) goto L26;
    L41:
        boolean r28 = false;
    L42:
        r25.put("show_recommend_room", String.valueOf(r28));
        IInteractService r29 = (IInteractService) k.f(IInteractService.class);
        if (r29 == null) goto L51;
        cj0.a r30 = r29.paidLinkMicContext();
        if (r30 == null) goto L51;
        cj0.c r31 = r30.getWidget();
        if (r31 == null) goto L51;
        if (r31.isIncreasePriceOn() != true) goto L51;
        boolean r32 = true;
    L52:
        r25.put("is_paid_linkmic_increase_price_on", String.valueOf(r32));
        IInteractService r33 = (IInteractService) k.f(IInteractService.class);
        if (r33 != null) goto L55;
    L64:
        boolean r34 = false;
    L65:
        r25.put("is_paid_linkmic_on", String.valueOf(r34));
        r25.put("is_paid_quene_on", String.valueOf(false));
        IKtvService r35 = k.f(IKtvService.class);
        if (r35 != null) goto L68;
    L70:
        r25.put("is_live_song", "false");
    L71:
        r25.put("apply_waiting_count", String.valueOf(tc0.c.h().i));
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().c == false) goto L75;
        int r36 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.k().b;
    L80:
        long r37 = r36;
    L82:
        r25.put("limited_time", String.valueOf(r37));
        String r38 = y0.b(r24, r25);
        IBaseLiveActionHandler r39 = k.f(IBaseLiveActionHandler.class);
        if (r39 == null) goto L127;
        r39.handle(r17, r38);
        return;
    L127:
        return;
    L75:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().c == false) goto L78;
        r36 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.h().b;
        goto L80
    L78:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().c == false) goto L81;
        r36 = com.bytedance.android.live.liveinteract.api.data.a.C0017a.a().b;
        goto L80
    L81:
        r37 = 0;
        goto L82
    L68:
        if (r35.hasSelfPrivateSong() != true) goto L70;
        r25.put("is_live_song", "true");
        goto L71
    L55:
        if (r33.getLinkPanelTransitService() == null) goto L64;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.c r40 = MultiRevenueDataContext.a.c();
        if (r40 != null) goto L59;
    L61:
        boolean r41 = false;
    L62:
        if (r41 != true) goto L64;
        r34 = true;
        goto L65
    L59:
        if (r40.isPaidLinkOn() != true) goto L61;
        r41 = true;
    L51:
        r32 = false;
    L26:
        if (h.U().f() == false) goto L41;
        IMiddlewareHostBusiness r42 = k.f(IMiddlewareHostBusiness.class);
        if (r42 == null) goto L41;
        if (r42.isEnablePersonalRecommend() != true) goto L41;
        int r43 = tc0.c.h().h;
        IInteractService r44 = (IInteractService) k.f(IInteractService.class);
        if (r44 == null) goto L37;
        i<ILinkPlayerInfoBridge> r45 = r44.getLinkUserInfoCenter();
        if (r45 == null) goto L37;
        r3 = r45.Z4();
    L37:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L39;
    L40:
        r28 = true;
        goto L42
    L39:
        if (r43 < h.U().c()) goto L41;
    L7:
        if (this.g != MultiLinkPanelLifecycle.SHOW.ordinal()) goto L9;
    L12:
        boolean r46 = true;
    L13:
        if (r46 == false) goto L15;
        return;
    L9:
        if (this.g == MultiLinkPanelLifecycle.UPDATE.ordinal()) goto L12;
        r46 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void uO(Context r3, DataCenter r4, IRoom r5, List r6, String r7, LifecycleOwner r8) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r7, "platformActivityId");
        Intrinsics.checkNotNullParameter(r8, "lifecycleOwner");
        com.bytedance.android.live.liveinteract.linkpanel.api.c r0 = new com.bytedance.android.live.liveinteract.linkpanel.api.c(this);
        int r1 = LinkPanelManageDialog.v;
        LinkPanelManageDialog.a r2 = new LinkPanelManageDialog.a(r4, r8, r0);
        r2.h = r5;
        r2.l = r6;
        r2.m = r7;
        r2.n = 1;
        LinkPanelManageDialog r9 = r2.a(25);
        this.a = r9;
        a(r9, ((FragmentActivity) r3).getSupportFragmentManager());
    }

    @Override // com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService
    public final void C70(Context r20, DataCenter r21, int r22, String r23, int r24, IRoom r25, LifecycleOwner r26) {
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter(r21, "dataCenter");
        Intrinsics.checkNotNullParameter(r23, "requestPage");
        Intrinsics.checkNotNullParameter(r25, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r26, "lifecycleOwner");
        LinkPanelManageDialog r7 = this.a;
        if (r7 != null) goto L5;
    L14:
        Map<String, cm2.a> r8 = p.a;
        p.h("apply_panel", r22);
        p.h("invite_panel", r22);
        t61 r9 = z.a();
        if (r9 != null) goto L17;
    L31:
        c r10 = new c(this);
        int r11 = LinkPanelManageDialog.v;
        LinkPanelManageDialog.a r12 = new LinkPanelManageDialog.a(r21, r26, r10);
        r12.e = r22;
        r12.g = r23;
        r12.f = r24;
        r12.d = r25;
        LinkPanelManageDialog r2 = r12.a(7);
        this.a = r2;
        a(r2, ((FragmentActivity) r20).getSupportFragmentManager());
        return;
    L17:
        if (u61.a(r9) != true) goto L31;
        DataContext r13 = com.bytedance.live.datacontext.d.d(AdminInviteAndApplyViewModel.TAG);
        DataContext r14 = null;
        if ((r13 instanceof AdminInviteAndApplyViewModel) == true) goto L21;
        r13 = null;
    L21:
        AdminInviteAndApplyViewModel r15 = (AdminInviteAndApplyViewModel) r13;
        if (r15 == null) goto L24;
        r15.getInviteList();
    L24:
        DataContext r16 = com.bytedance.live.datacontext.d.d(AdminInviteAndApplyViewModel.TAG);
        if ((r16 instanceof AdminInviteAndApplyViewModel) == false) goto L28;
        r14 = r16;
    L28:
        AdminInviteAndApplyViewModel r17 = (AdminInviteAndApplyViewModel) r14;
        if (r17 == null) goto L31;
        AdminInviteAndApplyViewModel.getWaitingList$default(r17, 0, null, 0, 7, null);
        goto L31
    L5:
        if (r7.isShowing() != true) goto L14;
        LinkPanelManageDialog r18 = this.a;
        if (r18 == null) goto L14;
        if (r18.d != 7) goto L11;
        boolean r19 = true;
    L12:
        if (r19 != true) goto L14;
        return;
    L11:
        r19 = false;
        goto L12
    }
}
