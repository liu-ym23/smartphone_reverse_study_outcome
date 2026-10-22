package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "authorization")
public final class q0 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {
    public final List<String> a;
    public final Map<String, List<String>> b;
    public TokenCert c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/q0$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "args", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "token", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private final Map<String, String> args;

        @SerializedName("token")
        private final String token;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.type, r4.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.args, r4.args) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.token, r4.token) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<String, String> r4 = this.args;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.token;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", args=" + this.args + ", token=" + this.token + ")";
        }

        public final Map<String, String> a() {
            return this.args;
        }

        public final String b() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void onTerminate() {
    }

    public q0() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        List<String> r0 = CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
    L6:
        this.a = r0;
        this.b = MapsKt.mapOf(new Pair[]{TuplesKt.to("location", CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})), TuplesKt.to("writeStorage", r0)});
        this.c = TokenCert.Companion.with("bpea-live_authPermissionMethod_jsb_get_location_or_write_storage_permission");
        return;
    L5:
        r0 = CollectionsKt.emptyList();
        goto L6
    }

    public static JSONObject j(boolean r5) {
        return new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("isAuthorization", Integer.valueOf(r5 ? 1 : 0))}));
    }

    public final void invoke(Object r5, CallContext r6) {
        a r7 = (a) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        List<String> r0 = this.b.get(r7.getType());
        if (r0 == null) goto L30;
        String r1 = r7.a().get("method");
        String r2 = r7.a().get("value");
        String r8 = r7.b();
        if (r8 != null) goto L7;
    L9:
        if (r1 == null) goto L28;
        int r9 = r1.hashCode();
        if (r9 == 102230) goto L24;
        if (r9 != 113762) goto L28;
        if (r1.equals("set") == false) goto L28;
        if (Intrinsics.areEqual(r2, "open") == false) goto L31;
        TokenCert r11 = this.c;
        Context r3 = r6.getContext();
        if (r3 == null) goto L22;
        SettingKey<Boolean> r4 = m60.i.a;
        new m60.i.b((Activity) r3).a(new r0(this, r6, r0), r11, r0);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L31:
        return;
    L24:
        if (r1.equals("get") == false) goto L28;
        finishWithResult(j(m60.c.c(r6.getContext(), r0)));
        return;
    L28:
        throw new IllegalArgumentException("Unsupported permission operation");
    L7:
        if (StringsKt.isBlank(r8) == true) goto L9;
        this.c = TokenCert.Companion.with(r8);
        goto L9
    L30:
        throw new IllegalArgumentException("Unsupported permission type");
    }
}
