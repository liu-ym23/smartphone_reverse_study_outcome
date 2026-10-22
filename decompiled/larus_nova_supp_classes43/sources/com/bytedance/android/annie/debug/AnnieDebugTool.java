package com.bytedance.android.annie.debug;

import android.content.Context;
import com.bytedance.android.annie.card.AnnieCard;
import com.bytedance.android.annie.service.debug.DebugTatPosition;
import com.bytedance.android.live.browser.AnnieNGInitHelper;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AnnieDebugTool implements c9.d {
    public static final AnnieDebugTool a = null;
    public static boolean b;
    public static final ConcurrentHashMap<DebugTatPosition, List<c9.c>> c = null;
    public static final Lazy d = null;

    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ AnnieCard b;

        public a(Context r1, AnnieCard r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context r0 = this.a;     // Catch: Throwable -> L8
            AnnieCard r1 = this.b;     // Catch: Throwable -> L8
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L5
            new com.bytedance.android.annie.debug.ui.d(r0, r1).b();     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L17:
            return;
        L5:
            th = move-exception;
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L8
            Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public AnnieDebugTool() {
    }

    @Override // c9.d
    public final void registerMethod(String r10, f.b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
    }

    @Override // c9.d
    public final <P, R> void registerMethod(String r10, g<P, R> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "method");
    }

    static {
        a = new AnnieDebugTool();
        b = true;
        ConcurrentHashMap<DebugTatPosition, List<c9.c>> r0 = new ConcurrentHashMap();
        r0.put(DebugTatPosition.TOP_LEFT, new ArrayList());
        r0.put(DebugTatPosition.TOP_RIGHT, new ArrayList());
        c = r0;
        d = LazyKt.lazy(AnnieDebugTool$defaultImplNew$2.INSTANCE);
    }

    @Override // c9.d
    public final void E0(DebugTatPosition r10, AnnieNGInitHelper.a r11) {
        Intrinsics.checkNotNullParameter(r10, "position");
        Intrinsics.checkNotNullParameter(r11, "providerService");
        List<c9.c> r12 = c.get(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.contains(r11) == true) goto L21;
        Iterator<T> r0 = r12.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((c9.c) r1).getTagName(), "annie") == false) goto L8;
    L13:
        if (r1 != null) goto L22;
        r12.add(r11);
        return;
    L22:
        return;
    L12:
        r1 = null;
        goto L13
    }

    @Override // c9.d
    public final void c0(Context r10, AnnieCard r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "annieCard");
        if (b == false) goto L5;
        h.h.getClass();
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        r11.post(new a(r10, r11));
        Iterator<T> r12 = c.entrySet().iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        Iterator r1 = ((Iterable) ((Map.Entry) r12.next()).getValue()).iterator();
    L12:
        if (r1.hasNext() == false) goto L9;
        c9.c r13 = (c9.c) r1.next();
        r11.c(new x7.a(r13, new com.bytedance.android.annie.debug.service.a(), r11.getMHybridParamVoNew()));
        r11.o(new x7.b(r13, new com.bytedance.android.annie.debug.service.a(), r11.getMHybridParamVoNew()));
        goto L12
    L14:
        Lazy r14 = d;
        r11.c(new x7.a((AnnieDebugTool$defaultImplNew$2.a) r14.getValue(), new com.bytedance.android.annie.debug.service.a(), r11.getMHybridParamVoNew()));
        r11.o(new x7.b((AnnieDebugTool$defaultImplNew$2.a) r14.getValue(), new com.bytedance.android.annie.debug.service.a(), r11.getMHybridParamVoNew()));
        return;
    L18:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
