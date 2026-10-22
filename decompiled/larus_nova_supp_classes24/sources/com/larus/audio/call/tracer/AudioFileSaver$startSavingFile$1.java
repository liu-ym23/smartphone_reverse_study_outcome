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
@DebugMetadata(c = "com.larus.audio.call.tracer.AudioFileSaver$startSavingFile$1", f = "AudioFileSaver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioFileSaver$startSavingFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $roomId;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ AudioFileSaver this$0;

    public AudioFileSaver$startSavingFile$1(String r1, int r2, AudioFileSaver r3, byte[] r4, Continuation<? super AudioFileSaver$startSavingFile$1> r5) {
        this.$roomId = r1;
        this.$type = r2;
        this.this$0 = r3;
        this.$data = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AudioFileSaver$startSavingFile$1(this.$roomId, this.$type, this.this$0, this.$data, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L55;
        ResultKt.throwOnFailure(r8);
        String r9 = this.$roomId;
        boolean r2 = false;
        if (r9 != null) goto L7;
    L10:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L14;
        String r11 = this.$type + '_' + this.this$0.a;
    L15:
        FileOutputStream r4 = (FileOutputStream) ((LinkedHashMap) this.this$0.d).get(r11);
        if (r4 == null) goto L56;
    L40:
        File r0 = (File) ((LinkedHashMap) this.this$0.e).get(r11);     // Catch: Exception -> L50
        if (r0 != null) goto L45;
        return Unit.INSTANCE;
    L45:
        if (AudioFileSaver.a(this.this$0, r11, r0, this.$data.length) == false) goto L47;
        r4.write(this.$data);     // Catch: Exception -> L50
        AudioFileSaver.c(this.this$0, r11, r0, this.$data.length);     // Catch: Exception -> L50
    L53:
        return Unit.INSTANCE;
    L47:
        return Unit.INSTANCE;
    L56:
        String r5 = this.$roomId;     // Catch: Exception -> L50
        if (r5 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == false) goto L24;
        AudioFileSaver r1 = this.this$0;     // Catch: Exception -> L50
        String r3 = AudioFileSaver.b(r1, this.$type, r1.a);     // Catch: Exception -> L50
    L25:
        if (r3 == null) goto L27;
        File r6 = new PolarisFileWrapper(r3);     // Catch: Exception -> L50
        File r7 = r6.getParentFile();     // Catch: Exception -> L50
        if (r7 == null) goto L32;
        Boxing.boxBoolean(r7.mkdirs());     // Catch: Exception -> L50
    L32:
        if (r6.exists() == false) goto L37;
        if (this.$type != 11) goto L37;
        r6.delete();     // Catch: Exception -> L50
    L37:
        if (r6.exists() == true) goto L39;
        r6.createNewFile();     // Catch: Exception -> L50
    L39:
        r4 = new PolarisFileOutputStreamWrapper(r6, true);     // Catch: Exception -> L50
        this.this$0.d.put(r11, r4);     // Catch: Exception -> L50
        this.this$0.e.put(r11, r6);     // Catch: Exception -> L50
        this.this$0.f.put(r11, Boxing.boxLong(r6.length()));     // Catch: Exception -> L50
        com.larus.audio.call.util.e.a.i(this.this$0.c, "dump in doubao is " + r6);     // Catch: Exception -> L50
        goto L40
    L27:
        return Unit.INSTANCE;
    L24:
        r3 = AudioFileSaver.b(this.this$0, this.$type, "room_" + this.$roomId);     // Catch: Exception -> L50
        goto L25
    L20:
        if (r5.length() != 0) goto L22;
    L50:
        e = move-exception;
        com.larus.audio.call.util.e.a.e(this.this$0.c, "[startSavingFile] error=" + e.getMessage());
        goto L53
    L14:
        r11 = this.$type + '_' + this.$roomId;
        goto L15
    L7:
        if (r9.length() == 0) goto L10;
        r10 = false;
        goto L12
    L55:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
