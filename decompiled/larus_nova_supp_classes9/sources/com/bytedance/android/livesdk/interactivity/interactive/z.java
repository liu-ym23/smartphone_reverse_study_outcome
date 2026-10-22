package com.bytedance.android.livesdk.interactivity.interactive;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class z implements LiveInteractiveAnnieXWidget.a {
    public final /* synthetic */ LiveInteractiveAnnieXWidget a;

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveAnnieXWidget.a
    public final void onDegrade() {
        LiveInteractiveAnnieXHelper r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.p(false);
        o82.h.b("liveRefinedDegrade: set gone cuzz of auth interactiveComponent hide");
        return;
    }

    public z(LiveInteractiveAnnieXWidget r1) {
        this.a = r1;
    }
}
