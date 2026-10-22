package com.larus.dora.o.impl.simul;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020)J\b\u0010+\u001a\u00020)H\u0014J\b\u0010,\u001a\u00020)H\u0002J\u0018\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u000200H\u0002J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00170\nJ\u0012\u00102\u001a\u0004\u0018\u00010\u00172\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020)H\u0002J\u0006\u00107\u001a\u00020)J\u0016\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u0017J\u001c\u0010;\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010\u00172\b\u0010:\u001a\u0004\u0018\u00010\u0017H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/dora/o/impl/simul/ODoraSimulInterpretViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "avlinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "getAvlinkService", "()Lcom/larus/avlink/api/IDoraAVLinkService;", "_topList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/larus/avlink/api/DoraSimulSubtitleItem;", "topList", "Lkotlinx/coroutines/flow/StateFlow;", "getTopList", "()Lkotlinx/coroutines/flow/StateFlow;", "_bottomList", "bottomList", "getBottomList", "_isTranslating", "", "isTranslating", "_topLanguage", "Lcom/larus/avlink/api/DoraSimulLanguage;", "topLanguage", "getTopLanguage", "_bottomLanguage", "bottomLanguage", "getBottomLanguage", "_autoSwitchToastSignal", "", "autoSwitchToastSignal", "getAutoSwitchToastSignal", "topWorkList", "", "bottomWorkList", "observeJobs", "Lkotlinx/coroutines/Job;", "bound", "translationStateListener", "Lkotlin/Function1;", "", "bind", "onCleared", "restoreHistory", "applyEvent", "isTop", "event", "Lcom/larus/avlink/api/DoraSimulSubtitleEvent;", "allLanguages", "findLanguage", "code", "", "isLiteOrHDevice", "loadLanguages", "swapLanguages", "applyLanguagePair", "top", "bottom", "applyLanguages", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODoraSimulInterpretViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "ODoraSimulInterpretVM";
    private final z0<Long> _autoSwitchToastSignal;
    private final z0<w88.j> _bottomLanguage;
    private final z0<List<w88.l>> _bottomList;
    private final z0<Boolean> _isTranslating;
    private final z0<w88.j> _topLanguage;
    private final z0<List<w88.l>> _topList;
    private final i1<Long> autoSwitchToastSignal;
    private final i1<w88.j> bottomLanguage;
    private final i1<List<w88.l>> bottomList;
    private final List<w88.l> bottomWorkList;
    private boolean bound;
    private final i1<Boolean> isTranslating;
    private List<Job> observeJobs;
    private final i1<w88.j> topLanguage;
    private final i1<List<w88.l>> topList;
    private final List<w88.l> topWorkList;
    private final Function1<Boolean, Unit> translationStateListener;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$1", f = "ODoraSimulInterpretViewModel.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODoraSimulInterpretViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ODoraSimulInterpretViewModel a;

            public a(ODoraSimulInterpretViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                ODoraSimulInterpretViewModel r4 = this.a;
                ODoraSimulInterpretViewModel.access$applyEvent(r4, true, (w88.k) r2);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(ODoraSimulInterpretViewModel r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IDoraAVLinkService r6 = ODoraSimulInterpretViewModel.access$getAvlinkService(this.this$0);
            if (r6 == null) goto L16;
            Flow r7 = r6.w0(true);
            if (r7 == null) goto L16;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$2", f = "ODoraSimulInterpretViewModel.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ODoraSimulInterpretViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.o.impl.simul.ODoraSimulInterpretViewModel$bind$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ ODoraSimulInterpretViewModel a;

            public a(ODoraSimulInterpretViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                ODoraSimulInterpretViewModel r4 = this.a;
                ODoraSimulInterpretViewModel.access$applyEvent(r4, false, (w88.k) r2);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(ODoraSimulInterpretViewModel r1, Continuation<? super AnonymousClass2> r2) {
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

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IDoraAVLinkService r6 = ODoraSimulInterpretViewModel.access$getAvlinkService(this.this$0);
            if (r6 == null) goto L16;
            Flow r7 = r6.w0(false);
            if (r7 == null) goto L16;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L16;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Unit yo(ODoraSimulInterpretViewModel r0, boolean r1) {
        return translationStateListener$lambda$0(r0, r1);
    }

    private final IDoraAVLinkService getAvlinkService() {
        return (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
    }

    private final boolean isLiteOrHDevice() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.b0() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void bind() {
        if (this.bound == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.bound = true;
        IDoraAVLinkService r1 = getAvlinkService();
        z0<Boolean> r2 = this._isTranslating;
        if (r1 != null) goto L8;
    L10:
        r0 = false;
    L11:
        r2.setValue(Boolean.valueOf(r0));
        if (r1 == null) goto L14;
        r1.O0(this.translationStateListener);
    L14:
        loadLanguages();
        restoreHistory();
        this.observeJobs.add(BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null));
        this.observeJobs.add(BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(this, null), 3, null));
        return;
    L8:
        if (r1.j() != true) goto L10;
        goto L10
    }

    public final void swapLanguages() {
        applyLanguages((w88.j) this._bottomLanguage.getValue(), (w88.j) this._topLanguage.getValue());
    }

    public ODoraSimulInterpretViewModel() {
        StateFlowImpl r0 = j1.a(CollectionsKt.emptyList());
        this._topList = r0;
        this.topList = r0;
        StateFlowImpl r1 = j1.a(CollectionsKt.emptyList());
        this._bottomList = r1;
        this.bottomList = r1;
        StateFlowImpl r2 = j1.a(Boolean.FALSE);
        this._isTranslating = r2;
        this.isTranslating = r2;
        StateFlowImpl r3 = j1.a(null);
        this._topLanguage = r3;
        this.topLanguage = r3;
        StateFlowImpl r4 = j1.a(null);
        this._bottomLanguage = r4;
        this.bottomLanguage = r4;
        StateFlowImpl r5 = j1.a(0L);
        this._autoSwitchToastSignal = r5;
        this.autoSwitchToastSignal = r5;
        this.topWorkList = new ArrayList();
        this.bottomWorkList = new ArrayList();
        this.observeJobs = new ArrayList();
        this.translationStateListener = new u(this);
    }

    private final void loadLanguages() {
        boolean r0 = isLiteOrHDevice();
        Keva r1 = DoraConfig.a;
        if (r0 == false) goto L5;
        String r2 = DoraConfig.d();
    L6:
        if (r0 == false) goto L8;
        String r3 = DoraConfig.c();
    L9:
        z0<w88.j> r4 = this._topLanguage;
        w88.j r5 = findLanguage(r2);
        if (r5 != null) goto L12;
        r5 = findLanguage("en");
    L12:
        r4.setValue(r5);
        z0<w88.j> r6 = this._bottomLanguage;
        w88.j r7 = findLanguage(r3);
        if (r7 != null) goto L15;
        r7 = findLanguage("zh");
    L15:
        r6.setValue(r7);
        return;
    L8:
        r3 = DoraConfig.a();
        goto L9
    L5:
        r2 = DoraConfig.b();
        goto L6
    }

    private final void restoreHistory() {
        IDoraAVLinkService r0 = getAvlinkService();
        if (r0 != null) goto L5;
        return;
    L5:
        this.topWorkList.clear();
        this.topWorkList.addAll(r0.X0(true));
        this.bottomWorkList.clear();
        this.bottomWorkList.addAll(r0.X0(false));
        this._topList.setValue(CollectionsKt.toList(this.topWorkList));
        this._bottomList.setValue(CollectionsKt.toList(this.bottomWorkList));
    }

    public final List<w88.j> allLanguages() {
        IDoraAVLinkService r0 = getAvlinkService();
        if (r0 == null) goto L7;
        List<w88.j> r1 = r0.G0();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public void onCleared() {
        super.onCleared();
        IDoraAVLinkService r0 = getAvlinkService();
        if (r0 == null) goto L5;
        r0.C0(this.translationStateListener);
    L5:
        Iterator<T> r1 = this.observeJobs.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Job.DefaultImpls.cancel$default((Job) r1.next(), null, 1, null);
        goto L7
    L9:
        this.observeJobs.clear();
    }

    public final i1<Long> getAutoSwitchToastSignal() {
        return this.autoSwitchToastSignal;
    }

    public final i1<w88.j> getBottomLanguage() {
        return this.bottomLanguage;
    }

    public final i1<List<w88.l>> getBottomList() {
        return this.bottomList;
    }

    public final i1<w88.j> getTopLanguage() {
        return this.topLanguage;
    }

    public final i1<List<w88.l>> getTopList() {
        return this.topList;
    }

    public final i1<Boolean> isTranslating() {
        return this.isTranslating;
    }

    public static final /* synthetic */ IDoraAVLinkService access$getAvlinkService(ODoraSimulInterpretViewModel r0) {
        return r0.getAvlinkService();
    }

    private final w88.j findLanguage(String r4) {
        Iterator<T> r0 = allLanguages().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((w88.j) r1).b, r4) == false) goto L4;
    L10:
        return (w88.j) r1;
    L8:
        r1 = null;
        goto L10
    }

    private final void applyEvent(boolean r7, w88.k r8) {
        if (r7 == false) goto L4;
        List<w88.l> r0 = this.topWorkList;
    L6:
        if ((r8 instanceof w88.k.b) == false) goto L26;
        ListIterator<w88.l> r1 = r0.listIterator(r0.size());
    L9:
        if (r1.hasPrevious() == false) goto L13;
        if (Intrinsics.areEqual(r1.previous().a, ((w88.k.b) r8).b) == false) goto L9;
        int r2 = r1.nextIndex();
    L14:
        if (r2 == (-1)) goto L20;
        w88.l r3 = (w88.l) ListProtector.get(r0, r2);
        w88.k.b r9 = (w88.k.b) r8;
        if (r9.a == false) goto L18;
        w88.l r10 = w88.l.a(r3, null, StringsKt.trim(r3.c + r9.c).toString(), 3);
    L19:
        ListProtector.set(r0, r2, r10);
    L36:
        if (r7 == false) goto L38;
        this._topList.setValue(CollectionsKt.toList(r0));
        return;
    L38:
        this._bottomList.setValue(CollectionsKt.toList(r0));
        return;
    L18:
        r10 = w88.l.a(r3, StringsKt.trim(r3.b + r9.c).toString(), null, 5);
        goto L19
    L20:
        w88.k.b r11 = (w88.k.b) r8;
        if (r11.a == false) goto L23;
        w88.l r4 = new w88.l(r11.b, "", StringsKt.trim(r11.c).toString());
    L24:
        r0.add(r4);
        goto L36
    L23:
        r4 = new w88.l(r11.b, StringsKt.trim(r11.c).toString(), "");
        goto L24
    L13:
        r2 = -1;
        goto L14
    L26:
        if ((r8 instanceof w88.k.a) == false) goto L41;
        ListIterator<w88.l> r5 = r0.listIterator(r0.size());
    L29:
        if (r5.hasPrevious() == false) goto L33;
        if (Intrinsics.areEqual(r5.previous().a, ((w88.k.a) r8).a.a) == false) goto L29;
        int r6 = r5.nextIndex();
    L34:
        if (r6 == (-1)) goto L36;
        ListProtector.set(r0, r6, ((w88.k.a) r8).a);
        goto L36
    L33:
        r6 = -1;
        goto L34
    L41:
        throw new NoWhenBranchMatchedException();
    L4:
        r0 = this.bottomWorkList;
        goto L6
    }

    private final void applyLanguages(w88.j r5, w88.j r6) {
        boolean r0 = isLiteOrHDevice();
        if (r5 == null) goto L9;
        Keva r1 = DoraConfig.a;
        if (r0 == false) goto L7;
        DoraConfig.k(r5.b);
    L8:
        this._topLanguage.setValue(r5);
        goto L9
    L7:
        DoraConfig.i(r5.b);
    L9:
        if (r6 == null) goto L15;
        Keva r2 = DoraConfig.a;
        if (r0 == false) goto L13;
        DoraConfig.j(r6.b);
    L14:
        this._bottomLanguage.setValue(r6);
        goto L15
    L13:
        DoraConfig.h(r6.b);
    L15:
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("applyLanguages top=");
        String r7 = null;
        if (r5 == null) goto L18;
        String r8 = r5.b;
    L19:
        r4.append(r8);
        r4.append(" bottom=");
        if (r6 == null) goto L22;
        r7 = r6.b;
    L22:
        r4.append(r7);
        r4.append(" liteOrH=");
        r4.append(r0);
        r3.i(TAG, r4.toString());
        return;
    L18:
        r8 = null;
        goto L19
    }

    private static final Unit translationStateListener$lambda$0(ODoraSimulInterpretViewModel r2, boolean r3) {
        if (r3 == true) goto L4;
    L6:
        r2._isTranslating.setValue(Boolean.valueOf(r3));
        return Unit.INSTANCE;
    L4:
        if (((Boolean) r2._isTranslating.getValue()).booleanValue() == true) goto L6;
        r2.topWorkList.clear();
        r2.bottomWorkList.clear();
        r2._topList.setValue(CollectionsKt.emptyList());
        r2._bottomList.setValue(CollectionsKt.emptyList());
        goto L6
    }

    public final void applyLanguagePair(w88.j r2, w88.j r3) {
        Intrinsics.checkNotNullParameter(r2, "top");
        Intrinsics.checkNotNullParameter(r3, "bottom");
        applyLanguages(r2, r3);
    }

    public static final /* synthetic */ void access$applyEvent(ODoraSimulInterpretViewModel r0, boolean r1, w88.k r2) {
        r0.applyEvent(r1, r2);
    }
}
