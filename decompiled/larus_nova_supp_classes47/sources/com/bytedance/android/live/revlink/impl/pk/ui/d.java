package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ g a;

    public d(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        IPKLinkBizDataService r9 = com.bytedance.android.live.revlink.impl.global.b.P();
        boolean r0 = true;
        if (r9 == null) goto L5;
        r9.setIsRandomReMatch(true);
    L5:
        com.bytedance.android.live.revlink.impl.pk.service.a r10 = com.bytedance.android.live.revlink.impl.global.b.M();
        long r1 = 0;
        if (r10 == null) goto L10;
        h0 r12 = r10.d();
        if (r12 == null) goto L10;
        r12.c = 0;
    L10:
        com.bytedance.android.live.revlink.impl.pk.service.a r13 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r13 == null) goto L15;
        h0 r14 = r13.d();
        if (r14 == null) goto L15;
        r14.b = System.currentTimeMillis();
    L15:
        i41.a r15 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r15 == null) goto L21;
        IRoom r4 = this.a.b;
        if (r4 == null) goto L20;
        r1 = r4.getId();
    L20:
        i41.a.e(r15, r1, false);
    L21:
        ((LinearLayout) this.a.a(2131374838)).setVisibility(8);
        ((FrameLayout) this.a.a(2131379712)).setVisibility(0);
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(this.a.a(2131362934), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp");
        IRoom r16 = this.a.b;
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.c("reinvite");
        Integer r2 = null;
        if (this.a.a(2131383716).isChecked() == false) goto L24;
        l51.a.h0.setValue(null, l51.a.a[69], 2);
    L24:
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r17 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r17 == null) goto L27;
        Intrinsics.checkNotNullParameter("pk_banner", "<set-?>");
        r17.c = "pk_banner";
    L27:
        HashMap r18 = new HashMap();
        r18.put("is_oncemore", DataType.FALSE);
        r18.put("connection_type", "random_pk");
        r18.put("pk_description", "routine");
        p11.h r3 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r3 == null) goto L30;
        String r5 = r3.getInviteMode();
    L31:
        if (r5 != null) goto L33;
    L36:
        boolean r6 = true;
    L37:
        if (r6 == false) goto L40;
        r5 = "routine_pk";
    L40:
        r18.put("invite_mode", r5);
        p11.h r7 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r7 == null) goto L43;
        String r19 = r7.getTheme();
    L44:
        if (r19 != null) goto L46;
    L49:
        boolean r20 = true;
    L50:
        if (r20 == true) goto L52;
        r18.put(FileUtils.PICTURE_THEME, r19);
    L52:
        r18.put("pk_activity_type", "");
        IPKLinkBizDataService r22 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r22 == null) goto L55;
        String r23 = IPKLinkBizDataService.b.a(r22, null);
    L56:
        if (r23 != null) goto L58;
    L61:
        if (r0 == true) goto L63;
        r18.put("transform_reason", r23);
    L63:
        r18.put("source", "restart");
        r18.put("connection_sub_type", "");
        r18.put("anchor_connect_status", DataType.FALSE);
        r18.put("room_status", "live");
        r18.put("is_rematch", DataType.TRUE);
        if (com.bytedance.android.live.revlink.impl.global.b.c0() == null) goto L66;
        r2 = Integer.valueOf(n41.a.b());
    L66:
        r18.put("audience_connect_cnt", String.valueOf(r2));
        mz0.n r24 = new mz0.n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r18, "map");
        r25.putAll(r18);
        mz0.m r26 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r27 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r27, "linkInfoLog");
        am2.m r28 = r27.a;
        r28.i = 300;
        ((ArrayList) r26.a).add(r28);
        LinkCrossRoomDataHolder.a r29 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r26);
        r26.b(LogCommon.ROOM);
        ((ArrayList) r24.b).addAll(r26.a);
        cy0.e.a.getClass();
        cy0.j r30 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("random_match", r24.a, r24.b);
        return;
    L58:
        if (r23.length() == 0) goto L61;
        r0 = false;
        goto L61
    L55:
        r23 = null;
        goto L56
    L46:
        if (r19.length() == 0) goto L49;
        r20 = false;
        goto L50
    L43:
        r19 = null;
        goto L44
    L33:
        if (r5.length() == 0) goto L36;
        r6 = false;
        goto L37
    L30:
        r5 = null;
        goto L31
    }
}
