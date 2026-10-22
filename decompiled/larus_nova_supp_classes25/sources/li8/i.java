package li8;

import com.larus.bmhome.chat.component.bottom.multimodal.latest.c0;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i implements Function2 {
    public /* synthetic */ i() {
    }

    public final Object invoke(Object r2, Object r3) {
        boolean r4 = ((Boolean) r2).booleanValue();
        String r5 = (String) r3;
        Intrinsics.checkNotNullParameter(r5, "uriString");
        if (r4 == false) goto L11;
        if (r5.length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        CopyOnWriteArraySet<String> r7 = c0.a;
        Intrinsics.checkNotNullParameter(r5, "uriString");
        c0.a.add(r5);
        goto L11
    L7:
        r6 = false;
    L11:
        return Unit.INSTANCE;
    }
}
