package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.room.ILiveSDKService;
import com.bytedance.android.live.user.IUserService;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e5 {
    public static final /* synthetic */ int a = 0;

    public static final class a implements com.bytedance.android.live.core.verify.utils.a.g {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void onVerify(boolean r1, Map<String, Object> r2) {
        }
    }

    public static final class b implements com.bytedance.android.live.core.verify.utils.a.f {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Observable<Response<w80.a>> a(Map<String, String> r4) {
            HashMap r0 = new HashMap();
            r0.put("scene", "1");
            r0.putAll(r4);
            return ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).getCertificationCommonSubmit(r0);
        }
    }

    static {
    }

    public static void a(Activity r9) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Bundle r5 = new Bundle();
        r5.putString("enter_from", "minor");
        r5.putString("request_page", "live_detail");
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 != null) goto L5;
    L7:
        String r1 = null;
    L8:
        com.bytedance.android.live.core.verify.utils.a.p(r9, null, "recharge", r1, r5, a.a, b.a, false);
        return;
    L5:
        if (r0.user().isLogin() == false) goto L7;
        r1 = r0.user().a(r0.user().n());
        goto L8
    }

    public static void b(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Activity r5 = ContextUtil.contextToActivity(r4);
        Bundle r0 = new Bundle();
        r0.putString("enter_from", "safety");
        jc1.k.n(ILiveSDKService.class).handleRealNameConflictWithoutDialog(r5, 111, null, r0);
    }
}
