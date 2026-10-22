package dt8;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
        AppHost.a.isDebugChannel();
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter("CustomActionBarSpringReportStrategy", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        FLogger.a.i("actionbar_log_CustomActionBarSpringReportStrategy", r2);
    }
}
