package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.m01;
import com.bytedance.android.livesdk.config.q91;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public static final Set<String> c = null;
    public String a;
    public long b;

    public static final class a {
    }

    public final /* synthetic */ JsonElement a(String r1) {
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r1);
    }

    public final com.bytedance.android.annie.api.data.subscribe.g<JsonObject> c() {
        return this;
    }

    public final char d() {
        return ':';
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* bridge */ /* synthetic */ Object g() {
        return null;
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    static {
        c = SetsKt.setOf(new String[]{"user_id", "room_id", "anchor_id"});
    }

    public final String key() {
        int r0 = com.bytedance.android.live.browser.jsbridge.i.g.b.b;
        return "localCache";
    }

    public c() {
        this.a = "";
    }

    public final JsonElement j(String r11) {
        com.bytedance.android.livesdk.log.g r0 = u.l();
        CacheStatus r2 = CacheStatus.HIT_CACHE;
        r0.sendLog("livesdk_rd_cache_stat", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", String.valueOf(this.a)), TuplesKt.to("status_code", String.valueOf(r2.getCode())), TuplesKt.to("cost_time", String.valueOf(System.currentTimeMillis() - this.b))}), new Object[0]);
        Gson r1 = com.bytedance.android.annie.api.data.subscribe.d.a;
        return com.bytedance.android.annie.api.data.subscribe.d.b(new b(r11, r2.getCode(), System.currentTimeMillis() - this.b, null));
    }

    public static String k(String r4, u6 r5) {
        boolean r1 = false;
        if (StringsKt.startsWith$default(r4, "{", false, 2, null) == true) goto L5;
        return r4;
    L5:
        if (StringsKt.endsWith$default(r4, "}", false, 2, null) == false) goto L44;
        String r6 = r4.substring(1, r4.length() - 1);
        String r7 = r5.a(r6);
        if (r7 != null) goto L9;
    L10:
        r1 = true;
    L11:
        if (r1 == false) goto L46;
        if (c.contains(r6) == false) goto L41;
        if (Intrinsics.areEqual(r6, "user_id") == false) goto L22;
        IUserService r8 = jc1.k.f(IUserService.class);
        if (r8 == null) goto L35;
        com.bytedance.android.livesdk.user.f r9 = r8.user();
        if (r9 == null) goto L35;
        String r11 = r9.n();
    L36:
        if (r11 == null) goto L39;
        return r11;
    L39:
        throw new QueryFailedException("get query failed");
    L35:
        r11 = null;
        goto L36
    L22:
        if (Intrinsics.areEqual(r6, "room_id") == false) goto L29;
        IRoomService r12 = jc1.k.f(IRoomService.class);
        if (r12 == null) goto L35;
        Room r13 = r12.getCurrentRoomFromRoomContext();
        if (r13 == null) goto L35;
        r11 = r13.getIdStr();
        goto L36
    L29:
        if (Intrinsics.areEqual(r6, "anchor_id") == false) goto L35;
        IRoomService r14 = jc1.k.f(IRoomService.class);
        if (r14 == null) goto L35;
        Room r15 = r14.getCurrentRoomFromRoomContext();
        if (r15 == null) goto L35;
        r11 = r15.getOwnerUserIdString();
        goto L36
    L41:
        throw new QueryFailedException("get query failed");
    L46:
        return r7;
    L9:
        if (StringsKt.isBlank(r7) == false) goto L11;
    L44:
        throw new IllegalKeyException("illegal key " + r4);
    }

    public final JsonElement e(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, LiveSlardarConstants.EXTRA_KEY_URL);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L30
        this.b = System.currentTimeMillis();     // Catch: Throwable -> L30
        u6 r1 = new u6(r12);     // Catch: Throwable -> L30
        this.a = r1.c().getPath();     // Catch: Throwable -> L30
        List r13 = ((q91) m01.a.getValue()).a();     // Catch: Throwable -> L30
        if (r13 == null) goto L6;
        int r14 = CollectionsKt.indexOf(r13, this.a);     // Catch: Throwable -> L30
    L7:
        if (r14 >= 0) goto L9;
        JsonElement r15 = i(CacheStatus.NOT_IN_ALLOW_LIST, "not in white list");     // Catch: Throwable -> L30
    L28:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L30
    L32:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L43;
        if ((r17 instanceof IllegalKeyException) == false) goto L39;
        r16 = i(CacheStatus.ILLEGAL_KEY, r17.getMessage());
        goto L43
    L39:
        if ((r17 instanceof QueryFailedException) == false) goto L41;
        r16 = i(CacheStatus.ILLEGAL_KEY, r17.getMessage());
        goto L43
    L41:
        r16 = i(CacheStatus.OTHER_ERROR, r17.getMessage());
    L43:
        return (JsonElement) r16;
    L9:
        List r18 = StringsKt.split$default(r11, new String[]{"-"}, false, 0, 6, null);     // Catch: Throwable -> L30
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));     // Catch: Throwable -> L30
        Iterator r19 = r18.iterator();     // Catch: Throwable -> L30
    L11:
        if (r19.hasNext() == false) goto L13;
        r2.add(k((String) r19.next(), r1));     // Catch: Throwable -> L30
        goto L11
    L13:
        String r110 = CollectionsKt.joinToString$default(r2, "-", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L30
        Pair r111 = com.bytedance.android.live.schema.helper.f.a(r110);     // Catch: Throwable -> L30
        boolean r3 = ((Boolean) r111.component1()).booleanValue();     // Catch: Throwable -> L30
        String r112 = (String) r111.component2();     // Catch: Throwable -> L30
        if (r112 != null) goto L21;
        if (r3 == false) goto L19;
        return i(CacheStatus.MISS_CACHE, "fail to find " + r110);
    L19:
        return i(CacheStatus.INVALID_CACHE, "cache invalid " + r110);
    L21:
        if (r112.length() != 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L26;
        r15 = j(r112);     // Catch: Throwable -> L30
        goto L28
    L26:
        return i(CacheStatus.MISS_CACHE, "fail to find " + r110);
    L23:
        r4 = false;
        goto L24
    L6:
        r14 = -1;
    L30:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }

    public final JsonElement i(CacheStatus r9, String r11) {
        u.l().sendLog("livesdk_rd_cache_stat", MapsKt.mapOf(new Pair[]{TuplesKt.to("path", String.valueOf(this.a)), TuplesKt.to("status_code", String.valueOf(r9.getCode())), TuplesKt.to("cost_time", String.valueOf(System.currentTimeMillis() - this.b))}), new Object[0]);
        Gson r0 = com.bytedance.android.annie.api.data.subscribe.d.a;
        return com.bytedance.android.annie.api.data.subscribe.d.b(new b(null, r9.getCode(), System.currentTimeMillis() - this.b, r11));
    }
}
