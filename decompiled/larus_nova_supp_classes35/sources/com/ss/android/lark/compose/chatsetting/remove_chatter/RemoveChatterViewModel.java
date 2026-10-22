package com.ss.android.lark.compose.chatsetting.remove_chatter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.im.v1.DeleteChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/remove_chatter/RemoveChatterViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/remove_chatter/RemoveChatterViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "removeMembers", BuildConfig.FLAVOR, "chatterIds", BuildConfig.FLAVOR, "withdraw", "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveChatterViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final String chatId;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$a$a, reason: collision with other inner class name */
        public static final class C0139a extends a {
            public static final C0139a a = null;

            static {
                a = new C0139a();
            }

            public C0139a() {
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

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$removeMembers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.remove_chatter.RemoveChatterViewModel$removeMembers$1", f = "RemoveChatterViewModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $chatterIds;
        final /* synthetic */ boolean $withdraw;
        int label;
        final /* synthetic */ RemoveChatterViewModel this$0;

        public AnonymousClass1(RemoveChatterViewModel r1, Set<String> r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$chatterIds = r2;
            this.$withdraw = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$chatterIds, this.$withdraw, r5);
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
            RemoveChatterViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r13) == false) goto L14;
            DeleteChatChattersResponse r3 = (DeleteChatChattersResponse) r13;
            RemoveChatterViewModel.access$get_loading$p(r2).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r2), null, null, new RemoveChatterViewModel$removeMembers$1$1$1(r2, null), 3, null);
        L14:
            RemoveChatterViewModel r4 = this.this$0;
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L20;
            if ((r14 instanceof CancellationException) == true) goto L20;
            RemoveChatterViewModel.access$get_loading$p(r4).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r4), null, null, new RemoveChatterViewModel$removeMembers$1$2$1(r4, null), 3, null);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            RemoveChatterViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r15 = RemoveChatterViewModel.access$getRepository$p(this.this$0);
            String r5 = RemoveChatterViewModel.access$getChatId$p(this.this$0);
            List<String> r6 = CollectionsKt.toList(this.$chatterIds);
            boolean r7 = this.$withdraw;
            this.label = 1;
            r13 = r15.n(r5, r6, r7, this);
            if (r13 != r0) goto L11;
            return r0;
        }
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(RemoveChatterViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(RemoveChatterViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(RemoveChatterViewModel r0) {
        return r0._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_loading$p(RemoveChatterViewModel r0) {
        return r0._loading;
    }

    public RemoveChatterViewModel(String r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "rustClient");
        this.chatId = r2;
        this.repository = new ChatSettingRepository(r3);
        StateFlowImpl r4 = j1.a(Boolean.FALSE);
        this._loading = r4;
        this.loading = e.b(r4);
        MutableSharedFlow<a> r5 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionEvent = r5;
        this.actionEvent = e.a(r5);
    }

    public final void removeMembers(Set<String> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "chatterIds");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        if (r8.isEmpty() == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
        return;
    }

    public static /* synthetic */ void removeMembers$default(RemoveChatterViewModel r0, Set r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.removeMembers(r1, r2);
    }
}
