package y61;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import com.bytedance.android.live.room.api.messagewindow.model.CommonCardInitScene;
import com.bytedance.android.livesdk.message.model.i3;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    Map<String, Object> generateCardData(m1 r1, CommonCardInitScene r2);

    Map<String, Object> generateTopRightCardData(i3 r1);

    Map<Integer, m1> getBottomRightCardData();

    Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> getCardLifecycleMap();

    Map<Integer, Pair<v61.a, g71.b>> getCardMap();

    Map<MsgWindowPosition, Map<Integer, Pair<v61.a, g71.b>>> getCardMapV2();

    Map<w61.b, Map<Integer, Pair<v61.a, g71.b>>> getCardMapV3();

    Map<Integer, com.bytedance.android.live.room.api.messagewindow.builder.card.c> getCommonCardWrapperMap();

    boolean getHasInitialized();

    Map<Integer, i3> getTopRightCardData();

    Pair<String, g<JSONObject, JSONObject>> provideCloseJsMethod(Function1<? super Boolean, Unit> r1);

    Pair<String, g<JSONObject, JSONObject>> provideHideJsMethod(Function1<? super Boolean, Unit> r1);

    Pair<String, g<JSONObject, JSONObject>> providePreLoadedJsMethod(Function1<? super Boolean, Unit> r1);

    Pair<String, g<JSONObject, JSONObject>> provideShowJsMethod(Function0<Unit> r1);

    Pair<String, f.b> provideWRDSJsMethod();

    CompositeDisposable registerCardCallback(v61.a r1, int r2, z61.a r3);

    void registerJsEvent(HybridCard r1, Observable<p71.a> r2);

    void setBottomRightCardData(Map<Integer, m1> r1);

    void setCardLifecycleMap(Map<v61.a, com.bytedance.android.live.room.api.messagewindow.builder.card.b> r1);

    void setCardMap(Map<Integer, Pair<v61.a, g71.b>> r1);

    void setHasInitialized(boolean r1);

    void setTopRightCardData(Map<Integer, i3> r1);

    void unRegisterCardCallback(com.bytedance.android.live.room.api.messagewindow.builder.card.b r1, CompositeDisposable r2);
}
