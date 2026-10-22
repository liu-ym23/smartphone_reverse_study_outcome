package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements PublicScreenConfigSliderView.a {
    public final /* synthetic */ AnchorPublicScreenConfigDialog a;

    public b(AnchorPublicScreenConfigDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r2) {
        this.a.v = r2;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r4) {
        AnchorPublicScreenConfigDialog r0 = this.a;
        r0.U90((int) (r0.w + (r0.y * r4)));
    }
}
