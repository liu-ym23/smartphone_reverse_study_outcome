package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "setGiftTrayPosition")
public final class z extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/z$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "bottom", "I", "a", "()I", "setBottom", "(I)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("bottom")
        private int bottom;

        @SerializedName("type")
        private String type;

        public a() {
            this.type = BuildConfig.FLAVOR;
        }

        public final int a() {
            return this.bottom;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void onTerminate() {
    }

    public z() {
    }

    public final void invoke(Object r3, CallContext r4) {
        a r5 = (a) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.getType();
        int r7 = r5.a();
        if ("set".equals(r6) == false) goto L6;
        jc1.k.n(IGiftService.class).updateGiftTrayPosition(new f0(s1.f(r7), true));
        return;
    L6:
        if ("reset".equals(r6) == false) goto L10;
        jc1.k.n(IGiftService.class).updateGiftTrayPosition(new f0(s1.f(r7), false));
        return;
    }
}
