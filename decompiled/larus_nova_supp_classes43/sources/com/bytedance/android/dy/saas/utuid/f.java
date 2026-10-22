package com.bytedance.android.dy.saas.utuid;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.live.saas.middleware.utuid.UtUidInitTask;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements d {
    public static boolean a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static nd.a g;
    public static boolean h;
    public static final f i = null;

    public f() {
    }

    static {
        i = new f();
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String b() {
        String r0 = b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerUt");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String c() {
        String r0 = d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSecUt");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getSalt() {
        String r0 = f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getSecUid() {
        String r0 = e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSecUid");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getUid() {
        String r0 = c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerUid");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final boolean a() {
        return a;
    }

    public static final boolean d(Application r28, e r29, String r30) {
        f r10 = i;
        Random r11 = RandomKt.Random(System.currentTimeMillis());
        int r12 = r11.nextInt(1000000, 9999999);
        int r13 = c.a;
        String r14 = c.d(r12 + r29.c);
        if (r14 == null) goto L90;
        String r15 = r14.substring(0, 10);
        if (StringsKt.startsWith$default(r29.e, "enc_", false, 2, null) == false) goto L15;
        String r16 = r29.e;
        if (r16 == null) goto L14;
        String r17 = r16.substring(4);
        String r18 = c.d(r29.b);
        if (r18 == null) goto L12;
        String r19 = c.a(r17, r18.substring(0, 16));
    L17:
        if (StringsKt.startsWith$default(r29.d, "enc_", false, 2, null) == false) goto L27;
        String r20 = r29.d;
        if (r20 == null) goto L26;
        String r21 = r20.substring(4);
        String r110 = c.d(r29.b);
        if (r110 == null) goto L24;
        String r22 = c.a(r21, r110.substring(0, 16));
    L28:
        String r23 = "https://mercury-sdk.snssdk.com/access_token/register/wap/v4/?partner=" + r22;
        Map<String, String> r111 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Salt", r15), TuplesKt.to("webcast-app-id", r29.b), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded")});
        nd.a r112 = g;
        String r113 = "";
        if (r112 == null) goto L35;
        String r114 = r112.getSdkVersion();
        if (r114 != null) goto L34;
        r114 = "";
    L34:
        String r115 = r111.put("webcast-sdk-version", r114);
    L35:
        String r24 = String.valueOf(System.currentTimeMillis() / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR));
        String r25 = String.valueOf(r11.nextInt(100000, 999999));
        Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uuid", r30), TuplesKt.to("timestamp", r24), TuplesKt.to("appid", r29.c), TuplesKt.to("nonce", r25), TuplesKt.to("signature", c.d(CollectionsKt.joinToString$default(CollectionsKt.sorted(CollectionsKt.listOf(new String[]{r19, r24, r25, r30})), "", null, null, 0, null, null, 62, null)))});
        nd.a r26 = g;
        if (r26 == null) goto L42;
        String r27 = r26.getSdkVersion();
        if (r27 == null) goto L40;
        r113 = r27;
    L40:
        String r31 = (String) r1.put("sdk_version", r113);
    L42:
        if (r29.f.length() <= 0) goto L44;
        boolean r32 = true;
    L45:
        if (r32 == false) goto L48;
        r1.put("original_partner", r29.f);
    L48:
        if (r29.g.length() <= 0) goto L50;
        boolean r33 = true;
    L51:
        if (r33 == false) goto L53;
        r1.put("original_uuid", r29.g);
    L53:
        ArrayList r34 = new ArrayList(r1.size());
        Iterator r35 = r1.entrySet().iterator();
    L55:
        if (r35.hasNext() == false) goto L57;
        Map.Entry r36 = (Map.Entry) r35.next();
        r34.add(((String) r36.getKey()) + '=' + URLEncoder.encode((String) r36.getValue(), "utf-8"));
        goto L55
    L57:
        String r37 = CollectionsKt.joinToString$default(r34, "&", null, null, 0, null, null, 62, null);
        int r38 = c.a;
        String r39 = c.c("MD5", r19 + r15);
        if (r39 == null) goto L88;
        String r40 = r39.toLowerCase();
        if (r40 == null) goto L86;
        String r41 = r40.substring(0, 16);
        String r42 = c.b(r37, r41);
        Charset r43 = Charsets.UTF_8;
        if (r42 == null) goto L84;
        byte[] r44 = r42.getBytes(r43);
        nd.a r45 = g;
        if (r45 == null) goto L66;
        String r46 = r45.post(r23, r44, r111);
    L67:
        if (r46 != null) goto L69;
    L72:
        if (r46 == null) goto L91;
    L74:
        if (GsonProtectorUtils.parse(new JsonParser(), c.a(r46, r41)).getAsJsonObject().get("ret").getAsInt() != 0) goto L81;
        SharedPreferences r47 = r28.getSharedPreferences("IUtUidStore", 0);
        r47.edit().putString("salt_seed", String.valueOf(r12)).putString("enc_content", r46).commit();
        r10.g(r47, String.valueOf(r12), r29);
        return true;
    L81:
        return false;
    L79:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L81
    L91:
        Intrinsics.throwNpe();     // Catch: IllegalArgumentException -> L79
        goto L74
    L69:
        if (StringsKt.startsWith$default(r46, "{", false, 2, null) != true) goto L72;
    L66:
        r46 = null;
        goto L67
    L84:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L86:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L88:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L50:
        r33 = false;
        goto L51
    L44:
        r32 = false;
        goto L45
    L24:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L26:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L27:
        r22 = r29.d;
        goto L28
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L15:
        r19 = r29.e;
        goto L17
    L90:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static void e(final Application r10, final e r11, final String r12) {
        final a r13 = null;
        ThreadsKt.thread$default(false, false, null, null, 0, new UtUidStoreImpl$asyncFetch$1(r10, r11, r12, r13), 31, null);
    }

    public static void f(Context r10, final e r11, final UtUidInitTask.init.1 r12) {
        final SharedPreferences r13 = r10.getSharedPreferences("IUtUidStore", 0);
        final String r0 = r13.getString("salt_seed", null);
        if (r0 != null) goto L6;
        r12.onSuccess(Boolean.FALSE);
        return;
    L6:
        ThreadsKt.thread$default(false, false, null, null, 0, new UtUidStoreImpl$asyncLoad$1(r13, r0, r11, r12), 31, null);
    }

    public final synchronized void g(SharedPreferences r10, String r11, e r12) {
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L4:
        if (h == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        h = true;     // Catch: Throwable -> L73
        String r13 = r10.getString("enc_content", null);     // Catch: Throwable -> L70
        if (r13 != null) goto L13;
    L68:
        h = false;     // Catch: Throwable -> L70
    L71:
        monitor-exit(this);
        return;
    L13:
        if (r13.length() <= 0) goto L15;
        boolean r14 = true;
    L16:
        if (r14 != true) goto L68;
        if (StringsKt.startsWith$default(r13, "{", false, 2, null) == false) goto L22;
        h = false;     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L22:
        int r15 = c.a;     // Catch: Throwable -> L70
        String r16 = c.d(r11 + r12.c);     // Catch: Throwable -> L70
        if (r16 == null) goto L67;
        f = r16.substring(0, 10);     // Catch: Throwable -> L70
        if (StringsKt.startsWith$default(r12.e, "enc_", false, 2, null) == false) goto L35;
        String r17 = r12.e;     // Catch: Throwable -> L70
        if (r17 == null) goto L34;
        String r18 = r17.substring(4);     // Catch: Throwable -> L70
        String r19 = c.d(r12.b);     // Catch: Throwable -> L70
        if (r19 == null) goto L32;
        String r20 = c.a(r18, r19.substring(0, 16));     // Catch: Throwable -> L70
    L36:
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L70
        r21.append(r20);     // Catch: Throwable -> L70
        String r22 = f;     // Catch: Throwable -> L70
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");     // Catch: Throwable -> L70
    L39:
        r21.append(r22);     // Catch: Throwable -> L70
        String r23 = c.c("MD5", r21.toString());     // Catch: Throwable -> L70
        if (r23 == null) goto L65;
        String r24 = r23.toLowerCase();     // Catch: Throwable -> L70
        if (r24 == null) goto L63;
        JsonObject r25 = new JsonParser().parse(c.a(r13, r24.substring(0, 16))).getAsJsonObject();     // Catch: Throwable -> L70
        if (r25.get("ret").getAsInt() == 0) goto L48;
        h = false;     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L48:
        JsonObject r26 = r25.getAsJsonObject("data");     // Catch: Throwable -> L70
        c = r26.get(com.bytedance.android.ec.core.event.a.KEY_USER_ID).getAsString();     // Catch: Throwable -> L70
        b = r26.get(com.bytedance.android.ec.core.event.a.KEY_USER_TYPE).getAsString();     // Catch: Throwable -> L70
        StringBuilder r27 = new StringBuilder();     // Catch: Throwable -> L70
        r27.append(r12.b);     // Catch: Throwable -> L70
        String r28 = f;     // Catch: Throwable -> L70
        if (r28 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");     // Catch: Throwable -> L70
    L51:
        r27.append(r28);     // Catch: Throwable -> L70
        String r29 = c.d(r27.toString());     // Catch: Throwable -> L70
        if (r29 == null) goto L61;
        String r30 = r29.substring(0, 16);     // Catch: Throwable -> L70
        String r31 = c;     // Catch: Throwable -> L70
        if (r31 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("innerUid");     // Catch: Throwable -> L70
    L56:
        e = c.b(r31, r30);     // Catch: Throwable -> L70
        String r32 = b;     // Catch: Throwable -> L70
        if (r32 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("innerUt");     // Catch: Throwable -> L70
    L59:
        d = c.b(r32, r30);     // Catch: Throwable -> L70
        a = true;     // Catch: Throwable -> L70
        goto L68
    L61:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L63:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L65:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L32:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L34:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L35:
        r20 = r12.e;     // Catch: Throwable -> L70
        goto L36
    L67:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L15:
        r14 = false;
    L70:
        h = false;     // Catch: Throwable -> L73
        goto L71
    }
}
