package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.utils.g2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class a extends g2 {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a$a, reason: collision with other inner class name */
    public static final class C0035a extends a {
        public final RoomBannerBarEvent a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof C0035a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((C0035a) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            RoomBannerBarEvent r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "BannerNameBarEventViewState(roomBannerBarEvent=" + this.a + ")";
        }

        public C0035a(RoomBannerBarEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "roomBannerBarEvent");
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final boolean a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (this.a == ((b) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r0 = this.a;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        public final String toString() {
            return "ContainerVisibilityViewState(isShow=" + this.a + ")";
        }

        public b(boolean r1) {
            this.a = r1;
        }
    }

    public static final class c extends a {
        public final int a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (this.a == ((c) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "ContentVisibilityViewState(visibility=" + this.a + ")";
        }

        public c(int r1) {
            this.a = r1;
        }
    }

    public static final class d extends a {
        public final boolean a;
        public final BannerInRoomCollection.BannerInfo b;
        public final String c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L12;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            int r2 = r1 * 31;
            BannerInRoomCollection.BannerInfo r3 = this.b;
            int r4 = 0;
            if (r3 == null) goto L8;
            int r5 = r3.hashCode();
        L9:
            int r6 = (r2 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            r4 = r7.hashCode();
        L13:
            return r6 + r4;
        L8:
            r5 = 0;
            goto L9
        }

        public final String toString() {
            return "FetchBannerDataViewState(isSuccess=" + this.a + ", data=" + this.b + ", msg=" + this.c + ")";
        }

        public d(boolean r1, BannerInRoomCollection.BannerInfo r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class e extends a {
        public final String a;

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
            String r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "InitViewState(source=" + this.a + ")";
        }

        public e() {
            this.a = "start";
        }
    }

    public static final class f extends a {
        public final String a;
        public final JSONObject b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L10;
            f r4 = (f) r3;
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
            JSONObject r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "JsEventViewState(eventName=" + this.a + ", jsonData=" + this.b + ")";
        }

        public f(String r1, JSONObject r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class g extends a {
        public final boolean a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof g) == true) goto L6;
            return false;
        L6:
            if (this.a == ((g) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            boolean r0 = this.a;
            if (r0 == false) goto L6;
            return 1;
        L6:
            return r0 ? 1 : 0;
        }

        public final String toString() {
            return "KeyboardStatusViewState(show=" + this.a + ")";
        }

        public g(boolean r1) {
            this.a = r1;
        }
    }

    public static final class h extends a {
        public final BannerInRoomCollection.BannerInfo a;
        public final int b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof h) == false) goto L10;
            h r4 = (h) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            BannerInRoomCollection.BannerInfo r0 = this.a;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + this.b;
        L5:
            r1 = 0;
            goto L7
        }

        public final String toString() {
            return "LoadMessageBannerState(bannerInfo=" + this.a + ", operationType=" + this.b + ")";
        }

        public h(BannerInRoomCollection.BannerInfo r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "bannerInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class i extends a {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof i) == false) goto L10;
            i r4 = (i) r3;
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
            return "LoadUrlViewState(originUrl=" + this.a + ", finalUrl=" + this.b + ")";
        }

        public i(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class j extends a {
        public final int a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof j) == true) goto L6;
            return false;
        L6:
            if (this.a == ((j) r2).a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "RefreshActivityBannerNumberEventState(bannerNumber=" + this.a + ")";
        }

        public j(int r1) {
            this.a = r1;
        }
    }

    public a() {
    }
}
