package com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex;

import android.content.SharedPreferences;
import android.net.Uri;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.config.s00;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gd0.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class InitialProps {
    public static final Lazy a = null;
    public static final Map<String, a> b = null;
    public static final Map<String, a> c = null;
    public static final InitialProps d = null;

    public interface a {
        JsonObject a(List<String> r1, DataCenter r2);
    }

    public static final class b implements a {
        public b() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps.a
        public final JsonObject a(List<String> r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            JsonObject r4 = SettingUtil.getGson().toJsonTree(je0.d.e(r3)).getAsJsonObject();     // Catch: Throwable -> L5
        L7:
            if (r4 == null) goto L9;
            return r4;
        L9:
            return new JsonObject();
        L5:
            th = move-exception;
            ALogger.e("CurrentRoomState", "room to jsonObject error, error: " + th);
            r4 = null;
            goto L7
        }
    }

    public static final class c implements a {
        public c() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps.a
        public final JsonObject a(List<String> r2, DataCenter r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            JsonObject r4 = SettingUtil.getGson().toJsonTree(k.n(IMiddlewareUserService.class).user().b()).getAsJsonObject();     // Catch: Throwable -> L5
        L7:
            if (r4 == null) goto L9;
            return r4;
        L9:
            return new JsonObject();
        L5:
            th = move-exception;
            ALogger.e("CurrentUserState", "user to jsonObject error, error: " + th);
            r4 = null;
            goto L7
        }
    }

    public static final class d implements a {

        public static final class a {
        }

        static {
        }

        public d() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps.a
        public final JsonObject a(List<String> r9, DataCenter r10) {
            Intrinsics.checkNotNullParameter(r9, "params");
            JsonObject r11 = new JsonObject();
            r11.addProperty("link_audience_state", (Number) ((ge1.a) hd0.c.f()).b);
            boolean r0 = k.n(IMiddlewareRoomService.class).isRecording();
            int r1 = 1;
            int r2 = 0;
            if (r0 != true) goto L5;
            int r3 = 1;
        L7:
            r11.addProperty("is_recording", Integer.valueOf(r3));
            yr0.d r4 = k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal();
            r11.addProperty("channel_id", Long.valueOf(r4.getChannelId()));
            r11.addProperty("pk_id", Long.valueOf(r4.getPkId()));
            r11.addProperty("pk_time", Long.valueOf(r4.getDuration()));
            r11.addProperty("right_user_id", r4.a());
            r11.addProperty("match_type", Integer.valueOf(r4.getMatchType()));
            int r5 = UserListInviteType.a;
            Integer r6 = null;
            r11.addProperty("invitee_list", UserListInviteType.a(r4.getInviteType(), null));
            r11.addProperty("connection_type", ((IInteractService) k.n(IInteractService.class)).getLinkConnectionType());
            boolean r7 = je0.d.r();
            if (r10 == null) goto L10;
            r6 = (Integer) r10.get("data_link_state", 0);
        L10:
            r11.addProperty("link_mode", r6);
            r11.addProperty("scene", Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()));
            r11.addProperty("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
            r11.addProperty("self_in_video_talk", Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getVideoTalkService().u(r7, k.n(IMiddlewareUserService.class).user().n()) ? 1 : 0));
            Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
            if (r8 != null) goto L14;
        L17:
            r11.addProperty("is_ktv_guest", Integer.valueOf(r1));
            com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.c.v1;
            String r13 = "1";
            if (((Boolean) r12.getValue()).booleanValue() == false) goto L20;
            String r14 = "1";
        L21:
            r11.addProperty("video_talk_admin_operate", r14);
            if (((Boolean) r12.getValue()).booleanValue() == false) goto L24;
            String r15 = "1";
        L25:
            r11.addProperty("audio_chat_admin_operate", r15);
            if (((Boolean) r12.getValue()).booleanValue() == true) goto L29;
            r13 = "0";
        L29:
            r11.addProperty("intimate_chat_admin_operate", r13);
            if (((Boolean) s00.a.getValue()).booleanValue() == false) goto L42;
            if (r10 == null) goto L36;
            Integer r16 = (Integer) r10.get("data_link_state", 0);
            if (r16 == null) goto L36;
            r2 = r16.intValue();
        L36:
            if (v.a(r2, 32) == false) goto L38;
        L41:
            r11.addProperty("is_support_pk", 0);
            goto L42
        L38:
            if (v.a(r2, 8) == true) goto L41;
            if (v.a(r2, 2) == true) goto L41;
        L42:
            return r11;
        L24:
            r15 = "0";
            goto L25
        L20:
            r14 = "0";
            goto L21
        L14:
            if (r8.intValue() != 0) goto L17;
            r1 = 0;
            goto L17
        L5:
            if (r0 == true) goto L44;
            r3 = 0;
            goto L7
        L44:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class e implements a {
        public e() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps.a
        public final JsonObject a(List<String> r5, DataCenter r6) {
            Intrinsics.checkNotNullParameter(r5, "params");
            JsonObject r7 = new JsonObject();
            Iterator<T> r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L22;
            String r0 = (String) r8.next();
            Intrinsics.checkNotNullParameter(r0, "key");
            Gson r1 = SettingUtil.getGson();
            Object r2 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r0);
            if (r2 != null) goto L8;
            JsonElement r3 = null;
        L21:
            r7.add(r0, r3);
            goto L4
        L8:
            if ((r2 instanceof JSONObject) == false) goto L11;
            r3 = GsonProtectorUtils.toJsonTree(r1, GsonProtectorUtils.fromJson(r1, r2.toString(), Object.class));
            goto L21
        L11:
            if ((r2 instanceof JSONArray) == false) goto L14;
            r3 = GsonProtectorUtils.toJsonTree(r1, GsonProtectorUtils.fromJson(r1, r2.toString(), new g().getType()));
            goto L21
        L14:
            if ((r2 instanceof Boolean) == true) goto L16;
            r3 = GsonProtectorUtils.toJsonTree(r1, r2);
            goto L21
        L16:
            if (((Boolean) r2).booleanValue() == false) goto L18;
            r3 = GsonProtectorUtils.toJsonTree(r1, 1);
            goto L21
        L18:
            r3 = GsonProtectorUtils.toJsonTree(r1, 0);
            goto L21
        L22:
            return r7;
        }
    }

    public static final class f implements a {
        public f() {
        }

        @Override // com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.InitialProps.a
        public final JsonObject a(List<String> r5, DataCenter r6) {
            Intrinsics.checkNotNullParameter(r5, "params");
            JsonObject r7 = new JsonObject();
            Iterator<T> r8 = r5.iterator();
        L4:
            if (r8.hasNext() == false) goto L6;
            String r0 = (String) r8.next();
            Intrinsics.checkNotNullParameter(r0, "key");
            SharedPreferences r1 = s1.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
            JsonObject r2 = new JsonObject();
            r2.addProperty(r0, r1.getString(r0, ""));
            r7.add(r0, r2);
            goto L4
        L6:
            return r7;
        }
    }

    public InitialProps() {
    }

    static {
        d = new InitialProps();
        a = LazyKt.lazy(InitialProps$slowFunctionOpt$2.INSTANCE);
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to("storage", new f()), TuplesKt.to("setting", new e()), TuplesKt.to("current_user", new c()), TuplesKt.to("current_room", new b()), TuplesKt.to("linkmic", new d())});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to("storage", new f()), TuplesKt.to("setting", new e()), TuplesKt.to("current_user", new c()), TuplesKt.to("linkmic", new d())});
    }

    public static GsonMap a(Uri r11, Uri r12, DataCenter r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "scheme");
        Intrinsics.checkNotNullParameter(r12, "url");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L36
        String r15 = UriProtector.getQueryParameter(r11, "initialProps");     // Catch: Throwable -> L36
        if (r15 != null) goto L67;
    L23:
        String r16 = UriProtector.getQueryParameter(r12, "initialProps");     // Catch: Throwable -> L36
        if (r16 != null) goto L71;
        JSONArray r17 = null;
    L34:
        Object r18 = Result.constructor-impl(r17);     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r18) == false) goto L41;
        r18 = null;
    L41:
        JSONArray r19 = (JSONArray) r18;
        if (r19 != null) goto L44;
        return null;
    L44:
        Lazy r110 = LazyKt.lazy(InitialProps$parse$job$1.INSTANCE);
        int r0 = r19.length();
        int r5 = 0;
    L45:
        if (r5 >= r0) goto L63;
        List r6 = StringsKt.split$default(r19.optString(r5), new String[]{":"}, false, 0, 6, null);
        String r7 = (String) ListProtector.get(r6, 0);
        if (r14 == false) goto L49;
    L56:
        a r8 = b.get(r7);
        if (r8 == null) goto L61;
        JsonObject r9 = r8.a(CollectionsKt.slice(r6, RangesKt.until(1, r6.size())), r13);
        if (r9 == null) goto L61;
        ((JsonObject) r110.getValue()).add(r7, r9);
    L61:
        r5 = r5 + 1;
        goto L45
    L49:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L56;
        a r10 = c.get(r7);
        if (r10 == null) goto L61;
        JsonObject r20 = r10.a(CollectionsKt.slice(r6, RangesKt.until(1, r6.size())), r13);
        if (r20 == null) goto L61;
        ((JsonObject) r110.getValue()).add(r7, r20);
        goto L61
    L63:
        if (r110.isInitialized() == true) goto L66;
        return null;
    L66:
        return UtilsKt.i((JsonObject) r110.getValue());
    L71:
        Object r111 = Result.constructor-impl(new JSONArray(r16));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r111) == false) goto L32;
        r111 = null;
    L32:
        r17 = (JSONArray) r111;     // Catch: Throwable -> L36
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        r111 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
        goto L30
    L67:
        Object r113 = Result.constructor-impl(new JSONArray(r15));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r113) == false) goto L12;
        r113 = null;
    L12:
        r17 = (JSONArray) r113;     // Catch: Throwable -> L36
        if (r17 == null) goto L23;
        if (r17.length() <= 0) goto L17;
        boolean r21 = true;
    L18:
        if (r21 == true) goto L21;
        r17 = null;
    L21:
        if (r17 == null) goto L23;
    L17:
        r21 = false;
    L7:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L36
        r113 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }
}
