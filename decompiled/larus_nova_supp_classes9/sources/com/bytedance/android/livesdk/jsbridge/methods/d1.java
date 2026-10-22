package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.jsbridge.methods.draft.RxDownloadApi$download$1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.SerializedName;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d1 extends com.bytedance.ies.web.jsbridge2.f<b, Object> {
    public final WeakReference<Context> a;
    public final com.bytedance.android.livesdk.jsbridge.methods.draft.l b;
    public final CompositeDisposable c;
    public Disposable d;
    public km3.g e;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010&\u001a\u00020%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "videoId", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "videoUrl", "m", "title", "j", "type", "getType", "roomId", "e", "roomTime", "f", BuildConfig.FLAVOR, "createTime", "J", "a", "()J", "startTime", "i", "endTime", "b", "shootWay", "g", "fragmentId", "c", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "shoppingExtras", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "h", "()Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", "promotionId", "d", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "trackExtras", "Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "k", "()Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", "cover", "getCover", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("cover")
        private final String cover;

        @SerializedName("create_time")
        private final long createTime;

        @SerializedName("end_time")
        private final long endTime;

        @SerializedName("fragment_id")
        private final String fragmentId;

        @SerializedName("promotion_id")
        private final String promotionId;

        @SerializedName("room_id")
        private final String roomId;

        @SerializedName("room_time")
        private final String roomTime;

        @SerializedName("shoot_way")
        private final String shootWay;

        @SerializedName("shopping_extras")
        private final c shoppingExtras;

        @SerializedName("start_time")
        private final long startTime;

        @SerializedName("title")
        private final String title;

        @SerializedName("track_extras")
        private final d trackExtras;

        @SerializedName("type")
        private final String type;

        @SerializedName("video_id")
        private final String videoId;

        @SerializedName("video_url")
        private final String videoUrl;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L36;
            b r7 = (b) r6;
            if (Intrinsics.areEqual(this.videoId, r7.videoId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.videoUrl, r7.videoUrl) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r7.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r7.type) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.roomId, r7.roomId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.roomTime, r7.roomTime) == true) goto L18;
            return false;
        L18:
            if (this.createTime == r7.createTime) goto L20;
            return false;
        L20:
            if (this.startTime == r7.startTime) goto L22;
            return false;
        L22:
            if (this.endTime == r7.endTime) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.shootWay, r7.shootWay) == true) goto L26;
            return false;
        L26:
            if (Intrinsics.areEqual(this.fragmentId, r7.fragmentId) == true) goto L28;
            return false;
        L28:
            if (Intrinsics.areEqual(this.shoppingExtras, r7.shoppingExtras) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.promotionId, r7.promotionId) == true) goto L32;
            return false;
        L32:
            if (Intrinsics.areEqual(this.trackExtras, r7.trackExtras) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.cover, r7.cover) == true) goto L55;
            return false;
        L55:
            return true;
        L36:
            return false;
        }

        public final int hashCode() {
            String r0 = this.videoId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.videoUrl;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.title;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.type;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            String r14 = this.roomId;
            if (r14 == null) goto L21;
            int r15 = r14.hashCode();
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.roomTime;
            if (r17 == null) goto L25;
            int r18 = r17.hashCode();
        L26:
            int r19 = (r16 + r18) * 31;
            long r20 = this.createTime;
            int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
            long r23 = this.startTime;
            int r24 = (r21 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
            long r25 = this.endTime;
            int r26 = (r24 + ((int) (r25 ^ (r25 >>> 32)))) * 31;
            String r27 = this.shootWay;
            if (r27 == null) goto L29;
            int r28 = r27.hashCode();
        L30:
            int r29 = (r26 + r28) * 31;
            String r30 = this.fragmentId;
            if (r30 == null) goto L33;
            int r31 = r30.hashCode();
        L34:
            int r33 = (r29 + r31) * 31;
            c r34 = this.shoppingExtras;
            if (r34 == null) goto L37;
            int r35 = r34.hashCode();
        L38:
            int r36 = (r33 + r35) * 31;
            String r37 = this.promotionId;
            if (r37 == null) goto L41;
            int r38 = r37.hashCode();
        L42:
            int r39 = (r36 + r38) * 31;
            d r40 = this.trackExtras;
            if (r40 == null) goto L45;
            int r41 = r40.hashCode();
        L46:
            int r43 = (r39 + r41) * 31;
            String r44 = this.cover;
            if (r44 == null) goto L50;
            r1 = r44.hashCode();
        L50:
            return r43 + r1;
        L45:
            r41 = 0;
            goto L46
        L41:
            r38 = 0;
            goto L42
        L37:
            r35 = 0;
            goto L38
        L33:
            r31 = 0;
            goto L34
        L29:
            r28 = 0;
            goto L30
        L25:
            r18 = 0;
            goto L26
        L21:
            r15 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", title=" + this.title + ", type=" + this.type + ", roomId=" + this.roomId + ", roomTime=" + this.roomTime + ", createTime=" + this.createTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", shootWay=" + this.shootWay + ", fragmentId=" + this.fragmentId + ", shoppingExtras=" + this.shoppingExtras + ", promotionId=" + this.promotionId + ", trackExtras=" + this.trackExtras + ", cover=" + this.cover + ")";
        }

        public b() {
            c r0 = new c(0);
            d r2 = new d(0);
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "videoId");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "videoUrl");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "title");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "type");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "roomId");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "roomTime");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "shootWay");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "fragmentId");
            Intrinsics.checkNotNullParameter(r0, "shoppingExtras");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "promotionId");
            Intrinsics.checkNotNullParameter(r2, "trackExtras");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "cover");
            this.videoId = BuildConfig.FLAVOR;
            this.videoUrl = BuildConfig.FLAVOR;
            this.title = BuildConfig.FLAVOR;
            this.type = BuildConfig.FLAVOR;
            this.roomId = BuildConfig.FLAVOR;
            this.roomTime = BuildConfig.FLAVOR;
            this.createTime = -1;
            this.startTime = -1;
            this.endTime = -1;
            this.shootWay = BuildConfig.FLAVOR;
            this.fragmentId = BuildConfig.FLAVOR;
            this.shoppingExtras = r0;
            this.promotionId = BuildConfig.FLAVOR;
            this.trackExtras = r2;
            this.cover = BuildConfig.FLAVOR;
        }

        public final long a() {
            return this.createTime;
        }

        public final long b() {
            return this.endTime;
        }

        public final String c() {
            return this.fragmentId;
        }

        public final String d() {
            return this.promotionId;
        }

        public final String e() {
            return this.roomId;
        }

        public final String f() {
            return this.roomTime;
        }

        public final String g() {
            return this.shootWay;
        }

        public final String getType() {
            return this.type;
        }

        public final c h() {
            return this.shoppingExtras;
        }

        public final long i() {
            return this.startTime;
        }

        public final String j() {
            return this.title;
        }

        public final d k() {
            return this.trackExtras;
        }

        public final String l() {
            return this.videoId;
        }

        public final String m() {
            return this.videoUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "I", "getType", "()I", BuildConfig.FLAVOR, "content", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "title", "c", "source", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("anchor_content")
        private final String content;

        @SerializedName("source")
        private final int source;

        @SerializedName("anchor_title")
        private final String title;

        @SerializedName("anchor_business_type")
        private final int type;

        public c() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof c) == false) goto L14;
            c r4 = (c) r3;
            if (this.type == r4.type) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.content, r4.content) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.title, r4.title) == true) goto L12;
            return false;
        L12:
            if (this.source == r4.source) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r0 = this.type * 31;
            String r1 = this.content;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.title;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return ((r4 + r2) * 31) + this.source;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "ShoppingExtras(type=" + this.type + ", content=" + this.content + ", title=" + this.title + ", source=" + this.source + ")";
        }

        public final String a() {
            return this.content;
        }

        public final int b() {
            return this.source;
        }

        public final String c() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public c(int r2) {
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "content");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "title");
            this.type = -1;
            this.content = BuildConfig.FLAVOR;
            this.title = BuildConfig.FLAVOR;
            this.source = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/d1$d;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "anchorId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "commodityId", "b", BuildConfig.FLAVOR, "commodityType", "I", "c", "()I", "isEcom", "f", "pageName", "d", "sourcePage", "e", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("anchor_id")
        private final String anchorId;

        @SerializedName("commodity_id")
        private final String commodityId;

        @SerializedName("commodity_type")
        private final int commodityType;

        @SerializedName("is_ecom")
        private final String isEcom;

        @SerializedName("page_name")
        private final String pageName;

        @SerializedName("source_page")
        private final String sourcePage;

        public d() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L18;
            d r4 = (d) r3;
            if (Intrinsics.areEqual(this.anchorId, r4.anchorId) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.commodityId, r4.commodityId) == true) goto L10;
            return false;
        L10:
            if (this.commodityType == r4.commodityType) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.isEcom, r4.isEcom) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.sourcePage, r4.sourcePage) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r0 = this.anchorId;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.commodityId;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (((r3 + r5) * 31) + this.commodityType) * 31;
            String r7 = this.isEcom;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.pageName;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            String r14 = this.sourcePage;
            if (r14 == null) goto L22;
            r1 = r14.hashCode();
        L22:
            return r13 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TrackExtras(anchorId=" + this.anchorId + ", commodityId=" + this.commodityId + ", commodityType=" + this.commodityType + ", isEcom=" + this.isEcom + ", pageName=" + this.pageName + ", sourcePage=" + this.sourcePage + ")";
        }

        public final String a() {
            return this.anchorId;
        }

        public final String b() {
            return this.commodityId;
        }

        public final int c() {
            return this.commodityType;
        }

        public final String d() {
            return this.pageName;
        }

        public final String e() {
            return this.sourcePage;
        }

        public final String f() {
            return this.isEcom;
        }

        public d(int r2) {
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "anchorId");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "commodityId");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "isEcom");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "pageName");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "sourcePage");
            this.anchorId = BuildConfig.FLAVOR;
            this.commodityId = BuildConfig.FLAVOR;
            this.commodityType = 0;
            this.isEcom = BuildConfig.FLAVOR;
            this.pageName = BuildConfig.FLAVOR;
            this.sourcePage = BuildConfig.FLAVOR;
        }
    }

    static {
    }

    public final void onTerminate() {
        this.c.clear();
    }

    public d1(Context r2) {
        this.a = new WeakReference(r2);
        this.b = new com.bytedance.android.livesdk.jsbridge.methods.draft.l();
        this.c = new CompositeDisposable();
    }

    public final void invoke(Object r30, CallContext r31) {
        b r1 = (b) r30;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r31, "callContext");
        String r3 = r1.getType();
        int r4 = r3.hashCode();
        if (r4 == (-681210700)) goto L9;
        if (r4 != 3322092) goto L24;
        r3.equals("live");
        return;
    L24:
        return;
    L9:
        if (r3.equals("highlight") == false) goto L23;
        Context r5 = this.a.get();
        if (r5 == null) goto L25;
        com.bytedance.android.livesdk.jsbridge.methods.draft.l r6 = this.b;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r1, "params");
        String r2 = UriProtector.parse(r1.m()).getLastPathSegment();
        if (r2 != null) goto L16;
        r2 = "ts";
    L16:
        final String r7 = com.bytedance.android.livesdk.chatroom.record.u.c(com.bytedance.android.live.core.utils.s1.getContext(), r2);
        if (r7 != null) goto L19;
        Observable r8 = Observable.error(new Throwable("localPath is null"));
    L20:
        Disposable r9 = r8.subscribe(new e1(this), new f1(this, r1), new g1(this, r1));
        this.c.add(r9);
        this.d = r9;
        return;
    L19:
        String r10 = r1.l();
        String r11 = r1.j();
        String r13 = r1.getType();
        String r14 = r1.e();
        String r15 = r1.f();
        long r16 = r1.i();
        long r17 = r1.b();
        String r18 = r1.g();
        String r19 = r1.c();
        int r20 = r1.h().getType();
        String r21 = r1.h().a();
        String r23 = r1.h().c();
        int r24 = r1.h().b();
        Room r25 = new Room();
        r25.id = CastLongProtector.parseLong(r1.e());
        r25.setCreateTime(r1.a());
        com.bytedance.android.livesdk.user.f r26 = r6.c.user();
        User r27 = new User();
        r27.setIdStr(r26.b().getIdString());
        r27.setNickName(r26.b().getNickName());
        com.bytedance.android.livesdk.jsbridge.methods.draft.f r28 = new com.bytedance.android.livesdk.jsbridge.methods.draft.f(r7, r10, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r27, r1.h(), r1.d(), r1.k());
        final com.bytedance.android.livesdk.jsbridge.methods.draft.h r29 = r6.a;
        final String r33 = r1.m();
        r29.getClass();
        Intrinsics.checkNotNullParameter(r33, "url");
        Intrinsics.checkNotNullParameter(r7, "localPath");
        com.bytedance.android.livesdk.jsbridge.methods.draft.k r34 = r6.b;
        r34.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r28, "draft");
        com.bytedance.android.livesdk.jsbridge.methods.draft.k r35 = r6.b;
        r35.getClass();
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r28, "draft");
        r8 = Observable.concat(CollectionsKt.listOf(new Observable[]{Observable.create(new RxDownloadApi$download$1(r29, r33, r7)), Observable.create(new com.bytedance.android.livesdk.jsbridge.methods.draft.j(r34, r28, r5)), Observable.create(new com.bytedance.android.livesdk.jsbridge.methods.draft.i(r35, r28, r5))}));
        goto L20
    L25:
        return;
    }
}
