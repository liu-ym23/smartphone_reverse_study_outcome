package com.bytedance.android.live.room;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface r extends IService {
    Disposable K(long r1, Function1<Object, Unit> r3);

    void P3(long r1, DataCenter r3, boolean r4);

    void X0(WeakHandler r1);

    Observable a(long r1);

    Observable<Response<Map<String, Room>>> p0(long[] r1);

    Disposable p4(WeakHandler r1, long r2);

    Observable<BaseResponse<Room, Extra>> r1(long r1, String r3, String r4, String r5, String r6);

    void x(WeakHandler r1, long r2, boolean r4, DataCenter r5);
}
