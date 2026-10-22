package omb;

import android.content.Context;
import com.bytedance.lark.base.open.pkm.PkmBizType;
import com.bytedance.lark.base.open.pkm.j;
import com.larksuite.component.card.cardcontainer.IUniversalCardJsService;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.log.Log;
import java.io.File;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class g implements IUniversalCardJsService {
    @Inject
    public g() {
    }

    public final String getJsBundleFile(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return a.f(r2);
    }

    public final String getJsBundleVersion(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r3 = a.d;
        if (r3 != null) goto L6;
        return InvRouter.UNKNOWN;
    L6:
        return r3;
    }

    public final void initCardEnv(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        ee6.f.a();
    }

    public final byte[] loadTemplate(Context r4, File r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        PkmBizType r0 = a.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        j r6 = a.b;
        if (r6 != null) goto L8;
        a.e(r4);
        r6 = a.b;
        if (r6 != null) goto L8;
        Log.w("CardTemplatePkmManager", "ensureManager: pkmManager still null");
    L8:
        if (r6 == null) goto L23;
        String r7 = a.f(r4);
        if (r7 != null) goto L13;
    L16:
        boolean r1 = true;
    L17:
        if (r1 == true) goto L23;
        return r6.g(a.a);
    L21:
        e = move-exception;
        Log.e("CardTemplatePkmManager", "localTemplate failed. path=" + r7, e);
        goto L23
    L13:
        if (r7.length() == 0) goto L16;
        r1 = false;
    L23:
        return null;
    }
}
