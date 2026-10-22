package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "privilege_wear_notification")
public final class g3 extends com.bytedance.ies.web.jsbridge2.f<b, JSONObject> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/g3$b;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "privilegeName", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "toastText", "b", BuildConfig.FLAVOR, "wear_status", "I", "c", "()I", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("privilege_name")
        private final String privilegeName;

        @SerializedName("toast_text")
        private final String toastText;

        @SerializedName("wear_status")
        private final int wear_status;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L12;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.privilegeName, r4.privilegeName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.toastText, r4.toastText) == true) goto L10;
            return false;
        L10:
            if (this.wear_status == r4.wear_status) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r0 = this.privilegeName;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.toastText;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return ((r3 + r1) * 31) + this.wear_status;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(privilegeName=" + this.privilegeName + ", toastText=" + this.toastText + ", wear_status=" + this.wear_status + ")";
        }

        public b() {
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "privilegeName");
            Intrinsics.checkNotNullParameter(BuildConfig.FLAVOR, "toastText");
            this.privilegeName = BuildConfig.FLAVOR;
            this.toastText = BuildConfig.FLAVOR;
            this.wear_status = 0;
        }

        public final String a() {
            return this.privilegeName;
        }

        public final String b() {
            return this.toastText;
        }

        public final int c() {
            return this.wear_status;
        }
    }

    static {
    }

    public final void onTerminate() {
    }

    public g3() {
    }

    public final void invoke(Object r17, CallContext r18) {
        b r0 = (b) r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r18, "context");
        String r1 = jc1.k.n(IUserService.class).user().b().getIdString();
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.J2;
        Map r3 = (Map) r2.getValue();
        r3.put(r1, r0.b());
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r3);
        int r4 = r0.c();
        String r5 = r0.a();
        int r6 = r5.hashCode();
        String r7 = BuildConfig.FLAVOR;
        if (r6 == (-1103111423)) goto L13;
        if (r6 == 1025909779) goto L7;
    L19:
        String r13 = BuildConfig.FLAVOR;
    L20:
        int r8 = r0.c();
        String r9 = r0.a();
        int r10 = r9.hashCode();
        if (r10 == (-1103111423)) goto L31;
        if (r10 == 1025909779) goto L25;
    L36:
        String r14 = r7;
        com.bytedance.android.live.profit.privilege.a r11 = yt0.c.i();
        if (r11 == null) goto L40;
        r11.vo(2000, r13, r14, null);
        return;
    L40:
        return;
    L25:
        if (r9.equals("webcast_mystic") == false) goto L36;
        if (r8 != 1) goto L28;
        int r15 = 2131921700;
    L29:
        r7 = com.bytedance.android.live.core.utils.s1.B(r15);
        goto L36
    L28:
        r15 = 2131921698;
        goto L29
    L31:
        if (r9.equals("webcast_invisible") == false) goto L36;
        if (r8 != 1) goto L34;
        int r16 = 2131921696;
    L35:
        r7 = com.bytedance.android.live.core.utils.s1.B(r16);
        goto L36
    L34:
        r16 = 2131921694;
        goto L35
    L7:
        if (r5.equals("webcast_mystic") == false) goto L19;
        if (r4 != 1) goto L10;
        int r19 = 2131921701;
    L11:
        String r20 = com.bytedance.android.live.core.utils.s1.B(r19);
    L18:
        r13 = r20;
        goto L20
    L10:
        r19 = 2131921699;
        goto L11
    L13:
        if (r5.equals("webcast_invisible") == false) goto L19;
        if (r4 != 1) goto L16;
        int r21 = 2131921697;
    L17:
        r20 = com.bytedance.android.live.core.utils.s1.B(r21);
        goto L18
    L16:
        r21 = 2131921695;
        goto L17
    }
}
