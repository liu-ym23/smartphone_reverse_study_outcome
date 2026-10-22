package com.larus.app.settings.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t48.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/app/settings/api/AppSettingsHostServiceNoop;", "Lcom/larus/app/settings/api/IAppSettingsHostService;", "<init>", "()V", "isManualUpdateSupported", "", "checkForUpdate", "", "context", "Landroid/content/Context;", "getAboutAppHostConfig", "Lcom/larus/app/settings/api/AboutAppHostConfig;", "getCustomAboutAppFragment", "Landroidx/fragment/app/Fragment;", "onAboutAppItemClicked", "semanticId", "", "api_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AppSettingsHostServiceNoop implements IAppSettingsHostService {
    public AppSettingsHostServiceNoop() {
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final Fragment a() {
        return null;
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final boolean c() {
        return false;
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final void d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "semanticId");
    }

    @Override // com.larus.app.settings.api.IAppSettingsHostService
    public final a b() {
        return new a(0);
    }
}
