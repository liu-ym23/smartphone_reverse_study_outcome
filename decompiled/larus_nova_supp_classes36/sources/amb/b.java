package amb;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements f<String, LarkWebView> {
    public b() {
    }

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Log.i("RichtextPreviewBridge", "AISelectionLongPressHandler : " + ((String) r1));
        if (r4 == null) goto L6;
        int r5 = com.ss.android.lark.inline.ai.utils.f.a;
        com.ss.android.lark.inline.ai.utils.f.a(r4.getContext());
        return;
    }
}
