package na8;

import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements gk5.a {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ o b;
    public final /* synthetic */ IvyBridgeMethod.a c;
    public final /* synthetic */ String d;

    public final void onCancel() {
        if (this.a.compareAndSet(false, true) == false) goto L5;
        FLogger.a.i("OfficeCCMH5JSBMethod", "handle cancelled, method=" + this.b.b);
        bx7.c.c(this.b, this.c, -7, "User cancelled", 8);
        this.b.i(this);
        return;
    L5:
        a("cancel");
    }

    public final void a(String r4) {
        FLogger.a.w("OfficeCCMH5JSBMethod", "ignore duplicate callback, method=" + this.b.b + ", type=" + r4);
    }

    public final void onEvent(JSONObject r6) {
        Intrinsics.checkNotNullParameter("biz.forms.onFrameRecorded", "name");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (Intrinsics.areEqual("biz.forms.onFrameRecorded", this.b.c) == true) goto L6;
        FLogger.a.w("OfficeCCMH5JSBMethod", "drop unexpected event, method=" + this.b.b + ", event=biz.forms.onFrameRecorded");
        return;
    L6:
        IXBridgeApi.Companion r0 = IXBridgeApi.a;
        this.b.getClass();
        r0.b("biz.forms.onFrameRecorded", o.g(r6), this.d);
        FLogger.a.i("OfficeCCMH5JSBMethod", "send event, method=" + this.b.b + ", event=biz.forms.onFrameRecorded, containerId=" + this.d);
        if (this.b.f(r6) == false) goto L10;
        this.b.i(this);
        return;
    }

    public final void onSuccess(JSONObject r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (this.a.compareAndSet(false, true) == false) goto L5;
        FLogger.a.i("OfficeCCMH5JSBMethod", "handle success, method=" + this.b.b);
        o r0 = this.b;
        IvyBridgeMethod.a r1 = this.c;
        r0.getClass();
        bx7.c.d(r0, r1, o.g(r4));
        return;
    L5:
        a("success");
    }

    public final void onFailure(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (this.a.compareAndSet(false, true) == false) goto L5;
        FLogger.a.w("OfficeCCMH5JSBMethod", "handle failure, method=" + this.b.b + ", code=" + r4);
        bx7.c.c(this.b, this.c, r4, r5, 8);
        this.b.i(this);
        return;
    L5:
        a("failure");
    }

    public p(AtomicBoolean r1, o r2, ux7.d.d r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
