package c;

import android.view.View;
import com.zte.miboard.cards.R;
import com.zte.miboard.cards.express.login.LoginNumberActivity;

/* JADX INFO: loaded from: classes.dex */
public final class y implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f1091b;

    public y(c0 r5, int r10) {
        this.f1091b = r5;
        this.f1090a = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        c0 r5 = this.f1091b;
        LoginNumberActivity r11 = r5.f1030b;
        com.obric.oui.dialog.v2.alert.e r12 = new com.obric.oui.dialog.v2.alert.e(r11);
        int r13 = R.string.express_unbind_phone;
        CharSequence r14 = r12.f.getText(r13);
        r12.f13159i = false;
        r12.g = r14;
        r12.f13158h = r11.getResources().getString(R.string.express_unbind_phone_tips);
        r12.e(r11.getResources().getString(R.string.dialog_button_cancel), new i(1));
        r12.g(r11.getResources().getString(R.string.express_unbind_phone), new z(r5, this.f1090a));
        r12.a().show();
    }
}
