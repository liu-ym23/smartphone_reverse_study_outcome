package com.bytedance.android.live.liveinteract.digitavatar;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public g0() {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r10) {
        if (r10 == null) goto L5;
        Context r11 = r10.getContext();
    L6:
        FragmentActivity r12 = ContextUtil.contextToActivity(r11);
        if (r12 != null) goto L9;
        return;
    L9:
        DataCenter r1 = this.a;
        if (r1 != null) goto L12;
        return;
    L12:
        int r2 = x.a;
        boolean r3 = com.bytedance.android.live.core.utils.a0.d(r1, false);
        LinkedHashMap r4 = new LinkedHashMap();
        x.c(r4, r3);
        boolean r5 = true;
        j0.l().sendLog("livesdk_anchor_audience_connection_avatar_entrance_click", r4, new Object[]{IRoom.class});
        if ((r12 instanceof FragmentActivity) == true) goto L15;
        return;
    L15:
        if (((Boolean) b6.s.getValue()).booleanValue() == true) goto L17;
        DigitAvatarContext.a r6 = DigitAvatarContext.Companion;
        DigitAvatarContext r7 = r6.getContext();
        if (r7 == null) goto L23;
        VideoShowMode r8 = r7.getCurrentVideoShowMode();
    L24:
        VideoShowMode r9 = VideoShowMode.DIGIT_AVATAR;
        if (r8 == r9) goto L28;
        r5 = false;
    L28:
        if (r5 == true) goto L33;
        DigitAvatarContext r13 = r6.getContext();
        if (r13 == null) goto L33;
        DigitAvatarContext.setVideoShowMode$default(r13, r9, null, 2, null);
    L33:
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 4) == false) goto L35;
        f2.c(s1.B(2131917588), 0);
        return;
    L35:
        int r0 = DigitAvatarEmojiDialog.n;
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r1, "dataCenter");
        Intrinsics.checkNotNullParameter("virtual", "requestPage");
        DigitAvatarEmojiDialog r14 = new DigitAvatarEmojiDialog(r12, r1);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L39:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        return;
    L23:
        r8 = null;
        goto L24
    L17:
        if (gd0.v.a(((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode(), 4) == false) goto L19;
        f2.c(s1.B(2131917588), 0);
        return;
    L19:
        int r15 = m.a;
        m.a(r12, r12.getSupportFragmentManager(), r1, false, null);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = null;
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = r3;
    }
}
