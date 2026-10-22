package com.ss.android.lark.chat.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import v0c.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o extends v0c.a {
    public View e;
    public View f;

    public final void g() {
        this.f = this.e.findViewById(2131379052);
    }

    public final void k() {
        r r0 = i();
        if (r0 == null) goto L19;
        int r2 = r0.getState();
        if (r2 != (-2)) goto L7;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L19;
        r(r0.a());
        return;
    L7:
        if (r2 == (-1)) goto L16;
        if (r2 == 0) goto L16;
        r3 = true;
        if (r2 == 1) goto L16;
        if (r2 == 4) goto L16;
        if (r2 == 5) goto L16;
    L19:
        r(false);
    }

    public o(FragmentActivity r1) {
        super(r1);
    }

    public final View m(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(2131564128, null);
        this.e = r4;
        return r4;
    }

    public final void r(boolean r2) {
        if (r2 == false) goto L4;
        i();
        this.f.setVisibility(0);
        q(0);
        return;
    L4:
        q(8);
    }

    public final void a(int r1, Bundle r2) {
        switch(r1) {
            case -99052: goto L5;
            case -99050: goto L4;
            case -99015: goto L5;
            case -99014: goto L5;
            case -99013: goto L4;
            case -99011: goto L5;
            case -99010: goto L4;
            case -99007: goto L5;
            case -99001: goto L4;
            default: goto L8;
        };
    L4:
        r(true);
        return;
    L5:
        r(false);
        return;
    }

    public final void h(int r1, Bundle r2) {
        q(8);
    }
}
