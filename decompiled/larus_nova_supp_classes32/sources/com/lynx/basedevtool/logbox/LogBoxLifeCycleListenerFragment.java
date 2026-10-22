package com.lynx.basedevtool.logbox;

import a5a.b;
import a5a.l;
import a5a.m;
import a5a.n;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LogBoxLifeCycleListenerFragment extends Fragment {
    @Override // android.app.Fragment
    public final void onDestroy() {
        Activity r0 = getActivity();
        n r1 = n.a.a;
        if (r0 != null) goto L5;
        r1.getClass();
        l r2 = null;
    L6:
        if (r2 == null) goto L16;
        b r3 = r2.d;
        if (r3 == null) goto L10;
        l.a(r3);
        r2.d = null;
    L10:
        m r4 = r2.c;
        if (r4 == null) goto L16;
        Dialog r5 = r4.e;
        if (r5 == null) goto L15;
        m.a(r5);
        r4.e = null;
    L15:
        r2.c = null;
    L16:
        super.onDestroy();
        return;
    L5:
        r2 = r1.a.get(r0);
        goto L6
    }

    public LogBoxLifeCycleListenerFragment() {
    }
}
