package com.bytedance.ai.ex.widget.inittasks;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lu0/a;", "", "themeResId", "", "setThemeResIdCompat", "(Lu0/a;I)V", "widget-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AISDKConfigCompatKt {
    public static final void setThemeResIdCompat(u0.a r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Class r11 = Integer.TYPE;
        if (r11 == null) goto L21;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L7
        Object r13 = Result.m124constructorimpl(r5.getClass().getMethod("setThemeResId", new Class[]{r11}).invoke(r5, new Object[]{Integer.valueOf(r10)}));     // Catch: Throwable -> L7
    L10:
        if (Result.m131isSuccessimpl(r13) == true) goto L22;
        Field r14 = r5.getClass().getDeclaredField("themeResId");     // Catch: Throwable -> L14
        r14.setAccessible(true);     // Catch: Throwable -> L14
        r14.setInt(r5, r10);     // Catch: Throwable -> L14
        Result.m124constructorimpl(r14);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    L22:
        return;
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
