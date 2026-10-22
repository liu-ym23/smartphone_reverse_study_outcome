package com.larus.audio.call.tracer;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.tracer.AudioFileSaver$startSavingFileForO$1", f = "AudioFileSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioFileSaver$startSavingFileForO$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $roomId;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ AudioFileSaver this$0;

    public AudioFileSaver$startSavingFileForO$1(String r1, int r2, AudioFileSaver r3, byte[] r4, Continuation<? super AudioFileSaver$startSavingFileForO$1> r5) {
        this.$roomId = r1;
        this.$type = r2;
        this.this$0 = r3;
        this.$data = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AudioFileSaver$startSavingFileForO$1(this.$roomId, this.$type, this.this$0, this.$data, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L54;
        ResultKt.throwOnFailure(r8);
        String r9 = this.$roomId;
        boolean r2 = false;
        if (r9 != null) goto L7;
    L10:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L14;
        String r11 = "o_" + this.$type + '_' + this.this$0.a;
    L15:
        FileOutputStream r4 = (FileOutputStream) ((LinkedHashMap) this.this$0.d).get(r11);
        if (r4 == null) goto L55;
    L39:
        File r0 = (File) ((LinkedHashMap) this.this$0.e).get(r11);     // Catch: Exception -> L49
        if (r0 != null) goto L44;
        return Unit.INSTANCE;
    L44:
        if (AudioFileSaver.a(this.this$0, r11, r0, this.$data.length) == false) goto L46;
        r4.write(this.$data);     // Catch: Exception -> L49
        AudioFileSaver.c(this.this$0, r11, r0, this.$data.length);     // Catch: Exception -> L49
    L52:
        return Unit.INSTANCE;
    L46:
        return Unit.INSTANCE;
    L55:
        String r5 = this.$roomId;     // Catch: Exception -> L49
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L25:
        if (r6 == false) goto L27;
        String r1 = this.this$0.a + "_click.pcm";     // Catch: Exception -> L49
        b68.b.a.getClass();     // Catch: Exception -> L49
        String r3 = b68.b.c("/record/asr/pcm_o/", r1);     // Catch: Exception -> L49
    L28:
        if (r3 != null) goto L30;
    L31:
        r2 = true;
    L32:
        if (r2 == false) goto L35;
        com.larus.audio.call.util.e.a.e(this.this$0.c, "[startSavingFileForO] invalid path");     // Catch: Exception -> L49
        return Unit.INSTANCE;
    L35:
        File r7 = new PolarisFileWrapper(r3);     // Catch: Exception -> L49
        File r12 = r7.getParentFile();     // Catch: Exception -> L49
        if (r12 == null) goto L38;
        Boxing.boxBoolean(r12.mkdirs());     // Catch: Exception -> L49
    L38:
        r4 = new PolarisFileOutputStreamWrapper(r7, true);     // Catch: Exception -> L49
        this.this$0.d.put(r11, r4);     // Catch: Exception -> L49
        this.this$0.e.put(r11, r7);     // Catch: Exception -> L49
        this.this$0.f.put(r11, Boxing.boxLong(r7.length()));     // Catch: Exception -> L49
        com.larus.audio.call.util.e.a.i(this.this$0.c, "dump in o assistant is " + r7);     // Catch: Exception -> L49
        goto L39
    L30:
        if (r3.length() != 0) goto L32;
    L27:
        String r13 = "room_" + this.$roomId + "_click.pcm";     // Catch: Exception -> L49
        b68.b.a.getClass();     // Catch: Exception -> L49
        r3 = b68.b.c("/record/asr/pcm_o/", r13);     // Catch: Exception -> L49
        goto L28
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
    L49:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(this.this$0.c, "[startSavingFileForO] error=" + e.getMessage());
        goto L52
    L14:
        r11 = "o_" + this.$type + '_' + this.$roomId;
        goto L15
    L7:
        if (r9.length() == 0) goto L10;
        r10 = false;
        goto L12
    L54:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
