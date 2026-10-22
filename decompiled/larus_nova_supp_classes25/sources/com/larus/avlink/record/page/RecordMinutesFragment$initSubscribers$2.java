package com.larus.avlink.record.page;

import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.avlink.impl.databinding.LayoutFragmentRecordMinutesBinding;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/avlink/record/page/PageStatus;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesFragment$initSubscribers$2", f = "RecordMinutesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesFragment$initSubscribers$2 extends SuspendLambda implements Function2<PageStatus, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesFragment this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PageStatus.values().length];
            r0[PageStatus.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PageStatus.ONBOARDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PageStatus.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PageStatus.ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public RecordMinutesFragment$initSubscribers$2(RecordMinutesFragment r1, Continuation<? super RecordMinutesFragment$initSubscribers$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesFragment$initSubscribers$2 r0 = new RecordMinutesFragment$initSubscribers$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(PageStatus r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((PageStatus) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L56;
        ResultKt.throwOnFailure(r7);
        PageStatus r8 = (PageStatus) this.L$0;
        if (r8 == null) goto L54;
        RecordMinutesFragment r0 = this.this$0;
        LayoutFragmentRecordMinutesBinding r1 = r0.e;
        if (r1 == null) goto L11;
        SwipeRefreshLayout r2 = r1.g;
        if (r2 == null) goto L11;
        r2.setRefreshing(false);
    L11:
        int r9 = a.a[r8.ordinal()];
        RecordMinutesActivity r4 = null;
        if (r9 != 1) goto L14;
        LayoutFragmentRecordMinutesBinding r10 = r0.e;
        if (r10 == null) goto L48;
        r10.c.setVisibility(0);
        r10.c.R5();
        r10.i.a.c.setVisibility(0);
        r10.e.setVisibility(8);
        r10.g.setVisibility(8);
        r10.b.setVisibility(8);
        r10.a.setBackgroundResource(2131100488);
    L48:
        FragmentActivity r11 = r0.getActivity();
        if ((r11 instanceof RecordMinutesActivity) == false) goto L51;
        r4 = (RecordMinutesActivity) r11;
    L51:
        if (r4 == null) goto L54;
        r4.Y0(2131100488);
        goto L54
    L14:
        if (r9 != 2) goto L16;
        LayoutFragmentRecordMinutesBinding r12 = r0.e;
        if (r12 == null) goto L40;
        r12.e.setVisibility(0);
        r12.i.a.c.setVisibility(8);
        r12.g.setVisibility(8);
        r12.b.setVisibility(0);
        r12.c.setVisibility(8);
        r12.a.setBackgroundResource(2131102535);
    L40:
        FragmentActivity r13 = r0.getActivity();
        if ((r13 instanceof RecordMinutesActivity) == false) goto L43;
        r4 = (RecordMinutesActivity) r13;
    L43:
        if (r4 == null) goto L54;
        r4.Y0(2131102535);
        goto L54
    L16:
        if (r9 != 3) goto L18;
        LayoutFragmentRecordMinutesBinding r14 = r0.e;
        if (r14 == null) goto L32;
        r14.e.setVisibility(8);
        r14.i.a.c.setVisibility(0);
        r14.g.setVisibility(0);
        r14.b.setVisibility(0);
        r14.c.setVisibility(8);
        r14.a.setBackgroundResource(2131100488);
    L32:
        FragmentActivity r15 = r0.getActivity();
        if ((r15 instanceof RecordMinutesActivity) == false) goto L35;
        r4 = (RecordMinutesActivity) r15;
    L35:
        if (r4 == null) goto L54;
        r4.Y0(2131100488);
        goto L54
    L18:
        if (r9 != 4) goto L28;
        LayoutFragmentRecordMinutesBinding r16 = r0.e;
        if (r16 == null) goto L22;
        r16.c.setVisibility(0);
        r16.c.S5();
        r16.i.a.c.setVisibility(0);
        r16.e.setVisibility(8);
        r16.g.setVisibility(8);
        r16.b.setVisibility(0);
        r16.a.setBackgroundResource(2131100488);
    L22:
        FragmentActivity r17 = r0.getActivity();
        if ((r17 instanceof RecordMinutesActivity) == false) goto L25;
        r4 = (RecordMinutesActivity) r17;
    L25:
        if (r4 == null) goto L54;
        r4.Y0(2131100488);
        goto L54
    L28:
        throw new NoWhenBranchMatchedException();
    L54:
        return Unit.INSTANCE;
    L56:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
