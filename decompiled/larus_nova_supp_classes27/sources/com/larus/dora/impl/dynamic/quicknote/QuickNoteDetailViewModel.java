package com.larus.dora.impl.dynamic.quicknote;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.c0;
import com.larus.dora.impl.device.u0;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteItemState;
import com.larus.dora.impl.dynamic.quicknote.entity.QuickNoteKeys;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.y;
import com.larus.dora.impl.network.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0018H\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "_quickNoteRecordUrl", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "quickNoteRecordUrl", "Lkotlinx/coroutines/flow/SharedFlow;", "getQuickNoteRecordUrl", "()Lkotlinx/coroutines/flow/SharedFlow;", "gestureSettingsStateFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsState;", "getGestureSettingsStateFlow", "()Lkotlinx/coroutines/flow/Flow;", "onAction", "", "action", "Lcom/larus/dora/impl/dynamic/quicknote/QuickNoteAction;", "onViewQuickNoteRecord", "onQueryConfig", "onItemClicked", "index", "", "onConfirmed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickNoteDetailViewModel extends ViewModel {
    private final MutableSharedFlow<String> _quickNoteRecordUrl;
    private final z0<k> _uiState;
    private final Flow<c0> gestureSettingsStateFlow;
    private final d1<String> quickNoteRecordUrl;
    private final i1<k> uiState;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$1", f = "QuickNoteDetailViewModel.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
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
            GestureSettingsRepository r5 = GestureSettingsRepository.a;
            this.label = 1;
            if (r5.f(false, this) != r0) goto L12;
            return r0;
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[QuickNoteItemState.values().length];
            r0[QuickNoteItemState.SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[QuickNoteItemState.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onConfirmed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onConfirmed$1", f = "QuickNoteDetailViewModel.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QuickNoteDetailViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onConfirmed$1$a */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[QuickNoteItemState.values().length];
                r0[QuickNoteItemState.SELECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        public C03111(QuickNoteDetailViewModel r1, Continuation<? super C03111> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03111(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r3v19, types: [com.larus.dora.impl.dynamic.quicknote.j] */
        /* JADX WARN: Type inference failed for: r4v10, types: [com.larus.dora.impl.dynamic.quicknote.i] */
        public final Object invokeSuspend(Object r16) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L8;
            if (r0 != 1) goto L7;
            ResultKt.throwOnFailure(r16);
        L51:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r16);
            if (DoraAdapterExtKt.h(kj4.a.g()) == null) goto L11;
            Ref.ObjectRef r1 = new Ref.ObjectRef();
            r1.element = "";
            Ref.ObjectRef r3 = new Ref.ObjectRef();
            r3.element = "";
            Ref.ObjectRef r4 = new Ref.ObjectRef();
            r4.element = "";
            Ref.ObjectRef r5 = new Ref.ObjectRef();
            r5.element = "";
            Iterator<T> r6 = ((k) QuickNoteDetailViewModel.access$get_uiState$p(this.this$0).getValue()).a.iterator();
            int r10 = 0;
        L14:
            if (r6.hasNext() == false) goto L47;
            Object r11 = r6.next();
            int r12 = r10 + 1;
            if (r10 >= 0) goto L18;
            CollectionsKt.throwIndexOverflow();
        L18:
            f59.a r13 = (f59.a) r11;
            if (r13.b == QuickNoteItemState.IDLE) goto L21;
            boolean r14 = true;
        L23:
            if (Intrinsics.areEqual(r13.a, QuickNoteKeys.LEFT_LONG_PRESS.getValue()) == false) goto L29;
            if (r14 == false) goto L26;
            String r15 = r13.c;
        L27:
            r1.element = r15;
        L46:
            r10 = r12;
            goto L14
        L26:
            r15 = "";
            goto L27
        L29:
            if (Intrinsics.areEqual(r13.a, QuickNoteKeys.RIGHT_LONG_PRESS.getValue()) == false) goto L35;
            if (r14 == false) goto L32;
            String r17 = r13.c;
        L33:
            r3.element = r17;
            goto L46
        L32:
            r17 = "";
            goto L33
        L35:
            if (Intrinsics.areEqual(r13.a, QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue()) == false) goto L41;
            if (r14 == false) goto L38;
            String r18 = r13.c;
        L39:
            r4.element = r18;
            goto L46
        L38:
            r18 = "";
            goto L39
        L41:
            if (Intrinsics.areEqual(r13.a, QuickNoteKeys.RIGHT_DOUBLE_CLICK.getValue()) == false) goto L46;
            if (r14 == false) goto L44;
            String r110 = r13.c;
        L45:
            r5.element = r110;
            goto L46
        L44:
            r110 = "";
            goto L45
        L21:
            r14 = false;
            goto L23
        L47:
            z r2 = new z((String) r1.element, (String) r3.element, (String) r4.element, (String) r5.element);
            int r7 = b.a;
            Intrinsics.checkNotNullParameter(r2, "config");
            DoraBuryPointManager.a.L("event_quick_note_confirm_clicked", MapsKt.mapOf(new Pair[]{TuplesKt.to(QuickNoteKeys.LEFT_LONG_PRESS.getValue(), r2.c()), TuplesKt.to(QuickNoteKeys.RIGHT_LONG_PRESS.getValue(), r2.e()), TuplesKt.to(QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue(), r2.b()), TuplesKt.to(QuickNoteKeys.RIGHT_DOUBLE_CLICK.getValue(), r2.d())}));
            g49.d.a("QuickNoteDetailViewModel", "onConfirmed config is " + r2);
            QuickNoteRepo r9 = QuickNoteRepo.a;
            final QuickNoteDetailViewModel r20 = this.this$0;
            ?? r21 = new i(r20);
            ?? r22 = new j();
            this.label = 1;
            if (QuickNoteRepo.k(r9, r2, r21, r22, null, this, 8) != r8) goto L51;
            return r8;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onQueryConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onQueryConfig$1", f = "QuickNoteDetailViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QuickNoteDetailViewModel this$0;

        public C03121(QuickNoteDetailViewModel r1, Continuation<? super C03121> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03121(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L15:
            z r13 = (z) r12;
            if (r13 != null) goto L18;
        L81:
            g49.d.a("QuickNoteDetailViewModel", "onQueryConfig response config is empty,show default selected.");
            z0 r14 = QuickNoteDetailViewModel.access$get_uiState$p(this.this$0);
        L82:
            Object r2 = r14.getValue();
            List<f59.a> r3 = ((k) r2).a;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator<T> r5 = r3.iterator();
        L84:
            if (r5.hasNext() == false) goto L93;
            f59.a r6 = (f59.a) r5.next();
            String r7 = r6.a;
            if (Intrinsics.areEqual(r7, QuickNoteKeys.LEFT_LONG_PRESS.getValue()) == false) goto L89;
            f59.a r8 = f59.a.a(r6, QuickNoteItemState.SELECTED);
        L92:
            r4.add(r8);
            goto L84
        L89:
            if (Intrinsics.areEqual(r7, QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue()) == false) goto L91;
            r8 = f59.a.a(r6, QuickNoteItemState.SELECTED);
            goto L92
        L91:
            r8 = f59.a.a(r6, QuickNoteItemState.IDLE);
            goto L92
        L93:
            Intrinsics.checkNotNullParameter(r4, "itemUiStates");
            if (r14.compareAndSet(r2, new k(r4)) == false) goto L82;
            return Unit.INSTANCE;
        L18:
            if (r13.f() == true) goto L81;
            z0 r9 = QuickNoteDetailViewModel.access$get_uiState$p(this.this$0);
        L21:
            Object r10 = r9.getValue();
            List<f59.a> r11 = ((k) r10).a;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
            Iterator<T> r16 = r11.iterator();
        L23:
            if (r16.hasNext() == false) goto L77;
            f59.a r17 = (f59.a) r16.next();
            String r18 = r17.a;
            boolean r110 = false;
            if (Intrinsics.areEqual(r18, QuickNoteKeys.LEFT_LONG_PRESS.getValue()) == false) goto L38;
            String r20 = r13.c();
            if (r20 != null) goto L29;
        L30:
            r110 = true;
        L31:
            if (r110 == false) goto L35;
            QuickNoteItemState r21 = r17.b;
            if (r21 != QuickNoteItemState.CONFIRMED) goto L36;
            r21 = QuickNoteItemState.IDLE;
        L36:
            r17 = f59.a.a(r17, r21);
        L76:
            r15.add(r17);
            goto L23
        L35:
            r21 = QuickNoteItemState.CONFIRMED;
            goto L36
        L29:
            if (r20.length() != 0) goto L31;
        L38:
            if (Intrinsics.areEqual(r18, QuickNoteKeys.RIGHT_LONG_PRESS.getValue()) == false) goto L51;
            String r22 = r13.e();
            if (r22 != null) goto L42;
        L43:
            r110 = true;
        L44:
            if (r110 == false) goto L48;
            QuickNoteItemState r23 = r17.b;
            if (r23 != QuickNoteItemState.CONFIRMED) goto L49;
            r23 = QuickNoteItemState.IDLE;
        L49:
            r17 = f59.a.a(r17, r23);
            goto L76
        L48:
            r23 = QuickNoteItemState.CONFIRMED;
            goto L49
        L42:
            if (r22.length() != 0) goto L44;
        L51:
            if (Intrinsics.areEqual(r18, QuickNoteKeys.LEFT_DOUBLE_CLICK.getValue()) == false) goto L64;
            String r24 = r13.b();
            if (r24 != null) goto L55;
        L56:
            r110 = true;
        L57:
            if (r110 == false) goto L61;
            QuickNoteItemState r25 = r17.b;
            if (r25 != QuickNoteItemState.CONFIRMED) goto L62;
            r25 = QuickNoteItemState.IDLE;
        L62:
            r17 = f59.a.a(r17, r25);
            goto L76
        L61:
            r25 = QuickNoteItemState.CONFIRMED;
            goto L62
        L55:
            if (r24.length() != 0) goto L57;
        L64:
            if (Intrinsics.areEqual(r18, QuickNoteKeys.RIGHT_DOUBLE_CLICK.getValue()) == false) goto L76;
            String r26 = r13.d();
            if (r26 != null) goto L68;
        L69:
            r110 = true;
        L70:
            if (r110 == false) goto L74;
            QuickNoteItemState r27 = r17.b;
            if (r27 != QuickNoteItemState.CONFIRMED) goto L75;
            r27 = QuickNoteItemState.IDLE;
        L75:
            r17 = f59.a.a(r17, r27);
            goto L76
        L74:
            r27 = QuickNoteItemState.CONFIRMED;
            goto L75
        L68:
            if (r26.length() != 0) goto L70;
        L77:
            Intrinsics.checkNotNullParameter(r15, "itemUiStates");
            if (r9.compareAndSet(r10, new k(r15)) == false) goto L21;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            if (DoraAdapterExtKt.h(kj4.a.g()) == null) goto L11;
            QuickNoteRepo r111 = QuickNoteRepo.a;
            this.label = 1;
            r12 = r111.c(this);
            if (r12 != r0) goto L15;
            return r0;
        L11:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onViewQuickNoteRecord$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailViewModel$onViewQuickNoteRecord$1", f = "QuickNoteDetailViewModel.kt", i = {}, l = {83, 88}, m = "invokeSuspend", n = {}, s = {})
    public static final class C03131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QuickNoteDetailViewModel this$0;

        public C03131(QuickNoteDetailViewModel r1, Continuation<? super C03131> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C03131(this.this$0, r3);
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
            boolean r3 = true;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L37:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r8);
            Object r9 = ((Result) r8).unbox-impl();
        L18:
            if (Result.isSuccess-impl(r9) == false) goto L35;
            String r6 = null;
            if (Result.isFailure-impl(r9) == false) goto L22;
            r9 = null;
        L22:
            y r10 = (y) r9;
            if (r10 == null) goto L25;
            r6 = r10.a();
        L25:
            if (r6 != null) goto L27;
        L30:
            if (r3 == true) goto L34;
            g49.d.a("QuickNoteDetailViewModel", "onViewQuickNoteRecord, open url: " + r6);
            MutableSharedFlow r11 = QuickNoteDetailViewModel.access$get_quickNoteRecordUrl$p(this.this$0);
            this.label = 2;
            if (r11.emit(r6, this) != r0) goto L37;
            return r0;
        L34:
            g49.d.e("QuickNoteDetailViewModel", "onViewQuickNoteRecord failed, url is empty.");
            goto L37
        L27:
            if (r6.length() == 0) goto L30;
            r3 = false;
            goto L30
        L35:
            g49.d.b("QuickNoteDetailViewModel", "onViewQuickNoteRecord failed.");
            s.a.g(AppHost.a.getApplication(), 2131908080, false);
            goto L37
        L10:
            ResultKt.throwOnFailure(r8);
            DoraDevice r12 = DoraAdapterExtKt.h(kj4.a.g());
            if (r12 != null) goto L14;
            g49.d.e("QuickNoteDetailViewModel", "onViewQuickNoteRecord failed, device is null.");
            return Unit.INSTANCE;
        L14:
            int r2 = b.a;
            DoraBuryPointManager.a.L("event_view_quick_note_record", MapsKt.emptyMap());
            DoraNetworkApi r4 = DoraNetworkApi.a;
            this.label = 1;
            r9 = r4.u(r12, this);
            if (r9 != r0) goto L18;
            return r0;
        }
    }

    public QuickNoteDetailViewModel() {
        QuickNoteRepo.a.getClass();
        StateFlowImpl r0 = j1.a(new k(QuickNoteRepo.i));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
        MutableSharedFlow<String> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._quickNoteRecordUrl = r1;
        this.quickNoteRecordUrl = kotlinx.coroutines.flow.e.a(r1);
        GestureSettingsRepository.a.getClass();
        final StateFlowImpl r2 = GestureSettingsRepository.h;
        this.gestureSettingsStateFlow = new QuickNoteDetailViewModel$special$$inlined$map$1(r2);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    private final void onConfirmed() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03111(this, null), 2, null);
    }

    private final void onQueryConfig() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03121(this, null), 2, null);
    }

    private final void onViewQuickNoteRecord() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03131(this, null), 2, null);
    }

    public final Flow<c0> getGestureSettingsStateFlow() {
        return this.gestureSettingsStateFlow;
    }

    public final d1<String> getQuickNoteRecordUrl() {
        return this.quickNoteRecordUrl;
    }

    public final i1<k> getUiState() {
        return this.uiState;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_quickNoteRecordUrl$p(QuickNoteDetailViewModel r0) {
        return r0._quickNoteRecordUrl;
    }

    public static final /* synthetic */ z0 access$get_uiState$p(QuickNoteDetailViewModel r0) {
        return r0._uiState;
    }

    private final void onItemClicked(int r9) {
        f59.a r0 = (f59.a) CollectionsKt.getOrNull(((k) this._uiState.getValue()).a, r9);
        if (r0 != null) goto L7;
        g49.d.b("QuickNoteDetailViewModel", "onItemClicked index:" + r9 + ", but state is null.");
        return;
    L7:
        if (r0.b != QuickNoteItemState.CONFIRMED) goto L10;
        u0.a("gesture_settings");
        com.bytedance.router.i r10 = SmartRouter.buildRoute(AppHost.a.getApplication(), "//dora_gesture_settings");
        r10.d = 2130772401;
        r10.e = 2130772399;
        r10.d();
        g49.d.a("QuickNoteDetailViewModel", "onItemClicked, current state is CONFIRMED, open gesture settings page.");
        return;
    L10:
        z0<k> r1 = this._uiState;
    L11:
        Object r2 = r1.getValue();
        List<f59.a> r3 = ((k) r2).a;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
        int r6 = 0;
    L13:
        if (r5.hasNext() == false) goto L27;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        f59.a r11 = (f59.a) r7;
        if (r9 != r6) goto L26;
        int r12 = a.a[r11.b.ordinal()];
        if (r12 != 1) goto L22;
        r11 = f59.a.a(r11, QuickNoteItemState.IDLE);
        goto L26
    L22:
        if (r12 != 2) goto L26;
        r11 = f59.a.a(r11, QuickNoteItemState.SELECTED);
    L26:
        r4.add(r11);
        r6 = r8;
        goto L13
    L27:
        Intrinsics.checkNotNullParameter(r4, "itemUiStates");
        if (r1.compareAndSet(r2, new k(r4)) == false) goto L11;
    }

    public final void onAction(com.larus.dora.impl.dynamic.quicknote.a r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if ((r2 instanceof com.larus.dora.impl.dynamic.quicknote.a.c) == false) goto L6;
        onQueryConfig();
        return;
    L6:
        if ((r2 instanceof com.larus.dora.impl.dynamic.quicknote.a.C0067a) == false) goto L9;
        onItemClicked(((com.larus.dora.impl.dynamic.quicknote.a.C0067a) r2).a);
        return;
    L9:
        if ((r2 instanceof com.larus.dora.impl.dynamic.quicknote.a.b) == false) goto L12;
        onConfirmed();
        return;
    L12:
        if ((r2 instanceof com.larus.dora.impl.dynamic.quicknote.a.d) == false) goto L16;
        onViewQuickNoteRecord();
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
