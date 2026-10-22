package d8b;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final Context a(Composer r4) {
        r4.startReplaceGroup(-1097321285);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1097321285, 0, -1, "com.ss.android.lark.compose.chatsetting.common.router.getPlatformContext (ChatSettingRouter.android.kt:16)");
    L5:
        Context r0 = (Context) r4.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r4.endReplaceGroup();
        return r0;
    }
}
