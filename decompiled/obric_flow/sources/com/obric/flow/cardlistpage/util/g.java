package com.obric.flow.cardlistpage.util;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Vibrator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static Context a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Context r10 = r5.createConfigurationContext(new Configuration(r5.getResources().getConfiguration()));     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r10);     // Catch: Exception -> L5
        b.d(r10, "contextWrapperForWidgetDensityChange");     // Catch: Exception -> L5
        return r10;
    L5:
        e = move-exception;
        String r11 = "contextWrapperForWidgetDensityChange error:" + e;
        Intrinsics.checkNotNullParameter("ObricWidgetUtils", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        org.koin.core.a r12 = su.a.f22013b;
        if (r12 == null) goto L11;
        ((ju.b) r12.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("ObricWidgetUtils", r11);
        return r5;
    L11:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    public static final kotlinx.coroutines.flow.b b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new kotlinx.coroutines.flow.b(new ScreenStatusManagerKt$screenStatusFlow$1(r5, null), EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
    }

    public static void c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        Vibrator r11 = (Vibrator) r5.getSystemService(Vibrator.class);     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        return;
    L6:
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L8
        Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = Result.m127exceptionOrNullimpl(r12);
        if (r13 == null) goto L17;
        Intrinsics.checkNotNullParameter("NLAppUtils", "tag");
        Intrinsics.checkNotNullParameter("Vibration failed", "msg");
        Intrinsics.checkNotNullParameter(r13, "t");
        org.koin.core.a r14 = su.a.f22013b;
        if (r14 == null) goto L16;
        ((ju.b) r14.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("NLAppUtils", "Vibration failed", r13);
        return;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
