package com.bytedance.android.annie.bridge.method.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.RequestPermissionResultModel;
import com.bytedance.android.annie.container.fragment.q;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e7.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "requestPermission")
public final class RequestPermissionMethod extends w<RequestPermissionParamModel, RequestPermissionResultModel> {
    public final q a;
    public Lifecycle.Event b;
    public Context c;
    public final Lazy d;

    public static final class a implements com.bytedance.android.annie.bridge.method.permission.b {
        public final /* synthetic */ RequestPermissionMethod a;

        public a(RequestPermissionMethod r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.b
        public final void onRequestPermissionsResult(int r10, String[] r11, int[] r12) {
            Intrinsics.checkNotNullParameter(r11, "permissions");
            Intrinsics.checkNotNullParameter(r12, "grantResults");
            if (r10 != 200) goto L10;
            RequestPermissionMethod r13 = this.a;
            RequestPermissionResultModel r14 = new RequestPermissionResultModel();
            r14.a(RequestPermissionResultModel.Code.Success);
            if (com.bytedance.android.annie.bridge.method.permission.c.h(r12) == false) goto L7;
            String r15 = RequestPermissionResultModel.Status.Permitted.toString();
        L8:
            r14.c(r15);
            r14.b("Request Permission Success !");
            r13.finishWithResult(r14);
            return;
        L7:
            r15 = RequestPermissionResultModel.Status.Denied.toString();
            goto L8
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Permission.values().length];
            r0[Permission.PHOTOALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[Permission.WRITE_PHOTOALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[Permission.READ_PHOTOALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public RequestPermissionMethod(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.d = LazyKt.lazy(new RequestPermissionMethod$lifeCycleMonitorListener$2(this));
        q r11 = (q) r10.c(q.class);
        if (r11 == null) goto L9;
        this.a = r11;
        return;
    }

    public RequestPermissionMethod(q r10) {
        q r0 = this.a;
        if (r0 == null) goto L5;
        r0.registerOnRequestPermissionsCallBack(new a(this));
    L5:
        this.d = LazyKt.lazy(new RequestPermissionMethod$lifeCycleMonitorListener$2(this));
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        RequestPermissionParamModel r12 = (RequestPermissionParamModel) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        this.c = r11.getContext();
        RequestPermissionParamModel.Permission r13 = r12.a();
        if (r13 != null) goto L5;
        RequestPermissionResultModel r14 = new RequestPermissionResultModel();
        r14.a(RequestPermissionResultModel.Code.InvalidParam);
        r14.b("Illegal permission");
        finishWithResult(r14);
        return;
    L5:
        Permission.a r15 = Permission.Companion;
        String r16 = r13.toString();
        r15.getClass();
        Permission r17 = Permission.a.a(r16);
        if (r17 != Permission.UNKNOWN) goto L8;
        RequestPermissionResultModel r18 = new RequestPermissionResultModel();
        r18.a(RequestPermissionResultModel.Code.InvalidParam);
        r18.b("Illegal permission");
        finishWithResult(r18);
        return;
    L8:
        FragmentActivity r19 = null;
        if (r17 != Permission.NOTIFICATION) goto L21;
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r20 = com.bytedance.android.annie.bridge.method.permission.c.a;
        if (com.bytedance.android.annie.bridge.method.permission.c.g(r11.getContext()) == false) goto L13;
        RequestPermissionResultModel r21 = new RequestPermissionResultModel();
        r21.a(RequestPermissionResultModel.Code.Success);
        RequestPermissionResultModel.Status r110 = RequestPermissionResultModel.Status.Permitted;
        r21.b(r110.toString());
        r21.c(r110.toString());
        finishWithResult(r21);
        return;
    L13:
        FragmentActivity r22 = r11.getContext();
        if ((r22 instanceof FragmentActivity) == false) goto L16;
        r19 = r22;
    L16:
        if (r19 == null) goto L20;
        Lifecycle r23 = r19.getLifecycle();
        if (r23 == null) goto L20;
        r23.addObserver((LifecycleObserver) this.d.getValue());
    L20:
        Context r24 = r11.getContext();
        r24.startActivity(com.bytedance.android.annie.bridge.method.permission.c.b(r24));
        return;
    L21:
        boolean r25 = false;
        if (r17 != Permission.LOCATION) goto L55;
        Map<String, com.bytedance.android.annie.bridge.method.permission.c.b> r26 = com.bytedance.android.annie.bridge.method.permission.c.a;
        Context r27 = r11.getContext();
        Intrinsics.checkNotNullParameter(r27, "context");
        if (com.bytedance.android.annie.bridge.method.permission.c.i(r27) == true) goto L26;
        PermissionStatus r28 = PermissionStatus.DENIED;
    L35:
        if (r28 != PermissionStatus.PERMITTED) goto L37;
    L46:
        RequestPermissionResultModel r111 = new RequestPermissionResultModel();
        r111.a(RequestPermissionResultModel.Code.Success);
        String r0 = r28.name();
        if (r0 == null) goto L54;
        r111.c(r0.toLowerCase());
        String r29 = r28.name();
        if (r29 == null) goto L52;
        r111.b(r29.toLowerCase());
        finishWithResult(r111);
        return;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L54:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L37:
        if (r28 == PermissionStatus.DENIED) goto L46;
        if ((r11.getContext() instanceof Activity) == true) goto L42;
        return;
    L42:
        if (this.a != null) goto L44;
        e r30 = new e(this, r11);
    L45:
        q9.b r1 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        Context r112 = r11.getContext();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type android.app.Activity");
        r1.n((Activity) r112, this.a, r30, new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        return;
    L44:
        r30 = null;
        goto L45
    L26:
        Intrinsics.checkNotNullParameter(r27, "context");
        if (ContextCompat.checkSelfPermission(r27, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L29;
    L31:
        if (r25 == false) goto L33;
        r28 = PermissionStatus.PERMITTED;
        goto L35
    L33:
        r28 = PermissionStatus.DENIED;
        goto L35
    L29:
        if (ContextCompat.checkSelfPermission(r27, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L31;
        r25 = true;
        goto L31
    L55:
        int r31 = c.a[r17.ordinal()];
        if (r31 == 1) goto L63;
        if (r31 != 2) goto L59;
        List<String> r32 = com.bytedance.android.annie.bridge.method.permission.c.f();
    L64:
        q9.b r33 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        Context r34 = r11.getContext();
        List<String> r35 = r32;
        ArrayList r36 = new ArrayList();
        Iterator<T> r37 = r35.iterator();
    L66:
        if (r37.hasNext() == false) goto L70;
        String r38 = (String) r37.next();
        if (r38 == null) goto L66;
        r36.add(r38);
        goto L66
    L70:
        Object[] r39 = r36.toArray(new String[0]);
        if (r39 == null) goto L93;
        String[] r40 = (String[]) r39;
        if (r33.isPermissionAllGranted(r34, (String[]) Arrays.copyOf(r40, r40.length)) == false) goto L75;
        RequestPermissionResultModel r41 = new RequestPermissionResultModel();
        r41.a(RequestPermissionResultModel.Code.Success);
        RequestPermissionResultModel.Status r113 = RequestPermissionResultModel.Status.Permitted;
        r41.c(r113.toString());
        r41.b(r113.toString());
        finishWithResult(r41);
        return;
    L75:
        Context r42 = r11.getContext();
        r11.a();
        if ((r42 instanceof Activity) == false) goto L111;
        q9.b r114 = (q9.b) Annie.getService$default(q9.b.class, null, 2, null);
        q r43 = this.a;
        if (r43 != null) goto L80;
        r19 = new d(this);
    L80:
        Activity r44 = (Activity) r42;
        ArrayList r45 = new ArrayList();
        Iterator<T> r46 = r35.iterator();
    L82:
        if (r46.hasNext() == false) goto L86;
        String r47 = (String) r46.next();
        if (r47 == null) goto L82;
        r45.add(r47);
        goto L82
    L86:
        Object[] r48 = r45.toArray(new String[0]);
        if (r48 == null) goto L90;
        String[] r49 = (String[]) r48;
        r114.n(r44, r43, r19, (String[]) Arrays.copyOf(r49, r49.length));
        return;
    L90:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L111:
        return;
    L93:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L59:
        if (r31 == 3) goto L61;
        r32 = r17.getPermission();
        goto L64
    L61:
        r32 = com.bytedance.android.annie.bridge.method.permission.c.d();
        goto L64
    L63:
        r32 = com.bytedance.android.annie.bridge.method.permission.c.c();
        goto L64
    }
}
