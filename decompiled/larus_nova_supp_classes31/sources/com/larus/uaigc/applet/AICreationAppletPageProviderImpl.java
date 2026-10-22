package com.larus.uaigc.applet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.uaigc.createpage.CreationFragment;
import com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment;
import com.larus.uaigc.createpage.s0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.b;
import ny9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0016¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/applet/AICreationAppletPageProviderImpl;", "Lcom/larus/uaigc/applet/IAICreationAppletPageProvider;", "<init>", "()V", "startCreatePagePerf", "", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "buildChooseTemplateBundle", "Landroid/os/Bundle;", "Lcom/larus/uaigc/bean/createpage/CreatePageChooseTemplateConfig;", "buildCreatePageBundle", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "openNativeCreatePage", "getNativeCreationIntent", "Landroid/content/Intent;", "createCreationFragment", "Landroidx/fragment/app/Fragment;", "args", "createImageRemoveFragment", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class AICreationAppletPageProviderImpl implements IAICreationAppletPageProvider {
    public AICreationAppletPageProviderImpl() {
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Fragment a(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        ImageRemoveFragment r0 = new ImageRemoveFragment();
        r0.setArguments(r2);
        return r0;
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        s0.a.getClass();
        s0.d(r2);
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Bundle c(b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        s0.a.getClass();
        return s0.b(r2);
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final void d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        s0.a.getClass();
        s0.e(r2);
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Fragment e(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        CreationFragment r0 = new CreationFragment();
        r0.setArguments(r2);
        return r0;
    }

    @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
    public final Bundle f(ny9.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        s0.a.getClass();
        return s0.a(r2);
    }
}
