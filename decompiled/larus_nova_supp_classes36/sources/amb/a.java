package amb;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements f<String, LarkWebView> {
    public final d a;

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "aiSelectionShowMenuHandler");
        this.a = r2;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        Log.i("RichtextPreviewBridge", "AISelectionCloseMenuHandler : " + ((String) r1));
        this.a.b();
    }
}
