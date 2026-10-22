package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.business;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils.MorePanelBubbleAlog;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PadBubbleLoader a;

    public f(PadBubbleLoader r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Object r4 = ((Map) r3).get("has_pad_devices");
        if ((r4 instanceof Boolean) == true) goto L5;
        r4 = null;
    L5:
        Boolean r5 = (Boolean) r4;
        if (r5 == null) goto L8;
        this.a.g = r5.booleanValue();
    L8:
        MorePanelBubbleAlog.SimpleAlogArgsBuilder r6 = new MorePanelBubbleAlog.SimpleAlogArgsBuilder();
        r6.d(this.a.b);
        r6.c("scan pad devices callback");
        r6.a("hasDevices", Boolean.valueOf(this.a.g));
        MorePanelBubbleAlog.a(r6.b());
        this.a.b();
    }
}
