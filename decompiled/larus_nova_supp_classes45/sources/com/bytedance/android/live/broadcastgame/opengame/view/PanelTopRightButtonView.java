package com.bytedance.android.live.broadcastgame.opengame.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.ReportService;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PanelTopRightButtonView extends FrameLayout {
    public final ImageView a;
    public final ImageView b;
    public final View c;
    public boolean d;
    public final boolean e;
    public final OPPluginMoreDialog f;
    public final LandscapeOpPluginMoreDialog g;
    public final Lazy h;
    public final PluginContext i;
    public final Context j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PanelTopRightButtonView a;

        public a(PanelTopRightButtonView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ PanelTopRightButtonView a;

        public b(PanelTopRightButtonView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.b();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PanelTopRightButtonView a;

        public c(PanelTopRightButtonView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.i.m.getClass();
            int r5 = v5.b().getInt("live.key.KEY_GAME_DIALOG_CLiCK_X_TOAST_START", 0);
            if (r5 >= 3) goto L5;
            v5.b().edit().putInt("live.key.KEY_GAME_DIALOG_CLiCK_X_TOAST_START", r5 + 1).apply();
            f2.c("玩法最小化", 0);
        L5:
            this.a.i.k.a();
        }
    }

    public static final class d {
    }

    static {
    }

    private final CommercialService getCommercialService() {
        return (CommercialService) this.h.getValue();
    }

    private final Dialog getPluginMoreDialog() {
        if (this.i.j() == PanelType.PANEL_TYPE_LANDSCAPE) goto L6;
        return this.f;
    L6:
        return this.g;
    }

    public final void b() {
        if (getPluginMoreDialog().isShowing() == true) goto L9;
        Dialog r0 = getPluginMoreDialog();
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L31;
        DialogLancet.handleBlockedDialogShow(r0);
        goto L9
    L31:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L8:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    L9:
        String r1 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
        Long r2 = Long.valueOf(this.i.m.h);
        PluginContext r3 = this.i;
        String r4 = r3.m.b(r3.o);
        String r5 = ((BootInfoService) this.i.o(BootInfoService.class)).e();
        Boolean r6 = Boolean.valueOf(this.e);
        String r7 = this.i.m.i;
        LinkedHashMap r8 = new LinkedHashMap();
        if (r6 == null) goto L17;
        r6.booleanValue();
        if (r6.booleanValue() == false) goto L14;
        String r9 = "anchor";
    L15:
        r8.put("user_type", r9);
        goto L17
    L14:
        r9 = "user";
    L17:
        if (Intrinsics.areEqual(jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource(), "accepted_tool_invited") == false) goto L19;
        String r11 = "invited";
    L20:
        r8.put("game_anchor_type", r11);
        if (r7 == null) goto L23;
        r8.put("game_app_id", r7);
    L23:
        boolean r12 = com.bytedance.android.live.revenue.core.util.h.a;
        kc0.e r13 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
        if (r13 == null) goto L28;
        Map<String, String> r14 = r13.h();
        if (r14 == null) goto L28;
        r8.putAll(r14);
    L28:
        com.bytedance.android.live.broadcastgame.opengame.service.e.a(r8, r2, r4, r5);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_open_page_more_click", r8, new Object[]{am2.x.class, Room.class});
        return;
    L19:
        r11 = "self_start";
        goto L20
    }

    public final Context getCtx() {
        return this.j;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [android.view.ViewGroup, com.bytedance.android.live.broadcastgame.opengame.view.PayFlowView] */
    public static final void a(final PanelTopRightButtonView r5) {
        ViewGroup r0 = (ViewGroup) r5.findViewById(2131381994);
        CommercialService r1 = r5.getCommercialService();
        Function0<Unit> r2 = new PanelTopRightButtonView$setupAnchorPayFlowMsg$1(r5);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "block");
        r1.b = new u();
        ?? r6 = new PayFlowView(r1.j.getContext());
        r1.c = r6;
        r6.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        u r7 = r1.b;
        if (r7 == null) goto L7;
        PayFlowView r3 = r1.c;
        if (r3 == null) goto L7;
        Intrinsics.checkNotNullParameter(r7, "queue");
        r3.b = r7;
    L7:
        ConstraintLayout r8 = r1.c;
        if (r8 == null) goto L10;
        r8.setOnClickListener(new com.bytedance.android.live.broadcastgame.opengame.service.d(r1));
    L10:
        r1.d = r2;
        r0.addView(r1.c);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r4) {
        super.onViewRemoved(r4);
        Dialog r5 = getPluginMoreDialog();
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(r5));
    }

    public final void setTopRightTheme(boolean r4) {
        this.d = r4;
        Object r0 = null;
        if (r4 == false) goto L17;
        ImageView r5 = this.a;
        if (r5 == null) goto L7;
        r5.setImageResource(2131252540);
    L7:
        ImageView r6 = this.b;
        if (r6 == null) goto L10;
        r6.setImageResource(2131250671);
    L10:
        findViewById(2131369232).setBackgroundColor(335544320);
        ViewParent r7 = getParent();
        if ((r7 instanceof View) == false) goto L14;
        r0 = r7;
    L14:
        View r1 = (View) r0;
        if (r1 == null) goto L31;
        r1.setBackgroundResource(2131250673);
        return;
    L31:
        return;
    L17:
        ImageView r8 = this.a;
        if (r8 == null) goto L20;
        r8.setImageResource(2131252539);
    L20:
        ImageView r9 = this.b;
        if (r9 == null) goto L23;
        r9.setImageResource(2131250670);
    L23:
        findViewById(2131369232).setBackgroundColor(654311423);
        ViewParent r11 = getParent();
        if ((r11 instanceof View) == false) goto L27;
        r0 = r11;
    L27:
        View r2 = (View) r0;
        if (r2 == null) goto L33;
        r2.setBackgroundResource(2131250672);
        return;
    }

    public PanelTopRightButtonView(PluginContext r4, Context r5) {
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        Intrinsics.checkNotNullParameter(r5, "ctx");
        super(r5);
        this.i = r4;
        this.j = r5;
        boolean r0 = r4.o;
        this.e = r0;
        this.f = new OPPluginMoreDialog(r5, r4, r0, false);
        this.g = new LandscapeOpPluginMoreDialog(r5, r4, r0);
        this.h = LazyKt.lazy(new PanelTopRightButtonView$commercialService$2(this));
        if (r4.m.o != PluginType.SONIC_GAME) goto L7;
        View.inflate(getContext(), 2131567110, this);
        ImageView r6 = (ImageView) findViewById(2131380299);
        this.a = r6;
        if (r6 == null) goto L23;
        r6.setOnClickListener(new a(this));
    L23:
        this.c = findViewById(2131369232);
        ImageView r7 = (ImageView) findViewById(2131371856);
        this.b = r7;
        if (r7 == null) goto L26;
        r7.setOnClickListener(new c(this));
    L26:
        r4.o(ReportService.class);
        CommercialService r8 = getCommercialService();
        Function0<Unit> r1 = new AnonymousClass5(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r1, "initFun");
        r8.e = r1;
        CommercialService r9 = getCommercialService();
        Function1<Boolean, Unit> r2 = new AnonymousClass6(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r2, "onPayMessageChange");
        r9.f = r2;
        r3.c(this.a, s1.B(2131923541), true);
        r3.c(r7, s1.B(2131923509), true);
        return;
    L7:
        View.inflate(getContext(), 2131567111, this);
        ImageView r11 = (ImageView) findViewById(2131380299);
        this.a = r11;
        if (r11 == null) goto L10;
        r11.setOnClickListener(new b(this));
    L10:
        ViewGroup.LayoutParams r3 = null;
        if (r11 == null) goto L13;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L15:
        if ((r12 instanceof ConstraintLayout.LayoutParams) == false) goto L18;
        r3 = r12;
    L18:
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r3;
        if (r13 == null) goto L23;
        ((ViewGroup.MarginLayoutParams) r13).rightMargin = s1.f(12.0f);
        if (r11 == null) goto L23;
        r11.setLayoutParams(r13);
        goto L23
    L13:
        r12 = null;
        goto L15
    }

    public static void c(PanelTopRightButtonView r2, Function0 r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r3, "isShowBubble");
        Intrinsics.checkNotNullParameter(r4, "isFullPanel");
        r2.postDelayed(new s(r2, r3, r4, 48.0f), 1000);
    }
}
