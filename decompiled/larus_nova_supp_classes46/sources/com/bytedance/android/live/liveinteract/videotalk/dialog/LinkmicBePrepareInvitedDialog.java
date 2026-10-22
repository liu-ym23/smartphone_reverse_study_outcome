package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.livesdk.chatroom.model.LinkerPrepareInviteContent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.r2;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/LinkmicBePrepareInvitedDialog;", "Lcom/bytedance/android/live/liveinteract/videotalk/dialog/VideoTalkBeInvitedDialogV2;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicBePrepareInvitedDialog extends VideoTalkBeInvitedDialogV2 {
    public static final /* synthetic */ int v = 0;
    public Map<Integer, View> u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void U90() {
        aa0(1);
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2, com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void S90() {
        this.u.clear();
    }

    public LinkmicBePrepareInvitedDialog() {
        this.u = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2, com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2, com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final View T90(int r3) {
        if (this.u != null) goto L5;
        this.u = new LinkedHashMap();
    L5:
        View r0 = this.u.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.u.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void Y90(String r2) {
        Intrinsics.checkNotNullParameter(r2, "refuseType");
        aa0(2);
        dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void aa0(int r12) {
        h1 r0 = this.k;
        if (r0 == null) goto L7;
        LinkerPrepareInviteContent r1 = r0.getLinkerPrepareInviteContent();
        if (r1 == null) goto L7;
        long r6 = r1.getFromRoomId();
    L8:
        h1 r2 = this.k;
        if (r2 == null) goto L13;
        LinkerPrepareInviteContent r3 = r2.getLinkerPrepareInviteContent();
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$fromUserId");
        o0.a r4 = o0.a;
        Long r5 = Long.valueOf(r3.get_fromUserId());
        String r7 = r3.get_fromOpenId();
        r4.getClass();
        String r8 = o0.a.g(r5, r7);
    L14:
        h1 r9 = this.k;
        if (r9 == null) goto L22;
        LinkerPrepareInviteContent r10 = r9.getLinkerPrepareInviteContent();
        if (r10 == null) goto L22;
        String r11 = r10.getSource();
        if (r11 == null) goto L22;
        String r13 = r11;
    L24:
        if (r6 != 0) goto L26;
        return;
    L26:
        if (r2.a(r8) == false) goto L32;
        com.bytedance.android.live.liveinteract.plantform.base.g r14 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r14 == null) goto L33;
        r14.ua(r6, r8, r12, r13);
        return;
    L33:
        return;
    L32:
        return;
    L22:
        r13 = "";
    L13:
        r8 = "";
    L7:
        r6 = 0;
        goto L8
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2, com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        h1 r6 = this.k;
        if (r6 == null) goto L19;
        LinkerPrepareInviteContent r7 = r6.getLinkerPrepareInviteContent();
        if (r7 == null) goto L20;
        ImageView r8 = (ImageView) T90(2131374209);
        IBaseUser r0 = r7.getInvitorUser();
        String r1 = null;
        if (r0 == null) goto L9;
        py.k r2 = r0.getAvatarThumbKt();
    L10:
        a1.v(r8, r2, 2131251889);
        TextView r9 = (TextView) T90(2131380593);
        a5 r3 = r7.getContent();
        if (r3 == null) goto L13;
        r1 = r3.getDefaultPattern();
    L13:
        r9.setText(r1);
        String r10 = r7.getSubtitle();
        if (r10 == null) goto L21;
        TextView r11 = (TextView) T90(2131387625);
        if (r11 == null) goto L22;
        r11.setVisibility(0);
        r11.setText(r10);
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r2 = null;
        goto L10
    L20:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.dialog.VideoTalkBeInvitedDialogV2, com.bytedance.android.live.liveinteract.linkpanel.dialog.GuestTalkBeInvitedDialog
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (vm2.h.U().d() == false) goto L6;
        return r2.inflate(2131565518, r3, false);
    L6:
        return r2.inflate(2131565517, r3, false);
    }
}
