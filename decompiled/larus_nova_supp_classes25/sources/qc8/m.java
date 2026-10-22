package qc8;

import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m implements Function0 {
    public final /* synthetic */ BubbleBannerComponent a;
    public final /* synthetic */ String b;
    public final /* synthetic */ pc8.e c;

    public /* synthetic */ m(BubbleBannerComponent r1, String r2, pc8.e r3) {
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
        r0.w = null;
        if (Intrinsics.areEqual(r0.u, r2.a) == false) goto L8;
        r0.q4();
    L8:
        BubbleBannerComponent.i4(r2);
        return Unit.INSTANCE;
    }
}
