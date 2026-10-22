package com.larus.bmhome.chat.list.cell.progress_loading;

import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.k;
import com.larus.bmhome.creative.loading.MessageLoadingUIState;
import com.larus.bmhome.creative.loading.ProgressLoadingUIState;
import com.larus.im.bean.message.Message;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.progress_loading.BaseProgressLoadingCell$observeProgress$1", f = "BaseProgressLoadingCell.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class BaseProgressLoadingCell$observeProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseProgressLoadingCell<xc8.b> this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BaseProgressLoadingCell<xc8.b> a;

        public a(BaseProgressLoadingCell<xc8.b> r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            Map r7 = ((MessageLoadingUIState) r5).getMessageLoadingMap();
            xc8.b r8 = ((BaseMessageListCell) this.a).d;
            k r0 = null;
            if (r8 == null) goto L7;
            Message r9 = r8.getMessage();
            if (r9 == null) goto L7;
            String r10 = r9.getLocalMessageId();
        L8:
            ProgressLoadingUIState r11 = (ProgressLoadingUIState) r7.get(DataConverterKt.a(r10, null));
            if (r11 == null) goto L26;
            BaseProgressLoadingCell<xc8.b> r12 = this.a;
            FLogger r1 = FLogger.a;
            StringBuilder r2 = new StringBuilder(" progressLoadingAbility localMessageId ");
            xc8.b r3 = ((BaseMessageListCell) r12).d;
            if (r3 == null) goto L15;
            Message r4 = r3.getMessage();
            if (r4 == null) goto L15;
            String r13 = r4.getLocalMessageId();
        L16:
            r2.append(r13);
            r2.append(",progress is ");
            r2.append(r11.getProgress());
            r1.d("BaseProgressLoadingCell", r2.toString());
            k r14 = r12.e;
            if (r14 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("progressLoadingBox");
        L20:
            Integer r15 = r11.getProgress();
            if (r15 == null) goto L23;
            int r16 = r15.intValue();
        L24:
            r0.o(r16);
            goto L26
        L23:
            r16 = 0;
            goto L24
        L19:
            r0 = r14;
        L15:
            r13 = null;
        L26:
            return Unit.INSTANCE;
        L7:
            r10 = null;
            goto L8
        }
    }

    public BaseProgressLoadingCell$observeProgress$1(BaseProgressLoadingCell<xc8.b> r1, Continuation<? super BaseProgressLoadingCell$observeProgress$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BaseProgressLoadingCell$observeProgress$1(this.this$0, r3);
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
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FLogger.a.d("BaseProgressLoadingCell", " progressLoadingAbility " + ((zd8.b) this.this$0.j.getValue()));
        zd8.b r6 = (zd8.b) this.this$0.j.getValue();
        if (r6 == null) goto L18;
        i1 r7 = r6.H4();
        if (r7 == null) goto L18;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
