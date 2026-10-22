package yg0;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static final String a = null;

    static {
        StringBuilder r0 = new StringBuilder("https://");
        IMiddleWareHostContext r1 = k.f(IMiddleWareHostContext.class);
        boolean r3 = false;
        if (r1 == null) goto L8;
        if (r1.isBoe() == false) goto L8;
        String r2 = "tosv-boe.byted.org";
    L14:
        r0.append(r2);
        r0.append("/obj/");
        IMiddleWareHostContext r4 = k.f(IMiddleWareHostContext.class);
        if (r4 == null) goto L20;
        if (r4.isBoe() == false) goto L20;
        String r5 = "gecko-internal/10893";
    L26:
        r0.append(r5);
        r0.append("/gecko/resource/webcast_multilink_layout_config_resource");
        a = r0.toString();
        return;
    L20:
        if (((Boolean) vm2.b.b.getValue(null, vm2.b.a[0])).booleanValue() == true) goto L23;
        r3 = v.a();
    L23:
        if (r3 == false) goto L25;
        r5 = "gecko-internal/10180";
        goto L26
    L25:
        r5 = "byte-gurd-source/10181";
    L8:
        if (((Boolean) vm2.b.b.getValue(null, vm2.b.a[0])).booleanValue() == false) goto L10;
        boolean r6 = false;
    L11:
        if (r6 == false) goto L13;
        r2 = "tosv.byted.org";
        goto L14
    L13:
        r2 = "lf-webcast-sourcecdn-tos.bytegecko.com";
        goto L14
    L10:
        r6 = v.a();
        goto L11
    }
}
