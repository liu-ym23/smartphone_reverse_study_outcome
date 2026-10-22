package com.ss.android.lark.chat.api.service.impl.smartreply;

import a2b.j;
import com.bytedance.lark.pb.basic.v1.AIReply;
import com.bytedance.lark.pb.im.v1.PushSmartAIReply;
import com.ss.android.lark.chat.entity.message.AISmartReply;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.smartreply.SmartApplyAnswerService$start$1$1", f = "SmartApplyAnswerService.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class SmartApplyAnswerService$start$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SmartApplyAnswerService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.smartreply.SmartApplyAnswerService$start$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.smartreply.SmartApplyAnswerService$start$1$1$1", f = "SmartApplyAnswerService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AISmartReply> $smartAIReply;
        int label;
        final /* synthetic */ SmartApplyAnswerService this$0;

        public AnonymousClass1(SmartApplyAnswerService r1, List<AISmartReply> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$smartAIReply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$smartAIReply, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            Iterator r3 = ((CopyOnWriteArrayList) this.this$0.b).iterator();
        L6:
            if (r3.hasNext() == false) goto L9;
            ((j.b) r3.next()).a();
            goto L6
        L9:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SmartApplyAnswerService$start$1$1(SmartApplyAnswerService r1, Continuation<? super SmartApplyAnswerService$start$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        SmartApplyAnswerService$start$1$1 r0 = new SmartApplyAnswerService$start$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004b -> B:13:0x0050). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r10 = r3;
        com.larksuite.rucket.job.extension.a r4 = r2;
        Object r5 = r0;
        SmartApplyAnswerService$start$1$1 r6 = this;
    L14:
        if (((Boolean) r12).booleanValue() == false) goto L23;
        List r13 = ((PushSmartAIReply) r4.a().b()).smart_ai_reply;
        ArrayList r7 = new ArrayList();
        Iterator r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L21;
        AIReply r8 = (AIReply) r14.next();
        AISmartReply.Companion.getClass();
        AISmartReply r9 = AISmartReply.a.a(r8);
        if (r9 == null) goto L17;
        r7.add(r9);
        goto L17
    L21:
        List r15 = CollectionsKt.toMutableList(r7);
        Log.i("SmartApplyAnswerCache", "push smart reply answer: " + r15);
        BuildersKt.launch$default(r10, Dispatchers.getMain(), null, new AnonymousClass1(r6.this$0, r15, null), 2, null);
        SmartApplyAnswerService$start$1$1 r16 = r6;
        r0 = r5;
        com.larksuite.rucket.job.extension.a r11 = r4;
        CoroutineScope r17 = r10;
    L9:
        r16.L$0 = r17;
        r16.L$1 = r11;
        r16.label = 1;
        Object r18 = r11.hasNext(r16);
        if (r18 != r0) goto L12;
        return r0;
    L12:
        r10 = r17;
        r4 = r11;
        r5 = r0;
        r6 = r16;
        r12 = r18;
        goto L14
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        r11 = ((SmartApplyAnswerService.b) this.this$0.c.getValue()).pushSmartAIReply().iterator();
        r17 = r19;
        r16 = this;
        goto L9
    }
}
