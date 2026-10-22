package com.bytedance.android.live.core.permission;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.collection.SparseArrayCompat;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import m60.i;
import o60.d;
import p60.c;
import p60.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PermissionFragment extends Fragment {
    public static final /* synthetic */ int c = 0;
    public final SparseArrayCompat<b> a;
    public final SparseArrayCompat<b> b;

    public class a implements o60.b {
        public final /* synthetic */ b a;
        public final /* synthetic */ PermissionFragment b;

        @Override // o60.b
        public final void cancel() {
            this.a.c();
        }

        @Override // o60.b
        public final void execute() {
            PermissionFragment r0 = this.b;
            b r1 = this.a;
            int r2 = PermissionFragment.c;
            r0.getClass();
            int r3 = (m60.a.a(r1.b) & (-65536)) >>> 16;
            Activity r4 = r0.getActivity();     // Catch: Exception -> L8
            Activity r5 = r0.getActivity();     // Catch: Exception -> L8
            Map<String, c> r6 = e.b;     // Catch: Exception -> L8
            e r7 = e.a.a;     // Catch: Exception -> L8
            if (PermissionFragment.e(r4, r7.a(r5)) == false) goto L6;
            r0.startActivityForResult(r7.a(r0.getActivity()), r3);     // Catch: Exception -> L8
            r0.b.put(r3, r1);     // Catch: Exception -> L8
        L11:
        L9:
            this.a.b();
            return;
        L6:
            r0.d(r1, r3);     // Catch: Exception -> L8
        L8:
            r0.d(r1, r3);
            goto L9
        }

        public a(PermissionFragment r1, b r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class b {
        public final Cert a;
        public final String[] b;
        public String[] c;
        public final o60.e d;
        public final d e;
        public final o60.a f;
        public final o60.a g;
        public final Runnable h;
        public final Runnable i;

        public final void a() {
            this.h.run();
            m60.d r0 = m60.d.a.a;
            String[] r1 = this.c;
            r0.getClass();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            Iterator<o60.c> r4 = r0.a(r1[r3]).iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            r4.next().a();
            goto L6
        L8:
            r3 = r3 + 1;
            goto L3
        }

        public final void b() {
            d r0 = this.e;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            m60.d r1 = m60.d.a.a;
            String[] r2 = this.c;
            r1.getClass();
            int r3 = r2.length;
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L12;
            Iterator<o60.c> r5 = r1.a(r2[r4]).iterator();
        L9:
            if (r5.hasNext() == false) goto L11;
            r5.next().d();
            goto L9
        L11:
            r4 = r4 + 1;
            goto L6
        }

        public final void c() {
            this.d.onPermissionDenied(this.b);
            m60.d r0 = m60.d.a.a;
            String[] r1 = this.c;
            r0.getClass();
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L9;
            Iterator<o60.c> r4 = r0.a(r1[r3]).iterator();
        L6:
            if (r4.hasNext() == false) goto L8;
            r4.next().onPermissionDenied();
            goto L6
        L8:
            r3 = r3 + 1;
            goto L3
        }

        public final void d(boolean r8) {
            this.d.onPermissionGrant(this.b);
            m60.d r0 = m60.d.a.a;
            String[] r1 = this.b;
            r0.getClass();
            int r2 = r1.length;
            int r3 = 0;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L9;
            Iterator<o60.c> r5 = r0.a(r1[r4]).iterator();
        L6:
            if (r5.hasNext() == false) goto L8;
            r5.next().c();
            goto L6
        L8:
            r4 = r4 + 1;
            goto L3
        L9:
            if (r8 == false) goto L17;
            this.i.run();
            m60.d r9 = m60.d.a.a;
            String[] r6 = this.c;
            r9.getClass();
            int r7 = r6.length;
        L11:
            if (r3 >= r7) goto L22;
            Iterator<o60.c> r11 = r9.a(r6[r3]).iterator();
        L14:
            if (r11.hasNext() == false) goto L16;
            r11.next().b();
            goto L14
        L16:
            r3 = r3 + 1;
            goto L11
        L22:
            return;
        }

        public b(String[] r1, Runnable r2, o60.e r3, d r4, i.c r5, Runnable r6, o60.a r7, Cert r8) {
            this.b = r1;
            this.h = r2;
            this.i = r6;
            this.d = r3;
            this.e = r4;
            this.f = r5;
            this.g = r7;
            this.c = new String[0];
            this.a = r8;
        }
    }

    public PermissionFragment() {
        this.a = new SparseArrayCompat();
        this.b = new SparseArrayCompat();
    }

    public static String a(String r3) {
        HashMap r0 = new HashMap();
        r0.put("android.permission.CAMERA", "91100930");
        r0.put("android.permission.RECORD_AUDIO", "1019459842");
        r0.put("audio_camera", "1026219778");
        return (String) r0.get(r3);
    }

    public static PermissionFragment b(Activity r3) {
        FragmentManager r4 = r3.getFragmentManager();
        PermissionFragment r1 = (PermissionFragment) r4.findFragmentByTag("PermissionFragment");
        if (r1 != null) goto L6;
        PermissionFragment r2 = new PermissionFragment();
        r4.beginTransaction().add(r2, "PermissionFragment").commitAllowingStateLoss();
        r4.executePendingTransactions();
        return r2;
    L6:
        return r1;
    }

    public static Intent c(Context r2) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r2.getPackageName()));
    }

    public final void g(b r4) {
        a r0 = new a(this, r4);
        Activity r1 = getActivity();
        r4.g.a(r1, r0, r4.b);
    }

    public void requestPermissions(b r4) {
        if (r4.c.length != 0) goto L6;
        r4.d(false);
        return;
    L6:
        r4.a();
        if (Build.VERSION.SDK_INT < 23) goto L13;
        Map<String, c> r0 = e.b;
        if (e.a.a.b() == true) goto L13;
        com.bytedance.android.live.core.permission.b r1 = new com.bytedance.android.live.core.permission.b(this, r4);
        Activity r2 = getActivity();
        r4.f.a(r2, r1, r4.b);
        return;
    L13:
        g(r4);
    }

    public static boolean e(Context r3, Intent r4) {
        ResolveInfo r5 = r3.getPackageManager().resolveActivity(r4, 65536);
        if (r5 == null) goto L16;
        ActivityInfo r1 = r5.activityInfo;
        if (r1 == null) goto L16;
        if (r1.name.toLowerCase().contains("resolver") == true) goto L16;
        String r6 = r5.activityInfo.permission;
        if (TextUtils.isEmpty(r6) == false) goto L12;
        return true;
    L12:
        if (r3.checkCallingOrSelfPermission(r6) == 0) goto L17;
        return false;
    L17:
        return true;
    L16:
        return false;
    }

    public final void d(b r4, int r5) {
    L8:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r5);     // Catch: Exception -> L10
        this.b.put(r5, r4);     // Catch: Exception -> L10
    L11:
        return;
    L4:
        if (e(getActivity(), c(getActivity())) == false) goto L7;
        startActivityForResult(c(getActivity()), r5);     // Catch: Exception -> L8
        this.b.put(r5, r4);     // Catch: Exception -> L8
        goto L15
    L7:
        getActivity();     // Catch: Exception -> L10
        startActivityForResult(new Intent("android.settings.APPLICATION_SETTINGS"), r5);     // Catch: Exception -> L10
        this.b.put(r5, r4);     // Catch: Exception -> L10
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
        b r4 = (b) this.b.get(r1);
        this.b.remove(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (m60.c.d(getActivity(), r4.b) == false) goto L9;
        r4.d(true);
        return;
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r24, String[] r25, int[] r26) {
        ArrayList r12 = new ArrayList();
        Object[] r13 = {Integer.valueOf(r24), r25, r26};
        f06.b r16 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(102612);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r4 = r7[r5];
        int r21 = r5;
        int r22 = r6;
        f06.a[] r23 = r7;
        f06.d r2 = r4.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r13, "void", r16);     // Catch: Exception -> L37
        if (r2.a == true) goto L17;
        r12.add(r4);     // Catch: Exception -> L37
    L17:
        if (r2.a == true) goto L20;
        super.onRequestPermissionsResult(r24, r25, r26);
    L20:
        b r3 = (b) this.a.get(r24);
        this.a.remove(r24);
        if (r3 != null) goto L23;
        return;
    L23:
        if (m60.c.f(getActivity(), r25, r26) == false) goto L26;
        r3.d(true);
        return;
    L26:
        if (m60.c.e(getActivity(), r25) == false) goto L28;
        r3.c();
        return;
    L28:
        Activity r8 = getActivity();
        Activity r9 = getActivity();
        Map<String, c> r11 = e.b;
        if (e(r8, e.a.a.a(r9)) == false) goto L31;
    L35:
        r3.c = m60.c.a(getActivity(), r3.b);
        g(r3);
        return;
    L31:
        if (e(getActivity(), c(getActivity())) == true) goto L35;
        Activity r14 = getActivity();
        getActivity();
        if (e(r14, new Intent("android.settings.APPLICATION_SETTINGS")) == true) goto L35;
        r3.c();
        return;
    L14:
        r5 = r21 + 1;
        r6 = r22;
        r7 = r23;
        goto L8
    L15:
        r2 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    public static void f(Activity r13, o60.e r14, d r15, Runnable r16, i.c r17, o60.a r18, Runnable r19, Cert r21, String... r22) {
        b r12 = new b(r22, r16, r14, r15, r17, r19, r18, r21);
        r12.c = m60.c.a(r13, r22);
        if (LiveInfraSettingKeys.LIVE_EZPERMISSION_REQUEST.getValue().booleanValue() == true) goto L5;
    L22:
        ALogger.i("PermissionFragment", "requestPermissions use old PermissionFragment");
        b(r13).requestPermissions(r12);
        return;
    L5:
        if (jc1.a.c() == true) goto L22;
        if (LiveInfraSettingKeys.LIVE_SHOW_NEVER_ASK_DIALOG.getValue().booleanValue() == false) goto L18;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Map<String, c> r1 = e.b;
        if (e.a.a.b() == false) goto L18;
    L12:
        ALogger.i("PermissionFragment", "requestPermissions use old PermissionFragment instead of ezpermission");
        PermissionFragment r0 = b(r13);
        if (r12.c.length != 0) goto L16;
        r12.d(false);
        return;
    L16:
        r12.a();
        r0.g(r12);
        return;
    L18:
        if (("requestPermissions use ezpermission, cert=" + r21) != null) goto L20;
        String r2 = "null";
    L21:
        ALogger.i("PermissionFragment", r2);
        k.f(IMiddlewareHostAction.class).requestPermissions(r13, new com.bytedance.android.live.core.permission.a(r12, r13, r22, r18), r21, r22);
        return;
    L20:
        r2 = r21.certToken();
        goto L21
    }
}
