package com.ss.android.lark.permission.rxPermission;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.log.Log;
import f06.b;
import f06.d;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import n0c.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class RxPermissionsFragment extends Fragment {
    public static final AtomicInteger b = null;
    public static final Map<Integer, String[]> c = null;
    public final Map<String, PublishSubject<a>> a;

    static {
        b = new AtomicInteger(100000);
        c = new ConcurrentHashMap();
    }

    public final void b() {
        Map<String, PublishSubject<a>> r0 = this.a;
        monitor-enter(r0);
        Iterator r1 = ((ConcurrentHashMap) this.a).entrySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L14
        r1.remove();     // Catch: Throwable -> L14
        PublishSubject r3 = (PublishSubject) r2.getValue();     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r3.onNext(new a((String) r2.getKey(), false, c(this, (String) r2.getKey())));     // Catch: Throwable -> L14
    L11:
        r3.onComplete();     // Catch: Throwable -> L14
        goto L6
    L10:
        r3.onNext(new a((String) r2.getKey(), false, false));     // Catch: Throwable -> L14
        goto L11
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public RxPermissionsFragment() {
        this.a = new ConcurrentHashMap();
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        b();
        super.onDestroy();
    }

    public static int a(String[] r3) {
        int r0 = b.getAndIncrement();
        Map<Integer, String[]> r1 = c;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        r2.put(Integer.valueOf(r0), r3);
        return r0;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setRetainInstance(true);
    }

    public void requestPermissions(String[] r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        requestPermissions(r3, a(r3));
        return;
    L5:
        ActivityCompat.requestPermissions(getActivity(), r3, a(r3));
    }

    public static boolean c(RxPermissionsFragment r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_ss_android_lark_permission_rxPermission_RxPermissionsFragment_com_ss_android_lark_permission_rxPermission_RxPermissionsFragment_shouldShowRequestPermissionRationale");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102610);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102610, "com/ss/android/lark/permission/rxPermission/RxPermissionsFragment", "shouldShowRequestPermissionRationale", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r18.shouldShowRequestPermissionRationale(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int r22, String[] r23, int[] r24) {
        ArrayList r10 = new ArrayList();
        Object[] r11 = {Integer.valueOf(r22), r23, r24};
        b r14 = new b();
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
        int r18 = r5;
        int r19 = r6;
        f06.a[] r20 = r7;
        d r2 = r4.preInvoke(102612, "android/app/Fragment", "onRequestPermissionsResult", this, r11, "void", r14);     // Catch: Exception -> L63
        if (r2.a == true) goto L17;
        r10.add(r4);     // Catch: Exception -> L63
    L17:
        if (r2.a == true) goto L21;
        super.onRequestPermissionsResult(r22, r23, r24);
    L21:
        if (r22 >= 100000) goto L23;
        return;
    L23:
        String[] r3 = (String[]) ((ConcurrentHashMap) c).remove(Integer.valueOf(r22));
        Bundle r8 = getArguments();
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L47;
        if (r23 != null) goto L32;
    L41:
        boolean r12 = true;
    L42:
        if (r12 == false) goto L47;
        if (r3 == null) goto L45;
        int[] r13 = new int[r3.length];
        Arrays.fill(r13, -1);
    L48:
        boolean[] r15 = new boolean[r3.length];
        int r16 = 0;
    L50:
        if (r16 >= r3.length) goto L52;
        r15[r16] = c(this, r3[r16]);
        r16 = r16 + 1;
        goto L50
    L52:
        int r17 = r3.length;
        int r21 = 0;
    L53:
        if (r21 >= r17) goto L76;
        PublishSubject r25 = (PublishSubject) ((ConcurrentHashMap) this.a).get(r3[r21]);
        if (r25 == null) goto L56;
        ((ConcurrentHashMap) this.a).remove(r3[r21]);
        if (r13[r21] != 0) goto L60;
        boolean r26 = true;
    L61:
        r25.onNext(new a(r3[r21], r26, r15[r21]));
        r25.onComplete();
        r21 = r21 + 1;
        goto L53
    L60:
        r26 = false;
        goto L61
    L56:
        Log.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
        return;
    L76:
        return;
    L45:
        b();
        return;
    L32:
        if (r23.length == 0) goto L41;
        int r27 = r23.length;
        int r28 = 0;
    L35:
        if (r28 >= r27) goto L40;
        if (TextUtils.isEmpty(r23[r28]) == true) goto L41;
        r28 = r28 + 1;
        goto L35
    L40:
        r12 = false;
    L47:
        r13 = r24;
        r3 = r23;
        goto L48
    L26:
        if (r8.getBoolean("key_enable_patch", false) == false) goto L28;
        r9 = true;
    L14:
        r5 = r18 + 1;
        r6 = r19;
        r7 = r20;
        goto L8
    L15:
        r2 = new d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }
}
