package com.larus.bmhome.taskskill;

import android.widget.FrameLayout;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.taskskill.view.t;
import com.larus.bmhome.taskskill.view.v;
import com.larus.flowskill.impl.databinding.LayoutPcHintContainerBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$onViewCreated$2$1", f = "SkillComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$onViewCreated$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IChatMessageShareAbility $ability;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ SkillComponent a;

        public a(SkillComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            if (Intrinsics.areEqual(((rr8.a) r3).a, Boxing.boxBoolean(true)) == false) goto L19;
            v r5 = this.a.s;
            LayoutPcHintContainerBinding r1 = r5.b;
            if (r1 == null) goto L11;
            FrameLayout r2 = r1.a;
            if (r2 == null) goto L11;
            if (r2.getVisibility() != 0) goto L11;
            boolean r6 = true;
        L12:
            if (r6 == false) goto L28;
            r5.e = true;
            LayoutPcHintContainerBinding r7 = r5.b;
            if (r7 == null) goto L28;
            FrameLayout r8 = r7.a;
            if (r8 == null) goto L28;
            r8.setVisibility(8);
            r5.b(r8, 0);
        L28:
            return Unit.INSTANCE;
        L11:
            r6 = false;
            goto L12
        L19:
            final v r9 = this.a.s;
            if (r9.e == false) goto L28;
            r9.e = false;
            LayoutPcHintContainerBinding r10 = r9.b;
            if (r10 == null) goto L28;
            final FrameLayout r11 = r10.a;
            if (r11 == null) goto L28;
            r11.setVisibility(0);
            r11.post(new t(r9, r11));
            goto L28
        }
    }

    public SkillComponent$onViewCreated$2$1(IChatMessageShareAbility r1, SkillComponent r2, Continuation<? super SkillComponent$onViewCreated$2$1> r3) {
        this.$ability = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SkillComponent$onViewCreated$2$1(this.$ability, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        this.$ability.A60(new a(this.this$0));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
