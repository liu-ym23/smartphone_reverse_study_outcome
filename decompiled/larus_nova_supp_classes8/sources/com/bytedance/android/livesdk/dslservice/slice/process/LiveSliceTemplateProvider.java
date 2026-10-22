package com.bytedance.android.livesdk.dslservice.slice.process;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.api.data.subscribe.d;
import com.bytedance.android.ecom.arch.slice.render.ISlcElement;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.g;
import com.bytedance.android.ecom.arch.slice.render.i;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.dslservice.gecko.GeckoUtils;
import com.bytedance.android.livesdk.dslservice.slice.cache.c;
import com.bytedance.android.livesdk.dslservice.slice.cache.f;
import com.bytedance.android.livesdk.dslservice.util.o;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveSliceTemplateProvider implements g {
    public final f a;

    public final void release() {
    }

    public LiveSliceTemplateProvider() {
        f r0 = f.d;
        Intrinsics.checkNotNullParameter(r0, "cacheManager");
        this.a = r0;
    }

    public final void a(i r12, Map<String, ? extends Object> r13, final com.bytedance.android.ecom.arch.slice.render.f r14) {
        Intrinsics.checkNotNullParameter(r12, "createViewInfo");
        Intrinsics.checkNotNullParameter(r14, "listener");
        Context r0 = null;
        if ((r12 instanceof a) == true) goto L5;
        i r15 = null;
    L6:
        a r16 = (a) r15;
        final String r1 = r12.b;
        String r17 = r12.a;
        if (r16 == null) goto L41;
        final q r2 = r16.d;
        if (r2 == null) goto L42;
        String r3 = r16.e;
        this.a.getClass();
        SlcElement r7 = f.a.a(r2);
        this.a.getClass();
        c r4 = f.b;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "key");
        LinkedList<r> r5 = r4.a(r2);
        if (r5 == null) goto L14;
        r r6 = r5.poll();
    L15:
        WeakReference<Context> r18 = r16.f;
        if (r18 == null) goto L18;
        Context r19 = r18.get();
    L19:
        if (r6 == null) goto L23;
        View r8 = r6.c;
        if (r8 == null) goto L23;
        r0 = r8.getContext();
    L23:
        boolean r110 = Intrinsics.areEqual(r19, r0);
        if (r6 == null) goto L28;
        if (r110 == false) goto L28;
        o.f.d(new LiveSliceTemplateProvider$loadTemplate$1(r1));
        r14.a(new com.bytedance.android.ecom.arch.slice.render.o(r6, r7, true, "ViewCache", 440));
        return;
    L28:
        boolean r111 = false;
        if (r7 == null) goto L32;
        c(r1, r14, r7, false);
        return;
    L32:
        if (r3 != null) goto L34;
    L39:
        o.f.d(new LiveSliceTemplateProvider$loadTemplate$3(r1));
        ConcurrentHashMap<String, com.bytedance.android.livesdk.dslservice.gecko.a> r112 = GeckoUtils.a;
        GeckoUtils.a(o.d, r1, r17, new LiveSliceTemplateProvider$loadTemplate$4(this, r2, r14), LiveSliceTemplateProvider$loadTemplate$5.INSTANCE);
        return;
    L34:
        if (r3.length() <= 0) goto L36;
        r111 = true;
    L36:
        if (r111 != true) goto L39;
        o.f.d(new LiveSliceTemplateProvider$loadTemplate$2(r1));
        b(r3, r2, "LocalRawData", r14);
        return;
    L18:
        r19 = null;
        goto L19
    L14:
        r6 = null;
        goto L15
    L42:
        return;
    L41:
        return;
    L5:
        r15 = r12;
        goto L6
    }

    public static void c(final String r8, com.bytedance.android.ecom.arch.slice.render.f r9, SlcElement r10, boolean r11) {
        o.f.d(new LiveSliceTemplateProvider$loadFromElement$1(r8));
        if (r11 == false) goto L5;
        String r12 = "RemoteData";
    L6:
        r9.a(new com.bytedance.android.ecom.arch.slice.render.o(null, r10, false, r12, 441));
        return;
    L5:
        r12 = "NodeCache";
        goto L6
    }

    public final void b(String r7, q r8, String r9, com.bytedance.android.ecom.arch.slice.render.f r10) {
        if (v.a() == false) goto L5;
        this.a.getClass();
        f.c.b().put(r8, r7);
    L5:
        Gson r0 = d.a;
        Object r11 = d.a(r7, ISlcElement.class);
        if ((r11 instanceof SlcElement) == true) goto L8;
        r11 = null;
    L8:
        SlcElement r2 = (SlcElement) r11;
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "key");
        if (r2 == null) goto L23;
        boolean r1 = true;
        if (r8.b.length() != 0) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == true) goto L17;
    L22:
        f.a.b().put(r8, r2);
        goto L23
    L17:
        if (r8.c.length() == 0) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
    L14:
        r12 = false;
    L23:
        r10.a(new com.bytedance.android.ecom.arch.slice.render.o(null, r2, false, r9, 441));
    }
}
