package qc8;

import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Function0 {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ pc8.e c;

    public /* synthetic */ n(BubbleBannerComponent r1, String r2, pc8.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        BubbleBannerComponent r0 = this.a;
        String r1 = this.b;
        pc8.e r2 = this.c;
        if (Intrinsics.areEqual(r0.v, r1) == false) goto L5;
        r0.v = null;
    L5:
        int r3 = com.larus.bmhome.chat.bubble.floating.runtime.k.a;
        String r4 = r2.a;
        Intrinsics.checkNotNullParameter(r4, "promptId");
        IBubbleBannerRuntimeService r5 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r5 == null) goto L9;
        r5.o(r4);
    L9:
        return Unit.INSTANCE;
    }
}
