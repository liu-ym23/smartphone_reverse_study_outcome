package com.larus.avlink.o;

import com.larus.avlink.simulInterpret.page.model.TextType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import ea8.w;
import ea8.x;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.k;
import w88.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/larus/avlink/api/DoraSimulSubtitleEvent;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.o.DoraOCapability$observeSimulSubtitles$1", f = "DoraOCapability.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class DoraOCapability$observeSimulSubtitles$1 extends SuspendLambda implements Function2<k<? super w88.k>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isTop;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements Function1 {
        public final /* synthetic */ k<w88.k> a;

        public a(k<? super w88.k> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r6) {
            w r7 = (w) r6;
            Intrinsics.checkNotNullParameter(r7, "item");
            k<w88.k> r0 = this.a;
            int r2 = d.a;
            r0.trySend-JP2dKIU(new w88.k.a(new l(r7.a, r7.b, r7.c)));
            return null;
        }
    }

    public static final class b implements Function1 {
        public final /* synthetic */ k<w88.k> a;

        public b(k<? super w88.k> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r5) {
            x r6 = (x) r5;
            Intrinsics.checkNotNullParameter(r6, "sentence");
            k<w88.k> r0 = this.a;
            if (r6.getType() != TextType.TRANSLATION) goto L5;
            boolean r2 = true;
        L6:
            r0.trySend-JP2dKIU(new w88.k.b(r2, r6.b, r6.c));
            return null;
        L5:
            r2 = false;
            goto L6
        }
    }

    public DoraOCapability$observeSimulSubtitles$1(boolean r1, Continuation<? super DoraOCapability$observeSimulSubtitles$1> r2) {
        this.$isTop = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DoraOCapability$observeSimulSubtitles$1 r0 = new DoraOCapability$observeSimulSubtitles$1(this.$isTop, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super w88.k> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        k r8 = (k) this.L$0;
        final b r2 = new b(r8);
        final a r3 = new a(r8);
        final boolean r4 = this.$isTop;
        if (r4 == false) goto L11;
        ha8.d.e = r2;
        ha8.d.i = r3;
    L12:
        Function0 r5 = new c(r4, r2, r3);
        this.label = 1;
        if (ProduceKt.a(r8, r5, this) != r0) goto L16;
        return r0;
    L11:
        ha8.d.f = r2;
        ha8.d.j = r3;
        goto L12
    }
}
