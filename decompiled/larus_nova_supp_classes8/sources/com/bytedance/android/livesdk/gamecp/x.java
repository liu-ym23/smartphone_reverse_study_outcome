package com.bytedance.android.livesdk.gamecp;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livesdk.config.dy;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.service.gamecp.IHybridService;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements IHybridService {
    public x() {
    }

    public final List<Object> getBehaviorList() {
        return jc1.k.n(IBrowserService.class).getBehaviorList();
    }

    public final void initAnnie() {
        jc1.k.n(IBrowserService.class).initAnnie();
    }

    public final void closeWebDialog() {
        xs2.b.a().post(new b30.c());
        Annie.closeAllAnnieDialog(null);
    }

    public final void activateGeckoResource(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        int r1 = ux1.c.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        if (dy.a.getValue().b() == false) goto L7;
        TTExecutors.getNormalExecutor().submit(new ux1.b(r3));
        return;
    }

    public final Long getGeckoLatestChannelVersion(String r4) {
        String r0 = com.bytedance.android.livesdk.gecko.n.b.b();
        com.bytedance.geckox.b r1 = com.bytedance.geckox.b.a.a;
        String r2 = (String) ((ConcurrentHashMap) GlobalManager.d).get(r0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return ResLoadUtils.getLatestChannelVersion(new PolarisFileWrapper(r2), r0, r4);
    }

    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        return jc1.k.n(IBrowserService.class).registerExternalMethodFactory(r2);
    }

    public final Observable<SubscriberJsEvent> registerJsEventSubscriber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return jc1.k.n(IBrowserService.class).registerJsEventSubscriber(r2);
    }

    public final <T> void sendEventToAllJsBridges(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        jc1.k.n(IBrowserService.class).sendEventToAllJsBridges(r2, r3);
    }

    public final HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return jc1.k.n(IBrowserService.class).getHybridCard(r2, r3, r4);
    }

    public final HybridDialog showHybridDialog(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return jc1.k.n(IBrowserService.class).showHybridDialog(r2, r3, r4);
    }
}
