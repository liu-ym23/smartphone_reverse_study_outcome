package com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation;

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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    DialogFragment a(Context r1, Uri r2);

    String appendCommonParams(String r1);

    void c(Context r1);

    Uri d(Uri r1, String r2);

    void dismissAllWebDialogs(Activity r1);

    void f(VSRecyclableWidgetManager r1);

    HybridCard getHybridCard(Context r1, Uri r2, b7.a r3);

    HybridFragment getHybridFragment(Context r1, Uri r2, b7.a r3);

    Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r1);

    Observable<Pair<String, Map<String, Object>>> registerJsEventSubscriber(String r1);

    void sendJsEvent(String r1, JSONObject r2);

    HybridDialog showHybridDialog(Context r1, Uri r2, b7.a r3, Bundle r4, DialogInterface.OnDismissListener r5);
}
