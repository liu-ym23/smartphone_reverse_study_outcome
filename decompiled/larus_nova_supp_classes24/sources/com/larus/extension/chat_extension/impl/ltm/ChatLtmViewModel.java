package com.larus.extension.chat_extension.impl.ltm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.extension.chat_extension.impl.ltm.view.ChatLtmBaseHolder;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 K2\u00020\u0001:\u0001KB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0082@¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010\u0007J\u0010\u0010>\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010\u0007J\u001a\u0010?\u001a\u0004\u0018\u00010@2\b\u0010=\u001a\u0004\u0018\u00010\u0007H\u0082@¢\u0006\u0002\u0010AJ\u0014\u0010B\u001a\u0002042\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070!J\u001c\u0010D\u001a\u00020;2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070!H\u0082@¢\u0006\u0002\u0010EJ\u0006\u0010F\u001a\u000204J\u000e\u0010G\u001a\u00020;H\u0082@¢\u0006\u0002\u00109J \u0010H\u001a\u0002012\b\u0010I\u001a\u0004\u0018\u00010\u00072\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020)0-¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "value", "", "botID", "getBotID", "()Ljava/lang/String;", "setBotID", "(Ljava/lang/String;)V", "conversationID", "getConversationID", "setConversationID", "currentPage", "getCurrentPage", "setCurrentPage", "previousPage", "getPreviousPage", "setPreviousPage", "targetMemoryContent", "getTargetMemoryContent", "setTargetMemoryContent", "config", "Lcom/larus/im/bean/bot/BotMemoryConfig;", "getConfig", "()Lcom/larus/im/bean/bot/BotMemoryConfig;", "setConfig", "(Lcom/larus/im/bean/bot/BotMemoryConfig;)V", "_itemListData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/extension/chat_extension/impl/ltm/ChatLtmItemData;", "itemListData", "Landroidx/lifecycle/LiveData;", "getItemListData", "()Landroidx/lifecycle/LiveData;", "_insertStatus", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotRespStatus;", "get_insertStatus", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "insertStatus", "Lkotlinx/coroutines/flow/SharedFlow;", "getInsertStatus", "()Lkotlinx/coroutines/flow/SharedFlow;", "ids", "", "testContentList", "loadData", "", "initNoNetwork", "initList", "localList", "_requireLtmList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isOverCnt", "", "isOverSize", "content", "requireInsertLtmItem", "_requireInsertLtmItem", "Lcom/larus/extension/chat_extension/impl/ltm/InsertBotMemoryData;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireDeleteLtmItem", "memoryIDS", "_requireDeleteLtmItem", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireClearLtmItem", "_requireClearLtm", "findMemoryIndex", "memoryTipSubTitle", "list", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ChatLtmViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "ChatLtmViewModel";
    private final MutableSharedFlow<InsertBotRespStatus> _insertStatus;
    private final MutableLiveData<List<r>> _itemListData;
    private String botID;
    private BotMemoryConfig config;
    private String conversationID;
    private String currentPage;
    private final List<Integer> ids;
    private final d1<InsertBotRespStatus> insertStatus;
    private final LiveData<List<r>> itemListData;
    private String previousPage;
    private String targetMemoryContent;
    private final List<String> testContentList;

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireClearLtm$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {304}, m = "_requireClearLtm", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass1(ChatLtmViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return ChatLtmViewModel.access$_requireClearLtm(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireDeleteLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {271}, m = "_requireDeleteLtmItem", n = {}, s = {})
    public static final class C02521 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02521(ChatLtmViewModel r1, Continuation<? super C02521> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return ChatLtmViewModel.access$_requireDeleteLtmItem(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireInsertLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {232}, m = "_requireInsertLtmItem", n = {}, s = {})
    public static final class C02531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02531(ChatLtmViewModel r1, Continuation<? super C02531> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return ChatLtmViewModel.access$_requireInsertLtmItem(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$_requireLtmList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel", f = "ChatLtmViewModel.kt", i = {}, l = {126}, m = "_requireLtmList", n = {}, s = {})
    public static final class C02541 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02541(ChatLtmViewModel r1, Continuation<? super C02541> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return ChatLtmViewModel.access$_requireLtmList(this.this$0, this);
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$loadData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$loadData$1", f = "ChatLtmViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02551(ChatLtmViewModel r1, Continuation<? super C02551> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02551(this.this$0, r3);
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
        L11:
            List r5 = (List) r4;
            if (r5 == null) goto L14;
        L17:
            ChatLtmViewModel.access$get_itemListData$p(this.this$0).postValue(r5);
            return Unit.INSTANCE;
        L14:
            if (this.this$0.getBotID() == null) goto L16;
            r5 = ChatLtmViewModel.access$initNoNetwork(this.this$0);
            goto L17
        L16:
            r5 = ChatLtmViewModel.access$initList(this.this$0);
            goto L17
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ChatLtmViewModel r6 = this.this$0;
            this.label = 1;
            r4 = ChatLtmViewModel.access$_requireLtmList(r6, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireClearLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireClearLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02561(ChatLtmViewModel r1, Continuation<? super C02561> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02561(this.this$0, r3);
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
            if (((Boolean) r4).booleanValue() == false) goto L15;
            ChatLtmViewModel.access$get_itemListData$p(this.this$0).postValue(ChatLtmViewModel.access$initNoNetwork(this.this$0));
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ChatLtmViewModel r5 = this.this$0;
            this.label = 1;
            r4 = ChatLtmViewModel.access$_requireClearLtm(r5, this);
            if (r4 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireDeleteLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireDeleteLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $memoryIDS;
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02571(ChatLtmViewModel r1, List<String> r2, Continuation<? super C02571> r3) {
            this.this$0 = r1;
            this.$memoryIDS = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02571(this.this$0, this.$memoryIDS, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r20);
            Object r3 = r20;
        L12:
            if (((Boolean) r3).booleanValue() == false) goto L34;
            List r4 = (List) ChatLtmViewModel.access$get_itemListData$p(this.this$0).getValue();
            if (r4 == null) goto L34;
            List r5 = CollectionsKt.toMutableList(r4);
            if (r5 == null) goto L34;
            ChatLtmViewModel r6 = this.this$0;
            final List<String> r7 = this.$memoryIDS;
            CollectionsKt.removeAll(r5, new s(r7));
            ArrayList r8 = new ArrayList();
            Iterator r9 = r5.iterator();
            int r10 = 0;
        L19:
            if (r9.hasNext() == false) goto L32;
            Object r11 = r9.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            r r13 = (r) r11;
            if (r10 != 1) goto L26;
            boolean r17 = true;
        L28:
            if (r10 != (r5.size() - 1)) goto L30;
            boolean r16 = true;
        L31:
            String r14 = r13.a;
            String r15 = r13.b;
            ChatLtmStatus r19 = r13.c;
            String r110 = r13.d;
            int r111 = r13.e;
            boolean r21 = r13.h;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r14, "id");
            Intrinsics.checkNotNullParameter(r15, "content");
            Intrinsics.checkNotNullParameter(r19, "status");
            Intrinsics.checkNotNullParameter(r110, "date");
            r8.add(new r(r14, r15, r19, r110, r111, r16, r17, r21));
            r10 = r12;
            goto L19
        L30:
            r16 = false;
            goto L31
        L26:
            r17 = false;
            goto L28
        L32:
            ChatLtmViewModel.access$get_itemListData$p(r6).postValue(r8);
        L34:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r20);
            ChatLtmViewModel r22 = this.this$0;
            List<String> r23 = this.$memoryIDS;
            this.label = 1;
            r3 = ChatLtmViewModel.access$_requireDeleteLtmItem(r22, r23, this);
            if (r3 != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$1", f = "ChatLtmViewModel.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public C02581(ChatLtmViewModel r1, Continuation<? super C02581> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02581(this.this$0, r3);
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
            MutableSharedFlow<InsertBotRespStatus> r5 = this.this$0.get_insertStatus();
            InsertBotRespStatus r2 = InsertBotRespStatus.StartInsert;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$2", f = "ChatLtmViewModel.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass2(ChatLtmViewModel r1, Continuation<? super AnonymousClass2> r2) {
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
            MutableSharedFlow<InsertBotRespStatus> r5 = this.this$0.get_insertStatus();
            InsertBotRespStatus r2 = InsertBotRespStatus.OutOfCntLimit;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$3", f = "ChatLtmViewModel.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        public AnonymousClass3(ChatLtmViewModel r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
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
            MutableSharedFlow<InsertBotRespStatus> r5 = this.this$0.get_insertStatus();
            InsertBotRespStatus r2 = InsertBotRespStatus.OutOfSizeLimit;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4", f = "ChatLtmViewModel.kt", i = {0, 1, 2, 3, 4, 5, 6}, l = {183, 199, 203, 207, 211, 215, 219}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatLtmViewModel this$0;

        /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmViewModel$requireInsertLtmItem$4$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[InsertBotRespStatus.values().length];
                r0[InsertBotRespStatus.Success.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[InsertBotRespStatus.OutOfCntLimit.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[InsertBotRespStatus.OutOfSizeLimit.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[InsertBotRespStatus.ReviewNotPass.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[InsertBotRespStatus.RepeatedMemory.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        public AnonymousClass4(ChatLtmViewModel r1, String r2, Continuation<? super AnonymousClass4> r3) {
            this.this$0 = r1;
            this.$content = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass4 r0 = new AnonymousClass4(this.this$0, this.$content, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r19) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L6;
                case 3: goto L6;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r19);
        L64:
            return Unit.INSTANCE;
        L7:
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r19);
            Object r4 = r19;
        L11:
            InsertBotMemoryData r5 = (InsertBotMemoryData) r4;
            if (r5 == null) goto L62;
            ChatLtmViewModel r6 = this.this$0;
            String r8 = this.$content;
            InsertBotRespStatus r7 = r5.getStatus();
            if (r7 != null) goto L16;
            int r9 = -1;
        L18:
            if (r9 == 1) goto L42;
            if (r9 != 2) goto L22;
            MutableSharedFlow<InsertBotRespStatus> r10 = r6.get_insertStatus();
            InsertBotRespStatus r11 = InsertBotRespStatus.OutOfCntLimit;
            this.L$0 = r3;
            this.label = 3;
            if (r10.emit(r11, this) != r1) goto L64;
            return r1;
        L22:
            if (r9 != 3) goto L24;
            MutableSharedFlow<InsertBotRespStatus> r12 = r6.get_insertStatus();
            InsertBotRespStatus r13 = InsertBotRespStatus.OutOfSizeLimit;
            this.L$0 = r3;
            this.label = 4;
            if (r12.emit(r13, this) != r1) goto L64;
            return r1;
        L24:
            if (r9 == 4) goto L32;
            if (r9 == 5) goto L29;
            MutableSharedFlow<InsertBotRespStatus> r14 = r6.get_insertStatus();
            InsertBotRespStatus r15 = InsertBotRespStatus.FailInsert;
            this.L$0 = r3;
            this.label = 7;
            if (r14.emit(r15, this) != r1) goto L64;
            return r1;
        L29:
            MutableSharedFlow<InsertBotRespStatus> r16 = r6.get_insertStatus();
            InsertBotRespStatus r17 = InsertBotRespStatus.RepeatedMemory;
            this.L$0 = r3;
            this.label = 6;
            if (r16.emit(r17, this) != r1) goto L64;
            return r1;
        L32:
            MutableSharedFlow<InsertBotRespStatus> r20 = r6.get_insertStatus();
            InsertBotRespStatus r21 = InsertBotRespStatus.ReviewNotPass;
            this.L$0 = r3;
            this.label = 5;
            if (r20.emit(r21, this) != r1) goto L64;
            return r1;
        L42:
            if (r5.getMemoryId() == null) goto L64;
            if (((List) ChatLtmViewModel.access$get_itemListData$p(r6).getValue()) == null) goto L58;
            List r22 = (List) ChatLtmViewModel.access$get_itemListData$p(r6).getValue();
            if (r22 == null) goto L58;
            ArrayList r23 = new ArrayList();
            Iterator r24 = r22.iterator();
        L50:
            if (r24.hasNext() == false) goto L57;
            Object r25 = r24.next();
            if (((r) r25).c != ChatLtmStatus.PLACEHOLDER) goto L54;
            boolean r110 = true;
        L55:
            if (r110 == true) goto L50;
            r23.add(r25);
            goto L50
        L54:
            r110 = false;
            goto L55
        L57:
            List r26 = CollectionsKt.toMutableList(r23);
            int r27 = 2;
            ListProtector.add(r26, 2, new r(r5.getMemoryId(), r8, ChatLtmStatus.NORMAL, null, 0, false, false, false, 248));
            ChatLtmViewModel.access$get_itemListData$p(r6).postValue(r26);
        L59:
            MutableSharedFlow<InsertBotRespStatus> r29 = r6.get_insertStatus();
            InsertBotRespStatus r30 = InsertBotRespStatus.Success;
            this.L$0 = r3;
            this.label = r27;
            if (r29.emit(r30, this) != r1) goto L64;
            return r1;
        L58:
            r27 = 2;
            goto L59
        L16:
            r9 = a.a[r7.ordinal()];
            goto L18
        L62:
            ChatLtmViewModel r31 = this.this$0;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(r31), null, null, new ChatLtmViewModel$requireInsertLtmItem$4$2$1(r31, null), 3, null);
            goto L64
        L8:
            ResultKt.throwOnFailure(r19);
            r3 = (CoroutineScope) this.L$0;
            ChatLtmViewModel r32 = this.this$0;
            String r33 = this.$content;
            this.L$0 = r3;
            this.label = 1;
            r4 = ChatLtmViewModel.access$_requireInsertLtmItem(r32, r33, this);
            if (r4 != r1) goto L11;
            return r1;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    private final List<r> initList() {
        return CollectionsKt.listOf(new r("-1", "", ChatLtmStatus.NO_STATUS, null, ChatLtmBaseHolder.Companion.ChatItemViewType.TITLE.getValue(), false, false, false, 232));
    }

    private final List<r> initNoNetwork() {
        return CollectionsKt.listOf(new r("-1", "", ChatLtmStatus.NO_STATUS, null, ChatLtmBaseHolder.Companion.ChatItemViewType.TITLE.getValue(), false, false, false, 232));
    }

    public final boolean isOverCnt() {
        List r0 = (List) this.itemListData.getValue();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L6:
        int r2 = r1 - 1;
        BotMemoryConfig r3 = this.config;
        if (r3 == null) goto L11;
        Integer r4 = r3.getBotMemoryCntLimit();
        if (r4 == null) goto L11;
        int r5 = r4.intValue();
    L12:
        if (r2 < r5) goto L15;
        return true;
    L15:
        return false;
    L11:
        r5 = LKUIToast.DURATION_MAX;
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    private final List<r> localList() {
        return CollectionsKt.toMutableList(initList());
    }

    public final void loadData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02551(this, null), 2, null);
    }

    public final void requireClearLtmItem() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02561(this, null), 2, null);
    }

    public final String getBotID() {
        return this.botID;
    }

    public final BotMemoryConfig getConfig() {
        return this.config;
    }

    public final String getConversationID() {
        return this.conversationID;
    }

    public final String getCurrentPage() {
        return this.currentPage;
    }

    public final d1<InsertBotRespStatus> getInsertStatus() {
        return this.insertStatus;
    }

    public final LiveData<List<r>> getItemListData() {
        return this.itemListData;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final String getTargetMemoryContent() {
        return this.targetMemoryContent;
    }

    public final MutableSharedFlow<InsertBotRespStatus> get_insertStatus() {
        return this._insertStatus;
    }

    public ChatLtmViewModel(Application r6) {
        Intrinsics.checkNotNullParameter(r6, "application");
        super(r6);
        MutableLiveData<List<r>> r0 = new MutableLiveData();
        this._itemListData = r0;
        this.itemListData = r0;
        MutableSharedFlow<InsertBotRespStatus> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._insertStatus = r1;
        this.insertStatus = r1;
        loadData();
        List<Integer> r2 = CollectionsKt.listOf(new Integer[]{2131899209, 2131899210, 2131899211, 2131899212});
        this.ids = r2;
        List<Integer> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        int r7 = ((Number) r5.next()).intValue();
        if (com.larus.utils.i.h(r6) == true) goto L8;
        String r8 = r6.getString(2131899214) + r6.getString(r7);
    L9:
        r4.add(r8);
        goto L4
    L8:
        r8 = r6.getString(r7) + r6.getString(2131899214);
        goto L9
    L10:
        this.testContentList = r4;
    }

    private final Object _requireClearLtm(Continuation<? super Boolean> r19) {
        if ((r19 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r2 = (AnonymousClass1) r19;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        AnonymousClass1 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        boolean r15 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L21:
        com.larus.network.http.f r6 = (com.larus.network.http.a) r1;
        if ((r6 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger.a.e(TAG, "_requireClearLtm error, msg is " + r6.d.getMessage());
        r15 = false;
    L25:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (this.botID == null) goto L17;
        JSONObject r7 = new JSONObject();
        r7.put("bot_id", this.botID);
        Unit r8 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Message", ClearOrDeleteResponse.class, "/chat/memory/clear", r7, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L21;
        return r4;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r2 = new AnonymousClass1(this, r19);
        goto L8
    }

    private final Object _requireLtmList(Continuation<? super List<r>> r22) {
        if ((r22 instanceof C02541) == false) goto L7;
        C02541 r2 = (C02541) r22;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        C02541 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        List r16 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L23:
        com.larus.network.http.f r6 = (com.larus.network.http.a) r1;
        if ((r6 instanceof com.larus.network.http.f) == false) goto L26;
        FLogger.a.e(TAG, "getUserLtmList error, msg is " + r6.d.getMessage());
        return null;
    L26:
        ListBotMemoryDataV2 r7 = (ListBotMemoryDataV2) ((com.larus.network.http.a) r6).b;
        if (r7 == null) goto L34;
        List<BotMemoryItemV2> r8 = r7.getSavedMemory();
        if (r8 == null) goto L34;
        if ((!r8.isEmpty()) == false) goto L34;
    L36:
        if (r8 == null) goto L64;
        List<BotMemoryItemV2> r9 = r8;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
        int r12 = 0;
    L39:
        if (r11.hasNext() == false) goto L63;
        Object r14 = r11.next();
        int r15 = r12 + 1;
        if (r12 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        BotMemoryItemV2 r17 = (BotMemoryItemV2) r14;
        String r19 = r17.getId();
        if (r19 != null) goto L46;
        String r110 = "";
    L47:
        String r20 = r17.getContent();
        if (r20 != null) goto L50;
        String r111 = "";
    L51:
        ChatLtmStatus r112 = ChatLtmStatus.NORMAL;
        String r21 = r17.getDate();
        if (r21 != null) goto L54;
        String r113 = "";
    L55:
        if (r12 != 0) goto L57;
        boolean r114 = true;
    L59:
        if (r12 != (r8.size() - 1)) goto L61;
        boolean r115 = true;
    L62:
        r10.add(new r(r110, r111, r112, r113, 0, r115, r114, Intrinsics.areEqual(r17.getContent(), this.targetMemoryContent), 16));
        r12 = r15;
        goto L39
    L61:
        r115 = false;
        goto L62
    L57:
        r114 = false;
        goto L59
    L54:
        r113 = r21;
        goto L55
    L50:
        r111 = r20;
        goto L51
    L46:
        r110 = r19;
        goto L47
    L63:
        r16 = CollectionsKt.toMutableList(r10);
    L64:
        List r23 = r16;
        if (r23 == null) goto L67;
        Boxing.boxBoolean(r23.addAll(0, initList()));
    L67:
        if (r23 != null) goto L70;
        return localList();
    L70:
        return r23;
    L34:
        r8 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (this.botID != null) goto L18;
        FLogger.a.e(TAG, "botID is null");
        Unit r24 = Unit.INSTANCE;
    L18:
        if (this.botID != null) goto L20;
        return null;
    L20:
        JSONObject r25 = new JSONObject();
        r25.put("bot_id", this.botID);
        Unit r26 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Message", ListBotMemoryDataV2.class, "/chat/memory/list", r25, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L23;
        return r4;
    L7:
        r2 = new C02541(this, r22);
        goto L8
    }

    public static final /* synthetic */ MutableLiveData access$get_itemListData$p(ChatLtmViewModel r0) {
        return r0._itemListData;
    }

    public static final /* synthetic */ List access$initList(ChatLtmViewModel r0) {
        return r0.initList();
    }

    public static final /* synthetic */ List access$initNoNetwork(ChatLtmViewModel r0) {
        return r0.initNoNetwork();
    }

    public final boolean isOverSize(String r3) {
        if (r3 == null) goto L5;
        int r4 = r3.length();
    L6:
        BotMemoryConfig r1 = this.config;
        if (r1 == null) goto L11;
        Integer r2 = r1.getBotMemorySizeLimit();
        if (r2 == null) goto L11;
        int r5 = r2.intValue();
    L12:
        if (r4 <= r5) goto L15;
        return true;
    L15:
        return false;
    L11:
        r5 = LKUIToast.DURATION_MAX;
        goto L12
    L5:
        r4 = 0;
        goto L6
    }

    public final void requireDeleteLtmItem(List<String> r8) {
        Intrinsics.checkNotNullParameter(r8, "memoryIDS");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02571(this, r8, null), 2, null);
    }

    public final void requireInsertLtmItem(String r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02581(this, null), 3, null);
        if (isOverCnt() == false) goto L8;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L8:
        int r0 = r14.length();
        BotMemoryConfig r1 = this.config;
        if (r1 == null) goto L13;
        Integer r2 = r1.getBotMemorySizeLimit();
        if (r2 == null) goto L13;
        int r3 = r2.intValue();
    L14:
        if (r0 <= r3) goto L17;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(this, null), 3, null);
        return;
    L17:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass4(this, r14, null), 2, null);
        return;
    L13:
        r3 = LKUIToast.DURATION_MAX;
        goto L14
    }

    public final void setBotID(String r1) {
        this.botID = r1;
        loadData();
    }

    public final void setConfig(BotMemoryConfig r1) {
        this.config = r1;
    }

    public final void setConversationID(String r1) {
        this.conversationID = r1;
    }

    public final void setCurrentPage(String r1) {
        this.currentPage = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public final void setTargetMemoryContent(String r1) {
        this.targetMemoryContent = r1;
    }

    private final Object _requireDeleteLtmItem(List<String> r19, Continuation<? super Boolean> r110) {
        if ((r110 instanceof C02521) == false) goto L7;
        C02521 r2 = (C02521) r110;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        C02521 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        boolean r15 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L21:
        com.larus.network.http.f r6 = (com.larus.network.http.a) r1;
        if ((r6 instanceof com.larus.network.http.f) == false) goto L25;
        FLogger.a.e(TAG, "requireDeleteLtmItem error, msg is " + r6.d.getMessage());
        r15 = false;
    L25:
        return Boxing.boxBoolean(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (this.botID == null) goto L17;
        JSONObject r7 = new JSONObject();
        r7.put("bot_id", this.botID);
        JSONObject r8 = new JSONObject();
        r8.put("saved_memory", new JSONArray(r19));
        Unit r9 = Unit.INSTANCE;
        r7.put("memory_ids", r8);
        r13.label = 1;
        r1 = HttpExtKt.k("Message", ClearOrDeleteResponse.class, "/chat/memory/delete", r7, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L21;
        return r4;
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r2 = new C02521(this, r110);
        goto L8
    }

    private final Object _requireInsertLtmItem(String r17, Continuation<? super InsertBotMemoryData> r19) {
        if ((r19 instanceof C02531) == false) goto L7;
        C02531 r2 = (C02531) r19;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        C02531 r13 = r2;
        Object r1 = r13.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r13.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L20:
        com.larus.network.http.f r6 = (com.larus.network.http.a) r1;
        if ((r6 instanceof com.larus.network.http.f) == false) goto L24;
        FLogger.a.e(TAG, "requireInsertLtmItem error, msg is " + r6.d.getMessage());
        return null;
    L24:
        return (InsertBotMemoryData) ((com.larus.network.http.a) r6).b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (this.botID != null) goto L17;
        return null;
    L17:
        JSONObject r7 = new JSONObject();
        r7.put("bot_id", this.botID);
        r7.put("memory_content", r17);
        Unit r8 = Unit.INSTANCE;
        r13.label = 1;
        r1 = HttpExtKt.k("Message", InsertBotMemoryData.class, "/alice/bot/insert_memory", r7, null, null, false, null, null, null, r13, 1008);
        if (r1 != r4) goto L20;
        return r4;
    L7:
        r2 = new C02531(this, r19);
        goto L8
    }

    public static final /* synthetic */ Object access$_requireClearLtm(ChatLtmViewModel r0, Continuation r1) {
        return r0._requireClearLtm(r1);
    }

    public static final /* synthetic */ Object access$_requireLtmList(ChatLtmViewModel r0, Continuation r1) {
        return r0._requireLtmList(r1);
    }

    public final int findMemoryIndex(String r9, List<r> r10) {
        Integer r0 = null;
        if (r9 == null) goto L5;
        String r11 = StringsKt.trim(r9).toString();
    L6:
        if (r10 != null) goto L9;
        r10 = CollectionsKt.emptyList();
    L9:
        if (r11 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return 0;
    L17:
        if (r10.isEmpty() == true) goto L52;
        int r4 = r10.size();
        int r5 = 0;
    L20:
        if (r5 >= r4) goto L39;
        r r6 = (r) ListProtector.get(r10, r5);
        if (r6.c == ChatLtmStatus.NO_STATUS) goto L38;
        String r7 = r6.b;
        if (r7.length() != 0) goto L26;
        boolean r8 = true;
    L27:
        if (r8 == true) goto L38;
        if (Intrinsics.areEqual(r7, r11) == true) goto L30;
        if (StringsKt.equals(r7, r11, true) == true) goto L33;
        if (r0 != null) goto L38;
        if (StringsKt.contains(r7, r11, true) == false) goto L38;
        r0 = Integer.valueOf(r5);
        goto L38
    L33:
        return r5;
    L30:
        return r5;
    L26:
        r8 = false;
    L38:
        r5 = r5 + 1;
        goto L20
    L39:
        if (r0 != null) goto L41;
        return 0;
    L41:
        return r0.intValue();
    L52:
        return 0;
    L11:
        if (r11.length() == 0) goto L14;
        r3 = false;
        goto L15
    L5:
        r11 = null;
        goto L6
    }

    public static final /* synthetic */ Object access$_requireDeleteLtmItem(ChatLtmViewModel r0, List r1, Continuation r2) {
        return r0._requireDeleteLtmItem(r1, r2);
    }

    public static final /* synthetic */ Object access$_requireInsertLtmItem(ChatLtmViewModel r0, String r1, Continuation r2) {
        return r0._requireInsertLtmItem(r1, r2);
    }
}
