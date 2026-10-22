package com.larus.asr.view;

import android.widget.FrameLayout;
import com.larus.asr.api.databinding.LarusWidgetSpeakerHandsfreeBinding;
import com.larus.bmhome.utils.a4;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class g1 implements Function1 {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ LarusWidgetSpeakerHandsfreeBinding c;

    public /* synthetic */ g1(h1 r1, j r2, LarusWidgetSpeakerHandsfreeBinding r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        h1 r0 = this.a;
        Function0 r1 = this.b;
        LarusWidgetSpeakerHandsfreeBinding r2 = this.c;
        Intrinsics.checkNotNullParameter((FrameLayout) r6, "it");
        if (r0.a == false) goto L10;
        if (r0.b == false) goto L7;
    L8:
        a4.a.getClass();
        a4.a(a4.b);
        r1.invoke();
        r0.b = false;
        r0.c = false;
        r0.d(r2);
        r0.g();
        goto L10
    L7:
        if (r0.c == true) goto L8;
    L10:
        return Unit.INSTANCE;
    }
}
