package mq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    void onListDataChanged(List<? extends EpisodeGroup> r1);

    void onPullDataFailed(Throwable r1);
}
