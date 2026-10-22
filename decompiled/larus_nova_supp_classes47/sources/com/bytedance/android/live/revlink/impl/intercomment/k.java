package com.bytedance.android.live.revlink.impl.intercomment;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.Widget;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ InteractCommentWidget a;

    public k(InteractCommentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r14) {
        Integer r15 = (Integer) r14;
        String r4 = "pk";
        Long r6 = null;
        if (r15 != null) goto L6;
    L26:
        int r9 = 2131251947;
        if (r15 != null) goto L30;
    L53:
        if (r15 != null) goto L56;
        return;
    L56:
        if (r15.intValue() != 0) goto L72;
        InteractCommentWidget r16 = this.a;
        int r0 = InteractCommentWidget.n;
        InteractCommentView r17 = r16.wq();
        if (r17 == null) goto L64;
        boolean r1 = !this.a.e;
        HSImageView r18 = r17.a(2131375499);
        if (r1 == true) goto L63;
        r9 = 2131251942;
    L63:
        ImageLoader.bindDrawableResource(r18, r9);
    L64:
        this.a.yq(false);
        return;
    L72:
        return;
    L30:
        if (r15.intValue() != 4) goto L53;
        this.a.i = System.currentTimeMillis();
        InteractCommentView r19 = this.a.wq();
        if (r19 == null) goto L38;
        boolean r12 = !this.a.e;
        HSImageView r110 = r19.a(2131375499);
        if (r12 == true) goto L37;
        r9 = 2131251945;
    L37:
        ImageLoader.bindDrawableResource(r110, r9);
    L38:
        this.a.yq(false);
        InteractCommentWidget r111 = this.a;
        if (r111.e == false) goto L52;
        e r112 = r111.h;
        r112.getClass();
        HashMap r8 = new HashMap();
        if (r112.b == 1) goto L44;
        r4 = "connection";
    L44:
        r8.put("connection_scene", r4);
        LinkCrossRoomDataHolder r3 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r3 == null) goto L47;
        Long r5 = Long.valueOf(r3.c());
    L48:
        r8.put("channel_id", String.valueOf(r5));
        w31.c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r2 == null) goto L51;
        r6 = Long.valueOf(r2.i());
    L51:
        r8.put("pk_id", String.valueOf(r6));
        r112.a(r8);
        mz0.n r113 = new mz0.n();
        Map<String, String> r7 = r113.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r7.putAll(r8);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        ((ArrayList) r113.b).addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((mz0.i) ((f80.a) r20)).w3("livesdk_comment_interflow_start", r113.a, r113.b);
        goto L52
    L47:
        r5 = null;
    L52:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).W9();
        return;
    L6:
        if (r15.intValue() != 2) goto L26;
        InteractCommentWidget r114 = this.a;
        if (r114.e == false) goto L69;
        InteractCommentBeInviteDialog r22 = new InteractCommentBeInviteDialog(((Widget) r114).context, new n(r114));
        if (DialogLancet.shouldBlockDialogShow(r22) == false) goto L67;
        DialogLancet.handleBlockedDialogShow(r22);
    L14:
        e r115 = this.a.h;
        r115.getClass();
        HashMap r23 = new HashMap();
        if (r115.b == 1) goto L18;
        r4 = "connection";
    L18:
        r23.put("connection_scene", r4);
        LinkCrossRoomDataHolder r24 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r24 == null) goto L21;
        Long r25 = Long.valueOf(r24.c());
    L22:
        r23.put("channel_id", String.valueOf(r25));
        w31.c r26 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r26 == null) goto L25;
        r6 = Long.valueOf(r26.i());
    L25:
        r23.put("pk_id", String.valueOf(r6));
        r115.a(r23);
        mz0.n r116 = new mz0.n();
        Map<String, String> r27 = r116.a;
        Intrinsics.checkNotNullParameter(r27, "map");
        Intrinsics.checkNotNullParameter(r23, "map");
        r27.putAll(r23);
        mz0.m r28 = new mz0.m();
        r28.b(LogCommon.ROOM);
        ((ArrayList) r116.b).addAll(r28.a);
        cy0.e.a.getClass();
        cy0.j r29 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r30 = com.bytedance.android.scope.m.b(r29).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r30);
        ((mz0.i) ((f80.a) r30)).w3("livesdk_comment_interflow_recieve", r116.a, r116.b);
        return;
    L21:
        r25 = null;
        goto L22
    L67:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L66
    L13:
        DialogLancet.beforeDialogShow(r22);
        r22.show();
        DialogLancet.afterDialogShow(r22);
        goto L14
    }
}
