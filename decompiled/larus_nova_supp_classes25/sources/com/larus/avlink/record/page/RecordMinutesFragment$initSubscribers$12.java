package com.larus.avlink.record.page;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.avlink.impl.databinding.LayoutFragmentRecordMinutesBinding;
import com.larus.avlink.record.ui.RecordMinutesBottomView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/record/page/BottomStatus;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesFragment$initSubscribers$12", f = "RecordMinutesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesFragment$initSubscribers$12 extends SuspendLambda implements Function2<BottomStatus, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesFragment this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BottomStatus.values().length];
            r0[BottomStatus.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BottomStatus.OFFLINE_RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BottomStatus.END_RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public RecordMinutesFragment$initSubscribers$12(RecordMinutesFragment r1, Continuation<? super RecordMinutesFragment$initSubscribers$12> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesFragment$initSubscribers$12 r0 = new RecordMinutesFragment$initSubscribers$12(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(BottomStatus r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((BottomStatus) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r11);
        BottomStatus r12 = (BottomStatus) this.L$0;
        if (r12 == null) goto L54;
        RecordMinutesFragment r0 = this.this$0;
        r0.h = r12;
        int r13 = a.a[r12.ordinal()];
        if (r13 != 1) goto L9;
        LayoutFragmentRecordMinutesBinding r14 = r0.e;
        if (r14 == null) goto L54;
        RecordMinutesBottomView r15 = r14.b;
        if (r15 == null) goto L54;
        r15.a.b.setVisibility(0);
        r15.a.c.setVisibility(8);
        r15.a.d.setVisibility(0);
        goto L54
    L9:
        if (r13 != 2) goto L11;
        LayoutFragmentRecordMinutesBinding r16 = r0.e;
        if (r16 == null) goto L54;
        RecordMinutesBottomView r17 = r16.b;
        if (r17 == null) goto L54;
        r17.a.b.setVisibility(0);
        r17.a.c.setVisibility(8);
        r17.a.d.setVisibility(8);
        goto L54
    L11:
        if (r13 != 3) goto L42;
        LayoutFragmentRecordMinutesBinding r18 = r0.e;
        if (r18 == null) goto L54;
        RecordMinutesBottomView r19 = r18.b;
        if (r19 == null) goto L54;
        r19.a.d.setVisibility(0);
        LinearLayout r1 = r19.a.d;
        int r4 = r1.getChildCount();
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L40;
        View r6 = r1.getChildAt(r5);
        TextView r8 = null;
        if (r5 == 0) goto L35;
        if (r5 == 2) goto L30;
        if (r5 != 4) goto L39;
        if ((r6 instanceof TextView) == false) goto L27;
        r8 = (TextView) r6;
    L27:
        if (r8 == null) goto L39;
        r8.setText("00");
    L39:
        r5 = r5 + 1;
        goto L17
    L30:
        if ((r6 instanceof TextView) == false) goto L32;
        r8 = (TextView) r6;
    L32:
        if (r8 == null) goto L39;
        r8.setText("00");
        goto L39
    L35:
        if ((r6 instanceof TextView) == false) goto L37;
        r8 = (TextView) r6;
    L37:
        if (r8 == null) goto L39;
        r8.setText("00");
        goto L39
    L40:
        r19.a.b.setVisibility(8);
        r19.a.c.setVisibility(0);
        r19.R5();
        goto L54
    L42:
        throw new NoWhenBranchMatchedException();
    L54:
        return Unit.INSTANCE;
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
