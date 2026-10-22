package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.logsdk.format.Spm;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    public final void accept(Object r3) {
        String r4 = "failed to get emoji list. message is " + ((Throwable) r3).getMessage();
        int r0 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.k.a;
        Intrinsics.checkNotNullParameter(r4, "info");
        Spm.Companion.getClass();
        vw2.a.a(Spm.a.a("a100.a100.a314.a999").e().addArg("info", r4), "ChatChannelTracer");
    }
}
