package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "halfFullSwitch")
public final class h0 extends com.bytedance.ies.web.jsbridge2.g<b, Object> {
    public final HybridDialog a;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/h0$b;", "", "", "enableToFull", "I", "a", "()I", "setEnableToFull", "(I)V", "enableToHalf", "b", "setEnableToHalf", "showCloseIcon", "c", "setShowCloseIcon", "annie_release"}, k = 1, mv = {1, 4, 3})
    public final class b {

        @SerializedName("enable_to_full")
        private int enableToFull;

        @SerializedName("enable_to_half")
        private int enableToHalf;

        @SerializedName("show_close_icon")
        private int showCloseIcon;

        public final int a() {
            return this.enableToFull;
        }

        public final int b() {
            return this.enableToHalf;
        }

        public final int c() {
            return this.showCloseIcon;
        }
    }

    static {
    }

    public h0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridDialog r11 = (HybridDialog) r10.c(HybridDialog.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public h0(HybridDialog r10) {
        Intrinsics.checkNotNullParameter(r10, "dialogFragment");
        this.a = r10;
    }

    public final Object invoke(Object r10, CallContext r11) {
        b r12 = (b) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        HybridDialog r13 = this.a;
        boolean r0 = false;
        if (r13 != null) goto L5;
    L9:
        HybridDialog r14 = this.a;
        if (r14 != null) goto L12;
    L16:
        HybridDialog r15 = this.a;
        if (r15 != null) goto L19;
        return null;
    L19:
        if (r12.c() != 1) goto L21;
        r0 = true;
    L21:
        r15.Z90(r0);
        return null;
    L12:
        if (r12.a() != 1) goto L14;
        boolean r16 = true;
    L15:
        r14.V90(r16);
        goto L16
    L14:
        r16 = false;
        goto L15
    L5:
        if (r12.b() != 1) goto L7;
        boolean r17 = true;
    L8:
        r13.W90(r17);
        goto L9
    L7:
        r17 = false;
        goto L8
    }
}
