package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.base.BaseBannerWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class ActivityTopBannerViewIntent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/activity/banner/ActivityTopBannerViewIntent$LifeCycle;", "", "ON_RESUME", "ON_PAUSE", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LifeCycle extends Enum<LifeCycle> {
        public static final LifeCycle ON_PAUSE = null;
        public static final LifeCycle ON_RESUME = null;
        public static final /* synthetic */ LifeCycle[] a = null;

        static {
            LifeCycle r1 = new LifeCycle("ON_RESUME", 0);
            ON_RESUME = r1;
            LifeCycle r2 = new LifeCycle("ON_PAUSE", 1);
            ON_PAUSE = r2;
            a = new LifeCycle[]{r1, r2};
        }

        public static LifeCycle valueOf(String r1) {
            return (LifeCycle) r27.a.a(LifeCycle.class, r1);
        }

        public static LifeCycle[] values() {
            return (LifeCycle[]) a.clone();
        }

        public LifeCycle(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends ActivityTopBannerViewIntent {
        public final h1 a;

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
            h1 r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BannerMessageEventViewIntent(bannerMessage=" + this.a + ")";
        }

        public a(h1 r1) {
            this.a = r1;
        }
    }

    public static final class b extends ActivityTopBannerViewIntent {
        public final BaseBannerWidget.BannerPosition a;

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
            BaseBannerWidget.BannerPosition r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "FetchBannerDataViewIntent(bannerPosition=" + this.a + ")";
        }

        public b(BaseBannerWidget.BannerPosition r2) {
            Intrinsics.checkNotNullParameter(r2, "bannerPosition");
            this.a = r2;
        }
    }

    public static final class c extends ActivityTopBannerViewIntent {
        public final LifeCycle a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            LifeCycle r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "JsBannerLifeCycleViewIntent(cycle=" + this.a + ")";
        }

        public c(LifeCycle r2) {
            Intrinsics.checkNotNullParameter(r2, "cycle");
            this.a = r2;
        }
    }

    public static final class d extends ActivityTopBannerViewIntent {
        public final BaseBannerWidget.BannerPosition a;
        public final BannerInRoomCollection.BannerInfo b;

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
            BaseBannerWidget.BannerPosition r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            BannerInRoomCollection.BannerInfo r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "JsBannerListViewIntent(source=" + this.a + ", bannerInfo=" + this.b + ")";
        }

        public d(BaseBannerWidget.BannerPosition r2, BannerInRoomCollection.BannerInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends ActivityTopBannerViewIntent {
        public final BaseBannerWidget.BannerPosition a;

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
            BaseBannerWidget.BannerPosition r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "JsBannerStatusViewIntent(source=" + this.a + ")";
        }

        public e(BaseBannerWidget.BannerPosition r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            this.a = r2;
        }
    }

    public static final class f extends ActivityTopBannerViewIntent {
        public final UserEvent a;

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
            UserEvent r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "JsBannerUserEventViewIntent(userEvent=" + this.a + ")";
        }

        public f(UserEvent r1) {
            this.a = r1;
        }
    }

    public static final class g extends ActivityTopBannerViewIntent {
        public final String a;
        public final String b;

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
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "LoadUrlViewIntent(originUrl=" + this.a + ", logId=" + this.b + ")";
        }

        public g(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ActivityTopBannerViewIntent() {
    }
}
