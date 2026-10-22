package o89;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements CapsuleComponent.OnClickCloseListener {
    public final /* synthetic */ CapsuleComponent a;

    public /* synthetic */ g(CapsuleComponent r1) {
        this.a = r1;
    }

    public final void onClick(View r3) {
        CapsuleComponent r0 = this.a;
        Intrinsics.checkNotNullParameter(r3, "it");
        AtomicBoolean r4 = q.a;
        String r5 = r0.getScene();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        q.c(r5);
    }
}
