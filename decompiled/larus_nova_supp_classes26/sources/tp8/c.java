package tp8;

import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.inputarea.InputAreaBlockComponent;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ InputAreaBlockComponent a;

    public /* synthetic */ c(InputAreaBlockComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        y r0 = (y) this.a.n.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Y1();
    }
}
