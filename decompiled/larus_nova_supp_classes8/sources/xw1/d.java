package xw1;

import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.BubbleId;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveModuleCrashFixConfig;
import java.util.ArrayList;
import java.util.List;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements c {
    public static final String k = null;
    public final String[] a;
    public final String[] b;
    public final String[] c;
    public final int[] d;
    public final int[] e;
    public final int[] f;
    public final int[] g;
    public final int[] h;
    public final int[] i;
    public final String[] j;

    @Override // xw1.c
    public final List<e> a() {
        ArrayList r0 = new ArrayList(1);
        int r1 = 0;
    L4:
        if (r1 >= this.a.length) goto L6;
        e r2 = new e();
        r2.x(this.g[r1]);
        r2.w(this.c[r1]);
        r2.A(this.c[r1]);
        r2.z(this.a[r1]);
        r2.F(this.b[r1]);
        r2.B(this.d[r1]);
        r2.D(this.e[r1]);
        r2.E(this.f[r1]);
        r2.C(this.h[r1]);
        r2.u(this.i[r1]);
        r2.y(this.j[r1]);
        r0.add(r2);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    static {
        if (LiveModuleCrashFixConfig.getLiveFixHostInitializeNpe() == true) goto L5;
        String r0 = k.f(INetworkService.class).getHostDomain();
    L9:
        k = r0;
        return;
    L5:
        if (k.f(INetworkService.class) == null) goto L7;
        r0 = k.f(INetworkService.class).getHostDomain();
        goto L9
    L7:
        r0 = "webcast.amemv.com";
        goto L9
    }

    public d() {
        this.a = new String[]{"直播"};
        StringBuilder r2 = new StringBuilder("https://");
        String r4 = k;
        r2.append(r4);
        r2.append("/webcast/feed/");
        this.b = new String[]{r2.toString()};
        this.c = new String[]{"live"};
        new String[]{"live"};
        this.d = new int[]{1};
        int[] r1 = {1};
        this.e = r1;
        this.f = new int[]{1};
        this.g = new int[]{1};
        this.h = new int[]{BubbleId.PadCastForVs};
        this.i = new int[]{0};
        this.j = new String[]{"https://" + r4 + "/webcast/feed/?cate_id=0&channel_id=21&content_type=0&req_type=0&show_location=0&style=3&sub_channel_id=0&sub_type=live_merge&tab_id=1&type=live"};
        this.b = new String[]{"https://" + r4 + "/webcast/feed/?cate_id=0&channel_id=21&content_type=0&req_type=0&show_location=0&style=2&sub_channel_id=0&sub_type=live_merge&tab_id=1&type=live"};
        r1[0] = 3;
    }
}
