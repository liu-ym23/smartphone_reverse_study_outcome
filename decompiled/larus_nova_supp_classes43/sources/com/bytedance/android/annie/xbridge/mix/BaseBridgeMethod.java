package com.bytedance.android.annie.xbridge.mix;

import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/BaseBridgeMethod;", "Lz36/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBridgeMethod extends z36.a implements LifecycleObserver, com.bytedance.sdk.xbridge.cn.protocol.h {

    public static final class a extends com.bytedance.android.annie.xbridge.mix.a {
        public final /* synthetic */ IBridgeMethod.a a;

        public a(IBridgeMethod.a r1) {
            this.a = r1;
        }

        public final void a(String r10) {
            IBridgeMethod.a r0 = this.a;
            if (r10 != null) goto L5;
            r10 = "";
        L5:
            r0.onError(-1, r10);
        }

        public final void b(JSONObject r10) {
            this.a.onComplete(r10);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public void b(JSONObject r10, a r11) throws JSONException {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
    }

    public BaseBridgeMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        super(r10);
    }

    public final void b70(JSONObject r10, IBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        b(r10, new a(r11));
    }
}
