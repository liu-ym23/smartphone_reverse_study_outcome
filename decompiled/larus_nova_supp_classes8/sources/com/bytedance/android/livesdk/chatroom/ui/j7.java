package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.widget.BaseDialogFragment;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.action.SelectablePage;
import com.bytedance.android.livesdk.admin.ui.AdminListAdapter;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.config.gv;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j7 implements LiveProfileManageDialogV2.b {
    public final /* synthetic */ LiveProfileManageDialogV2 a;

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2.b
    public final void dismissDialog() {
        LiveProfileManageDialogV2 r0 = this.a;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
    }

    public j7(LiveProfileManageDialogV2 r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.LiveProfileManageDialogV2.b
    public final void onClick(int r13) {
        SelectablePage r1 = null;
        if (r13 == 0) goto L95;
        switch(r13) {
            case 3: goto L92;
            case 4: goto L23;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L138;
        };
    L6:
        dismissDialog();
        return;
    L7:
        LiveProfileManageViewPager r14 = (LiveProfileManageViewPager) this.a.findViewById(2131386019);
        LiveProfileManageViewPager.ProfileManageViewAdapter r0 = r14.a;
        if (r0 == null) goto L139;
        r14.setCurrentItem(3, false);
        SelectablePage r15 = r0.f();
        if ((r15 instanceof SelectablePage) == false) goto L14;
        r1 = r15;
    L14:
        SelectablePage r2 = r1;
        if (r2 == null) goto L17;
        r2.onPageSelected();
    L17:
        LiveRoomManageAppLogger.h();
        return;
    L139:
        return;
    L18:
        ((LiveProfileManageViewPager) this.a.findViewById(2131386019)).j();
        return;
    L19:
        LiveProfileManageViewPager r16 = (LiveProfileManageViewPager) this.a.findViewById(2131386019);
        LiveProfileManageViewPager.ProfileManageViewAdapter r3 = r16.a;
        if (r3 == null) goto L140;
        r3.g(null);
        r16.setCurrentItem(2, false);
        r16.k(r3.e);
        LiveRoomManageAppLogger.k();
        return;
    L140:
        return;
    L23:
        LiveProfileManageDialogV2 r17 = this.a;
        r17.getClass();
        Uri r4 = UriProtector.parse(gv.a.getValue());
        Uri.Builder r5 = UriProtector.parse(UriProtector.getQueryParameter(r4, "url")).buildUpon();
        Room r6 = r17.l;
        if (r6 == null) goto L26;
        Long r7 = Long.valueOf(r6.id);
    L27:
        Uri.Builder r8 = r5.appendQueryParameter("room_id", String.valueOf(r7));
        User r9 = r17.m;
        if (r9 == null) goto L30;
        String r10 = r9.getIdStr();
    L31:
        Uri.Builder r11 = r8.appendQueryParameter("anchor_id", String.valueOf(r10));
        User r12 = r17.m;
        if (r12 == null) goto L34;
        String r18 = r12.getIdStr();
    L35:
        Uri.Builder r19 = r11.appendQueryParameter("user_id", String.valueOf(r18));
        User r20 = r17.m;
        if (r20 == null) goto L38;
        String r21 = r20.getCastSecUid();
    L39:
        Uri.Builder r22 = r19.appendQueryParameter("sec_user_id", String.valueOf(r21));
        Room r23 = r17.l;
        if (r23 == null) goto L44;
        User r24 = r23.getOwner();
        if (r24 == null) goto L44;
        String r25 = r24.getCastSecUid();
    L45:
        String r26 = r22.appendQueryParameter("sec_anchor_id", String.valueOf(r25)).toString();
        String r27 = UriProtector.getQueryParameter(r4, "fallback_url");
        Resources r28 = r17.getContext().getResources();
        DisplayMetrics r29 = WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics());
        float r30 = r29.widthPixels;
        float r31 = r29.density;
        int r32 = (int) (r30 / r31);
        int r33 = (int) (((double) (r29.heightPixels / r31)) * 0.7d);
        if (SettingKeyUtils.a() == true) goto L68;
        LiveDialogFragment r34 = r17.e;
        if (r34 != null) goto L50;
    L59:
        com.bytedance.android.live.browser.webview.fragment.o r35 = jc1.k.n(IBrowserService.class).buildLynxDialog(r26, r27, null).setWidth(r32);
        r35.b = r33;
        r35.p = false;
        r35.q = true;
        boolean r36 = r17.o;
        r35.m = !r36;
        if (r36 == false) goto L62;
        int r37 = 80;
    L63:
        r35.i = r37;
        r17.e = r35.build();
        com.bytedance.android.livesdk.f.d().a();
        BaseDialogFragment.show(ContextUtil.contextToFragmentActivity(r17.getContext()), r17.e);
        if (r17.e == null) goto L67;
        r17.setOnDismissListener(new k7(r17));
        return;
    L67:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment");
    L62:
        r37 = 8388613;
        goto L63
    L50:
        if (r34.isShowing() != true) goto L59;
        LiveDialogFragment r38 = r17.e;
        Intrinsics.checkNotNull(r38);
        r38.dismissAllowingStateLoss();     // Catch: Exception -> L54
    L58:
        r17.e = null;
    L54:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r39 = DialogFragmentLancet.sLastShowStack;
        if (r39 == null) goto L58;
        com.bytedance.crash.d.d(r39, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L58
    L68:
        HybridDialog r40 = r17.f;
        if (r40 == null) goto L81;
        Dialog r41 = r40.getDialog();
        if (r41 == null) goto L81;
        if (r41.isShowing() == false) goto L81;
        r40.dismissAllowingStateLoss();     // Catch: Exception -> L76
    L80:
        r17.f = null;
    L76:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r42 = DialogFragmentLancet.sLastShowStack;
        if (r42 == null) goto L80;
        com.bytedance.crash.d.d(r42, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L81:
        String r43 = jc1.k.n(IBrowserService.class).getRenderUrlByH5Service(r26);
        IBrowserService r44 = jc1.k.n(IBrowserService.class);
        Context r45 = r17.getContext();
        Uri.Builder r46 = x6.a.c(r43).appendQueryParameter("type", "popup").appendQueryParameter("width", String.valueOf(r32)).appendQueryParameter("height", String.valueOf(r33));
        String r47 = "0";
        Uri.Builder r48 = r46.appendQueryParameter("show_dim", "0");
        if (r17.o == true) goto L85;
        r47 = "1";
    L85:
        Uri.Builder r49 = r48.appendQueryParameter("landscape_custom_height", r47);
        if (r17.o == false) goto L88;
        String r50 = "bottom";
    L89:
        HybridDialog r51 = r44.showHybridDialogWithListener(r45, r49.appendQueryParameter("gravity", r50).appendQueryParameter("fallback_url", r27).build(), null, new l7(r17));
        r17.f = r51;
        if (r51 == null) goto L133;
        com.bytedance.android.livesdk.f.d().a();
        return;
    L133:
        return;
    L88:
        r50 = "end";
    L44:
        r25 = null;
        goto L45
    L38:
        r21 = null;
        goto L39
    L34:
        r18 = null;
        goto L35
    L30:
        r10 = null;
        goto L31
    L26:
        r7 = null;
        goto L27
    L92:
        LiveProfileManageViewPager r110 = (LiveProfileManageViewPager) this.a.findViewById(2131386019);
        LiveProfileManageViewPager.ProfileManageViewAdapter r52 = r110.a;
        if (r52 == null) goto L135;
        r110.setCurrentItem(0, false);
        r110.k(r52.a);
        r110.b = true;
        return;
    L135:
        return;
    L138:
        return;
    L95:
        LiveProfileManageViewPager r111 = (LiveProfileManageViewPager) this.a.findViewById(2131386019);
        LiveProfileManageViewPager.ProfileManageViewAdapter r53 = r111.a;
        if (r53 == null) goto L137;
        us2.a r54 = r53.b;
        if (r54.k == null) goto L122;
        String r55 = r54.l;
        if (r55 == null) goto L122;
        if (com.bytedance.android.live.base.model.user.q0.a(r55) != true) goto L122;
        r54.a(2131384792).setLayoutManager(new SSLinearLayoutManager(r54.getContext(), 1));
        r54.c = 2131919021;
        r54.a(2131384792).setVisibility(0);
        r54.b = 2131919019;
        r54.d = r54.getContext().getString(2131914520);
        r54.h = new ud1.a(r54.j);
        r54.i = new AdminListAdapter(r54.getContext(), r54.l, r54.k.longValue());
        r54.a(2131384792).setAdapter(r54.i);
        r54.b();
        ((TextView) r54.a(2131384794)).setText(r54.d);
        View r56 = LayoutInflater.from(r54.getContext()).inflate(2131563550, null);
        r56.setOnClickListener(new us2.b(r54));
        a8 r57 = new a8(r54.getContext());
        ImageView r58 = r57.b;
        if (r58 == null) goto L106;
        r58.setImageResource(2131252618);
    L106:
        ImageView r59 = r57.b;
        if (r59 == null) goto L109;
        r59.setVisibility(0);
    L109:
        String r60 = r54.getContext().getString(r54.b);
        Intrinsics.checkNotNullParameter(r60, LiveEndPageData.TAG_TITLE);
        TextView r61 = r57.c;
        if (r61 == null) goto L112;
        r61.setText(r60);
    L112:
        TextView r62 = r57.c;
        if (r62 == null) goto L115;
        r62.setVisibility(0);
    L115:
        String r63 = r54.getContext().getString(r54.c);
        Intrinsics.checkNotNullParameter(r63, "label");
        TextView r64 = r57.d;
        if (r64 == null) goto L118;
        r64.setText(r63);
    L118:
        TextView r65 = r57.d;
        if (r65 == null) goto L121;
        r65.setVisibility(0);
    L121:
        r57.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r54.a(2131384793).setBuilder(LoadingStatusView.Builder.createDefaultBuilder(r54.getContext()).setEmptyView(r57).setErrorView(r56).setUseProgressBar(r54.getContext().getResources().getDimensionPixelSize(2131168552)));
    L122:
        r111.setCurrentItem(2, false);
        r111.k(r53.b);
        LiveRoomManageAppLogger.k();
        return;
    }
}
