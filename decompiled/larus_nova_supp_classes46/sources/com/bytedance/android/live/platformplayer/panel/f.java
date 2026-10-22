package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdk.message.model.nk;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public final HashMap<Integer, vlc.l> a;
    public nk b;
    public final StreamAutoAdapterService c;

    public f() {
        StreamAutoAdapterService r0 = StreamAutoAdapterService.o;
        Intrinsics.checkNotNullParameter(r0, "streamAdapterService");
        this.c = r0;
        this.a = new HashMap();
    }

    public final void a(nk r5) {
        int r0 = r5.H();
        nk r1 = this.b;
        if (r1 != null) goto L5;
    L11:
        StreamAutoAdapterService r2 = this.c;
        StringBuilder r3 = new StringBuilder("room@");
        CommonMessageData r4 = ((BaseMessage) r5).baseMessage;
        if (r4 == null) goto L14;
        Long r6 = Long.valueOf(r4.roomId);
    L15:
        r3.append(r6);
        r3.append(" cache message, adaptationType: ");
        r3.append(r5.H());
        r3.append(", adaptationHeightRatio: ");
        r3.append(r5.G());
        r3.append(", adaptationBodyCenterRatio: ");
        r3.append(r5.E());
        r2.e(r3.toString());
        this.b = r5;
        return;
    L14:
        r6 = null;
        goto L15
    L5:
        if (r0 != r1.H()) goto L11;
        float r7 = r5.G();
        nk r8 = this.b;
        if (r8 == null) goto L11;
        if (r7 != r8.G()) goto L11;
    }
}
