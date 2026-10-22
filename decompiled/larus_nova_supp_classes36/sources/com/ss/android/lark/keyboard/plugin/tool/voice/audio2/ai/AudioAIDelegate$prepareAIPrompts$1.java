package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import slb.j;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.audio2.ai.AudioAIDelegate$prepareAIPrompts$1", f = "AudioAIDelegate.kt", i = {0, 0}, l = {137}, m = "invokeSuspend", n = {"$this$launch", "promptList"}, s = {"L$0", "L$1"})
final class AudioAIDelegate$prepareAIPrompts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ b this$0;

    public AudioAIDelegate$prepareAIPrompts$1(b r1, Continuation<? super AudioAIDelegate$prepareAIPrompts$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AudioAIDelegate$prepareAIPrompts$1 r0 = new AudioAIDelegate$prepareAIPrompts$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L26;
        if (r0 != 1) goto L25;
        List<j> r1 = (List) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
        List r10 = (List) r9;
        if (r10 == null) goto L27;
        Iterator r11 = r10.iterator();
    L10:
        if (r11.hasNext() == false) goto L18;
        ArrayList<j> r4 = ((m) r11.next()).b;
        ArrayList r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((j) r7).f.get("is_visible"), Boxing.boxBoolean(true)) == false) goto L13;
        r5.add(r7);
        goto L13
    L17:
        r1.addAll(r5);
        goto L10
    L18:
        StringBuilder r12 = new StringBuilder("prepareAIPrompts / Get prompts: ");
        List<j> r2 = r1;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r13 = r2.iterator();
    L20:
        if (r13.hasNext() == false) goto L22;
        r8.add(((j) r13.next()).d);
        goto L20
    L22:
        r12.append(r8);
        Log.i("AudioAIDelegate", r12.toString());
        b r14 = this.this$0;
        int r15 = b.a;
        r14.a(r1);
        this.this$0.getClass();
        return Unit.INSTANCE;
    L27:
        b r16 = this.this$0;
        Log.w("AudioAIDelegate", "prepareAIPrompts / My AI is disable or not onboarding");
        int r17 = b.a;
        r16.a(null);
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L26:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        new ArrayList();
        this.this$0.getClass();
        goto L27
    }
}
