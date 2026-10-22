package com.obric.assistant.spi.security.privacypermission;

import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u008f\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2u\u0010\n\u001aq\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00050\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/spi/security/privacypermission/DefaultObricPrivacyAndPermissionUiServiceImpl;", "Lcom/obric/assistant/spi/security/privacypermission/IObricPrivacyAndPermissionUiService;", "<init>", "()V", "setupObricSystemPermissionItems", "", "host", "Landroidx/fragment/app/Fragment;", "itemsStub", "Landroid/view/ViewStub;", "onRequestGoSettings", "Lkotlin/Function5;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "permissionType", "title", "message", "confirmText", "releaseObricSystemPermissionItems", "isPermissionRequestUiCustomizeEnabled", "", "getPermissionRequestUiDialogTitle", "type", "getPermissionRequestUiDialogSubtitle", "getNotesDisplayName", "setInterceptGoToSettingsDialog", "intercept", "shouldInterceptGoToSettingsDialog", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricPrivacyAndPermissionUiServiceImpl implements IObricPrivacyAndPermissionUiService {
    public DefaultObricPrivacyAndPermissionUiServiceImpl() {
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String a() {
        return "";
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void b(Fragment r2, ViewStub r3, Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "itemsStub");
        Intrinsics.checkNotNullParameter(r4, "onRequestGoSettings");
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void c() {
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final boolean d() {
        return false;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void e() {
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return null;
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return null;
    }
}
