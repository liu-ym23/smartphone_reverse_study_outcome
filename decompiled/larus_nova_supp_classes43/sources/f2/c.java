package f2;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.ai.model.AppletRuntimeManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends z4.a.C0216a {
    public c() {
    }

    @Override // z4.a.C0216a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        super.onActivityDestroyed(r10);
        x2.b.a.getClass();
        Intrinsics.checkNotNullParameter(r10, "context");
        Iterator r0 = ((LinkedHashMap) x2.b.b).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        x2.c r1 = (x2.c) r0.next();
        if (Intrinsics.areEqual(r1.getContext(), r10) == true) goto L9;
        if (r1.getContext() != null) goto L4;
    L9:
        x2.a r11 = (x2.a) ((LinkedHashMap) x2.b.b).get(r1);
        if (r11 == null) goto L16;
        r11.c = true;
        com.bytedance.ai.applet.base.log.b r12 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("RenderViewPool", "destroy: pool size = " + r11.b.size());
        Iterator r13 = r11.b.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        ((w2.a) r13.next()).destroy();
        goto L13
    L15:
        r11.b.clear();
    L16:
        r0.remove();
        goto L4
    }

    @Override // z4.a.C0216a, android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        super.onActivityCreated(r10, r11);
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r12 = AppletRuntimeManager.d;
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof AppCompatActivity) == true) goto L7;
        return;
    L7:
        if ((((AppCompatActivity) r10).getResources().getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r13 = true;
    L10:
        r12.b(r13);
        return;
    L9:
        r13 = false;
        goto L10
    }
}
