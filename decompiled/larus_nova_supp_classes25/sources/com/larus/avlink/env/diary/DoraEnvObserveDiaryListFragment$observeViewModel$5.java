package com.larus.avlink.env.diary;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.avlink.api.DoraGResourceServiceDelegate;
import com.larus.avlink.impl.databinding.FragmentDoraEnvObserveDiaryListBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.DoraEnvObserveDiaryListFragment$observeViewModel$5", f = "DoraEnvObserveDiaryListFragment.kt", i = {}, l = {277}, m = "invokeSuspend", n = {}, s = {})
final class DoraEnvObserveDiaryListFragment$observeViewModel$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraEnvObserveDiaryListFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraEnvObserveDiaryListFragment a;

        public a(DoraEnvObserveDiaryListFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            String r8 = (String) r6;
            FLogger.a.i(this.a.i, "nextUpdateTime changed: " + r8);
            if (this.a.V90().isEnvObserveEnable() == true) goto L5;
            FragmentDoraEnvObserveDiaryListBinding r9 = this.a.g;
            if (r9 == null) goto L82;
            LinearLayout r10 = r9.d;
            if (r10 == null) goto L82;
            r10.setVisibility(8);
        L82:
            return Unit.INSTANCE;
        L5:
            if (this.a.V90().inEnvObserveScene() == true) goto L7;
            FragmentDoraEnvObserveDiaryListBinding r11 = this.a.g;
            if (r11 == null) goto L61;
            LinearLayout r12 = r11.d;
            if (r12 == null) goto L61;
            r12.setVisibility(0);
        L61:
            FragmentDoraEnvObserveDiaryListBinding r13 = this.a.g;
            if (r13 == null) goto L66;
            LottieAdapterView r14 = r13.e;
            if (r14 == null) goto L66;
            r14.setVisibility(8);
        L66:
            FragmentDoraEnvObserveDiaryListBinding r15 = this.a.g;
            if (r15 == null) goto L71;
            TextView r16 = r15.c;
            if (r16 == null) goto L71;
            r16.setVisibility(8);
        L71:
            FragmentDoraEnvObserveDiaryListBinding r17 = this.a.g;
            if (r17 == null) goto L82;
            TextView r18 = r17.f;
            if (r18 == null) goto L82;
            r18.setVisibility(0);
            goto L82
        L7:
            if (r8 == null) goto L11;
            Long r19 = StringsKt.toLongOrNull(r8);
            if (r19 == null) goto L11;
            long r20 = r19.longValue();
        L13:
            if (r20 <= 0) goto L51;
            FragmentDoraEnvObserveDiaryListBinding r2 = this.a.g;
            if (r2 == null) goto L19;
            LinearLayout r3 = r2.d;
            if (r3 == null) goto L19;
            r3.setVisibility(0);
        L19:
            FragmentDoraEnvObserveDiaryListBinding r4 = this.a.g;
            if (r4 == null) goto L24;
            TextView r5 = r4.f;
            if (r5 == null) goto L24;
            r5.setVisibility(8);
        L24:
            DoraGResourceServiceDelegate r0 = DoraGResourceServiceDelegate.b;
            FragmentDoraEnvObserveDiaryListBinding r21 = this.a.g;
            String r22 = null;
            if (r21 == null) goto L27;
            LottieAdapterView r23 = r21.e;
        L28:
            r0.e(r23);
            FragmentDoraEnvObserveDiaryListBinding r1 = this.a.g;
            if (r1 == null) goto L33;
            LottieAdapterView r24 = r1.e;
            if (r24 == null) goto L33;
            r24.playAnimation();
        L33:
            FragmentDoraEnvObserveDiaryListBinding r25 = this.a.g;
            if (r25 == null) goto L38;
            LottieAdapterView r26 = r25.e;
            if (r26 == null) goto L38;
            r26.setVisibility(0);
        L38:
            FragmentDoraEnvObserveDiaryListBinding r27 = this.a.g;
            if (r27 == null) goto L43;
            TextView r28 = r27.c;
            if (r28 == null) goto L43;
            r28.setVisibility(0);
        L43:
            FragmentDoraEnvObserveDiaryListBinding r29 = this.a.g;
            if (r29 == null) goto L82;
            TextView r30 = r29.c;
            if (r30 == null) goto L82;
            StringBuilder r31 = new StringBuilder();
            Context r32 = this.a.getContext();
            if (r32 == null) goto L50;
            r22 = r32.getString(2131902477);
        L50:
            r31.append(r22);
            r31.append(' ');
            r31.append(ia8.d.c(r20));
            r30.setText(r31.toString());
            goto L82
        L27:
            r23 = null;
            goto L28
        L51:
            FragmentDoraEnvObserveDiaryListBinding r33 = this.a.g;
            if (r33 == null) goto L82;
            LinearLayout r34 = r33.d;
            if (r34 == null) goto L82;
            r34.setVisibility(8);
        L11:
            r20 = 0;
            goto L13
        }
    }

    public DoraEnvObserveDiaryListFragment$observeViewModel$5(DoraEnvObserveDiaryListFragment r1, Continuation<? super DoraEnvObserveDiaryListFragment$observeViewModel$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraEnvObserveDiaryListFragment$observeViewModel$5(this.this$0, r3);
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
        DoraEnvObserveDiaryListFragment r6 = this.this$0;
        int r2 = DoraEnvObserveDiaryListFragment.k;
        d1<String> r7 = r6.V90().getNextUpdateTime();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
