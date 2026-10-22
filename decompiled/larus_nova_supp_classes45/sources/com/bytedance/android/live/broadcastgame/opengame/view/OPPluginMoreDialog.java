package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.network.MiniGameIntroCardApi;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.GameCastStrategy;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.config.aa0;
import com.bytedance.android.livesdk.config.je0;
import com.bytedance.android.livesdk.config.m61;
import com.bytedance.android.livesdk.config.ph1;
import com.bytedance.android.livesdk.config.te0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/OPPluginMoreDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class OPPluginMoreDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int I = 0;
    public final OPPluginMoreDialog$getItemClickListener$1 B;
    public OPMoreDialogAdapter C;
    public boolean D;
    public boolean E;
    public final PluginContext F;
    public final boolean G;
    public final /* synthetic */ i20.a H;

    public static final class a extends RecyclerView.ItemDecoration {
        public final int a;

        public a(int r1) {
            this.a = r1;
        }

        public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
            Intrinsics.checkNotNullParameter(r2, "outRect");
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "parent");
            Intrinsics.checkNotNullParameter(r5, "state");
            if (r4.getChildLayoutPosition(r3) == 0) goto L6;
            r2.left = this.a;
            return;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog a;

        public b(OPPluginMoreDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            OPPluginMoreDialog r0 = this.a;
            OPPluginMoreDialog$getItemClickListener$1 r1 = r0.B;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r0, "pluginMoreDialog");
            Intrinsics.checkNotNullParameter(r13, "view");
            x0.b r14 = new x0.b(r1.a.F.i(), 4);
            r14.l(2131920878);
            r14.i(1, 2131920876, o.a);
            r14.i(0, 2131920877, new p(r1, r0));
            r14.k(0, true);
            r14.n();
            String r15 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
            Long r6 = Long.valueOf(r1.a.F.m.h);
            PluginContext r16 = r1.a.F;
            com.bytedance.android.live.broadcastgame.opengame.service.e.f(r6, r16.m.b(r16.o), "退出功能", ((BootInfoService) r1.a.F.o(BootInfoService.class)).e(), Boolean.valueOf(r1.a.G), r1.a.F.m.i);
            int r17 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.opengame.t r18 = r1.a.F.m;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r18.i, r18.b(true), "退出功能");
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OPPluginMoreDialog a;

        public c(OPPluginMoreDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.opengame.view.OPPluginMoreDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            InteractGameContext.Companion r6 = InteractGameContext.Companion;
            InteractGameContext r0 = r6.getContext();
            boolean r1 = true;
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r2 = r0.getClearScreen();
            if (r2 == null) goto L9;
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L9;
            String r3 = "退出清屏";
        L10:
            int r4 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.opengame.t r7 = this.a.F.m;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r7.i, r7.b(true), r3);
            InteractGameContext r8 = r6.getContext();
            if (r8 == null) goto L23;
            com.bytedance.live.datacontext.m<Boolean> r9 = r8.getClearScreen();
            if (r9 == null) goto L23;
            InteractGameContext r11 = r6.getContext();
            if (r11 == null) goto L22;
            com.bytedance.live.datacontext.m<Boolean> r12 = r11.getClearScreen();
            if (r12 == null) goto L22;
            if (((Boolean) r12.getValue()).booleanValue() != true) goto L22;
            r1 = false;
        L22:
            r9.setValue(Boolean.valueOf(r1));
        L23:
            ?? r13 = this.a;
            Handler r14 = DialogLancet.resolveDialogHandler(r13);
            if (r14 != null) goto L26;
        L28:
            DialogLancet.beforeDialogDismiss(r13);
            r13.dismiss();     // Catch: Throwable -> L31 Exception -> L33
        L37:
            DialogLancet.afterDialogDismiss(r13);
            return;
        L31:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r13);
            throw th;
        L33:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
            Throwable r15 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
            if (r15 == null) goto L37;
            com.bytedance.crash.d.d(r15, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
            goto L37
        L26:
            if (Looper.myLooper() == r14.getLooper()) goto L28;
            r14.post(DialogLancet.createDismissRunnable(r13));
            return;
        L9:
            r3 = "清屏";
            goto L10
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ OPPluginMoreDialog a;

        public d(OPPluginMoreDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = ((com.bytedance.android.live.broadcastgame.opengame.network.model.k) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r4)).data).a();
            if (r5 != null) goto L6;
        L10:
            if (r5 != null) goto L13;
            return;
        L13:
            if (r5.intValue() != 2) goto L20;
            OPPluginMoreDialog r6 = this.a;
            r6.D = false;
            OPMoreDialogAdapter r2 = r6.C;
            if (r2 == null) goto L21;
            r2.z2(OPPluginMoreDialog.Y0(r6, false, 2));
            return;
        L21:
            return;
        L20:
            return;
        L6:
            if (r5.intValue() != 1) goto L10;
            OPPluginMoreDialog r7 = this.a;
            r7.D = true;
            OPMoreDialogAdapter r1 = r7.C;
            if (r1 == null) goto L18;
            r1.z2(OPPluginMoreDialog.Y0(r7, true, 2));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public int getLayoutId() {
        return 2131567107;
    }

    public final boolean a1() {
        InteractGameContext r0 = InteractGameContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getXplayRunning();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        if (this.G == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final void show() {
        OPMoreDialogAdapter r0 = this.C;
        if (r0 == null) goto L5;
        r0.z2(X0(this.D, this.E));
    L5:
        Disposable r1 = com.bytedance.android.live.broadcastgame.opengame.utils.i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r1, "$this$autoDispose");
        this.H.a(r1);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        RecyclerView r2 = findViewById(2131364751);
        RecyclerView.Adapter r3 = null;
        if (r2 == null) goto L13;
        RecyclerView.Adapter r4 = r2.getAdapter();
    L15:
        if ((r4 instanceof OPMoreDialogAdapter) == false) goto L18;
        r3 = r4;
    L18:
        OPMoreDialogAdapter r5 = (OPMoreDialogAdapter) r3;
        if (r5 == null) goto L41;
        Iterator<T> r6 = r5.b.iterator();
        int r7 = 0;
    L22:
        if (r6.hasNext() == false) goto L49;
        Object r8 = r6.next();
        int r9 = r7 + 1;
        if (r7 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        int r11 = ((n) r8).a;
        String r12 = "";
        if (r11 != 11) goto L34;
        int r13 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r14 = this.F.m;
        long r15 = r14.h;
        String r16 = r14.a();
        if (r16 == null) goto L32;
        r12 = r16;
    L32:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.f(r15, r12, false);
    L40:
        r7 = r9;
        goto L22
    L34:
        if (r11 != 12) goto L40;
        int r17 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        com.bytedance.android.live.broadcastgame.opengame.t r18 = this.F.m;
        long r19 = r18.h;
        String r21 = r18.a();
        if (r21 == null) goto L39;
        r12 = r21;
    L39:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.f(r19, r12, true);
        goto L40
    L49:
        return;
    L41:
        return;
    L13:
        r4 = null;
        goto L15
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L9:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    }

    public void Z0() {
        RecyclerView r0 = findViewById(2131364751);
        if (r0 == null) goto L6;
        OPMoreDialogAdapter r2 = W0(this, Y0(this, false, 1));
        this.C = r2;
        r0.setAdapter(r2);
        r0.setLayoutManager(new LinearLayoutManager(r0.getContext(), 0, false));
        r0.addItemDecoration(new a((int) fm3.e.a(r0.getContext(), 26.0f)));
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
    L17:
        this.H.b();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public final void onStart() {
        super/*com.bytedance.android.livesdk.pannel.SheetBaseDialog*/.onStart();
        if (this.G == false) goto L22;
        com.bytedance.android.live.broadcastgame.api.model.u r0 = this.F.m.e();
        if (r0 == null) goto L22;
        Intrinsics.checkNotNullParameter(r0, "$this$supportGameCard");
        com.bytedance.android.live.broadcastgame.api.model.r r1 = r0.c();
        if (r1 == null) goto L18;
        String r2 = r1.m();
        if (r2 == null) goto L18;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L32
        int r3 = JSONObjectProtectorUtils.getInt(LiveSeiUtil.c(r2), "default_status");     // Catch: Exception -> L32
        if (r3 != 1) goto L13;
    L17:
        boolean r4 = true;
    L19:
        if (r4 != true) goto L22;
        MiniGameIntroCardApi r5 = (MiniGameIntroCardApi) com.bytedance.android.live.network.c.b().e(MiniGameIntroCardApi.class);
        com.bytedance.android.live.broadcastgame.opengame.t r6 = this.F.m;
        Disposable r7 = r5.getMiniGameIntroCardStatus(r6.i, r6.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullParameter(r7, "$this$autoDispose");
        this.H.a(r7);
        goto L22
    L13:
        if (r3 == 2) goto L17;
        Unit r8 = Unit.INSTANCE;     // Catch: Exception -> L32
    L18:
        r4 = false;
    L22:
        if (a1() == false) goto L35;
        InteractGameContext r9 = InteractGameContext.Companion.getContext();
        if (r9 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r11 = r9.getClearScreen();
        if (r11 == null) goto L30;
        if (((Boolean) r11.getValue()).booleanValue() != true) goto L30;
        a1.m((ImageView) findViewById(2131366946), 2131251096);
        ((TextView) findViewById(2131366948)).setText(s1.B(2131916504));
        ((TextView) findViewById(2131366947)).setText(s1.B(2131916506));
        return;
    L30:
        a1.m((ImageView) findViewById(2131366946), 2131251094);
        ((TextView) findViewById(2131366948)).setText(s1.B(2131915814));
        ((TextView) findViewById(2131366947)).setText(s1.B(2131915817));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b1(boolean r8) {
        this.F.m.c = r8;
        if (isShowing() == false) goto L31;
        RecyclerView r0 = findViewById(2131364751);
        RecyclerView.Adapter r1 = null;
        if (r0 == null) goto L7;
        RecyclerView.Adapter r2 = r0.getAdapter();
    L9:
        if ((r2 instanceof OPMoreDialogAdapter) == false) goto L12;
        r1 = r2;
    L12:
        OPMoreDialogAdapter r3 = (OPMoreDialogAdapter) r1;
        if (r3 == null) goto L34;
        Iterator<T> r4 = r3.b.iterator();
        int r5 = 0;
    L16:
        if (r4.hasNext() == false) goto L36;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        n r9 = (n) r6;
        if (r9.a == 2) goto L22;
        r5 = r7;
        goto L16
    L22:
        if (r8 == false) goto L24;
        String r11 = "取消常用";
    L25:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r9.b = r11;
        if (r8 == false) goto L28;
        int r12 = 2131251345;
    L29:
        r9.c = r12;
        r3.notifyItemChanged(r5);
        return;
    L28:
        r12 = 2131251344;
        goto L29
    L24:
        r11 = "设为常用";
        goto L25
    L36:
        return;
    L34:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        Z0();
        UtilityKotlinExtentionsKt.w(findViewById(2131371856));
        ((TextView) findViewById(2131371856)).setOnClickListener(new b(this));
        ((TextView) findViewById(2131380593)).setText(this.F.m.b(this.G));
        Object r6 = this.F.m.k.get("OPEN_APP_ICON_URL");
        if ((r6 instanceof String) == true) goto L5;
        r6 = null;
    L5:
        String r7 = (String) r6;
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        GenericDraweeHierarchy r1 = ((HSImageView) findViewById(2131374718)).getHierarchy();
        ((HSImageView) findViewById(2131374718)).setActualImageResource(2131107985);
        r1.setPlaceholderImage(2131107985);
        r1.setFailureImage(2131107985);
        ((HSImageView) findViewById(2131374718)).setHierarchy(r1);
        if (r7.length() <= 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        ((HSImageView) findViewById(2131374718)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r7)).build());
    L15:
        if (a1() == false) goto L17;
        UtilityKotlinExtentionsKt.w(findViewById(2131366945));
        ((LinearLayout) findViewById(2131366945)).setOnClickListener(new c(this));
        return;
    L17:
        UtilityKotlinExtentionsKt.t(findViewById(2131366945));
        return;
    L11:
        r2 = false;
        goto L12
    }

    public OPMoreDialogAdapter W0(OPPluginMoreDialog r2, List<n> r3) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        Intrinsics.checkNotNullParameter(r3, "items");
        return new OPMoreDialogAdapter(this, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<n> X0(boolean r11, boolean r12) {
        ArrayList r0 = new ArrayList();
        if (this.F.o == true) goto L13;
        boolean r2 = this.F.m.c;
        if (r2 == false) goto L7;
        String r3 = "取消常用";
    L8:
        if (r2 == false) goto L10;
        int r4 = 2131251345;
    L11:
        r0.add(new n(2, r3, r4, this.B));
        goto L13
    L10:
        r4 = 2131251344;
        goto L11
    L7:
        r3 = "设为常用";
    L13:
        if (this.F.m() != PluginType.LYNX) goto L15;
        r0.add(new n(6, getContext().getString(2131921008), 2131252537, this.B));
    L15:
        r0.add(new n(5, "意见反馈", 2131251283, this.B));
        boolean r6 = true;
        r0.add(new n(1, "举报投诉", 2131251284, this.B));
        CommercialService r1 = (CommercialService) this.F.o(CommercialService.class);
        if (r1.a() == false) goto L26;
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r5 = ((BootInfoService) this.F.o(BootInfoService.class)).c();
        if (r5 == null) goto L22;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r7 = r5.b;
        if (r7 == null) goto L22;
        boolean r8 = r7.d;
    L23:
        if (r8 == true) goto L26;
        r0.add(new n(3, "消费榜单", 2131251281, this.B));
    L22:
        r8 = false;
    L26:
        if (r1.b() == false) goto L29;
        r0.add(new n(4, "消息中心", 2131251282, this.B));
    L29:
        if (((m61) te0.a.getValue()).b() == false) goto L36;
        if (r12 == false) goto L36;
        if (this.F.o == false) goto L36;
        if (r11 == false) goto L35;
        r0.add(new n(8, "取消讲解", 2131251279, this.B));
        goto L36
    L35:
        r0.add(new n(7, "推送讲解", 2131251280, this.B));
    L36:
        this.E = r12;
        if ((this.F.k() instanceof SonicGamePlugin) == false) goto L39;
        r0.add(new n(10, "权限设置", 2131251311, this.B));
    L39:
        PluginContext r13 = this.F;
        if (r13.m.d(r13.o) != 5) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == true) goto L71;
        PluginContext r15 = this.F;
        if (r15.m.p == true) goto L71;
        GameCastStrategy r16 = r15.h(r15.r());
        int r17 = com.bytedance.android.live.broadcastgame.opengame.utils.m.a;
        if (tb1.c.a == true) goto L49;
    L52:
        boolean r18 = false;
    L53:
        if (r18 == true) goto L55;
    L63:
        boolean r19 = false;
    L64:
        if (r19 == false) goto L71;
        boolean r110 = jc1.k.n(IInteractService.class).isLinkCasting();
        this.F.m.getClass();
        if (r110 == true) goto L69;
        r0.add(new n(11, "投屏至直播间", 2131251035, this.B));
        goto L71
    L69:
        r0.add(new n(12, "取消投屏", 2131251025, this.B));
        goto L71
    L55:
        if (r16 != GameCastStrategy.VIDEO_CHATROOM) goto L63;
        InteractGameContext r111 = InteractGameContext.Companion.getContext();
        if (r111 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r112 = r111.getXplayRunning();
        if (r112 == null) goto L62;
        if (((Boolean) r112.getValue()).booleanValue() == true) goto L63;
    L62:
        r19 = true;
        goto L64
    L49:
        if (tb1.c.b == true) goto L52;
        r18 = ((ph1) je0.a.getValue()).b();
    L71:
        if (this.G == true) goto L73;
    L75:
        boolean r113 = false;
    L76:
        if (r113 == false) goto L86;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r114 = AnchorGameContext.a.a();
        if (r114 == null) goto L84;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.getOpenCapture();
        if (r115 == null) goto L84;
        if (((Boolean) r115.getValue()).booleanValue() != true) goto L84;
        r0.add(new n(14, "关闭摄像头", 2131251095, this.B));
    L84:
        r0.add(new n(13, "打开摄像头", 2131251099, this.B));
    L86:
        if (this.G == false) goto L94;
        com.bytedance.android.live.broadcastgame.api.model.u r116 = this.F.m.e();
        if (r116 == null) goto L90;
        com.bytedance.android.live.broadcastgame.api.model.r r117 = r116.c();
    L92:
        if (q1.g(r117) == false) goto L94;
    L95:
        if (r6 == false) goto L97;
        r0.add(new n(15, "玩法键盘", 2131251098, this.B));
    L97:
        return r0;
    L90:
        r117 = null;
    L94:
        r6 = false;
        goto L95
    L73:
        if (((Boolean) aa0.a.getValue()).booleanValue() == false) goto L75;
        r113 = true;
        goto L76
    L42:
        r14 = false;
        goto L43
    }

    public static /* synthetic */ List Y0(OPPluginMoreDialog r2, boolean r3, int r4) {
        boolean r1 = false;
        if ((r4 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r1 = true;
    L9:
        return r2.X0(r3, r1);
    }

    public OPPluginMoreDialog(Context r8, PluginContext r9, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "pluginContext");
        super(r8, r12, true, false, 8);
        this.H = new i20.a();
        this.F = r9;
        this.G = r11;
        this.B = new OPPluginMoreDialog$getItemClickListener$1(this);
    }
}
