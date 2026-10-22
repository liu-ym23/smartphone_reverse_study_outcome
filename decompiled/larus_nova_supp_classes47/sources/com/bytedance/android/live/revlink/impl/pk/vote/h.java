package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import cy0.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ InteractVoteThemeSelectDialog a;

    public h(InteractVoteThemeSelectDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        InteractVoteThemeSelectDialog r6 = this.a;
        InteractVoteStartDialog.b r0 = r6.g;
        if (r0 == null) goto L7;
        InteractVoteThemeBinder.b r7 = r6.i;
        if (r7 == null) goto L7;
        r7.s80(r0);
    L7:
        InteractVoteThemeSelectDialog r8 = this.a;
        r8.getClass();
        HashMap r1 = new HashMap();
        String r2 = "";
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L10;
        String r3 = "2";
    L19:
        r1.put("anchor_connect_status", r3);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.b() == false) goto L23;
        String r4 = "pve_participate";
    L26:
        r1.put("source", r4);
        InteractVoteStartDialog.b r9 = r8.g;
        if (r9 == null) goto L32;
        String r10 = r9.b;
        if (r10 == null) goto L32;
        r2 = r10;
    L32:
        r1.put(FileUtils.PICTURE_THEME, r2);
        int r12 = UserListInviteType.a;
        LinkCrossRoomDataHolder r13 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r13 == null) goto L35;
        int r14 = r13.f();
    L36:
        r1.put("invitee_list", UserListInviteType.a(r14, null));
        n r15 = new n();
        Map<String, String> r16 = r15.a;
        Intrinsics.checkNotNullParameter(r16, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r16.putAll(r1);
        m r17 = new m();
        LinkCrossRoomDataHolder.a r18 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r17);
        r17.b(LogCommon.ROOM);
        List<Object> r19 = r15.b;
        ArrayList r20 = (ArrayList) r19;
        r20.addAll(r17.a);
        cy0.e.a.getClass();
        j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((mz0.i) ((f80.a) r23)).w3("livesdk_vote_theme_setting_panel_click", r15.a, r15.b);
        this.a.dismiss();     // Catch: Exception -> L39
        return;
    L39:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r24 = DialogFragmentLancet.sLastShowStack;
        if (r24 == null) goto L46;
        com.bytedance.crash.d.d(r24, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L46:
        return;
    L35:
        r14 = 0;
        goto L36
    L23:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L25;
        r4 = "pk_participate";
        goto L26
    L25:
        r4 = "link_participate";
        goto L26
    L10:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r25 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r25 == null) goto L18;
        i11.b r26 = r25.getLinkUserCenter();
        if (r26 == null) goto L18;
        List<p> r27 = r26.getOnlineUserList();
        if (r27 == null) goto L18;
        r3 = String.valueOf(r27.size());
        if (r3 != null) goto L19;
    L18:
        r3 = "";
        goto L19
    }
}
