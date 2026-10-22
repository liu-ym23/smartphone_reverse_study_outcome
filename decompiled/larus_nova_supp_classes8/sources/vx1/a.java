package vx1;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.LiveSettingKeys;
import com.bytedance.android.livesdk.config.e6;
import com.bytedance.android.livesdk.gecko.n;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements fw.c {
    public a() {
    }

    public final void F1(String r2, g r3, m16.b r4) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "methodInstance");
        Intrinsics.checkNotNullParameter(r4, "contextProviderFactory");
    }

    public final void e0(HybridCard r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridCard");
    }

    public final void getContextProviderFactory() {
    }

    public final void initAnnie() {
    }

    public final void m1(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter("card", "scene");
    }

    public final void x2(String r2, f r3, m16.b r4) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        Intrinsics.checkNotNullParameter(r3, "methodInstance");
        Intrinsics.checkNotNullParameter(r4, "contextProviderFactory");
    }

    public final List<Object> getBehaviorList() {
        return k.n(IBrowserService.class).getBehaviorList();
    }

    public final void closeWebDialog() {
        xs2.b.a().post(new b30.c());
        Annie.closeAllAnnieDialog(null);
    }

    public final Observable<Unit> K(fw.a r3) {
        Intrinsics.checkNotNullParameter(r3, "factory");
        IBrowserService r0 = k.n(IBrowserService.class);
        int r1 = e.a;
        Intrinsics.checkNotNullParameter(r3, "jsBridgeMethodFactory");
        return r0.registerExternalMethodFactory(new c(r3));
    }

    public final void activateGeckoResource(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = com.bytedance.android.livesdk.gamecp.utils.d.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        if (((e6) LiveSettingKeys.LIVE_GAME_PROMOTE_GECKO_ACTIVATE_CONFIG.getValue()).b() == false) goto L7;
        TTExecutors.getNormalExecutor().submit(new com.bytedance.android.livesdk.gamecp.utils.c(r3));
        return;
    }

    public final Long getGeckoLatestChannelVersion(String r4) {
        String r0 = n.b.b();
        com.bytedance.geckox.b r1 = com.bytedance.geckox.b.a.a;
        String r2 = (String) ((ConcurrentHashMap) GlobalManager.d).get(r0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return ResLoadUtils.getLatestChannelVersion(new PolarisFileWrapper(r2), r0, r4);
    }

    public final Observable<fw.b> registerJsEventSubscriber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Observable r3 = k.n(IBrowserService.class).registerJsEventSubscriber(r2);
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r3, "jsEvent");
        return r3.flatMap(d.a);
    }

    public final <T> void sendEventToAllJsBridges(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        k.n(IBrowserService.class).sendEventToAllJsBridges(r2, r3);
    }

    public final HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return k.n(IBrowserService.class).getHybridCard(r2, r3, r4);
    }

    public final HybridDialog showHybridDialog(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return k.n(IBrowserService.class).showHybridDialog(r2, r3, r4);
    }
}
