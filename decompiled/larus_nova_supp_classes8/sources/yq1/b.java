package yq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    boolean canShowMsgBoard(DataCenter r1);

    String getMsgBoardSchema(DataCenter r1);

    k getVsMsgBoardIcon(DataCenter r1);

    String getVsMsgBoardLiveEpisodeId(DataCenter r1);

    void paidStatusChanged(DataCenter r1);

    boolean replayToolbarDataHasDress(Episode r1);
}
