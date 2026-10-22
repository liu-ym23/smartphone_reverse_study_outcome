package com.bytedance.android.ec.core.imagex;

import com.bytedance.android.ec.core.utils.a2;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class r implements com.bytedance.android.shopping.api.image.l, com.bytedance.android.ec.core.imagex.opt.x {
    public static final /* synthetic */ int h = 0;
    public String a;
    public String b;
    public Map<String, Object> c;
    public Map<String, Object> d;
    public final WeakReference<Function0<Map<String, Object>>> e;
    public final String f;
    public String g;

    public static final class a {
        @JvmStatic
        public static r a(String r10) {
            String r11 = a2.d(r10);
            if (r11 != null) goto L6;
            r11 = "unknown";
        L6:
            return new r("ec_detail", r11);
        }

        @JvmStatic
        public static r b(String r10) {
            String r11 = a2.d(r10);
            if (r11 != null) goto L6;
            r11 = "unknown";
        L6:
            return new r("ec_live", r11);
        }

        @JvmStatic
        public static r c(String r10) {
            String r11 = a2.d(r10);
            if (r11 != null) goto L6;
            r11 = "unknown";
        L6:
            return new r("ec_shop", r11);
        }

        @JvmStatic
        public static r d(String r10) {
            String r11 = a2.d(r10);
            if (r11 != null) goto L6;
            r11 = "unknown";
        L6:
            return new r("ec_window", r11);
        }
    }

    static {
    }

    public final String toString() {
        Pair[] r0 = new Pair[3];
        r0[0] = TuplesKt.to("biz_tag", this.f);
        r0[1] = TuplesKt.to("scene_tag", this.g);
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_NAME, r1);
        Map r10 = MapsKt.mutableMapOf(r0);
        r10.putAll(this.d);
        return "ImageCallerContext " + r10;
    }

    @Override // com.bytedance.android.ec.core.imagex.opt.x
    public final String getCacheKey() {
        StringBuilder r0 = new StringBuilder("ImageCallerContextbiz_tag:");
        r0.append(this.f);
        r0.append(",scene_tag:");
        r0.append(this.g);
        r0.append(",page_name:");
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.append(r1);
        r0.append(",");
        return r0.toString();
    }

    public final String a() {
        return this.g;
    }

    public final Map<String, Object> c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public final String getBizTag() {
        return this.f;
    }

    public final Object b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return this.d.get(r10);
    }

    public final void i(String r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        this.d.remove(r10);
    }

    public r(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bizTag");
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        this.f = r10;
        this.g = r11;
        this.b = com.bytedance.android.ec.core.event.a.VALUE_NATIVE;
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
    }

    public final void f(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.d.put(r10, r11);
    }

    public final void g(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.c.put("biz_extra_" + r10, r11);
    }

    public final void h(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        this.c.put(r10, r11);
    }

    public r(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "bizTag");
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        Intrinsics.checkNotNullParameter(r12, "pageName");
        this(r10, r11);
        this.a = r12;
    }

    public r(String r10, String r11, Function0<? extends Map<String, ? extends Object>> r12) {
        Intrinsics.checkNotNullParameter(r10, "mBizTag");
        Intrinsics.checkNotNullParameter(r11, "mSceneTag");
        this(r10, r11);
        this.e = new WeakReference(r12);
    }
}
