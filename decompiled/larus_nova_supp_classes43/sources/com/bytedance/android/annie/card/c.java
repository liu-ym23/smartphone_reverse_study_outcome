package com.bytedance.android.annie.card;

import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements Runnable {
    public final /* synthetic */ AnnieCard a;
    public final /* synthetic */ Ref.ObjectRef<String> b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Ref.ObjectRef<String> d;
    public final /* synthetic */ Ref.ObjectRef<String> e;

    public c(AnnieCard r1, Ref.ObjectRef<String> r10, String r11, Ref.ObjectRef<String> r12, Ref.ObjectRef<String> r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final void a() {
        AnnieCard r0 = this.a;
        String r1 = (String) this.b.element;
        String r10 = this.c;
        String r11 = (String) this.d.element;
        String r12 = (String) this.e.element;
        x9.b r13 = (x9.b) r0.k(x9.b.class);
        Pair[] r14 = new Pair[5];
        r14[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SCHEME, r1);
        r14[1] = TuplesKt.to("container_type", r10);
        r14[2] = TuplesKt.to("original_url", r11);
        r14[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r12);
        CardParamVoNew r15 = r0.getMHybridParamVoNew();
        if (r15 == null) goto L8;
        PageType r16 = r15.I0();
        if (r16 == null) goto L8;
        String r17 = r16.getPageType();
        if (r17 == null) goto L8;
    L9:
        r14[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_TYPE, r17);
        r13.logV3("livesdk_live_container_load", MapsKt.mutableMapOf(r14));
        return;
    L8:
        r17 = "";
        goto L9
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
