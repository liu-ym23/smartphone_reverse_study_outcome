package com.bytedance.android.live.browser.jsbridge.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Locale;
import java.util.Map;
import m60.c;
import p60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class JSBOpenSettingFragment extends Fragment {
    public final SparseArrayCompat<a> a;

    public static class a {
        public final String[] a;
        public final h30.a b;

        public a(String[] r1, h30.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public JSBOpenSettingFragment() {
        this.a = new SparseArrayCompat();
    }

    public static Intent a(Context r2) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r2.getPackageName()));
    }

    public static boolean c(Context r3, Intent r4) {
        ResolveInfo r5 = r3.getPackageManager().resolveActivity(r4, 65536);
        if (r5 == null) goto L18;
        ActivityInfo r1 = r5.activityInfo;
        if (r1 == null) goto L18;
        String r2 = r1.name;
        if (r2 != null) goto L9;
    L11:
        String r6 = r5.activityInfo.permission;
        if (TextUtils.isEmpty(r6) == false) goto L14;
        return true;
    L14:
        if (r3.checkCallingOrSelfPermission(r6) == 0) goto L19;
        return false;
    L19:
        return true;
    L9:
        if (r2.toLowerCase(Locale.getDefault()).contains("resolver") == false) goto L11;
    L18:
        return false;
    }

    public final void b(a r4, int r5) {
    L8:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r5);     // Catch: Exception -> L10
        this.a.put(r5, r4);     // Catch: Exception -> L10
    L11:
        return;
    L4:
        if (c(getActivity(), a(getActivity())) == false) goto L7;
        startActivityForResult(a(getActivity()), r5);     // Catch: Exception -> L8
        this.a.put(r5, r4);     // Catch: Exception -> L8
        goto L15
    L7:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r5);     // Catch: Exception -> L10
        this.a.put(r5, r4);     // Catch: Exception -> L10
    }

    public final void d(h30.a r6, String... r7) {
        a r0 = new a(r7, r6);
        if (c.a(getActivity(), r7).length != 0) goto L7;
        r6.onPermissionGrant(r7);
        return;
    L7:
        if (getActivity() != null) goto L9;
        return;
    L9:
        Activity r1 = getActivity();
        Activity r2 = getActivity();
        Map<String, p60.c> r3 = e.b;
        e r4 = e.a.a;
        if (c(r1, r4.a(r2)) == false) goto L12;
    L17:
        int r8 = (m60.a.a(r7) & (-65536)) >>> 16;
    L23:
        b(r0, r8);
        return;
    L19:
        if (c(getActivity(), r4.a(getActivity())) == false) goto L21;
        startActivityForResult(r4.a(getActivity()), r8);     // Catch: Exception -> L23
        this.a.put(r8, r0);     // Catch: Exception -> L23
    L25:
        return;
    L21:
        b(r0, r8);     // Catch: Exception -> L23
        goto L25
    L12:
        if (c(getActivity(), a(getActivity())) == true) goto L17;
        Activity r5 = getActivity();
        getActivity();
        if (c(r5, new Intent("android.settings.APPLICATION_SETTINGS")) == true) goto L17;
        r6.onPermissionDenied(r7);
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        a r5 = (a) this.a.get(r2);
        this.a.remove(r2);
        if (r5 != null) goto L5;
        return;
    L5:
        if (getActivity() == null) goto L25;
        String[] r6 = r5.a;
        if (r6 == null) goto L17;
        if (r6.length != 1) goto L17;
        if ("notification".equals(r6[0]) == false) goto L17;
        int r7 = c30.c.a;
        if (c30.c.b(getActivity()) == false) goto L15;
        r5.b.onPermissionGrant(r5.a);
        return;
    L15:
        r5.b.a(r5.a);
        return;
    L17:
        if (c.d(getActivity(), r5.a) == false) goto L20;
        r5.b.onPermissionGrant(r5.a);
        return;
    L20:
        if (c.e(getActivity(), r5.a) == false) goto L22;
        r5.b.a(r5.a);
        return;
    L22:
        r5.b.onPermissionDenied(r5.a);
        return;
    }
}
