package com.bytedance.android.livesdk.interactivity.chatchannel.v2.widget;

import com.bytedance.android.livesdk.interactivity.service.messagelist.MessageListScrollManager;
import com.bytedance.android.livesdk.interactivity.service.messagelist.m;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements Action {
    public final /* synthetic */ ChatChannelWidgetV2 a;

    public b(ChatChannelWidgetV2 r1) {
        this.a = r1;
    }

    public final void run() {
        m r0 = this.a.b;
        if (r0 == null) goto L9;
        MessageListScrollManager r1 = r0.b;
        Disposable r2 = r1.h;
        if (r2 == null) goto L7;
        r2.dispose();
    L7:
        r1.h = null;
        r1.m.setOnClickListener(null);
        r1.k = true;
        r1.c = false;
        r1.l.setOnFlingListener(null);
        r1.l.setOnTouchListener(null);
        r1.l.removeOnScrollListener(r1.e);
        r0.d.dispose();
        MultiTypeAdapter r3 = r0.a;
        r3.a = new ArrayList();
        r0.f.removeItemDecoration(r0.c);
        return;
    }
}
