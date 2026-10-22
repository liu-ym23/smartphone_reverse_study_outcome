package com.bytedance.android.live.livepkaudience.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ PkAdminInviteFragment a;

    public c(PkAdminInviteFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        this.a.getClass();
        LinkedHashMap r10 = new LinkedHashMap();
        el0.j.m(r10);
        el0.j.k(r10);
        el0.j.n(r10, Integer.valueOf(dl0.n.a()));
        r10.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
        boolean r1 = true;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_link_setting_click", r10, new Object[]{Room.class});
        Room r11 = jc1.k.n(IRoomService.class).getCurrentRoom();
        if (r11 == null) goto L23;
        PkAdminInviteFragment r0 = this.a;
        Context r2 = r0.getContext();
        if (r2 == null) goto L12;
        FragmentActivity r4 = this.a.getActivity();
        PkAdminInviteFragment r5 = this.a;
        boolean r6 = r5.k;
        DataCenter r7 = r5.o;
        if (r7 == null) goto L11;
        Boolean r8 = (Boolean) r7.get("data_is_portrait", Boolean.TRUE);
        if (r8 == null) goto L11;
        r1 = r8.booleanValue();
    L11:
        int r12 = this.a.r;
        PkWithAudienceSettingDialog r3 = new PkWithAudienceSettingDialog(r11, r2, r4, r1);
    L13:
        r0.l = r3;
        PkWithAudienceSettingDialog r13 = this.a.l;
        if (r13 != null) goto L16;
    L20:
        k0 r14 = this.a.d;
        if (r14 == null) goto L23;
        r14.dismiss();
        goto L23
    L16:
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L29;
        DialogLancet.handleBlockedDialogShow(r13);
        goto L20
    L29:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L19:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        goto L20
    L12:
        r3 = null;
    L23:
        ViewGroup r15 = this.a.h;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L26:
        r15.findViewById(2131385981).setVisibility(8);
    }
}
