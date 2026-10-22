package com.bytedance.android.live.revlink.impl.multianchor.profit;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.livesdk.link.model.b8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.live.datacontext.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final com.bytedance.android.livesdk.revenue.service.room.c a;
    public final com.bytedance.android.live.revlink.impl.global.c b;

    public final String a() {
        com.bytedance.android.livesdk.revenue.service.room.c r0 = this.a;
        List r1 = null;
        if (r0 == null) goto L12;
        com.bytedance.android.livesdk.revenue.room.a r2 = r0.getRoomContext();
        if (r2 == null) goto L12;
        IRoomBase r3 = r2.getCommonRoom();
        if (r3 == null) goto L12;
        IBaseUser r4 = r3.getOwnerKt();
        if (r4 == null) goto L12;
        Object r5 = r4.getIdString();
        if (r5 == null) goto L12;
    L27:
        com.bytedance.android.live.revlink.impl.global.c r6 = this.b;
        if (r6 == null) goto L30;
        ProfitInteractionDataContext r7 = r6.vj();
    L31:
        if (r7 == null) goto L35;
        n<Map<String, b8>> r8 = r7.getMultiAnchorData();
        if (r8 == null) goto L35;
        Map r9 = (Map) r8.getValue();
    L36:
        if (r9 == null) goto L49;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r12 = r9.entrySet().iterator();
    L39:
        if (r12.hasNext() == false) goto L43;
        Map.Entry r13 = (Map.Entry) r12.next();
        if ((!Intrinsics.areEqual((String) r13.getKey(), r5)) == false) goto L39;
        r10.put(r13.getKey(), r13.getValue());
        goto L39
    L43:
        ArrayList r14 = new ArrayList(r10.size());
        Iterator r15 = r10.entrySet().iterator();
    L45:
        if (r15.hasNext() == false) goto L47;
        r14.add(((b8) ((Map.Entry) r15.next()).getValue()).getScoreStr());
        goto L45
    L47:
        r1 = r14;
    L49:
        if (r1 != null) goto L52;
        r1 = CollectionsKt.emptyList();
    L52:
        return new JSONArray(r1).toString();
    L35:
        r9 = null;
        goto L36
    L30:
        r7 = null;
    L12:
        com.bytedance.android.livesdk.revenue.service.room.c r16 = this.a;
        if (r16 == null) goto L17;
        com.bytedance.android.livesdk.revenue.room.a r17 = r16.getRoomContext();
        if (r17 == null) goto L17;
        boolean r18 = r17.getCommonIsAnchor();
    L18:
        if (r18 == false) goto L26;
        com.bytedance.android.live.revlink.impl.global.c r19 = this.b;
        if (r19 == null) goto L22;
        s r20 = r19.getRevLinkCommonUtil();
    L23:
        if (r20 == null) goto L25;
        r5 = r20.e();
        goto L27
    L25:
        r5 = null;
        goto L27
    L22:
        r20 = null;
        goto L23
    L26:
        r5 = 0;
    L17:
        r18 = false;
        goto L18
    }

    public final void b(Map<String, String> r5) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.b;
        LinkCrossRoomDataHolder r1 = null;
        if (r0 == null) goto L5;
        LinkCrossRoomDataHolder r2 = r0.getLinkCrossRoomDataHolder();
    L6:
        if (r2 == null) goto L8;
        Long r3 = Long.valueOf(r2.c());
    L9:
        r5.put("channel_id", String.valueOf(r3));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.b;
        if (r4 == null) goto L12;
        w31.c r6 = r4.getPkLinkUtils();
    L13:
        if (r6 == null) goto L15;
        Long r7 = Long.valueOf(r6.i());
    L16:
        r5.put("pk_id", String.valueOf(r7));
        com.bytedance.android.live.revlink.impl.global.c r8 = this.b;
        if (r8 == null) goto L19;
        d31.d r9 = r8.getRevLinkLogHelper();
    L20:
        String r10 = "";
        if (r9 == null) goto L23;
        String r12 = r9.c();
    L24:
        r5.put("connection_type", r12);
        com.bytedance.android.live.revlink.impl.global.c r13 = this.b;
        if (r13 == null) goto L27;
        w r14 = r13.getMultiLinkUtil();
    L28:
        if (r14 != null) goto L30;
    L32:
        com.bytedance.android.live.revlink.impl.global.c r15 = this.b;
        if (r15 == null) goto L35;
        w r16 = r15.getMultiLinkUtil();
    L36:
        if (r16 == null) goto L40;
        i11.b r17 = r16.a();
        if (r17 == null) goto L40;
        int r18 = r17.c();
    L41:
        r5.put("anchor_connect_status", String.valueOf(r18));
        com.bytedance.android.live.revlink.impl.global.c r19 = this.b;
        if (r19 == null) goto L44;
        r1 = r19.getLinkCrossRoomDataHolder();
    L44:
        if (r1 == null) goto L46;
        r10 = r1.h();
    L46:
        r5.put("invitee_list", r10);
        return;
    L40:
        r18 = 0;
        goto L41
    L35:
        r16 = null;
        goto L36
    L30:
        if (r14.e() != true) goto L32;
        r18 = 2;
        goto L41
    L27:
        r14 = null;
        goto L28
    L23:
        r12 = "";
        goto L24
    L19:
        r9 = null;
        goto L20
    L15:
        r7 = null;
        goto L16
    L12:
        r6 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public d(com.bytedance.android.livesdk.revenue.service.room.c r1, LinkFakeGlobalService r2) {
        this.a = r1;
        this.b = r2;
    }
}
