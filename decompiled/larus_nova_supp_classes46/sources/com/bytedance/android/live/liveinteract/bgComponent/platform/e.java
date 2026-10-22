package com.bytedance.android.live.liveinteract.bgComponent.platform;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ MultiLinkThemeBgUIWidget a;

    public e(MultiLinkThemeBgUIWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        MultiLinkThemeBgUIWidget r0 = this.a;
        int r1 = MultiLinkThemeBgUIWidget.D;
        r0.Bq((IVoiceLiveTheme) r3, 100);
    }
}
