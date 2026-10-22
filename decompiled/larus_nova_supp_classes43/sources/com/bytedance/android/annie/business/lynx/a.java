package com.bytedance.android.annie.business.lynx;

import com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import q26.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends DefaultDynamicComponentFetcher {
    public final Map<String, ? extends k7a.a> d;

    /* JADX INFO: renamed from: com.bytedance.android.annie.business.lynx.a$a, reason: collision with other inner class name */
    public static final class C0065a {
    }

    static {
    }

    public a(j r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L9
        f8.b r12 = com.bytedance.android.annie.lynx.e.a().h;     // Catch: Throwable -> L9
        if (r12 == null) goto L6;
        Map<String, k7a.a> r13 = r12.provide();     // Catch: Throwable -> L9
    L7:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L9
    L12:
        if (Result.exceptionOrNull-impl(r14) == null) goto L15;
        r14 = MapsKt.emptyMap();
    L15:
        this.d = (Map) r14;
        return;
    L6:
        r13 = null;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final void loadDynamicComponent(String r10, k7a.a.a r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == true) goto L41;
        Map<String, ? extends k7a.a> r13 = this.d;
        if (r13 == null) goto L41;
        if (r13.isEmpty() != true) goto L15;
        boolean r14 = true;
    L16:
        if (r14 == true) goto L41;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L39
        String r16 = UriProtector.getQueryParameter(UriProtector.parse(r10), "res_biz_name");     // Catch: Throwable -> L39
        if (r16 != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == true) goto L41;
        Map<String, ? extends k7a.a> r18 = this.d;     // Catch: Throwable -> L39
        if (r18 == null) goto L36;
        Iterator<Map.Entry<String, ? extends k7a.a>> r19 = r18.entrySet().iterator();     // Catch: Throwable -> L39
    L31:
        if (r19.hasNext() == false) goto L35;
        Map.Entry<String, ? extends k7a.a> r20 = r19.next();     // Catch: Throwable -> L39
        if (Intrinsics.areEqual(r20.getKey(), r16) == false) goto L31;
        r20.getValue().loadDynamicComponent(r10, new b(this, r10, r11));     // Catch: Throwable -> L39
        r0 = true;
        goto L41
    L35:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L37:
        Result.constructor-impl(r1);     // Catch: Throwable -> L39
        goto L41
    L36:
        r1 = null;
        goto L37
    L21:
        if (r16.length() == 0) goto L24;
        r17 = false;
    L39:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    L15:
        r14 = false;
    L41:
        if (r0 == false) goto L43;
        return;
    L43:
        super.loadDynamicComponent(r10, r11);
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
