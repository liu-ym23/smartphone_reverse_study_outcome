package sea;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b0 implements Function0 {
    public final /* synthetic */ ObricState a;

    public /* synthetic */ b0(ObricState r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricState r0 = this.a;
        g r1 = g.a;
        Context r2 = AppHost.a.getApplication().getApplicationContext();
        r1.getClass();
        g.e(r2, r0);
        return Unit.INSTANCE;
    }
}
