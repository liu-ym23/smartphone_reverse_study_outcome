package com.obric.assistant.interaction.impl.permission;

import android.app.Activity;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IPermissionHelperApi;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J=\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u0015H\u0016Js\u0010\u0016\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2[\u0010\u0010\u001aW\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00050\u0017j\u0002`\u001aH\u0016JS\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u0011j\u0002`\u00152\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cH\u0016JF\u0010\f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u001d2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\tH\u0016J$\u0010#\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001e\u0010'\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u001dH\u0016J\u0012\u0010(\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010)\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¨\u0006+"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionHelperImpl;", "Lcom/larus/platform/api/IPermissionHelperApi;", "<init>", "()V", "startHelper", "", "task", "Lcom/obric/assistant/interaction/impl/permission/PermissionTask;", "isConditionMet", "", "activity", "Landroid/app/Activity;", "permission", "manifest", "", "", "requestCallBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allGranted", "Lcom/larus/platform/api/RequestPermissionCallback;", "permissionForDetail", "Lkotlin/Function3;", "grantedList", "deniedList", "Lcom/larus/platform/api/RequestPermissionDataCallback;", "subTitleMap", "", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "trackInfo", "Lorg/json/JSONObject;", "showGoSettingsDialog", "requestNotificationPermission", "isLaunching", "showGoSettingPageDialog", "subTitle", "callback", "Lcom/larus/platform/api/IPermission$IGoSettingPageCallback;", "permissionAny", "goPermissionSettings", "checkAllPermissionsGranted", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermissionHelperImpl implements IPermissionHelperApi {
    public static final Companion Companion = null;
    private static final String TAG = "PermissionHelperImpl";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/permission/PermissionHelperImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PermissionHelperImpl() {
    }

    private final boolean checkAllPermissionsGranted(List<String> r4) {
        List<String> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L23;
        String r0 = (String) r6.next();
        if (ContextCompat.checkSelfPermission(AppHost.a.getApplication(), r0) != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L9;
        return false;
    L13:
        r1 = false;
        goto L14
    L23:
        return true;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return true;
    }

    private final void startHelper(PermissionTask r4) {
        FLogger.a.i(TAG, "startHelper ".concat(r4.getClass().getSimpleName()));
        PermissionMediator.INSTANCE.startNewTask(r4);
        AppHost.Companion r0 = AppHost.a;
        Intent r5 = new Intent(r0.getApplication(), PermissionHelperActivity.class);
        r5.addFlags(268435456);
        r5.addFlags(134217728);
        r5.addFlags(UiType.FLAG_ALARM_CLOCK_CARD);
        r5.addFlags(536870912);
        r0.getApplication().startActivity(r5);
    }

    public void goPermissionSettings(g1.c r2) {
        startHelper(new PermissionTask.GoSettings(r2));
    }

    public boolean isConditionMet(Activity r2) {
        if (ChatWindowServiceDelegate.b.e() == false) goto L5;
    L8:
        return true;
    L5:
        if (IWindowContextKt.isWindowContext(r2) == true) goto L8;
        return false;
    }

    public void requestNotificationPermission(boolean r2) {
        if (checkAllPermissionsGranted(CollectionsKt.listOf("android.permission.POST_NOTIFICATIONS")) == false) goto L5;
        return;
    L5:
        startHelper(new PermissionTask.RequestNotification(r2));
    }

    public void permission(List<String> r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        if (checkAllPermissionsGranted(r2) == false) goto L6;
        r3.invoke(Boolean.TRUE);
        return;
    L6:
        startHelper(new PermissionTask.RequestBasic(r2, r3));
    }

    public void permissionAny(List<String> r4, g1.c r5) {
        Intrinsics.checkNotNullParameter(r4, "manifest");
        Intrinsics.checkNotNullParameter(r5, "requestCallBack");
        if (checkAllPermissionsGranted(r4) == false) goto L6;
        r5.onResult(true, r4, new ArrayList(), false);
        return;
    L6:
        startHelper(new PermissionTask.RequestAny(r4, r5));
    }

    public void permissionForDetail(List<String> r3, Function3<? super Boolean, ? super List<String>, ? super List<String>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "manifest");
        Intrinsics.checkNotNullParameter(r4, "requestCallBack");
        if (checkAllPermissionsGranted(r3) == false) goto L6;
        r4.invoke(Boolean.TRUE, r3, CollectionsKt.emptyList());
        return;
    L6:
        startHelper(new PermissionTask.RequestDetail(r3, r4));
    }

    public void permission(List<String> r2, Function1<? super Boolean, Unit> r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "manifest");
        Intrinsics.checkNotNullParameter(r3, "requestCallBack");
        if (checkAllPermissionsGranted(r2) == false) goto L6;
        r3.invoke(Boolean.TRUE);
        return;
    L6:
        startHelper(new PermissionTask.RequestWithMap(r2, r3, r4));
    }

    public void showGoSettingPageDialog(String r2, String r3, g1.b r4) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        startHelper(new PermissionTask.ShowSettingDialog(r2, r3, r4));
    }

    public void permission(List<String> r8, g1.c r9, Map<String, String> r10, JSONObject r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "manifest");
        Intrinsics.checkNotNullParameter(r9, "requestCallBack");
        if (checkAllPermissionsGranted(r8) == false) goto L6;
        r9.onResult(true, r8, CollectionsKt.emptyList(), false);
        return;
    L6:
        startHelper(new PermissionTask.RequestFull(r8, r9, r10, r11, r12));
    }
}
