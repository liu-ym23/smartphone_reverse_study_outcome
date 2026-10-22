package com.larus.uaigc.applet;

import android.os.Bundle;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0012\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletHostService;", "", "registerAppletApplication", "", "open", "", "arguments", "Landroid/os/Bundle;", "page", "", "routeMode", "navigateBack", "delta", "", "canNavigateBack", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IMusicAppletHostService {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J!\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/applet/IMusicAppletHostService$Companion;", "Lcom/larus/uaigc/applet/IMusicAppletHostService;", "<init>", "()V", "canNavigateBack", "", "navigateBack", "delta", "", "open", "arguments", "Landroid/os/Bundle;", "page", "", "routeMode", "registerAppletApplication", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IMusicAppletHostService {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IMusicAppletHostService b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletHostService
        public final void a() {
            this.b.a();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletHostService
        public final boolean b() {
            return this.b.b();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletHostService
        public final boolean c() {
            return this.b.c();
        }

        @Override // com.larus.uaigc.applet.IMusicAppletHostService
        public final boolean d(Bundle r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "arguments");
            Intrinsics.checkNotNullParameter(r3, "page");
            Intrinsics.checkNotNullParameter(r4, "routeMode");
            return this.b.d(r2, r3, r4);
        }

        private Companion() {
            this.b = (IMusicAppletHostService) ServiceManager.get().getService(IMusicAppletHostService.class);
        }
    }

    static {
        a = Companion.c;
    }

    void a();

    boolean b();

    boolean c();

    boolean d(Bundle r1, String r2, String r3);
}
