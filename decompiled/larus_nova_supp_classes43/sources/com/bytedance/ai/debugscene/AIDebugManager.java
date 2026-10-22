package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.debugscene.tag.DebugTagStyle;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.ai.resource.core.bean.OpenPlatformScanTarget;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIDebugManager {
    public static final AIDebugManager a = null;
    public static AppletDebugTool b;
    public static IAISDKDebugService$DebugMode c;
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> d = null;
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> e = null;
    public static final ConcurrentHashMap<c, com.bytedance.ai.resource.d0> f = null;
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> g = null;
    public static final ConcurrentHashMap<String, com.bytedance.ai.resource.d0> h = null;
    public static final ConcurrentHashMap<String, Boolean> i = null;
    public static String j;
    public static String k;
    public static JSONObject l;
    public static final ConcurrentHashMap<String, a> m = null;
    public static boolean n;
    public static String o;
    public static final ConcurrentHashMap<String, String> p = null;
    public static b q;

    public static final class a {
        public final String a;
        public final boolean b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r10 = (r0 + r1) * 31;
            String r11 = this.c;
            if (r11 != null) goto L9;
            int r12 = 0;
        L11:
            return r10 + r12;
        L9:
            r12 = r11.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "PreviewDebugConfigChange(appKey=" + this.a + ", enabled=" + this.b + ", versionTag=" + this.c + ')';
        }

        public final JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("app_key", this.a);
            r0.put("enabled", this.b);
            if (this.b == false) goto L13;
            String r1 = this.c;
            if (r1 != null) goto L7;
        L10:
            boolean r10 = true;
        L11:
            if (r10 == true) goto L13;
            r0.put("version_tag", this.c);
            goto L13
        L7:
            if (StringsKt.isBlank(r1) == true) goto L10;
            r10 = false;
        L13:
            return r0;
        }

        public a(String r10, boolean r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "appKey");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            b r11 = (b) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "PreviewInstallContext(deviceId=" + this.a + ", xToken=" + this.b + ", source=" + this.c + ')';
        }

        public b(String r10, String r11, int r12) {
            Intrinsics.checkNotNullParameter(r10, "deviceId");
            Intrinsics.checkNotNullParameter(r11, "xToken");
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class c {
        public final String a;
        public final String b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PreviewPackageKey(packageName=" + this.a + ", versionTag=" + this.b + ')';
        }

        public c(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "packageName");
            Intrinsics.checkNotNullParameter(r11, "versionTag");
            this.a = r10;
            this.b = r11;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IAISDKDebugService$DebugMode.values().length];
            r0[IAISDKDebugService$DebugMode.LOCAL_DEBUG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IAISDKDebugService$DebugMode.SCAN_PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IAISDKDebugService$DebugMode.LEGACY_SCAN_PREVIEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IAISDKDebugService$DebugMode.NORMAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public AIDebugManager() {
    }

    static {
        a = new AIDebugManager();
        c = IAISDKDebugService$DebugMode.NORMAL;
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
        i = new ConcurrentHashMap();
        m = new ConcurrentHashMap();
        p = new ConcurrentHashMap();
    }

    public static Set c() {
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll(e.keySet());
        r0.addAll(g.keySet());
        r0.addAll(d.keySet());
        return r0;
    }

    public static String i() {
        String r10 = null;
        if (c != IAISDKDebugService$DebugMode.LOCAL_DEBUG) goto L21;
        String r0 = o;
        if (r0 != null) goto L19;
        AppletDebugTool r1 = b;
        if (r1 == null) goto L54;
        final j1 r11 = r1.c;
        if (r11 != null) goto L13;
        return null;
    L13:
        if (r11.a.getBoolean("applet_cache_debug_host", false) == false) goto L56;
        r0 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(d.keySet()), new com.bytedance.ai.debugscene.b()), new k(r11)));
        if (r0 == null) goto L57;
        o = r0;
        goto L19
    L57:
        return null;
    L56:
        return null;
    L54:
        return null;
    L19:
        return r0;
    L21:
        if (c != IAISDKDebugService$DebugMode.SCAN_PREVIEW) goto L47;
        q();
        JSONObject r12 = l;
        if (r12 == null) goto L25;
        r10 = r12.optString("app_key");
    L25:
        Collection<a> r13 = m.values();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L27:
        if (r15.hasNext() == false) goto L31;
        Object r16 = r15.next();
        if ((!Intrinsics.areEqual(((a) r16).a, r10)) == false) goto L27;
        r14.add(r16);
        goto L27
    L31:
        boolean r17 = !r14.isEmpty();
        if (r12 != null) goto L36;
        if (r17 == true) goto L36;
        JSONObject r18 = new JSONObject();
        r18.put("mode", "preview");
        r18.put("scan_app", new JSONArray());
        r18.put("changes", new JSONArray());
        return r18.toString();
    L36:
        JSONObject r19 = new JSONObject();
        r19.put("mode", "preview");
        if (r12 == null) goto L39;
        JSONArray r20 = new JSONArray();
        r20.put(r12);
        Unit r21 = Unit.INSTANCE;
        r19.put("scan_app", r20);
    L39:
        if (r17 == false) goto L46;
        JSONArray r22 = new JSONArray();
        Iterator r23 = r14.iterator();
    L42:
        if (r23.hasNext() == false) goto L44;
        r22.put(((a) r23.next()).a());
        goto L42
    L44:
        Unit r24 = Unit.INSTANCE;
        r19.put("changes", r22);
    L46:
        return r19.toString();
    L47:
        return null;
    }

    public static void q() {
        if ((!m.isEmpty()) == false) goto L5;
        return;
    L5:
        AppletDebugTool r1 = b;
        if (r1 == null) goto L68;
        j1 r10 = r1.c;
        if (r10 == null) goto L69;
        String r11 = r10.b.get("preview_debug_config_changes");
        if (r11 != null) goto L21;
        r11 = r10.a.getString("preview_debug_config_changes", null);
        if (r11 != null) goto L15;
        r11 = null;
        goto L21
    L15:
        if (r11.length() <= 0) goto L17;
        boolean r12 = true;
    L18:
        if (r12 == false) goto L21;
        r10.b.put("preview_debug_config_changes", r11);
        goto L21
    L17:
        r12 = false;
    L21:
        if (r11 == null) goto L72;
        JSONArray r13 = new JSONArray(r11);     // Catch: Exception -> L55
        int r14 = r13.length();     // Catch: Exception -> L55
        int r15 = 0;
    L24:
        if (r15 >= r14) goto L53;
        JSONObject r16 = r13.optJSONObject(r15);     // Catch: Exception -> L55
        if (r16 == null) goto L52;
        String r17 = r16.optString("app_key");     // Catch: Exception -> L55
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L55
        if ((!StringsKt.isBlank(r17)) == true) goto L32;
        r17 = null;
    L32:
        if (r17 == null) goto L52;
        boolean r18 = r16.optBoolean("enabled");     // Catch: Exception -> L55
        String r19 = r16.optString("version_tag");     // Catch: Exception -> L55
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L55
        if ((!StringsKt.isBlank(r19)) == true) goto L38;
        r19 = null;
    L38:
        if (r18 == false) goto L47;
        if (r19 != null) goto L41;
    L44:
        boolean r110 = true;
    L45:
        if (r110 == true) goto L47;
        boolean r111 = true;
    L48:
        if (r111 == true) goto L51;
        r19 = null;
    L51:
        m.put(r17, new a(r17, r18, r19));     // Catch: Exception -> L55
        goto L52
    L41:
        if (StringsKt.isBlank(r19) == true) goto L44;
        r110 = false;
    L47:
        r111 = false;
    L52:
        r15 = r15 + 1;     // Catch: Exception -> L55
        goto L24
    L53:
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "load preview debug config changes from storage. size: " + m.size());     // Catch: Exception -> L55
        return;
    L55:
        e = move-exception;
        com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
        r20.e("AIDebugManager", "failed to load preview debug config changes from storage: " + e.getMessage());
        AppletDebugTool r0 = b;
        if (r0 == null) goto L70;
        j1 r21 = r0.c;
        if (r21 == null) goto L71;
        r21.b.remove("preview_debug_config_changes");
        SharedPreferences.Editor r22 = r21.a.edit();
        r22.remove("preview_debug_config_changes");
        r22.commit();
        r20.i("AISDKDebugSettings", "Cleared preview debug config changes from storage");
        return;
    L71:
        return;
    L70:
        return;
    L72:
        return;
    L69:
        return;
    }

    public static Map j() {
        String r0 = i();
        if (r0 == null) goto L5;
        JSONArray r1 = new JSONObject(r0).optJSONArray("changes");     // Catch: Exception -> L33
        if (r1 == null) goto L9;
        Map r10 = MapsKt.createMapBuilder();     // Catch: Exception -> L33
        int r11 = r1.length();     // Catch: Exception -> L33
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L41;
        JSONObject r13 = r1.optJSONObject(r12);     // Catch: Exception -> L33
        if (r13 == null) goto L30;
        String r14 = r13.optString("app_key");     // Catch: Exception -> L33
        Intrinsics.checkNotNull(r14);     // Catch: Exception -> L33
        boolean r15 = true;
        String r16 = null;
        if ((!StringsKt.isBlank(r14)) == true) goto L19;
        r14 = null;
    L19:
        if (r14 == null) goto L30;
        boolean r17 = r13.optBoolean("enabled");     // Catch: Exception -> L33
        String r18 = r13.optString("version_tag");     // Catch: Exception -> L33
        if (r17 == false) goto L26;
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L33
        if ((!StringsKt.isBlank(r18)) == false) goto L26;
    L27:
        if (r15 == false) goto L29;
        r16 = r18;
    L29:
        r10.put(r14, new a(r14, r17, r16));     // Catch: Exception -> L33
    L26:
        r15 = false;
    L30:
        r12 = r12 + 1;     // Catch: Exception -> L33
        goto L11
    L41:
        return MapsKt.build(r10);
    L9:
        return MapsKt.emptyMap();
    L33:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AIDebugManager", "failed to parse preview debug config changes for mock data: " + e.getMessage());
        return MapsKt.emptyMap();
    L5:
        return MapsKt.emptyMap();
    }

    public static void B(String r10) {
        AppletDebugTool r0 = b;
        if (r0 == null) goto L5;
        j1 r1 = r0.c;
    L6:
        if (r1 == null) goto L19;
        SharedPreferences.Editor r11 = r1.a.edit();
        if (r10 != null) goto L10;
    L13:
        boolean r12 = true;
    L15:
        if (r12 == false) goto L17;
        r11.remove("remote_debug_modern_tag_package");
    L18:
        r11.commit();
        goto L19
    L17:
        r11.putString("remote_debug_modern_tag_package", r10);
        goto L18
    L10:
        if (StringsKt.isBlank(r10) == true) goto L13;
        r12 = false;
    L19:
        v4.c.c();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static v4.a e(String r10) {
        com.bytedance.ai.resource.d0 r0 = f(r10);
        Boolean r1 = null;
        j1 r11 = null;
        j1 r12 = null;
        if (r0 == null) goto L7;
        AIPackage r13 = r0.g(r10);
        if (r13 == null) goto L7;
    L11:
        int r14 = d.a[c.ordinal()];
        boolean r15 = true;
        if (r14 != 1) goto L14;
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if (r13.A == true) goto L44;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == false) goto L66;
        Intrinsics.checkNotNullParameter(r10, "packageName");
        AppletDebugTool r17 = b;
        if (r17 == null) goto L51;
        j1 r18 = r17.c;
    L52:
        if (r18 == null) goto L63;
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r19 = "show_debug_tag_".concat(r10);
        String r20 = r18.b.get(r19);
        if (r20 == null) goto L56;
        r1 = Boolean.valueOf(Boolean.parseBoolean(r20));
    L56:
        if (r1 == null) goto L58;
    L60:
        boolean r21 = Intrinsics.areEqual(r1, Boolean.TRUE);
    L61:
        if (r21 != true) goto L63;
        boolean r22 = true;
    L64:
        if (r22 == false) goto L66;
    L67:
        v4.a r23 = new v4.a(r15, "Debug", DebugTagStyle.MODERN_DEBUG);
    L71:
        return r23;
    L58:
        if (r18.c == false) goto L60;
        r21 = r18.a.getBoolean(r19, false);
        r18.b.put(r19, String.valueOf(r21));
    L63:
        r22 = false;
        goto L64
    L51:
        r18 = null;
    L66:
        r15 = false;
        goto L67
    L44:
        if (com.bytedance.ai.utils.f.g(IAISDKDebugService.a.G(r13.b)) == false) goto L46;
        r16 = true;
        goto L47
    L14:
        if (r14 != 2) goto L16;
        Intrinsics.checkNotNullParameter(r10, "packageName");
        AppletDebugTool r24 = b;
        if (r24 == null) goto L34;
        r12 = r24.c;
    L34:
        if (r12 != null) goto L36;
    L38:
        r15 = false;
    L39:
        r23 = new v4.a(r15, "Debug", DebugTagStyle.MODERN_DEBUG);
        goto L71
    L36:
        if (r12.a.getBoolean("remote_debug_tag_enabled", true) != true) goto L38;
    L16:
        if (r14 != 3) goto L18;
        Intrinsics.checkNotNullParameter(r10, "packageName");
        AppletDebugTool r25 = b;
        if (r25 == null) goto L25;
        r11 = r25.c;
    L25:
        if (r11 != null) goto L27;
    L29:
        r15 = false;
    L30:
        r23 = new v4.a(r15, "Preview", DebugTagStyle.LEGACY_PREVIEW);
        goto L71
    L27:
        if (r11.a.getBoolean("remote_debug_tag_enabled", true) != true) goto L29;
    L18:
        if (r14 != 4) goto L21;
        return new v4.a();
    L21:
        throw new NoWhenBranchMatchedException();
    L7:
        if (r0 == null) goto L9;
        r13 = (Widget) CollectionsKt.firstOrNull(r0.f());
    L10:
        if (r13 != null) goto L11;
        return new v4.a();
    L9:
        r13 = null;
        goto L10
    }

    public static com.bytedance.ai.resource.d0 f(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        IAISDKDebugService$DebugMode r0 = c;
        int r1 = d.a[r0.ordinal()];
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L19;
        if (r1 == 3) goto L18;
        if (r1 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return e.get(r10);
    L19:
        return g.get(r10);
    L16:
        return d.get(r10);
    }

    public static boolean m(String r10) {
        AppletDebugTool r0 = b;
        if (r0 == null) goto L12;
        j1 r1 = r0.c;
        if (r1 == null) goto L12;
        if (d.containsKey(r10) == false) goto L12;
        if (com.bytedance.ai.utils.f.g(r1.b(r10)) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void x(IAISDKDebugService$DebugMode r10) {
        Intrinsics.checkNotNullParameter(r10, "debugMode");
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "setDebugMode: " + c + " -> " + r10);
        c = r10;
    }

    public static void A(String r10, String r11) {
        Activity r0 = f2.k.b();
        if (r0 == null) goto L6;
        final AlertDialog.Builder r1 = new AlertDialog.Builder(r0);
        r1.setTitle(r10);
        r1.setMessage(r11);
        r1.setNegativeButton("Confirm", new e());
        r0.runOnUiThread(new f(r1));
        return;
    }

    public static com.bytedance.ai.resource.d0 b(String r10, String r11) {
        if (r11 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        return f.get(new c(r10, r11));
    L12:
        return g.get(r10);
    L4:
        if (r11.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static OpenPlatformPreviewAppInfo t(OpenPlatformPreviewAppInfo r21, a r22) {
        if (r22.b == false) goto L5;
        String r0 = r22.c;
        if (r0 == null) goto L9;
        List<OpenPlatformPreviewVersion> r1 = r21.getTestVersions();
        List<OpenPlatformPreviewVersion> r10 = r21.getAuditVersions();
        OpenPlatformPreviewVersionPage r11 = r21.getFormalVersions();
        Boolean r12 = Boolean.TRUE;
        ArrayList r13 = null;
        if (r1 == null) goto L17;
        List<OpenPlatformPreviewVersion> r14 = r1;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        OpenPlatformPreviewVersion r17 = (OpenPlatformPreviewVersion) r16.next();
        r15.add(OpenPlatformPreviewVersion.copy$default(r17, null, null, Boolean.valueOf(Intrinsics.areEqual(r17.getVersionTag(), r0)), null, null, 27, null));
        goto L14
    L16:
        ArrayList r18 = r15;
    L18:
        if (r10 == null) goto L24;
        List<OpenPlatformPreviewVersion> r19 = r10;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r23 = r19.iterator();
    L21:
        if (r23.hasNext() == false) goto L23;
        OpenPlatformPreviewVersion r110 = (OpenPlatformPreviewVersion) r23.next();
        r20.add(OpenPlatformPreviewVersion.copy$default(r110, null, null, Boolean.valueOf(Intrinsics.areEqual(r110.getVersionTag(), r0)), null, null, 27, null));
        goto L21
    L23:
        ArrayList r24 = r20;
    L25:
        if (r11 == null) goto L33;
        List<OpenPlatformPreviewVersion> r25 = r11.getItems();
        if (r25 == null) goto L32;
        List<OpenPlatformPreviewVersion> r26 = r25;
        r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator<T> r27 = r26.iterator();
    L30:
        if (r27.hasNext() == false) goto L32;
        OpenPlatformPreviewVersion r111 = (OpenPlatformPreviewVersion) r27.next();
        r13.add(OpenPlatformPreviewVersion.copy$default(r111, null, null, Boolean.valueOf(Intrinsics.areEqual(r111.getVersionTag(), r0)), null, null, 27, null));
    L32:
        OpenPlatformPreviewVersionPage r28 = OpenPlatformPreviewVersionPage.copy$default(r11, r13, null, false, 6, null);
    L35:
        return OpenPlatformPreviewAppInfo.copy$default(r21, null, null, null, r12, r18, r24, r28, 7, null);
    L33:
        r28 = null;
        goto L35
    L24:
        r24 = null;
        goto L25
    L17:
        r18 = null;
        goto L18
    L9:
        return OpenPlatformPreviewAppInfo.copy$default(r21, null, null, null, Boolean.TRUE, null, null, null, 119, null);
    L5:
        return OpenPlatformPreviewAppInfo.copy$default(r21, null, null, null, Boolean.FALSE, null, null, null, 119, null);
    }

    public static List u(List r18, OpenPlatformScanTarget r19) {
        ArrayList r0 = null;
        boolean r1 = false;
        if (r18 == null) goto L40;
        List r10 = r18;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L39;
        OpenPlatformPreviewAppInfo r13 = (OpenPlatformPreviewAppInfo) r12.next();
        a.getClass();
        if (Intrinsics.areEqual(r13.getAppKey(), r19.getAppKey()) == false) goto L33;
        List<OpenPlatformPreviewVersion> r14 = v(r13.getTestVersions(), r19.getVersionTag());
        List<OpenPlatformPreviewVersion> r15 = v(r13.getAuditVersions(), r19.getVersionTag());
        OpenPlatformPreviewVersionPage r16 = r13.getFormalVersions();
        if (r16 == null) goto L13;
        List<OpenPlatformPreviewVersion> r17 = r16.getItems();
    L14:
        List<OpenPlatformPreviewVersion> r110 = v(r17, r19.getVersionTag());
        OpenPlatformPreviewVersionPage r20 = r13.getFormalVersions();
        if (r20 == null) goto L17;
        List<OpenPlatformPreviewVersion> r21 = r20.getItems();
    L18:
        if (r110 != r21) goto L20;
        OpenPlatformPreviewVersionPage r22 = r13.getFormalVersions();
    L23:
        OpenPlatformPreviewVersionPage r111 = r22;
    L25:
        Boolean r23 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r13.getDefaultEnabled()) == true) goto L28;
    L34:
        OpenPlatformPreviewAppInfo r24 = OpenPlatformPreviewAppInfo.copy$default(r13, null, null, null, r23, r14, r15, r111, 7, null);
    L35:
        if (r24 == r13) goto L38;
        r1 = true;
        r13 = r24;
    L38:
        r11.add(r13);
        goto L6
    L28:
        if (r14 != r13.getTestVersions()) goto L34;
        if (r15 != r13.getAuditVersions()) goto L34;
        if (r111 != r13.getFormalVersions()) goto L34;
    L20:
        OpenPlatformPreviewVersionPage r112 = r13.getFormalVersions();
        if (r112 == null) goto L24;
        r22 = OpenPlatformPreviewVersionPage.copy$default(r112, r110, null, false, 6, null);
        goto L23
    L24:
        r111 = null;
        goto L25
    L17:
        r21 = null;
        goto L18
    L13:
        r17 = null;
    L33:
        r24 = r13;
        goto L35
    L39:
        r0 = r11;
    L40:
        if (r1 == false) goto L43;
        return r0;
    L43:
        return r18;
    }

    public static List v(List r12, String r13) {
        boolean r0 = false;
        if (r12 == null) goto L12;
        List r1 = r12;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r11 = r1.iterator();
    L6:
        if (r11.hasNext() == false) goto L13;
        OpenPlatformPreviewVersion r14 = (OpenPlatformPreviewVersion) r11.next();
        boolean r15 = Intrinsics.areEqual(r14.getVersionTag(), r13);
        if (Intrinsics.areEqual(r14.isDefault(), Boolean.valueOf(r15)) == true) goto L11;
        r14 = OpenPlatformPreviewVersion.copy$default(r14, null, null, Boolean.valueOf(r15), null, null, 27, null);
        r0 = true;
    L11:
        r10.add(r14);
    L13:
        if (r0 == true) goto L15;
        return r12;
    L15:
        return r10;
    L12:
        r10 = null;
        goto L13
    }

    public static void y(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "packageName");
        o = r10;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r11)) == true) goto L5;
        return;
    L5:
        if (m(r11) == false) goto L24;
        AppletDebugTool r0 = b;
        if (r0 == null) goto L25;
        j1 r12 = r0.c;
        if (r12 == null) goto L26;
        Intrinsics.checkNotNullParameter(r11, "appletName");
        String r13 = "local_debug_config_" + r11;
        if (r12.c == false) goto L27;
        SharedPreferences.Editor r14 = r12.a.edit();
        if (r10 != null) goto L15;
    L18:
        if (r1 == false) goto L20;
        r14.remove(r13);
    L21:
        r14.commit();
        return;
    L20:
        r14.putString(r13, r10);
        goto L21
    L15:
        if (r10.length() == 0) goto L18;
        r1 = false;
        goto L18
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public final Object d(String r10, Continuation<? super String> r11) {
        if ((r11 instanceof AIDebugManager$getDebugSchema$1) == false) goto L7;
        AIDebugManager$getDebugSchema$1 r0 = (AIDebugManager$getDebugSchema$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L17:
        String r15 = (String) r12;
        if (r15 == null) goto L20;
        n = true;
        return r15;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        n = false;
        AIManager r16 = AIManager.a;
        r0.label = 1;
        r12 = AIManager.j(r10, r0);
        if (r12 != r13) goto L17;
        return r13;
    L7:
        r0 = new AIDebugManager$getDebugSchema$1(this, r11);
        goto L8
    }

    public final Object p(String r10, Continuation r11) {
        if ((r11 instanceof AIDebugManager$loadAppletWithWidgets$1) == false) goto L7;
        AIDebugManager$loadAppletWithWidgets$1 r0 = (AIDebugManager$loadAppletWithWidgets$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        Applet r15 = (Applet) r0.L$1;
        Applet r16 = (Applet) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        List r17 = (List) r12;
        ArrayList<Widget> r18 = r16.S;
        if (r18 == null) goto L28;
        r18.clear();
    L28:
        if (r17 == null) goto L33;
        ArrayList<Widget> r19 = r16.S;
        if (r19 == null) goto L33;
        Boxing.boxBoolean(r19.addAll(r17));
    L33:
        return r16;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r20 = (String) r0.L$1;
        String r21 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        String r22 = r20;
        r10 = r21;
        Object r23 = r12;
    L19:
        Applet r24 = (Applet) r23;
        if (r24 == null) goto L34;
        AIDebugManager r25 = a;
        r0.L$0 = r24;
        r0.L$1 = r24;
        r0.label = 2;
        r12 = r25.s(r10, r22, r0);
        if (r12 != r13) goto L24;
        return r13;
    L24:
        r16 = r24;
        goto L25
    L34:
        return r24;
    L16:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r22 = null;
        r0.L$1 = null;
        r0.label = 1;
        r23 = n(r10, null, r0);
        if (r23 != r13) goto L19;
        return r13;
    L7:
        r0 = new AIDebugManager$loadAppletWithWidgets$1(this, r11);
        goto L8
    }

    public static void w(String r10, String r11, com.bytedance.ai.resource.d0 r12) {
        String r0 = r12.a;
        if (StringsKt.isBlank(r0) == true) goto L6;
        r10 = r0;
    L6:
        c r1 = new c(r10, r11);
        ConcurrentHashMap<String, com.bytedance.ai.resource.d0> r13 = g;
        com.bytedance.ai.resource.d0 r14 = r13.get(r10);
        if (r14 == null) goto L10;
        if (r14 == r12) goto L10;
        h.put(r10 + '_' + r14.i + '_' + r11, r14);
    L10:
        f.put(r1, r12);
        r13.put(r10, r12);
        AppletDebugTool r15 = b;
        if (r15 == null) goto L15;
        j1 r16 = r15.c;
        if (r16 == null) goto L15;
        Intrinsics.checkNotNullParameter(r13, "debugPackages");
        r16.g("debug_packages", r13);
        ConcurrentHashMap<String, com.bytedance.ai.resource.d0> r17 = h;
        Intrinsics.checkNotNullParameter(r17, "previousDebugPackages");
        r16.g("previous_debug_packages", r17);
    L15:
        com.bytedance.ai.utils.g.a.i("AIManager", "install scan preview package succeed: " + r10 + ", versionCode: " + r12.i + ", versionTag: " + r11);
    }

    public static void z(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "deviceId");
        Intrinsics.checkNotNullParameter(r11, "xToken");
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        StringBuilder r1 = new StringBuilder("setPreviewInstallContext. source: ");
        r1.append(r12);
        r1.append(", deviceIdEmpty: ");
        boolean r13 = false;
        if (r10.length() != 0) goto L5;
        boolean r14 = true;
    L6:
        r1.append(r14);
        r1.append(", xTokenEmpty: ");
        if (r11.length() != 0) goto L9;
        r13 = true;
    L9:
        r1.append(r13);
        r0.i("AIDebugManager", r1.toString());
        q = new b(r10, r11, r12);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public final Object a(final String r10, final String r11, Continuation<? super com.bytedance.ai.resource.d0> r12) {
        if ((r12 instanceof AIDebugManager$ensureScanPreviewPackage$1) == false) goto L7;
        AIDebugManager$ensureScanPreviewPackage$1 r0 = (AIDebugManager$ensureScanPreviewPackage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$ensureScanPreviewPackage$1 r13 = r0;
        Object r14 = r13.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r11 = (String) r13.L$1;
        r10 = (String) r13.L$0;
        ResultKt.throwOnFailure(r14);
    L34:
        return b(r10, r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        com.bytedance.ai.resource.d0 r17 = b(r10, r11);
        if (r17 == null) goto L17;
        return r17;
    L17:
        if (r11 != null) goto L19;
    L22:
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        return null;
    L26:
        b r19 = q;
        if (r19 != null) goto L30;
        com.bytedance.ai.utils.g.a.e("AIManager", "scan preview install context is null. packageName: " + r10 + ", versionTag: " + r11);
        return null;
    L30:
        AIManager r20 = AIManager.a;
        int r21 = r19.c;
        String r22 = r19.a;
        String r23 = r19.b;
        Function4<? super Boolean, ? super Boolean, ? super com.bytedance.ai.resource.d0, ? super String, Unit> r24 = new l(r10, r11);
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        if (r20.v(r21, r10, r11, r22, r23, r24, r13) != r15) goto L34;
        return r15;
    L19:
        if (r11.length() == 0) goto L22;
        r18 = false;
    L7:
        r0 = new AIDebugManager$ensureScanPreviewPackage$1(this, r12);
        goto L8
    }

    public final Object n(String r11, String r12, Continuation<? super Applet> r13) {
        int r0 = d.a[c.ordinal()];
        if (r0 != 1) goto L5;
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r13), 1);
        r10.C();
        com.bytedance.ai.resource.d0 r1 = d.get(r11);
        if (r1 == null) goto L22;
        Applet r14 = r1.g(r11);
    L23:
        if (r14 != null) goto L37;
        AppletDebugTool r15 = b;
        if (r15 == null) goto L36;
        j1 r16 = r15.c;
        if (r16 == null) goto L36;
        ConcurrentHashMap<String, Boolean> r17 = i;
        if (Intrinsics.areEqual(r17.get(r11), Boxing.boxBoolean(true)) == false) goto L31;
        com.bytedance.ai.utils.g.a.d("AIManager", "--loadApplet: " + r11 + " --skip to install " + r11 + " from debug host");
        r10.resumeWith(Result.constructor-impl(null));
    L38:
        Object r18 = r10.B();
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L41:
        return r18;
    L31:
        r17.put(r11, Boxing.boxBoolean(true));
        String r19 = r16.b(r11);
        if (r16.a.getBoolean("applet_cache_debug_host", false) == false) goto L35;
        if (r19 == null) goto L35;
        boolean r20 = r16.e(r11);
        String r21 = r16.c(r11);
        boolean r22 = r16.d(r11);
        com.bytedance.ai.utils.g.a.d("AIManager", "--loadApplet: " + r11 + " --try to install " + r11 + " from debug host: " + r19);
        l(a, r11, r20, r21, r22, new w(r10, r11), new x(r10), 64);
    L35:
        r10.resumeWith(Result.constructor-impl(null));
    L36:
        r10.resumeWith(Result.constructor-impl(null));
        goto L38
    L37:
        r10.resumeWith(Result.constructor-impl(r14));
        goto L38
    L22:
        r14 = null;
        goto L23
    L5:
        if (r0 == 2) goto L18;
        if (r0 != 3) goto L9;
        com.bytedance.ai.resource.d0 r23 = e.get(r11);
        if (r23 != null) goto L16;
        return null;
    L16:
        return r23.g(r11);
    L9:
        if (r0 != 4) goto L12;
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return o(r11, r12, r13);
    }

    public final Object o(String r10, String r11, Continuation<? super Applet> r12) {
        if ((r12 instanceof AIDebugManager$loadAppletFromScanPreview$1) == false) goto L7;
        AIDebugManager$loadAppletFromScanPreview$1 r0 = (AIDebugManager$loadAppletFromScanPreview$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        com.bytedance.ai.resource.d0 r16 = (com.bytedance.ai.resource.d0) r13;
        if (r16 != null) goto L22;
        return null;
    L22:
        return r16.g(r10);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r0.L$0 = r10;
        r0.label = 1;
        r13 = a(r10, r11, r0);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r0 = new AIDebugManager$loadAppletFromScanPreview$1(this, r12);
        goto L8
    }

    public final Object s(String r10, String r11, Continuation<? super List<? extends Widget>> r12) {
        if ((r12 instanceof AIDebugManager$loadWidgetsWithPackageName$1) == false) goto L7;
        AIDebugManager$loadWidgetsWithPackageName$1 r0 = (AIDebugManager$loadWidgetsWithPackageName$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L31:
        com.bytedance.ai.resource.d0 r16 = (com.bytedance.ai.resource.d0) r13;
        if (r16 != null) goto L40;
    L37:
        return null;
    L40:
        return r16.f();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        IAISDKDebugService$DebugMode r17 = c;
        int r18 = d.a[r17.ordinal()];
        if (r18 != 1) goto L17;
        com.bytedance.ai.resource.d0 r19 = d.get(r10);
        if (r19 == null) goto L37;
        return r19.f();
    L17:
        if (r18 != 2) goto L19;
        r0.label = 1;
        r13 = a(r10, r11, r0);
        if (r13 != r14) goto L31;
        return r14;
    L19:
        if (r18 != 3) goto L21;
        com.bytedance.ai.resource.d0 r20 = e.get(r10);
        if (r20 == null) goto L37;
        return r20.f();
    L21:
        if (r18 == 4) goto L37;
        throw new NoWhenBranchMatchedException();
    L7:
        r0 = new AIDebugManager$loadWidgetsWithPackageName$1(this, r12);
        goto L8
    }

    public final Object r(String r10, String r11, String r12, Continuation<? super Widget> r13) {
        if ((r13 instanceof AIDebugManager$loadWidgetFromScanPreview$1) == false) goto L7;
        AIDebugManager$loadWidgetFromScanPreview$1 r0 = (AIDebugManager$loadWidgetFromScanPreview$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        com.bytedance.ai.resource.d0 r17 = (com.bytedance.ai.resource.d0) r14;
        if (r17 != null) goto L22;
        return null;
    L22:
        return r17.h(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r0.L$0 = r11;
        r0.label = 1;
        r14 = a(r10, r12, r0);
        if (r14 != r15) goto L17;
        return r15;
    L7:
        r0 = new AIDebugManager$loadWidgetFromScanPreview$1(this, r13);
        goto L8
    }

    public final Object g(int r25, String r26, String r27, String r28, int r29, Continuation<? super OpenPlatformPreviewAppInfoList> r30) {
        if ((r30 instanceof AIDebugManager$getPreviewAppInfoList$1) == false) goto L7;
        AIDebugManager$getPreviewAppInfoList$1 r1 = (AIDebugManager$getPreviewAppInfoList$1) r30;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$getPreviewAppInfoList$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L35:
        OpenPlatformPreviewAppInfoList r14 = (OpenPlatformPreviewAppInfoList) r0;
        Map r15 = j();
        ArrayList r16 = null;
        if (r15.isEmpty() == false) goto L38;
    L37:
        OpenPlatformPreviewAppInfoList r17 = r14;
        JSONObject r18 = l;
        if (r18 != null) goto L70;
        OpenPlatformScanTarget r19 = null;
    L71:
        if (r19 == null) goto L77;
        List<OpenPlatformPreviewAppInfo> r20 = u(r17.getScanSelectedApps(), r19);
        List<OpenPlatformPreviewAppInfo> r21 = u(r17.getApps(), r19);
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "merge scan debug config with preview app info list. appKey: " + r19.getAppKey() + ", versionTag: " + r19.getVersionTag());
        if (r20 == r17.getScanSelectedApps()) goto L76;
    L78:
        r17 = OpenPlatformPreviewAppInfoList.copy$default(r17, null, r20, r21, null, false, 25, null);
        goto L77
    L76:
        if (r21 != r17.getApps()) goto L78;
    L77:
        OpenPlatformPreviewAppInfoList r110 = r17;
        List<OpenPlatformPreviewAppInfo> r22 = r110.getScanSelectedApps();
        if (r22 == null) goto L93;
        ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r22.iterator();
    L83:
        if (r24.hasNext() == false) goto L92;
        String r31 = ((OpenPlatformPreviewAppInfo) r24.next()).getAppKey();
        if (r31 != null) goto L87;
    L89:
        r31 = null;
    L90:
        if (r31 == null) goto L83;
        r23.add(r31);
        goto L83
    L87:
        if ((!StringsKt.isBlank(r31)) == false) goto L89;
    L92:
        Set r32 = CollectionsKt.toSet(r23);
    L94:
        if (r32 != null) goto L97;
        r32 = SetsKt.emptySet();
    L97:
        if (r32.isEmpty() == true) goto L139;
        List<OpenPlatformPreviewAppInfo> r33 = r110.getApps();
        if (r33 == null) goto L119;
        r16 = new ArrayList();
        Iterator<T> r34 = r33.iterator();
    L103:
        if (r34.hasNext() == false) goto L119;
        Object r35 = r34.next();
        String r36 = ((OpenPlatformPreviewAppInfo) r35).getAppKey();
        if (r36 != null) goto L107;
    L110:
        boolean r37 = true;
    L111:
        if (r37 == false) goto L113;
    L116:
        boolean r38 = true;
    L117:
        if (r38 == false) goto L103;
        r16.add(r35);
        goto L103
    L113:
        if (r32.contains(r36) == false) goto L116;
        r38 = false;
        goto L117
    L107:
        if (StringsKt.isBlank(r36) == true) goto L110;
        r37 = false;
    L119:
        ArrayList r111 = r16;
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "remove scan selected apps from preview app list. selectedAppCount: " + r32.size());
        return OpenPlatformPreviewAppInfoList.copy$default(r110, null, null, r111, null, false, 27, null);
    L139:
        return r110;
    L93:
        r32 = null;
        goto L94
    L70:
        r19 = new OpenPlatformScanTarget(r18.optString("app_key"), r18.optString("version_tag"));
        goto L71
    L38:
        List<OpenPlatformPreviewAppInfo> r39 = r14.getScanSelectedApps();
        if (r39 == null) goto L51;
        List<OpenPlatformPreviewAppInfo> r40 = r39;
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator<T> r42 = r40.iterator();
    L42:
        if (r42.hasNext() == false) goto L50;
        OpenPlatformPreviewAppInfo r43 = (OpenPlatformPreviewAppInfo) r42.next();
        String r44 = r43.getAppKey();
        if (r44 == null) goto L49;
        a r45 = (a) r15.get(r44);
        if (r45 == null) goto L49;
        a.getClass();
        r43 = t(r43, r45);
    L49:
        r41.add(r43);
        goto L42
    L50:
        ArrayList r112 = r41;
    L52:
        List<OpenPlatformPreviewAppInfo> r46 = r14.getApps();
        if (r46 == null) goto L65;
        List<OpenPlatformPreviewAppInfo> r47 = r46;
        ArrayList r48 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator<T> r49 = r47.iterator();
    L56:
        if (r49.hasNext() == false) goto L64;
        OpenPlatformPreviewAppInfo r50 = (OpenPlatformPreviewAppInfo) r49.next();
        String r51 = r50.getAppKey();
        if (r51 == null) goto L63;
        a r52 = (a) r15.get(r51);
        if (r52 == null) goto L63;
        a.getClass();
        r50 = t(r50, r52);
    L63:
        r48.add(r50);
        goto L56
    L64:
        ArrayList r113 = r48;
    L66:
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "merge preview debug config changes with mock app info list. changes: " + r15.size());
        r14 = OpenPlatformPreviewAppInfoList.copy$default(r14, null, r112, r113, null, false, 25, null);
        goto L37
    L65:
        r113 = null;
        goto L66
    L51:
        r112 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        ArrayList r53 = new ArrayList();
        JSONObject r54 = l;
        if (r54 == null) goto L32;
        String r55 = r54.optString("app_key");
        String r56 = r54.optString("version_tag");
        if (r55 != null) goto L19;
    L22:
        boolean r57 = true;
    L23:
        if (r57 == true) goto L32;
        if (r56 != null) goto L26;
    L29:
        boolean r58 = true;
    L30:
        if (r58 == true) goto L32;
        r53.add(new OpenPlatformScanTarget(r55, r56));
        goto L32
    L26:
        if (StringsKt.isBlank(r56) == true) goto L29;
        r58 = false;
        goto L30
    L19:
        if (StringsKt.isBlank(r55) == true) goto L22;
        r57 = false;
    L32:
        AIManager r59 = AIManager.a;
        r11.label = 1;
        r0 = AIManager.n(r25, r26, r27, r28, r29, r53, r11);
        if (r0 != r12) goto L35;
        return r12;
    L7:
        r1 = new AIDebugManager$getPreviewAppInfoList$1(this, r30);
        goto L8
    }

    public static void k(final String r12, final boolean r13, final String r14, final boolean r15, final Function0 r16, final Function1 r17, final String r18) {
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r16, "resolve");
        Intrinsics.checkNotNullParameter(r17, "reject");
        Intrinsics.checkNotNullParameter(r18, "appletType");
        x(IAISDKDebugService$DebugMode.LOCAL_DEBUG);
        AppletResourceTool r10 = AppletResourceTool.a;
        Function1 r11 = new n(r12, r17, r13, r14, r15, r18, r16);
        Function1 r0 = new o(r12, r17);
        r10.getClass();
        AppletResourceTool.p(r12, "manifest.json", false, r11, r0);
    }

    public final Object h(int r20, String r21, String r22, String r23, String r24, int r25, Continuation<? super OpenPlatformPreviewAppVersionList> r26) {
        if ((r26 instanceof AIDebugManager$getPreviewAppVersionList$1) == false) goto L7;
        AIDebugManager$getPreviewAppVersionList$1 r1 = (AIDebugManager$getPreviewAppVersionList$1) r26;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AIDebugManager$getPreviewAppVersionList$1 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r11.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        OpenPlatformPreviewAppVersionList r14 = (OpenPlatformPreviewAppVersionList) r0;
        a r15 = (a) j().get(r14.getAppKey());
        if (r15 != null) goto L21;
    L38:
        JSONObject r16 = l;
        if (r16 != null) goto L41;
        OpenPlatformScanTarget r17 = null;
    L42:
        if (r17 == null) goto L56;
        OpenPlatformPreviewVersionPage r18 = r14.getFormalVersions();
        if (r18 == null) goto L57;
        boolean r19 = Intrinsics.areEqual(r14.getAppKey(), r17.getAppKey());
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "merge scan debug config with preview app version list. appKey: " + r17.getAppKey() + ", versionTag: " + r17.getVersionTag() + ", targetApp: " + r19);
        if (r19 == false) goto L58;
        List<OpenPlatformPreviewVersion> r27 = v(r18.getItems(), r17.getVersionTag());
        if (r27 != r18.getItems()) goto L54;
        return r14;
    L54:
        return OpenPlatformPreviewAppVersionList.copy$default(r14, null, OpenPlatformPreviewVersionPage.copy$default(r18, r27, null, false, 6, null), 1, null);
    L58:
        return r14;
    L57:
        return r14;
    L56:
        return r14;
    L41:
        r17 = new OpenPlatformScanTarget(r16.optString("app_key"), r16.optString("version_tag"));
        goto L42
    L21:
        if (r15.b == false) goto L28;
        String r28 = r15.c;
        if (r28 == null) goto L28;
        OpenPlatformPreviewVersionPage r29 = r14.getFormalVersions();
        if (r29 == null) goto L28;
        List<OpenPlatformPreviewVersion> r30 = r29.getItems();
        if (r30 == null) goto L35;
        List<OpenPlatformPreviewVersion> r31 = r30;
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator<T> r33 = r31.iterator();
    L33:
        if (r33.hasNext() == false) goto L36;
        OpenPlatformPreviewVersion r110 = (OpenPlatformPreviewVersion) r33.next();
        r32.add(OpenPlatformPreviewVersion.copy$default(r110, null, null, Boolean.valueOf(Intrinsics.areEqual(r110.getVersionTag(), r28)), null, null, 27, null));
    L36:
        OpenPlatformPreviewAppVersionList r34 = OpenPlatformPreviewAppVersionList.copy$default(r14, null, OpenPlatformPreviewVersionPage.copy$default(r29, r32, null, false, 6, null), 1, null);
    L37:
        com.bytedance.ai.utils.g.a.i("AIDebugManager", "merge preview debug config changes with mock app version list. appKey: " + r14.getAppKey());
        r14 = r34;
        goto L38
    L35:
        r32 = null;
    L28:
        r34 = r14;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        AIManager r35 = AIManager.a;
        r11.label = 1;
        r0 = AIManager.o(r20, r21, r22, r23, r24, r25, r11);
        if (r0 != r12) goto L17;
        return r12;
    L7:
        r1 = new AIDebugManager$getPreviewAppVersionList$1(this, r26);
        goto L8
    }

    public static /* synthetic */ void l(AIDebugManager r10, String r11, boolean r12, String r13, boolean r14, Function0 r15, Function1 r16, int r17) {
        String r1 = null;
        if ((r17 & 4) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r17 & 32) == 0) goto L13;
        Function1 r20 = new m();
    L15:
        if ((r17 & 64) == 0) goto L17;
        r1 = "0";
    L17:
        r10.getClass();
        k(r11, r12, r18, r19, r15, r20, r1);
        return;
    L13:
        r20 = r16;
        goto L15
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }
}
