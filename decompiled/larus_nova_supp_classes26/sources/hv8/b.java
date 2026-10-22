package hv8;

import androidx.fragment.app.FragmentActivity;
import com.larus.browsertakeover.api.BrowserTakeoverOpenResult;
import com.larus.browsertakeover.api.IBrowserTakeoverService;
import com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    static {
    }

    public static boolean a(FragmentActivity r2, a r3, RequestActionBrowserOperationInterceptor.CompletionDelegate r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "request");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        IBrowserTakeoverService r0 = (IBrowserTakeoverService) ServiceManager.get().getService(IBrowserTakeoverService.class);
        if (r0 != null) goto L7;
        r3.a(BrowserTakeoverOpenResult.SERVICE_UNAVAILABLE);
        return false;
    L7:
        return r0.a(r2, r3, r4);
    }
}
