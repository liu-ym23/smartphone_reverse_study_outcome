package com.bytedance.android.annie.debug.service;

import android.view.View;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y7.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements c {
    public String a;

    public a() {
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void a(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.a = r1;
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void onRelease(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        GeckoOfflineInfoHolder r0 = (GeckoOfflineInfoHolder) GeckoOfflineInfoHolder.b.getValue();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        String r11 = GeckoOfflineInfoHolder.a(r10);
        if (r11 == null) goto L16;
        monitor-enter(r0);
        g r12 = (g) ((Map) r0.a.getValue()).remove(r11);     // Catch: Throwable -> L11
        monitor-exit(r0);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void h(View r22, com.bytedance.android.annie.card.web.resource.a r23) {
        Intrinsics.checkNotNullParameter(r23, "resourceInfo");
        Intrinsics.checkNotNullParameter(r23, "resourceInfo");
        if (r22 != null) goto L5;
        return;
    L5:
        String r10 = this.a;
        if (r10 != null) goto L8;
        return;
    L8:
        GeckoOfflineInfoHolder r11 = (GeckoOfflineInfoHolder) GeckoOfflineInfoHolder.b.getValue();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r22, "view");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r23, "resourceInfo");
        String r0 = "template loaded, offline " + r23.a + ", from " + r23.b + ", version " + r23.c + ", url " + r10;
        b8.a r12 = b8.a.a;
        b8.a.d(new b8.b("GeckoOfflineInfoHolder", LogLevel.DEBUG, null, r0));
        String r1 = GeckoOfflineInfoHolder.a(r10);
        if (r1 != null) goto L12;
        return;
    L12:
        if (r23.a == true) goto L14;
        g r13 = new g(false, r23.d, r23.b, "");
    L47:
        monitor-enter(r11);
        ((Map) r11.a.getValue()).put(r1, r13);     // Catch: Throwable -> L51
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r11);
        return;
    L51:
        th = move-exception;
        throw th;
    L14:
        if (r23.d == false) goto L16;
        String r15 = String.valueOf(r23.c);
    L45:
        String r16 = "offline version " + r15 + ", forest " + r23.d;
        b8.a r17 = b8.a.a;
        b8.a.d(new b8.b("GeckoOfflineInfoHolder", LogLevel.DEBUG, null, r16));
        r13 = new g(true, r23.d, r23.b, r15);
        goto L47
    L16:
        int r18 = a8.a.a;
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (StringsKt.isBlank(r10) == true) goto L44;
        ArrayList r19 = new ArrayList();
        r19.addAll(ov5.a.b);
        ListIterator r110 = r19.listIterator(r19.size());
    L21:
        if (r110.hasPrevious() == false) goto L25;
        Object r111 = r110.previous();
        int r20 = 2;
        if (StringsKt.contains$default(((ov5.a.a) r111).b, (CharSequence) ListProtector.get(StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, null), 0), false, 2, null) == false) goto L21;
    L26:
        ov5.a.a r21 = (ov5.a.a) r111;
        if (r21 == null) goto L44;
        if (r21.a == false) goto L44;
        if (r21.d != (-1)) goto L41;
        Object r24 = ListProtector.get(StringsKt.split$default(r21.c, new String[]{"/"}, false, 0, 6, null), 0);
        ListIterator r25 = r19.listIterator(r19.size());
    L35:
        if (r25.hasPrevious() == false) goto L39;
        Object r26 = r25.previous();
        if (StringsKt.contains$default(((ov5.a.a) r26).c, (CharSequence) r24, false, r20, null) == false) goto L35;
    L40:
        r21 = (ov5.a.a) r26;
        goto L41
    L39:
        r26 = null;
    L41:
        if (r21 == null) goto L44;
        r15 = Long.valueOf(r21.d).toString();
        if (r15 != null) goto L45;
    L25:
        r20 = 2;
        r111 = null;
    L44:
        r15 = "";
        goto L45
    }
}
