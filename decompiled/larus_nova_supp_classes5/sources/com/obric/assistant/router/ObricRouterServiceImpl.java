package com.obric.assistant.router;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricAssistant;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.onelogin.IObricOneLogin;
import com.obric.assistant.spi.router.IObricRouterService;
import com.obric.assistant.t1;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import dea.a;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/router/ObricRouterServiceImpl;", "Lcom/obric/assistant/spi/router/IObricRouterService;", "<init>", "()V", "addAllRouterInterceptor", "", "deeplinkQueryDisabled", "putDeeplinkQueryParams", "", "bundle", "Landroid/os/Bundle;", "uri", "Landroid/net/Uri;", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRouterServiceImpl implements IObricRouterService {
    public static final Set<String> a = null;

    public ObricRouterServiceImpl() {
    }

    static {
        a = SetsKt.setOf(new String[]{"question", "push_question", "qst3", "auto_send_text"});
    }

    public final boolean a() {
        FLogger.a.i("ObricRouterServiceImpl", "obric addAllRouterInterceptor");
        IObricAssistant r0 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        a r1 = null;
        if (r0 == null) goto L5;
        q97.a r2 = r0.k();
    L6:
        SmartRouter.addInterceptor(r2);
        IObricAssistant r3 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r3 == null) goto L9;
        q97.a r4 = r3.c();
    L10:
        SmartRouter.addInterceptor(r4);
        IObricAssistant r5 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r5 == null) goto L13;
        q97.a r6 = r5.h();
    L14:
        SmartRouter.addInterceptor(r6);
        IObricAssistant r7 = (IObricAssistant) ServiceManager.get().getService(IObricAssistant.class);
        if (r7 == null) goto L17;
        q97.a r8 = r7.b();
    L18:
        SmartRouter.addInterceptor(r8);
        IObricOneLogin r9 = (IObricOneLogin) ServiceManager.get().getService(IObricOneLogin.class);
        if (r9 == null) goto L21;
        q97.a r10 = r9.d();
    L22:
        SmartRouter.addInterceptor(r10);
        IObricUserGuide r11 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r11 == null) goto L25;
        r1 = r11.i();
    L25:
        SmartRouter.addInterceptor(r1);
        return true;
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final boolean c() {
        t1 r0 = t1.a;
        if (r0.I0().getEnableOSecurity() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        FLogger.a.i("ObricRouterServiceImpl", "obric deeplinkQueryDisabled: " + r1);
        return r1;
    L5:
        if (r0.I0().getEnableOBlockDeeplinkQuery() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void b(Bundle r6, Uri r7) {
        Intrinsics.checkNotNullParameter(r6, "bundle");
        if (r7 == null) goto L13;
        Set r0 = UriProtector.getQueryParameterNames(r7);
        if (r0 == null) goto L20;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L21;
        String r2 = (String) r1.next();
        if (a.contains(r2) == true) goto L11;
        r6.putString(r2, UriProtector.getQueryParameter(r7, r2));
        goto L8
    L11:
        FLogger.a.i("ObricRouterServiceImpl", "data url contains: " + r2 + ",  block by obric");
        goto L8
    L21:
        return;
    L20:
        return;
    }
}
