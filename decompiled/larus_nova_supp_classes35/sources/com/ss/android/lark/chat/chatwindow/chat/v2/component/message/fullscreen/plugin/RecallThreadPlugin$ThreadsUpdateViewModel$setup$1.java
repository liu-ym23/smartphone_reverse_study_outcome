package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.parser.internal.b0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin.RecallThreadPlugin$ThreadsUpdateViewModel$setup$1", f = "RecallThreadPlugin.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class RecallThreadPlugin$ThreadsUpdateViewModel$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $threadId;
    Object L$0;
    int label;
    final /* synthetic */ RecallThreadPlugin.ThreadsUpdateViewModel this$0;

    public RecallThreadPlugin$ThreadsUpdateViewModel$setup$1(RecallThreadPlugin.ThreadsUpdateViewModel r1, String r2, Continuation<? super RecallThreadPlugin$ThreadsUpdateViewModel$setup$1> r3) {
        this.this$0 = r1;
        this.$threadId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RecallThreadPlugin$ThreadsUpdateViewModel$setup$1(this.this$0, this.$threadId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0040 -> B:13:0x0045). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
        ResultKt.throwOnFailure(r9);
        com.larksuite.rucket.job.extension.a r3 = r2;
        Object r4 = r0;
        RecallThreadPlugin$ThreadsUpdateViewModel$setup$1 r5 = this;
    L14:
        if (((Boolean) r9).booleanValue() == false) goto L30;
        Collection r10 = ((Entity) r3.a().b()).threads.values();
        ArrayList r6 = new ArrayList();
        Iterator r11 = r10.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        ThreadTopic r7 = b0.a((Thread) r11.next());
        if (r7 == null) goto L17;
        r6.add(r7);
        goto L17
    L21:
        LinkedHashMap r8 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r6, 10)), 16));
        Iterator r12 = r6.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        Object r13 = r12.next();
        r8.put(((ThreadTopic) r13).getId(), r13);
        goto L23
    L25:
        ThreadTopic r14 = (ThreadTopic) r8.get(r5.$threadId);
        if (r14 == null) goto L28;
        r5.this$0.getThreadLiveData().postValue(r14);
    L28:
        RecallThreadPlugin$ThreadsUpdateViewModel$setup$1 r15 = r5;
        r0 = r4;
        com.larksuite.rucket.job.extension.a r16 = r3;
    L9:
        r15.L$0 = r16;
        r15.label = 1;
        Object r17 = r16.hasNext(r15);
        if (r17 != r0) goto L12;
        return r0;
    L12:
        Object r18 = r0;
        r5 = r15;
        r9 = r17;
        r3 = r16;
        r4 = r18;
        goto L14
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r16 = ((RecallThreadPlugin.a) b38.b.a.create(RecallThreadPlugin.a.class)).threadsPush().iterator();
        r15 = this;
        goto L9
    }
}
