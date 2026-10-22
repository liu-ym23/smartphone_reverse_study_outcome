package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.livesdk.chatroom.model.o1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/RedPacketRushResult;", "", "<init>", "()V", "a", "b", "c", "d", "e", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class RedPacketRushResult {

    public static final class a extends RedPacketRushResult {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends RedPacketRushResult {
        public final py.k a;
        public final List<m1> b;

        public b(String r2, py.k r3, com.bytedance.android.live.revenue.common.u0 r4, String r5, List r6) {
            Intrinsics.checkNotNullParameter(r2, "voucherName");
            Intrinsics.checkNotNullParameter(r4, "voucherExpiredTime");
            Intrinsics.checkNotNullParameter(r5, "dressId");
            Intrinsics.checkNotNullParameter(r6, "vouchers");
            this.a = r3;
            this.b = r6;
        }
    }

    public static final class c extends RedPacketRushResult {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }
    }

    public static final class d extends RedPacketRushResult {
        public d(String r2) {
            Intrinsics.checkNotNullParameter(r2, "dressId");
        }
    }

    public static final class e extends RedPacketRushResult {
        public final int a;
        public final py.k b;
        public final long c;
        public final o1.b d;

        public e(int r2, String r3, py.k r4, long r5, o1.b r7, String r8) {
            Intrinsics.checkNotNullParameter(r3, "rewardName");
            Intrinsics.checkNotNullParameter(r8, "dressId");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r7;
        }
    }

    public RedPacketRushResult() {
    }
}
