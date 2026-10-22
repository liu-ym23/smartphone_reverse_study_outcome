package com.larus.bmhome.tipoff;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.obric.assistant.spi.feedback.FeedbackServiceDelegate;
import com.obric.assistant.spi.feedback.IFeedbackService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0088\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0014j\b\u0012\u0004\u0012\u00020\u0010`\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020 0\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/larus/bmhome/tipoff/TipOffDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "repo", "Lcom/larus/bmhome/tipoff/TipOffRepo;", "submitEnable", "Landroidx/lifecycle/MutableLiveData;", "", "getSubmitEnable", "()Landroidx/lifecycle/MutableLiveData;", "submitEnable$delegate", "Lkotlin/Lazy;", "requireTipOff", "Lkotlinx/coroutines/Job;", "reportType", "", "entityId", "", "reasonIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasonDetail", "conversationId", "serverIndex", "reportSource", "batchIds", "", "extra", "", "callback", "Lkotlin/Function1;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TipOffDialogViewModel extends ViewModel {
    private final TipOffRepo repo;
    private final Lazy submitEnable$delegate;

    /* JADX INFO: renamed from: com.larus.bmhome.tipoff.TipOffDialogViewModel$requireTipOff$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.tipoff.TipOffDialogViewModel$requireTipOff$1", f = "TipOffDialogViewModel.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $batchIds;
        final /* synthetic */ Function1<Integer, Unit> $callback;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ String $entityId;
        final /* synthetic */ Map<String, String> $extra;
        final /* synthetic */ String $reasonDetail;
        final /* synthetic */ ArrayList<Integer> $reasonIds;
        final /* synthetic */ int $reportSource;
        final /* synthetic */ int $reportType;
        final /* synthetic */ String $serverIndex;
        int label;
        final /* synthetic */ TipOffDialogViewModel this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(TipOffDialogViewModel r1, int r2, String r3, ArrayList<Integer> r4, String r5, String r6, String r7, int r8, List<String> r9, Map<String, String> r10, Function1<? super Integer, Unit> r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r1;
            this.$reportType = r2;
            this.$entityId = r3;
            this.$reasonIds = r4;
            this.$reasonDetail = r5;
            this.$serverIndex = r6;
            this.$conversationId = r7;
            this.$reportSource = r8;
            this.$batchIds = r9;
            this.$extra = r10;
            this.$callback = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r14, Continuation<?> r15) {
            return new AnonymousClass1(this.this$0, this.$reportType, this.$entityId, this.$reasonIds, this.$reasonDetail, this.$serverIndex, this.$conversationId, this.$reportSource, this.$batchIds, this.$extra, this.$callback, r15);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L11:
            FeedbackServiceDelegate r3 = FeedbackServiceDelegate.b;
            ArrayList<Integer> r4 = this.$reasonIds;
            String r5 = this.$reasonDetail;
            List<String> r16 = this.$batchIds;
            if (r16 != null) goto L14;
        L17:
            if (r2 == false) goto L19;
            List<String> r17 = CollectionsKt.listOf(this.$entityId);
        L20:
            IFeedbackService.a.a(r3, r4, r5, null, r17, Boxing.boxInt(this.$reportType), 34);
            return Unit.INSTANCE;
        L19:
            r17 = this.$batchIds;
            goto L20
        L14:
            if (r16.isEmpty() == true) goto L17;
            r2 = false;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            TipOffRepo r18 = TipOffDialogViewModel.access$getRepo$p(this.this$0);
            int r6 = this.$reportType;
            String r7 = this.$entityId;
            ArrayList<Integer> r8 = this.$reasonIds;
            String r9 = this.$reasonDetail;
            String r10 = this.$serverIndex;
            String r11 = this.$conversationId;
            int r12 = this.$reportSource;
            List<String> r13 = this.$batchIds;
            Map<String, String> r14 = this.$extra;
            Function1<Integer, Unit> r19 = this.$callback;
            this.label = 1;
            r18.getClass();
            if (TipOffRepo.a(r6, r7, r8, r9, r10, r11, r12, r13, r14, r19, this) != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ MutableLiveData yo() {
        return submitEnable_delegate$lambda$0();
    }

    private static final MutableLiveData submitEnable_delegate$lambda$0() {
        return new MutableLiveData(Boolean.FALSE);
    }

    public final MutableLiveData<Boolean> getSubmitEnable() {
        return (MutableLiveData) this.submitEnable$delegate.getValue();
    }

    public TipOffDialogViewModel() {
        RepoDispatcher.a.getClass();
        this.repo = RepoDispatcher.h;
        this.submitEnable$delegate = LazyKt.lazy(new i());
    }

    public static final /* synthetic */ TipOffRepo access$getRepo$p(TipOffDialogViewModel r0) {
        return r0.repo;
    }

    public final Job requireTipOff(int r18, String r19, ArrayList<Integer> r20, String r21, String r22, String r23, int r24, List<String> r25, Map<String, String> r26, Function1<? super Integer, Unit> r27) {
        Intrinsics.checkNotNullParameter(r19, "entityId");
        Intrinsics.checkNotNullParameter(r20, "reasonIds");
        Intrinsics.checkNotNullParameter(r21, "reasonDetail");
        Intrinsics.checkNotNullParameter(r22, "conversationId");
        Intrinsics.checkNotNullParameter(r23, "serverIndex");
        Intrinsics.checkNotNullParameter(r27, "callback");
        return BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, r18, r19, r20, r21, r23, r22, r24, r25, r26, r27, null), 3, null);
    }
}
