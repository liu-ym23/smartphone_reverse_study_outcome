package com.bytedance.android.live.profit.redpacket;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LuckyBoxClientService implements cv0.a, com.bytedance.android.scope.o {
    public final List<Function1<b1, Unit>> a;
    public b1 b;
    public final BehaviorSubject<com.bytedance.android.live.profit.redpacket.model.h> c;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // cv0.a
    public final void activateIconFirst() {
        LuckyBoxClientService$activateIconFirst$execute$1 r0 = LuckyBoxClientService$activateIconFirst$execute$1.INSTANCE;
        b1 r1 = this.b;
        if (r1 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r2 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r1)) == null) goto L6;
    }

    @Override // cv0.a
    public final void adjustToTempStateWidth() {
        LuckyBoxClientService$adjustToTempStateWidth$execute$1 r0 = LuckyBoxClientService$adjustToTempStateWidth$execute$1.INSTANCE;
        b1 r1 = this.b;
        if (r1 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r2 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r1)) == null) goto L6;
    }

    @Override // cv0.a
    public final Observable observeLuckyBoxShortTouchTempState() {
        return new com.bytedance.revenue.platform.api.core.rx.b(this.c);
    }

    @Override // cv0.a
    public final void removeLuckyBoxShortTouchItem() {
        LuckyBoxClientService$removeLuckyBoxShortTouchItem$execute$1 r0 = LuckyBoxClientService$removeLuckyBoxShortTouchItem$execute$1.INSTANCE;
        b1 r1 = this.b;
        if (r1 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r2 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r1)) == null) goto L6;
    }

    @Override // cv0.a
    public final void showNormalState() {
        LuckyBoxClientService$showNormalState$execute$1 r0 = LuckyBoxClientService$showNormalState$execute$1.INSTANCE;
        b1 r1 = this.b;
        if (r1 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r2 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r1)) == null) goto L6;
    }

    public LuckyBoxClientService() {
        this.a = new ArrayList();
        Class r0 = com.bytedance.android.live.profit.redpacket.model.h.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L17;
        this.c = BehaviorSubject.createDefault((com.bytedance.android.live.profit.redpacket.model.h) r4);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.model.ObserveLuckyBoxShortTouchTempStateResponse");
    }

    @Override // cv0.a
    public final Single<com.bytedance.android.live.profit.redpacket.model.a> getTempStateDuration(int r5) {
        Class r0 = com.bytedance.android.live.profit.redpacket.model.a.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L21;
        com.bytedance.android.live.profit.redpacket.model.a r6 = (com.bytedance.android.live.profit.redpacket.model.a) r4;
        b1 r7 = this.b;
        if (r7 == null) goto L17;
        long r8 = r7.getTempShowTime(r5);
    L18:
        r6.setDuration(r8);
        return Single.just(r6);
    L17:
        r8 = 0;
        goto L18
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.model.GetTempStateDurationResponse");
    }

    @Override // cv0.a
    public final void requestShowTempState(final int r2) {
        Function1<b1, Unit> r0 = new LuckyBoxClientService$requestShowTempState$execute$1(r2);
        b1 r3 = this.b;
        if (r3 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r4 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r3)) == null) goto L6;
    }

    @Override // cv0.a
    public final void updateDiamondCountForTempState(final long r2) {
        Function1<b1, Unit> r0 = new LuckyBoxClientService$updateDiamondCountForTempState$execute$1(r2);
        b1 r3 = this.b;
        if (r3 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r4 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r3)) == null) goto L6;
    }

    @Override // cv0.a
    public final void createLuckyBoxShortTouchItem(final String r2, final boolean r3, final String r4) {
        Intrinsics.checkNotNullParameter(r2, "luckyBoxShowTouchInitData");
        Intrinsics.checkNotNullParameter(r4, "luckyBoxAniViewInitData");
        Function1<b1, Unit> r0 = new LuckyBoxClientService$createLuckyBoxShortTouchItem$execute$1(r3, r2, r4);
        b1 r5 = this.b;
        if (r5 != null) goto L5;
    L6:
        this.a.add(r0);
        Unit r6 = Unit.INSTANCE;
        return;
    L5:
        if (((Unit) r0.invoke(r5)) == null) goto L6;
    }
}
