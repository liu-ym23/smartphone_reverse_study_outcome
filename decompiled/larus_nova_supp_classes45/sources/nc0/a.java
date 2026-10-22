package nc0;

import com.bytedance.android.live.anchorlink.network.model.MultiChannelData;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements Function1<r1, Unit> {
    public final /* synthetic */ Function1 a;

    public a(Function1 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r2) {
        r1 r3 = (r1) r2;
        Function1 r0 = this.a;
        if (r3 == null) goto L5;
        vh7.c r4 = k.a(r3);
    L6:
        r0.invoke((MultiChannelData) r4);
        return Unit.INSTANCE;
    L5:
        r4 = null;
        goto L6
    }
}
