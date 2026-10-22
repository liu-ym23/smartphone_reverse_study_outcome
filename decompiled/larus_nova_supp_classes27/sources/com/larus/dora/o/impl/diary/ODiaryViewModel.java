package com.larus.dora.o.impl.diary;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u00142\u0006\u0010&\u001a\u00020\u0006J\u0015\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\fJ\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010-\u001a\u00020$J\u0006\u0010.\u001a\u00020$J\u0006\u0010/\u001a\u00020$J\u000e\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u0010J\u0010\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u0014J\u000e\u00104\u001a\u00020$2\u0006\u00103\u001a\u00020\u0014J\u000e\u00105\u001a\u00020$2\u0006\u00103\u001a\u00020\u0014J\u0018\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00142\u0006\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u0004\u0018\u00010\u0014J\u001a\u0010;\u001a\u00020$2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020$0=J\u0006\u0010>\u001a\u00020\fR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/dora/o/impl/diary/ODiaryViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_totalRecordDays", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "totalRecordDays", "Lkotlinx/coroutines/flow/StateFlow;", "getTotalRecordDays", "()Lkotlinx/coroutines/flow/StateFlow;", "isEnvObserveEnabled", "", "isObserveSceneRunning", "_briefItems", "", "Lcom/larus/dora/o/impl/diary/ODiaryBriefItem;", "briefItems", "getBriefItems", "_selectedDate", "", "selectedDate", "getSelectedDate", "_detailState", "Lcom/larus/dora/o/impl/diary/ODiaryViewModel$DetailState;", "detailState", "getDetailState", "nextCursor", "hasMore", "loadingBrief", "diaryBizId", "Ljava/lang/Integer;", "detailRenderedByH5", "firstScreenDate", "h5DiaryId", "applyH5Stats", "", "diaryId", "recordDays", "setDiaryBizId", "bizId", "(Ljava/lang/Integer;)V", "setDetailRenderedByH5", "byH5", "todayDate", "loadFirstPage", "refreshBriefKeepingSelection", "loadMore", "selectDate", "item", "setFirstScreenDate", "date", "selectDateFromH5", "selectEmptyDate", "detailJob", "Lkotlinx/coroutines/Job;", "fetchDetail", "requestDate", "selectedDiaryId", "deleteCurrentDiary", "onResult", "Lkotlin/Function1;", "isSelectedToday", "Companion", "DetailState", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryViewModel extends ViewModel {
    public static final a Companion = null;
    private static final SimpleDateFormat DATE_FORMAT = null;
    private static final String TAG = "ODiaryViewModel";
    private final z0<List<i>> _briefItems;
    private final z0<b> _detailState;
    private final z0<String> _selectedDate;
    private final z0<Integer> _totalRecordDays;
    private final i1<List<i>> briefItems;
    private Job detailJob;
    private boolean detailRenderedByH5;
    private final i1<b> detailState;
    private Integer diaryBizId;
    private String firstScreenDate;
    private String h5DiaryId;
    private boolean hasMore;
    private boolean loadingBrief;
    private String nextCursor;
    private final i1<String> selectedDate;
    private final i1<Integer> totalRecordDays;

    public static final class a {
        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {
            public final String a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "Content(diaryId=" + this.a + ", detailRawJson=" + this.b + ')';
            }

            public a(String r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "diaryId");
                Intrinsics.checkNotNullParameter(r3, "detailRawJson");
                this.a = r2;
                this.b = r3;
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$b$b, reason: collision with other inner class name */
        public static final class C0092b extends b {
            public static final C0092b a = null;

            static {
                a = new C0092b();
            }

            public C0092b() {
            }
        }

        public static final class c extends b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public static final class d extends b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public static final class e extends b {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }
        }

        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1", f = "ODiaryViewModel.kt", i = {0}, l = {275}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1$1", f = "ODiaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $onResult;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00931(Function1<? super Boolean, Unit> r1, Continuation<? super C00931> r2) {
                this.$onResult = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00931(this.$onResult, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$onResult.invoke(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1$3, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$deleteCurrentDiary$1$3", f = "ODiaryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Boolean, Unit> $onResult;
            final /* synthetic */ boolean $success;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass3(Function1<? super Boolean, Unit> r1, boolean r2, Continuation<? super AnonymousClass3> r3) {
                this.$onResult = r1;
                this.$success = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass3(this.$onResult, this.$success, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.$onResult.invoke(Boxing.boxBoolean(this.$success));
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String r1, ODiaryViewModel r2, Function1<? super Boolean, Unit> r3, Continuation<? super AnonymousClass1> r4) {
            this.$diaryId = r1;
            this.this$0 = r2;
            this.$onResult = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$diaryId, this.this$0, this.$onResult, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            boolean r11 = ((Boolean) r10).booleanValue();
            if (r11 == true) goto L15;
        L18:
            if (r11 == false) goto L30;
            z0 r3 = ODiaryViewModel.access$get_briefItems$p(this.this$0);
            Iterable r4 = (Iterable) ODiaryViewModel.access$get_briefItems$p(this.this$0).getValue();
            String r5 = this.$diaryId;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r7 = r4.iterator();
        L21:
            if (r7.hasNext() == false) goto L26;
            i r8 = (i) r7.next();
            if (Intrinsics.areEqual(r8.c(), r5) == false) goto L25;
            r8 = i.a(r8);
        L25:
            r6.add(r8);
            goto L21
        L26:
            r3.setValue(r6);
            if (ODiaryViewModel.access$getDetailRenderedByH5$p(this.this$0) == true) goto L29;
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(b.C0092b.a);
        L29:
            FLogger.a.i(ODiaryViewModel.TAG, "deleteCurrentDiary success: " + this.$diaryId);
        L30:
            BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new AnonymousClass3(this.$onResult, r11, null), 2, null);
            return Unit.INSTANCE;
        L15:
            if (ODiaryViewModel.access$getDetailRenderedByH5$p(this.this$0) == false) goto L18;
            ODiaryViewModel.access$setH5DiaryId$p(this.this$0, null);
            FLogger.a.i(ODiaryViewModel.TAG, "deleteCurrentDiary success (h5): " + this.$diaryId);
            BuildersKt.launch$default(r2, Dispatchers.getMain(), null, new C00931(this.$onResult, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r9 = DoraODiaryRepo.a;
            List<String> r13 = CollectionsKt.listOf(this.$diaryId);
            this.L$0 = r12;
            this.label = 1;
            Object r14 = r9.b(r13, this);
            if (r14 != r0) goto L11;
            return r0;
        L11:
            r2 = r12;
            r10 = r14;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$fetchDetail$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$fetchDetail$1", f = "ODiaryViewModel.kt", i = {0}, l = {248}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C04431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $diaryId;
        final /* synthetic */ String $requestDate;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ODiaryViewModel this$0;

        public C04431(String r1, ODiaryViewModel r2, String r3, Continuation<? super C04431> r4) {
            this.$diaryId = r1;
            this.this$0 = r2;
            this.$requestDate = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C04431 r0 = new C04431(this.$diaryId, this.this$0, this.$requestDate, r6);
            r0.L$0 = r5;
            return r0;
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
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r5);
        L12:
            String r6 = (String) r5;
            if (CoroutineScopeKt.isActive(r3) == false) goto L28;
            if (Intrinsics.areEqual(ODiaryViewModel.access$get_selectedDate$p(this.this$0).getValue(), this.$requestDate) == false) goto L28;
            if (r6 != null) goto L19;
        L22:
            if (r2 == false) goto L24;
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(b.c.a);
        L26:
            return Unit.INSTANCE;
        L24:
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(new b.a(this.$diaryId, r6));
            goto L26
        L19:
            if (r6.length() == 0) goto L22;
            r2 = false;
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            CoroutineScope r7 = (CoroutineScope) this.L$0;
            DoraODiaryRepo r4 = DoraODiaryRepo.a;
            String r8 = this.$diaryId;
            this.L$0 = r7;
            this.label = 1;
            Object r9 = r4.e(r8, this);
            if (r9 != r0) goto L11;
            return r0;
        L11:
            r3 = r7;
            r5 = r9;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$loadFirstPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$loadFirstPage$1", f = "ODiaryViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODiaryViewModel this$0;

        public C04441(ODiaryViewModel r1, Continuation<? super C04441> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04441(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Object r2 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            j r9 = (j) r8;
            ODiaryViewModel.access$setLoadingBrief$p(this.this$0, false);
            if (r9 != null) goto L15;
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(b.c.a);
            return Unit.INSTANCE;
        L15:
            ODiaryViewModel.access$setHasMore$p(this.this$0, r9.a());
            ODiaryViewModel.access$setNextCursor$p(this.this$0, r9.c());
            z0 r3 = ODiaryViewModel.access$get_totalRecordDays$p(this.this$0);
            Long r4 = r9.d();
            if (r4 == null) goto L18;
            long r5 = r4.longValue();
        L19:
            r3.setValue(Boxing.boxInt((int) r5));
            List<i> r10 = r9.b();
            if (r10 == null) goto L23;
            List r11 = CollectionsKt.filterNotNull(r10);
            if (r11 == null) goto L23;
        L24:
            ODiaryViewModel.access$get_briefItems$p(this.this$0).setValue(r11);
            String r6 = this.this$0.todayDate();
            Iterator r12 = r11.iterator();
        L26:
            if (r12.hasNext() == false) goto L35;
            Object r7 = r12.next();
            i r13 = (i) r7;
            if (Intrinsics.areEqual(r13.b(), r6) == true) goto L30;
        L32:
            boolean r14 = false;
        L33:
            if (r14 == false) goto L26;
            r2 = r7;
            goto L35
        L30:
            if (r13.e() == false) goto L32;
            r14 = true;
        L35:
            i r15 = (i) r2;
            if (r15 == null) goto L38;
            this.this$0.selectDate(r15);
        L40:
            return Unit.INSTANCE;
        L38:
            ODiaryViewModel.access$get_selectedDate$p(this.this$0).setValue(r6);
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(b.C0092b.a);
        L23:
            r11 = CollectionsKt.emptyList();
            goto L24
        L18:
            r5 = 0;
            goto L19
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            DoraODiaryRepo r16 = DoraODiaryRepo.a;
            Integer r17 = ODiaryViewModel.access$getDiaryBizId$p(this.this$0);
            this.label = 1;
            r8 = r16.d(null, r17, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$loadMore$1", f = "ODiaryViewModel.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODiaryViewModel this$0;

        public C04451(ODiaryViewModel r1, Continuation<? super C04451> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04451(this.this$0, r3);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            j r6 = (j) r5;
            ODiaryViewModel.access$setLoadingBrief$p(this.this$0, false);
            if (r6 == null) goto L14;
            ODiaryViewModel.access$setHasMore$p(this.this$0, r6.a());
            ODiaryViewModel.access$setNextCursor$p(this.this$0, r6.c());
            List<i> r7 = r6.b();
            if (r7 == null) goto L19;
            List r8 = CollectionsKt.filterNotNull(r7);
            if (r8 == null) goto L19;
        L21:
            if ((!r8.isEmpty()) == false) goto L24;
            ODiaryViewModel.access$get_briefItems$p(this.this$0).setValue(CollectionsKt.plus((Collection) ODiaryViewModel.access$get_briefItems$p(this.this$0).getValue(), r8));
        L24:
            return Unit.INSTANCE;
        L19:
            r8 = CollectionsKt.emptyList();
            goto L21
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            DoraODiaryRepo r9 = DoraODiaryRepo.a;
            String r2 = ODiaryViewModel.access$getNextCursor$p(this.this$0);
            Integer r3 = ODiaryViewModel.access$getDiaryBizId$p(this.this$0);
            this.label = 1;
            r5 = r9.d(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.diary.ODiaryViewModel$refreshBriefKeepingSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryViewModel$refreshBriefKeepingSelection$1", f = "ODiaryViewModel.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODiaryViewModel this$0;

        public C04461(ODiaryViewModel r1, Continuation<? super C04461> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04461(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Object r2 = null;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            j r10 = (j) r9;
            ODiaryViewModel.access$setLoadingBrief$p(this.this$0, false);
            if (r10 == null) goto L14;
            ODiaryViewModel.access$setHasMore$p(this.this$0, r10.a());
            ODiaryViewModel.access$setNextCursor$p(this.this$0, r10.c());
            z0 r4 = ODiaryViewModel.access$get_totalRecordDays$p(this.this$0);
            Long r5 = r10.d();
            if (r5 == null) goto L18;
            long r6 = r5.longValue();
        L19:
            r4.setValue(Boxing.boxInt((int) r6));
            List<i> r11 = r10.b();
            if (r11 == null) goto L23;
            List r12 = CollectionsKt.filterNotNull(r11);
            if (r12 == null) goto L23;
        L24:
            i r7 = (i) CollectionsKt.lastOrNull(r12);
            if (r7 == null) goto L27;
            String r8 = r7.b();
        L28:
            if (r8 == null) goto L41;
            Iterable r13 = (Iterable) ODiaryViewModel.access$get_briefItems$p(this.this$0).getValue();
            Collection r14 = new ArrayList();
            Iterator r15 = r13.iterator();
        L31:
            if (r15.hasNext() == false) goto L42;
            Object r16 = r15.next();
            String r17 = ((i) r16).b();
            if (r17 != null) goto L36;
            r17 = "";
        L36:
            if (r17.compareTo(r8) >= 0) goto L38;
            boolean r18 = true;
        L39:
            if (r18 == false) goto L31;
            r14.add(r16);
            goto L31
        L38:
            r18 = false;
        L42:
            ODiaryViewModel.access$get_briefItems$p(this.this$0).setValue(CollectionsKt.plus(r12, r14));
            if (ODiaryViewModel.access$getDetailRenderedByH5$p(this.this$0) == true) goto L45;
            String r20 = (String) ODiaryViewModel.access$get_selectedDate$p(this.this$0).getValue();
            if (r20 == null) goto L49;
            Iterator r21 = ((Iterable) ODiaryViewModel.access$get_briefItems$p(this.this$0).getValue()).iterator();
        L52:
            if (r21.hasNext() == false) goto L56;
            Object r22 = r21.next();
            if (Intrinsics.areEqual(((i) r22).b(), r20) == false) goto L52;
            r2 = r22;
        L56:
            i r23 = (i) r2;
            boolean r24 = ODiaryViewModel.access$get_detailState$p(this.this$0).getValue() instanceof b.a;
            if (r23 != null) goto L59;
        L61:
            boolean r25 = false;
        L62:
            if (r25 == false) goto L65;
            if (r24 == true) goto L65;
            this.this$0.selectDate(r23);
        L74:
            return Unit.INSTANCE;
        L65:
            if (r23 != null) goto L67;
        L69:
            r3 = false;
        L70:
            if (r3 == true) goto L74;
            if (r24 == false) goto L74;
            ODiaryViewModel.access$get_detailState$p(this.this$0).setValue(b.C0092b.a);
            goto L74
        L67:
            if (r23.e() != true) goto L69;
        L59:
            if (r23.e() != true) goto L61;
            r25 = true;
            goto L62
        L49:
            return Unit.INSTANCE;
        L45:
            return Unit.INSTANCE;
        L41:
            r14 = (List) ODiaryViewModel.access$get_briefItems$p(this.this$0).getValue();
            goto L42
        L27:
            r8 = null;
        L23:
            r12 = CollectionsKt.emptyList();
            goto L24
        L18:
            r6 = 0;
            goto L19
        L14:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            DoraODiaryRepo r26 = DoraODiaryRepo.a;
            Integer r27 = ODiaryViewModel.access$getDiaryBizId$p(this.this$0);
            this.label = 1;
            r9 = r26.d(null, r27, this);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public final boolean isEnvObserveEnabled() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        com.larus.dora.impl.serviceimpl.r r1 = r0.g1();
        if (r1 == null) goto L9;
        if (r1.b() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isObserveSceneRunning() {
        IDoraAVLinkService r0 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.x1() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSelectedToday() {
        return Intrinsics.areEqual(this._selectedDate.getValue(), todayDate());
    }

    public final void loadFirstPage() {
        if (this.detailRenderedByH5 == false) goto L10;
        z0<String> r0 = this._selectedDate;
        String r1 = this.firstScreenDate;
        if (r1 != null) goto L7;
        r1 = todayDate();
    L7:
        r0.setValue(r1);
        return;
    L10:
        if (this.loadingBrief == false) goto L12;
        return;
    L12:
        this.loadingBrief = true;
        this.nextCursor = null;
        this.hasMore = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04441(this, null), 2, null);
    }

    public final void loadMore() {
        if (this.detailRenderedByH5 == false) goto L6;
        return;
    L6:
        if (this.loadingBrief == false) goto L8;
        return;
    L8:
        if (this.hasMore == false) goto L13;
        this.loadingBrief = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04451(this, null), 2, null);
        return;
    }

    public final void refreshBriefKeepingSelection() {
        if (this.detailRenderedByH5 == false) goto L6;
        return;
    L6:
        if (this.loadingBrief == false) goto L8;
        return;
    L8:
        this.loadingBrief = true;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04461(this, null), 2, null);
    }

    public final String selectedDiaryId() {
        if (this.detailRenderedByH5 == true) goto L11;
        Object r0 = this._detailState.getValue();
        if ((r0 instanceof b.a) == false) goto L7;
        b.a r1 = (b.a) r0;
    L8:
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.a;
    L7:
        r1 = null;
        goto L8
    L11:
        String r2 = this.h5DiaryId;
        if (r2 != null) goto L14;
        return null;
    L14:
        if (r2.length() <= 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L19;
        return null;
    L19:
        return r2;
    L16:
        r3 = false;
        goto L17
    }

    public final String todayDate() {
        return DATE_FORMAT.format(new Date());
    }

    public ODiaryViewModel() {
        StateFlowImpl r1 = j1.a(null);
        this._totalRecordDays = r1;
        this.totalRecordDays = r1;
        StateFlowImpl r2 = j1.a(CollectionsKt.emptyList());
        this._briefItems = r2;
        this.briefItems = r2;
        StateFlowImpl r0 = j1.a(null);
        this._selectedDate = r0;
        this.selectedDate = r0;
        StateFlowImpl r3 = j1.a(b.d.a);
        this._detailState = r3;
        this.detailState = r3;
        this.hasMore = true;
    }

    public final i1<List<i>> getBriefItems() {
        return this.briefItems;
    }

    public final i1<b> getDetailState() {
        return this.detailState;
    }

    public final i1<String> getSelectedDate() {
        return this.selectedDate;
    }

    public final i1<Integer> getTotalRecordDays() {
        return this.totalRecordDays;
    }

    public static final /* synthetic */ boolean access$getDetailRenderedByH5$p(ODiaryViewModel r0) {
        return r0.detailRenderedByH5;
    }

    public static final /* synthetic */ Integer access$getDiaryBizId$p(ODiaryViewModel r0) {
        return r0.diaryBizId;
    }

    public static final /* synthetic */ String access$getNextCursor$p(ODiaryViewModel r0) {
        return r0.nextCursor;
    }

    public static final /* synthetic */ z0 access$get_briefItems$p(ODiaryViewModel r0) {
        return r0._briefItems;
    }

    public static final /* synthetic */ z0 access$get_detailState$p(ODiaryViewModel r0) {
        return r0._detailState;
    }

    public static final /* synthetic */ z0 access$get_selectedDate$p(ODiaryViewModel r0) {
        return r0._selectedDate;
    }

    public static final /* synthetic */ z0 access$get_totalRecordDays$p(ODiaryViewModel r0) {
        return r0._totalRecordDays;
    }

    public final void deleteCurrentDiary(Function1<? super Boolean, Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onResult");
        String r0 = selectedDiaryId();
        if (r0 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r0, this, r8, null), 2, null);
    }

    public final void selectDate(i r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        String r0 = r4.b();
        if (r0 != null) goto L5;
        return;
    L5:
        this._selectedDate.setValue(r0);
        if (this.detailRenderedByH5 == false) goto L8;
        return;
    L8:
        String r1 = r4.c();
        if (r4.e() == false) goto L20;
        if (r1 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == true) goto L20;
        fetchDetail(r1, r0);
        return;
    L12:
        if (r1.length() == 0) goto L15;
        r5 = false;
    L20:
        Job r6 = this.detailJob;
        if (r6 == null) goto L23;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L23:
        this._detailState.setValue(b.C0092b.a);
    }

    public final void selectDateFromH5(String r2) {
        Intrinsics.checkNotNullParameter(r2, "date");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this._selectedDate.setValue(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void selectEmptyDate(String r4) {
        Intrinsics.checkNotNullParameter(r4, "date");
        Job r0 = this.detailJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this._selectedDate.setValue(r4);
        if (this.detailRenderedByH5 == false) goto L8;
        return;
    L8:
        this._detailState.setValue(b.C0092b.a);
    }

    public final void setDetailRenderedByH5(boolean r1) {
        this.detailRenderedByH5 = r1;
    }

    public final void setDiaryBizId(Integer r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.diaryBizId = r3;
        return;
    L5:
        if (r3.intValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    public final void setFirstScreenDate(String r3) {
        if (r3 != null) goto L5;
    L10:
        r3 = null;
    L11:
        this.firstScreenDate = r3;
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L10;
    L7:
        r1 = false;
        goto L8
    }

    public static final /* synthetic */ void access$setH5DiaryId$p(ODiaryViewModel r0, String r1) {
        r0.h5DiaryId = r1;
    }

    public static final /* synthetic */ void access$setHasMore$p(ODiaryViewModel r0, boolean r1) {
        r0.hasMore = r1;
    }

    public static final /* synthetic */ void access$setLoadingBrief$p(ODiaryViewModel r0, boolean r1) {
        r0.loadingBrief = r1;
    }

    public static final /* synthetic */ void access$setNextCursor$p(ODiaryViewModel r0, String r1) {
        r0.nextCursor = r1;
    }

    private final void fetchDetail(String r10, String r11) {
        this._detailState.setValue(b.e.a);
        Job r0 = this.detailJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.detailJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04431(r10, this, r11, null), 2, null);
    }

    public final void applyH5Stats(String r5, int r6) {
        Integer r0 = null;
        boolean r1 = true;
        if (r5 != null) goto L5;
    L12:
        Integer r7 = Integer.valueOf(r6);
        if (r7.intValue() > 0) goto L16;
        r1 = false;
    L16:
        if (r1 == false) goto L18;
        r0 = r7;
    L18:
        if (r0 == null) goto L21;
        this._totalRecordDays.setValue(Integer.valueOf(r0.intValue()));
        return;
    L21:
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r5 = null;
    L11:
        this.h5DiaryId = r5;
        goto L12
    L7:
        r3 = false;
        goto L8
    }
}
