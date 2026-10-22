package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryState;", "", "<init>", "()V", "a", "b", "c", "d", "e", "f", "g", "Lcom/bytedance/android/live/profit/lottery/LotteryState$a;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$b;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$c;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$d;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$e;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$f;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$g;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class LotteryState {

    public static final class a extends LotteryState {
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
            return "Drawing(info=" + this.a + ")";
        }

        public a(t r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            super(null);
            this.a = r2;
        }
    }

    public static final class b extends LotteryState {
        public final t a;
        public final p0 b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
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
            t r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            p0 r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Finished(info=" + this.a + ", finishInfo=" + this.b + ")";
        }

        public b(t r2, p0 r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            Intrinsics.checkNotNullParameter(r3, "finishInfo");
            super(null);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends LotteryState {
        public static final c a = null;

        public c() {
            super(null);
        }

        static {
            a = new c();
        }
    }

    public static final class d extends LotteryState {
        public final t a;
        public h1 b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
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
            t r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            h1 r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Refresh(info=" + this.a + ", refreshInfo=" + this.b + ")";
        }

        public d(t r2, h1 r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            Intrinsics.checkNotNullParameter(r3, "refreshInfo");
            super(null);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends LotteryState {
        public final i1 a;
        public final t b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof e) == false) goto L10;
            e r4 = (e) r3;
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
            return "Rejected(rejectInfo=" + this.a + ", info=" + this.b + ")";
        }

        public e(i1 r2, t r3) {
            Intrinsics.checkNotNullParameter(r2, "rejectInfo");
            super(null);
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class f extends LotteryState {
        public static final f a = null;

        public f() {
            super(null);
        }

        static {
            a = new f();
        }
    }

    public static final class g extends LotteryState {
        public final t a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof g) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((g) r2).a) == true) goto L13;
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
            return "Waiting(info=" + this.a + ")";
        }

        public g(t r2) {
            Intrinsics.checkNotNullParameter(r2, "info");
            super(null);
            this.a = r2;
        }
    }

    private LotteryState() {
    }

    public /* synthetic */ LotteryState(DefaultConstructorMarker r1) {
        this();
    }
}
