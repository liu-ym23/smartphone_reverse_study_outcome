package com.bytedance.android.live.lynx.ui;

import com.bytedance.ies.xelement.api.XResourceFrom;
import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lf76/c;", "it", "", "invoke", "(Lf76/c;)V", "com/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer$setSrc$1$1", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$1 extends Lambda implements Function1<f76.c, Unit> {
    final /* synthetic */ String $directUrl$inlined;
    final /* synthetic */ LiveLynxAlphaPlayer this$0;

    public LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$1(LiveLynxAlphaPlayer r1, String r2) {
        this.this$0 = r1;
        this.$directUrl$inlined = r2;
        super(1);
    }

    public final void invoke(f76.c r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        LiveLynxAlphaPlayer r0 = this.this$0;
        int r1 = LiveLynxAlphaPlayer.h;
        r0.getClass();
        LiveLynxAlphaPlayer r2 = this.this$0;
        XResourceFrom r4 = r3.d;
        r2.getClass();
        LLog.i("x-alpha-video", "load resource success: " + r3.b + ", " + r3.c);
        XResourceFrom r5 = r3.d;
        if (r5 == null) goto L22;
        int r6 = b.a[r5.ordinal()];
        if (r6 != 1) goto L8;
    L15:
        String r7 = r3.b;
        if (r7 == null) goto L21;
        LiveLynxAlphaPlayer.N(this.this$0, r7, this.$directUrl$inlined);
        return;
    L21:
        return;
    L8:
        if (r6 == 2) goto L15;
        if (r6 != 3) goto L23;
        String r8 = r3.b;
        if (r8 == null) goto L19;
        this.this$0.R(r8);
        return;
    L19:
        return;
    L23:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((f76.c) r1);
        return Unit.INSTANCE;
    }
}
