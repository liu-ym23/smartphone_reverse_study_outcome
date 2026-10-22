package com.larus.platform.api;

import android.app.Activity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0001J>\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0015H\u0096\u0001JT\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017H\u0096\u0001JG\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0096\u0001J\u001f\u0010\u001b\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0096\u0001Jt\u0010\u001c\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2[\u0010\u0010\u001aW\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001e\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00050\u001dj\u0002` H\u0096\u0001J\u0011\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\tH\u0096\u0001J%\u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010%H\u0096\u0001¨\u0006&"}, d2 = {"Lcom/larus/platform/api/PermissionHelperDelegate;", "Lcom/larus/platform/api/IPermissionHelperApi;", "<init>", "()V", "goPermissionSettings", "", "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "isConditionMet", "", "activity", "Landroid/app/Activity;", "permission", "manifest", "", "", "requestCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", "subTitleMap", "", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "permissionAny", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "requestNotificationPermission", "isLaunching", "showGoSettingPageDialog", "subTitle", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class PermissionHelperDelegate implements IPermissionHelperApi {
    public static final PermissionHelperDelegate b = null;
    public final /* synthetic */ IPermissionHelperApi a;

    static {
        b = new PermissionHelperDelegate();
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final boolean isConditionMet(Activity r2) {
        return this.a.isConditionMet(r2);
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r8, g1$c r9, Map<String, String> r10, JSONObject r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "manifest");
        Intrinsics.checkNotNullParameter(r9, "requestCallBack");
        this.a.permission(r8, r9, r10, r11, r12);
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        this.a.permission(r2, r3);
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permission(List<String> r2, Function1<? super Boolean, Unit> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        this.a.permission(r2, r3, r4);
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permissionAny(List<String> r2, g1$c r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        this.a.permissionAny(r2, r3);
    }

    @Override // com.larus.platform.api.IPermissionHelperApi
    public final void permissionForDetail(List<String> r2, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        this.a.permissionForDetail(r2, r3);
    }

    private PermissionHelperDelegate() {
        IPermissionHelperApi r0 = (IPermissionHelperApi) ServiceManager.get().getService(IPermissionHelperApi.class);
        if (r0 != null) goto L5;
        r0 = new DefaultPermissionHelperImpl();
    L5:
        this.a = r0;
    }
}
