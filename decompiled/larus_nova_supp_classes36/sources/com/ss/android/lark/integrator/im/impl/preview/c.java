package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.biz.officesdk.im.preview.UrlPreviewCardType;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Object a;
    public final LinkedHashMap<String, f> b;
    public final HashMap<String, Long> c;
    public final LinkedHashMap<String, Unit> d;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Object r0 = this.a;
        monitor-enter(r0);
        Iterator r1 = CollectionsKt.toList(this.b.keySet()).iterator();     // Catch: Throwable -> L17
    L6:
        if (r1.hasNext() == false) goto L14;
        String r2 = (String) r1.next();     // Catch: Throwable -> L17
        f r3 = this.b.get(r2);     // Catch: Throwable -> L17
        if (r3 == null) goto L6;
        UrlCardPreviewEntity r9 = r3.a();     // Catch: Throwable -> L17
        if (r9 == null) goto L6;
        this.b.put(r2, new f.a(r3.d(), r3.b(), r3.c(), r9));     // Catch: Throwable -> L17
        goto L6
    L14:
        this.d.clear();     // Catch: Throwable -> L17
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public final void e() {
    L3:
        if (this.d.size() <= 20) goto L11;
        String r0 = this.d.entrySet().iterator().next().getKey();
        this.d.remove(r0);
        f r1 = this.b.get(r0);
        if (r1 == null) goto L3;
        UrlCardPreviewEntity r7 = r1.a();
        if (r7 == null) goto L3;
        this.b.put(r0, new f.a(r1.d(), r1.b(), r1.c(), r7));
        goto L3
    }

    public c() {
        this.a = new Object();
        this.b = new LinkedHashMap();
        this.c = new HashMap();
        this.d = new LinkedHashMap(20, 0.75f, true);
    }

    public final long a(String r3) {
        Long r4 = this.c.get(r3);
        if (r4 != null) goto L7;
        return 0;
    L7:
        return r4.longValue();
    }

    public final f c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "previewId");
        Object r0 = this.a;
        monitor-enter(r0);
        f r4 = this.b.get(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public final t6c.d b(String r4, UrlPreviewCardType r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "previewId");
        Intrinsics.checkNotNullParameter(r5, "cardType");
        Object r0 = this.a;
        monitor-enter(r0);
        f r1 = this.b.get(r4);     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        Map<g, t6c.d> r2 = r1.e();     // Catch: Throwable -> L15
        if (r2 == null) goto L12;
        t6c.d r7 = r2.get(new g(r5, r6));     // Catch: Throwable -> L15
        if (r7 == null) goto L12;
        this.d.put(r4, Unit.INSTANCE);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);
        return r7;
    L12:
        r7 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean f(String r19, long r20, UrlCardPreviewEntity r22) {
        Intrinsics.checkNotNullParameter(r19, "previewId");
        Intrinsics.checkNotNullParameter(r22, "entity");
        Object r15 = this.a;
        monitor-enter(r15);
        f r2 = this.b.get(r19);     // Catch: Throwable -> L28
        if (r2 != null) goto L11;
        monitor-exit(r15);
        return false;
    L11:
        if (r2.b() == r20) goto L14;
        monitor-exit(r15);
        return false;
    L14:
        UrlCardPreviewEntity r4 = r2.a();     // Catch: Throwable -> L28
        if (r4 != null) goto L17;
    L20:
        LinkedHashMap<String, f> r13 = this.b;     // Catch: Throwable -> L28
        PreviewHangPoint r3 = r2.c();     // Catch: Throwable -> L28
        Url r5 = r22.getInlineEntity().getUrl();     // Catch: Throwable -> L28
        if (r5 == null) goto L23;
        String r6 = r5.getUrl();     // Catch: Throwable -> L28
    L24:
        r13.put(r19, new f.a(r19, r20, PreviewHangPoint.copy$default(r3, r6, null, null, null, false, false, null, r22, 126, null), r22));     // Catch: Throwable -> L28
        this.d.remove(r19);     // Catch: Throwable -> L28
        monitor-exit(r15);
        return true;
    L23:
        r6 = null;
        goto L24
    L17:
        if (r4.getInlineEntity().getVersion() < r22.getInlineEntity().getVersion()) goto L20;
        monitor-exit(r15);
        return false;
    L28:
        th = move-exception;
        throw th;
    }

    public final boolean g(String r14, long r15, UrlCardPreviewEntity r17, UrlPreviewCardType r18, t6c.d r19, int r20) {
        Intrinsics.checkNotNullParameter(r14, "previewId");
        Intrinsics.checkNotNullParameter(r17, "entity");
        Intrinsics.checkNotNullParameter(r18, "cardType");
        Intrinsics.checkNotNullParameter(r19, "render");
        Object r9 = this.a;
        monitor-enter(r9);
        f r4 = this.b.get(r14);     // Catch: Throwable -> L26
        if (r4 != null) goto L10;
        monitor-exit(r9);
        return false;
    L10:
        if (r4.b() != r15) goto L24;
        UrlCardPreviewEntity r6 = r4.a();     // Catch: Throwable -> L26
        if (r6 == null) goto L18;
        UrlInlinePreviewEntity r7 = r6.getInlineEntity();     // Catch: Throwable -> L26
        if (r7 == null) goto L18;
        if (r7.getVersion() != r17.getInlineEntity().getVersion()) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L24;
        this.b.put(r14, new f.c(r14, r15, r4.c(), r17, MapsKt.plus(r4.e(), TuplesKt.to(new g(r18, r20), r19))));     // Catch: Throwable -> L26
        this.d.put(r14, Unit.INSTANCE);     // Catch: Throwable -> L26
        e();     // Catch: Throwable -> L26
        monitor-exit(r9);
        return true;
    L18:
        r8 = false;
    L24:
        monitor-exit(r9);
        return false;
    L26:
        th = move-exception;
        throw th;
    }
}
