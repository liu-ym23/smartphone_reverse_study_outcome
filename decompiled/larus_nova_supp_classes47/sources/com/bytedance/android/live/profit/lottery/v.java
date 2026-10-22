package com.bytedance.android.live.profit.lottery;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v {
    public static final c a = null;

    public static final class a {
        public final JsonObject a;
        public final e b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            JsonObject r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            e r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LotteryResult(rawResponse=" + this.a + ", response=" + this.b + ")";
        }

        public a(JsonObject r2, e r3) {
            Intrinsics.checkNotNullParameter(r2, "rawResponse");
            Intrinsics.checkNotNullParameter(r3, "response");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final t a;

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                t r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Approve(info=" + this.a + ")";
            }

            public a(t r2) {
                Intrinsics.checkNotNullParameter(r2, "info");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.lottery.v$b$b, reason: collision with other inner class name */
        public static final class C0034b extends b {
            public static final C0034b a = null;

            static {
                a = new C0034b();
            }

            public C0034b() {
            }
        }

        public static final class c extends b {
            public final i1 a;
            public final t b;

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof c) == false) goto L10;
                c r4 = (c) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                i1 r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                t r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Reject(rejectInfo=" + this.a + ", info=" + this.b + ")";
            }

            public c(i1 r2, t r3) {
                Intrinsics.checkNotNullParameter(r2, "rejectInfo");
                this.a = r2;
                this.b = r3;
            }
        }

        public b() {
        }
    }

    public static final class c extends com.bytedance.android.live.core.utils.rxutils.l.a {
        public c() {
        }

        public final boolean a(Throwable r4, int r5) {
            c r0 = v.a;
            if ((r4 instanceof ApiException) == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L11;
            return true;
        L11:
            return super.a(r4, r5);
        L5:
            if (((ApiException) r4).getErrorCode() != 43913) goto L7;
            r1 = true;
            goto L8
        }
    }

    public v() {
    }

    static {
        a = new c();
    }

    public static t b(k r17, long r18) {
        Intrinsics.checkNotNullParameter(r17, "$this$toLotteryInfo");
        long r2 = r17.getLotteryId();
        int r4 = r17.getStatus();
        long r5 = r17.getCurrentTime();
        long r7 = WebcastRedirectException.UNKNOWN;
        long r6 = e3.c(r5 * r7, r17.getDrawTime() * r7, 0, false) - r18;
        p r0 = r17.getPrizeInfo();
        if (r0 == null) goto L5;
        int r8 = r0.getType();
    L6:
        long r9 = r17.getPrizeCount();
        List<h> r1 = r17.getConditions();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        r12.add(Integer.valueOf(((h) r3.next()).getType()));
        goto L8
    L11:
        return new t(r2, r4, r6, r8, r9, 0, r12, r17.getUseNewDrawInteraction(), r17.getServerBizData(), r17.getUiConfig(), (com.bytedance.android.live.profit.lottery.c) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r17.getExtra(), com.bytedance.android.live.profit.lottery.c.class));
    L5:
        r8 = -1;
        goto L6
    }

    public static Single a(long r17, boolean r19, LotteryApi.QueryFrom r20, int r22) {
        int r1 = 0;
        if ((r22 & 2) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r22 & 4) == 0) goto L10;
        r1 = 5;
    L10:
        if ((r22 & 8) == 0) goto L12;
        long r2 = 3000;
    L14:
        if ((r22 & 16) == 0) goto L16;
        LotteryApi.QueryFrom r4 = LotteryApi.QueryFrom.Undefined;
    L17:
        Intrinsics.checkNotNullParameter(r4, "queryFrom");
        LinkedHashMap<String, String> r5 = LotteryTraceMonitor.a;
        LotteryTraceMonitor.a(LotteryTraceMonitor.EventName.lottery_init_api, "begin");
        com.bytedance.android.live.revenue.common.g r6 = new com.bytedance.android.live.revenue.common.g("ttlive_lottery", "fetchRoomLottery roomId=" + r17);
        r6.a("begin");
        int r7 = LotteryApi.a;
        long r8 = r4.getValue();
        tz0.b r9 = tz0.b.a;
        uz0.c r12 = new uz0.c();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r12, "$this$beforeConfigureRequest");
        r12.a(qx0.a.a);
        Map<String, String> r10 = r12.b;
        Intrinsics.checkNotNullParameter(r10, "queriesMap");
        String r13 = Long.valueOf(r17).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r13 == null) goto L20;
        r10.put("room_id", r13);
    L20:
        String r14 = Long.valueOf(r8).toString();
        Intrinsics.checkNotNullParameter("query_from", "$this$setTo");
        if (r14 == null) goto L23;
        r10.put("query_from", r14);
    L23:
        Intrinsics.checkNotNullParameter(r12, "$this$afterConfigureRequest");
        return RxUtilKt.h(RxCompatKt.b(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/lottery/melon/lottery_info/", TypesJVMKt.getJavaType(Reflection.typeOf(f.class)), Extra.class, r12.d, r12.a, r12.b, r12.c).map(new e0(r0)).onErrorResumeNext(f0.a), new com.bytedance.android.live.core.utils.rxutils.l(r1, r2))).singleOrError().doOnEvent(new g0(r6));
    L16:
        r4 = r20;
        goto L17
    L12:
        r2 = 0;
        goto L14
    L5:
        r0 = r19;
        goto L7
    }
}
