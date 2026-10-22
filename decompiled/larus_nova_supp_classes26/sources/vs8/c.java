package vs8;

import com.larus.bmhome.view.actionbar.custom.actionbarpanel.CustomActionBarPanel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ CustomActionBarPanel a;
    public final /* synthetic */ d b;

    public /* synthetic */ c(CustomActionBarPanel r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r4) {
        CustomActionBarPanel r0 = this.a;
        d r1 = this.b;
        int r5 = ((Integer) r4).intValue();
        int r2 = CustomActionBarPanel.i;
        r0.c(r1, r5);
        return Unit.INSTANCE;
    }
}
