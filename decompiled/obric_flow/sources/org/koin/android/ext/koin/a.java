package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.b;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final void a(b r5, final Context r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "androidContext");
        um.a r11 = r5.f21002a.f21001c;
        Level r12 = Level.INFO;
        boolean r13 = r11.r(r12);
        org.koin.core.a r14 = r5.f21002a;
        if (r13 == false) goto L6;
        um.a r15 = r14.f21001c;
        r15.getClass();
        Intrinsics.checkNotNullParameter("[init] declare Android Context", "msg");
        r15.s(r12, "[init] declare Android Context");
    L6:
        if ((r10 instanceof Application) == false) goto L8;
        r14.d(CollectionsKt.listOf(com.lynx.tasm.utils.b.p(new KoinExtKt$androidContext$1(r10))), true, false);
        return;
    L8:
        r14.d(CollectionsKt.listOf(com.lynx.tasm.utils.b.p(new KoinExtKt$androidContext$2(r10))), true, false);
    }
}
