package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog;
import com.bytedance.android.live.liveinteract.plantform.model.j0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.pannel.SheetBaseDialog;
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
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/VideoTalkBeInvitedDialogV2;", "Lcom/bytedance/android/live/liveinteract/linkpanel/dialog/GuestTalkBeInvitedDialog;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class VideoTalkBeInvitedDialogV2 extends GuestTalkBeInvitedDialog {
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
            r5.setAnimationBackend(new com.bytedance.android.live.liveinteract.videotalk.dialog.a(r5.getAnimationBackend()));
            return;
        }
    }

    public static final class c extends LiveBottomSheetBehavior.c {
        public final /* synthetic */ VideoTalkBeInvitedDialogV2 a;

        public final void a(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "var1");
        }

        public c(VideoTalkBeInvitedDialogV2 r1) {
            this.a = r1;
        }

        public final void b(View r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "var1");
            if (r3 == 5) goto L13;
            return;
        L13:
            this.a.dismiss();     // Catch: Exception -> L7
        L11:
            VideoTalkBeInvitedDialogV2 r4 = this.a;
            int r5 = VideoTalkBeInvitedDialogV2.t;
            r4.Y90("oneself");
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L11;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
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
    public void S90() {
        this.r.clear();
    }

    public VideoTalkBeInvitedDialogV2() {
        this.r = new LinkedHashMap();
        this.s = new c(this);
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public View T90(int r3) {
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

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
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
    public void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Dialog r12 = getDialog();
        String r1 = null;
        Integer r2 = null;
        if ((r12 instanceof LiveStandardSheetDialog) == true) goto L5;
        r12 = null;
    L5:
        LiveStandardSheetDialog r13 = (LiveStandardSheetDialog) r12;
        if (r13 == null) goto L8;
        c r0 = this.s;
        Intrinsics.checkNotNullParameter(r0, "stateCallback");
        ((SheetBaseDialog) r13).f = new i1(r0);
    L8:
        Dialog r14 = getDialog();
        if ((r14 instanceof LiveBottomSheetDialog) == true) goto L11;
        r14 = null;
    L11:
        LiveBottomSheetDialog r15 = (LiveBottomSheetDialog) r14;
        if (r15 == null) goto L14;
        r15.setStateCallback(this.s);
    L14:
        HSImageView r16 = r10.findViewById(2131374210);
        if (r16 == null) goto L17;
        r16.setVisibility(0);
        r16.setController(Fresco.newDraweeControllerBuilder().setUri(com.bytedance.android.live.ktv.common.util.n.a((String) vm2.h.v5.getValue(null, vm2.h.a[332(0x14c, float:4.65E-43)]))).setAutoPlayAnimations(true).setControllerListener(new b()).build());
    L17:
        z0 r17 = this.j;
        if (r17 != null) goto L21;
        return;
    L21:
        if (TeamFightContext.Companion.h() == false) goto L62;
        if (r17.getJoinTeamFightInfo() == null) goto L62;
        j0 r3 = r17.getJoinTeamFightInfo();
        if (r3 == null) goto L27;
        long r7 = r3.getTeamId();
    L29:
        if (r7 <= 0) goto L62;
        j0 r4 = r17.getJoinTeamFightInfo();
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "$this$isRedTeam");
        if (((int) r4.getTeamId()) != 1) goto L33;
        boolean r5 = true;
    L34:
        IRoom r6 = this.i;
        if (r6 == null) goto L37;
        String r8 = r6.getOwnerUserIdString();
    L38:
        boolean r9 = true ^ Intrinsics.areEqual(r8, r17.getFromUserIdStr());
        j0 r18 = r17.getJoinTeamFightInfo();
        if (r18 == null) goto L41;
        r2 = Integer.valueOf((int) r18.getTeamId());
    L41:
        this.m = r2;
        if (r5 == false) goto L44;
        String r19 = "#FE2C55";
    L45:
        int r20 = ColorProtector.parseColor(r19);
        if (r9 == false) goto L48;
        int r21 = 2131922769;
    L49:
        String r22 = s1.B(r21);
        SpannableStringBuilder r23 = new SpannableStringBuilder();
        r23.append(r22);
        if (r5 == false) goto L52;
        int r24 = 2131922805;
    L53:
        r23.append(s1.B(r24));
        ForegroundColorSpan r25 = new ForegroundColorSpan(r20);
        if (r9 == false) goto L56;
        int r26 = 6;
    L57:
        if (r9 == false) goto L59;
        int r27 = 10;
    L60:
        r23.setSpan(r25, r26, r27, 33);
        ((TextView) T90(2131380593)).setText(r23);
    L86:
        if (vm2.h.U().d() == true) goto L88;
        return;
    L88:
        if (r17.getInviteSubtitle() == null) goto L94;
        TextView r110 = (TextView) r10.findViewById(2131387625);
        if (r110 == null) goto L95;
        r110.setVisibility(0);
        r110.setText(r17.getInviteSubtitle());
        return;
    L95:
        return;
    L94:
        return;
    L59:
        r27 = 9;
        goto L60
    L56:
        r26 = 5;
        goto L57
    L52:
        r24 = 2131922777;
        goto L53
    L48:
        r21 = 2131922772;
        goto L49
    L44:
        r19 = "#27A4FF";
        goto L45
    L37:
        r8 = null;
        goto L38
    L33:
        r5 = false;
        goto L34
    L27:
        r7 = 0;
    L62:
        if (LinkMicGameContext.Companion.e() == false) goto L86;
        IGameDataService r28 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r28 == null) goto L86;
        com.bytedance.android.live.broadcastgame.api.model.i r29 = r28.getGameOpenInfo();
        if (r29 == null) goto L86;
        if (r29.d != true) goto L86;
        IRoom r30 = this.i;
        if (r30 == null) goto L72;
        r1 = r30.getOwnerUserIdString();
    L72:
        boolean r31 = !Intrinsics.areEqual(r1, r17.getFromUserIdStr());
        IGameDataService r32 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r32 == null) goto L78;
        com.bytedance.android.live.broadcastgame.api.model.i r33 = r32.getGameOpenInfo();
        if (r33 == null) goto L78;
        String r34 = r33.c;
        if (r34 == null) goto L78;
    L79:
        if (r31 == false) goto L81;
        String r35 = s1.C(2131919211, new Object[]{r34});
    L82:
        TextView r36 = (TextView) r10.findViewById(2131380593);
        if (r36 == null) goto L86;
        r36.setText(r35);
        goto L86
    L81:
        r35 = s1.C(2131919214, new Object[]{r34});
    L78:
        r34 = "游戏";
        goto L79
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (vm2.h.U().d() == false) goto L6;
        return r2.inflate(2131565553, r3, false);
    L6:
        return r2.inflate(2131565552, r3, false);
    }
}
