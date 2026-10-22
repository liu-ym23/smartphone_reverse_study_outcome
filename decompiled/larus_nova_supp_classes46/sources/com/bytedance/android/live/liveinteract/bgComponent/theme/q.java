package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q<T> implements Consumer {
    public final /* synthetic */ j a;
    public final /* synthetic */ IVoiceLiveTheme b;
    public final /* synthetic */ int c;

    public q(j r1, IVoiceLiveTheme r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r5) {
        ApiServerException r6 = (Throwable) r5;
        if (this.b.getBgStatus() == 1) goto L5;
    L7:
        be0.a r0 = this.a.c.a(this.c);
        r0.getCurrentTheme().setValue(r0.a().getValue());
        if ((r6 instanceof ApiServerException) == false) goto L10;
        f2.c(r6.getPrompt(), 0);
    L11:
        ALogger.e("[VideoTalk]VoiceLiveThemeManager", "selectTheme.failed " + r6);
        h.b(false, r6);
        return;
    L10:
        f2.b(2131922877, 0);
        goto L11
    L5:
        if (IVoiceLiveThemeKt.isUgcVideoTheme(this.b) == false) goto L7;
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "selectTheme.failed but isUgcVideoTheme=true and bgStatus is in audit");
    }
}
