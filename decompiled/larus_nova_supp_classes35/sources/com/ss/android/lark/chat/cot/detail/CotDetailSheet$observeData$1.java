package com.ss.android.lark.chat.cot.detail;

import android.view.View;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.ss.android.lark.chat.entity.message.CotStatus;
import com.ss.android.lark.widget.textview.ShineTextView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.cot.detail.CotDetailSheet$observeData$1", f = "CotDetailSheet.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class CotDetailSheet$observeData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CotDetailSheet this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CotDetailSheet a;

        public a(CotDetailSheet r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            q r11 = (q) r9;
            CotDetailSheet r12 = this.a;
            String r0 = r12.p;
            if (r0 != null) goto L5;
            r0 = r12.a.getString(2131890941);
        L5:
            StringBuilder r1 = new StringBuilder("render detail sheet, messageId=");
            r1.append(r12.c);
            r1.append(", cotId=");
            r1.append(r11.a);
            r1.append(", status=");
            r1.append(r11.c);
            r1.append(", isRunning=");
            CotStatus r3 = r11.c;
            CotStatus r4 = CotStatus.RUNNING;
            boolean r5 = true;
            if (r3 != r4) goto L8;
            boolean r6 = true;
        L9:
            r1.append(r6);
            r1.append(", hasConfirmStop=");
            if (r12.g == null) goto L12;
            boolean r7 = true;
        L13:
            r1.append(r7);
            com.ss.android.lark.chat.cot.f.c("detail_stop_visibility", r1.toString());
            c r13 = r12.j;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r11, "state");
            Intrinsics.checkNotNullParameter(r0, "title");
            r13.p = r11;
            boolean r2 = !r13.q;
            if (r2 == true) goto L16;
        L20:
            View r8 = r13.i;
            if (r8 != null) goto L23;
        L35:
            ShineTextView r14 = r13.h;
            if (r14 == null) goto L50;
            boolean r15 = !Intrinsics.areEqual(r0, r13.s);
            if (r15 == false) goto L41;
            r14.setText(r0);
            r13.s = r0;
        L41:
            if (r11.c != r4) goto L43;
            boolean r16 = true;
        L44:
            if (r16 == true) goto L46;
            r14.x();
            goto L50
        L46:
            if (r15 == false) goto L48;
            r14.x();
            r14.y();
            goto L50
        L48:
            r14.y();
            goto L50
        L43:
            r16 = false;
        L50:
            if (r13.r == false) goto L58;
            if (r2 == true) goto L53;
        L59:
            StringBuilder r17 = new StringBuilder("render initial=");
            r17.append(r2);
            r17.append(", status=");
            r17.append(r11.c);
            r17.append(", items=");
            r17.append(r11.b.size());
            r17.append(", followBottom=");
            r17.append(r13.r);
            r17.append(", shouldAutoScroll=");
            r17.append(r5);
            r17.append(", lastItem=");
            k r18 = (k) CollectionsKt.lastOrNull(r11.b);
            if (r18 == null) goto L62;
            CotDetailBlockType r19 = r18.b;
        L63:
            r17.append(r19);
            com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r17.toString());
            if (r13.c == false) goto L66;
            int r20 = p.a;
            List<k> r21 = p.a(r11.b, r13.a);
        L67:
            CotDetailBlueprintAdapter r22 = r13.j;
            if (r22 == null) goto L71;
            f r23 = new f(r5, r13, r2, r11);
            Intrinsics.checkNotNullParameter(r21, "list");
            r22.c.submitList(r21, r23);
        L71:
            return Unit.INSTANCE;
        L66:
            r21 = r11.b;
            goto L67
        L62:
            r19 = null;
            goto L63
        L53:
            if (r11.c != r4) goto L55;
            boolean r24 = true;
        L56:
            if (r24 == false) goto L58;
        L55:
            r24 = false;
        L58:
            r5 = false;
            goto L59
        L23:
            if (r11.c != r4) goto L25;
            boolean r25 = true;
        L26:
            if (r25 == true) goto L28;
        L30:
            boolean r26 = false;
        L31:
            if (r26 == false) goto L33;
            int r27 = 0;
        L34:
            r8.setVisibility(r27);
            goto L35
        L33:
            r27 = 8;
            goto L34
        L28:
            if (r13.k == null) goto L30;
            r26 = true;
            goto L31
        L25:
            r25 = false;
            goto L26
        L16:
            if (r11.c != r4) goto L18;
            boolean r28 = true;
        L19:
            r13.r = r28;
            goto L20
        L18:
            r28 = false;
            goto L19
        L12:
            r7 = false;
            goto L13
        L8:
            r6 = false;
            goto L9
        }
    }

    public CotDetailSheet$observeData$1(CotDetailSheet r1, Continuation<? super CotDetailSheet$observeData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CotDetailSheet$observeData$1(this.this$0, r3);
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
        CotDetailSheet r6 = this.this$0;
        StateFlowImpl r2 = r6.h.c;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
