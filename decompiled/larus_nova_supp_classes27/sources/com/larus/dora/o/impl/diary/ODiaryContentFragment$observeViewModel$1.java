package com.larus.dora.o.impl.diary;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.dora.o.impl.diary.calendar.ODiaryMonthCalendarDialog;
import com.larus.dora.o.impl.diary.week.OWeekCalendarBar;
import com.larus.dora.o.impl.diary.week.OWeekPagerAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryContentFragment$observeViewModel$1", f = "ODiaryContentFragment.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
final class ODiaryContentFragment$observeViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODiaryContentFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryContentFragment$observeViewModel$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "items", "", "Lcom/larus/dora/o/impl/diary/ODiaryBriefItem;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryContentFragment$observeViewModel$1$1", f = "ODiaryContentFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends i>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryContentFragment this$0;

        public AnonymousClass1(ODiaryContentFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((List) r1, (Continuation) r2);
        }

        public final Object invoke(List<i> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L119;
            ResultKt.throwOnFailure(r20);
            List r1 = (List) this.L$0;
            OWeekCalendarBar r2 = this.this$0.f;
            boolean r5 = false;
            int r6 = -1;
            if (r2 == null) goto L65;
            List<String> r7 = com.larus.dora.o.impl.diary.calendar.a.a;
            Intrinsics.checkNotNullParameter(r1, "briefItems");
            String r8 = com.larus.dora.o.impl.diary.calendar.a.b.format(new Date());
            ArrayList r9 = new ArrayList();
            Iterator r10 = r1.iterator();
        L8:
            if (r10.hasNext() == false) goto L15;
            i r11 = (i) r10.next();
            String r12 = r11.b();
            if (r12 == null) goto L12;
            Pair r13 = TuplesKt.to(r12, r11);
        L13:
            if (r13 == null) goto L8;
            r9.add(r13);
            goto L8
        L12:
            r13 = null;
            goto L13
        L15:
            Map r14 = MapsKt.toMap(r9);
            String r15 = (String) CollectionsKt.minOrNull(r14.keySet());
            if (r15 != null) goto L18;
            r15 = r8;
        L18:
            Calendar r16 = com.larus.dora.o.impl.diary.calendar.a.c(r15);
            if (r16 != null) goto L21;
            List<com.larus.dora.o.impl.diary.calendar.a.c> r17 = CollectionsKt.emptyList();
        L33:
            String r3 = (String) this.this$0.U90().getSelectedDate().getValue();
            Intrinsics.checkNotNullParameter(r17, "weeks");
            int r18 = r2.f.size();
            r2.f = r17;
            OWeekPagerAdapter r110 = r2.e;
            r110.getClass();
            Intrinsics.checkNotNullParameter(r17, "weeks");
            r110.b = r17;
            r110.c = r3;
            r110.notifyDataSetChanged();
            if (r18 != 0) goto L49;
            if ((!r17.isEmpty()) == false) goto L49;
            Integer r4 = Integer.valueOf(com.larus.dora.o.impl.diary.calendar.a.d(r17, r3));
            if (r4.intValue() < 0) goto L40;
            boolean r21 = true;
        L41:
            if (r21 == true) goto L44;
            r4 = null;
        L44:
            if (r4 == null) goto L46;
            int r22 = r4.intValue();
        L47:
            r2.d.scrollToPosition(r22);
            goto L65
        L46:
            r22 = r17.size() - 1;
            goto L47
        L40:
            r21 = false;
        L49:
            if (r17.size() <= r18) goto L65;
            if (r18 <= 0) goto L65;
            int r23 = r2.d.findFirstVisibleItemPosition();
            if (r23 == (-1)) goto L54;
            r2.d.scrollToPosition(r23 + (r17.size() - r18));
            goto L65
        L54:
            Integer r24 = Integer.valueOf(com.larus.dora.o.impl.diary.calendar.a.d(r17, r3));
            if (r24.intValue() < 0) goto L57;
            boolean r25 = true;
        L58:
            if (r25 == true) goto L61;
            r24 = null;
        L61:
            if (r24 == null) goto L63;
            int r26 = r24.intValue();
        L64:
            r2.d.scrollToPosition(r26);
            goto L65
        L63:
            r26 = r17.size() - 1;
            goto L64
        L57:
            r25 = false;
            goto L58
        L21:
            r16.set(7, 2);
            Calendar r111 = com.larus.dora.o.impl.diary.calendar.a.c(r8);
            if (r111 != null) goto L24;
            r17 = CollectionsKt.emptyList();
            goto L33
        L24:
            r111.set(7, 2);
            r111.add(5, 6);
            ArrayList r112 = new ArrayList();
        L26:
            if (r16.getTimeInMillis() > r111.getTimeInMillis()) goto L32;
            IntRange r113 = RangesKt.until(0, 7);
            ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
            IntIterator r27 = r113.iterator();
        L29:
            if (r27.hasNext() == false) goto L31;
            r27.nextInt();
            com.larus.dora.o.impl.diary.calendar.a.C0094a r115 = com.larus.dora.o.impl.diary.calendar.a.a(r16, r8, r14);
            r16.add(5, 1);
            r114.add(r115);
            goto L29
        L31:
            r112.add(new com.larus.dora.o.impl.diary.calendar.a.c(r114));
            goto L26
        L32:
            r17 = r112;
        L65:
            ODiaryMonthCalendarDialog r28 = this.this$0.g;
            if (r28 != null) goto L68;
        L116:
            ODiaryContentFragment.S90(this.this$0);
            this.this$0.da0();
            return Unit.INSTANCE;
        L68:
            if (r28.isAdded() == true) goto L71;
            r28 = null;
        L71:
            if (r28 == null) goto L116;
            List<com.larus.dora.o.impl.diary.calendar.a.b> r30 = com.larus.dora.o.impl.diary.calendar.a.b(r1);
            String r31 = (String) this.this$0.U90().getSelectedDate().getValue();
            Intrinsics.checkNotNullParameter(r30, "newMonths");
            LinearLayoutManager r32 = r28.i;
            if (r32 == null) goto L116;
            ODiaryMonthCalendarDialog.b r33 = r28.j;
            if (r33 == null) goto L116;
            if (Intrinsics.areEqual(r30, r28.d) == true) goto L81;
        L83:
            boolean r116 = r28.d.isEmpty();
            int r117 = r32.findFirstVisibleItemPosition();
            com.larus.dora.o.impl.diary.calendar.a.b r118 = (com.larus.dora.o.impl.diary.calendar.a.b) CollectionsKt.getOrNull(r28.d, r117);
            View r119 = r32.findViewByPosition(r117);
            if (r119 == null) goto L86;
            int r120 = r119.getTop();
        L87:
            r28.d = r30;
            r28.e = r31;
            Intrinsics.checkNotNullParameter(r30, "newMonths");
            r33.a = r30;
            r33.b = r31;
            r33.notifyDataSetChanged();
            if (r118 == null) goto L101;
            Iterator<com.larus.dora.o.impl.diary.calendar.a.b> r34 = r30.iterator();
            int r35 = 0;
        L91:
            if (r34.hasNext() == false) goto L101;
            com.larus.dora.o.impl.diary.calendar.a.b r36 = r34.next();
            if (r36.a == r118.a) goto L95;
        L97:
            boolean r37 = false;
        L98:
            if (r37 == true) goto L99;
            r35 = r35 + 1;
            goto L91
        L99:
            r6 = r35;
            goto L101
        L95:
            if (r36.b != r118.b) goto L97;
            r37 = true;
        L101:
            if (r6 < 0) goto L103;
            r32.scrollToPositionWithOffset(r6, r120);
            goto L116
        L103:
            if (r116 == false) goto L116;
            if ((!r30.isEmpty()) == false) goto L116;
            Integer r38 = Integer.valueOf(r28.V90());
            if (r38.intValue() < 0) goto L109;
            r5 = true;
        L109:
            if (r5 == false) goto L111;
            Integer r40 = r38;
        L112:
            if (r40 == null) goto L114;
            int r41 = r40.intValue();
        L115:
            r32.scrollToPosition(r41);
            goto L116
        L114:
            r41 = r30.size() - 1;
            goto L115
        L111:
            r40 = null;
            goto L112
        L86:
            r120 = 0;
            goto L87
        L81:
            if (Intrinsics.areEqual(r31, r28.e) == false) goto L83;
        L119:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ODiaryContentFragment$observeViewModel$1(ODiaryContentFragment r1, Continuation<? super ODiaryContentFragment$observeViewModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ODiaryContentFragment$observeViewModel$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ODiaryContentFragment r7 = this.this$0;
        SimpleDateFormat r2 = ODiaryContentFragment.q;
        i1<List<i>> r8 = r7.U90().getBriefItems();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r8, r3, this) != r0) goto L12;
        return r0;
    }
}
