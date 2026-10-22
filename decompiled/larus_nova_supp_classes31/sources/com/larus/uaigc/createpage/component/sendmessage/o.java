package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class o implements Function1<mr9.l, Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ kotlinx.coroutines.i<mr9.l> c;

    public o(String r1, AtomicBoolean r2, kotlinx.coroutines.j r3, CreationMessageStrategy r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        mr9.l r5 = (mr9.l) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        FLogger.a.i("CreationMessageStrategy", "submitLocalImageResourceAccess success, curUploaderIdentifier:" + this.a);
        CreationMessageStrategy.c(this.b, this.a, this.c, r5);
        return Unit.INSTANCE;
    }
}
