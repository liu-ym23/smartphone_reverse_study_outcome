package e2b;

import com.bytedance.lark.pb.basic.v1.Message;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.service.impl.MonitorMessageSendCallback;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h {
    public final String a;
    public final List<String> b;
    public boolean c;
    public String d;
    public String e;
    public Message.PartialReplyInfo f;
    public int g;
    public boolean h;
    public Scene i;
    public MonitorMessageSendCallback j;
    public a k;
    public final boolean l;
    public com.ss.android.lark.chat.entity.message.a m;

    public interface a {
        void a(PolarisFileWrapper r1);
    }

    public final MonitorMessageSendCallback a() {
        if (this.j != null) goto L6;
        this.j = new MonitorMessageSendCallback();
    L6:
        return this.j;
    }

    public h(String r2, List<String> r3) {
        this.h = false;
        this.a = r2;
        this.b = r3;
        this.k = new e2b.a(this);
        this.l = ImSdkProxy.c().isFeatureGatingEnable("lark.android.img.convert.to.webp");
    }
}
