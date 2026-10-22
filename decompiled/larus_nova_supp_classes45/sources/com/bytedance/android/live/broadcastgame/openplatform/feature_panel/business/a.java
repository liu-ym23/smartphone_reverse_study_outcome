package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import a20.m;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.NetworkIconEnterFrom;
import com.bytedance.android.live.broadcastgame.api.model.n;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a<VM extends AbsOpenFeaturePanelViewModel> implements a20.d {
    public long a;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business.a$a, reason: collision with other inner class name */
    public static final class C0091a {
    }

    static {
    }

    public a() {
    }

    public abstract void e(View r1, f10.f r2, int r3, m r4);

    public abstract f10.f f(InteractEntranceCell r1, boolean r2, @NetworkIconEnterFrom int r3);

    @Override // a20.d
    public void onDestroy() {
    }

    public static long d() {
        return System.currentTimeMillis() / ((long) 1000);
    }

    @Override // a20.e
    public final void a(View r8, f10.f r9, int r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "icon");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.a) <= 500) goto L5;
        boolean r2 = false;
    L6:
        this.a = r0;
        if (r2 == false) goto L9;
        return;
    L9:
        this.a = System.currentTimeMillis();
        e(r8, r9, r11, r12);
        return;
    L5:
        r2 = true;
        goto L6
    }

    @Override // a20.h
    public final f10.f c(InteractEntranceCell r1, boolean r2, @NetworkIconEnterFrom int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "data");
        n r5 = r1.f;
        r5.b = r3;
        r5.c = r2;
        r1.getClass();
        return f(r1, r2, r3);
    }
}
