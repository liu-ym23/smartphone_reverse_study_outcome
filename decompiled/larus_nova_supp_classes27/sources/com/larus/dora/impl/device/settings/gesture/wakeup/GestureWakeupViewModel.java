package com.larus.dora.impl.device.settings.gesture.wakeup;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.util.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000*\u0001\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0016\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gestureWakeupStateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupSideType;", "getGestureWakeupStateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "gestureWakeupUpdateFlow", "", "getGestureWakeupUpdateFlow", "_actionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupAction;", "actionSharedFlow", "getActionSharedFlow", "doraLinkCallback", "com/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupViewModel$doraLinkCallback$1;", "adapter", "Lcom/bytedance/dora/DoraAdapter;", "kotlin.jvm.PlatformType", "onCleared", "", "load", "checkAbility", "updateOption", "side", "", "type", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "getGestureWakeupTypes", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureWakeupViewModel extends ViewModel {
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.gesture.wakeup.a> _actionSharedFlow;
    private final d1<com.larus.dora.impl.device.settings.gesture.wakeup.a> actionSharedFlow;
    private final kj4.a adapter;
    private final a doraLinkCallback;
    private final d1<h> gestureWakeupStateFlow;
    private final d1<Boolean> gestureWakeupUpdateFlow;

    public static final class a extends t0 {
        public final /* synthetic */ GestureWakeupViewModel a;

        public a(GestureWakeupViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            super.onDoraLinkStateChanged(r1, r2, r3);
            if (r3 != 2) goto L6;
            GestureWakeupViewModel.access$load(this.a, true);
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel$load$1", f = "GestureWakeupViewModel.kt", i = {}, l = {53, 55, 59}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $checkAbility;
        int label;
        final /* synthetic */ GestureWakeupViewModel this$0;

        public AnonymousClass1(boolean r1, GestureWakeupViewModel r2, Continuation<? super AnonymousClass1> r3) {
            this.$checkAbility = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$checkAbility, this.this$0, r4);
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
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r6);
        L28:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r6);
        L24:
            GestureWakeupRepository r7 = GestureWakeupRepository.a;
            this.label = 3;
            if (r7.i(this) != r0) goto L28;
            return r0;
        L11:
            ResultKt.throwOnFailure(r6);
        L20:
            if (((Boolean) r6).booleanValue() == true) goto L24;
            MutableSharedFlow r8 = GestureWakeupViewModel.access$get_actionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.gesture.wakeup.a.C0044a r2 = com.larus.dora.impl.device.settings.gesture.wakeup.a.C0044a.a;
            this.label = 2;
            if (r8.emit(r2, this) != r0) goto L24;
            return r0;
        L12:
            ResultKt.throwOnFailure(r6);
            if (this.$checkAbility == false) goto L24;
            if (DoraAdapterExtKt.h(kj4.a.g()) == null) goto L24;
            sk4.e r9 = o0.a;
            this.label = 1;
            r6 = o0.g();
            if (r6 != r0) goto L20;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel$updateOption$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupViewModel$updateOption$1", f = "GestureWakeupViewModel.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $side;
        final /* synthetic */ GestureWakeupType $type;
        int label;

        public C02611(int r1, GestureWakeupType r2, Continuation<? super C02611> r3) {
            this.$side = r1;
            this.$type = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02611(this.$side, this.$type, r4);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            GestureWakeupRepository r6 = GestureWakeupRepository.a;
            int r2 = this.$side;
            GestureWakeupType r3 = this.$type;
            this.label = 1;
            if (r6.update(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public final List<GestureWakeupType> getGestureWakeupTypes() {
        GestureWakeupRepository.a.getClass();
        if (GestureWakeupRepository.g() == false) goto L16;
        EnumEntries<GestureWakeupType> r0 = GestureWakeupType.getEntries();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L17;
        Object r3 = r2.next();
        GestureWakeupType r4 = (GestureWakeupType) r3;
        if (r4 != GestureWakeupType.RADIO) goto L10;
    L13:
        boolean r5 = true;
    L14:
        if (r5 == false) goto L6;
        r1.add(r3);
        goto L6
    L10:
        if (r4 == GestureWakeupType.CLOSE) goto L13;
        r5 = false;
    L17:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L19:
        if (r7.hasNext() == false) goto L23;
        Object r8 = r7.next();
        if (((GestureWakeupType) r8).isAvailable() == false) goto L19;
        r6.add(r8);
        goto L19
    L23:
        return r6;
    L16:
        r1 = GestureWakeupType.getEntries();
        goto L17
    }

    public GestureWakeupViewModel() {
        GestureWakeupRepository.a.getClass();
        this.gestureWakeupStateFlow = GestureWakeupRepository.i;
        this.gestureWakeupUpdateFlow = GestureWakeupRepository.k;
        MutableSharedFlow<com.larus.dora.impl.device.settings.gesture.wakeup.a> r0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._actionSharedFlow = r0;
        this.actionSharedFlow = r0;
        a r1 = new a(this);
        this.doraLinkCallback = r1;
        kj4.a r2 = kj4.a.g();
        this.adapter = r2;
        load(false);
        r2.registerDoraLinkCallback(r1);
    }

    public void onCleared() {
        super.onCleared();
        this.adapter.unregisterDoraLinkCallback(this.doraLinkCallback);
    }

    public final d1<com.larus.dora.impl.device.settings.gesture.wakeup.a> getActionSharedFlow() {
        return this.actionSharedFlow;
    }

    public final d1<h> getGestureWakeupStateFlow() {
        return this.gestureWakeupStateFlow;
    }

    public final d1<Boolean> getGestureWakeupUpdateFlow() {
        return this.gestureWakeupUpdateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_actionSharedFlow$p(GestureWakeupViewModel r0) {
        return r0._actionSharedFlow;
    }

    private final void load(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r7, this, null), 2, null);
    }

    public static final /* synthetic */ void access$load(GestureWakeupViewModel r0, boolean r1) {
        r0.load(r1);
    }

    public final void updateOption(int r8, GestureWakeupType r9) {
        Intrinsics.checkNotNullParameter(r9, "type");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C02611(r8, r9, null), 2, null);
    }
}
