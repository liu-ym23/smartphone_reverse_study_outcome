package com.bytedance.android.live.anchormodelink.gift;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public ArrayList<ILinkPlayerInfoBridge> a;
    public final Set<iy.i> b;
    public int c;
    public kh0.a d;
    public final a e;
    public final DataCenter f;
    public final oy.a g;

    public d(DataCenter r2, AnchorModeLinkDynamicWidget.e r3) {
        Intrinsics.checkNotNullParameter(r3, "interactCallback");
        this.f = r2;
        this.g = r3;
        this.b = new LinkedHashSet();
        this.e = new a(r2, this);
    }
}
