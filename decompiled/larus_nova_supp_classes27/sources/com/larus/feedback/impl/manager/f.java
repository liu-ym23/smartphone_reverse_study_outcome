package com.larus.feedback.impl.manager;

import android.os.Handler;
import com.larus.utils.t0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f implements o99.c {
    public final /* synthetic */ q99.e a;
    public final /* synthetic */ DefaultIMFeedbackManager b;

    @Override // o99.c
    public final void e(q99.d r5) {
        if (r5 == null) goto L12;
        q99.e r0 = this.a;
        String r1 = r0.b;
        Map<String, String> r2 = r0.g;
        if (r2 == null) goto L6;
        String r3 = r2.get("section_id");
    L7:
        final q99.d r6 = r5.j(r1, r3, this.a.g);
        String r4 = this.a.b;
        if (r4 != null) goto L10;
        r4 = r6.e();
    L10:
        final q99.e r7 = q99.e.a(this.a, null, r4, r6, 93);
        Handler r8 = t0.a;
        final DefaultIMFeedbackManager r9 = this.b;
        r8.post(new e(r9, r7, r6));
        return;
    L6:
        r3 = null;
        goto L7
    }

    public f(q99.e r1, DefaultIMFeedbackManager r2) {
        this.a = r1;
        this.b = r2;
    }
}
