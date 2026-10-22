package com.bytedance.android.livesdk.interactivity.pin.business.qa;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f implements t22.d {
    public final /* synthetic */ PinAnswerProcessor a;
    public final /* synthetic */ j42.a b;

    @Override // t22.d
    public final void a(CharSequence r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        if (StringsKt.isBlank(r9) == false) goto L5;
        return;
    L5:
        long r2 = this.b.a.j();
        String r1 = this.b.a.h();
        if (r1 != null) goto L8;
        String r5 = BuildConfig.FLAVOR;
    L9:
        String r6 = String.valueOf(this.b.a.f());
        String r3 = this.b.a.i();
        if (r3 != null) goto L12;
        String r7 = BuildConfig.FLAVOR;
    L13:
        j42.b r0 = new j42.b(r2, r5, r6, r7);
        PinAnswerProcessor.u(this.a, r9.toString(), r0, Long.valueOf(this.b.a.b()));
        return;
    L12:
        r7 = r3;
        goto L13
    L8:
        r5 = r1;
        goto L9
    }

    public f(PinAnswerProcessor r1, j42.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
