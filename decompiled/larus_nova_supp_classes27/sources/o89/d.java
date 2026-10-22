package o89;

import android.view.View;
import com.bytedance.android.ec.base.api.ai.framework.component.BackComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements View.OnClickListener {
    public final /* synthetic */ BackComponent a;

    public /* synthetic */ d(BackComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        BackComponent r0 = this.a;
        r.a.getClass();
        r.a("return_last_page_doubao_apps", null);
        BackComponent.OnClickListener r1 = r0.getOnClickListener();
        if (r1 == null) goto L6;
        Intrinsics.checkNotNull(r4);
        r1.onClick(r4);
        return;
    }
}
