package com.bytedance.android.live.broadcastgame.api.xplay;

import android.graphics.Rect;
import android.view.ViewGroup;
import io.reactivex.Observable;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface d {
    ViewGroup a();

    Observable<g> c();

    Rect d();

    Observable<Unit> f();

    Boolean g();

    String getRtcExtInfo();

    Rect h();

    Rect i();

    ViewGroup j();
}
