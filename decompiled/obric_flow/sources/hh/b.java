package hh;

import android.text.TextUtils;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import com.bytedance.pia.core.bridge.methods.n0;
import com.bytedance.pia.core.plugins.StreamingPlugin;
import j1.g;
import kotlin.jvm.internal.Intrinsics;
import l9.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends WebMessagePort.WebMessageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebMessagePort[] f17323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f17324c;

    public /* synthetic */ b(Object r5, WebMessagePort[] r10, int r11) {
        this.f17322a = r11;
        this.f17324c = r5;
        this.f17323b = r10;
    }

    @Override // android.webkit.WebMessagePort.WebMessageCallback
    public final void onMessage(WebMessagePort r5, WebMessage r10) {
        switch(this.f17322a) {
            case 0: goto L21;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        if ("streaming_ack".equals(r10.getData()) == false) goto L36;
        ((StreamingPlugin) this.f17324c).f7050h.set(this.f17323b[0]);
        return;
    L36:
        return;
    L9:
        if (r10 == null) goto L37;
        String r11 = r10.getData();
        if (r11 != null) goto L14;
        return;
    L14:
        if (r11.length() == 0) goto L40;
        boolean r12 = Intrinsics.areEqual("__channel_ack__", r11);
        g r13 = (g) this.f17324c;
        if (r12 == false) goto L19;
        r13.e = this.f17323b[0];
        return;
    L19:
        r13.d.c(r11);
        String r14 = "[WebViewAIBridgePort] receive message:" + r11 + " from WebMessagePort";
        Intrinsics.checkNotNullParameter("ai_bridge", "tag");
        Intrinsics.checkNotNullParameter(r14, "msg");
        a1.a.f43a.d("ai_bridge", r14);
        return;
    L40:
        return;
    L37:
        return;
    L21:
        String r15 = r10.getData();
        if (TextUtils.isEmpty(r15) == true) goto L44;
        boolean r16 = "__port_init__".equals(r15);
        l r17 = (l) this.f17324c;
        com.bytedance.pia.core.utils.a r18 = (com.bytedance.pia.core.utils.a) r17.d;
        if (r16 == false) goto L28;
        r18.b(new n0(2, r17, Boolean.FALSE));
        return;
    L28:
        if ("__port_init_next__".equals(r15) == false) goto L31;
        r18.b(new n0(2, r17, Boolean.TRUE));
        return;
    L31:
        if ("__channel_ack__".equals(r15) == false) goto L33;
        r17.f19575c = this.f17323b[0];
        return;
    L33:
        ((com.bytedance.pia.core.utils.a) r17.f19574b).c(r15);
        return;
    }
}
