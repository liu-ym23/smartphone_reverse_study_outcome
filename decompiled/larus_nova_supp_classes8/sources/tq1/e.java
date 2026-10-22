package tq1;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.vs_base.api.ReplayListApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ b a;

    public e(b r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        com.bytedance.android.live.network.response.e r6 = (com.bytedance.android.live.network.response.e) r5;
        this.a.g.setValue(Boolean.FALSE);
        this.a.h.setValue(Boolean.valueOf(!((ReplayListApi.GetMoreReplayListResponse) ((ExtraResponse) r6).data).getHasMore()));
        NextLiveData<List<EpisodeGroup>> r0 = this.a.a;
        List r1 = (List) r0.getValue();
        if (r1 != null) goto L5;
        r1 = new ArrayList();
    L5:
        EpisodeGroup r2 = new EpisodeGroup();
        r2.groupName = ((ReplayListApi.GetMoreReplayListResponse) ((ExtraResponse) r6).data).getTypeName();
        r2.episodes = ((ReplayListApi.GetMoreReplayListResponse) ((ExtraResponse) r6).data).getMoreEpisodes();
        r2.extra = ((ReplayListApi.GetMoreReplayListResponse) ((ExtraResponse) r6).data).getExtra();
        Unit r3 = Unit.INSTANCE;
        r1.add(r2);
        r0.setValue(r1);
        b r4 = this.a;
        Long r7 = ((ReplayListApi.GetMoreReplayListResponse) ((ExtraResponse) r6).data).getCursor();
        if (r7 == null) goto L8;
        long r8 = r7.longValue();
    L9:
        r4.b = r8;
        return;
    L8:
        r8 = 0;
        goto L9
    }
}
