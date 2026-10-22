package com.bytedance.android.livesdk.feedback.light;

import com.bytedance.android.annie.api.card.IHybridComponent;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j implements IHybridComponent.a {
    public final /* synthetic */ LiveLightFeedbackWidget a;

    public j(LiveLightFeedbackWidget r1) {
        this.a = r1;
    }

    public final void onJSBridgeCreated(y6.c r4) {
        Intrinsics.checkNotNullParameter(r4, "manager");
        com.bytedance.android.livesdk.feedback.light.context.a r0 = this.a.a;
        if (r0 == null) goto L10;
        List<Pair<String, com.bytedance.ies.web.jsbridge2.f.b>> r1 = r0.provideJsMethods();
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        Pair r3 = (Pair) r2.next();
        r4.registerMethod((String) r3.getFirst(), (com.bytedance.ies.web.jsbridge2.f.b) r3.getSecond());
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
