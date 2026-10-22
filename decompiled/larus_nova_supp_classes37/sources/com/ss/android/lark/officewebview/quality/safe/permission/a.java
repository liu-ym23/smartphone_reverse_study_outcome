package com.ss.android.lark.officewebview.quality.safe.permission;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public int a;
    public b.a b;

    public a() {
        this.a = -1;
    }

    public void startActivityForResult(Fragment r1, Intent r2, int r3, b.a r4) {
        this.b = r4;
        this.a = r3;
        r1.startActivityForResult(r2, r3);
    }
}
