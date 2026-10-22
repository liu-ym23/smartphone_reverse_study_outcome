package tx1;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.elder.LiveElderModeConfig;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final b a = null;

    public b() {
    }

    static {
        a = new b();
    }

    public static float a() {
        IMiddlewareHostBusiness r0 = k.f(IMiddlewareHostBusiness.class);
        if (r0 == null) goto L35;
        LiveElderModeConfig r1 = r0.elderModeConfig();
        if (r1 != null) goto L8;
        return 1.0f;
    L8:
        if (r1.getEnableElderMode() == true) goto L10;
        return 1.0f;
    L10:
        if (r1.getFontScale() != LiveElderModeConfig.FontScale.FONT_SCALE_BY_RESOURCE) goto L25;
        Application r2 = jc1.a.b();
        if (r2 == null) goto L18;
        Resources r3 = r2.getResources();
        if (r3 == null) goto L18;
        Configuration r4 = r3.getConfiguration();
        if (r4 == null) goto L18;
        float r5 = r4.fontScale;
    L19:
        double r6 = r5;
        if (r6 > 1.0d) goto L23;
        return 1.0f;
    L23:
        if (r6 < 1.25d) goto L33;
    L32:
        return 1.25f;
    L33:
        return 1.15f;
    L18:
        r5 = 1.0f;
        goto L19
    L25:
        LiveElderModeConfig.FontScale r7 = r1.getFontScale();
        Intrinsics.checkNotNullParameter(r7, "$this$adjustFontScale");
        int r8 = a.a[r7.ordinal()];
        if (r8 != 1) goto L28;
        return 1.0f;
    L28:
        if (r8 == 2) goto L33;
        if (r8 == 3) goto L32;
        return 1.0f;
    L35:
        return 1.0f;
    }
}
