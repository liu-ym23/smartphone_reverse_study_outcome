package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.view.View;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.sti.IECExternalEntryEvent;
import com.bytedance.android.livesdk.livecommerce.room.widgets.coupon.CustomIconTemplate;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalEntryEvent;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalEntryView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconModel;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import io.reactivex.Observable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class IconModelAdapter<STATE> extends IExternalIconModel<STATE> {
    public final STATE a;
    public final int b;
    public final yd.b<STATE> c;

    public final void dispose() {
        this.c.dispose();
    }

    public final boolean isDisposed() {
        return this.c.isDisposed();
    }

    public final void onClick() {
        this.c.m();
    }

    public final void onCreate() {
        this.c.onCreate();
    }

    public final void onDestroy() {
        this.c.onDestroy();
    }

    public final STATE getInitialState() {
        return this.a;
    }

    public final int getTypeId() {
        return this.b;
    }

    public IconModelAdapter(yd.b<STATE> r11) {
        Intrinsics.checkNotNullParameter(r11, "iconModel");
        this.c = r11;
        Function0<Unit> r0 = new AnonymousClass1(this);
        Function1<STATE, Unit> r1 = new AnonymousClass2(this);
        Function1<Integer, yd.a> r10 = new AnonymousClass3(this);
        Function0<STATE> r12 = new AnonymousClass4(this);
        Function0<Long> r13 = new AnonymousClass5(this);
        Function0<Long> r14 = new AnonymousClass6(this);
        Function0<Observable<Long>> r15 = new AnonymousClass7(this);
        Function0<Unit> r16 = new AnonymousClass8(this);
        Function4<Long, STATE, Long, Function1<? super Long, ? extends String>, Unit> r17 = new AnonymousClass9(this);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r0, "activateIcon");
        Intrinsics.checkNotNullParameter(r1, "moveToState");
        Intrinsics.checkNotNullParameter(r10, "inflateEntryView");
        Intrinsics.checkNotNullParameter(r12, "stateGetter");
        Intrinsics.checkNotNullParameter(r13, "countDownSecGetter");
        Intrinsics.checkNotNullParameter(r14, "countDownMsGetter");
        Intrinsics.checkNotNullParameter(r15, "countDownObservableGetter");
        Intrinsics.checkNotNullParameter(r16, "clearCountDown");
        Intrinsics.checkNotNullParameter(r17, "startCountDown");
        r11.a = r0;
        r11.b = r1;
        r11.c = null;
        r11.d = null;
        r11.e = null;
        this.a = r11.e();
        this.b = r11.j();
    }

    public final IExternalIconTemplate getViewForState(STATE r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        CustomIconTemplate r11 = this.c.k(r10);
        if (r11 == null) goto L5;
        Intrinsics.checkNotNullParameter(r11, "$this$convert2Live");
        return com.bytedance.android.ec.adapter.impl.converter.c.i.b.a(r11);
    L5:
        return null;
    }

    public final IExternalEntryView getEntryViewForState(STATE r10, STATE r11) {
        Intrinsics.checkNotNullParameter(r10, "state");
        yd.a r12 = this.c.d(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new IExternalEntryView(r12.a, r12.b);
    }

    public final void onEntryEvent(View r10, IExternalEntryEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "entryView");
        Intrinsics.checkNotNullParameter(r11, "event");
        yd.b<STATE> r0 = this.c;
        int r12 = e.a[r11.ordinal()];
        if (r12 != 1) goto L5;
        IECExternalEntryEvent r13 = IECExternalEntryEvent.Start;
    L13:
        r0.n(r10, r13);
        return;
    L5:
        if (r12 != 2) goto L7;
        r13 = IECExternalEntryEvent.Skip;
        goto L13
    L7:
        if (r12 != 3) goto L10;
        r13 = IECExternalEntryEvent.End;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void applyState(STATE r10, STATE r11, IExternalIconTemplate r12) {
        Intrinsics.checkNotNullParameter(r11, "curState");
        yd.b<STATE> r0 = this.c;
        if (r12 == null) goto L5;
        yd.c r13 = com.bytedance.android.ec.adapter.impl.converter.c.i.b.d(r12);
    L5:
        r0.b(r10, r11);
    }
}
