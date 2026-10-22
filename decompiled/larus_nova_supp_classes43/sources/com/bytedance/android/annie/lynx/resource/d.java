package com.bytedance.android.annie.lynx.resource;

import android.os.AsyncTask;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements com.bytedance.android.annie.card.base.d, k7a.a {
    public final com.bytedance.android.annie.service.resource.g a;
    public volatile boolean b;
    public final k7a.a c;
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> d;
    public com.bytedance.android.annie.card.base.c e;
    public final Map<String, ? extends k7a.a> f;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ k7a.a.a c;

        public b(d r1, String r10, k7a.a.a r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void a() {
            final d r0 = this.a;
            final String r1 = this.b;
            final k7a.a.a r10 = this.c;
            r0.getClass();
            LinkedHashMap r11 = new LinkedHashMap();
            com.bytedance.android.annie.card.base.c r12 = r0.e;
            if (r12 == null) goto L5;
            r12.b(r1, AnnieResType.COMPONENT, IHybridComponent.HybridType.LYNX, r11);
        L5:
            RequestConfig r13 = new RequestConfig(AnnieResType.LYNX_CHILD_RESOURCE);
            r13.c = n.c(IHybridComponent.HybridType.LYNX);
            com.bytedance.android.annie.service.resource.g r14 = r0.a;
            r13.l = r14.e;
            if (r14.c == false) goto L8;
            r13.h = r14.d;
        L8:
            r13.a().putAll(r11);
            com.bytedance.android.annie.service.resource.h r15 = n.g(r1, r13, new LynxDynamicComponentProvider$useGeckoLoader$2(r0, r1, r10));
            if (r15 == null) goto L11;
            r0.d.put(r1, r15);
            return;
        L11:
            if (r10 == null) goto L15;
            r10.a(null, new Throwable("gecko loader is null"));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.card.base.d
    public final ConcurrentHashMap<String, com.bytedance.android.annie.service.resource.h> a() {
        return this.d;
    }

    public d(com.bytedance.android.annie.service.resource.g r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        this.a = r10;
        ConcurrentHashMap<String, d8.b> r0 = e8.d.a;
        f8.c r11 = e8.d.a(r10.f).g;
        Map<String, k7a.a> r1 = null;
        if (r11 == null) goto L5;
        k7a.a r12 = r11.provide();
    L6:
        this.c = r12;
        this.d = new ConcurrentHashMap();
        f8.b r13 = com.bytedance.android.annie.lynx.e.a().h;
        if (r13 == null) goto L9;
        r1 = r13.provide();
    L9:
        this.f = r1;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void b(String r10, k7a.a.a r11) {
        if (r10 != null) goto L5;
        if (r11 == null) goto L19;
        r11.a(null, new Throwable("url is null"));
        return;
    L19:
        return;
    L5:
        if (this.a.a == false) goto L7;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new b(this, r10, r11));
        return;
    L7:
        k7a.a r1 = this.c;
        if (r1 == null) goto L10;
        r1.loadDynamicComponent(r10, r11);
        return;
    L10:
        if (r11 == null) goto L17;
        r11.a(null, new Throwable("provider is null"));
        return;
    }

    public final void loadDynamicComponent(String r10, k7a.a.a r11) {
        if (this.b == false) goto L5;
        return;
    L5:
        boolean r0 = false;
        if (r10 != null) goto L8;
    L11:
        boolean r12 = true;
    L12:
        if (r12 == true) goto L44;
        Map<String, ? extends k7a.a> r13 = this.f;
        if (r13 == null) goto L44;
        if (r13.isEmpty() != true) goto L18;
        boolean r14 = true;
    L19:
        if (r14 == true) goto L44;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L42
        String r16 = UriProtector.getQueryParameter(UriProtector.parse(r10), "res_biz_name");     // Catch: Throwable -> L42
        if (r16 != null) goto L24;
    L27:
        boolean r17 = true;
    L28:
        if (r17 == true) goto L44;
        Map<String, ? extends k7a.a> r18 = this.f;     // Catch: Throwable -> L42
        if (r18 == null) goto L39;
        Iterator<Map.Entry<String, ? extends k7a.a>> r19 = r18.entrySet().iterator();     // Catch: Throwable -> L42
    L34:
        if (r19.hasNext() == false) goto L38;
        Map.Entry<String, ? extends k7a.a> r20 = r19.next();     // Catch: Throwable -> L42
        if (Intrinsics.areEqual(r20.getKey(), r16) == false) goto L34;
        r20.getValue().loadDynamicComponent(r10, new e(this, r10, r11));     // Catch: Throwable -> L42
        r0 = true;
        goto L44
    L38:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L40:
        Result.constructor-impl(r1);     // Catch: Throwable -> L42
        goto L44
    L39:
        r1 = null;
        goto L40
    L24:
        if (r16.length() == 0) goto L27;
        r17 = false;
    L42:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L18:
        r14 = false;
    L44:
        if (r0 == false) goto L46;
        return;
    L46:
        b(r10, r11);
        return;
    L8:
        if (r10.length() == 0) goto L11;
        r12 = false;
        goto L12
    }
}
