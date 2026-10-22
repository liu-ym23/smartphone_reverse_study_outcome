package com.larus.audio.utils;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p68.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ e a;
    public final /* synthetic */ String b;

    public /* synthetic */ i(e r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        e r0 = this.a;
        String r1 = this.b;
        Intrinsics.checkNotNullParameter((String) r4, "it");
        l1.a(false);
        if (f78.a.a.b() == false) goto L5;
        t19.s r5 = t19.s.a;
        Application r2 = AppHost.a.getApplication();
        r5.getClass();
        t19.s.s(r2, 2131901654);
    L6:
        r0.onError();
        FLogger.a.i("AudioLoadManager", "[playMixAudio] media request failed " + r1 + " !!");
        return Unit.INSTANCE;
    L5:
        t19.s r6 = t19.s.a;
        Application r3 = AppHost.a.getApplication();
        r6.getClass();
        t19.s.s(r3, 2131901103);
        goto L6
    }
}
