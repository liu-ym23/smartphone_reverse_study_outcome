package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/broadcastgame/opengame/panel/OpenPanel$adjustPosition$1$1$1", "com/bytedance/android/live/broadcastgame/opengame/panel/OpenPanel$$special$$inlined$let$lambda$1"}, k = 3, mv = {1, 4, 3})
final class OpenPanel$adjustPosition$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $gravity$inlined;
    final /* synthetic */ Window $it$inlined;
    final /* synthetic */ WindowManager.LayoutParams $lp;
    final /* synthetic */ OpenPanel this$0;

    public OpenPanel$adjustPosition$$inlined$let$lambda$1(WindowManager.LayoutParams r1, Window r2, OpenPanel r3, int r4) {
        this.$lp = r1;
        this.$it$inlined = r2;
        this.this$0 = r3;
        this.$gravity$inlined = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m273invoke() {
        Window r0 = this.this$0.getWindow();
        if (r0 == null) goto L6;
        r0.setAttributes(this.$lp);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m273invoke();
        return Unit.INSTANCE;
    }
}
