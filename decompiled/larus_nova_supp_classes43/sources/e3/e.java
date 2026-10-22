package e3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import f2.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final Activity a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Activity r10 = r1.getOwnerActivity();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return k.b();
    }

    public static final Context b(d r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Activity r0 = a(r1);
        if (r0 != null) goto L17;
        View r10 = r1.getEngineView();
        if (r10 == null) goto L8;
        Context r11 = r10.getContext();
    L9:
        if (r11 != null) goto L14;
        IHostContextDepend r12 = r4.a.a;
        IHostContextDepend r13 = r4.a.a;
        if (r13 != null) goto L16;
        return null;
    L16:
        return r13.getApplicationContext();
    L14:
        return r11;
    L8:
        r11 = null;
        goto L9
    L17:
        return r0;
    }
}
