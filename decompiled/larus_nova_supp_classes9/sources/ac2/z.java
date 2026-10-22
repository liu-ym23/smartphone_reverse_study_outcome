package ac2;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostBoeParams;
import com.bytedance.android.livesdk.interactivity.service.uplink.FrontierTransformConfig;
import com.ss.ugc.live.sdk.message.data.PayloadItemType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements lmc.h, vlc.n {
    public com.ss.ugc.live.sdk.msg.network.m a;

    public static final class a {
    }

    static {
    }

    public z() {
    }

    public final void f() {
        this.a = null;
    }

    public final void a() {
        com.ss.ugc.live.sdk.msg.network.m r0 = this.a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public final boolean c() {
        com.ss.ugc.live.sdk.platform.a.f.getClass();
        return false;
    }

    public final boolean g() {
        int r0 = k.a;
        return true;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        com.ss.ugc.live.sdk.msg.network.m r3 = this.a;
        if (r3 == null) goto L6;
        r3.b("bytelink ws disconnect");
        return;
    }

    public final void d(tlc.f r4) {
        Intrinsics.checkNotNullParameter(r4, "payloadItem");
        com.ss.ugc.live.sdk.msg.network.m r0 = this.a;
        if (r0 != null) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(r4.c, PayloadItemType.PAYLOAD_TYPE_UPLINK.getType()) == false) goto L12;
        bc2.c.b("bytelink ws uplink packet received");     // Catch: Exception -> L9
        r0.i(r4);     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public final void e(tlc.f r14) {
        Iterator r0 = r14.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (Intrinsics.areEqual(((com.ss.ugc.live.sdk.msg.network.d) r1).a, "im_uplink_service_id") == false) goto L4;
    L9:
        com.ss.ugc.live.sdk.msg.network.d r2 = (com.ss.ugc.live.sdk.msg.network.d) r1;
        if (r2 == null) goto L16;
        String r3 = r2.b;
        if (r3 == null) goto L16;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L16;
        int r5 = r4.intValue();
    L17:
        ArrayList r8 = new ArrayList();
        List r6 = r14.f;
        if (r6 == null) goto L39;
        Iterator r7 = r6.iterator();
    L21:
        if (r7.hasNext() == false) goto L39;
        com.ss.ugc.live.sdk.msg.network.d r9 = (com.ss.ugc.live.sdk.msg.network.d) r7.next();
        String r10 = r9.a;
        boolean r11 = true;
        if (r10 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == true) goto L21;
        String r15 = r9.b;
        if (r15 != null) goto L33;
    L36:
        if (r11 == true) goto L21;
        r8.add(r9);
        goto L21
    L33:
        if (r15.length() == 0) goto L36;
        r11 = false;
        goto L36
    L25:
        if (r10.length() == 0) goto L28;
        r13 = false;
    L39:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L48;
        HostBoeParams r16 = jc1.k.n(IMiddleWareHostContext.class).getHostBoeParams();
        if (r16 == null) goto L48;
        if (r16.getBoeEnable() == false) goto L46;
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("X-Tt-Env", r16.getBoeLane()));
        goto L48
    L46:
        if (r16.getPpeEnable() == false) goto L48;
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("X-Tt-Env", r16.getPpeLane()));
        r8.add(new com.ss.ugc.live.sdk.msg.network.d("x-use-ppe", "1"));
    L48:
        FrontierTransformConfig r17 = x.a;
        Integer r18 = r17.getConfigMap().get(Integer.valueOf(r5));
        if (r18 == null) goto L51;
        int r19 = r18.intValue();
    L52:
        tlc.f r20 = new tlc.f(r19, 1, r14.c, r14.d, r14.e, r8, r14.g, r14.h);
        com.ss.ugc.live.sdk.platform.a.f.getClass();
        Intrinsics.checkNotNullParameter(r20, "payloadItem");
        return;
    L51:
        r19 = r17.getDefaultValue();
    L16:
        r5 = 0;
        goto L17
    L8:
        r1 = null;
        goto L9
    }

    public final void h(com.ss.ugc.live.sdk.msg.network.m r1) {
        this.a = r1;
        com.ss.ugc.live.sdk.platform.a.f.getClass();
    }
}
