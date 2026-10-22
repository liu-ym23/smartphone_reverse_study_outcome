package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public c(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Map r6 = (Map) r5;
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r0 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, ((Widget) this.a).dataCenter);
        ch0.e r1 = null;
        if (r0 == null) goto L15;
        BehaviorSubject<List<ch0.e>> r2 = r0.f();
        if (r2 == null) goto L15;
        List r3 = (List) r2.getValue();
        if (r3 == null) goto L15;
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        T r7 = r4.next();
        if (((ch0.e) r7).a.isEnlarged() == false) goto L10;
        r1 = r7;
    L14:
        r1 = r1;
    L15:
        if (r1 == null) goto L20;
        ILinkPlayerInfoBridge r8 = r1.a;
        if (r8 == null) goto L20;
        String r9 = r8.getInteractId();
        if (r9 == null) goto L20;
    L21:
        boolean r10 = Intrinsics.areEqual((Boolean) r6.get(r9), Boolean.TRUE);
        HamletAvatarWidget.yq(this.a, r10);
        return;
    L20:
        r9 = "";
        goto L21
    }
}
