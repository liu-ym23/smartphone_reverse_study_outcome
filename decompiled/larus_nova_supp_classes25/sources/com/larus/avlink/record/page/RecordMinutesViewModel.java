package com.larus.avlink.record.page;

import com.larus.avlink.record.util.LarkRecordMinutesManager;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService;
import com.larus.minutes.api.IMinutesService;
import com.larus.minutes.api.MinutesOfflineRecordingUploadStatus;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\b\n*\u00010\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fJ \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u000e\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fJ\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u001c\u0010$\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000fH\u0002J \u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0'*\b\u0012\u0004\u0012\u00020\u001b0'2\u0006\u0010(\u001a\u00020\u0017H\u0002J \u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0'*\b\u0012\u0004\u0012\u00020\u001b0'2\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0017J\u0006\u00102\u001a\u00020\u0011J\u0006\u00103\u001a\u00020\u0011J\u0010\u00104\u001a\u00020\u00172\b\u00105\u001a\u0004\u0018\u00010\u000fJ\u000e\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u000fR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101¨\u00069"}, d2 = {"Lcom/larus/avlink/record/page/RecordMinutesViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/avlink/record/page/RecordMinutesState;", "<init>", "()V", "model", "Lcom/larus/avlink/record/page/RecordMinutesModel;", "getModel", "()Lcom/larus/avlink/record/page/RecordMinutesModel;", "model$delegate", "Lkotlin/Lazy;", "uploadProgressJob", "Lkotlinx/coroutines/Job;", "finishedUploadIds", "", "", "fetchRecordMinutesHistoryList", "", "action", "Lcom/larus/avlink/record/page/Action;", "fetchRecordMinutesHistoryListDelayed", "justEndedRecordingId", "doFetch", "", "(Lcom/larus/avlink/record/page/Action;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecordItem", "item", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "observeOfflineRecordingUploadProgress", "isOfflineRecordingUploading", "recordingId", "uploadOfflineRecording", "updateOfflineRecordingUploadProgress", "progress", "", "clearOfflineRecordingUploadProgress", "handleOfflineRecordingUploadFailed", "errorMsg", "ensureCurrentRecordingItem", "", "isHardwareRecording", "ensureOfflineRecordingPlaceholder", "isOfflineRecording", "startRecord", "endRecord", "onHardwareOfflineRecordingChanged", "recording", "syncListener", "com/larus/avlink/record/page/RecordMinutesViewModel$syncListener$1", "Lcom/larus/avlink/record/page/RecordMinutesViewModel$syncListener$1;", "registerSyncListener", "unregisterSyncListener", "isExternalOpusItem", "id", "uploadExternalOpusFile", "itemId", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RecordMinutesViewModel extends ComponentViewModel<RecordMinutesState> {
    public static final int $stable = 0;
    public static final a Companion = null;
    private static final long FIRST_FETCH_DELAY_MS = 1000;
    private static final int MAX_END_PULL_RETRY = 2;
    private static final long RETRY_FETCH_INTERVAL_MS = 500;
    private static final String TAG = "RecordMinutesViewModel";
    private final Set<String> finishedUploadIds;
    private final Lazy model$delegate;
    private final RecordMinutesViewModel$syncListener$1 syncListener;
    private Job uploadProgressJob;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$deleteRecordItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$deleteRecordItem$1", f = "RecordMinutesViewModel.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ String $id;
        final /* synthetic */ i0 $item;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public AnonymousClass1(RecordMinutesViewModel r1, i0 r2, String r3, Action r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$item = r2;
            this.$id = r3;
            this.$action = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$item, this.$id, this.$action, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L19:
            com.larus.avlink.record.page.a r8 = (com.larus.avlink.record.page.a) r7;
            if ((r8 instanceof com.larus.avlink.record.page.a.b) == false) goto L23;
            final RecordMinutesViewModel r9 = this.this$0;
            final String r3 = this.$id;
            final Action r4 = this.$action;
            RecordMinutesViewModel.access$withState(r9, new h1(r9, r3, r4));
        L26:
            return Unit.INSTANCE;
        L23:
            if ((r8 instanceof com.larus.avlink.record.page.a.C0022a) == false) goto L28;
            final long r5 = System.currentTimeMillis();
            RecordMinutesViewModel.access$setState(this.this$0, new i1(r5));
            goto L26
        L28:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            RecordMinutesModel r10 = RecordMinutesViewModel.access$getModel(this.this$0);
            i0 r6 = this.$item;
            this.label = 1;
            r10.getClass();
            String r11 = r6.a;
            if (r11 != null) goto L11;
        L14:
            if (r2 == false) goto L16;
            com.larus.avlink.n1.d("RecordMinutesModel", "delete failed, recording id is null or empty");
            r7 = new com.larus.avlink.record.page.a.C0022a("recording id is null or empty");
        L17:
            if (r7 != r0) goto L19;
            return r0;
        L16:
            r7 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$deleteRecordMinutesItem$2(r10, r11, r6, null), this);
            goto L17
        L11:
            if (r11.length() == 0) goto L14;
            r2 = false;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$doFetch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel", f = "RecordMinutesViewModel.kt", i = {0}, l = {76}, m = "doFetch", n = {"action"}, s = {"L$0"})
    public static final class C01241 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C01241(RecordMinutesViewModel r1, Continuation<? super C01241> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return RecordMinutesViewModel.access$doFetch(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryList$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryList$2", f = "RecordMinutesViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public AnonymousClass2(RecordMinutesViewModel r1, Action r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$action = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$action, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RecordMinutesViewModel r5 = this.this$0;
            Action r2 = this.$action;
            this.label = 1;
            if (RecordMinutesViewModel.access$doFetch(r5, r2, null, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryListDelayed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$fetchRecordMinutesHistoryListDelayed$1", f = "RecordMinutesViewModel.kt", i = {2, 3}, l = {56, 57, 62, 63}, m = "invokeSuspend", n = {"retry", "retry"}, s = {"I$0", "I$0"})
    public static final class C01251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        final /* synthetic */ String $justEndedRecordingId;
        int I$0;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C01251(RecordMinutesViewModel r1, Action r2, String r3, Continuation<? super C01251> r4) {
            this.this$0 = r1;
            this.$action = r2;
            this.$justEndedRecordingId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01251(this.this$0, this.$action, this.$justEndedRecordingId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x009a -> B:32:0x009d). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r9);
            C01251 r5 = this;
        L32:
            boolean r10 = ((Boolean) r9).booleanValue();
        L22:
            if (r10 == true) goto L24;
        L33:
            if (r10 == false) goto L38;
            if (r5.$justEndedRecordingId == null) goto L38;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "end-pull give up after 2 retries, id=" + r5.$justEndedRecordingId);
        L38:
            return Unit.INSTANCE;
        L24:
            if (r5.$justEndedRecordingId == null) goto L33;
            if (r2 >= 2) goto L33;
            r2 = r2 + 1;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "end-pull still pending, retry=" + r2 + ", id=" + r5.$justEndedRecordingId);
            r5.I$0 = r2;
            r5.label = 3;
            if (DelayKt.delay(RecordMinutesViewModel.RETRY_FETCH_INTERVAL_MS, r5) != r0) goto L29;
            return r0;
        L29:
            RecordMinutesViewModel r11 = r5.this$0;
            Action r6 = r5.$action;
            String r7 = r5.$justEndedRecordingId;
            r5.I$0 = r2;
            r5.label = 4;
            r9 = RecordMinutesViewModel.access$doFetch(r11, r6, r7, r5);
            if (r9 != r0) goto L32;
            return r0;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = this.I$0;
            ResultKt.throwOnFailure(r9);
            r5 = this;
            goto L29
        L12:
            ResultKt.throwOnFailure(r9);
        L20:
            r10 = ((Boolean) r9).booleanValue();
            r2 = 0;
            r5 = this;
            goto L22
        L13:
            ResultKt.throwOnFailure(r9);
        L17:
            RecordMinutesViewModel r12 = this.this$0;
            Action r3 = this.$action;
            String r8 = this.$justEndedRecordingId;
            this.label = 2;
            r9 = RecordMinutesViewModel.access$doFetch(r12, r3, r8, this);
            if (r9 != r0) goto L20;
            return r0;
        L14:
            ResultKt.throwOnFailure(r9);
            this.label = 1;
            if (DelayKt.delay(RecordMinutesViewModel.FIRST_FETCH_DELAY_MS, this) != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1", f = "RecordMinutesViewModel.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.i1<yk9.e> $progressFlow;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00211<T> implements FlowCollector {
            public final /* synthetic */ RecordMinutesViewModel a;

            /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$a */
            public /* synthetic */ class a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[MinutesOfflineRecordingUploadStatus.values().length];
                    r0[MinutesOfflineRecordingUploadStatus.PROGRESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r0[MinutesOfflineRecordingUploadStatus.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r0[MinutesOfflineRecordingUploadStatus.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    a = r0;
                }
            }

            public C00211(RecordMinutesViewModel r1) {
                this.a = r1;
            }

            public final Object a(yk9.e r9, Continuation<? super Unit> r10) {
                if ((r10 instanceof RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1) == false) goto L7;
                RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1 r0 = (RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1) r10;
                int r1 = r0.label;
                if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
                r0.label = r1 - Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                boolean r4 = true;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                String r12 = (String) r0.L$0;
                ResultKt.throwOnFailure(r11);
            L51:
                r4 = ((Boolean) r11).booleanValue();
                String r13 = r12;
            L52:
                if (r4 == false) goto L54;
                this.a.fetchRecordMinutesHistoryList(Action.UPLOAD_PROGRESS);
            L57:
                return Unit.INSTANCE;
            L54:
                com.larus.avlink.n1.b(RecordMinutesViewModel.TAG, "skip refresh because dora cleanup is incomplete, id=" + r13);
                goto L57
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r11);
                if (r9 == null) goto L17;
                r13 = r9.a;
                boolean r5 = false;
                if (r13 != null) goto L21;
            L24:
                boolean r6 = true;
            L25:
                if (r6 == false) goto L29;
                return Unit.INSTANCE;
            L29:
                if (RecordMinutesViewModel.access$isOfflineRecordingUploading(this.a, r13) == true) goto L32;
                com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "ignore stale upload event, id=" + r13 + ", status=" + r9.c);
                return Unit.INSTANCE;
            L32:
                int r7 = a.a[r9.c.ordinal()];
                if (r7 != 1) goto L35;
                RecordMinutesViewModel.access$updateOfflineRecordingUploadProgress(this.a, r13, r9.b);
                goto L57
            L35:
                if (r7 != 2) goto L37;
                RecordMinutesViewModel.access$updateOfflineRecordingUploadProgress(this.a, r13, 1.0f);
                RecordMinutesViewModel.access$getModel(this.a).getClass();
                if (r13 != null) goto L44;
            L46:
                if (r5 == false) goto L52;
                RecordMinutesModel r14 = RecordMinutesViewModel.access$getModel(this.a);
                r0.L$0 = r13;
                r0.label = 1;
                Object r15 = r14.m(r13, r0);
                if (r15 != r2) goto L50;
                return r2;
            L50:
                r11 = r15;
                r12 = r13;
                goto L51
            L44:
                if (StringsKt.startsWith$default(r13, "external_opus_", false, 2, null) == false) goto L46;
                r5 = true;
                goto L46
            L37:
                if (r7 != 3) goto L40;
                RecordMinutesModel r8 = RecordMinutesViewModel.access$getModel(this.a);
                r8.getClass();
                Intrinsics.checkNotNullParameter(r13, "itemId");
                r8.f.remove(r13);
                RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.a, r13, r9.d);
                goto L57
            L40:
                throw new NoWhenBranchMatchedException();
            L21:
                if (r13.length() == 0) goto L24;
                r6 = false;
                goto L25
            L17:
                return Unit.INSTANCE;
            L7:
                r0 = new RecordMinutesViewModel$observeOfflineRecordingUploadProgress$1$1$emit$1(this, r10);
                goto L8
            }

            public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
                return a((yk9.e) r1, r2);
            }
        }

        public C01261(kotlinx.coroutines.flow.i1<yk9.e> r1, RecordMinutesViewModel r2, Continuation<? super C01261> r3) {
            this.$progressFlow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01261(this.$progressFlow, this.this$0, r4);
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
            kotlinx.coroutines.flow.i1<yk9.e> r6 = this.$progressFlow;
            C00211 r2 = new C00211(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$uploadExternalOpusFile$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$uploadExternalOpusFile$1", f = "RecordMinutesViewModel.kt", i = {}, l = {582}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $itemId;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C01271(RecordMinutesViewModel r1, String r2, Continuation<? super C01271> r3) {
            this.this$0 = r1;
            this.$itemId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01271(this.this$0, this.$itemId, r4);
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
        L11:
            com.larus.avlink.record.page.a r7 = (com.larus.avlink.record.page.a) r6;
            if ((r7 instanceof com.larus.avlink.record.page.a.b) == false) goto L15;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload external opus request success, id=" + this.$itemId);
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r7 instanceof com.larus.avlink.record.page.a.C0022a) == false) goto L20;
            String r8 = ((com.larus.avlink.record.page.a.C0022a) r7).a;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload external opus request failed, id=" + this.$itemId + ", msg=" + r8);
            RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.this$0, this.$itemId, r8);
            goto L18
        L20:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            RecordMinutesModel r9 = RecordMinutesViewModel.access$getModel(this.this$0);
            String r2 = this.$itemId;
            this.label = 1;
            r9.getClass();
            r6 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$uploadExternalOpusFile$2(r9, r2, null), this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.avlink.record.page.RecordMinutesViewModel$uploadOfflineRecording$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesViewModel$uploadOfflineRecording$1", f = "RecordMinutesViewModel.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $recordingId;
        int label;
        final /* synthetic */ RecordMinutesViewModel this$0;

        public C01281(RecordMinutesViewModel r1, String r2, Continuation<? super C01281> r3) {
            this.this$0 = r1;
            this.$recordingId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01281(this.this$0, this.$recordingId, r4);
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
        L11:
            com.larus.avlink.record.page.a r7 = (com.larus.avlink.record.page.a) r6;
            if ((r7 instanceof com.larus.avlink.record.page.a.b) == false) goto L15;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload offline recording request success, id=" + this.$recordingId);
        L18:
            return Unit.INSTANCE;
        L15:
            if ((r7 instanceof com.larus.avlink.record.page.a.C0022a) == false) goto L20;
            String r8 = ((com.larus.avlink.record.page.a.C0022a) r7).a;
            com.larus.avlink.n1.d(RecordMinutesViewModel.TAG, "upload offline recording request failed, id=" + this.$recordingId + ", msg=" + r8);
            RecordMinutesViewModel.access$handleOfflineRecordingUploadFailed(this.this$0, this.$recordingId, r8);
            goto L18
        L20:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            RecordMinutesModel r9 = RecordMinutesViewModel.access$getModel(this.this$0);
            String r2 = this.$recordingId;
            this.label = 1;
            r9.getClass();
            r6 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$uploadOfflineRecording$2(r2, r9, null), this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ RecordMinutesState No(long r0, RecordMinutesState r2) {
        return handleOfflineRecordingUploadFailed$lambda$19(r0, r2);
    }

    public static /* synthetic */ RecordMinutesState Oo(List r0, RecordMinutesState r1) {
        return onHardwareOfflineRecordingChanged$lambda$30$lambda$29(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState Po(Action r0, RecordMinutesState r1) {
        return fetchRecordMinutesHistoryList$lambda$1(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState Qo(Action r0, long r1, BottomStatus r3, RecordMinutesState r4) {
        return doFetch$lambda$6(r0, r1, r3, r4);
    }

    public static /* synthetic */ Unit So(RecordMinutesViewModel r0, RecordMinutesState r1) {
        return onHardwareOfflineRecordingChanged$lambda$30(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState To(RecordMinutesState r0) {
        return endRecord$lambda$26(r0);
    }

    public static /* synthetic */ RecordMinutesState Wo(List r0, Action r1, long r2, RecordMinutesState r4) {
        return doFetch$lambda$8$lambda$7(r0, r1, r2, r4);
    }

    public static /* synthetic */ RecordMinutesState Yo(Action r0, List r1, long r2, BottomStatus r4, RecordMinutesState r5) {
        return doFetch$lambda$5(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ RecordMinutesState Zo(RecordMinutesState r0) {
        return startRecord$lambda$22(r0);
    }

    public static /* synthetic */ RecordMinutesModel ap() {
        return model_delegate$lambda$0();
    }

    public static /* synthetic */ Unit bp(String r0, RecordMinutesViewModel r1, RecordMinutesState r2) {
        return startRecord$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ RecordMinutesState cp(List r0, RecordMinutesState r1) {
        return startRecord$lambda$25$lambda$24(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState dp(Action r0, RecordMinutesState r1) {
        return doFetch$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit ep(String r0, RecordMinutesViewModel r1, boolean r2, float r3, RecordMinutesState r4) {
        return updateOfflineRecordingUploadProgress$lambda$14(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit hp(RecordMinutesViewModel r0, Action r1, RecordMinutesState r2) {
        return doFetch$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ RecordMinutesState ip(List r0, RecordMinutesState r1) {
        return clearOfflineRecordingUploadProgress$lambda$18$lambda$17(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState kp(boolean r0, RecordMinutesState r1) {
        return onHardwareOfflineRecordingChanged$lambda$27(r0, r1);
    }

    public static /* synthetic */ Unit lp(RecordMinutesViewModel r0, String r1, RecordMinutesState r2) {
        return clearOfflineRecordingUploadProgress$lambda$18(r0, r1, r2);
    }

    public static /* synthetic */ Unit np(RecordMinutesViewModel r0, RecordMinutesState r1) {
        return onHardwareOfflineRecordingChanged$lambda$33(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState pp(List r0, RecordMinutesState r1) {
        return onHardwareOfflineRecordingChanged$lambda$33$lambda$32(r0, r1);
    }

    public static /* synthetic */ RecordMinutesState rp(List r0, RecordMinutesState r1) {
        return updateOfflineRecordingUploadProgress$lambda$14$lambda$13(r0, r1);
    }

    private final RecordMinutesModel getModel() {
        return (RecordMinutesModel) this.model$delegate.getValue();
    }

    private static final RecordMinutesModel model_delegate$lambda$0() {
        return new RecordMinutesModel();
    }

    public final void endRecord() {
        setState(new m0());
    }

    public final void observeOfflineRecordingUploadProgress() {
        Job r0 = this.uploadProgressJob;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isActive() != true) goto L7;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        getModel().getClass();
        IMinutesService r2 = (IMinutesService) ServiceManager.get().getService(IMinutesService.class);
        if (r2 != null) goto L29;
        com.larus.avlink.n1.d("RecordMinutesModel", "get upload progress flow failed, minutes service is null");
        kotlinx.coroutines.flow.i1 r3 = null;
    L24:
        if (r3 != null) goto L27;
        com.larus.avlink.n1.d(TAG, "observe upload progress skipped, flow is null");
        return;
    L27:
        this.uploadProgressJob = BuildersKt.launch$default(getViewModelScope(), null, null, new C01261(r3, this, null), 3, null);
        return;
    L29:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        Object r5 = Result.constructor-impl(r2.U0());     // Catch: Throwable -> L15
    L17:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L21;
        com.larus.avlink.n1.d("RecordMinutesModel", "get upload progress flow failed, msg=" + r6.getMessage());
    L21:
        if (Result.isFailure-impl(r5) == false) goto L23;
        r5 = null;
    L23:
        r3 = (kotlinx.coroutines.flow.i1) r5;
    L15:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1] */
    public RecordMinutesViewModel() {
        this.model$delegate = LazyKt.lazy(new v0());
        this.finishedUploadIds = new LinkedHashSet();
        this.syncListener = new RecordMinutesViewModel$syncListener$1(this);
    }

    public final void registerSyncListener() {
        RecordMinutesModel r0 = getModel();
        RecordMinutesViewModel$syncListener$1 r1 = this.syncListener;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        IDoraOfflineRecordSyncService r2 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r2 != null) goto L13;
        com.larus.avlink.n1.d("RecordMinutesModel", "register transfer listener skipped, dora record sync service is null");
        return;
    L13:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r2.d(r1);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L16;
        com.larus.avlink.n1.b("RecordMinutesModel", "register transfer listener failed: " + r5.getMessage());
        return;
    L16:
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final void unregisterSyncListener() {
        RecordMinutesModel r0 = getModel();
        RecordMinutesViewModel$syncListener$1 r1 = this.syncListener;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "listener");
        IDoraOfflineRecordSyncService r2 = (IDoraOfflineRecordSyncService) ServiceManager.get().getService(IDoraOfflineRecordSyncService.class);
        if (r2 == null) goto L16;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        r2.e(r1);     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        com.larus.avlink.n1.b("RecordMinutesModel", "unregister transfer listener failed: " + r5.getMessage());
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public static final /* synthetic */ RecordMinutesModel access$getModel(RecordMinutesViewModel r0) {
        return r0.getModel();
    }

    public static final /* synthetic */ CoroutineScope access$getViewModelScope(RecordMinutesViewModel r0) {
        return r0.getViewModelScope();
    }

    private final void clearOfflineRecordingUploadProgress(final String r2) {
        withState(new o0(this, r2));
    }

    private static final RecordMinutesState endRecord$lambda$26(RecordMinutesState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return RecordMinutesState.copy$default(r12, null, null, null, 0, null, BottomStatus.END_RECORDING, null, 95, null);
    }

    private final boolean isOfflineRecordingUploading(String r6) {
        Iterable r0 = (Iterable) ((RecordMinutesState) getState()).getHistoryList().getSecond();
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L25;
        i0 r2 = (i0) r1.next();
        if (Intrinsics.areEqual(r2.a, r6) == true) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L9;
        return true;
    L13:
        if (r2.h == null) goto L15;
        r3 = true;
        goto L16
    L25:
        return false;
    L5:
        if (((Collection) r0).isEmpty() == false) goto L7;
        return false;
    }

    private static final RecordMinutesState startRecord$lambda$22(RecordMinutesState r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$setState");
        return RecordMinutesState.copy$default(r12, null, null, null, 0, null, BottomStatus.RECORDING, null, 95, null);
    }

    public final void fetchRecordMinutesHistoryList(final Action r8) {
        Intrinsics.checkNotNullParameter(r8, "action");
        com.larus.avlink.n1.d(TAG, "fetchRecordMinutesHistoryList source is " + r8);
        if (r8 != Action.INITIAL_PULL) goto L5;
    L6:
        setState(new f1(r8));
    L7:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass2(this, r8, null), 3, null);
        return;
    L5:
        if (r8 != Action.RETRY_PULL) goto L7;
        goto L6
    }

    public final boolean isExternalOpusItem(String r5) {
        getModel().getClass();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r5, "external_opus_", false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onHardwareOfflineRecordingChanged(final boolean r4) {
        StringBuilder r0 = new StringBuilder("onHardwareOfflineRecordingChanged recording=");
        r0.append(r4);
        r0.append(", isHardwareRecording=");
        getModel().getClass();
        LarkRecordMinutesManager r1 = LarkRecordMinutesManager.a;
        r1.getClass();
        r0.append(LarkRecordMinutesManager.q());
        com.larus.avlink.n1.d(TAG, r0.toString());
        getModel().getClass();
        r1.getClass();
        if (LarkRecordMinutesManager.q() == false) goto L6;
        com.larus.avlink.n1.d(TAG, "offline recording change ignored, hardware online recording in progress");
        return;
    L6:
        setState(new x0(r4));
        if (r4 == false) goto L9;
        withState(new z0(this));
        return;
    L9:
        withState(new a1(this));
        fetchRecordMinutesHistoryList(Action.REFRESH_PULL);
    }

    public final void startRecord(final String r2) {
        setState(new w0());
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        com.larus.avlink.n1.d(TAG, "startRecord skip insert item, recordingId is null or empty");
        return;
    L12:
        withState(new y0(r2, this));
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void uploadExternalOpusFile(String r8) {
        Intrinsics.checkNotNullParameter(r8, "itemId");
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        com.larus.avlink.n1.d(TAG, "upload external opus skipped, itemId is empty");
        return;
    L9:
        observeOfflineRecordingUploadProgress();
        updateOfflineRecordingUploadProgress(r8, 0.0f);
        BuildersKt.launch$default(getViewModelScope(), null, null, new C01271(this, r8, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void uploadOfflineRecording(String r8) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        com.larus.avlink.n1.d(TAG, "upload offline recording skipped, recordingId is empty");
        return;
    L9:
        observeOfflineRecordingUploadProgress();
        updateOfflineRecordingUploadProgress(r8, 0.0f);
        BuildersKt.launch$default(getViewModelScope(), null, null, new C01281(this, r8, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isOfflineRecordingUploading(RecordMinutesViewModel r0, String r1) {
        return r0.isOfflineRecordingUploading(r1);
    }

    public static final /* synthetic */ void access$setState(RecordMinutesViewModel r0, Function1 r1) {
        r0.setState(r1);
    }

    public static final /* synthetic */ void access$withState(RecordMinutesViewModel r0, Function1 r1) {
        r0.withState(r1);
    }

    private static final RecordMinutesState clearOfflineRecordingUploadProgress$lambda$18$lambda$17(List r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return RecordMinutesState.copy$default(r13, new Pair(Action.UPLOAD_PROGRESS, r12), null, null, 0, null, null, null, 126, null);
    }

    private static final RecordMinutesState doFetch$lambda$9(Action r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        PageStatus r7 = PageStatus.ERROR;
        return RecordMinutesState.copy$default(r13, new Pair(r12, CollectionsKt.emptyList()), null, null, 0, r7, null, null, 110, null);
    }

    private final List<i0> ensureCurrentRecordingItem(List<i0> r6, boolean r7) {
        if (r7 == true) goto L4;
        return r6;
    L4:
        LarkRecordMinutesManager.a.getClass();
        String r8 = LarkRecordMinutesManager.j();
        boolean r0 = false;
        if (r8 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        com.larus.avlink.n1.d(TAG, "ensure current recording item skipped, recordingId is null or empty");
        return r6;
    L14:
        List<i0> r3 = r6;
        if ((r3 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r4 = r3.iterator();
    L21:
        if (r4.hasNext() == false) goto L25;
        if (Intrinsics.areEqual(((i0) r4.next()).a, r8) == false) goto L21;
        r0 = true;
    L25:
        if (r0 == false) goto L28;
        return r6;
    L28:
        return CollectionsKt.plus(CollectionsKt.listOf(getModel().f(r8)), r3);
    L17:
        if (r3.isEmpty() == false) goto L19;
    L7:
        if (r8.length() == 0) goto L10;
        r2 = false;
        goto L11
    }

    private final List<i0> ensureOfflineRecordingPlaceholder(List<i0> r5, boolean r6) {
        if (r6 == true) goto L4;
        return r5;
    L4:
        List<i0> r7 = r5;
        boolean r1 = false;
        if ((r7 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r0 = r7.iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((i0) r0.next()).a, "offline_recording_placeholder") == false) goto L11;
        r1 = true;
    L15:
        if (r1 == false) goto L18;
        return r5;
    L18:
        return CollectionsKt.plus(CollectionsKt.listOf(getModel().g()), r7);
    L7:
        if (r7.isEmpty() == false) goto L9;
        goto L9
    }

    private static final RecordMinutesState fetchRecordMinutesHistoryList$lambda$1(Action r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        PageStatus r7 = PageStatus.LOADING;
        return RecordMinutesState.copy$default(r13, new Pair(r12, CollectionsKt.emptyList()), null, null, 0, r7, null, null, 110, null);
    }

    private final void handleOfflineRecordingUploadFailed(String r3, String r4) {
        StringBuilder r0 = new StringBuilder("offline recording upload failed, id=");
        r0.append(r3);
        r0.append(", msg=");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.append(r4);
        com.larus.avlink.n1.d(TAG, r0.toString());
        clearOfflineRecordingUploadProgress(r3);
        final long r5 = System.currentTimeMillis();
        setState(new q0(r5));
    }

    private static final RecordMinutesState handleOfflineRecordingUploadFailed$lambda$19(long r12, RecordMinutesState r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$setState");
        return RecordMinutesState.copy$default(r14, null, null, new o1(r12), 0, null, null, null, 123, null);
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$27(boolean r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        if (r12 == false) goto L5;
        BottomStatus r14 = BottomStatus.OFFLINE_RECORDING;
    L7:
        return RecordMinutesState.copy$default(r13, null, null, null, 0, null, r14, null, 95, null);
    L5:
        r14 = BottomStatus.END_RECORDING;
        goto L7
    }

    private static final Unit onHardwareOfflineRecordingChanged$lambda$30(RecordMinutesViewModel r4, RecordMinutesState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        List r6 = (List) r5.getHistoryList().getSecond();
        boolean r1 = false;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator r0 = r6.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((i0) r0.next()).a, "offline_recording_placeholder") == false) goto L9;
        r1 = true;
    L13:
        if (r1 == true) goto L15;
        final List r7 = CollectionsKt.plus(CollectionsKt.listOf(r4.getModel().g()), r6);
        r4.setState(new c1(r7));
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L5:
        if (r6.isEmpty() == false) goto L7;
        goto L7
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$30$lambda$29(List r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        PageStatus r7 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r13, new Pair(Action.START_PULL, r12), null, null, 0, r7, null, null, 110, null);
    }

    private static final Unit onHardwareOfflineRecordingChanged$lambda$33(RecordMinutesViewModel r4, RecordMinutesState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        Iterable r6 = (Iterable) r5.getHistoryList().getSecond();
        final ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r1 = r7.next();
        if (Intrinsics.areEqual(((i0) r1).a, "offline_recording_placeholder") == true) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r4.setState(new d1(r0));
        return Unit.INSTANCE;
    }

    private static final RecordMinutesState onHardwareOfflineRecordingChanged$lambda$33$lambda$32(List r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return RecordMinutesState.copy$default(r13, new Pair(Action.END_PULL, r12), null, null, 0, null, null, null, 126, null);
    }

    private static final RecordMinutesState startRecord$lambda$25$lambda$24(List r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        PageStatus r7 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r13, new Pair(Action.START_PULL, r12), null, null, 0, r7, null, null, 110, null);
    }

    private final void updateOfflineRecordingUploadProgress(final String r3, float r4) {
        final float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
        if (r5 < 1.0f) goto L5;
        final boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.finishedUploadIds.add(r3);
    L8:
        withState(new e1(r3, this, r0, r5));
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final RecordMinutesState updateOfflineRecordingUploadProgress$lambda$14$lambda$13(List r12, RecordMinutesState r13) {
        Intrinsics.checkNotNullParameter(r13, "$this$setState");
        return RecordMinutesState.copy$default(r13, new Pair(Action.UPLOAD_PROGRESS, r12), null, null, 0, null, null, null, 126, null);
    }

    public final void deleteRecordItem(Action r12, i0 r13) {
        Intrinsics.checkNotNullParameter(r12, "action");
        Intrinsics.checkNotNullParameter(r13, "item");
        String r4 = r13.a;
        if (r4 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass1(this, r13, r4, r12, null), 3, null);
    }

    public final void fetchRecordMinutesHistoryListDelayed(Action r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "action");
        BuildersKt.launch$default(getViewModelScope(), null, null, new C01251(this, r8, r9, null), 3, null);
    }

    public static final /* synthetic */ void access$handleOfflineRecordingUploadFailed(RecordMinutesViewModel r0, String r1, String r2) {
        r0.handleOfflineRecordingUploadFailed(r1, r2);
    }

    public static final /* synthetic */ void access$updateOfflineRecordingUploadProgress(RecordMinutesViewModel r0, String r1, float r2) {
        r0.updateOfflineRecordingUploadProgress(r1, r2);
    }

    private static final Unit clearOfflineRecordingUploadProgress$lambda$18(RecordMinutesViewModel r4, String r5, RecordMinutesState r6) {
        Intrinsics.checkNotNullParameter(r6, "state");
        List r7 = (List) r6.getHistoryList().getSecond();
        Iterator r0 = r7.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((i0) r0.next()).a, r5) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L12;
        List r8 = r7;
        final ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L15:
        if (r9.hasNext() == false) goto L20;
        i0 r3 = (i0) r9.next();
        if (Intrinsics.areEqual(r3.a, r5) == false) goto L19;
        r3 = i0.a(r3, null, null, 895);
    L19:
        r2.add(r3);
        goto L15
    L20:
        r4.setState(new n0(r2));
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L9:
        r1 = -1;
        goto L10
    }

    private final Object doFetch(Action r12, String r13, Continuation<? super Boolean> r14) {
        if ((r14 instanceof C01241) == false) goto L7;
        C01241 r0 = (C01241) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r12 = (Action) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        final Action r6 = r12;
        m r16 = (m) r15;
        com.larus.avlink.record.page.a<List<i0>> r17 = r16.a;
        if ((r17 instanceof com.larus.avlink.record.page.a.b) == false) goto L69;
        getModel().getClass();
        LarkRecordMinutesManager r18 = LarkRecordMinutesManager.a;
        r18.getClass();
        boolean r4 = LarkRecordMinutesManager.q();
        if (r4 == true) goto L24;
        r18.getClass();
        if (LarkRecordMinutesManager.t() == false) goto L24;
        boolean r19 = true;
    L25:
        if (r4 == false) goto L28;
        BottomStatus r5 = BottomStatus.RECORDING;
    L27:
        final BottomStatus r10 = r5;
        com.larus.avlink.n1.d(TAG, "fetchRecordMinutesHistoryList bottomStatus decided=" + r10 + ", isHardwareRecording=" + r4 + ", isOfflineRecording=" + r19);
        Iterable r110 = (Iterable) ((com.larus.avlink.record.page.a.b) r17).a;
        ArrayList r7 = new ArrayList();
        Iterator r111 = r110.iterator();
    L33:
        if (r111.hasNext() == false) goto L42;
        Object r8 = r111.next();
        i0 r9 = (i0) r8;
        if (com.larus.utils.o0.d(r9.a) == true) goto L37;
    L39:
        boolean r11 = false;
    L40:
        if (r11 == false) goto L33;
        r7.add(r8);
        goto L33
    L37:
        if (com.larus.utils.o0.d(r9.b) == false) goto L39;
        r11 = true;
        goto L40
    L42:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r20 = r7.iterator();
    L44:
        if (r20.hasNext() == false) goto L54;
        i0 r21 = (i0) r20.next();
        String r22 = r21.a;
        if (r22 == null) goto L53;
        if (this.finishedUploadIds.contains(r22) == false) goto L53;
        TagType r23 = r21.d;
        if (r23 != TagType.OFFLINE) goto L52;
        r23 = null;
    L52:
        r21 = i0.a(r21, r23, Boxing.boxFloat(1.0f), 887);
    L53:
        r112.add(r21);
        goto L44
    L54:
        final List<i0> r24 = ensureOfflineRecordingPlaceholder(ensureCurrentRecordingItem(r112, r4), r19);
        Set<String> r113 = this.finishedUploadIds;
        ArrayList r25 = new ArrayList();
        Iterator<T> r114 = r24.iterator();
    L56:
        if (r114.hasNext() == false) goto L60;
        String r26 = ((i0) r114.next()).a;
        if (r26 == null) goto L56;
        r25.add(r26);
        goto L56
    L60:
        r113.retainAll(CollectionsKt.toSet(r25));
        if (r6 != Action.REFRESH_PULL) goto L63;
        long r115 = System.currentTimeMillis();
    L64:
        final long r27 = r115;
        if ((!r24.isEmpty()) == false) goto L67;
        setState(new r0(r6, r24, r27, r10));
    L75:
        return Boxing.boxBoolean(r16.b);
    L67:
        setState(new s0(r6, r27, r10));
        goto L75
    L63:
        r115 = ((RecordMinutesState) getState()).getRefreshResultTime();
        goto L64
    L28:
        if (r19 == false) goto L30;
        r5 = BottomStatus.OFFLINE_RECORDING;
        goto L27
    L30:
        r5 = BottomStatus.END_RECORDING;
    L24:
        r19 = false;
        goto L25
    L69:
        if ((r17 instanceof com.larus.avlink.record.page.a.C0022a) == false) goto L77;
        if (r6 != Action.REFRESH_PULL) goto L73;
        withState(new t0(this, r6));
        goto L75
    L73:
        setState(new u0(r6));
        goto L75
    L77:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        RecordMinutesModel r116 = getModel();
        r0.L$0 = r12;
        r0.label = 1;
        r116.getClass();
        r15 = BuildersKt.withContext(Dispatchers.getIO(), new RecordMinutesModel$fetchRecordMinutesHistoryList$2(r116, r13, null), r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new C01241(this, r14);
        goto L8
    }

    private static final Unit doFetch$lambda$8(RecordMinutesViewModel r3, final Action r4, RecordMinutesState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        final List r6 = (List) r5.getHistoryList().getSecond();
        final long r0 = System.currentTimeMillis();
        r3.setState(new b1(r6, r4, r0));
        return Unit.INSTANCE;
    }

    private static final Unit startRecord$lambda$25(String r3, RecordMinutesViewModel r4, RecordMinutesState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        List r6 = (List) r5.getHistoryList().getSecond();
        boolean r1 = false;
        if ((r6 instanceof Collection) == true) goto L5;
    L7:
        Iterator r0 = r6.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((i0) r0.next()).a, r3) == false) goto L9;
        r1 = true;
    L13:
        if (r1 == false) goto L16;
        com.larus.avlink.n1.d(TAG, "startRecord skip insert, item already exists, id=" + r3);
        return Unit.INSTANCE;
    L16:
        final List r7 = CollectionsKt.plus(CollectionsKt.listOf(r4.getModel().f(r3)), r6);
        r4.setState(new p0(r7));
        return Unit.INSTANCE;
    L5:
        if (r6.isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ Object access$doFetch(RecordMinutesViewModel r0, Action r1, String r2, Continuation r3) {
        return r0.doFetch(r1, r2, r3);
    }

    private static final RecordMinutesState doFetch$lambda$6(Action r12, long r13, BottomStatus r15, RecordMinutesState r16) {
        Intrinsics.checkNotNullParameter(r16, "$this$setState");
        PageStatus r7 = PageStatus.ONBOARDING;
        return RecordMinutesState.copy$default(r16, new Pair(r12, CollectionsKt.emptyList()), null, null, r13, r7, r15, null, 70, null);
    }

    private static final RecordMinutesState doFetch$lambda$8$lambda$7(List r12, Action r13, long r14, RecordMinutesState r16) {
        Intrinsics.checkNotNullParameter(r16, "$this$setState");
        if (r12.isEmpty() == false) goto L5;
        PageStatus r0 = PageStatus.ERROR;
    L6:
        Pair r2 = new Pair(r13, r12);
        return RecordMinutesState.copy$default(r16, r2, null, null, r14, r0, null, null, 102, null);
    L5:
        r0 = PageStatus.SUCCESS;
        goto L6
    }

    private static final RecordMinutesState doFetch$lambda$5(Action r12, List r13, long r14, BottomStatus r16, RecordMinutesState r17) {
        Intrinsics.checkNotNullParameter(r17, "$this$setState");
        PageStatus r7 = PageStatus.SUCCESS;
        return RecordMinutesState.copy$default(r17, new Pair(r12, r13), null, null, r14, r7, r16, null, 70, null);
    }

    public static /* synthetic */ void handleOfflineRecordingUploadFailed$default(RecordMinutesViewModel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.handleOfflineRecordingUploadFailed(r1, r2);
    }

    private static final Unit updateOfflineRecordingUploadProgress$lambda$14(String r5, RecordMinutesViewModel r6, boolean r7, float r8, RecordMinutesState r9) {
        Intrinsics.checkNotNullParameter(r9, "state");
        List r10 = (List) r9.getHistoryList().getSecond();
        Iterator r0 = r10.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((i0) r0.next()).a, r5) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 >= 0) goto L13;
        com.larus.avlink.n1.d(TAG, "update upload progress skipped, item not found, id=" + r5);
        return Unit.INSTANCE;
    L13:
        List r11 = r10;
        final ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L26;
        i0 r3 = (i0) r12.next();
        if (Intrinsics.areEqual(r3.a, r5) == false) goto L25;
        if (r7 == false) goto L20;
        TagType r4 = null;
    L21:
        if (r7 == false) goto L23;
        float r13 = 1.0f;
    L24:
        r3 = i0.a(r3, r4, Float.valueOf(r13), 887);
        goto L25
    L23:
        r13 = r8;
        goto L24
    L20:
        r4 = r3.d;
    L25:
        r2.add(r3);
        goto L15
    L26:
        r6.setState(new g1(r2));
        return Unit.INSTANCE;
    L9:
        r1 = -1;
        goto L10
    }
}
