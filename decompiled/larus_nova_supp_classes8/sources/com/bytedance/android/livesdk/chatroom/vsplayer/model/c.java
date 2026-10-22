package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public final NextLiveData<Integer> f;
    public final PlayerViewControl.KEY g;
    public final com.bytedance.android.livesdk.chatroom.vsplayer.model.a h;
    public final View i;
    public final PlayerViewControl.Type j;
    public final PlayerViewControl.Style k;
    public final float l;
    public final boolean m;
    public final boolean n;
    public final boolean o;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Integer r0 = (Integer) this.f.getValue();     // Catch: Exception -> L10
        if (r0 != null) goto L6;
    L8:
        int[] r1 = new int[2];     // Catch: Exception -> L10
        this.i.getLocationOnScreen(r1);     // Catch: Exception -> L10
        int r2 = r1[0];     // Catch: Exception -> L10
        int r3 = r1[1];     // Catch: Exception -> L10
        this.b = r3;     // Catch: Exception -> L10
        this.c = r2;     // Catch: Exception -> L10
        this.d = r2 + this.i.getWidth();     // Catch: Exception -> L10
        this.a = r3 + this.i.getHeight();     // Catch: Exception -> L10
        return;
    L6:
        if (r0.intValue() != 1) goto L8;
        return;
    L10:
        e = move-exception;
        ALogger.e("VSPlayerViewControlItem", "refreshViewPosition:error for" + this.g.name(), e);
    }

    public final PlayerViewControl.Type getType() {
        return this.j;
    }

    public c(PlayerViewControl.KEY r2, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r3, View r4, PlayerViewControl.Type r5, PlayerViewControl.Style r6, float r7, boolean r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "style");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
        this.o = r10;
        NextLiveData<Integer> r11 = new NextLiveData();
        r11.setValue(0);
        Unit r12 = Unit.INSTANCE;
        this.f = r11;
        a();
    }
}
