package com.bytedance.ai.applet.base.log;

import com.bytedance.ai.event.MessageIndication;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {
    public final String a;
    public final e b;

    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        ThreadLocal<Map<String, String>> r0 = f.a;
        e r1 = this.b;
        if (r1.a.isEmpty() == false) goto L5;
        b r11 = a.a;
        a.a(this.a, r10);
        return;
    L5:
        Map<String, String> r12 = f.a.get();
        f.b(MapsKt.plus(f.a(), r1.a));
        b r13 = a.a;     // Catch: Throwable -> L9
        a.a(this.a, r10);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r12);
        return;
    L9:
        th = move-exception;
        f.b(r12);
        throw th;
    }

    public final void c(String r10) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        ThreadLocal<Map<String, String>> r0 = f.a;
        e r1 = this.b;
        if (r1.a.isEmpty() == false) goto L5;
        b r11 = a.a;
        a.c(this.a, r10);
        return;
    L5:
        Map<String, String> r12 = f.a.get();
        f.b(MapsKt.plus(f.a(), r1.a));
        b r13 = a.a;     // Catch: Throwable -> L9
        a.c(this.a, r10);     // Catch: Throwable -> L9
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r12);
        return;
    L9:
        th = move-exception;
        f.b(r12);
        throw th;
    }

    public i(String r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        Intrinsics.checkNotNullParameter(r11, "logContext");
        this.a = r10;
        this.b = r11;
    }

    public final void b(String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r10, MessageIndication.MESSAGE_TYPE_MSG);
        ThreadLocal<Map<String, String>> r0 = f.a;
        e r1 = this.b;
        if (r1.a.isEmpty() == false) goto L5;
        b r12 = a.a;
        a.b(this.a, r10, r11);
        return;
    L5:
        Map<String, String> r13 = f.a.get();
        f.b(MapsKt.plus(f.a(), r1.a));
        b r14 = a.a;     // Catch: Throwable -> L9
        a.b(this.a, r10, r11);     // Catch: Throwable -> L9
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
        f.b(r13);
        return;
    L9:
        th = move-exception;
        f.b(r13);
        throw th;
    }
}
