package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    void b(String r1, Object r2);

    void e(String r1);

    void f(qb r1);

    String getFeedViewName();

    FrameLayout.LayoutParams getKtvComponentLayoutParams();

    View getViewCompat();

    void h(SeiAppData r1);

    void insertEffectView(View r1, int r2);

    void j(cj r1);

    void m(int r1, int r2, List<Integer> r3);

    void o(IPreviewMultiLinkOuterConfigProvider r1, te0.a r2);

    void onLivePlayerVideoSizeChanged();

    void onViewHolderPause();

    void onViewHolderResume();

    void onViewHolderSelected();

    void onViewHolderUnSelected();

    void release();

    void removeEffectView();

    void s();

    void updateMvControllerSei(String r1);

    void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r1);

    void updateRadioSei(JSONObject r1);

    void updateRadioTextSei(JSONObject r1);

    void updateSpeechRecognitionSei(String r1);

    void updateSpeechRhythmSei(String r1);

    void updateSubtitleSei(String r1);
}
