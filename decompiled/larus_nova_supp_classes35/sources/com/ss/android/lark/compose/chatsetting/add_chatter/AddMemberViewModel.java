package com.ss.android.lark.compose.chatsetting.add_chatter;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.pb.im.v1.AddChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.ss.android.lark.feed.app.entity.RankConstants;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/add_chatter/AddMemberViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "<init>", "(Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;)V", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "loading", "Lkotlinx/coroutines/flow/StateFlow;", "getLoading", "()Lkotlinx/coroutines/flow/StateFlow;", "_actionEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/chatsetting/add_chatter/AddMemberViewModel$ActionEvent;", "actionEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getActionEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "addMembers", BuildConfig.FLAVOR, "chatterIds", BuildConfig.FLAVOR, "ActionEvent", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddMemberViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<a> _actionEvent;
    private final z0<Boolean> _loading;
    private final d1<a> actionEvent;
    private final String chatId;
    private final i1<Boolean> loading;
    private final ChatSettingRepository repository;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$a$a, reason: collision with other inner class name */
        public static final class C0126a extends a {
            public static final C0126a a = null;

            static {
                a = new C0126a();
            }

            public C0126a() {
            }
        }

        public static final class b extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public final String toString() {
                return "OverLimit(message=" + this.a + ')';
            }

            public b(String r1) {
                this.a = r1;
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$addMembers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.add_chatter.AddMemberViewModel$addMembers$1", f = "AddMemberViewModel.kt", i = {}, l = {RankConstants.PRIORITY_FILTER_ITEM, 46, 48, 53}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $chatterIds;
        Object L$0;
        int label;
        final /* synthetic */ AddMemberViewModel this$0;

        public AnonymousClass1(AddMemberViewModel r1, List<String> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$chatterIds = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$chatterIds, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L13;
            if (r2 == 1) goto L12;
            if (r2 == 2) goto L11;
            if (r2 == 3) goto L11;
            if (r2 == 4) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r18);
        L48:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r18);
            Object r3 = ((Result) r18).unbox-impl();
        L16:
            AddMemberViewModel r6 = this.this$0;
            String r8 = null;
            int r9 = 0;
            if (Result.isSuccess-impl(r3) == false) goto L19;
            AddChatChattersResponse r7 = (AddChatChattersResponse) r3;
            AddMemberViewModel.access$get_loading$p(r6).setValue(Boxing.boxBoolean(false));
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r6), null, null, new AddMemberViewModel$addMembers$1$1$1(r6, null), 3, null);
        L19:
            AddMemberViewModel r10 = this.this$0;
            RustClientException r11 = Result.exceptionOrNull-impl(r3);
            if (r11 == null) goto L48;
            AddMemberViewModel.access$get_loading$p(r10).setValue(Boxing.boxBoolean(false));
            if ((r11 instanceof RustClientException) == false) goto L42;
            RustClientException r12 = r11;
            LarkError r4 = r12.getRustError();
            if (r4 == null) goto L28;
            Integer r5 = r4.getCode();
            if (r5 == null) goto L28;
            r9 = r5.intValue();
        L28:
            LarkError r13 = r12.getRustError();
            if (r13 == null) goto L32;
            r8 = r13.getDisplay_message();
        L32:
            if (r9 != 4013) goto L34;
        L38:
            MutableSharedFlow r14 = AddMemberViewModel.access$get_actionEvent$p(r10);
            a.b r15 = new a.b(r8);
            this.L$0 = r3;
            this.label = 2;
            if (r14.emit(r15, this) != r1) goto L48;
            return r1;
        L34:
            if (r9 == 6002) goto L38;
            MutableSharedFlow r16 = AddMemberViewModel.access$get_actionEvent$p(r10);
            a.C0126a r17 = a.C0126a.a;
            this.L$0 = r3;
            this.label = 3;
            if (r16.emit(r17, this) != r1) goto L48;
            return r1;
        L42:
            if ((r11 instanceof CancellationException) == true) goto L48;
            MutableSharedFlow r19 = AddMemberViewModel.access$get_actionEvent$p(r10);
            a.C0126a r20 = a.C0126a.a;
            this.L$0 = r3;
            this.label = 4;
            if (r19.emit(r20, this) != r1) goto L48;
            return r1;
        L13:
            ResultKt.throwOnFailure(r18);
            AddMemberViewModel.access$get_loading$p(this.this$0).setValue(Boxing.boxBoolean(true));
            ChatSettingRepository r21 = AddMemberViewModel.access$getRepository$p(this.this$0);
            String r22 = AddMemberViewModel.access$getChatId$p(this.this$0);
            List<String> r23 = this.$chatterIds;
            this.label = 1;
            r3 = r21.a(r22, r23, this);
            if (r3 != r1) goto L16;
            return r1;
        }
    }

    public final d1<a> getActionEvent() {
        return this.actionEvent;
    }

    public final i1<Boolean> getLoading() {
        return this.loading;
    }

    public static final /* synthetic */ String access$getChatId$p(AddMemberViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(AddMemberViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionEvent$p(AddMemberViewModel r0) {
        return r0._actionEvent;
    }

    public static final /* synthetic */ z0 access$get_loading$p(AddMemberViewModel r0) {
        return r0._loading;
    }

    public final void addMembers(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "chatterIds");
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public AddMemberViewModel(String r2, d r3) {
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
}
