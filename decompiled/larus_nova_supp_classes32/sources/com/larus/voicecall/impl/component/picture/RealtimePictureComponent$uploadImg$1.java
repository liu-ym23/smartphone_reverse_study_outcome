package com.larus.voicecall.impl.component.picture;

import com.obric.aivoice.core.data.NameKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.picture.RealtimePictureComponent$uploadImg$1", f = "RealtimePictureComponent.kt", i = {}, l = {700}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimePictureComponent$uploadImg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.upload.audio.b $bean;
    final /* synthetic */ String $key;
    final /* synthetic */ Map<String, Object> $mobExtra;
    final /* synthetic */ x3a.a $pic;
    final /* synthetic */ long $startTime;
    int label;
    final /* synthetic */ RealtimePictureComponent this$0;

    public RealtimePictureComponent$uploadImg$1(RealtimePictureComponent r1, com.larus.bmhome.upload.audio.b r2, x3a.a r3, long r4, String r6, Map<String, ? extends Object> r7, Continuation<? super RealtimePictureComponent$uploadImg$1> r8) {
        this.this$0 = r1;
        this.$bean = r2;
        this.$pic = r3;
        this.$startTime = r4;
        this.$key = r6;
        this.$mobExtra = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RealtimePictureComponent$uploadImg$1(this.this$0, this.$bean, this.$pic, this.$startTime, this.$key, this.$mobExtra, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.voicecall.impl.component.picture.y] */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.larus.voicecall.impl.component.picture.x] */
    public final Object invokeSuspend(Object r22) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        RealtimePictureComponent r1 = this.this$0;
        int r2 = RealtimePictureComponent.B;
        j3a.a r3 = r1.z3();
        if (r3 == null) goto L11;
        r3.F90();
    L11:
        com.larus.bmhome.upload.audio.g r4 = com.larus.bmhome.upload.audio.g.a;
        List r5 = CollectionsKt.listOf(this.$bean);
        String r6 = ((h88.a) this.this$0.m3()).d;
        String r8 = ((h88.a) this.this$0.m3()).f;
        final x3a.a r9 = this.$pic;
        final RealtimePictureComponent r10 = this.this$0;
        final long r14 = this.$startTime;
        final String r13 = this.$key;
        final Map<String, Object> r11 = this.$mobExtra;
        ?? r16 = new x(r9, r10, r14, r13, r11);
        ?? r15 = new y(r9, r14, r13, r11, r10);
        this.label = 1;
        if (com.larus.bmhome.upload.audio.g.b(r5, r6, r8, r16, r15, this) != r7) goto L15;
        return r7;
    }
}
