package sx9;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.timonkit.impl.TimonKitService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class h implements Function1 {
    public final /* synthetic */ ClipData a;

    public /* synthetic */ h(ClipData r1) {
        this.a = r1;
    }

    public final Object invoke(Object r8) {
        ClipData r0 = this.a;
        String r9 = (String) r8;
        int r1 = TimonKitService.a;
        Intrinsics.checkNotNullParameter(r9, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger r2 = FLogger.a;
        r2.i("TimonKit", "Clipboard compliance setPrimaryClip scene: " + r9);
        ClipboardManager r6 = null;
        if (StringsKt.contains$default(r9, "code=-6003", false, 2, null) == false) goto L12;
        r2.i("TimonKit", "Clipboard background, try to set using system call instead");
        Object r10 = AppHost.a.getApplication().getSystemService("clipboard");
        if ((r10 instanceof ClipboardManager) == false) goto L7;
        r6 = (ClipboardManager) r10;
    L7:
        if (r6 == null) goto L12;
        if (r0 != null) goto L10;
        r0 = ClipData.newPlainText("", "");
    L10:
        TimonKitService.i(r6, r0);
    L12:
        return Unit.INSTANCE;
    }
}
