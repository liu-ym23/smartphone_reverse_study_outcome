package or1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.tetris.widgets.VSRecyclableWidgetManager;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.android.livesdkapi.jsb.IExternalBrowserService;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c, com.bytedance.android.scope.o {

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r3) {
            SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            return new Pair(r4.getEventName(), r4.getParams());
        }
    }

    public d() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final String appendCommonParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return jc1.k.n(IBrowserService.class).appendCommonParams(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("https://www.cac.gov.cn/2017-08/25/c_1121541842.htm", "url");
        jc1.k.n(IBrowserService.class).buildFullScreenWebPage(r3, "https://www.cac.gov.cn/2017-08/25/c_1121541842.htm").b();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void dismissAllWebDialogs(Activity r2) {
        IBrowserService r0 = jc1.k.f(IBrowserService.class);
        if (r0 == null) goto L6;
        r0.dismissAllWebDialogs(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void f(VSRecyclableWidgetManager r3) {
        if (r3 == null) goto L5;
        r3.ea0(jc1.k.n(IBrowserService.class).provideBridgeSupportWidgetClass(), false, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        return jc1.k.n(IBrowserService.class).registerExternalMethodFactory(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Pair<String, Map<String, Object>>> registerJsEventSubscriber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return jc1.k.n(IBrowserService.class).registerJsEventSubscriber(r2).map(a.a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final DialogFragment a(Context r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        return jc1.k.n(IBrowserService.class).showHybridDialog(r3, r4, null);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Uri d(Uri r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        return com.bytedance.android.live.schema.helper.h.b(r3, "url", r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void sendJsEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter("ticket_unpaid", "eventName");
        Intrinsics.checkNotNullParameter(r3, "param");
        jc1.k.n(IExternalBrowserService.class).enqueueEvent("ticket_unpaid", r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return jc1.k.n(IBrowserService.class).getHybridCard(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridFragment getHybridFragment(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return jc1.k.n(IBrowserService.class).getHybridFragment(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridDialog showHybridDialog(Context r7, Uri r8, b7.a r9, Bundle r10, DialogInterface.OnDismissListener r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        return jc1.k.n(IBrowserService.class).showHybridDialog(r7, r8, r9, null, r11);
    }
}
