package o89;

import com.bytedance.android.ec.base.api.ai.framework.component.CapsuleComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ CapsuleComponent a;

    public /* synthetic */ e(CapsuleComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        CapsuleComponent r0 = this.a;
        r.a.getClass();
        JSONObject r1 = new JSONObject();
        r1.putOpt("exit_method", "click_exit_apps_btn");
        Unit r2 = Unit.INSTANCE;
        r.a("exit_doubao_apps", r1);
        CapsuleComponent.OnClickCloseListener r3 = r0.getOnClickCloseListener();
        if (r3 == null) goto L6;
        r3.onClick(r0.getView());
    L6:
        return Unit.INSTANCE;
    }
}
