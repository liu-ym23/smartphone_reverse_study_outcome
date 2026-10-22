package com.larus.audio.utils;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public /* synthetic */ k(String r1, e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r5) {
        String r0 = this.a;
        e r1 = this.b;
        Intrinsics.checkNotNullParameter((String) r5, "it");
        l1.a(false);
        if (f78.a.a.b() == false) goto L5;
        t19.s r6 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r6.getClass();
        t19.s.s(r2, 2131901654);
    L6:
        FLogger.a.i("AudioLoadManager", "[playAudio] media request failed styleId=" + r0 + " !!");
        if (r1 == null) goto L10;
        r1.onEnd();
    L10:
        return Unit.INSTANCE;
    L5:
        t19.s r7 = t19.s.a;
        Application r3 = AppHost.a.getApplication();
        r7.getClass();
        t19.s.s(r3, 2131901103);
        goto L6
    }
}
