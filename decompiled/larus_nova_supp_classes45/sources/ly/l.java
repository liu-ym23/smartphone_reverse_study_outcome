package ly;

import com.bytedance.android.live.browser.IBaseBrowserService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements com.bytedance.ies.web.jsbridge2.f.b {
    public final /* synthetic */ h a;

    public l(h r1) {
        this.a = r1;
    }

    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).provideRegisterMessageLatchMethod(this.a.c);
    }
}
