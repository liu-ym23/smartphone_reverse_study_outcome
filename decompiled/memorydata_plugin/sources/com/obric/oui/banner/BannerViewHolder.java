package com.obric.oui.banner;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0012H\u0002J\u0012\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020%H\u0004J\b\u0010&\u001a\u00020!H\u0017J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)H&J\u0018\u0010'\u001a\u00020!2\u0006\u0010*\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010+\u001a\u00020!H\u0017J\b\u0010,\u001a\u00020!H\u0017J\b\u0010-\u001a\u00020!H\u0017J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020!H\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/oui/banner/BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bannerOperator", "Lcom/obric/oui/banner/interfaces/BannerOperator;", "getBannerOperator", "()Lcom/obric/oui/banner/interfaces/BannerOperator;", "setBannerOperator", "(Lcom/obric/oui/banner/interfaces/BannerOperator;)V", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "isAttached", "", "()Z", "setAttached", "(Z)V", "isSelected", "setSelected", "selectPositionObserver", "Landroidx/lifecycle/Observer;", "selectScope", "Lkotlinx/coroutines/CoroutineScope;", "getSelectScope", "()Lkotlinx/coroutines/CoroutineScope;", "setSelectScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "checkSelectStatus", "", "force", "delayPlayDone", "delayMs", "", "onAttach", "onBind", "data", "Lcom/obric/oui/banner/BannerData;", "position", "onDetach", "onSelect", "onUnSelect", "onViewRecycled", "playDone", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BannerViewHolder extends RecyclerView.ViewHolder {
    private com.obric.oui.banner.b.a bannerOperator;
    private int currentPosition;
    private boolean isAttached;
    private boolean isSelected;
    private final Observer<Integer> selectPositionObserver;
    protected al selectScope;

    /* JADX INFO: renamed from: com.obric.oui.banner.BannerViewHolder$delayPlayDone$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.oui.banner.BannerViewHolder$delayPlayDone$1", f = "BannerViewHolder.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMs;
        int label;
        final /* synthetic */ BannerViewHolder this$0;

        AnonymousClass1(long r3, BannerViewHolder r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$delayMs = r3;
            this.this$0 = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$delayMs, this.this$0, r6), Continuation.class, "com.obric.memorydata.plugin");
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L11:
            this.this$0.playDone();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            long r3 = this.$delayMs;
            Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (au.a(r3, r7) != r0) goto L11;
            return r0;
        }
    }

    public BannerViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.currentPosition = -1;
        this.selectPositionObserver = new $$Lambda$BannerViewHolder$14tluXwa0j_GOVacZBqExe_6l30(this);
    }

    private final void checkSelectStatus(boolean r6) {
        com.obric.oui.banner.b.a r0 = this.bannerOperator;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L4:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L19;
        if (r6 == false) goto L17;
    L18:
        onSelect();
        goto L19
    L17:
        if (this.isSelected == false) goto L18;
    L19:
        com.obric.oui.banner.b.a r3 = this.bannerOperator;
        if (r3 != null) goto L22;
    L21:
        r1 = false;
    L30:
        if (r1 == true) goto L36;
        if (r6 == false) goto L33;
    L34:
        onUnSelect();
        return;
    L33:
        if (this.isSelected == true) goto L34;
        return;
    L36:
        return;
    L22:
        LiveData<Integer> r4 = r3.getSelectedPosition();
        if (r4 == null) goto L21;
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.getValue(), Integer.class, "com.obric.memorydata.plugin");
        int r7 = this.currentPosition;
        if (r5 == null) goto L21;
        if (r5.intValue() != r7) goto L21;
    L5:
        LiveData<Integer> r8 = r0.getSelectedPosition();
        if (r8 == null) goto L4;
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(r8.getValue(), Integer.class, "com.obric.memorydata.plugin");
        int r10 = this.currentPosition;
        if (r9 == null) goto L4;
        if (r9.intValue() != r10) goto L4;
        r2 = true;
        goto L14
    }

    static /* synthetic */ void checkSelectStatus$default(BannerViewHolder r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.checkSelectStatus(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkSelectStatus");
    }

    public static /* synthetic */ void delayPlayDone$default(BannerViewHolder r0, long r1, int r3, Object r4) {
        if (r4 != null) goto L12;
        if ((r3 & 1) == 0) goto L9;
        com.obric.oui.banner.b.a r2 = r0.bannerOperator;
        if (r2 != null) goto L8;
        r1 = 5000;
        goto L9
    L8:
        r1 = r2.getAutoSwitchIntervalMs();
    L9:
        r0.delayPlayDone(r1);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delayPlayDone");
    }

    public static /* synthetic */ void lambda$14tluXwa0j_GOVacZBqExe_6l30(BannerViewHolder r0, Integer r1) {
        m1256selectPositionObserver$lambda0(r0, r1);
    }

    /* JADX INFO: renamed from: selectPositionObserver$lambda-0, reason: not valid java name */
    private static final void m1256selectPositionObserver$lambda0(BannerViewHolder r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        checkSelectStatus$default(r2, false, 1, null);
    }

    public final void delayPlayDone(long r7) {
        i.a(getSelectScope(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final com.obric.oui.banner.b.a getBannerOperator() {
        return this.bannerOperator;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final al getSelectScope() {
        al r0 = this.selectScope;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("selectScope");
        return null;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public void onAttach() {
        com.obric.oui.banner.b.a r0 = this.bannerOperator;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.observeForever(this.selectPositionObserver);
    L9:
        this.isAttached = true;
    }

    public final void onBind(int r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "data");
        this.currentPosition = r3;
        onBind(r5);
        checkSelectStatus(true);
    }

    public abstract void onBind(a r1);

    public void onDetach() {
        com.obric.oui.banner.b.a r0 = this.bannerOperator;
        if (r0 == null) goto L9;
        LiveData<Integer> r1 = r0.getSelectedPosition();
        if (r1 == null) goto L9;
        r1.removeObserver(this.selectPositionObserver);
    L9:
        this.isAttached = false;
        onUnSelect();
    }

    public void onSelect() {
        setSelectScope(am.a(ba.b().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin"))));
        this.isSelected = true;
    }

    public void onUnSelect() {
        if (this.selectScope == null) goto L5;
        am.a(getSelectScope(), null, 1, null);
    L5:
        this.isSelected = false;
    }

    public void onViewRecycled() {
    }

    public void playDone() {
        if (this.isSelected == false) goto L9;
        com.obric.oui.banner.b.a r1 = this.bannerOperator;
        if (r1 == null) goto L10;
        r1.e();
        return;
    L10:
        return;
    }

    public final void setAttached(boolean r1) {
        this.isAttached = r1;
    }

    public final void setBannerOperator(com.obric.oui.banner.b.a r3) {
        this.bannerOperator = (com.obric.oui.banner.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.banner.b.a.class, "com.obric.memorydata.plugin");
    }

    public final void setCurrentPosition(int r1) {
        this.currentPosition = r1;
    }

    public final void setSelectScope(al r3) {
        al r4 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.selectScope = r4;
    }

    public final void setSelected(boolean r1) {
        this.isSelected = r1;
    }
}
