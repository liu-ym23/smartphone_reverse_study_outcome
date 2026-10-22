package z0b;

import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i extends AbsChameleonService {
    public final c a;

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final ArrayList<AbsChameleonHandler<?>> getBridgeHandlers() {
        return this.a.a();
    }

    public i() {
        this.a = new c();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final void onAttach(IChameleonHandlerContext r3) {
        super.onAttach(r3);
        Iterator<a> r0 = this.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().d(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService
    public final void onDetach(IChameleonHandlerContext r3) {
        super.onDetach(r3);
        Iterator<a> r0 = this.a.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().e(r3);
        goto L4
    }
}
