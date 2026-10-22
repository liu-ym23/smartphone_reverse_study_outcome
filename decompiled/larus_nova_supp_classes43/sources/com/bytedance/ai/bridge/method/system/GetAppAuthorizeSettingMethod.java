package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.system.setting.AbsGetAppAuthorizeSettingMethodIDL;
import com.bytedance.ai.utils.g;
import e3.e;
import f3.h;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetAppAuthorizeSettingMethod;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL$GetAppAuthorizeSettingResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/setting/AbsGetAppAuthorizeSettingMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppAuthorizeSettingMethod extends AbsGetAppAuthorizeSettingMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetAppAuthorizeSettingMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(e3.d r17, AbsGetAppAuthorizeSettingMethodIDL.a r18) {
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r18, "params");
        Context r0 = e.b(r17);
        if (r0 == null) goto L5;
        f4.b r1 = f4.b.a;
        Context r10 = r0.getApplicationContext();
        r1.getClass();
        String r11 = "full";
        String r12 = "authorized";
        Intrinsics.checkNotNullParameter(r10, "context");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L16
        if (Build.VERSION.SDK_INT < 33) goto L10;
        PackageInfo r14 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), PackageManager.PackageInfoFlags.of(4096));     // Catch: Throwable -> L16
    L11:
        String[] r15 = r14.requestedPermissions;     // Catch: Throwable -> L16
        if (r15 != null) goto L14;
        r15 = new String[0];     // Catch: Throwable -> L16
    L14:
        Object r16 = Result.constructor-impl(ArraysKt.toSet(r15));     // Catch: Throwable -> L16
    L18:
        Set r19 = SetsKt.emptySet();
        if (Result.isFailure-impl(r16) == false) goto L21;
        r16 = r19;
    L21:
        Set r20 = (Set) r16;
        f4.b.a.getClass();     // Catch: Throwable -> L24
        Object r21 = Result.constructor-impl(f4.b.c(r10, r20));     // Catch: Throwable -> L24
    L26:
        f4.c r22 = new f4.c("denied", null);
        if (Result.isFailure-impl(r21) == false) goto L29;
        r21 = r22;
    L29:
        f4.c r23 = (f4.c) r21;
        f4.b.a.getClass();     // Catch: Throwable -> L32
        Object r24 = Result.constructor-impl(f4.b.b(r10, r20, "android.permission.CAMERA"));     // Catch: Throwable -> L32
    L34:
        f4.c r110 = new f4.c("denied", null);
        if (Result.isFailure-impl(r24) == false) goto L37;
        r24 = r110;
    L37:
        f4.c r111 = (f4.c) r24;
        f4.b.a.getClass();     // Catch: Throwable -> L40
        Object r25 = Result.constructor-impl(f4.b.e(r10, r20));     // Catch: Throwable -> L40
    L42:
        f4.c r112 = new f4.c("denied", null);
        if (Result.isFailure-impl(r25) == false) goto L45;
        r25 = r112;
    L45:
        f4.c r113 = (f4.c) r25;
        f4.b.a.getClass();     // Catch: Throwable -> L48
        Object r26 = Result.constructor-impl(f4.b.b(r10, r20, "android.permission.RECORD_AUDIO"));     // Catch: Throwable -> L48
    L50:
        f4.c r114 = new f4.c("denied", null);
        if (Result.isFailure-impl(r26) == false) goto L53;
        r26 = r114;
    L53:
        f4.c r115 = (f4.c) r26;
        f4.b.a.getClass();     // Catch: Throwable -> L77
        boolean r27 = NotificationManagerCompat.from(r10).areNotificationsEnabled();     // Catch: Throwable -> L77
        int r116 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L77
        boolean r117 = true;
        if (r116 >= 33) goto L57;
    L60:
        boolean r118 = true;
    L61:
        if (r27 == false) goto L64;
        if (r118 == false) goto L64;
    L65:
        if (r117 == false) goto L67;
        String r28 = "authorized";
    L68:
        if (r116 >= 33) goto L70;
    L72:
        if (r117 == false) goto L74;
        String r29 = "full";
    L75:
        Object r30 = Result.constructor-impl(new f4.c(r28, r29));     // Catch: Throwable -> L77
    L79:
        f4.c r31 = new f4.c("denied", null);
        if (Result.isFailure-impl(r30) == false) goto L82;
        r30 = r31;
    L82:
        f4.c r32 = (f4.c) r30;
        f4.b.a.getClass();     // Catch: Throwable -> L101
        boolean r119 = r20.contains("android.permission.READ_CALENDAR");     // Catch: Throwable -> L101
        boolean r120 = r20.contains("android.permission.WRITE_CALENDAR");     // Catch: Throwable -> L101
        boolean r33 = f4.b.d(r10, "android.permission.READ_CALENDAR");     // Catch: Throwable -> L101
        boolean r121 = f4.b.d(r10, "android.permission.WRITE_CALENDAR");     // Catch: Throwable -> L101
        if (r33 == false) goto L87;
        if (r121 == false) goto L87;
    L88:
        if (r119 == true) goto L91;
        if (r120 == true) goto L91;
        r11 = null;
    L99:
        Object r34 = Result.constructor-impl(new f4.c(r12, r11));     // Catch: Throwable -> L101
    L103:
        f4.c r35 = new f4.c("denied", null);
        if (Result.isFailure-impl(r34) == false) goto L106;
        r34 = r35;
    L106:
        f4.c r36 = (f4.c) r34;
        String r37 = r23.a;
        String r38 = r111.a;
        String r122 = r113.a;
        String r123 = r115.a;
        String r124 = r32.a;
        String r39 = r36.a;
        f4.b.a.getClass();     // Catch: Throwable -> L109
        Object r40 = Result.constructor-impl(f4.b.a(r10, r20));     // Catch: Throwable -> L109
    L112:
        if (Result.isFailure-impl(r40) == false) goto L114;
        r40 = null;
    L114:
        String r41 = r23.b;
        String r42 = r111.b;
        String r43 = r113.b;
        String r125 = r115.b;
        String r44 = r32.b;
        String r45 = r36.b;
        Intrinsics.checkNotNullParameter("not determined", "albumAuthorized");
        Intrinsics.checkNotNullParameter(r37, "bluetoothAuthorized");
        Intrinsics.checkNotNullParameter(r38, "cameraAuthorized");
        Intrinsics.checkNotNullParameter(r122, "locationAuthorized");
        Intrinsics.checkNotNullParameter(r123, "microphoneAuthorized");
        Intrinsics.checkNotNullParameter(r124, "notificationAuthorized");
        Intrinsics.checkNotNullParameter("not determined", "notificationAlertAuthorized");
        Intrinsics.checkNotNullParameter("not determined", "notificationBadgeAuthorized");
        Intrinsics.checkNotNullParameter("not determined", "notificationSoundAuthorized");
        Intrinsics.checkNotNullParameter(r39, "phoneCalendarAuthorized");
        g.a.i("GetAppAuthorizeSetting", "buildResult, notification=" + r124 + ", alert=not determined, badge=not determined, sound=not determined");
        Intrinsics.checkNotNullParameter(AbsGetAppAuthorizeSettingMethodIDL.b.class, "<this>");
        BaseModel r46 = k3.c.a(AbsGetAppAuthorizeSettingMethodIDL.b.class);
        AbsGetAppAuthorizeSettingMethodIDL.b r47 = (AbsGetAppAuthorizeSettingMethodIDL.b) r46;
        r47.setAlbumAuthorized("not determined");
        r47.setBluetoothAuthorized(r37);
        r47.setCameraAuthorized(r38);
        r47.setLocationAuthorized(r122);
        r47.setLocationReducedAccuracy(false);
        r47.setMicrophoneAuthorized(r123);
        r47.setNotificationAuthorized(r124);
        r47.setNotificationAlertAuthorized("not determined");
        r47.setNotificationBadgeAuthorized("not determined");
        r47.setNotificationSoundAuthorized("not determined");
        r47.setPhoneCalendarAuthorized(r39);
        r47.setAlbumAuthorizationDetail((String) r40);
        r47.setBluetoothAuthorizationDetail(r41);
        r47.setCameraAuthorizationDetail(r42);
        r47.setLocationAuthorizationDetail(r43);
        r47.setMicrophoneAuthorizationDetail(r125);
        r47.setNotificationAuthorizationDetail(r44);
        r47.setPhoneCalendarAuthorizationDetail(r45);
        return new com.bytedance.ai.bridge.core.a.c(r46);
    L109:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L91:
        if (r33 == false) goto L94;
        if (r121 == true) goto L99;
    L94:
        if (r33 == false) goto L96;
        r11 = "read only";
        goto L99
    L96:
        if (r121 == false) goto L98;
        r11 = "write only";
        goto L99
    L98:
        r11 = "denied";
    L87:
        r12 = "denied";
    L101:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r34 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L103
    L74:
        r29 = "denied";
        goto L75
    L70:
        if (r20.contains("android.permission.POST_NOTIFICATIONS") == true) goto L72;
        r29 = null;
        goto L75
    L67:
        r28 = "denied";
    L64:
        r117 = false;
        goto L65
    L57:
        if (f4.b.d(r10, "android.permission.POST_NOTIFICATIONS") == true) goto L60;
        r118 = false;
    L77:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L48:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L40:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L10:
        r14 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 4096);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L5:
        return new com.bytedance.ai.bridge.core.a.b(0, "context is null", null, null, 29);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r1, ParamModel r10) {
        return b(r1, (AbsGetAppAuthorizeSettingMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsGetAppAuthorizeSettingMethodIDL.a r13 = (AbsGetAppAuthorizeSettingMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
