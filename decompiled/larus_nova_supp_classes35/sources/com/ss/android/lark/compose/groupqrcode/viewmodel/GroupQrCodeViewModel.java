package com.ss.android.lark.compose.groupqrcode.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.im.v1.GetChatQRCodeTokenResponse;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.compose.groupqrcode.repository.GroupQrCodeRepository;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/compose/groupqrcode/viewmodel/GroupQrCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "avatarKey", "chatName", "ownerId", "repository", "Lcom/ss/android/lark/compose/groupqrcode/repository/GroupQrCodeRepository;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/compose/groupqrcode/repository/GroupQrCodeRepository;)V", "viewModelState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ss/android/lark/compose/groupqrcode/viewmodel/GroupQrCodeState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "reload", BuildConfig.FLAVOR, "loadQrCodeData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GroupQrCodeViewModel extends ViewModel {
    public static final int $stable = 8;
    private final String chatId;
    private final String ownerId;
    private final GroupQrCodeRepository repository;
    private final i1<a> uiState;
    private final z0<a> viewModelState;

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel$1", f = "GroupQrCodeViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupQrCodeViewModel this$0;

        public AnonymousClass1(GroupQrCodeViewModel r1, Continuation<? super AnonymousClass1> r2) {
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            GroupQrCodeViewModel r5 = this.this$0;
            this.label = 1;
            if (GroupQrCodeViewModel.access$loadQrCodeData(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel$loadQrCodeData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel", f = "GroupQrCodeViewModel.kt", i = {1}, l = {58, 62}, m = "loadQrCodeData", n = {"response"}, s = {"L$0"})
    public static final class C04021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GroupQrCodeViewModel this$0;

        public C04021(GroupQrCodeViewModel r1, Continuation<? super C04021> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return GroupQrCodeViewModel.access$loadQrCodeData(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel$reload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.groupqrcode.viewmodel.GroupQrCodeViewModel$reload$1", f = "GroupQrCodeViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupQrCodeViewModel this$0;

        public C04031(GroupQrCodeViewModel r1, Continuation<? super C04031> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04031(this.this$0, r3);
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
            GroupQrCodeViewModel r5 = this.this$0;
            this.label = 1;
            if (GroupQrCodeViewModel.access$loadQrCodeData(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public final void reload() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04031(this, null), 3, null);
    }

    public final i1<a> getUiState() {
        return this.uiState;
    }

    private final Object loadQrCodeData(Continuation<? super Unit> r14) {
        if ((r14 instanceof C04021) == false) goto L7;
        C04021 r0 = (C04021) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        GetChatQRCodeTokenResponse r4 = (GetChatQRCodeTokenResponse) r0.L$0;
        ResultKt.throwOnFailure(r15);
        Object r16 = ((Result) r15).unbox-impl();
    L29:
        if (Result.exceptionOrNull-impl(r16) != null) goto L48;
        Chatter r17 = (Chatter) r16;
        z0<a> r5 = this.viewModelState;
    L31:
        Object r6 = r5.getValue();
        a r7 = (a) r6;
        LoadState r8 = LoadState.SUCCESS;
        String r9 = r4.getUrl();
        String r10 = BuildConfig.FLAVOR;
        if (r9 != null) goto L34;
        r9 = BuildConfig.FLAVOR;
    L34:
        if (r17 == null) goto L36;
        String r11 = r17.getName();
    L37:
        if (r11 == null) goto L40;
        r10 = r11;
    L40:
        Long r12 = r4.getExpire_time();
        if (r12 == null) goto L43;
        long r13 = r12.longValue();
    L45:
        if (r5.compareAndSet(r6, a.a(r7, r8, r9, r10, r13, 28)) == false) goto L31;
        return Unit.INSTANCE;
    L43:
        r13 = 0;
        goto L45
    L36:
        r11 = null;
        goto L37
    L48:
        z0<a> r18 = this.viewModelState;
    L49:
        Object r19 = r18.getValue();
        if (r18.compareAndSet(r19, a.a((a) r19, LoadState.ERROR, null, null, 0, 126)) == false) goto L49;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r15);
        Object r110 = ((Result) r15).unbox-impl();
    L23:
        if (Result.exceptionOrNull-impl(r110) != null) goto L53;
        GetChatQRCodeTokenResponse r111 = (GetChatQRCodeTokenResponse) r110;
        GroupQrCodeRepository r20 = this.repository;
        String r21 = this.ownerId;
        r0.L$0 = r111;
        r0.label = 2;
        Object r22 = r20.a(r21, r0);
        if (r22 != r2) goto L27;
        return r2;
    L27:
        r4 = r111;
        r16 = r22;
        goto L29
    L53:
        z0<a> r23 = this.viewModelState;
    L54:
        Object r112 = r23.getValue();
        if (r23.compareAndSet(r112, a.a((a) r112, LoadState.ERROR, null, null, 0, 126)) == false) goto L54;
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r15);
        z0<a> r113 = this.viewModelState;
    L17:
        Object r24 = r113.getValue();
        if (r113.compareAndSet(r24, a.a((a) r24, LoadState.LOADING, null, null, 0, 126)) == false) goto L17;
        GroupQrCodeRepository r114 = this.repository;
        String r25 = this.chatId;
        r0.label = 1;
        r110 = r114.b(r25, 7, false, r0);
        if (r110 != r2) goto L23;
        return r2;
    L7:
        r0 = new C04021(this, r14);
        goto L8
    }

    public static final /* synthetic */ Object access$loadQrCodeData(GroupQrCodeViewModel r0, Continuation r1) {
        return r0.loadQrCodeData(r1);
    }

    public GroupQrCodeViewModel(String r7, String r8, String r9, String r10, GroupQrCodeRepository r11) {
        Intrinsics.checkNotNullParameter(r7, "chatId");
        Intrinsics.checkNotNullParameter(r8, "avatarKey");
        Intrinsics.checkNotNullParameter(r9, "chatName");
        Intrinsics.checkNotNullParameter(r10, "ownerId");
        Intrinsics.checkNotNullParameter(r11, "repository");
        this.chatId = r7;
        this.ownerId = r10;
        this.repository = r11;
        StateFlowImpl r12 = j1.a(new a(r7, r8, r9, 99));
        this.viewModelState = r12;
        this.uiState = e.b(r12);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }
}
