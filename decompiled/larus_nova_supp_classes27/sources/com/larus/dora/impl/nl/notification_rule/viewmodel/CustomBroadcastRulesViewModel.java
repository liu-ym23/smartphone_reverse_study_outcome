package com.larus.dora.impl.nl.notification_rule.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo;
import com.larus.dora.impl.util.r;
import com.larus.network.http.AsyncThrowable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020#J\u000e\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0007J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001aJ\u0014\u0010-\u001a\u00020#2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006J\u001e\u0010/\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\u001aJ\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0014H\u0002J \u00104\u001a\u00020#2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u00108J\f\u00109\u001a\u00020\r*\u000206H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00060\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u001c¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u001c¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001e¨\u0006;"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_rulesList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/dora/api/entity/NotificationRule;", "rulesList", "Lkotlinx/coroutines/flow/StateFlow;", "getRulesList", "()Lkotlinx/coroutines/flow/StateFlow;", "_isLoading", "", "isLoading", "_canAddRule", "canAddRule", "getCanAddRule", "_errorToastRes", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "errorToastRes", "Lkotlinx/coroutines/flow/Flow;", "getErrorToastRes", "()Lkotlinx/coroutines/flow/Flow;", "_clarifiedDesc", "", "clarifiedDesc", "Lkotlinx/coroutines/flow/SharedFlow;", "getClarifiedDesc", "()Lkotlinx/coroutines/flow/SharedFlow;", "_clarifyError", "clarifyError", "getClarifyError", "_actionSuccessEvent", "", "actionSuccessEvent", "getActionSuccessEvent", "loadRules", "clarifyRule", "query", "toggleRuleSelection", "rule", "deleteRule", "ruleId", "createRules", "names", "updateRule", "status", "newName", "checkRuleLimit", "count", "emitError", "exception", "", "defaultResId", "(Ljava/lang/Throwable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isNetworkError", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBroadcastRulesViewModel extends ViewModel {
    public static final a Companion = null;
    private static final long ERROR_CODE_INCOMPLETE_SENTENCE = 3001;
    public static final int MAX_RULES_COUNT = 100;
    private static final String TAG = "CustomBroadcastRulesViewModel";
    private static final long TOAST_DEBOUNCE_INTERVAL = 500;
    private final MutableSharedFlow<Unit> _actionSuccessEvent;
    private final z0<Boolean> _canAddRule;
    private final MutableSharedFlow<List<String>> _clarifiedDesc;
    private final MutableSharedFlow<Integer> _clarifyError;
    private final MutableSharedFlow<Integer> _errorToastRes;
    private final z0<Boolean> _isLoading;
    private final z0<List<NotificationRule>> _rulesList;
    private final d1<Unit> actionSuccessEvent;
    private final i1<Boolean> canAddRule;
    private final d1<List<String>> clarifiedDesc;
    private final d1<Integer> clarifyError;
    private final Flow<Integer> errorToastRes;
    private final i1<Boolean> isLoading;
    private final i1<List<NotificationRule>> rulesList;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$clarifyRule$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$clarifyRule$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {70, 72, 76, 78, 79}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public AnonymousClass1(CustomBroadcastRulesViewModel r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$query = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$query, r4);
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
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L14;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L13;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
        L36:
            MutableSharedFlow r11 = CustomBroadcastRulesViewModel.access$get_clarifyError$p(this.this$0);
            this.label = 5;
            if (r11.emit(null, this) != r0) goto L39;
            return r0;
        L39:
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r10);
            goto L39
        L14:
            ResultKt.throwOnFailure(r10);
            Object r12 = ((Result) r10).unbox-impl();
        L19:
            if (Result.isSuccess-impl(r12) == false) goto L26;
            MutableSharedFlow r2 = CustomBroadcastRulesViewModel.access$get_clarifiedDesc$p(this.this$0);
            List r3 = CollectionsKt.emptyList();
            if (Result.isFailure-impl(r12) == false) goto L23;
            r12 = r3;
        L23:
            this.label = 2;
            if (r2.emit(r12, this) != r0) goto L39;
            return r0;
        L26:
            AsyncThrowable r13 = Result.exceptionOrNull-impl(r12);
            if ((r13 instanceof AsyncThrowable) == true) goto L29;
        L33:
            CustomBroadcastRulesViewModel r4 = this.this$0;
            this.label = 4;
            if (CustomBroadcastRulesViewModel.access$emitError(r4, r13, 2131902256, this) != r0) goto L36;
            return r0;
        L29:
            if (r13.getCode() != CustomBroadcastRulesViewModel.ERROR_CODE_INCOMPLETE_SENTENCE) goto L33;
            MutableSharedFlow r14 = CustomBroadcastRulesViewModel.access$get_clarifyError$p(this.this$0);
            Integer r5 = Boxing.boxInt(2131902255);
            this.label = 3;
            if (r14.emit(r5, this) != r0) goto L39;
            return r0;
        L15:
            ResultKt.throwOnFailure(r10);
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraNotificationRuleRepo r15 = DoraNotificationRuleRepo.a;
            String r6 = this.$query;
            this.label = 1;
            r12 = r15.b(r6, this);
            if (r12 != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$createRules$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$createRules$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {111, 113, 116}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $names;
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public C03611(CustomBroadcastRulesViewModel r1, List<String> r2, Continuation<? super C03611> r3) {
            this.this$0 = r1;
            this.$names = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03611(this.this$0, this.$names, r4);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r6);
        L24:
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r6);
        L20:
            this.this$0.loadRules();
            goto L24
        L11:
            ResultKt.throwOnFailure(r6);
            Object r7 = ((Result) r6).unbox-impl();
        L16:
            if (Result.isSuccess-impl(r7) == false) goto L21;
            MutableSharedFlow r8 = CustomBroadcastRulesViewModel.access$get_actionSuccessEvent$p(this.this$0);
            Unit r2 = Unit.INSTANCE;
            this.label = 2;
            if (r8.emit(r2, this) != r0) goto L20;
            return r0;
        L21:
            CustomBroadcastRulesViewModel r3 = this.this$0;
            Throwable r9 = Result.exceptionOrNull-impl(r7);
            this.label = 3;
            if (CustomBroadcastRulesViewModel.access$emitError(r3, r9, 2131902253, this) != r0) goto L24;
            return r0;
        L12:
            ResultKt.throwOnFailure(r6);
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraNotificationRuleRepo r10 = DoraNotificationRuleRepo.a;
            List<String> r4 = this.$names;
            this.label = 1;
            r7 = r10.c(r4, this);
            if (r7 != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$deleteRule$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$deleteRule$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {99, 103}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $ruleId;
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public C03621(String r1, CustomBroadcastRulesViewModel r2, Continuation<? super C03621> r3) {
            this.$ruleId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03621(this.$ruleId, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L26:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L14:
            if (Result.isSuccess-impl(r6) == false) goto L22;
            Object r2 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r6) == true) goto L20;
            r2 = r6;
        L20:
            if (((Boolean) r2).booleanValue() == false) goto L22;
            this.this$0.loadRules();
        L22:
            CustomBroadcastRulesViewModel r3 = this.this$0;
            Throwable r7 = Result.exceptionOrNull-impl(r6);
            this.label = 2;
            if (CustomBroadcastRulesViewModel.access$emitError(r3, r7, 2131902254, this) != r0) goto L26;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            DoraNotificationRuleRepo r8 = DoraNotificationRuleRepo.a;
            String r4 = this.$ruleId;
            this.label = 1;
            r6 = r8.d(r4, this);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$loadRules$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$loadRules$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {52, 58}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public C03631(CustomBroadcastRulesViewModel r1, Continuation<? super C03631> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03631(this.this$0, r3);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r5);
        L22:
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            Object r6 = ((Result) r5).unbox-impl();
        L14:
            if (Result.isSuccess-impl(r6) == false) goto L19;
            List r2 = CollectionsKt.emptyList();
            if (Result.isFailure-impl(r6) == false) goto L18;
            r6 = r2;
        L18:
            List r7 = (List) r6;
            CustomBroadcastRulesViewModel.access$get_rulesList$p(this.this$0).setValue(r7);
            CustomBroadcastRulesViewModel.access$checkRuleLimit(this.this$0, r7.size());
            goto L22
        L19:
            CustomBroadcastRulesViewModel r3 = this.this$0;
            Throwable r8 = Result.exceptionOrNull-impl(r6);
            this.label = 2;
            if (CustomBroadcastRulesViewModel.access$emitError(r3, r8, 2131900448, this) != r0) goto L22;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraNotificationRuleRepo r9 = DoraNotificationRuleRepo.a;
            this.label = 1;
            r6 = r9.e(this);
            if (r6 != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$toggleRuleSelection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$toggleRuleSelection$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {88, 92}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotificationRule $rule;
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public C03641(NotificationRule r1, CustomBroadcastRulesViewModel r2, Continuation<? super C03641> r3) {
            this.$rule = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03641(this.$rule, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L33:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L21:
            if (Result.isSuccess-impl(r8) == false) goto L29;
            Object r2 = Boxing.boxBoolean(false);
            if (Result.isFailure-impl(r8) == true) goto L27;
            r2 = r8;
        L27:
            if (((Boolean) r2).booleanValue() == false) goto L29;
            this.this$0.loadRules();
        L29:
            CustomBroadcastRulesViewModel r3 = this.this$0;
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            this.label = 2;
            if (CustomBroadcastRulesViewModel.access$emitError(r3, r9, 2131902257, this) != r0) goto L33;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            DoraNotificationRuleRepo r10 = DoraNotificationRuleRepo.a;
            String r4 = this.$rule.getId();
            if (r4 != null) goto L13;
            r4 = "";
        L13:
            Boolean r5 = this.$rule.getStatus();
            if (r5 == null) goto L16;
            boolean r6 = r5.booleanValue();
        L17:
            this.label = 1;
            r8 = r10.f(r4, !r6, null, this);
            if (r8 != r0) goto L21;
            return r0;
        L16:
            r6 = false;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$updateRule$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel$updateRule$1", f = "CustomBroadcastRulesViewModel.kt", i = {}, l = {128, 130, 135, 137, 138}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newName;
        final /* synthetic */ String $ruleId;
        final /* synthetic */ boolean $status;
        int label;
        final /* synthetic */ CustomBroadcastRulesViewModel this$0;

        public C03651(CustomBroadcastRulesViewModel r1, String r2, boolean r3, String r4, Continuation<? super C03651> r5) {
            this.this$0 = r1;
            this.$ruleId = r2;
            this.$status = r3;
            this.$newName = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03651(this.this$0, this.$ruleId, this.$status, this.$newName, r8);
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
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L13;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
        L35:
            MutableSharedFlow r11 = CustomBroadcastRulesViewModel.access$get_clarifyError$p(this.this$0);
            this.label = 5;
            if (r11.emit(null, this) != r0) goto L38;
            return r0;
        L38:
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r10);
            goto L38
        L14:
            ResultKt.throwOnFailure(r10);
        L24:
            this.this$0.loadRules();
            goto L38
        L15:
            ResultKt.throwOnFailure(r10);
            Object r12 = ((Result) r10).unbox-impl();
        L20:
            if (Result.isSuccess-impl(r12) == false) goto L25;
            MutableSharedFlow r13 = CustomBroadcastRulesViewModel.access$get_actionSuccessEvent$p(this.this$0);
            Unit r2 = Unit.INSTANCE;
            this.label = 2;
            if (r13.emit(r2, this) != r0) goto L24;
            return r0;
        L25:
            AsyncThrowable r14 = Result.exceptionOrNull-impl(r12);
            if ((r14 instanceof AsyncThrowable) == true) goto L28;
        L32:
            CustomBroadcastRulesViewModel r3 = this.this$0;
            this.label = 4;
            if (CustomBroadcastRulesViewModel.access$emitError(r3, r14, 2131902257, this) != r0) goto L35;
            return r0;
        L28:
            if (r14.getCode() != CustomBroadcastRulesViewModel.ERROR_CODE_INCOMPLETE_SENTENCE) goto L32;
            MutableSharedFlow r15 = CustomBroadcastRulesViewModel.access$get_clarifyError$p(this.this$0);
            Integer r4 = Boxing.boxInt(2131902255);
            this.label = 3;
            if (r15.emit(r4, this) != r0) goto L38;
            return r0;
        L16:
            ResultKt.throwOnFailure(r10);
            CustomBroadcastRulesViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            DoraNotificationRuleRepo r16 = DoraNotificationRuleRepo.a;
            String r5 = this.$ruleId;
            boolean r7 = this.$status;
            String r8 = this.$newName;
            this.label = 1;
            r12 = r16.f(r5, r7, r8, this);
            if (r12 != r0) goto L20;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public CustomBroadcastRulesViewModel() {
        StateFlowImpl r1 = j1.a(null);
        this._rulesList = r1;
        this.rulesList = e.b(r1);
        StateFlowImpl r2 = j1.a(Boolean.FALSE);
        this._isLoading = r2;
        this.isLoading = e.b(r2);
        StateFlowImpl r3 = j1.a(Boolean.TRUE);
        this._canAddRule = r3;
        this.canAddRule = e.b(r3);
        MutableSharedFlow<Integer> r4 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._errorToastRes = r4;
        this.errorToastRes = r.b(e.a(r4));
        MutableSharedFlow<List<String>> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._clarifiedDesc = r5;
        this.clarifiedDesc = e.a(r5);
        MutableSharedFlow<Integer> r6 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._clarifyError = r6;
        this.clarifyError = e.a(r6);
        MutableSharedFlow<Unit> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionSuccessEvent = r0;
        this.actionSuccessEvent = e.a(r0);
    }

    public final void loadRules() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03631(this, null), 3, null);
    }

    public final d1<Unit> getActionSuccessEvent() {
        return this.actionSuccessEvent;
    }

    public final i1<Boolean> getCanAddRule() {
        return this.canAddRule;
    }

    public final d1<List<String>> getClarifiedDesc() {
        return this.clarifiedDesc;
    }

    public final d1<Integer> getClarifyError() {
        return this.clarifyError;
    }

    public final Flow<Integer> getErrorToastRes() {
        return this.errorToastRes;
    }

    public final i1<List<NotificationRule>> getRulesList() {
        return this.rulesList;
    }

    public final i1<Boolean> isLoading() {
        return this.isLoading;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionSuccessEvent$p(CustomBroadcastRulesViewModel r0) {
        return r0._actionSuccessEvent;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_clarifiedDesc$p(CustomBroadcastRulesViewModel r0) {
        return r0._clarifiedDesc;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_clarifyError$p(CustomBroadcastRulesViewModel r0) {
        return r0._clarifyError;
    }

    public static final /* synthetic */ z0 access$get_isLoading$p(CustomBroadcastRulesViewModel r0) {
        return r0._isLoading;
    }

    public static final /* synthetic */ z0 access$get_rulesList$p(CustomBroadcastRulesViewModel r0) {
        return r0._rulesList;
    }

    private final void checkRuleLimit(int r3) {
        z0<Boolean> r0 = this._canAddRule;
        if (r3 >= 100) goto L5;
        boolean r4 = true;
    L6:
        r0.setValue(Boolean.valueOf(r4));
        return;
    L5:
        r4 = false;
        goto L6
    }

    private final boolean isNetworkError(Throwable r4) {
        if ((r4 instanceof IOException) == true) goto L14;
        String r5 = r4.getMessage();
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L10:
        if (r6 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (StringsKt.contains(r5, "network not available", true) != true) goto L9;
        r6 = true;
        goto L10
    L14:
        return true;
    }

    public final void clarifyRule(String r8) {
        Intrinsics.checkNotNullParameter(r8, "query");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final void createRules(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "names");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03611(this, r8, null), 3, null);
    }

    public final void deleteRule(String r8) {
        Intrinsics.checkNotNullParameter(r8, "ruleId");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03621(r8, this, null), 3, null);
    }

    public final void toggleRuleSelection(NotificationRule r8) {
        Intrinsics.checkNotNullParameter(r8, "rule");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03641(r8, this, null), 3, null);
    }

    public static final /* synthetic */ void access$checkRuleLimit(CustomBroadcastRulesViewModel r0, int r1) {
        r0.checkRuleLimit(r1);
    }

    private final Object emitError(Throwable r3, int r4, Continuation<? super Unit> r5) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L7:
        if (r0 == false) goto L13;
        Object r6 = this._errorToastRes.emit(Boxing.boxInt(2131908080), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r6;
    L12:
        return Unit.INSTANCE;
    L13:
        Object r7 = this._errorToastRes.emit(Boxing.boxInt(r4), r5);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r7;
    L17:
        return Unit.INSTANCE;
    L5:
        if (isNetworkError(r3) != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void updateRule(String r11, boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "ruleId");
        Intrinsics.checkNotNullParameter(r13, "newName");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03651(this, r11, r12, r13, null), 3, null);
    }

    public static final /* synthetic */ Object access$emitError(CustomBroadcastRulesViewModel r0, Throwable r1, int r2, Continuation r3) {
        return r0.emitError(r1, r2, r3);
    }
}
