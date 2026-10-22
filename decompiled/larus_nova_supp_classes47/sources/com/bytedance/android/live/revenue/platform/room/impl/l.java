package com.bytedance.android.live.revenue.platform.room.impl;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomCart;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentData;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l implements o, yz0.k, yz0.e {
    public com.bytedance.android.livesdk.revenue.room.a a;
    public Context b;
    public DataCenter c;
    public long d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BehaviorSubject a;

        public b(BehaviorSubject r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            BackendGeneratedData r3 = (BackendGeneratedData) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L6;
            this.a.onNext(r3);
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    static {
    }

    @Override // yz0.k
    public final boolean isGameRoom() {
        return false;
    }

    public final void onStart() {
    }

    @Override // yz0.k, yz0.g
    public Context getContext() {
        Context r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.e.getContext();
    }

    @Override // yz0.e
    public final Single<yz0.b> getCurrentRoom() {
        yz0.b r0 = new yz0.b();
        r0.a(getRoom());
        return Single.just(r0);
    }

    @Override // yz0.k
    public final DataCenter getDataCenter() {
        DataCenter r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.e.getDataCenter();
    }

    @Override // yz0.e
    public final Single<yz0.c> getOrientation() {
        yz0.c r0 = new yz0.c();
        if (((Boolean) this.e.getRoomContext().isPortraitInteraction().getValue()).booleanValue() == false) goto L5;
        int r1 = yz0.c.a;
        int r2 = 1;
    L6:
        r0.a(r2);
        return Single.just(r0);
    L5:
        int r3 = yz0.c.a;
        r2 = 0;
        goto L6
    }

    public final com.bytedance.android.livesdk.revenue.room.a getRoomContext() {
        com.bytedance.android.livesdk.revenue.room.a r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.e.getRoomContext();
    }

    public final void onStop() {
        this.b = this.e.getContext();
        this.a = this.e.getRoomContext();
        this.c = this.e.getDataCenter();
    }

    @Override // yz0.k, yz0.g
    public final Observable<IBaseUser> L0() {
        return getRoomContext().getUser().a().map(c.a);
    }

    @Override // yz0.k
    public final String Ln() {
        return getRoomContext().getFeedRespFrom();
    }

    @Override // yz0.k
    public final Observable<Boolean> Z2() {
        Observable<Boolean> r0 = getRoomContext().isPortraitInteraction().a();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.rx.Observable<kotlin.Boolean> /* = io.reactivex.Observable<kotlin.Boolean> */");
    }

    @Override // yz0.k
    public final boolean e4() {
        IRoomCart r0 = ((IRoom) getRoomContext().getRoom().getValue()).getRoomCart();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getShowCartExt() != 1) goto L7;
        return true;
    }

    @Override // yz0.k
    public final dq2.a getActivityRoomSkinInfo() {
        return getRoomContext().getActivityRoomSkinInfo();
    }

    @Override // yz0.k
    public final Observable<dq2.e> getAudioTalkSwitchSceneEvent() {
        return getRoomContext().getAudioTalkSwitchSceneEvent();
    }

    @Override // yz0.k
    public final long getDesireId() {
        return getRoomContext().getDesireId();
    }

    @Override // yz0.k
    public final long getEnterRoomTime() {
        return getRoomContext().getEnterRoomTime();
    }

    @Override // yz0.k
    public final long getForbiddenBeforeEnd() {
        return getRoomContext().getForbiddenBeforeEnd();
    }

    @Override // yz0.k
    public final boolean getHasCommerceEntrance() {
        return getRoomContext().getHasCommerceEntrance();
    }

    @Override // yz0.k
    public final long getLiveDurationStartTime() {
        return getRoomContext().getLiveDurationStartTime();
    }

    @Override // yz0.k
    public final ILiveMode getLiveMode() {
        return getRoomContext().getLiveMode();
    }

    @Override // yz0.k
    public final String getLogPb() {
        return getRoomContext().getLogPb();
    }

    @Override // yz0.k
    public final RevPadOrientation getPadOrientationData() {
        return getRoomContext().getPadOrientationData();
    }

    @Override // yz0.k
    public final IRoom getRoom() {
        return (IRoom) getRoomContext().getRoom().getValue();
    }

    @Override // yz0.k
    public final List<IToolbarComponentData> getToolbarDataList() {
        return getRoomContext().getToolbarDataList();
    }

    @Override // yz0.k, yz0.g
    public final IBaseUser getUser() {
        return (IBaseUser) getRoomContext().getUser().getValue();
    }

    @Override // yz0.k
    public final long getUserFrom() {
        return getRoomContext().getUserFrom();
    }

    @Override // yz0.k
    public final dq2.g getVideoTalkRoomSubScene() {
        return getRoomContext().getVideoTalkRoomSubScene();
    }

    @Override // yz0.k, yz0.g
    public final boolean isAnchor() {
        return ((Boolean) getRoomContext().isAnchor().getValue()).booleanValue();
    }

    @Override // yz0.k
    public final boolean isAudioRoom() {
        return Intrinsics.areEqual(((IRoom) getRoomContext().getRoom().getValue()).getStreamType().getSceneName(), "audio");
    }

    @Override // yz0.k
    public final boolean isCleanMode() {
        return ((Boolean) getRoomContext().isCleanMode().getValue()).booleanValue();
    }

    @Override // yz0.k
    public final boolean isLiveTypeSandbox() {
        return getRoomContext().isLiveTypeSandbox();
    }

    @Override // yz0.k
    public final boolean isPortraitInteraction() {
        return ((Boolean) getRoomContext().isPortraitInteraction().getValue()).booleanValue();
    }

    @Override // yz0.k
    public final long Hl() {
        return this.d;
    }

    @Override // yz0.j
    /* JADX INFO: renamed from: getRoom, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ IRoomBase mo444getRoom() {
        return getRoom();
    }

    public l(com.bytedance.android.livesdk.revenue.service.room.c r4) {
        Intrinsics.checkNotNullParameter(r4, "revRoomService");
        this.e = r4;
        CompositeDisposable r5 = new CompositeDisposable();
        BackendGeneratedData r0 = (BackendGeneratedData) getRoomContext().getRoomBackendData().getValue();
        if (r0 != null) goto L5;
        BehaviorSubject r1 = BehaviorSubject.create();
    L6:
        RxUtilKt.c(getRoomContext().getRoomBackendData().a().subscribe(new b(r1)), r5);
        Unit r6 = Unit.INSTANCE;
        return;
    L5:
        r1 = BehaviorSubject.createDefault(r0);
        goto L6
    }

    @Override // yz0.k
    public final void xc(long r1) {
        this.d = r1;
    }
}
