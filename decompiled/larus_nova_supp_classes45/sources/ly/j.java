package ly;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ h a;

    public j(h r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.a.c);
    }
}
