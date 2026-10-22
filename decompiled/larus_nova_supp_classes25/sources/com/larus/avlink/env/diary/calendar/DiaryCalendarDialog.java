package com.larus.avlink.env.diary.calendar;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0016\u0010+\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0016\u0010/\u001a\u00020\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010-H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\"H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J \u00105\u001a\u00020\u00072\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u001bH\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u0012\u0010 \u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006="}, d2 = {"Lcom/larus/avlink/env/diary/calendar/DiaryCalendarDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onDayClick", "Lkotlin/Function1;", "", "", "monthText", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/larus/avlink/env/diary/calendar/MonthCalendarAdapter;", "viewModel", "Lcom/larus/avlink/env/diary/calendar/DoraEnvObserveDiaryCalendarViewModel;", "getViewModel", "()Lcom/larus/avlink/env/diary/calendar/DoraEnvObserveDiaryCalendarViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "dateFormat", "Ljava/text/SimpleDateFormat;", "TAG", "MINUM_MONTH_COUNT", "", "isFirstLoad", "", "lastHighlightMonthPos", "Ljava/lang/Integer;", "lastHighlightDayPos", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "highlightToday", "calendarData", "", "Lcom/larus/avlink/env/diary/calendar/MonthCalendarData;", "calculateMonthCount", "emotionItems", "Lcom/larus/avlink/env/diary/calendar/DiaryEmotionItem;", "initViews", "initBottomSheetDialog", "setupRecyclerView", "handleDayClick", "dayItem", "Lcom/larus/avlink/env/diary/calendar/CalendarItem$DayItem;", "monthPos", "dayPos", "updateMonthText", "updateMonthTextByScroll", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryCalendarDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int p = 0;
    public Function1<? super String, Unit> d;
    public TextView e;
    public RecyclerView f;
    public MonthCalendarAdapter g;
    public final Lazy h;
    public final Calendar i;
    public final SimpleDateFormat j;
    public final String k;
    public final int l;
    public boolean m;
    public Integer n;
    public Integer o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.avlink.env.diary.calendar.DiaryCalendarDialog$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.env.diary.calendar.DiaryCalendarDialog$onViewCreated$1", f = "DiaryCalendarDialog.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DiaryCalendarDialog this$0;

        /* JADX INFO: renamed from: com.larus.avlink.env.diary.calendar.DiaryCalendarDialog$onViewCreated$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DiaryCalendarDialog a;

            public a(DiaryCalendarDialog r1) {
                this.a = r1;
            }

            public final Object emit(Object r24, Continuation r25) {
                List r2 = (List) r24;
                FLogger.a.i(this.a.k, "collect emotionItems: size=" + r2.size());
                DiaryCalendarDialog r3 = this.a;
                int r4 = r3.l;
                int r7 = 2;
                int r8 = 1;
                if (r2.isEmpty() == true) goto L24;
                j r0 = (j) CollectionsKt.lastOrNull(r2);
                if (r0 == null) goto L8;
                String r1 = r0.b();
            L9:
                if (r1 != null) goto L11;
            L14:
                boolean r9 = true;
            L15:
                if (r9 == true) goto L24;
                Calendar r10 = Calendar.getInstance();     // Catch: Exception -> L22
                Date r5 = r3.j.parse(r1);     // Catch: Exception -> L22
                if (r5 == null) goto L24;
                r10.setTime(r5);     // Catch: Exception -> L22
                r4 = RangesKt.coerceAtLeast((((r3.i.get(1) - r10.get(1)) * 12) + (r3.i.get(2) - r10.get(2))) + 1, r4);     // Catch: Exception -> L22
            L22:
                e = move-exception;
                FLogger.a.e(r3.k, "calculateMonthCount error", e);
                goto L24
            L11:
                if (r1.length() == 0) goto L14;
                r9 = false;
                goto L15
            L8:
                r1 = null;
            L24:
                SimpleDateFormat r6 = b.a;
                Calendar r11 = this.a.i;
                Intrinsics.checkNotNullParameter(r11, "referenceDate");
                List r12 = r2;
                LinkedHashMap r13 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r12, 10)), 16));
                Iterator<T> r14 = r12.iterator();
            L26:
                if (r14.hasNext() == false) goto L31;
                j r15 = (j) r14.next();
                String r16 = r15.b();
                if (r16 != null) goto L30;
                r16 = "";
            L30:
                Pair r17 = TuplesKt.to(r16, r15);
                r13.put(r17.getFirst(), r17.getSecond());
                goto L26
            L31:
                String r18 = b.a.format(r11.getTime());
                ArrayList r19 = new ArrayList();
                int r20 = -(r4 - 1);
                if (r20 > 0) goto L62;
                int r110 = 0;
            L34:
                Intrinsics.checkNotNull(r18);
                Object r111 = r11.clone();
                Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.util.Calendar");
                Calendar r112 = (Calendar) r111;
                r112.add(r7, r110);
                int r113 = r112.get(r8);
                int r114 = r112.get(r7) + 1;
                ArrayList r115 = new ArrayList();
                r112.set(5, r8);
                int r21 = r112.get(7);
                if (r21 != r8) goto L37;
                int r22 = 6;
            L38:
                int r23 = 0;
            L39:
                if (r23 >= r22) goto L41;
                ArrayList r26 = r115;
                r26.add(new com.larus.avlink.env.diary.calendar.a.C0005a(r113, r114, 0, false, null, false, null));
                r23 = r23 + 1;
                r115 = r26;
                r113 = r113;
                goto L39
            L41:
                ArrayList r27 = r115;
                int r28 = r113;
                int r29 = 5;
                int r30 = r112.getActualMaximum(5);
                if (1 > r30) goto L59;
                int r116 = 1;
            L44:
                r112.set(r29, r116);
                String r117 = b.a.format(r112.getTime());
                j r118 = (j) r13.get(r117);
                boolean r119 = Intrinsics.areEqual(r117, r18);
                if (r118 == null) goto L47;
                boolean r120 = Intrinsics.areEqual(r118.e(), Boolean.TRUE);
            L48:
                if (r118 == null) goto L52;
                l98.b r31 = r118.d();
                if (r31 == null) goto L52;
                String r121 = r31.b();
            L53:
                if (r118 == null) goto L55;
                String r122 = r118.c();
            L56:
                int r210 = r116;
                r27.add(new com.larus.avlink.env.diary.calendar.a.C0005a(r28, r114, r116, r120, r121, r119, r122));
                if (r210 == r30) goto L59;
                r116 = r210 + 1;
                r29 = 5;
                goto L44
            L55:
                r122 = null;
            L52:
                r121 = null;
                goto L53
            L47:
                r120 = false;
            L59:
                r19.add(new n(r28, r114, r27));
                if (r110 == r20) goto L62;
                r110 = r110 - 1;
                r7 = 2;
                r8 = 1;
                goto L34
            L37:
                r22 = r21 - 2;
            L62:
                MonthCalendarAdapter r32 = this.a.g;
                if (r32 != null) goto L65;
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                r32 = null;
            L65:
                r32.getClass();
                Intrinsics.checkNotNullParameter(r19, "newMonths");
                ((ArrayList) r32.b).clear();
                ((ArrayList) r32.b).addAll(r19);
                r32.notifyDataSetChanged();
                DiaryCalendarDialog r33 = this.a;
                if (r33.m == false) goto L73;
                r33.m = false;
                ViewGroup r34 = r33.f;
                if (r34 != null) goto L70;
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                ViewGroup r35 = null;
            L71:
                final DiaryCalendarDialog r36 = this.a;
                r35.postDelayed(new h(r36), 50);
                this.a.T90(r19);
                goto L73
            L70:
                r35 = r34;
            L73:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(DiaryCalendarDialog r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
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
            DiaryCalendarDialog r6 = this.this$0;
            int r2 = DiaryCalendarDialog.p;
            d1<List<j>> r7 = r6.S90().getCalendarEmotions();
            a r3 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public final DoraEnvObserveDiaryCalendarViewModel S90() {
        return (DoraEnvObserveDiaryCalendarViewModel) this.h.getValue();
    }

    public DiaryCalendarDialog() {
        final Function0 r0 = new c(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObserveDiaryCalendarViewModel.class), new DiaryCalendarDialog$special$$inlined$viewModels$default$1(r0), new DiaryCalendarDialog$special$$inlined$viewModels$default$2(r0, this));
        this.i = Calendar.getInstance();
        this.j = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        this.k = "DiaryCalendarDialog";
        this.l = 2;
        this.m = true;
    }

    public final void T90(List<n> r5) {
        n r6 = (n) CollectionsKt.getOrNull(r5, 0);
        if (r6 == null) goto L21;
        List<com.larus.avlink.env.diary.calendar.a.C0005a> r7 = r6.c;
        if (r7 == null) goto L22;
        Iterator<com.larus.avlink.env.diary.calendar.a.C0005a> r8 = r7.iterator();
        int r1 = 0;
    L8:
        if (r8.hasNext() == false) goto L13;
        if (r8.next().f == true) goto L14;
        r1 = r1 + 1;
    L14:
        MonthCalendarAdapter r9 = this.g;
        if (r9 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r9 = null;
    L17:
        r9.y2(this.n, this.o, 0, r1);
        this.o = Integer.valueOf(r1);
        this.n = 0;
        return;
    L13:
        r1 = -1;
        goto L14
    L22:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [com.larus.avlink.env.diary.calendar.d] */
    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        FLogger r12 = FLogger.a;
        r12.i(this.k, "onViewCreated, viewModel hash: " + S90().hashCode());
        Context r0 = getContext();
        if (r0 == null) goto L17;
        BottomSheetDialog r3 = getDialog();
        if ((r3 instanceof BottomSheetDialog) == false) goto L8;
        BottomSheetDialog r4 = r3;
    L9:
        if (r4 == null) goto L11;
        View r5 = r4.findViewById(2131368870);
    L12:
        int r6 = (com.larus.utils.i.c(r0) - com.larus.utils.i.e(r0)) - c7.b(62);
        if (r5 == null) goto L15;
        ViewGroup.LayoutParams r1 = r5.getLayoutParams();
        r1.height = r6;
        r5.setLayoutParams(r1);
        r5.setBackgroundResource(R.color.transparent);
        BottomSheetBehavior r2 = BottomSheetBehavior.from(r5);
        r2.setState(3);
        r2.setSkipCollapsed(true);
        r2.setPeekHeight(0);
        r2.setHideable(true);
        r2.setBottomSheetCallback(new g(this));
    L15:
        if (r4 == null) goto L17;
        r4.setCanceledOnTouchOutside(true);
        goto L17
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
    L17:
        this.e = (TextView) r10.findViewById(2131369025);
        this.f = r10.findViewById(2131369027);
        ((ImageView) r10.findViewById(2131369016)).setOnClickListener(new e(this));
        ((TextView) r10.findViewById(2131369028)).setOnClickListener(new f(this));
        int r13 = this.i.get(1);
        int r7 = this.i.get(2) + 1;
        TextView r8 = this.e;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("monthText");
        r8 = null;
    L20:
        StringBuilder r9 = new StringBuilder();
        r9.append(r13);
        r9.append(24180);
        r9.append(r7);
        r9.append(26376);
        r8.setText(r9.toString());
        this.g = new MonthCalendarAdapter(new d(this));
        RecyclerView r14 = this.f;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r14 = null;
    L23:
        r14.setLayoutManager(new LinearLayoutManager(getContext(), 1, true));
        RecyclerView r15 = this.f;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r15 = null;
    L26:
        MonthCalendarAdapter r16 = this.g;
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r16 = null;
    L29:
        r15.setAdapter(r16);
        RecyclerView r17 = this.f;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r17 = null;
    L32:
        r17.addOnScrollListener(new DiaryCalendarDialog$setupRecyclerView$2(this));
        IDoraService r18 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r18 == null) goto L35;
        r18.A0("dora_page_show", MapsKt.mapOf(TuplesKt.to("current_page", "dora_g_diary_calendar")));
    L35:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AnonymousClass1(this, null), 3, null);
        if (S90().getCalendarEmotions().getReplayCache().isEmpty() == false) goto L38;
    L39:
        r12.i(this.k, "replayCache is empty, try load");
        S90().loadCalendarEmotions();
        return;
    L38:
        if (((List) CollectionsKt.last(S90().getCalendarEmotions().getReplayCache())).isEmpty() == true) goto L39;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131562055, r3, false);
    }
}
