package sx9;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.timonkit.impl.TimonKitService;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class e implements Function1 {
    public /* synthetic */ e() {
    }

    public final Object invoke(Object r7) {
        String r8 = (String) r7;
        int r0 = TimonKitService.a;
        Intrinsics.checkNotNullParameter(r8, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        FLogger r1 = FLogger.a;
        r1.i("TimonKit", "Clipboard compliance clearPrimaryClip reason: " + r8);
        ClipboardManager r5 = null;
        if (StringsKt.contains$default(r8, "code=-6003", false, 2, null) == false) goto L14;
        r1.i("TimonKit", "Clipboard background, try to clear using system call instead");
        Object r9 = AppHost.a.getApplication().getSystemService("clipboard");
        if ((r9 instanceof ClipboardManager) == false) goto L8;
        r5 = (ClipboardManager) r9;
    L8:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        if (r5 == null) goto L14;
        TimonKitService.j(r5);
        goto L14
    L11:
        if (r5 == null) goto L14;
        TimonKitService.i(r5, ClipData.newPlainText("", ""));
    L14:
        return Unit.INSTANCE;
    }
}
