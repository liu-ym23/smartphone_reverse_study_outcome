package com.bytedance.ai.debugscene;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j1 {
    public final SharedPreferences a;
    public final ConcurrentHashMap<String, String> b;
    public final boolean c;

    public static final class a {
    }

    public static final class b {
        public final List<Applet> a;
        public final List<Widget> b;

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
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DebugPackageWrapper(applets=" + this.a + ", widgets=" + this.b + ')';
        }

        public b() {
            this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(List<Applet> r10, List<? extends Widget> r11) {
            Intrinsics.checkNotNullParameter(r10, "applets");
            Intrinsics.checkNotNullParameter(r11, "widgets");
            this.a = r10;
            this.b = r11;
        }
    }

    static {
    }

    public final void a() {
        SharedPreferences.Editor r0 = this.a.edit();
        r0.remove("debug_packages");
        r0.remove("previous_debug_packages");
        r0.remove("remote_debug_modern_tag_package");
        r0.commit();
        com.bytedance.ai.utils.g.a.i("AISDKDebugSettings", "Cleared all debug packages from storage");
    }

    public j1(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        SharedPreferences r11 = r10.getSharedPreferences("ai_sdk_sp_debug_settings_external", 0);
        this.a = r11;
        this.b = new ConcurrentHashMap();
        this.c = r11.getBoolean("applet_cache_debug_host", false);
    }

    public final String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r11 = "host_" + r10;
        String r0 = this.b.get(r11);
        if (r0 == null) goto L5;
    L15:
        return r0;
    L5:
        if (this.c == false) goto L15;
        r0 = this.a.getString(r11, null);
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        this.b.put(r11, r0);
        goto L15
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }

    public final String c(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r11 = "sign_version_" + r10;
        String r0 = this.b.get(r11);
        if (r0 == null) goto L5;
    L15:
        return r0;
    L5:
        if (this.c == false) goto L15;
        r0 = this.a.getString(r11, null);
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        this.b.put(r11, r0);
        goto L15
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }

    public final boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r11 = "encrypted_" + r10;
        String r0 = this.b.get(r11);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(Boolean.parseBoolean(r0));
    L6:
        if (r1 != null) goto L12;
        if (this.c == false) goto L12;
        boolean r12 = this.a.getBoolean(r11, false);
        this.b.put(r11, String.valueOf(r12));
        return r12;
    L12:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    public final boolean e(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r11 = "verify_" + r10;
        String r0 = this.b.get(r11);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(Boolean.parseBoolean(r0));
    L6:
        if (r1 != null) goto L12;
        if (this.c == false) goto L12;
        boolean r12 = this.a.getBoolean(r11, false);
        this.b.put(r11, String.valueOf(r12));
        return r12;
    L12:
        return Intrinsics.areEqual(r1, Boolean.TRUE);
    L5:
        r1 = null;
        goto L6
    }

    public final List<AIPackage> f(String r10) {
        ArrayList r11 = new ArrayList();
        String r12 = this.a.getString(r10, "");     // Catch: Exception -> L7
        if (com.bytedance.ai.utils.f.g(r12) == false) goto L9;
        Lazy r13 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L7
        b r14 = (b) com.bytedance.ai.applet.base.gson.e.a(r12, b.class);     // Catch: Exception -> L7
        r11.addAll(r14.a);     // Catch: Exception -> L7
        r11.addAll(r14.b);     // Catch: Exception -> L7
        com.bytedance.ai.utils.g.a.d("AISDKDebugSettings", "Loaded " + r11.size() + " debug packages (" + r14.a.size() + " applets, " + r14.b.size() + " widgets) from storage--" + r10);     // Catch: Exception -> L7
    L9:
        return r11;
    L7:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AISDKDebugSettings", "Failed to load debug packages-" + r10 + ": " + e.getMessage());
        goto L9
    }

    public final void g(String r10, Map<String, com.bytedance.ai.resource.d0> r11) {
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L18
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L18
        ConcurrentHashMap r13 = (ConcurrentHashMap) r11;     // Catch: Exception -> L18
        Iterator r14 = r13.entrySet().iterator();     // Catch: Exception -> L18
    L5:
        if (r14.hasNext() == false) goto L10;
        com.bytedance.ai.resource.d0 r15 = (com.bytedance.ai.resource.d0) ((Map.Entry) r14.next()).getValue();     // Catch: Exception -> L18
        Applet r16 = r15.g(r15.a);     // Catch: Exception -> L18
        if (r16 == null) goto L9;
        r1.add(r16);     // Catch: Exception -> L18
    L9:
        r12.addAll(r15.f());     // Catch: Exception -> L18
        goto L5
    L10:
        String r17 = com.bytedance.ai.applet.base.gson.e.c(new b(r1, r12));     // Catch: Exception -> L18
        com.bytedance.ai.utils.g.a.d("AISDKDebugSettings", "save debug packages: " + r17);     // Catch: Exception -> L18
        if (com.bytedance.ai.utils.f.g(r17) == true) goto L21;
    L16:
        SharedPreferences.Editor r18 = this.a.edit();     // Catch: Exception -> L18
        r18.putString(r10, r17);     // Catch: Exception -> L18
        r18.commit();     // Catch: Exception -> L18
        com.bytedance.ai.utils.g.a.d("AISDKDebugSettings", "Saved " + r13.size() + " debug packages (" + r1.size() + " applets, " + r12.size() + " widgets) to storage--" + r10);     // Catch: Exception -> L18
        return;
    L21:
        b r19 = (b) com.bytedance.ai.applet.base.gson.e.a(r17, b.class);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AISDKDebugSettings", "反序列化失败：" + e);     // Catch: Exception -> L18
    L18:
        e = move-exception;
        com.bytedance.ai.utils.g.a.e("AISDKDebugSettings", "Failed to save debug packages-" + r10 + ": " + e.getMessage());
    }

    public final void h(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "appletName");
        String r12 = "show_debug_tag_" + r10;
        this.b.put(r12, String.valueOf(r11));
        if (this.c == false) goto L6;
        SharedPreferences.Editor r0 = this.a.edit();
        r0.putBoolean(r12, r11);
        r0.commit();
        return;
    }
}
