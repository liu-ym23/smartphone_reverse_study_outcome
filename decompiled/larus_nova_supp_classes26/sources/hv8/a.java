package hv8;

import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final String e;
    public final String f;
    public final c g;
    public final String h;
    public final Function1<BrowserTakeoverOpenResult, Unit> i;

    public final void a(BrowserTakeoverOpenResult r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Function1<BrowserTakeoverOpenResult, Unit> r1 = this.i;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.invoke(r2);     // Catch: Throwable -> L9
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r3);     // Catch: Throwable -> L9
        return;
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r2, String r3, String r4, int r5, String r6, String r7, c r8, String r9, Function1<? super BrowserTakeoverOpenResult, Unit> r10) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r6, "toolCallId");
        Intrinsics.checkNotNullParameter(r8, "target");
        Intrinsics.checkNotNullParameter(r9, "takeoverId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
