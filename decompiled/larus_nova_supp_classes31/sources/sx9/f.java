package sx9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.timonkit.impl.TimonKitService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f implements Function1 {
    public /* synthetic */ f() {
    }

    public final Object invoke(Object r4) {
        String r5 = (String) r4;
        int r0 = TimonKitService.a;
        Intrinsics.checkNotNullParameter(r5, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger.a.i("TimonKit", "Clipboard compliance getPrimaryClipWithPattern callback: " + r5);
        return Unit.INSTANCE;
    }
}
