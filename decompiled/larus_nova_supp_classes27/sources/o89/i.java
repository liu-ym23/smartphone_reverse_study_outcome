package o89;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.e_commerce.impl.applet.panel.ECAppletPanel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.e_commerce.impl.applet.panel.j] */
    public static void a(Context r5, final String r6, List r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "items");
        Lazy<uq9.f> r3 = ECAppletPanel.i;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scene");
        Intrinsics.checkNotNullParameter(r7, "items");
        ILoginService r0 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r0 == null) goto L5;
        n38.e r1 = r0.Y(LoginPlatform.DOUYIN);
    L7:
        if (r1 == null) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L16;
        p.a(false);
        ECAppletPanel r4 = new ECAppletPanel(r5, r6, r7);
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(r4);
        return;
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L15:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        return;
    L16:
        final ?? r8 = new com.larus.e_commerce.impl.applet.panel.j();
        if ((r5 instanceof FragmentActivity) == false) goto L19;
        FragmentActivity r9 = (FragmentActivity) r5;
    L20:
        if (r9 != null) goto L27;
        Activity r10 = AppHost.a.a().getCurrentActivity();
        if ((r10 instanceof FragmentActivity) == false) goto L24;
        r9 = (FragmentActivity) r10;
    L25:
        if (r9 != null) goto L27;
        return;
    L24:
        r9 = null;
    L27:
        final IECommerceService r11 = (IECommerceService) ServiceManager.get().getService(IECommerceService.class);
        if (r11 == null) goto L38;
        r11.r(new com.larus.e_commerce.api.b(r9, r6, "click_ecom_apps_more", true ^ ((uq9.f) ECAppletPanel.i.getValue()).b()), null, new com.larus.e_commerce.impl.applet.panel.k(r8, r11, r6));
        return;
    L38:
        return;
    L19:
        r9 = null;
        goto L20
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
