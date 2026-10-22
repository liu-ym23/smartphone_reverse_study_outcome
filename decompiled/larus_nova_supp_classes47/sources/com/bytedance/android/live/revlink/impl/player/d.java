package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.scope.o;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface d extends o, c {
    boolean O(String r1);

    h handleSei(String r1);

    void me(StreamLayoutManager.b r1);

    PublishSubject ml();

    void q1();
}
