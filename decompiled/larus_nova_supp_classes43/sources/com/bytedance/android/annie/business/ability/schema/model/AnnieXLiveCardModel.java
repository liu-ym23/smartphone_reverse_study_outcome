package com.bytedance.android.annie.business.ability.schema.model;

import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t36.d;
import t36.f;
import y36.i;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AnnieXLiveCardModel implements f {
    public p a;
    public p b;
    public Uri c;
    public y36.a d;
    public final Lazy e;

    public final String b() {
        Uri r0 = this.c;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final String c() {
        p r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = (String) ((i) r0).b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public AnnieXLiveCardModel() {
        this.e = LazyKt.lazy(new AnnieXLiveCardModel$noQueryUrlWithID$2(this));
    }

    public void a(d r10) {
        Intrinsics.checkNotNullParameter(r10, "schemaData");
        this.a = new p(r10, "annie_x_url", null);
        this.b = new p(r10, "error_page_theme", null);
        this.c = r10.getOriginUrl();
        Boolean r1 = Boolean.FALSE;
        new y36.a(r10, "_close_after_open_success", r1);
        new p(r10, "is_out_url", "");
        this.d = new y36.a(r10, "screen_size_adaptation", r1);
    }
}
