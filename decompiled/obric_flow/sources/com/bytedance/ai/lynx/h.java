package com.bytedance.ai.lynx;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.lynx.tasm.TemplateBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f2185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SafeContinuation f2186c;

    public /* synthetic */ h(AtomicBoolean r5, SafeContinuation r10, int r11) {
        this.f2184a = r11;
        this.f2185b = r5;
        this.f2186c = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        SafeContinuation r5 = this.f2186c;
        AtomicBoolean r11 = this.f2185b;
        switch(this.f2184a) {
            case 0: goto L12;
            default: goto L4;
        };
    L4:
        Throwable r12 = (Throwable) r10;
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        if (r11.compareAndSet(false, true) == false) goto L11;
        String r13 = "getTemplateBundle failed. " + r12.getMessage();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L9;
        r14.e("AppletResourceLoader", r13);
    L9:
        r5.resumeWith(Result.m124constructorimpl(null));
    L11:
        return Unit.INSTANCE;
    L12:
        com.ivy.ivykit.api.plugin.b r15 = (com.ivy.ivykit.api.plugin.b) r10;
        Intrinsics.checkNotNullParameter(r15, "response");
        if (r11.compareAndSet(false, true) == false) goto L25;
        com.ivy.ivykit.api.plugin.a r16 = r15.e;
        if (r16 == null) goto L20;
        StringBuilder r17 = new StringBuilder("getTemplateBundle success. size: ");
        byte[] r18 = r16.f9478a;
        r17.append(r18.length);
        String r19 = r17.toString();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L19;
        r20.i("AppletResourceLoader", r19);
    L19:
        Result.Companion r21 = Result.Companion;
        r5.resumeWith(Result.m124constructorimpl(TemplateBundle.a(r18)));
        goto L25
    L20:
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L23;
        r22.e("AppletResourceLoader", "getTemplateBundle failed. templateJS is empty");
    L23:
        r5.resumeWith(Result.m124constructorimpl(null));
    L25:
        return Unit.INSTANCE;
    }
}
