package vo1;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.CommonIconModel$loadHybridComponent$1;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface i {

    public static final class a {
        public static /* synthetic */ void a(i r6, Activity r7, String r8, IBaseBrowserService.PageFinishedListener r9, IBaseBrowserService.PageErrorListener r10) {
            r6.d(r7, r8, r9, r10, "");
        }
    }

    void a(String r1, Map<String, ? extends Object> r2);

    void b(String r1, CommonIconModel$loadHybridComponent$1.a r2);

    View c();

    void d(Activity r1, String r2, IBaseBrowserService.PageFinishedListener r3, IBaseBrowserService.PageErrorListener r4, String r5);

    boolean e();

    void f(Activity r1, String r2, LynxThreadStrategy r3, d0 r4);

    View g();

    void h(String r1, Map r2, CommonIconModel$loadHybridComponent$1.a r3);

    IHybridComponent.HybridType hybridType();

    void loadUrl(String r1);

    void registerMethod(String r1, com.bytedance.ies.web.jsbridge2.f.b r2);

    void release();

    <T> void sendJsEvent(String r1, T r2);
}
