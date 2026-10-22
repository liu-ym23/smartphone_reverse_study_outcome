package com.bytedance.ai.bridge.method.router;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.model.AppletRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f1957b;

    public /* synthetic */ h(int r5, Function1 r10) {
        this.f1956a = r5;
        this.f1957b = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        switch(this.f1956a) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        Throwable r10 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r10, ST.IMPLICIT_ARG_NAME);
        String r11 = "loadResourceAsync failed. " + r10.getMessage();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L7;
        r12.e("AppletResourceLoader", r11);
    L7:
        this.f1957b.invoke(new Exception(r10));
        return Unit.INSTANCE;
    L9:
        this.f1957b.invoke((AppletRuntime) r5);
        return Unit.INSTANCE;
    L12:
        return OpenPageMethod.c(this.f1957b, (AppletRuntime) r5);
    L14:
        return OpenPageMethod.d(this.f1957b, (AppletRuntime) r5);
    }
}
