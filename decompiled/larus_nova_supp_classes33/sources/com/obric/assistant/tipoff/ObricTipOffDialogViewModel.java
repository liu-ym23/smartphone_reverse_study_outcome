package com.obric.assistant.tipoff;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.larus.bmhome.chat.model.repo.IRepoDispatcherService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0088\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0012j\b\u0012\u0004\u0012\u00020\u000e`\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000e2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\u001dR!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/tipoff/ObricTipOffDialogViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "submitEnable", "Landroidx/lifecycle/MutableLiveData;", "", "getSubmitEnable", "()Landroidx/lifecycle/MutableLiveData;", "submitEnable$delegate", "Lkotlin/Lazy;", "requireTipOff", "Lkotlinx/coroutines/Job;", "reportType", "", "entityId", "", "reasonIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasonDetail", "conversationId", "serverIndex", "reportSource", "batchIds", "", "extra", "", "callback", "Lkotlin/Function1;", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTipOffDialogViewModel extends ViewModel {
    private final Lazy submitEnable$delegate;

    /* JADX INFO: renamed from: com.obric.assistant.tipoff.ObricTipOffDialogViewModel$requireTipOff$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.tipoff.ObricTipOffDialogViewModel$requireTipOff$1", f = "ObricTipOffDialogViewModel.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(int r1, String r2, ArrayList<Integer> r3, String r4, String r5, String r6, int r7, List<String> r8, Map<String, String> r9, Function1<? super Integer, Unit> r10, Continuation<? super AnonymousClass1> r11) {
            this.$reportType = r1;
            this.$entityId = r2;
            this.$reasonIds = r3;
            this.$reasonDetail = r4;
            this.$serverIndex = r5;
            this.$conversationId = r6;
            this.$reportSource = r7;
            this.$batchIds = r8;
            this.$extra = r9;
            this.$callback = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            return new AnonymousClass1(this.$reportType, this.$entityId, this.$reasonIds, this.$reasonDetail, this.$serverIndex, this.$conversationId, this.$reportSource, this.$batchIds, this.$extra, this.$callback, r14);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
            Object r1 = r14;
        L13:
            Boolean r2 = (Boolean) r1;
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            IRepoDispatcherService r3 = (IRepoDispatcherService) ServiceManager.get().getService(IRepoDispatcherService.class);
            if (r3 == null) goto L15;
            int r4 = this.$reportType;
            String r5 = this.$entityId;
            ArrayList<Integer> r6 = this.$reasonIds;
            String r7 = this.$reasonDetail;
            String r8 = this.$serverIndex;
            String r9 = this.$conversationId;
            int r10 = this.$reportSource;
            List<String> r11 = this.$batchIds;
            Map<String, String> r13 = this.$extra;
            Function1<Integer, Unit> r15 = this.$callback;
            this.label = 1;
            r1 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r13, r15, this);
            if (r1 != r12) goto L13;
            return r12;
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

    public ObricTipOffDialogViewModel() {
        this.submitEnable$delegate = LazyKt.lazy(new t());
    }

    public final Job requireTipOff(int r17, String r18, ArrayList<Integer> r19, String r20, String r21, String r22, int r23, List<String> r24, Map<String, String> r25, Function1<? super Integer, Unit> r26) {
        Intrinsics.checkNotNullParameter(r18, "entityId");
        Intrinsics.checkNotNullParameter(r19, "reasonIds");
        Intrinsics.checkNotNullParameter(r20, "reasonDetail");
        Intrinsics.checkNotNullParameter(r21, "conversationId");
        Intrinsics.checkNotNullParameter(r22, "serverIndex");
        Intrinsics.checkNotNullParameter(r26, "callback");
        return BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(r17, r18, r19, r20, r22, r21, r23, r24, r25, r26, null), 3, null);
    }
}
