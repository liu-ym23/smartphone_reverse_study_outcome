package com.obric.assistant.permission;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.security.privacypermission.ObricPrivacyAndPermissionUiDelegate;
import com.obric.assistant.utils.IObricAssistantUtilHelperService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt;
import mfa.a;
import mfa.c;
import mfa.d;
import mfa.e;
import mfa.f;
import mfa.g;
import org.json.JSONObject;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J&\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016JG\u0010\u0019\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2%\u0010\u0017\u001a!\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001dj\u0002`!H\u0016JH\u0010\u0019\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016JP\u0010\u0019\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0017\u001a\u00020$2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\fH\u0016J}\u0010*\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2[\u0010\u0017\u001aW\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(,\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00050+j\u0002`.H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\fH\u0016J\u0010\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\nH\u0016J,\u00102\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u00010\n2\b\u00104\u001a\u0004\u0018\u000105H\u0016J<\u00106\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0017\u001a\u00020$H\u0016J\u001a\u00107\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0016J(\u00107\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u00104\u001a\u0004\u0018\u00010$H\u0016J\u0010\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\fH\u0016J\u001e\u0010;\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010=\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020\fH\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\f2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\u0002J\u001a\u0010D\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0002J\u001a\u0010E\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u00104\u001a\u0004\u0018\u00010$H\u0002J0\u0010F\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\t2\b\u00104\u001a\u0004\u0018\u00010$2\u0006\u0010I\u001a\u00020\nH\u0002J<\u0010)\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\n2\u0016\b\u0002\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010&2\n\b\u0002\u00104\u001a\u0004\u0018\u00010KH\u0002¨\u0006M"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionServiceImpl;", "Lcom/obric/assistant/permission/IObricPermissionService;", "<init>", "()V", "batchPermissionRequest", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "manifest", "", "", "needShowGrantedPermission", "", "showIcon", "fallbackToSingleRequestWhenNoResolveInfo", "forceRuntimeRequestOnFallback", "requestDataCallBack", "Lcom/obric/assistant/permission/IObricPermissionService$IObricRequestPermissionCallback;", "isSystemResolveInfo", "resolveInfo", "Landroid/content/pm/ResolveInfo;", "isGenesisRProduct", "tryRequestCombinePermissionByMiui", "requestCallBack", "checkPermission", "permission", "checkAlbumPermission", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "isOEMSupportAppListPermission", "Lkotlin/Function1;", "Lkotlin/ParameterName;", DBDefinition.NAME, "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", "fragment", "Landroidx/fragment/app/Fragment;", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "subTitleMap", "", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "requestNotificationPermission", "isLaunching", "hasPermissionRequest", "showGoSettingPageDialog", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "permissionAny", "goPermissionSettings", "permissions", "setInterceptGoToSettingsDialog", "intercept", "shouldShowRequestPermissionListRationale", "manifests", "getDescriptionByPermission", "hasAllFilesAccessPermission", "isPartAlbumAccess", "context", "Landroid/content/Context;", "isFullAlbumAccess", "getPermissionName", "openCommonAppPermissionPage", "openFileAccessPermissionPage", "openPermissionSettingsByCandidates", "intentCandidates", "Landroid/content/Intent;", "scene", "fragmentActivity", "Lcom/larus/permission/api/IPermissionX$IRequestPermissionCallback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IObricPermissionServiceImpl implements IObricPermissionService {
    public static final /* synthetic */ int b = 0;

    static {
    }

    public IObricPermissionServiceImpl() {
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void c() {
        ObricPrivacyAndPermissionUiDelegate.b.c();
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final IObricPermissionService.Companion.ObricPermissionStatus h() {
        AppHost.Companion r0 = AppHost.a;
        r0.getApplication();
        int r1 = Build.VERSION.SDK_INT;
        boolean r5 = true;
        if (r1 >= 33) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L27;
        r0.getApplication();
        if (r1 < 34) goto L22;
        boolean r3 = checkPermission("android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
        boolean r4 = checkPermission("android.permission.READ_MEDIA_IMAGES");
        if (checkPermission("android.permission.READ_MEDIA_VIDEO") == false) goto L18;
        if (r4 == false) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L22;
        if (r3 == false) goto L22;
    L23:
        if (r5 == false) goto L26;
        return IObricPermissionService.Companion.ObricPermissionStatus.LIMITED_GRANTED;
    L26:
        return IObricPermissionService.Companion.ObricPermissionStatus.DENIED;
    L18:
        r6 = false;
    L22:
        r5 = false;
        goto L23
    L27:
        return IObricPermissionService.Companion.ObricPermissionStatus.GRANTED;
    L5:
        if (checkPermission("android.permission.READ_MEDIA_IMAGES") == false) goto L9;
        if (checkPermission("android.permission.READ_MEDIA_VIDEO") == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final boolean o() {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        boolean r4 = false;
        if (Settings.Secure.getInt(AppHost.a.getApplication().getContentResolver(), "oem_installed_apps_runtime_permission_enable", 0) != 1) goto L6;
        r4 = true;
    L6:
        FLogger.a.w("IObricPermissionServiceImpl", "isOEMSupportAppListPermission ret: " + r4);     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.exceptionOrNull-impl(r1);
        if (r3 == null) goto L13;
        FLogger.a.w("IObricPermissionServiceImpl", "isOEMSupportAppListPermission failed: " + r3.getMessage(), r3);
    L13:
        Boolean r0 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L17;
        r1 = r0;
    L17:
        return ((Boolean) r1).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static String p(String r2) {
        switch(r2.hashCode()) {
            case -2062386608: goto L78;
            case -1928411001: goto L74;
            case -1925850455: goto L70;
            case -1921431796: goto L66;
            case -1888586689: goto L62;
            case -1813079487: goto L58;
            case -1446288141: goto L54;
            case -1142799244: goto L50;
            case -909527021: goto L46;
            case -798669607: goto L43;
            case -63024214: goto L39;
            case 175802396: goto L36;
            case 603653886: goto L32;
            case 710297143: goto L28;
            case 1166454870: goto L25;
            case 1780337063: goto L21;
            case 1831139720: goto L17;
            case 1977429404: goto L13;
            case 2024715147: goto L9;
            case 2062356686: goto L6;
            default: goto L81;
        };
    L81:
        return "";
    L6:
        if (r2.equals("android.permission.BLUETOOTH_SCAN") == false) goto L81;
    L48:
        String r3 = AppHost.a.getApplication().getString(2131912120);
        Intrinsics.checkNotNull(r3);
        return r3;
    L9:
        if (r2.equals("android.permission.ACCESS_BACKGROUND_LOCATION") == false) goto L81;
        String r4 = AppHost.a.getApplication().getString(2131912122);
        Intrinsics.checkNotNull(r4);
        return r4;
    L13:
        if (r2.equals("android.permission.READ_CONTACTS") == false) goto L81;
        String r5 = AppHost.a.getApplication().getString(2131912135);
        Intrinsics.checkNotNull(r5);
        return r5;
    L17:
        if (r2.equals("android.permission.RECORD_AUDIO") == false) goto L81;
        String r6 = AppHost.a.getApplication().getString(2131912143);
        Intrinsics.checkNotNull(r6);
        return r6;
    L21:
        if (r2.equals("android.permission.ACTIVITY_RECOGNITION") == false) goto L81;
        String r7 = AppHost.a.getApplication().getString(2131912121);
        Intrinsics.checkNotNull(r7);
        return r7;
    L25:
        if (r2.equals("android.permission.BLUETOOTH_ADVERTISE") == true) goto L48;
    L28:
        if (r2.equals("android.permission.READ_MEDIA_VIDEO") == false) goto L81;
        String r8 = AppHost.a.getApplication().getString(2131912131);
        Intrinsics.checkNotNull(r8);
        return r8;
    L32:
        if (r2.equals("android.permission.WRITE_CALENDAR") == false) goto L81;
        String r9 = AppHost.a.getApplication().getString(2131912175);
        Intrinsics.checkNotNull(r9);
        return r9;
    L36:
        if (r2.equals("android.permission.READ_MEDIA_IMAGES") == false) goto L81;
    L52:
        String r10 = AppHost.a.getApplication().getString(2131912130);
        Intrinsics.checkNotNull(r10);
        return r10;
    L39:
        if (r2.equals("android.permission.ACCESS_COARSE_LOCATION") == false) goto L81;
        String r11 = AppHost.a.getApplication().getString(2131912122);
        Intrinsics.checkNotNull(r11);
        return r11;
    L43:
        if (r2.equals("android.permission.BLUETOOTH_CONNECT") == true) goto L48;
    L46:
        if (r2.equals("android.permission.NEARBY_WIFI_DEVICES") == true) goto L48;
    L50:
        if (r2.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == true) goto L52;
    L54:
        if (r2.equals("com.android.permission.GET_INSTALLED_APPS") == false) goto L81;
        String r12 = AppHost.a.getApplication().getString(2131912142);
        Intrinsics.checkNotNull(r12);
        return r12;
    L58:
        if (r2.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L81;
        String r13 = AppHost.a.getApplication().getString(2131912136);
        Intrinsics.checkNotNull(r13);
        return r13;
    L62:
        if (r2.equals("android.permission.ACCESS_FINE_LOCATION") == false) goto L81;
        String r14 = AppHost.a.getApplication().getString(2131912122);
        Intrinsics.checkNotNull(r14);
        return r14;
    L66:
        if (r2.equals("android.permission.READ_CALL_LOG") == false) goto L81;
        String r15 = AppHost.a.getApplication().getString(2131912179);
        Intrinsics.checkNotNull(r15);
        return r15;
    L70:
        if (r2.equals("android.permission.POST_NOTIFICATIONS") == false) goto L81;
        String r16 = AppHost.a.getApplication().getString(2131912141);
        Intrinsics.checkNotNull(r16);
        return r16;
    L74:
        if (r2.equals("android.permission.READ_CALENDAR") == false) goto L81;
        String r17 = AppHost.a.getApplication().getString(2131912144);
        Intrinsics.checkNotNull(r17);
        return r17;
    L78:
        if (r2.equals("android.permission.READ_SMS") == false) goto L81;
        String r18 = AppHost.a.getApplication().getString(2131912180);
        Intrinsics.checkNotNull(r18);
        return r18;
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final boolean checkPermission(String r5) {
        Intrinsics.checkNotNullParameter(r5, "permission");
        if (Intrinsics.areEqual(r5, "android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L19;
        if (Build.VERSION.SDK_INT >= 30) goto L23;
        AppHost.Companion r6 = AppHost.a;
        if (ContextCompat.checkSelfPermission(r6.getApplication(), "android.permission.READ_EXTERNAL_STORAGE") != 0) goto L10;
        boolean r0 = true;
    L12:
        if (ContextCompat.checkSelfPermission(r6.getApplication(), "android.permission.WRITE_EXTERNAL_STORAGE") != 0) goto L14;
        boolean r7 = true;
    L15:
        if (r0 == false) goto L21;
        if (r7 == false) goto L21;
        return true;
    L21:
        return false;
    L14:
        r7 = false;
        goto L15
    L10:
        r0 = false;
        goto L12
    L23:
        return Environment.isExternalStorageManager();
    L19:
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r5) != 0) goto L21;
        return true;
    }

    public final boolean d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        return i2.b.d(r2);
    }

    public final void f(boolean r2) {
        i2.b.f(r2);
    }

    public static void q(FragmentActivity r6, g1.c r7) {
        String r0 = AppHost.a.getApplication().getPackageName();
        ArrayList r1 = new ArrayList();
        if (b.a().b() == false) goto L5;
    L7:
        Intent r2 = new Intent("android.intent.action.MANAGE_APP_PERMISSIONS");
        r2.putExtra("android.intent.extra.PACKAGE_NAME", r0);
        r1.add(r2);
        r(r6, r1, r7, "openCommonAppPermissionPage");
        return;
    L5:
        if (StringsKt.equals(Build.MANUFACTURER, "Xiaomi", true) == false) goto L7;
        Intent r3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        r3.putExtra("extra_pkgname", r0);
        r3.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity"));
        r1.add(r3);
        goto L7
    }

    public final void i(FragmentActivity r2, g1.c r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        i2.b.i(r2, r3);
    }

    public final void a(FragmentActivity r2, List<String> r3, Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        i2.b.a(r2, r3, r4);
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void e(FragmentActivity r6, List<String> r7, g1.c r8) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "permissions");
        FLogger.a.i("IObricPermissionServiceImpl", "goPermissionSettings with custom landing, permissions: " + r7);
        if (r7.contains("android.permission.MANAGE_EXTERNAL_STORAGE") == true) goto L5;
        q(r6, r8);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        q(r6, r8);
        return;
    L7:
        String r9 = AppHost.a.getApplication().getPackageName();
        ArrayList r0 = new ArrayList();
        Intent r1 = new Intent();
        r1.setComponent(new ComponentName("com.android.permissioncontroller", "com.android.permissioncontroller.permissionplus.ui.AppAllPermissionsActivity"));
        r1.putExtra("PACKAGE_NAME", r9);
        r0.add(r1);
        Intent r2 = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        r2.setData(UriProtector.parse("package:" + r9));
        r0.add(r2);
        r0.add(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"));
        if (r(r6, r0, r8, "openFileAccessPermissionPage") == true) goto L13;
        q(r6, r8);
        return;
    }

    public final void m(FragmentActivity r2, List<String> r3, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        i2.b.m(r2, r3, r4);
    }

    public static boolean r(FragmentActivity r8, List r9, g1.c r10, String r11) {
        IObricAssistantUtilHelperService r0 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r0 != null) goto L8;
        FLogger.a.w("IObricPermissionServiceImpl", r11.concat(" helper service is null"));
        if (r10 == null) goto L7;
        r10.onSettingPageReturn();
    L7:
        return false;
    L8:
        PackageManager r12 = r8.getPackageManager();
        Iterator r13 = r9.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        Intent r3 = (Intent) r13.next();
        List<ResolveInfo> r4 = r12.queryIntentActivities(r3, 65536);
        FLogger.a.i("IObricPermissionServiceImpl", r11 + " intent: " + r3 + ", resolveListEmpty: " + r4.isEmpty());
        if ((!r4.isEmpty()) == false) goto L10;
        r0.startActivityForResult(r3, new c(r10), new d(r10));
        return true;
    L15:
        if (r10 == null) goto L17;
        r10.onSettingPageReturn();
    L17:
        return false;
    }

    public final void b(Fragment r1, List<String> r2, Function1<? super Boolean, Unit> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
    }

    public final void l(FragmentActivity r7, String r8, String r9, g1.b r10) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "permission");
        boolean r0 = false;
        if (r9 == null) goto L5;
        MapsKt.mutableMapOf(new Pair[]{new Pair(r8, r9)});
    L5:
        d r11 = new d(r10);
        switch(r8.hashCode()) {
            case -2062386608: goto L35;
            case -1928411001: goto L31;
            case -1921431796: goto L27;
            case -1813079487: goto L23;
            case -1142799244: goto L19;
            case 175802396: goto L16;
            case 710297143: goto L13;
            case 1977429404: goto L9;
            default: goto L38;
        };
    L38:
        String r12 = "";
    L39:
        String r13 = p(r8);
        String r2 = r7.getString(2131907442);
        String r3 = r7.getString(2131907441);
        if (r12.length() != 0) goto L42;
        boolean r4 = true;
    L43:
        if (r4 == true) goto L45;
    L49:
        Ref$BooleanRef r1 = new Ref$BooleanRef();
        CommonDialog.a r5 = new CommonDialog.a();
        Intrinsics.checkNotNullParameter(r12, DBDefinition.TITLE);
        r5.a = r12;
        r5.g(r13);
        CommonDialog.a.e(r5, new e(), r3, 4);
        CommonDialog.a.f(r5, new f(r1, r7, r11), r2, true, 8);
        g r14 = new g(r11, r1);
        Intrinsics.checkNotNullParameter(r14, "listener");
        r5.x = r14;
        CommonDialog r15 = r5.b(ContextCompat.getColor(r7, 2131103203));
        if (r7.getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L60;
        FragmentManager r16 = r7.getSupportFragmentManager();
        LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r15, "PermissionXGoSettingDialog", r17);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r15, r17) == true) goto L62;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L57
    L55:
        r15.show(r16, "PermissionXGoSettingDialog");
        return;
    L62:
        return;
    L60:
        return;
    L45:
        if (r13.length() != 0) goto L47;
        r0 = true;
    L47:
        if (r0 == false) goto L49;
        return;
    L42:
        r4 = false;
        goto L43
    L9:
        if (r8.equals("android.permission.READ_CONTACTS") == false) goto L38;
        r12 = AppHost.a.getApplication().getString(2131912126);
        Intrinsics.checkNotNull(r12);
        goto L39
    L13:
        if (r8.equals("android.permission.READ_MEDIA_VIDEO") == false) goto L38;
    L21:
        r12 = AppHost.a.getApplication().getString(2131912123);
        Intrinsics.checkNotNull(r12);
        goto L39
    L16:
        if (r8.equals("android.permission.READ_MEDIA_IMAGES") == true) goto L21;
    L19:
        if (r8.equals("android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == true) goto L21;
    L23:
        if (r8.equals("android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L38;
        r12 = AppHost.a.getApplication().getString(2131912127);
        Intrinsics.checkNotNull(r12);
        goto L39
    L27:
        if (r8.equals("android.permission.READ_CALL_LOG") == false) goto L38;
        r12 = AppHost.a.getApplication().getString(2131912125);
        Intrinsics.checkNotNull(r12);
        goto L39
    L31:
        if (r8.equals("android.permission.READ_CALENDAR") == false) goto L38;
        r12 = AppHost.a.getApplication().getString(2131912124);
        Intrinsics.checkNotNull(r12);
        goto L39
    L35:
        if (r8.equals("android.permission.READ_SMS") == false) goto L38;
        r12 = AppHost.a.getApplication().getString(2131912128);
        Intrinsics.checkNotNull(r12);
        goto L39
    }

    public final void j(Fragment r8, FragmentActivity r9, List<String> r10, JSONObject r11, g1.c r12) {
        Intrinsics.checkNotNullParameter(r10, "manifest");
        Intrinsics.checkNotNullParameter(r12, "requestCallBack");
        i2.b.j(r8, r9, r10, r11, r12);
    }

    public final void k(Fragment r8, List<String> r9, g1.c r10, Map<String, String> r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r9, "manifest");
        Intrinsics.checkNotNullParameter(r10, "requestCallBack");
        i2.b.k(r8, r9, r10, r11, r12);
    }

    public final void g(FragmentActivity r9, List<String> r10, g1.c r11, Map<String, String> r12, JSONObject r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "manifest");
        Intrinsics.checkNotNullParameter(r11, "requestCallBack");
        i2.b.g(r9, r10, r11, r12, r13, r14);
    }

    @Override // com.obric.assistant.permission.IObricPermissionService
    public final void n(FragmentActivity r17, List<String> r18, boolean r19, boolean r20, boolean r21, boolean r22, IObricPermissionService.a r23) {
        Intrinsics.checkNotNullParameter(r18, "manifest");
        Intrinsics.checkNotNullParameter(r23, "requestDataCallBack");
        if (r17 != null) goto L103;
        return;
    L103:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L8
        String r8 = b.a().d();     // Catch: Throwable -> L8
        FLogger.a.i("IObricPermissionServiceImpl", "isGenesisRProduct " + r8);     // Catch: Throwable -> L8
        Object r0 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(r8, "Genesis-R")));     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.exceptionOrNull-impl(r0);
        if (r9 == null) goto L13;
        FLogger.a.w("IObricPermissionServiceImpl", "isGenesisRProduct failed: " + r9.getMessage(), r9);
    L13:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r0) == false) goto L16;
        r0 = r10;
    L16:
        boolean r11 = true;
        if (((Boolean) r0).booleanValue() == true) goto L105;
        ResolveInfo r1 = r17.getPackageManager().resolveActivity(new Intent("com.android.permissioncontroller.action.BATCH_PERMISSION_GRANT"), 65536);
        FLogger r12 = FLogger.a;
        r12.i("IObricPermissionServiceImpl", "checkResolveInfo, " + r1);
        if (r1 == null) goto L82;
        ActivityInfo r13 = r1.activityInfo;
        if (r13 == null) goto L74;
        ApplicationInfo r14 = r13.applicationInfo;
        if (r14 == null) goto L74;
        if ((r14.flags & 129) == 0) goto L72;
        boolean r15 = true;
    L73:
        r12.i("IObricPermissionServiceImpl", "isSystemResolveInfo pkg=" + r14.packageName + ", isSystem=" + r15);
    L75:
        if (r15 == false) goto L82;
        ActivityInfo r2 = r1.activityInfo;
        String[] r3 = (String[]) CollectionsKt.distinct(r18).toArray(new String[0]);
        ArrayList r4 = new ArrayList(r3.length);
        int r5 = r3.length;
        int r6 = 0;
    L77:
        if (r6 >= r5) goto L79;
        r4.add(p(r3[r6]));
        r6 = r6 + 1;
        goto L77
    L79:
        String[] r16 = (String[]) r4.toArray(new String[0]);
        Intent r24 = new Intent("com.android.permissioncontroller.action.BATCH_PERMISSION_GRANT");
        r24.setComponent(new ComponentName(r2.packageName, r2.name));
        r24.putExtra("com.android.permissioncontroller.extra.PERMISSION_LIST", r3);
        r24.putExtra("com.android.permissioncontroller.extra.PERMISSION_DESCRIPTIONS", r16);
        r24.putExtra("com.android.permissioncontroller.extra.SHOW_GRANTED_PERMISSIONS", r19);
        r24.putExtra("com.android.permissioncontroller.extra.SHOW_ICON", r20);
        IObricAssistantUtilHelperService r25 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r25 == null) goto L116;
        r25.startActivityForResult(r24, new a(r24, r23), null);
        return;
    L116:
        return;
    L72:
        r15 = false;
    L74:
        r15 = false;
    L82:
        if (r21 == true) goto L85;
        r12.w("IObricPermissionServiceImpl", "not support batch request permission, skip");
        r23.a(true, false, new ArrayList(), new ArrayList());
        return;
    L85:
        List<String> r26 = CollectionsKt.distinct(r18);
        List<String> r27 = r26;
        if ((r27 instanceof Collection) == true) goto L88;
    L90:
        Iterator<T> r28 = r27.iterator();
    L92:
        if (r28.hasNext() == false) goto L96;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r17, (String) r28.next()) == true) goto L92;
        r11 = false;
    L96:
        FLogger.a.w("IObricPermissionServiceImpl", "not support batch request permission, fallback to single request, shouldShowRequest: " + r11 + ", forceRuntimeRequestOnFallback: " + r22);
        if (r11 == true) goto L101;
        if (r22 == true) goto L101;
        e(r17, r26, new c(r26, r23, this));
        return;
    L101:
        i2 r29 = i2.b;
        g1.a.b(r17, r26, new b(r23), null, null, 24);
        return;
    L88:
        if (r27.isEmpty() == false) goto L90;
    L105:
        ApplicationInfo r110 = r17.getPackageManager().getApplicationInfo("com.miui.securitycenter", 128);     // Catch: Throwable -> L29
        Bundle r111 = r110.metaData;     // Catch: Throwable -> L29
        if (r111 == null) goto L22;
        int r112 = r111.getInt("combine_permission_version");     // Catch: Throwable -> L29
    L23:
        FLogger r113 = FLogger.a;     // Catch: Throwable -> L29
        r113.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui appInfo: " + r110);     // Catch: Throwable -> L29
        r113.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui appInfo.metadata: " + r110.metaData);     // Catch: Throwable -> L29
        r113.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui combinePermissionVersion: " + r112);     // Catch: Throwable -> L29
        Bundle r30 = r110.metaData;     // Catch: Throwable -> L29
        if (r30 == null) goto L26;
        boolean r31 = r30.getBoolean("supportCombinePermission", false);     // Catch: Throwable -> L29
    L27:
        Object r32 = Result.constructor-impl(Boolean.valueOf(r31));     // Catch: Throwable -> L29
    L31:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L34;
        FLogger.a.w("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui get meta failed: " + r33.getMessage(), r33);
    L34:
        Boolean r34 = Boolean.FALSE;
        if (Result.isFailure-impl(r32) == false) goto L38;
        r32 = r34;
    L38:
        if (((Boolean) r32).booleanValue() == true) goto L40;
        FLogger.a.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui not supported");
        r23.a(true, false, new ArrayList(), new ArrayList());
        return;
    L40:
        String[] r35 = (String[]) CollectionsKt.distinct(r18).toArray(new String[0]);
        ArrayList r36 = new ArrayList(r35.length);
        int r37 = r35.length;
        int r114 = 0;
    L41:
        if (r114 >= r37) goto L43;
        r36.add(p(r35[r114]));
        r114 = r114 + 1;
        goto L41
    L43:
        String[] r38 = (String[]) r36.toArray(new String[0]);
        Intent r39 = new Intent("miui.intent.action.REQUEST_PERMISSIONS_COMBINE");
        r39.setPackage("com.miui.securitycenter");
        r39.putExtra("miui.intent.extra.PERMISSIONS_DIALOG_DESC", "");
        r39.putExtra("miui.intent.extra.REQUEST_PERMISSIONS_NAMES", r35);
        r39.putExtra("miui.intent.extra.REQUEST_PERMISSIONS_NAMES_DESC", r38);
        r39.putExtra("miui.intent.extra.PERMISSION_FORCE_SHOW", true);
        ResolveInfo r40 = r17.getPackageManager().resolveActivity(r39, 65536);
        if (r40 != null) goto L46;
        FLogger.a.i("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui resolveActivity null");
        r23.a(true, false, new ArrayList(), new ArrayList());
        return;
    L46:
        ActivityInfo r41 = r40.activityInfo;
        if (r41 == null) goto L49;
        String r42 = r41.packageName;
    L51:
        if (Intrinsics.areEqual(r42, "com.miui.securitycenter") == true) goto L57;
        FLogger r43 = FLogger.a;
        StringBuilder r44 = new StringBuilder("tryRequestCombinePermissionByMiui resolveActivity not security center: ");
        ActivityInfo r45 = r40.activityInfo;
        if (r45 == null) goto L55;
        String r46 = r45.packageName;
    L56:
        r44.append(r46);
        r43.w("IObricPermissionServiceImpl", r44.toString());
        r23.a(true, false, new ArrayList(), new ArrayList());
        return;
    L55:
        r46 = null;
        goto L56
    L57:
        IObricAssistantUtilHelperService r47 = (IObricAssistantUtilHelperService) ServiceManager.get().getService(IObricAssistantUtilHelperService.class);
        if (r47 != null) goto L60;
        FLogger.a.w("IObricPermissionServiceImpl", "tryRequestCombinePermissionByMiui helper service null");
        r23.a(true, false, new ArrayList(), new ArrayList());
        return;
    L60:
        FLogger.a.i("IObricPermissionServiceImpl", "miui combine permission, intent: " + r39.getExtras());
        r47.startActivityForResult(r39, new mfa.b(r23), null);
        return;
    L49:
        r42 = null;
        goto L51
    L26:
        r31 = false;
        goto L27
    L22:
        r112 = 0;
    L29:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
    L8:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
