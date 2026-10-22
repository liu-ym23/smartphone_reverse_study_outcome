package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "endLiveLocationModule")
public final class p0 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/p0$a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "value", "a", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.value, r4.value) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.value;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", value=" + this.value + ")";
        }

        public final String a() {
            return this.value;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void onTerminate() {
    }

    public p0() {
    }

    public static JSONObject j(Context r7, boolean r8) {
        Integer r0 = (Integer) com.bytedance.android.live.browser.c0.b.getValue();
        if (r0 != null) goto L6;
    L8:
        String r1 = "close";
    L10:
        if (m60.c.d(r7, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L12;
    L15:
        int r9 = 1;
    L17:
        return new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("show", Integer.valueOf(r8 ? 1 : 0)), TuplesKt.to("isAuthorization", Integer.valueOf(r9)), TuplesKt.to("status", r1)}));
    L12:
        if (m60.c.d(r7, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L15;
        r9 = 0;
        goto L17
    L6:
        if (r0.intValue() != 1) goto L8;
        r1 = "open";
        goto L10
    }

    public final void invoke(Object r7, CallContext r8) {
        a r9 = (a) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r0 = r9.getType();
        String r10 = r9.a();
        int r1 = r0.hashCode();
        boolean r4 = false;
        if (r1 == 102230) goto L22;
        if (r1 != 113762) goto L55;
        if (r0.equals("set") == false) goto L55;
        Context r11 = r8.getContext();
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.live.browser.c0.b;
        int r3 = r10.hashCode();
        if (r3 == 3417674) goto L16;
        if (r3 != 94756344) goto L20;
        if (r10.equals("close") == false) goto L20;
        int r5 = 0;
    L18:
        r2.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r5);
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.live.browser.c0.a;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, 0);
        finishWithResult(j(r11, Intrinsics.areEqual(r10, "open")));
        return;
    L20:
        throw new IllegalArgumentException("Invalid parameter - value");
    L16:
        if (r10.equals("open") == false) goto L20;
        r5 = 1;
    L55:
        throw new IllegalArgumentException("Invalid parameter - type");
    L22:
        if (r0.equals("get") == false) goto L55;
        Context r13 = r8.getContext();
        IMiddlewareUserService r14 = jc1.k.f(IMiddlewareUserService.class);
        if (r14 == null) goto L28;
        com.bytedance.android.livesdk.user.e r15 = r14.user();
        if (r15 == null) goto L28;
        IBaseUser r16 = r15.b();
    L29:
        IMiddlewareUserService r17 = jc1.k.f(IMiddlewareUserService.class);
        if (r17 == null) goto L40;
        com.bytedance.android.livesdk.user.e r18 = r17.user();
        if (r18 == null) goto L40;
        if (r18.H() != true) goto L40;
        boolean r19 = tb1.c.a;
        if (r16 == null) goto L40;
        if (r16.getSecret() != 1) goto L40;
        boolean r20 = false;
    L41:
        boolean r21 = tb1.c.a;
        Integer r23 = (Integer) com.bytedance.android.live.browser.c0.b.getValue();
        if (r23 == null) goto L47;
        if (r23.intValue() != 1) goto L47;
    L52:
        finishWithResult(j(r13, r4));
        com.bytedance.android.livesdk.sharedpref.e r24 = com.bytedance.android.live.browser.c0.a;
        com.bytedance.android.livesdk.sharedpref.f.d(r24, Integer.valueOf(((Integer) r24.getValue()).intValue() + 1));
        return;
    L47:
        if (((Boolean) com.bytedance.android.live.browser.c0.c.getValue()).booleanValue() == true) goto L52;
        if (((Number) com.bytedance.android.live.browser.c0.a.getValue()).intValue() > 3) goto L52;
        r4 = r20;
    L40:
        r20 = true;
    L28:
        r16 = null;
        goto L29
    }
}
