package com.bytedance.ai.bridge.method.system.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.permission.AbsCheckPermissionMethodIDL;
import e3.d;
import f2.k;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import k3.a;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0002J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/CheckPermissionMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionResultModel;", "checkPermissions", "", "context", "Landroid/content/Context;", "permissions", "", "", "isPermissionsRejected", "handleNotificationPermission", "handleLocationPermission", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckPermissionMethod extends AbsCheckPermissionMethodIDL {
    public CheckPermissionMethod() {
    }

    public static boolean b(Context r1, List r10) {
        Activity r11 = (Activity) r1;
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String r0 = (String) r12.next();
        if (r0 == null) goto L4;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r11, r0) == true) goto L4;
        return true;
    L11:
        return false;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsCheckPermissionMethodIDL.a r13 = (AbsCheckPermissionMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        AbsCheckPermissionMethodIDL.PermissionName r14 = r13.getPermission();
        Permission.a r15 = Permission.Companion;
        String r16 = r14.name();
        r15.getClass();
        if (r16 != null) goto L69;
        Permission r17 = Permission.UNKNOWN;
    L8:
        boolean r1 = true;
        if (r17 == Permission.UNKNOWN) goto L68;
        Activity r18 = k.b();
        if (r18 != null) goto L13;
        h.a.a(r12, "Context not provided in host", null, null, 14);
        return;
    L13:
        boolean r19 = false;
        if (r17 != Permission.NOTIFICATION) goto L25;
        r19 = NotificationManagerCompat.from(r18).areNotificationsEnabled();     // Catch: Exception -> L17
    L19:
        BaseModel r20 = a.b(Reflection.getOrCreateKotlinClass(AbsCheckPermissionMethodIDL.b.class));
        AbsCheckPermissionMethodIDL.b r110 = (AbsCheckPermissionMethodIDL.b) r20;
        if (r19 == false) goto L22;
        AbsCheckPermissionMethodIDL.PermissionStatus r0 = AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED;
    L23:
        r110.setStatus(r0);
        r12.b((ResultModel) r20, "");
        return;
    L22:
        r0 = AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L25:
        if (r17 == Permission.LOCATION) goto L27;
        List<String> r21 = r17.getPermission();
        if (r21.isEmpty() == true) goto L60;
        List r22 = CollectionsKt.filterNotNull(r21);
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L41:
        if (r24.hasNext() == false) goto L49;
        Object r25 = r24.next();
        if (((String) r25).length() <= 0) goto L45;
        boolean r26 = true;
    L46:
        if (r26 == false) goto L41;
        r23.add(r25);
        goto L41
    L45:
        r26 = false;
        goto L46
    L49:
        if (r23.isEmpty() == true) goto L60;
        Iterator r27 = r23.iterator();
    L53:
        if (r27.hasNext() == false) goto L60;
        if (ContextCompat.checkSelfPermission(r18, (String) r27.next()) != 0) goto L57;
        boolean r28 = true;
    L58:
        if (r28 == true) goto L53;
        r1 = false;
        goto L60
    L57:
        r28 = false;
    L60:
        boolean r29 = b(r18, r21);
        if (r1 == false) goto L63;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r30 = c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r30).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED);
        r12.b((ResultModel) r30, "");
        return;
    L63:
        if (r29 == false) goto L65;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r31 = c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r31).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.DENIED);
        r12.b((ResultModel) r31, "");
        return;
    L65:
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r32 = c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r32).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED);
        r12.b((ResultModel) r32, "");
        return;
    L27:
        if (g4.a.b(r18) == true) goto L29;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r33 = c.a(AbsCheckPermissionMethodIDL.b.class);
        ((AbsCheckPermissionMethodIDL.b) r33).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.DENIED);
        r12.b((ResultModel) r33, "");
        return;
    L29:
        boolean r34 = g4.a.a(r18);
        boolean r111 = b(r18, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.b.class, "<this>");
        BaseModel r35 = c.a(AbsCheckPermissionMethodIDL.b.class);
        AbsCheckPermissionMethodIDL.b r36 = (AbsCheckPermissionMethodIDL.b) r35;
        if (r34 == false) goto L32;
        AbsCheckPermissionMethodIDL.PermissionStatus r37 = AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED;
    L35:
        r36.setStatus(r37);
        r12.b((ResultModel) r35, "");
        return;
    L32:
        if (r111 == false) goto L34;
        r37 = AbsCheckPermissionMethodIDL.PermissionStatus.DENIED;
        goto L35
    L34:
        r37 = AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED;
        goto L35
    L68:
        throw new AIBridgeMethod.InvalidParamsError(null, 1, null);
    L69:
        r17 = Permission.valueOf(r16.toUpperCase(Locale.ROOT));     // Catch: Exception -> L6
    L6:
        r17 = Permission.UNKNOWN;
        goto L8
    }
}
