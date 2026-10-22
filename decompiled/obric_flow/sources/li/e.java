package li;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AuthBridgeAccess f19653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f19654c;
    public String d;
    public AuthConfigType e;

    public e(String r5, AuthBridgeAccess r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeName");
        Intrinsics.checkNotNullParameter(r10, "auth");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        this.f19652a = r5;
        this.f19653b = r10;
        this.f19654c = r11;
        this.e = AuthConfigType.f7304a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        String r11 = r10.f19652a;
        if (Intrinsics.areEqual(this.f19652a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f19653b == r10.f19653b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f19654c, r10.f19654c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = this.f19652a.hashCode() * 31;
        int r10 = (this.f19653b.hashCode() + r5) * 31;
        return this.f19654c.hashCode() + r10;
    }

    public final String toString() {
        return "BridgeInfo(bridgeName=" + this.f19652a + ", auth=" + this.f19653b + ", params=" + this.f19654c + ')';
    }
}
