package com.bytedance.android.live.browser.jsbridge.permissions;

import android.app.Fragment;
import android.os.Build;
import androidx.collection.SparseArrayCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import java.util.ArrayList;
import m60.c;
import n60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class JSBPermissionFragment extends Fragment {
    public final SparseArrayCompat<a> a;

    public static class a {
        public final String[] a;
        public String[] b;
        public final h30.a c;

        public a(String[] r1, h30.a r2) {
            this.a = r1;
            this.c = r2;
            this.b = new String[0];
        }
    }

    public JSBPermissionFragment() {
        this.a = new SparseArrayCompat();
    }

    public void requestPermissions(h30.a r4, String... r5) {
        a r0 = new a(r5, r4);
        if (getActivity() != null) goto L5;
        return;
    L5:
        String[] r1 = c.a(getActivity(), r5);
        if (r1.length != 0) goto L9;
        r4.onPermissionGrant(r5);
        return;
    L9:
        r0.b = r1;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        int r6 = m60.a.a(r5) & 65535;
        this.a.put(r6, r0);
        requestPermissions(r0.b, r6);
        return;
    L12:
        if (getActivity() != null) goto L15;
        return;
    L15:
        if (e.a.a.b(getActivity(), r5) == false) goto L17;
        r4.onPermissionGrant(r5);
        return;
    L17:
        r4.onPermissionDenied(r5);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r23, String[] r24, int[] r25) {
        ArrayList r12 = new ArrayList();
        Object[] r13 = {Integer.valueOf(r23), r24, r25};
        b r15 = new b();
        g06.a r1 = (g06.a) ApiHookConfig.b.get(102612);
        if (r1 == null) goto L5;
        f06.a[] r2 = r1.i;
    L6:
        f06.a[] r8 = r2;
        int r7 = r8.length;
        int r6 = 0;
    L8:
        if (r6 >= r7) goto L15;
        f06.a r5 = r8[r6];
        int r19 = r6;
        int r21 = r7;
        f06.a[] r22 = r8;
        d r3 = r5.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r13, "void", r15);     // Catch: Exception -> L34
        if (r3.a == true) goto L17;
        r12.add(r5);     // Catch: Exception -> L34
    L17:
        if (r3.a == true) goto L20;
        super.onRequestPermissionsResult(r23, r24, r25);
    L20:
        a r4 = (a) this.a.get(r23);
        this.a.remove(r23);
        if (r4 == null) goto L44;
    L25:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        if (c.f(getActivity(), r24, r25) == false) goto L28;
        r4.c.onPermissionGrant(r4.a);     // Catch: Exception -> L25
    L35:
        return;
    L28:
        if (c.e(getActivity(), r24) == false) goto L30;
        r4.c.a(r4.a);     // Catch: Exception -> L25
        goto L35
    L30:
        r4.c.onPermissionDenied(r4.a);     // Catch: Exception -> L25
        goto L35
    L44:
        return;
    L14:
        r6 = r19 + 1;
        r7 = r21;
        r8 = r22;
        goto L8
    L15:
        r3 = new d(false, null);
        goto L17
    L5:
        r2 = ApiHookConfig.d;
        goto L6
    }
}
