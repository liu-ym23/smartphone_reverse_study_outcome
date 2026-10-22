package com.larus.camera.impl.ui.component.capture;

import com.larus.camera.api.params.OutputParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CaptureControlComponent$onHandleCapture$1 extends FunctionReferenceImpl implements Function3<List<? extends OutputParam>, Boolean, Continuation<? super Boolean>, Object>, SuspendFunction {
    public CaptureControlComponent$onHandleCapture$1(Object r8) {
        super(3, r8, CaptureControlComponent.class, "interceptResultPageOpen", "interceptResultPageOpen(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((List) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invoke(List<OutputParam> r2, boolean r3, Continuation<? super Boolean> r4) {
        return CaptureControlComponent.r((CaptureControlComponent) ((CallableReference) this).receiver, r2, r3, r4);
    }
}
