package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T, R> implements Function {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public final Object apply(Object r3) {
        com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        LinkMicRoomDataSyncModel r0 = LinkWRDSHelper.b();
        Intrinsics.checkNotNullParameter(r4, "response");
        return Single.create(new com.bytedance.android.live.liveinteract.wrds.g(r0, r4));
    }
}
