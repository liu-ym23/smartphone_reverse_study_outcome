package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ IVoiceLiveTheme b;

    public p(long r1, IVoiceLiveTheme r3) {
        this.a = r1;
        this.b = r3;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "selectTheme.success " + this.a + ' ' + this.b.getImageUri());
        h.b(true, null);
    }
}
