package com.obric.assistant.spi.security.minormode;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\"\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/spi/security/minormode/DefaultObricMinorModeServiceImpl;", "Lcom/obric/assistant/spi/security/minormode/IObricMinorModeService;", "<init>", "()V", "isMinorModeCustomizeEnabled", "", "getMinorSettingPolicySubTitle", "", "getMinorSettingAgreePolicyToastTitle", "getMinorPasswordSettingPolicySubTitle", "getObricMinorModeInstructionsReadByUser", "setObricMinorModeInstructionsReadByUser", "", "isChecked", "setupMinorSettingsSubTitle", "context", "Landroid/content/Context;", "subTitleView", "Lcom/larus/common_ui/widget/UrlSpanTextView;", "titleString", "setupPasswordDisclaimer", "Landroid/view/View;", "disclaimerStub", "Landroid/view/ViewStub;", "updatePasswordDisclaimerVisibility", "visible", "interceptPasswordSettingIfNeed", "releasePasswordDisclaimer", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricMinorModeServiceImpl implements IObricMinorModeService {
    public DefaultObricMinorModeServiceImpl() {
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final boolean a() {
        return false;
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final View b(Context r2, ViewStub r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "disclaimerStub");
        return null;
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void c(boolean r1) {
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final boolean d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void e(Context r1, UrlSpanTextView r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "subTitleView");
    }

    @Override // com.obric.assistant.spi.security.minormode.IObricMinorModeService
    public final void f() {
    }
}
