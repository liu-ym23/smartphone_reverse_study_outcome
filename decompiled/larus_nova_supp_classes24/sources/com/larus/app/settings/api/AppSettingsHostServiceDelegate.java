package com.larus.app.settings.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t48.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/larus/app/settings/api/AppSettingsHostServiceDelegate;", "Lcom/larus/app/settings/api/IAppSettingsHostService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/app/settings/api/IAppSettingsHostService;", "isManualUpdateSupported", "", "checkForUpdate", "", "context", "Landroid/content/Context;", "getAboutAppHostConfig", "Lcom/larus/app/settings/api/AboutAppHostConfig;", "getCustomAboutAppFragment", "Landroidx/fragment/app/Fragment;", "onAboutAppItemClicked", "semanticId", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppSettingsHostServiceDelegate implements IAppSettingsHostService {
    public static final AppSettingsHostServiceDelegate a = null;

    static {
        a = new AppSettingsHostServiceDelegate();
    }

    private AppSettingsHostServiceDelegate() {
    }

    public static IAppSettingsHostService f() {
        IAppSettingsHostService r0 = (IAppSettingsHostService) ServiceManager.get().getService(IAppSettingsHostService.class);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new AppSettingsHostServiceNoop();
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final Fragment a() {
        return f().a();
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final a b() {
        a r0 = f().b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new a(0);
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final boolean c() {
        return f().c();
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final void d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        f().d(r2);
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "semanticId");
        f().e(r2);
    }
}
