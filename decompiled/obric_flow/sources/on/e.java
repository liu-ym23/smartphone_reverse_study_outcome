package on;

import com.lynx.jsbridge.LynxResourceModule;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f20782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f20783i;

    @Override // on.b
    public final Map b() {
        HashMap r5 = this.f20783i;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return new HashMap();
    }

    @Override // on.b
    public final String c() {
        String r5 = this.f20782h;
        if (r5 == null) goto L5;
        return r5;
    L5:
        return LynxResourceModule.PARAMS_KEY;
    }
}
