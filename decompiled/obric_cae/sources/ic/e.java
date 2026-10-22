package ic;

import android.view.View;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OInputView f8307a;

    public e(OInputView r8) {
        this.f8307a = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        int r10 = OInputView.f6291v0;
        OInputView r11 = this.f8307a;
        r11.getClass();
        r11.setText("");
        r11.getClass();
        r11.A();
    }
}
