package com.bytedance.android.live.liveinteract.bgComponent.theme;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ Function2 a;
    public final /* synthetic */ int b;

    public o(Function2 r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        Function2 r0 = this.a;
        if (r0 == null) goto L5;
        Unit r1 = (Unit) r0.invoke(null, Boolean.FALSE);
    L5:
        ALogger.i("[VideoTalk]VoiceLiveThemeManager", "requestThemeList.failed.bgType:" + this.b);
        com.bytedance.android.live.liveinteract.bgComponent.theme.util.a.a(false, r5);
    }
}
