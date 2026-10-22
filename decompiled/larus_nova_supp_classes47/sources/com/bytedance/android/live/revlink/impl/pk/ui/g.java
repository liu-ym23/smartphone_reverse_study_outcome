package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends FrameLayout {
    public Map<Integer, View> a;
    public final IRoom b;

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

    public g(Context r10, IRoom r12, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r13, "dataCenter");
        super(r10);
        this.a = new LinkedHashMap();
        this.b = r12;
        LayoutInflater.from(getContext()).inflate(2131567805, this);
        ((Button) a(2131372572)).setOnClickListener(new c(this));
        String r0 = null;
        boolean r14 = false;
        if (((Number) l51.a.h0.getValue(null, l51.a.a[69])).intValue() != 0) goto L5;
        ((LinearLayout) a(2131374838)).setVisibility(0);
        ((FrameLayout) a(2131379712)).setVisibility(8);
    L61:
        ((Button) a(2131384217)).setOnClickListener(new d(this));
        ((Button) a(2131372574)).setOnClickListener(new e(this));
        ((LinearLayout) a(2131383718)).setOnClickListener(new f(this));
        return;
    L5:
        IPKLinkBizDataService r15 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r15 == null) goto L8;
        r15.setIsRandomReMatch(true);
    L8:
        com.bytedance.android.live.revlink.impl.pk.service.a r16 = com.bytedance.android.live.revlink.impl.global.b.M();
        long r5 = 0;
        if (r16 == null) goto L13;
        h0 r17 = r16.d();
        if (r17 == null) goto L13;
        r17.c = 0;
    L13:
        com.bytedance.android.live.revlink.impl.pk.service.a r18 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r18 == null) goto L18;
        h0 r19 = r18.d();
        if (r19 == null) goto L18;
        r19.b = System.currentTimeMillis();
    L18:
        i41.a r110 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r110 == null) goto L23;
        if (r12 == null) goto L22;
        r5 = r12.getId();
    L22:
        i41.a.e(r110, r5, false);
    L23:
        ((LinearLayout) a(2131374838)).setVisibility(8);
        ((FrameLayout) a(2131379712)).setVisibility(0);
        com.bytedance.android.live.revlink.impl.pk.utils.w.a(a(2131362934), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp");
        com.bytedance.android.live.revlink.impl.global.b.j();
        h41.g.c("reinvite");
        HashMap r111 = new HashMap();
        r111.put("is_oncemore", DataType.FALSE);
        r111.put("connection_type", "random_pk");
        r111.put("pk_description", "routine");
        p11.h r112 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r112 == null) goto L26;
        String r113 = r112.getInviteMode();
    L27:
        if (r113 != null) goto L29;
    L32:
        boolean r1 = true;
    L33:
        if (r1 == false) goto L36;
        r113 = "routine_pk";
    L36:
        r111.put("invite_mode", r113);
        p11.h r114 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r114 == null) goto L39;
        String r115 = r114.getTheme();
    L40:
        if (r115 != null) goto L42;
    L45:
        boolean r2 = true;
    L46:
        if (r2 == true) goto L48;
        r111.put(FileUtils.PICTURE_THEME, r115);
    L48:
        String r3 = "";
        r111.put("pk_activity_type", "");
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r116 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r116 == null) goto L51;
        r3 = r116.a();
    L51:
        r111.put("from_room_status", r3);
        IPKLinkBizDataService r117 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r117 == null) goto L54;
        r0 = IPKLinkBizDataService.b.a(r117, null);
    L54:
        if (r0 != null) goto L56;
    L57:
        r14 = true;
    L58:
        if (r14 == true) goto L60;
        r111.put("transform_reason", r0);
    L60:
        mz0.n r118 = new mz0.n();
        Map<String, String> r119 = r118.a;
        Intrinsics.checkNotNullParameter(r119, "map");
        Intrinsics.checkNotNullParameter(r111, "map");
        r119.putAll(r111);
        mz0.m r120 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.h r121 = vh6.c.b(kr2.a.class).be();
        Intrinsics.checkNotNullParameter(r121, "linkInfoLog");
        am2.m r122 = r121.a;
        r122.i = 300;
        ((ArrayList) r120.a).add(r122);
        LinkCrossRoomDataHolder.a r123 = LinkCrossRoomDataHolder.c;
        com.bytedance.android.live.revlink.impl.a.b(r120);
        r120.b(LogCommon.ROOM);
        ((ArrayList) r118.b).addAll(r120.a);
        cy0.e.a.getClass();
        cy0.j r124 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r125 = com.bytedance.android.scope.m.b(r124).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r125);
        ((mz0.i) ((f80.a) r125)).w3("connection_invite", r118.a, r118.b);
        goto L61
    L56:
        if (r0.length() != 0) goto L58;
    L42:
        if (r115.length() == 0) goto L45;
        r2 = false;
        goto L46
    L39:
        r115 = null;
        goto L40
    L29:
        if (r113.length() == 0) goto L32;
        r1 = false;
        goto L33
    L26:
        r113 = null;
        goto L27
    }
}
