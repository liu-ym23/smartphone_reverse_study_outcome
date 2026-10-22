package com.bytedance.android.live.broadcastgame.xplay;

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
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.aa0;
import com.bytedance.android.livesdk.config.n30;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zg1.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayMoreDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class XplayMoreDialog extends CommonStandardBottomDialog {
    public final r0 B;
    public OPMoreDialogAdapter C;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p D;
    public final XplayInternalContext E;
    public final Function0<Unit> F;
    public final /* synthetic */ i20.a G;

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
        public final /* synthetic */ XplayMoreDialog a;

        public b(XplayMoreDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r11v10, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.xplay.XplayMoreDialog] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            XplayMoreDialog r0 = this.a;
            r0 r1 = r0.B;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r0, "pluginMoreDialog");
            Intrinsics.checkNotNullParameter(r11, "view");
            com.bytedance.android.livesdk.widget.x0.b r12 = new com.bytedance.android.livesdk.widget.x0.b(r1.a.D.getContext(), 4);
            r12.l(2131923535);
            r12.i(1, 2131920876, p0.a);
            r12.i(0, 2131920877, new q0(r1, r0));
            r12.k(0, true);
            r12.n();
            String r13 = com.bytedance.android.live.broadcastgame.opengame.service.e.a;
            com.bytedance.android.live.broadcastgame.api.xplay.p r14 = r1.a.D;
            com.bytedance.android.live.broadcastgame.opengame.service.e.f(0L, r14.h.c, "退出功能", "barrage", Boolean.valueOf(r14.d), r1.a.D.h.b);
            int r15 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            ?? r16 = r1.a;
            com.bytedance.android.live.broadcastgame.api.xplay.l r2 = r16.D.h;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r2.b, r2.c, r16.getContext().getString(2131923545));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ XplayMoreDialog a;

        public c(XplayMoreDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (com.bytedance.android.livesdk.utils.f1.a(r5.getId()) == false) goto L5;
            return;
        L5:
            xs2.b.a().post(new a2(Long.valueOf(this.a.D.h.d), null, null, 6));
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ XplayMoreDialog a;

        public d(XplayMoreDialog r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.bytedance.android.live.broadcastgame.xplay.XplayMoreDialog, java.lang.Object] */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            XplayExternalContext.a r6 = XplayExternalContext.Companion;
            XplayExternalContext r0 = r6.getContext();
            boolean r1 = true;
            if (r0 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r2 = r0.getClearScreen();
            if (r2 == null) goto L9;
            if (((Boolean) r2.getValue()).booleanValue() != true) goto L9;
            String r3 = "退出清屏";
        L10:
            int r4 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
            com.bytedance.android.live.broadcastgame.api.xplay.l r7 = this.a.D.h;
            com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r7.b, r7.c, r3);
            XplayExternalContext r8 = r6.getContext();
            if (r8 == null) goto L23;
            com.bytedance.live.datacontext.m<Boolean> r9 = r8.getClearScreen();
            if (r9 == null) goto L23;
            XplayExternalContext r11 = r6.getContext();
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
        L33:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L31
            Throwable r15 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L31
            if (r15 == null) goto L37;
            com.bytedance.crash.d.d(r15, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r13);
            throw th;
        L26:
            if (Looper.myLooper() == r14.getLooper()) goto L28;
            r14.post(DialogLancet.createDismissRunnable(r13));
            return;
        L9:
            r3 = "清屏";
            goto L10
        }
    }

    public final int getLayoutId() {
        return 2131568052;
    }

    public final boolean Y0() {
        if (((XplayScene) this.E.getCurrentScene().getValue()) != XplayScene.Video) goto L6;
        return true;
    L6:
        if (((XplayScene) this.E.getCurrentScene().getValue()) != XplayScene.TalkRoom) goto L24;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L10;
        Integer r1 = Integer.valueOf(r0.getCurrentUiLayout());
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
    L21:
        if (r1 == null) goto L24;
        r1.intValue();
        goto L24
    L19:
        if (r1.intValue() != 16) goto L21;
        return false;
    L14:
        if (r1.intValue() != 15) goto L16;
        return true;
    L10:
        r1 = null;
    L24:
        return false;
    }

    public final boolean Z0() {
        if (((XplayScene) this.E.getCurrentScene().getValue()) != XplayScene.TalkRoom) goto L18;
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L7;
        Integer r1 = Integer.valueOf(r0.getCurrentUiLayout());
    L8:
        if (r1 != null) goto L11;
    L12:
        if (r1 == null) goto L18;
        if (r1.intValue() != 65) goto L18;
    L16:
        return false;
    L11:
        if (r1.intValue() == 16) goto L16;
    L7:
        r1 = null;
    L18:
        if (this.D.d == true) goto L20;
        return false;
    L20:
        if (Y0() == true) goto L24;
        return true;
    L24:
        return false;
    }

    public final void show() {
        OPMoreDialogAdapter r0 = this.C;
        if (r0 == null) goto L5;
        List<i> r1 = X0(false, false);
        Intrinsics.checkNotNullParameter(r1, "newList");
        r0.b.clear();
        r0.b.addAll(r1);
        r0.notifyDataSetChanged();
    L5:
        Disposable r2 = com.bytedance.android.live.broadcastgame.opengame.utils.i.b(RxUtilKt.h(xs2.b.a().b(q10.a.class)), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.G.a(r2);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.show();
        DialogLancet.afterDialogShow(this);
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
        this.G.b();
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
        if (Z0() == false) goto L13;
        XplayExternalContext r0 = XplayExternalContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getClearScreen();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        com.bytedance.android.livesdk.chatroom.utils.a1.m((ImageView) findViewById(2131366946), 2131251096);
        ((TextView) findViewById(2131366948)).setText(com.bytedance.android.live.core.utils.s1.B(2131916504));
        ((TextView) findViewById(2131366947)).setText(com.bytedance.android.live.core.utils.s1.B(2131916506));
        return;
    L11:
        com.bytedance.android.livesdk.chatroom.utils.a1.m((ImageView) findViewById(2131366946), 2131251094);
        ((TextView) findViewById(2131366948)).setText(com.bytedance.android.live.core.utils.s1.B(2131915814));
        ((TextView) findViewById(2131366947)).setText(com.bytedance.android.live.core.utils.s1.B(2131915817));
        return;
    }

    public final void onCreate(Bundle r6) {
        super.onCreate(r6);
        RecyclerView r7 = findViewById(2131364751);
        if (r7 == null) goto L5;
        List<i> r1 = X0(false, false);
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r1, "items");
        OPMoreDialogAdapter r2 = new OPMoreDialogAdapter(this, r1);
        this.C = r2;
        r7.setAdapter(r2);
        r7.setLayoutManager(new LinearLayoutManager(r7.getContext(), 0, false));
        r7.addItemDecoration(new a((int) fm3.e.a(r7.getContext(), 26.0f)));
    L5:
        UtilityKotlinExtentionsKt.w(findViewById(2131371856));
        ((TextView) findViewById(2131371856)).setOnClickListener(new b(this));
        ((TextView) findViewById(2131380593)).setText(this.D.h.c);
        String r8 = this.D.h.e;
        GenericDraweeHierarchy r3 = ((HSImageView) findViewById(2131374718)).getHierarchy();
        ((HSImageView) findViewById(2131374718)).setActualImageResource(2131107985);
        r3.setPlaceholderImage(2131107985);
        r3.setFailureImage(2131107985);
        ((HSImageView) findViewById(2131374718)).setHierarchy(r3);
        ((LinearLayout) findViewById(2131388807)).setOnClickListener(new c(this));
        boolean r4 = true;
        if (r8.length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        ((HSImageView) findViewById(2131374718)).setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r8)).build());
    L12:
        if (this.D.h.n.length() > 0) goto L15;
        r4 = false;
    L15:
        if (r4 == false) goto L18;
        ((LinearLayout) findViewById(2131382445)).setVisibility(0);
        ((TextView) findViewById(2131382446)).setText(this.D.h.n);
    L18:
        if (Z0() == false) goto L20;
        UtilityKotlinExtentionsKt.w(findViewById(2131366945));
        ((LinearLayout) findViewById(2131366945)).setOnClickListener(new d(this));
        return;
    L20:
        UtilityKotlinExtentionsKt.t(findViewById(2131366945));
        return;
    L8:
        r5 = false;
        goto L9
    }

    public static final void W0(XplayMoreDialog r1, i r2) {
        com.bytedance.android.live.broadcastgame.api.xplay.l r3 = r1.D.h;
        com.bytedance.android.live.broadcastgame.api.interactgame.n.a(r3.b, r3.c, r2.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<i> X0(boolean r8, boolean r9) {
        ArrayList r11 = new ArrayList();
        boolean r0 = true;
        if (Y0() == false) goto L13;
        XplayExternalContext r12 = XplayExternalContext.Companion.getContext();
        if (r12 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r13 = r12.getClearScreen();
        if (r13 == null) goto L11;
        if (((Boolean) r13.getValue()).booleanValue() != true) goto L11;
        r11.add(new i(17, getContext().getString(2131923542), 2131253462, this.B));
    L11:
        r11.add(new i(16, getContext().getString(2131923544), 2131253464, this.B));
    L13:
        if (((XplayScene) this.E.getCurrentScene().getValue()) != XplayScene.TalkRoom) goto L20;
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 != null) goto L17;
    L24:
        boolean r15 = false;
    L25:
        if (r15 == true) goto L27;
    L30:
        com.bytedance.android.live.broadcastgame.api.xplay.p r16 = this.D;
        if (r16.d == false) goto L50;
        com.bytedance.android.live.broadcastgame.api.xplay.l r17 = r16.h;
        if (q1.f() == false) goto L39;
        if (r17 == null) goto L37;
        com.bytedance.android.live.broadcastgame.api.model.q0 r18 = r17.l;
        if (r18 == null) goto L37;
    L38:
        com.bytedance.android.live.broadcastgame.api.model.q0 r19 = com.bytedance.android.live.broadcastgame.api.model.q0.a(r18, (String) n30.a.getValue());
    L42:
        if (r19 == null) goto L44;
    L47:
        boolean r21 = true;
    L48:
        if (r21 == false) goto L50;
    L51:
        if (r0 == false) goto L53;
        r11.add(new i(15, "玩法键盘", 2131251098, this.B));
    L53:
        return r11;
    L44:
        if (q1.f() == true) goto L47;
        r21 = false;
    L37:
        r18 = new com.bytedance.android.live.broadcastgame.api.model.q0(0);
        goto L38
    L39:
        if (r17 == null) goto L41;
        r19 = r17.l;
        goto L42
    L41:
        r19 = null;
    L50:
        r0 = false;
        goto L51
    L27:
        if (((Boolean) this.E.getOpenCapture().getValue()).booleanValue() == false) goto L29;
        r11.add(new i(14, "关闭摄像头", 2131251095, this.B));
        goto L30
    L29:
        r11.add(new i(13, "打开摄像头", 2131251099, this.B));
        goto L30
    L17:
        if (r14.getCurrentUiLayout() != 15) goto L24;
    L20:
        if (this.D.d == false) goto L24;
        if (((Boolean) aa0.a.getValue()).booleanValue() == false) goto L24;
        r15 = true;
        goto L25
    }

    public XplayMoreDialog(Context r8, com.bytedance.android.live.broadcastgame.api.xplay.p r9, XplayInternalContext r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "newEnv");
        Intrinsics.checkNotNullParameter(r11, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r12, "quit");
        super(r8, false, true, false, 8);
        this.G = new i20.a();
        this.D = r9;
        this.E = r11;
        this.F = r12;
        this.B = new r0(this);
    }
}
