package com.larus.bmhome.utils;

import android.os.Build;
import androidx.lifecycle.LiveData;
import com.larus.bmhome.auth.CreationConfig;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L13;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L13;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L13;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L13;
        if (r3.e() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean b() {
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L11;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L11;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L11;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L11;
        return r3.a();
    L11:
        return false;
    }

    public static boolean c() {
        if (com.larus.platform.service.z2.a.disableCreationOriImageLoad() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT <= 26) goto L7;
        return true;
    }

    public static boolean d() {
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L13;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L13;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L13;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L13;
        if (r3.g() != true) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean e() {
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L11;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L11;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L11;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L11;
        return r3.c();
    L11:
        return false;
    }

    public static boolean f() {
        if (com.larus.platform.service.z2.a.N() == true) goto L15;
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L13;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L13;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L13;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L13;
        boolean r4 = r3.h();
    L14:
        if (r4 == true) goto L15;
        return false;
    L13:
        r4 = false;
    L15:
        return true;
    }

    public static boolean g() {
        if (com.larus.platform.service.z2.a.M() == true) goto L15;
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L13;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L13;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L13;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L13;
        boolean r4 = r3.i();
    L14:
        if (r4 == true) goto L15;
        return false;
    L13:
        r4 = false;
    L15:
        return true;
    }

    public static boolean h() {
        if (com.larus.platform.service.z2.a.z() == true) goto L15;
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L13;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L13;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L13;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L13;
        boolean r4 = r3.b();
    L14:
        if (r4 == true) goto L15;
        return false;
    L13:
        r4 = false;
    L15:
        return true;
    }

    public static boolean i() {
        LiveData r0 = AuthModelDelegate.b.e();
        if (r0 == null) goto L11;
        e0 r1 = (e0) r0.getValue();
        if (r1 == null) goto L11;
        LaunchInfo r2 = r1.a;
        if (r2 == null) goto L11;
        CreationConfig r3 = r2.M();
        if (r3 == null) goto L11;
        int r4 = r3.d();
    L13:
        if (r4 == 2) goto L17;
        return false;
    L17:
        return true;
    L11:
        r4 = 1;
        goto L13
    }
}
