package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.saas.middleware.store.FileUtils;
import com.bytedance.android.livesdk.chatroom.interact.model.h0;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends FrameLayout {
    public Map<Integer, View> a;
    public final IRoom b;
    public h41.g c;

    public final h41.g getLogger() {
        return this.c;
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final void setLogger(h41.g r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public b(Context r6, IRoom r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        super(r6);
        this.a = new LinkedHashMap();
        this.b = r7;
        com.bytedance.android.live.revlink.impl.global.b.j();
        this.c = new h41.g(r7);
        boolean r0 = true;
        LayoutInflater.from(getContext()).inflate(2131567806, this, true);
        com.bytedance.android.live.revlink.impl.pk.service.a r9 = com.bytedance.android.live.revlink.impl.global.b.M();
        long r1 = 0;
        if (r9 == null) goto L7;
        h0 r10 = r9.d();
        if (r10 == null) goto L7;
        r10.c = 0;
    L7:
        com.bytedance.android.live.revlink.impl.pk.service.a r12 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r12 == null) goto L12;
        h0 r13 = r12.d();
        if (r13 == null) goto L12;
        r13.b = System.currentTimeMillis();
    L12:
        i41.a r14 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r14 == null) goto L17;
        if (r7 == null) goto L16;
        r1 = r7.getId();
    L16:
        i41.a.e(r14, r1, false);
    L17:
        IPKLinkBizDataService r15 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r15 == null) goto L20;
        r15.setIsRandomReMatch(true);
    L20:
        ((Button) a(2131365114)).setOnClickListener(new a(this));
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(a(2131362934), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp");
        HashMap r16 = new HashMap();
        r16.put("is_oncemore", DataType.FALSE);
        r16.put("connection_type", "random_pk");
        r16.put("pk_description", "routine");
        p11.h r17 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        String r2 = null;
        if (r17 == null) goto L23;
        String r18 = r17.getInviteMode();
    L24:
        if (r18 != null) goto L26;
    L29:
        boolean r3 = true;
    L30:
        if (r3 == false) goto L33;
        r18 = "routine_pk";
    L33:
        r16.put("invite_mode", r18);
        p11.h r19 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r19 == null) goto L36;
        String r20 = r19.getTheme();
    L37:
        if (r20 != null) goto L39;
    L42:
        boolean r4 = true;
    L43:
        if (r4 == true) goto L45;
        r16.put(FileUtils.PICTURE_THEME, r20);
    L45:
        String r5 = "";
        r16.put("pk_activity_type", "");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r22 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r22 == null) goto L48;
        r5 = r22.a();
    L48:
        r16.put("from_room_status", r5);
        IPKLinkBizDataService r23 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r23 == null) goto L51;
        r2 = IPKLinkBizDataService.b.a(r23, null);
    L51:
        if (r2 != null) goto L53;
    L56:
        if (r0 == true) goto L58;
        r16.put("transform_reason", r2);
    L58:
        mz0.n r24 = new mz0.n();
        Map<String, String> r25 = r24.a;
        Intrinsics.checkNotNullParameter(r25, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r25.putAll(r16);
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
        ((mz0.i) ((f80.a) r32)).w3("connection_invite", r24.a, r24.b);
        return;
    L53:
        if (r2.length() == 0) goto L56;
        r0 = false;
        goto L56
    L39:
        if (r20.length() == 0) goto L42;
        r4 = false;
        goto L43
    L36:
        r20 = null;
        goto L37
    L26:
        if (r18.length() == 0) goto L29;
        r3 = false;
        goto L30
    L23:
        r18 = null;
        goto L24
    }
}
