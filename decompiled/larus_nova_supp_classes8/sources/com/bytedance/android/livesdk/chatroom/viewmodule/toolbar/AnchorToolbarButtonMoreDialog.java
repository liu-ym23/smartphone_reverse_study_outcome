package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.RedDotHelper;
import com.bytedance.android.livesdk.common.LiveViewStub;
import com.bytedance.android.livesdk.config.dc;
import com.bytedance.android.livesdk.config.ec;
import com.bytedance.android.livesdk.config.ev0;
import com.bytedance.android.livesdk.config.fc;
import com.bytedance.android.livesdk.config.xb;
import com.bytedance.android.livesdk.config.yb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IFloatWindowDegradeManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AnchorToolbarButtonMoreDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/d2;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorToolbarButtonMoreDialog extends CommonStandardBottomDialog implements View.OnClickListener, d2, Observer<KVData> {
    public final String B;
    public final ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> C;
    public ToolbarDisableController D;
    public final TreeSet<RedDotDelegate> E;
    public DataCenter F;
    public final ep1.c G;
    public ViewGroup H;
    public g3 I;
    public final boolean J;
    public final CompositeDisposable K;
    public GridLayout L;
    public boolean M;
    public long N;
    public final a O;
    public final Map<ToolbarButton, Integer> P;
    public final float Q;

    public static final class a extends a81.b.a {
        public final /* synthetic */ AnchorToolbarButtonMoreDialog a;

        public a(AnchorToolbarButtonMoreDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void c(AnchorToolbarButtonMoreDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        public final void b(int r2) {
            ALogger.i(this.a.B, "onFoldScreenChange");
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
            c(this.a);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r0 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorToolbarButtonMoreDialog a;

        public b(AnchorToolbarButtonMoreDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            ALogger.d(this.a.B, ((Throwable) r2).toString());
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorToolbarButtonMoreDialog a;
        public final /* synthetic */ View b;

        public c(AnchorToolbarButtonMoreDialog r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            View r0 = this.b;
            if (r0 == null) goto L6;
            r0.setBackgroundDrawable(new BitmapDrawable(this.a.getContext().getResources(), r5));
            return;
        }
    }

    public static final class d implements com.bytedance.android.live.broadcast.api.model.o0 {
        public final /* synthetic */ c0.b a;
        public final /* synthetic */ View b;

        public d(c0.b r1, View r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void setEnterFrom(String r1) {
    }

    public final boolean X0() {
        DataCenter r0 = this.F;
        zg1.m r1 = null;
        if (r0 == null) goto L5;
        r1 = (zg1.m) r0.get("data_broadcast_pause_state", null);
    L5:
        if (r1 == null) goto L11;
        int r2 = r1.a;
        if (r2 != 1) goto L9;
        return true;
    L9:
        if (r2 != 2) goto L11;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0() {
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = this.C;
        ArrayList r1 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        ToolbarButton r3 = r2.next().e();
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List<ToolbarButton> r4 = CollectionsKt.toMutableList(r1);
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r5 = this.C;
        ALogger.i(this.B, "isPaused:" + X0());
        g3 r6 = this.I;
        if (r6 != null) goto L11;
    L18:
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r7 = this.C;
        if (c4.a(this.J) == false) goto L22;
        this.E.clear();
        RedDotHelper.b(W0(r7), this.I, this.E);
    L22:
        if (PadConfigUtils.c() == false) goto L24;
        final int r8 = (int) (UIUtils.dip2Px(getContext(), 375.0f) / 4);
    L25:
        final LayoutInflater r9 = LayoutInflater.from(getContext());
        ViewGroup r10 = this.H;
        if (r10 != null) goto L28;
        return;
    L28:
        GridLayout r11 = this.L;
        if (r11 == null) goto L32;
        r11.removeAllViews();
    L32:
        if (this.G.c(r4, r10, new AnchorToolbarButtonMoreDialog$loadAllToolbarButton$result$1(this, r8, r9)) == true) goto L39;
        GridLayout r12 = this.L;
        if (r12 == null) goto L46;
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r13 = this.C.iterator();
    L37:
        if (r13.hasNext() == false) goto L47;
        a1(r8, r9, r13.next(), r12);
        goto L37
    L47:
        return;
    L46:
        return;
    L39:
        return;
    L24:
        r8 = com.bytedance.android.live.core.utils.s1.y() / 4;
        goto L25
    L11:
        if (X0() == false) goto L15;
        ArrayList<ExtendedToolbarButton> r14 = W0(r5);
        ToolbarDisableController r15 = this.D;
        if (r15 == null) goto L18;
        r15.a(r6, r14, AnchorToolbarButtonMoreDialog$adaptiveToolbarsDisable$1$1.INSTANCE);
        goto L18
    L15:
        ToolbarDisableController r16 = this.D;
        if (r16 == null) goto L18;
        r16.b(r6);
        goto L18
    }

    public final int getLayoutId() {
        DataCenter r0 = this.F;
        if (r0 == null) goto L7;
        return this.G.a(r0);
    L7:
        if (ec.a.getValue().booleanValue() == false) goto L10;
        return 2131565666;
    L10:
        return 2131565665;
    }

    public final void onDetachedFromWindow() {
        this.K.clear();
        DataCenter r0 = this.F;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        g3 r1 = this.I;
        if (r1 == null) goto L9;
        r1.H(false);
    L9:
        if (fc.a.getValue().intValue() <= 0) goto L13;
        IScreenRotateService r2 = jc1.k.f(IScreenRotateService.class);
        if (r2 == null) goto L13;
        r2.unregisterOnConfigChanged(this.F, this.O);
    L13:
        super.onDetachedFromWindow();
        IFloatWindowDegradeManager r3 = jc1.k.f(IFloatWindowDegradeManager.class);
        if (r3 == null) goto L16;
        r3.checkRecoverForNative("more_panel", "dismiss");
    L16:
        DataCenter r4 = this.F;
        if (r4 == null) goto L20;
        r4.put("data_anchor_more_dialog_show", Boolean.FALSE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (c4.b(this.J) == false) goto L20;
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.g.a;
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, -1L);
        y3.m(this.F).b(ToolbarButton.MORE, new pp1.j(false));
    L20:
        com.bytedance.android.livesdk.f.d().g("MORE");
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        DataCenter r0 = this.F;
        if (r0 == null) goto L5;
        int r1 = z3.a;
        z3.c(r0, !((SheetBaseDialog) this).r);
    L5:
        Z0();
        IFloatWindowDegradeManager r2 = jc1.k.f(IFloatWindowDegradeManager.class);
        if (r2 == null) goto L8;
        r2.checkDegradeForNative("more_panel");
    L8:
        DataCenter r3 = this.F;
        if (r3 == null) goto L12;
        r3.put("data_anchor_more_dialog_show", Boolean.TRUE);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r0.addFlags(Integer.MIN_VALUE);
    L5:
        Window r1 = getWindow();
        if (r1 == null) goto L8;
        r1.setNavigationBarColor(-16777216);
    L8:
        DataCenter r2 = this.F;
        if (r2 == null) goto L12;
        int r3 = z3.a;
        z3.a(r2, getWindow());
    L12:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(this);
    L16:
        com.bytedance.android.livesdk.f.d().b("MORE", this);
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r4 = this.C.iterator();
    L18:
        if (r4.hasNext() == false) goto L26;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r5 = r4.next();
        g3 r6 = this.I;
        if (r6 == null) goto L22;
        c0.b r7 = r6.s(r5.m);
    L24:
        if ((r7 instanceof n) == false) goto L18;
        ((n) r7).onShow();
        goto L18
    L22:
        r7 = null;
        goto L24
    L26:
        DataCenter r8 = this.F;
        if (r8 == null) goto L29;
        r8.observe("cmd_live_toolbarmore_dialog_dismiss", this);
    L29:
        String r9 = "tool_panel";
        if (Y0(ToolbarButton.DOU_PLUS_PROMOTE) == true) goto L41;
        if (Y0(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == true) goto L41;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L41;
        if (this.J == false) goto L38;
        String r10 = "tool_panel";
    L39:
        kjc.a.call(new com.bytedance.android.livesdk.business.douplus.a(r10, 0, "10001", "未知原因"));
        goto L41
    L38:
        r10 = "share_panel";
    L41:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L44;
        kjc.a.call(new com.bytedance.android.livesdk.business.douplus.a("share_panel", 0, "10000", "用户未登录"));
    L44:
        if (Y0(ToolbarButton.REN_QI_BAO) == true) goto L55;
        if (n5.c(this.F) == false) goto L55;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L55;
        int r11 = q4.e;
        if (this.J == true) goto L53;
        r9 = "share_panel";
    L53:
        q4.a.a(0, r9, "10001", "未知原因");
    L55:
        if (n5.c(this.F) == true) goto L57;
        return;
    L57:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L69;
        int r12 = q4.e;
        q4.a.a(0, "share_panel", "10000", "用户未登录");
        return;
    L69:
        return;
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L15:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L16
    }

    public static void c1(View r1) {
        if ((r1 instanceof HSImageView) == false) goto L9;
        r1.setBackgroundResource(0);
        if (xb.a.getValue().booleanValue() == false) goto L7;
        ((HSImageView) r1).setImageResource(2131251040);
        return;
    L7:
        ((HSImageView) r1).setImageResource(2131251038);
        return;
    }

    public final ArrayList<ExtendedToolbarButton> W0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r3) {
        ArrayList<ExtendedToolbarButton> r0 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r4.next()).m);
        goto L4
    L6:
        return r0;
    }

    public final boolean Y0(ToolbarButton r4) {
        Iterator<T> r0 = this.C.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ExtendedToolbarButton r1 = ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r0.next()).m;
        if ((r1 instanceof ExtendedToolbarButton.b) == false) goto L4;
        if (((ExtendedToolbarButton.b) r1).i != r4) goto L4;
        return true;
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r4.getKey(), "cmd_live_toolbarmore_dialog_dismiss") == false) goto L27;
        Handler r5 = DialogLancet.resolveDialogHandler(this);
        if (r5 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(this);
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r6 == null) goto L20;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L9:
        if (Looper.myLooper() == r5.getLooper()) goto L11;
        r5.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        Long r0 = null;
        String r1 = null;
        if (r12 == null) goto L5;
        Object r2 = r12.getTag();
    L7:
        if ((r2 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) == true) goto L9;
        r2 = null;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r2;
        if (r3 == null) goto L12;
        ExtendedToolbarButton r5 = r3.m;
    L13:
        if (r5 != null) goto L15;
        return;
    L15:
        if (X0() == false) goto L22;
        g3 r4 = this.I;
        if (r4 == null) goto L22;
        if (r4.x(r5) != true) goto L22;
        com.bytedance.android.live.core.utils.f2.b(2131915411, 0);
        return;
    L22:
        g3 r6 = this.I;
        if (r6 == null) goto L25;
        c0.b r8 = r6.s(r5);
    L26:
        g3 r7 = this.I;
        if (r7 != null) goto L29;
    L37:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r9 = r3.j;
        if (r9 != null) goto L40;
    L48:
        if (r8 != null) goto L50;
        return;
    L50:
        if (c4.a(this.J) == false) goto L58;
        if (r12 == null) goto L53;
        Object r10 = r12.findViewById(2131384095);
    L55:
        if ((r10 instanceof RedDotView) == false) goto L58;
        ((RedDotView) r10).l();
        goto L58
    L53:
        r10 = null;
    L58:
        if (c4.b(this.J) == false) goto L67;
        if (Intrinsics.areEqual(r5.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L67;
        if (this.N <= 0) goto L67;
        Object r11 = r12.findViewById(2131384095);
        if ((r11 instanceof RedDotView) == false) goto L67;
        ((RedDotView) r11).l();
    L67:
        if (ev0.a.getValue().booleanValue() == false) goto L79;
        HashMap<ToolbarButton, Integer> r13 = com.bytedance.android.livesdk.chatroom.utils.k4.a;
        if (CollectionsKt.contains(r13.keySet(), r3.e()) == false) goto L79;
        if (dc.a.getValue().booleanValue() == false) goto L73;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    L73:
        IMiddlewareBroadcastService r14 = jc1.k.f(IMiddlewareBroadcastService.class);
        if (r14 == null) goto L87;
        Context r15 = r12.getContext();
        Integer r16 = r13.get(r3.e());
        if (r16 == null) goto L78;
        r0 = Long.valueOf(r16.intValue());
    L78:
        r14.checkToolbarPermission(r15, r0, "live_detail", new d(r8, r12));
        return;
    L87:
        return;
    L79:
        r8.onClick(r12);
        b4.c.a.b(r5.f());
        b1(r12.findViewById(2131384095), r5, null, r3.e(), r8);
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        Integer r17 = this.P.get(r3.e());
        if (r17 == null) goto L85;
        String.valueOf(r17.intValue());
        throw null;
    L85:
        throw null;
    L40:
        if (r9.a() != true) goto L48;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r18 = r3.j;
        if (r18 == null) goto L44;
        String r19 = r18.b;
    L46:
        if (TextUtils.isEmpty(r19) == true) goto L48;
        com.bytedance.android.live.core.utils.f2.c(r19, 0);
        goto L48
    L44:
        r19 = null;
        goto L46
    L29:
        if (r7.x(r5) != true) goto L37;
        g3 r110 = this.I;
        if (r110 == null) goto L34;
        r1 = r110.u(r5);
    L34:
        if (TextUtils.isEmpty(r1) == true) goto L84;
        com.bytedance.android.live.core.utils.f2.c(r1, 0);
        return;
    L84:
        return;
    L25:
        r8 = null;
        goto L26
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        ViewGroup r6 = (ViewGroup) findViewById(2131367728);
        this.H = r6;
        if (r6 == null) goto L5;
        r6.setOnClickListener(this);
    L5:
        ViewGroup r7 = this.H;
        if (r7 == null) goto L8;
        r7.setImportantForAccessibility(2);
    L8:
        this.L = (GridLayout) findViewById(2131373902);
        findViewById(2131369197);
        GridLayout r8 = (GridLayout) findViewById(2131375512);
        TextView r9 = (TextView) findViewById(2131380302);
        if (fc.a.getValue().intValue() <= 0) goto L26;
        IScreenRotateService r10 = jc1.k.f(IScreenRotateService.class);
        if (r10 == null) goto L14;
        r10.registerOnConfigChanged(this.F, this.O);
    L14:
        if (this.C.size() <= 12) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L26;
        if (yb.a.getValue().booleanValue() == false) goto L21;
        int r12 = UtilityKotlinExtentionsKt.i(484);
    L22:
        ViewGroup r0 = this.H;
        if (r0 == null) goto L26;
        com.bytedance.android.live.core.utils.a1.k(r0, r12);
        goto L26
    L21:
        r12 = Math.max(UtilityKotlinExtentionsKt.i(300), com.bytedance.android.live.core.utils.s1.w() / 2);
        goto L22
    L16:
        r11 = false;
    L26:
        if (getWindow() == null) goto L30;
        Window r13 = getWindow();
        if (r13 == null) goto L30;
        r13.setDimAmount(0.0f);
    L30:
        int r14 = com.bytedance.android.livesdk.utils.b1.a;
        com.bytedance.android.livesdk.utils.b1.b(true, new AnchorToolbarButtonMoreDialog$initDialogUI$1(this));
    }

    public final void setDataCenter(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.F = r3;
        if (r3 == null) goto L5;
        Room r4 = (Room) r3.get("data_room", null);
    L5:
        this.I = y3.f(this.F);
    }

    public AnchorToolbarButtonMoreDialog(Context r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, true, false, 8);
        this.B = "AbsAudienceToolbarButtonMoreDialog";
        this.C = new ArrayList();
        this.E = new TreeSet();
        int r10 = ep1.d.a;
        this.G = ep1.d.a(Panel.MORE);
        this.J = true;
        this.K = new CompositeDisposable();
        this.N = -1;
        this.O = new a(this);
        this.P = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ToolbarButton.BGM, 3001), TuplesKt.to(ToolbarButton.FNA_GROUP, 3002), TuplesKt.to(ToolbarButton.FAN_GROUP_MANAGE, 3002), TuplesKt.to(ToolbarButton.COMMENT, 3003), TuplesKt.to(ToolbarButton.ADVANCE_ANNOUNCEMENT, 3007), TuplesKt.to(ToolbarButton.BROADCAST_INFO, 3051), TuplesKt.to(ToolbarButton.SHARE, 3053), TuplesKt.to(ToolbarButton.RECORD, 3056), TuplesKt.to(ToolbarButton.PUBLIC_SCREEN_SELECTED_MESSAGE, 3057), TuplesKt.to(ToolbarButton.PUBLIC_SCREEN_CONFIG, 3058), TuplesKt.to(ToolbarButton.BROADCAST_PAUSE, 3059), TuplesKt.to(ToolbarButton.ADD_PICTURE, 3071), TuplesKt.to(ToolbarButton.BROADCAST_ADMIN, 3103), TuplesKt.to(ToolbarButton.STABLE_MODE, 3060), TuplesKt.to(ToolbarButton.MANAGE, 3104), TuplesKt.to(ToolbarButton.ANCHOR_CHAT_CHANNEL, 3061), TuplesKt.to(ToolbarButton.PUBLIC_SCREEN_AI_HELPER, 3062)});
        this.Q = 0.64f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d2
    public final void l0(List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r9, boolean r10) {
        if (r9 == null) goto L26;
        List<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = r9;
        boolean r2 = true;
        if ((!r0.isEmpty()) != true) goto L29;
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r1 = this.C;
        if (r1.size() == r9.size()) goto L9;
    L8:
        r2 = false;
    L15:
        if (r2 == false) goto L18;
        ALogger.i("AbsAudienceToolbarButtonMoreDialog", "all button same");
        return;
    L18:
        this.C.clear();
        this.C.addAll(r0);
        if (r10 == true) goto L21;
        return;
    L21:
        if (isShowing() == false) goto L28;
        Z0();
        return;
    L28:
        return;
    L9:
        int r3 = r1.size();
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L15;
        if ((!Intrinsics.areEqual((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r1, r4), (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) ListProtector.get(r9, r4))) == true) goto L8;
        r4 = r4 + 1;
        goto L10
    L29:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a1(int r22, LayoutInflater r23, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r24, GridLayout r25) {
        ToolbarButton r1 = r24.e();
        if (r1 == null) goto L140;
        ExtendedToolbarButton r2 = r1.extended();
        if (r2 == null) goto L143;
        g3 r3 = this.I;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.s(r2) != null) goto L13;
        return;
    L13:
        if (com.bytedance.android.live.core.utils.z.k(this.F) == false) goto L15;
    L24:
        int r4 = 2131567625;
    L26:
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.ANCHOR_BACKTRACK.name()) == true) goto L30;
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.RECORD_COMBINE.name()) == true) goto L30;
    L33:
        if (c4.b(this.J) == false) goto L38;
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L38;
        r4 = 2131567626;
    L38:
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.LIVE_IM_ENTRANCE_MORE.name()) == false) goto L40;
        r4 = 2131567873;
    L40:
        if (r23 == null) goto L142;
        View r9 = r23.inflate(r4, r25, false);
        if (r9 == null) goto L145;
        ViewGroup.LayoutParams r0 = r9.getLayoutParams();
        r0.width = r22;
        r9.setLayoutParams(r0);
        final View r10 = r9.findViewById(2131374718);
        final TextView r11 = (TextView) r9.findViewById(2131380593);
        View r12 = r9.findViewById(2131384095);
        View r13 = r9.findViewById(2131362039);
        TextView r5 = (TextView) r9.findViewById(2131374747);
        int r6 = com.bytedance.android.livesdk.utils.b1.a;
        com.bytedance.android.livesdk.utils.b1.b(true, new AnchorToolbarButtonMoreDialog$loadToolbarButton$1(r10, r11));
        if (r10 == null) goto L47;
        r10.setBackgroundResource(r24.b);
    L47:
        if (r11 == null) goto L49;
        r11.setText(r24.f);
    L49:
        if (r11 == null) goto L52;
        r11.setAccessibilityDelegate(com.bytedance.android.live.core.utils.t.a);
    L52:
        if (c4.b(this.J) == false) goto L62;
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L62;
        if (r12 == 0) goto L62;
        if (c4.b(this.J) == false) goto L62;
        if ((r12 instanceof RedDotView) == false) goto L62;
        ((RedDotView) r12).m(new com.bytedance.android.livesdk.reddot.a("more_gift", -1, 2, 4, -1), null, null, Boolean.valueOf(this.J));
    L62:
        if (c4.b(this.J) == false) goto L71;
        if (Intrinsics.areEqual(r2.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L71;
        if ((r12 instanceof RedDotView) == false) goto L71;
        RedDotDelegate r7 = r2.c;
        if (r7 == null) goto L71;
        ((RedDotView) r12).n(r7, Boolean.valueOf(this.J));
    L71:
        if (r24.a == false) goto L82;
        List<String> r8 = r24.c;
        if (r8 == null) goto L82;
        if ((!r8.isEmpty()) != true) goto L82;
        CompositeDisposable r14 = this.K;
        List<String> r15 = r24.c;
        if (r15 == null) goto L80;
        String r16 = (String) ListProtector.get(r15, 0);
        if (r16 == null) goto L80;
    L81:
        r14.add(com.bytedance.android.livesdk.utils.g3.a(r16).toMaybe().observeOn(AndroidSchedulers.mainThread()).doOnError(new b(this)).onErrorComplete().subscribe(new c(this, r10)));
    L80:
        r16 = "";
    L82:
        if (r5 != null) goto L84;
    L86:
        if (r5 == null) goto L89;
        UtilityKotlinExtentionsKt.t(r5);
    L89:
        if (r24.d == false) goto L99;
        if (r10 == null) goto L99;
        ImageView r17 = new ImageView(r10.getContext());
        if (r24.e == false) goto L94;
        int r18 = 2131251591;
    L95:
        r17.setBackgroundResource(r18);
        LiveViewStub r19 = (LiveViewStub) r9.findViewById(2131374798);
        if (r19 == null) goto L99;
        r19.a(r17);
        goto L99
    L94:
        r18 = 2131251590;
    L99:
        if (c4.a(this.J) == true) goto L101;
    L105:
        if (r10 == null) goto L111;
        ExtendedToolbarButton r20 = r24.m;
        ToolbarButton r21 = r24.e();
        g3 r26 = this.I;
        if (r26 == null) goto L109;
        c0.b r110 = r26.s(r2);
    L110:
        b1(r12, r20, r10, r21, r110);
        goto L111
    L109:
        r110 = null;
    L111:
        if (r13 == null) goto L113;
        r13.setAlpha(1.0f);
    L113:
        g3 r27 = this.I;
        if (r27 != null) goto L116;
    L117:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h r28 = r24.j;
        if (r28 != null) goto L120;
    L127:
        r9.setTag(r24);
        if (r25 == null) goto L130;
        r25.addView(r9);
    L130:
        g3 r29 = this.I;
        if (r29 == null) goto L135;
        Map<ExtendedToolbarButton, View> r30 = r29.c;
        if (r30 == null) goto L135;
        View r31 = (View) ((HashMap) r30).put(r24.m, r9);
    L135:
        g3 r32 = this.I;
        if (r32 == null) goto L138;
        r32.D(r24.m, r9);
    L138:
        r9.setOnClickListener(this);
        return;
    L120:
        if (r28.a() != true) goto L127;
    L121:
        if (r10 == null) goto L123;
        r10.setAlpha(this.Q);
    L123:
        if (r11 == null) goto L125;
        r11.setAlpha(this.Q);
    L125:
        if (r12 == 0) goto L127;
        r12.setAlpha(0.0f);
        goto L127
    L116:
        if (r27.x(r24.m) == true) goto L121;
    L101:
        if ((r12 instanceof RedDotView) == false) goto L105;
        RedDotDelegate r33 = r24.m.c;
        if (r33 == null) goto L105;
        ((RedDotView) r12).n(r33, Boolean.FALSE);
        goto L105
    L84:
        if (TextUtils.isEmpty(r24.h) == true) goto L86;
        UtilityKotlinExtentionsKt.w(r5);
        r5.setText(r24.h);
        goto L89
    L145:
        return;
    L142:
        return;
    L30:
        if (this.J == false) goto L33;
        r4 = 2131567624;
        goto L33
    L15:
        if (com.bytedance.android.live.core.utils.z.g(this.F) == true) goto L24;
        if (com.bytedance.android.live.core.utils.z.i(this.F) == true) goto L24;
        if (com.bytedance.android.live.core.utils.z.j(this.F) == true) goto L24;
        if (com.bytedance.android.live.core.utils.z.h(this.F) == true) goto L24;
        r4 = 2131567633;
        goto L26
    L143:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b1(View r17, ExtendedToolbarButton r18, View r19, ToolbarButton r20, c0.b r21) {
        final View r1 = r17;
        if (r1 != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r18.f()) == true) goto L98;
        if (r19 == null) goto L99;
        int r3 = com.bytedance.android.livesdk.utils.b1.a;
        boolean r4 = true;
        com.bytedance.android.livesdk.utils.b1.b(true, new AnchorToolbarButtonMoreDialog$renderIconRedDot$1(r1));
        if (c4.b(this.J) == false) goto L26;
        if (Intrinsics.areEqual(r18.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L26;
        if ((r1 instanceof RedDotView) == false) goto L26;
        RedDotView r5 = (RedDotView) r1;
        RedDotDelegate r7 = r5.getRedDot();
        if (r7 == null) goto L17;
        r7.e();
    L17:
        long r8 = ((Number) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        this.N = r8;
        if (r8 <= 0) goto L21;
        r5.o();
    L21:
        if (com.bytedance.android.livesdk.config.e.a.getValue().booleanValue() == false) goto L26;
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.S3;
        if (((Boolean) r9.getValue()).booleanValue() == true) goto L26;
        r5.o();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, Boolean.TRUE);
    L26:
        if (c4.a(this.J) == false) goto L31;
        if ((r1 instanceof RedDotView) == false) goto L38;
        boolean r6 = ((RedDotView) r1).j();
    L41:
        if (c4.b(this.J) == false) goto L75;
        if (Intrinsics.areEqual(r18.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L75;
        int r10 = 8;
        if (r6 == false) goto L70;
        boolean r11 = r1 instanceof RedDotView;
        if (r11 == false) goto L70;
        this.N = ((Number) com.bytedance.android.livesdk.sharedpref.g.a.getValue()).longValue();
        ImageModel r12 = (ImageModel) com.bytedance.android.livesdk.sharedpref.g.c.getValue();
        if (this.N < 0) goto L64;
        if (r12 == null) goto L64;
        if (CollectionUtils.isEmpty(r12.getUrls()) == true) goto L64;
        r19.setBackgroundResource(0);
        c1(r19);
        z3.e(r19);
        if (r11 == true) goto L56;
        Object r2 = null;
    L57:
        RedDotView r13 = (RedDotView) r2;
        if (r13 == null) goto L60;
        r13.setVisibility(8);
    L60:
        RedDotView r14 = (RedDotView) r1;
        RedDotDelegate r15 = r14.a;
        if (r15 == null) goto L63;
        r15.e();
    L63:
        r14.b = true;
        this.M = true;
        goto L75
    L56:
        r2 = r1;
    L64:
        c1(r19);
        Object r16 = r1;
        if (r11 == true) goto L67;
        r16 = null;
    L67:
        RedDotView r22 = (RedDotView) r16;
        if (r22 == null) goto L75;
        r22.setVisibility(0);
    L70:
        c1(r19);
        if (r6 == false) goto L73;
        r10 = 0;
    L73:
        r1.setVisibility(r10);
    L75:
        if (c4.b(this.J) == true) goto L77;
    L87:
        c0.b r23 = r21;
        if ((r23 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d) == true) goto L90;
        r23 = null;
    L90:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d r24 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d) r23;
        ((IBroadcastService) va1.b.a.a.a(IBroadcastService.class)).getBroadcastDotManager();
        Integer r25 = this.P.get(r20);
        if (r25 == null) goto L93;
        String.valueOf(r25.intValue());
    L93:
        if (r24 == null) goto L97;
        new WeakReference(r24);
        throw null;
    L97:
        throw null;
    L77:
        if (Intrinsics.areEqual(r18.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L87;
        DataCenter r26 = this.F;
        if (r26 == null) goto L87;
        int r27 = z3.a;
        if (r6 == true) goto L83;
    L85:
        r4 = false;
    L86:
        z3.d(r26, r4);
        goto L87
    L83:
        if (this.M == false) goto L85;
    L38:
        r6 = false;
        goto L41
    L31:
        if (c4.b(this.J) == true) goto L33;
    L39:
        r6 = b4.c.a.d(r18, this.I);
        goto L41
    L33:
        if (Intrinsics.areEqual(r18.f(), ToolbarButton.BROADCAST_GIFT.name()) == false) goto L39;
        if ((r1 instanceof RedDotView) == false) goto L38;
        r6 = ((RedDotView) r1).j();
        goto L41
    L99:
        return;
    }
}
