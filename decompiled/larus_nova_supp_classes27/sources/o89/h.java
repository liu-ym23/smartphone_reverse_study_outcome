package o89;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class h implements CapsuleComponent.OnClickMenuListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ CapsuleComponent b;

    public /* synthetic */ h(Context r1, CapsuleComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onClick(View r4) {
        Context r0 = this.a;
        CapsuleComponent r1 = this.b;
        Intrinsics.checkNotNullParameter(r4, "it");
        int r5 = i.a;
        String r6 = r1.getScene();
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        i.a(r0, r6, CollectionsKt.emptyList());
    }
}
