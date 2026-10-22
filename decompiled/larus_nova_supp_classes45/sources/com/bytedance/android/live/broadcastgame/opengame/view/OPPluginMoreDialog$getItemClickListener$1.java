package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.network.MiniGameIntroCardApi;
import com.bytedance.android.live.broadcastgame.opengame.network.outer.GamePlayApi;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.service.ReportService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameCardService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.GameCastStrategy;
import com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.re0;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class OPPluginMoreDialog$getItemClickListener$1 implements n.b {
    public final /* synthetic */ OPPluginMoreDialog a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public a(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            OPPluginMoreDialog r5 = this.a.a;
            int r0 = OPPluginMoreDialog.I;
            r5.getClass();
            f2.c("已取消常用玩法", 0);
            r5.b1(false);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.broadcastgame.opengame.q.j((Throwable) r3, "op moreDialog cancel collect error", 4);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;
        public final /* synthetic */ OPPluginMoreDialog b;
        public final /* synthetic */ boolean c;

        public c(OPPluginMoreDialog$getItemClickListener$1 r1, OPPluginMoreDialog r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog, java.lang.Object] */
        public final void accept(Object r12) {
            com.bytedance.android.live.network.response.e r13 = (com.bytedance.android.live.network.response.e) r12;
            OPPluginMoreDialog r14 = this.a.a;
            ?? r0 = this.b;
            boolean r1 = this.c;
            int r2 = OPPluginMoreDialog.I;
            r14.getClass();
            int r3 = com.bytedance.android.live.broadcastgame.opengame.utils.m.a;
            boolean r4 = false;
            if (((Boolean) re0.a.getValue()).booleanValue() == true) goto L5;
        L9:
            f2.c("设置成功，可在直播间底部\"…\"看到", 0);
        L10:
            r14.b1(true);
            if (r4 == false) goto L37;
            Context r5 = r14.F.i();
            PanelType.a r6 = PanelType.Companion;
            PanelType r7 = r14.F.j();
            r6.getClass();
            if (PanelType.a.a(r7) == true) goto L15;
            r14.F.m.getClass();
            r14.F.k.a();
            r5 = r14.F.getContext();
        L15:
            CommonBottomDialog r8 = new CollectSuccessDialog(r5, r1);
            r8.setOnDismissListener(new q(r14));
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L42;
            DialogLancet.handleBlockedDialogShow(r8);
        L20:
            Handler r9 = DialogLancet.resolveDialogHandler(r0);
            if (r9 != null) goto L23;
        L25:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L28 Exception -> L30
        L34:
            DialogLancet.afterDialogDismiss(r0);
            goto L37
        L30:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L28
            Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L28
            if (r11 == null) goto L34;
            com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L23:
            if (Looper.myLooper() == r9.getLooper()) goto L25;
            r9.post(DialogLancet.createDismissRunnable(r0));
            goto L37
        L42:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L39
        L19:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
        L37:
            ((OpenPlatformMonitorService) r14.F.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_collect_game", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
            v5.b().edit().putBoolean("live.key.AUDIENCE_HAS_COLLECTED_V2", true).apply();
            return;
        L5:
            if (r14.F.m.e == false) goto L9;
            if (v5.b().getBoolean("live.key.AUDIENCE_COLLECT_SELF_START_GAME", false) == true) goto L9;
            v5.b().edit().putBoolean("live.key.AUDIENCE_COLLECT_SELF_START_GAME", true).apply();
            MainThreadPostUtils.c(new r(r14), 2000);
            r4 = true;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public d(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Throwable r9 = (Throwable) r8;
            OpenPlatformMonitorService r1 = (OpenPlatformMonitorService) this.a.a.F.o(OpenPlatformMonitorService.class);
            Integer r5 = Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r9));
            String r6 = o1.a(r9);
            r1.a("ttlive_open_platform_collect_game", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, r5, r6).c();
            f2.c("设置失败，请稍后重试", 0);
            com.bytedance.android.live.broadcastgame.opengame.q.j(r9, "op moreDialog collect error", 4);
        }
    }

    public static final class e implements DialogInterface.OnDismissListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public e(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.a.F.k.g(null);
        }
    }

    public static final class f implements DialogInterface.OnDismissListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public f(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            this.a.a.F.k.g(null);
        }
    }

    public static final class g implements com.bytedance.bdp.live.livecontainer.sonicgame.c {
        public g() {
        }

        public final void a(JSONObject r3) {
            Intrinsics.checkNotNullParameter("onSettingClick", "status");
            Intrinsics.checkNotNullParameter(r3, "data");
        }

        public final void onSuccess(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "result");
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errMsg");
            f2.c("打开失败", 0);
        }
    }

    public static final class h implements DialogInterface.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public h(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            ((TrackMiniGameCardService) this.a.a.F.o(TrackMiniGameCardService.class)).d(true);
            r2.dismiss();
        }
    }

    public static final class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ i a;

            public a(i r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
                OPPluginMoreDialog r6 = this.a.a.a;
                OPMoreDialogAdapter r0 = r6.C;
                if (r0 == null) goto L5;
                r0.z2(OPPluginMoreDialog.Y0(r6, true, 2));
            L5:
                this.a.a.a.D = true;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public i(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            ((TrackMiniGameCardService) this.a.a.F.o(TrackMiniGameCardService.class)).d(false);
            OPPluginMoreDialog r8 = this.a.a;
            MiniGameIntroCardApi r0 = (MiniGameIntroCardApi) com.bytedance.android.live.network.c.b().e(MiniGameIntroCardApi.class);
            com.bytedance.android.live.broadcastgame.opengame.t r1 = this.a.a.F.m;
            Disposable r2 = r0.updateGameCardStatus(r1.i, r1.a, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
            r8.H.a(r2);
            r6.dismiss();
        }
    }

    public static final class j implements DialogInterface.OnDismissListener {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            com.bytedance.android.livesdk.e.b().d();
        }
    }

    public static final class k implements DialogInterface.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public k(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
            ((TrackMiniGameCardService) this.a.a.F.o(TrackMiniGameCardService.class)).c(true);
        }
    }

    public static final class l implements DialogInterface.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog$getItemClickListener$1 a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ l a;

            public a(l r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
                OPPluginMoreDialog r6 = this.a.a.a;
                OPMoreDialogAdapter r0 = r6.C;
                if (r0 == null) goto L5;
                r0.z2(OPPluginMoreDialog.Y0(r6, false, 2));
            L5:
                this.a.a.a.D = false;
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final /* bridge */ /* synthetic */ void accept(Object r1) {
                Throwable r2 = (Throwable) r1;
            }
        }

        public l(OPPluginMoreDialog$getItemClickListener$1 r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r6, int r7) {
            OPPluginMoreDialog r8 = this.a.a;
            MiniGameIntroCardApi r0 = (MiniGameIntroCardApi) com.bytedance.android.live.network.c.b().e(MiniGameIntroCardApi.class);
            com.bytedance.android.live.broadcastgame.opengame.t r1 = this.a.a.F.m;
            Disposable r2 = r0.updateGameCardStatus(r1.i, r1.a, 2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
            r8.H.a(r2);
            ((TrackMiniGameCardService) this.a.a.F.o(TrackMiniGameCardService.class)).c(false);
            r6.dismiss();
        }
    }

    public static final class m implements DialogInterface.OnDismissListener {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            com.bytedance.android.livesdk.e.b().d();
        }
    }

    public OPPluginMoreDialog$getItemClickListener$1(OPPluginMoreDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(OPPluginMoreDialog r3) {
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

    /* JADX WARN: Type inference failed for: r1v47, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.view.InteractGameFeedbackDialog, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v19, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.view.RewardMsgCenterDialog, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.view.n.b
    public final void a(OPPluginMoreDialog r22, View r23, n r24) {
        Intrinsics.checkNotNullParameter(r22, "pluginMoreDialog");
        Intrinsics.checkNotNullParameter(r23, "view");
        Intrinsics.checkNotNullParameter(r24, "item");
        if (this.a.F.j() != PanelType.PANEL_TYPE_LANDSCAPE) goto L5;
        boolean r14 = true;
    L6:
        PanelType.a r3 = PanelType.Companion;
        PanelType r4 = this.a.F.j();
        r3.getClass();
        boolean r5 = !PanelType.a.a(r4);
        com.bytedance.android.live.broadcastgame.opengame.service.e r6 = com.bytedance.android.live.broadcastgame.opengame.service.e.b;
        Long r15 = Long.valueOf(this.a.F.m.h);
        PluginContext r7 = this.a.F;
        com.bytedance.android.live.broadcastgame.opengame.service.e.f(r15, r7.m.b(r7.o), r24.b, ((BootInfoService) this.a.F.o(BootInfoService.class)).e(), Boolean.valueOf(this.a.G), this.a.F.m.i);
        boolean r21 = r14;
        switch(r24.a) {
            case 1: goto L164;
            case 2: goto L154;
            case 3: goto L149;
            case 4: goto L140;
            case 5: goto L125;
            case 6: goto L124;
            case 7: goto L117;
            case 8: goto L110;
            case 9: goto L200;
            case 10: goto L109;
            case 11: goto L65;
            case 12: goto L39;
            case 13: goto L15;
            case 14: goto L15;
            case 15: goto L9;
            default: goto L200;
        };
    L9:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r1 = AnchorGameContext.a.a();
        if (r1 == null) goto L14;
        com.bytedance.live.datacontext.k<Unit> r2 = r1.getShowKeyBoard();
        if (r2 == null) goto L14;
        r2.post(Unit.INSTANCE);
    L14:
        int r8 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r9 = this.a.F.m;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r9.i, r9.b(true), "玩法键盘");
        b(r22);
        return;
    L15:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r11 = AnchorGameContext.a.a();
        if (r11 == null) goto L29;
        com.bytedance.live.datacontext.m<Boolean> r12 = r11.getOpenCapture();
        if (r12 == null) goto L29;
        AnchorGameContext r13 = AnchorGameContext.a.a();
        if (r13 == null) goto L27;
        com.bytedance.live.datacontext.m<Boolean> r16 = r13.getOpenCapture();
        if (r16 == null) goto L27;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L27;
        boolean r17 = false;
    L28:
        r12.setValue(Boolean.valueOf(r17));
    L27:
        r17 = true;
    L29:
        AnchorGameContext r18 = AnchorGameContext.a.a();
        if (r18 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r19 = r18.getOpenCapture();
        if (r19 == null) goto L37;
        if (((Boolean) r19.getValue()).booleanValue() != true) goto L37;
        String r25 = "打开摄像头";
    L38:
        int r26 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r27 = this.a.F.m;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r27.i, r27.b(true), r25);
        b(r22);
        return;
    L37:
        r25 = "关闭摄像头";
        goto L38
    L39:
        b(r22);
        GameCastStrategy r28 = this.a.F.h(true);
        if (r28 != GameCastStrategy.VIDEO_CHATROOM) goto L51;
        PluginContext r29 = this.a.F;
        if (r29.o == false) goto L45;
        jc1.k.n(IInteractService.class).stopLinkCast(LinkScreenCastType.CAST_TYPE_GAME, r29.m.i, false);
    L45:
        int r31 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r32 = this.a.F.m;
        long r33 = r32.h;
        String r34 = r32.a();
        if (r34 != null) goto L48;
        String r35 = "";
    L49:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.e(r33, r35, true);
        return;
    L48:
        r35 = r34;
        goto L49
    L51:
        if (r28 != GameCastStrategy.VIDEO_SINGLE) goto L186;
        PluginContext r36 = this.a.F;
        if (r36.o == false) goto L64;
        com.bytedance.android.live.broadcastgame.opengame.runtime.k r37 = r36.a;
        if (r37 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L59:
        if ((r37 instanceof com.bytedance.android.live.broadcastgame.opengame.sonicgame.f) == true) goto L61;
        r37 = null;
    L61:
        com.bytedance.android.live.broadcastgame.opengame.sonicgame.f r38 = (com.bytedance.android.live.broadcastgame.opengame.sonicgame.f) r37;
        if (r38 == null) goto L64;
        r38.b(true);
    L64:
        int r39 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.d.a;
        Intrinsics.checkNotNullParameter("more_panel", "from");
        LinkedHashMap r41 = new LinkedHashMap();
        r41.put("cast_scene", "single");
        r41.put("cast_biz_value", "mini_game");
        r41.put("close_from", "more_panel");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_screenprojection_screenpack_end_button_click", r41, new Object[]{Room.class});
        return;
    L186:
        return;
    L65:
        b(r22);
        GameCastStrategy r42 = this.a.F.h(true);
        if (r42 != GameCastStrategy.VIDEO_CHATROOM) goto L80;
        this.a.F.v();
        if (v5.b().getBoolean("ttlive_chatroom_game_cast_intro_has_show", false) == true) goto L74;
        v5.b().edit().putBoolean("ttlive_chatroom_game_cast_intro_has_show", true).apply();
        VideoChatroomCastIntroDialog r43 = new VideoChatroomCastIntroDialog(this.a.F.i());
        if (DialogLancet.shouldBlockDialogShow(r43) == false) goto L173;
        DialogLancet.handleBlockedDialogShow(r43);
        goto L74
    L173:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L168
    L73:
        DialogLancet.beforeDialogShow(r43);
        r43.show();
        DialogLancet.afterDialogShow(r43);
    L74:
        int r44 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r45 = this.a.F.m;
        long r46 = r45.h;
        String r47 = r45.a();
        if (r47 != null) goto L77;
        String r48 = "";
    L78:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.e(r46, r48, false);
        return;
    L77:
        r48 = r47;
        goto L78
    L80:
        if (r42 == GameCastStrategy.VIDEO_SINGLE) goto L82;
        return;
    L82:
        if (v5.b().getBoolean("ttlive_open_game_single_cast_intro_has_shown", false) == true) goto L88;
        v5.b().edit().putBoolean("ttlive_open_game_single_cast_intro_has_shown", true).apply();
        SingleCastIntroDialog r49 = new SingleCastIntroDialog(this.a.getContext(), this.a.getContext().getString(2131921092), new OPPluginMoreDialog$getItemClickListener$1$onItemClick$14(this));
        if (DialogLancet.shouldBlockDialogShow(r49) == false) goto L181;
        DialogLancet.handleBlockedDialogShow(r49);
    L100:
        int r51 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.d.a;
        com.bytedance.android.live.broadcastgame.opengame.t r52 = this.a.F.m;
        String r53 = r52.i;
        String r54 = r52.b(true);
        Intrinsics.checkNotNullParameter(r53, "appId");
        Intrinsics.checkNotNullParameter(r54, "appName");
        Intrinsics.checkNotNullParameter("more_panel", "from");
        com.bytedance.android.livesdk.sharedpref.e r55 = com.bytedance.android.livesdk.sharedpref.b.z3;
        Map r56 = (Map) r55.getValue();
        if (r56.get(r53) != null) goto L103;
        r56.put(r53, Boolean.TRUE);
        Unit r57 = Unit.INSTANCE;
        com.bytedance.android.livesdk.sharedpref.f.d(r55, r56);
        boolean r58 = true;
    L104:
        LinkedHashMap r59 = new LinkedHashMap();
        r59.put("open_from", "more_panel");
        r59.put("game_name", r54);
        if (r58 == false) goto L107;
        String r61 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L108:
        r59.put("is_first_open", r61);
        r59.put("cast_scene", "single");
        r59.put("cast_biz_value", "mini_game");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_screenprojection_game_click", r59, new Object[]{Room.class});
        return;
    L107:
        r61 = "0";
        goto L108
    L103:
        r58 = false;
        goto L104
    L181:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L169
    L87:
        DialogLancet.beforeDialogShow(r49);
        r49.show();
        DialogLancet.afterDialogShow(r49);
        goto L100
    L88:
        PluginContext r62 = this.a.F;
        if (r62.o == false) goto L100;
        com.bytedance.android.live.broadcastgame.opengame.runtime.k r63 = r62.a;
        if (r63 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
    L95:
        if ((r63 instanceof com.bytedance.android.live.broadcastgame.opengame.sonicgame.f) == true) goto L97;
        r63 = null;
    L97:
        com.bytedance.android.live.broadcastgame.opengame.sonicgame.f r64 = (com.bytedance.android.live.broadcastgame.opengame.sonicgame.f) r63;
        if (r64 == null) goto L100;
        r64.g(false);
        goto L100
    L109:
        Long r65 = Long.valueOf(this.a.F.m.h);
        PluginContext r66 = this.a.F;
        String r67 = r66.m.b(r66.o);
        LinkedHashMap r68 = new LinkedHashMap();
        r68.put("botton_click", "authorization");
        com.bytedance.android.live.broadcastgame.opengame.service.e.b(r6, r68, r65, r67, 8);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_more_panel_item_click", r68, new Object[]{Room.class});
        ((OpenBaseAuthService) this.a.F.o(OpenBaseAuthService.class)).b(this.a.F.m.i, new g());
        return;
    L110:
        Context r69 = this.a.F.i();
        x0.d r71 = new x0.d();
        r71.b = r69;
        r71.a = 4;
        r71.c = "关闭讲解";
        r71.d = "是否结束向用户推送讲解卡";
        k r72 = new k(this);
        x0.c[] r73 = r71.g;
        x0.c r74 = r73[1];
        if (r74 != null) goto L113;
        r74 = new x0.c();
        r73[1] = r74;
    L113:
        r74.a = "取消";
        r74.b = r72;
        l r75 = new l(this);
        x0.c[] r76 = r71.g;
        x0.c r77 = r76[0];
        if (r77 != null) goto L116;
        r77 = new x0.c();
        r76[0] = r77;
    L116:
        r77.a = "确认";
        r77.b = r75;
        r71.i = m.a;
        x0.b.g(new x0(r71.b, r71));
        return;
    L117:
        Context r78 = this.a.F.i();
        x0.d r79 = new x0.d();
        r79.b = r78;
        r79.a = 4;
        r79.c = "推送讲解";
        r79.d = "是否向用户推送讲解卡";
        h r81 = new h(this);
        x0.c[] r82 = r79.g;
        x0.c r83 = r82[1];
        if (r83 != null) goto L120;
        r83 = new x0.c();
        r82[1] = r83;
    L120:
        r83.a = "取消";
        r83.b = r81;
        i r84 = new i(this);
        x0.c[] r85 = r79.g;
        x0.c r86 = r85[0];
        if (r86 != null) goto L123;
        r86 = new x0.c();
        r85[0] = r86;
    L123:
        r86.a = "确认";
        r86.b = r84;
        r79.i = j.a;
        x0.b.g(new x0(r79.b, r79));
        return;
    L124:
        x7a.g.d.c("introduce", MapsKt.emptyMap());
        b(r22);
        return;
    L125:
        Context r87 = this.a.F.i();
        if (r5 == false) goto L128;
        this.a.F.m.getClass();
        this.a.F.k.a();
        r87 = this.a.F.getContext();
    L128:
        com.bytedance.android.live.broadcastgame.opengame.t r88 = this.a.F.m;
        ?? r89 = new InteractGameFeedbackDialog(r87, r88.a, r88.h, 3, r21);
        r89.setOnDismissListener(new e(this));
        if (DialogLancet.shouldBlockDialogShow(r89) == false) goto L177;
        DialogLancet.handleBlockedDialogShow(r89);
    L133:
        b(r22);
        int r91 = GameDataReportHelper.a;
        PluginContext r92 = this.a.F;
        String r93 = r92.m.b(r92.o);
        com.bytedance.android.live.broadcastgame.opengame.t r94 = this.a.F.m;
        Map r95 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_name", r93), TuplesKt.to("game_id", r94.i), TuplesKt.to("game_type", r94.o.name())});
        IUserService r96 = jc1.k.f(IUserService.class);
        if (r96 == null) goto L138;
        com.bytedance.android.livesdk.user.f r97 = r96.user();
        if (r97 == null) goto L138;
        String r110 = r97.n();
    L139:
        r95.put("user_id", r110);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_feedback", r95, new Object[]{Room.class, am2.x.class});
        int r98 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        PluginContext r99 = this.a.F;
        com.bytedance.android.live.broadcastgame.opengame.t r100 = r99.m;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r100.i, r100.b(r99.o), "意见反馈");
        return;
    L138:
        r110 = null;
        goto L139
    L177:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L170
    L132:
        DialogLancet.beforeDialogShow(r89);
        r89.show();
        DialogLancet.afterDialogShow(r89);
        goto L133
    L140:
        Context r101 = this.a.F.i();
        if (r5 == false) goto L143;
        this.a.F.k.a();
        r101 = this.a.F.getContext();
    L143:
        ?? r102 = new RewardMsgCenterDialog(r101, ((CommercialService) this.a.F.o(CommercialService.class)).g, ((CommercialService) this.a.F.o(CommercialService.class)).a, r21);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L175;
        DialogLancet.handleBlockedDialogShow(r102);
    L148:
        r102.setOnDismissListener(new f(this));
        b(r22);
        return;
    L175:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L171
    L147:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L148
    L149:
        b(r22);
        Context r103 = this.a.F.i();
        com.bytedance.android.live.broadcastgame.opengame.t r104 = this.a.F.m;
        DiamondRankDialog r105 = new DiamondRankDialog(r103, r104.i, r104.a, r104.e(), ((CommercialService) this.a.F.o(CommercialService.class)).a, r21);
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L179;
        DialogLancet.handleBlockedDialogShow(r105);
        return;
    L179:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L172
    L153:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        return;
    L154:
        com.bytedance.android.live.broadcastgame.opengame.t r106 = this.a.F.m;
        boolean r107 = r106.c;
        long r108 = r106.h;
        String r109 = r106.i;
        if (r107 == false) goto L157;
        RxUtilKt.h(((GamePlayApi) com.bytedance.android.live.network.c.b().e(GamePlayApi.class)).cancelCollectGame(r109, Long.valueOf(r108))).subscribe(new a(this), b.a);
    L158:
        boolean r111 = !r107;
        Intrinsics.checkNotNullParameter("default", "popupReason");
        LinkedHashMap r112 = new LinkedHashMap();
        r112.put("botton_click", "收藏");
        if (r111 == false) goto L161;
        String r113 = "click";
    L162:
        r112.put("add_favourite_click_type", r113);
        r112.put("popup_reason", "default");
        com.bytedance.android.live.broadcastgame.opengame.service.e.b(r6, r112, null, null, 14);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_more_panel_item_click", r112, new Object[]{Room.class, com.bytedance.android.live.broadcastgame.api.c.class});
        return;
    L161:
        r113 = "unclick";
        goto L162
    L157:
        RxUtilKt.h(((GamePlayApi) com.bytedance.android.live.network.c.b().e(GamePlayApi.class)).collectGame(r109, Long.valueOf(r108))).subscribe(new c(this, r22, r21), new d(this));
        goto L158
    L200:
        return;
    L164:
        if (r5 == false) goto L166;
        this.a.F.m.getClass();
        this.a.F.k.a();
    L166:
        ((ReportService) this.a.F.o(ReportService.class)).d(r21);
        int r114 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        PluginContext r115 = this.a.F;
        com.bytedance.android.live.broadcastgame.opengame.t r116 = r115.m;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r116.i, r116.b(r115.o), "举报投诉");
        b(r22);
        return;
    L5:
        r14 = false;
        goto L6
    }
}
