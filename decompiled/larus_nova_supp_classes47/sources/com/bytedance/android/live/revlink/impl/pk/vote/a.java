package com.bytedance.android.live.revlink.impl.pk.vote;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.link.model.aa;
import com.bytedance.android.livesdk.link.model.f9;
import com.bytedance.android.livesdk.link.model.p;
import com.bytedance.android.livesdk.link.model.z0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cy0.j;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.m;
import mz0.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ InteractVoteStartDialog a;

    public a(InteractVoteStartDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        InteractVoteStartDialog r0 = this.a;
        z0 r13 = (z0) ((ExtraResponse) r12).data;
        if (r13 == null) goto L7;
        f9 r14 = r13.getSelfConfig();
        if (r14 == null) goto L7;
        List<? extends aa> r15 = r14.getVoteConfig();
    L8:
        r0.f = r15;
        InteractVoteStartDialog r16 = this.a;
        r16.getClass();
        long r2 = l51.a.g();
        String r1 = "";
        long r4 = 0;
        if (r2 == 0) goto L21;
        List<? extends aa> r6 = r16.f;
        if (r6 == null) goto L21;
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L21;
        aa r8 = (aa) r7.next();
        if (r2 != r8.getVoteType()) goto L14;
        long r9 = r8.getVoteType();
        String r10 = r8.getVoteDes();
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        r16.g = new InteractVoteStartDialog.b(r9, r10);
    L21:
        int r3 = 0;
        if (r16.g != null) goto L42;
        List<? extends aa> r5 = r16.f;
        if (r5 == null) goto L26;
        int r17 = r5.size();
    L27:
        if (r17 <= 0) goto L41;
        List<? extends aa> r18 = r16.f;
        if (r18 == null) goto L33;
        aa r19 = (aa) ListProtector.get(r18, 0);
        if (r19 == null) goto L33;
        r4 = r19.getVoteType();
    L33:
        List<? extends aa> r20 = r16.f;
        if (r20 == null) goto L39;
        aa r22 = (aa) ListProtector.get(r20, 0);
        if (r22 == null) goto L39;
        String r23 = r22.getVoteDes();
        if (r23 == null) goto L39;
    L40:
        r16.g = new InteractVoteStartDialog.b(r4, r23);
    L39:
        r23 = "";
        goto L40
    L41:
        r16.g = new InteractVoteStartDialog.b(0, s1.B(2131918094));
        goto L42
    L26:
        r17 = 0;
    L42:
        TextView r24 = (TextView) r16.S90(2131391578);
        InteractVoteStartDialog.b r25 = r16.g;
        if (r25 == null) goto L47;
        String r26 = r25.b;
        if (r26 == null) goto L47;
    L48:
        r24.setText(r26);
        HashMap r27 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L51;
        String r28 = "2";
    L60:
        r27.put("anchor_connect_status", r28);
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.b() == false) goto L64;
        String r29 = "pve_participate";
    L67:
        r27.put("source", r29);
        InteractVoteStartDialog.b r110 = r16.g;
        if (r110 == null) goto L73;
        String r111 = r110.b;
        if (r111 == null) goto L73;
        r1 = r111;
    L73:
        r27.put(FileUtils.PICTURE_THEME, r1);
        int r112 = UserListInviteType.a;
        LinkCrossRoomDataHolder r113 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r113 == null) goto L76;
        r3 = r113.f();
    L76:
        r27.put("invitee_list", UserListInviteType.a(r3, null));
        n r114 = new n();
        Map<String, String> r30 = r114.a;
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r27, "map");
        r30.putAll(r27);
        m r32 = new m();
        LinkCrossRoomDataHolder.a r33 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r32);
        r32.b(LogCommon.ROOM);
        ((ArrayList) r114.b).addAll(r32.a);
        cy0.e.a.getClass();
        j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((mz0.i) ((f80.a) r35)).w3("livesdk_vote_setting_panel_show", r114.a, r114.b);
        return;
    L64:
        if (com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.d.c() == false) goto L66;
        r29 = "pk_participate";
        goto L67
    L66:
        r29 = "link_participate";
        goto L67
    L51:
        com.bytedance.android.live.revlink.impl.multianchor.service.d r36 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r36 == null) goto L59;
        i11.b r37 = r36.getLinkUserCenter();
        if (r37 == null) goto L59;
        List<p> r38 = r37.getOnlineUserList();
        if (r38 == null) goto L59;
        r28 = String.valueOf(r38.size());
        if (r28 != null) goto L60;
    L59:
        r28 = "";
    L47:
        r26 = "";
    L7:
        r15 = null;
        goto L8
    }
}
