package com.bytedance.ai.bridge.method.system.permission;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.IHostLocationPermissionDepend;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import com.bytedance.android.ec.core.event.a;
import e3.d;
import f2.k;
import f3.h;
import g4.b;
import g4.c;
import g4.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J6\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 ²\u0006\n\u0010!\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/RequestPermissionMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL;", "<init>", "()V", "mCallback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionResultModel;", "previousEvent", "Landroidx/lifecycle/Lifecycle$Event;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionParamModel;", "callback", "checkNotificationPermission", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", "context", "Landroid/content/Context;", "goToAppSettings", "checkLocationPermission", "actualRequestPermission", a.VALUE_ACTIVITY, "Landroid/app/Activity;", "permissions", "", "", "handleLifeCycleCallback", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "event", "ai-sdk_release", "lifeCycleMonitorListener"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestPermissionMethod extends AbsRequestPermissionMethodIDL {
    public h<AbsRequestPermissionMethodIDL.b> b;
    public Lifecycle.Event c;

    public RequestPermissionMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsRequestPermissionMethodIDL.a r13 = (AbsRequestPermissionMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        final Activity r14 = k.b();
        if (r14 != null) goto L5;
        h.a.a(r12, "Context not provided in host", null, null, 14);
        return;
    L5:
        Lazy r1 = LazyKt.lazy(new c(this, r14));
        AbsRequestPermissionMethodIDL.PermissionName r15 = r13.getPermission();
        Permission.a r16 = Permission.Companion;
        String r17 = r15.name();
        r16.getClass();
        if (r17 != null) goto L85;
        Permission r18 = Permission.UNKNOWN;
    L11:
        boolean r19 = true;
        if (r18 == Permission.UNKNOWN) goto L82;
        boolean r20 = false;
        if (r18 != Permission.NOTIFICATION) goto L40;
        r20 = NotificationManagerCompat.from(r14).areNotificationsEnabled();     // Catch: Exception -> L17
    L19:
        if (r20 == false) goto L21;
        AbsRequestPermissionMethodIDL.PermissionStatus r110 = AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
    L23:
        if (r110 != AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED) goto L25;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r111 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        ((AbsRequestPermissionMethodIDL.b) r111).setStatus(r110);
        r12.b((ResultModel) r111, "");
        return;
    L25:
        this.b = r12;
        if ((r14 instanceof FragmentActivity) == false) goto L28;
        FragmentActivity r112 = (FragmentActivity) r14;
    L29:
        if (r112 == null) goto L33;
        Lifecycle r113 = r112.getLifecycle();
        if (r113 == null) goto L33;
        r113.addObserver((LifecycleObserver) r1.getValue());
    L33:
        Map<String, b.InterfaceC0159b> r114 = b.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        String r115 = Build.MANUFACTURER;
        Map<String, b.InterfaceC0159b> r116 = b.a;
        Intrinsics.checkNotNull(r115);
        b.InterfaceC0159b r117 = r116.get(r115.toLowerCase());
        if (r117 == null) goto L37;
        Intent r118 = r117.b(r14);
        if (r118 == null) goto L37;
    L38:
        r14.startActivity(r118);
        return;
    L37:
        Intrinsics.checkNotNullParameter(r14, "context");
        r118 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r118.addFlags(268435456);
        r118.setData(Uri.fromParts("package", r14.getPackageName(), null));
        goto L38
    L28:
        r112 = null;
        goto L29
    L21:
        r110 = AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L40:
        if (r18 == Permission.LOCATION) goto L42;
    L57:
        List<String> r0 = r18.getPermission();
        i r21 = r4.a.f;
        if (r21 == null) goto L68;
        ArrayList r22 = new ArrayList();
        Iterator<T> r23 = r0.iterator();
    L61:
        if (r23.hasNext() == false) goto L65;
        String r24 = (String) r23.next();
        if (r24 == null) goto L61;
        r22.add(r24);
        goto L61
    L65:
        String[] r25 = (String[]) r22.toArray(new String[0]);
        if (r21.isPermissionAllGranted(r14, (String[]) Arrays.copyOf(r25, r25.length)) != true) goto L68;
    L69:
        if (r19 == false) goto L71;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r119 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        ((AbsRequestPermissionMethodIDL.b) r119).setStatus(AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED);
        r12.b((ResultModel) r119, "");
        return;
    L71:
        List<String> r120 = r18.getPermission();
        i r26 = r4.a.f;
        if (r26 == null) goto L103;
        String r27 = this.a;
        ArrayList r28 = new ArrayList();
        Iterator<T> r121 = r120.iterator();
    L75:
        if (r121.hasNext() == false) goto L79;
        String r29 = (String) r121.next();
        if (r29 == null) goto L75;
        r28.add(r29);
        goto L75
    L79:
        String[] r122 = (String[]) r28.toArray(new String[0]);
        r26.a(r14, r10, r27, (String[]) Arrays.copyOf(r122, r122.length), new g4.d(r12));
        return;
    L103:
        return;
    L68:
        r19 = false;
        goto L69
    L42:
        if (g4.a.b(r14) == true) goto L45;
        AbsRequestPermissionMethodIDL.PermissionStatus r30 = AbsRequestPermissionMethodIDL.PermissionStatus.DENIED;
    L49:
        if (r30 != AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED) goto L51;
    L56:
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.b.class, "<this>");
        BaseModel r31 = k3.c.a(AbsRequestPermissionMethodIDL.b.class);
        ((AbsRequestPermissionMethodIDL.b) r31).setStatus(r30);
        r12.b((ResultModel) r31, "");
        goto L57
    L51:
        if (r30 == AbsRequestPermissionMethodIDL.PermissionStatus.DENIED) goto L56;
        IHostLocationPermissionDepend r123 = r4.a.g;
        if (r123 == null) goto L100;
        r123.requestPermission(r14, r10, this.a, new e(r12, r14));
        return;
    L100:
        return;
    L45:
        if (g4.a.a(r14) == false) goto L47;
        r30 = AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
        goto L49
    L47:
        r30 = AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
        goto L49
    L82:
        throw new AIBridgeMethod.InvalidParamsError(null, 1, null);
    L85:
        r18 = Permission.valueOf(r17.toUpperCase(Locale.ROOT));     // Catch: Exception -> L9
    L9:
        r18 = Permission.UNKNOWN;
        goto L11
    }
}
