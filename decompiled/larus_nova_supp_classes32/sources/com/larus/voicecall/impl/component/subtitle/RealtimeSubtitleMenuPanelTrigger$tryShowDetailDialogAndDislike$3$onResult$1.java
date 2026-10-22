package com.larus.voicecall.impl.component.subtitle;

import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.im.bean.message.Message;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.subtitle.RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3$onResult$1", f = "RealtimeSubtitleMenuPanelTrigger.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.voicecall.impl.component.feedback.b $data;
    int label;
    final /* synthetic */ k0 this$0;

    public RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3$onResult$1(k0 r1, com.larus.voicecall.impl.component.feedback.b r2, Continuation<? super RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3$onResult$1> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RealtimeSubtitleMenuPanelTrigger$tryShowDetailDialogAndDislike$3$onResult$1(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L20:
        if (this.$data.a == false) goto L33;
        t19.s r12 = t19.s.a;
        FragmentActivity r2 = this.this$0.a;
        r12.getClass();
        t19.s.o(r2, 2131901665, false);
        k0 r13 = this.this$0;
        String r3 = r13.h.e;
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
        if (r3 != null) goto L24;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L24:
        Message r14 = r13.e;
        if (r14 == null) goto L27;
        String r15 = r14.getMessageId();
    L28:
        if (r15 == null) goto L31;
        r4 = r15;
    L31:
        com.larus.voicecall.impl.component.feedback.v.c(r3, "long_press_answer", r4);
        goto L33
    L27:
        r15 = null;
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        k0 r16 = this.this$0;
        com.larus.voicecall.impl.component.feedback.e r5 = r16.c;
        Message r6 = r16.e;
        FeedbackMeta r17 = (FeedbackMeta) CollectionsKt.firstOrNull(this.$data.b);
        if (r17 == null) goto L11;
        int r7 = r17.a();
    L12:
        com.larus.voicecall.impl.component.feedback.b r18 = this.$data;
        String r8 = r18.c;
        List<FeedbackMeta> r19 = r18.b;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator<T> r110 = r19.iterator();
    L14:
        if (r110.hasNext() == false) goto L16;
        r9.add(Boxing.boxInt(((FeedbackMeta) r110.next()).a()));
        goto L14
    L16:
        this.label = 1;
        if (r5.rH(r6, r7, r8, r9, this) != r0) goto L20;
        return r0;
    L11:
        r7 = 0;
        goto L12
    }
}
