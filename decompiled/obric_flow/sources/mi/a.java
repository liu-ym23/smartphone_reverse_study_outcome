package mi;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f20109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20110b;

    public a() {
        Intrinsics.checkNotNullParameter("bdx_monitor_bridge_web_auth", "eventName");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        ((a) r5).getClass();
        if (Intrinsics.areEqual("bdx_monitor_bridge_web_auth", "bdx_monitor_bridge_web_auth") == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return 2080462331;
    }

    public final String toString() {
        return "AuthReportInfo : eventName: bdx_monitor_bridge_web_auth, category:" + this.f20109a + ", metrics: null, url: null";
    }
}
