package com.bytedance.android.livesdk.interactivity.interactive;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b1 implements LiveInteractiveWidget.a {
    public final /* synthetic */ LiveInteractiveWidget a;

    @Override // com.bytedance.android.livesdk.interactivity.interactive.LiveInteractiveWidget.a
    public final void onDegrade() {
        LiveInteractiveHelper r0 = this.a.b;
        if (r0 == null) goto L6;
        r0.p(false);
        o82.h.b("liveRefinedDegrade: set gone cuzz of auth interactiveComponent hide");
        return;
    }

    public b1(LiveInteractiveWidget r1) {
        this.a = r1;
    }
}
