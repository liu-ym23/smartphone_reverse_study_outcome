package qc0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.RevImCacheUnit;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u01.k;
import u01.l;
import u01.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f {
    void a(m r1);

    void b();

    void c();

    void d(l r1);

    void e(k r1);

    String getFeedViewName();

    b getIMultiFeedView();

    c getIPkFeedView();

    List<String> getImCacheTags();

    a getKtvComponentFeedView();

    void monitorLayouts(String r1);

    Observable<pc0.d> observeFeedViewExposeData();

    void onOnlineListChanged();

    void onSeiUpdatedRaw(String r1);

    void onViewHolderPause();

    void onViewHolderResume();

    void onViewHolderSelected();

    void onViewHolderUnSelected();

    void putImCacheContent(Map<String, ? extends RevImCacheUnit> r1);

    void reset();

    void sendMessage(List<? extends yh6.c> r1);

    void setJsBridgeMap(Map<String, ? extends com.bytedance.ies.web.jsbridge2.f.b> r1);

    void setLivePlayerView(Object r1);

    void updateRoom(IRoom r1);

    void updateTalkState(HashMap<String, Boolean> r1);
}
