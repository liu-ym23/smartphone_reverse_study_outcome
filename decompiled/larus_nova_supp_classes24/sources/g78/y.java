package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import y58.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y implements Function0 {
    public final /* synthetic */ FlowAsrClientImpl a;
    public final /* synthetic */ b b;

    public /* synthetic */ y(FlowAsrClientImpl r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final FlowAsrClientImpl r0 = this.a;
        final b r1 = this.b;
        r0.b.submit(new g(r0, r1));
        return Unit.INSTANCE;
    }
}
