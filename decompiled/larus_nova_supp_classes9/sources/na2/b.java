package na2;

import com.bytedance.android.livesdk.interactivity.publicscreen.stylesetting.ui.PublicScreenStyleSettingDialog;
import com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements PublicScreenConfigSliderView.a {
    public final /* synthetic */ PublicScreenStyleSettingDialog a;

    public b(PublicScreenStyleSettingDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void a(int r3) {
        this.a.t.i(d52.b.class, r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.ui.PublicScreenConfigSliderView.a
    public final void b(float r2) {
        int r3 = this.a.t.d(r2);
        this.a.T90(r3);
    }
}
