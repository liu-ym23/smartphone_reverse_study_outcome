package com.ss.android.badger;

import com.bytedance.badger.Badger;
import com.ss.android.token.g;
import com.ss.android.token.h;
import com.ss.android.token.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements h {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    @Override // com.ss.android.token.h
    public final void a(g r12) {
        if (r12.f == true) goto L5;
        return;
    L5:
        if (r12.i == false) goto L47;
        String r2 = r12.a;
        String r0 = r12.b;
        List<o> r1 = r12.d;
        List<o> r3 = r12.e;
        long r4 = r12.c;
        KProperty[] r13 = AccountBadger.a;
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.H == true) goto L10;
        return;
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        tb7.a.b("AccountBadger", "handleRequest, url is null");
        return;
    L19:
        if (r0 != null) goto L21;
    L25:
        Badger r14 = Badger.INSTANCE;
        if (r14.isInitialized() == true) goto L29;
        tb7.a.b("AccountBadger", "handleRequest, Badger not initialized");
        return;
    L29:
        if (r1 == null) goto L34;
        List<o> r5 = r1;
        ?? r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L32:
        if (r8.hasNext() == false) goto L35;
        o r9 = (o) r8.next();
        r6.add(TuplesKt.to(r9.a, r9.b));
    L35:
        if (r3 == null) goto L41;
        List<o> r10 = r3;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r15 = r10.iterator();
    L38:
        if (r15.hasNext() == false) goto L40;
        o r16 = (o) r15.next();
        r11.add(TuplesKt.to(r16.a, r16.b));
        goto L38
    L40:
        List r17 = r11;
    L42:
        r14.handleResponse(r2, r4, r6, r17);
        return;
    L41:
        r17 = CollectionsKt.emptyList();
        goto L42
    L34:
        r6 = CollectionsKt.emptyList();
        goto L35
    L21:
        if (StringsKt.startsWith$default(r0, "/passport/", false, 2, null) == false) goto L25;
        if (AccountBadger.d.compareAndSet(false, true) == false) goto L25;
        AccountBadger.f.getClass();
        AccountBadger.b();
        goto L25
    L12:
        if (r2.length() == 0) goto L15;
        r7 = false;
        goto L17
    }
}
