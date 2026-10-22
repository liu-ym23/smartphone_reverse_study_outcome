package com.larus.suggest.impl.wcb.render;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements IIMCallback<Message> {
    public final /* synthetic */ kotlinx.coroutines.i<n> a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ ImSdkWcbRenderer c;
    public final /* synthetic */ p d;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.e("WcbLog", "[render] im.callback operation=deprecate success=false target=" + this.d.a + " cancelled=" + this.a.isCancelled());
        if (this.b.compareAndSet(false, true) == false) goto L6;
        kotlinx.coroutines.i<n> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(new n.a("deprecateLocalMessage failed: " + r5)));
        return;
    }

    public final void onSuccess(Object r4) {
        Message r5 = (Message) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("WcbLog", "[render] im.callback operation=deprecate success=true localId=" + r5.getLocalMessageId() + " cancelled=" + this.a.isCancelled());
        if (this.b.compareAndSet(false, true) == false) goto L6;
        kotlinx.coroutines.i<n> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        r0.resumeWith(Result.constructor-impl(ImSdkWcbRenderer.b(this.c, r5)));
        return;
    }

    public f(kotlinx.coroutines.j r1, AtomicBoolean r2, ImSdkWcbRenderer r3, p r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
