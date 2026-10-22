package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements a20.f {
    public final List<String> a;

    @Override // a20.f
    public final void clear() {
        ((ArrayList) this.a).clear();
    }

    public d() {
        this.a = new ArrayList();
    }

    @Override // a20.f
    public final List<String> a() {
        return this.a;
    }

    @Override // a20.f
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (((ArrayList) this.a).contains(r2) == false) goto L11;
        ((ArrayList) this.a).remove(r2);
    L11:
        ((ArrayList) this.a).add(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // a20.f
    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (((ArrayList) this.a).contains(r3) == false) goto L11;
        ((ArrayList) this.a).remove(r3);
    L11:
        ListProtector.add(this.a, 0, r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // a20.f
    public final void d(List<InteractEntranceCell> r3) {
        Intrinsics.checkNotNullParameter(r3, "iconList");
        if (((ArrayList) this.a).isEmpty() == false) goto L9;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L20;
        InteractEntranceCell r0 = (InteractEntranceCell) r4.next();
        List<String> r1 = this.a;
        ArrayList r2 = (ArrayList) r1;
        r2.add(r0.h());
        goto L6
    L20:
        return;
    L9:
        if (((k81) ft0.a.getValue()).e() == false) goto L14;
        ((ArrayList) this.a).clear();
        Iterator<T> r5 = r3.iterator();
    L12:
        if (r5.hasNext() == false) goto L28;
        InteractEntranceCell r6 = (InteractEntranceCell) r5.next();
        List<String> r7 = this.a;
        ArrayList r8 = (ArrayList) r7;
        r8.add(r6.h());
        goto L12
    L28:
        return;
    L14:
        Iterator<T> r9 = r3.iterator();
    L16:
        if (r9.hasNext() == false) goto L29;
        String r11 = ((InteractEntranceCell) r9.next()).h();
        if (((ArrayList) this.a).contains(r11) == true) goto L16;
        ((ArrayList) this.a).add(r11);
        goto L16
    }
}
