package qc8;

import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponent;
import com.larus.bmhome.chat.component.list.u7;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ String b;

    public /* synthetic */ l(WeakReference r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        WeakReference r0 = this.a;
        String r1 = this.b;
        int r2 = BubbleBannerComponent.S;
        BubbleBannerComponent r3 = (BubbleBannerComponent) r0.get();
        if (r3 == null) goto L17;
        if (r3.K == false) goto L17;
        String r4 = r3.n;
        if (r4 != null) goto L12;
        r4 = r3.a4();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        if (Intrinsics.areEqual(r4, r1) == false) goto L17;
        u7 r5 = (u7) r3.Q.getValue();
        if (r5 == null) goto L17;
        r5.C90();
    L17:
        return Unit.INSTANCE;
    }
}
