package mh0;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h extends lh0.a {
    public final LinkedHashMap<String, com.bytedance.android.live.liveinteract.plantform.dynamicframe.o> e;
    public final ViewGroup f;
    public final ih0.b g;

    @Override // lh0.a
    public final void d() {
        super.d();
        Iterator<com.bytedance.android.live.liveinteract.plantform.dynamicframe.o> r0 = this.e.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().a("root_widget_destory");
        goto L4
    L6:
        this.e.clear();
    }

    public h(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r4, ViewGroup r5, ih0.b r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r4, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r6, "service");
        super(r2, r3, r4);
        this.f = r5;
        this.g = r6;
        this.e = new LinkedHashMap();
    }
}
