package com.larus.uaigc.applet;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ny9.b;
import ny9.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\nH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletPageProvider;", "", "startCreatePagePerf", "", "config", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "buildChooseTemplateBundle", "Landroid/os/Bundle;", "Lcom/larus/uaigc/bean/createpage/CreatePageChooseTemplateConfig;", "buildCreatePageBundle", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "openNativeCreatePage", "getNativeCreationIntent", "Landroid/content/Intent;", "createCreationFragment", "Landroidx/fragment/app/Fragment;", "args", "createImageRemoveFragment", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public interface IAICreationAppletPageProvider {
    public static final Companion a = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0096\u0001J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0012H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/applet/IAICreationAppletPageProvider$Companion;", "Lcom/larus/uaigc/applet/IAICreationAppletPageProvider;", "<init>", "()V", "buildChooseTemplateBundle", "Landroid/os/Bundle;", "config", "Lcom/larus/uaigc/bean/createpage/CreatePageChooseTemplateConfig;", "buildCreatePageBundle", "Lcom/larus/uaigc/bean/createpage/CreatePageConfig;", "createCreationFragment", "Landroidx/fragment/app/Fragment;", "args", "createImageRemoveFragment", "getNativeCreationIntent", "Landroid/content/Intent;", "openNativeCreatePage", "", "Lcom/larus/uaigc/bean/createpage/ICreatePageConfig;", "startCreatePagePerf", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class Companion implements IAICreationAppletPageProvider {
        public static final /* synthetic */ Companion c = null;
        public final /* synthetic */ IAICreationAppletPageProvider b;

        static {
            c = new Companion();
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final Fragment a(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "args");
            return this.b.a(r2);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final void b(c r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.b.b(r2);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final Bundle c(b r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            return this.b.c(r2);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final void d(c r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.b.d(r2);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final Fragment e(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "args");
            return this.b.e(r2);
        }

        @Override // com.larus.uaigc.applet.IAICreationAppletPageProvider
        public final Bundle f(ny9.a r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            return this.b.f(r2);
        }

        private Companion() {
            IAICreationAppletPageProvider r0 = (IAICreationAppletPageProvider) ServiceManager.get().getService(IAICreationAppletPageProvider.class);
            if (r0 != null) goto L5;
            r0 = new IAICreationAppletPageProviderNoop();
        L5:
            this.b = r0;
        }
    }

    static {
        a = Companion.c;
    }

    Fragment a(Bundle r1);

    void b(c r1);

    Bundle c(b r1);

    void d(c r1);

    Fragment e(Bundle r1);

    Bundle f(ny9.a r1);
}
