package c;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.zte.miboard.cards.R;

/* JADX INFO: loaded from: classes.dex */
public final class g extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1052b;

    public g(d r5, String r10) {
        this.f1052b = r5;
        this.f1051a = r10;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r10) {
        d r5 = this.f1052b;
        f r11 = r5.f1032a;
        com.obric.oui.dialog.v2.alert.e r12 = new com.obric.oui.dialog.v2.alert.e(r11);
        String r13 = r11.getResources().getString(R.string.express_call_phone);
        r12.f13159i = false;
        r12.g = r13;
        StringBuilder r14 = new StringBuilder();
        r14.append(r11.getResources().getString(R.string.express_call_phone));
        String r15 = this.f1051a;
        r12.f13158h = ai.j0.q(r14, r15, "?");
        r12.e(r11.getResources().getString(R.string.dialog_button_cancel), new i(0));
        r12.g(r11.getResources().getString(R.string.express_call_phone), new h(r5, r15));
        r12.a().show();
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        super.updateDrawState(r5);
        r5.setUnderlineText(true);
    }
}
