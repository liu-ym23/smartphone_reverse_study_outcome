package com.obric.oui.banner;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.q2;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0004H\u0017J\b\u0010\f\u001a\u00020\u0004H\u0017J\b\u0010\r\u001a\u00020\u0004H\u0017J\b\u0010\u000e\u001a\u00020\u0004H\u0017J\u0012\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0015J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\"\u0010\u0014\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010\u0015\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "force", "", "checkSelectStatus", "", "position", "Lcom/obric/oui/banner/a;", "data", "onBind", "onAttach", "onDetach", "onSelect", "onUnSelect", "", "delayMs", "delayPlayDone", "playDone", "onViewRecycled", "isAttached", "Z", "()Z", "setAttached", "(Z)V", "Lkotlinx/coroutines/l0;", "selectScope", "Lkotlinx/coroutines/l0;", "getSelectScope", "()Lkotlinx/coroutines/l0;", "setSelectScope", "(Lkotlinx/coroutines/l0;)V", "isSelected", "setSelected", "Landroidx/lifecycle/Observer;", "selectPositionObserver", "Landroidx/lifecycle/Observer;", "Lk9/a;", "bannerOperator", "Lk9/a;", "getBannerOperator", "()Lk9/a;", "setBannerOperator", "(Lk9/a;)V", "currentPosition", "I", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {
    private k9.a bannerOperator;
    private int currentPosition;
    private boolean isAttached;
    private boolean isSelected;
    private final Observer<Integer> selectPositionObserver;
    protected l0 selectScope;

    /* JADX INFO: renamed from: com.obric.oui.banner.BannerViewHolder$delayPlayDone$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.oui.banner.BannerViewHolder$delayPlayDone$1", f = "BannerViewHolder.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ BannerViewHolder this$0;

        AnonymousClass1(BannerViewHolder r10, long r11, Continuation r12) {
            this.this$0 = r10;
            this.$delayMs = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            return new AnonymousClass1(this.this$0, this.$delayMs, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            this.this$0.playDone();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            long r13 = this.$delayMs;
            this.label = 1;
            if (DelayKt.b(r13, this) != r11) goto L11;
            return r11;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.banner.BannerViewHolder$onUnSelect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C03911 extends PropertyReference0Impl {
        C03911(BannerViewHolder r10) {
            super(r10, BannerViewHolder.class, "selectScope", "getSelectScope()Lkotlinx/coroutines/CoroutineScope;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
        public Object get() {
            return ((BannerViewHolder) this.receiver).getSelectScope();
        }
    }

    public BannerViewHolder(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super(r10);
        this.currentPosition = -1;
        this.selectPositionObserver = new BannerViewHolder$selectPositionObserver$1(this);
    }

    private final void checkSelectStatus(boolean r10) {
        k9.a r11 = this.bannerOperator;
        Integer r12 = null;
        if (r11 == null) goto L7;
        LiveData<Integer> r13 = r11.getSelectedPosition();
        if (r13 == null) goto L7;
        Integer r14 = r13.getValue();
    L8:
        int r15 = this.currentPosition;
        if (r14 != null) goto L12;
    L17:
        k9.a r16 = this.bannerOperator;
        if (r16 == null) goto L22;
        LiveData<Integer> r17 = r16.getSelectedPosition();
        if (r17 == null) goto L22;
        r12 = r17.getValue();
    L22:
        int r18 = this.currentPosition;
        if (r12 != null) goto L26;
    L27:
        if (r10 == false) goto L29;
    L30:
        onUnSelect();
        return;
    L29:
        if (this.isSelected == true) goto L30;
        return;
    L26:
        if (r12.intValue() != r18) goto L27;
        return;
    L12:
        if (r14.intValue() != r15) goto L17;
        if (r10 == false) goto L15;
    L16:
        onSelect();
        goto L17
    L15:
        if (this.isSelected == true) goto L17;
    L7:
        r14 = null;
        goto L8
    }

    static /* synthetic */ void checkSelectStatus$default(BannerViewHolder r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.checkSelectStatus(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSelectStatus");
    }

    public static /* synthetic */ void delayPlayDone$default(BannerViewHolder r10, long r11, int r12, Object r13) {
        if (r13 != null) goto L12;
        if ((r12 & 1) == 0) goto L9;
        k9.a r14 = r10.bannerOperator;
        if (r14 == null) goto L8;
        r11 = r14.getAutoSwitchIntervalMs();
        goto L9
    L8:
        r11 = 5000;
    L9:
        r10.delayPlayDone(r11);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delayPlayDone");
    }

    protected final void delayPlayDone(long r10) {
        l0 r11 = this.selectScope;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectScope");
    L5:
        h.d(r11, null, null, new AnonymousClass1(this, r10, null), 3, null);
    }

    public final k9.a getBannerOperator() {
        return this.bannerOperator;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    protected final l0 getSelectScope() {
        l0 r10 = this.selectScope;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectScope");
    L5:
        return r10;
    }

    protected final boolean isAttached() {
        return this.isAttached;
    }

    protected final boolean isSelected() {
        return this.isSelected;
    }

    @CallSuper
    public void onAttach() {
        k9.a r10 = this.bannerOperator;
        if (r10 == null) goto L7;
        LiveData<Integer> r11 = r10.getSelectedPosition();
        if (r11 == null) goto L7;
        r11.observeForever(this.selectPositionObserver);
    L7:
        this.isAttached = true;
    }

    @CallSuper
    public final void onBind(int r10, a r11) {
        Intrinsics.checkNotNullParameter(r11, "data");
        this.currentPosition = r10;
        onBind(r11);
        checkSelectStatus(true);
    }

    public abstract void onBind(a r10);

    @CallSuper
    public void onDetach() {
        k9.a r10 = this.bannerOperator;
        if (r10 == null) goto L7;
        LiveData<Integer> r11 = r10.getSelectedPosition();
        if (r11 == null) goto L7;
        r11.removeObserver(this.selectPositionObserver);
    L7:
        this.isAttached = false;
        onUnSelect();
    }

    @CallSuper
    public void onSelect() {
        this.selectScope = m0.a(z0.c().plus(q2.b(null, 1, null)));
        this.isSelected = true;
    }

    @CallSuper
    public void onUnSelect() {
        l0 r10 = this.selectScope;
        if (r10 == null) goto L7;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectScope");
    L6:
        m0.c(r10, null, 1, null);
    L7:
        this.isSelected = false;
    }

    public void onViewRecycled() {
    }

    @CallSuper
    protected void playDone() {
        if (this.isSelected == false) goto L8;
        k9.a r10 = this.bannerOperator;
        if (r10 == null) goto L9;
        r10.a();
        return;
    L9:
        return;
    }

    protected final void setAttached(boolean r10) {
        this.isAttached = r10;
    }

    public final void setBannerOperator(k9.a r10) {
        this.bannerOperator = r10;
    }

    public final void setCurrentPosition(int r10) {
        this.currentPosition = r10;
    }

    protected final void setSelectScope(l0 r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.selectScope = r10;
    }

    protected final void setSelected(boolean r10) {
        this.isSelected = r10;
    }
}
