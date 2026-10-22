package mq1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface p {
    List<EpisodeGroup> getAllEpisodeList();

    NextLiveData<List<EpisodeGroup>> getMoreReplayList();

    Observable<List<EpisodeGroup>> getPlayList();

    boolean hasMoreData();

    boolean isLoadingMore();

    Episode nextReplayItem();

    void onStartRoom(Episode r1, Context r2, ReplayDataContext r3, com.bytedance.android.livesdk.chatroom.vs_base.session.video.h r4);

    void playNext(boolean r1);

    void refreshItem(Episode r1);

    void refreshReplayList();

    void registerReplayListListener(b r1, boolean r2);

    void registerReplaySwitchListener(e0 r1, boolean r2);

    void release();

    void switchPlayVideo(Episode r1, boolean r2);

    void tryLoadingMoreReplay(Episode r1);

    void unregisterReplayListListener(b r1);

    void unregisterReplaySwitchListener(e0 r1);
}
