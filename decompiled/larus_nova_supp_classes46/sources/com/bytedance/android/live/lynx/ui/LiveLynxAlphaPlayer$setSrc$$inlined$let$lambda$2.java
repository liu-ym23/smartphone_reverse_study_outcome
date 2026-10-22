package com.bytedance.android.live.lynx.ui;

import com.lynx.tasm.base.LLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "throwable", "", "isDebug", "", "invoke", "com/bytedance/android/live/lynx/ui/LiveLynxAlphaPlayer$setSrc$1$2"}, k = 3, mv = {1, 4, 3})
public final class LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$2 extends Lambda implements Function2<Throwable, Boolean, Unit> {
    final /* synthetic */ String $directUrl$inlined;
    final /* synthetic */ LiveLynxAlphaPlayer this$0;

    public LiveLynxAlphaPlayer$setSrc$$inlined$let$lambda$2(LiveLynxAlphaPlayer r1, String r2) {
        this.this$0 = r1;
        this.$directUrl$inlined = r2;
        super(2);
    }

    public final void invoke(Throwable r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        String r5 = "failed when use resource loader to load " + this.this$0.g + ", and error msg " + String.valueOf(r3.getMessage());
        if (r4 == false) goto L6;
        LLog.i("x-alpha-video", r5);
        this.this$0.R(this.$directUrl$inlined);
        return;
    L6:
        LiveLynxAlphaPlayer r6 = this.this$0;
        r6.Q(r5, r6.g, -11);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Throwable) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
