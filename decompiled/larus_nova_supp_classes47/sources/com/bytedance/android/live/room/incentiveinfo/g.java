package com.bytedance.android.live.room.incentiveinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final IncentiveInfoLayout a;
    public d b;
    public final x81.b<u81.d> c;
    public final List<w81.a> d;
    public final List<u81.h<w81.b>> e;
    public final Context f;
    public final DataCenter g;
    public final ViewGroup h;
    public final IRoom i;
    public final View j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((u81.h) r0.next()).reset();
        goto L4
    L6:
        ((ArrayList) this.e).clear();
    }

    public final void b() {
        Iterator<T> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        w81.a r1 = (w81.a) r0.next();
        boolean r3 = true;
        if (((ArrayList) this.d).size() <= 1) goto L9;
        r3 = false;
    L9:
        r1.b = Boolean.valueOf(r3);
        goto L4
    }

    public g(Context r1, DataCenter r2, DataContext r3, ViewGroup r4, IRoom r5, View r6) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r6, "parentView");
        this.f = r1;
        this.g = r2;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.a = (IncentiveInfoLayout) r4.findViewById(2131375203);
        this.c = new x81.b();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }
}
