package com.bytedance.android.live.revlink.impl.intercomment;

import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements InteractCommentBeInviteDialog.a {
    public final /* synthetic */ InteractCommentWidget a;

    @Override // com.bytedance.android.live.revlink.impl.intercomment.InteractCommentBeInviteDialog.a
    public final void a() {
        InteractCommentWidget r0 = this.a;
        int r1 = InteractCommentWidget.n;
        r0.getClass();
        String r2 = s41.b.c.a().b();
        if (TextUtils.isEmpty(r2) == true) goto L5;
        zz0.h.b(((Widget) r0).context, r2);
    L5:
        this.a.h.c(false);
    }

    public n(InteractCommentWidget r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.revlink.impl.intercomment.InteractCommentBeInviteDialog.a
    public final void b(int r8, boolean r9) {
        InteractCommentDataContext r0 = this.a.a;
        if (r0 == null) goto L5;
        r0.reply(r8, r9);
    L5:
        InteractCommentWidget r1 = this.a;
        if (r1.e == false) goto L31;
        e r2 = r1.h;
        r2.getClass();
        HashMap r3 = new HashMap();
        if (r2.b != 1) goto L10;
        String r4 = "pk";
    L11:
        r3.put("connection_scene", r4);
        LinkCrossRoomDataHolder r5 = com.bytedance.android.live.revlink.impl.global.b.j();
        Long r6 = null;
        if (r5 == null) goto L14;
        Long r7 = Long.valueOf(r5.c());
    L15:
        r3.put("channel_id", String.valueOf(r7));
        w31.c r10 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r10 == null) goto L18;
        r6 = Long.valueOf(r10.i());
    L18:
        r3.put("pk_id", String.valueOf(r6));
        if (r8 != 1) goto L22;
        String r12 = "agree";
    L25:
        r3.put("result", r12);
        if (r9 == false) goto L28;
        String r13 = DataType.TRUE;
    L29:
        r3.put("is_no_more_recieve", r13);
        r2.a(r3);
        mz0.n r14 = new mz0.n();
        Map<String, String> r15 = r14.a;
        Intrinsics.checkNotNullParameter(r15, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r15.putAll(r3);
        mz0.m r16 = new mz0.m();
        r16.b(LogCommon.ROOM);
        ((ArrayList) r14.b).addAll(r16.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((mz0.i) ((f80.a) r18)).w3("livesdk_comment_interflow_invite_handle", r14.a, r14.b);
        return;
    L28:
        r13 = DataType.FALSE;
        goto L29
    L22:
        if (r8 != 3) goto L24;
        r12 = "refuse_time_up";
        goto L25
    L24:
        r12 = "refuse_click";
        goto L25
    L14:
        r7 = null;
        goto L15
    L10:
        r4 = "connection";
        goto L11
    }
}
