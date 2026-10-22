package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/model/n0;", "invoke", "()Lcom/bytedance/android/livesdk/model/n0;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$cropSeiData$2 extends FunctionReferenceImpl implements Function0<n0> {
    public RevSeiFrame$cropSeiData$2(RevSeiFrame r8) {
        super(0, r8, RevSeiFrame.class, "parseCropSeiData", "parseCropSeiData()Lcom/bytedance/android/livesdk/model/RevCropSeiData;", 0);
    }

    public final n0 invoke() {
        RevSeiFrame r0 = (RevSeiFrame) ((CallableReference) this).receiver;
        Lazy r1 = RevSeiFrame.D;
        r0.getClass();
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        n0 r4 = r0.s();     // Catch: Throwable -> L9
        if (r4 != null) goto L18;
        n0 r5 = r0.r();     // Catch: Throwable -> L9
        if (r5 != null) goto L20;
        return null;
    L20:
        return r5;
    L18:
        return r4;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L15;
        r2 = r7;
    L15:
        return (n0) r2;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m375invoke() {
        return invoke();
    }
}
