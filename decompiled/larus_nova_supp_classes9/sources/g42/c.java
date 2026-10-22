package g42;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    void a(g r1);

    String c(HighlightItem r1);

    void d(g r1);

    long e();

    List<d> g(PinType r1);

    Context getContext();

    String getCurrentUserId();

    DataCenter getDataCenter();

    RoomContext getDataContext();

    boolean i(HighlightItem r1);

    BehaviorSubject k();

    f m(HighlightItem r1);

    void n(PinType r1, d r2);

    Map<String, HighlightItem> o();
}
