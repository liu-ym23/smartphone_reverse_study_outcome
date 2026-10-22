package com.bytedance.android.live.core.verify.utils;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.utils.v1;
import com.bytedance.android.tools.superkv.e;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class QueryResultForAliPayApp implements LifecycleObserver {
    public final Activity a;
    public final String b;
    public final boolean c;
    public final w80.a d;
    public final Bundle e;
    public boolean f;
    public final e g;
    public final a.g h;
    public final boolean i;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        if (this.f == true) goto L5;
        return;
    L5:
        this.f = false;
        Activity r1 = this.a;
        w80.a r2 = this.d;
        String r3 = this.b;
        Bundle r4 = this.e;
        boolean r5 = this.c;
        a.g r8 = this.h;
        boolean r9 = this.i;
        a.b(r1, r2, r3, r4, r5, 0, new HashMap(), r8, r9);
    }

    public QueryResultForAliPayApp(Activity r1, w80.a r2, String r3, Bundle r4, boolean r5, a.g r6, boolean r7) {
        this.a = r1;
        this.b = r3;
        this.e = r4;
        this.c = r5;
        this.d = r2;
        this.h = r6;
        this.i = r7;
        if ((r1 instanceof LifecycleOwner) == false) goto L5;
        ((LifecycleOwner) r1).getLifecycle().addObserver(this);
    L5:
        this.g = v1.a("webcast_jsb_local_data");
    }
}
