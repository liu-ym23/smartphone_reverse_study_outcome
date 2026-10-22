package com.ss.android.lark.compose.groupinfo;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0$H\u0082@¢\u0006\u0004\b%\u0010&J\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fJ\u0006\u0010)\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/ss/android/lark/compose/groupinfo/GroupInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "initialAvatarKey", "initialChatName", "canEdit", BuildConfig.FLAVOR, "repository", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoRepository;", "platformService", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoPlatformService;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/ss/android/lark/compose/groupinfo/GroupInfoRepository;Lcom/ss/android/lark/compose/groupinfo/GroupInfoPlatformService;)V", "getChatId", "()Ljava/lang/String;", "viewModelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoState;", "_effect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ss/android/lark/compose/groupinfo/GroupInfoEffect;", "effect", "Lkotlinx/coroutines/flow/SharedFlow;", "getEffect", "()Lkotlinx/coroutines/flow/SharedFlow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "onNameChange", BuildConfig.FLAVOR, IPortraitService.NAME, "changeSelectedImageUri", "uri", "updateGroupInfo", "Lkotlin/Result;", "updateGroupInfo-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConfirmClick", "onCancelClick", "onAvatarClick", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupInfoViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableSharedFlow<b> _effect;
    private final String chatId;
    private final d1<b> effect;
    private final d platformService;
    private final GroupInfoRepository repository;
    private final i1<e> uiState;
    private final z0<e> viewModelState;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onAvatarClick$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onAvatarClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {135, 137}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public AnonymousClass1(GroupInfoViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r5);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r5);
            if (((e) GroupInfoViewModel.access$getViewModelState$p(this.this$0).getValue()).d == false) goto L15;
            MutableSharedFlow r6 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.C0149b r2 = b.C0149b.a;
            this.label = 1;
            if (r6.emit(r2, this) != r0) goto L19;
            return r0;
        L15:
            MutableSharedFlow r7 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.d r3 = new b.d(GroupInfoToast.EDIT_NOT_ALLOWED);
            this.label = 2;
            if (r7.emit(r3, this) != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onCancelClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onCancelClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public C04001(GroupInfoViewModel r1, Continuation<? super C04001> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04001(this.this$0, r3);
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
            MutableSharedFlow r5 = GroupInfoViewModel.access$get_effect$p(this.this$0);
            b.a r2 = b.a.a;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onConfirmClick$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.GroupInfoViewModel$onConfirmClick$1", f = "GroupInfoViewModel.kt", i = {}, l = {BubbleStyle.ColorType.SINGLE_URL_CARD_WITH_THREAD_REPLY, 117, 118, 121}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ GroupInfoViewModel this$0;

        public C04011(GroupInfoViewModel r1, Continuation<? super C04011> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04011(this.this$0, r3);
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
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r15);
        L38:
            z0 r2 = GroupInfoViewModel.access$getViewModelState$p(this.this$0);
        L39:
            Object r16 = r2.getValue();
            if (r2.compareAndSet(r16, e.a((e) r16, null, null, null, 0, false, 63)) == false) goto L39;
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            Object r3 = this.L$0;
            ResultKt.throwOnFailure(r15);
        L31:
            GroupInfoViewModel r17 = this.this$0;
            Throwable r4 = Result.exceptionOrNull-impl(r3);
            if (r4 == null) goto L38;
            if (GroupInfoViewModel.access$getPlatformService$p(r17).b(r4) == true) goto L38;
            MutableSharedFlow r18 = GroupInfoViewModel.access$get_effect$p(r17);
            b.c r5 = new b.c(r4);
            this.L$0 = r3;
            this.label = 4;
            if (r18.emit(r5, this) != r0) goto L38;
            return r0;
        L12:
            GroupInfoViewModel r6 = (GroupInfoViewModel) this.L$1;
            Object r7 = this.L$0;
            ResultKt.throwOnFailure(r15);
        L27:
            MutableSharedFlow r19 = GroupInfoViewModel.access$get_effect$p(r6);
            b.a r8 = b.a.a;
            this.L$0 = r7;
            this.L$1 = null;
            this.label = 3;
            if (r19.emit(r8, this) != r0) goto L30;
            return r0;
        L30:
            r3 = r7;
            goto L31
        L13:
            ResultKt.throwOnFailure(r15);
            Object r110 = ((Result) r15).unbox-impl();
        L14:
            r3 = r110;
            GroupInfoViewModel r111 = this.this$0;
            if (Result.isSuccess-impl(r3) == false) goto L31;
            Unit r9 = (Unit) r3;
            c.b("GroupInfoViewModel updateInfo success");
            MutableSharedFlow r10 = GroupInfoViewModel.access$get_effect$p(r111);
            b.d r11 = new b.d(GroupInfoToast.SAVE_SUCCESS);
            this.L$0 = r3;
            this.L$1 = r111;
            this.label = 2;
            if (r10.emit(r11, this) != r0) goto L26;
            return r0;
        L26:
            r7 = r3;
            r6 = r111;
            goto L27
        L15:
            ResultKt.throwOnFailure(r15);
            z0 r112 = GroupInfoViewModel.access$getViewModelState$p(this.this$0);
        L16:
            Object r12 = r112.getValue();
            if (r112.compareAndSet(r12, e.a((e) r12, null, null, null, 0, true, 63)) == false) goto L16;
            GroupInfoViewModel r113 = this.this$0;
            this.label = 1;
            r110 = GroupInfoViewModel.m927access$updateGroupInfoIoAF18A(r113, this);
            if (r110 != r0) goto L14;
            return r0;
        }
    }

    public final void onConfirmClick() {
        if (f.a((e) this.viewModelState.getValue()) == true) goto L5;
        return;
    L5:
        if (((e) this.viewModelState.getValue()).g == true) goto L10;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04011(this, null), 3, null);
        return;
    }

    public final void onAvatarClick() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void onCancelClick() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04001(this, null), 3, null);
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final d1<b> getEffect() {
        return this.effect;
    }

    public final i1<e> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ d access$getPlatformService$p(GroupInfoViewModel r0) {
        return r0.platformService;
    }

    public static final /* synthetic */ z0 access$getViewModelState$p(GroupInfoViewModel r0) {
        return r0.viewModelState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_effect$p(GroupInfoViewModel r0) {
        return r0._effect;
    }

    /* JADX INFO: renamed from: updateGroupInfo-IoAF18A, reason: not valid java name */
    private final Object m928updateGroupInfoIoAF18A(Continuation<? super Result<Unit>> r20) {
        if ((r20 instanceof GroupInfoViewModel$updateGroupInfo$1) == false) goto L7;
        GroupInfoViewModel$updateGroupInfo$1 r2 = (GroupInfoViewModel$updateGroupInfo$1) r20;
        int r3 = r2.label;
        if ((r3 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r2.label = r3 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L18;
        if (r5 == 1) goto L17;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        String r6 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r7 = ((Result) r1).unbox-impl();
    L50:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L54;
        int r9 = c.a;
        c.a("GroupInfoViewModel updateAvatar rust failed: " + r8.getMessage());
        return Result.constructor-impl(ResultKt.createFailure(r8));
    L54:
        this.platformService.a(this.chatId, r6);
    L59:
        Result.Companion r10 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
        Object r11 = ((Result) r1).unbox-impl();
    L44:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L55;
        String r13 = (String) r11;
        c.b("GroupInfoViewModel onAvatarUploaded start rust update");
        GroupInfoRepository r14 = this.repository;
        String r15 = this.chatId;
        r2.L$0 = r13;
        r2.label = 3;
        Object r16 = r14.a(r15, r13, r2);
        if (r16 != r4) goto L49;
        return r4;
    L49:
        r6 = r13;
        r7 = r16;
        goto L50
    L55:
        int r17 = c.a;
        c.a("GroupInfoViewModel upload avatar failed: " + r12.getMessage());
        return Result.constructor-impl(ResultKt.createFailure(r12));
    L17:
        String r18 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r19 = ((Result) r1).unbox-impl();
    L24:
        if (Result.isSuccess-impl(r19) == false) goto L30;
        UpdateChatResponse r21 = (UpdateChatResponse) r19;
        z0<e> r110 = this.viewModelState;
    L26:
        Object r111 = r110.getValue();
        z0<e> r22 = r110;
        if (r22.compareAndSet(r111, e.a((e) r111, r18, null, null, 0, false, 126)) == true) goto L30;
        r110 = r22;
    L30:
        Throwable r23 = Result.exceptionOrNull-impl(r19);
        if (r23 == null) goto L34;
        int r24 = c.a;
        c.a("GroupInfoViewModel updateName failed: " + r23.getMessage());
        return Result.constructor-impl(ResultKt.createFailure(r23));
    L34:
        String r25 = ((e) this.viewModelState.getValue()).e;
        if (r25.length() <= 0) goto L37;
        boolean r26 = true;
    L38:
        if (r26 == false) goto L59;
        Object r27 = this.platformService.c(r25);
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 != null) goto L57;
        c.b("GroupInfoViewModel start upload avatar");
        d r29 = this.platformService;
        r2.L$0 = null;
        r2.label = 2;
        r11 = r29.d((String) r27, r2);
        if (r11 != r4) goto L44;
        return r4;
    L57:
        int r30 = c.a;
        c.a("GroupInfoViewModel resolve avatar path failed: " + r28.getMessage());
        return Result.constructor-impl(ResultKt.createFailure(r28));
    L37:
        r26 = false;
        goto L38
    L18:
        ResultKt.throwOnFailure(r1);
        r18 = ((e) this.viewModelState.getValue()).c;
        if (Intrinsics.areEqual(r18, ((e) this.viewModelState.getValue()).a) == true) goto L34;
        c.b("GroupInfoViewModel updateName start");
        GroupInfoRepository r31 = this.repository;
        String r32 = this.chatId;
        String r33 = StringsKt.trim(r18).toString();
        r2.L$0 = r18;
        r2.label = 1;
        r19 = r31.b(r32, r33, r2);
        if (r19 != r4) goto L24;
        return r4;
    L7:
        r2 = new GroupInfoViewModel$updateGroupInfo$1(this, r20);
        goto L8
    }

    public final void changeSelectedImageUri(String r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (Intrinsics.areEqual(((e) this.viewModelState.getValue()).e, r11) == false) goto L8;
        z0<e> r0 = this.viewModelState;
    L5:
        Object r12 = r0.getValue();
        e r1 = (e) r12;
        if (r0.compareAndSet(r12, e.a(r1, null, null, null, r1.f + 1, false, 95)) == false) goto L5;
        return;
    L8:
        z0<e> r2 = this.viewModelState;
    L9:
        Object r3 = r2.getValue();
        if (r2.compareAndSet(r3, e.a((e) r3, null, null, r11, 0, false, BubbleStyle.ColorType.PURPLE_HEADER_WHITE_BORDER)) == false) goto L9;
    }

    public final void onNameChange(String r11) {
        Intrinsics.checkNotNullParameter(r11, IPortraitService.NAME);
        z0<e> r0 = this.viewModelState;
    L3:
        Object r1 = r0.getValue();
        if (r0.compareAndSet(r1, e.a((e) r1, null, r11, null, 0, false, 123)) == false) goto L3;
    }

    /* JADX INFO: renamed from: access$updateGroupInfo-IoAF18A, reason: not valid java name */
    public static final /* synthetic */ Object m927access$updateGroupInfoIoAF18A(GroupInfoViewModel r0, Continuation r1) {
        return r0.m928updateGroupInfoIoAF18A(r1);
    }

    public GroupInfoViewModel(String r15, String r16, String r17, boolean r18, GroupInfoRepository r19, d r20) {
        Intrinsics.checkNotNullParameter(r15, "chatId");
        Intrinsics.checkNotNullParameter(r16, "initialAvatarKey");
        Intrinsics.checkNotNullParameter(r17, "initialChatName");
        Intrinsics.checkNotNullParameter(r19, "repository");
        Intrinsics.checkNotNullParameter(r20, "platformService");
        this.chatId = r15;
        this.repository = r19;
        this.platformService = r20;
        StateFlowImpl r1 = j1.a(new e(r17, r16, r17, r18, BuildConfig.FLAVOR, 0, false));
        this.viewModelState = r1;
        MutableSharedFlow<b> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._effect = r2;
        this.effect = kotlinx.coroutines.flow.e.a(r2);
        this.uiState = kotlinx.coroutines.flow.e.b(r1);
    }
}
