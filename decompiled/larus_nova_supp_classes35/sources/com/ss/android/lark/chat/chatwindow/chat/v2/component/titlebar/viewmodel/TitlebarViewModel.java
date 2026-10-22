package com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.c;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 L2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u0006:\u0001LB!\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u00104\u001a\u000205J\b\u00106\u001a\u000205H\u0002J\u0010\u00107\u001a\u0002052\b\b\u0002\u00108\u001a\u00020'J\u0010\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020\fH\u0016J\u0018\u0010=\u001a\u0002052\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010A\u001a\u0002052\u0006\u0010<\u001a\u00020\fH\u0016J\b\u0010B\u001a\u000205H\u0014J\u0006\u0010C\u001a\u000205J\u0012\u0010D\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020?H\u0002J\u0006\u0010G\u001a\u000205R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001a¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0014\u0010H\u001a\u00020IX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006M"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/viewmodel/TitlebarViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/larksuite/rucket/core/base/ServiceModel;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/viewmodel/ITitleBarModelService;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatBadgePushHandler$IBadgeChangeListener;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatChatterPushHandler$IChatterPushListener;", "chatContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "initChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "p2pChatter", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "<init>", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/chat/entity/chat/Chat;Lcom/ss/android/lark/chat/entity/chatter/Chatter;)V", "getChatContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getInitChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setInitChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "getP2pChatter", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "setP2pChatter", "(Lcom/ss/android/lark/chat/entity/chatter/Chatter;)V", "badgeCountLiveData", "Landroidx/lifecycle/MutableLiveData;", BuildConfig.FLAVOR, "getBadgeCountLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setBadgeCountLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "p2pChatterLiveData", "getP2pChatterLiveData", "setP2pChatterLiveData", "p2pUserFieldsLiveData", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/UserFields;", "getP2pUserFieldsLiveData", "destroyed", BuildConfig.FLAVOR, "badgePushHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatBadgePushHandler;", "chatterPushHandler", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/ChatChatterPushHandler;", "callbackManager", "Lcom/larksuite/framework/callback/CallbackManager;", "userFieldsService", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/IUserFieldsService;", "getUserFieldsService", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/titlebar/fields/IUserFieldsService;", "userFieldsService$delegate", "Lkotlin/Lazy;", "create", BuildConfig.FLAVOR, "initSpecialFocusPush", "triggerUpdateNewP2PChatter", "forceServer", "onBadgeChange", "badge", "onPushUpdatedChatter", "chatter", "onPushUpdatedNickname", "chatterId", BuildConfig.FLAVOR, "nickname", "onUpdateSelfInfo", "onCleared", "destroy", "tryGetLocalFields", "forceGetServerData", "userId", "reloadUserFieldsData", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitlebarViewModel extends ViewModel implements CoroutineScope, c.a, d.a {
    public static final a Companion = null;
    private static final String FIELD_LOG_TAG = "UserFieldsView";
    public static final String LOG_TAG = "ChatWindowLog";
    private MutableLiveData<Integer> badgeCountLiveData;
    private final c badgePushHandler;
    private final CallbackManager callbackManager;
    private final v chatContainer;
    private final d chatterPushHandler;
    private final CoroutineContext coroutineContext;
    private boolean destroyed;
    private Chat initChat;
    private Chatter p2pChatter;
    private MutableLiveData<Chatter> p2pChatterLiveData;
    private final MutableLiveData<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c> p2pUserFieldsLiveData;
    private final Lazy userFieldsService$delegate;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TitlebarViewModel b;
        public final /* synthetic */ String c;

        public b(boolean r1, TitlebarViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            if (this.a == false) goto L5;
            Chatter r0 = (Chatter) this.b.getChatContainer().T().ld(this.b.getInitChat().getId(), CollectionsKt.listOf(this.c)).get(this.c);
        L6:
            if (r0 == null) goto L9;
            this.b.getP2pChatterLiveData().postValue(r0);
            return;
        L9:
            return;
        L5:
            r0 = this.b.getChatContainer().T().ue(this.c);
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel$initSpecialFocusPush$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel$initSpecialFocusPush$1", f = "TitlebarViewModel.kt", i = {0}, l = {63}, m = "invokeSuspend", n = {"currentP2PChatterId"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ TitlebarViewModel this$0;

        public AnonymousClass1(TitlebarViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0051 -> B:13:0x0057). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.larksuite.rucket.job.extension.a r2 = (com.larksuite.rucket.job.extension.a) this.L$1;
            String r3 = (String) this.L$0;
            ResultKt.throwOnFailure(r12);
            String r4 = r3;
            com.larksuite.rucket.job.extension.a r5 = r2;
            Object r6 = r0;
            AnonymousClass1 r7 = this;
        L14:
            if (((Boolean) r12).booleanValue() == false) goto L48;
            com.larksuite.rucket.job.base.b r13 = r5.a();
            List r8 = ((PushFocusChatter) r13.b()).add_chatters;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator r10 = r8.iterator();
        L17:
            if (r10.hasNext() == false) goto L19;
            r9.add(j.a((com.bytedance.lark.pb.basic.v1.Chatter) r10.next()));
            goto L17
        L19:
            LinkedHashMap r11 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
            Iterator r14 = r9.iterator();
        L21:
            if (r14.hasNext() == false) goto L23;
            Object r15 = r14.next();
            r11.put(((Chatter) r15).getId(), r15);
            goto L21
        L23:
            List r16 = ((PushFocusChatter) r13.b()).delete_chatter_ids;
            ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
            Iterator r18 = r16.iterator();
        L25:
            if (r18.hasNext() == false) goto L28;
            r17.add(((Long) r18.next()).toString());
            goto L25
        L28:
            if (r11.containsKey(r4) == false) goto L33;
            Chatter r19 = (Chatter) r11.get(r4);
            if (r19 == null) goto L46;
            r7.this$0.getP2pChatterLiveData().postValue(r19);
        L46:
            AnonymousClass1 r110 = r7;
            r0 = r6;
            com.larksuite.rucket.job.extension.a r20 = r5;
            String r21 = r4;
        L9:
            r110.L$0 = r21;
            r110.L$1 = r20;
            r110.label = 1;
            Object r22 = r20.hasNext(r110);
            if (r22 != r0) goto L12;
            return r0;
        L12:
            Object r111 = r0;
            r7 = r110;
            r12 = r22;
            r4 = r21;
            r5 = r20;
            r6 = r111;
            goto L14
        L33:
            if (r17.isEmpty() == true) goto L41;
            Iterator r112 = r17.iterator();
        L37:
            if (r112.hasNext() == false) goto L41;
            if (Intrinsics.areEqual((String) r112.next(), r4) == false) goto L37;
            boolean r113 = true;
        L42:
            if (r113 == false) goto L46;
            Chatter r114 = ImSdkService.d().ue(r4);
            if (r114 == null) goto L46;
            r7.this$0.getP2pChatterLiveData().postValue(r114);
        L41:
            r113 = false;
            goto L42
        L48:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            String r115 = this.this$0.getInitChat().getP2pChatterId();
            r20 = ((com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.a) b38.b.a.create(com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.a.class)).focusChatterPush().iterator();
            r21 = r115;
            r110 = this;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedNickname(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "nickname");
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onUpdateSelfInfo(Chatter r2) {
        Intrinsics.checkNotNullParameter(r2, "chatter");
    }

    private final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b getUserFieldsService() {
        return (com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b) this.userFieldsService$delegate.getValue();
    }

    private final void initSpecialFocusPush() {
        if (this.initChat.isP2PChat() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final void create() {
        this.badgeCountLiveData.postValue(Integer.valueOf(ChatCoreModule.a().getFeedDependency().getBadge()));
        Chatter r0 = this.p2pChatter;
        if (r0 == null) goto L5;
        this.p2pChatterLiveData.postValue(r0);
        tryGetLocalFields(this.p2pChatter);
    L5:
        this.badgePushHandler.register();
        this.chatterPushHandler.register();
        initSpecialFocusPush();
    }

    public final void destroy() {
        if (this.destroyed == true) goto L5;
        this.badgePushHandler.unRegister();
        this.chatterPushHandler.unRegister();
        this.destroyed = true;
    L5:
        this.callbackManager.cancelCallbacks();
        CoroutineScopeKt.cancel$default(this, null, 1, null);
    }

    public final void reloadUserFieldsData() {
        tryGetLocalFields((Chatter) this.p2pChatterLiveData.getValue());
    }

    public void onCleared() {
        super.onCleared();
        destroy();
    }

    public final MutableLiveData<Integer> getBadgeCountLiveData() {
        return this.badgeCountLiveData;
    }

    public final v getChatContainer() {
        return this.chatContainer;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final Chat getInitChat() {
        return this.initChat;
    }

    public final Chatter getP2pChatter() {
        return this.p2pChatter;
    }

    public final MutableLiveData<Chatter> getP2pChatterLiveData() {
        return this.p2pChatterLiveData;
    }

    public final MutableLiveData<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c> getP2pUserFieldsLiveData() {
        return this.p2pUserFieldsLiveData;
    }

    public static final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b access$getUserFieldsService(TitlebarViewModel r0) {
        return r0.getUserFieldsService();
    }

    private final void forceGetServerData(final String r4) {
        IGetDataCallback<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c> r0 = new TitlebarViewModel$forceGetServerData$callback$1(r4, this);
        Log.d(FIELD_LOG_TAG, "tryGetLocalFields userId=" + r4);
        getUserFieldsService().X7(r4, (IGetDataCallback) this.callbackManager.wrapAndAddCallback(r0));
    }

    private final void tryGetLocalFields(Chatter r5) {
        if (r5 != null) goto L6;
        Log.d(FIELD_LOG_TAG, "tryGetLocalFields: chatter=null");
        return;
    L6:
        final String r6 = r5.getId();
        if (getUserFieldsService().O8() == true) goto L11;
        this.p2pUserFieldsLiveData.postValue(getUserFieldsService().Eb(r6));
        return;
    L11:
        if (this.initChat.isP2PChat() == true) goto L13;
    L17:
        this.p2pUserFieldsLiveData.postValue(getUserFieldsService().Eb(r6));
        return;
    L13:
        if (this.initChat.isSecret() == true) goto L17;
        IGetDataCallback<com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.c> r1 = new TitlebarViewModel$tryGetLocalFields$callback$1(this, r6);
        Log.d(FIELD_LOG_TAG, "tryGetLocalFields userId=" + r6);
        getUserFieldsService().w3(r6, (IGetDataCallback) this.callbackManager.wrapAndAddCallback(r1));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c.a
    public void onBadgeChange(int r2) {
        this.badgeCountLiveData.postValue(Integer.valueOf(r2));
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.d.a
    public void onPushUpdatedChatter(Chatter r3) {
        Intrinsics.checkNotNullParameter(r3, "chatter");
        if (this.initChat.isP2PChat() == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.getId(), this.initChat.getP2pChatterId()) == false) goto L9;
        this.p2pChatterLiveData.postValue(r3);
        return;
    }

    public final void setBadgeCountLiveData(MutableLiveData<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.badgeCountLiveData = r2;
    }

    public final void setInitChat(Chat r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.initChat = r2;
    }

    public final void setP2pChatter(Chatter r1) {
        this.p2pChatter = r1;
    }

    public final void setP2pChatterLiveData(MutableLiveData<Chatter> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p2pChatterLiveData = r2;
    }

    public final void triggerUpdateNewP2PChatter(boolean r4) {
        if (this.initChat.isP2PChat() == true) goto L5;
        return;
    L5:
        String r0 = this.initChat.getP2pChatterId();
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r4, this, r0));
        return;
    L8:
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ void access$forceGetServerData(TitlebarViewModel r0, String r1) {
        r0.forceGetServerData(r1);
    }

    public TitlebarViewModel(v r2, Chat r3, Chatter r4) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r3, "initChat");
        this.chatContainer = r2;
        this.initChat = r3;
        this.p2pChatter = r4;
        this.badgeCountLiveData = new MutableLiveData();
        this.p2pChatterLiveData = new MutableLiveData();
        this.p2pUserFieldsLiveData = new MutableLiveData();
        this.badgePushHandler = new c(this);
        this.chatterPushHandler = new d(this.initChat.getId(), this);
        this.callbackManager = new CallbackManager();
        this.userFieldsService$delegate = LazyKt.lazy(new TitlebarViewModel$userFieldsService$2(this));
        this.coroutineContext = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain());
    }

    public static /* synthetic */ void triggerUpdateNewP2PChatter$default(TitlebarViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.triggerUpdateNewP2PChatter(r1);
    }
}
