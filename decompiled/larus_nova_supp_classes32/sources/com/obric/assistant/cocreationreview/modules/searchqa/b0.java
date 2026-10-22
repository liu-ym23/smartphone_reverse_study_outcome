package com.obric.assistant.cocreationreview.modules.searchqa;

import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.w4;
import com.obric.assistant.cocreationreview.y4;
import com.obric.assistant.cocreationreview.z4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 extends w4<c0> {
    public static final b0 b = null;

    static {
        b = new b0();
    }

    public b0() {
        super(h.a);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(a r2) {
        c0 r3 = (c0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.m;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(a r11) {
        c0 r12 = (c0) r11;
        Intrinsics.checkNotNullParameter(r12, "record");
        return CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c("引用资料： " + r12.j.size(), CardTemplateTagTone.METRIC, null, null, null, null, null, 252));
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(a r2) {
        c0 r3 = (c0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.d;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(a r2) {
        c0 r3 = (c0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.g;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(a r2) {
        c0 r3 = (c0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.e;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(a r2) {
        c0 r3 = (c0) r2;
        Intrinsics.checkNotNullParameter(r3, "record");
        return r3.f;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(a r11, a5 r12) {
        final c0 r13 = (c0) r11;
        Intrinsics.checkNotNullParameter(r13, "record");
        Intrinsics.checkNotNullParameter(r12, "feedback");
        String r2 = r13.a;
        String r3 = h.a.b + "详情";
        com.obric.assistant.cocreationreview.e r4 = new com.obric.assistant.cocreationreview.e(r13.g, r13.f, r13.d);
        List r1 = CollectionsKt.createListBuilder();
        b.getClass();
        String r6 = r13.f;
        if (r6 != null) goto L5;
    L7:
        r6 = null;
    L8:
        if (r6 != null) goto L10;
        String r7 = r13.e;
    L11:
        r1.add(new y4.c("搜索范围", r7));
        if ((!StringsKt.isBlank(r13.h)) == true) goto L14;
    L16:
        r1.add(new y4.c("豆包回复", r13.i));
        if ((!r13.j.isEmpty()) == false) goto L20;
        r1.add(new y4.a("引用资料", null, new x(r13)));
    L20:
        return new z4.a(r2, r3, r4, r12, CollectionsKt.build(r1), null, null, 224);
    L14:
        if (Intrinsics.areEqual(r13.h, r13.i) == true) goto L16;
        r1.add(new y4.c("答案摘要", r13.h));
        goto L16
    L10:
        r7 = r13.e + " / " + r6;
        goto L11
    L5:
        if ((!StringsKt.isBlank(r6)) == false) goto L7;
        goto L7
    }
}
