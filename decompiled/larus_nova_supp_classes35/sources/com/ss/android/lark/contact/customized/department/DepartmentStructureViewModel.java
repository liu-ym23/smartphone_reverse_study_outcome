package com.ss.android.lark.contact.customized.department;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatRequest;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.sdk.SdkSender;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.j;
import mtb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001cR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/contact/customized/department/DepartmentStructureViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_stack", "Lkotlinx/coroutines/flow/MutableStateFlow;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/customized/department/DepartmentStructureViewModel$PageState;", "stack", "Lkotlinx/coroutines/flow/StateFlow;", "getStack", "()Lkotlinx/coroutines/flow/StateFlow;", "modifyMutex", "Lkotlinx/coroutines/sync/Mutex;", "nameDisplayRule", "Lcom/bytedance/lark/pb/contact/v1/GetAnotherNameFormatResponse$FormatRule;", "init", BuildConfig.FLAVOR, "departmentId", BuildConfig.FLAVOR, "departmentName", "loadMore", "back", BuildConfig.FLAVOR, "enter", "dept", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "fetchCurrent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchNameDisplayRule", "Companion", "PageState", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentStructureViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    public static final String TAG = "DepartmentStructureViewModel";
    private final z0<List<b>> _stack;
    private final kotlinx.coroutines.sync.a modifyMutex;
    private GetAnotherNameFormatResponse.FormatRule nameDisplayRule;
    private final i1<List<b>> stack;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final i a;
        public final List<mtb.c> b;
        public final int c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "PageState(item=" + this.a + ", items=" + this.b + ", loadOffset=" + this.c + ", hasMore=" + this.d + ')';
        }

        public /* synthetic */ b(i r4) {
            this(r4, CollectionsKt.emptyList(), 0, true);
        }

        public b(i r2, List<? extends mtb.c> r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r3, "items");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$back$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$back$1", f = "DepartmentStructureViewModel.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public AnonymousClass1(DepartmentStructureViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            DepartmentStructureViewModel r2 = (DepartmentStructureViewModel) this.L$1;
            kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r6);
        L18:
            DepartmentStructureViewModel.access$get_stack$p(r2).setValue(CollectionsKt.dropLast((List) DepartmentStructureViewModel.access$get_stack$p(r2).getValue(), 1));     // Catch: Throwable -> L15
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L15
            r3.unlock(null);
            return Unit.INSTANCE;
        L15:
            th = move-exception;
            r3.unlock(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            r3 = DepartmentStructureViewModel.access$getModifyMutex$p(this.this$0);
            DepartmentStructureViewModel r8 = this.this$0;
            this.L$0 = r3;
            this.L$1 = r8;
            this.label = 1;
            if (r3.a(null, this) != r0) goto L11;
            return r0;
        L11:
            r2 = r8;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$enter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$enter$1", f = "DepartmentStructureViewModel.kt", i = {0}, l = {149, 65}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class C04351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i $dept;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C04351(DepartmentStructureViewModel r1, i r2, Continuation<? super C04351> r3) {
            this.this$0 = r1;
            this.$dept = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04351(this.this$0, this.$dept, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r2 = (i) this.L$2;
            DepartmentStructureViewModel r3 = (DepartmentStructureViewModel) this.L$1;
            kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r8);
        L23:
            DepartmentStructureViewModel.access$get_stack$p(r3).setValue(CollectionsKt.plus((Collection) DepartmentStructureViewModel.access$get_stack$p(r3).getValue(), new b(r2)));     // Catch: Throwable -> L20
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L20
            r5.unlock(null);
            DepartmentStructureViewModel r10 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r10.fetchCurrent(this) != r0) goto L19;
            return r0;
        L20:
            th = move-exception;
            r5.unlock(null);
            throw th;
        L10:
            ResultKt.throwOnFailure(r8);
            r5 = DepartmentStructureViewModel.access$getModifyMutex$p(this.this$0);
            DepartmentStructureViewModel r11 = this.this$0;
            r2 = this.$dept;
            this.L$0 = r5;
            this.L$1 = r11;
            this.L$2 = r2;
            this.label = 1;
            if (r5.a(null, this) != r0) goto L13;
            return r0;
        L13:
            r3 = r11;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$fetchCurrent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel", f = "DepartmentStructureViewModel.kt", i = {0, 0}, l = {145, 89}, m = "fetchCurrent", n = {"state", "$completion$iv"}, s = {"L$0", "L$1"})
    public static final class C04361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C04361(DepartmentStructureViewModel r1, Continuation<? super C04361> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return this.this$0.fetchCurrent(this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$init$1", f = "DepartmentStructureViewModel.kt", i = {}, l = {37, 38}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C04371(DepartmentStructureViewModel r1, Continuation<? super C04371> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04371(this.this$0, r3);
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
            DepartmentStructureViewModel r2 = (DepartmentStructureViewModel) this.L$0;
            ResultKt.throwOnFailure(r5);
        L13:
            DepartmentStructureViewModel.access$setNameDisplayRule$p(r2, (GetAnotherNameFormatResponse.FormatRule) r5);
            DepartmentStructureViewModel r6 = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (r6.fetchCurrent(this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r5);
            r2 = this.this$0;
            this.L$0 = r2;
            this.label = 1;
            r5 = DepartmentStructureViewModel.access$fetchNameDisplayRule(r2, this);
            if (r5 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$loadMore$1", f = "DepartmentStructureViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C04381(DepartmentStructureViewModel r1, Continuation<? super C04381> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04381(this.this$0, r3);
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
            DepartmentStructureViewModel r5 = this.this$0;
            this.label = 1;
            if (r5.fetchCurrent(this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final boolean back() {
        if (((List) this._stack.getValue()).size() > 1) goto L6;
        return false;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return true;
    }

    public DepartmentStructureViewModel() {
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._stack = r0;
        this.stack = e.b(r0);
        this.modifyMutex = kotlinx.coroutines.sync.b.a();
        this.nameDisplayRule = GetAnotherNameFormatResponse.FormatRule.NAME_FIRST;
    }

    public final void loadMore() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04381(this, null), 3, null);
    }

    public final i1<List<b>> getStack() {
        return this.stack;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getModifyMutex$p(DepartmentStructureViewModel r0) {
        return r0.modifyMutex;
    }

    public static final /* synthetic */ GetAnotherNameFormatResponse.FormatRule access$getNameDisplayRule$p(DepartmentStructureViewModel r0) {
        return r0.nameDisplayRule;
    }

    public static final /* synthetic */ z0 access$get_stack$p(DepartmentStructureViewModel r0) {
        return r0._stack;
    }

    private final Object fetchNameDisplayRule(Continuation<? super GetAnotherNameFormatResponse.FormatRule> r6) {
        final j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        int r1 = d.a;
        IGetDataCallback<GetAnotherNameFormatResponse.FormatRule> r2 = new DepartmentStructureViewModel$fetchNameDisplayRule$2$1(r0);
        Intrinsics.checkNotNullParameter(r2, "callback");
        SdkSender.asynSendRequestNonWrap(Command.GET_ANOTHER_NAME_FORMAT, new GetAnotherNameFormatRequest.Builder(), r2, com.ss.android.lark.contact.customized.department.b.a);
        Object r3 = r0.B();
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r3;
    }

    public final void enter(i r8) {
        Intrinsics.checkNotNullParameter(r8, "dept");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04351(this, r8, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$b] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$fetchCurrent$resp$1$1$1] */
    public final Object fetchCurrent(Continuation<? super Unit> r9) {
        if ((r9 instanceof C04361) == false) goto L7;
        C04361 r0 = (C04361) r9;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        C04361 r4 = (C04361) r0.L$1;
        r3 = (b) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L29
    L27:
        Object r11 = Result.constructor-impl((GetDepartmentCombineChatResponse) r10);     // Catch: Throwable -> L29
        b r5 = r3;
    L32:
        if (Result.isSuccess-impl(r11) == false) goto L37;
        CoroutineDispatcher r6 = Dispatchers.getIO();
        DepartmentStructureViewModel$fetchCurrent$2$1 r7 = new DepartmentStructureViewModel$fetchCurrent$2$1(r5, (GetDepartmentCombineChatResponse) r11, this, null);
        r0.L$0 = r11;
        r0.L$1 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r6, r7, r0) != r2) goto L37;
        return r2;
    L18:
        ResultKt.throwOnFailure(r10);
        r3 = (b) CollectionsKt.lastOrNull((List) this._stack.getValue());
        if (r3 == 0) goto L21;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        r0.L$0 = r3;     // Catch: Throwable -> L29
        r0.L$1 = r0;     // Catch: Throwable -> L29
        r0.label = 1;     // Catch: Throwable -> L29
        final j r13 = new j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L29
        r13.C();     // Catch: Throwable -> L29
        int r8 = d.a;     // Catch: Throwable -> L29
        d.a(r3.a.b, r3.c, new DepartmentStructureViewModel$fetchCurrent$resp$1$1$1(r13));     // Catch: Throwable -> L29
        r10 = r13.B();     // Catch: Throwable -> L29
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L29
    L25:
        if (r10 != r2) goto L27;
        return r2;
    L21:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        r5 = r3;
    L7:
        r0 = new C04361(this, r9);
        goto L8
    }

    public static final /* synthetic */ Object access$fetchNameDisplayRule(DepartmentStructureViewModel r0, Continuation r1) {
        return r0.fetchNameDisplayRule(r1);
    }

    public static final /* synthetic */ void access$setNameDisplayRule$p(DepartmentStructureViewModel r0, GetAnotherNameFormatResponse.FormatRule r1) {
        r0.nameDisplayRule = r1;
    }

    public final void init(String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "departmentId");
        Intrinsics.checkNotNullParameter(r9, "departmentName");
        if (((List) this._stack.getValue()).isEmpty() == false) goto L5;
        this._stack.setValue(CollectionsKt.listOf(new b(new i(r9, r8))));
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04371(this, null), 3, null);
    }
}
