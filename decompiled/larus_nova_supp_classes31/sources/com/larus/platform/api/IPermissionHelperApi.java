package com.larus.platform.api;

import android.app.Activity;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J=\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u0010H&Js\u0010\u0011\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2[\u0010\u000b\u001aW\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00070\u0012j\u0002`\u0015H&JU\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u00102\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017H&JL\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00182\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0003H&J(\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H&J\u001e\u0010\"\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0018H&J\u0014\u0010#\u001a\u00020\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0018H&¨\u0006$"}, d2 = {"Lcom/larus/platform/api/IPermissionHelperApi;", "", "isConditionMet", "", "activity", "Landroid/app/Activity;", "permission", "", "manifest", "", "", "requestCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "subTitleMap", "", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "requestNotificationPermission", "isLaunching", "showGoSettingPageDialog", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "permissionAny", "goPermissionSettings", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IPermissionHelperApi {
    boolean isConditionMet(Activity r1);

    void permission(List<String> r1, g1$c r2, Map<String, String> r3, JSONObject r4, boolean r5);

    void permission(List<String> r1, Function1<? super Boolean, Unit> r2);

    void permission(List<String> r1, Function1<? super Boolean, Unit> r2, Map<String, String> r3);

    void permissionAny(List<String> r1, g1$c r2);

    void permissionForDetail(List<String> r1, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r2);
}
