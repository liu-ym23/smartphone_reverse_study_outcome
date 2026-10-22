package com.larus.platform.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.PermissionHelperDelegate;
import com.larus.platform.api.g1$b;
import com.larus.platform.api.g1$c;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i2 implements com.larus.platform.api.g1 {
    public static final i2 b = null;
    public static final Lazy c = null;

    public i2() {
    }

    static {
        b = new i2();
        c = LazyKt.lazy(new h2());
    }

    public static com.larus.platform.api.g1 p() {
        return (com.larus.platform.api.g1) c.getValue();
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        com.larus.platform.api.g1 r0 = p();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d(r2) != true) goto L7;
        return true;
    }

    public final void f(boolean r2) {
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L6;
        r0.f(r2);
        return;
    }

    public final void i(FragmentActivity r2, g1$c r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L6;
        r0.i(r2, r3);
        return;
    }

    public static void q(Fragment r2, List r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        if (r2 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permission(r3, r4);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r2.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L13;
        r0.b(r2, r3, r4, null);
        return;
    }

    public final void a(FragmentActivity r2, List<String> r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        if (r2 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permission(r3, r4);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r2) == true) goto L11;
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L13;
        r0.a(r2, r3, r4);
        return;
    }

    public final void m(FragmentActivity r2, List<String> r3, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        if (r2 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permissionForDetail(r3, r4);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r2) == true) goto L11;
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L13;
        r0.m(r2, r3, r4);
        return;
    }

    public final void b(Fragment r3, List<String> r4, Function1<? super Boolean, Unit> r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "manifest");
        Intrinsics.checkNotNullParameter(r5, "requestCallBack");
        if (r3 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permission(r4, r5, r6);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r3.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L13;
        r0.b(r3, r4, r5, r6);
        return;
    }

    public final void l(FragmentActivity r2, String r3, String r4, g1$b r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "permission");
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L6;
        r0.l(r2, r3, r4, r5);
        return;
    }

    public final void j(Fragment r7, FragmentActivity r8, List<String> r9, JSONObject r10, g1$c r11) {
        Intrinsics.checkNotNullParameter(r9, "manifest");
        Intrinsics.checkNotNullParameter(r11, "requestCallBack");
        if (r7 != null) goto L6;
        if (r8 != null) goto L6;
    L7:
        PermissionHelperDelegate.b.permissionAny(r9, r11);
        return;
    L6:
        if (PermissionHelperDelegate.b.isConditionMet(r8) == true) goto L7;
        com.larus.platform.api.g1 r0 = p();
        if (r0 == null) goto L13;
        r0.j(r7, r8, r9, r10, r11);
        return;
    }

    public final void k(Fragment r9, List<String> r10, g1$c r11, Map<String, String> r12, JSONObject r13) {
        Intrinsics.checkNotNullParameter(r10, "manifest");
        Intrinsics.checkNotNullParameter(r11, "requestCallBack");
        if (r9 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permission(r10, r11, r12, r13, true);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r9.getActivity()) == true) goto L11;
        com.larus.platform.api.g1 r1 = p();
        if (r1 == null) goto L13;
        r1.k(r9, r10, r11, r12, r13);
        return;
    }

    public final void g(FragmentActivity r9, List<String> r10, g1$c r11, Map<String, String> r12, JSONObject r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "manifest");
        Intrinsics.checkNotNullParameter(r11, "requestCallBack");
        if (r9 != null) goto L5;
    L11:
        PermissionHelperDelegate.b.permission(r10, r11, r12, r13, r14);
        return;
    L5:
        if (PermissionHelperDelegate.b.isConditionMet(r9) == true) goto L11;
        com.larus.platform.api.g1 r1 = p();
        if (r1 == null) goto L13;
        r1.g(r9, r10, r11, r12, r13, r14);
        return;
    }
}
