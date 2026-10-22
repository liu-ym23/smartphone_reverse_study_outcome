package g78;

import com.larus.audio.flow.client.FlowAsrClientImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ m(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        int r1 = FlowAsrClientImpl.E;
        r0.invoke();
    }
}
