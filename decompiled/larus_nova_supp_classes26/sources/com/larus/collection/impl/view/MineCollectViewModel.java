package com.larus.collection.impl.view;

import android.app.Activity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.collection.profile.api.CollectServiceDelegate;
import com.collection.profile.api.network.ListCollectionResponse;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.collection.CollectionReportDelegate;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.collection.impl.bean.CollectionListRequest;
import com.larus.collection.impl.bean.CollectionListScene;
import com.larus.collection.impl.repo.CollectionApi;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.network.FlowHttpConnection;
import com.larus.network.http.y;
import com.larus.platform.model.CollectionDetail;
import com.larus.platform.model.MessageCollection;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import hq9.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\b\b\u0001\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\u0012\u0010!\u001a\u00020\u001b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010\"\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016J\u001e\u0010#\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\u0007H\u0002J\f\u0010(\u001a\u00020\u0007*\u00020&H\u0002J\u000e\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\nJ\b\u0010+\u001a\u00020\u001bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006-"}, d2 = {"Lcom/larus/collection/impl/view/MineCollectViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "isCleared", "", "currentCollectionList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/platform/model/MessageCollection;", "currentIndex", "", "lastUpdateTime", "", "scene", "getScene$annotations", "loadMoreState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getLoadMoreState", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "lastCancelCollectionId", "", "collectionListLiveData", "Lcom/larus/collection/impl/view/CollectionListResponse;", "getCollectionListLiveData", "setScene", "", "setLastCancelCollectionId", "collectionId", "queryCollectList", "downgradeSource", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "requestMoreCollection", "cancelCollection", "updateQaCollectState", "messages", "", "Lcom/larus/im/bean/message/Message;", "collected", "needHideAvatarButtonInCollection", "cancelLikeCollection", "item", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MineCollectViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int FIRST_PAGE_INDEX = 1;
    public static final int PAGE_SIZE = 10;
    public static final String TAG = "MineCollectViewModel";
    private final MutableSharedFlow<b> collectionListLiveData;
    private CopyOnWriteArrayList<MessageCollection> currentCollectionList;
    private int currentIndex;
    private final ExecutorCoroutineDispatcher dispatcher;
    private volatile boolean isCleared;
    private String lastCancelCollectionId;
    private long lastUpdateTime;
    private final MutableSharedFlow<Integer> loadMoreState;
    private int scene;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectViewModel$cancelCollection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectViewModel$cancelCollection$1", f = "MineCollectViewModel.kt", i = {1, 1}, l = {196, 211}, m = "invokeSuspend", n = {"cancelCollectResponse", "collectedMessages"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MineCollectViewModel this$0;

        public AnonymousClass1(String r1, MineCollectViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$collectionId = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$collectionId, this.this$0, r4);
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
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            List r2 = (List) this.L$1;
            com.larus.network.http.a r3 = (com.larus.network.http.a) this.L$0;
            ResultKt.throwOnFailure(r15);
        L70:
            if ((r3 instanceof y) == false) goto L77;
            MineCollectViewModel r16 = this.this$0;
            if (r2 != null) goto L74;
            r2 = CollectionsKt.emptyList();
        L74:
            MineCollectViewModel.access$updateQaCollectState(r16, r2, false);
            Activity r17 = AppHost.a.a().getCurrentActivity();
            if (r17 == null) goto L79;
            t19.s.a.g(r17, 2131910858, false);
        L79:
            return Unit.INSTANCE;
        L77:
            FLogger.a.i(MineCollectViewModel.TAG, "cancelCollection, Fail");
            goto L79
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r15);
        L13:
            r3 = (com.larus.network.http.a) r15;
            CopyOnWriteArrayList r18 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            Integer r4 = null;
            if (r18 == null) goto L33;
            String r6 = this.$collectionId;
            Iterator r19 = r18.iterator();
        L17:
            if (r19.hasNext() == false) goto L21;
            Object r7 = r19.next();
            if (Intrinsics.areEqual(((MessageCollection) r7).getCollectionId(), r6) == false) goto L17;
        L22:
            MessageCollection r8 = (MessageCollection) r7;
            if (r8 == null) goto L33;
            List r110 = r8.getCollectionDetails();
            if (r110 == null) goto L33;
            ArrayList r9 = new ArrayList();
            Iterator r111 = r110.iterator();
        L28:
            if (r111.hasNext() == false) goto L32;
            Message r10 = k0.a((CollectionDetail) r111.next());
            if (r10 == null) goto L28;
            r9.add(r10);
            goto L28
        L32:
            ArrayList r112 = r9;
        L34:
            if (r112 == null) goto L36;
            Message r11 = (Message) CollectionsKt.getOrNull(r112, 0);
        L37:
            CollectionReportDelegate r12 = CollectionReportDelegate.b;
            if (r11 == null) goto L40;
            String r13 = r11.getSenderId();
        L41:
            if (r11 == null) goto L43;
            String r14 = r11.getConversationId();
        L44:
            ICollectionReport.a.b(r12, r3, r112, "long_press_cell", "bot_list_profile", r13, r14, 64);
            CopyOnWriteArrayList r20 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r20 == null) goto L58;
            CopyOnWriteArrayList r21 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r21 == null) goto L56;
            String r22 = this.$collectionId;
            Iterator r23 = r21.iterator();
        L50:
            if (r23.hasNext() == false) goto L54;
            Object r24 = r23.next();
            if (Intrinsics.areEqual(((MessageCollection) r24).getCollectionId(), r22) == false) goto L50;
        L55:
            MessageCollection r25 = (MessageCollection) r24;
        L57:
            Boxing.boxBoolean(r20.remove(r25));
            goto L58
        L54:
            r24 = null;
            goto L55
        L56:
            r25 = null;
        L58:
            FLogger r26 = FLogger.a;
            StringBuilder r27 = new StringBuilder("cancelCollection, current size = ");
            CopyOnWriteArrayList r28 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r28 == null) goto L61;
            r4 = Boxing.boxInt(r28.size());
        L61:
            r27.append(r4);
            r26.i(MineCollectViewModel.TAG, r27.toString());
            MutableSharedFlow<b> r5 = this.this$0.getCollectionListLiveData();
            List r29 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r29 != null) goto L65;
            r29 = CollectionsKt.emptyList();
        L65:
            b r30 = new b(3, r29);
            this.L$0 = r3;
            this.L$1 = r112;
            this.label = 2;
            if (r5.emit(r30, this) != r0) goto L68;
            return r0;
        L68:
            r2 = r112;
            goto L70
        L43:
            r14 = null;
            goto L44
        L40:
            r13 = null;
            goto L41
        L36:
            r11 = null;
            goto L37
        L21:
            r7 = null;
        L33:
            r112 = null;
            goto L34
        L10:
            ResultKt.throwOnFailure(r15);
            CollectServiceDelegate r113 = CollectServiceDelegate.b;
            String r31 = this.$collectionId;
            this.label = 1;
            r15 = r113.e(r31, this);
            if (r15 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectViewModel$cancelLikeCollection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectViewModel$cancelLikeCollection$1", f = "MineCollectViewModel.kt", i = {1}, l = {259, 261}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"})
    public static final class C02701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MessageCollection $item;
        final /* synthetic */ CopyOnWriteArrayList<MessageCollection> $list;
        final /* synthetic */ List<Message> $messageList;
        boolean Z$0;
        int label;
        final /* synthetic */ MineCollectViewModel this$0;

        public C02701(List<Message> r1, MineCollectViewModel r2, CopyOnWriteArrayList<MessageCollection> r3, MessageCollection r4, Continuation<? super C02701> r5) {
            this.$messageList = r1;
            this.this$0 = r2;
            this.$list = r3;
            this.$item = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new C02701(this.$messageList, this.this$0, this.$list, this.$item, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            boolean r2 = this.Z$0;
            ResultKt.throwOnFailure(r10);
        L29:
            FLogger r11 = FLogger.a;
            r11.i(MineCollectViewModel.TAG, "cancelLikeCollection, current size = " + this.$list.size());
            if (r2 == false) goto L34;
            Activity r12 = AppHost.a.a().getCurrentActivity();
            if (r12 == null) goto L36;
            t19.s.a.g(r12, 2131908559, false);
        L36:
            return Unit.INSTANCE;
        L34:
            r11.i(MineCollectViewModel.TAG, "cancelLikeCollection, Fail");
            goto L36
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L13:
            boolean r13 = ((Boolean) r10).booleanValue();
            CopyOnWriteArrayList r3 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r3 == null) goto L25;
            CopyOnWriteArrayList r4 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            Object r5 = null;
            if (r4 == null) goto L24;
            MessageCollection r6 = this.$item;
            Iterator r7 = r4.iterator();
        L19:
            if (r7.hasNext() == false) goto L23;
            Object r8 = r7.next();
            if (Intrinsics.areEqual(((MessageCollection) r8).getCollectionId(), r6.getCollectionId()) == false) goto L19;
            r5 = r8;
        L23:
            r5 = (MessageCollection) r5;
        L24:
            Boxing.boxBoolean(r3.remove(r5));
        L25:
            MutableSharedFlow<b> r9 = this.this$0.getCollectionListLiveData();
            b r14 = new b(3, this.$list);
            this.Z$0 = r13;
            this.label = 2;
            if (r9.emit(r14, this) != r0) goto L28;
            return r0;
        L28:
            r2 = r13;
            goto L29
        L10:
            ResultKt.throwOnFailure(r10);
            CollectServiceDelegate r15 = CollectServiceDelegate.b;
            List<Message> r16 = this.$messageList;
            this.label = 1;
            r10 = r15.i(r16, this);
            if (r10 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectViewModel$queryCollectList$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectViewModel$queryCollectList$1", f = "MineCollectViewModel.kt", i = {2}, l = {93, 103, 126, 129, 132, 139, 141}, m = "invokeSuspend", n = {"collectResponse"}, s = {"L$0"})
    public static final class C02711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        Object L$0;
        int label;
        final /* synthetic */ MineCollectViewModel this$0;

        public C02711(MineCollectViewModel r1, DowngradeSource r2, Continuation<? super C02711> r3) {
            this.this$0 = r1;
            this.$downgradeSource = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02711(this.this$0, this.$downgradeSource, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object invokeSuspend(Object r19) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r14 = false;
            Message r11 = null;
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r19);
        L123:
            return Unit.INSTANCE;
        L7:
            ResultKt.throwOnFailure(r19);
        L105:
            FLogger.a.i(MineCollectViewModel.TAG, "queryCollectList  loadMoreState END");
            goto L123
        L8:
            ResultKt.throwOnFailure(r19);
        L101:
            FLogger.a.i(MineCollectViewModel.TAG, "queryCollectList  loadMoreState HAS_MORE");
            goto L123
        L9:
            ListCollectionResponse r0 = (ListCollectionResponse) this.L$0;
            ResultKt.throwOnFailure(r19);
            r11 = r11;
            boolean r12 = true;
        L94:
            if (r0 == null) goto L96;
            boolean r1 = Intrinsics.areEqual(r0.getHasMore(), Boxing.boxBoolean(r12));
        L97:
            if (r1 == false) goto L102;
            MutableSharedFlow<Integer> r2 = this.this$0.getLoadMoreState();
            Integer r3 = Boxing.boxInt(0);
            this.L$0 = r11;
            this.label = 4;
            if (r2.emit(r3, this) != r10) goto L101;
            return r10;
        L102:
            MutableSharedFlow<Integer> r4 = this.this$0.getLoadMoreState();
            Integer r5 = Boxing.boxInt(2);
            this.L$0 = r11;
            this.label = 5;
            if (r4.emit(r5, this) != r10) goto L105;
            return r10;
        L96:
            r1 = false;
            goto L97
        L10:
            ResultKt.throwOnFailure(r19);
            Object r6 = r19;
            r12 = true;
        L30:
            dm9.a.b r7 = (dm9.a) r6;
            if ((r7 instanceof dm9.a.b) == false) goto L107;
            dm9.a.b r8 = r7;
            if (r8.a.isSuccess() == false) goto L107;
            r0 = (ListCollectionResponse) r8.a.getData();
            if (r0 == null) goto L84;
            List r9 = r0.getCollectionList();
            if (r9 == null) goto L84;
            MineCollectViewModel r13 = this.this$0;
            ArrayList r15 = new ArrayList();
            Iterator r16 = r9.iterator();
        L40:
            if (r16.hasNext() == false) goto L48;
            Object r17 = r16.next();
            MessageCollection r18 = (MessageCollection) r17;
            if (r18 == null) goto L44;
            Message r20 = r18.getCollectionId();
        L45:
            boolean r21 = Intrinsics.areEqual(r20, MineCollectViewModel.access$getLastCancelCollectionId$p(r13));
            if (((r21 ? 1 : 0) ^ (r12 ? 1 : 0)) == 0) goto L40;
            r15.add(r17);
            goto L40
        L44:
            r20 = r11;
            goto L45
        L48:
            MineCollectViewModel r22 = this.this$0;
            MessageCollection r23 = (MessageCollection) CollectionsKt.lastOrNull(r15);
            if (r23 == null) goto L53;
            Long r24 = r23.getCreateTime();
            if (r24 == null) goto L53;
            long r25 = r24.longValue();
        L54:
            MineCollectViewModel.access$setLastUpdateTime$p(r22, r25);
            FLogger.a.i(MineCollectViewModel.TAG, "queryCollectList  collection Size : " + r15.size() + ", scene=" + MineCollectViewModel.access$getScene$p(r22) + ", lastCancelCollectionId = " + MineCollectViewModel.access$getLastCancelCollectionId$p(r22) + " lastUpdateTime = " + MineCollectViewModel.access$getLastUpdateTime$p(r22));
            CopyOnWriteArrayList r26 = MineCollectViewModel.access$getCurrentCollectionList$p(r22);
            if (r26 == null) goto L57;
            r26.clear();
        L57:
            CopyOnWriteArrayList r27 = MineCollectViewModel.access$getCurrentCollectionList$p(r22);
            if (r27 == null) goto L60;
            Boxing.boxBoolean(r27.addAll(r15));
        L60:
            CopyOnWriteArrayList r28 = MineCollectViewModel.access$getCurrentCollectionList$p(r22);
            if (r28 == null) goto L82;
            Iterator r29 = r28.iterator();
        L64:
            if (r29.hasNext() == false) goto L81;
            List r30 = ((MessageCollection) r29.next()).getCollectionDetails();
            if (r30 == null) goto L64;
            Iterator r31 = r30.iterator();
        L69:
            if (r31.hasNext() == false) goto L64;
            Message r32 = k0.a((CollectionDetail) r31.next());
            if (r32 == null) goto L69;
            if (MineCollectViewModel.access$needHideAvatarButtonInCollection(r22, r32) == true) goto L76;
            r32 = r11;
        L76:
            if (r32 == null) goto L69;
            RepoDispatcher.a.getClass();
            ChatRepo r33 = RepoDispatcher.d;
            String r34 = r32.getLocalMessageId();
            if (r34 != null) goto L80;
            r34 = "";
        L80:
            r33.r1(r34, new n());
            goto L69
        L81:
            Unit r35 = Unit.INSTANCE;
        L83:
            if (r35 == null) goto L84;
        L87:
            MutableSharedFlow<b> r36 = this.this$0.getCollectionListLiveData();
            List r37 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r37 != null) goto L91;
            r37 = CollectionsKt.emptyList();
        L91:
            b r38 = new b(3, r37);
            this.L$0 = r0;
            this.label = 3;
            if (r36.emit(r38, this) != r10) goto L94;
            return r10;
        L82:
            r35 = r11;
        L53:
            r25 = 0;
        L84:
            CopyOnWriteArrayList r39 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r39 == null) goto L87;
            r39.clear();
            Unit r40 = Unit.INSTANCE;
        L107:
            if ((r7 instanceof dm9.a.a) == false) goto L123;
            FLogger.a.i(MineCollectViewModel.TAG, "queryCollectList Fail");
            CopyOnWriteArrayList r41 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r41 != null) goto L111;
        L112:
            r14 = true;
        L113:
            if (r14 == false) goto L123;
            if (((dm9.a.a) r7).a == (-555)) goto L119;
            MutableSharedFlow<b> r42 = this.this$0.getCollectionListLiveData();
            b r43 = new b(r12 ? 1 : 0, CollectionsKt.emptyList());
            this.label = 6;
            if (r42.emit(r43, this) != r10) goto L123;
            return r10;
        L119:
            MutableSharedFlow<b> r44 = this.this$0.getCollectionListLiveData();
            b r45 = new b(5, CollectionsKt.emptyList());
            this.label = 7;
            if (r44.emit(r45, this) != r10) goto L123;
            return r10;
        L111:
            if (r41.isEmpty() == false) goto L113;
        L11:
            ResultKt.throwOnFailure(r19);
        L23:
            MineCollectViewModel.access$setCurrentIndex$p(this.this$0, 1);
            CollectionListRequest r46 = new CollectionListRequest(Boxing.boxInt(10), Boxing.boxInt(MineCollectViewModel.access$getCurrentIndex$p(this.this$0)), r11, Boxing.boxInt(MineCollectViewModel.access$getScene$p(this.this$0)));
            FlowDowngradeServiceDelegate r47 = FlowDowngradeServiceDelegate.INSTANCE;
            JSONObject r48 = mz8.a.a(r46);
            DowngradeSource r49 = this.$downgradeSource;
            if (r49 == null) goto L26;
            Message r50 = MapsKt.mapOf(TuplesKt.to(MusicAppletPage.KEY_SOURCE, r49.getValue()));
        L27:
            Boolean r51 = IFlowDowngradeService.a.a(r47, ListCollectionResponse.class, r48, r50);
            CollectionApi.a r52 = CollectionApi.a;
            boolean r53 = Intrinsics.areEqual(r51, Boxing.boxBoolean(true));
            MineCollectViewModel$queryCollectList$1$result$1 r54 = new MineCollectViewModel$queryCollectList$1$result$1(r46, r11);
            this.label = 2;
            r52.getClass();
            mz8.b r55 = new mz8.b(r53);
            FlowHttpConnection r56 = FlowHttpConnection.a;
            r12 = true;
            r6 = FlowHttpConnection.g("Social", CollectionApi.class, r54, true, null, null, r55, this, 112);
            if (r6 != r10) goto L30;
            return r10;
        L26:
            r50 = r11;
            goto L27
        L12:
            ResultKt.throwOnFailure(r19);
            CopyOnWriteArrayList r57 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
            if (r57 != null) goto L15;
        L18:
            boolean r58 = true;
        L19:
            if (r58 == false) goto L23;
            MutableSharedFlow<b> r59 = this.this$0.getCollectionListLiveData();
            b r60 = new b(4, CollectionsKt.emptyList());
            this.label = 1;
            if (r59.emit(r60, this) != r10) goto L23;
            return r10;
        L15:
            if (r57.isEmpty() == true) goto L18;
            r58 = false;
            goto L19
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectViewModel$requestMoreCollection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectViewModel$requestMoreCollection$1", f = "MineCollectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DowngradeSource $downgradeSource;
        int label;
        final /* synthetic */ MineCollectViewModel this$0;

        /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectViewModel$requestMoreCollection$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectViewModel$requestMoreCollection$1$1", f = "MineCollectViewModel.kt", i = {1}, l = {164, 174, 177, 179, 184}, m = "invokeSuspend", n = {"collectResponse"}, s = {"L$0"})
        public static final class C01001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DowngradeSource $downgradeSource;
            Object L$0;
            int label;
            final /* synthetic */ MineCollectViewModel this$0;

            public C01001(MineCollectViewModel r1, DowngradeSource r2, Continuation<? super C01001> r3) {
                this.this$0 = r1;
                this.$downgradeSource = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C01001(this.this$0, this.$downgradeSource, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r19) {
                Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r0 = this.label;
                Integer r8 = null;
                if (r0 == 0) goto L15;
                if (r0 == 1) goto L14;
                if (r0 == 2) goto L13;
                if (r0 == 3) goto L12;
                if (r0 == 4) goto L12;
                if (r0 == 5) goto L12;
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r19);
            L67:
                return Unit.INSTANCE;
            L13:
                ListCollectionResponse r1 = (ListCollectionResponse) this.L$0;
                ResultKt.throwOnFailure(r19);
                r8 = null;
                boolean r16 = true;
            L51:
                if (r1 == null) goto L53;
                boolean r2 = Intrinsics.areEqual(r1.getHasMore(), Boxing.boxBoolean(r16));
            L54:
                if (r2 == false) goto L58;
                MutableSharedFlow<Integer> r3 = this.this$0.getLoadMoreState();
                Integer r4 = Boxing.boxInt(0);
                this.L$0 = r8;
                this.label = 3;
                if (r3.emit(r4, this) != r10) goto L67;
                return r10;
            L58:
                MutableSharedFlow<Integer> r5 = this.this$0.getLoadMoreState();
                Integer r6 = Boxing.boxInt(2);
                this.L$0 = r8;
                this.label = 4;
                if (r5.emit(r6, this) != r10) goto L67;
                return r10;
            L53:
                r2 = false;
                goto L54
            L14:
                ResultKt.throwOnFailure(r19);
                Object r7 = r19;
                r16 = true;
            L22:
                dm9.a.b r9 = (dm9.a) r7;
                if ((r9 instanceof dm9.a.b) == false) goto L62;
                dm9.a.b r11 = r9;
                if (r11.a.isSuccess() == false) goto L62;
                r1 = (ListCollectionResponse) r11.a.getData();
                if (r1 == null) goto L39;
                List r12 = r1.getCollectionList();
                if (r12 == null) goto L39;
                MineCollectViewModel r13 = this.this$0;
                MessageCollection r14 = (MessageCollection) CollectionsKt.lastOrNull(r12);
                if (r14 == null) goto L35;
                Long r15 = r14.getCreateTime();
                if (r15 == null) goto L35;
                long r17 = r15.longValue();
            L36:
                MineCollectViewModel.access$setLastUpdateTime$p(r13, r17);
                CopyOnWriteArrayList r18 = MineCollectViewModel.access$getCurrentCollectionList$p(r13);
                if (r18 == null) goto L39;
                Boxing.boxBoolean(r18.addAll(r12));
            L35:
                r17 = 0;
            L39:
                FLogger r20 = FLogger.a;
                StringBuilder r21 = new StringBuilder("requestMoreCollection, current size =");
                CopyOnWriteArrayList r22 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
                if (r22 == null) goto L42;
                Integer r23 = Boxing.boxInt(r22.size());
            L43:
                r21.append(r23);
                r21.append(" scene=");
                r21.append(MineCollectViewModel.access$getScene$p(this.this$0));
                r21.append(" lastUpdateTime = ");
                r21.append(MineCollectViewModel.access$getLastUpdateTime$p(this.this$0));
                r20.i(MineCollectViewModel.TAG, r21.toString());
                MutableSharedFlow<b> r24 = this.this$0.getCollectionListLiveData();
                List r25 = MineCollectViewModel.access$getCurrentCollectionList$p(this.this$0);
                if (r25 != null) goto L47;
                r25 = CollectionsKt.emptyList();
            L47:
                b r26 = new b(3, r25);
                this.L$0 = r1;
                this.label = 2;
                if (r24.emit(r26, this) != r10) goto L51;
                return r10;
            L42:
                r23 = r8;
            L62:
                if ((r9 instanceof dm9.a.a) == false) goto L67;
                FLogger.a.i(MineCollectViewModel.TAG, "requestMoreCollection, Fail");
                MutableSharedFlow<Integer> r27 = this.this$0.getLoadMoreState();
                Integer r28 = Boxing.boxInt(r16 ? 1 : 0);
                this.label = 5;
                if (r27.emit(r28, this) != r10) goto L67;
                return r10;
            L15:
                ResultKt.throwOnFailure(r19);
                FLogger.a.i(MineCollectViewModel.TAG, "requestMoreCollection, lastUpdateTime = " + MineCollectViewModel.access$getLastUpdateTime$p(this.this$0));
                MineCollectViewModel r29 = this.this$0;
                MineCollectViewModel.access$setCurrentIndex$p(r29, MineCollectViewModel.access$getCurrentIndex$p(r29) + 1);
                CollectionListRequest r30 = new CollectionListRequest(Boxing.boxInt(10), Boxing.boxInt(MineCollectViewModel.access$getCurrentIndex$p(this.this$0)), Boxing.boxLong(MineCollectViewModel.access$getLastUpdateTime$p(this.this$0)), Boxing.boxInt(MineCollectViewModel.access$getScene$p(this.this$0)));
                FlowDowngradeServiceDelegate r31 = FlowDowngradeServiceDelegate.INSTANCE;
                JSONObject r32 = mz8.a.a(r30);
                DowngradeSource r33 = this.$downgradeSource;
                if (r33 == null) goto L18;
                Map r34 = MapsKt.mapOf(TuplesKt.to(MusicAppletPage.KEY_SOURCE, r33.getValue()));
            L19:
                Boolean r35 = IFlowDowngradeService.a.a(r31, ListCollectionResponse.class, r32, r34);
                CollectionApi.a r36 = CollectionApi.a;
                boolean r37 = Intrinsics.areEqual(r35, Boxing.boxBoolean(true));
                MineCollectViewModel$requestMoreCollection$1$1$result$1 r38 = new MineCollectViewModel$requestMoreCollection$1$1$result$1(r30, null);
                this.label = 1;
                r36.getClass();
                mz8.b r39 = new mz8.b(r37);
                FlowHttpConnection r40 = FlowHttpConnection.a;
                r16 = true;
                r7 = FlowHttpConnection.g("Social", CollectionApi.class, r38, true, null, null, r39, this, 112);
                if (r7 != r10) goto L22;
                return r10;
            L18:
                r34 = null;
                goto L19
            }
        }

        public C02721(MineCollectViewModel r1, DowngradeSource r2, Continuation<? super C02721> r3) {
            this.this$0 = r1;
            this.$downgradeSource = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02721(this.this$0, this.$downgradeSource, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            BuildersKt.runBlocking$default(null, new C01001(this.this$0, this.$downgradeSource, null), 1, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Map Mo(boolean r0, Map r1) {
        return updateQaCollectState$lambda$3$lambda$2(r0, r1);
    }

    @CollectionListScene
    private static /* synthetic */ void getScene$annotations() {
    }

    public static /* synthetic */ Thread yo(Runnable r0) {
        return dispatcher$lambda$0(r0);
    }

    public void onCleared() {
        this.isCleared = true;
        this.dispatcher.close();
        super.onCleared();
    }

    public MineCollectViewModel() {
        this.dispatcher = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new l()));
        this.currentCollectionList = new CopyOnWriteArrayList();
        this.currentIndex = 1;
        this.scene = 1;
        this.loadMoreState = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.collectionListLiveData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final MutableSharedFlow<b> getCollectionListLiveData() {
        return this.collectionListLiveData;
    }

    public final MutableSharedFlow<Integer> getLoadMoreState() {
        return this.loadMoreState;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getCurrentCollectionList$p(MineCollectViewModel r0) {
        return r0.currentCollectionList;
    }

    public static final /* synthetic */ int access$getCurrentIndex$p(MineCollectViewModel r0) {
        return r0.currentIndex;
    }

    public static final /* synthetic */ String access$getLastCancelCollectionId$p(MineCollectViewModel r0) {
        return r0.lastCancelCollectionId;
    }

    public static final /* synthetic */ long access$getLastUpdateTime$p(MineCollectViewModel r2) {
        return r2.lastUpdateTime;
    }

    public static final /* synthetic */ int access$getScene$p(MineCollectViewModel r0) {
        return r0.scene;
    }

    private static final Thread dispatcher$lambda$0(Runnable r2) {
        return new PthreadThreadV2(r2, "collect#loadmore-dispatcher");
    }

    private final boolean needHideAvatarButtonInCollection(Message r4) {
        String r0 = r4.getLocalMessageId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L13;
        return false;
    L13:
        if (com.larus.im.bean.message.a.Z(r4) == true) goto L15;
        return false;
    L15:
        if (com.larus.im.bean.message.a.Y(r4) == false) goto L21;
        return true;
    L21:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void cancelCollection(String r8) {
        FLogger.a.i(TAG, "cancelCollection, collectionId = " + r8);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r8, this, null), 2, null);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void cancelLikeCollection(MessageCollection r13) {
        Intrinsics.checkNotNullParameter(r13, "item");
        List r0 = r13.getCollectionDetails();
        List r1 = null;
        if (r0 == null) goto L14;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r0.iterator();
    L6:
        if (r3.hasNext() == false) goto L13;
        CollectionDetail r4 = (CollectionDetail) r3.next();
        if (Intrinsics.areEqual(r4.isLike(), Boolean.TRUE) == false) goto L10;
        Message r5 = k0.a(r4);
    L11:
        if (r5 == null) goto L6;
        r2.add(r5);
        goto L6
    L10:
        r5 = null;
        goto L11
    L13:
        r1 = r2;
    L14:
        if (r1 != null) goto L16;
        r1 = CollectionsKt.emptyList();
    L16:
        List r6 = r1;
        FLogger.a.i(TAG, "cancelLikeCollection, message size=" + r6.size());
        if (r6.isEmpty() == false) goto L19;
        return;
    L19:
        CopyOnWriteArrayList<MessageCollection> r7 = this.currentCollectionList;
        if (r7 != null) goto L22;
        return;
    L22:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02701(r6, this, r7, r13, null), 2, null);
    }

    public final void queryCollectList(DowngradeSource r10) {
        this.lastUpdateTime = 0;
        FLogger.a.i(TAG, "queryCollectList, lastUpdateTime = " + this.lastUpdateTime);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02711(this, r10, null), 3, null);
    }

    public final void requestMoreCollection(DowngradeSource r8) {
        if (this.isCleared == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), this.dispatcher, null, new C02721(this, r8, null), 2, null);
    }

    public final void setLastCancelCollectionId(String r1) {
        this.lastCancelCollectionId = r1;
    }

    public final void setScene(@CollectionListScene int r1) {
        this.scene = r1;
    }

    public static final /* synthetic */ boolean access$needHideAvatarButtonInCollection(MineCollectViewModel r0, Message r1) {
        return r0.needHideAvatarButtonInCollection(r1);
    }

    public static final /* synthetic */ void access$setCurrentIndex$p(MineCollectViewModel r0, int r1) {
        r0.currentIndex = r1;
    }

    public static final /* synthetic */ void access$setLastUpdateTime$p(MineCollectViewModel r0, long r1) {
        r0.lastUpdateTime = r1;
    }

    private final void updateQaCollectState(List<Message> r4, final boolean r5) {
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L22;
        Message r0 = (Message) r6.next();
        String r1 = r0.getMessageId();
        String r2 = "";
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        String r3 = r0.getLocalMessageId();
        if (r3 == null) goto L13;
        r2 = r3;
    L13:
        if (r2.length() != 0) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == true) goto L20;
        r1 = r2;
    L20:
        if (StringsKt.isBlank(r1) == true) goto L4;
        RepoDispatcher.a.getClass();
        RepoDispatcher.d.r1(r1, new m(r5));
        goto L4
    L15:
        r7 = false;
        goto L16
    }

    private static final Map updateQaCollectState$lambda$3$lambda$2(boolean r2, Map r3) {
        Intrinsics.checkNotNullParameter(r3, "bizExt");
        Pair[] r0 = new Pair[1];
        if (r2 == false) goto L5;
        String r4 = "1";
    L6:
        r0[0] = TuplesKt.to("collect_type", r4);
        return com.larus.utils.h.c(r3, r0);
    L5:
        r4 = TriggerSendLoading.NO_LOADING;
        goto L6
    }

    public static final /* synthetic */ void access$updateQaCollectState(MineCollectViewModel r0, List r1, boolean r2) {
        r0.updateQaCollectState(r1, r2);
    }

    public static /* synthetic */ void queryCollectList$default(MineCollectViewModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.queryCollectList(r1);
    }

    public static /* synthetic */ void requestMoreCollection$default(MineCollectViewModel r0, DowngradeSource r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.requestMoreCollection(r1);
    }
}
