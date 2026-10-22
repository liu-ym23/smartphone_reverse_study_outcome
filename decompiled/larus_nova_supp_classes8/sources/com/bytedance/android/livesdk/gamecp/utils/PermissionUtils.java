package com.bytedance.android.livesdk.gamecp.utils;

import android.app.Activity;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.ies.ezpermission.EzPermission;
import com.bytedance.ies.ezpermission.core.PermissionResultListener;
import com.bytedance.ies.ezpermission.core.h;
import com.bytedance.ies.ezpermission.core.j;
import com.bytedance.ies.ezpermission.core.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PermissionUtils {
    public static final /* synthetic */ int a = 0;

    public static final class a implements k {
        public final /* synthetic */ yv.a.b a;

        public a(yv.a.b r1) {
            this.a = r1;
        }

        public final void a(List<String> r4) {
            Intrinsics.checkNotNullParameter(r4, "requestList");
            com.bytedance.android.gamecp.common.permission.b r5 = this.a;
            if (r5 == null) goto L6;
            yr.b.b(4, "PermissionFragment", "requestPermissions use ezpermission; beforeRequest called");
            r5.a.a();
            return;
        }
    }

    public static final class b implements h {
        public final /* synthetic */ yv.a.b a;

        public b(yv.a.b r1) {
            this.a = r1;
        }

        public final void a(List r2, SafeContinuation r3) {
            Intrinsics.checkNotNullParameter(r2, "deniedList");
            Intrinsics.checkNotNullParameter(r3, "continuation");
            if (this.a == null) goto L9;
            Object[] r4 = r2.toArray(new String[0]);
            if (r4 == null) goto L8;
            String[] r5 = (String[]) r4;
            r3.resumeWith(Result.constructor-impl(Boolean.FALSE));
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L9:
            r3.resumeWith(Result.constructor-impl(Boolean.TRUE));
        }
    }

    public static final class c implements j {
        public final /* synthetic */ yv.a.b a;

        public c(yv.a.b r1) {
            this.a = r1;
        }

        public final void a(List r5, SafeContinuation r6) {
            Intrinsics.checkNotNullParameter(r5, "deniedList");
            Intrinsics.checkNotNullParameter(r6, "continuation");
            com.bytedance.android.gamecp.common.permission.b r0 = this.a;
            if (r0 == null) goto L15;
            Object[] r7 = r5.toArray(new String[0]);
            if (r7 == null) goto L14;
            String[] r8 = (String[]) r7;
            com.bytedance.android.gamecp.common.permission.b r1 = r0;
            boolean r9 = !ru.c.d(r1.b, r1.c);
            yr.b.b(4, "PermissionFragment", "requestPermissions use ezpermission; goToAppSetting called, go=" + r9);
            if (r9 == false) goto L12;
            r1.a.c = ru.c.b(r1.b, r1.c);
            com.bytedance.android.gamecp.common.permission.a r10 = new com.bytedance.android.gamecp.common.permission.a(r1, r6);
            uu.a r11 = r1.d;
            if (r11 != null) goto L11;
            r10.cancel();
            return;
        L11:
            r11.a(r1.b, r10, r1.a.b);
            return;
        L12:
            Boolean r12 = Boolean.FALSE;
            Intrinsics.checkNotNullParameter(r6, "$this$resumeInJava");
            r6.resumeWith(Result.constructor-impl(r12));
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static final class d implements PermissionResultListener {
        public final /* synthetic */ Function3 a;

        public d(Function3 r1) {
            this.a = r1;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            this.a.invoke(Boolean.valueOf(r2), r3, r4);
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(Activity r1, final yv.a.b r2, Cert r3, final String... r4) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r3, "cert");
        Intrinsics.checkNotNullParameter(r4, "permissions");
        if (EzPermission.isAllGranted(r1, (String[]) Arrays.copyOf(r4, r4.length)) == false) goto L5;
        Function3<Boolean, List<? extends String>, List<? extends String>, Unit> r0 = new PermissionUtils$request$resultListener$1(r2, r4);
    L6:
        EzPermission.with(r1, r3).permissions((String[]) Arrays.copyOf(r4, r4.length)).onEachRequest(new a(r2)).onExplainAfter(new b(r2)).onPermanentDenied(new c(r2)).request(new d(r0));
        return;
    L5:
        r0 = new PermissionUtils$request$resultListener$2(r2, r4);
        goto L6
    }
}
