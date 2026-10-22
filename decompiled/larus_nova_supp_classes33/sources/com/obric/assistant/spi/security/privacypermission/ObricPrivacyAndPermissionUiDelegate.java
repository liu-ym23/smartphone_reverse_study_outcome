package com.obric.assistant.spi.security.privacypermission;

import android.view.View;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001J\u0090\u0001\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132u\u0010\u0014\u001aq\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\f0\u0015H\u0096\u0001J\t\u0010\u001e\u001a\u00020\nH\u0096\u0001¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/spi/security/privacypermission/ObricPrivacyAndPermissionUiDelegate;", "Lcom/obric/assistant/spi/security/privacypermission/IObricPrivacyAndPermissionUiService;", "<init>", "()V", "getNotesDisplayName", "", "getPermissionRequestUiDialogSubtitle", "type", "getPermissionRequestUiDialogTitle", "isPermissionRequestUiCustomizeEnabled", "", "releaseObricSystemPermissionItems", "", "setInterceptGoToSettingsDialog", "intercept", "setupObricSystemPermissionItems", "host", "Landroidx/fragment/app/Fragment;", "itemsStub", "Landroid/view/ViewStub;", "onRequestGoSettings", "Lkotlin/Function5;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "permissionType", "title", "message", "confirmText", "shouldInterceptGoToSettingsDialog", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyAndPermissionUiDelegate implements IObricPrivacyAndPermissionUiService {
    public static final ObricPrivacyAndPermissionUiDelegate b = null;
    public final /* synthetic */ IObricPrivacyAndPermissionUiService a;

    static {
        b = new ObricPrivacyAndPermissionUiDelegate();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String a() {
        return this.a.a();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void b(Fragment r2, ViewStub r3, Function5<? super View, ? super String, ? super String, ? super String, ? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "itemsStub");
        Intrinsics.checkNotNullParameter(r4, "onRequestGoSettings");
        this.a.b(r2, r3, r4);
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void c() {
        this.a.c();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final boolean d() {
        return this.a.d();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final void e() {
        this.a.e();
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.a.f(r2);
    }

    @Override // com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService
    public final String g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.a.g(r2);
    }

    private ObricPrivacyAndPermissionUiDelegate() {
        IObricPrivacyAndPermissionUiService r0 = (IObricPrivacyAndPermissionUiService) ServiceManager.get().getService(IObricPrivacyAndPermissionUiService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricPrivacyAndPermissionUiServiceImpl();
    L5:
        this.a = r0;
    }
}
