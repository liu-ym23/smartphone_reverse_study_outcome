package w64;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.utils.KLog;
import z64.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements z64.g {
    public b() {
    }

    @Override // z64.g
    public final void a(i r4) {
        if ((r4 instanceof i.b) == false) goto L6;
        KLog.i(Constants.TAGS.PSEUDO, "compensate, success " + ((i.b) r4).c);
        return;
    L6:
        if ((r4 instanceof i.a) == false) goto L10;
        KLog.e(Constants.TAGS.PSEUDO, "compensate, error " + ((i.a) r4).a);
        return;
    }
}
