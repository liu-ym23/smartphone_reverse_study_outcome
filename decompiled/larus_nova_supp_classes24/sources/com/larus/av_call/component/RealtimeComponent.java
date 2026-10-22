package com.larus.av_call.component;

import android.content.Intent;
import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.component.internal.attach.a;
import com.larus.utils.logger.FLogger;
import g88.r;
import jd9.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/av_call/component/IRealtimeComponentExt;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "getStringByFragment", "", "res", "getColorByFragment", "color", "onViewCreated", "", "view", "Landroid/view/View;", "av-call_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class RealtimeComponent extends BaseContentWidget implements r {
    public int m;

    public void A0() {
    }

    @Override // g88.r
    public void onActivityResult(int r1, int r2, Intent r3) {
    }

    @Override // g88.r
    public void onAppBackground() {
    }

    @Override // g88.r
    public void onAppForeground() {
    }

    public void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
    }

    public RealtimeComponent() {
        this.m = 2131383817;
    }

    public final int U2() {
        return this.m;
    }

    public void D9(z0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // g88.r
    public void I6(c r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void X2(int r1) {
        this.m = r1;
    }

    public final String Y2(int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L4
        return a.b(this, this).getResources().getString(r5);
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Throwable r2 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r2 == null) goto L13;
        FLogger.a.e("RealtimeComponent", "onErr=" + r2 + " res=" + r5 + " clazz=" + getClass());
        return "";
    L13:
        return "";
    }

    @Override // g88.r
    public void z2(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "event");
    }

    public void o1(MajorState r1, int r2, MajorState r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "currentMajorState");
        Intrinsics.checkNotNullParameter(r3, "newMajorState");
    }
}
