package com.obric.assistant.spi.login;

import android.view.View;
import android.view.ViewStub;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.login.impl.loginfragment.u0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J=\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0096\u0001¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/spi/login/ObricLoginDelegate;", "Lcom/obric/assistant/spi/login/IObricLoginService;", "<init>", "()V", "isNotObricLogin", "", "setupWelcomeContent", "", "welcomeStub", "Landroid/view/ViewStub;", "viewsToHide", "", "Landroid/view/View;", "animatorTitle", "animatorTitleBottomAnchor", "onWelcomePrimaryClick", "Lkotlin/Function0;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginDelegate implements IObricLoginService {
    public static final ObricLoginDelegate b = null;
    public final /* synthetic */ IObricLoginService a;

    static {
        b = new ObricLoginDelegate();
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final void a(ViewStub r8, List r9, SimpleDraweeView r10, View r11, u0 r12) {
        Intrinsics.checkNotNullParameter(r8, "welcomeStub");
        Intrinsics.checkNotNullParameter(r9, "viewsToHide");
        Intrinsics.checkNotNullParameter(r10, "animatorTitle");
        Intrinsics.checkNotNullParameter(r11, "animatorTitleBottomAnchor");
        Intrinsics.checkNotNullParameter(r12, "onWelcomePrimaryClick");
        this.a.a(r8, r9, r10, r11, r12);
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final boolean b() {
        return this.a.b();
    }

    private ObricLoginDelegate() {
        IObricLoginService r0 = (IObricLoginService) ServiceManager.get().getService(IObricLoginService.class);
        if (r0 != null) goto L5;
        r0 = new DefaultObricLoginServiceImpl();
    L5:
        this.a = r0;
    }
}
