package com.bytedance.android.annie.bridge.method.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsParamModel;
import com.bytedance.android.annie.bridge.method.abs.OpenPermissionSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import e7.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast", name = "openPermissionSettings")
public final class OpenPermissionSettingsMethod extends o<OpenPermissionSettingsParamModel, OpenPermissionSettingsResultModel> {
    public Lifecycle.Event a;
    public Context b;
    public Permission c;
    public final Lazy d;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Permission.values().length];
            r0[Permission.PHOTOALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[Permission.WRITE_PHOTOALBUM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[Permission.READ_PHOTOALBUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[Permission.NOTIFICATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[Permission.LOCATION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public OpenPermissionSettingsMethod() {
        this.d = LazyKt.lazy(new OpenPermissionSettingsMethod$lifeCycleMonitorListener$2(this));
    }

    public static PermissionStatus j(Context r10, Permission r11) {
        int[] r0 = a.a;
        int r1 = r0[r11.ordinal()];
        if (r1 == 4) goto L66;
        boolean r12 = true;
        if (r1 == 5) goto L53;
        int r13 = r0[r11.ordinal()];
        if (r13 != 1) goto L9;
        List<String> r14 = c.c();
    L17:
        if (r14.size() != 1) goto L21;
        String r15 = (String) CollectionsKt.first(r14);
        if (r15 == null) goto L31;
        boolean r16 = c.a(r10, r15);
    L33:
        Map<String, c.b> r17 = c.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r14, "permissions");
        if ((r10 instanceof Activity) == false) goto L36;
        Activity r18 = (Activity) r10;
    L37:
        if (r18 == null) goto L47;
        Iterator<T> r19 = r14.iterator();
    L41:
        if (r19.hasNext() == false) goto L47;
        String r20 = (String) r19.next();
        if (r20 == null) goto L41;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r18, r20) == true) goto L41;
    L48:
        if (r16 == true) goto L82;
        if (r12 == false) goto L84;
        return PermissionStatus.DENIED;
    L84:
        return PermissionStatus.UNDETERMINED;
    L82:
        return PermissionStatus.PERMITTED;
    L47:
        r12 = false;
        goto L48
    L36:
        r18 = null;
    L31:
        r16 = false;
        goto L33
    L21:
        Map<String, c.b> r21 = c.a;
        Intrinsics.checkNotNullParameter(r14, "permissions");
        if (r10 == null) goto L31;
        Iterator<String> r22 = r14.iterator();
    L26:
        if (r22.hasNext() == false) goto L32;
        String r23 = r22.next();
        if (r23 == null) goto L26;
        if (ContextCompat.checkSelfPermission(r10, r23) != (-1)) goto L26;
    L32:
        r16 = true;
        goto L33
    L9:
        if (r13 != 2) goto L11;
        r14 = c.f();
        goto L17
    L11:
        if (r13 == 3) goto L13;
        r14 = r11.getPermission();
        goto L17
    L13:
        r14 = c.d();
        goto L17
    L53:
        Map<String, c.b> r24 = c.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        if (c.i(r10) == false) goto L85;
        Intrinsics.checkNotNullParameter(r10, "context");
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L59;
    L61:
        r12 = false;
    L62:
        if (r12 == false) goto L87;
        return PermissionStatus.PERMITTED;
    L87:
        return PermissionStatus.DENIED;
    L59:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L61;
    L85:
        return PermissionStatus.DENIED;
    L66:
        if (c.g(r10) == false) goto L69;
        return PermissionStatus.PERMITTED;
    L69:
        return PermissionStatus.UNDETERMINED;
    }

    public final void invoke(Object r10, CallContext r11) {
        OpenPermissionSettingsParamModel r12 = (OpenPermissionSettingsParamModel) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        OpenPermissionSettingsParamModel.Permission r13 = r12.a();
        if (r13 != null) goto L5;
        OpenPermissionSettingsResultModel r14 = new OpenPermissionSettingsResultModel();
        r14.a(OpenPermissionSettingsResultModel.Code.InvalidParam);
        r14.b("Illegal permission");
        finishWithResult(r14);
        return;
    L5:
        Permission.a r15 = Permission.Companion;
        String r16 = r13.toString();
        r15.getClass();
        Permission r17 = Permission.a.a(r16);
        this.c = r17;
        this.b = r11.getContext();
        if (r17 != Permission.UNKNOWN) goto L8;
        OpenPermissionSettingsResultModel r18 = new OpenPermissionSettingsResultModel();
        r18.a(OpenPermissionSettingsResultModel.Code.InvalidParam);
        r18.b("Illegal permission");
        finishWithResult(r18);
        return;
    L8:
        PermissionStatus r1 = j(r11.getContext(), r17);
        PermissionStatus r19 = PermissionStatus.PERMITTED;
        if (r1 != r19) goto L19;
        OpenPermissionSettingsResultModel r20 = new OpenPermissionSettingsResultModel();
        r20.a(OpenPermissionSettingsResultModel.Code.Success);
        String r21 = r19.name();
        if (r21 == null) goto L18;
        r20.b(r21.toLowerCase());
        String r22 = r19.name();
        if (r22 == null) goto L16;
        r20.c(r22.toLowerCase());
        finishWithResult(r20);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        FragmentActivity r23 = r11.getContext();
        if ((r23 instanceof FragmentActivity) == false) goto L22;
        FragmentActivity r24 = r23;
    L23:
        if (r24 == null) goto L28;
        Lifecycle r25 = r24.getLifecycle();
        if (r25 == null) goto L28;
        r25.addObserver((LifecycleObserver) this.d.getValue());
    L28:
        if (r17 != Permission.LOCATION) goto L38;
        if (r1 != PermissionStatus.DENIED) goto L38;
        Context r26 = r11.getContext();
        Map<String, c.b> r27 = c.a;
        Intrinsics.checkNotNullParameter(r26, "context");
        c.b r28 = c.a.get(Build.MANUFACTURER.toLowerCase());
        if (r28 == null) goto L35;
        Intent r29 = r28.c(r26);
        if (r29 == null) goto L35;
    L36:
        r26.startActivity(r29);
        return;
    L35:
        Intrinsics.checkNotNullParameter(r26, "context");
        r29 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        r29.addFlags(268435456);
    L38:
        if (r17 != Permission.NOTIFICATION) goto L40;
        Context r30 = r11.getContext();
        r30.startActivity(c.b(r30));
        return;
    L40:
        Context r31 = r11.getContext();
        Map<String, c.b> r32 = c.a;
        Intrinsics.checkNotNullParameter(r31, "context");
        c.b r33 = c.a.get(Build.MANUFACTURER.toLowerCase());
        if (r33 == null) goto L44;
        Intent r34 = r33.a(r31);
        if (r34 == null) goto L44;
    L45:
        r31.startActivity(r34);
        return;
    L44:
        Intrinsics.checkNotNullParameter(r31, "context");
        r34 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r34.addFlags(268435456);
        r34.setData(Uri.fromParts("package", r31.getPackageName(), null));
        goto L45
    L22:
        r24 = null;
        goto L23
    }
}
