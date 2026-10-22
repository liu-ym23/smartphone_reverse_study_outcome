package com.bytedance.android.live.liveinteract.plantform.widgt;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

    public i(AudioSceneBasicBusinessContentWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        AudioSceneBasicBusinessContentWidget r0 = this.a;
        AudioSceneBasicBusinessContentWidget.wq(r0, (IVoiceLiveTheme) r3, 5);
    }
}
