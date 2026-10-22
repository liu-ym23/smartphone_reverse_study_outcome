package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.content.Context;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ ThemedCompetitionWidget a;

    public h(ThemedCompetitionWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Context r0 = ((Widget) this.a).context;
        ExceptionUtils.handleException(r0, (Throwable) r2);
    }
}
