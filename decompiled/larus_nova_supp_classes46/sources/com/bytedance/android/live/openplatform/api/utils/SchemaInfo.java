package com.bytedance.android.live.openplatform.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class SchemaInfo {
    public static final JSONObject p = null;
    public static final Set<String> q = null;
    public static final LruCache<String, SchemaInfo> r = null;
    public static final b s = null;
    public final Host a;
    public String b;
    public final Lazy c;
    public String d;
    public JSONObject e;
    public final Lazy f;
    public final Lazy g;
    public String h;
    public String i;
    public final Lazy j;
    public String k;
    public String l;
    public String m;
    public JSONObject n;
    public final Uri o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$Host;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", "a", "MICROAPP", "MICROGAME", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Host extends Enum<Host> {
        public static final a Companion = null;
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;
        public static final /* synthetic */ Host[] a = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        static {
            Host r1 = new Host("MICROAPP", 0, "microapp");
            MICROAPP = r1;
            Host r2 = new Host("MICROGAME", 1, "microgame");
            MICROGAME = r2;
            a = new Host[]{r1, r2};
            Companion = new a();
        }

        public static Host valueOf(String r1) {
            return (Host) r27.a.a(Host.class, r1);
        }

        public static Host[] values() {
            return (Host[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Host(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$LaunchMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "Companion", "a", "HOST_STACK", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final a Companion = null;
        public static final LaunchMode HOST_STACK = null;
        public static final /* synthetic */ LaunchMode[] a = null;
        private final String mode;

        public static final class a {
            public a() {
            }
        }

        static {
            LaunchMode r1 = new LaunchMode();
            HOST_STACK = r1;
            a = new LaunchMode[]{r1};
            Companion = new a();
        }

        public static LaunchMode valueOf(String r1) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r1);
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) a.clone();
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public final String getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$VersionType;", "", "Companion", "a", "current", "latest", "audit", PbRequest.SwitchType.PREVIEW, "local_dev", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VersionType extends Enum<VersionType> {
        public static final a Companion = null;
        public static final /* synthetic */ VersionType[] a = null;
        public static final VersionType audit = null;
        public static final VersionType current = null;
        public static final VersionType latest = null;
        public static final VersionType local_dev = null;
        public static final VersionType preview = null;

        public static final class a {
            public a() {
            }
        }

        static {
            VersionType r1 = new VersionType("current", 0);
            current = r1;
            VersionType r2 = new VersionType("latest", 1);
            latest = r2;
            VersionType r3 = new VersionType("audit", 2);
            audit = r3;
            VersionType r4 = new VersionType(PbRequest.SwitchType.PREVIEW, 3);
            preview = r4;
            VersionType r5 = new VersionType("local_dev", 4);
            local_dev = r5;
            a = new VersionType[]{r1, r2, r3, r4, r5};
            Companion = new a();
        }

        public static VersionType valueOf(String r1) {
            return (VersionType) r27.a.a(VersionType.class, r1);
        }

        public static VersionType[] values() {
            return (VersionType[]) a.clone();
        }

        public VersionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final LinkedHashMap<String, String> a;
        public String b;
        public final Host c;
        public JSONObject d;

        public final SchemaInfo d() throws Exception {
            if (this.b.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L8;
            this.b = "sslocal";
        L8:
            String r2 = this.a.get("app_id");
            if (TextUtils.isEmpty(r2) == true) goto L11;
            Intrinsics.checkNotNull(r2);
            StringsKt.startsWith$default(r2, "tt", false, 2, null);
        L11:
            String r5 = this.a.get("start_page");
            if (this.c != Host.MICROGAME) goto L14;
            r5 = null;
        L14:
            if (r5 == null) goto L16;
            StringsKt.startsWith$default(r5, "/", false, 2, null);
        L16:
            VersionType.a r9 = VersionType.Companion;
            String r10 = this.a.get("version_type");
            r9.getClass();
            VersionType[] r11 = VersionType.values();
            int r12 = r11.length;
            int r13 = 0;
        L17:
            if (r13 >= r12) goto L22;
            VersionType r14 = r11[r13];
            if (StringsKt.equals(r14.name(), r10, true) == true) goto L23;
            r13 = r13 + 1;
        L23:
            if (r14 != null) goto L25;
            r14 = VersionType.current;
        L25:
            String r15 = this.a.get("version");
            if (TextUtils.isEmpty(r15) == false) goto L28;
            r15 = "v2";
        L28:
            String r16 = this.a.get("scene");
            if (TextUtils.isEmpty(r16) == false) goto L32;
            r16 = "0";
        L32:
            if (r14 != VersionType.preview) goto L34;
        L36:
            String r3 = this.a.get("token");
            JSONObject r6 = this.d;
            if (r6 == null) goto L39;
            Intrinsics.checkNotNull(r6);
            r6.optString("launch_from");
        L39:
            Uri.Builder r4 = new Uri.Builder().scheme(this.b).authority(this.c.getValue()).appendQueryParameter("app_id", r2);
            JSONObject r7 = this.d;
            if (r7 == null) goto L42;
            SchemaInfo.s.getClass();
            r4.appendQueryParameter("bdp_log", b.c(r7));
        L42:
            Set<String> r8 = SchemaInfo.q;
            Iterator<Map.Entry<String, String>> r17 = this.a.entrySet().iterator();
        L44:
            if (r17.hasNext() == false) goto L49;
            Map.Entry<String, String> r18 = r17.next();
            if (r8.contains(r18.getKey()) == true) goto L44;
            r4.appendQueryParameter(r18.getKey(), r18.getValue());
            goto L44
        L49:
            r4.appendQueryParameter("scene", r16);
            if (r3 != null) goto L52;
        L58:
            if (r5 == null) goto L60;
            r4.appendQueryParameter("start_page", r5);
        L60:
            r4.appendQueryParameter("version", r15);
            r4.appendQueryParameter("version_type", r14.name());
            String r19 = r4.toString();
            if (TextUtils.isEmpty(r19) == false) goto L64;
        L95:
            String r20 = "";
        L96:
            r4.appendQueryParameter("bdpsum", r20);
            return new SchemaInfo(r4.build());
        L64:
            if (StringsKt.contains$default(r19, "://", false, 2, null) == false) goto L73;
            Object[] r21 = StringsKt.split$default(r19, new String[]{"://"}, false, 0, 6, null).toArray(new String[0]);
            if (r21 == null) goto L72;
            String[] r22 = (String[]) r21;
            if (r22.length < 2) goto L95;
            r19 = r22[1];
            goto L73
        L72:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L73:
            StringBuilder r23 = new StringBuilder();
            if (r19 == null) goto L99;
            int r24 = 0;
            r23.append(r19.substring(0, 10));
            r23.append("bytetimordance");
            r23.append(r19.substring(10));
            String r25 = r23.toString();
            if (r25 != null) goto L100;
        L90:
            String r26 = null;
        L91:
            if (r26 == null) goto L95;
            if (TextUtils.isEmpty(r26) == true) goto L95;
            r20 = r26.substring(2, 6) + r26.substring(20, 23);
            goto L96
        L100:
            if (r25.length() == 0) goto L90;
            MessageDigest r27 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L89
            r27.update(r25.getBytes("UTF-8"));     // Catch: Exception -> L89
            byte[] r28 = r27.digest();     // Catch: Exception -> L89
            char[] r29 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};     // Catch: Exception -> L89
            char[] r30 = new char[r28.length * 2];     // Catch: Exception -> L89
            int r31 = 0;
        L82:
            if (r24 >= r28.length) goto L87;
            int r32 = r28[r24];     // Catch: Exception -> L89
            if (r32 >= 0) goto L86;
            r32 = r32 + 256;     // Catch: Exception -> L89
        L86:
            int r33 = r31 + 1;     // Catch: Exception -> L89
            r30[r31] = r29[r32 >>> 4];     // Catch: Exception -> L89
            r31 = r33 + 1;     // Catch: Exception -> L89
            r30[r33] = r29[r32 & 15];     // Catch: Exception -> L89
            r24 = r24 + 1;     // Catch: Exception -> L89
            goto L82
        L87:
            r26 = new String(r30);     // Catch: Exception -> L89
            goto L91
        L99:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L52:
            if (r3.length() <= 0) goto L54;
            boolean r34 = true;
        L56:
            if (r34 != true) goto L58;
            r4.appendQueryParameter("token", r3);
            goto L58
        L54:
            r34 = false;
            goto L56
        L34:
            if (r14 == VersionType.local_dev) goto L36;
            this.a.remove("inspect");
            goto L36
        L22:
            r14 = null;
            goto L23
        L5:
            r1 = false;
            goto L6
        }

        public a() {
            this.a = new LinkedHashMap();
            this.b = "sslocal";
            this.c = Host.MICROAPP;
            this.d = null;
        }

        public final SchemaInfo c() {
            return d();
        L4:
            return null;
        }

        public a(String r10) {
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            Uri r11 = UriProtector.parse(r10);
            b r0 = SchemaInfo.s;
            r0.getClass();
            JSONObject r1 = null;
            if (r11 == null) goto L11;
            String r2 = r11.getEncodedQuery();
            if (r2 == null) goto L11;
            LinkedHashMap<String, String> r3 = b.d(r2);
        L12:
            if (r3 != null) goto L14;
            r3 = new LinkedHashMap();
        L14:
            this.a = r3;
            if (r11 == null) goto L18;
            String r4 = r11.getScheme();
            if (r4 == null) goto L18;
        L19:
            this.b = r4;
            Host.a r5 = Host.Companion;
            if (r11 == null) goto L22;
            String r12 = r11.getAuthority();
        L23:
            r5.getClass();
            Host[] r6 = Host.values();
            int r7 = r6.length;
            int r8 = 0;
        L24:
            if (r8 >= r7) goto L29;
            Host r9 = r6[r8];
            if (StringsKt.equals(r9.getValue(), r12, true) == true) goto L30;
            r8 = r8 + 1;
        L30:
            if (r9 != null) goto L32;
            r9 = Host.MICROAPP;
        L32:
            this.c = r9;
            String r13 = r3.get("bdp_log");
            if (r13 == null) goto L35;
            r1 = b.a(r0, r13);
        L35:
            this.d = r1;
            return;
        L29:
            r9 = null;
            goto L30
        L22:
            r12 = null;
        L18:
            r4 = "sslocal";
        L11:
            r3 = null;
            goto L12
        }

        public final void a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "appId");
            this.a.put("app_id", r3);
        }

        public final void f(LaunchMode r3) {
            Intrinsics.checkNotNullParameter(r3, "launchMode");
            this.a.put("launch_mode", r3.getMode());
        }

        @Deprecated(message = "startPageAndQuery代替，保证query的key/value都会encode")
        public final void g(String r3) {
            Intrinsics.checkNotNullParameter(r3, "startPage");
            this.a.put("start_page", r3);
        }

        public final void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            JSONObject r0 = this.d;
            if (r0 != null) goto L5;
            r0 = new JSONObject();
        L5:
            r0.put(r2, r3);
            this.d = r0;
        }

        public final void e(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "rawValue");
            this.a.put(r2, r3);
        }

        public final void h(String r7, Map r8) {
            Intrinsics.checkNotNullParameter(r7, "startPagePath");
            Intrinsics.checkNotNullParameter(r8, "startPageQuery");
            StringBuilder r0 = new StringBuilder(r7);
            Iterator r9 = r8.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r9.hasNext() == false) goto L15;
            Object r2 = r9.next();
            int r3 = r1 + 1;
            if (r1 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            Map.Entry r4 = (Map.Entry) r2;
            if (r1 == 0) goto L11;
        L13:
            r0.append("&");
        L14:
            r0.append(Uri.encode((String) r4.getKey()));
            r0.append("=");
            r0.append(Uri.encode((String) r4.getValue()));
            r1 = r3;
            goto L4
        L11:
            if (StringsKt.contains$default(r0, "?", false, 2, null) == true) goto L13;
            r0.append("?");
            goto L14
        L15:
            this.a.put("start_page", r0.toString());
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static SchemaInfo b(String r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (r2.length() != 0) goto L6;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L28;
            LruCache<String, SchemaInfo> r1 = SchemaInfo.r;
            SchemaInfo r3 = (SchemaInfo) r1.get(r2);
            if (r3 != null) goto L23;
            monitor-enter(r1);
            r3 = (SchemaInfo) r1.get(r2);     // Catch: Throwable -> L20
            if (r3 != null) goto L15;
            r3 = new a(r2).c();     // Catch: Throwable -> L20
        L15:
            if (r3 == null) goto L17;
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L20
            r1.put(r2, r3);     // Catch: Throwable -> L20
        L17:
            Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r1);
        L20:
            th = move-exception;
            throw th;
        L23:
            return r3;
        L28:
            return null;
        L6:
            r0 = false;
            goto L7
        }

        public static String c(JSONObject r6) {
            if (r6 != null) goto L6;
            return "";
        L6:
            return StringsKt.replace$default(r6.toString(), "\\/", "/", false, 4, null);
        }

        public static LinkedHashMap d(String r10) {
            if (r10.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L23;
            return null;
        L23:
            LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L22
            Iterator r11 = new Regex("&").split(r10, 0).iterator();     // Catch: Throwable -> L22
        L11:
            if (r11.hasNext() == false) goto L21;
            String r3 = (String) r11.next();     // Catch: Throwable -> L22
            int r4 = StringsKt.indexOf$default(r3, "=", 0, false, 6, null);     // Catch: Throwable -> L22
            if (r4 >= 0) goto L15;
            r1.put(URLDecoder.decode(r3, "UTF-8"), "");     // Catch: Throwable -> L22
            goto L11
        L15:
            if (r3 == null) goto L18;
            r1.put(URLDecoder.decode(r3.substring(0, r4), "UTF-8"), URLDecoder.decode(r3.substring(r4 + 1), "UTF-8"));     // Catch: Throwable -> L22
            goto L11
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L22
        L21:
            return r1;
        L22:
            return null;
        L5:
            r0 = false;
            goto L7
        }

        public static final JSONObject a(b r0, String r1) {
            r0.getClass();
            if (TextUtils.isEmpty(r1) == false) goto L10;
        L7:
            return null;
        L10:
            Intrinsics.checkNotNull(r1);     // Catch: Exception -> L9
            return new JSONObject(r1);
        }
    }

    static {
        s = new b();
        p = new JSONObject();
        q = SetsKt.setOf(new String[]{"start_page", "token", "version_type", "version", "scene", "app_id", "bdp_log", "bdpsum"});
        r = new LruCache(50);
        SetsKt.hashSetOf(new String[]{"ttc9b5bf08568f9ab2", "tt28f55e48b7ce0cb6"});
    }

    public final String a() {
        String r0 = this.b;
        if (r0 == "UNINITIALIZED_STRING") goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        String r2 = String.valueOf(c("app_id"));
        this.b = r2;
        return r2;
    L12:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final JSONObject b() {
        JSONObject r0 = this.e;
        if (r0 == p) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        JSONObject r2 = b.a(s, c("bdp_log"));
        this.e = r2;
        return r2;
    L12:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final String d() {
        String r0 = this.m;
        boolean r2 = true;
        if (r0 == "UNINITIALIZED_STRING") goto L5;
        boolean r1 = true;
    L6:
        String r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L25;
        JSONObject r3 = b();
        if (r3 == null) goto L14;
        r4 = r3.optString("location");
    L14:
        if (r4 != null) goto L16;
    L19:
        if (r2 == true) goto L21;
        r0 = r4;
    L24:
        this.m = r0;
        goto L25
    L21:
        r0 = c("location");
        if (r0 != null) goto L24;
        r0 = "";
        goto L24
    L16:
        if (r4.length() == 0) goto L19;
        r2 = false;
    L25:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final String e() {
        String r0 = this.h;
        if (r0 == "UNINITIALIZED_STRING") goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L12;
        String r2 = c("start_page");
        this.h = r2;
        return r2;
    L12:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final String f() {
        String r0 = this.i;
        if (r0 == "UNINITIALIZED_STRING") goto L5;
        boolean r1 = true;
    L6:
        String r3 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L18;
        String r2 = e();
        if (r2 == null) goto L16;
        List r4 = new Regex("\\?").split(r2, 0);
        if (r4 == null) goto L16;
        r3 = (String) CollectionsKt.getOrNull(r4, 0);
    L16:
        this.i = r3;
        return r3;
    L18:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final String g() {
        String r0 = this.k;
        if (r0 == "UNINITIALIZED_STRING") goto L5;
        boolean r1 = true;
    L6:
        String r4 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L18;
        String r2 = e();
        if (r2 == null) goto L16;
        List r3 = new Regex("\\?").split(r2, 0);
        if (r3 == null) goto L16;
        r4 = (String) CollectionsKt.getOrNull(r3, 1);
    L16:
        this.k = r4;
        return r4;
    L18:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public final String h() {
        return this.o.toString();
    }

    public final int hashCode() {
        return this.o.hashCode();
    }

    public final String toString() {
        return this.o.toString();
    }

    public SchemaInfo(Uri r7) {
        this.o = r7;
        if (TextUtils.isEmpty(r7.getScheme()) == true) goto L6;
        Intrinsics.checkNotNull(r7.getScheme());
    L6:
        Host.a r0 = Host.Companion;
        String r8 = r7.getHost();
        r0.getClass();
        Host[] r1 = Host.values();
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        Host r4 = r1[r3];
        if (StringsKt.equals(r4.getValue(), r8, true) == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r4 != null) goto L15;
        r4 = Host.MICROAPP;
    L15:
        this.a = r4;
        this.b = "UNINITIALIZED_STRING";
        Function0<VersionType> r5 = new SchemaInfo$versionType$2(this);
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.PUBLICATION;
        this.c = LazyKt.lazy(r6, r5);
        JSONObject r9 = p;
        this.d = "UNINITIALIZED_STRING";
        this.e = r9;
        this.f = LazyKt.lazy(r6, new SchemaInfo$techType$2(this));
        this.g = LazyKt.lazy(r6, new SchemaInfo$mpType$2(this));
        this.h = "UNINITIALIZED_STRING";
        this.i = "UNINITIALIZED_STRING";
        this.j = LazyKt.lazy(r6, new SchemaInfo$startPageQuery$2(this));
        this.k = "UNINITIALIZED_STRING";
        this.l = "UNINITIALIZED_STRING";
        this.m = "UNINITIALIZED_STRING";
        this.n = r9;
        return;
    L12:
        r4 = null;
        goto L13
    }

    public final String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return UriProtector.getQueryParameter(this.o, r2);
    L5:
        return null;
    }

    public final boolean equals(Object r2) {
        if (Intrinsics.areEqual(r2, this) == false) goto L7;
        return true;
    L7:
        if ((r2 instanceof SchemaInfo) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.o, ((SchemaInfo) r2).o);
    }
}
