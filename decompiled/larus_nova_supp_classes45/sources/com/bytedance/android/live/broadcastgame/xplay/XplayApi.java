package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.model.OpenPlatformRespExtra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Query;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001:\u000b\u001d\u001e\u001f !\"#$%&'JL\u0010\u000e\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\b\u0012\u0004\u0012\u00020\u000b`\r0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H'J8\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\nj\b\u0012\u0004\u0012\u00020\u0011`\r0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'J(\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'JB\u0010\u0019\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\f0\nj\b\u0012\u0004\u0012\u00020\u0018`\r0\t2\b\b\u0001\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'JB\u0010\u001c\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\nj\b\u0012\u0004\u0012\u00020\u001b`\r0\t2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¨\u0006("}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi;", "", "", "appId", "", "roomId", "", "needRtcInfo", "isContinuePlay", "Lio/reactivex/Single;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$d;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformRespExtra;", "Lcom/bytedance/android/live/broadcastgame/opengame/network/model/OpenPlatformBaseResponseV2;", "getToken", "", "guideType", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$a;", "switchToGuide", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/e;", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$h;", "getLiveData", "startId", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$b;", "continuePlay", "liveScene", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$c;", "getInteractEntranceItem", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface XplayApi {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$a;", "", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$e;", "guideInfo", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$e;", "a", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$e;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("guide_info")
        private final e guideInfo;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.guideInfo, ((a) r2).guideInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            e r0 = this.guideInfo;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "AnchorGuideResponseData(guideInfo=" + this.guideInfo + ")";
        }

        public final e a() {
            return this.guideInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$b;", "", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$f;", "interactEntranceItem", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$f;", "b", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$f;", "", "canContinue", "Z", "a", "()Z", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("can_continue")
        private final boolean canContinue;

        @SerializedName("interact_entrance_item")
        private final f interactEntranceItem;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.interactEntranceItem, r4.interactEntranceItem) == true) goto L8;
            return false;
        L8:
            if (this.canContinue == r4.canContinue) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            f r0 = this.interactEntranceItem;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.canContinue;
            ?? r4 = r3;
            if (r3 == false) goto L10;
            r4 = 1;
        L10:
            return r2 + r4;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ContinuePlayResponse(interactEntranceItem=" + this.interactEntranceItem + ", canContinue=" + this.canContinue + ")";
        }

        public b() {
            this.interactEntranceItem = null;
            this.canContinue = false;
        }

        public final boolean a() {
            return this.canContinue;
        }

        public final f b() {
            return this.interactEntranceItem;
        }
    }

    @ProtoMessage("webcast.open.anchor_mount_mobile.GetInteractEntranceCellResponse.ResponseData")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$c;", "", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "interactEntranceItem", "Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "getInteractEntranceItem", "()Lcom/bytedance/android/live/broadcastgame/api/model/InteractEntranceCell;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c implements vh7.h {

        @SerializedName("cell")
        protected InteractEntranceCell interactEntranceItem;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.interactEntranceItem, ((c) r2).interactEntranceItem) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            InteractEntranceCell r0 = this.interactEntranceItem;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "GetInteractEntranceCellResponse(interactEntranceItem=" + this.interactEntranceItem + ")";
        }

        public c() {
            this.interactEntranceItem = null;
        }

        public c(am3.g r5) {
            long r0 = r5.c();
        L3:
            int r2 = r5.f();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            this.interactEntranceItem = new InteractEntranceCell(r5);
            goto L3
        L7:
            am3.h.e(r5);
            goto L3
        L9:
            r5.d(r0);
            if (this.interactEntranceItem != null) goto L19;
            this.interactEntranceItem = null;
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$d;", "", "", "token", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$j;", "rtcInfo", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$j;", "a", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$j;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("rtc_info")
        private final j rtcInfo;

        @SerializedName("token")
        private final String token;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L10;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.token, r4.token) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.rtcInfo, r4.rtcInfo) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.token;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            j r4 = this.rtcInfo;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GetTokenResponseData(token=" + this.token + ", rtcInfo=" + this.rtcInfo + ")";
        }

        public final j a() {
            return this.rtcInfo;
        }

        public final String b() {
            return this.token;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$e;", "", "", "isShowGuide", "Z", "b", "()Z", "", "duration", "J", "a", "()J", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("duration_time")
        private final long duration;

        @SerializedName("display")
        private final boolean isShowGuide;

        public final boolean equals(Object r5) {
            if (this != r5) goto L4;
            return true;
        L4:
            if ((r5 instanceof e) == false) goto L10;
            e r6 = (e) r5;
            if (this.isShowGuide == r6.isShowGuide) goto L8;
            return false;
        L8:
            if (this.duration == r6.duration) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public final int hashCode() {
            boolean r0 = this.isShowGuide;
            ?? r1 = r0;
            if (r0 == false) goto L5;
            r1 = 1;
        L5:
            long r2 = this.duration;
            return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
        }

        public final String toString() {
            return "GuideInfo(isShowGuide=" + this.isShowGuide + ", duration=" + this.duration + ")";
        }

        public e() {
            this.isShowGuide = false;
            this.duration = 0;
        }

        public final long a() {
            return this.duration;
        }

        public final boolean b() {
            return this.isShowGuide;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$f;", "", "", "interactId", "I", "c", "()I", "", "name", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "iconUrl", "Ljava/util/List;", "b", "()Ljava/util/List;", "extra", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class f {

        @SerializedName("extra")
        private final String extra;

        @SerializedName("icon_url_list")
        private final List<String> iconUrl;

        @SerializedName("interact_id")
        private final int interactId;

        @SerializedName("title")
        private final String name;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L14;
            f r4 = (f) r3;
            if (this.interactId == r4.interactId) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.name, r4.name) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.iconUrl, r4.iconUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r0 = this.interactId * 31;
            String r1 = this.name;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            List<String> r5 = this.iconUrl;
            if (r5 == null) goto L9;
            int r6 = r5.hashCode();
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.extra;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return r7 + r2;
        L9:
            r6 = 0;
            goto L10
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "InteractEntranceItem(interactId=" + this.interactId + ", name=" + this.name + ", iconUrl=" + this.iconUrl + ", extra=" + this.extra + ")";
        }

        public f() {
            int r0 = InteractID.Unknown.getValue();
            ArrayList r1 = new ArrayList();
            Intrinsics.checkNotNullParameter("", "name");
            Intrinsics.checkNotNullParameter(r1, "iconUrl");
            Intrinsics.checkNotNullParameter("", "extra");
            this.interactId = r0;
            this.name = "";
            this.iconUrl = r1;
            this.extra = "";
        }

        public final String a() {
            return this.extra;
        }

        public final List<String> b() {
            return this.iconUrl;
        }

        public final int c() {
            return this.interactId;
        }

        public final String d() {
            return this.name;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$g;", "", "", "viewCount", "J", "getViewCount", "()J", "earnCoin", "getEarnCoin", "income", "getIncome", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class g {

        @SerializedName("earn_coin")
        private final long earnCoin;

        @SerializedName("income")
        private final long income;

        @SerializedName("uv")
        private final long viewCount;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof g) == false) goto L12;
            g r7 = (g) r6;
            if (this.viewCount == r7.viewCount) goto L8;
            return false;
        L8:
            if (this.earnCoin == r7.earnCoin) goto L10;
            return false;
        L10:
            if (this.income == r7.income) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            long r0 = this.viewCount;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.earnCoin;
            int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r4 = this.income;
            return r2 + ((int) (r4 ^ (r4 >>> 32)));
        }

        public final String toString() {
            return "InteractGameLiveData(viewCount=" + this.viewCount + ", earnCoin=" + this.earnCoin + ", income=" + this.income + ")";
        }

        public g() {
            this.viewCount = 0;
            this.earnCoin = 0;
            this.income = 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$h;", "", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$g;", "liveData", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$g;", "getLiveData", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$g;", "setLiveData", "(Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$g;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class h {

        @SerializedName("live_data")
        private g liveData;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof h) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.liveData, ((h) r2).liveData) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            g r0 = this.liveData;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "InteractGameLiveDataResponse(liveData=" + this.liveData + ")";
        }

        public h() {
            this.liveData = null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$i;", "", "", "rtcExtInfo", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class i {

        @SerializedName("rtc_ext_info")
        private final String rtcExtInfo;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof i) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.rtcExtInfo, ((i) r2).rtcExtInfo) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.rtcExtInfo;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Pod(rtcExtInfo=" + this.rtcExtInfo + ")";
        }

        public i() {
            Intrinsics.checkNotNullParameter("", "rtcExtInfo");
            this.rtcExtInfo = "";
        }

        public final String a() {
            return this.rtcExtInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$j;", "", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$k;", "userRtcInfo", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$k;", "b", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$k;", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$i;", "podRtcInfo", "Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$i;", "a", "()Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$i;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class j {

        @SerializedName("pod")
        private final i podRtcInfo;

        @SerializedName("user")
        private final k userRtcInfo;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof j) == false) goto L10;
            j r4 = (j) r3;
            if (Intrinsics.areEqual(this.userRtcInfo, r4.userRtcInfo) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.podRtcInfo, r4.podRtcInfo) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            k r0 = this.userRtcInfo;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            i r4 = this.podRtcInfo;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RtcInfo(userRtcInfo=" + this.userRtcInfo + ", podRtcInfo=" + this.podRtcInfo + ")";
        }

        public final i a() {
            return this.podRtcInfo;
        }

        public final k b() {
            return this.userRtcInfo;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/xplay/XplayApi$k;", "", "", "rtcExtInfo", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "rtcLiveCoreExtInfo", "c", "linkMicId", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class k {

        @SerializedName("link_mic_id")
        private final String linkMicId;

        @SerializedName("rtc_ext_info")
        private final String rtcExtInfo;

        @SerializedName("rtc_live_core_ext_info")
        private final String rtcLiveCoreExtInfo;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof k) == false) goto L12;
            k r4 = (k) r3;
            if (Intrinsics.areEqual(this.rtcExtInfo, r4.rtcExtInfo) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.rtcLiveCoreExtInfo, r4.rtcLiveCoreExtInfo) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.linkMicId, r4.linkMicId) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.rtcExtInfo;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.rtcLiveCoreExtInfo;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.linkMicId;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "User(rtcExtInfo=" + this.rtcExtInfo + ", rtcLiveCoreExtInfo=" + this.rtcLiveCoreExtInfo + ", linkMicId=" + this.linkMicId + ")";
        }

        public k() {
            Intrinsics.checkNotNullParameter("", "rtcExtInfo");
            Intrinsics.checkNotNullParameter("", "rtcLiveCoreExtInfo");
            Intrinsics.checkNotNullParameter("", "linkMicId");
            this.rtcExtInfo = "";
            this.rtcLiveCoreExtInfo = "";
            this.linkMicId = "";
        }

        public final String a() {
            return this.linkMicId;
        }

        public final String b() {
            return this.rtcExtInfo;
        }

        public final String c() {
            return this.rtcLiveCoreExtInfo;
        }
    }

    @GET("/webcast/anchor_mount/continue_play")
    Single<ExtraResponse<b, OpenPlatformRespExtra>> continuePlay(@Query("start_id") long r1, @Query(OpenPlatformBaseDebugger.APP_ID) String r3, @Query("room_id") long r4);

    @GET("/webcast/anchor_mount/interact_entrance/target_cell/")
    Single<ExtraResponse<c, OpenPlatformRespExtra>> getInteractEntranceItem(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("live_scene") int r2, @Query("room_id") long r3);

    @GET("/webcast/profit_open_game/interact_game/live_data")
    Observable<com.bytedance.android.live.network.response.e<h>> getLiveData(@Query("mini_app") String r1, @Query("room_id") long r2);

    @GET("/webcast/openapi/webcastmate/token")
    Single<ExtraResponse<d, OpenPlatformRespExtra>> getToken(@Query(OpenPlatformBaseDebugger.APP_ID) String r1, @Query("room_id") long r2, @Query("need_rtc_info") boolean r4, @Query("is_continue_play") boolean r5);

    @GET("/webcast/profit_open_game/anchor/app_guide")
    Single<ExtraResponse<a, OpenPlatformRespExtra>> switchToGuide(@Query("mini_app_id") String r1, @Query("guide_type") int r2);
}
