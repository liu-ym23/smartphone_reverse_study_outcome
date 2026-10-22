package com.larus.audio.call.play;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements u68.a.b {
    public String a;
    public final Set<u68.a.b> b;

    @Override // u68.a.b
    public final void a() {
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.a();
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void c() {
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.c();
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void onPaused() {
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.onPaused();
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void onPlayComplete() {
        String r0 = this.a;
        this.a = null;
        Iterator r1 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        u68.a.b r2 = (u68.a.b) r1.next();
        Intrinsics.checkNotNullParameter(r2, "$this$dispatch");
        if ((r2 instanceof e) == false) goto L8;
        ((e) r2).h(r0);
    L9:
        Unit r3 = Unit.INSTANCE;
        goto L4
    L8:
        r2.onPlayComplete();
        goto L9
    }

    @Override // u68.a.b
    public final void onResume() {
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.onResume();
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    public f() {
        this.b = new CopyOnWriteArraySet();
    }

    @Override // u68.a.b
    public final void b(Map<String, String> r4) {
        if (r4 == null) goto L8;
        String r0 = r4.get("query_round");
        if (r0 == null) goto L8;
        if ((!StringsKt.isBlank(r0)) == false) goto L8;
    L9:
        this.a = r0;
        Iterator r1 = CollectionsKt.toList(this.b).iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        u68.a.b r2 = (u68.a.b) r1.next();
        Intrinsics.checkNotNullParameter(r2, "$this$dispatch");
        r2.b(r4);
        Unit r3 = Unit.INSTANCE;
        goto L11
    L13:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // u68.a.b
    public final void d(h.a r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        String r0 = r4.c;
        if ((!StringsKt.isBlank(r0)) == true) goto L6;
        r0 = null;
    L6:
        this.a = r0;
        Iterator r1 = CollectionsKt.toList(this.b).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        u68.a.b r2 = (u68.a.b) r1.next();
        Intrinsics.checkNotNullParameter(r2, "$this$dispatch");
        r2.d(r4);
        Unit r3 = Unit.INSTANCE;
        goto L8
    }

    @Override // u68.a.b
    public final void e(boolean r4) {
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.e(r4);
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void f(TtsPlayEndType r4) {
        Intrinsics.checkNotNullParameter(r4, "endType");
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.f(r4);
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    @Override // u68.a.b
    public final void g(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "audio");
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.g(r4);
        Unit r2 = Unit.INSTANCE;
        goto L4
    }

    public final void h(u68.a.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        if (((CopyOnWriteArraySet) this.b).contains(r2) == false) goto L5;
        return;
    L5:
        ((CopyOnWriteArraySet) this.b).add(r2);
    }

    @Override // u68.a.b
    public final void i(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "audio");
        Iterator r0 = CollectionsKt.toList(this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u68.a.b r1 = (u68.a.b) r0.next();
        Intrinsics.checkNotNullParameter(r1, "$this$dispatch");
        r1.i(r4);
        Unit r2 = Unit.INSTANCE;
        goto L4
    }
}
