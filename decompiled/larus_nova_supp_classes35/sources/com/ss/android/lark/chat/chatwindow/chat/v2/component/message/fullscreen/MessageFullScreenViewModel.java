package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen;

import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0003?@AB\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:J\u0006\u0010;\u001a\u000208J\u0006\u0010<\u001a\u000208J\b\u0010=\u001a\u000208H\u0014J\b\u0010>\u001a\u000208H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R \u0010\u001f\u001a\b\u0012\u0002\b\u0003\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006B"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/larksuite/rucket/core/base/ServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/IChatPushService;", "messageService", "Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "fgService", "Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "<init>", "(Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;)V", "getMessageService", "()Lcom/ss/android/lark/im/sdk/service/ImSdkMessageService;", "getFgService", "()Lcom/ss/android/lark/featuregatingv2/interfaces/IUserFeatureGatingService;", "listener", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$FullDataChangeListener;", "launch", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenViewModel$InitData;", "getLaunch", "()Landroidx/lifecycle/MutableLiveData;", "chatLiveData", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChatLiveData", Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getError", "initLiveData", BuildConfig.FLAVOR, "getInitLiveData", "item", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "getItem", "()Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "setItem", "(Lcom/ss/android/lark/chat/vo/AbsMessageVO;)V", "initChat", "pageType", "Lcom/ss/android/lark/biz/im/extension/PageType;", "sequenceId", BuildConfig.FLAVOR, "fullScreenItemSupport", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenSupport;", "getFullScreenItemSupport", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/fullscreen/MessageFullScreenSupport;", "fullScreenItemSupport$delegate", "Lkotlin/Lazy;", "pushSourceJob", "Lcom/larksuite/rucket/job/RucketJob;", "Lcom/bytedance/lark/pb/basic/v1/Entity;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "parseArguments", BuildConfig.FLAVOR, "bundle", "Landroid/os/Bundle;", "destroy", "setup", "onCleared", "clear", "Companion", "FullDataChangeListener", "InitData", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageFullScreenViewModel extends ViewModel implements CoroutineScope {
    public static final a Companion = null;
    private static final String TAG = "MsgFullViewModel";
    private final MutableLiveData<Chat> chatLiveData;
    private final CoroutineContext coroutineContext;
    private final MutableLiveData<ErrorResult> error;
    private final jdb.g fgService;
    private final Lazy fullScreenItemSupport$delegate;
    private Chat initChat;
    private final MutableLiveData<Boolean> initLiveData;
    private y6b.a<?> item;
    private final MutableLiveData<c> launch;
    private b listener;
    private final com.ss.android.lark.im.sdk.service.p messageService;
    private PageType pageType;
    private RucketJob<Entity> pushSourceJob;
    private String sequenceId;

    public static final class a {
        public a() {
        }
    }

    public final class b extends com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.c {
        public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a r2) {
            Intrinsics.checkNotNullParameter(r2, "dataKey");
            super(r2);
        }
    }

    public static final class c {
        public final MessageFullScreenLaunchData a;
        public final Message b;
        public final Chat c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Message r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "InitData(launchData=" + this.a + ", message=" + this.b + ", chat=" + this.c + ')';
        }

        public c(MessageFullScreenLaunchData r2, Chat r3) {
            Intrinsics.checkNotNullParameter(r2, "launchData");
            Intrinsics.checkNotNullParameter(r3, "chat");
            this.a = r2;
            this.b = null;
            this.c = r3;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$parseArguments$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$parseArguments$1", f = "MessageFullScreenViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ MessageFullScreenLaunchData $launchData;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MessageFullScreenViewModel this$0;

        public AnonymousClass1(Chat r1, MessageFullScreenLaunchData r2, MessageFullScreenViewModel r3, Continuation<? super AnonymousClass1> r4) {
            this.$chat = r1;
            this.$launchData = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$chat, this.$launchData, this.this$0, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L25;
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            Chat r7 = this.$chat;
            if (r7 != null) goto L9;
            this.this$0.getError().postValue(new ErrorResult("launch chat is invalid"));
            return Unit.INSTANCE;
        L9:
            if (this.$launchData != null) goto L12;
            this.this$0.getError().postValue(new ErrorResult("launch data is invalid"));
            return Unit.INSTANCE;
        L12:
            MessageFullScreenViewModel.access$setInitChat$p(this.this$0, r7);
            this.this$0.getChatLiveData().postValue(this.$chat);
            MessageFullScreenViewModel.access$setPageType$p(this.this$0, this.$launchData.getPageType());
            MessageFullScreenViewModel.access$setSequenceId$p(this.this$0, this.$launchData.getSequenceId());
            ExecutorService r8 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.a;
            String r0 = this.$chat.getId();
            PageType r1 = this.$launchData.getPageType();
            String r2 = MessageFullScreenViewModel.access$getSequenceId$p(this.this$0);
            if (r2 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
            r2 = null;
        L15:
            com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a r9 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a(r0, r1, r2);
            String r3 = this.$launchData.getMessageId();
            Intrinsics.checkNotNullParameter(r9, "key");
            Intrinsics.checkNotNullParameter(r3, "messageId");
            if (((com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.b) ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.b).get(r9)) == null) goto L18;
            Intrinsics.checkNotNullParameter(r3, "messageId");
            Intrinsics.areEqual(null, r3);
        L18:
            this.this$0.setItem(null);
            StringBuilder r10 = new StringBuilder("parse data from memory center: messageId = ");
            r10.append(this.$launchData.getMessageId());
            r10.append(", vo valid: ");
            if (this.this$0.getItem() == null) goto L21;
            boolean r4 = true;
        L22:
            r10.append(r4);
            r10.append(", do valid: false");
            Log.i(MessageFullScreenViewModel.TAG, r10.toString());
            MutableLiveData<c> r11 = this.this$0.getLaunch();
            MessageFullScreenLaunchData r12 = this.$launchData;
            r12.setMessage(null);
            r11.postValue(new c(r12, this.$chat));
            this.this$0.getInitLiveData().postValue(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        L21:
            r4 = false;
            goto L22
        L25:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$setup$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel$setup$2", f = "MessageFullScreenViewModel.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ MessageFullScreenViewModel this$0;

        public AnonymousClass2(MessageFullScreenViewModel r1, Continuation<? super AnonymousClass2> r2) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0053 -> B:16:0x0058). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r8);
            com.larksuite.rucket.job.extension.a r3 = r2;
            Object r4 = r0;
            AnonymousClass2 r5 = this;
        L17:
            if (((Boolean) r8).booleanValue() == false) goto L28;
            com.larksuite.rucket.job.base.b r9 = r3.a();
            Chat r6 = null;
            Map r10 = com.ss.android.lark.parser.internal.h.d(((Entity) r9.b()).chats, null, ((Entity) r9.b()).mail_setting);
            Chat r7 = MessageFullScreenViewModel.access$getInitChat$p(r5.this$0);
            if (r7 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("initChat");
        L22:
            HashMap r11 = (HashMap) r10;
            Chat r12 = (Chat) r11.get(r6.getId());
            if (r12 == null) goto L26;
            r5.this$0.getChatLiveData().postValue(r12);
        L26:
            AnonymousClass2 r13 = r5;
            r0 = r4;
            com.larksuite.rucket.job.extension.a r14 = r3;
        L12:
            r13.L$0 = r14;
            r13.label = 1;
            Object r15 = r14.hasNext(r13);
            if (r15 != r0) goto L15;
            return r0;
        L15:
            Object r16 = r0;
            r5 = r13;
            r8 = r15;
            r3 = r14;
            r4 = r16;
            goto L17
        L21:
            r6 = r7;
            goto L22
        L28:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            RucketJob<Entity> r17 = ((f) b38.b.a.create(f.class)).chatsPush();
            if (this.this$0.getFgService().isEnable("im.chat.memory.disable_push_cancel") == true) goto L11;
            MessageFullScreenViewModel.access$setPushSourceJob$p(this.this$0, r17);
        L11:
            r14 = r17.iterator();
            r13 = this;
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    private final void clear() {
        b r0 = this.listener;
        if (r0 == null) goto L5;
        ExecutorService r1 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        ((CopyOnWriteArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.d).remove(r0);
    L5:
        ExecutorService r2 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.a;
        Chat r3 = this.initChat;
        String r4 = null;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("initChat");
        r3 = null;
    L8:
        String r5 = r3.getId();
        PageType r6 = this.pageType;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r6 = null;
    L11:
        String r7 = this.sequenceId;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
    L15:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a r8 = new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a(r5, r6, r4);
        Intrinsics.checkNotNullParameter(r8, "key");
        ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.b).remove(r8);
        ((ConcurrentHashMap) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.c).remove(r8);
        return;
    L14:
        r4 = r7;
        goto L15
    }

    private final o getFullScreenItemSupport() {
        return (o) this.fullScreenItemSupport$delegate.getValue();
    }

    public final void destroy() {
        this.initLiveData.postValue(Boolean.FALSE);
        this.item = null;
        clear();
        this.listener = null;
    }

    public void onCleared() {
        Log.i(TAG, "clear data and listeners");
        clear();
        if (this.fgService.isEnable("im.chat.memory.disable_push_cancel") == true) goto L9;
        RucketJob<Entity> r0 = this.pushSourceJob;
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        this.pushSourceJob = null;
        return;
    }

    public final void setup() {
        Chat r2 = this.initChat;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("initChat");
        r2 = null;
    L5:
        String r3 = r2.getId();
        PageType r4 = this.pageType;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("pageType");
        r4 = null;
    L8:
        String r5 = this.sequenceId;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("sequenceId");
        r5 = null;
    L11:
        b r0 = new b(new com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.C0067a(r3, r4, r5));
        this.listener = r0;
        ExecutorService r1 = com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.a;
        Intrinsics.checkNotNullParameter(r0, "listener");
        ((CopyOnWriteArrayList) com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a.d).add(r0);
        BuildersKt.launch$default(this, null, null, new AnonymousClass2(this, null), 3, null);
    }

    public final MutableLiveData<Chat> getChatLiveData() {
        return this.chatLiveData;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final MutableLiveData<ErrorResult> getError() {
        return this.error;
    }

    public final jdb.g getFgService() {
        return this.fgService;
    }

    public final MutableLiveData<Boolean> getInitLiveData() {
        return this.initLiveData;
    }

    public final y6b.a<?> getItem() {
        return this.item;
    }

    public final MutableLiveData<c> getLaunch() {
        return this.launch;
    }

    public final com.ss.android.lark.im.sdk.service.p getMessageService() {
        return this.messageService;
    }

    public static final /* synthetic */ o access$getFullScreenItemSupport(MessageFullScreenViewModel r0) {
        return r0.getFullScreenItemSupport();
    }

    public static final /* synthetic */ Chat access$getInitChat$p(MessageFullScreenViewModel r0) {
        return r0.initChat;
    }

    public static final /* synthetic */ PageType access$getPageType$p(MessageFullScreenViewModel r0) {
        return r0.pageType;
    }

    public static final /* synthetic */ String access$getSequenceId$p(MessageFullScreenViewModel r0) {
        return r0.sequenceId;
    }

    public final void parseArguments(Bundle r11) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L7;
        if (r11 == null) goto L6;
        MessageFullScreenLaunchData r1 = (MessageFullScreenLaunchData) r11.getSerializable("key_message_full_screen_data", MessageFullScreenLaunchData.class);
    L12:
        if (r0 < 33) goto L16;
        if (r11 == null) goto L15;
        Chat r12 = (Chat) r11.getSerializable("key_chat", Chat.class);
    L21:
        if (r1 == null) goto L24;
        String r2 = r1.toString();
        if (r2 == null) goto L24;
    L25:
        Log.i(TAG, "parseData: launchData = ".concat(r2));
        BuildersKt.launch$default(this, getCoroutineContext(), null, new AnonymousClass1(r12, r1, this, null), 2, null);
        return;
    L24:
        r2 = "invalid";
        goto L25
    L15:
        r12 = null;
        goto L21
    L16:
        if (r11 == null) goto L18;
        Serializable r13 = r11.getSerializable("key_chat");
    L19:
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chat.Chat");
        r12 = (Chat) r13;
        goto L21
    L18:
        r13 = null;
        goto L19
    L6:
        r1 = null;
        goto L12
    L7:
        if (r11 == null) goto L9;
        Serializable r3 = r11.getSerializable("key_message_full_screen_data");
    L10:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.MessageFullScreenLaunchData");
        r1 = (MessageFullScreenLaunchData) r3;
        goto L12
    L9:
        r3 = null;
        goto L10
    }

    public final void setItem(y6b.a<?> r1) {
        this.item = r1;
    }

    @Inject
    public MessageFullScreenViewModel(com.ss.android.lark.im.sdk.service.p r2, jdb.g r3) {
        Intrinsics.checkNotNullParameter(r2, "messageService");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        this.messageService = r2;
        this.fgService = r3;
        this.launch = new MutableLiveData();
        this.chatLiveData = new MutableLiveData();
        this.error = new MutableLiveData();
        this.initLiveData = new MutableLiveData();
        this.fullScreenItemSupport$delegate = LazyKt.lazy(MessageFullScreenViewModel$fullScreenItemSupport$2.INSTANCE);
        this.coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
    }

    public static final /* synthetic */ void access$setInitChat$p(MessageFullScreenViewModel r0, Chat r1) {
        r0.initChat = r1;
    }

    public static final /* synthetic */ void access$setPageType$p(MessageFullScreenViewModel r0, PageType r1) {
        r0.pageType = r1;
    }

    public static final /* synthetic */ void access$setPushSourceJob$p(MessageFullScreenViewModel r0, RucketJob r1) {
        r0.pushSourceJob = r1;
    }

    public static final /* synthetic */ void access$setSequenceId$p(MessageFullScreenViewModel r0, String r1) {
        r0.sequenceId = r1;
    }
}
