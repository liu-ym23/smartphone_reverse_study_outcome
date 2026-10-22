package com.larus.bmhome.chat.immerse;

import android.view.MotionEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class x0 implements Function1 {
    public final /* synthetic */ MessageListMaskWrapper a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ Ref.BooleanRef c;

    public /* synthetic */ x0(MessageListMaskWrapper r1, Ref.FloatRef r2, Ref.BooleanRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r7) {
        MessageListMaskWrapper r0 = this.a;
        Ref.FloatRef r1 = this.b;
        Ref.BooleanRef r2 = this.c;
        MotionEvent r8 = (MotionEvent) r7;
        Intrinsics.checkNotNullParameter(r8, "event");
        if (r0.f == true) goto L25;
        int r3 = r8.getAction();
        boolean r4 = true;
        if (r3 != 0) goto L8;
        r1.element = r8.getY();
        r2.element = !r0.r;
        goto L25
    L8:
        if (r3 != 2) goto L25;
        float r9 = r8.getY();
        float r5 = r9 - r1.element;
        r1.element = r9;
        if (Math.abs(r5) <= 2.0f) goto L25;
        if (r2.element == false) goto L25;
        if (r0.q == false) goto L18;
        FLogger.a.d("MessageListMaskWrapper", "onInterceptTouchEvent, inImePoppingProgress = true");
    L22:
        r2.element = false;
        goto L25
    L18:
        if (r5 < 0.0f) goto L21;
        r4 = false;
    L21:
        r0.n(r4);
    L25:
        return Boolean.FALSE;
    }
}
