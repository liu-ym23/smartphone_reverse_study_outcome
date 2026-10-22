package com.larus.uaigc.applet;

import android.os.Bundle;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletHostServiceNoop;", "Lcom/larus/uaigc/applet/IMusicAppletHostService;", "<init>", "()V", "registerAppletApplication", "", "open", "", "arguments", "Landroid/os/Bundle;", "page", "", "routeMode", "navigateBack", "delta", "", "canNavigateBack", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class IMusicAppletHostServiceNoop implements IMusicAppletHostService {
    public IMusicAppletHostServiceNoop() {
    }

    @Override // com.larus.uaigc.applet.IMusicAppletHostService
    public final void a() {
    }

    @Override // com.larus.uaigc.applet.IMusicAppletHostService
    public final boolean b() {
        return false;
    }

    @Override // com.larus.uaigc.applet.IMusicAppletHostService
    public final boolean c() {
        return false;
    }

    @Override // com.larus.uaigc.applet.IMusicAppletHostService
    public final boolean d(Bundle r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "arguments");
        Intrinsics.checkNotNullParameter(r3, "page");
        Intrinsics.checkNotNullParameter(r4, "routeMode");
        return false;
    }
}
