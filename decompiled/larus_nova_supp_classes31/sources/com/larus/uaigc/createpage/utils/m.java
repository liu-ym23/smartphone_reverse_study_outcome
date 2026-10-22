package com.larus.uaigc.createpage.utils;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements Function1<mr9.l, Unit> {
    public final /* synthetic */ String a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ kotlinx.coroutines.i<mr9.l> c;

    public m(String r1, AtomicBoolean r2, kotlinx.coroutines.j r3, ImageEditSendMessageStrategy r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r4) {
        mr9.l r5 = (mr9.l) r4;
        Intrinsics.checkNotNullParameter(r5, "it");
        FLogger.a.i("ImageEditSendMessageStrategy", "submitLocalImageResourceAccess success, curUploaderIdentifier:" + this.a);
        ImageEditSendMessageStrategy.e(this.b, this.a, this.c, r5);
        return Unit.INSTANCE;
    }
}
