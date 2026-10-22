package com.bytedance.android.live.core.permission;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.hostdefault.DefaultPermissionRequestListener;
import com.bytedance.android.livesdk.a0;
import com.ss.android.ugc.route_monitor.impl.route_out.control.i;
import java.util.Arrays;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import m60.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends DefaultPermissionRequestListener {
    public final /* synthetic */ PermissionFragment.b a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ o60.a d;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.permission.a$a, reason: collision with other inner class name */
    public class C0145a implements o60.b {
        public boolean a;
        public final /* synthetic */ Continuation b;
        public final /* synthetic */ a c;

        @Override // o60.b
        public final void cancel() {
            if (this.a == true) goto L6;
            this.a = true;
            Continuation r0 = this.b;
            Boolean r1 = Boolean.FALSE;
            Intrinsics.checkNotNullParameter(r0, "$this$resumeInJava");
            r0.resumeWith(Result.constructor-impl(r1));
            return;
        }

        @Override // o60.b
        public final void execute() {
            if (this.a == true) goto L33;
            ALogger.i("PermissionFragment", "requestPermissions use ezpermission; beforeGoToAppSetting called");
            this.c.a.b();
            this.a = true;
            String[] r2 = this.c.c;
            int r3 = PermissionFragment.c;
            if (((Boolean) a0.a.getValue()).booleanValue() == false) goto L27;
            int r4 = 0;
            if (r2.length != 1) goto L10;
            String r1 = PermissionFragment.a(r2[0]);
        L24:
            if (r1 == null) goto L26;
            i.a(r1);
            goto L27
        L26:
            ALogger.e("PermissionFragment", "当前申请的权限信息无法找到对应的鉴权 id，出错");
            goto L27
        L10:
            if (r2.length != 2) goto L23;
            int r5 = r2.length;
            boolean r6 = false;
            boolean r7 = false;
        L12:
            if (r4 >= r5) goto L20;
            String r8 = r2[r4];
            if ("android.permission.CAMERA".equals(r8) == false) goto L17;
            r6 = true;
        L19:
            r4 = r4 + 1;
            goto L12
        L17:
            if ("android.permission.RECORD_AUDIO".equals(r8) == false) goto L19;
            r7 = true;
            goto L19
        L20:
            if (r6 == false) goto L23;
            if (r7 == false) goto L23;
            r1 = PermissionFragment.a("audio_camera");
        L23:
            r1 = null;
        L27:
            Continuation r0 = this.b;
            Boolean r9 = Boolean.TRUE;
            Intrinsics.checkNotNullParameter(r0, "$this$resumeInJava");
            r0.resumeWith(Result.constructor-impl(r9));
            return;
        }

        public C0145a(a r1, Continuation r2) {
            this.c = r1;
            this.b = r2;
        }
    }

    public final void beforeRequest() {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; beforeRequest called");
        this.a.a();
    }

    public final void noNeedToRequest() {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; noNeedToRequest called");
        this.a.d(false);
    }

    public final void onPermissionDenied(String[] r3) {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; onPermissionDenied called,grantedList=" + Arrays.toString(r3));
        this.a.c();
    }

    public final void onPermissionGrant(String[] r3) {
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; onPermissionGrant called,grantedList=" + Arrays.toString(r3));
        this.a.d(true);
    }

    public final void goToAppSetting(Continuation<Boolean> r3, String[] r4) {
        boolean r5 = !c.e(this.b, this.c);
        ALogger.i("PermissionFragment", "requestPermissions use ezpermission; goToAppSetting called, go=" + r5);
        if (r5 == false) goto L5;
        this.a.c = c.a(this.b, this.c);
        this.d.a(this.b, new C0145a(this, r3), this.a.b);
        return;
    L5:
        Boolean r6 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(r3, "$this$resumeInJava");
        r3.resumeWith(Result.constructor-impl(r6));
    }

    public a(PermissionFragment.b r1, Activity r2, String[] r3, o60.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
