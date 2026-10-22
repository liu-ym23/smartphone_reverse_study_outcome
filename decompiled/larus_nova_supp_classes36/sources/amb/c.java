package amb;

import at5.f;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.ss.android.lark.inline.ai.ui.richtext.NSCLarkWebView;
import com.ss.android.lark.inline.ai.ui.richtext.selection.ScrollEnable;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements f<ScrollEnable, LarkWebView> {
    public final NSCLarkWebView.b a;

    public final boolean shouldRunInUIThread() {
        return true;
    }

    public c(NSCLarkWebView.b r1) {
        this.a = r1;
    }

    public final void a(Object r1, at5.d r2, String r3, LarkWebView r4) {
        ScrollEnable r5 = (ScrollEnable) r1;
        Intrinsics.checkNotNullParameter(r2, "callback");
        Log.i("RichtextPreviewBridge", "AISelectionScrollStatusHandler : " + r5);
        if (r5 == null) goto L18;
        int r6 = r5.getScrollEnable();
        if (r6 != 0) goto L7;
        NSCLarkWebView.b r7 = this.a;
        if (r7 == null) goto L23;
        r7.setEnable(false);
        return;
    L23:
        return;
    L7:
        if (r6 == 1) goto L11;
        NSCLarkWebView.b r8 = this.a;
        if (r8 == null) goto L19;
        r8.setEnable(true);
        return;
    L19:
        return;
    L11:
        NSCLarkWebView.b r9 = this.a;
        if (r9 == null) goto L21;
        r9.setEnable(true);
        return;
    L21:
        return;
    }
}
