package com.obric.assistant.permission;

import androidx.fragment.app.FragmentActivity;
import com.larus.platform.api.g1;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cJP\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\nH&J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\nH&¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/permission/IObricPermissionService;", "Lcom/larus/platform/api/IPermission;", "batchPermissionRequest", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "manifest", "", "", "needShowGrantedPermission", "", "showIcon", "fallbackToSingleRequestWhenNoResolveInfo", "forceRuntimeRequestOnFallback", "requestDataCallBack", "Lcom/obric/assistant/permission/IObricPermissionService$IObricRequestPermissionCallback;", "checkPermission", "checkAlbumPermission", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "isOEMSupportAppListPermission", "goPermissionSettings", "fragment", "permissions", "callback", "Lcom/larus/platform/api/IPermission$IRequestPermissionCallback;", "setInterceptGoToSettingsDialog", "intercept", "Companion", "IObricRequestPermissionCallback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricPermissionService extends g1 {
    public static final Companion a = null;

    static {
        a = Companion.a;
    }

    void c();

    boolean checkPermission(String r1);

    void e(FragmentActivity r1, List<String> r2, g1.c r3);

    Companion.ObricPermissionStatus h();

    void n(FragmentActivity r1, List<String> r2, boolean r3, boolean r4, boolean r5, boolean r6, a r7);

    boolean o();
}
