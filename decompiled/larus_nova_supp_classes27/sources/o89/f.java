package o89;

import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ CapsuleComponent a;

    public /* synthetic */ f(CapsuleComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CapsuleComponent r0 = this.a;
        r.a.getClass();
        r.a("click_doubao_apps_more", null);
        CapsuleComponent.OnClickMenuListener r1 = r0.getOnClickMenuListener();
        if (r1 == null) goto L6;
        r1.onClick(r0.getView());
    L6:
        return Unit.INSTANCE;
    }
}
