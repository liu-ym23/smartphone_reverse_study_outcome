package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.openplatform.IHostOpenPlatformGameService;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayApi;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayInstanceApi;
import com.bytedance.android.livehostapi.business.depend.xplay.XplayEnvParams;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o<T> implements SingleOnSubscribe {
    public final /* synthetic */ XplayCoreService a;

    public static final class a implements IXplayApi.IXplayInitCallback {
        public final /* synthetic */ o a;
        public final /* synthetic */ IXplayApi b;
        public final /* synthetic */ SingleEmitter c;

        public final void onSuccess() {
            XplayLog.a("XplayCoreService", "Xplay API init succeeded");
            XplayCoreService r0 = this.a.a;
            IXplayApi r1 = this.b;
            r0.c = r1;
            IXplayInstanceApi r2 = r0.d;
            if (r2 != null) goto L8;
            XplayEnvParams r3 = new XplayEnvParams();
            Context r4 = r0.r.getContext();
            if ((r4 instanceof FragmentActivity) == true) goto L7;
            r4 = null;
        L7:
            r3.setFragmentActivity((FragmentActivity) r4);
            r3.setDeviceId(jta.g.d());
            r3.setUserId(r0.r.e);
            r2 = r1.createInstance(r3);
        L8:
            this.a.a.d = r2;
            this.c.onSuccess(r2);
        }

        public final void onFailure(int r9) {
            this.c.onError(new ErrorCodeException(Integer.valueOf(r9), "Xplay API init failed, errorCode = " + r9, null, 4, null));
        }

        public a(o r1, IXplayApi r2, SingleEmitter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public o(XplayCoreService r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<IXplayInstanceApi> r9) {
        Intrinsics.checkNotNullParameter(r9, "emitter");
        IHostOpenPlatformGameService r0 = TTLiveSDK.hostService().hostApp().getOpenPlatformGameService();
        if (r0 == null) goto L5;
        IXplayApi r1 = r0.getXplayApiV2();
    L6:
        if (r1 != null) goto L8;
        r9.onError(new ErrorCodeException(-1, "Xplay API is not available", null, 4, null));
        return;
    L8:
        IXplayApi.-CC.initializeAsync$default(r1, new a(this, r1, r9), false, 2, null);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
