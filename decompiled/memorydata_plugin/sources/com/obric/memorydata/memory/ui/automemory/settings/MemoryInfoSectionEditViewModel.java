package com.obric.memorydata.memory.ui.automemory.settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\fJ\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", ObricMemoryConstants.KEY_SESSION_ID, "", MemoryInfoSectionEditActivity.EXTRA_KIND, "singleTextLoaded", "", "bind", "", "sid", "onSceneTextChanged", "newText", "addItem", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "updateItem", "index", "", "deleteItem", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryInfoSectionEditViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "MemoryInfoSectionEditVM";
    private final ae<f> _state;
    private String kind;
    private String sessionId;
    private boolean singleTextLoaded;
    private final ar<f> state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfoSectionEditViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditViewModel$bind$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditViewModel$bind$1", f = "MemoryInfoSectionEditActivity.kt", i = {}, l = {785}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $kind;
        final /* synthetic */ String $sid;
        int label;
        final /* synthetic */ MemoryInfoSectionEditViewModel this$0;

        AnonymousClass1(String r3, MemoryInfoSectionEditViewModel r4, String r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$sid = r3;
            this.this$0 = r4;
            this.$kind = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$sid, this.this$0, this.$kind, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L14:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<b> r7 = g.f10759a.a(this.$sid);
            if (r7 == null) goto L16;
            final MemoryInfoSectionEditViewModel r3 = this.this$0;
            final String r4 = this.$kind;
            kotlinx.coroutines.flow.j<? super b> r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05371(r3, r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<?> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r5) != r0) goto L14;
            return r0;
        L16:
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryInfoSectionEditViewModel() {
        ae<f> r0 = at.a(new f(null, null, 3, null));
        this._state = r0;
        this.state = k.a(r0);
        this.sessionId = "";
        this.kind = "";
    }

    public static final /* synthetic */ ae access$get_state$p(MemoryInfoSectionEditViewModel r0) {
        return r0._state;
    }

    private static final b addItem$lambda$2(String r31, b r32) {
        Intrinsics.checkNotNullParameter(r32, "draft");
        e.b r15 = r32.r().c();
        if (r15.b().contains(r31) == false) goto L6;
        return r32;
    L6:
        return b.a(r32, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r32.r(), null, null, e.b.a(r15, null, CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r15.b(), Collection.class, "com.obric.memorydata.plugin"), r31), 1, null), null, null, null, null, null, 251, null), false, 393215, null);
    }

    private static final b deleteItem$lambda$7(int r33, b r34) {
        Intrinsics.checkNotNullParameter(r34, "draft");
        e.b r14 = r34.r().c();
        boolean r2 = false;
        if (r33 >= 0) goto L5;
    L7:
        if (r2 == true) goto L9;
        return r34;
    L9:
        List r12 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r14.b(), Collection.class, "com.obric.memorydata.plugin"));
        r12.remove(r33);
        return b.a(r34, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r34.r(), null, null, e.b.a(r14, null, r12, 1, null), null, null, null, null, null, 251, null), false, 393215, null);
    L5:
        if (r33 >= ((Collection) ZeusTransformUtils.preCheckCast(r14.b(), Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r2 = true;
        goto L7
    }

    /* JADX INFO: renamed from: lambda$-YXZOhPORnIpPnj0iUEe6WutZ6Y, reason: not valid java name */
    public static /* synthetic */ b m826lambda$YXZOhPORnIpPnj0iUEe6WutZ6Y(int r0, String r1, b r2) {
        return updateItem$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ b lambda$IB7qM5Fl13HffBeUTGz5EdZA0O0(int r0, b r1) {
        return deleteItem$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$XqKYnKwarNH15HgvT8M8odksg-g, reason: not valid java name */
    public static /* synthetic */ b m827lambda$XqKYnKwarNH15HgvT8M8odksgg(String r0, b r1) {
        return addItem$lambda$2(r0, r1);
    }

    public static /* synthetic */ b lambda$rBQ5yHvcLrs95YL8xG_4eGbG8bs(String r0, b r1) {
        return onSceneTextChanged$lambda$1(r0, r1);
    }

    public static /* synthetic */ b lambda$zD5Pp6n1kXVbNAUYQuZMwMaZk7I(String r0, b r1) {
        return onSceneTextChanged$lambda$0(r0, r1);
    }

    private static final b onSceneTextChanged$lambda$0(String r30, b r31) {
        Intrinsics.checkNotNullParameter(r31, "draft");
        if (Intrinsics.areEqual(r31.r().e(), r30) == false) goto L6;
        return r31;
    L6:
        return b.a(r31, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r31.r(), null, null, null, null, r30, null, null, null, 239, null), false, 393215, null);
    }

    private static final b onSceneTextChanged$lambda$1(String r30, b r31) {
        Intrinsics.checkNotNullParameter(r31, "draft");
        if (Intrinsics.areEqual(r31.r().b(), r30) == false) goto L6;
        return r31;
    L6:
        return b.a(r31, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r31.r(), null, r30, null, null, null, null, null, null, 253, null), false, 393215, null);
    }

    private static final b updateItem$lambda$5(int r33, String r34, b r35) {
        Intrinsics.checkNotNullParameter(r35, "draft");
        e.b r14 = r35.r().c();
        boolean r2 = false;
        if (r33 >= 0) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
    L32:
        return r35;
    L10:
        if (Intrinsics.areEqual(r14.b().get(r33), r34) == true) goto L32;
        Iterable r5 = CollectionsKt.withIndex((Iterable) ZeusTransformUtils.preCheckCast(r14.b(), Iterable.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L15;
    L17:
        Iterator r6 = r5.iterator();
    L19:
        if (r6.hasNext() == false) goto L28;
        IndexedValue r7 = (IndexedValue) ZeusTransformUtils.preCheckCast(r6.next(), IndexedValue.class, "com.obric.memorydata.plugin");
        int r8 = r7.component1();
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.component2(), String.class, "com.obric.memorydata.plugin");
        if (r8 != r33) goto L23;
    L25:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L19;
        r2 = true;
        goto L28
    L23:
        if (Intrinsics.areEqual(r9, r34) == false) goto L25;
        r10 = true;
    L28:
        if (r2 == false) goto L30;
        return r35;
    L30:
        List r12 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r14.b(), Collection.class, "com.obric.memorydata.plugin"));
        r12.set(r33, r34);
        return b.a(r35, null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, e.a(r35.r(), null, null, e.b.a(r14, null, r12, 1, null), null, null, null, null, null, 251, null), false, 393215, null);
    L15:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L17;
    L5:
        if (r33 >= ((Collection) ZeusTransformUtils.preCheckCast(r14.b(), Collection.class, "com.obric.memorydata.plugin")).size()) goto L7;
        r4 = true;
        goto L8
    }

    public final void addItem(String r4) {
        Intrinsics.checkNotNullParameter(r4, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        final String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryInfoSectionEditViewModel$XqKYnKwarNH15HgvT8M8odksgg(r5));
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void bind(String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "sid");
        Intrinsics.checkNotNullParameter(r10, MemoryInfoSectionEditActivity.EXTRA_KIND);
        if (Intrinsics.areEqual(this.sessionId, r9) == true) goto L5;
    L7:
        this.sessionId = r9;
        this.kind = r10;
        if (Intrinsics.areEqual(r10, MemoryInfoSectionEditActivity.KIND_SCENE) == false) goto L10;
    L14:
        b r0 = g.f10759a.b(r9);
        if (r0 != null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "session not found: " + r9, null, 4, null);
        return;
    L18:
        this._state.b(new f(r10, r0.r()));
        this.singleTextLoaded = true;
        return;
    L10:
        if (Intrinsics.areEqual(r10, MemoryInfoSectionEditActivity.KIND_UPDATE_RULE) == true) goto L14;
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, this, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    L5:
        if (Intrinsics.areEqual(this.kind, r10) == false) goto L7;
    }

    public final void deleteItem(final int r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryInfoSectionEditViewModel$IB7qM5Fl13HffBeUTGz5EdZA0O0(r4));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final ar<f> getState() {
        return this.state;
    }

    public final void onSceneTextChanged(final String r18) {
        Intrinsics.checkNotNullParameter(r18, "newText");
        if (this.singleTextLoaded == true) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(((f) ZeusTransformUtils.preCheckCast(this._state.c(), f.class, "com.obric.memorydata.plugin")).d(), r18) == false) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(this.kind, MemoryInfoSectionEditActivity.KIND_UPDATE_RULE) == false) goto L16;
        ae<f> r15 = this._state;
        r15.b(f.a((f) ZeusTransformUtils.preCheckCast(r15.c(), f.class, "com.obric.memorydata.plugin"), null, e.a(((f) ZeusTransformUtils.preCheckCast(this._state.c(), f.class, "com.obric.memorydata.plugin")).b(), null, null, null, null, r18, null, null, null, 239, null), 1, null));
        g r2 = g.f10759a;
        String r0 = this.sessionId;
        Function1<? super b, b> r3 = new $$Lambda$MemoryInfoSectionEditViewModel$zD5Pp6n1kXVbNAUYQuZMwMaZk7I(r18);
    L17:
        r2.update(r0, r3);
        return;
    L16:
        ae<f> r13 = this._state;
        r13.b(f.a((f) ZeusTransformUtils.preCheckCast(r13.c(), f.class, "com.obric.memorydata.plugin"), null, e.a(((f) ZeusTransformUtils.preCheckCast(this._state.c(), f.class, "com.obric.memorydata.plugin")).b(), null, r18, null, null, null, null, null, null, 253, null), 1, null));
        r2 = g.f10759a;
        r0 = this.sessionId;
        r3 = new $$Lambda$MemoryInfoSectionEditViewModel$rBQ5yHvcLrs95YL8xG_4eGbG8bs(r18);
        goto L17
    L7:
        r1 = false;
        goto L8
    }

    public final void updateItem(final int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        final String r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.sessionId, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L13;
        g.f10759a.update(this.sessionId, new $$Lambda$MemoryInfoSectionEditViewModel$YXZOhPORnIpPnj0iUEe6WutZ6Y(r4, r6));
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
