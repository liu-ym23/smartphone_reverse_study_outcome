package com.larus.dispatcher.askhuman.handler;

import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class RequestActionBrowserOperationInterceptor$handleClick$request$1$1 extends FunctionReferenceImpl implements Function1<BrowserTakeoverOpenResult, Unit> {
    public RequestActionBrowserOperationInterceptor$handleClick$request$1$1(Object r8) {
        super(1, r8, BrowserTakeoverEntryMonitor.class, "onOpenResult", "onOpenResult(Lcom/larus/browsertakeover/api/BrowserTakeoverOpenResult;)V", 0);
    }

    public final void invoke(BrowserTakeoverOpenResult r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        BrowserTakeoverEntryMonitor r0 = (BrowserTakeoverEntryMonitor) ((CallableReference) this).receiver;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "result");
        r0.d = r3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((BrowserTakeoverOpenResult) r1);
        return Unit.INSTANCE;
    }
}
