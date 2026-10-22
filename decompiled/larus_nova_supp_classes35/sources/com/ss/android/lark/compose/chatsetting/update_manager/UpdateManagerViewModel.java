package com.ss.android.lark.compose.chatsetting.update_manager;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.im.v1.PatchChatAdminUsersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/update_manager/UpdateManagerViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_adminLoaded", "adminLoaded", "getAdminLoaded", "_currentAdminIds", BuildConfig.FLAVOR, "currentAdminIds", "getCurrentAdminIds", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/update_manager/UpdateManagerViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "fetchCurrentAdmins", BuildConfig.FLAVOR, "updateAdmins", "selectedAdminIds", "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateManagerViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _adminLoaded;
    private final z0<Set<String>> _currentAdminIds;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final i1<Boolean> adminLoaded;
    private final String chatId;
    private final i1<Set<String>> currentAdminIds;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$a$a, reason: collision with other inner class name */
        public static final class C0142a extends a {
            public static final C0142a a = null;

            static {
                a = new C0142a();
            }

            public C0142a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$fetchCurrentAdmins$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$fetchCurrentAdmins$1", f = "UpdateManagerViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public AnonymousClass1(UpdateManagerViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
            Object r8 = ((Result) r7).unbox-impl();
        L11:
            UpdateManagerViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r8) == false) goto L18;
            z0 r3 = UpdateManagerViewModel.access$get_currentAdminIds$p(r2);
            List r4 = (List) r8;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = r4.iterator();
        L15:
            if (r6.hasNext() == false) goto L17;
            r5.add(((Chatter) r6.next()).getId());
            goto L15
        L17:
            r3.setValue(CollectionsKt.toSet(r5));
            UpdateManagerViewModel.access$get_adminLoaded$p(r2).setValue(Boxing.boxBoolean(true));
        L18:
            UpdateManagerViewModel r9 = this.this$0;
            Throwable r10 = Result.exceptionOrNull-impl(r8);
            if (r10 == null) goto L24;
            if ((r10 instanceof CancellationException) == true) goto L24;
            UpdateManagerViewModel.access$get_currentAdminIds$p(r9).setValue(SetsKt.emptySet());
            UpdateManagerViewModel.access$get_adminLoaded$p(r9).setValue(Boxing.boxBoolean(true));
        L24:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ChatSettingRepository r11 = UpdateManagerViewModel.access$getRepository$p(this.this$0);
            String r12 = UpdateManagerViewModel.access$getChatId$p(this.this$0);
            this.label = 1;
            r8 = r11.f(r12, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$1", f = "UpdateManagerViewModel.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public C03991(UpdateManagerViewModel r1, Continuation<? super C03991> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03991(this.this$0, r3);
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
            MutableSharedFlow r5 = UpdateManagerViewModel.access$get_actionEvent$p(this.this$0);
            a.b r2 = a.b.a;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.update_manager.UpdateManagerViewModel$updateAdmins$2", f = "UpdateManagerViewModel.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $selectedAdminIds;
        final /* synthetic */ List<String> $toAdd;
        final /* synthetic */ List<String> $toDel;
        int label;
        final /* synthetic */ UpdateManagerViewModel this$0;

        public AnonymousClass2(UpdateManagerViewModel r1, List<String> r2, List<String> r3, Set<String> r4, Continuation<? super AnonymousClass2> r5) {
            this.this$0 = r1;
            this.$toAdd = r2;
            this.$toDel = r3;
            this.$selectedAdminIds = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass2(this.this$0, this.$toAdd, this.$toDel, this.$selectedAdminIds, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
            Object r13 = ((Result) r12).unbox-impl();
        L11:
            UpdateManagerViewModel r2 = this.this$0;
            Set<String> r3 = this.$selectedAdminIds;
            if (Result.isSuccess-impl(r13) == false) goto L14;
            PatchChatAdminUsersResponse r4 = (PatchChatAdminUsersResponse) r13;
            UpdateManagerViewModel.access$get_loading$p(r2).setValue(Boxing.boxBoolean(false));
            UpdateManagerViewModel.access$get_currentAdminIds$p(r2).setValue(r3);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r2), null, null, new UpdateManagerViewModel$updateAdmins$2$1$1(r2, null), 3, null);
        L14:
            UpdateManagerViewModel r5 = this.this$0;
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L20;
            if ((r14 instanceof CancellationException) == true) goto L20;
            UpdateManagerViewModel.access$get_loading$p(r5).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r5), null, null, new UpdateManagerViewModel$updateAdmins$2$2$1(r5, null), 3, null);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            UpdateManagerViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r15 = UpdateManagerViewModel.access$getRepository$p(this.this$0);
            String r6 = UpdateManagerViewModel.access$getChatId$p(this.this$0);
            List<String> r7 = this.$toAdd;
            List<String> r8 = this.$toDel;
            this.label = 1;
            r13 = r15.l(r6, r7, r8, this);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    private final void fetchCurrentAdmins() {
        if (StringsKt.isBlank(this.chatId) == false) goto L6;
        this._adminLoaded.setValue(Boolean.TRUE);
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getAdminLoaded() {
        return this.adminLoaded;
    }

    public final i1<Set<String>> getCurrentAdminIds() {
        return this.currentAdminIds;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(UpdateManagerViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(UpdateManagerViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(UpdateManagerViewModel r0) {
        return r0._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_adminLoaded$p(UpdateManagerViewModel r0) {
        return r0._adminLoaded;
    }

    public static final /* synthetic */ z0 access$get_currentAdminIds$p(UpdateManagerViewModel r0) {
        return r0._currentAdminIds;
    }

    public static final /* synthetic */ z0 access$get_loading$p(UpdateManagerViewModel r0) {
        return r0._loading;
    }

    public final void updateAdmins(Set<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "selectedAdminIds");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        Set r0 = (Set) this._currentAdminIds.getValue();
        List r4 = CollectionsKt.toList(SetsKt.minus(r13, r0));
        List r5 = CollectionsKt.toList(SetsKt.minus(r0, r13));
        if (r4.isEmpty() == true) goto L8;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, r4, r5, r13, null), 3, null);
        return;
    L8:
        if (r5.isEmpty() == false) goto L11;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03991(this, null), 3, null);
    }

    public UpdateManagerViewModel(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        this.chatId = r2;
        this.repository = new ChatSettingRepository(r3);
        Boolean r4 = Boolean.FALSE;
        StateFlowImpl r5 = j1.a(r4);
        this._loading = r5;
        this.loading = e.b(r5);
        StateFlowImpl r6 = j1.a(r4);
        this._adminLoaded = r6;
        this.adminLoaded = e.b(r6);
        StateFlowImpl r7 = j1.a(SetsKt.emptySet());
        this._currentAdminIds = r7;
        this.currentAdminIds = e.b(r7);
        MutableSharedFlow<a> r8 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionEvent = r8;
        this.actionEvent = e.a(r8);
        fetchCurrentAdmins();
    }
}
