package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.live.core.utils.s;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.de0;
import com.bytedance.android.livesdk.config.wc1;
import com.bytedance.android.livesdkapi.room.handler.ILiveRoomViewHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IWidgetType;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AudienceExplainCardWidget<T> implements IExternalWidget, IWidgetType, com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a<T> {
    public ILiveRoomViewHandler a;
    public volatile boolean b;
    public boolean c;
    public Animator d;
    public Animator e;
    public final long f;
    public final f<T> g;

    public final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final View getExplainCardView() {
        return this.g.getExplainCardView();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnBtnClickBlock() {
        return this.g.getOnBtnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnClickBlock() {
        return this.g.getOnClickBlock();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final Function0<Unit> getOnCloseBlock() {
        return this.g.getOnCloseBlock();
    }

    public final void onHide() {
    }

    public final void onLoad() {
        this.b = true;
    }

    public final void onShow() {
    }

    public final void onUnload() {
        this.b = false;
    }

    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewDetached() {
    }

    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
    }

    public final void onViewWillDetach() {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setData(T r2) {
        this.g.setData(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnBtnClickBlock(Function0<Unit> r2) {
        this.g.setOnBtnClickBlock(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnClickBlock(Function0<Unit> r2) {
        this.g.setOnClickBlock(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setOnCloseBlock(Function0<Unit> r2) {
        this.g.setOnCloseBlock(r2);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappcommon.explaincard.a
    public final void setSupplementInfo(com.bytedance.android.livesdk.wrds.syncdata.openplatform.a r2) {
        this.g.setSupplementInfo(r2);
    }

    public final void g() {
        Animator r0 = this.d;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.d = null;
        Animator r1 = this.e;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        this.e = null;
    }

    public final View getView() {
        if (this.g.getParent() == null) goto L9;
        ViewParent r0 = this.g.getParent();
        if (r0 == null) goto L8;
        ((ViewGroup) r0).removeView(this.g);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        f<T> r1 = this.g;
        r1.setAlpha(0.0f);
        return r1;
    }

    public final IWidgetType.ExternalWidgetType getWidgetType() {
        return IWidgetType.ExternalWidgetType.MINI_APP_POP_CARD;
    }

    public final void t(final s r5) {
        if (((wc1) de0.a.getValue()).h() == true) goto L8;
        this.g.setPivotX(0.0f);
        if (this.g.getHeight() != 0) goto L7;
        qo0.a.c("Perf", "prepare exec card anim, but height is 0");
        this.g.measure(View.MeasureSpec.makeMeasureSpec(s1.y(), ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION), View.MeasureSpec.makeMeasureSpec(s1.y(), ILinkPlayerInfoBridge.DEFAULT_ClIENT_UI_POSITION));
        f<T> r0 = this.g;
        r0.setPivotY(r0.getMeasuredHeight());
        goto L8
    L7:
        f<T> r1 = this.g;
        r1.setPivotY(r1.getHeight());
    L8:
        Animator r2 = this.d;
        if (r2 == null) goto L15;
        h.a(r2, new AudienceExplainCardWidget$startShowCardAnim$$inlined$run$lambda$1(this, r5));
        if (r5 == null) goto L13;
        r2.addListener(r5);
    L13:
        r2.start();
        return;
    }

    public final void q(long r8, Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        if (this.g.getParent() != null) goto L6;
        UtilityKotlinExtentionsKt.s(r8, false, false, r10, 6);
        return;
    L6:
        if (r8 > 0) goto L8;
        this.g.post(new a(r10));
        return;
    L8:
        this.g.postDelayed(new a(r10), r8);
    }

    public AudienceExplainCardWidget(Context r2, long r3, f<T> r5) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r5, "cardView");
        this.f = r3;
        this.g = r5;
    }

    public final Animator j(long r10, Pair<Float, Float> r12, long r13, Pair<Float, Float> r15) {
        AnimatorSet r0 = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.g, "ScaleX", new float[]{((Number) r12.getFirst()).floatValue(), ((Number) r12.getSecond()).floatValue()});
        r1.setDuration(r10);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.g, "ScaleY", new float[]{((Number) r12.getFirst()).floatValue(), ((Number) r12.getSecond()).floatValue()});
        r3.setDuration(r10);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.g, "ScaleX", new float[]{((Number) r15.getFirst()).floatValue(), ((Number) r15.getSecond()).floatValue()});
        r11.setDuration(r13);
        ObjectAnimator r14 = ObjectAnimator.ofFloat(this.g, "ScaleY", new float[]{((Number) r15.getFirst()).floatValue(), ((Number) r15.getSecond()).floatValue()});
        r14.setDuration(r13);
        r0.play(r1).with(r3).before(r11).before(r14);
        return r0;
    }
}
