package qc0;

import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.model.f1;
import com.bytedance.android.livesdk.chatroom.model.v1;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    void a(f1 r1);

    void b(v1 r1);

    String getFeedViewName();

    HashMap<String, Object> getKtvEnterRoomExtraParam();

    Object getKtvSeiModelObject();

    ViewGroup getKtvVideoContainer();

    Observable<za> getOrderInfoObservable();

    void onSeiUpdatedRaw(String r1);

    void reset();

    void setAttachParent(ViewGroup r1, ViewGroup.LayoutParams r2);

    void setLivePlayerView(Object r1);

    void setRenderViewBitmapToMockView();

    void updateKsongLayout(ViewGroup.LayoutParams r1);

    void updateKsongLayout(Function1<? super ViewGroup.LayoutParams, ? extends ViewGroup.LayoutParams> r1);

    void updateRoom(IRoom r1);
}
