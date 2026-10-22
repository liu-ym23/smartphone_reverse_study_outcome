package com.bytedance.android.live.liveinteract.chatroom.chatroom;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.anchormodelink.model.LinkerUserState;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.x;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.LinkDialog;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.h;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.VideoRoomAudiencePreApplyDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.g0;
import com.bytedance.android.live.liveinteract.widget.widget.q;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.aq;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.v;
import ht2.g;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pp1.m;
import zg1.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ToolbarVideoInteractBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ToolbarVideoInteractBehavior implements c0.b, Observer<KVData> {
    public static final /* synthetic */ int F = 0;
    public boolean A;
    public final b B;
    public final int C;
    public final int D;
    public int E;
    public TextView a;
    public View b;
    public boolean c;
    public DataCenter d;
    public boolean e;
    public boolean f;
    public Context g;
    public yo2.e h;
    public x i;
    public final CompositeDisposable j;
    public LottieAnimationView k;
    public HSImageView l;
    public ImageView m;
    public HSImageView n;
    public View o;
    public String p;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.b q;
    public boolean r;
    public boolean s;
    public boolean t;
    public com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b u;
    public String v;
    public VideoRoomAudiencePreApplyDialog w;
    public q x;
    public IRoom y;
    public long z;

    public static final class a {
        public static int a() {
            if (((Boolean) ev1.q.d.getValue()).booleanValue() == false) goto L6;
            return 2131243758;
        L6:
            return 2131250847;
        }
    }

    public static final class b<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {
        public final /* synthetic */ ToolbarVideoInteractBehavior a;

        public b(ToolbarVideoInteractBehavior r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Integer r6 = (Integer) r5;
            if (this.a.c == false) goto L10;
            if (r6 != null) goto L7;
        L36:
            ToolbarVideoInteractBehavior r7 = this.a;
            g.c(12, r7.y, r7.k);
            return;
        L7:
            if (r6.intValue() != 0) goto L36;
            this.a.f(2131250849, 2131250849, 1.0f);
            goto L36
        L10:
            if (r6 != null) goto L13;
        L15:
            if (r6 != null) goto L18;
        L20:
            com.bytedance.android.live.liveinteract.plantform.base.g r8 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
            if (r8 != null) goto L23;
        L26:
            int r9 = 2131917693;
        L27:
            HSImageView r1 = this.a.l;
            Object r2 = null;
            if (r1 == null) goto L30;
            ViewParent r3 = r1.getParent();
        L32:
            if ((r3 instanceof View) == false) goto L35;
            r2 = r3;
        L35:
            r3.c((View) r2, s1.B(r9), true);
            goto L36
        L30:
            r3 = null;
            goto L32
        L23:
            if (r8.W1() == false) goto L25;
            this.a.f(2131251092, 2131251092, 1.0f);
            goto L26
        L25:
            ToolbarVideoInteractBehavior r10 = this.a;
            int r4 = ToolbarVideoInteractBehavior.F;
            r10.f(a.a(), a.a(), 1.0f);
            goto L26
        L18:
            if (r6.intValue() != 2) goto L20;
            this.a.j();
            r9 = 2131917701;
            goto L27
        L13:
            if (r6.intValue() != 1) goto L15;
            this.a.k();
            r9 = 2131917742;
            goto L27
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ToolbarVideoInteractBehavior a;

        public c(ToolbarVideoInteractBehavior r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            if (((b2) r6).getType() != 1) goto L21;
            ToolbarVideoInteractBehavior r7 = this.a;
            FragmentActivity r1 = ContextUtil.contextToFragmentActivity(r7.g);
            if (r1 != null) goto L8;
            return;
        L8:
            if (vm2.d.S() == false) goto L10;
            DataCenter r2 = r7.d;
            int r3 = LinkDialog.v;
            LinkDialog r4 = new LinkDialog.a(r2, r1).b(15);
        L11:
            FragmentManager r5 = r1.getSupportFragmentManager();
            LandscapeRestrictionOperation r8 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "LinkDialog", r8);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r4, r8) == false) goto L19;
        L16:
            LivePluginSPIManager.e.getClass();
            LivePluginSPIManager.a().addOnSuccess(new com.bytedance.android.live.liveinteract.chatroom.chatroom.e(r7, r4)).callbackOnMainThread().syncCallbackIfReady(true).requireByUser("ToolbarVideoInteractBehavior");
            return;
        L19:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
        L15:
            r4.show(r5, "LinkDialog");
            goto L16
        L10:
            DataCenter r9 = r7.d;
            int r10 = LinkDialog.v;
            r4 = new LinkDialog.a(r9, r1).b(8);
            goto L11
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ToolbarVideoInteractBehavior a;

        public d(ToolbarVideoInteractBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ToolbarVideoInteractBehavior r0 = this.a;     // Catch: Throwable -> L4
            String r1 = s1.B(2131915770);     // Catch: Throwable -> L4
            int r2 = ToolbarVideoInteractBehavior.F;     // Catch: Throwable -> L4
            r0.i(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ ToolbarVideoInteractBehavior a;

        public e(ToolbarVideoInteractBehavior r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ToolbarVideoInteractBehavior r0 = this.a;     // Catch: Throwable -> L4
            String r1 = s1.B(2131917517);     // Catch: Throwable -> L4
            int r2 = ToolbarVideoInteractBehavior.F;     // Catch: Throwable -> L4
            r0.i(r1);     // Catch: Throwable -> L4
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

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final boolean c() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.performance.a r1 = r0.getMultiLinkPerfAbilityManager(true);
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.a("multilink_toolbar_degrade");
    L8:
        return true;
    }

    public ToolbarVideoInteractBehavior() {
        this.e = true;
        this.i = new x();
        this.j = new CompositeDisposable();
        this.p = "";
        this.s = true;
        this.u = new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b();
        this.B = new b(this);
        this.C = 1;
        this.D = -4;
        this.E = -1;
    }

    public final void j() {
        if (vm2.d.w0().a() == false) goto L16;
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        HSImageView r1 = this.l;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.w0().b).setAutoPlayAnimations(c()).build();
        HSImageView r3 = this.l;
        if (r3 == null) goto L13;
        r3.setController(r2);
    L13:
        ImageView r4 = this.m;
        if (r4 == null) goto L26;
        r4.setBackgroundResource(0);
        return;
    L26:
        return;
    L16:
        HSImageView r5 = this.l;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
    L19:
        LottieAnimationView r6 = this.k;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        g0.a(vm2.d.b().interactIcCallingId, this.k, null);
        LottieAnimationView r7 = this.k;
        if (r7 == null) goto L28;
        r7.setBackgroundResource(2131250014);
        return;
    }

    public final void k() {
        if (vm2.d.w0().a() == false) goto L16;
        LottieAnimationView r0 = this.k;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        HSImageView r1 = this.l;
        if (r1 == null) goto L10;
        r1.setVisibility(0);
    L10:
        AbstractDraweeController r2 = Fresco.newDraweeControllerBuilder().setUri(vm2.d.w0().c).setAutoPlayAnimations(c()).build();
        HSImageView r3 = this.l;
        if (r3 == null) goto L13;
        r3.setController(r2);
    L13:
        ImageView r4 = this.m;
        if (r4 == null) goto L26;
        r4.setBackgroundResource(0);
        return;
    L26:
        return;
    L16:
        HSImageView r5 = this.l;
        if (r5 == null) goto L19;
        r5.setVisibility(8);
    L19:
        LottieAnimationView r6 = this.k;
        if (r6 == null) goto L22;
        r6.setVisibility(0);
    L22:
        g0.a(vm2.d.b().interactIcWaitingId, this.k, null);
        LottieAnimationView r7 = this.k;
        if (r7 == null) goto L28;
        r7.setBackgroundResource(2131250014);
        return;
    }

    public final void a(String r8) {
        if (this.c == false) goto L54;
        String r0 = s1.B(2131917979);
        int r3 = 0;
        if (r8.length() != 0) goto L7;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L46;
        com.bytedance.android.live.liveinteract.plantform.base.g r9 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r9 == null) goto L13;
        int r10 = r9.getCurrentMode();
    L14:
        Boolean r2 = null;
        if (v.a(r10, 2) == false) goto L17;
        List<ILinkPlayerInfoBridge> r11 = com.bytedance.android.live.liveinteract.service.f.O(this.c);
    L18:
        if (r11 != null) goto L20;
        Boolean r12 = null;
    L25:
        if (r12 == null) goto L31;
        if (Intrinsics.areEqual(r12, Boolean.TRUE) == true) goto L31;
        f(2131251092, 2131251092, 1.0f);
    L45:
        r3.c(this.b, r0, true);
        return;
    L31:
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L33;
        r3 = 1;
    L33:
        DataCenter r13 = this.d;
        if (r13 == null) goto L36;
        r2 = (Boolean) r13.get("cmd_what_audience_join_self_link", Boolean.FALSE);
    L36:
        if (r3 != 0) goto L38;
    L40:
        if (r3 != 0) goto L42;
    L44:
        f(2131250849, 2131250849, 1.0f);
        goto L45
    L42:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L44;
        f(2131251092, 2131251092, 1.0f);
        goto L45
    L38:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L40;
        f(2131250846, 2131250846, 1.0f);
        goto L45
    L20:
        if (r11.size() > 1) goto L22;
        boolean r14 = true;
    L23:
        r12 = Boolean.valueOf(r14);
        goto L25
    L22:
        r14 = false;
        goto L23
    L17:
        r11 = null;
        goto L18
    L13:
        r10 = 0;
        goto L14
    L46:
        com.bytedance.android.live.liveinteract.plantform.base.g r4 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r4 == null) goto L50;
        r3 = r4.getCurrentMode();
    L50:
        if (v.a(r3, 32) == true) goto L52;
        f(2131251092, 2131251092, 1.0f);
    L52:
        r3.c(this.b, r0 + ", " + r8, true);
        return;
    L7:
        r1 = false;
        goto L9
    }

    public final void b(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L8;
        TextView r0 = this.a;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        this.p = r4;
    L36:
        a(r4);
        return;
    L8:
        this.p = r4;
        TextView r1 = this.a;
        if (r1 == null) goto L11;
        r1.setText(r4);
    L11:
        TextView r2 = this.a;
        if (r2 == null) goto L15;
        r2.setVisibility(0);
    L15:
        if (this.c == false) goto L36;
        if (vm2.d.s() == false) goto L36;
        TextView r3 = this.a;
        if (r3 == null) goto L21;
        r3.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L21:
        TextView r5 = this.a;
        Integer r6 = null;
        if (r5 == null) goto L24;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
    L25:
        if (r7 == null) goto L31;
        TextView r8 = this.a;
        if (r8 == null) goto L29;
        r6 = Integer.valueOf(r8.getMeasuredWidth());
    L29:
        Intrinsics.checkNotNull(r6);
        r7.width = r6.intValue();
    L31:
        if ((r7 instanceof FrameLayout.LayoutParams) == false) goto L33;
        ((FrameLayout.LayoutParams) r7).gravity = 48;
    L33:
        TextView r9 = this.a;
        if (r9 == null) goto L36;
        r9.setLayoutParams(r7);
        goto L36
    L24:
        r7 = null;
        goto L25
    }

    public final void d(boolean r2) {
        if (r2 == true) goto L4;
        f(2131250851, 2131250851, 1.0f);
        return;
    L4:
        if (hd0.c.f().h() == false) goto L8;
        j();
        return;
    }

    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r5) {
        Intrinsics.checkNotNullParameter(r5, "command");
        boolean r0 = this.t;
        if ((r5 instanceof m) == false) goto L5;
        g(((m) r5).a, r5);
        return;
    L5:
        int r2 = 8;
        if ((r5 instanceof pp1.g) == false) goto L20;
        this.r = ((pp1.g) r5).a;
        if (r0 == false) goto L10;
        r2 = 0;
    L10:
        g(r2, r5);
        if (this.r == false) goto L16;
        if (r0 == false) goto L16;
        DataCenter r6 = this.d;
        if (r6 == null) goto L41;
        r6.put("data_more_dialog_is_show_interact_more", Boolean.TRUE);
        return;
    L41:
        return;
    L16:
        DataCenter r7 = this.d;
        if (r7 == null) goto L43;
        r7.put("data_more_dialog_is_show_interact_more", Boolean.FALSE);
        return;
    L43:
        return;
    L20:
        if ((r5 instanceof pp1.f) == false) goto L30;
        if (((pp1.f) r5).a != 0) goto L24;
        boolean r1 = true;
    L25:
        this.s = r1;
        if (r0 == false) goto L28;
        r2 = 0;
    L28:
        g(r2, r5);
        return;
    L24:
        r1 = false;
        goto L25
    L30:
        if ((r5 instanceof pp1.c) == false) goto L46;
        if (r0 == false) goto L36;
        String r3 = ((pp1.c) r5).b;
        if (r3 != null) goto L35;
        r3 = "";
    L35:
        i(r3);
    L36:
        if (r0 == false) goto L38;
        r2 = 0;
    L38:
        g(r2, r5);
        return;
    }

    public final void i(String r11) {
        if (this.A == true) goto L6;
        ALogger.e("dzy-toolbar", "VideoBehavior#showPopup, but is unload");
        return;
    L6:
        yo2.e r0 = this.h;
        if (r0 != null) goto L9;
    L11:
        Context r1 = this.g;
        if (r1 != null) goto L15;
        ALogger.e("dzy-toolbar", "VideoBehavior#showPopup, return for no context");
        return;
    L15:
        View r2 = LayoutInflater.from(r1).inflate(2131566214, null);
        TextView r3 = (TextView) r2.findViewById(2131390805);
        View r4 = r2.findViewById(2131376322);
        r3.setText(r11);
        yo2.e r5 = new yo2.e(r1);
        ((yo2.d) r5).d = r2;
        ((yo2.d) r5).e = 0;
        ((yo2.d) r5).m = 5;
        ((yo2.d) r5).n = true;
        ((yo2.d) r5).l = true;
        r5.a();
        this.h = r5;
        View r12 = this.b;
        if (r12 == null) goto L26;
        r5.i(r12, 1, 0, s1.f(this.C), s1.f(this.D));
        if (this.c == false) goto L20;
        UIUtils.updateLayoutMargin(r4, (int) (r12.getX() + (r12.getWidth() / 2)), -3, -3, -3);
        return;
    L20:
        ViewGroup.LayoutParams r13 = r4.getLayoutParams();
        if (r13 != null) goto L23;
        return;
    L23:
        if ((r13 instanceof LinearLayout.LayoutParams) == false) goto L29;
        ((LinearLayout.LayoutParams) r13).gravity = 17;
        r4.setLayoutParams(r13);
        return;
    L29:
        return;
    L26:
        return;
    L9:
        if (r0.h() == false) goto L11;
        r0.d();
        goto L11
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        Object r0 = null;
        Integer r1 = null;
        if (r8 == null) goto L5;
        String r2 = r8.getKey();
    L7:
        if (Intrinsics.areEqual(r2, "data_video_talk_dot_with_number_show") == false) goto L11;
        String r9 = (String) r8.getData();
        if (r9 == null) goto L117;
        b(r9);
        return;
    L117:
        return;
    L11:
        if (r8 == null) goto L13;
        String r3 = r8.getKey();
    L15:
        if (Intrinsics.areEqual(r3, "data_interact_number_dot_show") == false) goto L19;
        String r10 = (String) r8.getData();
        if (r10 == null) goto L119;
        b(r10);
        return;
    L119:
        return;
    L19:
        if (r8 == null) goto L21;
        String r4 = r8.getKey();
    L23:
        if (Intrinsics.areEqual(r4, "cmd_send_show_apply_popup_success") == false) goto L27;
        Room r11 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r11 == null) goto L121;
        ((SingleSubscribeProxy) ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).showApplyPopupSuccess(r11.getId(), 1).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(null))).subscribe(com.bytedance.android.live.liveinteract.chatroom.chatroom.c.a, com.bytedance.android.live.liveinteract.chatroom.chatroom.d.a);
        return;
    L121:
        return;
    L27:
        if (r8 == null) goto L29;
        String r5 = r8.getKey();
    L31:
        if (Intrinsics.areEqual(r5, "data_audience_interact_game") == true) goto L33;
        if (r8 == null) goto L41;
        String r6 = r8.getKey();
    L43:
        if (Intrinsics.areEqual(r6, "DATA_LINK_DISMISS_WHEN_FLOATBALL_SHOW") == true) goto L45;
        if (r8 == null) goto L54;
        String r12 = r8.getKey();
    L56:
        if (Intrinsics.areEqual(r12, "data_online_changed_list") == false) goto L58;
        a(this.p);
        return;
    L58:
        if (r8 == null) goto L60;
        String r13 = r8.getKey();
    L62:
        if (Intrinsics.areEqual(r13, "data_link_pk_interact_show_red_dot") == true) goto L64;
        if (r8 == null) goto L73;
        String r14 = r8.getKey();
    L75:
        if (Intrinsics.areEqual(r14, "cmd_what_audience_join_self_link") == false) goto L77;
        a(this.p);
        return;
    L77:
        if (r8 == null) goto L79;
        String r15 = r8.getKey();
    L81:
        if (Intrinsics.areEqual(r15, "data_new_video_linkmic_state") == false) goto L136;
        if (r8 == null) goto L84;
        Integer r16 = (Integer) r8.getData();
    L86:
        if (this.c == true) goto L115;
        int r17 = LinkerUserState.Waiting.ordinal();
        if (r16 != null) goto L91;
    L92:
        int r18 = LinkerUserState.Ready.ordinal();
        if (r16 != null) goto L96;
    L98:
        int r19 = LinkerUserState.Linked.ordinal();
        if (r16 != null) goto L102;
    L104:
        f(a.a(), a.a(), 1.0f);
        int r20 = 2131917693;
    L106:
        HSImageView r21 = this.l;
        if (r21 == null) goto L109;
        Object r22 = r21.getParent();
    L111:
        if ((r22 instanceof View) == false) goto L114;
        r0 = r22;
    L114:
        r3.c((View) r0, s1.B(r20), true);
        goto L115
    L109:
        r22 = null;
        goto L111
    L102:
        if (r16.intValue() != r19) goto L104;
        j();
        r20 = 2131917701;
        goto L106
    L96:
        if (r16.intValue() != r18) goto L98;
    L105:
        k();
        r20 = 2131917742;
        goto L106
    L91:
        if (r16.intValue() == r17) goto L105;
    L115:
        g.c(12, this.y, this.k);
        return;
    L84:
        r16 = null;
        goto L86
    L136:
        return;
    L79:
        r15 = null;
        goto L81
    L73:
        r14 = null;
        goto L75
    L64:
        if (Intrinsics.areEqual((Boolean) r8.getData(), Boolean.FALSE) == false) goto L68;
        View r23 = this.o;
        if (r23 == null) goto L131;
        r23.setVisibility(0);
        return;
    L131:
        return;
    L68:
        View r24 = this.o;
        if (r24 == null) goto L133;
        r24.setVisibility(8);
        return;
    L133:
        return;
    L60:
        r13 = null;
        goto L62
    L54:
        r12 = null;
        goto L56
    L45:
        if (Intrinsics.areEqual((Boolean) r8.getData(), Boolean.TRUE) == true) goto L47;
        return;
    L47:
        if (this.d == null) goto L128;
        View r25 = this.b;
        if (r25 == null) goto L51;
        r1 = Integer.valueOf(r25.getVisibility());
    L51:
        Intrinsics.checkNotNull(r1);
        this.E = r1.intValue();
        y3.m(this.d).b(ToolbarButton.INTERACTION, new pp1.g(true));
        return;
    L128:
        return;
    L41:
        r6 = null;
        goto L43
    L33:
        if (r8.getData() != null) goto L123;
        DataCenter r26 = this.d;
        if (r26 == null) goto L124;
        y3.m(r26).i(ToolbarButton.GAME_GUESS.extended());
        if (this.E != 0) goto L125;
        this.E = -1;
        y3.m(this.d).b(ToolbarButton.INTERACTION, new pp1.g(false));
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L29:
        r5 = null;
        goto L31
    L21:
        r4 = null;
        goto L23
    L13:
        r3 = null;
        goto L15
    L5:
        r2 = null;
        goto L7
    }

    public final void onClick(View r13) {
        Intrinsics.checkNotNullParameter(r13, "v");
        ILoginGuideService.Companion.getClass();
        ILoginGuideService r14 = ILoginGuideService.a.a();
        if (r14 != null) goto L5;
    L7:
        long r1 = System.currentTimeMillis();
        if ((r1 - this.z) >= ((Number) vm2.d.v5.getValue(null, vm2.d.a[331(0x14b, float:4.64E-43)])).intValue()) goto L11;
        ALogger.i("ToolbarVideoInteractBehavior", "interact behavior repeat click");
        return;
    L11:
        this.z = r1;
        DataCenter r2 = this.d;
        if (r2 == null) goto L14;
        LiveMode r3 = (LiveMode) r2.get("data_live_mode");
    L15:
        iy.g r4 = ((IInteractService) k.n(IInteractService.class)).getDynamicCenterService(this.d);
        if (r4 == null) goto L18;
        Integer r5 = Integer.valueOf(r4.getCurrentScene());
    L19:
        int r6 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        IRoom r7 = this.y;
        String r8 = "";
        if (r7 == null) goto L25;
        Map r9 = r7.getAnchorABMap();
        if (r9 == null) goto L25;
        String r10 = (String) r9.get("video_linkmic_v3");
        if (r10 == null) goto L25;
    L26:
        boolean r11 = ky.a.a;
        if (vm2.d.c0().getCheckRuntimeReady() != true) goto L29;
        boolean r12 = true;
    L30:
        if (r12 == false) goto L36;
        if (r4 != null) goto L33;
    L35:
        boolean r15 = false;
    L37:
        ALogger.i("ToolbarVideoInteractBehavior", "click interact anchorABMap.video_linkmic_v3=" + r10 + " 新组件scene=" + r5 + " 老组件scene=" + r6);
        String r16 = "1";
        if (this.c == false) goto L56;
        if (r3 != LiveMode.VIDEO) goto L56;
        if (r5 != null) goto L44;
    L45:
        if (r5 == null) goto L56;
        if (r5.intValue() != 20) goto L56;
    L50:
        if (Intrinsics.areEqual(r10, "1") == false) goto L56;
        if (r6 != 0) goto L56;
        if (r15 == false) goto L56;
        r4.Dd("clickInteract", null);
        return;
    L44:
        if (r5.intValue() == 0) goto L50;
    L56:
        if (je0.d.r() == true) goto L66;
        if (r5 == null) goto L66;
        if (r5.intValue() != 20) goto L66;
        if (r15 == false) goto L66;
        if (r4 == null) goto L94;
        r4.Dd("clickAudienceLinkmic", null);
        return;
    L94:
        return;
    L66:
        if (this.c == false) goto L87;
        LiveMode r17 = LiveMode.VIDEO;
        if (r3 != r17) goto L70;
    L71:
        HashMap r18 = new HashMap();
        r18.put("action_type", "click");
        TalkRoomLogUtils.B0(r18, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        if (r3 != r17) goto L74;
        String r19 = "video_live";
    L75:
        r18.put("live_type", r19);
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() != 1) goto L78;
        boolean r110 = true;
    L79:
        if (r110 == false) goto L81;
        r8 = String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L81:
        r18.put("pk_id", r8);
        if (r110 == true) goto L85;
        r16 = "0";
    L85:
        r18.put("is_in_pk", r16);
        j0.l().sendLog("livesdk_guest_connection_anchor", r18, new Object[]{IRoom.class});
        goto L87
    L78:
        r110 = false;
        goto L79
    L74:
        r19 = "voice_live";
        goto L75
    L70:
        if (r3 == LiveMode.AUDIO) goto L71;
    L87:
        if (this.r == false) goto L89;
        tc0.c.h().z = "more_panel_show";
    L90:
        xs2.b.a().post(new h());
        com.bytedance.android.live.liveinteract.plantform.base.g r111 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r111 == null) goto L95;
        r111.Ik(false);
        return;
    L95:
        return;
    L89:
        tc0.c.h().z = "live_room_show";
        goto L90
    L33:
        if (r4.Bk() != true) goto L35;
    L36:
        r15 = true;
        goto L37
    L29:
        r12 = false;
    L25:
        r10 = "";
        goto L26
    L18:
        r5 = null;
        goto L19
    L14:
        r3 = null;
        goto L15
    L5:
        if (r14.intercept(new q61.c(new q61.b.a(cz.c.o.c))) != true) goto L7;
    }

    public final void setAlpha(float r2) {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setAlpha(r2);
        return;
    }

    /* JADX WARN: Type inference failed for: r5v14, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.q, java.lang.Object] */
    public final void R9(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.A = false;
        StringBuilder r7 = new StringBuilder("VideoBehavior#onUnload, roomId = ");
        IRoom r0 = this.y;
        if (r0 == null) goto L5;
        Long r1 = Long.valueOf(r0.getId());
    L6:
        r7.append(r1);
        ALogger.e("dzy-toolbar", r7.toString());
        Log.getStackTraceString(new Throwable("VideoBehavior#onUnload"));
        hd0.c.f().e(this.B);
        String r8 = this.v;
        if (r8 == null) goto L13;
        IInteractService r2 = (IInteractService) k.f(IInteractService.class);
        if (r2 == null) goto L13;
        com.bytedance.android.live.liveinteract.plantform.performance.a r3 = r2.getMultiLinkPerfAbilityManager(false);
        if (r3 == null) goto L13;
        r3.c("multilink_toolbar_degrade", r8);
    L13:
        this.v = null;
        this.c = false;
        this.e = true;
        this.f = false;
        this.p = "";
        this.r = false;
        this.s = true;
        this.t = false;
        this.a = null;
        this.b = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        DataCenter r9 = this.d;
        if (r9 == null) goto L16;
        r9.removeObserver(this);
    L16:
        this.d = null;
        this.g = null;
        this.q = null;
        this.y = null;
        yo2.e r10 = this.h;
        if (r10 != null) goto L19;
    L23:
        this.h = null;
        VideoRoomAudiencePreApplyDialog r11 = this.w;
        if (r11 != null) goto L26;
    L35:
        this.w = null;
        com.bytedance.android.livesdk.common.b r12 = this.x;
        if (r12 != null) goto L38;
    L58:
        this.x = null;
        this.i.dispose();
        this.i = new x();
        this.j.clear();
        this.u.a();
        this.u = new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b();
        DataCenter r13 = this.d;
        if (r13 == null) goto L67;
        r13.removeObserver("data_new_video_linkmic_state", this);
        return;
    L67:
        return;
    L38:
        if (r12.isShowing() != true) goto L58;
        ?? r14 = this.x;
        if (r14 == 0) goto L58;
        Handler r15 = DialogLancet.resolveDialogHandler(r14);
        if (r15 != null) goto L44;
    L46:
        DialogLancet.beforeDialogDismiss(r14);
        r14.dismiss();     // Catch: Throwable -> L49 Exception -> L51
    L55:
        DialogLancet.afterDialogDismiss(r14);
        goto L58
    L49:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r14);
        throw th;
    L51:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L49
        Throwable r16 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L49
        if (r16 == null) goto L55;
        com.bytedance.crash.d.d(r16, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L49
        goto L55
    L44:
        if (Looper.myLooper() == r15.getLooper()) goto L46;
        r15.post(DialogLancet.createDismissRunnable(r14));
        goto L58
    L26:
        if (r11.isShowing() != true) goto L35;
        VideoRoomAudiencePreApplyDialog r17 = this.w;
        if (r17 == null) goto L35;
        r17.dismiss();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r18 = DialogFragmentLancet.sLastShowStack;
        if (r18 == null) goto L35;
        com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L35
    L19:
        if (r10.h() != true) goto L23;
        yo2.e r19 = this.h;
        if (r19 == null) goto L23;
        r19.d();
        goto L23
    L5:
        r1 = null;
        goto L6
    }

    public final void e(Context r5, String r6) {
        VideoRoomAudiencePreApplyDialog r0 = this.w;
        if (r0 == null) goto L8;
        if (r0.isShowing() != true) goto L8;
        return;
    L8:
        if (this.w != null) goto L13;
        int r1 = VideoRoomAudiencePreApplyDialog.m;
        IRoom r2 = this.y;
        DataCenter r3 = this.d;
        VideoRoomAudiencePreApplyDialog r4 = new VideoRoomAudiencePreApplyDialog();
        r4.d = r2;
        r4.e = r3;
        DataContext r7 = com.bytedance.live.datacontext.d.d(o.class);
        if ((r7 instanceof DataContext) == true) goto L12;
        r7 = null;
    L12:
        r4.f = r7;
        this.w = r4;
    L13:
        VideoRoomAudiencePreApplyDialog r8 = this.w;
        if (r8 == null) goto L16;
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        r8.l = r6;
    L16:
        VideoRoomAudiencePreApplyDialog r9 = this.w;
        if (r9 == null) goto L35;
        Intrinsics.checkNotNullParameter(r5, "context");
        if (r9.isShowing() == false) goto L21;
        return;
    L21:
        if (r9.k == true) goto L37;
        r9.k = true;
        FragmentActivity r10 = ContextUtil.contextToFragmentActivity(r5);
        if (r10 == null) goto L38;
        FragmentManager r11 = r10.getSupportFragmentManager();
        if (r11 == null) goto L39;
        LandscapeRestrictionOperation r12 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r9, "VideoRoomAudiencePreApplyDialog", r12);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r11, r9, r12) == true) goto L40;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L30:
        r9.show(r11, "VideoRoomAudiencePreApplyDialog");
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    }

    public final void g(int r6, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r7) {
        Intrinsics.checkNotNullParameter(r7, "invokeCommand");
        int r0 = u40.a.a;
        if (((Boolean) aq.a.getValue()).booleanValue() == false) goto L6;
        ALogger.i("NewToolbarLog", "link mic stop view change by self.");
        return;
    L6:
        boolean r1 = true;
        if (r6 != 0) goto L9;
        boolean r8 = true;
    L10:
        this.t = r8;
        if (this.e == true) goto L22;
        View r9 = this.b;
        if (r9 == null) goto L61;
        if (r8 == true) goto L16;
    L18:
        r1 = false;
    L19:
        UtilityKotlinExtentionsKt.z(r9, r1);
        return;
    L16:
        if (this.s == false) goto L18;
    L61:
        return;
    L22:
        if (this.r == false) goto L24;
        View r10 = this.b;
        if (r10 == null) goto L44;
        r10.setVisibility(8);
    L44:
        if (this.t == false) goto L49;
        if (this.q != null) goto L51;
        this.q = new com.bytedance.android.live.liveinteract.chatroom.chatroom.b(this);
        y3.f(this.d).k(ToolbarButton.INTERACTION_MORE, this.q);
    L51:
        DataCenter r11 = this.d;
        if (r11 != null) goto L54;
        return;
    L54:
        if (this.t == true) goto L56;
    L58:
        r1 = false;
    L59:
        r11.put("data_has_interact_more", Boolean.valueOf(r1));
        return;
    L56:
        if (this.r == false) goto L58;
    L49:
        if (this.q == null) goto L51;
        y3.f(this.d).d(ToolbarButton.INTERACTION_MORE, this.q);
        this.q = null;
        goto L51
    L24:
        if (this.q == null) goto L26;
        y3.f(this.d).d(ToolbarButton.INTERACTION_MORE, this.q);
        this.q = null;
    L26:
        View r12 = this.b;
        if (r12 == null) goto L30;
        UtilityKotlinExtentionsKt.z(r12, this.t);
    L30:
        if ((r7 instanceof pp1.g) == false) goto L51;
        if (this.t == false) goto L51;
        View r13 = this.b;
        if (r13 == null) goto L38;
        if (r13.getVisibility() == 0) goto L51;
    L38:
        if (this.c == true) goto L51;
        tc0.c.h().z = "live_room_show";
        com.bytedance.android.live.liveinteract.utils.d r14 = jf0.c.a;
        jf0.c.i();
        goto L51
    L9:
        r8 = false;
        goto L10
    }

    public final void h(DataContext r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "requestPage");
        if (this.c == false) goto L5;
        return;
    L5:
        VideoRoomAudiencePreApplyDialog r0 = this.w;
        if (r0 == null) goto L11;
        if (r0.isShowing() != true) goto L11;
        return;
    L11:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue() == false) goto L31;
        IRoom r1 = this.y;
        if (r1 == null) goto L31;
        IBaseUser r2 = r1.getBaseOwner();
        if (r2 == null) goto L31;
        if (r2.isFollowing() == true) goto L31;
        if (com.bytedance.android.live.liveinteract.api.utils.m.m(r9) == null) goto L41;
        com.bytedance.android.livesdk.common.b r11 = this.x;
        if (r11 != null) goto L24;
    L26:
        q r12 = new q(this.g, com.bytedance.android.live.liveinteract.api.utils.m.i(), null, false, new f(this));
        this.x = r12;
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L30:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L24:
        if (r11.isShowing() != true) goto L26;
        return;
    L41:
        return;
    L31:
        Context r13 = this.g;
        if (r13 == null) goto L40;
        e(r13, r10);
        return;
    }

    public final void p4(View r9, DataCenter r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        this.A = true;
        this.b = r9;
        this.g = r9.getContext();
        this.c = a0.m(r10).c;
        this.d = r10;
        this.e = a0.m(r10).b;
        this.k = r9.findViewById(2131375894);
        this.l = r9.findViewById(2131393136);
        this.m = (ImageView) r9.findViewById(2131393133);
        View r1 = this.b;
        Long r2 = null;
        if (r1 == null) goto L5;
        HSImageView r3 = (HSImageView) r1.findViewById(2131393134);
    L6:
        this.n = r3;
        this.o = r9.findViewById(2131384095);
        this.a = (TextView) r9.findViewById(2131381099);
        if (this.c == true) goto L9;
    L21:
        IRoom r4 = (IRoom) r10.get("data_enter_room", null);
        this.y = r4;
        if (r4 != null) goto L25;
        this.y = (IRoom) r10.get("data_room", null);
    L25:
        if (this.c == false) goto L27;
        f(2131250849, 2131250849, 1.0f);
        r3.c(this.b, s1.B(2131917979), true);
    L28:
        r10.observe("data_interact_tips_show", this);
        r10.observe("cmd_send_show_apply_popup_success", this);
        r10.observe("data_video_talk_dot_with_number_show", this);
        r10.observe("data_interact_number_dot_show", this);
        r10.observe("data_online_changed_list", this);
        r10.observe("cmd_what_audience_join_self_link", this);
        r10.observe("data_link_pk_interact_show_red_dot", this);
        Intrinsics.checkNotNullParameter(r10, "$this$getMiddlewareLiveMode");
        LiveMode r5 = (LiveMode) r10.get("data_live_mode", LiveMode.UNDEFINED);
        LiveMode r6 = LiveMode.VIDEO;
        if (r5 != r6) goto L33;
        Disposable r7 = xs2.b.a().b(b2.class).subscribe(new c(this));
        if (r7 == null) goto L33;
        this.j.add(r7);
    L33:
        IRoom r8 = this.y;
        if (r8 != null) goto L36;
    L49:
        hd0.c.f().c(this.B);
        LiveMode r11 = (LiveMode) r10.get("data_live_mode");
        if (r11 != r6) goto L55;
        DataCenter r12 = this.d;
        if (r12 == null) goto L55;
        r12.observe("data_new_video_linkmic_state", this, true);
    L55:
        if (this.c == false) goto L65;
        if (r11 != r6) goto L58;
    L59:
        HashMap r13 = new HashMap();
        r13.put("action_type", "show");
        TalkRoomLogUtils.B0(r13, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        if (r11 != r6) goto L62;
        String r14 = "video_live";
    L63:
        r13.put("live_type", r14);
        j0.l().sendLog("livesdk_guest_connection_anchor", r13, new Object[]{IRoom.class});
        goto L65
    L62:
        r14 = "voice_live";
        goto L63
    L58:
        if (r11 == LiveMode.AUDIO) goto L59;
    L65:
        if (this.c == true) goto L67;
        r10.observe("data_audience_interact_game", this);
        r10.observe("DATA_LINK_DISMISS_WHEN_FLOATBALL_SHOW", this);
    L67:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.b r15 = this.u;
        HSImageView r16 = this.n;
        boolean r17 = this.c;
        IRoom r18 = this.y;
        if (r18 == null) goto L70;
        String r19 = r18.getAnchorId();
    L71:
        IRoom r20 = this.y;
        if (r20 == null) goto L74;
        String r21 = String.valueOf(r20.getRoomId());
    L75:
        r15.b(r16, r17, r19, r21);
        String r22 = this.v;
        if (r22 != null) goto L83;
        IInteractService r23 = (IInteractService) k.f(IInteractService.class);
        if (r23 == null) goto L82;
        com.bytedance.android.live.liveinteract.plantform.performance.a r24 = r23.getMultiLinkPerfAbilityManager(true);
        if (r24 == null) goto L82;
        r22 = r24.b("multilink_toolbar_degrade", new ToolbarVideoInteractBehavior$onLoad$5(this));
    L82:
        r22 = null;
    L83:
        this.v = r22;
        StringBuilder r25 = new StringBuilder("VideoBehavior#onLoad, roomId = ");
        IRoom r110 = this.y;
        if (r110 == null) goto L86;
        r2 = Long.valueOf(r110.getId());
    L86:
        r25.append(r2);
        ALogger.e("dzy-toolbar", r25.toString());
        Log.getStackTraceString(new Throwable("VideoBehavior#onload"));
        return;
    L74:
        r21 = null;
        goto L75
    L70:
        r19 = null;
        goto L71
    L36:
        if (r8.isLiveTypeAudio() == true) goto L49;
        com.bytedance.android.livesdk.sharedpref.e r26 = b6.d0;
        if (TextUtils.equals((CharSequence) r26.getValue(), "1") == false) goto L41;
        com.bytedance.android.livesdk.sharedpref.f.d(r26, "");
        this.f = true;
        r9.post(new d(this));
    L41:
        if (this.f == true) goto L49;
        if (vm2.c.e() == false) goto L49;
        if (this.c == false) goto L49;
        com.bytedance.android.livesdk.sharedpref.e r27 = b6.C;
        if (((Boolean) r27.getValue()).booleanValue() == true) goto L49;
        com.bytedance.android.livesdk.sharedpref.f.d(r27, Boolean.TRUE);
        r9.post(new e(this));
        goto L49
    L27:
        f(a.a(), a.a(), 1.0f);
        goto L28
    L9:
        if (vm2.d.s() == false) goto L21;
        View r28 = this.b;
        if ((r28 instanceof ViewGroup) == false) goto L21;
        if (r28 == null) goto L20;
        ((ViewGroup) r28).setClipChildren(false);
        View r29 = this.b;
        if (r29 == null) goto L18;
        ((ViewGroup) r29).setClipToPadding(false);
        goto L21
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r3 = null;
        goto L6
    }

    public final void f(int r3, int r4, float r5) {
        if (vm2.d.w0().a() == false) goto L21;
        ImageView r0 = this.m;
        if (r0 == null) goto L8;
        r0.setBackgroundResource(0);
    L8:
        if (a0.i(this.d) == false) goto L10;
    L15:
        HSImageView r6 = this.l;
        if (r6 == null) goto L18;
        r6.setActualImageResource(r4);
    L18:
        HSImageView r7 = this.l;
        if (r7 == null) goto L42;
        r7.setAlpha(r5);
    L42:
        if (g.f(this.y, 12, true) == false) goto L45;
        g.c(12, this.y, this.k);
        return;
    L45:
        return;
    L10:
        if (a0.f(this.d) == true) goto L15;
        HSImageView r8 = this.l;
        if (r8 == null) goto L42;
        r8.setActualImageResource(r3);
        goto L42
    L21:
        LottieAnimationView r1 = this.k;
        if (r1 == null) goto L24;
        r1.clearAnimation();
    L24:
        LottieAnimationView r2 = this.k;
        if (r2 == null) goto L28;
        r2.setBackgroundResource(0);
    L28:
        if (a0.i(this.d) == false) goto L30;
    L35:
        LottieAnimationView r9 = this.k;
        if (r9 == null) goto L38;
        r9.setImageResource(r4);
    L38:
        LottieAnimationView r10 = this.k;
        if (r10 == null) goto L42;
        r10.setAlpha(r5);
        goto L42
    L30:
        if (a0.f(this.d) == true) goto L35;
        LottieAnimationView r11 = this.k;
        if (r11 == null) goto L42;
        r11.setImageResource(r3);
        goto L42
    }
}
