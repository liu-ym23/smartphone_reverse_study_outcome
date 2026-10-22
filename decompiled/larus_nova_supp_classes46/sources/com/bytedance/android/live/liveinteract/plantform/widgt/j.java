package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Observer {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public j(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        AudioSceneBasicBusinessContentWidget r0 = this.a;
        AudioSceneBasicBusinessContentWidget.xq(r0, (ArrayList) r2);
    }
}
