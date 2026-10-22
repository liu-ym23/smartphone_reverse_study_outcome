package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class u implements Function0 {
    public final /* synthetic */ ChatReceiveServiceComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ u(ChatReceiveServiceComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatReceiveServiceComponent r0 = this.a;
        String r1 = this.b;
        int r2 = ChatReceiveServiceComponent.x;
        de8.c r3 = r0.f1();
        r3.getClass();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L29
        Bundle r6 = r3.b;     // Catch: Throwable -> L29
        if (r6 == null) goto L24;
        String r7 = r6.getString("auto_send_uris");     // Catch: Throwable -> L29
        if (r7 == null) goto L24;
        List r8 = StringsKt.split$default(r7, new String[]{","}, false, 0, 6, null);     // Catch: Throwable -> L29
        if (r8 == null) goto L24;
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L29
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L29
    L11:
        if (r10.hasNext() == false) goto L18;
        Object r11 = r10.next();     // Catch: Throwable -> L29
        if (((String) r11).length() <= 0) goto L15;
        boolean r12 = true;
    L16:
        if (r12 == false) goto L11;
        r9.add(r11);     // Catch: Throwable -> L29
        goto L11
    L15:
        r12 = false;
        goto L16
    L18:
        Iterator r13 = r9.iterator();     // Catch: Throwable -> L29
    L20:
        if (r13.hasNext() == false) goto L24;
        Uri r14 = UriProtector.parse((String) r13.next());     // Catch: Throwable -> L29
        if (r14 == null) goto L20;
        r5.add(r14);     // Catch: Throwable -> L29
    L24:
        Bundle r15 = r3.b;     // Catch: Throwable -> L29
        if (r15 == null) goto L27;
        r15.remove("auto_send_uris");     // Catch: Throwable -> L29
    L27:
        Object r16 = Result.constructor-impl(r5);     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r16) == false) goto L34;
        r16 = null;
    L34:
        r0.P2((ArrayList) r16, true, r1);
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
