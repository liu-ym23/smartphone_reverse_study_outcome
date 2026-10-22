package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/live/broadcastgame/opengame/panel/OpenPanel$onStart$1$1"}, k = 3, mv = {1, 4, 3})
public final class OpenPanel$onStart$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WindowManager.LayoutParams $it;
    final /* synthetic */ OpenPanel this$0;

    public OpenPanel$onStart$$inlined$let$lambda$1(WindowManager.LayoutParams r1, OpenPanel r2) {
        this.$it = r1;
        this.this$0 = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m276invoke() {
        Window r0 = this.this$0.getWindow();
        if (r0 == null) goto L6;
        r0.setAttributes(this.$it);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m276invoke();
        return Unit.INSTANCE;
    }
}
