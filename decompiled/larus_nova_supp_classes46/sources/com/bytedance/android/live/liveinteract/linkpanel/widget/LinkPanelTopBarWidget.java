package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.TalkRoomFeedbackDialog;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.AudioTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.VideoTalkSettingFragment;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdk.widget.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/widget/LinkPanelTopBarWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkPanelTopBarWidget extends PlatformMultiLinkWidget {
    public boolean a;
    public ViewGroup b;
    public final CompositeDisposable c;
    public final y d;
    public final Context e;
    public final DataCenter f;
    public final DataContext g;
    public final ViewPager h;
    public yf0.g i;
    public final int j;
    public final boolean k;
    public final String l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LinkPanelTopBarWidget a;

        public a(LinkPanelTopBarWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r22) {
            Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r1 == null) goto L22;
            if (r1.intValue() != 0) goto L22;
            String r2 = this.a.l;
            int r6 = r2.hashCode();
            if (r6 == (-1383228885)) goto L15;
            if (r6 == 3526149) goto L12;
        L17:
            int r3 = bh0.a.a;
        L18:
            gd0.m r4 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r4 == null) goto L94;
            ((LinkPanelTransitService) r4).b(r2, "top_bar_admin_click", -1);
            return;
        L94:
            return;
        L12:
            if (r2.equals("seat") == false) goto L17;
            int r5 = bh0.a.a;
            goto L18
        L15:
            if (r2.equals("bottom") == false) goto L17;
            int r7 = bh0.a.a;
        L22:
            if (r1 != null) goto L25;
        L27:
            if (r1 != null) goto L30;
            return;
        L30:
            if (r1.intValue() != 2) goto L97;
            gd0.m r8 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r8 == null) goto L98;
            LinkPanelTopBarWidget r9 = this.a;
            FragmentActivity r10 = r9.e;
            String r11 = r9.l;
            LinkPanelTransitService r12 = (LinkPanelTransitService) r8;
            Intrinsics.checkNotNullParameter(r11, "requestPage");
            if (r10 == null) goto L109;
            Boolean r13 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
            if (r13 == null) goto L39;
            boolean r14 = r13.booleanValue();
        L40:
            int r15 = 200;
            if (s0.c(r14) == false) goto L76;
            ILinkPanelService r16 = com.bytedance.android.live.liveinteract.component.b.a();
            if (r16 == null) goto L45;
            r16.close();
        L45:
            int r17 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
            if (r17 != 9) goto L54;
            LiveDialogFragment r18 = jc1.k.n(IKtvService.class).getKtvFeedbackDialog(r11, new com.bytedance.android.live.liveinteract.service.i(r12), false);
            if (r18 == null) goto L99;
            FragmentManager r19 = r10.getSupportFragmentManager();
            LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, "KtvFeedbackDialog", r20);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r18, r20) == true) goto L110;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L91
        L53:
            r18.show(r19, "KtvFeedbackDialog");
            return;
        L110:
            return;
        L99:
            return;
        L54:
            if (r14 == false) goto L56;
            int r21 = TalkRoomFeedbackDialog.r;
            LinkPanelTransitService.a(TalkRoomFeedbackDialog.a.a(r17, r14, r11, null, false, null, null, null, 1016), r10.getSupportFragmentManager());
            return;
        L56:
            int r23 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
            int r24 = r11.hashCode();
            if (r24 == (-1383228885)) goto L64;
            if (r24 != 3526149) goto L67;
            if (r11.equals("seat") == false) goto L67;
            r15 = 201;
        L67:
            if (gd0.v.a(r23, 32) == false) goto L72;
            rj0.l.n2.getClass();
            rj0.l r25 = rj0.l.a.a();
            if (r25 == null) goto L102;
            rj0.l.b.d(r25, r15, true, false, 12);
            return;
        L102:
            return;
        L72:
            if (gd0.v.a(r23, 8) == false) goto L104;
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r110 = IVoiceChatGuestService.a.a();
            if (r110 == null) goto L105;
            IVoiceChatGuestService.b.b(r110, r15, true, true, false, 24);
            return;
        L105:
            return;
        L104:
            return;
        L64:
            if (r11.equals("bottom") == false) goto L67;
            r15 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
            goto L67
        L76:
            int r26 = r11.hashCode();
            if (r26 == (-1383228885)) goto L84;
            if (r26 == 3526149) goto L81;
        L86:
            int r27 = 200;
        L87:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r28 = IVoiceChatGuestService.a.a();
            if (r28 == null) goto L107;
            IVoiceChatGuestService.b.b(r28, r27, true, true, false, 24);
            return;
        L107:
            return;
        L81:
            if (r11.equals("seat") == false) goto L86;
            r27 = 201;
            goto L87
        L84:
            if (r11.equals("bottom") == false) goto L86;
            r27 = com.bytedance.android.live.liveinteract.multianchor.model.b.TYPE_BATTLE_DATA;
            goto L87
        L39:
            r14 = false;
            goto L40
        L109:
            return;
        L98:
            return;
        L97:
            return;
        L25:
            if (r1.intValue() != 1) goto L27;
            LinkPanelTopBarWidget r29 = this.a;
            r29.getClass();
            Context r30 = r29.e;
            Intrinsics.checkNotNull(r30);
            j0.a r31 = new j0.a(r30);
            r31.a = s1.B(2131919819);
            r31.a(s1.B(2131915913), c0.a);
            r31.b(s1.B(2131915442), d0.a);
            r31.c();
        }
    }

    public final void xq() {
        ViewGroup r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L5:
        ((TextView) r0.findViewById(2131362297)).setVisibility(0);
        ViewGroup r1 = this.b;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L8:
        ((TextView) r1.findViewById(2131381002)).setVisibility(8);
        if (jc0.a.a() == false) goto L16;
        ViewGroup r2 = this.b;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L13:
        ((TextView) r2.findViewById(2131362297)).setVisibility(8);
        return;
    L16:
        if (this.a == true) goto L18;
        ViewGroup r3 = this.b;
        if (r3 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L50:
        ((TextView) r3.findViewById(2131362297)).setCompoundDrawables(null, null, null, null);
        ViewGroup r4 = this.b;
        if (r4 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L53:
        ((TextView) r4.findViewById(2131362297)).setTextColor(ColorProtector.parseColor("#80000000"));
        ViewGroup r5 = this.b;
        if (r5 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L56:
        ((TextView) r5.findViewById(2131362297)).setTextSize(14.0f);
        Integer r6 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r6 != null) goto L60;
    L65:
        if (r6 != null) goto L68;
    L73:
        if (r6 != null) goto L76;
    L81:
        ViewGroup r7 = this.b;
        if (r7 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L84:
        ((TextView) r7.findViewById(2131362297)).setOnClickListener(new a(this));
        hd0.c.f().c(this.d);
        return;
    L76:
        if (r6.intValue() != 2) goto L81;
        ViewGroup r8 = this.b;
        if (r8 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L80:
        ((TextView) r8.findViewById(2131362297)).setText(2131919271);
        goto L81
    L68:
        if (r6.intValue() != 1) goto L73;
        ViewGroup r9 = this.b;
        if (r9 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L72:
        ((TextView) r9.findViewById(2131362297)).setText(2131917526);
        goto L81
    L60:
        if (r6.intValue() != 0) goto L65;
        ViewGroup r10 = this.b;
        if (r10 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L64:
        ((TextView) r10.findViewById(2131362297)).setText(2131923154);
        goto L81
    L18:
        if (jc1.k.n(IKtvService.class).isCurrentUserIsSinger() == false) goto L26;
        Drawable r11 = s1.m(2131251751);
        ViewGroup r12 = this.b;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L22:
        ((TextView) r12.findViewById(2131362297)).setCompoundDrawablesWithIntrinsicBounds(r11, null, null, null);
        ViewGroup r13 = this.b;
        if (r13 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L25:
        ((TextView) r13.findViewById(2131362297)).setText(2131919500);
    L33:
        ViewGroup r14 = this.b;
        if (r14 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L36:
        ((TextView) r14.findViewById(2131362297)).setCompoundDrawablePadding(s1.f(2.0f));
        ViewGroup r15 = this.b;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L39:
        ((TextView) r15.findViewById(2131362297)).setTextColor(ColorProtector.parseColor("#FE2C55"));
        ViewGroup r16 = this.b;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L42:
        ((TextView) r16.findViewById(2131362297)).setTextSize(15.0f);
        ViewGroup r17 = this.b;
        if (r17 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L45:
        ((TextView) r17.findViewById(2131362297)).setOnClickListener(x0.a(new LinkPanelTopBarWidget$initAdminOperationButtonView$1(this)));
        return;
    L26:
        Drawable r18 = s1.m(2131251750);
        ViewGroup r19 = this.b;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L29:
        ((TextView) r19.findViewById(2131362297)).setCompoundDrawablesWithIntrinsicBounds(r18, null, null, null);
        ViewGroup r20 = this.b;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L32:
        ((TextView) r20.findViewById(2131362297)).setText(2131919498);
        goto L33
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        this.c.dispose();
    }

    public static final void wq(LinkPanelTopBarWidget r9) {
        r9.getClass();
        Room r3 = com.bytedance.android.live.liveinteract.api.utils.m.j(r9).getCurrentRoom();
        if (r3 == null) goto L43;
        com.bytedance.android.livesdk.sharedpref.e r0 = b6.e;
        Boolean r1 = Boolean.FALSE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        ViewGroup r2 = r9.b;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L7:
        r2.findViewById(2131385981).setVisibility(8);
        boolean r4 = com.bytedance.android.live.liveinteract.linkpanel.util.o.I();
        LinkedHashMap r5 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.z(r5);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r5);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r5, null, 6);
        if (r4 == false) goto L10;
        String r6 = "admin";
    L11:
        r5.put("user_type", r6);
        if (r4 == false) goto L14;
        String r7 = "0";
    L15:
        r5.put("is_anchor", r7);
        am2.x r8 = new am2.x();
        if (r4 == false) goto L18;
        String r10 = "live_take_detail";
    L19:
        r8.b = r10;
        r8.a = "live";
        r8.e = "click";
        boolean r11 = true;
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_click", r5, new Object[]{r8, IRoom.class, am2.x.class});
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L35;
        if (hg6.i.d() == false) goto L26;
        yf0.g r12 = r9.i;
        if (r12 == null) goto L44;
        SettingLynxContainerFragment.a r13 = SettingLynxContainerFragment.r;
        Intrinsics.checkNotNull(r12);
        DataCenter r14 = r9.f;
        DataContext r15 = r9.g;
        int r16 = r9.j;
        r13.getClass();
        r12.Rh(SettingLynxContainerFragment.a.a(r12, r14, r3, r15, null, r16, true));
        return;
    L44:
        return;
    L26:
        yf0.g r17 = r9.i;
        if (r17 == null) goto L46;
        int r18 = VideoTalkSettingFragment.z;
        Intrinsics.checkNotNull(r17);
        boolean r19 = r9.k;
        DataCenter r20 = r9.f;
        if (r20 == null) goto L33;
        Boolean r21 = (Boolean) r20.get("data_is_portrait", Boolean.TRUE);
        if (r21 == null) goto L33;
        r11 = r21.booleanValue();
    L33:
        r17.Rh(VideoTalkSettingFragment.a.a(r17, r3, r19, r11, r9.j, r9.f, false, true));
        return;
    L46:
        return;
    L35:
        if (hg6.i.d() == false) goto L39;
        yf0.g r22 = r9.i;
        if (r22 == null) goto L48;
        SettingLynxContainerFragment.a r23 = SettingLynxContainerFragment.r;
        Intrinsics.checkNotNull(r22);
        DataCenter r24 = r9.f;
        DataContext r25 = r9.g;
        r23.getClass();
        r22.Rh(SettingLynxContainerFragment.a.a(r22, r24, r3, r25, null, -1, true));
        return;
    L48:
        return;
    L39:
        yf0.g r26 = r9.i;
        if (r26 == null) goto L50;
        int r27 = AudioTalkSettingFragment.w;
        Intrinsics.checkNotNull(r26);
        r26.Rh(AudioTalkSettingFragment.a.a(r26, r3, r9.g, r9.f, "link_setting_click"));
        return;
    L50:
        return;
    L18:
        r10 = "live_detail";
        goto L19
    L14:
        r7 = "1";
        goto L15
    L10:
        r6 = "anchor";
        goto L11
    }

    public LinkPanelTopBarWidget(Context r2, DataCenter r3, DataContext r4, LinkNoScrollViewPager r5, yf0.g r6, int r7, boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r5, "viewPager");
        Intrinsics.checkNotNullParameter(r9, "requestPage");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.c = new CompositeDisposable();
        this.d = new y(this);
    }
}
