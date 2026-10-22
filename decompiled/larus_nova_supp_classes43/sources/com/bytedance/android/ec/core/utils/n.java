package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.core.utils.rotation.CommonLog;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n {

    public static final class a extends b {
        public final /* synthetic */ Application a;
        public final /* synthetic */ Function1 b;

        public a(Application r1, Function1 r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r1, Bundle r10) {
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            if (ECAppInfoService.e.b(r1) == false) goto L6;
            this.a.unregisterActivityLifecycleCallbacks(this);
            this.b.invoke(r1);
            return;
        }
    }

    public static final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getParamWithActivityWillFinish");
        return UriProtector.parse(r10).getBooleanQueryParameter("android_activity_will_finish", false);
    L5:
        return false;
    }

    public static void c(final Context r10, final boolean r11, final Function2 r12, final Function2 r13) {
        Intrinsics.checkNotNullParameter(r10, "$this$tryWaitValidActivityCreatedWithErrorMessage");
        Intrinsics.checkNotNullParameter(r12, "successCallback");
        boolean r14 = true;
        final boolean r15 = false;
        Context r16 = null;
        if (com.bytedance.android.ec.core.abtest.d.j() == false) goto L24;
        Intrinsics.checkNotNullParameter(r10, "$this$tryWaitValidActivityCreatedWithErrorMessageV2");
        Intrinsics.checkNotNullParameter(r12, "successCallback");
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r11 == true) goto L7;
        r14 = false;
    L7:
        final Activity r1 = r0.c(r10, r14);
        Lazy r17 = CommonLog.a;
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$1(r11, r15));
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$2(r10, r1));
        if (r1 != null) goto L23;
        boolean r18 = r10 instanceof Activity;
        if (r18 == false) goto L20;
        Activity r19 = (Activity) r10;
        if (r0.b(r19) == true) goto L20;
        Context r20 = r19.getApplicationContext();
        if ((r20 instanceof Application) == false) goto L17;
        r16 = r20;
    L17:
        final Application r21 = (Application) r16;
        com.bytedance.android.ec.sdk.helper.p.a.c(r19);
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$3.INSTANCE);
        final boolean r22 = r19.isTaskRoot();
        if (r21 == null) goto L50;
        r21.registerActivityLifecycleCallbacks(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$4(r21, r12, r22));
        return;
    L50:
        return;
    L20:
        if (r18 == true) goto L22;
        r13.invoke("context is not Activity V2: ".concat(r10.getClass().getName()), "activityWillFinish:" + r11 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$$inlined$also$lambda$1(r10, r13, r11, r15));
        return;
    L22:
        r13.invoke("context is HostMainPage V2: ".concat(r10.getClass().getName()), "activityWillFinish:" + r11 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$$inlined$also$lambda$2(r10, r13, r11, r15));
        return;
    L23:
        r12.invoke(r1, "");
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessageV2$6.INSTANCE);
        return;
    L24:
        ECAppInfoService r23 = ECAppInfoService.e;
        if (r11 == true) goto L27;
        r14 = false;
    L27:
        Activity r24 = r23.c(r10, r14);
        Lazy r25 = CommonLog.a;
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$1(r11, r15));
        if (r24 != null) goto L48;
        boolean r26 = r10 instanceof Activity;
        if (r26 == false) goto L42;
        Activity r27 = (Activity) r10;
        if (r27.isTaskRoot() == false) goto L42;
        if (r23.b(r27) == true) goto L42;
        Context r28 = r27.getApplicationContext();
        if ((r28 instanceof Application) == false) goto L39;
        r16 = r28;
    L39:
        final Application r29 = (Application) r16;
        com.bytedance.android.ec.sdk.helper.p.a.c(r27);
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$2.INSTANCE);
        if (r29 == null) goto L55;
        r29.registerActivityLifecycleCallbacks(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$3(r29, r12));
        return;
    L55:
        return;
    L42:
        if (r26 == true) goto L45;
        r13.invoke("context is not Activity: ".concat(r10.getClass().getName()), "activityWillFinish:" + r11 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$1(r10, r13, r11, r15));
        return;
    L45:
        if (((Activity) r10).isTaskRoot() == true) goto L47;
        r13.invoke("context is not in TaskRoot: ".concat(r10.getClass().getName()), "activityWillFinish:" + r11 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$2(r10, r13, r11, r15));
        return;
    L47:
        r13.invoke("context is HostMainPage: ".concat(r10.getClass().getName()), "activityWillFinish:" + r11 + ", activityWillFinishInUrlParam:false");
        CommonLog.a(new CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$$inlined$also$lambda$3(r10, r13, r11, r15));
        return;
    L48:
        r12.invoke(r24, "");
        CommonLog.a(CheckValidBeforeActivityLauncherHelperKt$tryWaitValidActivityCreatedWithErrorMessage$5.INSTANCE);
    }

    public static final void b(Context r10, boolean r11, String r12, Function1<? super Activity, Unit> r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r10, "$this$tryWaitValidActivityCreated");
        Intrinsics.checkNotNullParameter(r13, "successCallback");
        Intrinsics.checkNotNullParameter(r14, "errorCallback");
        boolean r0 = false;
        if (r12 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        ECAppInfoService r16 = ECAppInfoService.e;
        if (r11 == true) goto L11;
        if (r15 == true) goto L11;
    L12:
        Activity r17 = r16.c(r10, r0);
        if (r17 == null) goto L15;
        r13.invoke(r17);
        return;
    L15:
        if ((r10 instanceof Activity) == false) goto L26;
        Activity r18 = (Activity) r10;
        if (r18.isTaskRoot() == false) goto L26;
        if (r16.b(r18) == true) goto L26;
        Context r19 = r18.getApplicationContext();
        if ((r19 instanceof Application) == true) goto L23;
        r19 = null;
    L23:
        Application r20 = (Application) r19;
        com.bytedance.android.ec.sdk.helper.p.a.c(r18);
        if (r20 == null) goto L29;
        r20.registerActivityLifecycleCallbacks(new a(r20, r13));
        return;
    L29:
        return;
    L26:
        r14.invoke();
        return;
    L11:
        r0 = true;
        goto L12
    L5:
        if (a(r12) != true) goto L7;
        r15 = true;
        goto L8
    }
}
