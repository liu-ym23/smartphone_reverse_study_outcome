package com.bytedance.ai.bridge.method.system.permission;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.bridge.core.AIBridgeMethod$InvalidParamsError;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.permission.AbsCheckPermissionMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import f2.a;
import f8.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000bJ%\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J-\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/CheckPermissionMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL;", "<init>", "()V", "Landroid/content/Context;", "context", "", "", "permissions", "", "checkPermissions", "(Landroid/content/Context;Ljava/util/List;)Z", "isPermissionsRejected", "Lo1/f;", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionResultModel;", "callback", "", "handleNotificationPermission", "(Landroid/content/Context;Lo1/f;)V", "handleLocationPermission", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionParamModel;", LynxResourceModule.PARAMS_KEY, "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/system/permission/AbsCheckPermissionMethodIDL$PermissionParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCheckPermissionMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CheckPermissionMethod.kt\ncom/bytedance/ai/bridge/method/system/permission/CheckPermissionMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,138:1\n774#2:139\n865#2,2:140\n1734#2,3:142\n1863#2,2:145\n*S KotlinDebug\n*F\n+ 1 CheckPermissionMethod.kt\ncom/bytedance/ai/bridge/method/system/permission/CheckPermissionMethod\n*L\n65#1:139\n65#1:140,2\n65#1:142,3\n78#1:145,2\n*E\n"})
public final class CheckPermissionMethod extends AbsCheckPermissionMethodIDL {
    public CheckPermissionMethod() {
    }

    private final boolean checkPermissions(Context r5, List<String> r10) {
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        List r11 = CollectionsKt.m(r10);
        ArrayList r12 = new ArrayList();
        Iterator r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        Object r14 = r13.next();
        if (((String) r14).length() <= 0) goto L7;
        r12.add(r14);
        goto L7
    L12:
        if (r12.isEmpty() == false) goto L14;
        return true;
    L14:
        Iterator r15 = r12.iterator();
    L16:
        if (r15.hasNext() == false) goto L22;
        if (ContextCompat.checkSelfPermission(r5, (String) r15.next()) == 0) goto L16;
        return false;
    L22:
        return true;
    }

    private final void handleLocationPermission(Context r10, f r11) {
        if (b.i(r10) == true) goto L6;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r12 = e.c(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        ((AbsCheckPermissionMethodIDL.PermissionResultModel) r12).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.DENIED);
        r11.b((ResultModel) r12, "");
        return;
    L6:
        boolean r5 = b.g(r10);
        boolean r13 = isPermissionsRejected(r10, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r14 = e.c(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        AbsCheckPermissionMethodIDL.PermissionResultModel r15 = (AbsCheckPermissionMethodIDL.PermissionResultModel) r14;
        if (r5 == false) goto L9;
        AbsCheckPermissionMethodIDL.PermissionStatus r16 = AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED;
    L12:
        r15.setStatus(r16);
        r11.b((ResultModel) r14, "");
        return;
    L9:
        if (r13 == false) goto L11;
        r16 = AbsCheckPermissionMethodIDL.PermissionStatus.DENIED;
        goto L12
    L11:
        r16 = AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED;
        goto L12
    }

    private final void handleNotificationPermission(Context r5, f r10) {
        boolean r11 = NotificationManagerCompat.from(r5).areNotificationsEnabled();     // Catch: Exception -> L4
    L6:
        KClass r12 = Reflection.getOrCreateKotlinClass(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        Intrinsics.checkNotNullParameter(r12, "<this>");
        BaseModel r13 = e.c(JvmClassMappingKt.getJavaClass(r12));
        AbsCheckPermissionMethodIDL.PermissionResultModel r14 = (AbsCheckPermissionMethodIDL.PermissionResultModel) r13;
        if (r11 == false) goto L9;
        AbsCheckPermissionMethodIDL.PermissionStatus r15 = AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED;
    L10:
        r14.setStatus(r15);
        r10.b((ResultModel) r13, "");
        return;
    L9:
        r15 = AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    L4:
        e = move-exception;
        e.printStackTrace();
        r11 = false;
        goto L6
    }

    private final boolean isPermissionsRejected(Context r5, List<String> r10) {
        if ((r5 instanceof Activity) == false) goto L5;
        Activity r11 = (Activity) r5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        Iterator<T> r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L24;
        String r13 = (String) r12.next();
        if (r13 == null) goto L11;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r11, r13) == true) goto L11;
        return true;
    L24:
        return false;
    L5:
        r11 = null;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsCheckPermissionMethodIDL.PermissionParamModel) r10, r11);
    }

    public void handle(c r5, AbsCheckPermissionMethodIDL.PermissionParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        AbsCheckPermissionMethodIDL.PermissionName r12 = r10.getPermission();
        a r13 = Permission.f2012b;
        String r14 = r12.name();
        r13.getClass();
        if (r14 != null) goto L33;
        Permission r15 = Permission.e;
    L9:
        if (r15 == Permission.e) goto L32;
        Activity r16 = s0.c.b();
        if (r16 != null) goto L15;
        r11.a("Context not provided in host");
        return;
    L15:
        if (r15 != Permission.f2013c) goto L19;
        handleNotificationPermission(r16, r11);
        return;
    L19:
        if (r15 != Permission.d) goto L22;
        handleLocationPermission(r16, r11);
        return;
    L22:
        List<String> r17 = r15.f2014a;
        boolean r18 = checkPermissions(r16, r17);
        boolean r19 = isPermissionsRejected(r16, r17);
        if (r18 == false) goto L26;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r20 = e.c(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        ((AbsCheckPermissionMethodIDL.PermissionResultModel) r20).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.PERMITTED);
        r11.b((ResultModel) r20, "");
        return;
    L26:
        if (r19 == false) goto L29;
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r21 = e.c(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        ((AbsCheckPermissionMethodIDL.PermissionResultModel) r21).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.DENIED);
        r11.b((ResultModel) r21, "");
        return;
    L29:
        Intrinsics.checkNotNullParameter(AbsCheckPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r22 = e.c(AbsCheckPermissionMethodIDL.PermissionResultModel.class);
        ((AbsCheckPermissionMethodIDL.PermissionResultModel) r22).setStatus(AbsCheckPermissionMethodIDL.PermissionStatus.UNDETERMINED);
        r11.b((ResultModel) r22, "");
        return;
    L32:
        throw new AIBridgeMethod$InvalidParamsError();
    L33:
        r15 = Permission.valueOf(r14.toUpperCase(Locale.ROOT));     // Catch: Exception -> L6
    L6:
        r15 = Permission.e;
        goto L9
    }
}
