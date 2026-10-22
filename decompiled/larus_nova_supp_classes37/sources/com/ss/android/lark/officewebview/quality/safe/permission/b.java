package com.ss.android.lark.officewebview.quality.safe.permission;

import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface b {

    public interface a {
        void a(int r1, int r2, Intent r3);
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officewebview.quality.safe.permission.b$b, reason: collision with other inner class name */
    public interface InterfaceC0078b {
        void a(String[] r1, int[] r2);
    }

    void requestPermissions(String[] r1, InterfaceC0078b r2);

    void startActivityForResult(Intent r1, int r2, a r3);
}
