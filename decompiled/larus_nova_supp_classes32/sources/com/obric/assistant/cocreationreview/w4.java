package com.obric.assistant.cocreationreview;

import com.obric.assistant.cocreationreview.a;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class w4<R extends a> implements n5<R> {
    public final l5 a;

    public String l(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return null;
    }

    public w4(l5 r2) {
        Intrinsics.checkNotNullParameter(r2, "moduleMeta");
        this.a = r2;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public boolean a(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return false;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public String e(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return null;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public boolean g(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return false;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public List<d> i(R r11) {
        Intrinsics.checkNotNullParameter(r11, "record");
        d[] r0 = new d[2];
        r0[0] = new d(k(r11), CardTemplateTagTone.NEUTRAL, Integer.valueOf(this.a.e), Integer.valueOf(this.a.d), 16);
        String r12 = l(r11);
        d r1 = null;
        if (r12 != null) goto L5;
    L10:
        r0[1] = r1;
        return CollectionsKt.listOfNotNull(r0);
    L5:
        if ((!StringsKt.isBlank(r12)) == false) goto L7;
        String r5 = r12;
    L8:
        if (r5 == null) goto L10;
        r1 = new d(r5, CardTemplateTagTone.ACCENT, null, null, 28);
        goto L10
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public int j(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return 0;
    }

    public String k(R r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        return this.a.b;
    }
}
