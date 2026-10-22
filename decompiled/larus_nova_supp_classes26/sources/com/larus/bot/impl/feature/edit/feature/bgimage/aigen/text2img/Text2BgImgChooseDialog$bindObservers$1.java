package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img;

import com.larus.bot.impl.databinding.LarusDialogBotEditBgImageChooseBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.text2img.Text2BgImgChooseDialog$bindObservers$1", f = "Text2BgImgChooseDialog.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
final class Text2BgImgChooseDialog$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ Text2BgImgChooseDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Text2BgImgChooseDialog a;

        public a(Text2BgImgChooseDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            c r8 = (c) r6;
            Text2BgImgChooseDialog r9 = this.a;
            LarusDialogBotEditBgImageChooseBinding r0 = r9.d;
            if (r0 == null) goto L21;
            FLogger.a.i("AIGenBgImageChooseDialog", "refreshUIState, pageSize: " + r8.c.size());
            if (r8.a == false) goto L7;
            e1.q(r0.e);
            e1.q(r0.d);
            e1.q(r0.b);
            r0.c.a.setVisibility(0);
        L19:
            Unit r10 = Unit.INSTANCE;
            goto L21
        L7:
            r0.e.setVisibility(0);
            r0.d.setVisibility(0);
            r0.b.setVisibility(0);
            r0.c.a.setVisibility(8);
            Text2BgImageAdapter r1 = r9.g;
            if (r1 == null) goto L11;
            List<Text2BgImageBindingViewHolder.a> r3 = r8.c;
            Intrinsics.checkNotNullParameter(r3, "data");
            r1.a = r3;
            r1.notifyDataSetChanged();
        L11:
            if ((!r8.c.isEmpty()) == false) goto L16;
            if (r9.i == true) goto L16;
            r0.d.setupWithViewPager(r0.e);
            r9.i = true;
        L16:
            if (r8.b == false) goto L18;
            r0.b.setAlpha(1.0f);
            r0.b.setEnabled(true);
            goto L19
        L18:
            r0.b.setAlpha(0.3f);
            r0.b.setEnabled(false);
        L21:
            return Unit.INSTANCE;
        }
    }

    public Text2BgImgChooseDialog$bindObservers$1(Text2BgImgChooseDialog r1, Continuation<? super Text2BgImgChooseDialog$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new Text2BgImgChooseDialog$bindObservers$1(this.this$0, r3);
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
        Text2BgImgChooseDialog r6 = this.this$0;
        int r2 = Text2BgImgChooseDialog.k;
        i1<c> r7 = r6.S90().getUiState();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
