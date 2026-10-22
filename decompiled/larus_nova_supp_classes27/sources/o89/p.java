package o89;

import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.e_commerce.impl.applet.apis.ECAppletPanelApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static q89.c a;
    public static boolean b;
    public static final List<Function0<Unit>> c = null;

    static {
        c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [o89.j] */
    /* JADX WARN: Type inference failed for: r1v7, types: [o89.l] */
    public static void a(final boolean r6) {
        if (a == null) goto L5;
        return;
    L5:
        if (b == true) goto L20;
        ILoginService r0 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r0 == null) goto L10;
        n38.e r1 = r0.Y(LoginPlatform.DOUYIN);
    L12:
        if (r1 == null) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        return;
    L17:
        b = true;
        Observable r3 = ((ECAppletPanelApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://ec.snssdk.com", ECAppletPanelApi.class)).fetchPanelData("/aftersale/ecom_tool", MapsKt.mapOf(new Pair[]{TuplesKt.to("aid", String.valueOf(AppHost.a.getAppId())), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_ENTER_FROM, "applet"), TuplesKt.to("enter_from_live_saas", "1")})).subscribeOn(Schedulers.io());
        final ?? r4 = new j();
        Consumer r5 = new k(r4);
        final ?? r7 = new l(r6);
        r3.subscribe(r5, new m(r7));
        return;
    L14:
        r2 = false;
        goto L15
    L10:
        r1 = null;
        goto L12
    }
}
