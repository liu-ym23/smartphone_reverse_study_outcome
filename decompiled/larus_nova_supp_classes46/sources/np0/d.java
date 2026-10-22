package np0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r4, String r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "url");
        u.l().b("livesdk_live_takepage_function_component_description_page_show");
        String r0 = k.n(IHostContext.class).getVersionName();
        ILiveActionHandler r1 = k.n(IRoomService.class).actionHandler();
        StringBuilder r2 = new StringBuilder("sslocal://webcast_webview?hide_nav_bar=1&trans_status_bar=1&status_bar_color=black&web_bg_color=%23ffffffff&title=小程序组件说明&url=");
        r2.append(Uri.encode(r5 + "?engine_type=old&app_version=" + r0 + "&status_bar_height=" + s1.G(s1.A()) + "&is_talent_tab=" + r6));
        r1.handle(r4, r2.toString());
    }
}
