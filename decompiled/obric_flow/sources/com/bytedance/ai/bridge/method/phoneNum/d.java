package com.bytedance.ai.bridge.method.phoneNum;

import android.util.LruCache;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.resource.e0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1905c;

    public /* synthetic */ d(int r5, Object r10, Object r11) {
        this.f1903a = r5;
        this.f1904b = r10;
        this.f1905c = r11;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r5) {
        Object r10 = this.f1905c;
        Object r11 = this.f1904b;
        switch(this.f1903a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        Throwable r12 = (Throwable) r5;
        Intrinsics.checkNotNullParameter(r12, ST.IMPLICIT_ARG_NAME);
        String r13 = (String) r11;
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("failed to load manifest. packageName: "), r13, "AIPackageManager", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L7;
        r15.e("AIPackageManager", r14, r12);
    L7:
        LruCache r16 = e0.f2711a;
        Intrinsics.checkNotNullParameter(r13, "packageName");
        e0.f2711a.remove(r13);
        e0.p().erase(r13);
        Result.Companion r17 = Result.Companion;
        l r18 = (l) r10;
        r18.resumeWith(Result.m124constructorimpl(ResultKt.createFailure(r12)));
        return Unit.INSTANCE;
    L9:
        Throwable r19 = (Throwable) r5;
        ((com.bytedance.ai.applet.login.c) r11).a();
        ((AtomicBoolean) r10).set(true);
        return Unit.INSTANCE;
    }
}
