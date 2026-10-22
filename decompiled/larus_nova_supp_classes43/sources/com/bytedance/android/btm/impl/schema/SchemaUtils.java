package com.bytedance.android.btm.impl.schema;

import android.view.View;
import bd.c;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.h;
import com.bytedance.android.btm.api.k;
import com.bytedance.android.btm.impl.RegisterBtmPageHelper;
import com.bytedance.android.btm.impl.page.unknown.UnknownActivityLifecycleCallback;
import com.bytedance.android.btm.impl.setting.t;
import com.bytedance.android.btm.impl.setting.u;
import com.bytedance.android.btm.impl.thread.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SchemaUtils implements k {
    public static final Object a = null;
    public static boolean b;
    public static int c;
    public static final ConcurrentHashMap<String, List<String>> d = null;
    public static final Lazy e = null;
    public static final Map<String, Regex> f = null;
    public static final Map<String, String> g = null;
    public static final SchemaUtils$schemaNotMatchList$1 h = null;
    public static final Lazy i = null;
    public static final SchemaUtils j = null;

    public static final class a implements h {
        public final /* synthetic */ View a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        @Override // com.bytedance.android.btm.api.inner.h
        public void call(String r10, String r11) {
            Object r0 = SchemaUtils.a;
            if (SchemaUtils.c("getHybridContainerPageBtmBy", r10, "View", this.a, this.b, "") == false) goto L9;
            String r1 = RegisterBtmPageHelper.a;
            View r12 = this.a;
            String r13 = this.c;
            if (r13 == null) goto L7;
            r11 = r13;
        L7:
            RegisterBtmPageHelper.b(r12, r10, r11, null);
            return;
        }

        public a(View r1, String r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }
    }

    public SchemaUtils() {
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.android.btm.impl.schema.SchemaUtils$schemaNotMatchList$1] */
    static {
        j = new SchemaUtils();
        a = new Object();
        c = 20;
        d = new ConcurrentHashMap();
        e = LazyKt.lazy(SchemaUtils$handler$2.INSTANCE);
        f = Collections.synchronizedMap(new SchemaUtils$pattern2RegexCache$1());
        g = Collections.synchronizedMap(new SchemaUtils$schema2PageBtmCache$1());
        h = new SchemaUtils$schemaNotMatchList$1();
        i = LazyKt.lazy(SchemaUtils$gson$2.INSTANCE);
    }

    public static void b(u r10) {
        ALogger.m(ALogger.d, "SchemaUtils_build", SchemaUtils$build$1.INSTANCE);
        List r0 = r10.a();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        d.clear();
        Iterator r11 = r10.a().iterator();
    L13:
        if (r11.hasNext() == false) goto L32;
        t r12 = (t) r11.next();
        if (r12.a().length() != 0) goto L17;
        boolean r13 = true;
    L18:
        if (r13 == true) goto L13;
        List<String> r14 = r12.b();
        if (r14 != null) goto L22;
    L25:
        boolean r15 = true;
    L26:
        if (r15 == true) goto L13;
        ConcurrentHashMap<String, List<String>> r16 = d;
        String r17 = r12.a();
        List<String> r18 = r12.b();
        if (r18 != null) goto L31;
        Intrinsics.throwNpe();
    L31:
        r16.put(r17, r18);
        goto L13
    L22:
        if (r14.isEmpty() == true) goto L25;
        r15 = false;
        goto L26
    L17:
        r13 = false;
        goto L18
    L32:
        ALogger.m(ALogger.d, "SchemaUtils_build", SchemaUtils$build$3.INSTANCE);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.btm.api.k
    public final void a(final String r10, View r11, final String r12, String r13) {
        final String r0 = r11.getClass().getName();
        Set<c> r1 = UnknownActivityLifecycleCallback.a;
        UnknownActivityLifecycleCallback.b(r10, r11);
        ALogger.m(ALogger.d, "SchemaUtils_registerHybridContainerSchemaPageAsync", new SchemaUtils$registerHybridContainerSchemaPageAsync$1(r10, r0, r12));
        a r14 = new a(r11, r10, r13);
        monitor-enter(this);
        b r15 = b.e;     // Catch: Throwable -> L7
        com.bytedance.android.btm.impl.schema.a r16 = new com.bytedance.android.btm.impl.schema.a(r10, r12, r14);     // Catch: Throwable -> L7
        r15.getClass();     // Catch: Throwable -> L7
        b.d(r16);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean c(final String r10, final String r11, final String r12, Object r13, final String r14, final String r15) {
        final String r16 = r13.getClass().getName();
        if (r11.length() != 0) goto L5;
        boolean r17 = true;
    L7:
        if (r17 == false) goto L10;
        ALogger.m(ALogger.d, "BTMSDK_schema_ISchemaCallback_call", new SchemaUtils$pageBtmIsNotEmpty$1(r10, r12, r15, r14, r16));
        return false;
    L10:
        ALogger.m(ALogger.d, "BTMSDK_schema_ISchemaCallback_call", new SchemaUtils$pageBtmIsNotEmpty$2(r10, r12, r15, r14, r11, r16));
        return true;
    L5:
        r17 = false;
        goto L7
    }
}
