package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n implements Function1<Throwable, Unit> {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ String b;

    public n(AtomicBoolean r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        this.a.set(true);
        FLogger.a.i("CreationMessageStrategy", "submitLocalImageResourceAccess cancelled, curUploaderIdentifier:" + this.b);
        ICreationResourceAccessService.a.a(ICreationResourceAccessService.a, this.b);
        return Unit.INSTANCE;
    }
}
