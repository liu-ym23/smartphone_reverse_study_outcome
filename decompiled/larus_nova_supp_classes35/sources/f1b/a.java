package f1b;

import android.app.Application;
import android.content.res.Resources;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSFiles;
import com.suite.lark.platform.service.resourcerepository.api.Resource;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import swb.j;
import swb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends y0b.c {
    public final qpc.a a;

    public a() {
        this.a = (qpc.a) ApiUtils.getApi(qpc.a.class);
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r11) {
        if (r11 == null) goto L5;
        String r5 = UriProtector.getQueryParameter(r11, "key");
    L6:
        if (r11 == null) goto L8;
        String r1 = UriProtector.getQueryParameter(r11, "entityId");
    L9:
        if (r11 == null) goto L11;
        String r12 = UriProtector.getQueryParameter(r11, "size");
    L12:
        boolean r2 = true;
        if (r5 != null) goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == true) goto L40;
        if (r1 != null) goto L22;
    L25:
        boolean r6 = true;
    L26:
        if (r6 == true) goto L41;
        if (r12 != null) goto L29;
    L32:
        if (r2 == true) goto L44;
        p.a r3 = p.a;
        Application r7 = LarkContext.getApplication();
        float r13 = CastFloatProtector.parseFloat(r12);
        Intrinsics.checkNotNullParameter(r7, "context");
        Resources r8 = r7.getResources();
        int r9 = (int) ((r13 / WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f);
        qpc.a r10 = this.a;
        long r14 = CastLongProtector.parseLong(r1);
        Resources r15 = LarkContext.getApplication().getResources();
        Resource r16 = r10.getAvatarImageResource(r14, r5, r9, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics()).density, "webp", null);
        if (r16 == null) goto L42;
        String r17 = r16.b;
        if (r17 != null) goto L39;
        return null;
    L39:
        return new WebResourceResponse(j.i(r17), Charset.defaultCharset().name(), VFSFiles.b.k(r17));
    L42:
        return null;
    L44:
        return null;
    L29:
        if (r12.length() == 0) goto L32;
        r2 = false;
        goto L32
    L41:
        return null;
    L22:
        if (r1.length() == 0) goto L25;
        r6 = false;
        goto L26
    L40:
        return null;
    L15:
        if (r5.length() == 0) goto L18;
        r4 = false;
        goto L19
    L11:
        r12 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    L5:
        r5 = null;
        goto L6
    }
}
