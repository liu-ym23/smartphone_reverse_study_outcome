package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ InteractAnimationController a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ Ref.ObjectRef c;

    public k(InteractAnimationController r1, Ref.ObjectRef r2, Ref.ObjectRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final String generate() {
        StringBuilder r0 = new StringBuilder("onlineListChanged new : ");
        r0.append(l.a((ArrayList) this.b.element).toString());
        r0.append("  old : ");
        ArrayList<ILinkPlayerInfoBridge> r1 = this.a.c;
        if (r1 == null) goto L5;
        ArrayList<String> r2 = l.a(r1);
    L6:
        r0.append(String.valueOf(r2));
        r0.append("  offline : ");
        r0.append(l.a((ArrayList) this.c.element).toString());
        return r0.toString();
    L5:
        r2 = null;
        goto L6
    }
}
