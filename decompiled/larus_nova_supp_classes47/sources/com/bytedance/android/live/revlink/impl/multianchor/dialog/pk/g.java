package com.bytedance.android.live.revlink.impl.multianchor.dialog.pk;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKSearchFragment;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.android.livesdk.link.model.l8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ MultiAnchorTeamPkUserInviteDialog a;

    public g(MultiAnchorTeamPkUserInviteDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r12) {
        MultiAnchorTeamPkUserInviteDialog r13 = this.a;
        int r0 = MultiAnchorTeamPkUserInviteDialog.u;
        l8 r1 = (l8) r13.T90().getSearchBar().getValue();
        String r2 = "";
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.a() == false) goto L6;
        String r3 = "pk_participate";
    L9:
        DataCenter r4 = r13.e;
        int r5 = RevLinkDialog.x;
        RevLinkDialog r6 = new RevLinkDialog.a(r4, r13).a();
        int r7 = InteractPKSearchFragment.n;
        DataCenter r8 = r13.e;
        Integer r9 = null;
        if (r1 == null) goto L12;
        String r10 = r1.getContent();
    L13:
        r6.f = InteractPKSearchFragment.a.a(r6, r8, r10, r13.i, true, new u(SearchSourceFlag.INVITE_LINKING, r3));
        FragmentActivity r14 = r13.getContext();
        if (r14 == null) goto L45;
        FragmentManager r15 = r14.getSupportFragmentManager();
        LandscapeRestrictionOperation r16 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r6, "LinkDialog", r16);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r15, r6, r16) == false) goto L47;
    L20:
        HashMap r17 = new HashMap();
        LinkCrossRoomDataHolder r18 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r18 == null) goto L23;
        Long r19 = Long.valueOf(r18.c());
    L24:
        r17.put("channel_id", String.valueOf(r19));
        w31.c r20 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r20 == null) goto L27;
        Long r22 = Long.valueOf(r20.i());
    L28:
        r17.put("pk_id", String.valueOf(r22));
        if (r13.T90().getCurrentScene() != 1) goto L31;
        r9 = 2;
    L36:
        r17.put("anchor_connect_status", String.valueOf(r9));
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r110 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r110 == null) goto L42;
        String r111 = r110.a;
        if (r111 == null) goto L42;
        r2 = r111;
    L42:
        r17.put("source", r2);
        r17.put("enter_button", "team");
        mz0.n r112 = new mz0.n();
        Map<String, String> r23 = r112.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r17, "map");
        r23.putAll(r17);
        mz0.m r24 = new mz0.m();
        r24.b(LogCommon.ROOM);
        ((ArrayList) r112.b).addAll(r24.a);
        cy0.e.a.getClass();
        cy0.j r25 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r26 = com.bytedance.android.scope.m.b(r25).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r26);
        ((mz0.i) ((f80.a) r26)).w3("livesdk_connection_tab_search_click", r112.a, r112.b);
        return;
    L31:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r113 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r113 == null) goto L36;
        i11.b r114 = r113.getLinkUserCenter();
        if (r114 == null) goto L36;
        r9 = Integer.valueOf(r114.c());
        goto L36
    L27:
        r22 = null;
        goto L28
    L23:
        r19 = null;
        goto L24
    L47:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L46
    L19:
        r6.show(r15, "LinkDialog");
        goto L20
    L45:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L12:
        r10 = null;
        goto L13
    L6:
        if (y.b() == false) goto L8;
        r3 = "link_participate";
        goto L9
    L8:
        r3 = "";
        goto L9
    }
}
