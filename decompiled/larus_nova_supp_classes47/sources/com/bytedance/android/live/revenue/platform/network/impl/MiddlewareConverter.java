package com.bytedance.android.live.revenue.platform.network.impl;

import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MiddlewareConverter {
    public Pair<? extends MiddlewarePriority, Boolean> a;
    public final com.bytedance.android.livesdk.revenue.network.d b;
    public final List<com.bytedance.android.livesdk.revenue.network.a> c;
    public final List<com.bytedance.android.livesdk.revenue.network.a> d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/network/impl/MiddlewareConverter$MiddlewarePriority;", "", "Self", "Platform", "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MiddlewarePriority extends Enum<MiddlewarePriority> {
        public static final MiddlewarePriority Platform = null;
        public static final MiddlewarePriority Self = null;
        public static final /* synthetic */ MiddlewarePriority[] a = null;

        static {
            MiddlewarePriority r1 = new MiddlewarePriority("Self", 0);
            Self = r1;
            MiddlewarePriority r2 = new MiddlewarePriority("Platform", 1);
            Platform = r2;
            a = new MiddlewarePriority[]{r1, r2};
        }

        public static MiddlewarePriority valueOf(String r1) {
            return (MiddlewarePriority) r27.a.a(MiddlewarePriority.class, r1);
        }

        public static MiddlewarePriority[] values() {
            return (MiddlewarePriority[]) a.clone();
        }

        public MiddlewarePriority(String r1, int r2) {
            super(r1, r2);
        }
    }

    public MiddlewareConverter(List<? extends com.bytedance.android.livesdk.revenue.network.a> r12, List<? extends com.bytedance.android.livesdk.revenue.network.a> r13, com.bytedance.android.livesdk.revenue.network.d r14) {
        Intrinsics.checkNotNullParameter(r12, "selfMiddlewareList");
        Intrinsics.checkNotNullParameter(r13, "platformMiddleWareList");
        Intrinsics.checkNotNullParameter(r14, "originRequest");
        this.c = r12;
        this.d = r13;
        String r0 = r14.a;
        Unit r1 = Unit.INSTANCE;
        Iterator<T> r15 = r13.iterator();
    L3:
        Boolean r4 = null;
        if (r15.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.revenue.network.a r2 = (com.bytedance.android.livesdk.revenue.network.a) r15.next();
        MiddlewarePriority r5 = MiddlewarePriority.Platform;
        if (r2.h() == null) goto L23;
        Pair<? extends MiddlewarePriority, Boolean> r6 = this.a;
        if (r6 == null) goto L10;
        MiddlewarePriority r7 = (MiddlewarePriority) r6.getFirst();
    L11:
        if (r7 != r5) goto L20;
        Pair<? extends MiddlewarePriority, Boolean> r8 = this.a;
        if (r8 == null) goto L16;
        r4 = (Boolean) r8.getSecond();
    L16:
        if ((true ^ Intrinsics.areEqual(r4, r2.h())) == false) goto L20;
        throw new IllegalStateException("same priority middleware has more than one [enablePB] values".toString());
    L20:
        Boolean r3 = r2.h();
        if (r3 == null) goto L23;
        this.a = TuplesKt.to(r5, Boolean.valueOf(r3.booleanValue()));
        goto L23
    L10:
        r7 = null;
    L23:
        Unit r9 = Unit.INSTANCE;
        goto L3
    L24:
        Iterator<T> r16 = r12.iterator();
    L26:
        if (r16.hasNext() == false) goto L47;
        com.bytedance.android.livesdk.revenue.network.a r17 = (com.bytedance.android.livesdk.revenue.network.a) r16.next();
        MiddlewarePriority r10 = MiddlewarePriority.Self;
        if (r17.h() == null) goto L46;
        Pair<? extends MiddlewarePriority, Boolean> r18 = this.a;
        if (r18 == null) goto L32;
        MiddlewarePriority r19 = (MiddlewarePriority) r18.getFirst();
    L33:
        if (r19 != r10) goto L43;
        Pair<? extends MiddlewarePriority, Boolean> r20 = this.a;
        if (r20 == null) goto L37;
        Boolean r22 = (Boolean) r20.getSecond();
    L39:
        if ((!Intrinsics.areEqual(r22, r17.h())) == false) goto L43;
        throw new IllegalStateException("same priority middleware has more than one [enablePB] values".toString());
    L37:
        r22 = null;
    L43:
        Boolean r110 = r17.h();
        if (r110 == null) goto L46;
        this.a = TuplesKt.to(r10, Boolean.valueOf(r110.booleanValue()));
        goto L46
    L32:
        r19 = null;
    L46:
        Unit r111 = Unit.INSTANCE;
        goto L26
    L47:
        List<com.bytedance.android.livesdk.revenue.network.a> r112 = this.c;
        Iterator<T> r113 = this.d.iterator();
        com.bytedance.android.livesdk.revenue.network.d r23 = r14;
    L49:
        if (r113.hasNext() == false) goto L51;
        com.bytedance.android.livesdk.revenue.network.a r24 = (com.bytedance.android.livesdk.revenue.network.a) r113.next();
        MiddlewarePriority r25 = MiddlewarePriority.Self;
        r0 = r24.g(r0, r14.a);
        r23 = r24.x(r0, r14);
        goto L49
    L51:
        Iterator<T> r114 = r112.iterator();
        String r26 = r0;
    L53:
        if (r114.hasNext() == false) goto L55;
        com.bytedance.android.livesdk.revenue.network.a r115 = (com.bytedance.android.livesdk.revenue.network.a) r114.next();
        MiddlewarePriority r27 = MiddlewarePriority.Self;
        r26 = r115.g(r26, r14.a);
        r23 = r115.x(r26, r14);
        goto L53
    L55:
        Map r28 = MapsKt.toMutableMap(r23.b);
        Map r29 = r23.c;
        Map r30 = r23.d;
        JsonObject r116 = r23.g;
        Pair<? extends MiddlewarePriority, Boolean> r117 = this.a;
        if (r117 != null) goto L58;
    L60:
        this.b = new com.bytedance.android.livesdk.revenue.network.d(r26, r28, r29, r30, r14.e, r14.f, r116);
        if (r14.g != null) goto L63;
        return;
    L63:
        if ((!r14.d.isEmpty()) == true) goto L66;
        return;
    L66:
        throw new IllegalArgumentException("cannot add field when contentType is application/json");
    L58:
        if (((Boolean) r117.getSecond()).booleanValue() != true) goto L60;
        r28.put("response-format", "protobuf");
        goto L60
    }
}
