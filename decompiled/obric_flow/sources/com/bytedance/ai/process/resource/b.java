package com.bytedance.ai.process.resource;

import android.graphics.BitmapFactory;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f2454b;

    public /* synthetic */ b(AtomicReference r5, int r10) {
        this.f2453a = r10;
        this.f2454b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        byte[] r10 = null;
        AtomicReference r11 = this.f2454b;
        switch(this.f2453a) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L33;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L11;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter((Throwable) r5, "tr");
        j r12 = (j) r11.getAndSet(null);
        if (r12 == null) goto L10;
        if (r12.isActive() == false) goto L10;
        r12.resumeWith(Result.m124constructorimpl(null));
    L10:
        return Unit.INSTANCE;
    L11:
        com.ivy.ivykit.api.plugin.b r13 = (com.ivy.ivykit.api.plugin.b) r5;
        Intrinsics.checkNotNullParameter(r13, ST.IMPLICIT_ARG_NAME);
        j r14 = (j) r11.getAndSet(null);
        if (r14 == null) goto L20;
        if (r14.isActive() == false) goto L20;
        com.ivy.ivykit.api.plugin.a r15 = r13.e;
        if (r15 == null) goto L18;
        r10 = r15.f9478a;
    L18:
        r14.resumeWith(Result.m124constructorimpl(r10));
    L20:
        return Unit.INSTANCE;
    L21:
        Throwable r16 = (Throwable) r5;
        r11.set(null);
        return Unit.INSTANCE;
    L23:
        Throwable r17 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r17, ST.IMPLICIT_ARG_NAME);
        String r18 = "loadImage error: " + r17.getMessage();
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L26;
        r19.e("AppletResourceLoader", r18);
    L26:
        j r20 = (j) r11.getAndSet(null);
        if (r20 == null) goto L32;
        if (r20.isActive() == false) goto L32;
        r20.resumeWith(Result.m124constructorimpl(null));
    L32:
        return Unit.INSTANCE;
    L33:
        com.ivy.ivykit.api.plugin.b r21 = (com.ivy.ivykit.api.plugin.b) r5;
        Intrinsics.checkNotNullParameter(r21, ST.IMPLICIT_ARG_NAME);
        j r22 = (j) r11.getAndSet(null);
        if (r22 == null) goto L45;
        if (r22.isActive() == false) goto L45;
        com.ivy.ivykit.api.plugin.a r23 = r21.e;
        if (r23 == null) goto L43;
        byte[] r24 = r23.f9478a;
        if (r24 == null) goto L43;
        Result.Companion r25 = Result.Companion;
        r22.resumeWith(Result.m124constructorimpl(BitmapFactory.decodeByteArray(r24, 0, r24.length)));
    L43:
        r22.resumeWith(Result.m124constructorimpl(null));
    L45:
        return Unit.INSTANCE;
    L46:
        Throwable r26 = (Throwable) r5;
        r11.set(null);
        return Unit.INSTANCE;
    L48:
        Throwable r27 = (Throwable) r5;
        r11.set(null);
        return Unit.INSTANCE;
    }
}
