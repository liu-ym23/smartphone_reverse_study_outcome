package k2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.PageInfo;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements p {
    public final String a;

    public g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageId");
        this.a = r10;
    }

    @Override // k2.p
    public final View createPage(PageInfo r10, Context r11, Function1<? super Integer, Unit> r12, Function1<? super String, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        String r14 = a.a(r10);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L7;
        Context r16 = r15.currentActivity();
        if (r16 == null) goto L7;
    L8:
        Bundle r17 = BundleKt.bundleOf(new Pair[]{TuplesKt.to(BdpAwemeConstant.KEY_APP_NAME, r10.getPageName()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r14), TuplesKt.to("pageId", this.a), TuplesKt.to("botId", r10.getBotId()), TuplesKt.to("fullScreen", Boolean.TRUE), TuplesKt.to("appletId", r10.getPackageName())});
        Intrinsics.checkNotNullParameter(r16, "context");
        g2.b r18 = AppletRuntimeManager.d;
        if (r18 == null) goto L12;
        r18.D(r16, r17);
    L12:
        if (r12 == null) goto L14;
        r12.invoke(null);
    L14:
        return null;
    L7:
        r16 = f2.k.a();
        goto L8
    }
}
