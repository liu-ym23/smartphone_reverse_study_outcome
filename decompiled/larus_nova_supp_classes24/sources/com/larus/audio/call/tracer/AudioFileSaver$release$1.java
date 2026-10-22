package com.larus.audio.call.tracer;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import m58.h;
import m58.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.tracer.AudioFileSaver$release$1", f = "AudioFileSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioFileSaver$release$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioFileSaver this$0;

    public AudioFileSaver$release$1(AudioFileSaver r1, Continuation<? super AudioFileSaver$release$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AudioFileSaver$release$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r5);
        Iterator r6 = ((LinkedHashMap) this.this$0.d).values().iterator();     // Catch: Throwable -> L15 Exception -> L17
    L7:
        if (r6.hasNext() == false) goto L11;
        FileOutputStream r0 = (FileOutputStream) r6.next();     // Catch: Throwable -> L15 Exception -> L17
        if (r0 == null) goto L7;
        r0.close();     // Catch: Throwable -> L15 Exception -> L17
        goto L7
    L11:
        ((LinkedHashMap) this.this$0.d).clear();     // Catch: Throwable -> L15 Exception -> L17
        ((LinkedHashMap) this.this$0.e).clear();     // Catch: Throwable -> L15 Exception -> L17
        ((LinkedHashMap) this.this$0.f).clear();     // Catch: Throwable -> L15 Exception -> L17
        this.this$0.g.clear();     // Catch: Throwable -> L15 Exception -> L17
        this.this$0.h = null;     // Catch: Throwable -> L15 Exception -> L17
        x58.a r7 = h.a;
        q r8 = h.d;
        if (r8 == null) goto L23;
    L14:
        r8.e();
    L23:
        return Unit.INSTANCE;
    L17:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(this.this$0.c, "[release] error=" + e.getMessage());     // Catch: Throwable -> L15
        x58.a r9 = h.a;
        r8 = h.d;
        if (r8 == null) goto L23;
    L15:
        th = move-exception;
        x58.a r1 = h.a;
        q r2 = h.d;
        if (r2 == null) goto L27;
        r2.e();
    L27:
        throw th;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
