package com.ss.android.lark.keyboard.biz.voice.inject;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class VoiceInnerEndPlugin$onExternalCancel$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VoiceInnerEndPlugin this$0;

    public VoiceInnerEndPlugin$onExternalCancel$1(VoiceInnerEndPlugin r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1026invoke() {
        a r0 = this.this$0.k;
        Unit r2 = null;
        this.this$0.k = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.a();     // Catch: Throwable -> L8
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L8
    L10:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L16;
        Log.e("VoiceInnerEndPlugin", "external session cancel failed", r4);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1026invoke();
        return Unit.INSTANCE;
    }
}
