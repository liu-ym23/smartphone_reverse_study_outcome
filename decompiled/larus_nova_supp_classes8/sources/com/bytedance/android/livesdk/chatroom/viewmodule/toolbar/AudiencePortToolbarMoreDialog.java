package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.MorePanelDynamicControllerViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorBacktrackBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAnchorRecordBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarAudioCommentBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.ToolbarShakeMatchBehavior;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.config.ka0;
import com.bytedance.android.livesdk.feed.viewmodel.LiveFeedViewModel;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.n5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AudiencePortToolbarMoreDialog;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/AbsAudienceToolbarButtonMoreDialog;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortToolbarMoreDialog extends AbsAudienceToolbarButtonMoreDialog {
    public View Q;
    public View R;
    public LinearLayout S;
    public Fragment T;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final x3 b1() {
        g3 r0 = y3.f(this.F);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarManager");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void g1() {
        Iterator<T> r0 = this.G.iterator();
    L3:
        int r2 = 0;
        int r3 = 8;
        if (r0.hasNext() == false) goto L10;
        Pair r1 = (Pair) r0.next();
        View r4 = (View) r1.getFirst();
        if (((ViewGroup) r1.getFirst()).getChildCount() > 0) goto L9;
        r2 = 8;
    L9:
        UIUtils.setViewVisibility(r4, r2);
        goto L3
    L10:
        RecyclerView r5 = this.H;
        if (r5 == null) goto L15;
        RecyclerView.Adapter r6 = r5.getAdapter();
        if (r6 == null) goto L15;
        int r7 = r6.getItemCount();
    L16:
        if (r7 > 0) goto L19;
        r2 = 8;
    L19:
        UIUtils.setViewVisibility(r5, r2);
        View r8 = this.Q;
        RecyclerView r9 = this.H;
        if (r9 == null) goto L22;
        int r10 = r9.getVisibility();
    L23:
        UIUtils.setViewVisibility(r8, r10);
        View r11 = this.R;
        LinearLayout r12 = this.S;
        if (r12 == null) goto L26;
        r3 = r12.getVisibility();
    L26:
        UIUtils.setViewVisibility(r11, r3);
        return;
    L22:
        r10 = 8;
    L15:
        r7 = 0;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L18:
        if (this.L == true) goto L103;
        this.L = true;
        HashMap r3 = new HashMap();
        ArrayList<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r4 = this.C;
        ArrayList r5 = new ArrayList();
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r6 = r4.iterator();
    L21:
        boolean r7 = false;
        if (r6.hasNext() == false) goto L33;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r8 = r6.next();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r9 = r8;
        if (r9.l.length() <= 0) goto L26;
        boolean r10 = true;
    L27:
        if (r10 == true) goto L29;
    L31:
        if (r7 == false) goto L21;
        r5.add(r8);
        goto L21
    L29:
        if (r9.i != 2) goto L31;
        r7 = true;
        goto L31
    L26:
        r10 = false;
        goto L27
    L33:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r12 = r5.iterator();
    L35:
        if (r12.hasNext() == false) goto L37;
        r11.add(((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e) r12.next()).l);
        goto L35
    L37:
        StringBuilder r13 = new StringBuilder();
        Iterator r14 = r11.iterator();
    L39:
        if (r14.hasNext() == false) goto L42;
        r13.append((String) r14.next());
        r13.append("|");
        goto L39
    L42:
        if (r13.length() <= 0) goto L44;
        boolean r15 = true;
    L45:
        if (r15 == false) goto L47;
        r13.deleteCharAt(r13.length() - 1);
    L47:
        r3.put("icon_type", r13.toString());
        am2.j.c r16 = am2.j.a().b;
        if (r16 != null) goto L50;
        int r17 = -1;
    L51:
        r3.put("net_quality", String.valueOf(r17));
        MorePanelDynamicControllerViewModel.Companion r18 = MorePanelDynamicControllerViewModel.Companion;
        DataCenter r19 = this.F;
        r18.getClass();
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.k r20 = MorePanelDynamicControllerViewModel.Companion.a(r19);
        if (r20 == null) goto L56;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r21 = r20.getTheGuideButton();
        r20.setTheGuideButton(null);
        if (r21 == null) goto L56;
        r3.put("bubble_type", r21.l);
    L56:
        IUserService r22 = jc1.k.f(IUserService.class);
        if (r22 == null) goto L65;
        com.bytedance.android.livesdk.user.f r23 = r22.user();
        if (r23 == null) goto L65;
        IUser r24 = r23.b();
        if (r24 == null) goto L65;
        py.d r25 = r24.getUserHonor();
        if (r25 == null) goto L65;
        int r26 = r25.getLevel();
    L66:
        r3.put("privilege_level", String.valueOf(r26));
        String r27 = this.O;
        if (r27 == null) goto L69;
        r3.put("enter_from", r27);
    L69:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_more_function_panel_icon_show", r3, new Object[]{am2.x.class, Room.class});
    L65:
        r26 = 0;
        goto L66
    L50:
        r17 = r16.getNetQuality();
        goto L51
    L44:
        r15 = false;
    L103:
        Fragment r1 = this.T;     // Catch: Exception -> L98
        if (r1 == null) goto L115;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.F, 0, 2);     // Catch: Exception -> L98
        if (r2 == null) goto L81;
        com.bytedance.live.datacontext.n r28 = r2.getFragmentInfoGetter();     // Catch: Exception -> L98
        if (r28 == null) goto L81;
        h80.d r29 = (h80.d) r28.getValue();     // Catch: Exception -> L98
        if (r29 == null) goto L81;
        Pair r30 = (Pair) r29.get();     // Catch: Exception -> L98
        if (r30 == null) goto L81;
        FragmentManager r31 = (FragmentManager) r30.getSecond();     // Catch: Exception -> L98
    L83:
        if (((Boolean) ka0.a.getValue()).booleanValue() == true) goto L90;
        if (r31 == null) goto L96;
        FragmentTransaction r32 = r31.beginTransaction();     // Catch: Exception -> L98
        if (r32 == null) goto L96;
        FragmentTransaction r33 = r32.remove(r1);     // Catch: Exception -> L98
        if (r33 == null) goto L96;
        r33.commitNowAllowingStateLoss();     // Catch: Exception -> L98
    L96:
        this.T = null;     // Catch: Exception -> L98
        return;
    L90:
        if (r31 == null) goto L96;
        FragmentTransaction r34 = r31.beginTransaction();     // Catch: Exception -> L98
        if (r34 == null) goto L96;
        FragmentTransaction r35 = r34.remove(r1);     // Catch: Exception -> L98
        if (r35 == null) goto L96;
        r35.commitAllowingStateLoss();     // Catch: Exception -> L98
    L81:
        r31 = null;
        goto L83
    L115:
        return;
    L98:
        e = move-exception;
        SafetyGuard.a(null, e, "more panel remove fragment crash");
        ALogger.e("AudiencePortToolbarMoreDialog", "more panel remove fragment crash, error: " + e.getMessage());
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r36 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r36 == null) goto L16;
        com.bytedance.crash.d.d(r36, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L18
    }

    public final int getLayoutId() {
        jp1.c r0 = a1();
        if (r0 == null) goto L14;
        Integer r1 = Integer.valueOf(r0.a());
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        return r1.intValue();
    L7:
        r2 = false;
    L14:
        if (PadConfigUtils.c() == false) goto L16;
        return 2131565424;
    L16:
        return 2131565410;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void h1() {
        TextView r0 = (TextView) findViewById(2131380302);
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.t(r0);
    L5:
        this.Q = findViewById(2131388310);
        RecyclerView r1 = findViewById(2131388311);
        this.H = r1;
        if (r1 == null) goto L8;
        r1.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L8:
        GridLayout r2 = (GridLayout) findViewById(2131373902);
        if (r2 == null) goto L15;
        this.G.add(TuplesKt.to(r2, 2));
        r2.setPadding(UtilityKotlinExtentionsKt.i(5), com.bytedance.android.live.core.utils.s1.f(16.0f), UtilityKotlinExtentionsKt.i(5), r2.getPaddingBottom());
        if (com.bytedance.android.livesdk.config.setting.o.b() == false) goto L13;
        r2.setColumnCount(5);
    L14:
        Unit r3 = Unit.INSTANCE;
        goto L15
    L13:
        r2.setColumnCount(4);
    L15:
        LinearLayout r4 = (LinearLayout) findViewById(2131371978);
        if (r4 == null) goto L18;
        this.G.add(TuplesKt.to(r4, 3));
        Unit r5 = Unit.INSTANCE;
    L19:
        this.S = r4;
        this.R = findViewById(2131369210);
        return;
    L18:
        r4 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void i1() {
        super.i1();
        if (e1(ToolbarButton.DOU_PLUS_PROMOTE) == true) goto L10;
        if (e1(ToolbarButton.DOU_PLUS_PROMOTE_AUDIENCE) == true) goto L10;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L10;
        kjc.a.call(new com.bytedance.android.livesdk.business.douplus.a("share_panel", 0, "10001", "未知原因"));
    L10:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L13;
        kjc.a.call(new com.bytedance.android.livesdk.business.douplus.a("share_panel", 0, "10000", "用户未登录"));
    L13:
        if (e1(ToolbarButton.REN_QI_BAO) == true) goto L20;
        if (n5.c(this.F) == false) goto L20;
        if (TTLiveSDKContext.getHostService().h().isLogin() == false) goto L20;
        int r0 = q4.e;
        q4.a.a(0, "share_panel", "10001", "未知原因");
    L20:
        if (n5.c(this.F) == true) goto L22;
        return;
    L22:
        if (TTLiveSDKContext.getHostService().h().isLogin() == true) goto L26;
        int r1 = q4.e;
        q4.a.a(0, "share_panel", "10000", "用户未登录");
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y3.m(this.F).b(ToolbarButton.MORE, new pp1.j(false));
        x3 r0 = this.I;
        if (r0 == null) goto L6;
        r0.H(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
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
        if (r2 == null) goto L11;
        int r3 = z3.a;
        z3.a(r2, getWindow());
    L11:
        com.bytedance.android.livesdk.log.filter.t r4 = com.bytedance.android.livesdk.log.j0.l().c(am2.x.class);
        if ((r4 instanceof com.bytedance.android.livesdk.log.filter.t) == false) goto L14;
        String r5 = String.valueOf(r4.getMap().get("enter_from_merge"));
    L15:
        com.bytedance.android.livesdk.log.j0 r6 = com.bytedance.android.livesdk.log.j0.l();
        HashMap r7 = new HashMap();
        r7.put("enter_from", r5);
        r7.put("schema_type", LiveFeedViewModel.DOUBLE_FEED_WITH_BANNER);
        r7.put("panel_name", "share_3row_panel");
        Unit r8 = Unit.INSTANCE;
        r6.h("ug_share_channel_show", r7, new Object[0]);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L22;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L22:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        return;
    L14:
        r5 = "";
        goto L15
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2
    public final Fragment W() {
        return this.T;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public AudiencePortToolbarMoreDialog(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (FoldScreenUtils.f() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        super(r3, false, r0);
        return;
    L5:
        if (((CommunityFoldFixConfig) e81.b.getValue()).getEnableExperience() == false) goto L7;
        r0 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j1(AudiencePortToolbarMoreDialog r3) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Window r8 = getWindow();
        if (r8 == null) goto L5;
        r8.setDimAmount(0.0f);
    L5:
        MoreMixSharePanelUtils r9 = MoreMixSharePanelUtils.INSTANCE;
        DataCenter r0 = this.F;
        boolean r1 = true;
        if (r0 == null) goto L8;
        boolean r2 = gb2.a.c(r0, true);
    L10:
        if (r9.isMoreMixShareMode(false, r2) == false) goto L14;
        Window r3 = getWindow();
        if (r3 == null) goto L14;
        r3.setSoftInputMode(48);
    L14:
        DataCenter r4 = this.F;
        if (r4 == null) goto L18;
        r1 = gb2.a.c(r4, true);
    L18:
        if (r9.isMoreMixShareMode(false, r1) == true) goto L21;
        return;
    L21:
        if (this.T != null) goto L43;
        Fragment r10 = new Fragment();
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, this.F, 0, 2);
        if (r5 == null) goto L31;
        com.bytedance.live.datacontext.n r6 = r5.getFragmentInfoGetter();
        if (r6 == null) goto L31;
        h80.d r11 = (h80.d) r6.getValue();
        if (r11 == null) goto L31;
        Pair r12 = (Pair) r11.get();
        if (r12 == null) goto L31;
        FragmentManager r13 = (FragmentManager) r12.getSecond();
    L32:
        if (r13 == null) goto L41;
        FragmentTransaction r14 = r13.beginTransaction();
        if (r14 == null) goto L41;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r10, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AudiencePortToolbarMoreDialog", 0) == true) goto L39;
        r14 = r14.add(r10, "AudiencePortToolbarMoreDialog");
    L39:
        if (r14 == null) goto L41;
        r14.commitNowAllowingStateLoss();
    L41:
        Unit r15 = Unit.INSTANCE;
        this.T = r10;
        return;
    L31:
        r13 = null;
        goto L32
    L43:
        return;
    L8:
        r2 = true;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.AbsAudienceToolbarButtonMoreDialog
    public final void X0(ExtendedToolbarButton r7, c0.b r8) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "behavior");
        Intrinsics.checkNotNullParameter(r7, "localIcon");
        Iterator<com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e> r0 = this.C.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r1 = r0.next();
        if (Intrinsics.areEqual(r1.m, r7) == false) goto L4;
    L9:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e r2 = r1;
        if (r2 == null) goto L21;
        if (r2.l.length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        String r4 = r2.l;
    L19:
        HashMap r5 = new HashMap();
        r5.put("icon_type", r4);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_more_function_panel_icon_click", r5, new Object[]{am2.x.class, Room.class});
        goto L21
    L18:
        r4 = r2.f;
        goto L19
    L15:
        r3 = false;
    L21:
        if ((r7 instanceof ExtendedToolbarButton.d) == false) goto L24;
        j1(this);
        return;
    L24:
        if ((r8 instanceof ToolbarAnchorBacktrackBehavior) == false) goto L29;
        if (((ToolbarAnchorBacktrackBehavior) r8).d == false) goto L61;
        j1(this);
        return;
    L61:
        return;
    L29:
        if ((r8 instanceof ToolbarAnchorRecordBehavior) == false) goto L34;
        if (((ToolbarAnchorRecordBehavior) r8).e == false) goto L63;
        j1(this);
        return;
    L63:
        return;
    L34:
        if ((r8 instanceof ToolbarShakeMatchBehavior) == false) goto L37;
        ToolbarShakeMatchBehavior r9 = (ToolbarShakeMatchBehavior) r8;
        return;
    L37:
        if ((r8 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n2) == false) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n2 r10 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.n2) r8;
        return;
    L40:
        if ((r8 instanceof com.bytedance.android.livesdk.room.placeholder.behavior.p) == false) goto L42;
        return;
    L42:
        if ((r7 instanceof ExtendedToolbarButton.b) == false) goto L54;
        ToolbarButton r6 = ((ExtendedToolbarButton.b) r7).i;
        if (r6 == ToolbarButton.REVERSE_CAMERA) goto L54;
        if (r6 == ToolbarButton.REVERSE_MIRROR) goto L54;
        if (r6 == ToolbarButton.AUDIO_TOGGLE) goto L54;
        if ((r8 instanceof ToolbarAudioCommentBehavior) == true) goto L52;
    L55:
        j1(this);
        return;
    L52:
        if (((ToolbarAudioCommentBehavior) r8).d == true) goto L55;
    L54:
        if ((r7 instanceof ExtendedToolbarButton.c) == true) goto L55;
        return;
    L8:
        r1 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r3, float r4, com.bytedance.android.livesdk.chatroom.e r5) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        if (r5 == null) goto L9;
        s r6 = r5.getCustomView();
        if (r6 == null) goto L9;
        return r6.x(r3, r4, null);
    L9:
        if (PadConfigUtils.c() == false) goto L11;
        float r7 = UIUtils.dip2Px(getContext(), 375.0f);
    L12:
        int r8 = (int) (r7 / r4);
        View r9 = LayoutInflater.from(getContext()).inflate(2131567633, r3, false);
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        r10.width = r8;
        r9.setLayoutParams(r10);
        return r9;
    L11:
        r7 = com.bytedance.android.live.core.utils.s1.y() - UtilityKotlinExtentionsKt.i(10);
        goto L12
    }
}
