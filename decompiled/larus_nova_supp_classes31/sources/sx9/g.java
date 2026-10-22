package sx9;

import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.timonkit.impl.TimonKitService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ Ref.ObjectRef a;

    public /* synthetic */ g(Ref.ObjectRef r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        Ref.ObjectRef r0 = this.a;
        String r6 = (String) r5;
        int r1 = TimonKitService.a;
        Intrinsics.checkNotNullParameter(r6, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger.a.d("TimonKit", "Clipboard compliance getPrimaryClip callback: " + r6);
        r0.element = r6;
        return Unit.INSTANCE;
    }
}
