package com.larus.bmhome;

import aza.d;
import com.bytedance.keva.Keva;
import com.larus.bmhome.utils.r3;
import com.larus.larkfeed.IFlowLarkFeedApi;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.SocialIMData;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import hza.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class FlowLarkSocialServiceImpl {
    public final Map<Function1<SocialIMData, Unit>, b> a;

    public final boolean c() {
        return IFlowLarkFeedApi.a.f();
    }

    public FlowLarkSocialServiceImpl() {
        this.a = new LinkedHashMap();
    }

    public static SocialIMData a(pza.a r8) {
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = null;
        if (r2 == true) goto L18;
        if (r8 == null) goto L12;
        Long r4 = Long.valueOf(r8.a);
    L13:
        if (r4 == null) goto L18;
        if (r8 == null) goto L17;
        Long r0 = Long.valueOf(r8.a);
    L23:
        if (r8 == null) goto L25;
        Integer r1 = Integer.valueOf(r8.b);
    L26:
        if (r8 == null) goto L28;
        Integer r5 = Integer.valueOf(r8.c);
    L29:
        if (r8 == null) goto L31;
        r3 = r8.f;
    L31:
        SocialIMData r9 = new SocialIMData(r0, r3, r1, r5);
        Keva r6 = com.larus.home.impl.utils.k.a;
        Intrinsics.checkNotNullParameter(r9, "data");
        com.larus.home.impl.utils.k.a.storeString("default_data_cache".concat(r3.a()), HttpExtKt.p(r9));
        return r9;
    L28:
        r5 = null;
        goto L29
    L25:
        r1 = null;
        goto L26
    L17:
        r0 = null;
        goto L23
    L12:
        r4 = null;
    L18:
        Keva r7 = com.larus.home.impl.utils.l.a;
        long r10 = r7.getLong("default_update_time", 0);
        if (r10 != 0) goto L22;
        r10 = System.currentTimeMillis();
        r7.storeLong("default_update_time", r10);
    L22:
        r0 = Long.valueOf(r10);
        goto L23
    L5:
        if (r8.a != 0) goto L7;
        r2 = true;
        goto L8
    }

    public final void e(com.larus.bmhome.chat.reddot.g r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        b r0 = (b) ((LinkedHashMap) this.a).get(r3);
        if (r0 == null) goto L13;
        this.a.remove(r3);
        Object r4 = xp9.o.a;
        if ((r4 instanceof OfficeSDKUserApi) == false) goto L7;
        OfficeSDKUserApi r5 = (OfficeSDKUserApi) r4;
    L8:
        if (r5 == null) goto L14;
        d r6 = r5.getService(d.class);
        if (r6 == null) goto L15;
        r6.R6(r0);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r5 = null;
        goto L8
    }

    public final Object b(Object r6, Continuation<? super SocialIMData> r7) {
        if ((r7 instanceof FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1) == false) goto L7;
        FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1 r0 = (FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        pza.a r4 = null;
        Object r5 = null;
        r4 = null;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L25:
        if (Result.isFailure-impl(r9) == true) goto L28;
        r5 = r9;
    L28:
        r4 = (pza.a) r5;
    L30:
        return a(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if ((r6 instanceof OfficeSDKUserApi) == false) goto L17;
        OfficeSDKUserApi r10 = (OfficeSDKUserApi) r6;
    L18:
        if (r10 == null) goto L30;
        d r11 = r10.getService(d.class);
        if (r11 == null) goto L30;
        r0.label = 1;
        r9 = r11.ma(r0);
        if (r9 != r2) goto L25;
        return r2;
    L17:
        r10 = null;
    L7:
        r0 = new FlowLarkSocialServiceImpl$getHumanFeedDisplayItem$1(this, r7);
        goto L8
    }

    public final void d(Object r3, com.larus.bmhome.chat.reddot.g r4) {
        Intrinsics.checkNotNullParameter(r3, "userApi");
        Intrinsics.checkNotNullParameter(r4, "listener");
        v r0 = new v(r4, this);
        this.a.put(r4, r0);
        if ((r3 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r5 = (OfficeSDKUserApi) r3;
    L6:
        if (r5 == null) goto L11;
        d r6 = r5.getService(d.class);
        if (r6 == null) goto L12;
        r6.J5(r0);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
