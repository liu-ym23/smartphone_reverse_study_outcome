package com.obric.assistant.omnidetailpage.componment;

import android.widget.ImageView;
import com.obric.assistant.card.databinding.ObricFragmentOmniDetailBinding;
import com.obric.assistant.omnidetailpage.TaskDetailAdapter;
import com.obric.assistant.omnidetailpage.util.OmniPageUtil;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent$updateContent$1", f = "OmniDetailContentComponent.kt", i = {}, l = {1131}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailContentComponent$updateContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OmniDetailContentComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ OmniDetailContentComponent a;

        public a(OmniDetailContentComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            final List<ifa.f> r5 = (List) r3;
            if (r5.size() <= 1) goto L9;
            OmniDetailContentComponent r6 = this.a;
            int r0 = OmniDetailContentComponent.I;
            ObricFragmentOmniDetailBinding r7 = (ObricFragmentOmniDetailBinding) r6.m.getValue();
            if (r7 == null) goto L9;
            ImageView r8 = r7.h;
            if (r8 == null) goto L9;
            pla.j.h(r8, false);
        L9:
            Map<String, List<ifa.f>> r9 = OmniPageUtil.b;
            OmniDetailContentComponent r1 = this.a;
            int r2 = OmniDetailContentComponent.I;
            r9.put(r1.W3(), r5);
            if (((ObricFragmentOmniDetailBinding) this.a.m.getValue()) == null) goto L15;
            final OmniDetailContentComponent r10 = this.a;
            TaskDetailAdapter r11 = r10.r;
            if (r11 == null) goto L15;
            r11.submitList(r5, new y(r10, r5));
        L15:
            return Unit.INSTANCE;
        }
    }

    public OmniDetailContentComponent$updateContent$1(OmniDetailContentComponent r1, Continuation<? super OmniDetailContentComponent$updateContent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OmniDetailContentComponent$updateContent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        OmniDetailContentComponent r6 = this.this$0;
        MutableSharedFlow<List<ifa.f>> r2 = r6.q;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
