package dea;

import android.content.Context;
import android.net.Uri;
import com.bytedance.router.c;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements q97.a {

    /* JADX INFO: renamed from: dea.a$a, reason: collision with other inner class name */
    public static final class C0013a {
    }

    static {
    }

    public a() {
    }

    public final boolean b(c r2) {
        int r0 = k0.a;
        if (r2 == null) goto L7;
        Uri r3 = r2.d;
        if (r3 == null) goto L7;
        String r4 = r3.toString();
    L9:
        return Intrinsics.areEqual(k0.a(r4), "//main_page");
    L7:
        r4 = null;
        goto L9
    }

    public final boolean a(Context r5, c r6) {
        IObricUserGuide r7 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r5 == null) goto L9;
        if (r7 == null) goto L6;
        Boolean r8 = Boolean.valueOf(r7.d(r5));
    L7:
        if (r8 == null) goto L9;
        boolean r9 = r8.booleanValue();
    L10:
        FLogger.a.i("UserGuideInterceptor", "isInSystemWizard=" + r9);
        if (r9 == false) goto L16;
        if (r7 == null) goto L17;
        r7.e();
        return true;
    L17:
        return true;
    L16:
        return false;
    L6:
        r8 = null;
    L9:
        r9 = false;
        goto L10
    }
}
