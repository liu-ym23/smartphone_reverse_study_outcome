package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryAction;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$a;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$b;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$c;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$d;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$e;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$f;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$g;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class LotteryAction {

    public static final class a extends LotteryAction {
        public static final a a = null;

        public a() {
            super(null);
        }

        static {
            a = new a();
        }
    }

    public static final class b extends LotteryAction {
        public final t a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
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

        public b(t r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            super(null);
            this.a = r2;
        }
    }

    public static final class c extends LotteryAction {
        public static final c a = null;

        public c() {
            super(null);
        }

        static {
            a = new c();
        }
    }

    public static final class d extends LotteryAction {
        public static final d a = null;

        public d() {
            super(null);
        }

        static {
            a = new d();
        }
    }

    public static final class e extends LotteryAction {
        public final p0 a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            p0 r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Finish(finishInfo=" + this.a + ")";
        }

        public e(p0 r2) {
            Intrinsics.checkNotNullParameter(r2, "finishInfo");
            super(null);
            this.a = r2;
        }
    }

    public static final class f extends LotteryAction {
        public final h1 a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof f) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((f) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            h1 r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Refresh(refreshInfo=" + this.a + ")";
        }

        public f(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "refreshInfo");
            super(null);
            this.a = r2;
        }
    }

    public static final class g extends LotteryAction {
        public final i1 a;
        public final t b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof g) == false) goto L10;
            g r4 = (g) r3;
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

        public g(i1 r2, t r3) {
            Intrinsics.checkNotNullParameter(r2, "rejectInfo");
            super(null);
            this.a = r2;
            this.b = r3;
        }
    }

    private LotteryAction() {
    }

    public /* synthetic */ LotteryAction(DefaultConstructorMarker r1) {
        this();
    }
}
