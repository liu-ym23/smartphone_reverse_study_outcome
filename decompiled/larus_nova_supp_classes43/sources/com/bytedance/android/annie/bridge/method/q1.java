package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "dialogPullDownClose")
public final class q1 extends com.bytedance.ies.web.jsbridge2.g<a, Object> {
    public final HybridDialog a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/q1$a;", "", "", "pullDownClose", "I", "a", "()I", "setPullDownClose", "(I)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("pull_down_close")
        private int pullDownClose;

        public a() {
        }

        public final int a() {
            return this.pullDownClose;
        }
    }

    public q1(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridDialog r11 = (HybridDialog) r10.c(HybridDialog.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public q1(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.a = r10;
    }

    public final Object invoke(Object r10, CallContext r11) {
        a r12 = (a) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        HybridDialog r13 = this.a;
        if (r13 == null) goto L11;
        boolean r0 = true;
        if (r12.a() == 1) goto L8;
        r0 = false;
    L8:
        r13.Y90(r0);
        return null;
    L11:
        return null;
    }
}
