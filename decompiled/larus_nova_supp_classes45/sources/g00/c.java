package g00;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.LiveBroadcastHashTagUpdateParams;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.AnchorColumnPosterInfo;
import io.reactivex.Observable;
import nz.h;
import nz.t;
import org.json.JSONObject;
import z00.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c extends t {
    k a(Fragment r1, Room r2);

    h getBroadcastBubbleManager();

    String getLiveCoreVersion();

    boolean hasPoiPermission();

    @Override // nz.t
    void init();

    void openPosterGenerateDialog(Context r1, AnchorColumnPosterInfo r2);

    void savePerfKeva(JSONObject r1);

    Observable<Integer> updateBroadcastRoomHashTag(LiveBroadcastHashTagUpdateParams r1);
}
