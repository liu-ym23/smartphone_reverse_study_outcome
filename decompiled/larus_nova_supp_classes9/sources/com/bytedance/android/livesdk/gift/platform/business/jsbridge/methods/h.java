package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.browser.jsbridge.base.GetGiftDataResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.s0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import w20.i1;
import w20.m9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends i1<m9, GetGiftDataResultModel> {
    public h() {
    }

    public final void invoke(Object r20, CallContext r21) {
        m9 r0 = (m9) r20;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r21, "context");
        String r1 = r0.a();
        List r2 = r0.b();
        if (r1 != null) goto L6;
        if (r2 != null) goto L7;
        r2 = CollectionsKt.emptyList();
    L7:
        ArrayList r7 = new ArrayList();
        LinkedHashSet r8 = new LinkedHashSet();
        Iterator r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        String r4 = (String) r3.next();
        if (CastLongProtector.parseLong(r4) <= 0) goto L9;
        h1 r5 = com.bytedance.android.live.revenue.core.util.f.a(IGiftService.class).findGiftById(CastLongProtector.parseLong(r4));
        if (r5 == null) goto L15;
        r7.add(r5);
        goto L9
    L15:
        r8.add(r4);
        goto L9
    L18:
        if ((!r8.isEmpty()) == false) goto L36;
        String r6 = CollectionsKt.joinToString$default(r8, ",", null, null, 0, null, null, 62, null);
        com.bytedance.android.livesdk.revenue.room.a r9 = g02.a.d();
        if (r9 == null) goto L50;
        com.bytedance.live.datacontext.m r10 = r9.getRoom();
        if (r10 == null) goto L50;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L50;
        long r13 = r11.getId();
        tz0.b r14 = tz0.b.a;
        uz0.c r15 = new uz0.c();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "$this$beforeConfigureRequest");
        Map r16 = ((uz0.a) r15).b;
        Intrinsics.checkNotNullParameter(r16, "queriesMap");
        Intrinsics.checkNotNullParameter("gift_ids", "$this$setTo");
        if (r6 == null) goto L28;
        r16.put("gift_ids", r6);
    L28:
        String r17 = Long.valueOf(r13).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r17 == null) goto L31;
        r16.put("room_id", r17);
    L31:
        Integer r18 = 2;
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("fetch_from", "$this$setTo");
        if (r19 == null) goto L34;
        r16.put("fetch_from", r19);
    L34:
        Intrinsics.checkNotNullParameter(r15, "$this$afterConfigureRequest");
        com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(INetworkService.Biz.Revenue, "/webcast/gift/detail/", TypesJVMKt.getJavaType(Reflection.typeOf(s0.class)), Extra.class, ((uz0.a) r15).d, ((uz0.a) r15).a, ((uz0.a) r15).b, ((uz0.a) r15).c).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(r13, this, r6, r7), new g(r13, this, r6, r7));
    L50:
        return;
    L36:
        GetGiftDataResultModel r23 = new GetGiftDataResultModel();
        if (r7.size() != 1) goto L39;
        r23.b(GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), CollectionsKt.first(r7)));
    L40:
        r23.a(GetGiftDataResultModel.Code.Success);
        finishWithResult(r23);
        return;
    L39:
        r23.b(GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r7));
        goto L40
    L6:
        r2 = CollectionsKt.listOf(r1);
        goto L7
    }
}
