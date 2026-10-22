package com.larus.common.account.bdauth.viewmodel;

import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.common.account.bdauth.repository.BDAuthorizeAccountIssueType;
import com.larus.common.account.bdauth.repository.BDAuthorizeBlockingErrorType;
import com.larus.common.account.bdauth.repository.BDAuthorizeRepository;
import com.larus.common.account.bdauth.repository.m;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u0014J\u001a\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u0014J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020\u001fJ\u0010\u0010*\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010(J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0014J\u000e\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u001fJ\u0006\u00106\u001a\u00020\u001fJ\u0006\u00107\u001a\u00020\u001fJ\"\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020\u0014H\u0002J\u001c\u0010=\u001a\u0004\u0018\u00010(2\u0006\u0010;\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010(H\u0002J*\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u0010;\u001a\u00020<2\b\u0010B\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010\"\u001a\u00020\u0014H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010(2\u0006\u0010D\u001a\u00020\u0019H\u0002J\u0016\u0010E\u001a\u00020\u001f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00190@H\u0002J\u0010\u0010G\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002J!\u0010H\u001a\u00020\u001f2\u0017\u0010I\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0J¢\u0006\u0002\bKH\u0002J\u0010\u0010L\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010M\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u001b0\u001b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006N"}, d2 = {"Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeRepository;", "<init>", "(Lcom/larus/common/account/bdauth/repository/BDAuthorizeRepository;)V", "_uiState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeUiState;", "kotlin.jvm.PlatformType", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState", "()Landroidx/lifecycle/LiveData;", "_effect", "Lcom/larus/common/account/bdauth/viewmodel/Event;", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeEffect;", "effect", "getEffect", "isCanceled", "", "refreshAccountsJob", "Lkotlinx/coroutines/Job;", "latestAccounts", "", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeAccount;", "addAccountStage", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeAddAccountStage;", "getAddAccountStage", "()Landroidx/lifecycle/MutableLiveData;", "start", "", "request", "Lcom/bytedance/sdk/account/common/model/SendAuth$Request;", "suppressAccountSelection", "refreshAccounts", "forceRemote", "needPreferredSecUserId", "onAccountClicked", "secUserId", "", "onAddAccountClicked", "submit", "cancel", "cancelCode", "", "cancelDesc", "onLoginFailed", "failed", "onBlockingErrorConfirmed", "error", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeBlockingError;", "onPrivacyDenied", "onAccountOffline", "addAccountSuccess", "addAccountFailed", "applyPrepareData", "authInfoResponse", "Lcom/bytedance/sdk/account/bdplatform/model/AuthInfoResponseV2;", "snapshot", "Lcom/larus/common/account/bdauth/repository/BDAuthorizeAccountSnapshot;", "resolveSelectedAccountSecUserId", "preferredSecUserId", "buildAccountItems", "", "Lcom/larus/common/account/bdauth/viewmodel/BDAuthorizeListItemUiModel;", "selectedSecUserId", "buildSubtitle", "account", "updateLatestAccounts", "newAccounts", "updateSelection", "updateState", "reducer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "emitIfActive", "emitEffect", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BDAuthorizeViewModel extends ViewModel {
    private final MutableLiveData<l<b>> _effect;
    private final MutableLiveData<d> _uiState;
    private final MutableLiveData<BDAuthorizeAddAccountStage> addAccountStage;
    private final LiveData<l<b>> effect;
    private boolean isCanceled;
    private final List<com.larus.common.account.bdauth.repository.a> latestAccounts;
    private Job refreshAccountsJob;
    private final BDAuthorizeRepository repository;
    private final LiveData<d> uiState;

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$cancel$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$cancel$2", f = "BDAuthorizeViewModel.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cancelDesc;
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public AnonymousClass2(BDAuthorizeViewModel r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$cancelDesc = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$cancelDesc, r4);
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
        L19:
            BDAuthorizeViewModel.access$getRepository$p(this.this$0).getClass();
            fb7.d r7 = new fb7.d();
            ((fb7.b) r7).a = -2;
            ((fb7.b) r7).b = this.$cancelDesc;
            BDAuthorizeViewModel.access$emitEffect(this.this$0, new b.d(r7));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            if (this.this$0.getAddAccountStage().getValue() != BDAuthorizeAddAccountStage.Completed) goto L19;
            BDAuthorizeRepository r8 = BDAuthorizeViewModel.access$getRepository$p(this.this$0);
            this.label = 1;
            com.larus.common.account.bdauth.repository.a r2 = r8.f;
            if (r2 == null) goto L16;
            FLogger.a.d("BDAuthorizeRepository", "1. [restoreOriginalAccount]: restoreOriginalAccount B->A = " + r2);
            Object r9 = r8.g(r2, r8.c.a(), this);
            if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
            r9 = Unit.INSTANCE;
        L17:
            if (r9 != r0) goto L19;
            return r0;
        L16:
            r9 = Unit.INSTANCE;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onAccountOffline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onAccountOffline$1", f = "BDAuthorizeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public AnonymousClass1(BDAuthorizeViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            BDAuthorizeViewModel r5 = this.this$0;
            BDAuthorizeViewModel.access$getRepository$p(r5).getClass();
            fb7.d r1 = new fb7.d();
            ((fb7.b) r1).a = -1004;
            ((fb7.b) r1).b = null;
            BDAuthorizeViewModel.access$emitEffect(r5, new b.e(r1));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onBlockingErrorConfirmed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onBlockingErrorConfirmed$1", f = "BDAuthorizeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.common.account.bdauth.repository.d $error;
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public C01481(BDAuthorizeViewModel r1, com.larus.common.account.bdauth.repository.d r2, Continuation<? super C01481> r3) {
            this.this$0 = r1;
            this.$error = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01481(this.this$0, this.$error, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L15;
            ResultKt.throwOnFailure(r4);
            BDAuthorizeViewModel r5 = this.this$0;
            BDAuthorizeRepository r1 = BDAuthorizeViewModel.access$getRepository$p(r5);
            com.larus.common.account.bdauth.repository.d r2 = this.$error;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "error");
            BDAuthorizeBlockingErrorType r3 = r2.getType();
            int r6 = BDAuthorizeRepository.b.a[r3.ordinal()];
            if (r6 != 1) goto L7;
            fb7.d r7 = new fb7.d();
            ((fb7.b) r7).a = -1002;
            ((fb7.b) r7).b = "minor_mode";
        L12:
            BDAuthorizeViewModel.access$emitEffect(r5, new b.e(r7));
            return Unit.INSTANCE;
        L7:
            if (r6 != 2) goto L10;
            r7 = new fb7.d();
            ((fb7.b) r7).a = -1005;
            ((fb7.b) r7).b = "enterprise account not allow";
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onPrivacyDenied$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$onPrivacyDenied$1", f = "BDAuthorizeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public C01491(BDAuthorizeViewModel r1, Continuation<? super C01491> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01491(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            BDAuthorizeViewModel r5 = this.this$0;
            BDAuthorizeViewModel.access$getRepository$p(r5).getClass();
            fb7.d r1 = new fb7.d();
            ((fb7.b) r1).a = -1003;
            ((fb7.b) r1).b = "privacy not allow";
            BDAuthorizeViewModel.access$emitEffect(r5, new b.e(r1));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$refreshAccounts$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$refreshAccounts$1", f = "BDAuthorizeViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $forceRemote;
        final /* synthetic */ boolean $needPreferredSecUserId;
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public C01501(BDAuthorizeViewModel r1, boolean r2, boolean r3, Continuation<? super C01501> r4) {
            this.this$0 = r1;
            this.$forceRemote = r2;
            this.$needPreferredSecUserId = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01501(this.this$0, this.$forceRemote, this.$needPreferredSecUserId, r5);
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
            final com.larus.common.account.bdauth.repository.c r6 = (com.larus.common.account.bdauth.repository.c) r5;
            BDAuthorizeViewModel.access$updateLatestAccounts(this.this$0, r6.a);
            if (this.$needPreferredSecUserId == false) goto L16;
            d r2 = (d) this.this$0.getUiState().getValue();
            if (r2 == null) goto L16;
            final String r3 = r2.e;
        L17:
            final BDAuthorizeViewModel r4 = this.this$0;
            BDAuthorizeViewModel.access$updateState(r4, new j(r4, r6, r3));
            return Unit.INSTANCE;
        L16:
            r3 = null;
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            BDAuthorizeRepository r7 = BDAuthorizeViewModel.access$getRepository$p(this.this$0);
            boolean r8 = this.$forceRemote;
            this.label = 1;
            r7.getClass();
            r5 = r7.b(AccountService.a.isLogin().booleanValue(), ((Boolean) r7.d.getValue()).booleanValue(), r8, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$start$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$start$2", f = "BDAuthorizeViewModel.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01512 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ fb7.c $request;
        final /* synthetic */ boolean $suppressAccountSelection;
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public C01512(BDAuthorizeViewModel r1, fb7.c r2, boolean r3, Continuation<? super C01512> r4) {
            this.this$0 = r1;
            this.$request = r2;
            this.$suppressAccountSelection = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C01512(this.this$0, this.$request, this.$suppressAccountSelection, r5);
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
            com.larus.common.account.bdauth.repository.f r7 = (com.larus.common.account.bdauth.repository.f) r6;
            if ((r7 instanceof com.larus.common.account.bdauth.repository.f.c) == false) goto L15;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, b.C0007b.a);
        L32:
            return Unit.INSTANCE;
        L15:
            if ((r7 instanceof com.larus.common.account.bdauth.repository.f.a) == false) goto L18;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, new b.i(((com.larus.common.account.bdauth.repository.f.a) r7).a));
            goto L32
        L18:
            if ((r7 instanceof com.larus.common.account.bdauth.repository.f.b) == false) goto L21;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, new b.e(((com.larus.common.account.bdauth.repository.f.b) r7).a));
            goto L32
        L21:
            if ((r7 instanceof com.larus.common.account.bdauth.repository.f.d) == false) goto L34;
            com.larus.common.account.bdauth.repository.f.d r8 = (com.larus.common.account.bdauth.repository.f.d) r7;
            BDAuthorizeViewModel.access$updateLatestAccounts(this.this$0, r8.a.b.a);
            if (BDAuthorizeViewModel.access$isCanceled$p(this.this$0) == true) goto L32;
            BDAuthorizeViewModel r2 = this.this$0;
            com.larus.common.account.bdauth.repository.e r3 = r8.a;
            BDAuthorizeViewModel.access$applyPrepareData(r2, r3.a, r3.b, this.$suppressAccountSelection);
            com.larus.common.account.bdauth.repository.c r9 = r8.a.b;
            if (r9.d == false) goto L32;
            if (r9.e == false) goto L32;
            if (this.$suppressAccountSelection == true) goto L32;
            BDAuthorizeViewModel.refreshAccounts$default(this.this$0, true, false, 2, null);
            goto L32
        L34:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            BDAuthorizeRepository r10 = BDAuthorizeViewModel.access$getRepository$p(this.this$0);
            fb7.c r4 = this.$request;
            this.label = 1;
            r6 = r10.e(r4, this);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$submit$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.viewmodel.BDAuthorizeViewModel$submit$2", f = "BDAuthorizeViewModel.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ fb7.c $request;
        int label;
        final /* synthetic */ BDAuthorizeViewModel this$0;

        public C01522(BDAuthorizeViewModel r1, fb7.c r2, Continuation<? super C01522> r3) {
            this.this$0 = r1;
            this.$request = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01522(this.this$0, this.$request, r4);
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
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L20:
            m r9 = (m) r8;
            if ((r9 instanceof m.c) == false) goto L24;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, b.C0007b.a);
        L32:
            BDAuthorizeViewModel.access$updateState(this.this$0, new k());
            return Unit.INSTANCE;
        L24:
            if ((r9 instanceof m.a) == false) goto L27;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, new b.g(((m.a) r9).a));
            goto L32
        L27:
            if ((r9 instanceof m.b) == false) goto L30;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, new b.e(((m.b) r9).a));
            goto L32
        L30:
            if ((r9 instanceof m.d) == false) goto L35;
            BDAuthorizeViewModel.access$emitIfActive(this.this$0, new b.f(((m.d) r9).a));
            goto L32
        L35:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            List r10 = BDAuthorizeViewModel.access$getLatestAccounts$p(this.this$0);
            BDAuthorizeViewModel r2 = this.this$0;
            Iterator r11 = r10.iterator();
        L9:
            Object r4 = null;
            if (r11.hasNext() == false) goto L17;
            Object r3 = r11.next();
            String r5 = ((com.larus.common.account.bdauth.repository.a) r3).b;
            d r6 = (d) r2.getUiState().getValue();
            if (r6 == null) goto L15;
            r4 = r6.e;
        L15:
            if (Intrinsics.areEqual(r5, r4) == false) goto L9;
            r4 = r3;
        L17:
            BDAuthorizeRepository r12 = BDAuthorizeViewModel.access$getRepository$p(this.this$0);
            fb7.c r7 = this.$request;
            this.label = 1;
            r8 = r12.j(r7, (com.larus.common.account.bdauth.repository.a) r4, this);
            if (r8 != r0) goto L20;
            return r0;
        }
    }

    public static /* synthetic */ d Mo(boolean r0, com.larus.common.account.bdauth.repository.c r1, BDAuthorizeViewModel r2, za7.c r3, d r4) {
        return applyPrepareData$lambda$4(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ d No(d r0) {
        return cancel$lambda$3(r0);
    }

    public static /* synthetic */ d Oo(d r0) {
        return submit$lambda$2(r0);
    }

    public static /* synthetic */ d Po(d r0) {
        return start$lambda$0(r0);
    }

    public static /* synthetic */ d yo(String r0, d r1) {
        return updateSelection$lambda$9(r0, r1);
    }

    public final void addAccountSuccess() {
        refreshAccounts$default(this, false, false, 2, null);
        this.addAccountStage.setValue(BDAuthorizeAddAccountStage.Completed);
    }

    public final void addAccountFailed() {
        this.addAccountStage.setValue(BDAuthorizeAddAccountStage.Failed);
    }

    public final void onAddAccountClicked() {
        BDAuthorizeAddAccountStage r0 = (BDAuthorizeAddAccountStage) this.addAccountStage.getValue();
        if (r0 != null) goto L6;
        r0 = BDAuthorizeAddAccountStage.Idle;
    L6:
        if (r0.isInProgress() == false) goto L8;
        return;
    L8:
        this.addAccountStage.setValue(BDAuthorizeAddAccountStage.OpeningLoginPanel);
        emitEffect(b.c.a);
    }

    public final void onAccountOffline() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onPrivacyDenied() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01491(this, null), 3, null);
    }

    public final MutableLiveData<BDAuthorizeAddAccountStage> getAddAccountStage() {
        return this.addAccountStage;
    }

    public final LiveData<l<b>> getEffect() {
        return this.effect;
    }

    public final LiveData<d> getUiState() {
        return this.uiState;
    }

    public BDAuthorizeViewModel(BDAuthorizeRepository r3) {
        Intrinsics.checkNotNullParameter(r3, "repository");
        this.repository = r3;
        MutableLiveData<d> r4 = new MutableLiveData(new d(0));
        this._uiState = r4;
        this.uiState = r4;
        MutableLiveData<l<b>> r5 = new MutableLiveData();
        this._effect = r5;
        this.effect = r5;
        this.latestAccounts = new ArrayList();
        this.addAccountStage = new MutableLiveData(BDAuthorizeAddAccountStage.Idle);
    }

    public static final /* synthetic */ List access$getLatestAccounts$p(BDAuthorizeViewModel r0) {
        return r0.latestAccounts;
    }

    public static final /* synthetic */ BDAuthorizeRepository access$getRepository$p(BDAuthorizeViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ boolean access$isCanceled$p(BDAuthorizeViewModel r0) {
        return r0.isCanceled;
    }

    private final String buildSubtitle(com.larus.common.account.bdauth.repository.a r2) {
        if (r2.f == true) goto L10;
        String r3 = r2.a;
        if (r3 == null) goto L8;
        StringsKt.isBlank(r3);
    L8:
        return null;
    L10:
        return r2.e;
    }

    private static final d cancel$lambda$3(d r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$updateState");
        return d.a(r10, null, false, null, null, false, false, false, 253);
    }

    private final void emitEffect(b r3) {
        l r0 = new l(r3);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        this._effect.setValue(r0);
        return;
    L5:
        this._effect.postValue(r0);
    }

    private final void emitIfActive(b r2) {
        if (this.isCanceled == true) goto L6;
        emitEffect(r2);
        return;
    }

    private static final d start$lambda$0(d r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$updateState");
        if (r10.c != null) goto L5;
        BDAuthorizePageMode r0 = BDAuthorizePageMode.Loading;
    L7:
        return d.a(r10, r0, false, null, null, false, false, false, 252);
    L5:
        r0 = BDAuthorizePageMode.Content;
        goto L7
    }

    private static final d submit$lambda$2(d r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$updateState");
        return d.a(r10, null, true, null, null, false, false, false, 253);
    }

    private final void updateLatestAccounts(List<com.larus.common.account.bdauth.repository.a> r2) {
        this.latestAccounts.clear();
        this.latestAccounts.addAll(r2);
    }

    private final void updateSelection(final String r2) {
        updateState(new i(r2));
    }

    private final void updateState(Function1<? super d, d> r3) {
        d r0 = (d) this._uiState.getValue();
        if (r0 != null) goto L5;
        r0 = new d(0);
    L5:
        d r4 = (d) r3.invoke(r0);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        this._uiState.setValue(r4);
        return;
    L8:
        this._uiState.postValue(r4);
    }

    public final void onAccountClicked(String r4) {
        Intrinsics.checkNotNullParameter(r4, "secUserId");
        Iterator<T> r0 = this.latestAccounts.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.larus.common.account.bdauth.repository.a) r1).b, r4) == false) goto L4;
    L9:
        com.larus.common.account.bdauth.repository.a r2 = (com.larus.common.account.bdauth.repository.a) r1;
        if (r2 != null) goto L12;
        return;
    L12:
        emitEffect(new b.a(r2));
        if (r2.f == false) goto L16;
        emitEffect(new b.g(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.EnterpriseUnsupported, r2)));
        return;
    L16:
        if (r2.g == true) goto L18;
        emitEffect(new b.g(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r2)));
        return;
    L18:
        emitEffect(new b.h(r2));
        updateSelection(r4);
        return;
    L8:
        r1 = null;
        goto L9
    }

    public final void onBlockingErrorConfirmed(com.larus.common.account.bdauth.repository.d r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01481(this, r8, null), 3, null);
    }

    public final void onLoginFailed(boolean r2) {
        if (r2 == false) goto L4;
        int r0 = -30;
    L5:
        if (r2 == false) goto L7;
        String r3 = "login fail";
    L8:
        cancel(r0, r3);
        return;
    L7:
        r3 = "cancel login";
        goto L8
    L4:
        r0 = -31;
        goto L5
    }

    public final void submit(fb7.c r8) {
        this.isCanceled = false;
        updateState(new e());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01522(this, r8, null), 3, null);
    }

    public static final /* synthetic */ void access$emitEffect(BDAuthorizeViewModel r0, b r1) {
        r0.emitEffect(r1);
    }

    public static final /* synthetic */ void access$emitIfActive(BDAuthorizeViewModel r0, b r1) {
        r0.emitIfActive(r1);
    }

    public static final /* synthetic */ void access$updateLatestAccounts(BDAuthorizeViewModel r0, List r1) {
        r0.updateLatestAccounts(r1);
    }

    public static final /* synthetic */ void access$updateState(BDAuthorizeViewModel r0, Function1 r1) {
        r0.updateState(r1);
    }

    private final String resolveSelectedAccountSecUserId(com.larus.common.account.bdauth.repository.c r4, String r5) {
        if (r5 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L24;
        Iterator<T> r1 = r4.a.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((com.larus.common.account.bdauth.repository.a) r2).b, r5) == false) goto L11;
    L16:
        com.larus.common.account.bdauth.repository.a r3 = (com.larus.common.account.bdauth.repository.a) r2;
        if (r3 == null) goto L24;
        if (r3.g == false) goto L24;
        if (r3.f == true) goto L24;
        return r5;
    L15:
        r2 = null;
    L24:
        return r4.b;
    L4:
        if (StringsKt.isBlank(r5) == true) goto L7;
        r0 = false;
        goto L8
    }

    private static final d updateSelection$lambda$9(String r16, d r17) {
        Intrinsics.checkNotNullParameter(r17, "$this$updateState");
        List<c> r1 = r17.d;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        c r4 = (c) r2.next();
        if ((r4 instanceof c.a) == false) goto L9;
        a r5 = ((c.a) r4).a;
        boolean r13 = Intrinsics.areEqual(r5.b, r16);
        String r7 = r5.a;
        String r8 = r5.b;
        String r9 = r5.c;
        String r10 = r5.d;
        String r11 = r5.e;
        boolean r12 = r5.f;
        boolean r14 = r5.h;
        boolean r15 = r5.i;
        Intrinsics.checkNotNullParameter(r8, "secUserId");
        Intrinsics.checkNotNullParameter(r9, "displayName");
        a r6 = new a(r7, r8, r9, r10, r11, r12, r13, r14, r15);
        Intrinsics.checkNotNullParameter(r6, "item");
        r4 = new c.a(r6);
    L9:
        r3.add(r4);
        goto L4
    L11:
        return d.a(r17, null, false, r3, r16, false, false, false, 231);
    }

    public final void cancel(int r7, String r8) {
        if (this.isCanceled == false) goto L5;
        return;
    L5:
        this.isCanceled = true;
        updateState(new g());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r8, null), 3, null);
    }

    public final void refreshAccounts(boolean r10, boolean r11) {
        Job r0 = this.refreshAccountsJob;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.refreshAccountsJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01501(this, r10, r11, null), 3, null);
    }

    public final void start(fb7.c r8, boolean r9) {
        this.isCanceled = false;
        updateState(new h());
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01512(this, r8, r9, null), 3, null);
    }

    public static final /* synthetic */ String access$resolveSelectedAccountSecUserId(BDAuthorizeViewModel r0, com.larus.common.account.bdauth.repository.c r1, String r2) {
        return r0.resolveSelectedAccountSecUserId(r1, r2);
    }

    private final void applyPrepareData(final za7.c r2, final com.larus.common.account.bdauth.repository.c r3, final boolean r4) {
        updateState(new f(r4, r3, this, r2));
    }

    private final List<c> buildAccountItems(com.larus.common.account.bdauth.repository.c r18, String r110, boolean r20) {
        BDAuthorizeViewModel r0 = this;
        if (r20 == false) goto L9;
        List<com.larus.common.account.bdauth.repository.a> r1 = r18.a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        com.larus.common.account.bdauth.repository.a r3 = (com.larus.common.account.bdauth.repository.a) r2.next();
        r4.add(new c.C0008c(new a(r3.a, r3.b, r3.c, r0.buildSubtitle(r3), r3.d, r3.h, Intrinsics.areEqual(r3.b, r110), r3.f, r3.g)));
        r2 = r2;
        goto L6
    L8:
        return r4;
    L9:
        List<com.larus.common.account.bdauth.repository.a> r5 = r18.a;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L14;
        com.larus.common.account.bdauth.repository.a r8 = (com.larus.common.account.bdauth.repository.a) r7.next();
        r6.add(new c.a(new a(r8.a, r8.b, r8.c, r0.buildSubtitle(r8), r8.d, r8.h, Intrinsics.areEqual(r8.b, r110), r8.f, r8.g)));
        r0 = this;
        goto L11
    L14:
        if (r18.c == true) goto L16;
        return r6;
    L16:
        return CollectionsKt.plus(r6, new c.b(0));
    }

    public static final /* synthetic */ void access$applyPrepareData(BDAuthorizeViewModel r0, za7.c r1, com.larus.common.account.bdauth.repository.c r2, boolean r3) {
        r0.applyPrepareData(r1, r2, r3);
    }

    private static final d applyPrepareData$lambda$4(boolean r10, com.larus.common.account.bdauth.repository.c r11, BDAuthorizeViewModel r12, za7.c r13, d r14) {
        Intrinsics.checkNotNullParameter(r14, "$this$updateState");
        if (r10 == false) goto L5;
        List<com.larus.common.account.bdauth.repository.a> r2 = r11.a;
        boolean r5 = r11.d;
        boolean r6 = r11.e;
        Intrinsics.checkNotNullParameter(r2, "accounts");
        r11 = new com.larus.common.account.bdauth.repository.c(r2, null, false, r5, r6);
    L5:
        if (r10 == false) goto L7;
        String r0 = null;
    L8:
        String r7 = r0;
        BDAuthorizePageMode r3 = BDAuthorizePageMode.Content;
        List<c> r8 = r12.buildAccountItems(r11, r7, r10);
        boolean r9 = r11.e;
        boolean r15 = r11.c;
        boolean r16 = r11.d;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r3, "pageMode");
        Intrinsics.checkNotNullParameter(r8, "accountItems");
        return new d(r3, false, r13, r8, r7, r9, r15, r16);
    L7:
        r0 = r12.resolveSelectedAccountSecUserId(r11, r14.e);
        goto L8
    }

    public static /* synthetic */ void refreshAccounts$default(BDAuthorizeViewModel r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        r0.refreshAccounts(r1, r2);
    }

    public static /* synthetic */ void start$default(BDAuthorizeViewModel r0, fb7.c r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.start(r1, r2);
    }

    public static /* synthetic */ void applyPrepareData$default(BDAuthorizeViewModel r0, za7.c r1, com.larus.common.account.bdauth.repository.c r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.applyPrepareData(r1, r2, r3);
    }

    public static /* synthetic */ List buildAccountItems$default(BDAuthorizeViewModel r0, com.larus.common.account.bdauth.repository.c r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.buildAccountItems(r1, r2, r3);
    }
}
