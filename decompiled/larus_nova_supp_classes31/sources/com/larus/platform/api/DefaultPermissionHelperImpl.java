package com.larus.platform.api;

import android.app.Activity;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J=\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u000ej\u0002`\u0012H\u0016Js\u0010\u0013\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2[\u0010\r\u001aW\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\t0\u0014j\u0002`\u0017H\u0016JS\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2%\u0010\r\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\t0\u000ej\u0002`\u00122\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019H\u0016JF\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u001a2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J$\u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001e\u0010$\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u001aH\u0016J\u0012\u0010%\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001aH\u0016¨\u0006'"}, d2 = {"Lcom/larus/platform/api/DefaultPermissionHelperImpl;", "Lcom/larus/platform/api/IPermissionHelperApi;", "<init>", "()V", "isConditionMet", "", "activity", "Landroid/app/Activity;", "permission", "", "manifest", "", "", "requestCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "subTitleMap", "", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "requestNotificationPermission", "isLaunching", "showGoSettingPageDialog", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "permissionAny", "goPermissionSettings", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class DefaultPermissionHelperImpl implements IPermissionHelperApi {

    public static final class a {
    }

    static {
    }

    public DefaultPermissionHelperImpl() {
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final boolean isConditionMet(Activity r1) {
        return false;
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        FLogger.a.e("DefaultPermissionHelperImpl", "shouldn't be here! 1");
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permissionAny(List<String> r2, g1$c r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        FLogger.a.e("DefaultPermissionHelperImpl", "shouldn't be here! 8");
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permissionForDetail(List<String> r2, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        FLogger.a.e("DefaultPermissionHelperImpl", "shouldn't be here! 2");
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r1, Function1<? super Boolean, Unit> r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r1, "manifest");
        Intrinsics.checkNotNullParameter(r2, "requestCallBack");
        FLogger.a.e("DefaultPermissionHelperImpl", "shouldn't be here! 3");
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r1, g1$c r2, Map<String, String> r3, JSONObject r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "manifest");
        Intrinsics.checkNotNullParameter(r2, "requestCallBack");
        FLogger.a.e("DefaultPermissionHelperImpl", "shouldn't be here! 4");
    }
}
