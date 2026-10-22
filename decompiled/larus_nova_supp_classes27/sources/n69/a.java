package n69;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.p0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements p0 {
    public final /* synthetic */ Function0<Unit> a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        c.a();
        this.a.invoke();
        String r0 = UriProtector.parse("sslocal://flow/webview?.product_id=16&link_url=https://www.olafriend.com/alice/w/h5/dorag/reset_instruction").buildUpon().build().toString();
        SmartRouter.buildRoute(AppHost.a.getApplication(), r0).d();
    }

    public a(Function0<Unit> r1) {
        this.a = r1;
    }
}
