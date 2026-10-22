package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import n58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ FlowAsrClientImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ f(FlowAsrClientImpl r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        FlowAsrClientImpl r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        b r3 = r0.h;
        if (r3 == null) goto L6;
        r3.b(r1, r2);
    L6:
        return Unit.INSTANCE;
    }
}
