package com.bytedance.ai.bridge.method.system.permission;

import a2.a;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ai.bridge.core.AIBridgeMethod$InvalidParamsError;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.system.permission.AbsRequestPermissionMethodIDL;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostLocationPermissionServiceImpl;
import f8.b;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k5.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\bJ=\u0010\u0017\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b!\u0010\"R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010%\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006(²\u0006\f\u0010'\u001a\u00020\u00198\nX\u008a\u0084\u0002"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/permission/RequestPermissionMethod;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", "checkNotificationPermission", "(Landroid/content/Context;)Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionStatus;", "", "goToAppSettings", "(Landroid/content/Context;)V", "checkLocationPermission", "Ln1/c;", "bridgeContext", "Landroid/app/Activity;", "activity", "", "", "permissions", "Lo1/f;", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionResultModel;", "callback", "actualRequestPermission", "(Ln1/c;Landroid/app/Activity;Ljava/util/List;Lo1/f;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/Lifecycle$Event;", "event", "handleLifeCycleCallback", "(Landroidx/lifecycle/LifecycleObserver;Landroid/app/Activity;Landroidx/lifecycle/Lifecycle$Event;)V", "Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionParamModel;", LynxResourceModule.PARAMS_KEY, "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/system/permission/AbsRequestPermissionMethodIDL$PermissionParamModel;Lo1/f;)V", "mCallback", "Lo1/f;", "previousEvent", "Landroidx/lifecycle/Lifecycle$Event;", "lifeCycleMonitorListener", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRequestPermissionMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestPermissionMethod.kt\ncom/bytedance/ai/bridge/method/system/permission/RequestPermissionMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,217:1\n1611#2,9:218\n1863#2:227\n1864#2:229\n1620#2:230\n1611#2,9:233\n1863#2:242\n1864#2:244\n1620#2:245\n1#3:228\n1#3:243\n37#4,2:231\n37#4,2:246\n*S KotlinDebug\n*F\n+ 1 RequestPermissionMethod.kt\ncom/bytedance/ai/bridge/method/system/permission/RequestPermissionMethod\n*L\n112#1:218,9\n112#1:227\n112#1:229\n112#1:230\n165#1:233,9\n165#1:242\n165#1:244\n165#1:245\n112#1:228\n165#1:243\n112#1:231,2\n165#1:246,2\n*E\n"})
public final class RequestPermissionMethod extends AbsRequestPermissionMethodIDL {
    private f mCallback;
    private Lifecycle.Event previousEvent;

    public RequestPermissionMethod() {
    }

    public static final /* synthetic */ void access$handleLifeCycleCallback(RequestPermissionMethod r5, LifecycleObserver r10, Activity r11, Lifecycle.Event r12) {
        r5.handleLifeCycleCallback(r10, r11, r12);
    }

    private final void actualRequestPermission(c r5, Activity r10, List<String> r11, f r12) {
    }

    public static /* synthetic */ RequestPermissionMethod$handle$lifeCycleMonitorListener$2$1 b(RequestPermissionMethod r5, Activity r10) {
        return handle$lambda$0(r5, r10);
    }

    private final AbsRequestPermissionMethodIDL.PermissionStatus checkLocationPermission(Context r5) {
        if (b.i(r5) == true) goto L7;
        return AbsRequestPermissionMethodIDL.PermissionStatus.DENIED;
    L7:
        if (b.g(r5) == false) goto L11;
        return AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
    L11:
        return AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    }

    private final AbsRequestPermissionMethodIDL.PermissionStatus checkNotificationPermission(Context r5) {
        if (r5 == null) goto L4;
        boolean r10 = NotificationManagerCompat.from(r5).areNotificationsEnabled();     // Catch: Exception -> L7
    L9:
        if (r10 == false) goto L12;
        return AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED;
    L12:
        return AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    L7:
        e = move-exception;
        e.printStackTrace();
        r10 = false;
        goto L9
    L4:
        return AbsRequestPermissionMethodIDL.PermissionStatus.UNDETERMINED;
    }

    private final void goToAppSettings(Context r10) {
        Map r5 = f2.c.f16873a;
        Intrinsics.checkNotNullParameter(r10, "context");
        String r11 = Build.MANUFACTURER;
        Intrinsics.checkNotNull(r11);
        String r12 = r11.toLowerCase();
        f2.b r13 = (f2.b) f2.c.f16873a.get(r12);
        if (r13 == null) goto L5;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        ComponentName r14 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
        Intent r15 = new Intent();
        r15.setComponent(r14);
        r15.setData(Uri.fromParts("package", r10.getPackageName(), null));
        r15.setFlags(268435456);
    L6:
        r10.startActivity(r15);
        return;
    L5:
        Intrinsics.checkNotNullParameter(r10, "context");
        r15 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r15.addFlags(268435456);
        r15.setData(Uri.fromParts("package", r10.getPackageName(), null));
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ai.bridge.method.system.permission.RequestPermissionMethod$handle$lifeCycleMonitorListener$2$1] */
    private static final RequestPermissionMethod$handle$lifeCycleMonitorListener$2$1 handle$lambda$0(final RequestPermissionMethod r5, final Activity r10) {
        return new RequestPermissionMethod$handle$lifeCycleMonitorListener$2$1(r5, r10);
    }

    private static final LifecycleObserver handle$lambda$1(Lazy<RequestPermissionMethod$handle$lifeCycleMonitorListener$2$1> r5) {
        return r5.getValue();
    }

    private final void handleLifeCycleCallback(LifecycleObserver r5, Activity r10, Lifecycle.Event r11) {
        Lifecycle.Event r12 = Lifecycle.Event.ON_RESUME;
        if (r11 == r12) goto L8;
        if (r11 == Lifecycle.Event.ON_PAUSE) goto L8;
        return;
    L8:
        if (this.previousEvent != Lifecycle.Event.ON_PAUSE) goto L23;
        if (r11 != r12) goto L23;
        this.previousEvent = null;
        if ((r10 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r13 = (FragmentActivity) r10;
    L14:
        if (r13 == null) goto L18;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L18;
        r14.removeObserver(r5);
    L18:
        AbsRequestPermissionMethodIDL.PermissionStatus r15 = checkNotificationPermission(r10);
        f r16 = this.mCallback;
        if (r16 == null) goto L21;
        KClass r17 = Reflection.getOrCreateKotlinClass(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        BaseModel r18 = e.c(JvmClassMappingKt.getJavaClass(r17));
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r18).setStatus(r15);
        r16.b((ResultModel) r18, "");
    L21:
        this.mCallback = null;
        return;
    L13:
        r13 = null;
    L23:
        this.previousEvent = r11;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsRequestPermissionMethodIDL.PermissionParamModel) r10, r11);
    }

    public void handle(c r10, AbsRequestPermissionMethodIDL.PermissionParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        Activity r5 = s0.c.b();
        if (r5 != null) goto L6;
        r12.a("Context not provided in host");
        return;
    L6:
        Lazy r13 = LazyKt.lazy(new a(4, this, r5));
        AbsRequestPermissionMethodIDL.PermissionName r14 = r11.getPermission();
        f2.a r15 = Permission.f2012b;
        String r16 = r14.name();
        r15.getClass();
        if (r16 != null) goto L46;
        Permission r17 = Permission.e;
    L13:
        if (r17 == Permission.e) goto L45;
        if (r17 != Permission.f2013c) goto L31;
        AbsRequestPermissionMethodIDL.PermissionStatus r18 = checkNotificationPermission(r5);
        if (r18 != AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED) goto L20;
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r19 = e.c(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r19).setStatus(r18);
        r12.b((ResultModel) r19, "");
        return;
    L20:
        this.mCallback = r12;
        if ((r5 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r20 = (FragmentActivity) r5;
    L24:
        if (r20 == null) goto L28;
        Lifecycle r21 = r20.getLifecycle();
        if (r21 == null) goto L28;
        r21.addObserver(handle$lambda$1(r13));
    L28:
        goToAppSettings(r5);
        return;
    L23:
        r20 = null;
        goto L24
    L31:
        if (r17 != Permission.d) goto L42;
        AbsRequestPermissionMethodIDL.PermissionStatus r22 = checkLocationPermission(r5);
        if (r22 != AbsRequestPermissionMethodIDL.PermissionStatus.PERMITTED) goto L35;
    L41:
        Intrinsics.checkNotNullParameter(AbsRequestPermissionMethodIDL.PermissionResultModel.class, "<this>");
        BaseModel r23 = e.c(AbsRequestPermissionMethodIDL.PermissionResultModel.class);
        ((AbsRequestPermissionMethodIDL.PermissionResultModel) r23).setStatus(r22);
        r12.b((ResultModel) r23, "");
        goto L42
    L35:
        if (r22 == AbsRequestPermissionMethodIDL.PermissionStatus.DENIED) goto L41;
        ObricLauncherHostLocationPermissionServiceImpl r24 = d.e;
        if (r24 == null) goto L48;
        r24.requestPermission(r5, r10, getName(), new f2.d(r5, r12));
        return;
    L48:
        return;
    L42:
        actualRequestPermission(r10, r5, r17.f2014a, r12);
        return;
    L45:
        throw new AIBridgeMethod$InvalidParamsError();
    L46:
        r17 = Permission.valueOf(r16.toUpperCase(Locale.ROOT));     // Catch: Exception -> L10
    L10:
        r17 = Permission.e;
        goto L13
    }
}
