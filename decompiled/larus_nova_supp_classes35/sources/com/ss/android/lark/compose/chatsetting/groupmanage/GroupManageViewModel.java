package com.ss.android.lark.compose.chatsetting.groupmanage;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.kmp.pb.basic.v1.TnsOpKind;
import com.lark.kmp.rustclient.api.model.RustClientException;
import com.ss.android.lark.compose.chatsetting.common.platform.c;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.ErrorCodes;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020<H\u0002J\u001f\u0010@\u001a\u00020<2\n\u0010A\u001a\u00060Bj\u0002`C2\u0006\u0010D\u001a\u00020\u001c¢\u0006\u0002\u0010EJ\u001f\u0010F\u001a\u00020<2\n\u0010A\u001a\u00060Bj\u0002`C2\u0006\u0010D\u001a\u00020\u001c¢\u0006\u0002\u0010EJ?\u0010G\u001a\u00020<2\n\u0010A\u001a\u00060Bj\u0002`C2\u0006\u0010H\u001a\u00020\u00032\u000e\b\u0002\u0010I\u001a\b\u0012\u0004\u0012\u00020<0J2\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020<0J¢\u0006\u0002\u0010LJ\u0006\u0010M\u001a\u00020<J\u001f\u0010N\u001a\u00020<2\n\u0010A\u001a\u00060Bj\u0002`C2\u0006\u0010O\u001a\u00020\u0003¢\u0006\u0002\u0010PR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u00158F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R+\u0010\"\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u001c8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0014\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R+\u0010&\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0014\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R+\u0010,\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020%8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0014\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R+\u00101\u001a\u0002002\u0006\u0010\u000b\u001a\u0002008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0014\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00107\u001a\u0002002\u0006\u0010\u000b\u001a\u0002008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\u0014\u001a\u0004\b8\u00103\"\u0004\b9\u00105¨\u0006Q"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/groupmanage/GroupManageViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "currentUserId", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;)V", "<set-?>", BuildConfig.FLAVOR, "Lcom/lark/kmp/pb/basic/v1/Chatter;", "adminUsers", "getAdminUsers", "()Ljava/util/List;", "setAdminUsers", "(Ljava/util/List;)V", "adminUsers$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/lark/kmp/pb/basic/v1/Chat;", "chat", "getChat", "()Lcom/lark/kmp/pb/basic/v1/Chat;", "setChat", "(Lcom/lark/kmp/pb/basic/v1/Chat;)V", "chat$delegate", BuildConfig.FLAVOR, "isOwner", "()Z", "setOwner", "(Z)V", "isOwner$delegate", "isQuit", "setQuit", "isQuit$delegate", "Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchState;", "addAndSharePermissionState", "getAddAndSharePermissionState", "()Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchState;", "setAddAndSharePermissionState", "(Lcom/ss/android/lark/compose/foundation/widget/FlowSwitchState;)V", "addAndSharePermissionState$delegate", "editInfoPermissionState", "getEditInfoPermissionState", "setEditInfoPermissionState", "editInfoPermissionState$delegate", BuildConfig.FLAVOR, "addAndSharePermissionResetCount", "getAddAndSharePermissionResetCount", "()I", "setAddAndSharePermissionResetCount", "(I)V", "addAndSharePermissionResetCount$delegate", "editInfoPermissionResetCount", "getEditInfoPermissionResetCount", "setEditInfoPermissionResetCount", "editInfoPermissionResetCount$delegate", "fetchChat", BuildConfig.FLAVOR, "updateChatState", "newChat", "observeQuit", "toggleAddAndSharePermission", "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "onlyOwnerAdmin", "(Landroid/content/Context;Z)V", "toggleEditInfoPermission", "transferOwner", "newOwnerId", "onSuccess", "Lkotlin/Function0;", "onFailure", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "fetchAdminUsers", "routeToProfile", "chatterId", "(Landroid/content/Context;Ljava/lang/String;)V", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupManageViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableState addAndSharePermissionResetCount$delegate;
    private final MutableState addAndSharePermissionState$delegate;
    private final MutableState adminUsers$delegate;
    private final MutableState chat$delegate;
    private final String chatId;
    private final String currentUserId;
    private final MutableState editInfoPermissionResetCount$delegate;
    private final MutableState editInfoPermissionState$delegate;
    private final MutableState isOwner$delegate;
    private final MutableState isQuit$delegate;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$fetchAdminUsers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$fetchAdminUsers$1", f = "GroupManageViewModel.kt", i = {}, l = {ErrorCodes.ERROR_INVALID_APP}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        public AnonymousClass1(GroupManageViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
            Object r5 = ((Result) r4).unbox-impl();
        L11:
            GroupManageViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r5) == false) goto L14;
            GroupManageViewModel.access$setAdminUsers(r2, (List) r5);
        L14:
            Throwable r6 = Result.exceptionOrNull-impl(r5);
            if (r6 == null) goto L20;
            if ((r6 instanceof CancellationException) == true) goto L20;
            int r3 = c8b.a.a;
            c8b.a.a("[GroupManageViewModel.fetchAdminUsers] error: " + r6.getMessage());
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ChatSettingRepository r7 = GroupManageViewModel.access$getRepository$p(this.this$0);
            String r8 = GroupManageViewModel.access$getChatId$p(this.this$0);
            this.label = 1;
            r5 = r7.f(r8, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$fetchChat$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$fetchChat$1", f = "GroupManageViewModel.kt", i = {}, l = {73, 74}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$fetchChat$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GroupManageViewModel a;

            public a(GroupManageViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                GroupManageViewModel r3 = this.a;
                GroupManageViewModel.access$updateChatState(r3, (Chat) r1);
                return Unit.INSTANCE;
            }
        }

        public C03831(GroupManageViewModel r1, Continuation<? super C03831> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03831(this.this$0, r3);
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
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
            ((Result) r5).unbox-impl();
        L13:
            c1 r6 = com.ss.android.lark.compose.chatsetting.common.repository.a.b(GroupManageViewModel.access$getRepository$p(this.this$0), GroupManageViewModel.access$getChatId$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 2;
            if (r6.collect(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            ChatSettingRepository r7 = GroupManageViewModel.access$getRepository$p(this.this$0);
            String r3 = GroupManageViewModel.access$getChatId$p(this.this$0);
            this.label = 1;
            if (r7.o(r3, this) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$observeQuit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$observeQuit$1", f = "GroupManageViewModel.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$observeQuit$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GroupManageViewModel a;

            public a(GroupManageViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                Unit r3 = (Unit) r1;
                GroupManageViewModel.access$setQuit(this.a, true);
                return Unit.INSTANCE;
            }
        }

        public C03841(GroupManageViewModel r1, Continuation<? super C03841> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03841(this.this$0, r3);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            c1 r6 = com.ss.android.lark.compose.chatsetting.common.repository.a.c(GroupManageViewModel.access$getRepository$p(this.this$0), GroupManageViewModel.access$getChatId$p(this.this$0), GroupManageViewModel.access$getCurrentUserId$p(this.this$0));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$toggleAddAndSharePermission$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$toggleAddAndSharePermission$1", f = "GroupManageViewModel.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat.AddMemberPermission.Enum $addPermission;
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $oldState;
        final /* synthetic */ Chat.ShareCardPermission.Enum $sharePermission;
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        public C03851(GroupManageViewModel r1, Chat.AddMemberPermission.Enum r2, Chat.ShareCardPermission.Enum r3, Context r4, com.ss.android.lark.compose.foundation.widget.a r5, Continuation<? super C03851> r6) {
            this.this$0 = r1;
            this.$addPermission = r2;
            this.$sharePermission = r3;
            this.$context = r4;
            this.$oldState = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new C03851(this.this$0, this.$addPermission, this.$sharePermission, this.$context, this.$oldState, r9);
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
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            GroupManageViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L14;
            GroupManageViewModel.access$updateChatState(r2, (Chat) r7);
        L14:
            GroupManageViewModel r3 = this.this$0;
            Context r4 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r5 = this.$oldState;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L20;
            if ((r8 instanceof CancellationException) == true) goto L20;
            int r9 = c8b.a.a;
            c8b.a.a("[GroupManageViewModel.toggleAddAndSharePermission] error: " + r8.getMessage());
            GroupManageViewModel.access$getPlatformEffects$p(r3).m(r4, r8);
            GroupManageViewModel.access$setAddAndSharePermissionState(r3, r5);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ChatSettingRepository r10 = GroupManageViewModel.access$getRepository$p(this.this$0);
            String r11 = GroupManageViewModel.access$getChatId$p(this.this$0);
            Chat.AddMemberPermission.Enum r12 = this.$addPermission;
            Chat.ShareCardPermission.Enum r13 = this.$sharePermission;
            this.label = 1;
            r7 = r10.p(r11, r12, r13, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$toggleEditInfoPermission$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$toggleEditInfoPermission$1", f = "GroupManageViewModel.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ com.ss.android.lark.compose.foundation.widget.a $oldState;
        final /* synthetic */ boolean $onlyOwnerAdmin;
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        public C03861(GroupManageViewModel r1, boolean r2, Context r3, com.ss.android.lark.compose.foundation.widget.a r4, Continuation<? super C03861> r5) {
            this.this$0 = r1;
            this.$onlyOwnerAdmin = r2;
            this.$context = r3;
            this.$oldState = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C03861(this.this$0, this.$onlyOwnerAdmin, this.$context, this.$oldState, r8);
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
            Object r7 = ((Result) r6).unbox-impl();
        L11:
            GroupManageViewModel r2 = this.this$0;
            if (Result.isSuccess-impl(r7) == false) goto L14;
            GroupManageViewModel.access$updateChatState(r2, (Chat) r7);
        L14:
            GroupManageViewModel r3 = this.this$0;
            Context r4 = this.$context;
            com.ss.android.lark.compose.foundation.widget.a r5 = this.$oldState;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L20;
            if ((r8 instanceof CancellationException) == true) goto L20;
            int r9 = c8b.a.a;
            c8b.a.a("[GroupManageViewModel.toggleEditInfoPermission] error: " + r8.getMessage());
            GroupManageViewModel.access$getPlatformEffects$p(r3).m(r4, r8);
            GroupManageViewModel.access$setEditInfoPermissionState(r3, r5);
        L20:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ChatSettingRepository r10 = GroupManageViewModel.access$getRepository$p(this.this$0);
            String r11 = GroupManageViewModel.access$getChatId$p(this.this$0);
            boolean r12 = this.$onlyOwnerAdmin;
            this.label = 1;
            r7 = r10.q(r11, r12, this);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$transferOwner$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageViewModel$transferOwner$3", f = "GroupManageViewModel.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $newOwnerId;
        final /* synthetic */ Function0<Unit> $onFailure;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ GroupManageViewModel this$0;

        public AnonymousClass3(GroupManageViewModel r1, String r2, Function0<Unit> r3, Context r4, Function0<Unit> r5, Continuation<? super AnonymousClass3> r6) {
            this.this$0 = r1;
            this.$newOwnerId = r2;
            this.$onSuccess = r3;
            this.$context = r4;
            this.$onFailure = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass3(this.this$0, this.$newOwnerId, this.$onSuccess, this.$context, this.$onFailure, r9);
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
            GroupManageViewModel r2 = this.this$0;
            Function0<Unit> r3 = this.$onSuccess;
            if (Result.isSuccess-impl(r8) == false) goto L14;
            GroupManageViewModel.access$updateChatState(r2, (Chat) r8);
            r3.invoke();
        L14:
            GroupManageViewModel r4 = this.this$0;
            Context r5 = this.$context;
            Function0<Unit> r6 = this.$onFailure;
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L47;
            if ((r9 instanceof CancellationException) == true) goto L47;
            int r10 = c8b.a.a;
            c8b.a.a("[GroupManageViewModel.transferOwner] error: " + r9.getMessage());
            Chat r11 = r4.getChat();
            if (r11 == null) goto L27;
            Chat.TnsInfo r12 = r11.getTns_info();
            if (r12 == null) goto L27;
            TnsOpKind r13 = r12.getOp_kind();
            if (r13 == null) goto L27;
            if (r13.getValue() != TnsOpKind.TNS_OP_BANNED.getValue()) goto L27;
            boolean r14 = true;
        L28:
            if (r14 == false) goto L45;
            String r15 = null;
            if ((r9 instanceof RustClientException) == false) goto L32;
            RustClientException r16 = (RustClientException) r9;
        L33:
            if (r16 == null) goto L37;
            LarkError r17 = r16.getRustError();
            if (r17 == null) goto L37;
            r15 = r17.getDisplay_message();
        L37:
            if (r15 != null) goto L39;
            r15 = BuildConfig.FLAVOR;
        L39:
            GroupManageViewModel.access$getPlatformEffects$p(r4).m(r5, r9);
            if ((!StringsKt.isBlank(r15)) == false) goto L42;
            GroupManageViewModel.access$getPlatformEffects$p(r4).n(r5, new c.j(r15));
        L44:
            return Unit.INSTANCE;
        L42:
            r6.invoke();
            goto L44
        L32:
            r16 = null;
            goto L33
        L45:
            r6.invoke();
        L27:
            r14 = false;
        L47:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            ChatSettingRepository r18 = GroupManageViewModel.access$getRepository$p(this.this$0);
            String r19 = GroupManageViewModel.access$getChatId$p(this.this$0);
            String r20 = this.$newOwnerId;
            this.label = 1;
            r8 = r18.r(r19, r20, this);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    private final void fetchChat() {
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03831(this, null), 3, null);
    }

    public final void fetchAdminUsers() {
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final int getAddAndSharePermissionResetCount() {
        return ((Number) this.addAndSharePermissionResetCount$delegate.getValue()).intValue();
    }

    public final com.ss.android.lark.compose.foundation.widget.a getAddAndSharePermissionState() {
        return (com.ss.android.lark.compose.foundation.widget.a) this.addAndSharePermissionState$delegate.getValue();
    }

    public final List<Chatter> getAdminUsers() {
        return (List) this.adminUsers$delegate.getValue();
    }

    public final Chat getChat() {
        return (Chat) this.chat$delegate.getValue();
    }

    public final int getEditInfoPermissionResetCount() {
        return ((Number) this.editInfoPermissionResetCount$delegate.getValue()).intValue();
    }

    public final com.ss.android.lark.compose.foundation.widget.a getEditInfoPermissionState() {
        return (com.ss.android.lark.compose.foundation.widget.a) this.editInfoPermissionState$delegate.getValue();
    }

    public final boolean isOwner() {
        return ((Boolean) this.isOwner$delegate.getValue()).booleanValue();
    }

    public final boolean isQuit() {
        return ((Boolean) this.isQuit$delegate.getValue()).booleanValue();
    }

    private final void observeQuit() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03841(this, null), 3, null);
    }

    public static final /* synthetic */ String access$getChatId$p(GroupManageViewModel r0) {
        return r0.chatId;
    }

    public static final /* synthetic */ String access$getCurrentUserId$p(GroupManageViewModel r0) {
        return r0.currentUserId;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(GroupManageViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(GroupManageViewModel r0) {
        return r0.repository;
    }

    private final void setAddAndSharePermissionResetCount(int r2) {
        this.addAndSharePermissionResetCount$delegate.setValue(Integer.valueOf(r2));
    }

    private final void setAddAndSharePermissionState(com.ss.android.lark.compose.foundation.widget.a r2) {
        this.addAndSharePermissionState$delegate.setValue(r2);
    }

    private final void setAdminUsers(List<Chatter> r2) {
        this.adminUsers$delegate.setValue(r2);
    }

    private final void setChat(Chat r2) {
        this.chat$delegate.setValue(r2);
    }

    private final void setEditInfoPermissionResetCount(int r2) {
        this.editInfoPermissionResetCount$delegate.setValue(Integer.valueOf(r2));
    }

    private final void setEditInfoPermissionState(com.ss.android.lark.compose.foundation.widget.a r2) {
        this.editInfoPermissionState$delegate.setValue(r2);
    }

    private final void setOwner(boolean r2) {
        this.isOwner$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void setQuit(boolean r2) {
        this.isQuit$delegate.setValue(Boolean.valueOf(r2));
    }

    private final void updateChatState(Chat r5) {
        setChat(r5);
        this.platformEffects.h(r5);
        boolean r3 = true;
        if (r5.getAdd_member_permission() == Chat.AddMemberPermission.Enum.ALL_MEMBERS) goto L5;
    L7:
        boolean r0 = false;
    L8:
        setAddAndSharePermissionState(new com.ss.android.lark.compose.foundation.widget.a(!r0, false));
        Boolean r1 = r5.getOff_edit_group_chat_info();
        if (r1 == null) goto L11;
        r3 = r1.booleanValue();
    L11:
        setEditInfoPermissionState(new com.ss.android.lark.compose.foundation.widget.a(r3, false));
        setOwner(Intrinsics.areEqual(r5.getOwner_id(), this.currentUserId));
        fetchAdminUsers();
        return;
    L5:
        if (r5.getShare_card_permission() != Chat.ShareCardPermission.Enum.ALLOWED) goto L7;
        r0 = true;
        goto L8
    }

    public static final /* synthetic */ void access$setAddAndSharePermissionState(GroupManageViewModel r0, com.ss.android.lark.compose.foundation.widget.a r1) {
        r0.setAddAndSharePermissionState(r1);
    }

    public static final /* synthetic */ void access$setAdminUsers(GroupManageViewModel r0, List r1) {
        r0.setAdminUsers(r1);
    }

    public static final /* synthetic */ void access$setEditInfoPermissionState(GroupManageViewModel r0, com.ss.android.lark.compose.foundation.widget.a r1) {
        r0.setEditInfoPermissionState(r1);
    }

    public static final /* synthetic */ void access$setQuit(GroupManageViewModel r0, boolean r1) {
        r0.setQuit(r1);
    }

    public static final /* synthetic */ void access$updateChatState(GroupManageViewModel r0, Chat r1) {
        r0.updateChatState(r1);
    }

    public final void routeToProfile(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        int r0 = d8b.a.a;
        d8b.a.c(r2, this.chatId, r3);
    }

    public final void toggleAddAndSharePermission(Context r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r14, "context");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        com.ss.android.lark.compose.foundation.widget.a r6 = getAddAndSharePermissionState();
        setAddAndSharePermissionState(new com.ss.android.lark.compose.foundation.widget.a(r15, true));
        if (this.platformEffects.a(r14, ChatSettingFunction.GROUP_MANAGE) == false) goto L9;
        setAddAndSharePermissionState(r6);
        setAddAndSharePermissionResetCount(getAddAndSharePermissionResetCount() + 1);
        return;
    L9:
        if (r15 == false) goto L11;
        Chat.AddMemberPermission.Enum r0 = Chat.AddMemberPermission.Enum.ONLY_OWNER;
    L12:
        Chat.AddMemberPermission.Enum r3 = r0;
        if (r15 == false) goto L15;
        Chat.ShareCardPermission.Enum r16 = Chat.ShareCardPermission.Enum.NOT_ALLOWED;
    L16:
        Chat.ShareCardPermission.Enum r4 = r16;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03851(this, r3, r4, r14, r6, null), 3, null);
        return;
    L15:
        r16 = Chat.ShareCardPermission.Enum.ALLOWED;
        goto L16
    L11:
        r0 = Chat.AddMemberPermission.Enum.ALL_MEMBERS;
        goto L12
    }

    public final void toggleEditInfoPermission(Context r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        com.ss.android.lark.compose.foundation.widget.a r5 = getEditInfoPermissionState();
        setEditInfoPermissionState(new com.ss.android.lark.compose.foundation.widget.a(r12, true));
        if (this.platformEffects.a(r11, ChatSettingFunction.GROUP_MANAGE) == false) goto L9;
        setEditInfoPermissionState(r5);
        setEditInfoPermissionResetCount(getEditInfoPermissionResetCount() + 1);
        return;
    L9:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03861(this, r12, r11, r5, null), 3, null);
    }

    public GroupManageViewModel(String r2, String r3, ChatSettingRepository r4, com.ss.android.lark.compose.chatsetting.common.platform.b r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "currentUserId");
        Intrinsics.checkNotNullParameter(r4, "repository");
        Intrinsics.checkNotNullParameter(r5, "platformEffects");
        this.chatId = r2;
        this.currentUserId = r3;
        this.repository = r4;
        this.platformEffects = r5;
        this.adminUsers$delegate = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
        this.chat$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        Boolean r6 = Boolean.FALSE;
        this.isOwner$delegate = SnapshotStateKt.mutableStateOf$default(r6, null, 2, null);
        this.isQuit$delegate = SnapshotStateKt.mutableStateOf$default(r6, null, 2, null);
        this.addAndSharePermissionState$delegate = SnapshotStateKt.mutableStateOf$default(new com.ss.android.lark.compose.foundation.widget.a(false, false), null, 2, null);
        this.editInfoPermissionState$delegate = SnapshotStateKt.mutableStateOf$default(new com.ss.android.lark.compose.foundation.widget.a(false, false), null, 2, null);
        this.addAndSharePermissionResetCount$delegate = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        this.editInfoPermissionResetCount$delegate = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        fetchChat();
        fetchAdminUsers();
        observeQuit();
    }

    public final void transferOwner(Context r12, String r13, Function0<Unit> r14, Function0<Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "newOwnerId");
        Intrinsics.checkNotNullParameter(r14, "onSuccess");
        Intrinsics.checkNotNullParameter(r15, "onFailure");
        if (StringsKt.isBlank(this.chatId) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r13) == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(this, r13, r14, r12, r15, null), 3, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void transferOwner$default(GroupManageViewModel r0, Context r1, String r2, Function0 r3, Function0 r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = C03871.INSTANCE;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = AnonymousClass2.INSTANCE;
    L8:
        r0.transferOwner(r1, r2, r3, r4);
    }
}
