package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import android.graphics.Bitmap;
import ca0.l;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.g;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.lynx.fresco.FrescoImagePrefetchHelper;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftWallPreRequestManager implements l, o {
    public static final ReadOnlyProperty l = null;
    public static final ReadOnlyProperty m = null;
    public static final a n = null;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final CompositeDisposable d;
    public final a.C0057a e;
    public final HashMap<String, Pair<Long, JsonObject>> f;
    public final HashMap<String, Pair<Long, JsonObject>> g;
    public String h;
    public String i;
    public final k j;
    public final SendGiftRelationService k;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.giftwall.GiftWallPreRequestManager$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/giftwall/GiftWallPreRequestManager$a$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "giftImageWebp", "Z", "b", "()Z", BuildConfig.FLAVOR, "prefetchType", "I", "getPrefetchType", "()I", "bitmapCache", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0057a {

            @SerializedName("bitmap_cache")
            private final boolean bitmapCache;

            @SerializedName("gift_image_webp")
            private final boolean giftImageWebp;

            @SerializedName("prefetch_type")
            private final int prefetchType;

            public C0057a() {
                this(0);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0057a) == false) goto L12;
                C0057a r4 = (C0057a) r3;
                if (this.giftImageWebp == r4.giftImageWebp) goto L8;
                return false;
            L8:
                if (this.prefetchType == r4.prefetchType) goto L10;
                return false;
            L10:
                if (this.bitmapCache == r4.bitmapCache) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public final int hashCode() {
                boolean r0 = this.giftImageWebp;
                ?? r1 = 1;
                ?? r2 = r0;
                if (r0 == false) goto L5;
                r2 = 1;
            L5:
                int r3 = ((r2 * 31) + this.prefetchType) * 31;
                boolean r4 = this.bitmapCache;
                if (r4 == true) goto L10;
                r1 = r4;
            L10:
                return r3 + r1;
            }

            public final String toString() {
                return "GiftWallImageOpt(giftImageWebp=" + this.giftImageWebp + ", prefetchType=" + this.prefetchType + ", bitmapCache=" + this.bitmapCache + ")";
            }

            public final boolean c() {
                if (this.prefetchType == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public final boolean d() {
                if (this.prefetchType != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public final boolean a() {
                return this.bitmapCache;
            }

            public final boolean b() {
                return this.giftImageWebp;
            }

            public C0057a(int r1) {
                this.giftImageWebp = false;
                this.prefetchType = 0;
                this.bitmapCache = false;
            }
        }

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "ENABLE_GIFT_WALL_PRE_REQUEST", "getENABLE_GIFT_WALL_PRE_REQUEST()Z", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "GIFT_WALL_IMAGE_OPT_CONFIG", "getGIFT_WALL_IMAGE_OPT_CONFIG()Lcom/bytedance/android/livesdk/gift/platform/business/giftwall/GiftWallPreRequestManager$Companion$GiftWallImageOpt;", 0))};
        }

        public a() {
        }

        public static boolean a() {
            return ((Boolean) GiftWallPreRequestManager.l.getValue(GiftWallPreRequestManager.n, a[0])).booleanValue();
        }
    }

    public final void f() {
        this.i = null;
    }

    public final void onStart() {
    }

    static {
        n = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_wall_pre_request_enable", Boolean.FALSE, Boolean.TYPE, false);
        KProperty[] r1 = a.a;
        KProperty r10 = r1[0];
        l = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r2 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_gift_wall_image_opt_config", new a.C0057a(0), a.C0057a.class, false);
        KProperty r8 = r1[1];
        m = UltraSettingsManager.a().a(r2.a, r2.b, r2.getType(), r2.d, r8);
    }

    public final JsonObject h() {
        n.getClass();
        if (a.a() == false) goto L5;
        String r0 = this.h;
        if (r0 != null) goto L9;
        r0 = (String) this.b.getValue();
    L9:
        final Pair<Long, JsonObject> r1 = this.f.get(r0);
        final Pair<Long, JsonObject> r2 = this.g.get(r0);
        if (r1 == null) goto L19;
        if (r2 == null) goto L19;
        if (this.e.c() == false) goto L16;
        g.a(true, new GiftWallPreRequestManager$buildExhibitionData$1(this, r2, r1));
    L16:
        JsonObject r3 = new JsonObject();
        r3.addProperty("user_id", r0);
        r3.addProperty("home_data", ((JsonObject) r1.getSecond()).toString());
        r3.addProperty("rare_data", ((JsonObject) r2.getSecond()).toString());
        r3.addProperty("fetch_time", String.valueOf(((Number) r1.getFirst()).longValue()));
        return r3;
    L19:
        return new JsonObject();
    L5:
        return new JsonObject();
    }

    public final void onStop() {
        this.d.dispose();
    }

    public final void a(final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        if (this.e.b() == true) goto L5;
        return;
    L5:
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "json");
        f.b(new GiftWallWebpImageUtils$convertRareGiftImageUrl$1(r3));
    }

    public final void c(final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "json");
        if (this.e.b() == true) goto L5;
        return;
    L5:
        f.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "json");
        f.b(new GiftWallWebpImageUtils$convertHomeGiftImageUrl$1(r3));
    }

    public final void d(String r27) {
        Intrinsics.checkNotNullParameter(r27, "userId");
        if (((Boolean) this.c.getValue()).booleanValue() == true) goto L30;
        n.getClass();
        if (a.a() == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r27, this.i) == false) goto L10;
        return;
    L10:
        this.i = r27;
        jy0.b.a("ttlive_gift_wall", "onUserProfileShow uid=" + r27 + ", fetchExhibitionData");
        tz0.b r2 = tz0.b.a;
        uz0.c r3 = new uz0.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "$this$beforeConfigureRequest");
        x.a(r3, false);
        Map r4 = ((uz0.a) r3).b;
        Intrinsics.checkNotNullParameter(r4, "queriesMap");
        String r6 = Long.valueOf(((Number) this.a.getValue()).longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r6 == null) goto L13;
        r4.put("room_id", r6);
    L13:
        Integer r7 = 4;
        String r8 = r7.toString();
        Intrinsics.checkNotNullParameter("exhibition_source", "$this$setTo");
        if (r8 == null) goto L16;
        r4.put("exhibition_source", r8);
    L16:
        Intrinsics.checkNotNullParameter("anchor_id", "$this$setTo");
        if (r27 == null) goto L19;
        r4.put("anchor_id", r27);
    L19:
        Intrinsics.checkNotNullParameter("target_open_uid", "$this$setTo");
        if (r27 == null) goto L22;
        r4.put("target_open_uid", r27);
    L22:
        Intrinsics.checkNotNullParameter(r3, "$this$afterConfigureRequest");
        INetworkService r5 = com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class);
        INetworkService.Biz r17 = INetworkService.Biz.Revenue;
        Observable r9 = r5.x0(r17, "/webcast/gift/exhibition/home/", TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)), Extra.class, ((uz0.a) r3).d, ((uz0.a) r3).a, ((uz0.a) r3).b, ((uz0.a) r3).c).map(new d(this));
        uz0.c r10 = new uz0.c();
        Intrinsics.checkNotNullParameter(r10, "$this$beforeConfigureRequest");
        x.a(r10, false);
        Map r11 = ((uz0.a) r10).b;
        Intrinsics.checkNotNullParameter(r11, "queriesMap");
        String r13 = Long.valueOf(((Number) this.a.getValue()).longValue()).toString();
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        if (r13 == null) goto L25;
        r11.put("room_id", r13);
    L25:
        Intrinsics.checkNotNullParameter("target_open_uid", "$this$setTo");
        if (r27 == null) goto L28;
        r11.put("target_open_uid", r27);
    L28:
        Intrinsics.checkNotNullParameter(r10, "$this$afterConfigureRequest");
        RxUtilKt.c(Observable.zip(r9, com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class).x0(r17, "/webcast/gift/exhibition/rare/", TypesJVMKt.getJavaType(Reflection.typeOf(JsonObject.class)), Extra.class, ((uz0.a) r10).d, ((uz0.a) r10).a, ((uz0.a) r10).b, ((uz0.a) r10).c).map(new e(this)), com.bytedance.android.livesdk.gift.platform.business.giftwall.a.a).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r27), new c(r27)), this.d);
        return;
    }

    public GiftWallPreRequestManager(k r3, SendGiftRelationService r4) {
        Intrinsics.checkNotNullParameter(r3, "roomDataService");
        Intrinsics.checkNotNullParameter(r4, "sendGiftRelationService");
        this.j = r3;
        this.k = r4;
        this.a = LazyKt.lazy(new GiftWallPreRequestManager$roomId$2(this));
        this.b = LazyKt.lazy(new GiftWallPreRequestManager$anchorId$2(this));
        this.c = LazyKt.lazy(new GiftWallPreRequestManager$isAnchor$2(this));
        this.d = new CompositeDisposable();
        a r5 = n;
        r5.getClass();
        this.e = (a.C0057a) m.getValue(r5, a.a[1]);
        this.f = new HashMap();
        this.g = new HashMap();
    }

    public static final String j(GiftWallPreRequestManager r1, JsonElement r2) {
        r1.getClass();
        Object r3 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        JsonElement r4 = (JsonElement) CollectionsKt.firstOrNull(r2.getAsJsonObject().get("gift").getAsJsonObject().get("image").getAsJsonObject().get("url_list").getAsJsonArray());     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        String r5 = r4.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == true) goto L16;
        r3 = r6;
    L16:
        return (String) r3;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static final void k(GiftWallPreRequestManager r1, String r2) {
        if (r1.e.a() == false) goto L5;
        FrescoImagePrefetchHelper.prefetchImageToBitmapCache(r2, Bitmap.Config.ARGB_8888, "gift_wall_icon_prefetch_bitmap");
        return;
    L5:
        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r2), "gift_wall_icon_prefetch_disk");
    }

    public final String g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L15;
        n.getClass();
        if (a.a() == false) goto L15;
        this.h = r2;
        x0 r4 = new x0(r3);
        r4.b("initialProps", "[gift_exhibition_data]");
        return r4.toString();
    L15:
        return r3;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static final void i(GiftWallPreRequestManager r7, JsonObject r8, String r9) {
        r7.getClass();
        JsonArray r0 = r8.getAsJsonArray("url_list");
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((JsonElement) r2.next()).getAsString());
        goto L4
    L6:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L7:
        ArrayList r5 = null;
        if (r4.hasNext() == false) goto L12;
        Object r6 = r4.next();
        if (StringsKt.endsWith$default((String) r6, r9, false, 2, null) == false) goto L7;
        r3.add(r6);
        goto L7
    L12:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r3.iterator();
    L14:
        if (r11.hasNext() == false) goto L19;
        String r13 = (String) r11.next();
        int r14 = RevenueImageUrlService.c;
        String r15 = RevenueImageUrlService.a.b(r13, r9, true);
        if (r15 == null) goto L14;
        r10.add(r15);
        goto L14
    L19:
        if ((!r10.isEmpty()) == false) goto L21;
        r5 = r10;
    L21:
        if (r5 == null) goto L40;
        JsonArray r16 = new JsonArray();
        Iterator r17 = r5.iterator();
    L24:
        if (r17.hasNext() == false) goto L26;
        r16.add((String) r17.next());
        goto L24
    L26:
        r8.add("url_list", r16);
        return;
    }
}
