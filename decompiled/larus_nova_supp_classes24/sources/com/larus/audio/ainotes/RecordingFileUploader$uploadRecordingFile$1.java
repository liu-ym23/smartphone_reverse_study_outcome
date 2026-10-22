package com.larus.audio.ainotes;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.a;
import com.larus.network.http.f;
import com.larus.network.http.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.ainotes.RecordingFileUploader$uploadRecordingFile$1", f = "RecordingFileUploader.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
final class RecordingFileUploader$uploadRecordingFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $callback;
    final /* synthetic */ String $filePath;
    int label;

    public RecordingFileUploader$uploadRecordingFile$1(String r1, c r2, Continuation<? super RecordingFileUploader$uploadRecordingFile$1> r3) {
        this.$filePath = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecordingFileUploader$uploadRecordingFile$1(this.$filePath, null, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        y r14 = (a) r13;
        if ((r14 instanceof y) == false) goto L27;
        b r15 = (b) ((a) r14).b;
        if (r15 == null) goto L16;
        String r16 = r15.a();
    L17:
        if (r16 != null) goto L19;
    L22:
        if (r2 == false) goto L25;
        AsyncThrowable.Companion.getClass();
        AsyncThrowable.access$getDEFAULT$cp();
        throw null;
    L25:
        throw null;
    L19:
        if (r16.length() == 0) goto L22;
        r2 = false;
        goto L22
    L16:
        r16 = null;
        goto L17
    L27:
        if ((r14 instanceof f) == false) goto L29;
        AsyncThrowable r17 = ((f) r14).d;
        throw null;
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        String r7 = this.$filePath;
        Map r9 = MapsKt.mapOf(TuplesKt.to("X-Demo-APIAuthKey", "SaKi3nxJD1lRimVMea3poTnMEbzkSIYaivYu9GHPrTFxnCArBSWY7AEjXdXIcCts"));
        this.label = 1;
        r13 = HttpExtKt.f("Audio", b.class, "https://official-meeting.bytedance.net/api/v1/flow/meeting/demo/upload", "data", r7, null, r9, this, 32);
        if (r13 != r0) goto L11;
        return r0;
    }
}
