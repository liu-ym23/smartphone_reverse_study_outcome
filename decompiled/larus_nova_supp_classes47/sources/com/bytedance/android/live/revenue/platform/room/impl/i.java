package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements yz0.d, o {
    public final BehaviorSubject<yz0.a> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public i() {
        this.a = BehaviorSubject.create();
    }

    @Override // yz0.d
    public final Observable<yz0.a> observeCoreRoomInfo() {
        return this.a;
    }
}
