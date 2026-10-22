package com.larus.audio.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.utils.FileUtilKt$readByteArrayAsFlow$1", f = "FileUtil.kt", i = {0, 0, 0}, l = {250}, m = "invokeSuspend", n = {"$this$flow", "stream", "buffer"}, s = {"L$0", "L$2", "L$3"})
final class FileUtilKt$readByteArrayAsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super byte[]>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $blockSize;
    final /* synthetic */ File $this_readByteArrayAsFlow;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public FileUtilKt$readByteArrayAsFlow$1(File r1, int r2, Continuation<? super FileUtilKt$readByteArrayAsFlow$1> r3) {
        this.$this_readByteArrayAsFlow = r1;
        this.$blockSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FileUtilKt$readByteArrayAsFlow$1 r0 = new FileUtilKt$readByteArrayAsFlow$1(this.$this_readByteArrayAsFlow, this.$blockSize, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super byte[]> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        byte[] r2 = (byte[]) this.L$3;
        BufferedInputStream r3 = (BufferedInputStream) this.L$2;
        Closeable r4 = (Closeable) this.L$1;
        FlowCollector r5 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L8
        BufferedInputStream r6 = r3;
    L15:
        int r7 = r6.read(r2);     // Catch: Throwable -> L8
        if (r7 == (-1)) goto L24;
        if (r7 != r2.length) goto L20;
        byte[] r8 = r2;
    L21:
        this.L$0 = r5;     // Catch: Throwable -> L8
        this.L$1 = r4;     // Catch: Throwable -> L8
        this.L$2 = r6;     // Catch: Throwable -> L8
        this.L$3 = r2;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        if (r5.emit(r8, this) != r0) goto L15;
        return r0;
    L20:
        r8 = Arrays.copyOf(r2, r7);     // Catch: Throwable -> L8
        goto L21
    L24:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r4, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r9);
        FlowCollector r11 = (FlowCollector) this.L$0;
        r4 = new BufferedInputStream(new PolarisFileInputStreamWrapper(this.$this_readByteArrayAsFlow), this.$blockSize);
        r2 = new byte[this.$blockSize];     // Catch: Throwable -> L8
        r5 = r11;
        r6 = r4;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    }
}
