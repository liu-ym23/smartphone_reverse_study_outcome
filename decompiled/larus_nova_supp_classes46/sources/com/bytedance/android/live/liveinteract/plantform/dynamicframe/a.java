package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a extends ih0.b {
    void Kk();

    void Wf(Integer r1);

    void bh(boolean r1);

    void fd(com.bytedance.android.live.liveinteract.plantform.datamerge.a r1);

    void fg(nh0.f r1);

    void initDataContext();

    void onDestroy();

    void onPause();

    void onResume();

    void onViewHolderSelected();

    void updateRoom(IRoom r1);
}
