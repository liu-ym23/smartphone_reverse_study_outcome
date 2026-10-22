package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
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
public final class c implements View.OnClickListener {
    public final /* synthetic */ InteractVoteStartDialog a;

    public static final class a implements InteractVoteThemeBinder.b {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revlink.impl.pk.vote.InteractVoteThemeBinder.b
        public final void s80(InteractVoteStartDialog.b r6) {
            Intrinsics.checkNotNullParameter(r6, "themeData");
            InteractVoteStartDialog r0 = this.a.a;
            r0.g = r6;
            TextView r7 = (TextView) r0.S90(2131391578);
            InteractVoteStartDialog.b r1 = r0.g;
            if (r1 == null) goto L7;
            String r2 = r1.b;
            if (r2 == null) goto L7;
        L8:
            r7.setText(r2);
            InteractVoteStartDialog.b r8 = this.a.a.g;
            if (r8 == null) goto L20;
            Long r9 = Long.valueOf(r8.a);
            if (r9.longValue() < 0) goto L13;
            boolean r3 = true;
        L14:
            if (r3 == true) goto L17;
            r9 = null;
        L17:
            if (r9 == null) goto L21;
            l51.a.G(r9.longValue());
            return;
        L21:
            return;
        L13:
            r3 = false;
            goto L14
        L20:
            return;
        L7:
            r2 = "";
            goto L8
        }
    }

    public c(InteractVoteStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        InteractVoteThemeSelectDialog r6 = new InteractVoteThemeSelectDialog();
        InteractVoteStartDialog r0 = this.a;
        r6.e = r0.f;
        r6.f = r0.g;
        r6.i = new a(this);
        p8.a(r6, r0.getContext());
        InteractVoteStartDialog r7 = this.a;
        r7.getClass();
        HashMap r1 = new HashMap();
        String r2 = "";
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L5;
        String r3 = "2";
    L14:
        r1.put("anchor_connect_status", r3);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L17;
        String r4 = "pk_participate";
    L18:
        r1.put("source", r4);
        InteractVoteStartDialog.b r8 = r7.g;
        if (r8 == null) goto L24;
        String r9 = r8.b;
        if (r9 == null) goto L24;
        r2 = r9;
    L24:
        r1.put(FileUtils.PICTURE_THEME, r2);
        int r10 = UserListInviteType.a;
        LinkCrossRoomDataHolder r12 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r12 == null) goto L27;
        int r13 = r12.f();
    L28:
        r1.put("invitee_list", UserListInviteType.a(r13, null));
        n r14 = new n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r15.putAll(r1);
        m r16 = new m();
        LinkCrossRoomDataHolder.a r17 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r16);
        r16.b(LogCommon.ROOM);
        List<Object> r18 = r14.b;
        ArrayList r19 = (ArrayList) r18;
        r19.addAll(r16.a);
        cy0.e.a.getClass();
        j r20 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r22 = com.bytedance.android.scope.m.b(r20).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r22);
        ((mz0.i) ((f80.a) r22)).w3("livesdk_vote_theme_setting_button_click", r14.a, r14.b);
        return;
    L27:
        r13 = 0;
        goto L28
    L17:
        r4 = "link_participate";
        goto L18
    L5:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r23 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r23 == null) goto L13;
        i11.b r24 = r23.getLinkUserCenter();
        if (r24 == null) goto L13;
        List<p> r25 = r24.getOnlineUserList();
        if (r25 == null) goto L13;
        r3 = String.valueOf(r25.size());
        if (r3 != null) goto L14;
    L13:
        r3 = "";
        goto L14
    }
}
