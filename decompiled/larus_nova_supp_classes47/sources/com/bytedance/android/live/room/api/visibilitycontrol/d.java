package com.bytedance.android.live.room.api.visibilitycontrol;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public int a;
    public int b;
    public int c;
    public int d;
    public final NextLiveData<Integer> e;
    public final LiveVisibilityControl.KEY f;
    public final com.bytedance.android.live.room.api.visibilitycontrol.a g;
    public final View h;
    public final LiveVisibilityControl.Type i;
    public final LiveVisibilityControl.Style j;
    public final float k;
    public final boolean l;
    public final boolean m;
    public final boolean n;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Integer r0 = (Integer) this.e.getValue();     // Catch: Exception -> L10
        if (r0 != null) goto L6;
    L8:
        int[] r1 = new int[2];     // Catch: Exception -> L10
        this.h.getLocationOnScreen(r1);     // Catch: Exception -> L10
        int r2 = r1[0];     // Catch: Exception -> L10
        int r3 = r1[1];     // Catch: Exception -> L10
        this.b = r3;     // Catch: Exception -> L10
        this.c = r2;     // Catch: Exception -> L10
        this.d = r2 + this.h.getWidth();     // Catch: Exception -> L10
        this.a = r3 + this.h.getHeight();     // Catch: Exception -> L10
        return;
    L6:
        if (r0.intValue() != 1) goto L8;
        return;
    L10:
        e = move-exception;
        ALogger.e("VSPlayerViewControlItem", "refreshViewPosition:error for" + this.f.name(), e);
    }

    public final LiveVisibilityControl.Type getType() {
        return this.i;
    }

    public d(LiveVisibilityControl.KEY r2, com.bytedance.android.live.room.api.visibilitycontrol.a r3, View r4, LiveVisibilityControl.Type r5, LiveVisibilityControl.Style r6, float r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "style");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        this.m = r9;
        this.n = r10;
        NextLiveData<Integer> r12 = new NextLiveData();
        r12.setValue(0);
        Unit r13 = Unit.INSTANCE;
        this.e = r12;
        a();
    }
}
