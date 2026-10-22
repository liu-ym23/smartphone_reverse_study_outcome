package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class SonicGamePlugin$switchScreen$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $success;
    final /* synthetic */ PanelType $toType;
    final /* synthetic */ SonicGamePlugin this$0;

    public SonicGamePlugin$switchScreen$1(SonicGamePlugin r1, PanelType r2, Function1 r3) {
        this.this$0 = r1;
        this.$toType = r2;
        this.$success = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m333invoke() {
        SonicGamePlugin r0 = this.this$0;
        Function1<com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> r1 = new AnonymousClass1(this);
        int r2 = LiveBasePluginWithPanel.p;
        r0.t(null, r1);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m333invoke();
        return Unit.INSTANCE;
    }
}
