package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.app.Dialog;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.ReplyType;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetBehavior;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdk.widget.LiveStandardSheetDialog;
import com.bytedance.android.livesdk.widget.i1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.imagepipeline.image.ImageInfo;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/dialog/AudioTalkBeInvitedDialogV2;", "Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/GuestTalkBeInvitedDialog;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioTalkBeInvitedDialogV2 extends GuestTalkBeInvitedDialog {
    public static final /* synthetic */ int t = 0;
    public Map<Integer, View> r;
    public final c s;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public b() {
        }

        public final void onFinalImageSet(String r1, Object r2, Animatable r3) {
            ImageInfo r4 = (ImageInfo) r2;
            if ((r3 instanceof AnimatedDrawable2) == false) goto L6;
            AnimatedDrawable2 r5 = (AnimatedDrawable2) r3;
            r5.setAnimationBackend(new com.bytedance.android.live.liveinteract.voicechat.dialog.a(r5.getAnimationBackend()));
            return;
        }
    }

    public static final class c extends LiveBottomSheetBehavior.c {
        public final /* synthetic */ AudioTalkBeInvitedDialogV2 a;

        public final void a(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "var1");
        }

        public c(AudioTalkBeInvitedDialogV2 r1) {
            this.a = r1;
        }

        public final void b(View r9, int r10) {
            Intrinsics.checkNotNullParameter(r9, "var1");
            if (r10 == 5) goto L34;
            return;
        L34:
            this.a.dismiss();     // Catch: Exception -> L7
        L11:
            AudioTalkBeInvitedDialogV2 r11 = this.a;
            IRoom r12 = r11.i;
            if (r12 == null) goto L37;
            z0 r0 = r11.j;
            String r1 = "";
            if (r0 == null) goto L19;
            String r2 = r0.getSecFromUserId();
            if (r2 == null) goto L19;
            String r5 = r2;
        L20:
            z0 r3 = r11.j;
            if (r3 == null) goto L26;
            String r4 = r3.getFromUserIdStr();
            if (r4 == null) goto L26;
            r1 = r4;
        L26:
            gd0.m r6 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
            if (r6 == null) goto L29;
            LinkPanelTransitService r7 = (LinkPanelTransitService) r6;
            String r8 = r1;
            r7.j(r12.getId(), r5, r8, ReplyType.Reject.ordinal());
        L29:
            IMessageBoardInfo r13 = r11.o;
            if ((r13 instanceof MessageBoardInfo) == true) goto L32;
            r13 = null;
        L32:
            com.bytedance.android.live.liveinteract.linkpanel.util.m.f("oneself", (MessageBoardInfo) r13, r1);
            return;
        L19:
            r5 = "";
            goto L20
        L37:
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r14 = DialogFragmentLancet.sLastShowStack;
            if (r14 == null) goto L11;
            com.bytedance.crash.d.d(r14, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void V90() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void Z90(String r1) {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void S90() {
        this.r.clear();
    }

    public AudioTalkBeInvitedDialogV2() {
        this.r = new LinkedHashMap();
        this.s = new c(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final View T90(int r3) {
        if (this.r != null) goto L5;
        this.r = new LinkedHashMap();
    L5:
        View r0 = this.r.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.r.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void W90(z0 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "msg");
        if (r3 == false) goto L5;
        String r4 = s1.B(2131919210);
    L6:
        ((TextView) T90(2131380593)).setText(r4);
        return;
    L5:
        r4 = s1.B(2131919213);
        goto L6
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super.onViewCreated(r14, r15);
        Dialog r16 = getDialog();
        String r1 = null;
        Integer r2 = null;
        if ((r16 instanceof LiveStandardSheetDialog) == true) goto L5;
        r16 = null;
    L5:
        LiveStandardSheetDialog r17 = (LiveStandardSheetDialog) r16;
        if (r17 == null) goto L8;
        c r0 = this.s;
        Intrinsics.checkNotNullParameter(r0, "stateCallback");
        ((SheetBaseDialog) r17).f = new i1(r0);
    L8:
        Dialog r18 = getDialog();
        if ((r18 instanceof LiveBottomSheetDialog) == true) goto L11;
        r18 = null;
    L11:
        LiveBottomSheetDialog r19 = (LiveBottomSheetDialog) r18;
        if (r19 == null) goto L14;
        r19.setStateCallback(this.s);
    L14:
        HSImageView r110 = r14.findViewById(2131374210);
        if (r110 == null) goto L17;
        r110.setVisibility(0);
        r110.setController(Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.live.ktv.common.util.n.a((String) vm2.h.v5.getValue(null, vm2.h.a[332(0x14c, float:4.65E-43)]))).setAutoPlayAnimations(true).setControllerListener(new b()).build());
    L17:
        z0 r111 = this.j;
        if (r111 != null) goto L21;
        return;
    L21:
        if (TeamFightContext.Companion.h() == false) goto L64;
        if (r111.getJoinTeamFightInfo() == null) goto L64;
        j0 r3 = r111.getJoinTeamFightInfo();
        if (r3 == null) goto L27;
        long r7 = r3.getTeamId();
    L29:
        if (r7 <= 0) goto L64;
        IRoom r4 = this.i;
        if (r4 == null) goto L33;
        String r5 = r4.getOwnerUserIdString();
    L34:
        boolean r6 = !Intrinsics.areEqual(r5, r111.getFromUserIdStr());
        j0 r8 = r111.getJoinTeamFightInfo();
        if (r8 == null) goto L39;
        Intrinsics.checkNotNullParameter(r8, "$this$isRedTeam");
        if (((int) r8.getTeamId()) != 1) goto L39;
        boolean r9 = true;
    L40:
        j0 r10 = r111.getJoinTeamFightInfo();
        if (r10 == null) goto L43;
        r2 = Integer.valueOf((int) r10.getTeamId());
    L43:
        this.m = r2;
        if (r9 == false) goto L46;
        String r11 = "#FE2C55";
    L47:
        int r12 = ColorProtector.parseColor(r11);
        if (r6 == false) goto L50;
        int r13 = 2131922769;
    L51:
        String r20 = s1.B(r13);
        SpannableStringBuilder r21 = new SpannableStringBuilder();
        r21.append(r20);
        if (r9 == false) goto L54;
        int r22 = 2131922805;
    L55:
        r21.append(s1.B(r22));
        ForegroundColorSpan r23 = new ForegroundColorSpan(r12);
        if (r6 == false) goto L58;
        int r24 = 6;
    L59:
        if (r6 == false) goto L61;
        int r25 = 10;
    L62:
        r21.setSpan(r23, r24, r25, 33);
        ((TextView) T90(2131380593)).setText(r21);
    L88:
        if (r111.getInviteImage() == null) goto L90;
        ((FrameLayout) T90(2131374217)).setVisibility(8);
        ((FrameLayout) T90(2131374968)).setVisibility(0);
        ImageUtil.loadImage((ImageView) T90(2131375610), r111.getInviteImage(), -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
    L90:
        String r26 = r111.getInvitePrompt();
        if (r26 == null) goto L96;
        if (r2.a(r26) != true) goto L96;
        ((TextView) T90(2131380593)).setText(r111.getInvitePrompt());
    L96:
        if (vm2.h.U().d() == true) goto L98;
        return;
    L98:
        if (r111.getInviteSubtitle() == null) goto L104;
        TextView r112 = (TextView) r14.findViewById(2131387625);
        if (r112 == null) goto L105;
        r112.setVisibility(0);
        r112.setText(r111.getInviteSubtitle());
        return;
    L105:
        return;
    L104:
        return;
    L61:
        r25 = 9;
        goto L62
    L58:
        r24 = 5;
        goto L59
    L54:
        r22 = 2131922777;
        goto L55
    L50:
        r13 = 2131922772;
        goto L51
    L46:
        r11 = "#27A4FF";
    L39:
        r9 = false;
        goto L40
    L33:
        r5 = null;
        goto L34
    L27:
        r7 = 0;
    L64:
        if (LinkMicGameContext.Companion.e() == false) goto L88;
        IGameDataService r27 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r27 == null) goto L88;
        com.bytedance.android.live.broadcastgame.api.model.i r28 = r27.getGameOpenInfo();
        if (r28 == null) goto L88;
        if (r28.d != true) goto L88;
        IRoom r29 = this.i;
        if (r29 == null) goto L74;
        r1 = r29.getOwnerUserIdString();
    L74:
        boolean r30 = !Intrinsics.areEqual(r1, r111.getFromUserIdStr());
        IGameDataService r31 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r31 == null) goto L80;
        com.bytedance.android.live.broadcastgame.api.model.i r32 = r31.getGameOpenInfo();
        if (r32 == null) goto L80;
        String r33 = r32.c;
        if (r33 == null) goto L80;
    L81:
        if (r30 == false) goto L83;
        String r34 = s1.C(2131919211, new Object[]{r33});
    L84:
        TextView r35 = (TextView) r14.findViewById(2131380593);
        if (r35 == null) goto L88;
        r35.setText(r34);
        goto L88
    L83:
        r34 = s1.C(2131919214, new Object[]{r33});
    L80:
        r33 = "游戏";
        goto L81
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        if (vm2.h.U().d() == false) goto L13;
        z0 r9 = this.j;
        if (r9 == null) goto L15;
        String r10 = r9.getInvitePrompt();
        if (r10 == null) goto L15;
        if (StringsKt.contains$default(r10, "邀请你成为主咖", false, 2, null) != true) goto L15;
        return r6.inflate(2131565552, r7, false);
    L15:
        return r6.inflate(2131565553, r7, false);
    L13:
        return r6.inflate(2131565552, r7, false);
    }
}
