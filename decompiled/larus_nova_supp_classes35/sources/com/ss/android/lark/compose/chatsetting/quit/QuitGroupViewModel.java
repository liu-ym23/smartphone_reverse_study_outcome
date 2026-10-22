package com.ss.android.lark.compose.chatsetting.quit;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.im.v1.DeleteChatChattersResponse;
import com.lark.kmp.rustclient.api.d;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository;
import com.ss.android.lark.feed.app.entity.RankConstants;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00032\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013H\u0082@¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/compose/chatsetting/quit/QuitGroupViewModel;", "Landroidx/lifecycle/ViewModel;", "chatId", BuildConfig.FLAVOR, "currentUserId", "rustClient", "Lcom/lark/kmp/rustclient/api/IRustClient;", "platformEffects", "Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/lark/kmp/rustclient/api/IRustClient;Lcom/ss/android/lark/compose/chatsetting/common/platform/ChatSettingPlatformEffects;)V", "getChatId", "()Ljava/lang/String;", "repository", "Lcom/ss/android/lark/compose/chatsetting/common/repository/ChatSettingRepository;", "exitGroup", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "Lcom/ss/android/lark/compose/chatsetting/common/router/PlatformContext;", "(Landroid/content/Context;)V", "changeOwner", "newOwnerId", "(Ljava/lang/String;Landroid/content/Context;)V", "exit", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuitGroupViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    private final String chatId;
    private final String currentUserId;
    private final com.ss.android.lark.compose.chatsetting.common.platform.b platformEffects;
    private final ChatSettingRepository repository;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel$changeOwner$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel$changeOwner$1", f = "QuitGroupViewModel.kt", i = {}, l = {29, RankConstants.PRIORITY_SHORT_CUT_ITEM}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $newOwnerId;
        Object L$0;
        int label;
        final /* synthetic */ QuitGroupViewModel this$0;

        public AnonymousClass1(QuitGroupViewModel r1, String r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$newOwnerId = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$newOwnerId, this.$context, r5);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r6);
        L19:
            Object r7 = r2;
        L20:
            QuitGroupViewModel r3 = this.this$0;
            Context r4 = this.$context;
            Throwable r8 = Result.exceptionOrNull-impl(r7);
            if (r8 == null) goto L24;
            QuitGroupViewModel.access$getPlatformEffects$p(r3).m(r4, r8);
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r6);
            r7 = ((Result) r6).unbox-impl();
        L13:
            QuitGroupViewModel r5 = this.this$0;
            Context r9 = this.$context;
            if (Result.isSuccess-impl(r7) == false) goto L20;
            Chat r10 = (Chat) r7;
            this.L$0 = r7;
            this.label = 2;
            if (QuitGroupViewModel.access$exit(r5, r9, this) != r0) goto L18;
            return r0;
        L18:
            r2 = r7;
            goto L19
        L10:
            ResultKt.throwOnFailure(r6);
            ChatSettingRepository r11 = QuitGroupViewModel.access$getRepository$p(this.this$0);
            String r12 = this.this$0.getChatId();
            String r13 = this.$newOwnerId;
            this.label = 1;
            r7 = r11.r(r12, r13, this);
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel$exit$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel", f = "QuitGroupViewModel.kt", i = {0}, l = {41}, m = "exit", n = {"context"}, s = {"L$0"})
    public static final class C03971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ QuitGroupViewModel this$0;

        public C03971(QuitGroupViewModel r1, Continuation<? super C03971> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return QuitGroupViewModel.access$exit(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel$exitGroup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.quit.QuitGroupViewModel$exitGroup$1", f = "QuitGroupViewModel.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ QuitGroupViewModel this$0;

        public C03981(QuitGroupViewModel r1, Context r2, Continuation<? super C03981> r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C03981(this.this$0, this.$context, r4);
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
            QuitGroupViewModel r5 = this.this$0;
            Context r2 = this.$context;
            this.label = 1;
            if (QuitGroupViewModel.access$exit(r5, r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public static final /* synthetic */ com.ss.android.lark.compose.chatsetting.common.platform.b access$getPlatformEffects$p(QuitGroupViewModel r0) {
        return r0.platformEffects;
    }

    public static final /* synthetic */ ChatSettingRepository access$getRepository$p(QuitGroupViewModel r0) {
        return r0.repository;
    }

    public final void exitGroup(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C03981(this, r8, null), 3, null);
    }

    private final Object exit(Context r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C03971) == false) goto L7;
        C03971 r0 = (C03971) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L22:
        if (Result.isSuccess-impl(r9) == false) goto L29;
        DeleteChatChattersResponse r4 = (DeleteChatChattersResponse) r9;
        Object r5 = this.platformEffects.f(r6);
        if (Result.isSuccess-impl(r5) == false) goto L26;
        Unit r10 = (Unit) r5;
        d8b.a.a(r6);
    L26:
        Throwable r11 = Result.exceptionOrNull-impl(r5);
        if (r11 == null) goto L29;
        this.platformEffects.m(r6, r11);
    L29:
        Throwable r12 = Result.exceptionOrNull-impl(r9);
        if (r12 == null) goto L33;
        this.platformEffects.l(this.chatId, false);
        this.platformEffects.m(r6, r12);
    L33:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (this.platformEffects.d(r6) == false) goto L17;
        this.platformEffects.l(this.chatId, true);
        ChatSettingRepository r13 = this.repository;
        String r14 = this.chatId;
        String r15 = this.currentUserId;
        r0.L$0 = r6;
        r0.label = 1;
        r9 = r13.h(r14, r15, r0);
        if (r9 != r2) goto L22;
        return r2;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new C03971(this, r7);
        goto L8
    }

    public final void changeOwner(String r8, Context r9) {
        Intrinsics.checkNotNullParameter(r8, "newOwnerId");
        Intrinsics.checkNotNullParameter(r9, "context");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r8, r9, null), 3, null);
    }

    public static final /* synthetic */ Object access$exit(QuitGroupViewModel r0, Context r1, Continuation r2) {
        return r0.exit(r1, r2);
    }

    public QuitGroupViewModel(String r2, String r3, d r4, com.ss.android.lark.compose.chatsetting.common.platform.b r5) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "currentUserId");
        Intrinsics.checkNotNullParameter(r4, "rustClient");
        Intrinsics.checkNotNullParameter(r5, "platformEffects");
        this.chatId = r2;
        this.currentUserId = r3;
        this.platformEffects = r5;
        this.repository = new ChatSettingRepository(r4);
    }
}
