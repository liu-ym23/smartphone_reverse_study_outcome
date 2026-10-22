package com.bytedance.android.annie.bridge.method.permission;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.android.annie.bridge.method.abs.CheckPermissionParamModel;
import com.bytedance.android.annie.bridge.method.abs.CheckPermissionResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "checkPermission")
public final class a extends e7.b<CheckPermissionParamModel, CheckPermissionResultModel> {

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.permission.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0063a {
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

    public a() {
    }

    public final void invoke(Object r10, CallContext r11) {
        CheckPermissionParamModel r12 = (CheckPermissionParamModel) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        CheckPermissionParamModel.Permission r13 = r12.a();
        if (r13 != null) goto L5;
        CheckPermissionResultModel r14 = new CheckPermissionResultModel();
        r14.a(CheckPermissionResultModel.Code.InvalidParam);
        r14.b("Illegal permission");
        finishWithResult(r14);
        return;
    L5:
        Permission.a r15 = Permission.Companion;
        String r16 = r13.toString();
        r15.getClass();
        Permission r17 = Permission.a.a(r16);
        if (r17 != Permission.UNKNOWN) goto L9;
        CheckPermissionResultModel r18 = new CheckPermissionResultModel();
        r18.a(CheckPermissionResultModel.Code.InvalidParam);
        r18.b("Illegal permission");
        finishWithResult(r18);
        return;
    L9:
        if (r17 != Permission.NOTIFICATION) goto L14;
        Map<String, c.b> r19 = c.a;
        if (c.g(r11.getContext()) == false) goto L13;
        CheckPermissionResultModel r20 = new CheckPermissionResultModel();
        r20.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r21 = CheckPermissionResultModel.Status.Permitted;
        r20.c(r21.toString());
        r20.b(r21.toString());
        finishWithResult(r20);
        return;
    L13:
        CheckPermissionResultModel r22 = new CheckPermissionResultModel();
        r22.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r23 = CheckPermissionResultModel.Status.Denied;
        r22.c(r23.toString());
        r22.b(r23.toString());
        finishWithResult(r22);
        return;
    L14:
        boolean r24 = true;
        boolean r25 = false;
        if (r17 != Permission.LOCATION) goto L34;
        Map<String, c.b> r26 = c.a;
        if (c.i(r11.getContext()) == true) goto L19;
        CheckPermissionResultModel r27 = new CheckPermissionResultModel();
        r27.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r28 = CheckPermissionResultModel.Status.Restricted;
        r27.c(r28.toString());
        r27.b(r28.toString());
        finishWithResult(r27);
        return;
    L19:
        Context r29 = r11.getContext();
        Intrinsics.checkNotNullParameter(r29, "context");
        if (ContextCompat.checkSelfPermission(r29, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L22;
    L24:
        r24 = false;
    L25:
        CheckPermissionResultModel r30 = new CheckPermissionResultModel();
        r30.a(CheckPermissionResultModel.Code.Success);
        if (r24 == false) goto L28;
        CheckPermissionResultModel.Status r31 = CheckPermissionResultModel.Status.Permitted;
    L29:
        r30.c(r31.toString());
        if (r24 == false) goto L32;
        CheckPermissionResultModel.Status r32 = CheckPermissionResultModel.Status.Permitted;
    L33:
        r30.b(r32.toString());
        finishWithResult(r30);
        return;
    L32:
        r32 = CheckPermissionResultModel.Status.Denied;
        goto L33
    L28:
        r31 = CheckPermissionResultModel.Status.Denied;
        goto L29
    L22:
        if (ContextCompat.checkSelfPermission(r29, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L24;
    L34:
        int r0 = C0063a.a[r17.ordinal()];
        if (r0 != 1) goto L37;
        List<String> r33 = c.c();
    L45:
        if (r33.size() != 1) goto L54;
        String r34 = (String) CollectionsKt.first(r33);
        if (r34 == null) goto L66;
        Context r35 = r11.getContext();
        if (r35 == null) goto L66;
        if (ContextCompat.checkSelfPermission(r35, r34) != (-1)) goto L65;
    L64:
        r24 = false;
    L65:
        r25 = r24;
    L66:
        if (r25 == false) goto L68;
        CheckPermissionResultModel r36 = new CheckPermissionResultModel();
        r36.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r37 = CheckPermissionResultModel.Status.Permitted;
        r36.c(r37.toString());
        r36.b(r37.toString());
        finishWithResult(r36);
        return;
    L68:
        CheckPermissionResultModel r38 = new CheckPermissionResultModel();
        r38.a(CheckPermissionResultModel.Code.Success);
        CheckPermissionResultModel.Status r39 = CheckPermissionResultModel.Status.Denied;
        r38.c(r39.toString());
        r38.b(r39.toString());
        finishWithResult(r38);
        return;
    L54:
        Context r40 = r11.getContext();
        if (r40 == null) goto L64;
        Iterator<String> r41 = r33.iterator();
    L59:
        if (r41.hasNext() == false) goto L65;
        String r1 = r41.next();
        if (r1 == null) goto L59;
        if (ContextCompat.checkSelfPermission(r40, r1) != (-1)) goto L59;
    L37:
        if (r0 != 2) goto L39;
        r33 = c.f();
        goto L45
    L39:
        if (r0 == 3) goto L41;
        r33 = r17.getPermission();
        goto L45
    L41:
        r33 = c.d();
        goto L45
    }
}
