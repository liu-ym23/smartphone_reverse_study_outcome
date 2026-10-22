package com.bytedance.ai.applet.app.foundation;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/bytedance/ai/applet/app/foundation/AppletAppRouterKt$createResultReceiver$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletAppRouterKt$createResultReceiver$1 extends ResultReceiver {
    public final /* synthetic */ Function1<Result<Unit>, Unit> a;

    public AppletAppRouterKt$createResultReceiver$1(Function1<? super Result<Unit>, Unit> r1, Handler r10) {
        this.a = r1;
        super(r10);
    }

    @Override // android.os.ResultReceiver
    public final void onReceiveResult(int r10, Bundle r11) {
        if (r10 != 0) goto L4;
        Function1<Result<Unit>, Unit> r12 = this.a;
        Result.Companion r13 = Result.Companion;
        r12.invoke(Result.box-impl(Result.constructor-impl(Unit.INSTANCE)));
        return;
    L4:
        if (r11 == null) goto L7;
        String r14 = r11.getString(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG);
        if (r14 == null) goto L7;
    L8:
        Function1<Result<Unit>, Unit> r15 = this.a;
        Result.Companion r0 = Result.Companion;
        r15.invoke(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new RuntimeException(r14)))));
        return;
    L7:
        r14 = "Unknown error";
        goto L8
    }
}
