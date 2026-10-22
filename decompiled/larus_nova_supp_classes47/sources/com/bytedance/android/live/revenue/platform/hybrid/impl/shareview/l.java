package com.bytedance.android.live.revenue.platform.hybrid.impl.shareview;

import io.reactivex.Single;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class l {

    public static final class a extends l {
        public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c a;

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
            com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Created(sharer=" + this.a + ")";
        }

        public a(com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r2) {
            Intrinsics.checkNotNullParameter(r2, "sharer");
            this.a = r2;
        }
    }

    public static final class b extends l {
        public final Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> a;

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
            Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Creating(onResult=" + this.a + ")";
        }

        public b(Single<com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c> r2) {
            Intrinsics.checkNotNullParameter(r2, "onResult");
            this.a = r2;
        }
    }

    public l() {
    }
}
