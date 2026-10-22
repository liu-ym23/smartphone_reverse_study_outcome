package com.bytedance.android.accessibilityLib_Core.util;

import android.content.Context;
import com.byted.cast.sink.api.IAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, d2 = {"", com.bytedance.android.ec.core.event.a.KEY_MSG, "Lkotlin/coroutines/Continuation;", "", "continuation", "", "showToastInDebugMode"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.android.accessibilityLib_Core.util.ToolUtilKt", f = "ToolUtil.kt", i = {}, l = {IAPI.OPTION_SERVER_LISTENER}, m = "showToastInDebugMode", n = {}, s = {})
final class ToolUtilKt$showToastInDebugMode$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ToolUtilKt$showToastInDebugMode$1(Continuation r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        int r11 = this.label | Integer.MIN_VALUE;
        this.label = r11;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r11 - Integer.MIN_VALUE;
        ToolUtilKt$showToastInDebugMode$1 r12 = this;
    L6:
        Object r0 = r12.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r12.label;
        if (r13 != 0) goto L9;
        ResultKt.throwOnFailure(r0);
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L17
        return Unit.INSTANCE;
    L9:
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L17
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L17
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L21;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L21:
        Unit r17 = Unit.INSTANCE;
        goto L23
    L5:
        r12 = new ToolUtilKt$showToastInDebugMode$1(this);
        goto L6
    }
}
