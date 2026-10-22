package com.bytedance.android.live.core.verify.interceptor;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements com.bytedance.android.live.core.verify.utils.a.f {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // com.bytedance.android.live.core.verify.utils.a.f
    public final Observable<Response<w80.a>> a(Map<String, String> r4) {
        HashMap r0 = new HashMap();
        r0.put("scene", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r0.putAll(r4);
        return ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).getCertificationCommonSubmit(r0);
    }
}
