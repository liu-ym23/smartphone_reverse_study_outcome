package com.obric.memorydata.recommend.ui.list;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.obric.memory.model.DelMemoryRequest;
import com.bytedance.obric.memory.model.DelMemoryResponse;
import com.bytedance.obric.memory.model.GetUserTodoListRequest;
import com.bytedance.obric.memory.model.GetUserTodoListResponse;
import com.bytedance.obric.memory.model.UserTodo;
import com.bytedance.obric.memory.model.UserTodoList;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/UserTodoViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/recommend/ui/list/TodoState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "certainMap", "", "", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem$TodoEntity;", "uncertainMap", "clearCache", "", "clearData", "refresh", "fetchData", "updateMap", "todoList", "Lcom/bytedance/obric/memory/model/UserTodoList;", "flatData", "", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "deleteTodo", "", "todoData", "Lcom/bytedance/obric/memory/model/UserTodo;", "(Lcom/bytedance/obric/memory/model/UserTodo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMemoryEntity", "todo", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserTodoViewModel extends ViewModel {
    private static final int CATEGORY_TODO = 5;
    private static final Lazy<String> CERTAIN_TEXT$delegate = null;
    private static final int CERTAIN_TYPE = 1;
    public static final a Companion = null;
    private static final long PAGE_SIZE = 10;
    private static final String TAG = "UserTodoViewModel";
    private static final Lazy<String> UNCERTAIN_TEXT$delegate = null;
    private static final int UNCERTAIN_TYPE = 2;
    private final ae<m> _state;
    private final Map<Long, f.d> certainMap;
    private final ar<m> state;
    private final Map<Long, f.d> uncertainMap;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/UserTodoViewModel$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "CERTAIN_TYPE", "", "UNCERTAIN_TYPE", "CATEGORY_TODO", "CERTAIN_TEXT", "getCERTAIN_TEXT", "()Ljava/lang/String;", "CERTAIN_TEXT$delegate", "Lkotlin/Lazy;", "UNCERTAIN_TEXT", "getUNCERTAIN_TEXT", "UNCERTAIN_TEXT$delegate", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final String a() {
            return (String) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$getCERTAIN_TEXT$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ String a(a r0) {
            return r0.a();
        }

        private final String b() {
            return (String) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$getUNCERTAIN_TEXT$delegate$cp().getValue(), String.class, "com.obric.memorydata.plugin");
        }

        public static final /* synthetic */ String b(a r0) {
            return r0.b();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.UserTodoViewModel$deleteMemoryEntity$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.UserTodoViewModel", f = "UserTodoViewModel.kt", i = {0, 0}, l = {179}, m = "deleteMemoryEntity", n = {"this", "todo"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ UserTodoViewModel this$0;

        AnonymousClass1(UserTodoViewModel r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.deleteMemoryEntity(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.UserTodoViewModel$deleteTodo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.UserTodoViewModel$deleteTodo$2", f = "UserTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super Boolean>, Object> {
        final /* synthetic */ UserTodo $todoData;
        int label;

        AnonymousClass2(UserTodo r3, Continuation<? super AnonymousClass2> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$todoData = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$todoData, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Boolean> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Boolean> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r9);
            boolean r10 = false;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "deleteMemory: id=" + this.$todoData.id + ", category=todo", false, 4, null);     // Catch: Exception -> L8
            DelMemoryRequest r1 = new DelMemoryRequest();     // Catch: Exception -> L8
            r1.id = this.$todoData.id;     // Catch: Exception -> L8
            r1.category = 5;     // Catch: Exception -> L8
            DelMemoryResponse r8 = com.bytedance.obric.memory.a.a.a(r1);     // Catch: Exception -> L8
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "deleteMemory: response.code=" + r8.code, false, 4, null);     // Catch: Exception -> L8
            if (r8.code != 0) goto L11;
            r10 = true;
        L11:
            return Boxing.boxBoolean(r10);
        L8:
            e = move-exception;
            RunLog.INSTANCE.error(UserTodoViewModel.TAG, "deleteMemory error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.UserTodoViewModel$fetchData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.UserTodoViewModel$fetchData$2", f = "UserTodoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C12232 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UserTodoViewModel this$0;

        C12232(UserTodoViewModel r3, Continuation<? super C12232> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C12232(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C12232) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C12232.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r5v9, types: [T, com.bytedance.obric.memory.model.GetUserTodoListResponse] */
        /* JADX WARN: Type inference failed for: r6v31, types: [T, com.bytedance.obric.memory.model.GetUserTodoListResponse] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r31) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L65;
            ResultKt.throwOnFailure(r31);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "fetchData page: " + ((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(this.this$0).c(), m.class, "com.obric.memorydata.plugin")).c(), false, 4, null);     // Catch: Exception -> L58
            Ref.ObjectRef r4 = new Ref.ObjectRef();     // Catch: Exception -> L58
            GetUserTodoListRequest r5 = new GetUserTodoListRequest();     // Catch: Exception -> L58
            UserTodoViewModel r6 = this.this$0;     // Catch: Exception -> L58
            r5.num = 10;     // Catch: Exception -> L58
            r5.nextId = ((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(r6).c(), m.class, "com.obric.memorydata.plugin")).d();     // Catch: Exception -> L58
            r5.possibilityType = ((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(r6).c(), m.class, "com.obric.memorydata.plugin")).e();     // Catch: Exception -> L58
            r4.element = com.bytedance.obric.memory.a.a.a(r5);     // Catch: Exception -> L58
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "getRecommendListSync " + ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).code, false, 4, null);     // Catch: Exception -> L58
            if (((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).code == 0) goto L12;
            ae r0 = UserTodoViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L58
        L8:
            Object r2 = r0.c();     // Catch: Exception -> L58
            m r7 = (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L58
            int r15 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).code;     // Catch: Exception -> L58
            String r8 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).msg;     // Catch: Exception -> L58
            Intrinsics.checkNotNullExpressionValue(r8, NotificationCompat.CATEGORY_MESSAGE);     // Catch: Exception -> L58
            if (r0.a(r2, m.a(r7, null, false, 0, ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data.nextId, 0, false, r15, r8, 53, null)) == false) goto L8;
            return Unit.INSTANCE;
        L12:
            Ref.BooleanRef r9 = new Ref.BooleanRef();     // Catch: Exception -> L58
            UserTodoList r10 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data;     // Catch: Exception -> L58
            if (r10 == null) goto L19;
            List<UserTodo> r11 = r10.data;     // Catch: Exception -> L58
            if (r11 == null) goto L19;
            if (r11.size() != 10) goto L19;
            boolean r12 = true;
        L20:
            r9.element = r12;     // Catch: Exception -> L58
            ae r13 = UserTodoViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L58
            UserTodoViewModel r14 = this.this$0;     // Catch: Exception -> L58
        L21:
            Object r16 = r13.c();     // Catch: Exception -> L58
            m r17 = (m) ZeusTransformUtils.preCheckCast(r16, m.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L58
            List<UserTodo> r18 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data.data;     // Catch: Exception -> L58
            Intrinsics.checkNotNullExpressionValue(r18, "data");     // Catch: Exception -> L58
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L58
        L24:
            if (r19.hasNext() == false) goto L26;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "user todo: " + ((UserTodo) ZeusTransformUtils.preCheckCast(r19.next(), UserTodo.class, "com.obric.memorydata.plugin")).eventDescription, false, 4, null);     // Catch: Exception -> L58
            goto L24
        L26:
            UserTodoList r20 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data;     // Catch: Exception -> L58
            Intrinsics.checkNotNullExpressionValue(r20, "data");     // Catch: Exception -> L58
            UserTodoViewModel.access$updateMap(r14, r20);     // Catch: Exception -> L58
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "hasMore: " + r9.element, false, 4, null);     // Catch: Exception -> L58
            List r110 = UserTodoViewModel.access$flatData(r14);     // Catch: Exception -> L58
            long r111 = ((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(r14).c(), m.class, "com.obric.memorydata.plugin")).c() + 1;     // Catch: Exception -> L58
            boolean r21 = r9.element;     // Catch: Exception -> L58
            long r112 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data.nextId;     // Catch: Exception -> L58
            if (r21 == false) goto L29;
            boolean r23 = true;
        L31:
            if (r13.a(r16, m.a(r17, r110, false, r111, r112, 0, r23, 0, null, 208, null)) == false) goto L21;
            if (r9.element == true) goto L63;
            if (((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(this.this$0).c(), m.class, "com.obric.memorydata.plugin")).e() != 1) goto L63;
            GetUserTodoListRequest r22 = new GetUserTodoListRequest();     // Catch: Exception -> L58
            r22.num = 10;     // Catch: Exception -> L58
            r22.nextId = 0;     // Catch: Exception -> L58
            r22.possibilityType = 2;     // Catch: Exception -> L58
            r4.element = com.bytedance.obric.memory.a.a.a(r22);     // Catch: Exception -> L58
            UserTodoList r24 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data;     // Catch: Exception -> L58
            if (r24 == null) goto L43;
            List<UserTodo> r25 = r24.data;     // Catch: Exception -> L58
            if (r25 == null) goto L43;
            if (r25.size() != 10) goto L43;
            boolean r26 = true;
        L44:
            r9.element = r26;     // Catch: Exception -> L58
            ae r27 = UserTodoViewModel.access$get_state$p(this.this$0);     // Catch: Exception -> L58
            UserTodoViewModel r28 = this.this$0;     // Catch: Exception -> L58
        L45:
            Object r113 = r27.c();     // Catch: Exception -> L58
            m r114 = (m) ZeusTransformUtils.preCheckCast(r113, m.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L58
            List<UserTodo> r115 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data.data;     // Catch: Exception -> L58
            Intrinsics.checkNotNullExpressionValue(r115, "data");     // Catch: Exception -> L58
            Iterator r116 = ((Iterable) ZeusTransformUtils.preCheckCast(r115, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L58
        L47:
            if (r116.hasNext() == false) goto L49;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "user todo: " + ((UserTodo) ZeusTransformUtils.preCheckCast(r116.next(), UserTodo.class, "com.obric.memorydata.plugin")).eventDescription, false, 4, null);     // Catch: Exception -> L58
            goto L47
        L49:
            UserTodoList r117 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data;     // Catch: Exception -> L58
            Intrinsics.checkNotNullExpressionValue(r117, "data");     // Catch: Exception -> L58
            UserTodoViewModel.access$updateMap(r28, r117);     // Catch: Exception -> L58
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), UserTodoViewModel.TAG, "hasMore: " + r9.element, false, 4, null);     // Catch: Exception -> L58
            List r118 = UserTodoViewModel.access$flatData(r28);     // Catch: Exception -> L58
            long r119 = ((m) ZeusTransformUtils.preCheckCast(UserTodoViewModel.access$get_state$p(r28).c(), m.class, "com.obric.memorydata.plugin")).c() + 1;     // Catch: Exception -> L58
            boolean r120 = r9.element;     // Catch: Exception -> L58
            long r121 = ((GetUserTodoListResponse) ZeusTransformUtils.preCheckCast(r4.element, GetUserTodoListResponse.class, "com.obric.memorydata.plugin")).data.nextId;     // Catch: Exception -> L58
            if (r120 == false) goto L52;
            boolean r29 = true;
        L54:
            if (r27.a(r113, m.a(r114, r118, false, r119, r121, 2, r29, 0, null, 192, null)) == false) goto L45;
        L52:
            r29 = false;
        L43:
            r26 = false;
        L63:
            return Unit.INSTANCE;
        L29:
            r23 = false;
        L19:
            r12 = false;
        L58:
            e = move-exception;
            RunLog.INSTANCE.error(UserTodoViewModel.TAG, "Load failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            ae r1 = UserTodoViewModel.access$get_state$p(this.this$0);
        L60:
            Object r3 = r1.c();
            if (r1.a(r3, m.a((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin"), null, false, 0, 0, 0, false, 0, null, 253, null)) == false) goto L60;
        L65:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
        CERTAIN_TEXT$delegate = LazyKt.lazy($$Lambda$UserTodoViewModel$HKmBqW9oN1wjL2gtGjyLp6tz9iE.INSTANCE);
        UNCERTAIN_TEXT$delegate = LazyKt.lazy($$Lambda$UserTodoViewModel$lI3gfzL2XmdTXQIoAGSugJhesQ.INSTANCE);
    }

    public UserTodoViewModel() {
        ae<m> r0 = at.a(new m(CollectionsKt.emptyList(), false, 0, 0, 1, true, 0, ""));
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
        this.certainMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.uncertainMap = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private static final String CERTAIN_TEXT_delegate$lambda$4() {
        return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.recommend_todo_certain_text, TypedValues.Custom.S_STRING, "recommend_todo_certain_text"));
    }

    private static final String UNCERTAIN_TEXT_delegate$lambda$5() {
        return com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.recommend_todo_uncertain_text, TypedValues.Custom.S_STRING, "recommend_todo_uncertain_text"));
    }

    public static final /* synthetic */ List access$flatData(UserTodoViewModel r0) {
        return r0.flatData();
    }

    public static final /* synthetic */ Lazy access$getCERTAIN_TEXT$delegate$cp() {
        return CERTAIN_TEXT$delegate;
    }

    public static final /* synthetic */ Lazy access$getUNCERTAIN_TEXT$delegate$cp() {
        return UNCERTAIN_TEXT$delegate;
    }

    public static final /* synthetic */ ae access$get_state$p(UserTodoViewModel r0) {
        return r0._state;
    }

    public static final /* synthetic */ void access$updateMap(UserTodoViewModel r0, UserTodoList r1) {
        r0.updateMap(r1);
    }

    private final List<f> flatData() {
        List<f> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if ((!this.certainMap.isEmpty()) == false) goto L6;
        r0.add(new f.a(a.a(Companion)));
        r0.addAll(this.certainMap.values());
    L6:
        if ((!this.uncertainMap.isEmpty()) == false) goto L8;
        r0.add(new f.a(a.b(Companion)));
        r0.addAll(this.uncertainMap.values());
    L8:
        return r0;
    }

    public static /* synthetic */ String lambda$HKmBqW9oN1wjL2gtGjyLp6tz9iE() {
        return CERTAIN_TEXT_delegate$lambda$4();
    }

    /* JADX INFO: renamed from: lambda$lI3gfzL-2XmdTXQIoAGSugJhesQ, reason: not valid java name */
    public static /* synthetic */ String m1151lambda$lI3gfzL2XmdTXQIoAGSugJhesQ() {
        return UNCERTAIN_TEXT_delegate$lambda$5();
    }

    private final void updateMap(UserTodoList r8) {
        List<UserTodo> r9 = r8.data;
        Intrinsics.checkNotNullExpressionValue(r9, "data");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        UserTodo r0 = (UserTodo) ZeusTransformUtils.preCheckCast(r10.next(), UserTodo.class, "com.obric.memorydata.plugin");
        if (r0.possibilityType == 1) goto L8;
        if (this.uncertainMap.containsKey(Long.valueOf(r0.id)) == true) goto L4;
        Map<Long, f.d> r2 = this.uncertainMap;
        Long r3 = Long.valueOf(r0.id);
        Intrinsics.checkNotNull(r0);
        f.d r5 = new f.d(r0, false);
    L13:
        r2.put(r3, r5);
        goto L4
    L8:
        if (this.certainMap.containsKey(Long.valueOf(r0.id)) == true) goto L4;
        r2 = this.certainMap;
        r3 = Long.valueOf(r0.id);
        Intrinsics.checkNotNull(r0);
        r5 = new f.d(r0, false);
        goto L13
    }

    public final void clearCache() {
        this.certainMap.clear();
        this.uncertainMap.clear();
    }

    public final void clearData() {
        clearCache();
        ae<m> r15 = this._state;
    L3:
        m r0 = r15.c();
        if (r15.a(r0, m.a((m) ZeusTransformUtils.preCheckCast(r0, m.class, "com.obric.memorydata.plugin"), CollectionsKt.emptyList(), false, 0, 0, 1, true, 0, "", 64, null)) == false) goto L3;
    }

    public final Object deleteMemoryEntity(UserTodo r20, Continuation<? super Unit> r21) {
        UserTodoViewModel r0 = this;
        UserTodo r1 = r20;
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r4 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r2, AnonymousClass1.class, "com.obric.memorydata.plugin");
        if ((r4.label & Integer.MIN_VALUE) == 0) goto L7;
        r4.label -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        UserTodo r7 = (UserTodo) ZeusTransformUtils.preCheckCast(r4.L$1, UserTodo.class, "com.obric.memorydata.plugin");
        UserTodoViewModel r8 = (UserTodoViewModel) ZeusTransformUtils.preCheckCast(r4.L$0, UserTodoViewModel.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r3);
        r1 = r7;
        r0 = r8;
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L23;
        r0.certainMap.remove(Boxing.boxLong(r1.id));
        r0.uncertainMap.remove(Boxing.boxLong(r1.id));
        ae<m> r9 = r0._state;
    L20:
        m r10 = r9.c();
        if (r9.a(r10, m.a((m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.memorydata.plugin"), r0.flatData(), false, 0, 0, 0, false, 0, null, 254, null)) == false) goto L20;
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        r4.L$0 = r0;
        r4.L$1 = r1;
        r4.label = 1;
        r3 = r0.deleteTodo(r1, r4);
        if (r3 != r5) goto L18;
        return r5;
    L7:
        r4 = new AnonymousClass1(r0, r2);
        goto L8
    }

    public final Object deleteTodo(UserTodo r4, Continuation<? super Boolean> r5) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public final void fetchData() {
        if (((m) ZeusTransformUtils.preCheckCast(this._state.c(), m.class, "com.obric.memorydata.plugin")).b() == false) goto L6;
        return;
    L6:
        if (((m) ZeusTransformUtils.preCheckCast(this._state.c(), m.class, "com.obric.memorydata.plugin")).f() == true) goto L8;
        return;
    L8:
        ae<m> r1 = this._state;
    L9:
        m r2 = r1.c();
        if (r1.a(r2, m.a((m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.memorydata.plugin"), null, true, 0, 0, 0, false, 0, null, 253, null)) == false) goto L9;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new C12232(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    public final ar<m> getState() {
        return this.state;
    }

    public final void refresh() {
        clearData();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refresh", false, 4, null);
        fetchData();
    }
}
