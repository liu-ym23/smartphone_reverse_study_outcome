package com.bytedance.android.livesdk.interactivity.comment;

import com.bytedance.android.livesdk.interactivity.api.comment.CommentComponentType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements t22.a {
    public final CommentComponentType a;
    public final List<com.bytedance.android.livesdk.interactivity.c> b;
    public final com.bytedance.android.livesdk.interactivity.e c;
    public final DataCenter d;

    public final x22.a a() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((com.bytedance.android.livesdk.interactivity.c) r1).a() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        com.bytedance.android.livesdk.interactivity.c r2 = (com.bytedance.android.livesdk.interactivity.c) r1;
        if (r2 != null) goto L15;
        return null;
    L15:
        return r2.a();
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    @Override // t22.a
    public final void onLoad() {
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.i.b(this.d, 1);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.j<t22.g> r1 = r0.getTopicTipManager();
        if (r1 == null) goto L9;
        t22.g r2 = (t22.g) r1.getValue();
        if (r2 == null) goto L9;
        ((ArrayList) this.b).add(r2);
    L9:
        Iterator r3 = ((ArrayList) this.b).iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((com.bytedance.android.livesdk.interactivity.c) r3.next()).b(this.c);
        goto L11
    }

    @Override // t22.a
    public final void onUnload() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.c) r0.next()).b(null);
        goto L4
    L6:
        ((ArrayList) this.b).clear();
    }

    @Override // t22.a
    public CommentComponentType getType() {
        return this.a;
    }

    public t(i0 r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "updateCb");
        this.c = r2;
        this.d = r3;
        this.a = CommentComponentType.Tip;
        this.b = new ArrayList();
    }
}
