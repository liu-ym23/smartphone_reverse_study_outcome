package fq1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.core.tetris.widgets.VSRecyclableWidgetManager;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c, com.bytedance.android.scope.o {
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final DialogFragment a(Context r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return this.a.a(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final String appendCommonParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "url");
        return this.a.appendCommonParams(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("https://www.cac.gov.cn/2017-08/25/c_1121541842.htm", "url");
        this.a.c(r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Uri d(Uri r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        return this.a.d(r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void dismissAllWebDialogs(Activity r2) {
        this.a.dismissAllWebDialogs(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void f(VSRecyclableWidgetManager r2) {
        this.a.f(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridCard getHybridCard(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return this.a.getHybridCard(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridFragment getHybridFragment(Context r2, Uri r3, b7.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        return this.a.getHybridFragment(r2, r3, r4);
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r2) {
        Intrinsics.checkNotNullParameter(r2, "factory");
        return this.a.registerExternalMethodFactory(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Pair<String, Map<String, Object>>> registerJsEventSubscriber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return this.a.registerJsEventSubscriber(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void sendJsEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter("ticket_unpaid", "eventName");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a.sendJsEvent("ticket_unpaid", r3);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridDialog showHybridDialog(Context r7, Uri r8, b7.a r9, Bundle r10, DialogInterface.OnDismissListener r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "uri");
        return this.a.showHybridDialog(r7, r8, r9, null, r11);
    }

    public e(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridService");
        this.a = r2;
    }
}
