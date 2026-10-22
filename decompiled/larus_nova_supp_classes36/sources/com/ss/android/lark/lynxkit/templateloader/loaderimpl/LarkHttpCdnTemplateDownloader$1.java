package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/larksuite/framework/http/client/IHttpClient;", "kotlin.jvm.PlatformType", "config", "Lcom/ss/android/lark/lynxkit/templateloader/loaderimpl/CdnTemplateLoaderConfig;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class LarkHttpCdnTemplateDownloader$1 extends Lambda implements Function1<f, x18.b> {
    public static final LarkHttpCdnTemplateDownloader$1 INSTANCE = null;

    static {
        INSTANCE = new LarkHttpCdnTemplateDownloader$1();
    }

    public LarkHttpCdnTemplateDownloader$1() {
        super(1);
    }

    public final x18.b invoke(f r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        x18.b.a r0 = new x18.b.a();
        long r1 = r5.f;
        TimeUnit r3 = TimeUnit.MILLISECONDS;
        r0.d = r1;
        r0.e = r3;
        int r6 = r5.g;
        r0.f = r6;
        r0.g = r3;
        r0.h = r6;
        r0.i = r3;
        return new x18.d(r0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((f) r1);
    }
}
