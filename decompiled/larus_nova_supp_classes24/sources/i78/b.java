package i78;

import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.bmhome.chat.trace.c0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ Function1 a;

    public /* synthetic */ b(c0 r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Function1 r0 = this.a;
        String r4 = (String) r3;
        int r1 = FlowTtsClientKmpManagerDelegate.d;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.invoke(r4);
        return Unit.INSTANCE;
    }
}
