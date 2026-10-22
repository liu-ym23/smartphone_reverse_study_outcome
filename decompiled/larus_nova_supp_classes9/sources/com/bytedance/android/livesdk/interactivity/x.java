package com.bytedance.android.livesdk.interactivity;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.interactivity.interactive.EpisodeInteractiveContext;
import com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveWidget;
import com.bytedance.android.livesdk.interactivity.interactive.episode.EpisodeInteractiveWidget;
import com.bytedance.android.livesdk.x4;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class x implements nm1.q, com.bytedance.android.scope.o {
    public x() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final EpisodeInteractiveContext a() {
        EpisodeInteractiveContext r0 = new EpisodeInteractiveContext();
        r0.init();
        return r0;
    }

    public final Class<? extends Widget> d() {
        Intrinsics.areEqual(x4.a.getValue(), Boolean.TRUE);
        return EpisodeInteractiveWidget.class;
    }

    public final Class<? extends Widget> f() {
        Intrinsics.areEqual(x4.a.getValue(), Boolean.TRUE);
        return LiveInteractiveWidget.class;
    }

    public final void c(boolean r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        ViewModel r0 = null;
        vr1.u r5 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r4, null, 2);
        if (r5 == null) goto L5;
        ViewModel r6 = r5.c();
    L7:
        if ((r6 instanceof EpisodeInteractiveContext) == false) goto L10;
        r0 = r6;
    L10:
        EpisodeInteractiveContext r1 = (EpisodeInteractiveContext) r0;
        if (r1 == null) goto L14;
        r1.setUpForTemplate(r3);
        return;
    L14:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
