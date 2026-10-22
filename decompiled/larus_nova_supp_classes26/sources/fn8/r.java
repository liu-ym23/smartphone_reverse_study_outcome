package fn8;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.video.VideoPlayView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class r implements Function1 {
    public final /* synthetic */ w a;
    public final /* synthetic */ x b;
    public final /* synthetic */ VideoPlayView c;

    public /* synthetic */ r(w r1, x r2, VideoPlayView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke(Object r6) {
        w r0 = this.a;
        x r1 = this.b;
        VideoPlayView r2 = this.c;
        boolean r7 = ((Boolean) r6).booleanValue();
        if (Intrinsics.areEqual(r0.h, r1.a) == false) goto L13;
        int r3 = 0;
        if (r7 == false) goto L7;
        int r4 = 0;
    L8:
        r2.setVisibility(r4);
        SimpleDraweeView r5 = r0.a;
        if (r7 == false) goto L11;
        r3 = 8;
    L11:
        r5.setVisibility(r3);
        goto L13
    L7:
        r4 = 8;
    L13:
        return Unit.INSTANCE;
    }
}
