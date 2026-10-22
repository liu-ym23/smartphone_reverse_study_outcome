package com.larus.bmhome.view.actionbar.bot;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.bmhome.chat.api.ActionBarApi;
import com.larus.bmhome.chat.api.ActionBarTempData;
import com.larus.im.bean.conversation.Templates;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0\"0!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0002\u0010%R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/larus/bmhome/view/actionbar/bot/ActionBarViewModel;", "Landroidx/lifecycle/ViewModel;", "lang", "", "<init>", "(Ljava/lang/String;)V", "newPageList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/im/bean/conversation/Templates;", "getNewPageList", "()Landroidx/lifecycle/MutableLiveData;", "dataList", "getDataList", "dataLoading", "", "getDataLoading", "cursor", "", "getCursor", "()J", "setCursor", "(J)V", "hasMore", "getHasMore", "()Z", "setHasMore", "(Z)V", "loadData", "", "isColdStart", "(Ljava/lang/Boolean;)V", "executeApiCall", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActionBarViewModel extends ViewModel {
    public static final a Companion = null;
    private static final int LOAD_PAGE_SIZE = 20;
    private long cursor;
    private final MutableLiveData<List<Templates>> dataList;
    private final MutableLiveData<Boolean> dataLoading;
    private boolean hasMore;
    private final String lang;
    private final MutableLiveData<List<Templates>> newPageList;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Result;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/chat/api/ActionBarTempData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$executeApiCall$2", f = "ActionBarViewModel.kt", i = {0}, l = {59, 63, 65}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends BizResponse<ActionBarTempData>>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $isColdStart;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ActionBarViewModel this$0;

        public AnonymousClass2(ActionBarViewModel r1, Boolean r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$isColdStart = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, this.$isColdStart, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super Result<BizResponse<ActionBarTempData>>> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r16) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L12;
            if (r0 == 1) goto L11;
            if (r0 == 2) goto L10;
            if (r0 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r16);
        L29:
            return Unit.INSTANCE;
        L11:
            FlowCollector r1 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r16);
            FlowCollector r14 = r1;
            Object r2 = r16;
        L15:
            dm9.a.b r3 = (dm9.a) r2;
            if ((r3 instanceof dm9.a.b) == false) goto L21;
            Result.Companion r4 = Result.Companion;
            Result r5 = Result.box-impl(Result.constructor-impl(r3.a));
            this.L$0 = null;
            this.label = 2;
            if (r14.emit(r5, this) != r10) goto L29;
            return r10;
        L21:
            if ((r3 instanceof dm9.a.a) == false) goto L29;
            Result.Companion r6 = Result.Companion;
            Throwable r7 = ((dm9.a.a) r3).c;
            if (r7 != null) goto L25;
            r7 = new Exception();
        L25:
            Result r8 = Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r7)));
            this.L$0 = null;
            this.label = 3;
            if (r14.emit(r8, this) != r10) goto L29;
            return r10;
        L12:
            ResultKt.throwOnFailure(r16);
            r14 = (FlowCollector) this.L$0;
            ActionBarApi.a r9 = ActionBarApi.a;
            ActionBarViewModel$executeApiCall$2$result$1 r11 = new ActionBarViewModel$executeApiCall$2$result$1(this.this$0, this.$isColdStart, null);
            this.L$0 = r14;
            this.label = 1;
            r9.getClass();
            FlowHttpConnection r12 = FlowHttpConnection.a;
            r2 = FlowHttpConnection.g("Message", ActionBarApi.class, r11, false, null, null, null, this, 248);
            if (r2 != r10) goto L15;
            return r10;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1", f = "ActionBarViewModel.kt", i = {}, l = {30, 30}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Boolean $isColdStart;
        int label;
        final /* synthetic */ ActionBarViewModel this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.bot.ActionBarViewModel$loadData$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ActionBarViewModel a;

            public a(ActionBarViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r5, Continuation<? super Unit> r6) {
                Result r7 = (Result) r5;
                if (Result.isSuccess-impl(r7.unbox-impl()) == false) goto L24;
                Object r8 = r7.unbox-impl();
                ActionBarViewModel r9 = this.a;
                if (Result.exceptionOrNull-impl(r8) != null) goto L22;
                ActionBarTempData r10 = (ActionBarTempData) ((BizResponse) r8).getData();
                if (r10 == null) goto L26;
                ActionBarViewModel r11 = this.a;
                r10.bindRequestId();
                r11.getDataLoading().setValue(Boxing.boxBoolean(false));
                r11.setHasMore(r10.getHasMore());
                r11.setCursor(r10.getNextCursor());
                List r12 = r10.getTemplateInfos();
                if (r12 == null) goto L26;
                List r13 = CollectionsKt.filterNotNull(r12);
                if (r13 == null) goto L26;
                r11.getNewPageList().postValue(r13);
                List r0 = (List) r11.getDataList().getValue();
                if (r0 != null) goto L15;
                r0 = CollectionsKt.emptyList();
            L15:
                List r14 = CollectionsKt.plus(r0, r13);
                HashSet r1 = new HashSet();
                ArrayList r2 = new ArrayList();
                Iterator<T> r15 = r14.iterator();
            L17:
                if (r15.hasNext() == false) goto L21;
                T r3 = r15.next();
                if (r1.add(((Templates) r3).getId()) == false) goto L17;
                r2.add(r3);
                goto L17
            L21:
                r11.getDataList().postValue(r2);
            L26:
                return Unit.INSTANCE;
            L22:
                r9.getDataLoading().setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            L24:
                this.a.getDataLoading().setValue(Boxing.boxBoolean(false));
                goto L26
            }
        }

        public AnonymousClass1(ActionBarViewModel r1, Boolean r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$isColdStart = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$isColdStart, r4);
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
        L13:
            a r2 = new a(this.this$0);
            this.label = 2;
            if (((Flow) r5).collect(r2, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            ActionBarViewModel r6 = this.this$0;
            Boolean r3 = this.$isColdStart;
            this.label = 1;
            r5 = ActionBarViewModel.access$executeApiCall(r6, r3, this);
            if (r5 != r0) goto L13;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final long getCursor() {
        return this.cursor;
    }

    public final MutableLiveData<List<Templates>> getDataList() {
        return this.dataList;
    }

    public final MutableLiveData<Boolean> getDataLoading() {
        return this.dataLoading;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<List<Templates>> getNewPageList() {
        return this.newPageList;
    }

    public ActionBarViewModel(String r1) {
        this.lang = r1;
        this.newPageList = new MutableLiveData();
        this.dataList = new MutableLiveData();
        this.dataLoading = new MutableLiveData();
        this.hasMore = true;
    }

    public static final /* synthetic */ String access$getLang$p(ActionBarViewModel r0) {
        return r0.lang;
    }

    public final void loadData(Boolean r9) {
        this.dataLoading.setValue(Boolean.TRUE);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r9, null), 3, null);
    }

    public final void setCursor(long r1) {
        this.cursor = r1;
    }

    public final void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    private final Object executeApiCall(Boolean r2, Continuation<? super Flow<Result<BizResponse<ActionBarTempData>>>> r3) {
        return new c1(new AnonymousClass2(this, r2, null));
    }

    public static final /* synthetic */ Object access$executeApiCall(ActionBarViewModel r0, Boolean r1, Continuation r2) {
        return r0.executeApiCall(r1, r2);
    }
}
