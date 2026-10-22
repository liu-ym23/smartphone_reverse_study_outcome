package com.ss.android.lark.compose.chatsetting.main.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.kmp.pb.im.v1.GetChatChattersResponse;
import com.lark.kmp.pb.im.v1.PushChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.compose.chat_member_list.FlowChatMembersListActivity;
import com.ss.android.lark.compose.chatsetting.common.platform.AndroidChatSettingPlatformEffects;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.ss.android.lark.compose.chatsetting.report.ChatSettingFunction;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0017\u0010\u001d\u001a\u00020\u001a2\n\u0010\u001e\u001a\u00060\u001fj\u0002` ¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u001a2\n\u0010\u001e\u001a\u00060\u001fj\u0002` ¢\u0006\u0002\u0010!J\u0017\u0010#\u001a\u00020\u001a2\n\u0010\u001e\u001a\u00060\u001fj\u0002` ¢\u0006\u0002\u0010!J\u001f\u0010$\u001a\u00020\u001a2\n\u0010\u001e\u001a\u00060\u001fj\u0002` 2\u0006\u0010%\u001a\u00020\u0003¢\u0006\u0002\u0010&J\u001f\u0010'\u001a\u00020(2\n\u0010\u001e\u001a\u00060\u001fj\u0002` 2\u0006\u0010)\u001a\u00020*¢\u0006\u0002\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/main/viewmodel/GroupMembersViewModel;", "Landroidx/lifecycle/ViewModel;", "userId", BuildConfig.FLAVOR, "chatId", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;)V", "getUserId", "()Ljava/lang/String;", "getChatId", "getRustClient", "()Lcom/lark/kmp/rustclient/api/IRustClient;", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "viewModelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/chatsetting/main/viewmodel/GroupMembersState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "fetchAndObserveChat", BuildConfig.FLAVOR, "fetchChatters", "observeChatters", "routeToMembersList", "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "(Landroid/content/Context;)V", "routeToAddMember", "routeToRemoveMember", "routeToProfile", "chatterId", "(Landroid/content/Context;Ljava/lang/String;)V", "checkFunctionDisableAndShowDialog", BuildConfig.FLAVOR, "function", "Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;", "(Landroid/content/Context;Lcom/ss/android/lark/compose/chatsetting/report/ChatSettingFunction;)Z", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupMembersViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final String chatId;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;
    private final d rustClient;
    private final i1<c> uiState;
    private final String userId;
    private final z0<c> viewModelState;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$fetchAndObserveChat$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$fetchAndObserveChat$1", f = "GroupMembersViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$fetchAndObserveChat$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GroupMembersViewModel a;

            public a(GroupMembersViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r11, Continuation r12) {
                Chat r13 = (Chat) r11;
                z0 r14 = GroupMembersViewModel.access$getViewModelState$p(this.a);
                GroupMembersViewModel r0 = this.a;
            L3:
                Object r1 = r14.getValue();
                c r2 = (c) r1;
                Chat.Type r4 = r13.getType();
                if (r4 != null) goto L6;
                r4 = Chat.Type.P2P;
            L6:
                boolean r5 = Intrinsics.areEqual(r0.getUserId(), r13.getOwner_id());
                Boolean r6 = r13.is_admin();
                int r7 = 0;
                if (r6 == null) goto L9;
                boolean r8 = r6.booleanValue();
            L10:
                Integer r9 = r13.getUser_count();
                if (r9 == null) goto L13;
                r7 = r9.intValue();
            L13:
                Boolean r10 = r13.is_user_count_visible();
                if (r10 == null) goto L16;
                boolean r15 = r10.booleanValue();
            L18:
                if (r14.compareAndSet(r1, c.a(r2, null, r4, r5, r8, r7, r15, 1)) == false) goto L3;
                GroupMembersViewModel.access$getPlatformEffects$p(this.a).h(r13);
                return Unit.INSTANCE;
            L16:
                r15 = true;
                goto L18
            L9:
                r8 = false;
                goto L10
            }
        }

        public AnonymousClass1(GroupMembersViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            c1 r6 = com.ss.android.lark.compose.chatsetting.common.repository.a.b(GroupMembersViewModel.access$getRepository$p(this.this$0), this.this$0.getChatId());
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$fetchChatters$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$fetchChatters$1", f = "GroupMembersViewModel.kt", i = {}, l = {86, 90}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupMembersViewModel this$0;

        public C03951(GroupMembersViewModel r1, Continuation<? super C03951> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03951(this.this$0, r3);
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
            Object r8 = ((Result) r7).unbox-impl();
        L16:
            a(r8, this.this$0);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
            Object r9 = ((Result) r7).unbox-impl();
        L13:
            a(r9, this.this$0);
            ChatSettingRepository r10 = GroupMembersViewModel.access$getRepository$p(this.this$0);
            String r2 = this.this$0.getChatId();
            this.label = 2;
            r8 = r10.g(r2, true, 20, this);
            if (r8 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r7);
            ChatSettingRepository r11 = GroupMembersViewModel.access$getRepository$p(this.this$0);
            String r3 = this.this$0.getChatId();
            this.label = 1;
            r9 = r11.g(r3, false, 20, this);
            if (r9 != r0) goto L13;
            return r0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.util.ArrayList] */
        public static final void a(Object r9, GroupMembersViewModel r10) {
            if (Result.isSuccess-impl(r9) == false) goto L37;
            GetChatChattersResponse r11 = (GetChatChattersResponse) r9;
            String r0 = r10.getChatId();
            Intrinsics.checkNotNullParameter(r11, "<this>");
            Intrinsics.checkNotNullParameter(r0, "chatId");
            Entity.ChatChatter r1 = (Entity.ChatChatter) r11.getEntity().getChat_chatters().get(r0);
            if (r1 == null) goto L27;
            Map r2 = r1.getChatters();
            if (r2 == null) goto L27;
            List r3 = CollectionsKt.createListBuilder();
            List r4 = r11.getLetter_maps();
            if (r4 == null) goto L18;
            Iterator r5 = r4.iterator();
        L13:
            if (r5.hasNext() == false) goto L18;
            List r6 = ((GetChatChattersResponse.LetterMap) r5.next()).getChatter_ids();
            if (r6 != null) goto L17;
            r6 = CollectionsKt.emptyList();
        L17:
            r3.addAll(r6);
        L18:
            List r12 = r11.getChatter_ids();
            if (r12 != null) goto L21;
            r12 = CollectionsKt.emptyList();
        L21:
            r3.addAll(r12);
            List r13 = CollectionsKt.distinct(CollectionsKt.build(r3));
            ?? r7 = new ArrayList();
            Iterator r14 = r13.iterator();
        L23:
            if (r14.hasNext() == false) goto L28;
            Chatter r8 = (Chatter) r2.get((String) r14.next());
            if (r8 == null) goto L23;
            r7.add(r8);
        L28:
            r9 = new ArrayList();
            Iterator r15 = ((Iterable) r7).iterator();
        L30:
            if (r15.hasNext() == false) goto L37;
            Object r16 = r15.next();
            if (((Chatter) r16).getType() == Chatter.Type.BOT) goto L34;
            boolean r17 = true;
        L35:
            if (r17 == false) goto L30;
            r9.add(r16);
            goto L30
        L34:
            r17 = false;
        L27:
            r7 = CollectionsKt.emptyList();
        L37:
            Object r18 = Result.constructor-impl(r9);
            if (Result.isSuccess-impl(r18) == false) goto L42;
            List r19 = (List) r18;
            z0 r110 = GroupMembersViewModel.access$getViewModelState$p(r10);
        L40:
            Object r20 = r110.getValue();
            if (r110.compareAndSet(r20, c.a((c) r20, r19, null, false, false, 0, false, 62)) == false) goto L40;
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$1", f = "GroupMembersViewModel.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GroupMembersViewModel a;

            /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$1$a$a, reason: collision with other inner class name */
            public /* synthetic */ class C0134a {
                public static final /* synthetic */ int[] a = null;

                static {
                    int[] r0 = new int[PushChatChattersResponse.Type.values().length];
                    r0[PushChatChattersResponse.Type.ADD_CHATTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[PushChatChattersResponse.Type.DELETE_CHATTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[PushChatChattersResponse.Type.DELETE_ME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[PushChatChattersResponse.Type.UPDATE_CHATTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    a = r0;
                }
            }

            public a(GroupMembersViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r12, Continuation r13) {
                PushChatChattersResponse r14 = (PushChatChattersResponse) r12;
                Entity r15 = r14.getEntity();
                if (r15 == null) goto L65;
                Map r16 = r15.getChat_chatters();
                if (r16 == null) goto L65;
                Entity.ChatChatter r17 = (Entity.ChatChatter) r16.get(this.a.getChatId());
                if (r17 == null) goto L65;
                Map r18 = r17.getChatters();
                if (r18 == null) goto L65;
                PushChatChattersResponse.Type r19 = r14.getType();
                int r110 = C0134a.a[r19.ordinal()];
                if (r110 != 1) goto L14;
                z0 r111 = GroupMembersViewModel.access$getViewModelState$p(this.a);
            L44:
                Object r1 = r111.getValue();
                c r2 = (c) r1;
                List<Chatter> r3 = r2.a;
                Collection r4 = r18.values();
                ArrayList r5 = new ArrayList();
                Iterator<T> r6 = r4.iterator();
            L46:
                if (r6.hasNext() == false) goto L62;
                T r7 = r6.next();
                Chatter r8 = (Chatter) r7;
                List<Chatter> r9 = r3;
                if ((r9 instanceof Collection) == true) goto L50;
            L52:
                Iterator<T> r10 = r9.iterator();
            L54:
                if (r10.hasNext() == false) goto L58;
                if (Intrinsics.areEqual(((Chatter) r10.next()).getId(), r8.getId()) == false) goto L54;
                boolean r11 = true;
            L59:
                if (r11 == true) goto L46;
                r5.add(r7);
            L58:
                r11 = false;
                goto L59
            L50:
                if (r9.isEmpty() == false) goto L52;
            L62:
                if (r111.compareAndSet(r1, c.a(r2, CollectionsKt.plus(r3, r5), null, false, false, 0, false, 62)) == false) goto L44;
            L88:
                return Unit.INSTANCE;
            L14:
                if (r110 != 2) goto L16;
                z0 r112 = GroupMembersViewModel.access$getViewModelState$p(this.a);
            L34:
                Object r0 = r112.getValue();
                c r20 = (c) r0;
                List<Chatter> r21 = r20.a;
                Set r22 = r18.keySet();
                ArrayList r23 = new ArrayList();
                Iterator<T> r24 = r21.iterator();
            L36:
                if (r24.hasNext() == false) goto L41;
                T r25 = r24.next();
                if (r22.contains(((Chatter) r25).getId()) == true) goto L36;
                r23.add(r25);
                goto L36
            L41:
                if (r112.compareAndSet(r0, c.a(r20, r23, null, false, false, 0, false, 62)) == false) goto L34;
            L16:
                if (r110 == 3) goto L88;
                if (r110 != 4) goto L32;
                z0 r113 = GroupMembersViewModel.access$getViewModelState$p(this.a);
            L20:
                Object r26 = r113.getValue();
                c r27 = (c) r26;
                List<Chatter> r28 = r27.a;
                ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
                Iterator<T> r30 = r28.iterator();
            L22:
                if (r30.hasNext() == false) goto L29;
                Chatter r31 = (Chatter) r30.next();
                Chatter r32 = (Chatter) r18.get(r31.getId());
                if (r32 == null) goto L27;
                r31 = r32;
            L27:
                r29.add(r31);
                goto L22
            L29:
                if (r113.compareAndSet(r26, c.a(r27, r29, null, false, false, 0, false, 62)) == false) goto L20;
            L32:
                throw new NoWhenBranchMatchedException();
            L65:
                return Unit.INSTANCE;
            }
        }

        public C03961(GroupMembersViewModel r1, Continuation<? super C03961> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03961(this.this$0, r3);
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
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r6 = GroupMembersViewModel.access$getRepository$p(this.this$0).j();
            GroupMembersViewModel r2 = this.this$0;
            a r3 = new a(r2);
            this.label = 1;
            Object r7 = r6.collect(new GroupMembersViewModel$observeChatters$1$invokeSuspend$$inlined$filter$1$2(r3, r2), this);
            if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
            r7 = Unit.INSTANCE;
        L12:
            if (r7 != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$2", f = "GroupMembersViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupMembersViewModel this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.main.viewmodel.GroupMembersViewModel$observeChatters$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ GroupMembersViewModel a;

            public a(GroupMembersViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r10, Continuation r11) {
                Map r12 = ((Entity) r10).getChatters();
                List<Chatter> r13 = ((c) GroupMembersViewModel.access$getViewModelState$p(this.a).getValue()).a;
                ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
                Iterator<T> r14 = r13.iterator();
                boolean r0 = false;
            L4:
                if (r14.hasNext() == false) goto L9;
                Chatter r1 = (Chatter) r14.next();
                Chatter r2 = (Chatter) r12.get(r1.getId());
                if (r2 == null) goto L8;
                r0 = true;
                r1 = r2;
            L8:
                r8.add(r1);
                goto L4
            L9:
                if (r0 == false) goto L14;
                z0 r15 = GroupMembersViewModel.access$getViewModelState$p(this.a);
            L11:
                Object r16 = r15.getValue();
                if (r15.compareAndSet(r16, c.a((c) r16, r8, null, false, false, 0, false, 62)) == false) goto L11;
            L14:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(GroupMembersViewModel r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r6 = GroupMembersViewModel.access$getRepository$p(this.this$0).k();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    private final void fetchAndObserveChat() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void fetchChatters() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03951(this, null), 3, null);
    }

    private final void observeChatters() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03961(this, null), 3, null);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final d getRustClient() {
        return this.rustClient;
    }

    public final i1<c> getUiState() {
        return this.uiState;
    }

    public final String getUserId() {
        return this.userId;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(GroupMembersViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(GroupMembersViewModel r0) {
        return r0.repository;
    }

    public static final /* synthetic */ z0 access$getViewModelState$p(GroupMembersViewModel r0) {
        return r0.viewModelState;
    }

    public final void routeToAddMember(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = d8b.a.a;
        d8b.a.b(r2, this.chatId);
    }

    public final void routeToMembersList(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r1 = d8b.a.a;
        String r2 = this.chatId;
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intent r0 = new Intent(r4, FlowChatMembersListActivity.class).putExtra("chat_id", r2);
        PassportcConvention.e(r0, LarkContext.getApplication());
        r4.startActivity(r0);
    }

    public final void routeToRemoveMember(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = d8b.a.a;
        d8b.a.d(r2, this.chatId);
    }

    public final boolean checkFunctionDisableAndShowDialog(Context r2, ChatSettingFunction r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "function");
        return this.platformEffects.a(r2, r3);
    }

    public final void routeToProfile(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chatterId");
        int r0 = d8b.a.a;
        d8b.a.c(r2, this.chatId, r3);
    }

    public GroupMembersViewModel(String r8, String r9, d r10, com.ss.android.lark.compose.chatsetting.common.platform.b r11) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r9, "chatId");
        Intrinsics.checkNotNullParameter(r10, "rustClient");
        Intrinsics.checkNotNullParameter(r11, "platformEffects");
        this.userId = r8;
        this.chatId = r9;
        this.rustClient = r10;
        this.platformEffects = r11;
        this.repository = new ChatSettingRepository(r10);
        StateFlowImpl r12 = j1.a(new c(CollectionsKt.emptyList(), Chat.Type.P2P, false, false, 0, true));
        this.viewModelState = r12;
        this.uiState = e.b(r12);
        fetchAndObserveChat();
        fetchChatters();
        observeChatters();
    }

    public GroupMembersViewModel(String r1, String r2, d r3, com.ss.android.lark.compose.chatsetting.common.platform.b r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = new AndroidChatSettingPlatformEffects(null);
    L5:
        this(r1, r2, r3, r4);
    }
}
